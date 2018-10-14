package avaj.Aircrafts;

import avaj.WeatherTower;

/**
 * Created by achepurn on 12.10.2018.
 */
public interface Flyable {
    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);

    public void landing();
}
