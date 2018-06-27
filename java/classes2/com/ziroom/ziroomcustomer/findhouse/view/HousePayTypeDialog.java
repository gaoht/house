package com.ziroom.ziroomcustomer.findhouse.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.model.HouseDetailPayWay;
import com.ziroom.ziroomcustomer.model.PayWay;
import java.util.ArrayList;
import java.util.List;

public class HousePayTypeDialog
  extends DialogFragment
{
  private HouseDetailPayWay a;
  private RelativeLayout b;
  private List<TextView> c;
  private final int[] d = { 2131693777, 2131693780, 2131693783, 2131693786, 2131693789 };
  private List<TextView> e;
  private final int[] f = { 2131693778, 2131693781, 2131693784, 2131693787, 2131693790 };
  private List<TextView> g;
  private final int[] h = { 2131693779, 2131693782, 2131693785, 2131693788, 2131693791 };
  
  private void a(List<TextView> paramList, PayWay paramPayWay)
  {
    ((TextView)paramList.get(1)).setText("¥" + paramPayWay.getMonth());
    ((TextView)paramList.get(2)).setText("¥" + paramPayWay.getQuarter());
    ((TextView)paramList.get(3)).setText("¥" + paramPayWay.getHalfYear());
    ((TextView)paramList.get(4)).setText("¥" + paramPayWay.getYear());
  }
  
  private void a(List<TextView> paramList, int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      paramList.add((TextView)this.b.findViewById(paramArrayOfInt[i]));
      i += 1;
    }
  }
  
  public static HousePayTypeDialog getInstance(HouseDetailPayWay paramHouseDetailPayWay)
  {
    HousePayTypeDialog localHousePayTypeDialog = new HousePayTypeDialog();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("payWay", paramHouseDetailPayWay);
    localHousePayTypeDialog.setArguments(localBundle);
    return localHousePayTypeDialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getDialog().requestWindowFeature(1);
    getDialog().getWindow().setBackgroundDrawableResource(17170445);
    this.a = ((HouseDetailPayWay)getArguments().getSerializable("payWay"));
    this.c = new ArrayList();
    this.e = new ArrayList();
    this.g = new ArrayList();
    this.b = ((RelativeLayout)paramLayoutInflater.inflate(2130903797, null));
    a(this.c, this.d);
    a(this.e, this.f);
    a(this.g, this.h);
    a(this.c, this.a.getRentFee());
    a(this.e, this.a.getDeposit());
    a(this.g, this.a.getServiceFee());
    ((ImageView)this.b.findViewById(2131690588)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        HousePayTypeDialog.this.getDialog().dismiss();
      }
    });
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/HousePayTypeDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */