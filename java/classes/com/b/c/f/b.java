package com.b.c.f;

import java.util.HashMap;

public class b
  extends com.b.c.b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(0), "Profile Size");
    e.put(Integer.valueOf(4), "CMM Type");
    e.put(Integer.valueOf(8), "Version");
    e.put(Integer.valueOf(12), "Class");
    e.put(Integer.valueOf(16), "Color space");
    e.put(Integer.valueOf(20), "Profile Connection Space");
    e.put(Integer.valueOf(24), "Profile Date/Time");
    e.put(Integer.valueOf(36), "Signature");
    e.put(Integer.valueOf(40), "Primary Platform");
    e.put(Integer.valueOf(44), "CMM Flags");
    e.put(Integer.valueOf(48), "Device manufacturer");
    e.put(Integer.valueOf(52), "Device model");
    e.put(Integer.valueOf(56), "Device attributes");
    e.put(Integer.valueOf(64), "Rendering Intent");
    e.put(Integer.valueOf(68), "XYZ values");
    e.put(Integer.valueOf(80), "Profile Creator");
    e.put(Integer.valueOf(128), "Tag Count");
    e.put(Integer.valueOf(1093812784), "AToB 0");
    e.put(Integer.valueOf(1093812785), "AToB 1");
    e.put(Integer.valueOf(1093812786), "AToB 2");
    e.put(Integer.valueOf(1649957210), "Blue Colorant");
    e.put(Integer.valueOf(1649693251), "Blue TRC");
    e.put(Integer.valueOf(1110589744), "BToA 0");
    e.put(Integer.valueOf(1110589745), "BToA 1");
    e.put(Integer.valueOf(1110589746), "BToA 2");
    e.put(Integer.valueOf(1667329140), "Calibration Date/Time");
    e.put(Integer.valueOf(1952543335), "Char Target");
    e.put(Integer.valueOf(1667785060), "Chromatic Adaptation");
    e.put(Integer.valueOf(1667789421), "Chromaticity");
    e.put(Integer.valueOf(1668313716), "Copyright");
    e.put(Integer.valueOf(1668441193), "CrdInfo");
    e.put(Integer.valueOf(1684893284), "Device Mfg Description");
    e.put(Integer.valueOf(1684890724), "Device Model Description");
    e.put(Integer.valueOf(1684371059), "Device Settings");
    e.put(Integer.valueOf(1734438260), "Gamut");
    e.put(Integer.valueOf(1800688195), "Gray TRC");
    e.put(Integer.valueOf(1733843290), "Green Colorant");
    e.put(Integer.valueOf(1733579331), "Green TRC");
    e.put(Integer.valueOf(1819635049), "Luminance");
    e.put(Integer.valueOf(1835360627), "Measurement");
    e.put(Integer.valueOf(1651208308), "Media Black Point");
    e.put(Integer.valueOf(2004119668), "Media White Point");
    e.put(Integer.valueOf(1852010348), "Named Color");
    e.put(Integer.valueOf(1852009522), "Named Color 2");
    e.put(Integer.valueOf(1919251312), "Output Response");
    e.put(Integer.valueOf(1886545200), "Preview 0");
    e.put(Integer.valueOf(1886545201), "Preview 1");
    e.put(Integer.valueOf(1886545202), "Preview 2");
    e.put(Integer.valueOf(1684370275), "Profile Description");
    e.put(Integer.valueOf(1886610801), "Profile Sequence Description");
    e.put(Integer.valueOf(1886610480), "Ps2 CRD 0");
    e.put(Integer.valueOf(1886610481), "Ps2 CRD 1");
    e.put(Integer.valueOf(1886610482), "Ps2 CRD 2");
    e.put(Integer.valueOf(1886610483), "Ps2 CRD 3");
    e.put(Integer.valueOf(1886597747), "Ps2 CSA");
    e.put(Integer.valueOf(1886597737), "Ps2 Rendering Intent");
    e.put(Integer.valueOf(1918392666), "Red Colorant");
    e.put(Integer.valueOf(1918128707), "Red TRC");
    e.put(Integer.valueOf(1935897188), "Screening Desc");
    e.put(Integer.valueOf(1935897198), "Screening");
    e.put(Integer.valueOf(1952801640), "Technology");
    e.put(Integer.valueOf(1650877472), "Ucrbg");
    e.put(Integer.valueOf(1987405156), "Viewing Conditions Description");
    e.put(Integer.valueOf(1986618743), "Viewing Conditions");
    e.put(Integer.valueOf(1685283693), "Apple Multi-language Profile Name");
  }
  
  public b()
  {
    setDescriptor(new a(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "ICC Profile";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */