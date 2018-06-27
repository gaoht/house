package com.b.c.m;

public class f
  extends com.b.c.g<g>
{
  public f(g paramg)
  {
    super(paramg);
  }
  
  public String getBitsPerChannelDescription()
  {
    Object localObject = ((g)this.a).getInteger(4);
    if (localObject == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(localObject).append(" bit");
    if (((Integer)localObject).intValue() == 1) {}
    for (localObject = "";; localObject = "s") {
      return (String)localObject + " per channel";
    }
  }
  
  public String getChannelCountDescription()
  {
    Object localObject = ((g)this.a).getInteger(1);
    if (localObject == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(localObject).append(" channel");
    if (((Integer)localObject).intValue() == 1) {}
    for (localObject = "";; localObject = "s") {
      return (String)localObject;
    }
  }
  
  public String getColorModeDescription()
  {
    return a(5, new String[] { "Bitmap", "Grayscale", "Indexed", "RGB", "CMYK", null, null, "Multichannel", "Duotone", "Lab" });
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 1: 
      return getChannelCountDescription();
    case 4: 
      return getBitsPerChannelDescription();
    case 5: 
      return getColorModeDescription();
    case 2: 
      return getImageHeightDescription();
    }
    return getImageWidthDescription();
  }
  
  public String getImageHeightDescription()
  {
    Object localObject = ((g)this.a).getInteger(2);
    if (localObject == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(localObject).append(" pixel");
    if (((Integer)localObject).intValue() == 1) {}
    for (localObject = "";; localObject = "s") {
      return (String)localObject;
    }
  }
  
  public String getImageWidthDescription()
  {
    try
    {
      Object localObject = ((g)this.a).getInteger(3);
      if (localObject == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder().append(localObject).append(" pixel");
      if (((Integer)localObject).intValue() == 1) {}
      for (localObject = "";; localObject = "s") {
        return (String)localObject;
      }
      return null;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/m/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */