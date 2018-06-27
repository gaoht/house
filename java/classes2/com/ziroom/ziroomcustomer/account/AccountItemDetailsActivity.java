package com.ziroom.ziroomcustomer.account;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.account.model.AccountDetails.DataBean;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;

public class AccountItemDetailsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView a;
  private ImageView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private AccountDetails.DataBean t;
  
  private void a()
  {
    this.t = ((AccountDetails.DataBean)getIntent().getExtras().get("accountDetails"));
    this.a = ((ImageView)findViewById(2131689770));
    this.c = ((TextView)findViewById(2131689846));
    this.d = ((TextView)findViewById(2131689848));
    this.e = ((TextView)findViewById(2131689850));
    this.f = ((TextView)findViewById(2131689852));
    this.g = ((TextView)findViewById(2131689855));
    this.r = ((TextView)findViewById(2131689541));
    this.s = ((TextView)findViewById(2131689845));
    this.b = ((ImageView)findViewById(2131689849));
    this.b.setVisibility(8);
    b();
    if (this.t == null) {}
    do
    {
      do
      {
        return;
        this.r.setText(this.t.getType_name());
        this.d.setText(this.t.getStatus_name());
        this.e.setText(this.t.getRemark());
        this.f.setText(this.t.getDate());
        this.g.setText(this.t.getOrder_no());
        if ("1".equals(this.t.getType()))
        {
          this.c.setText("+" + this.t.getBalance());
          this.c.setTextColor(Color.parseColor("#63D18B"));
          this.d.setText("交易成功");
          return;
        }
        if ("2".equals(this.t.getType()))
        {
          this.c.setText("-" + this.t.getBalance());
          this.d.setText("交易成功");
          return;
        }
      } while (!"3".equals(this.t.getType()));
      this.c.setText(this.t.getBalance());
      if ("1".equals(this.t.getStatus()))
      {
        this.c.setTextColor(Color.parseColor("#63D18B"));
        return;
      }
      if ("2".equals(this.t.getStatus()))
      {
        this.d.setTextColor(Color.parseColor("#FF6262"));
        this.b.setVisibility(0);
        this.b.setOnClickListener(this);
        return;
      }
    } while (!"0".equals(this.t.getStatus()));
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.s.setOnClickListener(this);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131695798: 
    default: 
    case 2131689849: 
      do
      {
        return;
      } while ((this.t == null) || (this.t.getQuestion_url() == null));
      JsBridgeWebActivity.start(this, null, this.t.getQuestion_url());
      return;
    case 2131689770: 
      finish();
      return;
    }
    paramView = new ContactusDialog();
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (!(paramView instanceof DialogFragment))
    {
      paramView.show(localFragmentManager, null);
      return;
    }
    VdsAgent.showDialogFragment((DialogFragment)paramView, localFragmentManager, null);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903086);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/AccountItemDetailsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */