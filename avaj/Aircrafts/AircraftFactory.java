package avaj.Aircrafts;

import java.lang.reflect.Constructor;

/**
 * Created by achepurn on 13.10.2018.
 */
abstract public class AircraftFactory {

    private static void checkFlyable(Class clazz) throws WrongFormatException {
        Class<?> [] interfaces = clazz.getInterfaces();
        for (int i = 0; i < interfaces.length; i++)
        {
            if (interfaces[i] == Flyable.class)
                return;
        }
        throw new WrongFormatException();
    }

    private static Class getClassfromType(String type) throws WrongFormatException {
        try {
            Class factory = AircraftFactory.class;
            type = factory.getPackage().toString().split(" ")[1] + "." + type;
            return Class.forName(type);
        }
        catch (ClassNotFoundException e)
        {
            throw new WrongFormatException();
        }
    }

    public static Flyable newAircraft(String type, String name, int longtitude, int latitude, int height) throws Exception
    {
        if (name.equals(""))
            throw new WrongFormatException();
        Class clazz = getClassfromType(type);
        checkFlyable(clazz);
        Coordinates coordinates = new Coordinates(longtitude, latitude, height);
        Constructor constructor;
        Flyable obj;
        try {
            constructor = clazz.getDeclaredConstructor(String.class, Coordinates.class);
            obj = (Flyable) constructor.newInstance(name, coordinates);

        }
        catch (Exception e)
        {
            constructor = clazz.getDeclaredConstructor();
            obj = (Flyable) constructor.newInstance();
        }
        return obj;
    }
}

