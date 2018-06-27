package com.b.c.m;

import com.b.c.b;
import java.util.HashMap;

public class d
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(1000), "Channels, Rows, Columns, Depth, Mode");
    e.put(Integer.valueOf(1001), "Mac Print Info");
    e.put(Integer.valueOf(1002), "XML Data");
    e.put(Integer.valueOf(1003), "Indexed Color Table");
    e.put(Integer.valueOf(1005), "Resolution Info");
    e.put(Integer.valueOf(1006), "Alpha Channels");
    e.put(Integer.valueOf(1007), "Display Info (Obsolete)");
    e.put(Integer.valueOf(1008), "Caption");
    e.put(Integer.valueOf(1009), "Border Information");
    e.put(Integer.valueOf(1010), "Background Color");
    e.put(Integer.valueOf(1011), "Print Flags");
    e.put(Integer.valueOf(1012), "Grayscale and Multichannel Halftoning Information");
    e.put(Integer.valueOf(1013), "Color Halftoning Information");
    e.put(Integer.valueOf(1014), "Duotone Halftoning Information");
    e.put(Integer.valueOf(1015), "Grayscale and Multichannel Transfer Function");
    e.put(Integer.valueOf(1016), "Color Transfer Functions");
    e.put(Integer.valueOf(1017), "Duotone Transfer Functions");
    e.put(Integer.valueOf(1018), "Duotone Image Information");
    e.put(Integer.valueOf(1019), "Effective Black and White Values");
    e.put(Integer.valueOf(1021), "EPS Options");
    e.put(Integer.valueOf(1022), "Quick Mask Information");
    e.put(Integer.valueOf(1024), "Layer State Information");
    e.put(Integer.valueOf(1026), "Layers Group Information");
    e.put(Integer.valueOf(1028), "IPTC-NAA Record");
    e.put(Integer.valueOf(1029), "Image Mode for Raw Format Files");
    e.put(Integer.valueOf(1030), "JPEG Quality");
    e.put(Integer.valueOf(1032), "Grid and Guides Information");
    e.put(Integer.valueOf(1033), "Photoshop 4.0 Thumbnail");
    e.put(Integer.valueOf(1034), "Copyright Flag");
    e.put(Integer.valueOf(1035), "URL");
    e.put(Integer.valueOf(1036), "Thumbnail Data");
    e.put(Integer.valueOf(1037), "Global Angle");
    e.put(Integer.valueOf(1039), "ICC Profile Bytes");
    e.put(Integer.valueOf(1040), "Watermark");
    e.put(Integer.valueOf(1041), "ICC Untagged Profile");
    e.put(Integer.valueOf(1042), "Effects Visible");
    e.put(Integer.valueOf(1043), "Spot Halftone");
    e.put(Integer.valueOf(1044), "Seed Number");
    e.put(Integer.valueOf(1045), "Unicode Alpha Names");
    e.put(Integer.valueOf(1046), "Indexed Color Table Count");
    e.put(Integer.valueOf(1047), "Transparency Index");
    e.put(Integer.valueOf(1049), "Global Altitude");
    e.put(Integer.valueOf(1050), "Slices");
    e.put(Integer.valueOf(1051), "Workflow URL");
    e.put(Integer.valueOf(1052), "Jump To XPEP");
    e.put(Integer.valueOf(1053), "Alpha Identifiers");
    e.put(Integer.valueOf(1054), "URL List");
    e.put(Integer.valueOf(1057), "Version Info");
    e.put(Integer.valueOf(1058), "EXIF Data 1");
    e.put(Integer.valueOf(1059), "EXIF Data 3");
    e.put(Integer.valueOf(1060), "XMP Data");
    e.put(Integer.valueOf(1061), "Caption Digest");
    e.put(Integer.valueOf(1062), "Print Scale");
    e.put(Integer.valueOf(1064), "Pixel Aspect Ratio");
    e.put(Integer.valueOf(1065), "Layer Comps");
    e.put(Integer.valueOf(1066), "Alternate Duotone Colors");
    e.put(Integer.valueOf(1067), "Alternate Spot Colors");
    e.put(Integer.valueOf(1069), "Layer Selection IDs");
    e.put(Integer.valueOf(1070), "HDR Toning Info");
    e.put(Integer.valueOf(1071), "Print Info");
    e.put(Integer.valueOf(1072), "Layer Groups Enabled ID");
    e.put(Integer.valueOf(1073), "Color Samplers");
    e.put(Integer.valueOf(1074), "Measurement Scale");
    e.put(Integer.valueOf(1075), "Timeline Information");
    e.put(Integer.valueOf(1076), "Sheet Disclosure");
    e.put(Integer.valueOf(1077), "Display Info");
    e.put(Integer.valueOf(1078), "Onion Skins");
    e.put(Integer.valueOf(1080), "Count information");
    e.put(Integer.valueOf(1082), "Print Info 2");
    e.put(Integer.valueOf(1083), "Print Style");
    e.put(Integer.valueOf(1084), "Mac NSPrintInfo");
    e.put(Integer.valueOf(1085), "Win DEVMODE");
    e.put(Integer.valueOf(1086), "Auto Save File Path");
    e.put(Integer.valueOf(1087), "Auto Save Format");
    e.put(Integer.valueOf(1088), "Path Selection State");
    e.put(Integer.valueOf(2999), "Clipping Path Name");
    e.put(Integer.valueOf(3000), "Origin Path Info");
    e.put(Integer.valueOf(7000), "Image Ready Variables XML");
    e.put(Integer.valueOf(7001), "Image Ready Data Sets");
    e.put(Integer.valueOf(8000), "Lightroom Workflow");
    e.put(Integer.valueOf(10000), "Print Flags Information");
  }
  
  public d()
  {
    setDescriptor(new c(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Photoshop";
  }
  
  public byte[] getThumbnailBytes()
  {
    byte[] arrayOfByte1 = getByteArray(1036);
    if (arrayOfByte1 == null) {
      arrayOfByte1 = getByteArray(1033);
    }
    for (;;)
    {
      if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 28)) {
        return null;
      }
      int i = arrayOfByte1.length - 28;
      byte[] arrayOfByte2 = new byte[i];
      System.arraycopy(arrayOfByte1, 28, arrayOfByte2, 0, i);
      return arrayOfByte2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/m/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */