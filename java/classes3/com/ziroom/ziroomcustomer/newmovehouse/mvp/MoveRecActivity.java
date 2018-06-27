package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.common.internal.Preconditions;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceLoginActivity;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecResultRequestModel;
import com.ziroom.ziroomcustomer.widget.ScrollControlerViewPager;
import java.util.ArrayList;
import java.util.List;

public class MoveRecActivity
  extends BaseActivity
  implements b.b
{
  private Unbinder a;
  private b.a b;
  @BindView(2131691493)
  ImageView btnLeftImg;
  private List<Fragment> c = new ArrayList();
  @BindView(2131690023)
  ImageView ivChat;
  @BindView(2131689808)
  RelativeLayout rlTitle;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131691721)
  ScrollControlerViewPager viewPager;
  
  private void a() {}
  
  public static void launchActivity(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, MoveRecActivity.class));
  }
  
  @OnClick({2131691493})
  public void click(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    onBackPressed();
  }
  
  public void currentPageSelected(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      this.viewPager.setCurrentItem(paramInt, true);
      return;
      paramInt = i;
      if (this.viewPager.getCurrentItem() != 0)
      {
        paramInt = this.viewPager.getCurrentItem() - 1;
        continue;
        if (this.viewPager.getCurrentItem() == this.c.size() - 1) {
          paramInt = this.viewPager.getCurrentItem();
        } else {
          paramInt = this.viewPager.getCurrentItem() + 1;
        }
      }
    }
  }
  
  public void finishView()
  {
    finish();
  }
  
  public List<MoveRecResultRequestModel> getOptions(MoveRecResultRequestModel paramMoveRecResultRequestModel)
  {
    return this.b.getOptions(paramMoveRecResultRequestModel);
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  public void gotoLogin()
  {
    startActivity(new Intent(this, ServiceLoginActivity.class));
    finish();
  }
  
  public void initViewPager(List<Fragment> paramList)
  {
    if (paramList != null) {
      this.c = paramList;
    }
    com.ziroom.ziroomcustomer.newmovehouse.b.e locale = new com.ziroom.ziroomcustomer.newmovehouse.b.e(getSupportFragmentManager(), paramList);
    this.viewPager.setAdapter(locale);
    this.viewPager.setOffscreenPageLimit(paramList.size() - 1);
    this.viewPager.setNoScroll(false);
    this.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt) {}
    });
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setContentView(2130903346);
    this.a = ButterKnife.bind(this);
    a();
    this.b = new e(this);
    if (this.b != null) {
      this.b.start();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.unbind();
    }
    if (this.b != null) {
      this.b.detachView();
    }
  }
  
  public void setPresenter(b.a parama)
  {
    this.b = ((b.a)Preconditions.checkNotNull(parama));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/MoveRecActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */