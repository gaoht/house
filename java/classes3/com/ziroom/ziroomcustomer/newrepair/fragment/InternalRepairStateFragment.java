package com.ziroom.ziroomcustomer.newrepair.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.newrepair.a.j;
import com.ziroom.ziroomcustomer.newrepair.b.d;
import com.ziroom.ziroomcustomer.newrepair.widget.ZiScroListView;
import java.util.List;

public class InternalRepairStateFragment
  extends BaseFragment
{
  private static InternalRepairStateFragment f;
  private static final Object g = new Object();
  private Context a;
  private View b;
  private LinearLayout c;
  private ZiScroListView d;
  private j e;
  
  private void c()
  {
    this.c = ((LinearLayout)this.b.findViewById(2131689998));
    this.d = ((ZiScroListView)this.b.findViewById(2131694149));
  }
  
  public static InternalRepairStateFragment getInstance()
  {
    synchronized (g)
    {
      if (f == null) {
        f = new InternalRepairStateFragment();
      }
      InternalRepairStateFragment localInternalRepairStateFragment = f;
      return localInternalRepairStateFragment;
    }
  }
  
  public void initData(String paramString, List<d> paramList)
  {
    this.e = new j(this.a, paramList, "");
    this.d.setAdapter(this.e);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = getActivity();
    this.b = View.inflate(getActivity(), 2130903928, null);
    c();
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/fragment/InternalRepairStateFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */