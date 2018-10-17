package avaj;

import avaj.Aircrafts.Coordinates;
import avaj.Aircrafts.Flyable;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by achepurn on 12.10.2018.
 */
public class WeatherTower extends Tower {
    FileWriter output;

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
        try {
            output.write(s);
            output.write("\n");
            output.flush();
        } catch (IOException e) {
        }
    }

    public void setOutput(FileWriter output)
    {
        this.output = output;
    }

    void changeWeather()
    {
        WeatherProvider.getProvider().changeWeather();
    }

}
