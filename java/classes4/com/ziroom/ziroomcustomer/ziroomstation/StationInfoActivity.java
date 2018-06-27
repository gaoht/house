package com.ziroom.ziroomcustomer.ziroomstation;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;

public class StationInfoActivity
  extends BaseActivity
{
  private boolean a = true;
  @BindView(2131691272)
  CommonTitle commonTitle;
  @BindView(2131690150)
  ObservableScrollView sv_content;
  @BindView(2131690216)
  TextView tvAgree;
  @BindView(2131691441)
  TextView tvDec;
  @BindView(2131689541)
  TextView tvTitle;
  
  private void a()
  {
    Object localObject = getIntent();
    String str1 = ((Intent)localObject).getStringExtra("title");
    String str2 = ((Intent)localObject).getStringExtra("content");
    localObject = ((Intent)localObject).getStringExtra("customConfirmText");
    this.tvTitle.setText(str1);
    this.tvDec.setText(str2);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.tvAgree.setVisibility(8);
      return;
    }
    this.tvAgree.setVisibility(0);
    this.tvAgree.setText((CharSequence)localObject);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968696, 2130968695);
  }
  
  public void initTitle()
  {
    int i = 0;
    this.commonTitle.showRightText(false, null);
    CommonTitle localCommonTitle = this.commonTitle;
    if (this.a) {
      i = 4;
    }
    localCommonTitle.setLeftButtonType(i);
    this.commonTitle.setBottomLineAlpha(0.0F);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        StationInfoActivity.this.setResult(0);
        StationInfoActivity.this.finish();
      }
    });
  }
  
  @OnClick({2131690216})
  public void onAgree()
  {
    setResult(-1, getIntent());
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903289);
    ButterKnife.bind(this);
    a();
    initTitle();
    this.sv_content.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        StationInfoActivity.this.commonTitle.setBottomLineAlpha(f);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/StationInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */