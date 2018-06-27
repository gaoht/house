package com.b.c.c;

import com.b.b.l;
import java.text.DecimalFormat;

public class m
  extends com.b.c.g<n>
{
  public m(n paramn)
  {
    super(paramn);
  }
  
  private String a()
  {
    return a(0, 1);
  }
  
  public String getDegreesMinutesSecondsDescription()
  {
    com.b.b.g localg = ((n)this.a).getGeoLocation();
    if (localg == null) {
      return null;
    }
    return localg.toDMSString();
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 8: 
    case 11: 
    case 13: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    default: 
      return super.getDescription(paramInt);
    case 0: 
      return a();
    case 6: 
      return getGpsAltitudeDescription();
    case 5: 
      return getGpsAltitudeRefDescription();
    case 9: 
      return getGpsStatusDescription();
    case 10: 
      return getGpsMeasureModeDescription();
    case 12: 
      return getGpsSpeedRefDescription();
    case 14: 
    case 16: 
    case 23: 
      return getGpsDirectionReferenceDescription(paramInt);
    case 15: 
    case 17: 
    case 24: 
      return getGpsDirectionDescription(paramInt);
    case 25: 
      return getGpsDestinationReferenceDescription();
    case 7: 
      return getGpsTimeStampDescription();
    case 4: 
      return getGpsLongitudeDescription();
    case 2: 
      return getGpsLatitudeDescription();
    }
    return getGpsDifferentialDescription();
  }
  
  public String getGpsAltitudeDescription()
  {
    l locall = ((n)this.a).getRational(6);
    if (locall == null) {
      return null;
    }
    return locall.intValue() + " metres";
  }
  
  public String getGpsAltitudeRefDescription()
  {
    return a(5, new String[] { "Sea level", "Below sea level" });
  }
  
  public String getGpsDestinationReferenceDescription()
  {
    String str = ((n)this.a).getString(25);
    if (str == null) {
      return null;
    }
    str = str.trim();
    if ("K".equalsIgnoreCase(str)) {
      return "kilometers";
    }
    if ("M".equalsIgnoreCase(str)) {
      return "miles";
    }
    if ("N".equalsIgnoreCase(str)) {
      return "knots";
    }
    return "Unknown (" + str + ")";
  }
  
  public String getGpsDifferentialDescription()
  {
    return a(30, new String[] { "No Correction", "Differential Corrected" });
  }
  
  public String getGpsDirectionDescription(int paramInt)
  {
    Object localObject = ((n)this.a).getRational(paramInt);
    if (localObject != null) {}
    for (localObject = new DecimalFormat("0.##").format(((l)localObject).doubleValue()); (localObject == null) || (((String)localObject).trim().length() == 0); localObject = ((n)this.a).getString(paramInt)) {
      return null;
    }
    return ((String)localObject).trim() + " degrees";
  }
  
  public String getGpsDirectionReferenceDescription(int paramInt)
  {
    String str = ((n)this.a).getString(paramInt);
    if (str == null) {
      return null;
    }
    str = str.trim();
    if ("T".equalsIgnoreCase(str)) {
      return "True direction";
    }
    if ("M".equalsIgnoreCase(str)) {
      return "Magnetic direction";
    }
    return "Unknown (" + str + ")";
  }
  
  public String getGpsLatitudeDescription()
  {
    com.b.b.g localg = ((n)this.a).getGeoLocation();
    if (localg == null) {
      return null;
    }
    return com.b.b.g.decimalToDegreesMinutesSecondsString(localg.getLatitude());
  }
  
  public String getGpsLongitudeDescription()
  {
    com.b.b.g localg = ((n)this.a).getGeoLocation();
    if (localg == null) {
      return null;
    }
    return com.b.b.g.decimalToDegreesMinutesSecondsString(localg.getLongitude());
  }
  
  public String getGpsMeasureModeDescription()
  {
    String str = ((n)this.a).getString(10);
    if (str == null) {
      return null;
    }
    str = str.trim();
    if ("2".equalsIgnoreCase(str)) {
      return "2-dimensional measurement";
    }
    if ("3".equalsIgnoreCase(str)) {
      return "3-dimensional measurement";
    }
    return "Unknown (" + str + ")";
  }
  
  public String getGpsSpeedRefDescription()
  {
    String str = ((n)this.a).getString(12);
    if (str == null) {
      return null;
    }
    str = str.trim();
    if ("K".equalsIgnoreCase(str)) {
      return "kph";
    }
    if ("M".equalsIgnoreCase(str)) {
      return "mph";
    }
    if ("N".equalsIgnoreCase(str)) {
      return "knots";
    }
    return "Unknown (" + str + ")";
  }
  
  public String getGpsStatusDescription()
  {
    String str = ((n)this.a).getString(9);
    if (str == null) {
      return null;
    }
    str = str.trim();
    if ("A".equalsIgnoreCase(str)) {
      return "Active (Measurement in progress)";
    }
    if ("V".equalsIgnoreCase(str)) {
      return "Void (Measurement Interoperability)";
    }
    return "Unknown (" + str + ")";
  }
  
  public String getGpsTimeStampDescription()
  {
    l[] arrayOfl = ((n)this.a).getRationalArray(7);
    DecimalFormat localDecimalFormat = new DecimalFormat("00.000");
    if (arrayOfl == null) {
      return null;
    }
    return String.format("%02d:%02d:%s UTC", new Object[] { Integer.valueOf(arrayOfl[0].intValue()), Integer.valueOf(arrayOfl[1].intValue()), localDecimalFormat.format(arrayOfl[2].doubleValue()) });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */