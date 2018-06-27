package com.ziroom.ziroomcustomer.my;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar.TextButton;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.collectlist.MinsuHouseCollectListFragment;

public class MyCollectionsActivity
  extends BaseActivity
{
  private BasicZiroomToolBar.TextButton a;
  private boolean b = false;
  private final String c = "alternateList";
  private final String d = "minsu";
  private String e = "alternateList";
  private MyAlternateListFragment f;
  private MinsuHouseCollectListFragment g;
  @BindView(2131689787)
  BasicZiroomToolBar mBztb;
  @BindView(2131691891)
  FrameLayout mFrameContent;
  @BindView(2131691889)
  TextView mTvHz;
  @BindView(2131691890)
  TextView mTvMinsu;
  private View.OnClickListener r = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      paramAnonymousView = MyCollectionsActivity.this;
      boolean bool;
      if (!MyCollectionsActivity.a(MyCollectionsActivity.this))
      {
        bool = true;
        MyCollectionsActivity.a(paramAnonymousView, bool);
        if (!MyCollectionsActivity.a(MyCollectionsActivity.this)) {
          break label83;
        }
        MyCollectionsActivity.b(MyCollectionsActivity.this).setText("完成");
      }
      for (;;)
      {
        if (MyCollectionsActivity.c(MyCollectionsActivity.this) != null) {
          MyCollectionsActivity.c(MyCollectionsActivity.this).updateStatus(MyCollectionsActivity.a(MyCollectionsActivity.this));
        }
        return;
        bool = false;
        break;
        label83:
        MyCollectionsActivity.b(MyCollectionsActivity.this).setText("管理");
      }
    }
  };
  
  private void a()
  {
    this.a = this.mBztb.newButton("管理", this.r);
    this.mBztb.addButton(this.a);
    d("alternateList");
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramTextView.setTextColor(getResources().getColor(2131624588));
      paramTextView.setBackgroundResource(2130837975);
      return;
    }
    paramTextView.setTextColor(getResources().getColor(2131624416));
    paramTextView.setBackgroundResource(2131624583);
  }
  
  private void d(String paramString)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (paramString.equals("alternateList"))
        {
          i = 0;
          continue;
          if (paramString.equals("minsu")) {
            i = 1;
          }
        }
        break;
      }
    }
    this.f = MyAlternateListFragment.getInstance();
    localFragmentTransaction.replace(2131691891, this.f, "alternateList");
    localFragmentTransaction.commit();
    this.e = "alternateList";
    return;
    this.g = MinsuHouseCollectListFragment.getInstance();
    localFragmentTransaction.replace(2131691891, this.g, "minsu");
    localFragmentTransaction.commit();
    this.e = "minsu";
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.g != null) {
      this.g.refreshData(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903381);
    ButterKnife.bind(this);
    this.mBztb.setTitle("我的收藏");
    a();
  }
  
  @OnClick({2131691889, 2131691890})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while ("alternateList".equals(this.e));
      d("alternateList");
      this.b = false;
      this.a.setText("管理");
      this.a.setVisibility(0);
      a(this.mTvHz, true);
      a(this.mTvMinsu, false);
      return;
    } while ("minsu".equals(this.e));
    d("minsu");
    this.a.setVisibility(8);
    a(this.mTvHz, false);
    a(this.mTvMinsu, true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyCollectionsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */