package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.base.BaseLandlordReleaseFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseCheckInfoInitBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckInTimeBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckInTimeBean.CheckInTimListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckOutTimeBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckOutTimeBean.CheckOutTimeListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.MinDayBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.MinDayBean.ListMinDayBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveCheckInfoInit;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SingleChoseBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c.a;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.List;

public class LLReleaseFourthStepFragment
  extends BaseLandlordReleaseFragment
  implements View.OnClickListener, com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a
{
  private List<LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckOutTimeBean.CheckOutTimeListBean> A;
  private List<LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.MinDayBean.ListMinDayBean> B;
  private boolean C = false;
  private boolean D = false;
  private boolean E = false;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c F;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c G;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c H;
  private ImageView b;
  private TextView c;
  private ObservableScrollView d;
  private View e;
  private RelativeLayout f;
  private TextView g;
  private RelativeLayout h;
  private TextView i;
  private RelativeLayout j;
  private TextView k;
  private Button l;
  private MinsuReleaseActivity m;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c n;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b o;
  private LLReleaseCheckInfoInitBean p;
  private SaveCheckInfoInit q;
  private List<SingleChoseBean> r = new ArrayList();
  private List<SingleChoseBean> s = new ArrayList();
  private List<SingleChoseBean> t = new ArrayList();
  private LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean u;
  private int v;
  private int w;
  private String x;
  private String y;
  private List<LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckInTimeBean.CheckInTimListBean> z;
  
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c a(String paramString, List<SingleChoseBean> paramList, c.a parama)
  {
    paramString = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c(this.m, paramString, parama, paramList);
    paramString.setCanceledOnTouchOutside(true);
    paramList = paramString.getWindow();
    paramList.getDecorView().setPadding(0, 0, 0, 0);
    parama = paramList.getAttributes();
    parama.width = -1;
    parama.height = -2;
    paramList.setAttributes(parama);
    paramList.setGravity(80);
    return paramString;
  }
  
  private void d()
  {
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.d.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LLReleaseFourthStepFragment.a(LLReleaseFourthStepFragment.this).setAlpha(f);
      }
    });
  }
  
  private void e()
  {
    this.v = h();
    n();
  }
  
  private void m()
  {
    this.n = new com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c(this);
    this.a.register(this.n);
    this.o = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void n()
  {
    this.o.getCheckInfoInit(this, this.m, k(), j(), Integer.valueOf(h()));
  }
  
  public static LLReleaseFourthStepFragment newInstance()
  {
    Bundle localBundle = new Bundle();
    LLReleaseFourthStepFragment localLLReleaseFourthStepFragment = new LLReleaseFourthStepFragment();
    localLLReleaseFourthStepFragment.setArguments(localBundle);
    return localLLReleaseFourthStepFragment;
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    int i2 = 0;
    parama = parama.getType();
    int i1 = -1;
    switch (parama.hashCode())
    {
    default: 
      switch (i1)
      {
      }
      break;
    }
    do
    {
      do
      {
        return;
        if (!parama.equals("check_info_init")) {
          break;
        }
        i1 = 0;
        break;
        if (!parama.equals("check_info_init_error")) {
          break;
        }
        i1 = 1;
        break;
        if (!parama.equals("save_check_info_init")) {
          break;
        }
        i1 = 2;
        break;
        if (!parama.equals("save_check_info_init_error")) {
          break;
        }
        i1 = 3;
        break;
        this.p = this.n.getmLLReleaseCheckInfoInitBean();
        if (this.p != null) {
          this.u = this.p.getData();
        }
      } while (this.u == null);
      this.B = this.u.getMinDay().getList();
      i1 = 0;
      while (i1 < this.B.size())
      {
        parama = new SingleChoseBean();
        parama.setText(((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.MinDayBean.ListMinDayBean)this.B.get(i1)).getText());
        parama.setIsChosen(((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.MinDayBean.ListMinDayBean)this.B.get(i1)).isIsSelect());
        this.r.add(parama);
        if (((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.MinDayBean.ListMinDayBean)this.B.get(i1)).isIsSelect())
        {
          parama = ((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.MinDayBean.ListMinDayBean)this.B.get(i1)).getText();
          this.g.setText(parama);
          this.g.setTextColor(Color.parseColor("#444444"));
          this.w = Integer.parseInt(((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.MinDayBean.ListMinDayBean)this.B.get(i1)).getValue());
          aa.putInt(this.m, "minDay", this.w);
        }
        i1 += 1;
      }
      this.z = this.u.getCheckInTime().getList();
      i1 = 0;
      while (i1 < this.z.size())
      {
        parama = new SingleChoseBean();
        parama.setText(((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckInTimeBean.CheckInTimListBean)this.z.get(i1)).getText());
        parama.setIsChosen(((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckInTimeBean.CheckInTimListBean)this.z.get(i1)).isIsSelect());
        this.s.add(parama);
        if (((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckInTimeBean.CheckInTimListBean)this.z.get(i1)).isIsSelect())
        {
          parama = ((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckInTimeBean.CheckInTimListBean)this.z.get(i1)).getText();
          this.i.setText(parama);
          this.i.setTextColor(Color.parseColor("#444444"));
          this.x = ((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckInTimeBean.CheckInTimListBean)this.z.get(i1)).getValue();
          aa.putString(this.m, "checkInTime", this.x);
        }
        i1 += 1;
      }
      this.A = this.u.getCheckOutTime().getList();
      i1 = i2;
      while (i1 < this.A.size())
      {
        parama = new SingleChoseBean();
        parama.setText(((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckOutTimeBean.CheckOutTimeListBean)this.A.get(i1)).getText());
        parama.setIsChosen(((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckOutTimeBean.CheckOutTimeListBean)this.A.get(i1)).isIsSelect());
        this.t.add(parama);
        if (((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckOutTimeBean.CheckOutTimeListBean)this.A.get(i1)).isIsSelect())
        {
          parama = ((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckOutTimeBean.CheckOutTimeListBean)this.A.get(i1)).getText();
          this.k.setText(parama);
          this.k.setTextColor(Color.parseColor("#444444"));
          this.y = ((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckOutTimeBean.CheckOutTimeListBean)this.A.get(i1)).getValue();
          aa.putString(this.m, "checkOutTime", this.y);
        }
        i1 += 1;
      }
      this.F = a("single_min_days", this.r, new c(null));
      this.G = a("single_check_in_time", this.s, new a(null));
      this.H = a("single_check_out_time", this.t, new b(null));
      return;
      this.d.setVisibility(8);
      this.l.setVisibility(8);
      showToast(this.n.getReleaseCheckInfoInitErrorMsg());
      return;
      this.q = this.n.getmSaveCheckInfoInit();
    } while (this.q.getStatus() != 0);
    f();
    return;
    showToast(this.n.getSaveCheckInfoInitMsg());
  }
  
  protected View c()
  {
    View localView = LayoutInflater.from(this.m).inflate(2130903956, null);
    this.b = ((ImageView)localView.findViewById(2131689492));
    this.c = ((TextView)localView.findViewById(2131694276));
    this.d = ((ObservableScrollView)localView.findViewById(2131689506));
    this.e = localView.findViewById(2131689863);
    this.f = ((RelativeLayout)localView.findViewById(2131694180));
    this.g = ((TextView)localView.findViewById(2131694182));
    this.h = ((RelativeLayout)localView.findViewById(2131694183));
    this.i = ((TextView)localView.findViewById(2131694185));
    this.j = ((RelativeLayout)localView.findViewById(2131694186));
    this.k = ((TextView)localView.findViewById(2131694188));
    this.l = ((Button)localView.findViewById(2131691053));
    if ("manager".equals(getActivity().getIntent().getStringExtra("from")))
    {
      this.l.setVisibility(8);
      ((TextView)localView.findViewById(2131694277)).setText("入住信息");
      this.c.setVisibility(0);
    }
    return localView;
  }
  
  public boolean onBackPressed()
  {
    if ((this.C) || (this.D) || (this.E)) {
      d.newBuilder(this.m).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          LLReleaseFourthStepFragment.c(LLReleaseFourthStepFragment.this);
        }
      }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
    }
    for (;;)
    {
      return false;
      if ((!this.C) && (!this.D) && (!this.E)) {
        g();
      }
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131689492: 
    case 2131694180: 
    case 2131694183: 
    case 2131694186: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if ((this.C) || (this.D) || (this.E))
              {
                d.newBuilder(this.m).setOnConfirmClickListener(new d.b()
                {
                  public void onLeftClick(View paramAnonymousView) {}
                  
                  public void onRightClick(View paramAnonymousView)
                  {
                    LLReleaseFourthStepFragment.b(LLReleaseFourthStepFragment.this);
                  }
                }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
                return;
              }
            } while ((this.C) || (this.D) || (this.E));
            g();
            return;
          } while (this.F == null);
          this.F.show();
          return;
        } while (this.G == null);
        this.G.show();
        return;
      } while (this.H == null);
      this.H.show();
      return;
    }
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.m);
      af.showToast(this.m, "请先登录");
      return;
    }
    if (TextUtils.isEmpty(this.g.getText().toString()))
    {
      showToast("请选择最小入住天数");
      return;
    }
    if (TextUtils.isEmpty(this.x))
    {
      showToast("请选择入住时间");
      return;
    }
    if (TextUtils.isEmpty(this.y))
    {
      showToast("请选择离开时间");
      return;
    }
    this.o.saveCheckInfoInit(this, this.m, k(), j(), Integer.valueOf(h()), this.w, this.x, this.y);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.m = ((MinsuReleaseActivity)getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    m();
    return c();
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.n);
    super.onDestroyView();
  }
  
  public void onLoginBack(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      e();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    d();
    e();
  }
  
  private class a
    implements c.a
  {
    private a() {}
    
    public void onSingleSelect(String paramString, int paramInt)
    {
      LLReleaseFourthStepFragment.a(LLReleaseFourthStepFragment.this, ((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckInTimeBean.CheckInTimListBean)LLReleaseFourthStepFragment.h(LLReleaseFourthStepFragment.this).get(paramInt)).getValue());
      if (aa.getString(LLReleaseFourthStepFragment.e(LLReleaseFourthStepFragment.this), "checkInTime", "").equals(LLReleaseFourthStepFragment.i(LLReleaseFourthStepFragment.this))) {
        LLReleaseFourthStepFragment.b(LLReleaseFourthStepFragment.this, false);
      }
      for (;;)
      {
        LLReleaseFourthStepFragment.j(LLReleaseFourthStepFragment.this).setText(paramString);
        LLReleaseFourthStepFragment.j(LLReleaseFourthStepFragment.this).setTextColor(Color.parseColor("#444444"));
        return;
        LLReleaseFourthStepFragment.b(LLReleaseFourthStepFragment.this, true);
      }
    }
  }
  
  private class b
    implements c.a
  {
    private b() {}
    
    public void onSingleSelect(String paramString, int paramInt)
    {
      LLReleaseFourthStepFragment.b(LLReleaseFourthStepFragment.this, ((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.CheckOutTimeBean.CheckOutTimeListBean)LLReleaseFourthStepFragment.k(LLReleaseFourthStepFragment.this).get(paramInt)).getValue());
      if (aa.getString(LLReleaseFourthStepFragment.e(LLReleaseFourthStepFragment.this), "checkOutTime", "").equals(LLReleaseFourthStepFragment.l(LLReleaseFourthStepFragment.this))) {
        LLReleaseFourthStepFragment.c(LLReleaseFourthStepFragment.this, false);
      }
      for (;;)
      {
        LLReleaseFourthStepFragment.m(LLReleaseFourthStepFragment.this).setText(paramString);
        LLReleaseFourthStepFragment.m(LLReleaseFourthStepFragment.this).setTextColor(Color.parseColor("#444444"));
        return;
        LLReleaseFourthStepFragment.c(LLReleaseFourthStepFragment.this, true);
      }
    }
  }
  
  private class c
    implements c.a
  {
    private c() {}
    
    public void onSingleSelect(String paramString, int paramInt)
    {
      String str = ((LLReleaseCheckInfoInitBean.LLReleaseCheckInfoInitDataBean.MinDayBean.ListMinDayBean)LLReleaseFourthStepFragment.d(LLReleaseFourthStepFragment.this).get(paramInt)).getValue();
      if (!TextUtils.isEmpty(str)) {
        LLReleaseFourthStepFragment.a(LLReleaseFourthStepFragment.this, Integer.parseInt(str));
      }
      if (aa.getInt(LLReleaseFourthStepFragment.e(LLReleaseFourthStepFragment.this), "minDay", -1) == LLReleaseFourthStepFragment.f(LLReleaseFourthStepFragment.this)) {
        LLReleaseFourthStepFragment.a(LLReleaseFourthStepFragment.this, false);
      }
      for (;;)
      {
        LLReleaseFourthStepFragment.g(LLReleaseFourthStepFragment.this).setText(paramString);
        LLReleaseFourthStepFragment.g(LLReleaseFourthStepFragment.this).setTextColor(Color.parseColor("#444444"));
        return;
        LLReleaseFourthStepFragment.a(LLReleaseFourthStepFragment.this, true);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LLReleaseFourthStepFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */