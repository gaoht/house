package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.newServiceList.view.FlowLayoutLimitLine;
import com.ziroom.ziroomcustomer.newrepair.widget.StarBar;
import com.ziroom.ziroomcustomer.newrepair.widget.StarBar.a;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InternalRepairEvalActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private List<com.ziroom.ziroomcustomer.newrepair.b.a> A = new ArrayList();
  private String B = "";
  private String C = "";
  private String D = "";
  private LinearLayout E;
  private SimpleDraweeView F;
  private boolean G = false;
  private Context a;
  private LinearLayout b;
  private Button c;
  private int d = 0;
  private ImageView e;
  private TextView f;
  private SimpleDraweeView g;
  private TextView r;
  private RelativeLayout s;
  private FlowLayoutLimitLine t;
  private StarBar u;
  private EditText v;
  private int w = 200;
  private TextView x;
  private List<com.ziroom.ziroomcustomer.newrepair.b.b> y;
  private List<com.ziroom.ziroomcustomer.newrepair.b.a> z = new ArrayList();
  
  private void a()
  {
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.u.setOnStarChangeListener(new StarBar.a()
    {
      public void onStarChange(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat != InternalRepairEvalActivity.a(InternalRepairEvalActivity.this)) {
          InternalRepairEvalActivity.a(InternalRepairEvalActivity.this, (int)paramAnonymousFloat);
        }
      }
    });
    h();
  }
  
  private void a(List<com.ziroom.ziroomcustomer.newrepair.b.a> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        d(((com.ziroom.ziroomcustomer.newrepair.b.a)paramList.next()).getEvaluateLableName());
      }
    }
  }
  
  private void b()
  {
    String str1 = getIntent().getStringExtra("headUrl");
    String str2 = getIntent().getStringExtra("name");
    this.B = getIntent().getStringExtra("mailBillId");
    this.C = getIntent().getStringExtra("orderNum");
    this.D = getIntent().getStringExtra("serverId");
    this.f.setText(str2);
    if (!TextUtils.isEmpty(str1)) {
      this.g.setController(com.freelxl.baselibrary.f.c.frescoController(str1));
    }
    e();
  }
  
  private void b(int paramInt)
  {
    this.d = paramInt;
    this.A.clear();
    i();
    this.t.setVisibility(0);
    this.s.setVisibility(0);
    this.v.setVisibility(0);
    this.c.setVisibility(0);
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.r.setText(str);
      this.r.setTextColor(getResources().getColor(2131624516));
      return;
      str = "服务极差";
      continue;
      str = "服务很差";
      continue;
      str = "服务一般";
      continue;
      str = "服务良好";
      continue;
      str = "服务优秀";
    }
  }
  
  private void d(String paramString)
  {
    Button localButton = new Button(this);
    localButton.setText(paramString);
    localButton.setTag(Boolean.valueOf(false));
    localButton.setTextColor(getResources().getColor(2131624097));
    localButton.setTextSize(12.0F);
    localButton.setLines(1);
    localButton.setEllipsize(TextUtils.TruncateAt.END);
    localButton.setIncludeFontPadding(false);
    localButton.setPadding(n.dip2px(this.a, 8.0F), 0, n.dip2px(this.a, 8.0F), 0);
    localButton.setBackgroundResource(2130839367);
    paramString = new LinearLayout.LayoutParams(-2, n.dip2px(this.a, 24.0F));
    paramString.setMargins(0, 0, n.dip2px(this.a, 6.0F), n.dip2px(this.a, 6.0F));
    localButton.setLayoutParams(paramString);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = (Button)paramAnonymousView;
        String str = paramAnonymousView.getText().toString();
        if (!((Boolean)paramAnonymousView.getTag()).booleanValue())
        {
          paramAnonymousView.setBackgroundResource(2130839376);
          paramAnonymousView.setTextColor(InternalRepairEvalActivity.this.getResources().getColor(2131624583));
          paramAnonymousView.setTag(Boolean.valueOf(true));
          InternalRepairEvalActivity.a(InternalRepairEvalActivity.this, str);
          return;
        }
        paramAnonymousView.setBackgroundResource(2130839367);
        paramAnonymousView.setTextColor(InternalRepairEvalActivity.this.getResources().getColor(2131624097));
        paramAnonymousView.setTag(Boolean.valueOf(false));
        InternalRepairEvalActivity.b(InternalRepairEvalActivity.this, str);
      }
    });
    this.t.addView(localButton);
  }
  
  private void e()
  {
    showProgressNoCancel("", 30000L);
    com.ziroom.ziroomcustomer.e.j.getInternalRepairEvalList(this.a, new b(new com.ziroom.ziroomcustomer.newrepair.utils.a(com.ziroom.ziroomcustomer.newrepair.b.b.class, false)));
  }
  
  private void e(String paramString)
  {
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext())
    {
      com.ziroom.ziroomcustomer.newrepair.b.a locala = (com.ziroom.ziroomcustomer.newrepair.b.a)localIterator.next();
      if (paramString.equals(locala.getEvaluateLableName())) {
        this.A.add(locala);
      }
    }
  }
  
  private void f()
  {
    showEmptyView(this.b, "点击重试").setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        InternalRepairEvalActivity.d(InternalRepairEvalActivity.this);
      }
    });
  }
  
  private void f(String paramString)
  {
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext())
    {
      com.ziroom.ziroomcustomer.newrepair.b.a locala = (com.ziroom.ziroomcustomer.newrepair.b.a)localIterator.next();
      if (paramString.equals(locala.getEvaluateLableName())) {
        this.A.add(locala);
      }
    }
  }
  
  private void g()
  {
    this.b = ((LinearLayout)findViewById(2131689998));
    this.f = ((TextView)findViewById(2131690371));
    this.e = ((ImageView)findViewById(2131689492));
    this.v = ((EditText)findViewById(2131690002));
    this.x = ((TextView)findViewById(2131690003));
    this.s = ((RelativeLayout)findViewById(2131690001));
    this.u = ((StarBar)findViewById(2131690000));
    this.t = ((FlowLayoutLimitLine)findViewById(2131691005));
    this.t.setVisibility(8);
    this.c = ((Button)findViewById(2131689843));
    this.c.setTag("humanControlled");
    this.g = ((SimpleDraweeView)findViewById(2131690047));
    this.E = ((LinearLayout)findViewById(2131691006));
    this.F = ((SimpleDraweeView)findViewById(2131690027));
    this.r = ((TextView)findViewById(2131691004));
    this.d = 0;
    this.s.setVisibility(4);
    this.v.setVisibility(4);
    this.c.setVisibility(8);
  }
  
  private void h()
  {
    this.v.addTextChangedListener(new TextWatcher()
    {
      private CharSequence b;
      private int c;
      private int d;
      
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        int i = paramAnonymousEditable.length();
        InternalRepairEvalActivity.e(InternalRepairEvalActivity.this).setText("" + i);
        this.c = InternalRepairEvalActivity.f(InternalRepairEvalActivity.this).getSelectionStart();
        this.d = InternalRepairEvalActivity.f(InternalRepairEvalActivity.this).getSelectionEnd();
        if (this.b.length() > InternalRepairEvalActivity.g(InternalRepairEvalActivity.this))
        {
          paramAnonymousEditable.delete(this.c - 1, this.d);
          i = this.d;
          InternalRepairEvalActivity.f(InternalRepairEvalActivity.this).setText(paramAnonymousEditable);
          InternalRepairEvalActivity.f(InternalRepairEvalActivity.this).setSelection(i);
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.b = paramAnonymousCharSequence;
      }
    });
  }
  
  private void i()
  {
    if ((this.y != null) && (this.y.size() > 0))
    {
      Iterator localIterator = this.y.iterator();
      while (localIterator.hasNext())
      {
        com.ziroom.ziroomcustomer.newrepair.b.b localb = (com.ziroom.ziroomcustomer.newrepair.b.b)localIterator.next();
        if (this.d == localb.getScore()) {
          this.z = localb.getEvaluateLable();
        }
      }
      if ((this.z != null) && (this.z.size() > 0))
      {
        this.t.removeAllViews();
        a(this.z);
      }
    }
  }
  
  private void j()
  {
    if (this.d == 0)
    {
      g.textToast(this.a, "请选择维修人员评价分数");
      return;
    }
    showProgressNoCancel("", 30000L);
    String str = VdsAgent.trackEditTextSilent(this.v).toString();
    Object localObject2;
    if (this.A.size() > 0)
    {
      localObject1 = "";
      int i = 0;
      localObject2 = localObject1;
      if (i < this.A.size())
      {
        if (i < this.A.size() - 1) {}
        for (localObject1 = (String)localObject1 + ((com.ziroom.ziroomcustomer.newrepair.b.a)this.A.get(i)).getEvaluateLableCode() + "|";; localObject1 = (String)localObject1 + ((com.ziroom.ziroomcustomer.newrepair.b.a)this.A.get(i)).getEvaluateLableCode())
        {
          i += 1;
          break;
        }
      }
    }
    else
    {
      localObject2 = "";
    }
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("mailBillId", this.B);
    ((Map)localObject1).put("score", Integer.valueOf(this.d));
    ((Map)localObject1).put("suggestion", str);
    ((Map)localObject1).put("lables", localObject2);
    com.ziroom.ziroomcustomer.e.j.saveInternalRepairEval(this.a, (Map)localObject1, new a(new com.ziroom.ziroomcustomer.newrepair.utils.b(null)));
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
    }
    paramView = getIntent();
    paramView.putExtra("eval", false);
    setResult(-1, paramView);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(35);
    setContentView(2130903227);
    this.a = this;
    g();
    a();
    b();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Intent localIntent = getIntent();
      localIntent.putExtra("eval", false);
      setResult(-1, localIntent);
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  class a
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public a(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      InternalRepairEvalActivity.this.dismissProgress();
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      InternalRepairEvalActivity.this.dismissProgress();
      if (paraml.getSuccess().booleanValue())
      {
        g.textToast(InternalRepairEvalActivity.h(InternalRepairEvalActivity.this), "评价订单成功！");
        InternalRepairEvalActivity.a(InternalRepairEvalActivity.this, true);
        InternalRepairEvalActivity.i(InternalRepairEvalActivity.this).setVisibility(0);
        if (TextUtils.isEmpty(InternalRepairEvalActivity.j(InternalRepairEvalActivity.this))) {
          InternalRepairEvalActivity.k(InternalRepairEvalActivity.this).setVisibility(8);
        }
        for (;;)
        {
          org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("refresh_service_order_list", null));
          return;
          paraml = new Bundle();
          paraml.putString("thumbType", "repair");
          paraml.putString("showType", "eval");
          paraml.putString("orderCode", InternalRepairEvalActivity.l(InternalRepairEvalActivity.this));
          paraml.putString("orderNum", InternalRepairEvalActivity.m(InternalRepairEvalActivity.this));
          paraml.putString("employeeCode", InternalRepairEvalActivity.j(InternalRepairEvalActivity.this));
          com.ziroom.ziroomcustomer.newServiceList.utils.j.setServantThumb(InternalRepairEvalActivity.h(InternalRepairEvalActivity.this), InternalRepairEvalActivity.k(InternalRepairEvalActivity.this), paraml);
        }
      }
      paraml = paraml.getMessage();
      g.textToast(InternalRepairEvalActivity.h(InternalRepairEvalActivity.this), paraml);
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
      InternalRepairEvalActivity.this.dismissProgress();
      InternalRepairEvalActivity.c(InternalRepairEvalActivity.this);
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        InternalRepairEvalActivity.a(InternalRepairEvalActivity.this, (List)paraml.getObject());
        InternalRepairEvalActivity.this.closeEmpty(InternalRepairEvalActivity.b(InternalRepairEvalActivity.this));
      }
      for (;;)
      {
        InternalRepairEvalActivity.this.dismissProgress();
        return;
        paraml = paraml.getMessage();
        InternalRepairEvalActivity.this.showToast(paraml);
        InternalRepairEvalActivity.c(InternalRepairEvalActivity.this);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/InternalRepairEvalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */