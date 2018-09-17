package src.simulation.aircrafts;

import src.simulation.controllers.*;
import src.simulation.aircrafts.*;

import java.io.*;

public class AircraftFactory
{
    public static Flyable newAircraft( String type, String name, int longitude, int latitude, int height )
    {
        if (type.equals( "Baloon" ) )
        {
            return ( new Baloon ( name, new Coordinates( longitude, latitude, height ) ) );
        } 
        else if (type.equals( "JetPlane" ) ) 
        {
            return ( new JetPlan ( name, new Coordinates( longitude, latitude, height ) ) );
        }
        else if (type.equals( "Helicopter" ) )
        {
            return ( new Helicopter ( name, new Coordinates( longitude, latitude, height ) ) );
        }
        else 
        {
            return ( null );
        }
    }
}

/*
1. This identifies the type of aircraft
2. We create the instance of the aircraft which has been identified
*/