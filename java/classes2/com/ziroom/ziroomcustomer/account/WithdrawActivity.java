package com.ziroom.ziroomcustomer.account;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.b.b;
import com.freelxl.baselibrary.d.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.j;
import com.ziroom.ziroomcustomer.e.q;
import java.util.Map;

public class WithdrawActivity
  extends BaseActivity
  implements View.OnClickListener
{
  com.freelxl.baselibrary.d.c.a a = new com.ziroom.commonlibrary.a.a(this, new d(b.class))
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      com.freelxl.baselibrary.f.g.textToast(ApplicationEx.c, "网络访问失败");
    }
    
    public void onSuccess(int paramAnonymousInt, b paramAnonymousb)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousb);
      if (paramAnonymousb.status.equals("success"))
      {
        WithdrawActivity.this.finish();
        paramAnonymousb = new Intent(WithdrawActivity.this, WithdrawSucceedActivity.class);
        paramAnonymousb.putExtra("cardName", WithdrawActivity.a(WithdrawActivity.this));
        paramAnonymousb.putExtra("cardNum", WithdrawActivity.b(WithdrawActivity.this));
        paramAnonymousb.putExtra("money", WithdrawActivity.c(WithdrawActivity.this));
        WithdrawActivity.this.startActivity(paramAnonymousb);
        WithdrawActivity.this.overridePendingTransition(2130968673, 2130968678);
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(WithdrawActivity.this, paramAnonymousb.error_message);
    }
  };
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private ImageView g;
  private EditText r;
  private Button s;
  private SimpleDraweeView t;
  private String u;
  private String v;
  private String w;
  private String x;
  
  private void a()
  {
    Map localMap = com.ziroom.ziroomcustomer.e.g.buildWithdraw(this.v);
    com.freelxl.baselibrary.d.a.post(q.H + e.j.n).params(localMap).tag(this).enqueue(this.a);
  }
  
  private void b()
  {
    this.s = ((Button)findViewById(2131689800));
    this.b = ((TextView)findViewById(2131689799));
    this.c = ((TextView)findViewById(2131689798));
    this.r = ((EditText)findViewById(2131689797));
    this.g = ((ImageView)findViewById(2131689795));
    this.d = ((TextView)findViewById(2131689796));
    this.t = ((SimpleDraweeView)findViewById(2131689776));
    this.f = ((TextView)findViewById(2131689777));
    this.e = ((TextView)findViewById(2131689778));
    this.t.setVisibility(8);
    this.w = getIntent().getStringExtra("cardName");
    this.x = getIntent().getStringExtra("cardNum");
    String str = getIntent().getStringExtra("cardPicUrl");
    this.u = getIntent().getStringExtra("balance");
    Object localObject = new SpannableString("可用余额" + this.u + "元");
    ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(18, true), 0, ((SpannableString)localObject).length(), 33);
    this.r.setHint(new SpannedString((CharSequence)localObject));
    f();
    if (!TextUtils.isEmpty(this.x))
    {
      localObject = this.x.replaceAll("(?<=.{4})(.{8})", "********").replaceAll(".{4}(?!$)", "$0 ");
      this.e.setText((CharSequence)localObject);
    }
    this.f.setText(this.w);
    this.t.setController(com.freelxl.baselibrary.f.c.frescoController(str));
    e();
    this.b.setVisibility(8);
  }
  
  private void e()
  {
    this.s.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.r.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (TextUtils.isEmpty(paramAnonymousCharSequence.toString()))
        {
          WithdrawActivity.d(WithdrawActivity.this);
          WithdrawActivity.e(WithdrawActivity.this).setVisibility(8);
          return;
        }
        if (paramAnonymousCharSequence.toString().indexOf(".") == 0) {}
        for (paramAnonymousCharSequence = "0" + paramAnonymousCharSequence.toString(); (paramAnonymousCharSequence.indexOf(".") > 0) && (paramAnonymousCharSequence.length() - paramAnonymousCharSequence.indexOf(".") > 3); paramAnonymousCharSequence = paramAnonymousCharSequence.toString())
        {
          WithdrawActivity.f(WithdrawActivity.this).setText(paramAnonymousCharSequence.substring(0, paramAnonymousCharSequence.indexOf(".") + 3));
          return;
        }
        paramAnonymousCharSequence = Float.valueOf(paramAnonymousCharSequence);
        Float localFloat = Float.valueOf(WithdrawActivity.g(WithdrawActivity.this));
        if (paramAnonymousCharSequence.floatValue() > 0.0F)
        {
          if (paramAnonymousCharSequence.floatValue() <= localFloat.floatValue())
          {
            if (paramAnonymousCharSequence.floatValue() > 10000.0F)
            {
              WithdrawActivity.d(WithdrawActivity.this);
              return;
            }
            WithdrawActivity.h(WithdrawActivity.this).setBackground(WithdrawActivity.this.getResources().getDrawable(2130838035));
            WithdrawActivity.h(WithdrawActivity.this).setClickable(true);
            WithdrawActivity.h(WithdrawActivity.this).setEnabled(true);
            WithdrawActivity.e(WithdrawActivity.this).setText("单笔提现金额不能超过10000元");
            WithdrawActivity.e(WithdrawActivity.this).setVisibility(8);
            return;
          }
          WithdrawActivity.h(WithdrawActivity.this).setBackground(WithdrawActivity.this.getResources().getDrawable(2130839643));
          WithdrawActivity.h(WithdrawActivity.this).setClickable(false);
          WithdrawActivity.h(WithdrawActivity.this).setEnabled(false);
          WithdrawActivity.e(WithdrawActivity.this).setText("输入金额超过账户余额");
          WithdrawActivity.e(WithdrawActivity.this).setVisibility(0);
          return;
        }
        WithdrawActivity.d(WithdrawActivity.this);
        WithdrawActivity.e(WithdrawActivity.this).setVisibility(8);
      }
    });
  }
  
  private void f()
  {
    this.s.setBackground(getResources().getDrawable(2130839643));
    this.s.setClickable(false);
    this.s.setEnabled(false);
    this.b.setText("单笔提现金额不能超过10000元");
    this.b.setVisibility(0);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131689797: 
    case 2131689799: 
    default: 
      return;
    case 2131689796: 
      paramView = new ContactusDialog();
      FragmentManager localFragmentManager = getSupportFragmentManager();
      if (!(paramView instanceof DialogFragment))
      {
        paramView.show(localFragmentManager, null);
        return;
      }
      VdsAgent.showDialogFragment((DialogFragment)paramView, localFragmentManager, null);
      return;
    case 2131689798: 
      this.r.setText(this.u);
      return;
    case 2131689795: 
      finish();
      overridePendingTransition(2130968678, 0);
      return;
    }
    this.v = VdsAgent.trackEditTextSilent(this.r).toString();
    a();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903076);
    b();
  }
  
  protected void onDestroy()
  {
    com.freelxl.baselibrary.d.a.cancel(this);
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/WithdrawActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */