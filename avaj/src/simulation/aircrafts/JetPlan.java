package src.simulation.aircrafts;

import src.simulation.aircrafts.*;
import src.simulation.controllers.*;

public class JetPlan extends Aircraft implements Flyable 
{
    private WeatherTower weatherTower;

    JetPlan( String name, Coordinates coordinates )
    {
        super( name, coordinates );
    }

    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather( this.coordinates );
        if ( weather.equals("RAIN" ) )
        {
            this.coordinates.setHeight( this.coordinates.getHeight() - 5 );
            WriteFile.writeToFile( "JetPlan#" + this.name + "(" + this.id + ") IT'S A RAINY DAY, MUST LAND" );
        }
        else if ( weather.equals("FOG" ) )
        {
            this.coordinates.setHeight( this.coordinates.getHeight() - 1 );
            WriteFile.writeToFile( "JetPlan#" + this.name + "(" + this.id + ") IT'S A FOGGY DAY, MUST LAND" );
        }
        else if ( weather.equals("SUN" ) )
        {
            this.coordinates.setLatitude( this.coordinates.getLongitude() + 10 );
            this.coordinates.setHeight( this.coordinates.getHeight() + 2 );
            WriteFile.writeToFile( "JetPlan#" + this.name + "(" + this.id + ") IT'S A SUNNY DAY, MUST LAND" );
        }
        else if ( weather.equals("SNOW" ) )
        {
            coordinates.setHeight( this.coordinates.getHeight() - 12 );
            WriteFile.writeToFile( "JetPlan#" + this.name + "(" + this.id + ") IT'S A SNOWWY DAY, MUST LAND" );
        }
        if ( this.coordinates.getHeight() <= 0 )
        {
            WriteFile.writeToFile( "JetPlan#" + this.name + "(" + this.id + ") LANDING" );
            weatherTower = new WeatherTower();
            this.weatherTower.unregister( this );
            WriteFile.writeToFile( "Tower says: JetPlan#" + this.name + "(" + this.id + ") unregistered to weather tower." );
        }
    }

    public void unregisterTower( WeatherTower weatherTower )
    {
        this.weatherTower = weatherTower;
        this.weatherTower.unregister( this );
    }

    public void registerTower( WeatherTower weatherTower )
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register( this );
        WriteFile.writeToFile( "Tower says: JetPlan#" + this.name + "(" + this.id + ") registered to weather tower." );
    }
}
