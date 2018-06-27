package com.ziroom.datacenter.remote.e;

import android.content.Context;
import java.util.Map;

public class a
{
  public static void getHttpAppID(Context paramContext, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.a.a> parama)
  {
    parama = new a.1(new com.ziroom.commonlib.ziroomhttp.f.c(com.ziroom.datacenter.remote.responsebody.a.a.class), parama);
    Map localMap = com.ziroom.datacenter.c.b.buildGetAppIDMap(paramContext);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(com.ziroom.datacenter.remote.f.b.k);
    localStringBuffer.append(com.ziroom.datacenter.remote.f.a.a);
    com.ziroom.commonlib.ziroomhttp.a.post(localStringBuffer.toString()).params(localMap).tag(paramContext).enqueue(parama);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/datacenter/remote/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */