package src.simulation.aircrafts;

import src.simulation.aircrafts.*;
import src.simulation.controllers.*;

public interface Flyable {
    public void updateConditions();
    public void registerTower( WeatherTower WeatherTower );
}
