package com.alibaba.fastjson.asm;

public class Type
{
  public static final Type BOOLEAN_TYPE;
  public static final Type BYTE_TYPE;
  public static final Type CHAR_TYPE;
  public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);
  public static final Type FLOAT_TYPE;
  public static final Type INT_TYPE;
  public static final Type LONG_TYPE;
  public static final Type SHORT_TYPE;
  public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
  private final char[] buf;
  private final int len;
  private final int off;
  protected final int sort;
  
  static
  {
    BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    CHAR_TYPE = new Type(2, null, 1124075009, 1);
    BYTE_TYPE = new Type(3, null, 1107297537, 1);
    SHORT_TYPE = new Type(4, null, 1392510721, 1);
    INT_TYPE = new Type(5, null, 1224736769, 1);
    FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    LONG_TYPE = new Type(7, null, 1241579778, 1);
  }
  
  private Type(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    this.sort = paramInt1;
    this.buf = paramArrayOfChar;
    this.off = paramInt2;
    this.len = paramInt3;
  }
  
  public static int getArgumentsAndReturnSizes(String paramString)
  {
    int m = 1;
    int j = 1;
    int i = 1;
    for (;;)
    {
      int k = j + 1;
      j = paramString.charAt(j);
      if (j == 41)
      {
        k = paramString.charAt(k);
        if (k == 86) {
          j = 0;
        }
        for (;;)
        {
          return i << 2 | j;
          if (k != 68)
          {
            j = m;
            if (k != 74) {}
          }
          else
          {
            j = 2;
          }
        }
      }
      if (j == 76)
      {
        for (;;)
        {
          j = k + 1;
          if (paramString.charAt(k) == ';') {
            break;
          }
          k = j;
        }
        i += 1;
      }
      else if ((j == 68) || (j == 74))
      {
        i += 2;
        j = k;
      }
      else
      {
        i += 1;
        j = k;
      }
    }
  }
  
  public static Type getType(String paramString)
  {
    return getType(paramString.toCharArray(), 0);
  }
  
  private static Type getType(char[] paramArrayOfChar, int paramInt)
  {
    int i = 1;
    int j = 1;
    switch (paramArrayOfChar[paramInt])
    {
    default: 
      i = j;
    }
    while (paramArrayOfChar[(paramInt + i)] != ';')
    {
      i += 1;
      continue;
      return VOID_TYPE;
      return BOOLEAN_TYPE;
      return CHAR_TYPE;
      return BYTE_TYPE;
      return SHORT_TYPE;
      return INT_TYPE;
      return FLOAT_TYPE;
      return LONG_TYPE;
      return DOUBLE_TYPE;
      while (paramArrayOfChar[(paramInt + i)] == '[') {
        i += 1;
      }
      j = i;
      if (paramArrayOfChar[(paramInt + i)] == 'L')
      {
        i += 1;
        for (;;)
        {
          j = i;
          if (paramArrayOfChar[(paramInt + i)] == ';') {
            break;
          }
          i += 1;
        }
      }
      return new Type(9, paramArrayOfChar, paramInt, j + 1);
    }
    return new Type(10, paramArrayOfChar, paramInt + 1, i - 1);
  }
  
  String getDescriptor()
  {
    return new String(this.buf, this.off, this.len);
  }
  
  public String getInternalName()
  {
    return new String(this.buf, this.off, this.len);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/asm/Type.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */