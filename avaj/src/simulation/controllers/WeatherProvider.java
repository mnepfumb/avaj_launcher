package src.simulation.controllers;

import src.simulation.controllers.*;
import src.simulation.aircrafts.*;

import java.util.Random;

public class WeatherProvider 
{
    private static WeatherProvider weatherProvider = null;
    private static String weather[] = {"RAIN", "FOG", "SUN","SNOW"};

    private WeatherProvider()
    {
        // this.weather[0] = "RAIN";
        // this.weather[1] = "FOR";
        // this.weather[2] = "SUN";
        // this.weather[3] = "SNOW";
        // this.weatherProvider = null;
    }

    public static WeatherProvider getProvider()
    {
        if ( weatherProvider == null )
        {
            weatherProvider = new WeatherProvider();
        }
        return ( weatherProvider ); 
    }

    public String getCurrentWeather( Coordinates coordinates )
    {
        int rand_num = 0;
        Random rand = new Random();
        rand_num = rand.nextInt(4);
        return ( weather[rand_num] );
    }
}
