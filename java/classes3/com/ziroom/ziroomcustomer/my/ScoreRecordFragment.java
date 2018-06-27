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
import com.ziroom.ziroomcustomer.model.Contract;
import java.util.ArrayList;
import java.util.List;

public class ScoreRecordFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private Context a;
  private ListView b;
  private i c;
  private List<Contract> d;
  
  private void a(View paramView)
  {
    this.d = new ArrayList();
    this.b = ((ListView)paramView.findViewById(2131696988));
    this.c = new i(this.a, this.d);
    this.b.setAdapter(this.c);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView.getId();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130904957, null);
    this.a = getActivity();
    a(paramLayoutInflater);
    if (checkNet(this.a)) {
      return paramLayoutInflater;
    }
    showToast("网络异常!");
    return paramLayoutInflater;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/ScoreRecordFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */