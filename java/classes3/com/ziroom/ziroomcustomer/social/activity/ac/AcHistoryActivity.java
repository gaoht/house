package com.ziroom.ziroomcustomer.social.activity.ac;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import java.util.ArrayList;
import java.util.List;

public class AcHistoryActivity
  extends BaseActivity
{
  private int a = 1;
  private final int b = 10;
  private boolean c = true;
  private String d = "110000";
  private boolean e;
  private com.ziroom.ziroomcustomer.social.a.b f;
  private List<com.ziroom.ziroomcustomer.social.model.a> g = new ArrayList();
  @BindView(2131689492)
  ImageView mIvBack;
  @BindView(2131689818)
  LinearLayout mLlEmpty;
  @BindView(2131689827)
  ListView mLvHistory;
  private com.ziroom.ziroomcustomer.e.a.f<com.ziroom.ziroomcustomer.social.model.b> r = new com.ziroom.ziroomcustomer.e.a.f(this, new com.ziroom.ziroomcustomer.e.c.f(com.ziroom.ziroomcustomer.social.model.b.class))
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      AcHistoryActivity.b(AcHistoryActivity.this, false);
    }
    
    public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.social.model.b paramAnonymousb)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousb);
      if (paramAnonymousb != null)
      {
        if ((paramAnonymousb.getList() == null) || (paramAnonymousb.getList().size() <= 0)) {
          break label138;
        }
        paramAnonymousb = paramAnonymousb.getList();
        if (paramAnonymousb.size() < 10) {
          AcHistoryActivity.a(AcHistoryActivity.this, false);
        }
        AcHistoryActivity.d(AcHistoryActivity.this);
        if (AcHistoryActivity.e(AcHistoryActivity.this) == null) {
          AcHistoryActivity.a(AcHistoryActivity.this, new ArrayList());
        }
        AcHistoryActivity.e(AcHistoryActivity.this).addAll(paramAnonymousb);
        AcHistoryActivity.f(AcHistoryActivity.this).notifyDataSetChanged();
      }
      for (;;)
      {
        AcHistoryActivity.this.mLvHistory.setEmptyView(AcHistoryActivity.this.mLlEmpty);
        AcHistoryActivity.b(AcHistoryActivity.this, false);
        return;
        label138:
        AcHistoryActivity.a(AcHistoryActivity.this, false);
      }
    }
  };
  
  private void a()
  {
    if (this.c)
    {
      this.e = true;
      j.getAcHistory(this, this.d, this.a, 10, this.r);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903083);
    ButterKnife.bind(this);
    this.d = getIntent().getStringExtra("cityCode");
    this.f = new com.ziroom.ziroomcustomer.social.a.b(this, this.g);
    this.mLvHistory.setAdapter(this.f);
    this.mLvHistory.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (AcHistoryActivity.this.mLvHistory.getChildAt(AcHistoryActivity.this.mLvHistory.getChildCount() - 1) != null) && (!AcHistoryActivity.a(AcHistoryActivity.this)))
        {
          d.d("ListView", "##### 滚动到底部 ######");
          if (AcHistoryActivity.b(AcHistoryActivity.this)) {
            AcHistoryActivity.c(AcHistoryActivity.this);
          }
        }
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    a();
  }
  
  @OnClick({2131689492})
  public void onViewClicked()
  {
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/ac/AcHistoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */