package com.b.c.c.a;

import com.b.b.j;
import com.b.c.a;
import com.b.c.c;
import java.io.IOException;
import java.util.HashMap;

public class z
  extends com.b.c.b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(1), "Quality Mode");
    e.put(Integer.valueOf(2), "Version");
    e.put(Integer.valueOf(3), "White Balance");
    e.put(Integer.valueOf(7), "Focus Mode");
    e.put(Integer.valueOf(15), "AF Area Mode");
    e.put(Integer.valueOf(26), "Image Stabilization");
    e.put(Integer.valueOf(28), "Macro Mode");
    e.put(Integer.valueOf(31), "Record Mode");
    e.put(Integer.valueOf(32), "Audio");
    e.put(Integer.valueOf(37), "Internal Serial Number");
    e.put(Integer.valueOf(33), "Unknown Data Dump");
    e.put(Integer.valueOf(34), "Easy Mode");
    e.put(Integer.valueOf(35), "White Balance Bias");
    e.put(Integer.valueOf(36), "Flash Bias");
    e.put(Integer.valueOf(38), "Exif Version");
    e.put(Integer.valueOf(40), "Color Effect");
    e.put(Integer.valueOf(41), "Camera Uptime");
    e.put(Integer.valueOf(42), "Burst Mode");
    e.put(Integer.valueOf(43), "Sequence Number");
    e.put(Integer.valueOf(44), "Contrast Mode");
    e.put(Integer.valueOf(45), "Noise Reduction");
    e.put(Integer.valueOf(46), "Self Timer");
    e.put(Integer.valueOf(48), "Rotation");
    e.put(Integer.valueOf(49), "AF Assist Lamp");
    e.put(Integer.valueOf(50), "Color Mode");
    e.put(Integer.valueOf(51), "Baby Age");
    e.put(Integer.valueOf(52), "Optical Zoom Mode");
    e.put(Integer.valueOf(53), "Conversion Lens");
    e.put(Integer.valueOf(54), "Travel Day");
    e.put(Integer.valueOf(57), "Contrast");
    e.put(Integer.valueOf(58), "World Time Location");
    e.put(Integer.valueOf(59), "Text Stamp");
    e.put(Integer.valueOf(60), "Program ISO");
    e.put(Integer.valueOf(61), "Advanced Scene Mode");
    e.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
    e.put(Integer.valueOf(63), "Number of Detected Faces");
    e.put(Integer.valueOf(64), "Saturation");
    e.put(Integer.valueOf(65), "Sharpness");
    e.put(Integer.valueOf(66), "Film Mode");
    e.put(Integer.valueOf(70), "White Balance Adjust (AB)");
    e.put(Integer.valueOf(71), "White Balance Adjust (GM)");
    e.put(Integer.valueOf(77), "Af Point Position");
    e.put(Integer.valueOf(78), "Face Detection Info");
    e.put(Integer.valueOf(81), "Lens Type");
    e.put(Integer.valueOf(82), "Lens Serial Number");
    e.put(Integer.valueOf(83), "Accessory Type");
    e.put(Integer.valueOf(89), "Transform");
    e.put(Integer.valueOf(93), "Intelligent Exposure");
    e.put(Integer.valueOf(97), "Face Recognition Info");
    e.put(Integer.valueOf(98), "Flash Warning");
    e.put(Integer.valueOf(99), "Recognized Face Flags");
    e.put(Integer.valueOf(101), "Title");
    e.put(Integer.valueOf(102), "Baby Name");
    e.put(Integer.valueOf(103), "Location");
    e.put(Integer.valueOf(105), "Country");
    e.put(Integer.valueOf(107), "State");
    e.put(Integer.valueOf(109), "City");
    e.put(Integer.valueOf(111), "Landmark");
    e.put(Integer.valueOf(112), "Intelligent Resolution");
    e.put(Integer.valueOf(32768), "Makernote Version");
    e.put(Integer.valueOf(32769), "Scene Mode");
    e.put(Integer.valueOf(32772), "White Balance (Red)");
    e.put(Integer.valueOf(32773), "White Balance (Green)");
    e.put(Integer.valueOf(32774), "White Balance (Blue)");
    e.put(Integer.valueOf(32775), "Flash Fired");
    e.put(Integer.valueOf(62), "Text Stamp 1");
    e.put(Integer.valueOf(32776), "Text Stamp 2");
    e.put(Integer.valueOf(32777), "Text Stamp 3");
    e.put(Integer.valueOf(32784), "Baby Age 1");
    e.put(Integer.valueOf(32786), "Transform 1");
  }
  
  public z()
  {
    setDescriptor(new y(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public a getAge(int paramInt)
  {
    String str = getString(paramInt);
    if (str == null) {
      return null;
    }
    return a.fromPanasonicString(str);
  }
  
  public c[] getDetectedFaces()
  {
    Object localObject = getByteArray(78);
    if (localObject == null) {
      return null;
    }
    localObject = new com.b.b.b((byte[])localObject);
    ((j)localObject).setMotorolaByteOrder(false);
    try
    {
      int j = ((j)localObject).getUInt16(0);
      if (j == 0) {
        return null;
      }
      c[] arrayOfc = new c[j];
      int i = 0;
      while (i < j)
      {
        int k = i * 8 + 2;
        arrayOfc[i] = new c(((j)localObject).getUInt16(k), ((j)localObject).getUInt16(k + 2), ((j)localObject).getUInt16(k + 4), ((j)localObject).getUInt16(k + 6), null, null);
        i += 1;
      }
      return arrayOfc;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getName()
  {
    return "Panasonic Makernote";
  }
  
  public c[] getRecognizedFaces()
  {
    Object localObject = getByteArray(97);
    if (localObject == null) {
      return null;
    }
    localObject = new com.b.b.b((byte[])localObject);
    ((j)localObject).setMotorolaByteOrder(false);
    try
    {
      int j = ((j)localObject).getUInt16(0);
      if (j == 0) {
        return null;
      }
      c[] arrayOfc = new c[j];
      int i = 0;
      while (i < j)
      {
        int k = i * 44 + 4;
        String str1 = ((j)localObject).getString(k, 20, "ASCII").trim();
        String str2 = ((j)localObject).getString(k + 28, 20, "ASCII").trim();
        arrayOfc[i] = new c(((j)localObject).getUInt16(k + 20), ((j)localObject).getUInt16(k + 22), ((j)localObject).getUInt16(k + 24), ((j)localObject).getUInt16(k + 26), str1, a.fromPanasonicString(str2));
        i += 1;
      }
      return arrayOfc;
    }
    catch (IOException localIOException) {}
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */