package com.ziroom.ziroomcustomer.ziroomapartment.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuSdElectricityPayActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuSdWaterBillsListActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.b;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sd.MeterDetail;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ZryuProgressBar;

public class ZryuSdWaterMeterFragment
  extends BaseFragment
{
  private TextView a;
  private TextView b;
  private Button c;
  private TextView d;
  private ZryuProgressBar e;
  private Context f;
  private RelativeLayout g;
  private TextView h;
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.g.setVisibility(0);
      this.e.setVisibility(8);
      this.a.setVisibility(8);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      return;
    }
    this.g.setVisibility(8);
    this.e.setVisibility(0);
    this.a.setVisibility(0);
    this.b.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(0);
  }
  
  private void c()
  {
    final String str = getArguments().getString("contractId");
    if (!TextUtils.isEmpty(str)) {
      j.zryuSdWaterMeterDetail(this.f, str, new com.ziroom.commonlibrary.a.a(this.f, new f(MeterDetail.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          ZryuSdWaterMeterFragment.a(ZryuSdWaterMeterFragment.this, true);
        }
        
        public void onSuccess(int paramAnonymousInt, final MeterDetail paramAnonymousMeterDetail)
        {
          int i = 0;
          super.onSuccess(paramAnonymousInt, paramAnonymousMeterDetail);
          if (paramAnonymousMeterDetail != null)
          {
            ZryuSdWaterMeterFragment.a(ZryuSdWaterMeterFragment.this, false);
            ZryuSdWaterMeterFragment.a(ZryuSdWaterMeterFragment.this).setText(paramAnonymousMeterDetail.getPayTypeName());
            ZryuSdWaterMeterFragment.b(ZryuSdWaterMeterFragment.this).setText(paramAnonymousMeterDetail.getUpdateInfo());
            ZryuSdWaterMeterFragment.c(ZryuSdWaterMeterFragment.this).setText(paramAnonymousMeterDetail.getTips());
            ZryuSdWaterMeterFragment.d(ZryuSdWaterMeterFragment.this).setText(paramAnonymousMeterDetail.getJumpDesc());
            ZryuSdWaterMeterFragment.e(ZryuSdWaterMeterFragment.this).setVisibility(0);
            ZryuSdWaterMeterFragment.e(ZryuSdWaterMeterFragment.this).setCalibraList(paramAnonymousMeterDetail.getListIntellectDialsVo());
            ZryuProgressBar localZryuProgressBar = ZryuSdWaterMeterFragment.e(ZryuSdWaterMeterFragment.this);
            if (paramAnonymousMeterDetail.getDialsTotal() == null)
            {
              paramAnonymousInt = 0;
              localZryuProgressBar.setDottedLineCount(paramAnonymousInt);
              ZryuSdWaterMeterFragment.e(ZryuSdWaterMeterFragment.this).setProgressDesc(paramAnonymousMeterDetail.getIntellectReadings(), paramAnonymousMeterDetail.getPanelTips());
              localZryuProgressBar = ZryuSdWaterMeterFragment.e(ZryuSdWaterMeterFragment.this);
              if (paramAnonymousMeterDetail.getCurrentDialsNum() != null) {
                break label200;
              }
            }
            label200:
            for (paramAnonymousInt = i;; paramAnonymousInt = paramAnonymousMeterDetail.getCurrentDialsNum().intValue())
            {
              localZryuProgressBar.setProgress(paramAnonymousInt, 50);
              ZryuSdWaterMeterFragment.d(ZryuSdWaterMeterFragment.this).setOnClickListener(new View.OnClickListener()
              {
                @Instrumented
                public void onClick(View paramAnonymous2View)
                {
                  VdsAgent.onClick(this, paramAnonymous2View);
                  if (paramAnonymousMeterDetail.getJumpType() != null) {}
                  switch (paramAnonymousMeterDetail.getJumpType().intValue())
                  {
                  default: 
                    return;
                  case 1: 
                    b.toBillsList(ZryuSdWaterMeterFragment.f(ZryuSdWaterMeterFragment.this), ZryuSdWaterMeterFragment.1.this.c, 2, 1);
                    return;
                  case 2: 
                    paramAnonymous2View = new Intent(ZryuSdWaterMeterFragment.f(ZryuSdWaterMeterFragment.this), ZryuSdWaterBillsListActivity.class);
                    paramAnonymous2View.putExtra("contractId", ZryuSdWaterMeterFragment.1.this.c);
                    ZryuSdWaterMeterFragment.f(ZryuSdWaterMeterFragment.this).startActivity(paramAnonymous2View);
                    return;
                  }
                  paramAnonymous2View = new Intent(ZryuSdWaterMeterFragment.f(ZryuSdWaterMeterFragment.this), ZryuSdElectricityPayActivity.class);
                  paramAnonymous2View.putExtra("contractId", ZryuSdWaterMeterFragment.1.this.c);
                  ZryuSdWaterMeterFragment.f(ZryuSdWaterMeterFragment.this).startActivity(paramAnonymous2View);
                }
              });
              return;
              paramAnonymousInt = paramAnonymousMeterDetail.getDialsTotal().intValue();
              break;
            }
          }
          ZryuSdWaterMeterFragment.a(ZryuSdWaterMeterFragment.this, true);
        }
      });
    }
  }
  
  public static ZryuSdWaterMeterFragment getInstance(String paramString)
  {
    ZryuSdWaterMeterFragment localZryuSdWaterMeterFragment = new ZryuSdWaterMeterFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("contractId", paramString);
    localZryuSdWaterMeterFragment.setArguments(localBundle);
    return localZryuSdWaterMeterFragment;
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.f = paramContext;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903999, paramViewGroup, false);
    this.g = ((RelativeLayout)paramLayoutInflater.findViewById(2131694401));
    this.h = ((TextView)paramLayoutInflater.findViewById(2131694402));
    this.e = ((ZryuProgressBar)paramLayoutInflater.findViewById(2131694404));
    this.a = ((TextView)paramLayoutInflater.findViewById(2131694403));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131694405));
    this.c = ((Button)paramLayoutInflater.findViewById(2131690043));
    this.d = ((TextView)paramLayoutInflater.findViewById(2131689835));
    c();
    return paramLayoutInflater;
  }
  
  public void refresh(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      getArguments().putString("contractId", paramString);
      c();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/fragment/ZryuSdWaterMeterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */