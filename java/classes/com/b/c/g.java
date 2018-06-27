package com.b.c;

import com.b.b.l;
import com.b.b.p;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class g<T extends b>
{
  protected final T a;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
  public g(T paramT)
  {
    this.a = paramT;
  }
  
  protected static String a(double paramDouble)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("0.0");
    localDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    return "f/" + localDecimalFormat.format(paramDouble);
  }
  
  protected static String b(double paramDouble)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("0.#");
    localDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    return localDecimalFormat.format(paramDouble) + " mm";
  }
  
  public static String convertBytesToVersionString(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if ((i < 4) && (i < paramArrayOfInt.length))
    {
      if (i == paramInt) {
        localStringBuilder.append('.');
      }
      char c2 = (char)paramArrayOfInt[i];
      char c1 = c2;
      if (c2 < '0') {
        c1 = (char)(c2 + '0');
      }
      if ((i == 0) && (c1 == '0')) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(c1);
      }
    }
    return localStringBuilder.toString();
  }
  
  protected String a(int paramInt)
  {
    Object localObject = this.a.getByteArray(paramInt);
    if (localObject == null) {
      return null;
    }
    paramInt = localObject.length;
    if (localObject.length == 1) {}
    for (localObject = "";; localObject = "s") {
      return String.format("(%d byte%s)", new Object[] { Integer.valueOf(paramInt), localObject });
    }
  }
  
  protected String a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.a.getIntArray(paramInt1);
    if (arrayOfInt == null) {
      return null;
    }
    return convertBytesToVersionString(arrayOfInt, paramInt2);
  }
  
  protected String a(int paramInt1, int paramInt2, String... paramVarArgs)
  {
    Integer localInteger = this.a.getInteger(paramInt1);
    if (localInteger == null) {
      paramVarArgs = null;
    }
    String str;
    do
    {
      return paramVarArgs;
      paramInt1 = localInteger.intValue() - paramInt2;
      if ((paramInt1 < 0) || (paramInt1 >= paramVarArgs.length)) {
        break;
      }
      str = paramVarArgs[paramInt1];
      paramVarArgs = str;
    } while (str != null);
    return "Unknown (" + localInteger + ")";
  }
  
  protected String a(int paramInt, String paramString)
  {
    Integer localInteger = this.a.getInteger(paramInt);
    if (localInteger == null) {
      return null;
    }
    return String.format(paramString, new Object[] { localInteger });
  }
  
  protected String a(int paramInt, Object... paramVarArgs)
  {
    Integer localInteger = this.a.getInteger(paramInt);
    if (localInteger == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramInt = 0;
    if (paramVarArgs.length > paramInt)
    {
      Object localObject = paramVarArgs[paramInt];
      int i;
      if (localObject != null)
      {
        if ((localInteger.intValue() & 0x1) == 1) {
          i = 1;
        }
        for (;;)
        {
          if ((localObject instanceof String[]))
          {
            localObject = (String[])localObject;
            if ((!b) && (localObject.length != 2))
            {
              throw new AssertionError();
              i = 0;
            }
            else if (i != 0)
            {
              i = 1;
              label107:
              localArrayList.add(localObject[i]);
            }
          }
        }
      }
      for (;;)
      {
        localInteger = Integer.valueOf(localInteger.intValue() >> 1);
        paramInt += 1;
        break;
        i = 0;
        break label107;
        if ((i != 0) && ((localObject instanceof String))) {
          localArrayList.add((String)localObject);
        }
      }
    }
    return p.join(localArrayList, ", ");
  }
  
  protected String a(int paramInt, String... paramVarArgs)
  {
    return a(paramInt, 0, paramVarArgs);
  }
  
  protected String b(int paramInt)
  {
    l locall = this.a.getRational(paramInt);
    if (locall == null) {
      return null;
    }
    return locall.toSimpleString(true);
  }
  
  protected String b(int paramInt1, int paramInt2)
  {
    l locall = this.a.getRational(paramInt1);
    if (locall == null) {
      return null;
    }
    return String.format("%." + paramInt2 + "f", new Object[] { Double.valueOf(locall.doubleValue()) });
  }
  
  protected String b(int paramInt, String paramString)
  {
    String str = this.a.getString(paramInt);
    if (str == null) {
      return null;
    }
    return String.format(paramString, new Object[] { str });
  }
  
  protected String c(int paramInt)
  {
    Long localLong = this.a.getLongObject(paramInt);
    if (localLong == null) {
      return null;
    }
    return new Date(localLong.longValue()).toString();
  }
  
  protected String d(int paramInt)
  {
    byte[] arrayOfByte = this.a.getByteArray(paramInt);
    if (arrayOfByte == null) {
      return null;
    }
    int j = arrayOfByte.length;
    paramInt = 0;
    if (paramInt < arrayOfByte.length)
    {
      int k = arrayOfByte[paramInt] & 0xFF;
      i = paramInt;
      if (k != 0) {
        if (k <= 127) {
          break label68;
        }
      }
    }
    for (int i = paramInt;; i = j)
    {
      return new String(arrayOfByte, 0, i);
      label68:
      paramInt += 1;
      break;
    }
  }
  
  protected String e(int paramInt)
  {
    Object localObject = this.a.getByteArray(paramInt);
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = new String((byte[])localObject, "ASCII").trim();
      return (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return null;
  }
  
  protected String f(int paramInt)
  {
    Object localObject = this.a.getRational(paramInt);
    if (localObject != null) {
      return ((l)localObject).toSimpleString(true);
    }
    localObject = this.a.getDoubleObject(paramInt);
    if (localObject != null) {
      return new DecimalFormat("0.###").format(localObject);
    }
    return null;
  }
  
  protected String g(int paramInt)
  {
    l[] arrayOfl = this.a.getRationalArray(paramInt);
    if ((arrayOfl == null) || (arrayOfl.length != 4) || ((arrayOfl[0].doubleValue() == 0.0D) && (arrayOfl[2].doubleValue() == 0.0D))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    DecimalFormat localDecimalFormat;
    if (arrayOfl[0].equals(arrayOfl[1]))
    {
      localStringBuilder.append(arrayOfl[0].toSimpleString(true)).append("mm");
      if (arrayOfl[2].doubleValue() != 0.0D)
      {
        localStringBuilder.append(' ');
        localDecimalFormat = new DecimalFormat("0.0");
        localDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (!arrayOfl[2].equals(arrayOfl[3])) {
          break label183;
        }
        localStringBuilder.append(a(arrayOfl[2].doubleValue()));
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(arrayOfl[0].toSimpleString(true)).append('-').append(arrayOfl[1].toSimpleString(true)).append("mm");
      break;
      label183:
      localStringBuilder.append("f/").append(localDecimalFormat.format(arrayOfl[2].doubleValue())).append('-').append(localDecimalFormat.format(arrayOfl[3].doubleValue()));
    }
  }
  
  public String getDescription(int paramInt)
  {
    Object localObject = this.a.getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if (localObject.getClass().isArray())
    {
      int i = Array.getLength(localObject);
      if (i > 16)
      {
        if (i == 1) {}
        for (localObject = "value";; localObject = "values") {
          return String.format("[%d %s]", new Object[] { Integer.valueOf(i), localObject });
        }
      }
    }
    if ((localObject instanceof Date)) {
      return new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy").format((Date)localObject).replaceAll("([0-9]{2} [^ ]+)$", ":$1");
    }
    return this.a.getString(paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */