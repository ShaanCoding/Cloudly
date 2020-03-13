import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Program
{
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public static void main(String[] args)
    {
        long woeID;
        woeID = getWoeID();

        for(int i=0; i < 7; i++)
        {
            getWeather(woeID, getAddedDate(i));
        }
    }

    private static long getWoeID()
    {
        System.out.println("Welcome to the weather app, please enter your desired location");

        //User input
        Scanner in = new Scanner(System.in);
        String location = in.nextLine();

        //add forward slash yyyy/mm/dd to WOeID to get next day
        try
        {
            URL findWOEIDURL = new URL(String.format("https://www.metaweather.com/api/location/search/?query=%s", location));
            InputStreamReader reader = new InputStreamReader(findWOEIDURL.openStream());
            WoeIDJson[] data = new Gson().fromJson(reader, WoeIDJson[].class);

            return data[0].getWoeID();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
            return 0;
        }
    }

    private static String getAddedDate(int i)
    {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, i);
        Date addedDate = calendar.getTime();
        return dateFormat.format(addedDate);
    }

    private static void getWeather(long woeID, String dateString)
    {
        try
        {
            //add forward slash yyyy/mm/dd to WOeID to get next day
            URL metaWeatherURL = new URL(String.format("https://www.metaweather.com/api/location/%1$s/%2$s", woeID, dateString));
            InputStreamReader reader = new InputStreamReader(metaWeatherURL.openStream());

            //Json structure updated
            ConsolidatedWeather[] data = new Gson().fromJson(reader, ConsolidatedWeather[].class);

            //Prints out each source per day
            for(int i = 0; i < data.length; i++)
            {
                System.out.println("\n\n-==== Source: " + i + " ====-");
                System.out.println("The weather today is: " + data[i].getWeatherStateName());
                System.out.println("The temperature today is:" + data[i].getTheTemp() + " with a low of: " + data[i].getMinTemp() + " and a max of: " + data[i].getMaxTemp());
                System.out.println("The wind speed is: " + data[i].getWindSpeed() + " km/h");
                System.out.println("The visibility is: " + data[i].getVisibility() + " km");
                System.out.println("The air pressure is: " + data[i].getAirPressure() + "millibar (mb)");
                System.out.println("The humidity is: " + data[i].getHumidity() + "%");
            }

            System.out.println();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
