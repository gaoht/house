package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.home.view.ZiScroListView;
import com.ziroom.ziroomcustomer.newrepair.a.h;
import com.ziroom.ziroomcustomer.newrepair.b.k;
import com.ziroom.ziroomcustomer.newrepair.b.m;
import com.ziroom.ziroomcustomer.newrepair.b.m.a;
import com.ziroom.ziroomcustomer.newrepair.utils.b;
import com.ziroom.ziroomcustomer.widget.MyGridView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InternalRepairPlanActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String A;
  private String B;
  private String C;
  private m D;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private ArrayList<String> I = new ArrayList();
  private Context a;
  private ImageView b;
  private TextView c;
  private ZiScroListView d;
  private ZiScroListView e;
  private com.ziroom.ziroomcustomer.newrepair.a.g f;
  private h g;
  private LinearLayout r;
  private LinearLayout s;
  private LinearLayout t;
  private MyGridView u;
  private c v;
  private TextView w;
  private TextView x;
  private TextView y;
  private Button z;
  
  private void a()
  {
    if (!this.H) {
      this.z.setOnClickListener(this);
    }
    this.b.setOnClickListener(this);
    this.y.setOnClickListener(this);
  }
  
  private void b()
  {
    e();
  }
  
  private void e()
  {
    showProgressNoCancel("", 30000L);
    j.getInternalRepairPlanDetail(this.a, this.C, new b(new b(m.class)));
  }
  
  private void f()
  {
    showEmptyView(this.r, "点击重试").setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        InternalRepairPlanActivity.u(InternalRepairPlanActivity.this);
      }
    });
  }
  
  private void g()
  {
    this.r = ((LinearLayout)findViewById(2131689998));
    this.t = ((LinearLayout)findViewById(2131691017));
    this.c = ((TextView)findViewById(2131689541));
    this.b = ((ImageView)findViewById(2131689492));
    this.e = ((ZiScroListView)findViewById(2131691018));
    this.d = ((ZiScroListView)findViewById(2131691016));
    this.w = ((TextView)findViewById(2131689996));
    this.x = ((TextView)findViewById(2131691021));
    this.y = ((TextView)findViewById(2131690169));
    this.z = ((Button)findViewById(2131689843));
    this.z.setTag("humanControlled");
    if (this.E) {
      this.z.setText("验收通过");
    }
    this.s = ((LinearLayout)findViewById(2131691019));
    this.u = ((MyGridView)findViewById(2131691020));
    if (this.H)
    {
      this.z.setVisibility(8);
      this.x.setVisibility(8);
    }
  }
  
  private void h()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("确认放弃维修方案？").setContent("放弃维修订单将被取消，如您有其它维修需求，可重新下单。如您有疑问，请联系客服。").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          InternalRepairPlanActivity.this.showProgressNoCancel("", 30000L);
          InternalRepairPlanActivity.v(InternalRepairPlanActivity.this);
        }
      }
    }).build().show();
  }
  
  private void i()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailBillId", this.D.getMailBillId());
    j.giveUpInternalRepairPlan(this.a, localHashMap, new a(true, new b(null)));
  }
  
  private void j()
  {
    if (!this.E)
    {
      k();
      return;
    }
    l();
  }
  
  private void k()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("确认方案").setContent("点击”确定”表示认可维修方案，如果是人为原因导致损坏，也包含确认对应费用金额。").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          InternalRepairPlanActivity.this.showProgressNoCancel("", 30000L);
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("mailBillId", InternalRepairPlanActivity.a(InternalRepairPlanActivity.this).getMailBillId());
          paramAnonymousView.put("wxxmId", "");
          j.confirmInternalRepairPlan(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), paramAnonymousView, new InternalRepairPlanActivity.a(InternalRepairPlanActivity.this, new b(null)));
        }
      }
    }).build().show();
  }
  
  private void l()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("确认验收").setContent("维修已完成，请点击“确定”，否则请和师傅沟通或反馈客服。").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          InternalRepairPlanActivity.this.showProgressNoCancel("", 30000L);
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("mailBillId", InternalRepairPlanActivity.a(InternalRepairPlanActivity.this).getMailBillId());
          j.passInternalPlan(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), paramAnonymousView, new InternalRepairPlanActivity.a(InternalRepairPlanActivity.this, new b(null)));
        }
      }
    }).build().show();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689843: 
      j();
      return;
    case 2131689492: 
      finish();
      return;
    }
    h();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903229);
    this.a = this;
    this.F = getIntent().getBooleanExtra("isFromList", false);
    this.H = getIntent().getBooleanExtra("isReview", false);
    this.C = getIntent().getStringExtra("mailBillId");
    this.E = getIntent().getBooleanExtra("isDetail", false);
    this.A = getIntent().getStringExtra("orderCode");
    this.B = getIntent().getStringExtra("orderCodeType");
    g();
    a();
    b();
  }
  
  class a
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    boolean b;
    
    public a(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
      this.b = false;
    }
    
    public a(boolean paramBoolean, com.freelxl.baselibrary.d.f.a parama)
    {
      super();
      this.b = paramBoolean;
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      InternalRepairPlanActivity.this.dismissProgress();
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      InternalRepairPlanActivity.this.dismissProgress();
      if (paraml.getSuccess().booleanValue())
      {
        if (InternalRepairPlanActivity.d(InternalRepairPlanActivity.this))
        {
          com.freelxl.baselibrary.f.g.textToast(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), "方案验收成功");
          paraml = new Intent();
          if ((InternalRepairPlanActivity.w(InternalRepairPlanActivity.this)) && (InternalRepairPlanActivity.p(InternalRepairPlanActivity.this)))
          {
            paraml.setClass(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), UrgencyRepairActivity.class);
            paraml.putExtra("orderCode", InternalRepairPlanActivity.x(InternalRepairPlanActivity.this));
            paraml.putExtra("orderCodeType", InternalRepairPlanActivity.y(InternalRepairPlanActivity.this));
            InternalRepairPlanActivity.this.startActivity(paraml);
            InternalRepairPlanActivity.this.finish();
            return;
          }
          if ((InternalRepairPlanActivity.w(InternalRepairPlanActivity.this)) && (!InternalRepairPlanActivity.p(InternalRepairPlanActivity.this)))
          {
            paraml.setClass(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), InternalRepairEvalActivity.class);
            paraml.putExtra("headUrl", InternalRepairPlanActivity.a(InternalRepairPlanActivity.this).getSPic());
            paraml.putExtra("name", InternalRepairPlanActivity.a(InternalRepairPlanActivity.this).getSName());
            paraml.putExtra("mailBillId", InternalRepairPlanActivity.a(InternalRepairPlanActivity.this).getMailBillId());
            InternalRepairPlanActivity.this.startActivity(paraml);
            InternalRepairPlanActivity.this.finish();
            return;
          }
          if (InternalRepairPlanActivity.p(InternalRepairPlanActivity.this))
          {
            paraml.putExtra("isPay", true);
            InternalRepairPlanActivity.this.setResult(-1, paraml);
          }
          for (;;)
          {
            InternalRepairPlanActivity.this.finish();
            return;
            paraml.putExtra("isPay", false);
            InternalRepairPlanActivity.this.setResult(-1, paraml);
          }
        }
        paraml = new Intent();
        if ((this.b) && (InternalRepairPlanActivity.w(InternalRepairPlanActivity.this)))
        {
          com.freelxl.baselibrary.f.g.textToast(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), "放弃维修成功");
          paraml.setClass(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), InternalRepairEvalActivity.class);
          paraml.putExtra("headUrl", InternalRepairPlanActivity.a(InternalRepairPlanActivity.this).getSPic());
          paraml.putExtra("name", InternalRepairPlanActivity.a(InternalRepairPlanActivity.this).getSName());
          paraml.putExtra("mailBillId", InternalRepairPlanActivity.z(InternalRepairPlanActivity.this));
          InternalRepairPlanActivity.this.startActivity(paraml);
          InternalRepairPlanActivity.this.finish();
          return;
        }
        if ((this.b) && (!InternalRepairPlanActivity.w(InternalRepairPlanActivity.this)))
        {
          com.freelxl.baselibrary.f.g.textToast(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), "放弃维修成功");
          paraml.putExtra("giveUp", true);
        }
        for (;;)
        {
          InternalRepairPlanActivity.this.setResult(-1, paraml);
          InternalRepairPlanActivity.this.finish();
          return;
          com.freelxl.baselibrary.f.g.textToast(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), "方案确认成功");
          paraml.putExtra("giveUp", false);
        }
      }
      paraml = paraml.getMessage();
      com.freelxl.baselibrary.f.g.textToast(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), paraml);
    }
  }
  
  class b
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public b(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      InternalRepairPlanActivity.this.dismissProgress();
      InternalRepairPlanActivity.b(InternalRepairPlanActivity.this);
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        InternalRepairPlanActivity.a(InternalRepairPlanActivity.this, (m)paraml.getObject());
        if (InternalRepairPlanActivity.a(InternalRepairPlanActivity.this) == null)
        {
          InternalRepairPlanActivity.b(InternalRepairPlanActivity.this);
          com.freelxl.baselibrary.f.g.textToast(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), "获取数据失败，请稍后再试！");
          return;
        }
        Object localObject2 = InternalRepairPlanActivity.a(InternalRepairPlanActivity.this).getPicUrls();
        paraml = InternalRepairPlanActivity.a(InternalRepairPlanActivity.this).getWxxmList();
        Object localObject1 = InternalRepairPlanActivity.a(InternalRepairPlanActivity.this).getWxScheme();
        boolean bool;
        if (InternalRepairPlanActivity.d(InternalRepairPlanActivity.this))
        {
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            InternalRepairPlanActivity.e(InternalRepairPlanActivity.this).setText("维修明细");
            InternalRepairPlanActivity.f(InternalRepairPlanActivity.this).setText("如果对维修质量有疑问，可以和师傅沟通再次维修或联系客服反馈，我们会及时安排处理。");
            InternalRepairPlanActivity.g(InternalRepairPlanActivity.this).setVisibility(0);
            InternalRepairPlanActivity.h(InternalRepairPlanActivity.this).clear();
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              m.a locala = (m.a)((Iterator)localObject2).next();
              InternalRepairPlanActivity.h(InternalRepairPlanActivity.this).add(locala.getPicUrl());
            }
            InternalRepairPlanActivity.a(InternalRepairPlanActivity.this, new InternalRepairPlanActivity.c(InternalRepairPlanActivity.this, InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), InternalRepairPlanActivity.h(InternalRepairPlanActivity.this)));
            InternalRepairPlanActivity.j(InternalRepairPlanActivity.this).setAdapter(InternalRepairPlanActivity.i(InternalRepairPlanActivity.this));
            InternalRepairPlanActivity.j(InternalRepairPlanActivity.this).setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              @Instrumented
              public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
                paramAnonymousAdapterView = new Intent(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), PreviewPhotoAc.class);
                paramAnonymousAdapterView.putStringArrayListExtra("photos", InternalRepairPlanActivity.h(InternalRepairPlanActivity.this));
                paramAnonymousAdapterView.putExtra("position", paramAnonymousInt);
                InternalRepairPlanActivity.this.startActivity(paramAnonymousAdapterView);
              }
            });
          }
          localObject2 = InternalRepairPlanActivity.this;
          if (InternalRepairPlanActivity.a(InternalRepairPlanActivity.this).getIsPay() == 0) {
            break label517;
          }
          bool = true;
          label300:
          InternalRepairPlanActivity.a((InternalRepairPlanActivity)localObject2, bool);
          InternalRepairPlanActivity.a(InternalRepairPlanActivity.this, new h(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), paraml));
          InternalRepairPlanActivity.n(InternalRepairPlanActivity.this).setAdapter(InternalRepairPlanActivity.m(InternalRepairPlanActivity.this));
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break label523;
          }
          InternalRepairPlanActivity.o(InternalRepairPlanActivity.this).setVisibility(0);
          InternalRepairPlanActivity.a(InternalRepairPlanActivity.this, new com.ziroom.ziroomcustomer.newrepair.a.g(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), (List)localObject1, InternalRepairPlanActivity.p(InternalRepairPlanActivity.this), true));
          InternalRepairPlanActivity.r(InternalRepairPlanActivity.this).setAdapter(InternalRepairPlanActivity.q(InternalRepairPlanActivity.this));
        }
        for (;;)
        {
          label423:
          if (InternalRepairPlanActivity.p(InternalRepairPlanActivity.this))
          {
            double d = 0.0D;
            paraml = ((List)localObject1).iterator();
            for (;;)
            {
              if (paraml.hasNext())
              {
                localObject1 = (k)paraml.next();
                d += ((k)localObject1).getTotalPrice() * ((k)localObject1).getUsedNum();
                continue;
                InternalRepairPlanActivity.g(InternalRepairPlanActivity.this).setVisibility(8);
                if (InternalRepairPlanActivity.k(InternalRepairPlanActivity.this)) {
                  break;
                }
                InternalRepairPlanActivity.l(InternalRepairPlanActivity.this).setVisibility(0);
                break;
                label517:
                bool = false;
                break label300;
                label523:
                InternalRepairPlanActivity.o(InternalRepairPlanActivity.this).setVisibility(8);
                break label423;
              }
            }
            paraml = String.format("%.2f", new Object[] { Double.valueOf(d) });
            InternalRepairPlanActivity.s(InternalRepairPlanActivity.this).setVisibility(0);
            InternalRepairPlanActivity.s(InternalRepairPlanActivity.this).setText(paraml + "元");
            InternalRepairPlanActivity.this.closeEmpty(InternalRepairPlanActivity.t(InternalRepairPlanActivity.this));
          }
        }
      }
      for (;;)
      {
        InternalRepairPlanActivity.this.dismissProgress();
        return;
        InternalRepairPlanActivity.s(InternalRepairPlanActivity.this).setVisibility(8);
        break;
        paraml = paraml.getMessage();
        com.freelxl.baselibrary.f.g.textToast(InternalRepairPlanActivity.c(InternalRepairPlanActivity.this), paraml);
        InternalRepairPlanActivity.b(InternalRepairPlanActivity.this);
      }
    }
  }
  
  public class c
    extends BaseAdapter
  {
    private Context b;
    
    public c(List<String> paramList)
    {
      this.b = paramList;
      Object localObject;
      InternalRepairPlanActivity.a(InternalRepairPlanActivity.this, (ArrayList)localObject);
    }
    
    public int getCount()
    {
      return InternalRepairPlanActivity.h(InternalRepairPlanActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return InternalRepairPlanActivity.h(InternalRepairPlanActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.b).inflate(2130904255, null);
        paramView = new InternalRepairPlanActivity.d(null);
        paramView.b = ((RelativeLayout)localView.findViewById(2131692167));
        paramView.a = ((SimpleDraweeView)localView.findViewById(2131694859));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        if (paramInt % 3 != 0) {
          break label119;
        }
        paramViewGroup.b.setGravity(3);
      }
      for (;;)
      {
        paramViewGroup.a.setController(com.freelxl.baselibrary.f.c.frescoController((String)InternalRepairPlanActivity.h(InternalRepairPlanActivity.this).get(paramInt)));
        return localView;
        paramViewGroup = (InternalRepairPlanActivity.d)paramView.getTag();
        localView = paramView;
        break;
        label119:
        if (paramInt % 3 == 2) {
          paramViewGroup.b.setGravity(5);
        } else {
          paramViewGroup.b.setGravity(1);
        }
      }
    }
  }
  
  private static class d
  {
    public SimpleDraweeView a;
    public RelativeLayout b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/InternalRepairPlanActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */