package avaj.Aircrafts;


import avaj.WeatherTower;

/**
 * Created by achepurn on 13.10.2018.
 */
public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
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
                weatherTower.logMessage(this.say() + "I think rain is so dramatic.");
                break;
            case "SUN" :
                coordinates.increasesLatitude(10);
                coordinates.increasesHeight(2);
                weatherTower.logMessage(this.say() + "This is hot.");
                break;
            case "FOG" :
                coordinates.increasesLatitude(1);
                weatherTower.logMessage(this.say() + "It is wet fog, omg.");
                break;
            case "SNOW" :
                coordinates.increasesHeight(-12);
                weatherTower.logMessage(this.say() + "My rotor is going to freeze!");
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
