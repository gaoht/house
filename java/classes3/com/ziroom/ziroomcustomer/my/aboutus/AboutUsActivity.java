package com.ziroom.ziroomcustomer.my.aboutus;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class AboutUsActivity
  extends BaseActivity
  implements a.b
{
  private Unbinder a;
  private a.a b;
  @BindView(2131695951)
  View commonTitleDivideLine;
  @BindView(2131695948)
  ImageView commonTitleIvBack;
  @BindView(2131695950)
  TextView commonTitleTvRightButton;
  @BindView(2131695949)
  TextView commonTitleTvTitle;
  @BindView(2131689805)
  LinearLayout llCurrVersion;
  @BindView(2131689804)
  LinearLayout llServiceAndHelp;
  @BindView(2131689807)
  TextView tvCurrentVersion;
  @BindView(2131689806)
  View viewHasUpdateSign;
  
  public Context getViewContext()
  {
    return this;
  }
  
  public void initView()
  {
    this.commonTitleTvTitle.setVisibility(8);
    this.commonTitleTvRightButton.setVisibility(8);
    this.commonTitleDivideLine.setVisibility(8);
  }
  
  public boolean isActive()
  {
    return isActive();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903078);
    this.a = ButterKnife.bind(this);
    initView();
    this.b = new b(this);
    this.b.initData();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    super.onDestroy();
  }
  
  @OnClick({2131695948, 2131689804, 2131689805})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131695948: 
      finish();
      return;
    case 2131689804: 
      this.b.toServiceAndHelp();
      return;
    }
    this.b.checkUpdate();
  }
  
  public void setPresenter(a.a parama)
  {
    this.b = parama;
  }
  
  public void showCurrVersion(String paramString)
  {
    this.tvCurrentVersion.setText(paramString);
  }
  
  public void showUpdate(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.viewHasUpdateSign.setVisibility(0);
      return;
    }
    this.viewHasUpdateSign.setVisibility(8);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/aboutus/AboutUsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */