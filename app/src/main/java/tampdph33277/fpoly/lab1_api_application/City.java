package tampdph33277.fpoly.lab1_api_application;

import java.io.Serializable;
import java.util.List;

public class City  {
    private String textViewCityName , textViewStateCity ,textViewCountryCity , textViewPopulation;

    public City() {
    }

    public City(String textViewCityName, String textViewStateCity, String textViewCountryCity, String textViewPopulation) {
        this.textViewCityName = textViewCityName;
        this.textViewStateCity = textViewStateCity;
        this.textViewCountryCity = textViewCountryCity;
        this.textViewPopulation = textViewPopulation;
    }

    public String getTextViewCityName() {
        return textViewCityName;
    }

    public void setTextViewCityName(String textViewCityName) {
        this.textViewCityName = textViewCityName;
    }

    public String getTextViewStateCity() {
        return textViewStateCity;
    }

    public void setTextViewStateCity(String textViewStateCity) {
        this.textViewStateCity = textViewStateCity;
    }

    public String getTextViewCountryCity() {
        return textViewCountryCity;
    }

    public void setTextViewCountryCity(String textViewCountryCity) {
        this.textViewCountryCity = textViewCountryCity;
    }

    public String getTextViewPopulation() {
        return textViewPopulation;
    }

    public void setTextViewPopulation(String textViewPopulation) {
        this.textViewPopulation = textViewPopulation;
    }
}
