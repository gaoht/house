package com.ziroom.ziroomcustomer.signed;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.account.AccountMainActivity;
import com.ziroom.ziroomcustomer.account.model.GiftBase;
import com.ziroom.ziroomcustomer.account.model.GiftBase.DataBean;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.pay.common.b.a;

public class PayPartActivity
  extends BaseActivity
  implements View.OnClickListener
{
  View a;
  Dialog b;
  private TextView c;
  private Button d;
  private Button e;
  private String f;
  private View g;
  private String r;
  private String s;
  private String t;
  private TextView u;
  
  private void a()
  {
    this.s = getIntent().getStringExtra("mCityCode");
    this.u = ((TextView)findViewById(2131692065));
    this.c = ((TextView)findViewById(2131692067));
    this.d = ((Button)findViewById(2131692068));
    this.e = ((Button)findViewById(2131692048));
    this.f = getIntent().getStringExtra("contract_code");
    this.g = findViewById(2131692070);
    String str = getIntent().getStringExtra("wystate");
    this.r = getIntent().getStringExtra("old_contract_code");
    this.t = getIntent().getStringExtra("bizCode");
    if ((str != null) && (str.equals("wystate")))
    {
      this.e.setVisibility(8);
      this.g.setVisibility(4);
    }
    if (this.r != null)
    {
      findViewById(2131690909).setVisibility(8);
      this.e.setVisibility(8);
    }
    this.u.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    str = getIntent().getStringExtra("sub_amount");
    this.c.setText(str);
    e();
  }
  
  private void b()
  {
    this.a = View.inflate(this, 2130905165, null);
    Object localObject = (TextView)this.a.findViewById(2131697639);
    TextView localTextView1 = (TextView)this.a.findViewById(2131697638);
    TextView localTextView2 = (TextView)this.a.findViewById(2131697637);
    TextView localTextView3 = (TextView)this.a.findViewById(2131697634);
    localTextView1.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        PayPartActivity.this.b.dismiss();
      }
    });
    ((TextView)localObject).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(PayPartActivity.this, AccountMainActivity.class);
        PayPartActivity.this.startActivity(paramAnonymousView);
        PayPartActivity.this.b.dismiss();
      }
    });
    localTextView3.setVisibility(8);
    ((TextView)localObject).setVisibility(0);
    localTextView1.setVisibility(0);
    localTextView2.setGravity(17);
    localTextView2.setText("恭喜您获得一个现金红包，请前往账户查看吧！");
    ((TextView)localObject).setText("立即前往");
    localTextView1.setText("稍后查看");
    this.b = new Dialog(this, 2131427781);
    this.b.setContentView(this.a);
    this.b.setCanceledOnTouchOutside(false);
    this.b.setCancelable(false);
    if (!this.b.isShowing())
    {
      localObject = this.b;
      if ((localObject instanceof Dialog)) {
        break label212;
      }
      ((Dialog)localObject).show();
    }
    for (;;)
    {
      this.b.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          PayPartActivity.this.a = null;
          PayPartActivity.this.b.dismiss();
          PayPartActivity.this.b = null;
        }
      });
      return;
      label212:
      VdsAgent.showDialog((Dialog)localObject);
    }
  }
  
  private void e()
  {
    if ((this.t == null) || (this.t.equals(""))) {
      return;
    }
    showProgress("");
    a.getGiftForBizCodeResult(this, this.t, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        PayPartActivity.this.dismissProgress();
        if (paramAnonymousk.getSuccess().booleanValue())
        {
          paramAnonymousk = (GiftBase)paramAnonymousk.getObject();
          if ((paramAnonymousk != null) && (paramAnonymousk.getData() != null) && (paramAnonymousk.getData().getCode() == 0)) {
            PayPartActivity.a(PayPartActivity.this);
          }
          return;
        }
        g.textToast(PayPartActivity.this, paramAnonymousk.getMessage());
      }
    });
  }
  
  public void onBackPressed() {}
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692068: 
      paramView = new Intent(this, HouseBillInfoActivity.class);
      paramView.putExtra("uniqueCode", this.f);
      paramView.putExtra("period", "1");
      if (this.r != null) {
        paramView.putExtra("old_contract_code", this.r);
      }
      paramView.putExtra("payType", "fz");
      startActivity(paramView);
      return;
    case 2131692048: 
      paramView = new Intent(this, ZxingActivity.class);
      paramView.putExtra("contract_part_code", this.f);
      startActivity(paramView);
      return;
    }
    paramView = new Intent(this, MainActivity.class);
    paramView.putExtra("FRAGMENT_TYPE", 7);
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903420);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/PayPartActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */