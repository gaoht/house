package cn.jpush.android.api;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.a.b;
import cn.jpush.android.c.a;
import cn.jpush.android.c.f;
import cn.jpush.android.data.h;
import cn.jpush.android.e;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.ui.PopWinActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.zip.Adler32;

public final class c
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[47];
    int j = 0;
    Object localObject2 = "(\0263o\030>\013u+\t%\034oj\001/VUQ%\007'O@;";
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
        i = 104;
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
        localObject2 = "\030\035saH;\rnmH9\035~`\001=\035y%\n9\027|a\013*\013i%\034$Xy`\036.\024ru\r9Xy`\016\"\026xaH9\035~`\001=\035o";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "8\035sa&$\ftc\001(\031il\007%*xf\r\"\016xa*9\027|a\013*\013i%\r9\nrwR";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "-\021q`RdW";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/VSJ<\002>TF)\0371RK7\017=K@$\004(XW7\n*Z5";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "#\fiuRdW";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/Vtk\034.\026i+&\004,TC!\b9IL'\005'O@+\0161K@,";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\005\027il\016\"\033|q\001$\026U`\004;\035o";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "e\bxw\005\"\013nl\007%VWU=\0300BH-\030+\\B-";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/VUQ%\007'MD<\003";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "%\027il\016\"\033|q\001$\026";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "*\033il\007%B~i\r*\026Sj\034\"\036tf\t?\021rkHfXp`\0338\031z`!/B";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/Vtk\034.\026i+%\0364IL7\033*RF-\030+";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "*\033il\007%";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "&\rqq\001\024\fdu\r";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/V_L/\024,X]<";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "?\020x%8>\013uW\r(\035ts\r9XtkH&\031sl\016.\013i%\0018Xy`\004.\fxaH)\001=v\007&\035=j\034#\035o%\t;\bn)\037.Xnm\007>\024y%\033.\026y%\034#\035=g\032$\031yf\t8\f=a\0019\035~q\0042V";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/V_L/\024(TF7\0339IM";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "\f\027i%&\0364Q%\006$\ftc\001(\031il\007%V=B\001=\035=p\030k\fr%\033#\027j+";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/VSJ<\002'^D<\016?RW1";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "*\bm";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/VSJ<\002>TF)\0371RK7\b7SQ-\005,BQ!\0374X";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "*\033il\007%Bnm\007<6rq\001-\021~d\034\"\027s";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "\"\013Sj\034\"\036tf\t?\021rk";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/VTK*\004 ";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/VPV/\0241Y";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/Vtk\034.\026i+&\004,TC!\b9IL'\005'RU-\005=Y";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "9\rsk\001%\037=c\004*\037'";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        j = 28;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/V\\I-\031,";
        i = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i4] = localObject1;
        j = 29;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/Vtk\034.\026i+&\004,TC!\b9IL'\005'RU-\005=YZ8\0317E\\F";
        i = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i4] = localObject1;
        j = 30;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/VX]<\0319";
        i = 29;
        localObject1 = arrayOfString;
        break;
      case 29: 
        localObject3[i4] = localObject1;
        j = 31;
        localObject2 = "8\034vq\021;\035";
        i = 30;
        localObject1 = arrayOfString;
        break;
      case 30: 
        localObject3[i4] = localObject1;
        j = 32;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/VSJ<\002>TF)\0371RK7\037!M@";
        i = 31;
        localObject1 = arrayOfString;
        break;
      case 31: 
        localObject3[i4] = localObject1;
        j = 33;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/VSJ<\002'MW!\004*TQ1";
        i = 32;
        localObject1 = arrayOfString;
        break;
      case 32: 
        localObject3[i4] = localObject1;
        j = 34;
        localObject2 = "/\035ql\036.\nd%\032\"\033u%\030>\013u%\0342\bx?H";
        i = 33;
        localObject1 = arrayOfString;
        break;
      case 33: 
        localObject3[i4] = localObject1;
        j = 35;
        localObject2 = "*\033il\007%B~i\r*\026\\i\004\005\027il\016\"\033|q\001$\026=(H&\035nv\t,\035TaR";
        i = 34;
        localObject1 = arrayOfString;
        break;
      case 34: 
        localObject3[i4] = localObject1;
        j = 36;
        localObject2 = "8\f|w\034k\026xrH?\020o`\t/";
        i = 35;
        localObject1 = arrayOfString;
        break;
      case 35: 
        localObject3[i4] = localObject1;
        j = 37;
        localObject2 = "(\0263o\030>\013u+\t%\034oj\001/VSJ<\002>TF)\0371RK7\002<";
        i = 36;
        localObject1 = arrayOfString;
        break;
      case 36: 
        localObject3[i4] = localObject1;
        j = 38;
        localObject2 = "e*";
        i = 37;
        localObject1 = arrayOfString;
        break;
      case 37: 
        localObject3[i4] = localObject1;
        j = 39;
        localObject2 = "\r\031ti\r/XijH,\035i%\032.\013=l\fk\036rwH%\031p`F";
        i = 38;
        localObject1 = arrayOfString;
        break;
      case 38: 
        localObject3[i4] = localObject1;
        j = 40;
        localObject2 = ";\031od\005.\fxwH9\035nQ\021;\035=j\032k\036t`\004/6|h\r8Xxw\032$\n3";
        i = 39;
        localObject1 = arrayOfString;
        break;
      case 39: 
        localObject3[i4] = localObject1;
        j = 41;
        localObject2 = "\031\\yw\t<\031i\r";
        i = 40;
        localObject1 = arrayOfString;
        break;
      case 40: 
        localObject3[i4] = localObject1;
        j = 42;
        localObject2 = "!\bhv\000\024\026rq\001-\021~d\034\"\027sZ\001(\027s";
        i = 41;
        localObject1 = arrayOfString;
        break;
      case 41: 
        localObject3[i4] = localObject1;
        j = 43;
        localObject2 = "\b\031s%\006$\f=i\007*\034=w\r8\027hw\013.B=o\030>\013uZ\006$\ftc\001(\031il\007%'tf\007%";
        i = 42;
        localObject1 = arrayOfString;
        break;
      case 42: 
        localObject3[i4] = localObject1;
        j = 44;
        localObject2 = "*\033il\007%B~i\r*\026Sj\034\"\036tf\t?\021rkHfXsj\034\"\036tf\t?\021rk!/B";
        i = 43;
        localObject1 = arrayOfString;
        break;
      case 43: 
        localObject3[i4] = localObject1;
        j = 45;
        localObject2 = "\037\020n%\0058\037TaH\"\013=k\007?X|%\001%\fxb\r9";
        i = 44;
        localObject1 = arrayOfString;
        break;
      case 44: 
        localObject3[i4] = localObject1;
        j = 46;
        localObject2 = "*\033il\007%Bz`\034\005\027{l\034\"\033|q\001$\026TAHfXxh\030?\001=h\r8\013|b\r\002\034";
        i = 45;
        localObject1 = arrayOfString;
        break;
      case 45: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 75;
        continue;
        i = 120;
        continue;
        i = 29;
        continue;
        i = 5;
      }
    }
  }
  
  public static int a(int paramInt)
  {
    int j = 17301586;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    case 1: 
    case -1: 
      for (;;)
      {
        return i;
        HashMap localHashMap = a(z[41], new String[] { z[42] });
        try
        {
          paramInt = ((Integer)localHashMap.get(z[42])).intValue();
          i = paramInt;
          if (paramInt <= 0) {
            return 17301618;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            f.i(z[7], z[43]);
            paramInt = 0;
          }
        }
      }
    case 0: 
      return 17301647;
    case 2: 
      return 17301618;
    }
    return 17301567;
  }
  
  private static int a(cn.jpush.android.data.c paramc, int paramInt)
  {
    String str = paramc.c;
    if (!TextUtils.isEmpty(paramc.d)) {
      str = paramc.d;
    }
    return a(str, paramInt);
  }
  
  private static int a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      f.c(z[7], z[46]);
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      try
      {
        i = Integer.valueOf(paramString).intValue();
        return i;
      }
      catch (Exception localException)
      {
        f.g(z[7], z[45]);
        Adler32 localAdler32 = new Adler32();
        localAdler32.update(paramString.getBytes());
        int j = (int)localAdler32.getValue();
        i = j;
        if (j < 0) {
          i = Math.abs(j);
        }
        i += 13889152 * paramInt;
        paramInt = i;
      }
    } while (i >= 0);
    return Math.abs(i);
  }
  
  private static HashMap<String, Integer> a(String paramString, String[] paramArrayOfString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException(z[40]);
    }
    localHashMap = new HashMap();
    try
    {
      String str = cn.jpush.android.d.e.getPackageName();
      Class[] arrayOfClass = Class.forName(str + z[38]).getDeclaredClasses();
      int k = arrayOfClass.length;
      int i = 0;
      while (i < k)
      {
        str = arrayOfClass[i];
        if (str.getName().contains(paramString))
        {
          i = j;
          while (i <= 0)
          {
            paramString = paramArrayOfString[0];
            localHashMap.put(paramString, Integer.valueOf(str.getDeclaredField(paramString).getInt(paramString)));
            i += 1;
          }
        }
        i += 1;
      }
      return localHashMap;
    }
    catch (Exception paramString)
    {
      f.b(z[7], z[39], paramString);
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (paramInt > 0)
    {
      int i = 0;
      while (i < paramInt)
      {
        Integer localInteger = Integer.valueOf(cn.jpush.android.a.d.a());
        if (localInteger.intValue() != 0) {
          b(paramContext, localInteger.intValue());
        }
        i += 1;
      }
    }
  }
  
  public static void a(Context paramContext, cn.jpush.android.data.c paramc)
  {
    f.e(z[7], z[36]);
    new Thread(new d(paramContext, paramc)).start();
  }
  
  public static void a(Context paramContext, cn.jpush.android.data.c paramc, int paramInt)
  {
    f.c(z[7], z[11] + paramc.c);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = cn.jpush.android.d.e;
    }
    ((NotificationManager)localContext.getSystemService(z[10])).cancel(a(paramc, 0));
  }
  
  public static void a(Context paramContext, String paramString)
  {
    f.c(z[7], z[35] + paramString);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = cn.jpush.android.d.e;
    }
    paramContext = (NotificationManager)localContext.getSystemService(z[10]);
    paramContext.cancel(a(paramString, 0));
    paramContext.cancel(a(paramString, 1));
  }
  
  private static void a(Context paramContext, Map<String, String> paramMap, int paramInt, String paramString1, String paramString2, cn.jpush.android.data.c paramc)
  {
    Intent localIntent;
    StringBuilder localStringBuilder;
    for (;;)
    {
      try
      {
        f.d(z[7], z[1]);
        localIntent = new Intent(z[6]);
        a(localIntent, paramMap, paramInt);
        if (!TextUtils.isEmpty(paramString1)) {
          localIntent.putExtra(z[4], paramString1);
        }
        if ((!paramc.a()) || (!(paramc instanceof h))) {
          break label331;
        }
        paramMap = (h)paramc;
        if ((paramMap.J == 0) || (paramMap.J == 4)) {
          break label331;
        }
        if ((paramMap.O != null) && (paramMap.O.startsWith(z[3])))
        {
          paramMap.O = paramMap.O.replaceFirst(z[3], "");
          localIntent.putExtra(z[9], paramMap.O);
        }
        if ((paramMap.L == null) || (paramMap.L.size() <= 0)) {
          break label331;
        }
        localStringBuilder = new StringBuilder();
        paramc = cn.jpush.android.c.c.b(paramContext, paramc.c);
        Iterator localIterator = paramMap.L.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        paramString1 = (String)localIterator.next();
        paramMap = paramString1;
        if (paramString1.startsWith(z[5])) {
          paramMap = cn.jpush.android.c.c.a(paramString1);
        }
        if (TextUtils.isEmpty(localStringBuilder.toString())) {
          localStringBuilder.append(paramc).append(paramMap);
        } else {
          localStringBuilder.append(",").append(paramc).append(paramMap);
        }
      }
      catch (Throwable paramContext)
      {
        f.h(z[7], z[2] + paramContext.getMessage());
        return;
      }
    }
    localIntent.putExtra(z[0], localStringBuilder.toString());
    label331:
    localIntent.addCategory(paramString2);
    paramContext.sendBroadcast(localIntent, paramString2 + z[8]);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if ((paramBoolean) || (JCoreInterface.canCallDirect())) {
      for (;;)
      {
        localObject = Integer.valueOf(cn.jpush.android.a.d.a());
        if (((Integer)localObject).intValue() == 0) {
          break;
        }
        b(paramContext, ((Integer)localObject).intValue());
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString(z[13], z[12]);
    ((Bundle)localObject).putInt(z[14], 10);
    JCoreInterface.sendAction(paramContext, cn.jpush.android.d.a, (Bundle)localObject);
  }
  
  private static void a(Intent paramIntent, Map<String, String> paramMap, int paramInt)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramIntent.putExtra(str, (String)paramMap.get(str));
    }
    if (paramInt != 0) {
      paramIntent.putExtra(z[37], paramInt);
    }
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    f.c(z[7], z[44] + paramInt);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = cn.jpush.android.d.e;
    }
    ((NotificationManager)localContext.getSystemService(z[10])).cancel(paramInt);
  }
  
  public static void b(Context paramContext, cn.jpush.android.data.c paramc)
  {
    f.a(z[7], z[22]);
    int j = a(paramc, 0);
    NotificationManager localNotificationManager;
    Object localObject1;
    int i;
    int k;
    String str3;
    String str4;
    String str5;
    String str1;
    HashMap localHashMap;
    if ((paramc.h) && (paramc.e))
    {
      localNotificationManager = (NotificationManager)paramContext.getSystemService(z[10]);
      if ((paramc instanceof h))
      {
        localObject1 = paramc.t;
        str2 = paramc.s;
        i = paramc.u;
        k = paramc.y;
        localObject2 = paramc.v;
        str3 = paramc.w;
        str4 = paramc.x;
        str5 = paramc.z;
        String str6 = paramc.l;
        if (!TextUtils.isEmpty(paramc.m)) {
          break label326;
        }
        str1 = paramContext.getPackageName();
        localHashMap = new HashMap();
        localHashMap.put(z[25], paramc.c);
        localHashMap.put(z[28], localObject1);
        if (!TextUtils.isEmpty(str2)) {
          localHashMap.put(z[21], str2);
        }
        if (!TextUtils.isEmpty(str6)) {
          localHashMap.put(z[30], str6);
        }
        if ((i != 1) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          break label335;
        }
        localHashMap.put(z[15], localObject2);
      }
    }
    for (;;)
    {
      if (k != 0) {
        localHashMap.put(z[33], k);
      }
      if (!TextUtils.isEmpty(str5)) {
        localHashMap.put(z[19], str5);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label399;
      }
      a(paramContext, localHashMap, 0, "", str1, paramc);
      return;
      label326:
      str1 = paramc.m;
      break;
      label335:
      if ((i == 2) && (!TextUtils.isEmpty(str4))) {
        localHashMap.put(z[24], str4);
      } else if ((i == 3) && (!TextUtils.isEmpty(str3))) {
        localHashMap.put(z[17], str3);
      }
    }
    label399:
    Object localObject2 = JPushInterface.b(paramc.f);
    String str2 = ((PushNotificationBuilder)localObject2).getDeveloperArg0();
    localObject2 = ((PushNotificationBuilder)localObject2).buildNotification(localHashMap);
    if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      if (!paramc.a())
      {
        f.d(z[7], z[27] + JCoreInterface.getRuningFlag());
        if (a.c(paramContext, PushReceiver.class.getCanonicalName()))
        {
          localObject1 = new Intent(z[29] + UUID.randomUUID().toString());
          ((Intent)localObject1).putExtra(z[32], paramc.g);
          if (JCoreInterface.getRuningFlag())
          {
            ((Intent)localObject1).setClass(paramContext, PopWinActivity.class);
            ((Intent)localObject1).putExtra(z[23], true);
            ((Intent)localObject1).putExtra(z[31], cn.jpush.android.d.a);
            a((Intent)localObject1, localHashMap, j);
            ((Intent)localObject1).putExtra(z[20], str1);
            if (!TextUtils.isEmpty(str2)) {
              ((Intent)localObject1).putExtra(z[4], str2);
            }
            if (!JCoreInterface.getRuningFlag()) {
              break label895;
            }
            localObject1 = PendingIntent.getActivity(paramContext, 0, (Intent)localObject1, 1073741824);
            label660:
            ((Notification)localObject2).contentIntent = ((PendingIntent)localObject1);
            if (!JPushInterface.a(paramc.f))
            {
              if (1 == paramc.g) {
                paramc.r = 1;
              }
              k = paramc.r;
              i = 1;
              switch (k)
              {
              }
            }
          }
        }
      }
      for (;;)
      {
        ((Notification)localObject2).flags = i;
        if (((Notification)localObject2).defaults == 0) {
          ((Notification)localObject2).defaults = 3;
        }
        if (a.d(paramContext)) {
          ((Notification)localObject2).defaults = 0;
        }
        if (localObject2 != null) {
          localNotificationManager.notify(j, (Notification)localObject2);
        }
        if (1 != paramc.g)
        {
          if (!cn.jpush.android.a.d.b(j)) {
            cn.jpush.android.a.d.a(j);
          }
          if (cn.jpush.android.a.d.b() > e.a(paramContext))
          {
            i = cn.jpush.android.a.d.a();
            if (i != 0) {
              b(paramContext, i);
            }
          }
          b.a(paramc.c, 1018, paramContext);
        }
        a(paramContext, localHashMap, j, str2, str1, paramc);
        return;
        ((Intent)localObject1).setClass(paramContext, PushReceiver.class);
        break;
        f.e(z[7], z[16]);
        localObject1 = new Intent(z[26]);
        ((Intent)localObject1).addCategory(str1);
        break;
        label895:
        localObject1 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject1, 1073741824);
        break label660;
        f.e(z[7], z[34] + ((h)paramc).J);
        if ((3 == ((h)paramc).J) || (4 == ((h)paramc).J) || (((h)paramc).J == 0)) {
          localObject1 = a.a(paramContext, paramc, false);
        }
        for (;;)
        {
          localObject1 = PendingIntent.getActivity(paramContext, j, (Intent)localObject1, 134217728);
          break;
          if (2 == ((h)paramc).J) {
            localObject1 = a.a(paramContext, paramc);
          } else {
            localObject1 = a.a(paramContext, paramc, false);
          }
        }
        i = 1;
        continue;
        i = 16;
        continue;
        i = 32;
      }
    }
    f.h(z[7], z[18]);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/api/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */