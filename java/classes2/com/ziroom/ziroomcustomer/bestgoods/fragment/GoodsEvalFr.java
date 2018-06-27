package com.ziroom.ziroomcustomer.bestgoods.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.bestgoods.a.e;
import com.ziroom.ziroomcustomer.bestgoods.activity.GoodsDetailAc;
import com.ziroom.ziroomcustomer.bestgoods.model.h;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.newrepair.utils.c;
import com.ziroom.ziroomcustomer.widget.HouseListXListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsEvalFr
  extends BaseFragment
{
  public boolean a = true;
  private Context b;
  private WeakReference<GoodsDetailAc> c;
  private HouseListXListView d;
  private LinearLayout e;
  private e f;
  private List<h> g = new ArrayList();
  private String h;
  private int i;
  private b j;
  
  private void a(View paramView)
  {
    this.d = ((HouseListXListView)paramView.findViewById(2131694042));
    this.e = ((LinearLayout)paramView.findViewById(2131689998));
    paramView = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    paramView.height = this.i;
    this.e.setLayoutParams(paramView);
    if (this.j != null) {
      this.j.getScrollView(this.d);
    }
    this.d.setPullLoadEnable(false);
    this.d.setPullRefreshEnable(false);
    this.f = new e(this.b, this.g);
    this.d.setAdapter(this.f);
  }
  
  private void c()
  {
    showProgress("");
    HashMap localHashMap = new HashMap();
    localHashMap.put("productCode", this.h);
    localHashMap.put("page", "1");
    localHashMap.put("pageSize", "10000");
    j.getGoodsEvalList(getActivity(), localHashMap, new a(new com.ziroom.ziroomcustomer.newrepair.utils.a(h.class, false, "list")));
  }
  
  public static GoodsEvalFr newInstance(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("productCode", paramString);
    localBundle.putInt("height", paramInt);
    paramString = new GoodsEvalFr();
    paramString.setArguments(localBundle);
    Log.e("fragment", paramString.hashCode() + "");
    return paramString;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getActivity();
    this.c = new WeakReference((GoodsDetailAc)getActivity());
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.h = paramBundle.getString("productCode");
      this.i = paramBundle.getInt("height");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903914, paramViewGroup, false);
    a(paramLayoutInflater);
    if ((this.c != null) && (this.c.get() != null)) {
      ((GoodsDetailAc)this.c.get()).setObjectForPosition(paramLayoutInflater, 2);
    }
    return paramLayoutInflater;
  }
  
  public void setOnInitViewListener(b paramb)
  {
    this.j = paramb;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((paramBoolean) && ((this.g == null) || (this.g.size() == 0)))
    {
      if (checkNet(this.b)) {
        c();
      }
    }
    else {
      return;
    }
    showToast("网络不佳，请稍后再试");
  }
  
  class a
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public a(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      c.catchExp(paramThrowable);
      GoodsEvalFr.this.dismissProgress();
      GoodsEvalFr.this.showToast("请稍后再试");
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        GoodsEvalFr.a(GoodsEvalFr.this, (List)paraml.getObject());
        if ((GoodsEvalFr.a(GoodsEvalFr.this) != null) && (GoodsEvalFr.a(GoodsEvalFr.this).size() > 0))
        {
          GoodsEvalFr.b(GoodsEvalFr.this).setData(GoodsEvalFr.a(GoodsEvalFr.this));
          GoodsEvalFr.b(GoodsEvalFr.this).notifyDataSetChanged();
        }
      }
      for (;;)
      {
        GoodsEvalFr.this.dismissProgress();
        return;
        GoodsEvalFr.this.showToast("暂无评价信息");
        continue;
        paraml = paraml.getMessage();
        if (paraml != null) {
          GoodsEvalFr.this.showToast(paraml);
        } else {
          GoodsEvalFr.this.showToast("请稍后再试");
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void getScrollView(HouseListXListView paramHouseListXListView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/fragment/GoodsEvalFr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */