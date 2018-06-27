package com.ziroom.credit.main;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.f;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.base.CreditBaseActivity;
import com.ziroom.credit.view.InstrumentView;
import com.ziroom.credit.view.InstrumentView.a;
import com.ziroom.credit.view.TextViewDrawable;
import com.ziroom.credit.view.a.a;
import com.ziroom.datacenter.remote.responsebody.financial.b.b;
import com.ziroom.router.activityrouter.Routers;
import java.util.List;

public class CreditScoreActivity
  extends CreditBaseActivity
  implements View.OnClickListener, w.b
{
  private InstrumentView d;
  private TextView e;
  private TextView f;
  private TextViewDrawable g;
  private ImageView h;
  private TextView i;
  private LinearLayout j;
  private ImageView k;
  private TextView l;
  private LinearLayout m;
  private ImageView n;
  private TextView o;
  private LinearLayout p;
  private ImageView q;
  private TextView r;
  private LinearLayout s;
  private LinearLayout t;
  private RecyclerView u;
  
  private void a(List<b> paramList)
  {
    paramList = new a(this, R.layout.credit_item_score_banar, paramList)
    {
      protected void a(com.ziroom.credit.view.a.a.c paramAnonymousc, final b paramAnonymousb, int paramAnonymousInt)
      {
        SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)paramAnonymousc.getView(R.id.credit_img);
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(f.getScreenWidth() - CreditScoreActivity.dip2px(CreditScoreActivity.this, 44.0F), -1);
        paramAnonymousc.getConvertView().setLayoutParams(localLayoutParams);
        localSimpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(CreditScoreActivity.this.getResources()).setFadeDuration(300).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build());
        localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousb.getImg()));
        localSimpleDraweeView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            Routers.open(CreditScoreActivity.this, "ziroomCustomer://zrRentModule/h5WJFunction?url=" + paramAnonymousb.getTarget().toString() + "&title=" + paramAnonymousb.getTitle());
          }
        });
      }
    };
    this.u.addItemDecoration(new a());
    this.u.setHasFixedSize(true);
    StaggeredGridLayoutManager localStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 0);
    this.u.setLayoutManager(localStaggeredGridLayoutManager);
    this.u.setAdapter(paramList);
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat / 1.5D + 0.5D);
  }
  
  protected int c()
  {
    return R.layout.credit_activity_score;
  }
  
  protected void d()
  {
    setTitleText("自如分");
    this.d = ((InstrumentView)findViewById(R.id.credit_instrument));
    this.e = ((TextView)findViewById(R.id.credit_tv_score));
    this.f = ((TextView)findViewById(R.id.credit_tv_level));
    this.g = ((TextViewDrawable)findViewById(R.id.credit_tv_promote));
    this.h = ((ImageView)findViewById(R.id.credit_img_analyze));
    this.i = ((TextView)findViewById(R.id.credit_tv_analyze));
    this.j = ((LinearLayout)findViewById(R.id.credit_ll_analyze));
    this.k = ((ImageView)findViewById(R.id.credit_img_medal));
    this.l = ((TextView)findViewById(R.id.credit_tv_medal));
    this.m = ((LinearLayout)findViewById(R.id.credit_ll_medal));
    this.n = ((ImageView)findViewById(R.id.credit_img_right));
    this.o = ((TextView)findViewById(R.id.credit_tv_right));
    this.p = ((LinearLayout)findViewById(R.id.credit_ll_right));
    this.q = ((ImageView)findViewById(R.id.credit_img_manage));
    this.r = ((TextView)findViewById(R.id.credit_tv_manage));
    this.s = ((LinearLayout)findViewById(R.id.credit_ll_manage));
    this.t = ((LinearLayout)findViewById(R.id.credit_ll));
    this.u = ((RecyclerView)findViewById(R.id.credit_recycler_view));
    this.g.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.m.setOnClickListener(this);
  }
  
  protected w.a e()
  {
    return new x(this);
  }
  
  public void getBannerData(List<b> paramList)
  {
    a(paramList);
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  protected void initData()
  {
    int i1 = (f.getScreenWidth() - dip2px(this, 44.0F)) * 190 / 339;
    this.u.getLayoutParams().height = i1;
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i1 = paramView.getId();
    if (i1 == R.id.credit_tv_promote) {
      Routers.open(this, "ziroomCustomer://zrCreditModule/scorePromoteView");
    }
    do
    {
      return;
      if (i1 == R.id.credit_ll_analyze)
      {
        Routers.open(this, "ziroomCustomer://zrCreditModule/scoreInterpretationView");
        return;
      }
      if (i1 == R.id.credit_ll_medal)
      {
        Routers.open(this, "ziroomCustomer://zrCreditModule/medalListView");
        return;
      }
      if (i1 == R.id.credit_ll_right)
      {
        Routers.open(this, "ziroomCustomer://zrCreditModule/benefitListView");
        return;
      }
    } while (i1 != R.id.credit_ll_manage);
    Routers.open(this, "ziroomCustomer://zrCreditModule/managerListView");
  }
  
  public void setLevelText(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public void setPresenter(w.a parama)
  {
    this.a = parama;
  }
  
  public void setPromoteVisible(int paramInt)
  {
    this.g.setVisibility(paramInt);
  }
  
  public void setScore(int paramInt)
  {
    this.e.setText(paramInt + "");
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    this.d.setReferValue(i1, new InstrumentView.a()
    {
      public void rotate(float paramAnonymousFloat1, final float paramAnonymousFloat2, int paramAnonymousInt)
      {
        CreditScoreActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            CreditScoreActivity.a(CreditScoreActivity.this).setText((int)paramAnonymousFloat2 + "");
          }
        });
      }
    });
  }
  
  class a
    extends RecyclerView.g
  {
    a() {}
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.r paramr)
    {
      paramRect.set(0, 0, CreditScoreActivity.dip2px(CreditScoreActivity.this, 6.0F), 0);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditScoreActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */