package app.android.com.weatherapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akash on 12/10/17.
 */
public class WeatherBean {

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private double message;
    @SerializedName("cnt")
    @Expose
    private Double cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<List> list = null;
    @SerializedName("city")
    @Expose
    private City city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public Double getCnt() {
        return cnt;
    }

    public void setCnt(Double cnt) {
        this.cnt = cnt;
    }

    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public class City {

        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("coord")
        @Expose
        private Coord coord;
        @SerializedName("country")
        @Expose
        private String country;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Coord getCoord() {
            return coord;
        }

        public void setCoord(Coord coord) {
            this.coord = coord;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

    }


    public class Clouds {

        @SerializedName("all")
        @Expose
        private int all;

        public int getAll() {
            return all;
        }

        public void setAll(int all) {
            this.all = all;
        }

    }


    public class Coord {

        @SerializedName("lat")
        @Expose
        private double lat;
        @SerializedName("lon")
        @Expose
        private double lon;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

    }


    public class List {

        @SerializedName("dt")
        @Expose
        private Double dt;
        @SerializedName("main")
        @Expose
        private Main main;
        @SerializedName("weather")
        @Expose
        private java.util.List<Weather> weather = null;
        @SerializedName("clouds")
        @Expose
        private Clouds clouds;
        @SerializedName("wind")
        @Expose
        private Wind wind;
        @SerializedName("snow")
        @Expose
        private Snow snow;
        @SerializedName("sys")
        @Expose
        private Sys sys;
        @SerializedName("dt_txt")
        @Expose
        private String dtTxt;

        public Double getDt() {
            return dt;
        }

        public void setDt(Double dt) {
            this.dt = dt;
        }

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        public java.util.List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(java.util.List<Weather> weather) {
            this.weather = weather;
        }

        public Clouds getClouds() {
            return clouds;
        }

        public void setClouds(Clouds clouds) {
            this.clouds = clouds;
        }

        public Wind getWind() {
            return wind;
        }

        public void setWind(Wind wind) {
            this.wind = wind;
        }

        public Snow getSnow() {
            return snow;
        }

        public void setSnow(Snow snow) {
            this.snow = snow;
        }

        public Sys getSys() {
            return sys;
        }

        public void setSys(Sys sys) {
            this.sys = sys;
        }

        public String getDtTxt() {
            return dtTxt;
        }

        public void setDtTxt(String dtTxt) {
            this.dtTxt = dtTxt;
        }

    }

    public class Main {

        @SerializedName("temp")
        @Expose
        private double temp;
        @SerializedName("temp_min")
        @Expose
        private double tempMin;
        @SerializedName("temp_max")
        @Expose
        private double tempMax;
        @SerializedName("pressure")
        @Expose
        private Double pressure;
        @SerializedName("sea_level")
        @Expose
        private double seaLevel;
        @SerializedName("grnd_level")
        @Expose
        private Double grndLevel;
        @SerializedName("humidity")
        @Expose
        private Double humidity;
        @SerializedName("temp_kf")
        @Expose
        private Double tempKf;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getTempMin() {
            return tempMin;
        }

        public void setTempMin(double tempMin) {
            this.tempMin = tempMin;
        }

        public double getTempMax() {
            return tempMax;
        }

        public void setTempMax(double tempMax) {
            this.tempMax = tempMax;
        }

        public Double getPressure() {
            return pressure;
        }

        public void setPressure(Double pressure) {
            this.pressure = pressure;
        }

        public double getSeaLevel() {
            return seaLevel;
        }

        public void setSeaLevel(double seaLevel) {
            this.seaLevel = seaLevel;
        }

        public Double getGrndLevel() {
            return grndLevel;
        }

        public void setGrndLevel(Double grndLevel) {
            this.grndLevel = grndLevel;
        }

        public Double getHumidity() {
            return humidity;
        }

        public void setHumidity(Double humidity) {
            this.humidity = humidity;
        }

        public Double getTempKf() {
            return tempKf;
        }

        public void setTempKf(Double tempKf) {
            this.tempKf = tempKf;
        }

    }


    public class Snow {

        @SerializedName("3h")
        @Expose
        private double _3h;

        public double get3h() {
            return _3h;
        }

        public void set3h(double _3h) {
            this._3h = _3h;
        }

    }


    public class Sys {

        @SerializedName("pod")
        @Expose
        private String pod;

        public String getPod() {
            return pod;
        }

        public void setPod(String pod) {
            this.pod = pod;
        }

    }


    public class Weather {

        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("main")
        @Expose
        private String main;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("icon")
        @Expose
        private String icon;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

    }


    public class Wind {

        @SerializedName("speed")
        @Expose
        private double speed;
        @SerializedName("deg")
        @Expose
        private double deg;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public double getDeg() {
            return deg;
        }

        public void setDeg(double deg) {
            this.deg = deg;
        }

    }
}
