package cn.jiguang.c.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.MultiSpHelper;
import cn.jiguang.api.SdkType;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jiguang.c.b.e;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  private static d e;
  private static Object f;
  private static final String[] z;
  private boolean a = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private Map<Long, String> g = new HashMap();
  
  static
  {
    String[] arrayOfString = new String[29];
    int j = 0;
    Object localObject2 = "fQ\020i\021hK.O\005aC,|\020fA3V D\030";
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
        i = 100;
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
        localObject2 = "lLno\rhW!k\003!C.d\bvV)f\027!C.a\026`K$+\005KnO%aC,|\020fA3L\n{G2c\005lG";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "LN)`\n{Q\b`\bG2";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "fQ\020i\021hK.O\024zQ(V D\030";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "lLno\024zQ(+\005aF2j\rk\f!u\r!h\020p\027gk.q\001}D!f\001";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "fQ\020i\021hK.O)jQ3d\003jq\004N^";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "lLno\024zQ(+\rb\f!k\000}M)aJnR)+.BG3v\005hG\003i\rjL4";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "fQ\020i\021hK.O\027gC2`7Kiz";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "lLno\rhW!k\003!Q(d\026j\f!k\000}M)aJnR)+.\\J!w\001FL4`\026iC#`";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "|F+Z\022jP3l\013a}";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "zQ%w'{P,V\021lA%v\027/P)a^";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "zQ%w'{P,V\021lA%v\027/@5qDaM4%\002`W.aD|F+s\001}Q)j\n/@9%\027kI\024|\024j\030";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "zQ%w'{P,V\021lA%v\027/@5qDaM4%\002`W.aD}K$?";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "#Q$n0vR%?";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "`L\025v\001}a4w\bIC)i\001k\0022l\0005";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "#G2w\013}a/a\0015";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "`L\025v\001}a4w\bIC)i\001k\002\"p\020/L/qDiM5k\000/Q$n\022jP3l\013a\002\"|D|F+Q\035Gz";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "`L\025v\001}a4w\bIC)i\001k\002\"p\020/L/qDiM5k\000/P)a^";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "Bd";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "Zd";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "#T%w-aD/?";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "|G.a1|G2F\020}N\tk\002`\0023a\017[[0`^";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "#R2j\024jP4|^";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "`L\025v\001}a4w\b[K-`\013zV`w\rk\030";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "gC.a\bjw3`\026LV2iDiC)i\001k\016#j\n{G8qDfQ`k\021cN";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "hG4%\r|l%`\000ZQ%w'{P,%\002nK,`\000#A/k\020jZ4%\r|\002.p\bc";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "aG%aDaM4%";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "/W3`\026lV2iHaG7`\027{\0026`\026|K/k^";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "aW,i";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        f = new Object();
        return;
        i = 15;
        continue;
        i = 34;
        continue;
        i = 64;
        continue;
        i = 5;
      }
    }
  }
  
  public static d a()
  {
    synchronized (f)
    {
      if (e == null) {
        e = new d();
      }
      return e;
    }
  }
  
  private static String a(Context paramContext, String paramString)
  {
    a.a();
    String str1 = a.c(paramString, "");
    paramContext = MultiSpHelper.getString(paramContext, z[9] + paramString, "");
    if ((!TextUtils.isEmpty(str1)) && (!str1.equals(paramContext))) {
      return str1;
    }
    String str2 = z[2];
    paramString = new StringBuilder(z[26]).append(paramString).append(z[27]);
    paramContext = str1;
    if (TextUtils.isEmpty(str1)) {
      paramContext = z[28];
    }
    cn.jiguang.d.d.a(str2, paramContext);
    return "";
  }
  
  private void a(short paramShort, String paramString1, String paramString2)
  {
    cn.jiguang.d.d.c(z[2], z[21] + paramString2 + z[22] + paramShort + z[20] + paramString1);
    long l1 = cn.jiguang.c.a.a.r();
    int i = cn.jiguang.c.a.a.D();
    long l2 = cn.jiguang.c.a.a.i();
    OutputDataUtil localOutputDataUtil = new OutputDataUtil(20480);
    localOutputDataUtil.writeU16(0);
    localOutputDataUtil.writeU8(0);
    localOutputDataUtil.writeU8(26);
    localOutputDataUtil.writeU64(l2);
    localOutputDataUtil.writeU32(i);
    localOutputDataUtil.writeU64(l1);
    localOutputDataUtil.writeU8(paramShort);
    localOutputDataUtil.writeU8(1);
    localOutputDataUtil.writeByteArrayincludeLength(paramString1.getBytes());
    localOutputDataUtil.writeU16At(localOutputDataUtil.current(), 0);
    paramString1 = localOutputDataUtil.toByteArray();
    e.a();
    e.a(paramString1, SdkType.JCORE.name(), 0);
    this.g.put(Long.valueOf(l2), paramString2);
  }
  
  public static boolean f()
  {
    return !cn.jiguang.c.a.a.G();
  }
  
  private static boolean j()
  {
    boolean bool = false;
    try
    {
      Class.forName(z[4]);
      bool = true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        cn.jiguang.d.d.a(z[2], z[3] + localClassNotFoundException.getMessage());
      }
    }
    cn.jiguang.d.d.a(z[2], z[3] + bool);
    return bool;
  }
  
  private static boolean k()
  {
    boolean bool = false;
    try
    {
      Class.forName(z[6]);
      bool = true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        cn.jiguang.d.d.a(z[2], z[5] + localClassNotFoundException.getMessage());
      }
    }
    cn.jiguang.d.d.a(z[2], z[5] + bool);
    return bool;
  }
  
  private static boolean l()
  {
    boolean bool = true;
    try
    {
      Class.forName(z[1]);
      cn.jiguang.d.d.a(z[2], z[0] + bool);
      return bool;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        cn.jiguang.d.d.a(z[2], z[0] + localClassNotFoundException.getMessage());
        bool = false;
      }
    }
  }
  
  private static boolean m()
  {
    boolean bool = false;
    try
    {
      Class.forName(z[8]);
      bool = true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        cn.jiguang.d.d.a(z[2], z[7] + localClassNotFoundException.getMessage());
      }
    }
    cn.jiguang.d.d.a(z[2], z[7] + bool);
    return bool;
  }
  
  public final void a(Context paramContext)
  {
    if (paramContext == null) {
      cn.jiguang.d.d.g(z[2], z[24]);
    }
    do
    {
      return;
      String str1 = a(paramContext, SdkType.JPUSH.name());
      String str2 = a(paramContext, SdkType.JMESSAGE.name());
      String str3 = a(paramContext, SdkType.JANALYTICS.name());
      paramContext = a(paramContext, SdkType.JSHARE.name());
      if (!TextUtils.isEmpty(str1)) {
        a((short)1, str1, SdkType.JPUSH.name());
      }
      if (!TextUtils.isEmpty(str2)) {
        a((short)2, str2, SdkType.JMESSAGE.name());
      }
      if (!TextUtils.isEmpty(str3)) {
        a((short)4, str3, SdkType.JANALYTICS.name());
      }
    } while (TextUtils.isEmpty(paramContext));
    a((short)5, paramContext, SdkType.JSHARE.name());
  }
  
  public final void a(Context paramContext, long paramLong)
  {
    String str1 = (String)this.g.remove(Long.valueOf(paramLong));
    if (!TextUtils.isEmpty(str1))
    {
      cn.jiguang.d.d.c(z[2], z[10] + paramLong + z[13] + str1);
      a.a();
      String str2 = a.c(str1, "");
      if (!TextUtils.isEmpty(str2)) {
        MultiSpHelper.commitString(paramContext, z[9] + str1, str2);
      }
    }
    for (;;)
    {
      if (!b(paramContext)) {
        e.a().c();
      }
      return;
      cn.jiguang.d.d.c(z[2], z[11] + str1);
      continue;
      cn.jiguang.d.d.c(z[2], z[12] + paramLong);
    }
  }
  
  public final void a(Context paramContext, long paramLong, int paramInt)
  {
    paramContext = (String)this.g.remove(Long.valueOf(paramLong));
    if (!TextUtils.isEmpty(paramContext))
    {
      cn.jiguang.d.d.c(z[2], z[14] + paramLong + z[13] + paramContext + z[15] + paramInt);
      a.a();
      if (TextUtils.isEmpty(a.c(paramContext, ""))) {
        cn.jiguang.d.d.c(z[2], z[16] + paramContext);
      }
    }
    for (;;)
    {
      if (((this.g == null) || (this.g.isEmpty())) && (!this.b) && (!this.a)) {
        e.a().c();
      }
      return;
      cn.jiguang.d.d.c(z[2], z[17] + paramLong);
    }
  }
  
  public final String b()
  {
    if (this.b) {
      return z[18];
    }
    return z[19];
  }
  
  public final void b(Context paramContext, long paramLong)
  {
    cn.jiguang.d.d.c(z[2], z[23] + paramLong);
    this.g.remove(Long.valueOf(paramLong));
    if (((this.g == null) || (this.g.isEmpty())) && (!this.b) && (!this.a)) {
      e.a().c();
    }
  }
  
  public final boolean b(Context paramContext)
  {
    boolean bool = false;
    int i;
    if ((!this.b) && (!this.a))
    {
      if (paramContext != null) {
        break label44;
      }
      cn.jiguang.d.d.h(z[2], z[25]);
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
      label44:
      if ((this.c) && (!TextUtils.isEmpty(a(paramContext, SdkType.JANALYTICS.name()))))
      {
        i = 1;
      }
      else if ((this.d) && (!TextUtils.isEmpty(a(paramContext, SdkType.JSHARE.name()))))
      {
        i = 1;
      }
      else if ((this.a) && (!TextUtils.isEmpty(a(paramContext, SdkType.JPUSH.name()))))
      {
        i = 1;
      }
      else
      {
        if ((!this.b) || (TextUtils.isEmpty(a(paramContext, SdkType.JMESSAGE.name())))) {
          break;
        }
        i = 1;
      }
    }
  }
  
  public final short c()
  {
    short s1 = 0;
    if (this.a) {
      s1 = 1;
    }
    short s2 = s1;
    if (this.b)
    {
      if ((cn.jiguang.c.a.a.H() >= 0) || (cn.jiguang.c.a.a.G())) {
        s2 = (short)(s1 | 0x20);
      }
    }
    else {
      return s2;
    }
    return (short)(s1 | 0x40);
  }
  
  public final short d()
  {
    short s2 = 0;
    if (this.a) {
      s2 = 1;
    }
    short s1 = s2;
    if (this.c) {
      s1 = (short)(s2 | 0x4);
    }
    s2 = s1;
    if (this.d) {
      s2 = (short)(s1 | 0x8);
    }
    s1 = s2;
    if (this.b) {
      s1 = (short)(s2 | 0x20);
    }
    return s1;
  }
  
  public final short e()
  {
    short s2 = 0;
    if (this.a) {
      s2 = 1;
    }
    short s1 = s2;
    if (this.b) {
      if ((cn.jiguang.c.a.a.H() < 0) && (!cn.jiguang.c.a.a.G())) {
        break label69;
      }
    }
    label69:
    for (s1 = (short)(s2 | 0x20);; s1 = (short)(s2 | 0x40))
    {
      s2 = s1;
      if (this.c) {
        s2 = (short)(s1 | 0x4);
      }
      s1 = s2;
      if (this.d) {
        s1 = (short)(s2 | 0x8);
      }
      return s1;
    }
  }
  
  public final boolean g()
  {
    return this.b;
  }
  
  public final boolean h()
  {
    return this.a;
  }
  
  public final boolean i()
  {
    return (this.b) || (this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */