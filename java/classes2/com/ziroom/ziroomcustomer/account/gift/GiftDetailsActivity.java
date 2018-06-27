package com.ziroom.ziroomcustomer.account.gift;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.account.AccountMainActivity;
import com.ziroom.ziroomcustomer.account.model.GiftListItemBase.DataBean;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import java.text.DecimalFormat;

public class GiftDetailsActivity
  extends BaseActivity
{
  private TextView a;
  private TextView b;
  private TextView c;
  private ImageView d;
  private GiftListItemBase.DataBean e;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903087);
    this.e = ((GiftListItemBase.DataBean)getIntent().getSerializableExtra("giftBase"));
    this.a = ((TextView)findViewById(2131689856));
    this.b = ((TextView)findViewById(2131689846));
    this.c = ((TextView)findViewById(2131689858));
    this.d = ((ImageView)findViewById(2131689492));
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        GiftDetailsActivity.this.setResult(-1);
        GiftDetailsActivity.this.finish();
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(GiftDetailsActivity.this, GiftRuleActivity.class);
        paramAnonymousView.putExtra("rule", GiftDetailsActivity.a(GiftDetailsActivity.this).getRuleStr());
        GiftDetailsActivity.this.startActivity(paramAnonymousView);
      }
    });
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(GiftDetailsActivity.this, AccountMainActivity.class);
        GiftDetailsActivity.this.startActivity(paramAnonymousView);
        GiftDetailsActivity.this.finish();
      }
    });
    if (this.e != null)
    {
      paramBundle = new DecimalFormat("######0.00");
      this.b.setText(paramBundle.format(this.e.getAmount()));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/gift/GiftDetailsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */