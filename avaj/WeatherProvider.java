package avaj;

import java.util.Random;

/**
 * Created by achepurn on 13.10.2018.
 */
public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String weather;
    private static Random rand = new Random();

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider()
    {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    private void changeWeather()
    {
        int x = rand.nextInt(Weather.values().length);
        weather = Weather.values()[x].name();
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        changeWeather();
        return weather;
    }

}

