package src.simulation.controllers;

import src.simulation.controllers.*;
import src.simulation.aircrafts.*;

public class WeatherTower extends Tower 
{

    public String getWeather( Coordinates coordinates )
    {
        return ( WeatherProvider.getProvider().getCurrentWeather( coordinates ) );
    }

    void changeWeather()
    {
        this.conditionsChanged();
        //invoke conditionshange from Tower
    }
}
/*
1. getWeather
*/