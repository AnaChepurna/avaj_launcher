package avaj.Aircrafts;

import avaj.Chatable;
import avaj.Coordinates;

/**
 * Created by achepurn on 13.10.2018.
 */
public abstract class Aircraft implements Chatable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.id = nextId();
        this.coordinates = coordinates;
        this.name = name;
    }

    private static long nextId()
    {
        return idCounter++;
    }

    public String toString()
    {
        String className = this.getClass().getTypeName();
        int index = className.lastIndexOf(".");
        className = className.substring(index + 1);
        return className + "#" + this.name + "(" + this.id + ")";
    }

    @Override
    public String say() {
        return this + ": ";
    }
}
