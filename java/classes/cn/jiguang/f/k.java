package cn.jiguang.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.c.a;
import cn.jiguang.d.d;
import java.util.ArrayList;
import java.util.List;

public final class k
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[15];
    int j = 0;
    Object localObject2 = "yD>fZ^o<DzOK2";
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
        i = 15;
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
        localObject2 = "zJup{OW!#LAH%laKK!9/";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "OF!j`@\005x#iGI!f}\016D9o/jD0n`@v0qyGF0";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "MK{i[V=-n@A'lfJ\013<m{KK!-KO@8la}@'ufM@";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "hD<o/ZJup{OW!#`ZM0q/OU%#lOP&fk\016G,#@[Q\032eBKH:qv\000";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "]Q4q{aQ=f}oU%Pj\\S<`j\016C4jcKAy`n@i4vaMM0g\\ZJ%sjJv0qyGF0#f]\0053bc]@";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "oF!j`@\005x#|ZD'w@ZM0qN^U\006f}XL6f";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\000U0qbGV&j`@\013\037SZ}m\nNJ}v\024DJ";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "mD;#aAQudjZ\0054sBL6b{GJ;#f@C:#xGQ=#OF>bhK\005;bbK\005o#";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "@P9o";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "\000\0054sE@,9";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "uF=flEr=f{F@'W`}Q4q{s\005x#KW8j|]L:m5";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "\000\005\005v|Fv0qyGF09";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "MK{i[V=-n@A'lfJ\013&f}XL6f!~P&k\\KW#jlK";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "du\000PGqd\005SDk|";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 46;
        continue;
        i = 37;
        continue;
        i = 85;
        continue;
        i = 3;
      }
    }
  }
  
  public static List<ComponentName> a(Context paramContext)
  {
    d.c(z[0], z[2]);
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getPackageManager();
    Object localObject = new Intent();
    ((Intent)localObject).setAction(z[3]);
    localObject = paramContext.queryIntentServices((Intent)localObject, 0);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    int i = 0;
    while (i < ((List)localObject).size())
    {
      ServiceInfo localServiceInfo = ((ResolveInfo)((List)localObject).get(i)).serviceInfo;
      String str1 = localServiceInfo.name;
      String str2 = localServiceInfo.packageName;
      if ((str1 != null) && (str2 != null) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (localServiceInfo.exported) && (localServiceInfo.enabled) && (!a.c.equals(str2)) && (a(paramContext, str2)))
      {
        d.c(z[0], z[1] + str2 + "/" + str1 + "}");
        localArrayList.add(new ComponentName(str2, str1));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    if (!a.l)
    {
      d.c(z[0], z[5]);
      return;
    }
    try
    {
      d.c(z[0], z[6]);
      new Thread(new l(paramLong, paramContext)).start();
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      d.g(z[0], z[4]);
    }
  }
  
  private static boolean a(PackageManager paramPackageManager, String paramString)
  {
    try
    {
      int i = paramPackageManager.checkPermission(paramString + z[7], paramString);
      String str1 = paramPackageManager.getApplicationInfo(paramString, 128).metaData.getString(z[14]);
      Object localObject = new Intent();
      ((Intent)localObject).setClassName(paramString, z[13]);
      localObject = paramPackageManager.queryIntentServices((Intent)localObject, 0);
      String str2 = z[0];
      StringBuilder localStringBuilder = new StringBuilder(z[11]).append(i).append(z[10]).append(str1).append(z[12]);
      if (localObject == null) {}
      int j;
      for (paramPackageManager = z[9];; paramPackageManager = Integer.valueOf(j))
      {
        d.e(str2, paramPackageManager);
        if ((i != 0) || (localObject == null) || (((List)localObject).size() == 0) || (TextUtils.isEmpty(str1)) || (str1.length() != 24)) {
          break;
        }
        return true;
        j = ((List)localObject).size();
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramPackageManager)
    {
      d.g(z[0], z[8] + paramString);
      return false;
    }
    catch (Exception paramPackageManager)
    {
      paramPackageManager.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/f/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */