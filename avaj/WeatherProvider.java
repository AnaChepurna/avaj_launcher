package avaj;

import avaj.Aircrafts.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by achepurn on 13.10.2018.
 */
public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String [] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static ArrayList<String> currentWeather = new ArrayList<>();
    private static Random rand = new Random();

    private WeatherProvider() {
        changeWeather();
    }

    public static WeatherProvider getProvider()
    {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    void changeWeather()
    {
        int len = rand.nextInt(10);
        for (int i = 0; i < len; i++)
            currentWeather.add(weather[rand.nextInt(3)]);
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        int h = coordinates.getHeight();
        h = h == 0 ? 1 : h;
        int x = coordinates.getLatitude() * coordinates.getLongtitude()
                / h % currentWeather.size();
        return currentWeather.get(x);
    }

}

