package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.a.r;
import com.ziroom.ziroomcustomer.bestgoods.model.ag;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import java.text.DecimalFormat;
import java.util.List;

public class YouPinBackOrderDetailsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private RelativeLayout a;
  private ImageView b;
  private SimpleDraweeView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private LinearLayout v;
  private ListViewForScrollView w;
  private Context x;
  private ag y;
  private TextView z;
  
  private void a()
  {
    this.x = this;
    this.a = ((RelativeLayout)findViewById(2131689808));
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((SimpleDraweeView)findViewById(2131692668));
    this.d = ((TextView)findViewById(2131692669));
    this.d.setFocusable(true);
    this.d.setFocusableInTouchMode(true);
    this.d.requestFocus();
    this.e = ((TextView)findViewById(2131692670));
    this.z = ((TextView)findViewById(2131690091));
    this.f = ((TextView)findViewById(2131692672));
    this.g = ((TextView)findViewById(2131692674));
    this.r = ((TextView)findViewById(2131692676));
    this.s = ((TextView)findViewById(2131692678));
    this.t = ((TextView)findViewById(2131692680));
    this.u = ((TextView)findViewById(2131692681));
    this.v = ((LinearLayout)findViewById(2131692682));
    this.w = ((ListViewForScrollView)findViewById(2131692683));
  }
  
  private void b()
  {
    this.z.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  private void e()
  {
    String str = getIntent().getStringExtra("retreatOrderCode");
    n.getYouBackOrderDetailsInfo(this.x, str, new com.ziroom.ziroomcustomer.e.a.a(this.x, new m(ag.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, ag paramAnonymousag)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousag);
        YouPinBackOrderDetailsActivity.a(YouPinBackOrderDetailsActivity.this, paramAnonymousag);
        if (YouPinBackOrderDetailsActivity.a(YouPinBackOrderDetailsActivity.this) != null) {
          YouPinBackOrderDetailsActivity.b(YouPinBackOrderDetailsActivity.this);
        }
      }
    });
  }
  
  private void f()
  {
    Object localObject2 = this.y.getAmount();
    String str1 = this.y.getRetreatOrderCode();
    String str2 = this.y.getCreateTime();
    String str3 = this.y.getRetreatReason();
    Object localObject1 = this.y.getRefundAmount();
    String str4 = this.y.getSkuName();
    String str5 = this.y.getStatusName();
    String str6 = this.y.getSkuPicUrl();
    this.c.setController(c.frescoController(str6));
    this.d.setText(str4);
    this.e.setText(str5);
    this.f.setText(str1);
    this.g.setText(localObject2 + "");
    this.r.setText(str2);
    this.s.setText(str3);
    localObject2 = new DecimalFormat("0.00");
    this.t.setText("￥" + ((DecimalFormat)localObject2).format(localObject1));
    localObject1 = this.y.getProgressList();
    localObject1 = new r(this.x, (List)localObject1);
    this.w.setAdapter((ListAdapter)localObject1);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    ah.callPhone(this.x, "4001001111");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903550);
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinBackOrderDetailsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */