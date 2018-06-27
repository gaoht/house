package cn.jiguang.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import cn.jiguang.api.BasePreferenceManager;
import cn.jiguang.api.MultiSpHelper;
import cn.jiguang.c.b.g;
import cn.jiguang.d.d;
import cn.jiguang.f.h;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public final class a
  extends BasePreferenceManager
{
  public static String a;
  public static int b;
  public static boolean c;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[71];
    int j = 0;
    Object localObject2 = "\005/x~D\017/xxo\004$miB\033+u";
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
        i = 48;
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
        localObject2 = "\001%~e^29|~F\b8FxY\000/";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\001%~e^2&voQ\001\025me]\b";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "'\032lXC'Ki]\002>|_U\037<poUM#j,^\030&u";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = ".%wjY\n9";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\036#ui^\016/IyC\005\036paU";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "\037/~eC\031/kST\b<poU2+whB\002#}SY\t";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\t/oeS\b\025tmY\003\025paU\004";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "\001+jxo\n%vho\036#j";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "\003%meV\004)xxY\002$FbE\000";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "\016%wbU\016>pbW29mmD\b";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "\036/kzY\016/FD\002:|h";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "\037/~eC\031/kST\b<poU2'xo";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "\007:lX2)vb^2'p|";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "\003%meV\f)me_\003\025wy]";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "\t/oeS\b\025tmY\003\025xbT\037%pho\004.";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "\000\003I";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "\007:lX2)vb^2'icB\031";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "'\032lX2\016|zY\016/Ph";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "\017+zgE\035\025ki@\0028mSQ\t.k";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "\037/~eC\031/kST\b<poU2#tiY";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "\037/~eC\031/kST\b<poU2#wj_";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "\016$7f@\0309q\"Q\003.kcY\tdX\\`&\017@";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "\001+jxo\037/icB\031\025}iF\004)|SY\003,v";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "\036/kzY\016/Fo_\003$|oU\031";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "\035?jdo\030.ph";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "\007:lX29po\037/ziY\033/kSC\0318pbW";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "\001+jxo\n%vho\016%wbo\035%kx";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "\001%~e^28||_\037>FxY\000/";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        j = 29;
        localObject2 = "\035?jdD\004'|";
        i = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i4] = localObject1;
        j = 30;
        localObject2 = "\005>m|o\037/icB\031\025jeC2?k`";
        i = 29;
        localObject1 = arrayOfString;
        break;
      case 29: 
        localObject3[i4] = localObject1;
        j = 31;
        localObject2 = "\t/mE\001>Fo_\003$Fe@";
        i = 30;
        localObject1 = arrayOfString;
        break;
      case 30: 
        localObject3[i4] = localObject1;
        j = 32;
        localObject2 = "\001)me]\b";
        i = 31;
        localObject1 = arrayOfString;
        break;
      case 31: 
        localObject3[i4] = localObject1;
        j = 33;
        localObject2 = "\036/mxY\003-F|E\036\"FxY\000/";
        i = 32;
        localObject1 = arrayOfString;
        break;
      case 32: 
        localObject3[i4] = localObject1;
        j = 34;
        localObject2 = "\001+jxo\n%vho\016%wbo\004:";
        i = 33;
        localObject1 = arrayOfString;
        break;
      case 33: 
        localObject3[i4] = localObject1;
        j = 35;
        localObject2 = "\001+jxo\037/icB\031\025ucS\f>pc^";
        i = 34;
        localObject1 = arrayOfString;
        break;
      case 34: 
        localObject3[i4] = localObject1;
        j = 36;
        localObject2 = "\007:lX29po\003/mxI\035/";
        i = 35;
        localObject1 = arrayOfString;
        break;
      case 35: 
        localObject3[i4] = localObject1;
        j = 37;
        localObject2 = "\037/~eC\0318xxY\002$FeT";
        i = 36;
        localObject1 = arrayOfString;
        break;
      case 36: 
        localObject3[i4] = localObject1;
        j = 38;
        localObject2 = "\t/oeS\b\025tmY\003\025phC";
        i = 37;
        localObject1 = arrayOfString;
        break;
      case 37: 
        localObject3[i4] = localObject1;
        j = 39;
        localObject2 = "\t/oSY\003,vSB\b:FxY\000/";
        i = 38;
        localObject1 = arrayOfString;
        break;
      case 38: 
        localObject3[i4] = localObject1;
        j = 40;
        localObject2 = "\t/oeS\b\025tmY\003\025tmS";
        i = 39;
        localObject1 = arrayOfString;
        break;
      case 39: 
        localObject3[i4] = localObject1;
        j = 41;
        localObject2 = "\016$7f@\0309q\"C\b8oiB\016%wjY\n";
        i = 40;
        localObject1 = arrayOfString;
        break;
      case 40: 
        localObject3[i4] = localObject1;
        j = 42;
        localObject2 = "\036/mxY\003-FY\001/woU2:lX2>paU";
        i = 41;
        localObject1 = arrayOfString;
        break;
      case 41: 
        localObject3[i4] = localObject1;
        j = 43;
        localObject2 = "\001+jxo\016%wbU\016>pc^2>`|U";
        i = 42;
        localObject1 = arrayOfString;
        break;
      case 42: 
        localObject3[i4] = localObject1;
        j = 44;
        localObject2 = "\004'|e";
        i = 43;
        localObject1 = arrayOfString;
        break;
      case 43: 
        localObject3[i4] = localObject1;
        j = 45;
        localObject2 = "\t/mE\001>Fo_\003$F|_\037>";
        i = 44;
        localObject1 = arrayOfString;
        break;
      case 44: 
        localObject3[i4] = localObject1;
        j = 46;
        localObject2 = "\000\032v~D";
        i = 45;
        localObject1 = arrayOfString;
        break;
      case 45: 
        localObject3[i4] = localObject1;
        j = 47;
        localObject2 = "\036.rSF\b8je_\003";
        i = 46;
        localObject1 = arrayOfString;
        break;
      case 46: 
        localObject3[i4] = localObject1;
        j = 48;
        localObject2 = "\001+jxo\036#jSB\b;liC\031\025me]\b";
        i = 47;
        localObject1 = arrayOfString;
        break;
      case 47: 
        localObject3[i4] = localObject1;
        j = 49;
        localObject2 = "\t/oeS\b\025kiW\0049miB\b.Fm@\035!|u";
        i = 48;
        localObject1 = arrayOfString;
        break;
      case 48: 
        localObject3[i4] = localObject1;
        j = 50;
        localObject2 = "\t/ooY\b\025pho\n/wiB\f>|h";
        i = 49;
        localObject1 = arrayOfString;
        break;
      case 49: 
        localObject3[i4] = localObject1;
        j = 51;
        localObject2 = "\0049FxS\035\025z`_\036/";
        i = 50;
        localObject1 = arrayOfString;
        break;
      case 50: 
        localObject3[i4] = localObject1;
        j = 52;
        localObject2 = "8:}mD\bj~_\000jx,F\b8je_\003j|mB\001#|~\020\031\"xb\020\\r),\034\00289jY\036>9xY\000/9e^\036>x`\\M\000IyC\005\031]G\036";
        i = 51;
        localObject1 = arrayOfString;
        break;
      case 51: 
        localObject3[i4] = localObject1;
        j = 53;
        localObject2 = "\t/oeS\b\025zdQ\003$|`";
        i = 52;
        localObject1 = arrayOfString;
        break;
      case 52: 
        localObject3[i4] = localObject1;
        j = 54;
        localObject2 = "\t/oeS\b\025imC\036=v~T";
        i = 53;
        localObject1 = arrayOfString;
        break;
      case 53: 
        localObject3[i4] = localObject1;
        j = 55;
        localObject2 = "\t/oeS\b\025leT";
        i = 54;
        localObject1 = arrayOfString;
        break;
      case 54: 
        localObject3[i4] = localObject1;
        j = 56;
        localObject2 = "\001+jxo\037/icB\031\025pbT\b2";
        i = 55;
        localObject1 = arrayOfString;
        break;
      case 55: 
        localObject3[i4] = localObject1;
        j = 57;
        localObject2 = "\036/jY\002$FeT";
        i = 56;
        localObject1 = arrayOfString;
        break;
      case 56: 
        localObject3[i4] = localObject1;
        j = 58;
        localObject2 = "\t/oeS\b\025kiW\0049m~Q\031#vbo\004.";
        i = 57;
        localObject1 = arrayOfString;
        break;
      case 57: 
        localObject3[i4] = localObject1;
        j = 59;
        localObject2 = ">+ti\020$\007\\E\020\f$},Q\003.kcY\t\003}-";
        i = 58;
        localObject1 = arrayOfString;
        break;
      case 58: 
        localObject3[i4] = localObject1;
        j = 60;
        localObject2 = "#/nHU\033#zi\n$\007\\E\020\00289M^\t8veT$.9dQ\tjzdQ\003-|h\021";
        i = 59;
        localObject1 = arrayOfString;
        break;
      case 59: 
        localObject3[i4] = localObject1;
        j = 61;
        localObject2 = "\003/axo\037#}";
        i = 60;
        localObject1 = arrayOfString;
        break;
      case 60: 
        localObject3[i4] = localObject1;
        j = 62;
        localObject2 = "\017+zgE\035\025lU\037\025xhT\037";
        i = 61;
        localObject1 = arrayOfString;
        break;
      case 61: 
        localObject3[i4] = localObject1;
        j = 63;
        localObject2 = "#/nHU\033#zi\n,$}~_\004.Ph\020\00289AQ\016jqmTM)qm^\n/}-";
        i = 62;
        localObject1 = arrayOfString;
        break;
      case 62: 
        localObject3[i4] = localObject1;
        j = 64;
        localObject2 = ">+ti\020\f$}~_\004.Ph\020\f$},]\f)XhT\037/j\021";
        i = 63;
        localObject1 = arrayOfString;
        break;
      case 63: 
        localObject3[i4] = localObject1;
        j = 65;
        localObject2 = "\036/kzY\016/jS\\\f?woX\b.FxY\000/";
        i = 64;
        localObject1 = arrayOfString;
        break;
      case 64: 
        localObject3[i4] = localObject1;
        j = 66;
        localObject2 = "\t/oeS\b\025x|@\006/`";
        i = 65;
        localObject1 = arrayOfString;
        break;
      case 65: 
        localObject3[i4] = localObject1;
        j = 67;
        localObject2 = "\004'F`_\n#wSS\002?wx";
        i = 66;
        localObject1 = arrayOfString;
        break;
      case 66: 
        localObject3[i4] = localObject1;
        j = 68;
        localObject2 = "\0049Fe]2&vkW\b.Fe^";
        i = 67;
        localObject1 = arrayOfString;
        break;
      case 67: 
        localObject3[i4] = localObject1;
        j = 69;
        localObject2 = "\\{*\"\003\\d(;\036\\z/";
        i = 68;
        localObject1 = arrayOfString;
        break;
      case 68: 
        localObject3[i4] = localObject1;
        j = 70;
        localObject2 = "\007:lX28|kY\036>|~o\016%}i";
        i = 69;
        localObject1 = arrayOfString;
        break;
      case 69: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = "";
        b = -1;
        c = false;
        return;
        i = 109;
        continue;
        i = 74;
        continue;
        i = 25;
        continue;
        i = 12;
      }
    }
  }
  
  public static boolean A()
  {
    String str1 = getString(z[7], "");
    String str2 = getString(z[15], "");
    String str3 = getString(z[40], "");
    if ((str1.isEmpty()) && (str2.isEmpty()) && (str3.isEmpty()))
    {
      d.e(z[4], z[52]);
      return true;
    }
    return false;
  }
  
  public static String B()
  {
    return getString(z[7], "");
  }
  
  public static String C()
  {
    return getString(z[47], "");
  }
  
  public static int D()
  {
    return MultiSpHelper.getInt(cn.jiguang.c.a.e, z[57], 0);
  }
  
  public static boolean E()
  {
    try
    {
      boolean bool = cn.jiguang.c.a.m.a();
      return bool;
    }
    catch (Exception localException)
    {
      d.a(z[4], z[3], localException);
      if (g.a.get() != 0L) {
        return true;
      }
    }
    return false;
  }
  
  public static long F()
  {
    return MultiSpHelper.getLong(cn.jiguang.c.a.e, z[65], -1L);
  }
  
  public static boolean G()
  {
    return MultiSpHelper.getBoolean(cn.jiguang.c.a.e, z[68], false);
  }
  
  public static int H()
  {
    return MultiSpHelper.getInt(cn.jiguang.c.a.e, z[67], -1);
  }
  
  public static long a(long paramLong)
  {
    long l = getLong(z[2], 0L);
    return (getLong(z[1], 0L) - l + paramLong) / 1000L;
  }
  
  public static String a(Context paramContext)
  {
    return getString(paramContext, z[25], "");
  }
  
  public static void a(int paramInt)
  {
    commitInt(z[27], paramInt);
  }
  
  public static void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(Long.valueOf(paramLong));
    n(paramString1);
    o(paramString2);
    if (!h.a(paramString3)) {
      g(paramString3);
    }
    commitString(z[49], paramString4);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    MultiSpHelper.commitInt(paramContext, z[70], paramInt);
  }
  
  public static void a(Context paramContext, cn.jiguang.c.b.a parama)
  {
    MultiSpHelper.commitString(paramContext, z[10], parama.name());
  }
  
  public static void a(Context paramContext, String paramString)
  {
    commitString(paramContext, z[25], paramString);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    MultiSpHelper.commitString(paramContext, paramString1, getEncryptedString(paramString2));
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    MultiSpHelper.commitBoolean(paramContext, z[51], paramBoolean);
  }
  
  private static void a(Long paramLong)
  {
    cn.jiguang.c.a.g = paramLong.longValue();
    MultiSpHelper.commitLong(cn.jiguang.c.a.e, z[55], paramLong.longValue());
  }
  
  public static void a(String paramString)
  {
    commitString(z[34], paramString);
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 172	cn/jiguang/c/a/a:z	[Ljava/lang/String;
    //   6: bipush 56
    //   8: aaload
    //   9: lconst_0
    //   10: invokestatic 253	cn/jiguang/c/a/a:getLong	(Ljava/lang/String;J)J
    //   13: lstore_0
    //   14: invokestatic 331	java/lang/System:currentTimeMillis	()J
    //   17: lstore_2
    //   18: lload_2
    //   19: lload_0
    //   20: lsub
    //   21: ldc2_w 332
    //   24: lcmp
    //   25: ifle +22 -> 47
    //   28: getstatic 172	cn/jiguang/c/a/a:z	[Ljava/lang/String;
    //   31: bipush 56
    //   33: aaload
    //   34: lload_2
    //   35: invokestatic 336	cn/jiguang/c/a/a:commitLong	(Ljava/lang/String;J)V
    //   38: iconst_1
    //   39: istore 4
    //   41: ldc 2
    //   43: monitorexit
    //   44: iload 4
    //   46: ireturn
    //   47: iconst_0
    //   48: istore 4
    //   50: goto -9 -> 41
    //   53: astore 5
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload 5
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	7	0	l1	long
    //   17	18	2	l2	long
    //   39	10	4	bool	boolean
    //   53	6	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	18	53	finally
    //   28	38	53	finally
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    String str1 = getString(z[7], "");
    String str2 = getString(z[15], "");
    if ((paramString1.equals(str1)) && (paramString2.equals(str2)))
    {
      d.e(z[4], z[59]);
      return true;
    }
    d.e(z[4], z[60]);
    return false;
  }
  
  public static long b()
  {
    return getLong(z[56], 0L);
  }
  
  public static String b(Context paramContext)
  {
    return getString(paramContext, z[44], "");
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = MultiSpHelper.getString(paramContext, paramString1, "");
    if (h.a(paramContext)) {
      return paramString2;
    }
    return getDecryptString(paramContext, paramString2);
  }
  
  public static void b(int paramInt)
  {
    commitInt(z[45], paramInt);
  }
  
  public static void b(long paramLong)
  {
    commitLong(z[1], paramLong);
    commitLong(z[2], System.currentTimeMillis());
  }
  
  public static void b(Context paramContext, String paramString)
  {
    commitString(paramContext, z[44], paramString);
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    if (!paramString.equalsIgnoreCase(getString(z[43], null)))
    {
      commitString(z[43], paramString);
      return true;
    }
    return false;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    String str1 = getString(z[15], "");
    String str2 = getString(z[40], "");
    if ((h.a(paramString2)) || (h.a(str2))) {
      return paramString1.equals(str1);
    }
    if ((paramString1.equals(str1)) && (paramString2.equals(str2)))
    {
      d.e(z[4], z[64]);
      return true;
    }
    d.e(z[4], z[63]);
    return false;
  }
  
  public static cn.jiguang.c.b.a c(Context paramContext)
  {
    return cn.jiguang.c.b.a.valueOf(MultiSpHelper.getString(paramContext, z[10], cn.jiguang.c.b.a.b.name()));
  }
  
  public static String c()
  {
    return getString(z[34], null);
  }
  
  public static void c(int paramInt)
  {
    MultiSpHelper.commitInt(cn.jiguang.c.a.e, z[57], paramInt);
  }
  
  public static void c(long paramLong)
  {
    MultiSpHelper.commitLong(cn.jiguang.c.a.e, z[65], paramLong);
  }
  
  public static void c(String paramString)
  {
    commitString(z[31], paramString);
  }
  
  public static int d()
  {
    return getInt(z[27], 0);
  }
  
  public static void d(Context paramContext)
  {
    init(paramContext);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(z[41], 0);
    String str2 = z[10];
    if (localSharedPreferences.getInt(z[24], 0) == 1) {}
    for (String str1 = cn.jiguang.c.b.a.a.name();; str1 = cn.jiguang.c.b.a.b.name())
    {
      commitString(paramContext, str2, str1);
      commitString(paramContext, z[38], localSharedPreferences.getString(z[21], ""));
      commitString(paramContext, z[7], localSharedPreferences.getString(z[20], ""));
      commitString(paramContext, z[15], localSharedPreferences.getString(z[6], ""));
      commitString(paramContext, z[40], localSharedPreferences.getString(z[12], ""));
      commitString(paramContext, z[43], localSharedPreferences.getString(z[36], ""));
      commitString(paramContext, z[8], localSharedPreferences.getString(z[26], ""));
      commitString(paramContext, z[31], localSharedPreferences.getString(z[16], ""));
      commitString(paramContext, z[19], localSharedPreferences.getString(z[30], ""));
      commitString(paramContext, z[34], localSharedPreferences.getString(z[13], ""));
      commitString(paramContext, z[25], localSharedPreferences.getString(z[25], ""));
      commitString(paramContext, z[44], localSharedPreferences.getString(z[44], ""));
      commitInt(paramContext, z[45], localSharedPreferences.getInt(z[46], 0));
      commitInt(paramContext, z[27], localSharedPreferences.getInt(z[17], 0));
      commitLong(paramContext, z[2], localSharedPreferences.getLong(z[32], 0L));
      commitLong(paramContext, z[23], localSharedPreferences.getLong(z[39], 0L));
      commitLong(paramContext, z[1], localSharedPreferences.getLong(z[1], 0L));
      commitLong(paramContext, z[35], localSharedPreferences.getLong(z[28], 0L));
      o(localSharedPreferences.getString(z[37], ""));
      h(localSharedPreferences.getString(z[22], ""));
      g(localSharedPreferences.getString(z[18], ""));
      MultiSpHelper.commitString(paramContext, z[42], localSharedPreferences.getString(z[5], ""));
      MultiSpHelper.commitString(paramContext, z[33], localSharedPreferences.getString(z[29], ""));
      MultiSpHelper.commitInt(paramContext, z[9], localSharedPreferences.getInt(z[14], 5));
      int i = localSharedPreferences.getInt(z[11], 0);
      MultiSpHelper.commitInt(paramContext, z[11], i);
      return;
    }
  }
  
  public static void d(String paramString)
  {
    MultiSpHelper.commitString(cn.jiguang.c.a.e, z[19], paramString);
  }
  
  public static void e(String paramString)
  {
    commitString(z[62], paramString);
  }
  
  public static boolean e()
  {
    long l = getLong(z[48], 0L);
    return System.currentTimeMillis() - l > 180000L;
  }
  
  public static boolean e(Context paramContext)
  {
    return MultiSpHelper.getBoolean(paramContext, z[51], false);
  }
  
  public static void f()
  {
    commitLong(z[48], System.currentTimeMillis());
  }
  
  public static void f(String paramString)
  {
    commitString(z[8], paramString);
  }
  
  public static long g()
  {
    long l = getLong(z[2], 0L);
    return (getLong(z[1], 0L) - l + System.currentTimeMillis()) / 1000L;
  }
  
  public static void g(String paramString)
  {
    MultiSpHelper.commitString(cn.jiguang.c.a.e, z[50], paramString);
  }
  
  public static long h()
  {
    long l = getLong(z[2], 0L);
    return getLong(z[1], 0L) - l + System.currentTimeMillis();
  }
  
  public static void h(String paramString)
  {
    MultiSpHelper.commitString(cn.jiguang.c.a.e, z[66], paramString);
  }
  
  public static long i()
  {
    try
    {
      String str = z[61];
      long l2 = Math.abs(new Random().nextInt(32767));
      long l1 = l2;
      if (l2 % 2L == 0L) {
        l1 = l2 + 1L;
      }
      l1 = getLong(str, l1) % 32767L;
      commitLong(z[61], l1 + 2L);
      return l1 + 2L;
    }
    finally {}
  }
  
  public static void i(String paramString)
  {
    commitString(z[53], paramString);
  }
  
  public static int j()
  {
    return getInt(z[0], 290);
  }
  
  public static void j(String paramString)
  {
    commitString(z[7], paramString);
  }
  
  public static void k()
  {
    commitInt(z[0], 290);
  }
  
  public static void k(String paramString)
  {
    commitString(z[15], paramString);
  }
  
  public static void l()
  {
    commitInt(z[0], 86400);
  }
  
  public static void l(String paramString)
  {
    commitString(z[40], paramString);
  }
  
  public static void m(String paramString)
  {
    commitString(z[47], paramString);
  }
  
  public static boolean m()
  {
    return j() == 86400;
  }
  
  public static String n()
  {
    return getString(z[31], z[69]);
  }
  
  private static void n(String paramString)
  {
    cn.jiguang.c.a.h = paramString;
    MultiSpHelper.commitString(cn.jiguang.c.a.e, z[54], paramString);
  }
  
  public static int o()
  {
    return getInt(z[45], 7000);
  }
  
  private static void o(String paramString)
  {
    MultiSpHelper.commitString(cn.jiguang.c.a.e, z[58], paramString);
  }
  
  public static String p()
  {
    return MultiSpHelper.getString(cn.jiguang.c.a.e, z[19], null);
  }
  
  public static String q()
  {
    return getString(z[8], null);
  }
  
  public static long r()
  {
    long l2 = cn.jiguang.c.a.g;
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = MultiSpHelper.getLong(cn.jiguang.c.a.e, z[55], 0L);
      cn.jiguang.c.a.g = l1;
    }
    return l1;
  }
  
  public static boolean s()
  {
    long l = r();
    String str = v();
    return (l > 0L) && (!h.a(str));
  }
  
  public static void t()
  {
    a(Long.valueOf(0L));
    n("");
    o("");
    g("");
    removeKey(z[49]);
  }
  
  public static String u()
  {
    String str2 = cn.jiguang.c.a.h;
    String str1 = str2;
    if (h.a(str2))
    {
      str1 = MultiSpHelper.getString(cn.jiguang.c.a.e, z[54], "");
      cn.jiguang.c.a.h = str1;
    }
    return str1;
  }
  
  public static String v()
  {
    return MultiSpHelper.getString(cn.jiguang.c.a.e, z[58], "");
  }
  
  public static String w()
  {
    return getString(z[49], null);
  }
  
  public static String x()
  {
    return MultiSpHelper.getString(cn.jiguang.c.a.e, z[50], "");
  }
  
  public static String y()
  {
    return MultiSpHelper.getString(cn.jiguang.c.a.e, z[66], "");
  }
  
  public static String z()
  {
    return getString(z[53], null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */