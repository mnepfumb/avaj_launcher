package src.simulation.aircrafts;

import src.simulation.aircrafts.*;
import src.simulation.controllers.*;
import src.simulation.controllers.WriteFile;

public class Baloon extends Aircraft implements Flyable 
{
    private WeatherTower weatherTower;

    Baloon( String name, Coordinates coordinates )
    {
        super( name, coordinates );
    }

    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather( this.coordinates );
        if ( weather.equals( "RAIN" ) )
        {
            this.coordinates.setHeight( this.coordinates.getHeight() - 5 );
            WriteFile.writeToFile( "Baloon#" + this.name + "(" + this.id + "): IT'S A RAINY DAY, MUST LAND" );
        }
        else if ( weather.equals( "FOG" ) ) 
        {
            this.coordinates.setHeight( this.coordinates.getHeight() - 2 );
            WriteFile.writeToFile( "Baloon#" + this.name + "(" + this.id + "): IT'S FOGGY, MUST LAND" );
        }
        else if ( weather.equals( "SUN" ) )
        {
            this.coordinates.setLongitude( this.coordinates.getLongitude() + 2 );
            WriteFile.writeToFile( "Baloon#" + this.name + "(" + this.id + "): IT'S SUNNY, WE CAN GO HIGHER" );
        }
        else if ( weather.equals( "SNOW" ) )
        {
            this.coordinates.setHeight( this.coordinates.getHeight() - 15 );
            WriteFile.writeToFile( "Baloon#" + this.name + "(" + this.id + "): IT'S SNOWING, MUST LAND" );
        }
        if ( this.coordinates.getHeight() <= 0 )
        {
            WriteFile.writeToFile( "Baloon#" + this.name + "(" + this.id + "): LANDING" );
            weatherTower = new WeatherTower();
            this.weatherTower.unregister( this );
            WriteFile.writeToFile( "Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered to weather tower." );
        }

    }

    public void registerTower( WeatherTower weatherTower )
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register( this );
        WriteFile.writeToFile( "Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower." );
    }
}
/*
1. Baloon is a constructer 
*/