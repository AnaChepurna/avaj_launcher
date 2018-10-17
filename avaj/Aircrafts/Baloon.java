package avaj.Aircrafts;


import avaj.Chatable;
import avaj.Coordinates;
import avaj.Weather;
import avaj.WeatherTower;

/**
 * Created by achepurn on 13.10.2018.
 */
public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        if (!weatherTower.isRegistered(this))
            return;
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN" :
                coordinates.increasesHeight(-5);
                weatherTower.logMessage(this.say() + "Damn you rain! You messed up my baloon.");
                break;
            case "SUN" :
                coordinates.increasesLongtitude(2);
                coordinates.increasesHeight(4);
                weatherTower.logMessage(this.say() + "Let's enjoy the good weather and take some pics.");
                break;
            case "FOG" :
                coordinates.increasesHeight(-3);
                weatherTower.logMessage(this.say() + "We do not see anything.");
                break;
            case "SNOW" :
                coordinates.increasesHeight(-15);
                weatherTower.logMessage(this.say() + "It's snowing. We're  gonna crash.");
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
