package com.growingio.android.sdk.b;

import java.lang.ref.SoftReference;

class a
{
  protected static final ThreadLocal<SoftReference<a>> a = new ThreadLocal();
  private short[] b;
  
  public static a a()
  {
    Object localObject1 = (SoftReference)a.get();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (a)((SoftReference)localObject1).get())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new a();
        a.set(new SoftReference(localObject2));
      }
      return (a)localObject2;
    }
  }
  
  public void a(short[] paramArrayOfShort)
  {
    if ((this.b == null) || ((paramArrayOfShort != null) && (paramArrayOfShort.length > this.b.length))) {
      this.b = paramArrayOfShort;
    }
  }
  
  public short[] a(int paramInt)
  {
    short[] arrayOfShort = this.b;
    if ((arrayOfShort == null) || (arrayOfShort.length < paramInt)) {
      return new short[paramInt];
    }
    this.b = null;
    return arrayOfShort;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */