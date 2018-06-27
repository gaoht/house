package cn.jiguang.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.BasePreferenceManager;
import cn.jiguang.api.SdkType;
import cn.jiguang.c.d.l;
import cn.jiguang.c.d.p;
import cn.jiguang.f.h;
import cn.jiguang.service.Protocol;
import cn.jpush.android.service.PushService;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  public static final String a;
  public static boolean b;
  public static String c;
  public static String d;
  public static Context e;
  public static String f;
  public static long g;
  public static String h;
  public static int i;
  public static String j;
  public static boolean k;
  public static boolean l;
  public static cn.jiguang.b.a m;
  private static AtomicBoolean n;
  private static boolean o;
  private static ServiceConnection p;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[30];
    int i2 = 0;
    Object localObject2 = "K\034?\003Pq2?\nTq2?\nPc:q\013Q%:qNXd=v\bPv'1";
    int i1 = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int i3 = arrayOfChar.length;
    int i6 = 0;
    int i4 = 0;
    int i8 = i1;
    localObject2 = arrayOfChar;
    int i9 = i2;
    Object localObject3 = localObject1;
    int i5 = i3;
    Object localObject4;
    int i7;
    if (i3 <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i7 = i1;
      label68:
      i5 = i4;
      label71:
      localObject2 = localObject1;
      i6 = localObject2[i4];
      switch (i5 % 5)
      {
      default: 
        i1 = 53;
      }
    }
    for (;;)
    {
      localObject2[i4] = ((char)(i1 ^ i6));
      i5 += 1;
      if (i3 == 0)
      {
        i4 = i3;
        break label71;
      }
      i6 = i5;
      i5 = i3;
      localObject3 = localObject4;
      i9 = i2;
      localObject2 = localObject1;
      i8 = i7;
      i7 = i8;
      localObject1 = localObject2;
      i2 = i9;
      localObject4 = localObject3;
      i3 = i5;
      i4 = i6;
      if (i5 > i6) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i8)
      {
      default: 
        localObject3[i9] = localObject1;
        i2 = 1;
        localObject2 = ")sO\002Pd zNR`'?\027Zp!?/Eu8z\027\025c!p\003\025O\032X;tK\024?\031Pgs|\001[v<s\013\024";
        i1 = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i9] = localObject1;
        i2 = 2;
        localObject2 = "O\003J=}Z\020W/{K\026S";
        i1 = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i9] = localObject1;
        i2 = 3;
        localObject2 = "O\003J=}Z\022O>~@\n";
        i1 = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i9] = localObject1;
        i2 = 4;
        localObject2 = "h6k\017Qd'~T\025O\020p\034P%2o\036~`*?C\025k<kNQ`5v\000Pasv\000\025h2q\007S` k";
        i1 = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i9] = localObject1;
        i2 = 5;
        localObject2 = "O\020p\034PB?p\fTi";
        i1 = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i9] = localObject1;
        i2 = 6;
        localObject2 = "`!m\001Gf<{\013\0174c/V\031L=i\017Yl7?\017Eu\030z\027\025?s";
        i1 = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i9] = localObject1;
        i2 = 7;
        localObject2 = "h6k\017Qd'~T\025f;~\000[`??C\025k<kNQ`5v\000Pasv\000\025h2q\007S` k";
        i1 = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i9] = localObject1;
        i2 = 8;
        localObject2 = "h6k\017Qd'~T\025d#o%P|s2N";
        i1 = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i9] = localObject1;
        i2 = 9;
        localObject2 = "P=z\026E`0k\013Q?sy\017\\i6{NAjsx\013A%0j\034G`=kNTu#s\007Vd'v\001[%:q\bZ";
        i1 = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i9] = localObject1;
        i2 = 10;
        localObject2 = "h6k\017Qd'~T\025F2qN[j'?\tPqsr\013Ad\027~\032T%5m\001X%\022o\036Yl0~\032\\j=V\000Sj";
        i1 = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i9] = localObject1;
        i2 = 11;
        localObject2 = "h6k\017Qd'~T\025f;~\000[`??C\025";
        i1 = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i9] = localObject1;
        i2 = 12;
        localObject2 = "B6kNFa8?\030Pw v\001[%5~\007Y$\b莨厸Fa8牗杂处贠rB";
        i1 = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i9] = localObject1;
        i2 = 13;
        localObject2 = "v<I\013Gv:p\000\017";
        i1 = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i9] = localObject1;
        i2 = 14;
        localObject2 = "o2i\017\033k6k@Ew6y\013GL\003iXta7m\013Fv6l";
        i1 = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i9] = localObject1;
        i2 = 15;
        localObject2 = "W6r\001A`sL\013Gs:|\013\025g:q\n\025c2v\002Pas|\017@v6{NW|sL\013Vp!v\032L@+|\013Eq:p\000\024";
        i1 = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i9] = localObject1;
        i2 = 16;
        localObject2 = "O\020p\034P%}l\001\025c:s\013\025a<?\000Zqsr\017Af;?$vj!zN\033o2mNSl?zN\\ksk\006P%#m\001_`0kB\025C2v\002Pask\001\025l=v\032\025O\020p\034P";
        i1 = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i9] = localObject1;
        i2 = 17;
        localObject2 = "W6r\001A`sL\013Gs:|\013\025g:q\n\025c2v\002Pa";
        i1 = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i9] = localObject1;
        i2 = 18;
        localObject2 = "V6m\030\\f6W\013Yu6m";
        i1 = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i9] = localObject1;
        i2 = 19;
        localObject2 = "W6r\001A`sL\013Gs:|\013\025j=?\f\\k7v\000R+}1";
        i1 = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i9] = localObject1;
        i2 = 20;
        localObject2 = "q!j\013";
        i1 = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i9] = localObject1;
        i2 = 21;
        localObject2 = "d0k\007Zkiv\000\\qs2Nf`!i\007V`";
        i1 = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i9] = localObject1;
        i2 = 22;
        localObject2 = "k&s\002";
        i1 = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i9] = localObject1;
        i2 = 23;
        localObject2 = "K\034?\030Pw v\001[F<{\013\025j!?\030Pw v\001[K2r\013\025a6y\007[`7?\007[%>~\000\\c6l\032\033";
        i1 = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i9] = localObject1;
        i2 = 24;
        localObject2 = "c2s\035P";
        i1 = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i9] = localObject1;
        i2 = 25;
        localObject2 = "o2i\017\033k6k@Ew6y\013GL\003iZfq2|\005";
        i1 = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i9] = localObject1;
        i2 = 26;
        localObject2 = "U&l\006f`!i\007V`sw\017F%1z\013[%1v\000Q)sx\007C`sj\036\025k<h";
        i1 = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i9] = localObject1;
        i2 = 27;
        localObject2 = "d0k\007Zkiv\000\\qs2NFa8I\013Gv:p\000\0174}.@\005)s}\033\\i7V\n\0174b(";
        i1 = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i9] = localObject1;
        i2 = 28;
        localObject2 = "R6?\bZp={NAm6?\017Eu\030z\027\025l ?\r]d=x\013Q+sH\007Yism\013\030w6x\007Fq6m@";
        i1 = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i9] = localObject1;
        i2 = 29;
        localObject2 = "O\020p\034P%0~\000[j'?\fP%:q\007Al2s\007O`7?\rZh#s\013A`?fNQp6?\032Z%\035J\"y%2o\036|k5p@";
        i1 = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i9] = localObject1;
        z = arrayOfString;
        a = SdkType.JCORE.name();
        b = false;
        n = new AtomicBoolean(false);
        g = 0L;
        h = "";
        k = true;
        l = false;
        p = new b();
        return;
        i1 = 5;
        continue;
        i1 = 83;
        continue;
        i1 = 31;
        continue;
        i1 = 110;
      }
    }
  }
  
  private static boolean a()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        int i1 = Protocol.GetSdkVersion();
        cn.jiguang.d.d.j(z[5], z[12]);
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        try
        {
          cn.jiguang.d.d.a(z[5], z[13] + i1);
          if (i1 >= 100) {
            bool = true;
          }
          return bool;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          for (;;) {}
        }
        localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
        i1 = 0;
      }
      localUnsatisfiedLinkError1.printStackTrace();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = true;
    try
    {
      boolean bool2 = n.get();
      if (bool2) {}
      for (;;)
      {
        return bool1;
        if (o)
        {
          bool1 = false;
        }
        else if (!cn.jiguang.f.a.r(paramContext))
        {
          o = true;
          bool1 = false;
        }
        else
        {
          o = false;
          cn.jiguang.d.d.c(z[5], z[21]);
          cn.jiguang.c.d.d.a();
          cn.jiguang.a.a.b.d.a().a(paramContext.getApplicationContext());
          BasePreferenceManager.init(paramContext.getApplicationContext());
          p.a(paramContext);
          cn.jiguang.d.d.d(z[5], z[27]);
          if (!a())
          {
            cn.jiguang.d.d.j(z[5], z[16]);
            bool1 = false;
          }
          else
          {
            c = paramContext.getPackageName();
            e = paramContext.getApplicationContext();
            g = cn.jiguang.c.a.a.r();
            h = cn.jiguang.c.a.a.u();
            Object localObject1 = c(paramContext);
            if (localObject1 == null)
            {
              cn.jiguang.d.d.j(z[5], z[29]);
              bool1 = false;
            }
            else
            {
              d = paramContext.getPackageManager().getApplicationLabel((ApplicationInfo)localObject1).toString();
              try
              {
                localObject1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
                i = ((PackageInfo)localObject1).versionCode;
                localObject1 = ((PackageInfo)localObject1).versionName;
                j = (String)localObject1;
                if (((String)localObject1).length() > 30) {
                  j = j.substring(0, 30);
                }
                if (!b(paramContext)) {
                  bool1 = false;
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  cn.jiguang.d.d.d(z[5], z[23]);
                }
              }
            }
          }
        }
      }
      localObject2 = cn.jiguang.c.a.a.w();
    }
    finally {}
    Object localObject2;
    if ((h.a((String)localObject2)) || (z[22].equals(localObject2)))
    {
      label310:
      if (Build.VERSION.SDK_INT == 8)
      {
        System.setProperty(z[25], z[20]);
        System.setProperty(z[14], z[24]);
      }
      n.set(true);
      cn.jiguang.c.b.b.b();
      localObject2 = paramContext.getApplicationContext();
      if (m == null) {
        break label427;
      }
      cn.jiguang.d.d.c(z[5], z[26]);
    }
    for (;;)
    {
      cn.jiguang.a.a.a(paramContext);
      break;
      if (f.equalsIgnoreCase((String)localObject2)) {
        break label310;
      }
      cn.jiguang.d.d.d(z[18], z[28]);
      cn.jiguang.c.a.a.t();
      l.a(paramContext);
      break label310;
      label427:
      Intent localIntent = new Intent();
      localIntent.setClass((Context)localObject2, PushService.class);
      try
      {
        if (!((Context)localObject2).bindService(localIntent, p, 1)) {
          break label494;
        }
        cn.jiguang.d.d.a(z[5], z[19]);
      }
      catch (SecurityException localSecurityException)
      {
        cn.jiguang.d.d.h(z[5], z[15]);
      }
      continue;
      label494:
      cn.jiguang.d.d.a(z[5], z[17]);
    }
  }
  
  private static boolean b(Context paramContext)
  {
    Object localObject;
    String str;
    try
    {
      localObject = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (localObject != null)
      {
        localObject = ((ApplicationInfo)localObject).metaData;
        if (localObject == null) {
          break label343;
        }
        str = ((Bundle)localObject).getString(z[3]);
        if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(f)) || (!f.equals(str))) {
          break label113;
        }
        if (f.length() != 24) {
          return false;
        }
      }
      else
      {
        cn.jiguang.d.d.d(z[5], z[10]);
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      cn.jiguang.d.d.d(z[5], z[9], paramContext);
      return false;
    }
    return true;
    label113:
    f = str;
    if (h.a(str))
    {
      cn.jiguang.d.d.j(z[5], z[4]);
      cn.jiguang.c.d.b.a(e, 10001, false);
      cn.jiguang.c.a.a.a(paramContext, 10001);
      return false;
    }
    if (f.length() != 24)
    {
      cn.jiguang.d.d.j(z[5], z[6] + f + z[1]);
      cn.jiguang.c.d.b.a(e, 1008, false);
      cn.jiguang.c.a.a.a(paramContext, 1008);
      return false;
    }
    f = f.toLowerCase(Locale.getDefault());
    cn.jiguang.d.d.d(z[5], z[8] + f);
    cn.jiguang.c.a.a.h(f);
    paramContext = h.c(((Bundle)localObject).getString(z[2]));
    if (h.a(paramContext)) {
      cn.jiguang.d.d.d(z[5], z[7]);
    }
    for (;;)
    {
      return true;
      cn.jiguang.d.d.d(z[5], z[11] + paramContext);
      cn.jiguang.c.a.a.i(paramContext);
    }
    label343:
    cn.jiguang.d.d.d(z[5], z[0]);
    return false;
  }
  
  private static ApplicationInfo c(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      cn.jiguang.d.d.f(z[5], z[9], paramContext);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */