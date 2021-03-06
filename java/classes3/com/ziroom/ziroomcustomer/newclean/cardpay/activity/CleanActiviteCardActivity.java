package com.ziroom.ziroomcustomer.newclean.cardpay.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import java.util.Map;

public class CleanActiviteCardActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Context a;
  private ImageView b;
  private TextView c;
  private ImageView d;
  private ImageView e;
  private LabeledEditText f;
  private LabeledEditText g;
  private boolean r = false;
  private boolean s = false;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((TextView)findViewById(2131690191));
    this.d = ((ImageView)findViewById(2131690192));
    this.e = ((ImageView)findViewById(2131690194));
    this.f = ((LabeledEditText)findViewById(2131690193));
    this.g = ((LabeledEditText)findViewById(2131690195));
    this.f.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() > 0)
        {
          CleanActiviteCardActivity.a(CleanActiviteCardActivity.this).setVisibility(0);
          CleanActiviteCardActivity.a(CleanActiviteCardActivity.this, true);
          CleanActiviteCardActivity.a(CleanActiviteCardActivity.this, CleanActiviteCardActivity.b(CleanActiviteCardActivity.this), CleanActiviteCardActivity.c(CleanActiviteCardActivity.this));
          return;
        }
        CleanActiviteCardActivity.a(CleanActiviteCardActivity.this).setVisibility(8);
        CleanActiviteCardActivity.a(CleanActiviteCardActivity.this, false);
        CleanActiviteCardActivity.a(CleanActiviteCardActivity.this, CleanActiviteCardActivity.b(CleanActiviteCardActivity.this), CleanActiviteCardActivity.c(CleanActiviteCardActivity.this));
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 64) {
          g.textToast(CleanActiviteCardActivity.d(CleanActiviteCardActivity.this), "字数超出限制！");
        }
      }
    });
    this.g.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() > 0)
        {
          CleanActiviteCardActivity.e(CleanActiviteCardActivity.this).setVisibility(0);
          CleanActiviteCardActivity.b(CleanActiviteCardActivity.this, true);
          CleanActiviteCardActivity.a(CleanActiviteCardActivity.this, CleanActiviteCardActivity.b(CleanActiviteCardActivity.this), CleanActiviteCardActivity.c(CleanActiviteCardActivity.this));
          return;
        }
        CleanActiviteCardActivity.e(CleanActiviteCardActivity.this).setVisibility(8);
        CleanActiviteCardActivity.b(CleanActiviteCardActivity.this, false);
        CleanActiviteCardActivity.a(CleanActiviteCardActivity.this, CleanActiviteCardActivity.b(CleanActiviteCardActivity.this), CleanActiviteCardActivity.c(CleanActiviteCardActivity.this));
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 64) {
          g.textToast(CleanActiviteCardActivity.d(CleanActiviteCardActivity.this), "字数超出限制！");
        }
      }
    });
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1 == true) && (paramBoolean2 == true))
    {
      this.c.setTextColor(40960);
      return;
    }
    this.c.setTextColor(-6710887);
  }
  
  private void b()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    String str1 = this.f.getText();
    String str2 = this.g.getText();
    String str3 = localUserInfo.getMobile();
    String str4 = localUserInfo.getUser_name();
    if (TextUtils.isEmpty(this.f.getText())) {
      g.textToast(this.a, "请先输入卡号");
    }
    do
    {
      return;
      if (TextUtils.isEmpty(this.g.getText()))
      {
        g.textToast(this.a, "请先输入密码");
        return;
      }
    } while (localUserInfo == null);
    n.activiteCleanCard(this.a, str1, str2, localUserInfo.getUid(), str4, str3, new a(), false);
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
    case 2131690191: 
      b();
      return;
    case 2131690192: 
      this.f.setText("");
      return;
    }
    this.g.setText("");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903134);
    this.a = this;
    a();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.f.disposeFocus(findViewById(2131689541));
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      u.e("dsgdsgh:", com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      paramString = a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = new Intent();
        CleanActiviteCardActivity.this.setResult(-1, paramk);
        g.textToast(CleanActiviteCardActivity.d(CleanActiviteCardActivity.this), "激活成功");
        CleanActiviteCardActivity.this.finish();
      }
      while (TextUtils.isEmpty(paramk.getMessage())) {
        return;
      }
      g.textToast(CleanActiviteCardActivity.d(CleanActiviteCardActivity.this), paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/activity/CleanActiviteCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */