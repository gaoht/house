package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ah;

public class PeriodCleanChangePhoneActivity
  extends BaseActivity
{
  @BindView(2131690043)
  Button btn;
  @BindView(2131692071)
  EditText edPhone;
  @BindView(2131692072)
  ImageView imgClean;
  @BindView(2131689492)
  ImageView ivBack;
  
  private void a()
  {
    if (VdsAgent.trackEditTextSilent(this.edPhone).toString().length() == 11)
    {
      this.btn.setEnabled(true);
      return;
    }
    this.btn.setEnabled(false);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903423);
    ButterKnife.bind(this);
    paramBundle = getIntent().getStringExtra("phone");
    this.edPhone.setText(paramBundle);
    this.btn.setEnabled(true);
    this.edPhone.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.toString().length() > 0) {
          PeriodCleanChangePhoneActivity.this.imgClean.setVisibility(0);
        }
        for (;;)
        {
          PeriodCleanChangePhoneActivity.a(PeriodCleanChangePhoneActivity.this);
          return;
          PeriodCleanChangePhoneActivity.this.imgClean.setVisibility(8);
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  @OnClick({2131689492, 2131692072, 2131690043})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131692072: 
      this.edPhone.setText("");
      return;
    }
    if (!ah.isMobile(VdsAgent.trackEditTextSilent(this.edPhone).toString()))
    {
      g.textToast(this, "手机号格式不正确");
      return;
    }
    paramView = new Intent();
    paramView.putExtra("phone", VdsAgent.trackEditTextSilent(this.edPhone).toString());
    setResult(16, paramView);
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanChangePhoneActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */