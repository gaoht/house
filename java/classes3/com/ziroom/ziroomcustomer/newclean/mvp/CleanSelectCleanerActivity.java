package com.ziroom.ziroomcustomer.newclean.mvp;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;

public class CleanSelectCleanerActivity
  extends BaseActivity
  implements c.b
{
  private Unbinder a;
  private c.a b;
  private CleanSelectCleanerActivity c;
  @BindView(2131690327)
  ImageView mIvPull;
  @BindView(2131690328)
  LinearLayout mLlCommend;
  @BindView(2131690323)
  LinearLayout mLlHistory;
  @BindView(2131690325)
  LinearLayout mLlMore;
  @BindView(2131690329)
  ListViewForScrollView mLsvCommend;
  @BindView(2131690324)
  ListViewForScrollView mLsvHistory;
  @BindView(2131690326)
  TextView mTvMore;
  
  private void a()
  {
    new d(this);
    this.b.start();
  }
  
  public Context getViewContext()
  {
    return this.c;
  }
  
  public ImageView getmIvPull()
  {
    return this.mIvPull;
  }
  
  public LinearLayout getmLlCommend()
  {
    return this.mLlCommend;
  }
  
  public LinearLayout getmLlHistory()
  {
    return this.mLlHistory;
  }
  
  public LinearLayout getmLlMore()
  {
    return this.mLlMore;
  }
  
  public ListViewForScrollView getmLsvCommend()
  {
    return this.mLsvCommend;
  }
  
  public ListViewForScrollView getmLsvHistory()
  {
    return this.mLsvHistory;
  }
  
  public TextView getmTvMore()
  {
    return this.mTvMore;
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903150);
    this.c = this;
    this.a = ButterKnife.bind(this);
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.unbind();
  }
  
  public void setPresenter(c.a parama)
  {
    this.b = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/CleanSelectCleanerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */