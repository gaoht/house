package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import com.baidu.mapapi.BMapManager;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuHouseTypeActivity
  extends BaseActivity
{
  private int a = -1;
  @BindView(2131691422)
  CheckBox cbHouse;
  @BindView(2131691425)
  CheckBox cbRoom;
  @BindView(2131691272)
  CommonTitle commonTitle;
  @BindView(2131691420)
  RelativeLayout rlHouse;
  @BindView(2131691423)
  RelativeLayout rlRoom;
  @BindView(2131690953)
  TextView tvSave;
  
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
        MinsuHouseTypeActivity.this.setResult(0);
        MinsuHouseTypeActivity.this.finish();
      }
    });
  }
  
  @OnCheckedChanged({2131691422, 2131691425})
  public void onChecked(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      switch (paramCompoundButton.getId())
      {
      }
      for (;;)
      {
        this.tvSave.setBackgroundColor(getResources().getColor(2131624475));
        this.tvSave.setEnabled(true);
        return;
        this.a = 0;
        this.cbRoom.setChecked(false);
        continue;
        this.a = 1;
        this.cbHouse.setChecked(false);
      }
    }
    this.tvSave.setBackgroundColor(getResources().getColor(2131624046));
    this.tvSave.setEnabled(false);
    this.a = -1;
  }
  
  @OnClick({2131691420, 2131691423, 2131690953})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691420: 
      if (this.a == 0) {
        this.cbHouse.setChecked(false);
      }
      for (this.a = 1;; this.a = 0)
      {
        this.cbRoom.setChecked(false);
        v.onClick(BMapManager.getContext(), "M-Whole_rent");
        return;
        this.cbHouse.setChecked(true);
      }
    case 2131691423: 
      if (this.a == 1)
      {
        this.a = 0;
        this.cbRoom.setChecked(false);
      }
      for (;;)
      {
        this.cbHouse.setChecked(false);
        v.onClick(BMapManager.getContext(), "M-Partment_rent");
        return;
        this.a = 1;
        this.cbRoom.setChecked(true);
      }
    }
    paramView = new Intent();
    paramView.putExtra("houseType", this.a);
    setResult(-1, paramView);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903285);
    ButterKnife.bind(this);
    initTitle();
    this.a = getIntent().getIntExtra("houseType", -1);
    if (this.a == 0) {
      this.cbHouse.setChecked(true);
    }
    while (this.a != 1) {
      return;
    }
    this.cbRoom.setChecked(true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuHouseTypeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */