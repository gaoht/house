package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.d;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.adapter.OwnerDeliveryDetailAdapter;
import com.ziroom.ziroomcustomer.my.model.OwnerDeliveryDetailEntity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;

public class OwnerDeliveryDetailActivity
  extends BaseActivity
{
  private static final String a = OwnerDeliveryDetailActivity.class.getSimpleName();
  private Unbinder b;
  private OwnerDeliveryDetailEntity c;
  private String d;
  private String e;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131690608)
  LinearLayout llContentContainer;
  @BindView(2131692004)
  ListViewForScrollView owner_delivery_detail_list;
  @BindView(2131692003)
  TextView owner_delivery_detail_time;
  @BindView(2131691990)
  TextView tvContactKeeper;
  
  private void b()
  {
    String str = "0";
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    for (;;)
    {
      j.getOCDelieverDetail(this, g.buildOCDelieverDetail(str, this.d), new f(this, new d())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          OwnerDeliveryDetailActivity.this.q.sendEmptyMessage(0);
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if (paramAnonymouse != null)
          {
            u.logBigData(OwnerDeliveryDetailActivity.a(), "===ymq:" + paramAnonymouse.toString());
            OwnerDeliveryDetailActivity.a(OwnerDeliveryDetailActivity.this, (OwnerDeliveryDetailEntity)com.alibaba.fastjson.a.parseObject(paramAnonymouse + "", OwnerDeliveryDetailEntity.class));
            if (OwnerDeliveryDetailActivity.a(OwnerDeliveryDetailActivity.this) != null)
            {
              OwnerDeliveryDetailActivity.this.llContentContainer.setVisibility(0);
              OwnerDeliveryDetailActivity.b(OwnerDeliveryDetailActivity.this);
            }
          }
          else
          {
            return;
          }
          OwnerDeliveryDetailActivity.this.llContentContainer.setVisibility(4);
        }
      });
      return;
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    }
  }
  
  private void e()
  {
    this.e = this.c.hireCommissionerPhone;
    if (!ae.isNull(this.e)) {
      this.tvContactKeeper.setVisibility(0);
    }
    for (;;)
    {
      this.owner_delivery_detail_time.setText("物业交割日期" + this.c.getDeliveryDate());
      this.owner_delivery_detail_list.setAdapter(new OwnerDeliveryDetailAdapter(this.c.getDelivery(), this));
      return;
      this.tvContactKeeper.setVisibility(8);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903407);
    this.b = ButterKnife.bind(this);
    this.d = getIntent().getStringExtra("contractCode");
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.b.unbind();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  @OnClick({2131689492, 2131691990})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    ah.callPhone(this, this.e);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerDeliveryDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */