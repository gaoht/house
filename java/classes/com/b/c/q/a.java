package com.b.c.q;

import com.b.a.e;
import com.b.b.l;
import com.b.c.g;

public class a
  extends g<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  public String getApertureValueDescription()
  {
    Double localDouble = ((b)this.a).getDoubleObject(11);
    if (localDouble == null) {
      return null;
    }
    return a(e.apertureToFStop(localDouble.doubleValue()));
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 1: 
    case 2: 
      return ((b)this.a).getString(paramInt);
    case 3: 
      return getExposureTimeDescription();
    case 12: 
      return getExposureProgramDescription();
    case 4: 
      return getShutterSpeedDescription();
    case 5: 
      return getFNumberDescription();
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      return ((b)this.a).getString(paramInt);
    case 10: 
      return getFocalLengthDescription();
    }
    return getApertureValueDescription();
  }
  
  public String getExposureProgramDescription()
  {
    return a(12, 1, new String[] { "Manual control", "Program normal", "Aperture priority", "Shutter priority", "Program creative (slow program)", "Program action (high-speed program)", "Portrait mode", "Landscape mode" });
  }
  
  public String getExposureTimeDescription()
  {
    String str = ((b)this.a).getString(3);
    if (str == null) {
      return null;
    }
    return str + " sec";
  }
  
  public String getFNumberDescription()
  {
    l locall = ((b)this.a).getRational(5);
    if (locall == null) {
      return null;
    }
    return a(locall.doubleValue());
  }
  
  public String getFocalLengthDescription()
  {
    l locall = ((b)this.a).getRational(10);
    if (locall == null) {
      return null;
    }
    return b(locall.doubleValue());
  }
  
  public String getShutterSpeedDescription()
  {
    Float localFloat = ((b)this.a).getFloatObject(4);
    if (localFloat == null) {
      return null;
    }
    if (localFloat.floatValue() <= 1.0F)
    {
      float f = (float)Math.round((float)(1.0D / Math.exp(localFloat.floatValue() * Math.log(2.0D))) * 10.0D) / 10.0F;
      return f + " sec";
    }
    int i = (int)Math.exp(localFloat.floatValue() * Math.log(2.0D));
    return "1/" + i + " sec";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/q/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */