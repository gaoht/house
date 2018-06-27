package com.ziroom.ziroomcustomer.newclean.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.widget.HorizontalListView;

public class CleanSelectTimeActivity
  extends BaseActivity
  implements e.b
{
  private Unbinder a;
  private CleanSelectTimeActivity b;
  private e.a c;
  @BindView(2131689973)
  MyGridView mGvHome;
  @BindView(2131689972)
  HorizontalListView mHlData;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131689956)
  TextView mTvCommit;
  
  private void a()
  {
    new f(this);
    this.c.start();
  }
  
  private void b()
  {
    this.mIvBack.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanSelectTimeActivity.this.finish();
      }
    });
    this.mHlData.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        CleanSelectTimeActivity.a(CleanSelectTimeActivity.this).dataClick(paramAnonymousInt);
      }
    });
    this.mGvHome.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        CleanSelectTimeActivity.a(CleanSelectTimeActivity.this).timeClick(paramAnonymousInt);
      }
    });
    this.mTvCommit.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanSelectTimeActivity.a(CleanSelectTimeActivity.this).setCommit();
      }
    });
  }
  
  public BaseActivity getActivity()
  {
    return this;
  }
  
  public Intent getExtras()
  {
    return getIntent();
  }
  
  public Context getViewContext()
  {
    return this.b;
  }
  
  public MyGridView getmGvHome()
  {
    return this.mGvHome;
  }
  
  public HorizontalListView getmHlData()
  {
    return this.mHlData;
  }
  
  public TextView getmTvCommit()
  {
    return this.mTvCommit;
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903187);
    this.a = ButterKnife.bind(this);
    this.b = this;
    a();
    b();
  }
  
  public void setPresenter(e.a parama)
  {
    this.c = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/CleanSelectTimeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */