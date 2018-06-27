package cn.jpush.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.c.b.e;
import cn.jiguang.c.b.g;
import cn.jiguang.c.d.i;
import cn.jiguang.d.d;
import java.util.concurrent.atomic.AtomicLong;

public class PushService
  extends Service
{
  private static final String[] z;
  private cn.jiguang.b.b a = null;
  private long b;
  
  static
  {
    String[] arrayOfString = new String[13];
    int j = 0;
    Object localObject2 = "u\f!.@\013$~\036@";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label68:
      n = m;
      label71:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 125;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "D\032&~\022KY7\022K,<U\024K\035";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "v\034 a\024F\034rz\034L\027rc\025W\0343s]\bY&\017@\0306^\031\037";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "J\027\021e\030D\r7?T";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "c\030;{]Q\026rd\tD\013&7\022Q\0217e]D\t\"7\036D\f!r\031\005\033+72P\r\035q0@\024=e\004\013";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "J\027\021e\030D\r7-7f\026 r4K\r7e\033D\03277\024K\020&7\033D\020>r\031";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "J\027\001c\034W\r\021x\020H\030<sGo:=e\030l\027&r\017C\0301r]L\027;c]C\030;{\030A";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "J\027\001c\034W\r\021x\020H\030<s]\bY;y\t@\027&-";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "v\034 a\024F\034ru\bK\035>r]\bY";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "\tY\"|\032\037";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "\tY1x\023K\0341c\024J\027h";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "D\032&~\022KY7\022K;;y\031";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "J\027\026r\016Q\013=n]\bY\"e\022F\034!d4AC";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 37;
        continue;
        i = 121;
        continue;
        i = 82;
        continue;
        i = 23;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    d.c(z[0], z[11]);
    cn.jiguang.c.b.b.a(this);
    return this.a;
  }
  
  public void onCreate()
  {
    d.e(z[0], z[3]);
    d.a(z[0], z[2] + Thread.currentThread().getId());
    if (!JCoreInterface.init(this, false))
    {
      d.h(z[0], z[5]);
      return;
    }
    cn.jiguang.c.b.b.a(this);
    this.b = Thread.currentThread().getId();
    this.a = new cn.jiguang.c.d.k(this);
    cn.jiguang.f.a.l(getApplicationContext());
    e.a().a(this);
    e.a().a(this);
    cn.jiguang.f.a.h(getApplicationContext());
    try
    {
      cn.jiguang.f.k.a(getApplicationContext(), 0L);
      super.onCreate();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        d.g(z[0], z[4]);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d.c(z[0], z[12] + Process.myPid());
    e locale = e.a();
    getApplicationContext();
    locale.c();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    d.d(z[0], z[7] + paramIntent + z[9] + cn.jiguang.c.a.c + z[10] + g.a.get());
    cn.jiguang.c.b.b.a(this);
    if (!JCoreInterface.init(this, false))
    {
      d.h(z[0], z[6]);
      return 1;
    }
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getAction();
      localObject = paramIntent.getExtras();
      paramIntent = str;
    }
    for (;;)
    {
      if (localObject != null) {
        d.a(z[0], z[8] + ((Bundle)localObject).toString());
      }
      if ((paramIntent == null) || (localObject == null)) {
        break;
      }
      i.a().a(this, paramIntent, (Bundle)localObject);
      return 1;
      str = null;
      paramIntent = (Intent)localObject;
      localObject = str;
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    d.i(z[0], z[1]);
    return super.onUnbind(paramIntent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/service/PushService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */