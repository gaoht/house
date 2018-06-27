package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

public class m
{
  private static volatile m a;
  private SharedPreferences b;
  
  private m(Context paramContext)
  {
    this.b = paramContext.getSharedPreferences("mipush", 0);
  }
  
  public static m a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new m(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      SharedPreferences.Editor localEditor = this.b.edit();
      localEditor.remove("miid");
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        str = "0";
      }
      paramString = this.b.edit();
      paramString.putString("miid", str);
      paramString.commit();
      return;
    }
    finally {}
  }
  
  public String b()
  {
    try
    {
      String str = this.b.getString("miid", "0");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 56
    //   4: aload_0
    //   5: invokevirtual 68	com/xiaomi/push/service/m:b	()Ljava/lang/String;
    //   8: invokestatic 72	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   11: istore_1
    //   12: iload_1
    //   13: ifne +9 -> 22
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -6 -> 18
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	m
    //   11	13	1	bool	boolean
    //   27	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	27	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */