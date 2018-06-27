package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sd.FeeBillDetail;

public class ZryuSdBillDetailActivity
  extends BaseActivity
{
  private ImageView a;
  private LinearLayout b;
  private TextView c;
  private LinearLayout d;
  private TextView e;
  private LinearLayout f;
  private TextView g;
  private LinearLayout r;
  private TextView s;
  private String t;
  
  private void a()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((LinearLayout)findViewById(2131692946));
    this.c = ((TextView)findViewById(2131692947));
    this.d = ((LinearLayout)findViewById(2131689851));
    this.e = ((TextView)findViewById(2131689852));
    this.f = ((LinearLayout)findViewById(2131692948));
    this.g = ((TextView)findViewById(2131689912));
    this.r = ((LinearLayout)findViewById(2131692949));
    this.s = ((TextView)findViewById(2131690309));
  }
  
  private void b()
  {
    this.t = getIntent().getStringExtra("billFid");
    if (!TextUtils.isEmpty(this.t)) {
      j.zryuSdWaterFeeBillDetail(this, this.t, new com.ziroom.commonlibrary.a.a(this, new f(FeeBillDetail.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, FeeBillDetail paramAnonymousFeeBillDetail)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousFeeBillDetail);
          if (paramAnonymousFeeBillDetail != null) {
            ZryuSdBillDetailActivity.a(ZryuSdBillDetailActivity.this).setText(paramAnonymousFeeBillDetail.getOughtAmount() + "");
          }
        }
      });
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903598);
    a();
    b();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSdBillDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */