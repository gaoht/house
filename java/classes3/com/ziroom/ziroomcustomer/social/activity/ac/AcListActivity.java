package com.ziroom.ziroomcustomer.social.activity.ac;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.d.f.a;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.social.a.c;
import com.ziroom.ziroomcustomer.social.model.m;
import com.ziroom.ziroomcustomer.social.model.m.a;
import java.util.ArrayList;
import java.util.List;

public class AcListActivity
  extends BaseActivity
{
  private c a;
  private List<m.a> b = new ArrayList();
  private String c = "110000";
  private int d = 1;
  private int e = 10;
  private boolean f = true;
  private int g = 5;
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131689834)
  LinearLayout mLlTips;
  @BindView(2131689817)
  ListView mLv;
  @BindView(2131689832)
  TextView mTvEnd;
  @BindView(2131689829)
  TextView mTvRunning;
  @BindView(2131689835)
  TextView mTvTips;
  @BindView(2131689833)
  View mVEndIndicator;
  @BindView(2131689830)
  View mVRunningIndicator;
  private final int r = 5;
  private final int s = 6;
  private String t;
  private boolean u;
  private com.ziroom.ziroomcustomer.e.a.f<m> v = new com.ziroom.ziroomcustomer.e.a.f(this, new com.ziroom.ziroomcustomer.e.c.f(m.class))
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      AcListActivity.b(AcListActivity.this, false);
    }
    
    public void onSuccess(int paramAnonymousInt, m paramAnonymousm)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousm);
      if ((paramAnonymousm != null) && (paramAnonymousm.getList() != null))
      {
        AcListActivity.c(AcListActivity.this);
        if (paramAnonymousm.getList().size() < AcListActivity.d(AcListActivity.this)) {
          AcListActivity.a(AcListActivity.this, false);
        }
        AcListActivity.e(AcListActivity.this).addAll(paramAnonymousm.getList());
        AcListActivity.f(AcListActivity.this).notifyDataSetChanged();
      }
      AcListActivity.this.mLv.setEmptyView(AcListActivity.this.mLlTips);
      AcListActivity.b(AcListActivity.this, false);
    }
  };
  
  private void a()
  {
    String str = getIntent().getStringExtra("cityCode");
    this.t = getIntent().getStringExtra("from");
    if (!TextUtils.isEmpty(str)) {
      this.c = getIntent().getStringExtra("cityCode");
    }
    this.d = 1;
    this.f = true;
    this.b = new ArrayList();
    this.a = new c(this, this.b);
    this.mLv.setAdapter(this.a);
    this.mLv.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (AcListActivity.this.mLv.getChildAt(AcListActivity.this.mLv.getChildCount() - 1) != null) && (!AcListActivity.a(AcListActivity.this)))
        {
          d.d("ListView", "##### 滚动到底部 ######");
          AcListActivity.b(AcListActivity.this);
        }
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.mLv.setEmptyView(null);
    b();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mTvRunning.setTextColor(getResources().getColor(2131624588));
      this.mTvEnd.setTextColor(getResources().getColor(2131624417));
      this.mVRunningIndicator.setVisibility(0);
      this.mVEndIndicator.setVisibility(8);
      return;
    }
    this.mTvRunning.setTextColor(getResources().getColor(2131624417));
    this.mTvEnd.setTextColor(getResources().getColor(2131624588));
    this.mVRunningIndicator.setVisibility(8);
    this.mVEndIndicator.setVisibility(0);
  }
  
  private void b()
  {
    if (this.f)
    {
      this.u = true;
      j.getAcList(this, this.c, this.d, this.e, this.g, this.t, this.v);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903084);
    ButterKnife.bind(this);
    a();
  }
  
  @OnClick({2131689492, 2131689828, 2131689831})
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
        finish();
        return;
        a(true);
      } while (this.g == 5);
      this.g = 5;
      this.mTvTips.setText("新活动还未发布哦~");
      a();
      return;
      a(false);
    } while (this.g == 6);
    this.g = 6;
    this.mTvTips.setText("活动都还在进行中呢~");
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/ac/AcListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */