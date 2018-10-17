package avaj.Aircrafts;

import avaj.Chatable;
import avaj.Coordinates;
import avaj.WeatherTower;

/**
 * Created by achepurn on 13.10.2018.
 */
public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        if (!weatherTower.isRegistered(this))
            return;
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN" :
                coordinates.increasesLatitude(5);
                weatherTower.logMessage(this.say() + "It's raining. Better watch out for lightings.");
                break;
            case "SUN" :
                coordinates.increasesLatitude(10);
                coordinates.increasesHeight(2);
                weatherTower.logMessage(this.say() + "Maximum speed!");
                break;
            case "FOG" :
                coordinates.increasesLatitude(1);
                weatherTower.logMessage(this.say() + "So dangerous to fly in fog!");
                break;
            case "SNOW" :
                coordinates.increasesHeight(-7);
                weatherTower.logMessage(this.say() + "OMG! Winter is coming!");
                break;
        }
        if (coordinates.getHeight() == 0)
            landing();
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
    }

    @Override
    public void landing() {
        weatherTower.logMessage(this + " landing on " + coordinates.getLongtitude() + " longtitude, " +
                coordinates.getLatitude() + " latitude.");
        weatherTower.unregister(this);
    }
}
