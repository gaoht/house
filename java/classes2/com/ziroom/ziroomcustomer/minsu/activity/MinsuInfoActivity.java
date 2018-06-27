package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
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
import com.ziroom.ziroomcustomer.minsu.bean.MinsuInfoBean;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.p;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;

public class MinsuInfoActivity
  extends BaseActivity
{
  private int a;
  private int b;
  private String c;
  @BindView(2131691272)
  CommonTitle commonTitle;
  private int d;
  private boolean e = true;
  private String f;
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
    Intent localIntent = getIntent();
    this.a = localIntent.getIntExtra("code", -1);
    this.b = localIntent.getIntExtra("rentWay", 0);
    this.c = localIntent.getStringExtra("fid");
    this.d = localIntent.getIntExtra("special", 0);
    this.e = localIntent.getBooleanExtra("isExitAnim", false);
    this.f = localIntent.getStringExtra("customConfirmText");
    com.ziroom.ziroomcustomer.minsu.e.a.showRules(this, this.a + "", this.c, this.b, new s(this, new p(MinsuInfoBean.class))
    {
      public void onSuccess(int paramAnonymousInt, final MinsuInfoBean paramAnonymousMinsuInfoBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuInfoBean);
        if (paramAnonymousMinsuInfoBean == null) {
          return;
        }
        MinsuInfoActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            MinsuInfoActivity.this.tvTitle.setText(paramAnonymousMinsuInfoBean.title);
            MinsuInfoActivity.this.tvDec.setText(paramAnonymousMinsuInfoBean.content);
            if (MinsuInfoActivity.a(MinsuInfoActivity.this) == -1)
            {
              if (TextUtils.isEmpty(MinsuInfoActivity.b(MinsuInfoActivity.this))) {
                break label108;
              }
              MinsuInfoActivity.this.tvAgree.setText(MinsuInfoActivity.b(MinsuInfoActivity.this));
            }
            for (;;)
            {
              MinsuInfoActivity.this.tvAgree.setVisibility(0);
              return;
              label108:
              MinsuInfoActivity.this.tvAgree.setText(MinsuInfoActivity.this.getString(2131297026).replace("title", paramAnonymousMinsuInfoBean.title));
            }
          }
        });
      }
    });
  }
  
  public void finish()
  {
    super.finish();
    if (this.e) {
      k.animFinishAlpha(this);
    }
  }
  
  public void initTitle()
  {
    int i = 0;
    this.commonTitle.showRightText(false, null);
    CommonTitle localCommonTitle = this.commonTitle;
    if (this.e) {
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
        MinsuInfoActivity.this.setResult(0);
        MinsuInfoActivity.this.finish();
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
        MinsuInfoActivity.this.commonTitle.setBottomLineAlpha(f);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */