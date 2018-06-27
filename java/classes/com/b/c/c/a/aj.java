package com.b.c.c.a;

import com.b.c.b;
import java.util.HashMap;

public class aj
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(16), "Camera Info");
    e.put(Integer.valueOf(32), "Focus Info");
    e.put(Integer.valueOf(258), "Image Quality");
    e.put(Integer.valueOf(260), "Flash Exposure Compensation");
    e.put(Integer.valueOf(261), "Teleconverter Model");
    e.put(Integer.valueOf(274), "White Balance Fine Tune Value");
    e.put(Integer.valueOf(276), "Camera Settings");
    e.put(Integer.valueOf(277), "White Balance");
    e.put(Integer.valueOf(278), "Extra Info");
    e.put(Integer.valueOf(3584), "Print Image Matching Info");
    e.put(Integer.valueOf(4096), "Multi Burst Mode");
    e.put(Integer.valueOf(4097), "Multi Burst Image Width");
    e.put(Integer.valueOf(4098), "Multi Burst Image Height");
    e.put(Integer.valueOf(4099), "Panorama");
    e.put(Integer.valueOf(8193), "Preview Image");
    e.put(Integer.valueOf(8194), "Rating");
    e.put(Integer.valueOf(8196), "Contrast");
    e.put(Integer.valueOf(8197), "Saturation");
    e.put(Integer.valueOf(8198), "Sharpness");
    e.put(Integer.valueOf(8199), "Brightness");
    e.put(Integer.valueOf(8200), "Long Exposure Noise Reduction");
    e.put(Integer.valueOf(8201), "High ISO Noise Reduction");
    e.put(Integer.valueOf(8202), "HDR");
    e.put(Integer.valueOf(8203), "Multi Frame Noise Reduction");
    e.put(Integer.valueOf(8206), "Picture Effect");
    e.put(Integer.valueOf(8207), "Soft Skin Effect");
    e.put(Integer.valueOf(8209), "Vignetting Correction");
    e.put(Integer.valueOf(8210), "Lateral Chromatic Aberration");
    e.put(Integer.valueOf(8211), "Distortion Correction");
    e.put(Integer.valueOf(8212), "WB Shift Amber/Magenta");
    e.put(Integer.valueOf(8214), "Auto Portrait Framing");
    e.put(Integer.valueOf(8219), "Focus Mode");
    e.put(Integer.valueOf(8222), "AF Point Selected");
    e.put(Integer.valueOf(12288), "Shot Info");
    e.put(Integer.valueOf(45056), "File Format");
    e.put(Integer.valueOf(45057), "Sony Model ID");
    e.put(Integer.valueOf(45088), "Color Mode Setting");
    e.put(Integer.valueOf(45089), "Color Temperature");
    e.put(Integer.valueOf(45090), "Color Compensation Filter");
    e.put(Integer.valueOf(45091), "Scene Mode");
    e.put(Integer.valueOf(45092), "Zone Matching");
    e.put(Integer.valueOf(45093), "Dynamic Range Optimizer");
    e.put(Integer.valueOf(45094), "Image Stabilisation");
    e.put(Integer.valueOf(45095), "Lens ID");
    e.put(Integer.valueOf(45096), "Minolta Makernote");
    e.put(Integer.valueOf(45097), "Color Mode");
    e.put(Integer.valueOf(45098), "Lens Spec");
    e.put(Integer.valueOf(45099), "Full Image Size");
    e.put(Integer.valueOf(45100), "Preview Image Size");
    e.put(Integer.valueOf(45120), "Macro");
    e.put(Integer.valueOf(45121), "Exposure Mode");
    e.put(Integer.valueOf(45122), "Focus Mode");
    e.put(Integer.valueOf(45123), "AF Mode");
    e.put(Integer.valueOf(45124), "AF Illuminator");
    e.put(Integer.valueOf(45127), "Quality");
    e.put(Integer.valueOf(45128), "Flash Level");
    e.put(Integer.valueOf(45129), "Release Mode");
    e.put(Integer.valueOf(45130), "Sequence Number");
    e.put(Integer.valueOf(45131), "Anti Blur");
    e.put(Integer.valueOf(45134), "Long Exposure Noise Reduction");
    e.put(Integer.valueOf(45135), "Dynamic Range Optimizer");
    e.put(Integer.valueOf(45136), "High ISO Noise Reduction");
    e.put(Integer.valueOf(45138), "Intelligent Auto");
    e.put(Integer.valueOf(45140), "White Balance 2");
    e.put(Integer.valueOf(65535), "No Print");
  }
  
  public aj()
  {
    setDescriptor(new ai(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Sony Makernote";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/a/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */