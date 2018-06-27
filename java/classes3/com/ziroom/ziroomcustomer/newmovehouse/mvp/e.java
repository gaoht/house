package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.content.Context;
import com.freelxl.baselibrary.d.f.a;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecModel;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecResultRequestModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class e
  implements b.a
{
  private WeakReference<b.b> a;
  private HashMap<String, MoveRecResultRequestModel> b = new HashMap();
  
  public e(MoveRecActivity paramMoveRecActivity)
  {
    this.a = new WeakReference(paramMoveRecActivity);
    paramMoveRecActivity = getView();
    if (paramMoveRecActivity != null) {
      paramMoveRecActivity.setPresenter(this);
    }
  }
  
  private void a()
  {
    n.requestMoveRecSub(getView().getViewContext(), new d(getView().getViewContext(), new com.ziroom.ziroomcustomer.e.c.e(MoveRecModel.class))
    {
      public void onSuccess(int paramAnonymousInt, List<MoveRecModel> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        try
        {
          e.a(e.this, paramAnonymousList);
          return;
        }
        catch (Exception paramAnonymousList)
        {
          g.textToast(e.this.getView().getViewContext(), "服务器请求异常！");
        }
      }
    });
  }
  
  private void a(List<MoveRecModel> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1))
    {
      g.textToast(getView().getViewContext(), "服务器请求异常！");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add(MoveRecFragment.newInstance(i + 1, paramList.size(), (MoveRecModel)paramList.get(i)));
      i += 1;
    }
    getView().initViewPager(localArrayList);
  }
  
  public void detachView()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public List<MoveRecResultRequestModel> getOptions(MoveRecResultRequestModel paramMoveRecResultRequestModel)
  {
    this.b.put(paramMoveRecResultRequestModel.num, paramMoveRecResultRequestModel);
    paramMoveRecResultRequestModel = new ArrayList();
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramMoveRecResultRequestModel.add(((Map.Entry)localIterator.next()).getValue());
    }
    return paramMoveRecResultRequestModel;
  }
  
  public b.b getView()
  {
    if (this.a != null) {
      return (b.b)this.a.get();
    }
    return null;
  }
  
  public void start()
  {
    if ((getView() == null) || (!getView().isActive())) {
      return;
    }
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */