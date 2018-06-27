package com.ziroom.credit.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.f;
import com.ziroom.commonlib.utils.r;
import com.ziroom.credit.R.drawable;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.base.CreditBaseActivity;
import com.ziroom.credit.view.CreditCommonTitle;
import com.ziroom.credit.view.ObservableScrollView;
import com.ziroom.credit.view.ObservableScrollView.a;
import com.ziroom.datacenter.c.c;
import com.ziroom.datacenter.remote.f.b;
import com.ziroom.datacenter.remote.responsebody.financial.b.d;
import com.ziroom.datacenter.remote.responsebody.financial.b.i;
import com.ziroom.router.activityrouter.Routers;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CreditScorePromoteActivity
  extends CreditBaseActivity
  implements View.OnClickListener, y.b, ObservableScrollView.a
{
  private TextView d;
  private TextView e;
  private LinearLayout f;
  private ImageView g;
  private LinearLayout h;
  private LinearLayout i;
  private LinearLayout j;
  private LinearLayout k;
  private LinearLayout l;
  private LinearLayout m;
  private LinearLayout n;
  private View o;
  private View p;
  private View q;
  private View r;
  private View s;
  private View t;
  private ObservableScrollView u;
  private View v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void a(List<d> paramList)
  {
    this.n.removeAllViews();
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        d locald = (d)paramList.next();
        final View localView1 = LayoutInflater.from(this).inflate(R.layout.credit_include_score_promote_item, null);
        this.n.addView(localView1);
        View localView2 = new View(this);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
        localLayoutParams.setMargins(f.dp2px(18.0F), 0, 0, 0);
        localView2.setLayoutParams(localLayoutParams);
        localView2.setBackgroundColor(-1118482);
        this.n.addView(localView2);
        ((ImageView)localView1.findViewById(R.id.credit_img)).setImageResource(R.drawable.credit_zrk_ic_cdt_life);
        ((TextView)localView1.findViewById(R.id.credit_tv_content)).setText("生活代缴费用");
        localView1.setTag(locald);
        localView1.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = (d)localView1.getTag();
            Routers.open(CreditScorePromoteActivity.this, "ziroomCustomer://zrRentModule/costOfLivingBill?mContractCode=" + paramAnonymousView.getOutContractCode() + "&notPayLiving=NotPayLiving");
          }
        });
      }
    }
  }
  
  protected int c()
  {
    return R.layout.credit_activity_score_promote;
  }
  
  protected void d()
  {
    setTitleText("自如分提升");
    this.n = ((LinearLayout)findViewById(R.id.credit_ll_other));
    this.d = ((TextView)findViewById(R.id.credit_tv_task_num));
    this.e = ((TextView)findViewById(R.id.credit_tv_no_data));
    this.h = ((LinearLayout)findViewById(R.id.credit_ll_real_name));
    this.i = ((LinearLayout)findViewById(R.id.credit_ll_education));
    this.j = ((LinearLayout)findViewById(R.id.credit_ll_work));
    this.k = ((LinearLayout)findViewById(R.id.credit_ll_linked));
    this.l = ((LinearLayout)findViewById(R.id.credit_ll_zhima));
    this.m = ((LinearLayout)findViewById(R.id.credit_ll_maimai));
    this.o = findViewById(R.id.credit_v_real_name);
    this.p = findViewById(R.id.credit_v_education);
    this.q = findViewById(R.id.credit_v_work);
    this.r = findViewById(R.id.credit_v_linked);
    this.s = findViewById(R.id.credit_v_zhima);
    this.t = findViewById(R.id.credit_v_maimai);
    this.u = ((ObservableScrollView)findViewById(R.id.credit_osv));
    this.w = ((TextView)findViewById(R.id.credit_tv_min_score));
    this.x = ((TextView)findViewById(R.id.credit_tv_min_level));
    this.y = ((TextView)findViewById(R.id.credit_tv_max_score));
    this.z = ((TextView)findViewById(R.id.credit_tv_max_level));
    this.g = ((ImageView)findViewById(R.id.credit_iv));
    this.f = ((LinearLayout)findViewById(R.id.credit_ll_max));
    this.u.setOverScrollMode(2);
    this.v = findViewById(R.id.credit_bottom_line);
    this.v.setVisibility(8);
  }
  
  protected y.a e()
  {
    return new z(this);
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  public void gotoSignerCareerInfoActivity(i parami)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", parami.getType());
    localBundle.putString("logo", parami.getLogo());
    localBundle.putInt("status", parami.getStatus());
    localBundle.putString("desc", parami.getDesc());
    localBundle.putString("link", parami.getUrl());
    localBundle.putString("maimaiClass", CreditThirdAuthorizationActivity.class.getName());
    Routers.open(this, "ziroomCustomer://zrRentModule/OccupationBinding", localBundle);
  }
  
  public void initData()
  {
    ((ImageView)this.h.findViewById(R.id.credit_img)).setImageResource(R.drawable.credit_zrk_ic_cdt_idinfo2);
    ((TextView)this.h.findViewById(R.id.credit_tv_content)).setText("完成实名认证");
    ((ImageView)this.i.findViewById(R.id.credit_img)).setImageResource(R.drawable.credit_zrk_ic_cdt_eduinfo2);
    ((TextView)this.i.findViewById(R.id.credit_tv_content)).setText("完成学历信息录入");
    ((ImageView)this.j.findViewById(R.id.credit_img)).setImageResource(R.drawable.credit_zrk_ic_cdt_zizhi);
    ((TextView)this.j.findViewById(R.id.credit_tv_content)).setText("完成工作信息录入");
    ((ImageView)this.k.findViewById(R.id.credit_img)).setImageResource(R.drawable.credit_zrk_ic_cdt_lingying);
    ((TextView)this.k.findViewById(R.id.credit_tv_content)).setText("关联linkedin");
    ((ImageView)this.l.findViewById(R.id.credit_img)).setImageResource(R.drawable.credit_zrk_ic_cdt_zhima);
    ((TextView)this.l.findViewById(R.id.credit_tv_content)).setText("授权芝麻信用");
    ((ImageView)this.m.findViewById(R.id.credit_img)).setImageResource(R.drawable.credit_zrk_ic_cdt_maimai);
    ((TextView)this.m.findViewById(R.id.credit_tv_content)).setText("关联脉脉");
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    this.j.setVisibility(8);
    this.k.setVisibility(8);
    this.l.setVisibility(8);
    this.m.setVisibility(8);
    this.o.setVisibility(8);
    this.p.setVisibility(8);
    this.q.setVisibility(8);
    this.r.setVisibility(8);
    this.s.setVisibility(8);
    this.t.setVisibility(8);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.u.setOnScrollChangedCallback(this);
    this.c.getBackground().setAlpha(0);
    this.c.setCreditTitleStatic(false);
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
    if (i1 == R.id.credit_ll_real_name) {
      ((y.a)this.a).setRealNameOnClick();
    }
    do
    {
      return;
      if (i1 == R.id.credit_ll_education)
      {
        Routers.open(this, "ziroomCustomer://zrRentModule/educationalInfo");
        return;
      }
      if (i1 == R.id.credit_ll_work)
      {
        Routers.open(this, "ziroomCustomer://zrRentModule/qualificationInfo?activityName=AccountInfoActivity");
        return;
      }
      if (i1 == R.id.credit_ll_linked)
      {
        paramView = c.buildUid();
        paramView = toURLencoded(String.format(b.x + "credits/linkedin?uid=%s&sign=%s&timestamp=%s", new Object[] { paramView.get("uid"), paramView.get("sign"), paramView.get("timestamp") }));
        Routers.open(this, "ziroomCustomer://zrRentModule/h5WJFunction?url=" + paramView + "&title=领英&isUniCode=1");
        return;
      }
      if (i1 == R.id.credit_ll_zhima)
      {
        ((y.a)this.a).setZhimaOnClick();
        return;
      }
    } while (i1 != R.id.credit_ll_maimai);
    ((y.a)this.a).setMaimaiOnClick();
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    float f2 = paramInt2 / 500.0F;
    if (f2 > 0.2D)
    {
      this.c.setCreditTitleStatic(true);
      if (f2 <= 1.0F) {
        break label63;
      }
    }
    for (;;)
    {
      this.c.getBackground().setAlpha((int)(f1 * 255.0F));
      return;
      this.c.setCreditTitleStatic(false);
      break;
      label63:
      f1 = f2;
    }
  }
  
  public void setBillsData(List<d> paramList)
  {
    a(paramList);
  }
  
  public void setDataCount(int paramInt)
  {
    if (paramInt == 0) {
      this.e.setVisibility(0);
    }
    this.d.setText(paramInt + "");
  }
  
  public void setEducationVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      this.i.setVisibility(i1);
      this.p.setVisibility(i1);
      return;
    }
  }
  
  public void setLinkedVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      this.k.setVisibility(i1);
      this.r.setVisibility(i1);
      return;
    }
  }
  
  public void setMaimaiVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      this.m.setVisibility(i1);
      this.t.setVisibility(i1);
      return;
    }
  }
  
  public void setPresenter(y.a parama)
  {
    this.a = parama;
  }
  
  public void setRealNameVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      this.h.setVisibility(i1);
      this.o.setVisibility(i1);
      return;
    }
  }
  
  public void setUserScoreInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.w.setText(paramString1);
    this.x.setText(paramString2);
    this.y.setText(paramString3 + "");
    this.z.setText(paramString4 + "");
    if (r.isNull(paramString3))
    {
      this.f.setVisibility(8);
      this.g.setVisibility(8);
    }
  }
  
  public void setWorkVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      this.j.setVisibility(i1);
      this.q.setVisibility(i1);
      return;
    }
  }
  
  public void setZhimaUrl(String paramString)
  {
    paramString = toURLencoded(paramString);
    Routers.open(this, "ziroomCustomer://zrCreditModule/zmAuthorizationView?ZiMaUrl=" + paramString);
  }
  
  public void setZhimaVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      this.l.setVisibility(i1);
      this.s.setVisibility(i1);
      return;
    }
  }
  
  public String toURLencoded(String paramString)
  {
    if (r.isNull(paramString)) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(new String(paramString.getBytes(), "UTF-8"), "UTF-8");
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditScorePromoteActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */