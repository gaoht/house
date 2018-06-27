package com.ziroom.ziroomcustomer.minsu.c;

import android.os.Handler;
import android.os.Looper;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean.TonightDiscountInfoVoBean;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
{
  private static c i;
  private static final Object j = new Object();
  private List<MinsuHouseBean.DataBean.ListBean> a;
  private Map<String, Long> b = new HashMap();
  private String c = "0";
  private List<String> d = new ArrayList();
  private a e;
  private a.a f;
  private Map<String, a.a> g = new HashMap();
  private Handler h = new Handler(Looper.getMainLooper());
  
  private c()
  {
    this.d.add("0");
    this.f = new a.a()
    {
      public void onCountDown(final long paramAnonymousLong)
      {
        final Object localObject3;
        synchronized ()
        {
          Iterator localIterator1 = c.a(c.this).entrySet().iterator();
          if (localIterator1.hasNext())
          {
            localObject3 = (Map.Entry)localIterator1.next();
            com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz_count", "  --- " + (((Long)((Map.Entry)localObject3).getValue()).longValue() + 1000L));
            c.a(c.this).put(((Map.Entry)localObject3).getKey(), Long.valueOf(((Long)((Map.Entry)localObject3).getValue()).longValue() + 1000L));
          }
        }
        if ((c.b(c.this) != null) && (c.c(c.this) != null))
        {
          Iterator localIterator2 = c.c(c.this).iterator();
          while (localIterator2.hasNext())
          {
            localObject3 = (String)localIterator2.next();
            localObject3 = (a.a)c.b(c.this).get(localObject3);
            if (localObject3 != null) {
              c.d(c.this).post(new Runnable()
              {
                public void run()
                {
                  localObject3.onCountDown(paramAnonymousLong);
                  com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz", " 回调 修改 +++ ui ts_help onCountDown --- ");
                }
              });
            }
          }
        }
      }
    };
    this.e = a.getInstance(this.f);
  }
  
  public static c getInstance()
  {
    if (i == null) {}
    synchronized (j)
    {
      if (i == null) {
        i = new c();
      }
      return i;
    }
  }
  
  public void addListener(String paramString, a.a parama)
  {
    synchronized (j)
    {
      this.g.put(paramString, parama);
      return;
    }
  }
  
  public long getTsDeadlineRemainTime(MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    Long localLong = (Long)this.b.get(String.valueOf(paramListBean.fid + paramListBean.rentWay));
    if (localLong != null)
    {
      if (paramListBean.tonightDiscountInfoVo != null)
      {
        long l = paramListBean.tonightDiscountInfoVo.getDeadlineRemainTime() - Math.abs(localLong.longValue());
        u.i("wz_count", "deadRT = " + paramListBean.tonightDiscountInfoVo.getDeadlineRemainTime() + " remainTime = " + localLong + " Math.abs(remainTime) = " + Math.abs(localLong.longValue()) + " result = " + l);
        return l;
      }
      u.e("wz error", "发生重要错误 活动结束剩余时间 1 ");
      return 0L;
    }
    u.e("wz error", "发生重要错误 活动结束剩余时间 2 ");
    if ((paramListBean != null) && (paramListBean.tonightDiscountInfoVo != null)) {
      return paramListBean.tonightDiscountInfoVo.getDeadlineRemainTime();
    }
    return 0L;
  }
  
  public long getTsRemainTime(MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    Long localLong = (Long)this.b.get(String.valueOf(paramListBean.fid + paramListBean.rentWay));
    if ((localLong != null) && (paramListBean != null) && (paramListBean.tonightDiscountInfoVo != null))
    {
      u.i("wz_count", "remainTime == " + localLong + " 原始 remain = " + paramListBean.tonightDiscountInfoVo.remainTime + " 原始 dead = " + paramListBean.tonightDiscountInfoVo.deadlineRemainTime + " 结果 = " + (paramListBean.tonightDiscountInfoVo.remainTime - localLong.longValue()));
      return paramListBean.tonightDiscountInfoVo.remainTime - localLong.longValue();
    }
    u.e("wz error", "发生重要错误 活动开始 剩余 时间");
    if ((paramListBean != null) && (paramListBean.tonightDiscountInfoVo != null)) {
      return paramListBean.tonightDiscountInfoVo.getRemainTime();
    }
    return 0L;
  }
  
  public void setCurrrent(String paramString)
  {
    synchronized (j)
    {
      this.c = paramString;
      return;
    }
  }
  
  public void setCurrrents(List<String> paramList)
  {
    synchronized (j)
    {
      this.d = paramList;
      return;
    }
  }
  
  public void start(List<MinsuHouseBean.DataBean.ListBean> paramList)
  {
    synchronized (j)
    {
      if ((this.a != null) && (this.a == paramList)) {
        return;
      }
      this.a = paramList;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MinsuHouseBean.DataBean.ListBean localListBean = (MinsuHouseBean.DataBean.ListBean)paramList.next();
        this.b.put(String.valueOf(localListBean.fid + localListBean.rentWay), Long.valueOf(0L));
        if (localListBean.tonightDiscountInfoVo == null) {
          u.e("wz", " 没有剩余 今夜特惠实体  " + String.valueOf(new StringBuilder().append(localListBean.fid).append(localListBean.rentWay).toString()));
        }
      }
    }
    this.e = a.getInstance(this.f);
    this.e.start();
  }
  
  public void stop()
  {
    synchronized (j)
    {
      if (this.e != null) {
        this.e.stop();
      }
      if (this.b != null) {
        this.b.clear();
      }
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */