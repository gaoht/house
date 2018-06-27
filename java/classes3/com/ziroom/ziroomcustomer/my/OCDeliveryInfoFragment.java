package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.my.adapter.OCDeliveryItemAdapter;
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmDeliveryBean.DeliveryInfoBean;
import com.ziroom.ziroomcustomer.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class OCDeliveryInfoFragment
  extends BaseFragment
{
  private Context a;
  private XListView b;
  private ViewStub c;
  private View d;
  private TextView e;
  private String f;
  private String g;
  private OCDeliveryItemAdapter h;
  private List<OwnerConfirmDeliveryBean.DeliveryInfoBean> i = new ArrayList();
  
  public OCDeliveryInfoFragment(String paramString1, String paramString2, List<OwnerConfirmDeliveryBean.DeliveryInfoBean> paramList)
  {
    this.f = paramString1;
    this.g = paramString2;
    this.i = paramList;
  }
  
  public static OCDeliveryInfoFragment getInstance(String paramString1, String paramString2, List<OwnerConfirmDeliveryBean.DeliveryInfoBean> paramList)
  {
    return new OCDeliveryInfoFragment(paramString1, paramString2, paramList);
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
    if ((this.i != null) && (this.i.size() > 0))
    {
      this.b.setVisibility(0);
      this.h = new OCDeliveryItemAdapter(this.a, this.i);
      this.b.setAdapter(this.h);
      this.e.setVisibility(8);
    }
    for (;;)
    {
      return this.d;
      this.b.setVisibility(8);
      this.e.setVisibility(0);
      this.e.setText("您没有" + this.f + "需确认，请点击" + this.g + "按钮。");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OCDeliveryInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */