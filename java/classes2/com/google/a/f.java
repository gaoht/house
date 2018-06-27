package com.google.a;

import java.util.Hashtable;

public final class f
{
  private static Hashtable a = new Hashtable();
  private String b;
  private i c;
  private byte d;
  private int e;
  private Object f;
  
  private f(String paramString, i parami, int paramInt, byte paramByte, Object paramObject)
  {
    this.b = paramString;
    this.c = parami;
    this.e = paramInt;
    this.d = paramByte;
    this.f = paramObject;
  }
  
  public static f a(String paramString, int paramInt)
  {
    return (f)a(paramString).get(new Integer(paramInt));
  }
  
  public static f a(String paramString, i parami, int paramInt, boolean paramBoolean, Object paramObject)
  {
    return new f(paramString, parami, paramInt, (byte)0, paramObject);
  }
  
  private static Hashtable a(String paramString)
  {
    Hashtable localHashtable = (Hashtable)a.get(paramString);
    if (localHashtable == null) {
      throw new RuntimeException("Extensions not supported by " + paramString + ".");
    }
    return localHashtable;
  }
  
  public static void a(f paramf)
  {
    String str = paramf.b;
    Hashtable localHashtable2 = (Hashtable)a.get(str);
    Hashtable localHashtable1 = localHashtable2;
    if (localHashtable2 == null)
    {
      localHashtable1 = new Hashtable();
      a.put(str, localHashtable1);
    }
    localHashtable1.put(new Integer(paramf.e), paramf);
  }
  
  public static void a(String paramString, f paramf)
  {
    Hashtable localHashtable = a(paramString);
    if ((paramf != null) && (!localHashtable.containsKey(new Integer(paramf.e)))) {
      throw new RuntimeException("Extension " + paramf + " not supported by " + paramString + ".");
    }
  }
  
  public final i a()
  {
    return this.c;
  }
  
  public final int b()
  {
    return this.e;
  }
  
  public final boolean c()
  {
    return (this.d & 0x1) != 0;
  }
  
  public final boolean d()
  {
    return (this.d & 0x2) != 0;
  }
  
  public final boolean e()
  {
    return (this.d & 0x4) != 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof f)) {
        break;
      }
      paramObject = (f)paramObject;
    } while ((this.e == ((f)paramObject).e) && (this.b.equals(((f)paramObject).b)));
    return false;
    return false;
  }
  
  public final Object f()
  {
    return this.f;
  }
  
  public final int hashCode()
  {
    return this.b.hashCode() ^ this.e;
  }
  
  public final String toString()
  {
    if (this.f != null) {}
    for (String str = this.f.getClass().getName();; str = "null") {
      return this.b + ":" + this.e + "[" + str + "]";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */