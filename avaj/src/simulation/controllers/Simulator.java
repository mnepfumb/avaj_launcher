package src.simulation.controllers;

import src.simulation.controllers.*;
import src.simulation.aircrafts.*;

import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Simulator {

    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<Flyable>();

    public static void main( String[] args ) throws InterruptedException
    {
        try
        {
            BufferedReader reader = new BufferedReader( new FileReader( args[0] ) );
            String scenario = reader.readLine();
            
            if ( scenario != null )
            {
                weatherTower = new WeatherTower();
                int simulations_counter = Integer.parseInt(scenario.split( " " )[0] );
                if ( simulations_counter <= 0 )
                {
                    System.out.println( "Invalid simulation count " + simulations_counter );
                    System.exit( 1 );
                }
                
                while ( ( scenario = reader.readLine() ) != null )
                {
                    String[] checkLenght = scenario.split(" ");

                    if ( checkLenght.length > 5 )
                    {
                        System.out.println(scenario + " Contains more data than needed.. The program will be stopped.");
                        return;
                    } 

                    if ( checkLenght.length < 5 )
                    {
                        System.out.println(scenario + " Contains less data than needed.. The program will be stopped.");
                        return;
                    }

                    Flyable flyable = AircraftFactory.newAircraft(
                        scenario.split( " " ) [0], 
                        scenario.split( " ") [1],
						Integer.parseInt( scenario.split( " " ) [2] ), 
						Integer.parseInt( scenario.split( " " ) [3] ),
                        Integer.parseInt( scenario.split( " " ) [4] ) );
                    flyables.add( flyable );
                    flyable.registerTower( weatherTower );
                }

                reader.close();

                for ( int i = 0; i < simulations_counter; i++ )
                {
                    weatherTower.changeWeather();
                }
            }
        }
        catch ( FileNotFoundException e )
        {
            System.out.println(  args[0] + " File is missing!" );
        }
        catch ( IOException e )
        {
            System.out.println( "There was an error while reading the File " + args[0] );
        }
        catch ( ArrayIndexOutOfBoundsException e )
        {
            System.out.println( "The " + args[0] + " may be missing value" );
        }
        // finally
        // {
        //     WriteFile.closeFile();
        // }

    }
}
