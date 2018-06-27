package com.b.c.c.a;

import com.b.c.g;
import java.text.DecimalFormat;
import java.util.HashMap;

public class u
  extends g<v>
{
  private static final HashMap<String, String> c = new HashMap();
  private static final HashMap<String, String> d = new HashMap();
  
  static
  {
    c.put("0 00 00", "None");
    c.put("0 01 00", "Olympus Zuiko Digital ED 50mm F2.0 Macro");
    c.put("0 01 01", "Olympus Zuiko Digital 40-150mm F3.5-4.5");
    c.put("0 01 10", "Olympus M.Zuiko Digital ED 14-42mm F3.5-5.6");
    c.put("0 02 00", "Olympus Zuiko Digital ED 150mm F2.0");
    c.put("0 02 10", "Olympus M.Zuiko Digital 17mm F2.8 Pancake");
    c.put("0 03 00", "Olympus Zuiko Digital ED 300mm F2.8");
    c.put("0 03 10", "Olympus M.Zuiko Digital ED 14-150mm F4.0-5.6 [II]");
    c.put("0 04 10", "Olympus M.Zuiko Digital ED 9-18mm F4.0-5.6");
    c.put("0 05 00", "Olympus Zuiko Digital 14-54mm F2.8-3.5");
    c.put("0 05 01", "Olympus Zuiko Digital Pro ED 90-250mm F2.8");
    c.put("0 05 10", "Olympus M.Zuiko Digital ED 14-42mm F3.5-5.6 L");
    c.put("0 06 00", "Olympus Zuiko Digital ED 50-200mm F2.8-3.5");
    c.put("0 06 01", "Olympus Zuiko Digital ED 8mm F3.5 Fisheye");
    c.put("0 06 10", "Olympus M.Zuiko Digital ED 40-150mm F4.0-5.6");
    c.put("0 07 00", "Olympus Zuiko Digital 11-22mm F2.8-3.5");
    c.put("0 07 01", "Olympus Zuiko Digital 18-180mm F3.5-6.3");
    c.put("0 07 10", "Olympus M.Zuiko Digital ED 12mm F2.0");
    c.put("0 08 01", "Olympus Zuiko Digital 70-300mm F4.0-5.6");
    c.put("0 08 10", "Olympus M.Zuiko Digital ED 75-300mm F4.8-6.7");
    c.put("0 09 10", "Olympus M.Zuiko Digital 14-42mm F3.5-5.6 II");
    c.put("0 10 01", "Kenko Tokina Reflex 300mm F6.3 MF Macro");
    c.put("0 10 10", "Olympus M.Zuiko Digital ED 12-50mm F3.5-6.3 EZ");
    c.put("0 11 10", "Olympus M.Zuiko Digital 45mm F1.8");
    c.put("0 12 10", "Olympus M.Zuiko Digital ED 60mm F2.8 Macro");
    c.put("0 13 10", "Olympus M.Zuiko Digital 14-42mm F3.5-5.6 II R");
    c.put("0 14 10", "Olympus M.Zuiko Digital ED 40-150mm F4.0-5.6 R");
    c.put("0 15 00", "Olympus Zuiko Digital ED 7-14mm F4.0");
    c.put("0 15 10", "Olympus M.Zuiko Digital ED 75mm F1.8");
    c.put("0 16 10", "Olympus M.Zuiko Digital 17mm F1.8");
    c.put("0 17 00", "Olympus Zuiko Digital Pro ED 35-100mm F2.0");
    c.put("0 18 00", "Olympus Zuiko Digital 14-45mm F3.5-5.6");
    c.put("0 18 10", "Olympus M.Zuiko Digital ED 75-300mm F4.8-6.7 II");
    c.put("0 19 10", "Olympus M.Zuiko Digital ED 12-40mm F2.8 Pro");
    c.put("0 20 00", "Olympus Zuiko Digital 35mm F3.5 Macro");
    c.put("0 20 10", "Olympus M.Zuiko Digital ED 40-150mm F2.8 Pro");
    c.put("0 21 10", "Olympus M.Zuiko Digital ED 14-42mm F3.5-5.6 EZ");
    c.put("0 22 00", "Olympus Zuiko Digital 17.5-45mm F3.5-5.6");
    c.put("0 22 10", "Olympus M.Zuiko Digital 25mm F1.8");
    c.put("0 23 00", "Olympus Zuiko Digital ED 14-42mm F3.5-5.6");
    c.put("0 23 10", "Olympus M.Zuiko Digital ED 7-14mm F2.8 Pro");
    c.put("0 24 00", "Olympus Zuiko Digital ED 40-150mm F4.0-5.6");
    c.put("0 24 10", "Olympus M.Zuiko Digital ED 300mm F4.0 IS Pro");
    c.put("0 25 10", "Olympus M.Zuiko Digital ED 8mm F1.8 Fisheye Pro");
    c.put("0 30 00", "Olympus Zuiko Digital ED 50-200mm F2.8-3.5 SWD");
    c.put("0 31 00", "Olympus Zuiko Digital ED 12-60mm F2.8-4.0 SWD");
    c.put("0 32 00", "Olympus Zuiko Digital ED 14-35mm F2.0 SWD");
    c.put("0 33 00", "Olympus Zuiko Digital 25mm F2.8");
    c.put("0 34 00", "Olympus Zuiko Digital ED 9-18mm F4.0-5.6");
    c.put("0 35 00", "Olympus Zuiko Digital 14-54mm F2.8-3.5 II");
    c.put("1 01 00", "Sigma 18-50mm F3.5-5.6 DC");
    c.put("1 01 10", "Sigma 30mm F2.8 EX DN");
    c.put("1 02 00", "Sigma 55-200mm F4.0-5.6 DC");
    c.put("1 02 10", "Sigma 19mm F2.8 EX DN");
    c.put("1 03 00", "Sigma 18-125mm F3.5-5.6 DC");
    c.put("1 03 10", "Sigma 30mm F2.8 DN | A");
    c.put("1 04 00", "Sigma 18-125mm F3.5-5.6 DC");
    c.put("1 04 10", "Sigma 19mm F2.8 DN | A");
    c.put("1 05 00", "Sigma 30mm F1.4 EX DC HSM");
    c.put("1 05 10", "Sigma 60mm F2.8 DN | A");
    c.put("1 06 00", "Sigma APO 50-500mm F4.0-6.3 EX DG HSM");
    c.put("1 07 00", "Sigma Macro 105mm F2.8 EX DG");
    c.put("1 08 00", "Sigma APO Macro 150mm F2.8 EX DG HSM");
    c.put("1 09 00", "Sigma 18-50mm F2.8 EX DC Macro");
    c.put("1 10 00", "Sigma 24mm F1.8 EX DG Aspherical Macro");
    c.put("1 11 00", "Sigma APO 135-400mm F4.5-5.6 DG");
    c.put("1 12 00", "Sigma APO 300-800mm F5.6 EX DG HSM");
    c.put("1 13 00", "Sigma 30mm F1.4 EX DC HSM");
    c.put("1 14 00", "Sigma APO 50-500mm F4.0-6.3 EX DG HSM");
    c.put("1 15 00", "Sigma 10-20mm F4.0-5.6 EX DC HSM");
    c.put("1 16 00", "Sigma APO 70-200mm F2.8 II EX DG Macro HSM");
    c.put("1 17 00", "Sigma 50mm F1.4 EX DG HSM");
    c.put("2 01 00", "Leica D Vario Elmarit 14-50mm F2.8-3.5 Asph.");
    c.put("2 01 10", "Lumix G Vario 14-45mm F3.5-5.6 Asph. Mega OIS");
    c.put("2 02 00", "Leica D Summilux 25mm F1.4 Asph.");
    c.put("2 02 10", "Lumix G Vario 45-200mm F4.0-5.6 Mega OIS");
    c.put("2 03 00", "Leica D Vario Elmar 14-50mm F3.8-5.6 Asph. Mega OIS");
    c.put("2 03 01", "Leica D Vario Elmar 14-50mm F3.8-5.6 Asph.");
    c.put("2 03 10", "Lumix G Vario HD 14-140mm F4.0-5.8 Asph. Mega OIS");
    c.put("2 04 00", "Leica D Vario Elmar 14-150mm F3.5-5.6");
    c.put("2 04 10", "Lumix G Vario 7-14mm F4.0 Asph.");
    c.put("2 05 10", "Lumix G 20mm F1.7 Asph.");
    c.put("2 06 10", "Leica DG Macro-Elmarit 45mm F2.8 Asph. Mega OIS");
    c.put("2 07 10", "Lumix G Vario 14-42mm F3.5-5.6 Asph. Mega OIS");
    c.put("2 08 10", "Lumix G Fisheye 8mm F3.5");
    c.put("2 09 10", "Lumix G Vario 100-300mm F4.0-5.6 Mega OIS");
    c.put("2 10 10", "Lumix G 14mm F2.5 Asph.");
    c.put("2 11 10", "Lumix G 12.5mm F12 3D");
    c.put("2 12 10", "Leica DG Summilux 25mm F1.4 Asph.");
    c.put("2 13 10", "Lumix G X Vario PZ 45-175mm F4.0-5.6 Asph. Power OIS");
    c.put("2 14 10", "Lumix G X Vario PZ 14-42mm F3.5-5.6 Asph. Power OIS");
    c.put("2 15 10", "Lumix G X Vario 12-35mm F2.8 Asph. Power OIS");
    c.put("2 16 10", "Lumix G Vario 45-150mm F4.0-5.6 Asph. Mega OIS");
    c.put("2 17 10", "Lumix G X Vario 35-100mm F2.8 Power OIS");
    c.put("2 18 10", "Lumix G Vario 14-42mm F3.5-5.6 II Asph. Mega OIS");
    c.put("2 19 10", "Lumix G Vario 14-140mm F3.5-5.6 Asph. Power OIS");
    c.put("2 20 10", "Lumix G Vario 12-32mm F3.5-5.6 Asph. Mega OIS");
    c.put("2 21 10", "Leica DG Nocticron 42.5mm F1.2 Asph. Power OIS");
    c.put("2 22 10", "Leica DG Summilux 15mm F1.7 Asph.");
    c.put("2 24 10", "Lumix G Macro 30mm F2.8 Asph. Mega OIS");
    c.put("2 25 10", "Lumix G 42.5mm F1.7 Asph. Power OIS");
    c.put("3 01 00", "Leica D Vario Elmarit 14-50mm F2.8-3.5 Asph.");
    c.put("3 02 00", "Leica D Summilux 25mm F1.4 Asph.");
    c.put("5 01 10", "Tamron 14-150mm F3.5-5.8 Di III");
    d.put("0 00", "None");
    d.put("0 04", "Olympus Zuiko Digital EC-14 1.4x Teleconverter");
    d.put("0 08", "Olympus EX-25 Extension Tube");
    d.put("0 10", "Olympus Zuiko Digital EC-20 2.0x Teleconverter");
  }
  
  public u(v paramv)
  {
    super(paramv);
  }
  
  private static double h(int paramInt)
  {
    return Math.pow(Math.sqrt(2.0D), paramInt / 256.0D);
  }
  
  public String GetBodyFirmwareVersionDescription()
  {
    Object localObject = ((v)this.a).getInteger(260);
    if (localObject == null) {
      return null;
    }
    localObject = String.format("%04X", new Object[] { localObject });
    return String.format("%s.%s", new Object[] { ((String)localObject).substring(0, ((String)localObject).length() - 3), ((String)localObject).substring(((String)localObject).length() - 3) });
  }
  
  public String GetEquipmentVersionDescription()
  {
    return a(0, 4);
  }
  
  public String GetExtenderDescription()
  {
    Object localObject = ((v)this.a).getString(769);
    if (localObject == null) {
      return null;
    }
    localObject = ((String)localObject).split(" ");
    if (localObject.length < 6) {
      return null;
    }
    try
    {
      localObject = String.format("%X %02X", new Object[] { Integer.valueOf(Integer.parseInt(localObject[0])), Integer.valueOf(Integer.parseInt(localObject[2])) });
      localObject = (String)d.get(localObject);
      return (String)localObject;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return null;
  }
  
  public String GetFlashModelDescription()
  {
    return a(4097, new String[] { "None", "FL-20", "FL-50", "RF-11", "TF-22", "FL-36", "FL-50R", "FL-36R" });
  }
  
  public String GetFlashTypeDescription()
  {
    return a(4096, new String[] { "None", null, "Simple E-System", "E-System" });
  }
  
  public String GetFocalPlaneDiagonalDescription()
  {
    return ((v)this.a).getString(259) + " mm";
  }
  
  public String GetLensFirmwareVersionDescription()
  {
    Object localObject = ((v)this.a).getInteger(516);
    if (localObject == null) {
      return null;
    }
    localObject = String.format("%04X", new Object[] { localObject });
    return String.format("%s.%s", new Object[] { ((String)localObject).substring(0, ((String)localObject).length() - 3), ((String)localObject).substring(((String)localObject).length() - 3) });
  }
  
  public String GetLensPropertiesDescription()
  {
    Integer localInteger = ((v)this.a).getInteger(523);
    if (localInteger == null) {
      return null;
    }
    return String.format("0x%04X", new Object[] { localInteger });
  }
  
  public String GetLensTypeDescription()
  {
    Object localObject = ((v)this.a).getString(513);
    if (localObject == null) {
      return null;
    }
    localObject = ((String)localObject).split(" ");
    if (localObject.length < 6) {
      return null;
    }
    try
    {
      int i = Integer.parseInt(localObject[0]);
      int j = Integer.parseInt(localObject[2]);
      int k = Integer.parseInt(localObject[3]);
      localObject = (String)c.get(String.format("%X %02X %02X", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
      return (String)localObject;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return null;
  }
  
  public String GetMaxApertureAtMaxFocalDescription()
  {
    Integer localInteger = ((v)this.a).getInteger(518);
    if (localInteger == null) {
      return null;
    }
    return new DecimalFormat("0.#").format(h(localInteger.intValue()));
  }
  
  public String GetMaxApertureAtMinFocalDescription()
  {
    Integer localInteger = ((v)this.a).getInteger(517);
    if (localInteger == null) {
      return null;
    }
    return new DecimalFormat("0.#").format(h(localInteger.intValue()));
  }
  
  public String GetMaxApertureDescription()
  {
    Integer localInteger = ((v)this.a).getInteger(522);
    if (localInteger == null) {
      return null;
    }
    return new DecimalFormat("0.#").format(h(localInteger.intValue()));
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 0: 
      return GetEquipmentVersionDescription();
    case 259: 
      return GetFocalPlaneDiagonalDescription();
    case 260: 
      return GetBodyFirmwareVersionDescription();
    case 513: 
      return GetLensTypeDescription();
    case 516: 
      return GetLensFirmwareVersionDescription();
    case 517: 
      return GetMaxApertureAtMinFocalDescription();
    case 518: 
      return GetMaxApertureAtMaxFocalDescription();
    case 522: 
      return GetMaxApertureDescription();
    case 523: 
      return GetLensPropertiesDescription();
    case 769: 
      return GetExtenderDescription();
    case 4096: 
      return GetFlashTypeDescription();
    }
    return GetFlashModelDescription();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */