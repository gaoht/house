package com.b.c;

import com.b.b.l;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class b
{
  private static final DecimalFormat e;
  protected final Map<Integer, Object> a = new HashMap();
  protected final Collection<f> b = new ArrayList();
  protected g c;
  private final Collection<String> f = new ArrayList(4);
  private b g;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      e = new DecimalFormat("0.###");
      return;
    }
  }
  
  protected abstract HashMap<Integer, String> a();
  
  public void addError(String paramString)
  {
    this.f.add(paramString);
  }
  
  public boolean containsTag(int paramInt)
  {
    return this.a.containsKey(Integer.valueOf(paramInt));
  }
  
  public boolean getBoolean(int paramInt)
    throws e
  {
    Object localObject = getBooleanObject(paramInt);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    localObject = getObject(paramInt);
    if (localObject == null) {
      throw new e("Tag '" + getTagName(paramInt) + "' has not been set -- check using containsTag() first");
    }
    throw new e("Tag '" + paramInt + "' cannot be converted to a boolean.  It is of type '" + localObject.getClass() + "'.");
  }
  
  public Boolean getBooleanObject(int paramInt)
  {
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof Boolean)) {
      return (Boolean)localObject;
    }
    boolean bool;
    if ((localObject instanceof String)) {
      try
      {
        bool = Boolean.getBoolean((String)localObject);
        return Boolean.valueOf(bool);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return null;
      }
    }
    if ((localNumberFormatException instanceof Number))
    {
      if (((Number)localNumberFormatException).doubleValue() != 0.0D) {}
      for (bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    }
    return null;
  }
  
  public byte[] getByteArray(int paramInt)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    byte[] arrayOfByte;
    if ((localObject instanceof l[]))
    {
      localObject = (l[])localObject;
      arrayOfByte = new byte[localObject.length];
      paramInt = i;
      while (paramInt < arrayOfByte.length)
      {
        arrayOfByte[paramInt] = localObject[paramInt].byteValue();
        paramInt += 1;
      }
      return arrayOfByte;
    }
    if ((localObject instanceof byte[])) {
      return (byte[])localObject;
    }
    if ((localObject instanceof int[]))
    {
      localObject = (int[])localObject;
      arrayOfByte = new byte[localObject.length];
      paramInt = j;
      while (paramInt < localObject.length)
      {
        arrayOfByte[paramInt] = ((byte)localObject[paramInt]);
        paramInt += 1;
      }
      return arrayOfByte;
    }
    if ((localObject instanceof short[]))
    {
      localObject = (short[])localObject;
      arrayOfByte = new byte[localObject.length];
      paramInt = k;
      while (paramInt < localObject.length)
      {
        arrayOfByte[paramInt] = ((byte)localObject[paramInt]);
        paramInt += 1;
      }
      return arrayOfByte;
    }
    if ((localObject instanceof CharSequence))
    {
      localObject = (CharSequence)localObject;
      arrayOfByte = new byte[((CharSequence)localObject).length()];
      paramInt = m;
      while (paramInt < ((CharSequence)localObject).length())
      {
        arrayOfByte[paramInt] = ((byte)((CharSequence)localObject).charAt(paramInt));
        paramInt += 1;
      }
      return arrayOfByte;
    }
    if ((localObject instanceof Integer)) {
      return new byte[] { ((Integer)localObject).byteValue() };
    }
    return null;
  }
  
  public Date getDate(int paramInt)
  {
    return getDate(paramInt, null, null);
  }
  
  public Date getDate(int paramInt, String paramString, TimeZone paramTimeZone)
  {
    int i = 0;
    Object localObject2 = getObject(paramInt);
    if ((localObject2 instanceof Date))
    {
      localObject1 = (Date)localObject2;
      return (Date)localObject1;
    }
    Object localObject1 = paramString;
    if ((localObject2 instanceof String))
    {
      String[] arrayOfString = new String[11];
      arrayOfString[0] = "yyyy:MM:dd HH:mm:ss";
      arrayOfString[1] = "yyyy:MM:dd HH:mm";
      arrayOfString[2] = "yyyy-MM-dd HH:mm:ss";
      arrayOfString[3] = "yyyy-MM-dd HH:mm";
      arrayOfString[4] = "yyyy.MM.dd HH:mm:ss";
      arrayOfString[5] = "yyyy.MM.dd HH:mm";
      arrayOfString[6] = "yyyy-MM-dd'T'HH:mm:ss";
      arrayOfString[7] = "yyyy-MM-dd'T'HH:mm";
      arrayOfString[8] = "yyyy-MM-dd";
      arrayOfString[9] = "yyyy-MM";
      arrayOfString[10] = "yyyy";
      localObject1 = (String)localObject2;
      localObject2 = Pattern.compile("(\\d\\d:\\d\\d:\\d\\d)(\\.\\d+)").matcher((CharSequence)localObject1);
      if (((Matcher)localObject2).find())
      {
        paramString = ((Matcher)localObject2).group(2).substring(1);
        localObject1 = ((Matcher)localObject2).replaceAll("$1");
      }
      Matcher localMatcher = Pattern.compile("(Z|[+-]\\d\\d:\\d\\d)$").matcher((CharSequence)localObject1);
      localObject2 = localObject1;
      if (localMatcher.find())
      {
        paramTimeZone = TimeZone.getTimeZone("GMT" + localMatcher.group().replaceAll("Z", ""));
        localObject2 = localMatcher.replaceAll("");
      }
      int j = arrayOfString.length;
      paramInt = i;
      for (;;)
      {
        localObject1 = paramString;
        if (paramInt < j)
        {
          localObject1 = arrayOfString[paramInt];
          try
          {
            localObject1 = new SimpleDateFormat((String)localObject1);
            if (paramTimeZone != null) {
              ((DateFormat)localObject1).setTimeZone(paramTimeZone);
            }
            for (;;)
            {
              localObject1 = ((DateFormat)localObject1).parse((String)localObject2);
              paramTimeZone = (TimeZone)localObject1;
              break;
              ((DateFormat)localObject1).setTimeZone(TimeZone.getTimeZone("GMT"));
            }
          }
          catch (ParseException localParseException)
          {
            paramInt += 1;
          }
        }
      }
    }
    do
    {
      TimeZone localTimeZone = paramTimeZone;
      if (paramString == null) {
        break;
      }
      try
      {
        paramInt = (int)(Double.parseDouble("." + paramString) * 1000.0D);
        localTimeZone = paramTimeZone;
        if (paramInt < 0) {
          break;
        }
        localTimeZone = paramTimeZone;
        if (paramInt >= 1000) {
          break;
        }
        paramString = Calendar.getInstance();
        paramString.setTime(paramTimeZone);
        paramString.set(14, paramInt);
        paramString = paramString.getTime();
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        return paramTimeZone;
      }
      paramTimeZone = null;
      paramString = localTimeZone;
    } while (paramTimeZone != null);
    return null;
  }
  
  public Date getDate(int paramInt, TimeZone paramTimeZone)
  {
    return getDate(paramInt, null, paramTimeZone);
  }
  
  public String getDescription(int paramInt)
  {
    if ((!d) && (this.c == null)) {
      throw new AssertionError();
    }
    return this.c.getDescription(paramInt);
  }
  
  public double getDouble(int paramInt)
    throws e
  {
    Object localObject = getDoubleObject(paramInt);
    if (localObject != null) {
      return ((Double)localObject).doubleValue();
    }
    localObject = getObject(paramInt);
    if (localObject == null) {
      throw new e("Tag '" + getTagName(paramInt) + "' has not been set -- check using containsTag() first");
    }
    throw new e("Tag '" + paramInt + "' cannot be converted to a double.  It is of type '" + localObject.getClass() + "'.");
  }
  
  public Double getDoubleObject(int paramInt)
  {
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof String)) {
      try
      {
        double d1 = Double.parseDouble((String)localObject);
        return Double.valueOf(d1);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return null;
      }
    }
    if ((localNumberFormatException instanceof Number)) {
      return Double.valueOf(((Number)localNumberFormatException).doubleValue());
    }
    return null;
  }
  
  public int getErrorCount()
  {
    return this.f.size();
  }
  
  public Iterable<String> getErrors()
  {
    return Collections.unmodifiableCollection(this.f);
  }
  
  public float getFloat(int paramInt)
    throws e
  {
    Object localObject = getFloatObject(paramInt);
    if (localObject != null) {
      return ((Float)localObject).floatValue();
    }
    localObject = getObject(paramInt);
    if (localObject == null) {
      throw new e("Tag '" + getTagName(paramInt) + "' has not been set -- check using containsTag() first");
    }
    throw new e("Tag '" + paramInt + "' cannot be converted to a float.  It is of type '" + localObject.getClass() + "'.");
  }
  
  public Float getFloatObject(int paramInt)
  {
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof String)) {
      try
      {
        float f1 = Float.parseFloat((String)localObject);
        return Float.valueOf(f1);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return null;
      }
    }
    if ((localNumberFormatException instanceof Number)) {
      return Float.valueOf(((Number)localNumberFormatException).floatValue());
    }
    return null;
  }
  
  public int getInt(int paramInt)
    throws e
  {
    Object localObject = getInteger(paramInt);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    localObject = getObject(paramInt);
    if (localObject == null) {
      throw new e("Tag '" + getTagName(paramInt) + "' has not been set -- check using containsTag() first");
    }
    throw new e("Tag '" + paramInt + "' cannot be converted to int.  It is of type '" + localObject.getClass() + "'.");
  }
  
  public int[] getIntArray(int paramInt)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof int[])) {
      return (int[])localObject;
    }
    int[] arrayOfInt;
    if ((localObject instanceof l[]))
    {
      localObject = (l[])localObject;
      arrayOfInt = new int[localObject.length];
      paramInt = i;
      while (paramInt < arrayOfInt.length)
      {
        arrayOfInt[paramInt] = localObject[paramInt].intValue();
        paramInt += 1;
      }
      return arrayOfInt;
    }
    if ((localObject instanceof short[]))
    {
      localObject = (short[])localObject;
      arrayOfInt = new int[localObject.length];
      paramInt = j;
      while (paramInt < localObject.length)
      {
        arrayOfInt[paramInt] = localObject[paramInt];
        paramInt += 1;
      }
      return arrayOfInt;
    }
    if ((localObject instanceof byte[]))
    {
      localObject = (byte[])localObject;
      arrayOfInt = new int[localObject.length];
      paramInt = k;
      while (paramInt < localObject.length)
      {
        arrayOfInt[paramInt] = localObject[paramInt];
        paramInt += 1;
      }
      return arrayOfInt;
    }
    if ((localObject instanceof CharSequence))
    {
      localObject = (CharSequence)localObject;
      arrayOfInt = new int[((CharSequence)localObject).length()];
      paramInt = m;
      while (paramInt < ((CharSequence)localObject).length())
      {
        arrayOfInt[paramInt] = ((CharSequence)localObject).charAt(paramInt);
        paramInt += 1;
      }
      return arrayOfInt;
    }
    if ((localObject instanceof Integer)) {
      return new int[] { ((Integer)localObject).intValue() };
    }
    return null;
  }
  
  public Integer getInteger(int paramInt)
  {
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof Number)) {
      return Integer.valueOf(((Number)localObject).intValue());
    }
    if ((localObject instanceof String)) {
      try
      {
        paramInt = Integer.parseInt((String)localObject);
        return Integer.valueOf(paramInt);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localObject = ((String)localObject).getBytes();
        int i = localObject.length;
        long l = 0L;
        paramInt = 0;
        while (paramInt < i)
        {
          l = (l << 8) + (localObject[paramInt] & 0xFF);
          paramInt += 1;
        }
        return Integer.valueOf((int)l);
      }
    }
    if ((localObject instanceof l[]))
    {
      localObject = (l[])localObject;
      if (localObject.length == 1) {
        return Integer.valueOf(localObject[0].intValue());
      }
    }
    else if ((localObject instanceof byte[]))
    {
      localObject = (byte[])localObject;
      if (localObject.length == 1) {
        return Integer.valueOf(localObject[0]);
      }
    }
    else if ((localObject instanceof int[]))
    {
      localObject = (int[])localObject;
      if (localObject.length == 1) {
        return Integer.valueOf(localObject[0]);
      }
    }
    return null;
  }
  
  public long getLong(int paramInt)
    throws e
  {
    Object localObject = getLongObject(paramInt);
    if (localObject != null) {
      return ((Long)localObject).longValue();
    }
    localObject = getObject(paramInt);
    if (localObject == null) {
      throw new e("Tag '" + getTagName(paramInt) + "' has not been set -- check using containsTag() first");
    }
    throw new e("Tag '" + paramInt + "' cannot be converted to a long.  It is of type '" + localObject.getClass() + "'.");
  }
  
  public Long getLongObject(int paramInt)
  {
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof String)) {
      try
      {
        long l = Long.parseLong((String)localObject);
        return Long.valueOf(l);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return null;
      }
    }
    if ((localNumberFormatException instanceof Number)) {
      return Long.valueOf(((Number)localNumberFormatException).longValue());
    }
    return null;
  }
  
  public abstract String getName();
  
  public Object getObject(int paramInt)
  {
    return this.a.get(Integer.valueOf(paramInt));
  }
  
  public b getParent()
  {
    return this.g;
  }
  
  public l getRational(int paramInt)
  {
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof l)) {
      return (l)localObject;
    }
    if ((localObject instanceof Integer)) {
      return new l(((Integer)localObject).intValue(), 1L);
    }
    if ((localObject instanceof Long)) {
      return new l(((Long)localObject).longValue(), 1L);
    }
    return null;
  }
  
  public l[] getRationalArray(int paramInt)
  {
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof l[])) {
      return (l[])localObject;
    }
    return null;
  }
  
  public String getString(int paramInt)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i = 0;
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof l)) {
      return ((l)localObject).toSimpleString(true);
    }
    if (localObject.getClass().isArray())
    {
      int i3 = Array.getLength(localObject);
      Class localClass = localObject.getClass().getComponentType();
      StringBuilder localStringBuilder = new StringBuilder();
      if (Object.class.isAssignableFrom(localClass))
      {
        paramInt = i;
        while (paramInt < i3)
        {
          if (paramInt != 0) {
            localStringBuilder.append(' ');
          }
          localStringBuilder.append(Array.get(localObject, paramInt).toString());
          paramInt += 1;
        }
      }
      if (localClass.getName().equals("int"))
      {
        paramInt = j;
        while (paramInt < i3)
        {
          if (paramInt != 0) {
            localStringBuilder.append(' ');
          }
          localStringBuilder.append(Array.getInt(localObject, paramInt));
          paramInt += 1;
        }
      }
      if (localClass.getName().equals("short"))
      {
        paramInt = k;
        while (paramInt < i3)
        {
          if (paramInt != 0) {
            localStringBuilder.append(' ');
          }
          localStringBuilder.append(Array.getShort(localObject, paramInt));
          paramInt += 1;
        }
      }
      if (localClass.getName().equals("long"))
      {
        paramInt = m;
        while (paramInt < i3)
        {
          if (paramInt != 0) {
            localStringBuilder.append(' ');
          }
          localStringBuilder.append(Array.getLong(localObject, paramInt));
          paramInt += 1;
        }
      }
      if (localClass.getName().equals("float"))
      {
        paramInt = n;
        while (paramInt < i3)
        {
          if (paramInt != 0) {
            localStringBuilder.append(' ');
          }
          localStringBuilder.append(e.format(Array.getFloat(localObject, paramInt)));
          paramInt += 1;
        }
      }
      if (localClass.getName().equals("double"))
      {
        paramInt = i1;
        while (paramInt < i3)
        {
          if (paramInt != 0) {
            localStringBuilder.append(' ');
          }
          localStringBuilder.append(e.format(Array.getDouble(localObject, paramInt)));
          paramInt += 1;
        }
      }
      if (localClass.getName().equals("byte"))
      {
        paramInt = i2;
        while (paramInt < i3)
        {
          if (paramInt != 0) {
            localStringBuilder.append(' ');
          }
          localStringBuilder.append(Array.getByte(localObject, paramInt) & 0xFF);
          paramInt += 1;
        }
      }
      addError("Unexpected array component type: " + localClass.getName());
      return localStringBuilder.toString();
    }
    if ((localObject instanceof Double)) {
      return e.format(((Double)localObject).doubleValue());
    }
    if ((localObject instanceof Float)) {
      return e.format(((Float)localObject).floatValue());
    }
    return localObject.toString();
  }
  
  public String getString(int paramInt, String paramString)
  {
    byte[] arrayOfByte = getByteArray(paramInt);
    if (arrayOfByte == null) {
      return null;
    }
    try
    {
      paramString = new String(arrayOfByte, paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return null;
  }
  
  public String[] getStringArray(int paramInt)
  {
    int j = 0;
    int i = 0;
    Object localObject = getObject(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof String[])) {
      return (String[])localObject;
    }
    if ((localObject instanceof String)) {
      return new String[] { (String)localObject };
    }
    String[] arrayOfString;
    if ((localObject instanceof int[]))
    {
      localObject = (int[])localObject;
      arrayOfString = new String[localObject.length];
      paramInt = i;
      while (paramInt < arrayOfString.length)
      {
        arrayOfString[paramInt] = Integer.toString(localObject[paramInt]);
        paramInt += 1;
      }
      return arrayOfString;
    }
    if ((localObject instanceof byte[]))
    {
      localObject = (byte[])localObject;
      arrayOfString = new String[localObject.length];
      paramInt = j;
      while (paramInt < arrayOfString.length)
      {
        arrayOfString[paramInt] = Byte.toString(localObject[paramInt]);
        paramInt += 1;
      }
      return arrayOfString;
    }
    if ((localObject instanceof l[]))
    {
      localObject = (l[])localObject;
      arrayOfString = new String[localObject.length];
      paramInt = 0;
      while (paramInt < arrayOfString.length)
      {
        arrayOfString[paramInt] = localObject[paramInt].toSimpleString(false);
        paramInt += 1;
      }
      return arrayOfString;
    }
    return null;
  }
  
  public int getTagCount()
  {
    return this.b.size();
  }
  
  public String getTagName(int paramInt)
  {
    Object localObject = a();
    if (!((HashMap)localObject).containsKey(Integer.valueOf(paramInt)))
    {
      for (localObject = Integer.toHexString(paramInt); ((String)localObject).length() < 4; localObject = "0" + (String)localObject) {}
      return "Unknown tag (0x" + (String)localObject + ")";
    }
    return (String)((HashMap)localObject).get(Integer.valueOf(paramInt));
  }
  
  public Collection<f> getTags()
  {
    return Collections.unmodifiableCollection(this.b);
  }
  
  public boolean hasErrors()
  {
    return this.f.size() > 0;
  }
  
  public boolean hasTagName(int paramInt)
  {
    return a().containsKey(Integer.valueOf(paramInt));
  }
  
  public boolean isEmpty()
  {
    return (this.f.isEmpty()) && (this.b.isEmpty());
  }
  
  public void setBoolean(int paramInt, boolean paramBoolean)
  {
    setObject(paramInt, Boolean.valueOf(paramBoolean));
  }
  
  public void setByteArray(int paramInt, byte[] paramArrayOfByte)
  {
    setObjectArray(paramInt, paramArrayOfByte);
  }
  
  public void setDate(int paramInt, Date paramDate)
  {
    setObject(paramInt, paramDate);
  }
  
  public void setDescriptor(g paramg)
  {
    if (paramg == null) {
      throw new NullPointerException("cannot set a null descriptor");
    }
    this.c = paramg;
  }
  
  public void setDouble(int paramInt, double paramDouble)
  {
    setObject(paramInt, Double.valueOf(paramDouble));
  }
  
  public void setDoubleArray(int paramInt, double[] paramArrayOfDouble)
  {
    setObjectArray(paramInt, paramArrayOfDouble);
  }
  
  public void setFloat(int paramInt, float paramFloat)
  {
    setObject(paramInt, Float.valueOf(paramFloat));
  }
  
  public void setFloatArray(int paramInt, float[] paramArrayOfFloat)
  {
    setObjectArray(paramInt, paramArrayOfFloat);
  }
  
  public void setInt(int paramInt1, int paramInt2)
  {
    setObject(paramInt1, Integer.valueOf(paramInt2));
  }
  
  public void setIntArray(int paramInt, int[] paramArrayOfInt)
  {
    setObjectArray(paramInt, paramArrayOfInt);
  }
  
  public void setLong(int paramInt, long paramLong)
  {
    setObject(paramInt, Long.valueOf(paramLong));
  }
  
  public void setObject(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("cannot set a null object");
    }
    if (!this.a.containsKey(Integer.valueOf(paramInt))) {
      this.b.add(new f(paramInt, this));
    }
    this.a.put(Integer.valueOf(paramInt), paramObject);
  }
  
  public void setObjectArray(int paramInt, Object paramObject)
  {
    setObject(paramInt, paramObject);
  }
  
  public void setParent(b paramb)
  {
    this.g = paramb;
  }
  
  public void setRational(int paramInt, l paraml)
  {
    setObject(paramInt, paraml);
  }
  
  public void setRationalArray(int paramInt, l[] paramArrayOfl)
  {
    setObjectArray(paramInt, paramArrayOfl);
  }
  
  public void setString(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("cannot set a null String");
    }
    setObject(paramInt, paramString);
  }
  
  public void setStringArray(int paramInt, String[] paramArrayOfString)
  {
    setObjectArray(paramInt, paramArrayOfString);
  }
  
  public String toString()
  {
    String str2 = getName();
    int i = this.a.size();
    if (this.a.size() == 1) {}
    for (String str1 = "tag";; str1 = "tags") {
      return String.format("%s Directory (%d %s)", new Object[] { str2, Integer.valueOf(i), str1 });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */