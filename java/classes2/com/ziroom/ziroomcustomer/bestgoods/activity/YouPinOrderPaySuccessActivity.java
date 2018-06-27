package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import java.text.DecimalFormat;

public class YouPinOrderPaySuccessActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView a;
  private ObservableScrollView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private LinearLayout f;
  private TextView g;
  private TextView r;
  private Context s;
  
  private void a()
  {
    this.s = this;
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((ObservableScrollView)findViewById(2131689506));
    this.c = ((TextView)findViewById(2131690551));
    this.d = ((TextView)findViewById(2131692730));
    this.e = ((TextView)findViewById(2131692731));
    this.f = ((LinearLayout)findViewById(2131691013));
    this.g = ((TextView)findViewById(2131691014));
    this.r = ((TextView)findViewById(2131691015));
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.r.setOnClickListener(this);
  }
  
  private void e()
  {
    String str1 = getIntent().getStringExtra("address");
    double d1 = getIntent().getDoubleExtra("totalPrice", 0.0D);
    DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
    String str2 = getIntent().getStringExtra("connectionPhone");
    String str3 = getIntent().getStringExtra("connectionName");
    this.c.setText("支付¥" + localDecimalFormat.format(Double.valueOf(d1)));
    this.d.setText("收件人 " + str3 + " " + str2);
    this.e.setText(str1);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    toYouPinHomePage();
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
      toYouPinHomePage();
      return;
    case 2131691014: 
      j.toServiceOrderList(this.s, "type_youpin", "");
      return;
    }
    toYouPinHomePage();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903559);
    a();
    b();
    e();
  }
  
  public void toYouPinHomePage()
  {
    String str = ad.getOther(this.s, "youpinH5url");
    if (!TextUtils.isEmpty(str))
    {
      Intent localIntent = new Intent(this.s, YouPinGuidanceH5Activity.class);
      localIntent.putExtra("youpinH5url", str);
      startActivity(localIntent);
    }
    for (;;)
    {
      finish();
      return;
      startActivity(new Intent(this.s, YouPinGuidanceActivity.class));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinOrderPaySuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */