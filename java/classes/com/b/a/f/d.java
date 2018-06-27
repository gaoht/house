package com.b.a.f;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class d
{
  public static final d a;
  public static final d b;
  public static final d c;
  public static final d d;
  public static final d e;
  public static final d f;
  public static final d g;
  public static final d h;
  public static final d i;
  public static final d j;
  public static final d k;
  public static final d l;
  public static final d m;
  public static final d n;
  public static final d o;
  public static final d p;
  public static final d q;
  public static final d r;
  private static final Set<String> t;
  private final byte[] u;
  private final boolean v;
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      s = bool;
      t = new HashSet(Arrays.asList(new String[] { "IDAT", "sPLT", "iTXt", "tEXt", "zTXt" }));
      a = new d("IHDR");
      b = new d("PLTE");
      c = new d("IDAT", true);
      d = new d("IEND");
      e = new d("cHRM");
      f = new d("gAMA");
      g = new d("iCCP");
      h = new d("sBIT");
      i = new d("sRGB");
      j = new d("bKGD");
      k = new d("hIST");
      l = new d("tRNS");
      m = new d("pHYs");
      n = new d("sPLT", true);
      o = new d("tIME");
      p = new d("iTXt", true);
      q = new d("tEXt", true);
      r = new d("zTXt", true);
      return;
    }
  }
  
  public d(String paramString)
  {
    this(paramString, false);
  }
  
  public d(String paramString, boolean paramBoolean)
  {
    this.v = paramBoolean;
    try
    {
      paramString = paramString.getBytes("ASCII");
      a(paramString);
      this.u = paramString;
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalArgumentException("Unable to convert string code to bytes.");
    }
  }
  
  public d(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte);
    this.u = paramArrayOfByte;
    this.v = t.contains(getIdentifier());
  }
  
  private static void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 4) {
      throw new IllegalArgumentException("PNG chunk type identifier must be four bytes in length");
    }
    int i2 = paramArrayOfByte.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (!c(paramArrayOfByte[i1])) {
        throw new IllegalArgumentException("PNG chunk type identifier may only contain alphabet characters");
      }
      i1 += 1;
    }
  }
  
  private static boolean a(byte paramByte)
  {
    return (paramByte & 0x20) != 0;
  }
  
  private static boolean b(byte paramByte)
  {
    return (paramByte & 0x20) == 0;
  }
  
  private static boolean c(byte paramByte)
  {
    return ((paramByte >= 65) && (paramByte <= 90)) || ((paramByte >= 97) && (paramByte <= 122));
  }
  
  public boolean areMultipleAllowed()
  {
    return this.v;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (d)paramObject;
    return Arrays.equals(this.u, ((d)paramObject).u);
  }
  
  public String getIdentifier()
  {
    try
    {
      String str = new String(this.u, "ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      if (!s) {
        throw new AssertionError();
      }
    }
    return "Invalid object instance";
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.u);
  }
  
  public boolean isAncillary()
  {
    return !isCritical();
  }
  
  public boolean isCritical()
  {
    return b(this.u[0]);
  }
  
  public boolean isPrivate()
  {
    return b(this.u[1]);
  }
  
  public boolean isSafeToCopy()
  {
    return a(this.u[3]);
  }
  
  public String toString()
  {
    return getIdentifier();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */