package app.android.com.weatherapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by akash on 26/10/17.
 */

public class AccuWeather5DayModel {

    @SerializedName("Headline")
    @Expose
    private Headline headline;
    @SerializedName("DailyForecasts")
    @Expose
    private List<DailyForecast> dailyForecasts = null;

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public List<DailyForecast> getDailyForecasts() {
        return dailyForecasts;
    }

    public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }

    public class DailyForecast {

        @SerializedName("Date")
        @Expose
        private String date;
        @SerializedName("EpochDate")
        @Expose
        private int epochDate;
        @SerializedName("Temperature")
        @Expose
        private Temperature temperature;
        @SerializedName("Day")
        @Expose
        private Day day;
        @SerializedName("Night")
        @Expose
        private Night night;
        @SerializedName("Sources")
        @Expose
        private List<String> sources = null;
        @SerializedName("MobileLink")
        @Expose
        private String mobileLink;
        @SerializedName("Link")
        @Expose
        private String link;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getEpochDate() {
            return epochDate;
        }

        public void setEpochDate(int epochDate) {
            this.epochDate = epochDate;
        }

        public Temperature getTemperature() {
            return temperature;
        }

        public void setTemperature(Temperature temperature) {
            this.temperature = temperature;
        }

        public Day getDay() {
            return day;
        }

        public void setDay(Day day) {
            this.day = day;
        }

        public Night getNight() {
            return night;
        }

        public void setNight(Night night) {
            this.night = night;
        }

        public List<String> getSources() {
            return sources;
        }

        public void setSources(List<String> sources) {
            this.sources = sources;
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

    }


    public class Day {

        @SerializedName("Icon")
        @Expose
        private int icon;
        @SerializedName("IconPhrase")
        @Expose
        private String iconPhrase;
        @SerializedName("LocalSource")
        @Expose
        private LocalSource localSource;

        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }

        public String getIconPhrase() {
            return iconPhrase;
        }

        public void setIconPhrase(String iconPhrase) {
            this.iconPhrase = iconPhrase;
        }

        public LocalSource getLocalSource() {
            return localSource;
        }

        public void setLocalSource(LocalSource localSource) {
            this.localSource = localSource;
        }

    }


    public class Headline {

        @SerializedName("EffectiveDate")
        @Expose
        private String effectiveDate;
        @SerializedName("EffectiveEpochDate")
        @Expose
        private int effectiveEpochDate;
        @SerializedName("Severity")
        @Expose
        private int severity;
        @SerializedName("Text")
        @Expose
        private String text;
        @SerializedName("Category")
        @Expose
        private String category;
        @SerializedName("EndDate")
        @Expose
        private Object endDate;
        @SerializedName("EndEpochDate")
        @Expose
        private Object endEpochDate;
        @SerializedName("MobileLink")
        @Expose
        private String mobileLink;
        @SerializedName("Link")
        @Expose
        private String link;

        public String getEffectiveDate() {
            return effectiveDate;
        }

        public void setEffectiveDate(String effectiveDate) {
            this.effectiveDate = effectiveDate;
        }

        public int getEffectiveEpochDate() {
            return effectiveEpochDate;
        }

        public void setEffectiveEpochDate(int effectiveEpochDate) {
            this.effectiveEpochDate = effectiveEpochDate;
        }

        public int getSeverity() {
            return severity;
        }

        public void setSeverity(int severity) {
            this.severity = severity;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Object getEndDate() {
            return endDate;
        }

        public void setEndDate(Object endDate) {
            this.endDate = endDate;
        }

        public Object getEndEpochDate() {
            return endEpochDate;
        }

        public void setEndEpochDate(Object endEpochDate) {
            this.endEpochDate = endEpochDate;
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


    public class LocalSource_ {

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


    public class Maximum {

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


    public class Minimum {

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


    public class Night {

        @SerializedName("Icon")
        @Expose
        private int icon;
        @SerializedName("IconPhrase")
        @Expose
        private String iconPhrase;
        @SerializedName("LocalSource")
        @Expose
        private LocalSource_ localSource;

        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }

        public String getIconPhrase() {
            return iconPhrase;
        }

        public void setIconPhrase(String iconPhrase) {
            this.iconPhrase = iconPhrase;
        }

        public LocalSource_ getLocalSource() {
            return localSource;
        }

        public void setLocalSource(LocalSource_ localSource) {
            this.localSource = localSource;
        }

    }


    public class Temperature {

        @SerializedName("Minimum")
        @Expose
        private Minimum minimum;
        @SerializedName("Maximum")
        @Expose
        private Maximum maximum;

        public Minimum getMinimum() {
            return minimum;
        }

        public void setMinimum(Minimum minimum) {
            this.minimum = minimum;
        }

        public Maximum getMaximum() {
            return maximum;
        }

        public void setMaximum(Maximum maximum) {
            this.maximum = maximum;
        }

    }
}
