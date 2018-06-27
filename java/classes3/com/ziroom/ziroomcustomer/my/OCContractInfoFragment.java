package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.my.adapter.OCContractItemAdapter;
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmContractBean.ContractInfoBean;
import com.ziroom.ziroomcustomer.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class OCContractInfoFragment
  extends BaseFragment
{
  private Context a;
  private XListView b;
  private ViewStub c;
  private View d;
  private TextView e;
  private String f;
  private OCContractItemAdapter g;
  private List<OwnerConfirmContractBean.ContractInfoBean> h = new ArrayList();
  
  public OCContractInfoFragment(String paramString, List<OwnerConfirmContractBean.ContractInfoBean> paramList)
  {
    this.f = paramString;
    this.h = paramList;
  }
  
  public static OCContractInfoFragment getInstance(String paramString, List<OwnerConfirmContractBean.ContractInfoBean> paramList)
  {
    return new OCContractInfoFragment(paramString, paramList);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.d = paramLayoutInflater.inflate(2130903891, paramViewGroup, false);
    this.c = ((ViewStub)this.d.findViewById(2131690620));
    this.b = ((XListView)this.d.findViewById(2131693946));
    this.e = ((TextView)this.d.findViewById(2131689835));
    this.b.setPullLoadEnable(false);
    this.b.setPullRefreshEnable(false);
    this.b.setHeaderDividersEnabled(false);
    this.a = getActivity();
    if ((this.h != null) && (this.h.size() > 0))
    {
      this.b.setVisibility(0);
      this.g = new OCContractItemAdapter(this.a, this.h);
      this.b.setAdapter(this.g);
      this.e.setVisibility(8);
    }
    for (;;)
    {
      return this.d;
      this.b.setVisibility(8);
      this.e.setVisibility(0);
      this.e.setText("您没有" + this.f + "需确认，请点击下一步按钮。");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OCContractInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */