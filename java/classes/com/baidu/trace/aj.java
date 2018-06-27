package com.baidu.trace;

import android.content.Context;
import android.os.Handler;
import com.baidu.trace.api.fence.CircleFence;
import com.baidu.trace.api.fence.Fence;
import com.baidu.trace.api.fence.MonitoredAction;
import com.baidu.trace.api.fence.MonitoredStatus;
import com.baidu.trace.api.fence.MonitoredStatusInfo;
import com.baidu.trace.c.e;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class aj
{
  private Map<Long, Fence> a = new ConcurrentHashMap();
  private Map<Long, MonitoredStatus> b = new ConcurrentHashMap();
  private bi c;
  
  public aj(Context paramContext)
  {
    try
    {
      paramContext = new File("/data/data/" + e.c(paramContext) + "/shared_prefs", "fenceStatus.xml");
      if (paramContext.exists()) {
        paramContext.delete();
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void a(CircleFence paramCircleFence, bi parambi, MonitoredAction paramMonitoredAction, Handler paramHandler)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    try
    {
      localJSONObject1.put("fence_id", paramCircleFence.getFenceId());
      localJSONObject1.put("fence", paramCircleFence.getFenceName());
      localJSONObject1.put("monitored_person", paramCircleFence.getMonitoredPerson());
      localJSONObject1.put("action", paramMonitoredAction.name());
      localJSONObject2.put("time", e.b());
      localJSONObject2.put("latitude", parambi.getLocation().latitude);
      localJSONObject2.put("longitude", parambi.getLocation().longitude);
      localJSONObject2.put("radius", parambi.getRadius());
      localJSONObject2.put("coord_type", CoordType.bd09ll.name());
      localJSONObject1.put("cur_point", localJSONObject2);
      if (this.c == null) {
        this.c = parambi;
      }
      localJSONObject3.put("time", this.c.getLocTime());
      localJSONObject3.put("latitude", this.c.getLocation().latitude);
      localJSONObject3.put("longitude", this.c.getLocation().longitude);
      localJSONObject3.put("radius", this.c.getRadius());
      localJSONObject3.put("coord_type", CoordType.bd09ll.name());
      localJSONObject1.put("pre_point", localJSONObject3);
      am.a(paramCircleFence, paramMonitoredAction, localJSONObject2.toString(), localJSONObject3.toString());
      paramCircleFence = paramHandler.obtainMessage(163);
      paramCircleFence.obj = localJSONObject1.toString();
      paramHandler.sendMessage(paramCircleFence);
      return;
    }
    catch (JSONException paramCircleFence) {}
  }
  
  private void b(long paramLong, MonitoredStatus paramMonitoredStatus)
  {
    this.b.put(Long.valueOf(paramLong), paramMonitoredStatus);
    am.a(paramLong, paramMonitoredStatus);
  }
  
  protected final void a(long paramLong)
  {
    try
    {
      this.a.remove(Long.valueOf(paramLong));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected final void a(long paramLong, Fence paramFence)
  {
    try
    {
      this.a.put(Long.valueOf(paramLong), paramFence);
      return;
    }
    finally
    {
      paramFence = finally;
      throw paramFence;
    }
  }
  
  protected final void a(long paramLong, MonitoredStatus paramMonitoredStatus)
  {
    try
    {
      this.b.put(Long.valueOf(paramLong), paramMonitoredStatus);
      return;
    }
    finally
    {
      paramMonitoredStatus = finally;
      throw paramMonitoredStatus;
    }
  }
  
  protected final void a(bi parambi, Handler paramHandler)
  {
    for (;;)
    {
      Object localObject;
      CircleFence localCircleFence;
      try
      {
        Iterator localIterator = this.a.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Fence)localIterator.next();
        if (!(localObject instanceof CircleFence)) {
          continue;
        }
        localCircleFence = (CircleFence)localObject;
        if ((!z.c.equals(localCircleFence.getMonitoredPerson())) || ((localCircleFence.getDenoise() > 0) && (parambi.getRadius() > localCircleFence.getDenoise()))) {
          continue;
        }
        LatLng localLatLng = localCircleFence.getCenter();
        localObject = MonitoredStatus.unknown;
        if (this.b.containsKey(Long.valueOf(localCircleFence.getFenceId()))) {
          localObject = (MonitoredStatus)this.b.get(Long.valueOf(localCircleFence.getFenceId()));
        }
        double d = e.a(localLatLng, parambi.getLocation());
        if (localCircleFence.getRadius() > d)
        {
          if ((MonitoredStatus.unknown != localObject) && (MonitoredStatus.out != localObject)) {
            continue;
          }
          b(localCircleFence.getFenceId(), MonitoredStatus.in);
          if (MonitoredStatus.out != localObject) {
            continue;
          }
          a(localCircleFence, parambi, MonitoredAction.enter, paramHandler);
          continue;
        }
        if (MonitoredStatus.in != localObject) {
          break label254;
        }
      }
      finally {}
      b(localCircleFence.getFenceId(), MonitoredStatus.out);
      a(localCircleFence, parambi, MonitoredAction.exit, paramHandler);
      continue;
      label254:
      if (MonitoredStatus.unknown == localObject) {
        b(localCircleFence.getFenceId(), MonitoredStatus.out);
      }
    }
    this.c = parambi;
  }
  
  protected final void a(String paramString, LatLng paramLatLng, List<MonitoredStatusInfo> paramList)
  {
    try
    {
      Iterator localIterator = this.a.values().iterator();
      while (localIterator.hasNext()) {
        a.a((Fence)localIterator.next(), paramString, paramLatLng, paramList);
      }
    }
    finally {}
  }
  
  /* Error */
  protected final boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/baidu/trace/aj:a	Ljava/util/Map;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 23	com/baidu/trace/aj:a	Ljava/util/Map;
    //   13: invokeinterface 274 1 0
    //   18: istore_1
    //   19: iload_1
    //   20: ifeq +9 -> 29
    //   23: iconst_1
    //   24: istore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_1
    //   31: goto -6 -> 25
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	aj
    //   18	13	1	bool	boolean
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	34	finally
  }
  
  /* Error */
  protected final Fence b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/baidu/trace/aj:a	Ljava/util/Map;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +9 -> 17
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_3
    //   16: areturn
    //   17: aload_0
    //   18: getfield 23	com/baidu/trace/aj:a	Ljava/util/Map;
    //   21: lload_1
    //   22: invokestatic 177	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   25: invokeinterface 242 2 0
    //   30: checkcast 212	com/baidu/trace/api/fence/Fence
    //   33: astore_3
    //   34: goto -21 -> 13
    //   37: astore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	aj
    //   0	42	1	paramLong	long
    //   6	28	3	localObject1	Object
    //   37	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   17	34	37	finally
  }
  
  protected final void b()
  {
    try
    {
      c();
      this.a = null;
      this.b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected final void c()
  {
    try
    {
      if (this.a != null) {
        this.a.clear();
      }
      if (this.b != null) {
        this.b.clear();
      }
      return;
    }
    finally {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */