package com.ziroom.ziroomcustomer.social.activity.ac;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.social.activity.a.a.a;
import com.ziroom.ziroomcustomer.social.activity.a.a.b;
import com.ziroom.ziroomcustomer.social.activity.a.d;
import com.ziroom.ziroomcustomer.social.view.NavigationView;
import com.ziroom.ziroomcustomer.social.view.NavigationView.a;

public class AcEnrollListActivityNew
  extends BaseActivity
  implements a.b
{
  private a.a a;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131689820)
  NavigationView mNavi;
  @BindView(2131689808)
  RelativeLayout mRlTitle;
  @BindView(2131689541)
  TextView mTvTitle;
  
  private void a()
  {
    this.a = new d(this);
    this.a.start();
    this.a.initFragment(2131689821);
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  public void initNavi(String[] paramArrayOfString, int paramInt)
  {
    this.mNavi.setTitles(paramArrayOfString, paramInt);
    this.mNavi.setOnNaviChangeListener(new NavigationView.a()
    {
      public void onNaviChanged(int paramAnonymousInt)
      {
        AcEnrollListActivityNew.a(AcEnrollListActivityNew.this).switchFragment(2131689821, paramAnonymousInt);
      }
    });
  }
  
  public boolean isActive()
  {
    return (this != null) && (!isFinishing());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903081);
    ButterKnife.bind(this);
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.detachView();
  }
  
  @OnClick({2131689492})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  public void setPresenter(a.a parama)
  {
    this.a = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/ac/AcEnrollListActivityNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */