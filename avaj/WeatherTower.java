package avaj;

import avaj.Aircrafts.Flyable;

/**
 * Created by achepurn on 12.10.2018.
 */
public class WeatherTower extends Tower {

    @Override
    public void register(Flyable flyable) {
        if (!isRegistered(flyable)) {
            super.register(flyable);
            logMessage(this.say() + flyable.toString() + " registered to weather tower.");
        }
    }

    @Override
    public void unregister(Flyable flyable) {
        if (isRegistered(flyable)) {
            super.unregister(flyable);
            logMessage(this.say() + flyable.toString() + " unregistered from weather tower.");
        }
    }

    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void logMessage(String s) {
        System.out.println(s);
    }
}
