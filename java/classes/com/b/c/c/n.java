package com.b.c.c;

import com.b.b.g;
import com.b.b.l;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class n
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    a(e);
    e.put(Integer.valueOf(0), "GPS Version ID");
    e.put(Integer.valueOf(1), "GPS Latitude Ref");
    e.put(Integer.valueOf(2), "GPS Latitude");
    e.put(Integer.valueOf(3), "GPS Longitude Ref");
    e.put(Integer.valueOf(4), "GPS Longitude");
    e.put(Integer.valueOf(5), "GPS Altitude Ref");
    e.put(Integer.valueOf(6), "GPS Altitude");
    e.put(Integer.valueOf(7), "GPS Time-Stamp");
    e.put(Integer.valueOf(8), "GPS Satellites");
    e.put(Integer.valueOf(9), "GPS Status");
    e.put(Integer.valueOf(10), "GPS Measure Mode");
    e.put(Integer.valueOf(11), "GPS DOP");
    e.put(Integer.valueOf(12), "GPS Speed Ref");
    e.put(Integer.valueOf(13), "GPS Speed");
    e.put(Integer.valueOf(14), "GPS Track Ref");
    e.put(Integer.valueOf(15), "GPS Track");
    e.put(Integer.valueOf(16), "GPS Img Direction Ref");
    e.put(Integer.valueOf(17), "GPS Img Direction");
    e.put(Integer.valueOf(18), "GPS Map Datum");
    e.put(Integer.valueOf(19), "GPS Dest Latitude Ref");
    e.put(Integer.valueOf(20), "GPS Dest Latitude");
    e.put(Integer.valueOf(21), "GPS Dest Longitude Ref");
    e.put(Integer.valueOf(22), "GPS Dest Longitude");
    e.put(Integer.valueOf(23), "GPS Dest Bearing Ref");
    e.put(Integer.valueOf(24), "GPS Dest Bearing");
    e.put(Integer.valueOf(25), "GPS Dest Distance Ref");
    e.put(Integer.valueOf(26), "GPS Dest Distance");
    e.put(Integer.valueOf(27), "GPS Processing Method");
    e.put(Integer.valueOf(28), "GPS Area Information");
    e.put(Integer.valueOf(29), "GPS Date Stamp");
    e.put(Integer.valueOf(30), "GPS Differential");
  }
  
  public n()
  {
    setDescriptor(new m(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public g getGeoLocation()
  {
    Object localObject2 = getRationalArray(2);
    Object localObject1 = getRationalArray(4);
    String str2 = getString(1);
    String str1 = getString(3);
    if ((localObject2 == null) || (localObject2.length != 3)) {}
    do
    {
      do
      {
        return null;
      } while ((localObject1 == null) || (localObject1.length != 3) || (str2 == null) || (str1 == null));
      localObject2 = g.degreesMinutesSecondsToDecimal(localObject2[0], localObject2[1], localObject2[2], str2.equalsIgnoreCase("S"));
      localObject1 = g.degreesMinutesSecondsToDecimal(localObject1[0], localObject1[1], localObject1[2], str1.equalsIgnoreCase("W"));
    } while ((localObject2 == null) || (localObject1 == null));
    return new g(((Double)localObject2).doubleValue(), ((Double)localObject1).doubleValue());
  }
  
  public Date getGpsDate()
  {
    Object localObject = getString(29);
    l[] arrayOfl = getRationalArray(7);
    if (localObject == null) {}
    while ((arrayOfl == null) || (arrayOfl.length != 3)) {
      return null;
    }
    localObject = String.format(Locale.US, "%s %02d:%02d:%02.3f UTC", new Object[] { localObject, Integer.valueOf(arrayOfl[0].intValue()), Integer.valueOf(arrayOfl[1].intValue()), Double.valueOf(arrayOfl[2].doubleValue()) });
    try
    {
      localObject = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss.S z").parse((String)localObject);
      return (Date)localObject;
    }
    catch (ParseException localParseException) {}
    return null;
  }
  
  public String getName()
  {
    return "GPS";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */