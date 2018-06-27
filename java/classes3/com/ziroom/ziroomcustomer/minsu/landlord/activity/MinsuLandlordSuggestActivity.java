package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.f.w;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuLandlordSuggestActivity
  extends BaseActivity
{
  private Unbinder a;
  @BindView(2131689816)
  Button mBtnSubmit;
  @BindView(2131691275)
  EditText mEt;
  
  private void a()
  {
    this.mEt.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable.length() > 0)
        {
          MinsuLandlordSuggestActivity.this.mBtnSubmit.setEnabled(true);
          return;
        }
        MinsuLandlordSuggestActivity.this.mBtnSubmit.setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  private void b()
  {
    CommonTitle localCommonTitle = (CommonTitle)findViewById(2131691272);
    localCommonTitle.setMiddleText(getString(2131297115));
    localCommonTitle.setLeftButtonType(0);
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuLandlordSuggestActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903307);
    this.a = ButterKnife.bind(this);
    b();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.unbind();
  }
  
  @OnClick({2131689816})
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.saveAdvise(this, VdsAgent.trackEditTextSilent(this.mEt).toString(), new s(this, new w())
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        g.textToast(ApplicationEx.c, "提交成功");
        MinsuLandlordSuggestActivity.this.finish();
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/MinsuLandlordSuggestActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */