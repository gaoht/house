package com.ziroom.ziroomcustomer.sublet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.widget.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail;
import com.ziroom.ziroomcustomer.sublet.widget.LuxuryHouseShareView;
import com.ziroom.ziroomcustomer.sublet.widget.SubletHouseShareView;

public class SubletHouseShareActivity
  extends BaseActivity
{
  private int a;
  @BindView(2131692589)
  LuxuryHouseShareView luxuryShareView;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131692588)
  SubletHouseShareView mSubletShareView;
  @BindView(2131692590)
  TextView mTvSavePic;
  @BindView(2131689826)
  TextView mTvShare;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903524);
    ButterKnife.bind(this);
    paramBundle = (RentHouseDetail)getIntent().getSerializableExtra("houseDetail");
    this.a = paramBundle.getHouse_type();
    if (8 == this.a)
    {
      this.mSubletShareView.setVisibility(8);
      this.luxuryShareView.setVisibility(0);
      this.luxuryShareView.setContent(paramBundle);
      return;
    }
    this.mSubletShareView.setVisibility(0);
    this.luxuryShareView.setVisibility(8);
    this.mSubletShareView.setContent(paramBundle);
  }
  
  @OnClick({2131692590, 2131689826, 2131689492})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692590: 
      a.show(this, "", false, false);
      if (8 == this.a)
      {
        this.luxuryShareView.toSave();
        return;
      }
      this.mSubletShareView.toSave();
      return;
    case 2131689826: 
      a.show(this, "", false, false);
      if (8 == this.a)
      {
        this.luxuryShareView.toShare();
        return;
      }
      this.mSubletShareView.toShare();
      return;
    }
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/SubletHouseShareActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */