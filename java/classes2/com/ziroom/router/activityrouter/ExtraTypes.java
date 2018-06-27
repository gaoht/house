package com.ziroom.router.activityrouter;

import java.util.Map;

public class ExtraTypes
{
  public static final int BOOL = 3;
  public static final int BYTE = 7;
  public static final int CHAR = 8;
  public static final int DOUBLE = 6;
  public static final int FLOAT = 5;
  public static final int INT = 1;
  public static final int LONG = 2;
  public static final int SHORT = 4;
  public static final int STRING = -1;
  private String[] booleanExtra;
  private String[] byteExtra;
  private String[] charExtra;
  private String[] doubleExtra;
  private String[] floatExtra;
  private String[] intExtra;
  private String[] longExtra;
  private String[] shortExtra;
  private Map<String, String> transfer;
  
  private static boolean arrayContain(String[] paramArrayOfString, String paramString)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfString[i].equals(paramString)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public String[] getBooleanExtra()
  {
    return this.booleanExtra;
  }
  
  public String[] getByteExtra()
  {
    return this.byteExtra;
  }
  
  public String[] getCharExtra()
  {
    return this.charExtra;
  }
  
  public String[] getDoubleExtra()
  {
    return this.doubleExtra;
  }
  
  public String[] getFloatExtra()
  {
    return this.floatExtra;
  }
  
  public String[] getIntExtra()
  {
    return this.intExtra;
  }
  
  public String[] getLongExtra()
  {
    return this.longExtra;
  }
  
  public String[] getShortExtra()
  {
    return this.shortExtra;
  }
  
  public Map<String, String> getTransfer()
  {
    return this.transfer;
  }
  
  public int getType(String paramString)
  {
    if (arrayContain(this.intExtra, paramString)) {
      return 1;
    }
    if (arrayContain(this.longExtra, paramString)) {
      return 2;
    }
    if (arrayContain(this.booleanExtra, paramString)) {
      return 3;
    }
    if (arrayContain(this.shortExtra, paramString)) {
      return 4;
    }
    if (arrayContain(this.floatExtra, paramString)) {
      return 5;
    }
    if (arrayContain(this.doubleExtra, paramString)) {
      return 6;
    }
    if (arrayContain(this.byteExtra, paramString)) {
      return 7;
    }
    if (arrayContain(this.charExtra, paramString)) {
      return 8;
    }
    return -1;
  }
  
  public void setBooleanExtra(String[] paramArrayOfString)
  {
    this.booleanExtra = paramArrayOfString;
  }
  
  public void setByteExtra(String[] paramArrayOfString)
  {
    this.byteExtra = paramArrayOfString;
  }
  
  public void setCharExtra(String[] paramArrayOfString)
  {
    this.charExtra = paramArrayOfString;
  }
  
  public void setDoubleExtra(String[] paramArrayOfString)
  {
    this.doubleExtra = paramArrayOfString;
  }
  
  public void setFloatExtra(String[] paramArrayOfString)
  {
    this.floatExtra = paramArrayOfString;
  }
  
  public void setIntExtra(String[] paramArrayOfString)
  {
    this.intExtra = paramArrayOfString;
  }
  
  public void setLongExtra(String[] paramArrayOfString)
  {
    this.longExtra = paramArrayOfString;
  }
  
  public void setShortExtra(String[] paramArrayOfString)
  {
    this.shortExtra = paramArrayOfString;
  }
  
  public void setTransfer(Map<String, String> paramMap)
  {
    this.transfer = paramMap;
  }
  
  public String transfer(String paramString)
  {
    if (this.transfer == null) {
      return paramString;
    }
    String str = (String)this.transfer.get(paramString);
    if (str != null) {
      paramString = str;
    }
    for (;;)
    {
      return paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/router/activityrouter/ExtraTypes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */