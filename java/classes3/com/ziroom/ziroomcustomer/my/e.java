package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import com.freelxl.baselibrary.d.f.a;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.my.model.MyRentEvaluateListEntity;
import java.lang.ref.WeakReference;
import java.util.List;

public class e
  implements d.a
{
  private WeakReference<d.b> a;
  
  public e(d.b paramb)
  {
    this.a = new WeakReference(paramb);
    paramb = getView();
    if (paramb != null) {
      paramb.setPresenter(this);
    }
  }
  
  public void detachView() {}
  
  public void getData()
  {
    j.getRentEvaluateList(getView().getViewContext(), new com.ziroom.ziroomcustomer.e.a.c(getView().getViewContext(), new l(MyRentEvaluateListEntity.class, new com.ziroom.ziroomcustomer.e.c.a.c()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        paramAnonymousThrowable = e.this.getView();
        if ((paramAnonymousThrowable != null) && (paramAnonymousThrowable.isActive())) {
          paramAnonymousThrowable.showError(true, "网络不佳，请点击图片进行刷新");
        }
      }
      
      public void onSuccess(int paramAnonymousInt, List<MyRentEvaluateListEntity> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        d.b localb = e.this.getView();
        if ((localb != null) && (localb.isActive()))
        {
          localb.showError(false, "网络不佳，请点击图片进行刷新");
          localb.setAdapter(paramAnonymousList);
        }
      }
    });
  }
  
  public d.b getView()
  {
    if (this.a != null) {
      return (d.b)this.a.get();
    }
    return null;
  }
  
  public void start() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */