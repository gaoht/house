package com.ziroom.ziroomcustomer.termination;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.a;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.termination.a.f;
import com.ziroom.ziroomcustomer.termination.a.h;
import com.ziroom.ziroomcustomer.termination.a.i;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TerminationHandleSureActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView A;
  private TextView B;
  private TextView C;
  private ImageView D;
  private ImageView E;
  private Button F;
  private List<String> G;
  private ListView H;
  private PopupWindow I;
  private boolean J = true;
  private View K;
  private String L;
  private String M;
  private String N;
  private String O;
  private String P;
  private String Q;
  private int R;
  private String S;
  private Context a;
  private AlertDialog b;
  private TextView c;
  private ListView d;
  private ListView e;
  private ListView f;
  private b g;
  private a r;
  private c s;
  private List<h> t = new ArrayList();
  private List<f> u = new ArrayList();
  private List<com.ziroom.ziroomcustomer.termination.a.j> v = new ArrayList();
  private com.ziroom.ziroomcustomer.termination.a.e w = new com.ziroom.ziroomcustomer.termination.a.e();
  private i x = new i();
  private com.ziroom.ziroomcustomer.termination.a.g y = new com.ziroom.ziroomcustomer.termination.a.g();
  private TextView z;
  
  private void a()
  {
    this.G = new ArrayList();
    this.G.add("取消解约");
  }
  
  private void a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      View localView = LayoutInflater.from(paramContext).inflate(2130903785, null);
      localObject = (Button)localView.findViewById(2131692249);
      Button localButton = (Button)localView.findViewById(2131690460);
      this.b = new AlertDialog.Builder(paramContext).create();
      this.b.setView(localView, 0, 0, 0, 0);
      paramContext = this.b;
      if (!(paramContext instanceof AlertDialog)) {
        paramContext.show();
      }
      for (;;)
      {
        ((Button)localObject).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            TerminationHandleSureActivity.a(TerminationHandleSureActivity.this, q.s + e.a.o);
            paramAnonymousView = com.ziroom.ziroomcustomer.e.g.getRejectedBackRenderContractUrl(TerminationHandleSureActivity.a(TerminationHandleSureActivity.this), "物业交割驳回");
            com.ziroom.ziroomcustomer.e.j.getReservationOrderText(TerminationHandleSureActivity.b(TerminationHandleSureActivity.this), new TerminationHandleSureActivity.d(TerminationHandleSureActivity.this), paramAnonymousView, true, TerminationHandleSureActivity.c(TerminationHandleSureActivity.this));
            TerminationHandleSureActivity.a(TerminationHandleSureActivity.this, "N", 69673);
          }
        });
        localButton.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            TerminationHandleSureActivity.d(TerminationHandleSureActivity.this).dismiss();
          }
        });
        return;
        VdsAgent.showDialog((AlertDialog)paramContext);
      }
    case 1: 
      localObject = LayoutInflater.from(paramContext).inflate(2130903793, null);
      this.d = ((ListView)((View)localObject).findViewById(2131693767));
      this.c = ((TextView)((View)localObject).findViewById(2131693729));
      if (this.w.getTotalAccount() > 0.0F) {
        this.c.setText(this.w.getTotalAccount() + "元");
      }
      for (;;)
      {
        this.d.setAdapter(this.g);
        a(paramContext, (View)localObject);
        return;
        ((View)localObject).findViewById(2131693728).setVisibility(8);
      }
    case 2: 
      localObject = LayoutInflater.from(paramContext).inflate(2130903788, null);
      this.c = ((TextView)((View)localObject).findViewById(2131693729));
      this.e = ((ListView)((View)localObject).findViewById(2131693730));
      this.e.setAdapter(this.r);
      if (this.y.getTotalAccount() > 0.0F) {
        this.c.setText(this.y.getTotalAccount() + "元");
      }
      for (;;)
      {
        a(paramContext, (View)localObject);
        return;
        ((View)localObject).findViewById(2131693728).setVisibility(8);
      }
    }
    Object localObject = LayoutInflater.from(paramContext).inflate(2130903810, null);
    this.c = ((TextView)((View)localObject).findViewById(2131693729));
    this.f = ((ListView)((View)localObject).findViewById(2131693813));
    this.f.setAdapter(this.s);
    if (this.x.getTotalAccount() > 0.0F) {
      this.c.setText(this.x.getTotalAccount() + "元");
    }
    for (;;)
    {
      a(paramContext, (View)localObject);
      return;
      ((View)localObject).findViewById(2131693728).setVisibility(8);
    }
  }
  
  private void a(Context paramContext, View paramView)
  {
    this.b = new AlertDialog.Builder(paramContext).create();
    this.b.setView(paramView, 0, 0, 0, 0);
    paramContext = this.b;
    if (!(paramContext instanceof AlertDialog))
    {
      paramContext.show();
      return;
    }
    VdsAgent.showDialog((AlertDialog)paramContext);
  }
  
  private void a(String paramString, int paramInt) {}
  
  private void b()
  {
    a();
    View localView1 = View.inflate(this, 2130905075, null);
    this.H = ((ListView)localView1.findViewById(2131691156));
    final com.ziroom.ziroomcustomer.adapter.e locale = new com.ziroom.ziroomcustomer.adapter.e(this.a, this.G);
    this.H.setAdapter(locale);
    PopupWindow localPopupWindow;
    View localView2;
    if (this.J)
    {
      this.I = new PopupWindow(localView1, -1, -1, true);
      this.I.setContentView(localView1);
      this.I.setOutsideTouchable(false);
      this.I.setFocusable(false);
      localPopupWindow = this.I;
      localView2 = this.K;
      if (!(localPopupWindow instanceof PopupWindow)) {
        localPopupWindow.showAsDropDown(localView2);
      }
    }
    for (this.J = false;; this.J = true)
    {
      localView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          TerminationHandleSureActivity.h(TerminationHandleSureActivity.this).dismiss();
          TerminationHandleSureActivity.a(TerminationHandleSureActivity.this, true);
        }
      });
      this.H.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          if ("取消解约".equals(locale.getmList().get(paramAnonymousInt)))
          {
            paramAnonymousAdapterView = new Intent(TerminationHandleSureActivity.b(TerminationHandleSureActivity.this), MainActivity.class);
            paramAnonymousAdapterView.putExtra("FRAGMENT_TYPE", 7);
            TerminationHandleSureActivity.this.startActivity(paramAnonymousAdapterView);
            TerminationHandleSureActivity.this.finish();
          }
        }
      });
      return;
      VdsAgent.showAsDropDown((PopupWindow)localPopupWindow, localView2);
      break;
      this.I.dismiss();
    }
  }
  
  public void initView()
  {
    this.K = findViewById(2131691959);
    this.E = ((ImageView)findViewById(2131693342));
    this.C = ((TextView)findViewById(2131697622));
    this.F = ((Button)findViewById(2131697621));
    this.D = ((ImageView)findViewById(2131689492));
    this.z = ((TextView)findViewById(2131697247));
    this.A = ((TextView)findViewById(2131697248));
    this.B = ((TextView)findViewById(2131697249));
    this.E.setVisibility(8);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131697622: 
      do
      {
        return;
      } while (TextUtils.isEmpty(this.S));
      ah.callPhone(this.a, this.S);
      return;
    case 2131697621: 
      paramView = new Intent(this.a, CostSettlementActivity.class);
      paramView.putExtra("backRentOrderCode", this.P);
      paramView.putExtra("loanState", this.R);
      paramView.putExtra("contractCode", this.Q);
      startActivity(paramView);
      return;
    case 2131689492: 
      finish();
      return;
    case 2131697247: 
      this.L = (q.s + e.a.f);
      paramView = com.ziroom.ziroomcustomer.e.g.getViewPropertyGoosUrl(this.Q, this.P);
      com.ziroom.ziroomcustomer.e.j.getReservationOrderText(this.a, new d(), paramView, true, this.L);
      return;
    case 2131697248: 
      this.M = (q.s + e.a.h);
      paramView = com.ziroom.ziroomcustomer.e.g.getViewPropertyExpendsUrl(this.P);
      com.ziroom.ziroomcustomer.e.j.getReservationOrderText(this.a, new d(), paramView, true, this.M);
      return;
    case 2131697249: 
      this.N = (q.s + e.a.g);
      paramView = com.ziroom.ziroomcustomer.e.g.getViewPropertyKeyUrl(this.P);
      com.ziroom.ziroomcustomer.e.j.getReservationOrderText(this.a, new d(), paramView, true, this.N);
      return;
    }
    b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905169);
    this.a = this;
    this.S = getIntent().getStringExtra("gjPhone");
    this.R = getIntent().getIntExtra("loanState", 0);
    this.P = getIntent().getStringExtra("backRentOrderCode");
    this.Q = getIntent().getStringExtra("contractCode");
    initView();
    setOnclick();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    if ((this.I != null) && (this.I.isShowing()))
    {
      this.I.dismiss();
      this.J = true;
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setOnclick()
  {
    this.E.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.B.setOnClickListener(this);
  }
  
  public class a
    extends BaseAdapter
  {
    private a b;
    
    public a() {}
    
    public int getCount()
    {
      return TerminationHandleSureActivity.f(TerminationHandleSureActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return TerminationHandleSureActivity.f(TerminationHandleSureActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        this.b = new a();
        paramView = View.inflate(TerminationHandleSureActivity.b(TerminationHandleSureActivity.this), 2130904195, null);
        this.b.a = ((TextView)paramView.findViewById(2131694982));
        this.b.b = ((TextView)paramView.findViewById(2131694985));
        this.b.c = ((TextView)paramView.findViewById(2131694983));
        this.b.d = ((TextView)paramView.findViewById(2131694984));
        this.b.e = ((TextView)paramView.findViewById(2131694986));
        paramView.setTag(this.b);
        this.b.a.setText(((h)TerminationHandleSureActivity.f(TerminationHandleSureActivity.this).get(paramInt)).getName());
        if (TextUtils.isEmpty(((h)TerminationHandleSureActivity.f(TerminationHandleSureActivity.this).get(paramInt)).getBalance())) {
          break label350;
        }
        this.b.b.setText("卡显示余额" + ((h)TerminationHandleSureActivity.f(TerminationHandleSureActivity.this).get(paramInt)).getBalance());
      }
      for (;;)
      {
        this.b.c.setText(((h)TerminationHandleSureActivity.f(TerminationHandleSureActivity.this).get(paramInt)).getPrice() + "");
        this.b.e.setText(((h)TerminationHandleSureActivity.f(TerminationHandleSureActivity.this).get(paramInt)).getDisplayNums());
        if (!"1".equals(((h)TerminationHandleSureActivity.f(TerminationHandleSureActivity.this).get(paramInt)).getIsAdvancePay())) {
          break label365;
        }
        this.b.d.setText(2131296815);
        return paramView;
        this.b = ((a)paramView.getTag());
        break;
        label350:
        this.b.b.setText("");
      }
      label365:
      this.b.d.setText("");
      return paramView;
    }
    
    class a
    {
      TextView a;
      TextView b;
      TextView c;
      TextView d;
      TextView e;
      
      a() {}
    }
  }
  
  public class b
    extends BaseAdapter
  {
    private a b;
    
    public b() {}
    
    public int getCount()
    {
      return TerminationHandleSureActivity.e(TerminationHandleSureActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return TerminationHandleSureActivity.e(TerminationHandleSureActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        this.b = new a();
        paramView = View.inflate(TerminationHandleSureActivity.b(TerminationHandleSureActivity.this), 2130904212, null);
        this.b.a = ((TextView)paramView.findViewById(2131695040));
        this.b.b = ((TextView)paramView.findViewById(2131695041));
        this.b.c = ((TextView)paramView.findViewById(2131695043));
        this.b.d = ((TextView)paramView.findViewById(2131695044));
        this.b.e = ((TextView)paramView.findViewById(2131695045));
        paramView.setTag(this.b);
        this.b.a.setText(((f)TerminationHandleSureActivity.e(TerminationHandleSureActivity.this).get(paramInt)).getName());
        this.b.b.setText(((f)TerminationHandleSureActivity.e(TerminationHandleSureActivity.this).get(paramInt)).getCount());
        this.b.c.setText(((f)TerminationHandleSureActivity.e(TerminationHandleSureActivity.this).get(paramInt)).getBrand());
        this.b.d.setText(((f)TerminationHandleSureActivity.e(TerminationHandleSureActivity.this).get(paramInt)).getType());
        paramInt = Integer.parseInt(((f)TerminationHandleSureActivity.e(TerminationHandleSureActivity.this).get(paramInt)).getState());
        if (paramInt != 1) {
          break label290;
        }
        this.b.e.setText(2131297291);
      }
      label290:
      do
      {
        return paramView;
        this.b = ((a)paramView.getTag());
        break;
        if (paramInt == 2)
        {
          this.b.e.setText(2131297024);
          return paramView;
        }
        if (paramInt == 3)
        {
          this.b.e.setText(2131296606);
          return paramView;
        }
      } while (paramInt != 4);
      this.b.e.setText(2131296605);
      return paramView;
    }
    
    class a
    {
      TextView a;
      TextView b;
      TextView c;
      TextView d;
      TextView e;
      
      a() {}
    }
  }
  
  public class c
    extends BaseAdapter
  {
    private a b;
    
    public c() {}
    
    public int getCount()
    {
      return TerminationHandleSureActivity.g(TerminationHandleSureActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return TerminationHandleSureActivity.g(TerminationHandleSureActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        this.b = new a();
        paramViewGroup = View.inflate(TerminationHandleSureActivity.b(TerminationHandleSureActivity.this), 2130904264, null);
        this.b.a = ((TextView)paramViewGroup.findViewById(2131695122));
        this.b.b = ((TextView)paramViewGroup.findViewById(2131695123));
        this.b.c = ((TextView)paramViewGroup.findViewById(2131695124));
        paramViewGroup.setTag(this.b);
        this.b.a.setText(((com.ziroom.ziroomcustomer.termination.a.j)TerminationHandleSureActivity.g(TerminationHandleSureActivity.this).get(paramInt)).getName());
        this.b.b.setText(((com.ziroom.ziroomcustomer.termination.a.j)TerminationHandleSureActivity.g(TerminationHandleSureActivity.this).get(paramInt)).getCount());
        paramView = ((com.ziroom.ziroomcustomer.termination.a.j)TerminationHandleSureActivity.g(TerminationHandleSureActivity.this).get(paramInt)).getState();
        if (!"1".equals(paramView)) {
          break label262;
        }
        paramView = "正常 ";
      }
      for (;;)
      {
        String str = ((com.ziroom.ziroomcustomer.termination.a.j)TerminationHandleSureActivity.g(TerminationHandleSureActivity.this).get(paramInt)).getIsDeliver();
        if ((TextUtils.isEmpty(str)) || (!"1".equals(str))) {
          break label313;
        }
        this.b.c.setText(paramView + "已交付");
        return paramViewGroup;
        this.b = ((a)paramView.getTag());
        paramViewGroup = paramView;
        break;
        label262:
        if ("2".equals(paramView)) {
          paramView = "丢失 ";
        } else if ("3".equals(paramView)) {
          paramView = "损坏可维修 ";
        } else if ("4".equals(paramView)) {
          paramView = "损坏不可维修 ";
        } else {
          paramView = "";
        }
      }
      label313:
      this.b.c.setText(paramView + "未交付");
      return paramViewGroup;
    }
    
    class a
    {
      TextView a;
      TextView b;
      TextView c;
      
      a() {}
    }
  }
  
  class d
    implements i.a<String>
  {
    d() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        if (paramk.getUrl().equals(TerminationHandleSureActivity.i(TerminationHandleSureActivity.this)))
        {
          paramString = (com.ziroom.ziroomcustomer.termination.a.e)a.parseObject(paramString.get("data").toString(), com.ziroom.ziroomcustomer.termination.a.e.class);
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(paramString);
        }
        do
        {
          return;
          if (paramk.getUrl().equals(TerminationHandleSureActivity.k(TerminationHandleSureActivity.this)))
          {
            paramString = (i)a.parseObject(paramString.get("data").toString(), i.class);
            paramk.setSuccess(Boolean.valueOf(true));
            paramk.setObject(paramString);
            return;
          }
          if (paramk.getUrl().equals(TerminationHandleSureActivity.m(TerminationHandleSureActivity.this)))
          {
            paramString = (com.ziroom.ziroomcustomer.termination.a.g)a.parseObject(paramString.get("data").toString(), com.ziroom.ziroomcustomer.termination.a.g.class);
            paramk.setSuccess(Boolean.valueOf(true));
            paramk.setObject(paramString);
            return;
          }
        } while (!paramk.getUrl().equals(TerminationHandleSureActivity.c(TerminationHandleSureActivity.this)));
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue()) {
        if (paramk.getUrl().equals(TerminationHandleSureActivity.i(TerminationHandleSureActivity.this)))
        {
          TerminationHandleSureActivity.a(TerminationHandleSureActivity.this, (com.ziroom.ziroomcustomer.termination.a.e)paramk.getObject());
          TerminationHandleSureActivity.a(TerminationHandleSureActivity.this, TerminationHandleSureActivity.j(TerminationHandleSureActivity.this).getGoodsList());
          TerminationHandleSureActivity.a(TerminationHandleSureActivity.this, new TerminationHandleSureActivity.b(TerminationHandleSureActivity.this));
          TerminationHandleSureActivity.a(TerminationHandleSureActivity.this, TerminationHandleSureActivity.b(TerminationHandleSureActivity.this), 1);
        }
      }
      for (;;)
      {
        TerminationHandleSureActivity.this.dismissProgress();
        return;
        if (paramk.getUrl().equals(TerminationHandleSureActivity.k(TerminationHandleSureActivity.this)))
        {
          TerminationHandleSureActivity.a(TerminationHandleSureActivity.this, (i)paramk.getObject());
          TerminationHandleSureActivity.b(TerminationHandleSureActivity.this, TerminationHandleSureActivity.l(TerminationHandleSureActivity.this).getKeyCardsList());
          TerminationHandleSureActivity.a(TerminationHandleSureActivity.this, new TerminationHandleSureActivity.c(TerminationHandleSureActivity.this));
          TerminationHandleSureActivity.a(TerminationHandleSureActivity.this, TerminationHandleSureActivity.b(TerminationHandleSureActivity.this), 3);
        }
        else if (paramk.getUrl().equals(TerminationHandleSureActivity.m(TerminationHandleSureActivity.this)))
        {
          TerminationHandleSureActivity.a(TerminationHandleSureActivity.this, (com.ziroom.ziroomcustomer.termination.a.g)paramk.getObject());
          TerminationHandleSureActivity.c(TerminationHandleSureActivity.this, TerminationHandleSureActivity.n(TerminationHandleSureActivity.this).getExpendsList());
          TerminationHandleSureActivity.a(TerminationHandleSureActivity.this, new TerminationHandleSureActivity.a(TerminationHandleSureActivity.this));
          TerminationHandleSureActivity.a(TerminationHandleSureActivity.this, TerminationHandleSureActivity.b(TerminationHandleSureActivity.this), 2);
        }
        else if (paramk.getUrl().equals(TerminationHandleSureActivity.c(TerminationHandleSureActivity.this)))
        {
          TerminationHandleSureActivity.this.finish();
          continue;
          paramk = paramk.getMessage();
          TerminationHandleSureActivity.this.showToast(paramk);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/TerminationHandleSureActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */