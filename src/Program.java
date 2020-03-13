import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Program
{
    public static void main(String[] args)
    {
        getWeather(1105779);
    }

    public static int getWoeID()
    {
        System.out.println("Welcome to the weather app, please enter your desired location");
        String location = System.console().readLine();
        return 1105779;
    }

    public static void getWeather(int woeID)
    {
        try
        {
            //add forward slash yyyy/mm/dd to WOeID to get next day
            URL metaWeatherURL = new URL(String.format("https://www.metaweather.com/api/location/%s/", woeID));
            InputStreamReader reader = new InputStreamReader(metaWeatherURL.openStream());
            JsonStructure data = new Gson().fromJson(reader, JsonStructure.class);

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
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }

    }
}
