package avaj;

import avaj.Aircrafts.AircraftFactory;
import avaj.Aircrafts.Flyable;
import avaj.Aircrafts.WrongFormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by achepurn on 12.10.2018.
 */
abstract public class Simulator {
    private static int cycles;
    private static List<Flyable> aircrafts = new ArrayList<Flyable>();
    private static WeatherTower weatherTower = new WeatherTower();
    private static File output = new File("simulation.txt");

    {
        try {
            output.createNewFile();
        } catch (IOException e) {
        }
    }

    public static void getScenarioInfo(String filename) throws Exception
    {
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String info = br.readLine().trim();
        cycles = Integer.parseInt(info);
        if (cycles < 0)
            throw new WrongFormatException();
        while (br.ready())
        {
            info = br.readLine().trim();
            if (!info.equals("")) {
                String[] ar = info.split(" ");
                if (ar.length != 5)
                    throw new WrongFormatException();
                aircrafts.add(AircraftFactory.newAircraft(ar[0], ar[1], Integer.parseInt(ar[2]), Integer.parseInt(ar[3]),
                        Integer.parseInt(ar[4])));
            }
        }
        br.close();
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("usage : program <filename>");
            return;
        }
        String file = args[0];
        try {
            FileWriter writer = new FileWriter(output);
            weatherTower.setOutput(writer);
            getScenarioInfo(file);
            for (Flyable f :
                    aircrafts) {
                f.registerTower(weatherTower);
            }
            while (cycles-- > 0)
            {
                for (Flyable f :
                        aircrafts) {
                    f.updateConditions();
                }
                WeatherProvider.getProvider().changeWeather();
            }

        } catch (Exception e) {
            System.out.println("caught : " + e.toString());
        }
    }
}

