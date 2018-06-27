package com.ziroom.credit.main;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.a.b.a;
import com.ziroom.credit.b.a;
import com.ziroom.credit.base.CreditBaseActivity;
import com.ziroom.credit.view.MyListView;
import com.ziroom.credit.view.ObservableScrollView;
import com.ziroom.credit.view.ObservableScrollView.a;
import com.ziroom.credit.view.XListView.XListView.a;
import com.ziroom.datacenter.remote.responsebody.financial.b.p;
import com.ziroom.datacenter.remote.responsebody.financial.b.p.a;
import java.util.List;

public class CreditNegativeRecordActivity
  extends CreditBaseActivity
  implements View.OnClickListener, b.a, m.b, XListView.a
{
  private ImageView d;
  private p e;
  private List<p.a> f;
  private MyListView g;
  private View h;
  private ObservableScrollView i;
  private LinearLayout j;
  
  public void appealeFaliure() {}
  
  public void appealeSuccess()
  {
    this.a.start();
  }
  
  protected int c()
  {
    return R.layout.credit_activity_negative_record;
  }
  
  protected void d()
  {
    this.d = ((ImageView)findViewById(R.id.credit_iv_close));
    this.g = ((MyListView)findViewById(R.id.credit_lv_negative));
    this.i = ((ObservableScrollView)findViewById(R.id.credit_scrollview));
    this.h = findViewById(R.id.credit_v);
    this.j = ((LinearLayout)findViewById(R.id.credit_ll_empty));
    this.d.setOnClickListener(this);
    this.i.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        View localView = CreditNegativeRecordActivity.a(CreditNegativeRecordActivity.this);
        if (paramAnonymousInt2 > 1) {}
        for (paramAnonymousInt1 = 0;; paramAnonymousInt1 = 8)
        {
          localView.setVisibility(paramAnonymousInt1);
          return;
        }
      }
    });
  }
  
  protected m.a e()
  {
    return new n(this);
  }
  
  public void getUserNegativeRecord(p paramp)
  {
    this.e = paramp;
    if (this.e != null) {
      this.f = this.e.getNegatives();
    }
    if (this.e.getData().getNegativeCount() == 0) {
      this.j.setVisibility(0);
    }
    if ((this.f != null) && (this.f.size() > 0))
    {
      this.j.setVisibility(8);
      paramp = new com.ziroom.credit.a.b(this, this.f);
      paramp.setOnAppealStatusLiatener(this);
      this.g.setAdapter(paramp);
    }
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  protected void initData() {}
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    a.closeAcAnim(this);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView.getId() == R.id.credit_iv_close) {
      onBackPressed();
    }
  }
  
  public void onLoadMore() {}
  
  public void onRefresh()
  {
    this.a.start();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void setPresenter(m.a parama) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditNegativeRecordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */