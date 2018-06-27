package com.b.c.g;

import com.b.c.g;

public class a
  extends g<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  public String getColourPaletteSizeDescription()
  {
    Object localObject = ((b)this.a).getInteger(4);
    if (localObject == null) {
      return null;
    }
    if (((Integer)localObject).intValue() == 0) {
      return "No palette";
    }
    StringBuilder localStringBuilder = new StringBuilder().append(localObject).append(" colour");
    if (((Integer)localObject).intValue() == 1) {}
    for (localObject = "";; localObject = "s") {
      return (String)localObject;
    }
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 1: 
      return getImageTypeDescription();
    case 2: 
      return getImageWidthDescription();
    case 3: 
      return getImageHeightDescription();
    }
    return getColourPaletteSizeDescription();
  }
  
  public String getImageHeightDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(3);
    if (localInteger == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (localInteger.intValue() == 0) {}
    for (int i = 256;; i = localInteger.intValue()) {
      return i + " pixels";
    }
  }
  
  public String getImageTypeDescription()
  {
    return a(1, 1, new String[] { "Icon", "Cursor" });
  }
  
  public String getImageWidthDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(2);
    if (localInteger == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (localInteger.intValue() == 0) {}
    for (int i = 256;; i = localInteger.intValue()) {
      return i + " pixels";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */