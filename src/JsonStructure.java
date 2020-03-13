import java.util.ArrayList;

public class JsonStructure {
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

    public String getTime() {
        return time;
    }

    public String getSun_rise() {
        return sun_rise;
    }

    public String getSun_set() {
        return sun_set;
    }

    public String getTimezone_name() {
        return timezone_name;
    }

    public Parent getParent() {
        return ParentObject;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation_type() {
        return location_type;
    }

    public float getWoeid() {
        return woeid;
    }

    public String getLatt_long() {
        return latt_long;
    }

    public String getTimezone() {
        return timezone;
    }

    // Setter Methods

    public void setTime(String time) {
        this.time = time;
    }

    public void setSun_rise(String sun_rise) {
        this.sun_rise = sun_rise;
    }

    public void setSun_set(String sun_set) {
        this.sun_set = sun_set;
    }

    public void setTimezone_name(String timezone_name) {
        this.timezone_name = timezone_name;
    }

    public void setParent(Parent parentObject) {
        this.ParentObject = parentObject;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public void setWoeid(float woeid) {
        this.woeid = woeid;
    }

    public void setLatt_long(String latt_long) {
        this.latt_long = latt_long;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
public class Parent {
    private String title;
    private String location_type;
    private float woeid;
    private String latt_long;


    // Getter Methods

    public String getTitle() {
        return title;
    }

    public String getLocation_type() {
        return location_type;
    }

    public float getWoeid() {
        return woeid;
    }

    public String getLatt_long() {
        return latt_long;
    }

    // Setter Methods

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public void setWoeid(float woeid) {
        this.woeid = woeid;
    }

    public void setLatt_long(String latt_long) {
        this.latt_long = latt_long;
    }
}