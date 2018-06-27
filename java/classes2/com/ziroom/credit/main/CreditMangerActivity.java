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
import com.ziroom.credit.base.CreditBaseActivity;
import com.ziroom.credit.view.ObservableScrollView;
import com.ziroom.credit.view.ObservableScrollView.a;

public class CreditMangerActivity
  extends CreditBaseActivity
  implements View.OnClickListener, g.b
{
  private ImageView d;
  private LinearLayout e;
  private LinearLayout f;
  private LinearLayout g;
  private LinearLayout h;
  private LinearLayout i;
  private LinearLayout j;
  private View k;
  private ObservableScrollView l;
  
  protected int c()
  {
    return R.layout.credit_activity_manger;
  }
  
  protected void d()
  {
    this.d = ((ImageView)findViewById(R.id.credit_iv_back));
    this.e = ((LinearLayout)findViewById(R.id.credit_ll_cm_identity));
    this.f = ((LinearLayout)findViewById(R.id.credit_ll_cm_school));
    this.g = ((LinearLayout)findViewById(R.id.credit_ll_cm_work));
    this.h = ((LinearLayout)findViewById(R.id.credit_ll_cm_ziroomscore));
    this.i = ((LinearLayout)findViewById(R.id.credit_ll_cm_thirdauthority));
    this.j = ((LinearLayout)findViewById(R.id.credit_ll_cm_wrong));
    this.l = ((ObservableScrollView)findViewById(R.id.credit_scrollview));
    this.k = findViewById(R.id.credit_v);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.l.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (paramAnonymousInt2 > 1)
        {
          CreditMangerActivity.a(CreditMangerActivity.this).setVisibility(0);
          return;
        }
        CreditMangerActivity.a(CreditMangerActivity.this).setVisibility(8);
      }
    });
  }
  
  protected g.a e()
  {
    return new h(this);
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
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int m = paramView.getId();
    if (m == R.id.credit_iv_back) {
      finish();
    }
    do
    {
      return;
      if (m == R.id.credit_ll_cm_identity)
      {
        ((g.a)this.a).setIdentityOnClick();
        return;
      }
      if (m == R.id.credit_ll_cm_school)
      {
        ((g.a)this.a).setSchoolOnClick();
        return;
      }
      if (m == R.id.credit_ll_cm_work)
      {
        ((g.a)this.a).setWorkOnClick();
        return;
      }
      if (m == R.id.credit_ll_cm_ziroomscore)
      {
        ((g.a)this.a).setZiroomscoreOnClick();
        return;
      }
      if (m == R.id.credit_ll_cm_thirdauthority)
      {
        ((g.a)this.a).setThirdOnClick();
        return;
      }
    } while (m != R.id.credit_ll_cm_wrong);
    ((g.a)this.a).setWrongOnClick();
  }
  
  public void setPresenter(g.a parama)
  {
    this.a = parama;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditMangerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */