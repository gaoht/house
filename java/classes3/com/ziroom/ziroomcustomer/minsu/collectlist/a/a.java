package com.ziroom.ziroomcustomer.minsu.collectlist.a;

import android.app.Activity;
import com.ziroom.ziroomcustomer.flux.b;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCollectListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;

public class a
{
  private static a b;
  private static final Object c = new Object();
  final b a;
  
  private a(b paramb)
  {
    this.a = paramb;
  }
  
  public static a getInstance(b paramb)
  {
    if (b == null) {}
    synchronized (c)
    {
      if (b == null) {
        b = new a(paramb);
      }
      return b;
    }
  }
  
  public void cancelCollectHouse(final Object paramObject, Activity paramActivity, MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.cancelCollectHouse(paramActivity, paramListBean.fid, paramListBean.rentWay, new s(paramActivity, new r(MinsuHouseCancelCollectResultBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("cancel_collect_house_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseCancelCollectResultBean paramAnonymousMinsuHouseCancelCollectResultBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuHouseCancelCollectResultBean);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("cancel_collect_house", paramAnonymousMinsuHouseCancelCollectResultBean), paramObject);
      }
    });
  }
  
  public void collectHouse(final Object paramObject, Activity paramActivity, MinsuHouseBean.DataBean.ListBean paramListBean)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.collectHouse(paramActivity, paramListBean.fid, paramListBean.rentWay, new s(paramActivity, new r(MinsuHouseCollectResultBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("collect_house_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuHouseCollectResultBean paramAnonymousMinsuHouseCollectResultBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuHouseCollectResultBean);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("collect_house", paramAnonymousMinsuHouseCollectResultBean), paramObject);
      }
    });
  }
  
  public void getCollectList(final Object paramObject, Activity paramActivity, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getCollectList(paramActivity, paramInt, new s(paramActivity, new r(MinsuCollectListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("get_collect_list_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuCollectListBean paramAnonymousMinsuCollectListBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuCollectListBean);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("get_collect_list", paramAnonymousMinsuCollectListBean), paramObject);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/collectlist/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */