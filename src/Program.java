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

public class Program
{
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public static void main(String[] args)
    {
        getWeather(1105779, getAddedDate(0));
    }

    public static String getAddedDate(int i)
    {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, i);
        Date addedDate = calendar.getTime();
        return dateFormat.format(addedDate);
    }

    public static int getWoeID()
    {
        System.out.println("Welcome to the weather app, please enter your desired location");
        String location = System.console().readLine();
        return 1105779;
    }

    public static void getWeather(int woeID, String dateString)
    {
        try
        {
            //add forward slash yyyy/mm/dd to WOeID to get next day
            URL metaWeatherURL = new URL(String.format("https://www.metaweather.com/api/location/%1$s/%2$s", woeID, dateString));
            InputStreamReader reader = new InputStreamReader(metaWeatherURL.openStream());

            //Update jsonstructure
            ConsolidatedWeather[] data = new Gson().fromJson(reader, ConsolidatedWeather[].class);

            for(int i = 0; i < data.length; i++)
            {
                System.out.println(data[i].getTheTemp());
            }
            /*
            //data.consolidated_weather.get(0).
            for(int i = 0; i < data.consolidated_weather.size(); i++)
            {
                System.out.println("\n\n-==== Day: " + i + " ====-");
                System.out.println("The weather today is: " + data.consolidated_weather.get(i).getWeatherStateName());
                System.out.println("The temperature today is:" + data.consolidated_weather.get(i).getTheTemp() + " with a low of: " + data.consolidated_weather.get(i).getMinTemp() + " and a max of: " + data.consolidated_weather.get(i).getMaxTemp());
                System.out.println("The wind speed is: " + data.consolidated_weather.get(i).getWindSpeed() + " km/h");
                System.out.println("The visibility is: " + data.consolidated_weather.get(i).getVisibility() + " km");
                System.out.println("The air pressure is: " + data.consolidated_weather.get(i).getAirPressure() + "millibar (mb)");
                System.out.println("The humidity is: " + data.consolidated_weather.get(i).getHumidity() + "%");

            }
            System.out.println();

             */
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }

    }
}
