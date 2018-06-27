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

public class ZryuSdElectricityMeterFragment
  extends BaseFragment
{
  private TextView a;
  private TextView b;
  private Button c;
  private TextView d;
  private ZryuProgressBar e;
  private RelativeLayout f;
  private TextView g;
  private Context h;
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setVisibility(0);
      this.e.setVisibility(8);
      this.a.setVisibility(8);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      return;
    }
    this.f.setVisibility(8);
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
      j.zryuSdElectricityMeterDetail(this.h, str, new com.ziroom.commonlibrary.a.a(this.h, new f(MeterDetail.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          ZryuSdElectricityMeterFragment.a(ZryuSdElectricityMeterFragment.this, true);
        }
        
        public void onSuccess(int paramAnonymousInt, final MeterDetail paramAnonymousMeterDetail)
        {
          int i = 0;
          super.onSuccess(paramAnonymousInt, paramAnonymousMeterDetail);
          if (paramAnonymousMeterDetail != null)
          {
            ZryuSdElectricityMeterFragment.a(ZryuSdElectricityMeterFragment.this, false);
            ZryuSdElectricityMeterFragment.a(ZryuSdElectricityMeterFragment.this).setText(paramAnonymousMeterDetail.getPayTypeName());
            ZryuSdElectricityMeterFragment.b(ZryuSdElectricityMeterFragment.this).setText(paramAnonymousMeterDetail.getUpdateInfo());
            ZryuSdElectricityMeterFragment.c(ZryuSdElectricityMeterFragment.this).setText(paramAnonymousMeterDetail.getJumpDesc());
            ZryuSdElectricityMeterFragment.d(ZryuSdElectricityMeterFragment.this).setText(paramAnonymousMeterDetail.getTips());
            ZryuSdElectricityMeterFragment.e(ZryuSdElectricityMeterFragment.this).setVisibility(0);
            ZryuSdElectricityMeterFragment.e(ZryuSdElectricityMeterFragment.this).setCalibraList(paramAnonymousMeterDetail.getListIntellectDialsVo());
            ZryuProgressBar localZryuProgressBar = ZryuSdElectricityMeterFragment.e(ZryuSdElectricityMeterFragment.this);
            if (paramAnonymousMeterDetail.getDialsTotal() == null)
            {
              paramAnonymousInt = 0;
              localZryuProgressBar.setDottedLineCount(paramAnonymousInt);
              ZryuSdElectricityMeterFragment.e(ZryuSdElectricityMeterFragment.this).setProgressDesc(paramAnonymousMeterDetail.getIntellectReadings(), paramAnonymousMeterDetail.getPanelTips());
              localZryuProgressBar = ZryuSdElectricityMeterFragment.e(ZryuSdElectricityMeterFragment.this);
              if (paramAnonymousMeterDetail.getCurrentDialsNum() != null) {
                break label200;
              }
            }
            label200:
            for (paramAnonymousInt = i;; paramAnonymousInt = paramAnonymousMeterDetail.getCurrentDialsNum().intValue())
            {
              localZryuProgressBar.setProgress(paramAnonymousInt, 50);
              ZryuSdElectricityMeterFragment.c(ZryuSdElectricityMeterFragment.this).setOnClickListener(new View.OnClickListener()
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
                    b.toBillsList(ZryuSdElectricityMeterFragment.f(ZryuSdElectricityMeterFragment.this), ZryuSdElectricityMeterFragment.1.this.c, 2, 1);
                    return;
                  case 2: 
                    paramAnonymous2View = new Intent(ZryuSdElectricityMeterFragment.f(ZryuSdElectricityMeterFragment.this), ZryuSdWaterBillsListActivity.class);
                    paramAnonymous2View.putExtra("contractId", ZryuSdElectricityMeterFragment.1.this.c);
                    ZryuSdElectricityMeterFragment.f(ZryuSdElectricityMeterFragment.this).startActivity(paramAnonymous2View);
                    return;
                  }
                  paramAnonymous2View = new Intent(ZryuSdElectricityMeterFragment.f(ZryuSdElectricityMeterFragment.this), ZryuSdElectricityPayActivity.class);
                  paramAnonymous2View.putExtra("contractId", ZryuSdElectricityMeterFragment.1.this.c);
                  ZryuSdElectricityMeterFragment.f(ZryuSdElectricityMeterFragment.this).startActivity(paramAnonymous2View);
                }
              });
              return;
              paramAnonymousInt = paramAnonymousMeterDetail.getDialsTotal().intValue();
              break;
            }
          }
          ZryuSdElectricityMeterFragment.a(ZryuSdElectricityMeterFragment.this, true);
        }
      });
    }
  }
  
  public static ZryuSdElectricityMeterFragment getInstance(String paramString)
  {
    ZryuSdElectricityMeterFragment localZryuSdElectricityMeterFragment = new ZryuSdElectricityMeterFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("contractId", paramString);
    localZryuSdElectricityMeterFragment.setArguments(localBundle);
    return localZryuSdElectricityMeterFragment;
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.h = paramContext;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903998, paramViewGroup, false);
    this.f = ((RelativeLayout)paramLayoutInflater.findViewById(2131694401));
    this.g = ((TextView)paramLayoutInflater.findViewById(2131694402));
    this.e = ((ZryuProgressBar)paramLayoutInflater.findViewById(2131694404));
    this.a = ((TextView)paramLayoutInflater.findViewById(2131694403));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131694405));
    this.c = ((Button)paramLayoutInflater.findViewById(2131690043));
    this.d = ((TextView)paramLayoutInflater.findViewById(2131689835));
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    c();
  }
  
  public void refresh(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      getArguments().putString("contractId", paramString);
      if (isResumed()) {
        c();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/fragment/ZryuSdElectricityMeterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */