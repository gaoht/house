package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.baidu.mapapi.BMapManager;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuPersonActiity
  extends BaseActivity
{
  private String a;
  @BindView(2131689574)
  ImageView add;
  @BindView(2131691272)
  CommonTitle commonTitle;
  @BindView(2131691636)
  LinearLayout llMapBottom;
  @BindView(2131691634)
  ImageView reduce;
  @BindView(2131691635)
  TextView tvPersonNum;
  @BindView(2131691637)
  TextView tvResetMap;
  @BindView(2131690953)
  TextView tvSave;
  @BindView(2131691638)
  TextView tvSearchMap;
  
  private void b(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("personNum", paramInt);
    setResult(-1, localIntent);
    finish();
  }
  
  private void c(int paramInt)
  {
    v.onClick(BMapManager.getContext(), "M-People_number_choice");
    if ("9+".equals(this.tvPersonNum.getText().toString())) {}
    for (Object localObject2 = Integer.valueOf(10);; localObject2 = Integer.valueOf(Integer.parseInt(this.tvPersonNum.getText().toString())))
    {
      Object localObject1 = localObject2;
      if (paramInt == 1)
      {
        this.reduce.setEnabled(true);
        localObject2 = Integer.valueOf(((Integer)localObject2).intValue() + 1);
        localObject1 = localObject2;
        if (((Integer)localObject2).intValue() >= 10)
        {
          localObject1 = Integer.valueOf(10);
          this.add.setEnabled(false);
        }
      }
      localObject2 = localObject1;
      if (paramInt == -1)
      {
        this.add.setEnabled(true);
        localObject1 = Integer.valueOf(((Integer)localObject1).intValue() - 1);
        localObject2 = localObject1;
        if (((Integer)localObject1).intValue() <= 1)
        {
          localObject2 = Integer.valueOf(1);
          this.reduce.setEnabled(false);
        }
      }
      if (((Integer)localObject2).intValue() <= 9) {
        break;
      }
      this.tvPersonNum.setText("9+");
      return;
    }
    this.tvPersonNum.setText(localObject2 + "");
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
        MinsuPersonActiity.this.setResult(0);
        MinsuPersonActiity.this.finish();
      }
    });
  }
  
  @OnClick({2131691634, 2131689574, 2131690953, 2131691637, 2131691638})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691634: 
      c(-1);
      return;
    case 2131689574: 
      c(1);
      return;
    case 2131690953: 
    case 2131691638: 
      if ("9+".equals(this.tvPersonNum.getText().toString())) {}
      for (int i = 10;; i = Integer.parseInt(this.tvPersonNum.getText().toString()))
      {
        b(i);
        return;
      }
    }
    this.tvPersonNum.setText("2");
    c(-1);
    b(0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903321);
    ButterKnife.bind(this);
    this.a = getIntent().getStringExtra("from");
    initTitle();
    int i = getIntent().getIntExtra("personNum", 1);
    if (i <= 1) {
      this.reduce.setEnabled(false);
    }
    if (i > 9) {
      this.tvPersonNum.setText("9+");
    }
    while ("map".equals(this.a))
    {
      this.llMapBottom.setVisibility(0);
      this.tvSave.setVisibility(8);
      return;
      this.tvPersonNum.setText(i + "");
    }
    this.llMapBottom.setVisibility(8);
    this.tvSave.setVisibility(0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuPersonActiity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */