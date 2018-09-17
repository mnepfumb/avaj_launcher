package src.simulation.controllers;

import src.simulation.controllers.*;
import src.simulation.aircrafts.*;

import java.util.ArrayList;
import java.util.List;

public class Tower
{
    Coordinates coords;
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register( Flyable flyable )
    {
        observers.add( flyable );  
    }

    public void unregister( Flyable flyable )
    {
        observers.remove( flyable );
    }

    protected void conditionsChanged()
    {
        for ( Flyable flyable : observers )
        {
            flyable.updateConditions();
        }
    }
}
