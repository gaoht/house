package com.ziroom.ziroomcustomer.service;

import android.content.Context;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.b.c;
import com.ziroom.ziroomcustomer.e.k;
import com.ziroom.ziroomcustomer.e.q;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class f
{
  private static e a(Map<String, Object> paramMap)
  {
    e locale = new e();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      locale.put((String)localEntry.getKey(), localEntry.getValue());
    }
    return locale;
  }
  
  public static void deleteMsgs(Context paramContext, com.freelxl.baselibrary.d.c.a<e> parama, Map<String, Object> paramMap)
  {
    k.requestGateWayService(paramContext, q.o + g.k, a(paramMap), parama, false);
  }
  
  public static void getSupportList(Context paramContext, com.freelxl.baselibrary.d.c.a<e> parama, Map<String, Object> paramMap)
  {
    k.requestGateWayService(paramContext, q.o + g.g, a(paramMap), parama, false);
  }
  
  public static void getUnreadNum(Context paramContext, com.freelxl.baselibrary.d.c.a<e> parama, Map<String, Object> paramMap)
  {
    k.requestGateWayService(paramContext, q.o + g.j, a(paramMap), parama, false);
  }
  
  public static void sendBroadcastDeal(com.freelxl.baselibrary.d.c.a<e> parama, Map<String, String> paramMap) {}
  
  public static void sendBroadcastRece(com.freelxl.baselibrary.d.c.a<e> parama, Map<String, String> paramMap) {}
  
  public static void sendDeviceInfo(com.freelxl.baselibrary.d.c.a<e> parama, Map<String, String> paramMap)
  {
    com.freelxl.baselibrary.d.a.post(q.Z + g.a).tag("push_feedback").params(paramMap).enqueue(parama);
  }
  
  public static void sendFeedBackDeal(com.freelxl.baselibrary.d.c.a<e> parama, Map<String, String> paramMap)
  {
    com.freelxl.baselibrary.d.a.post(q.Z + g.c).tag("push_feedback").params(paramMap).enqueue(parama);
  }
  
  public static void sendFeedBackRece(com.freelxl.baselibrary.d.c.a<e> parama, Map<String, String> paramMap)
  {
    com.freelxl.baselibrary.d.a.post(q.Z + g.b).tag("push_feedback").params(paramMap).enqueue(parama);
  }
  
  public static void setHuaWeiBind(Context paramContext, com.freelxl.baselibrary.d.c.a<e> parama, Map<String, Object> paramMap)
  {
    k.requestGateWayService(paramContext, q.o + g.h, a(paramMap), parama, false);
  }
  
  public static void setHuaWeiUnbind(Context paramContext, com.freelxl.baselibrary.d.c.a<e> parama, Map<String, Object> paramMap)
  {
    k.requestGateWayService(paramContext, q.o + g.i, a(paramMap), parama, false);
  }
  
  public static void syncMessages(Context paramContext, com.freelxl.baselibrary.d.c.a parama, Map<String, Object> paramMap)
  {
    k.requestGateWayService(paramContext, q.o + g.f, a(paramMap), parama, false);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/service/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */