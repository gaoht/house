package cn.jpush.android.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.c.f;
import cn.jpush.android.c.h;
import cn.jpush.android.d;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.service.TagAliasOperator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  private static ConcurrentLinkedQueue<Long> a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[25];
    int j = 0;
    Object localObject2 = "梛洚刈彔刔泺杘罩绛せ欿勹佤封坱杒缀绤旱膳勳纶绕扠蠕す";
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
        i = 89;
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
        localObject2 = "/0_'878Yty)8\\'d{";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\0170_F520KO<7!]u";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "\025\004tKy8>Vs<#%";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "1!Mt1\t4Ir<(%pb5+4J'0(qVr57p";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "wqLf>(k";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "\022?Nf525\030s8<\"\024'.2=T'74%\030t</qLf>(qLo0(qLn4>";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "wqOn57qVh-{\"]sy:=Qf*{%Pn*{%Qj<u";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "\025\004tKy:=Qf*{0Vcy/0_tw{\026Qq<{$H'88%Qh7u";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "(4L'-:6K(878Yty/>W'*4>V+6-4J'hkqLn4>\"\030n7{`\bt";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "(4IX0?";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "/0_t";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = ":=Qf*";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "/0_f520K'<#2]w-2>V=";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "\0179]'5>?_s1{>^'-:6K'*3>Mk={3]'5>\"K'-30V'nka\b';\"%]tw";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = ":2Ln65kKb-\032=Qf*\032?\\S8<\"\030*y:=Qf*a";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "\022?Nf525\030f520K=y";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "/0_ty74V`-3k";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "\022?Nf525\030s8<k\030";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "\022?Nf525\030s8<q\002'";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "\0179]'5>?_o-{>^'-:6K'4:(Zby6>Jby/9Yiyja\b7w";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "\025>Ln?\"\005Y`\03078Yt\034)#Wuc";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "8?\026m).\"P)855Jh0?Qi->?L)\r\032\026gF\025\022\020kX\032\032\035tE\030\030\032";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "/0_f520KX<)#Wu:45]";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "/0_f520KX*> Qc";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = new ConcurrentLinkedQueue();
        return;
        i = 91;
        continue;
        i = 81;
        continue;
        i = 56;
        continue;
        i = 7;
      }
    }
  }
  
  public static Set<String> a(Set<String> paramSet)
  {
    if (paramSet == null) {
      localObject = null;
    }
    do
    {
      return (Set<String>)localObject;
      localObject = paramSet;
    } while (paramSet.isEmpty());
    Object localObject = new LinkedHashSet();
    paramSet = paramSet.iterator();
    int i = 0;
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if ((!TextUtils.isEmpty(str)) && (h.a(str)))
      {
        ((Set)localObject).add(str);
        int j = i + 1;
        i = j;
        if (j >= 1000)
        {
          f.h(z[2], z[20]);
          return (Set<String>)localObject;
        }
      }
      else
      {
        f.j(z[2], z[19] + str);
      }
    }
    return (Set<String>)localObject;
  }
  
  private static void a(Context paramContext, int paramInt, long paramLong)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.addCategory(d.c);
      localIntent.setAction(z[22]);
      localIntent.putExtra(z[23], paramInt);
      localIntent.putExtra(z[24], paramLong);
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      f.h(z[2], z[21] + paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle, c paramc)
  {
    int j = 0;
    String str = paramBundle.getString(z[12]);
    Object localObject = paramBundle.getStringArrayList(z[11]);
    long l = paramBundle.getLong(z[10], 0L);
    paramBundle = null;
    if (localObject != null) {
      paramBundle = new HashSet((Collection)localObject);
    }
    if (!a(System.currentTimeMillis()))
    {
      f.g(z[2], z[9]);
      a(paramContext, cn.jpush.android.api.b.k, l);
      return;
    }
    if (str != null)
    {
      i = h.b(str);
      if (i != 0)
      {
        f.d(z[2], z[16] + str + z[7]);
        a(paramContext, i, l);
        return;
      }
    }
    if (paramBundle != null)
    {
      i = h.a(paramBundle);
      if (i != 0)
      {
        f.d(z[2], z[6]);
        a(paramContext, i, l);
        return;
      }
    }
    paramBundle = b(paramBundle);
    if ((str == null) && (paramBundle == null))
    {
      f.j(z[2], z[8]);
      a(paramContext, cn.jpush.android.api.b.a, l);
      return;
    }
    if (paramBundle != null)
    {
      localObject = paramBundle.replaceAll(",", "");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label484;
      }
    }
    label484:
    for (int i = ((String)localObject).getBytes().length + 0;; i = 0)
    {
      f.a(z[2], z[17] + i);
      if (i <= 7000) {
        j = 1;
      }
      if (j == 0)
      {
        a(paramContext, cn.jpush.android.api.b.h, l);
        f.h(z[2], z[14]);
        return;
      }
      f.d(z[2], z[15] + str + z[5] + paramBundle);
      paramContext = new JSONObject();
      if (str != null) {}
      try
      {
        paramContext.put(z[12], str);
        if (paramBundle != null) {
          paramContext.put(z[11], paramBundle);
        }
        paramContext = paramContext.toString();
        paramContext = new cn.jpush.a.b(l, JCoreInterface.getAppKey(), paramContext);
        if (paramc != null)
        {
          paramc.a(paramContext, 20000);
          return;
        }
      }
      catch (JSONException paramContext)
      {
        f.g(z[2], z[13] + paramContext.getMessage());
        return;
      }
      f.i(z[2], z[4]);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, Set<String> paramSet, TagAliasCallback paramTagAliasCallback)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException(z[3]);
    }
    if ((JCoreInterface.getDebugMode()) && (!cn.jpush.android.c.a.a(paramContext))) {
      f.d(z[2], z[0]);
    }
    cn.jpush.android.api.a locala = new cn.jpush.android.api.a(paramString, paramSet, paramTagAliasCallback);
    if (ServiceInterface.d(paramContext)) {
      if ((locala != null) && (locala.c != null)) {
        locala.c.gotResult(cn.jpush.android.api.b.l, locala.a, locala.b);
      }
    }
    do
    {
      return;
      paramTagAliasCallback = paramContext;
      if (!(paramContext instanceof Application)) {
        paramTagAliasCallback = paramContext.getApplicationContext();
      }
      if (d.a(paramTagAliasCallback)) {
        break;
      }
    } while ((locala == null) || (locala.c == null));
    locala.c.gotResult(cn.jpush.android.api.b.i, locala.a, locala.b);
    return;
    long l = JCoreInterface.getNextRid();
    if ((locala != null) && (locala.c != null)) {
      TagAliasOperator.a().a(Long.valueOf(l), locala);
    }
    f.e(z[2], z[1] + l);
    TagAliasOperator.a().a(paramTagAliasCallback);
    paramContext = null;
    if (paramSet != null) {
      paramContext = new ArrayList(paramSet);
    }
    ServiceInterface.a(paramTagAliasCallback, paramString, paramContext, l);
  }
  
  private static boolean a(long paramLong)
  {
    if (a.size() < 10)
    {
      a.offer(Long.valueOf(paramLong));
      return true;
    }
    if (paramLong - ((Long)a.element()).longValue() > 10000L)
    {
      while (a.size() >= 10) {
        a.poll();
      }
      a.offer(Long.valueOf(paramLong));
      return true;
    }
    return false;
  }
  
  public static String b(Set<String> paramSet)
  {
    Object localObject = null;
    Iterator localIterator = null;
    if (paramSet == null) {
      localObject = localIterator;
    }
    int i;
    label76:
    do
    {
      do
      {
        return (String)localObject;
        if (paramSet.isEmpty()) {
          return "";
        }
        i = 0;
        localIterator = paramSet.iterator();
        paramSet = (Set<String>)localObject;
        localObject = paramSet;
      } while (!localIterator.hasNext());
      localObject = (String)localIterator.next();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!h.a((String)localObject))) {
        break label119;
      }
      if (paramSet != null) {
        break;
      }
      paramSet = (Set<String>)localObject;
      i += 1;
      localObject = paramSet;
    } while (i >= 1000);
    for (;;)
    {
      break;
      paramSet = paramSet + "," + (String)localObject;
      break label76;
      label119:
      f.j(z[2], z[18] + (String)localObject);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */