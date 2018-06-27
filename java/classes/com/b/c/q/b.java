package com.b.c.q;

import com.a.a.a.l;
import com.a.a.a.n;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;

public class b
  extends com.b.c.b
{
  public static int e = 8193;
  protected static final HashMap<Integer, String> f = new HashMap();
  protected static final HashMap<Integer, String> g = new HashMap();
  protected static final HashMap<Integer, String> h = new HashMap();
  private final Map<String, String> i = new HashMap();
  private com.a.a.e j;
  
  static
  {
    f.put(Integer.valueOf(65535), "XMP Value Count");
    f.put(Integer.valueOf(1), "Make");
    f.put(Integer.valueOf(2), "Model");
    f.put(Integer.valueOf(3), "Exposure Time");
    f.put(Integer.valueOf(4), "Shutter Speed Value");
    f.put(Integer.valueOf(5), "F-Number");
    f.put(Integer.valueOf(6), "Lens Information");
    f.put(Integer.valueOf(7), "Lens");
    f.put(Integer.valueOf(8), "Serial Number");
    f.put(Integer.valueOf(9), "Firmware");
    f.put(Integer.valueOf(10), "Focal Length");
    f.put(Integer.valueOf(11), "Aperture Value");
    f.put(Integer.valueOf(12), "Exposure Program");
    f.put(Integer.valueOf(13), "Date/Time Original");
    f.put(Integer.valueOf(14), "Date/Time Digitized");
    f.put(Integer.valueOf(513), "Base URL");
    f.put(Integer.valueOf(514), "Create Date");
    f.put(Integer.valueOf(515), "Creator Tool");
    f.put(Integer.valueOf(516), "Identifier");
    f.put(Integer.valueOf(517), "Metadata Date");
    f.put(Integer.valueOf(518), "Modify Date");
    f.put(Integer.valueOf(519), "Nickname");
    f.put(Integer.valueOf(4097), "Rating");
    f.put(Integer.valueOf(8192), "Label");
    f.put(Integer.valueOf(e), "Subject");
    h.put(Integer.valueOf(1), "tiff:Make");
    h.put(Integer.valueOf(2), "tiff:Model");
    h.put(Integer.valueOf(3), "exif:ExposureTime");
    h.put(Integer.valueOf(4), "exif:ShutterSpeedValue");
    h.put(Integer.valueOf(5), "exif:FNumber");
    h.put(Integer.valueOf(6), "aux:LensInfo");
    h.put(Integer.valueOf(7), "aux:Lens");
    h.put(Integer.valueOf(8), "aux:SerialNumber");
    h.put(Integer.valueOf(9), "aux:Firmware");
    h.put(Integer.valueOf(10), "exif:FocalLength");
    h.put(Integer.valueOf(11), "exif:ApertureValue");
    h.put(Integer.valueOf(12), "exif:ExposureProgram");
    h.put(Integer.valueOf(13), "exif:DateTimeOriginal");
    h.put(Integer.valueOf(14), "exif:DateTimeDigitized");
    h.put(Integer.valueOf(513), "xmp:BaseURL");
    h.put(Integer.valueOf(514), "xmp:CreateDate");
    h.put(Integer.valueOf(515), "xmp:CreatorTool");
    h.put(Integer.valueOf(516), "xmp:Identifier");
    h.put(Integer.valueOf(517), "xmp:MetadataDate");
    h.put(Integer.valueOf(518), "xmp:ModifyDate");
    h.put(Integer.valueOf(519), "xmp:Nickname");
    h.put(Integer.valueOf(4097), "xmp:Rating");
    h.put(Integer.valueOf(8192), "xmp:Label");
    h.put(Integer.valueOf(e), "dc:subject");
    g.put(Integer.valueOf(1), "http://ns.adobe.com/tiff/1.0/");
    g.put(Integer.valueOf(2), "http://ns.adobe.com/tiff/1.0/");
    g.put(Integer.valueOf(3), "http://ns.adobe.com/exif/1.0/");
    g.put(Integer.valueOf(4), "http://ns.adobe.com/exif/1.0/");
    g.put(Integer.valueOf(5), "http://ns.adobe.com/exif/1.0/");
    g.put(Integer.valueOf(6), "http://ns.adobe.com/exif/1.0/aux/");
    g.put(Integer.valueOf(7), "http://ns.adobe.com/exif/1.0/aux/");
    g.put(Integer.valueOf(8), "http://ns.adobe.com/exif/1.0/aux/");
    g.put(Integer.valueOf(9), "http://ns.adobe.com/exif/1.0/aux/");
    g.put(Integer.valueOf(10), "http://ns.adobe.com/exif/1.0/");
    g.put(Integer.valueOf(11), "http://ns.adobe.com/exif/1.0/");
    g.put(Integer.valueOf(12), "http://ns.adobe.com/exif/1.0/");
    g.put(Integer.valueOf(13), "http://ns.adobe.com/exif/1.0/");
    g.put(Integer.valueOf(14), "http://ns.adobe.com/exif/1.0/");
    g.put(Integer.valueOf(513), "http://ns.adobe.com/xap/1.0/");
    g.put(Integer.valueOf(514), "http://ns.adobe.com/xap/1.0/");
    g.put(Integer.valueOf(515), "http://ns.adobe.com/xap/1.0/");
    g.put(Integer.valueOf(516), "http://ns.adobe.com/xap/1.0/");
    g.put(Integer.valueOf(517), "http://ns.adobe.com/xap/1.0/");
    g.put(Integer.valueOf(518), "http://ns.adobe.com/xap/1.0/");
    g.put(Integer.valueOf(519), "http://ns.adobe.com/xap/1.0/");
    g.put(Integer.valueOf(4097), "http://ns.adobe.com/xap/1.0/");
    g.put(Integer.valueOf(8192), "http://ns.adobe.com/xap/1.0/");
    g.put(Integer.valueOf(e), "http://purl.org/dc/elements/1.1/");
  }
  
  public b()
  {
    setDescriptor(new a(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return f;
  }
  
  void a(String paramString1, String paramString2)
  {
    this.i.put(paramString1, paramString2);
  }
  
  public void deleteProperty(int paramInt)
  {
    getXMPMeta().deleteProperty((String)g.get(Integer.valueOf(paramInt)), (String)h.get(Integer.valueOf(paramInt)));
  }
  
  public String getName()
  {
    return "XMP";
  }
  
  public com.a.a.e getXMPMeta()
  {
    if (this.j == null) {
      this.j = new n();
    }
    return this.j;
  }
  
  public Map<String, String> getXmpProperties()
  {
    return Collections.unmodifiableMap(this.i);
  }
  
  public void setXMPMeta(com.a.a.e parame)
  {
    this.j = parame;
    int k = 0;
    for (;;)
    {
      try
      {
        parame = this.j.iterator();
        if (parame.hasNext())
        {
          if (((com.a.a.c.c)parame.next()).getPath() != null) {
            k += 1;
          }
        }
        else
        {
          setInt(65535, k);
          return;
        }
      }
      catch (com.a.a.c parame)
      {
        return;
      }
    }
  }
  
  public void updateBoolean(int paramInt, boolean paramBoolean)
  {
    super.setBoolean(paramInt, paramBoolean);
    try
    {
      getXMPMeta().setPropertyBoolean((String)g.get(Integer.valueOf(paramInt)), (String)h.get(Integer.valueOf(paramInt)), paramBoolean);
      return;
    }
    catch (com.a.a.c localc)
    {
      localc.printStackTrace();
    }
  }
  
  public void updateDate(int paramInt, Date paramDate)
  {
    updateDate(paramInt, paramDate, TimeZone.getDefault());
  }
  
  public void updateDate(int paramInt, Date paramDate, TimeZone paramTimeZone)
  {
    super.setDate(paramInt, paramDate);
    paramDate = new l(paramDate, paramTimeZone);
    try
    {
      getXMPMeta().setPropertyDate((String)g.get(Integer.valueOf(paramInt)), (String)h.get(Integer.valueOf(paramInt)), paramDate);
      return;
    }
    catch (com.a.a.c paramDate)
    {
      paramDate.printStackTrace();
    }
  }
  
  public void updateDouble(int paramInt, double paramDouble)
  {
    super.setDouble(paramInt, paramDouble);
    try
    {
      getXMPMeta().setPropertyDouble((String)g.get(Integer.valueOf(paramInt)), (String)h.get(Integer.valueOf(paramInt)), paramDouble);
      return;
    }
    catch (com.a.a.c localc)
    {
      localc.printStackTrace();
    }
  }
  
  public void updateDoubleArray(int paramInt, double[] paramArrayOfDouble)
  {
    super.setDoubleArray(paramInt, paramArrayOfDouble);
    try
    {
      String str1 = (String)g.get(Integer.valueOf(paramInt));
      String str2 = (String)h.get(Integer.valueOf(paramInt));
      getXMPMeta().deleteProperty(str1, str2);
      com.a.a.b.e locale = new com.a.a.b.e().setArray(true);
      int k = paramArrayOfDouble.length;
      paramInt = 0;
      while (paramInt < k)
      {
        double d = paramArrayOfDouble[paramInt];
        getXMPMeta().appendArrayItem(str1, str2, locale, String.valueOf(d), null);
        paramInt += 1;
      }
      return;
    }
    catch (com.a.a.c paramArrayOfDouble)
    {
      paramArrayOfDouble.printStackTrace();
    }
  }
  
  public void updateFloat(int paramInt, float paramFloat)
  {
    super.setFloat(paramInt, paramFloat);
    try
    {
      getXMPMeta().setPropertyDouble((String)g.get(Integer.valueOf(paramInt)), (String)h.get(Integer.valueOf(paramInt)), paramFloat);
      return;
    }
    catch (com.a.a.c localc)
    {
      localc.printStackTrace();
    }
  }
  
  public void updateFloatArray(int paramInt, float[] paramArrayOfFloat)
  {
    super.setFloatArray(paramInt, paramArrayOfFloat);
    try
    {
      String str1 = (String)g.get(Integer.valueOf(paramInt));
      String str2 = (String)h.get(Integer.valueOf(paramInt));
      getXMPMeta().deleteProperty(str1, str2);
      com.a.a.b.e locale = new com.a.a.b.e().setArray(true);
      int k = paramArrayOfFloat.length;
      paramInt = 0;
      while (paramInt < k)
      {
        float f1 = paramArrayOfFloat[paramInt];
        getXMPMeta().appendArrayItem(str1, str2, locale, String.valueOf(f1), null);
        paramInt += 1;
      }
      return;
    }
    catch (com.a.a.c paramArrayOfFloat)
    {
      paramArrayOfFloat.printStackTrace();
    }
  }
  
  public void updateInt(int paramInt1, int paramInt2)
  {
    super.setInt(paramInt1, paramInt2);
    try
    {
      getXMPMeta().setPropertyInteger((String)g.get(Integer.valueOf(paramInt1)), (String)h.get(Integer.valueOf(paramInt1)), paramInt2);
      return;
    }
    catch (com.a.a.c localc)
    {
      localc.printStackTrace();
    }
  }
  
  public void updateIntArray(int paramInt, int[] paramArrayOfInt)
  {
    super.setIntArray(paramInt, paramArrayOfInt);
    try
    {
      String str1 = (String)g.get(Integer.valueOf(paramInt));
      String str2 = (String)h.get(Integer.valueOf(paramInt));
      getXMPMeta().deleteProperty(str1, str2);
      com.a.a.b.e locale = new com.a.a.b.e().setArray(true);
      int k = paramArrayOfInt.length;
      paramInt = 0;
      while (paramInt < k)
      {
        int m = paramArrayOfInt[paramInt];
        getXMPMeta().appendArrayItem(str1, str2, locale, String.valueOf(m), null);
        paramInt += 1;
      }
      return;
    }
    catch (com.a.a.c paramArrayOfInt)
    {
      paramArrayOfInt.printStackTrace();
    }
  }
  
  public void updateLong(int paramInt, long paramLong)
  {
    super.setLong(paramInt, paramLong);
    try
    {
      getXMPMeta().setPropertyLong((String)g.get(Integer.valueOf(paramInt)), (String)h.get(Integer.valueOf(paramInt)), paramLong);
      return;
    }
    catch (com.a.a.c localc)
    {
      localc.printStackTrace();
    }
  }
  
  public void updateString(int paramInt, String paramString)
  {
    super.setString(paramInt, paramString);
    try
    {
      getXMPMeta().setProperty((String)g.get(Integer.valueOf(paramInt)), (String)h.get(Integer.valueOf(paramInt)), paramString);
      return;
    }
    catch (com.a.a.c paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void updateStringArray(int paramInt, String[] paramArrayOfString)
  {
    super.setStringArray(paramInt, paramArrayOfString);
    try
    {
      String str1 = (String)g.get(Integer.valueOf(paramInt));
      String str2 = (String)h.get(Integer.valueOf(paramInt));
      getXMPMeta().deleteProperty(str1, str2);
      com.a.a.b.e locale = new com.a.a.b.e().setArray(true);
      int k = paramArrayOfString.length;
      paramInt = 0;
      while (paramInt < k)
      {
        String str3 = paramArrayOfString[paramInt];
        getXMPMeta().appendArrayItem(str1, str2, locale, str3, null);
        paramInt += 1;
      }
      return;
    }
    catch (com.a.a.c paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/q/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */