package com.b.c.c.a;

import com.b.b.m;
import com.b.c.b;
import java.io.IOException;
import java.util.HashMap;

public class x
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(0), "Makernote Version");
    e.put(Integer.valueOf(1), "Camera Settings");
    e.put(Integer.valueOf(3), "Camera Settings");
    e.put(Integer.valueOf(64), "Compressed Image Size");
    e.put(Integer.valueOf(129), "Thumbnail Offset");
    e.put(Integer.valueOf(136), "Thumbnail Offset");
    e.put(Integer.valueOf(137), "Thumbnail Length");
    e.put(Integer.valueOf(256), "Thumbnail Image");
    e.put(Integer.valueOf(257), "Colour Mode");
    e.put(Integer.valueOf(258), "Image Quality");
    e.put(Integer.valueOf(259), "Image Quality");
    e.put(Integer.valueOf(260), "Body Firmware Version");
    e.put(Integer.valueOf(512), "Special Mode");
    e.put(Integer.valueOf(513), "JPEG Quality");
    e.put(Integer.valueOf(514), "Macro");
    e.put(Integer.valueOf(515), "BW Mode");
    e.put(Integer.valueOf(516), "DigiZoom Ratio");
    e.put(Integer.valueOf(517), "Focal Plane Diagonal");
    e.put(Integer.valueOf(518), "Lens Distortion Parameters");
    e.put(Integer.valueOf(519), "Firmware Version");
    e.put(Integer.valueOf(520), "Pict Info");
    e.put(Integer.valueOf(521), "Camera Id");
    e.put(Integer.valueOf(523), "Image Width");
    e.put(Integer.valueOf(524), "Image Height");
    e.put(Integer.valueOf(525), "Original Manufacturer Model");
    e.put(Integer.valueOf(640), "Preview Image");
    e.put(Integer.valueOf(768), "Pre Capture Frames");
    e.put(Integer.valueOf(769), "White Board");
    e.put(Integer.valueOf(770), "One Touch WB");
    e.put(Integer.valueOf(771), "White Balance Bracket");
    e.put(Integer.valueOf(772), "White Balance Bias");
    e.put(Integer.valueOf(1027), "Scene Mode");
    e.put(Integer.valueOf(1028), "Firmware");
    e.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
    e.put(Integer.valueOf(3840), "Data Dump");
    e.put(Integer.valueOf(3841), "Data Dump 2");
    e.put(Integer.valueOf(4096), "Shutter Speed Value");
    e.put(Integer.valueOf(4097), "ISO Value");
    e.put(Integer.valueOf(4098), "Aperture Value");
    e.put(Integer.valueOf(4099), "Brightness Value");
    e.put(Integer.valueOf(4100), "Flash Mode");
    e.put(Integer.valueOf(4101), "Flash Device");
    e.put(Integer.valueOf(4102), "Bracket");
    e.put(Integer.valueOf(4103), "Sensor Temperature");
    e.put(Integer.valueOf(4104), "Lens Temperature");
    e.put(Integer.valueOf(4105), "Light Condition");
    e.put(Integer.valueOf(4106), "Focus Range");
    e.put(Integer.valueOf(4107), "Focus Mode");
    e.put(Integer.valueOf(4108), "Focus Distance");
    e.put(Integer.valueOf(4109), "Zoom");
    e.put(Integer.valueOf(4110), "Macro Focus");
    e.put(Integer.valueOf(4111), "Sharpness");
    e.put(Integer.valueOf(4112), "Flash Charge Level");
    e.put(Integer.valueOf(4113), "Colour Matrix");
    e.put(Integer.valueOf(4114), "Black Level");
    e.put(Integer.valueOf(4117), "White Balance");
    e.put(Integer.valueOf(4119), "Red Bias");
    e.put(Integer.valueOf(4120), "Blue Bias");
    e.put(Integer.valueOf(4121), "Color Matrix Number");
    e.put(Integer.valueOf(4122), "Serial Number");
    e.put(Integer.valueOf(4131), "Flash Bias");
    e.put(Integer.valueOf(4134), "External Flash Bounce");
    e.put(Integer.valueOf(4135), "External Flash Zoom");
    e.put(Integer.valueOf(4136), "External Flash Mode");
    e.put(Integer.valueOf(4137), "Contrast");
    e.put(Integer.valueOf(4138), "Sharpness Factor");
    e.put(Integer.valueOf(4139), "Colour Control");
    e.put(Integer.valueOf(4140), "Valid Bits");
    e.put(Integer.valueOf(4141), "Coring Filter");
    e.put(Integer.valueOf(4142), "Final Width");
    e.put(Integer.valueOf(4143), "Final Height");
    e.put(Integer.valueOf(4148), "Compression Ratio");
    e.put(Integer.valueOf(4149), "Thumbnail");
    e.put(Integer.valueOf(4150), "Thumbnail Offset");
    e.put(Integer.valueOf(4151), "Thumbnail Length");
    e.put(Integer.valueOf(4153), "CCD Scan Mode");
    e.put(Integer.valueOf(4154), "Noise Reduction");
    e.put(Integer.valueOf(4155), "Infinity Lens Step");
    e.put(Integer.valueOf(4156), "Near Lens Step");
    e.put(Integer.valueOf(8208), "Equipment");
    e.put(Integer.valueOf(8224), "Camera Settings");
    e.put(Integer.valueOf(8240), "Raw Development");
    e.put(Integer.valueOf(8241), "Raw Development 2");
    e.put(Integer.valueOf(8256), "Image Processing");
    e.put(Integer.valueOf(8272), "Focus Info");
    e.put(Integer.valueOf(12288), "Raw Info");
    e.put(Integer.valueOf(61442), "Exposure Mode");
    e.put(Integer.valueOf(61443), "Flash Mode");
    e.put(Integer.valueOf(61444), "White Balance");
    e.put(Integer.valueOf(61445), "Image Size");
    e.put(Integer.valueOf(61446), "Image Quality");
    e.put(Integer.valueOf(61447), "Shooting Mode");
    e.put(Integer.valueOf(61448), "Metering Mode");
    e.put(Integer.valueOf(61449), "Apex Film Speed Value");
    e.put(Integer.valueOf(61450), "Apex Shutter Speed Time Value");
    e.put(Integer.valueOf(61451), "Apex Aperture Value");
    e.put(Integer.valueOf(61452), "Macro Mode");
    e.put(Integer.valueOf(61453), "Digital Zoom");
    e.put(Integer.valueOf(61454), "Exposure Compensation");
    e.put(Integer.valueOf(61455), "Bracket Step");
    e.put(Integer.valueOf(61457), "Interval Length");
    e.put(Integer.valueOf(61458), "Interval Number");
    e.put(Integer.valueOf(61459), "Focal Length");
    e.put(Integer.valueOf(61460), "Focus Distance");
    e.put(Integer.valueOf(61461), "Flash Fired");
    e.put(Integer.valueOf(61462), "Date");
    e.put(Integer.valueOf(61463), "Time");
    e.put(Integer.valueOf(61464), "Max Aperture at Focal Length");
    e.put(Integer.valueOf(61467), "File Number Memory");
    e.put(Integer.valueOf(61468), "Last File Number");
    e.put(Integer.valueOf(61469), "White Balance Red");
    e.put(Integer.valueOf(61470), "White Balance Green");
    e.put(Integer.valueOf(61471), "White Balance Blue");
    e.put(Integer.valueOf(61472), "Saturation");
    e.put(Integer.valueOf(61473), "Contrast");
    e.put(Integer.valueOf(61474), "Sharpness");
    e.put(Integer.valueOf(61475), "Subject Program");
    e.put(Integer.valueOf(61476), "Flash Compensation");
    e.put(Integer.valueOf(61477), "ISO Setting");
    e.put(Integer.valueOf(61478), "Camera Model");
    e.put(Integer.valueOf(61479), "Interval Mode");
    e.put(Integer.valueOf(61480), "Folder Name");
    e.put(Integer.valueOf(61481), "Color Mode");
    e.put(Integer.valueOf(61482), "Color Filter");
    e.put(Integer.valueOf(61483), "Black and White Filter");
    e.put(Integer.valueOf(61484), "Internal Flash");
    e.put(Integer.valueOf(61485), "Apex Brightness Value");
    e.put(Integer.valueOf(61486), "Spot Focus Point X Coordinate");
    e.put(Integer.valueOf(61487), "Spot Focus Point Y Coordinate");
    e.put(Integer.valueOf(61488), "Wide Focus Zone");
    e.put(Integer.valueOf(61489), "Focus Mode");
    e.put(Integer.valueOf(61490), "Focus Area");
    e.put(Integer.valueOf(61491), "DEC Switch Position");
  }
  
  public x()
  {
    setDescriptor(new w(this));
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    m localm = new m(paramArrayOfByte);
    localm.setMotorolaByteOrder(true);
    int j = paramArrayOfByte.length / 4;
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          setInt(61440 + i, localm.getInt32());
          i += 1;
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Olympus Makernote";
  }
  
  public boolean isIntervalMode()
  {
    Long localLong = getLongObject(61447);
    return (localLong != null) && (localLong.longValue() == 5L);
  }
  
  public void setByteArray(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt == 1) || (paramInt == 3))
    {
      a(paramArrayOfByte);
      return;
    }
    super.setByteArray(paramInt, paramArrayOfByte);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */