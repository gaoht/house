package com.g.a;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class e
{
  public static final Parcelable.Creator e = new f();
  public boolean a;
  public int b;
  public final String c;
  public final int d;
  private final q.a f;
  
  public e(int paramInt)
  {
    this.d = paramInt;
    this.c = a(paramInt);
    this.f = q.a.a(paramInt);
    for (;;)
    {
      try
      {
        q.b localb = this.f.b("cpuacct");
        if (!this.f.b("cpu").c.contains("bg_non_interactive"))
        {
          this.a = bool;
          this.b = Integer.parseInt(localb.c.split("/")[1].replace("uid_", ""));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        av.postSDKError(localThrowable);
        if (d() == null) {
          continue;
        }
        this.b = d().a();
      }
      bool = false;
    }
  }
  
  protected e(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.f = ((q.a)paramParcel.readParcelable(q.a.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.a = bool;
      return;
    }
  }
  
  /* Error */
  static String a(int paramInt)
  {
    // Byte code:
    //   0: ldc 125
    //   2: iconst_1
    //   3: anewarray 4	java/lang/Object
    //   6: dup
    //   7: iconst_0
    //   8: iload_0
    //   9: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12: aastore
    //   13: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   16: invokestatic 138	com/g/a/q:a	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokevirtual 141	java/lang/String:trim	()Ljava/lang/String;
    //   22: astore_1
    //   23: aload_1
    //   24: astore_2
    //   25: aload_1
    //   26: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifeq +11 -> 40
    //   32: iload_0
    //   33: invokestatic 151	com/g/a/q$c:a	(I)Lcom/g/a/q$c;
    //   36: invokevirtual 153	com/g/a/q$c:b	()Ljava/lang/String;
    //   39: astore_2
    //   40: aload_2
    //   41: areturn
    //   42: astore_2
    //   43: aconst_null
    //   44: astore_1
    //   45: aload_2
    //   46: invokestatic 91	com/g/a/av:postSDKError	(Ljava/lang/Throwable;)V
    //   49: aload_1
    //   50: areturn
    //   51: astore_2
    //   52: goto -7 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramInt	int
    //   22	28	1	str1	String
    //   24	17	2	str2	String
    //   42	4	2	localThrowable1	Throwable
    //   51	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	23	42	java/lang/Throwable
    //   25	40	51	java/lang/Throwable
  }
  
  public String a()
  {
    try
    {
      String str = this.c.split(":")[0];
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public String b()
  {
    try
    {
      if (this.c.split(":").length > 1)
      {
        String str = ":" + this.c.split(":")[1];
        return str;
      }
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public q.a c()
  {
    return this.f;
  }
  
  public q.d d()
  {
    try
    {
      q.d locald = q.d.a(this.d);
      return locald;
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
    return null;
  }
  
  public q.c e()
  {
    try
    {
      q.c localc = q.c.a(this.d);
      return localc;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */