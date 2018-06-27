package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.model.RentCard;
import java.util.ArrayList;
import java.util.List;

public class RentCardFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private Context a;
  private ListView b;
  private List<RentCard> c;
  private h d;
  
  private void a(View paramView)
  {
    this.c = new ArrayList();
    this.b = ((ListView)paramView.findViewById(2131696974));
    this.d = new h(this.a, this.c);
    this.b.setAdapter(this.d);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView.getId();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130904954, null);
    this.a = getActivity();
    a(paramLayoutInflater);
    if (checkNet(this.a)) {
      return paramLayoutInflater;
    }
    showToast("网络异常!");
    return paramLayoutInflater;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/RentCardFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */