package com.example.moviemanagement.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class movies {
    private IntegerProperty id;
    private StringProperty username;
    private StringProperty moviename;
    private StringProperty rates;


    public movies(Integer id, String rates, String username, String moviename) {
        this.id = new SimpleIntegerProperty(id);
        this.username = new SimpleStringProperty(username);
        this.rates = new SimpleStringProperty(rates);
        this.moviename = new SimpleStringProperty(moviename);
    }

    public int getId(){
        return id.getValue();
    }
    public void setId(int id1){
        id.setValue(id1);
    }
    public IntegerProperty idProperty(){
        return id;
    }

    public String getUsername(){
        return username.getValue();
    }
    public void setUsername(String username1){
        username.setValue(username1);
    }
    public StringProperty usernameProperty(){
        return username;
    }

    public String getMoviename(){
        return moviename.getValue();
    }
    public void setMoviename(String moviename1){
        moviename.setValue(moviename1);
    }
    public StringProperty movienameProperty(){
        return moviename;
    }

    public String getRates(){
        return rates.getValue();
    }
    public void setRates(String rates1){
        username.setValue(rates1);
    }
    public StringProperty ratesProperty(){
        return rates;
    }
}
