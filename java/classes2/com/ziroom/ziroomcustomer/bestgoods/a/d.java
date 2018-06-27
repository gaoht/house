package com.ziroom.ziroomcustomer.bestgoods.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.model.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.newrepair.utils.b;
import com.ziroom.ziroomcustomer.newrepair.utils.c;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d
  extends RecyclerView.a<c>
{
  private List<f> a;
  private WeakReference<BaseActivity> b;
  private Context c;
  private b d;
  
  public d(BaseActivity paramBaseActivity, List<f> paramList)
  {
    if (paramList != null) {}
    for (this.a = paramList;; this.a = new ArrayList())
    {
      this.c = paramBaseActivity;
      this.b = new WeakReference(paramBaseActivity);
      return;
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    return m.getFormatDate(m.strToDate(paramString1, m.b), paramString2);
  }
  
  public int getItemCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public void onBindViewHolder(c paramc, final int paramInt)
  {
    final f localf = (f)this.a.get(paramInt);
    String str1;
    String str2;
    if (localf.getState() == 0)
    {
      c.a(paramc).setBackgroundResource(2130837740);
      c.b(paramc).setTextColor(this.c.getResources().getColor(2131623955));
      c.b(paramc).setBackgroundResource(2130839364);
      c.b(paramc).setText("点击领取");
      c.b(paramc).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (ApplicationEx.c.isLoginState()) {
            if (ah.checkNet(d.a(d.this)))
            {
              paramAnonymousView = new HashMap();
              paramAnonymousView.put("typeCode", localf.getTypeCode());
              j.bindingGoodsCoupon((Activity)d.b(d.this).get(), paramAnonymousView, new d.a(d.this, new b(String.class), paramInt));
            }
          }
          do
          {
            return;
            af.showToast(d.a(d.this), "请检查网络");
            return;
            com.ziroom.commonlibrary.login.a.startLoginActivity(d.a(d.this));
          } while (d.c(d.this) == null);
          d.c(d.this).isLogin(false);
        }
      });
      c.c(paramc).setText("自如优品优惠券");
      str1 = localf.getStartDate();
      str2 = localf.getEndDate();
      if (!TextUtils.isEmpty(str1)) {
        break label278;
      }
      str1 = "";
      label119:
      if (!TextUtils.isEmpty(str2)) {
        break label290;
      }
      str2 = "";
      label131:
      if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2))) {
        break label304;
      }
      c.d(paramc).setVisibility(8);
      label155:
      c.e(paramc).setText(String.format("%.2f", new Object[] { Double.valueOf(localf.getPromoPrice()) }));
      str1 = localf.getTypeName();
      str2 = localf.getDescription();
      if (!TextUtils.isEmpty(str1)) {
        break label382;
      }
      c.f(paramc).setVisibility(8);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str2)) {
        break label393;
      }
      c.g(paramc).setVisibility(8);
      return;
      c.a(paramc).setBackgroundResource(2130837741);
      c.b(paramc).setBackgroundResource(2130839355);
      c.b(paramc).setText("已领取");
      c.b(paramc).setTextColor(this.c.getResources().getColor(2131624045));
      break;
      label278:
      str1 = a(str1, m.k);
      break label119;
      label290:
      str2 = a(str2, m.k);
      break label131;
      label304:
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        c.d(paramc).setText(str1 + str2);
        break label155;
      }
      c.d(paramc).setText(str1 + "-" + str2);
      break label155;
      label382:
      c.f(paramc).setText(str1);
    }
    label393:
    c.g(paramc).setText(str2);
  }
  
  public c onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130904132, paramViewGroup, false));
  }
  
  public void setData(List<f> paramList)
  {
    this.a = paramList;
  }
  
  public void setLoginListener(b paramb)
  {
    this.d = paramb;
  }
  
  class a
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    private int c;
    
    public a(com.freelxl.baselibrary.d.f.a parama, int paramInt)
    {
      super();
      this.c = paramInt;
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      c.catchExp(paramThrowable);
      af.showToast(d.a(d.this), "请稍后再试");
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        ((f)d.d(d.this).get(this.c)).setState(1);
        d.this.notifyDataSetChanged();
        af.showToast(d.a(d.this), "领取成功");
        return;
      }
      paraml = paraml.getMessage();
      if (paraml != null)
      {
        af.showToast(d.a(d.this), paraml);
        return;
      }
      af.showToast(d.a(d.this), "请稍后再试");
    }
  }
  
  public static abstract interface b
  {
    public abstract void isLogin(boolean paramBoolean);
  }
  
  public static class c
    extends RecyclerView.u
  {
    private RelativeLayout a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    
    public c(View paramView)
    {
      super();
      this.a = ((RelativeLayout)paramView.findViewById(2131694853));
      this.b = ((TextView)paramView.findViewById(2131694854));
      this.c = ((TextView)paramView.findViewById(2131694855));
      this.d = ((TextView)paramView.findViewById(2131694856));
      this.e = ((TextView)paramView.findViewById(2131693072));
      this.f = ((TextView)paramView.findViewById(2131694857));
      this.g = ((TextView)paramView.findViewById(2131694858));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */