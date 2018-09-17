package src.simulation.aircrafts;

import src.simulation.controllers.*;
import src.simulation.aircrafts.*;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft( String name, Coordinates coordinates )
    {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId(); //idCounter gets it from the nextId methord
        
    }

    private long nextId()
    {
        return ( ++(Aircraft.idCounter)  ); //this will increament the id counter
    }
}
