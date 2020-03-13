import java.util.ArrayList;

public class JsonStructure
{
    ArrayList <ConsolidatedWeather> consolidated_weather = new ArrayList<ConsolidatedWeather>();
    private String time;
    private String sun_rise;
    private String sun_set;
    private String timezone_name;
    Parent ParentObject;
    ArrayList <Object> sources = new ArrayList <Object> ();
    private String title;
    private String location_type;
    private float woeid;
    private String latt_long;
    private String timezone;


    // Getter Methods
    public String getTime()
    {
        return time;
    }

    public String getSunRise()
    {
        return sun_rise;
    }

    public String getSunSet()
    {
        return sun_set;
    }

    public String getTimezoneName()
    {
        return timezone_name;
    }

    public Parent getParent()
    {
        return ParentObject;
    }

    public String getTitle()
    {
        return title;
    }

    public String getLocation_type()
    {
        return location_type;
    }

    public float getWoeid()
    {
        return woeid;
    }

    public String getLattLong()
    {
        return latt_long;
    }

    public String getTimezone()
    {
        return timezone;
    }
}

class Parent
{
    private String title;
    private String location_type;
    private float woeid;
    private String latt_long;


    // Getter Methods

    public String getTitle()
    {
        return title;
    }

    public String getLocationType()
    {
        return location_type;
    }

    public float getWoeid()
    {
        return woeid;
    }

    public String getLattLong()
    {
        return latt_long;
    }
}