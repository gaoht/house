package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.rangebar.RangeBar;
import com.ziroom.commonlibrary.widget.rangebar.RangeBar.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuPriceActivity
  extends BaseActivity
{
  String a = "-1";
  String b = "-1";
  private int c = -1;
  @BindView(2131691272)
  CommonTitle commonTitle;
  private int d = -1;
  @BindView(2131691679)
  RangeBar rangebar;
  @BindView(2131689912)
  TextView tvPrice;
  @BindView(2131690953)
  TextView tvSave;
  
  private void a()
  {
    this.rangebar.setTickCount(121);
    this.rangebar.setTickHeight(0.0F);
    this.rangebar.setConnectingLineWeight(1.0F);
    this.rangebar.setOnRangeBarChangeListener(new RangeBar.a()
    {
      public void onIndexChangeListener(RangeBar paramAnonymousRangeBar, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        MinsuPriceActivity.a(MinsuPriceActivity.this, paramAnonymousInt1, paramAnonymousInt2);
        d.d("lanzhihong", "leftThumbIndex==" + paramAnonymousInt1 + "===rightThumbIndex==" + paramAnonymousInt2);
      }
    });
    a(this.c, this.d);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.tvPrice.setText(b(paramInt1, paramInt2));
    if (((paramInt1 == 0) || (paramInt1 == -1)) && ((paramInt2 == 120) || (paramInt2 == -1)))
    {
      this.tvSave.setBackgroundColor(getResources().getColor(2131624046));
      this.tvSave.setEnabled(false);
    }
    for (;;)
    {
      this.a = String.valueOf(this.c * 10);
      this.b = String.valueOf(this.d * 10);
      v.onClick(this, "M-Search_pricechose", "start=" + this.a + "&end=" + this.b);
      return;
      this.tvSave.setBackgroundColor(getResources().getColor(2131624475));
      this.tvSave.setEnabled(true);
    }
  }
  
  private String b(int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 0) || (paramInt1 == -1)) && ((paramInt2 == 120) || (paramInt2 == -1))) {
      return ApplicationEx.c.getString(2131297339);
    }
    if ((paramInt1 == 0) || (paramInt1 == -1)) {
      return ApplicationEx.c.getString(2131297340).replace("price", paramInt2 * 10 + "");
    }
    if ((paramInt2 == 120) || (paramInt2 == -1)) {
      return ApplicationEx.c.getString(2131297341).replace("price", paramInt1 * 10 + "");
    }
    return ApplicationEx.c.getString(2131297342).replace("min", "" + paramInt1 * 10).replace("max", "" + paramInt2 * 10);
  }
  
  public void finish()
  {
    super.finish();
    k.animFinishAlpha(this);
  }
  
  public void initTitle()
  {
    this.commonTitle.showRightText(false, null);
    this.commonTitle.setLeftButtonType(4);
    this.commonTitle.setBottomLineVisible(false);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuPriceActivity.this.setResult(0);
        MinsuPriceActivity.this.finish();
      }
    });
  }
  
  @OnClick({2131690953})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.c * 10 == 0) {
      this.c = -1;
    }
    if (this.d * 10 == 1200) {
      this.d = -1;
    }
    paramView = new Intent();
    if (this.c == -1)
    {
      i = -1;
      paramView.putExtra("priceStart", i);
      if (this.d != -1) {
        break label107;
      }
    }
    label107:
    for (int i = -1;; i = this.d * 10 * 100)
    {
      paramView.putExtra("priceEnd", i);
      setResult(-1, paramView);
      finish();
      return;
      i = this.c * 10 * 100;
      break;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903331);
    ButterKnife.bind(this);
    initTitle();
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuPriceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */