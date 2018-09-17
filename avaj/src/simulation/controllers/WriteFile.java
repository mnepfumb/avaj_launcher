package src.simulation.controllers;

import src.simulation.controllers.*;
import src.simulation.aircrafts.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.lang.*;

public class WriteFile 
{
    static int i = 0;
        public static void writeToFile( String inputString )
    {
        if ( i == 0 )
        {
            try ( BufferedWriter bw = new BufferedWriter(new FileWriter( "Simulation.txt" ) ) )
            {
                bw.write( inputString );
                bw.newLine();
            }
            catch( IOException e )
            {
                System.out.println( e.getMessage() );
            }
            i++;
        }
        else 
        {
            try ( BufferedWriter bw = new BufferedWriter(new FileWriter( "Simulation.txt", true )) )
            {
                bw.write( inputString );
                bw.newLine();
            }
            catch( IOException e )
            {
                System.out.println( e.getMessage() );
            }
        }
    }
}

/* Auto closes the file */