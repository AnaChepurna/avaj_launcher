package avaj.Aircrafts;

/**
 * Created by achepurn on 13.10.2018.
 */
public class Coordinates {
    private int longtitude;
    private int latitude;
    private int height;

    Coordinates(int longtitude, int latitude, int height)
    {
        this.latitude = latitude > 0 ? latitude : 0;
        this.height = height > 0 ? (height < 100 ? height : 100) : 0;
        this.longtitude = longtitude > 0 ? longtitude : 0;
    }

    public int getLongtitude() {
        return longtitude;
    }


    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void increasesLatitude(int i)
    {
        latitude += i;
        if (latitude < 0)
            latitude = 0;
    }

    public void increasesLongtitude(int i)
    {
        longtitude += i;
        if (longtitude < 0)
            longtitude = 0;
    }

    public void increasesHeight(int i)
    {
        height += i;
        if (height < 0)
            height = 0;
        if (height > 100)
            height = 100;
    }
}
