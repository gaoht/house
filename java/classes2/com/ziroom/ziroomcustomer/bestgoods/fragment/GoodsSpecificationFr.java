package com.ziroom.ziroomcustomer.bestgoods.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.bestgoods.a.i;
import com.ziroom.ziroomcustomer.bestgoods.activity.GoodsDetailAc;
import com.ziroom.ziroomcustomer.bestgoods.model.GoodsParamsMo;
import com.ziroom.ziroomcustomer.bestgoods.widget.ScrollGridLayoutManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class GoodsSpecificationFr
  extends BaseFragment
{
  public boolean a = true;
  private Context b;
  private WeakReference<GoodsDetailAc> c;
  private RecyclerView d;
  private LinearLayout e;
  private ArrayList<GoodsParamsMo> f;
  private int g;
  private a h;
  
  private void a(View paramView)
  {
    this.d = ((RecyclerView)paramView.findViewById(2131694037));
    this.d.setLayoutManager(new ScrollGridLayoutManager(this.b, 2, 1, false));
    this.e = ((LinearLayout)paramView.findViewById(2131689998));
    paramView = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    paramView.height = this.g;
    this.e.setLayoutParams(paramView);
    if (this.h != null) {
      this.h.getScrollView(this.d);
    }
    this.d.setAdapter(new i(this.b, this.f));
  }
  
  public static GoodsSpecificationFr newInstance(ArrayList<GoodsParamsMo> paramArrayList, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("goodsParamses", paramArrayList);
    localBundle.putInt("height", paramInt);
    paramArrayList = new GoodsSpecificationFr();
    paramArrayList.setArguments(localBundle);
    Log.e("fragment", paramArrayList.hashCode() + "");
    return paramArrayList;
  }
  
  public void initData(boolean paramBoolean)
  {
    if (this.b == null) {}
    while (!paramBoolean) {
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getActivity();
    this.c = new WeakReference((GoodsDetailAc)getActivity());
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.g = paramBundle.getInt("height");
      this.f = paramBundle.getParcelableArrayList("goodsParamses");
      if (this.f == null) {
        this.f = new ArrayList();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903912, paramViewGroup, false);
    a(paramLayoutInflater);
    if ((this.c != null) && (this.c.get() != null)) {
      ((GoodsDetailAc)this.c.get()).setObjectForPosition(paramLayoutInflater, 1);
    }
    return paramLayoutInflater;
  }
  
  public void setOnInitViewListener(a parama)
  {
    this.h = parama;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((this.a) && (paramBoolean)) {
      this.a = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void getScrollView(RecyclerView paramRecyclerView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/fragment/GoodsSpecificationFr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */