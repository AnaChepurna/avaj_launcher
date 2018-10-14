package avaj;

import avaj.Aircrafts.Flyable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by achepurn on 12.10.2018.
 */
abstract public class Tower implements Chatable {
    private List<Flyable> observers = new LinkedList<Flyable>();

    public boolean isRegistered(Flyable flyable)
    {
        return observers.contains(flyable);
    }

    public void register(Flyable flyable)
    {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        observers.remove(flyable);
    }

    protected void conditionsChanged()
    {
        for (Flyable flyable: observers) {
            flyable.updateConditions();
        }
    }

    @Override
    public String say() {
        return "Tower says: ";
    }
}
