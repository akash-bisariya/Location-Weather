package app.android.com.weatherapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akash on 26/10/17.
 */

public class AccuWeatherModel {

    @SerializedName("LocalObservationDateTime")
    @Expose
    private String localObservationDateTime;
    @SerializedName("EpochTime")
    @Expose
    private int epochTime;
    @SerializedName("WeatherText")
    @Expose
    private String weatherText;
    @SerializedName("WeatherIcon")
    @Expose
    private int weatherIcon;
    @SerializedName("LocalSource")
    @Expose
    private LocalSource localSource;
    @SerializedName("IsDayTime")
    @Expose
    private boolean isDayTime;
    @SerializedName("Temperature")
    @Expose
    private Temperature temperature;
    @SerializedName("MobileLink")
    @Expose
    private String mobileLink;
    @SerializedName("Link")
    @Expose
    private String link;

    public String getLocalObservationDateTime() {
        return localObservationDateTime;
    }

    public void setLocalObservationDateTime(String localObservationDateTime) {
        this.localObservationDateTime = localObservationDateTime;
    }

    public int getEpochTime() {
        return epochTime;
    }

    public void setEpochTime(int epochTime) {
        this.epochTime = epochTime;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public LocalSource getLocalSource() {
        return localSource;
    }

    public void setLocalSource(LocalSource localSource) {
        this.localSource = localSource;
    }

    public boolean isIsDayTime() {
        return isDayTime;
    }

    public void setIsDayTime(boolean isDayTime) {
        this.isDayTime = isDayTime;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public String getMobileLink() {
        return mobileLink;
    }

    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public class Imperial {

        @SerializedName("Value")
        @Expose
        private double value;
        @SerializedName("Unit")
        @Expose
        private String unit;
        @SerializedName("UnitType")
        @Expose
        private int unitType;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public int getUnitType() {
            return unitType;
        }

        public void setUnitType(int unitType) {
            this.unitType = unitType;
        }

    }


    public class LocalSource {

        @SerializedName("Id")
        @Expose
        private int id;
        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("WeatherCode")
        @Expose
        private String weatherCode;

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

        public String getWeatherCode() {
            return weatherCode;
        }

        public void setWeatherCode(String weatherCode) {
            this.weatherCode = weatherCode;
        }

    }


    public class Metric {

        @SerializedName("Value")
        @Expose
        private double value;
        @SerializedName("Unit")
        @Expose
        private String unit;
        @SerializedName("UnitType")
        @Expose
        private int unitType;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public int getUnitType() {
            return unitType;
        }

        public void setUnitType(int unitType) {
            this.unitType = unitType;
        }

    }


    public class Temperature {

        @SerializedName("Metric")
        @Expose
        private Metric metric;
        @SerializedName("Imperial")
        @Expose
        private Imperial imperial;

        public Metric getMetric() {
            return metric;
        }

        public void setMetric(Metric metric) {
            this.metric = metric;
        }

        public Imperial getImperial() {
            return imperial;
        }

        public void setImperial(Imperial imperial) {
            this.imperial = imperial;
        }

    }
}
