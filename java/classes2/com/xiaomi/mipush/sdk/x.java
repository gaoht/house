package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.push.service.ah;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.e;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class x
{
  public static void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("mipush_extra", 0);
    long l1 = localSharedPreferences.getLong("last_sync_info", -1L);
    long l2 = System.currentTimeMillis() / 1000L;
    long l3 = ah.a(paramContext).a(e.B.a(), 1209600);
    if (l1 == -1L) {
      localSharedPreferences.edit().putLong("last_sync_info", l2).commit();
    }
    while (Math.abs(l2 - l1) <= l3) {
      return;
    }
    a(paramContext, true);
    localSharedPreferences.edit().putLong("last_sync_info", l2).commit();
  }
  
  public static void a(Context paramContext, ae paramae)
  {
    com.xiaomi.channel.commonutils.logger.b.a("need to update local info with: " + paramae.i());
    Object localObject = (String)paramae.i().get("accept_time");
    if (localObject != null)
    {
      MiPushClient.removeAcceptTime(paramContext);
      localObject = ((String)localObject).split("-");
      if (localObject.length == 2)
      {
        MiPushClient.addAcceptTime(paramContext, localObject[0], localObject[1]);
        if ((!"00:00".equals(localObject[0])) || (!"00:00".equals(localObject[1]))) {
          break label180;
        }
        a.a(paramContext).a(true);
      }
    }
    int j;
    int i;
    for (;;)
    {
      localObject = (String)paramae.i().get("aliases");
      if (localObject == null) {
        break;
      }
      MiPushClient.removeAllAliases(paramContext);
      if ("".equals(localObject)) {
        break;
      }
      localObject = ((String)localObject).split(",");
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        MiPushClient.addAlias(paramContext, localObject[i]);
        i += 1;
      }
      label180:
      a.a(paramContext).a(false);
    }
    localObject = (String)paramae.i().get("topics");
    if (localObject != null)
    {
      MiPushClient.removeAllTopics(paramContext);
      if (!"".equals(localObject))
      {
        localObject = ((String)localObject).split(",");
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          MiPushClient.addTopic(paramContext, localObject[i]);
          i += 1;
        }
      }
    }
    paramae = (String)paramae.i().get("user_accounts");
    if (paramae != null)
    {
      MiPushClient.removeAllAccounts(paramContext);
      if (!"".equals(paramae))
      {
        paramae = paramae.split(",");
        j = paramae.length;
        i = 0;
        while (i < j)
        {
          MiPushClient.addAccount(paramContext, paramae[i]);
          i += 1;
        }
      }
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    f.a(paramContext).a(new y(paramContext, paramBoolean));
  }
  
  private static String c(List<String> paramList)
  {
    paramList = d.a(d(paramList));
    if ((TextUtils.isEmpty(paramList)) || (paramList.length() <= 4)) {
      return "";
    }
    return paramList.substring(0, 4).toLowerCase();
  }
  
  private static String d(List<String> paramList)
  {
    if (com.xiaomi.channel.commonutils.misc.b.a(paramList))
    {
      localObject = "";
      return (String)localObject;
    }
    Object localObject = new ArrayList(paramList);
    Collections.sort((List)localObject, Collator.getInstance(Locale.CHINA));
    paramList = "";
    Iterator localIterator = ((List)localObject).iterator();
    for (;;)
    {
      localObject = paramList;
      if (!localIterator.hasNext()) {
        break;
      }
      String str = (String)localIterator.next();
      localObject = paramList;
      if (!TextUtils.isEmpty(paramList)) {
        localObject = paramList + ",";
      }
      paramList = (String)localObject + str;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/mipush/sdk/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */