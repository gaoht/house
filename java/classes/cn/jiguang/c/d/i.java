package cn.jiguang.c.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.c.b.b;
import cn.jiguang.f.a;
import cn.jpush.android.service.PushService;
import java.util.Iterator;
import java.util.List;

public final class i
{
  private static Object c;
  private static i d;
  private static final String[] z;
  private boolean a;
  private Context b;
  private boolean e;
  private boolean f;
  private boolean g;
  
  static
  {
    String[] arrayOfString = new String[25];
    int j = 0;
    Object localObject2 = "7hFP\004\024XFa\035\020VBL\0265^OR\027\017";
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
        i = 114;
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
        localObject2 = "\023NON";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\022UbA\006\024TM\002\023\036OJM\034G";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "\022UsW\001\025z@V\033\022U\003A\035\023OFZ\006]RP\002\034\bWO";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "]YVL\026\021^\031";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "]XBN\0364UWG\000\033Z@GR\027XLP\027]RMK\006]]BK\036\030_";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "\016^MF\000\030JVG\001\t_BV\023SZ@V\033\022U";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\036U\rH\002\bHK\f\023\023_QM\033\031\025JL\006\030UW\f;3rw";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "(UKC\034\031WFFR\016^QT\033\036^\003C\021\tRLLRP\033";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "\036U\rH\002\bHK\f\023\023_QM\033\031\025JL\006\030UW\f 8hwm 8kvq:";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "\031ZWC\001";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "\016^MF\026\034OB\f\023\036OJM\034";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "\017NM\f\023\036OJM\034";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "\016_HV\013\r^";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "\036U\rH\002\bHK\f\023\023_QM\033\031\025JL\006\030UW\f!)tsr'.s";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "<XWK\035\023\033\016\002\032\034UGN\027<XWK\035\023\001";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "\036U\rH\002\bHK\f\023\023_QM\033\031\025JL\006\030UW\f )x";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "\tRNG\035\bO";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "\036U\rH\002\bHK\f\023\023_QM\033\031\025JL\006\030UW\f12umg1)ruk&$d`j33|f";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "\036VG";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "^NMG\n\036^SV\027\031\033\016\002\025\030O`W\000-ILA\027\016HmC\037\030\033EC\033\021^G\030";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "\034XWK\004\024OZ";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "\036ZON3\036OJM\034]Z@V\033\022U\031";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "\bUFZ\021\030KWK\035\023\033\017A\023\023O\003Q\006\034IW\002\001\030IUK\021\030";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "\tSQM\005\034YOGRQXBL\006]HWC\000\t\033PG\000\013R@G";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        c = new Object();
        return;
        i = 125;
        continue;
        i = 59;
        continue;
        i = 35;
        continue;
        i = 34;
      }
    }
  }
  
  public static i a()
  {
    synchronized (c)
    {
      if (d == null) {
        d = new i();
      }
      return d;
    }
  }
  
  private static String b(Context paramContext)
  {
    try
    {
      int i = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService(z[21])).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      cn.jiguang.d.d.c(z[0], z[20] + paramContext.getMessage());
    }
    return "";
  }
  
  private void c(Context paramContext)
  {
    if (this.a) {
      return;
    }
    this.b = paramContext.getApplicationContext();
    this.e = a.p(paramContext);
    if (!this.e) {
      b.a = 0;
    }
    boolean bool;
    if ((this.e) && (a.q(paramContext)))
    {
      bool = true;
      this.f = bool;
      if (!this.f) {
        f.a().a(paramContext);
      }
      paramContext = b(this.b);
      String str = this.b.getPackageName();
      if ((paramContext == null) || (str == null) || (!this.b.getPackageName().equals(paramContext))) {
        break label124;
      }
    }
    label124:
    for (this.g = true;; this.g = false)
    {
      this.a = true;
      return;
      bool = false;
      break;
    }
  }
  
  private static boolean c(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      Intent localIntent = new Intent(paramContext, PushService.class);
      localIntent.setAction(paramString);
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      paramContext.startService(localIntent);
      return true;
    }
    catch (SecurityException paramContext)
    {
      cn.jiguang.d.d.h(z[0], z[23] + paramContext.getMessage());
      return false;
    }
    catch (Throwable paramContext)
    {
      cn.jiguang.d.d.h(z[0], z[24] + paramContext.getMessage());
    }
    return false;
  }
  
  public final void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    String str2 = z[0];
    StringBuilder localStringBuilder = new StringBuilder(z[22]).append(paramString).append(z[4]);
    if (paramBundle == null) {}
    for (String str1 = z[1];; str1 = paramBundle.toString())
    {
      cn.jiguang.d.d.c(str2, str1);
      c(paramContext);
      if (this.b == null) {
        this.b = paramContext.getApplicationContext();
      }
      cn.jiguang.c.f.d.a().a(new j(this, paramContext, paramString, paramBundle, 1));
      return;
    }
  }
  
  public final boolean a(Context paramContext)
  {
    c(paramContext);
    return this.e;
  }
  
  public final void b(Context paramContext, String paramString, Bundle paramBundle)
  {
    String str2 = z[0];
    StringBuilder localStringBuilder = new StringBuilder(z[2]).append(paramString).append(z[4]);
    if (paramBundle == null) {}
    for (String str1 = z[1];; str1 = paramBundle.toString())
    {
      cn.jiguang.d.d.c(str2, str1);
      if (JCoreInterface.init(paramContext, false)) {
        break;
      }
      cn.jiguang.d.d.g(z[0], z[5]);
      return;
    }
    c(paramContext);
    if (paramContext == null)
    {
      cn.jiguang.d.d.g(z[0], z[3]);
      return;
    }
    if (!b.c())
    {
      cn.jiguang.c.f.d.a().a(new j(this, paramContext, paramString, paramBundle, 0));
      return;
    }
    c(paramContext, paramString, paramBundle);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */