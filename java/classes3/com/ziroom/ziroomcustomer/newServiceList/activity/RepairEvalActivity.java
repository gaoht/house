package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.model.af;
import com.ziroom.ziroomcustomer.newServiceList.model.af.a;
import com.ziroom.ziroomcustomer.newServiceList.model.af.b;
import com.ziroom.ziroomcustomer.newServiceList.model.h;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepairEvalActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView A;
  private String B;
  private String C;
  private String D;
  private TextView E;
  private FlowLayout F;
  private FlowLayout G;
  private List<af.b> H;
  private List<af.a> I;
  private SimpleDraweeView J;
  private TextView K;
  private String L;
  private af M;
  private List<h> N = new ArrayList();
  private List<com.ziroom.ziroomcustomer.newServiceList.model.g> O = new ArrayList();
  private ArrayList<String> P = new ArrayList();
  private ArrayList<String> Q = new ArrayList();
  private int R = 150;
  private TextView S;
  private RelativeLayout T;
  private LinearLayout U;
  private SimpleDraweeView V;
  private String W;
  private Handler X = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69961: 
        if (locall.getSuccess().booleanValue())
        {
          RepairEvalActivity.a(RepairEvalActivity.this, (af)locall.getObject());
          RepairEvalActivity.a(RepairEvalActivity.this);
          RepairEvalActivity.b(RepairEvalActivity.this);
          RepairEvalActivity.c(RepairEvalActivity.this);
        }
        for (;;)
        {
          RepairEvalActivity.this.dismissProgress();
          return;
          com.freelxl.baselibrary.f.g.textToast(RepairEvalActivity.d(RepairEvalActivity.this), locall.getMessage());
        }
      }
      if (locall.getSuccess().booleanValue())
      {
        RepairEvalActivity.e(RepairEvalActivity.this).setVisibility(0);
        if (TextUtils.isEmpty(RepairEvalActivity.f(RepairEvalActivity.this)))
        {
          RepairEvalActivity.g(RepairEvalActivity.this).setVisibility(8);
          org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("refresh_service_order_list", null));
        }
      }
      for (;;)
      {
        RepairEvalActivity.this.dismissProgress();
        return;
        paramAnonymousMessage = new Bundle();
        paramAnonymousMessage.putString("thumbType", "repair");
        paramAnonymousMessage.putString("showType", "eval");
        paramAnonymousMessage.putString("orderCode", RepairEvalActivity.h(RepairEvalActivity.this));
        paramAnonymousMessage.putString("orderNum", RepairEvalActivity.h(RepairEvalActivity.this));
        paramAnonymousMessage.putString("employeeCode", RepairEvalActivity.f(RepairEvalActivity.this));
        j.setServantThumb(RepairEvalActivity.d(RepairEvalActivity.this), RepairEvalActivity.g(RepairEvalActivity.this), paramAnonymousMessage);
        break;
        com.freelxl.baselibrary.f.g.textToast(RepairEvalActivity.d(RepairEvalActivity.this), locall.getMessage());
      }
    }
  };
  private Context a;
  private UserInfo b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private LinearLayout f;
  private RelativeLayout g;
  private ImageView r;
  private ImageView s;
  private ImageView t;
  private ImageView u;
  private ImageView v;
  private EditText w;
  private Button x;
  private String y = "";
  private int z = 0;
  
  private void a()
  {
    this.b = ((ApplicationEx)getApplication()).getUser();
    this.W = getIntent().getStringExtra("servicerCode");
    if (getIntent().getStringExtra("maintainOrderCode") != null)
    {
      this.L = getIntent().getStringExtra("maintainOrderCode");
      this.B = getIntent().getStringExtra("repairPrice");
      this.E.setText(this.B);
      o.getNewRepairEvalInfo(this.a, this.X, this.b.getUid(), Long.valueOf(System.currentTimeMillis()), this.b.getLogin_name_mobile(), 12, this.L, "2", this.W);
    }
  }
  
  private void a(List<af.b> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        d(((af.b)paramList.next()).getTagValue());
      }
    }
  }
  
  private void b()
  {
    this.c = ((TextView)findViewById(2131690371));
    this.d = ((TextView)findViewById(2131691195));
    this.E = ((TextView)findViewById(2131690199));
    this.e = ((ImageView)findViewById(2131691963));
    this.f = ((LinearLayout)findViewById(2131690197));
    this.g = ((RelativeLayout)findViewById(2131691965));
    this.r = ((ImageView)findViewById(2131690054));
    this.s = ((ImageView)findViewById(2131690055));
    this.t = ((ImageView)findViewById(2131690056));
    this.u = ((ImageView)findViewById(2131690057));
    this.v = ((ImageView)findViewById(2131690058));
    this.A = ((ImageView)findViewById(2131689492));
    this.w = ((EditText)findViewById(2131690002));
    this.S = ((TextView)findViewById(2131690003));
    this.T = ((RelativeLayout)findViewById(2131690001));
    this.F = ((FlowLayout)findViewById(2131691964));
    this.G = ((FlowLayout)findViewById(2131691967));
    this.F.setVisibility(8);
    this.G.setVisibility(8);
    this.x = ((Button)findViewById(2131689843));
    this.J = ((SimpleDraweeView)findViewById(2131690047));
    this.K = ((TextView)findViewById(2131691966));
    this.U = ((LinearLayout)findViewById(2131691006));
    this.V = ((SimpleDraweeView)findViewById(2131690027));
    this.z = 0;
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.T.setVisibility(4);
    this.w.setVisibility(4);
    this.x.setVisibility(4);
    String str = getIntent().getStringExtra("firstEval");
    if ((!TextUtils.isEmpty(str)) && ("firstEval".equals(str)))
    {
      this.f.setVisibility(8);
      this.g.setVisibility(8);
    }
  }
  
  private void b(int paramInt)
  {
    this.z = paramInt;
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    this.F.setVisibility(0);
    this.G.setVisibility(0);
    this.T.setVisibility(0);
    this.w.setVisibility(0);
    this.x.setVisibility(0);
    String str;
    if (paramInt == 1)
    {
      this.r.setImageResource(2130839757);
      this.s.setImageResource(2130839753);
      this.t.setImageResource(2130839753);
      this.u.setImageResource(2130839753);
      this.v.setImageResource(2130839753);
      str = "";
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.K.setText(str);
      return;
      if (paramInt == 2)
      {
        this.r.setImageResource(2130839757);
        this.s.setImageResource(2130839757);
        this.t.setImageResource(2130839753);
        this.u.setImageResource(2130839753);
        this.v.setImageResource(2130839753);
        break;
      }
      if (paramInt == 3)
      {
        this.r.setImageResource(2130839757);
        this.s.setImageResource(2130839757);
        this.t.setImageResource(2130839757);
        this.u.setImageResource(2130839753);
        this.v.setImageResource(2130839753);
        break;
      }
      if (paramInt == 4)
      {
        this.r.setImageResource(2130839757);
        this.s.setImageResource(2130839757);
        this.t.setImageResource(2130839757);
        this.u.setImageResource(2130839757);
        this.v.setImageResource(2130839753);
        break;
      }
      if (paramInt != 5) {
        break;
      }
      this.r.setImageResource(2130839757);
      this.s.setImageResource(2130839757);
      this.t.setImageResource(2130839757);
      this.u.setImageResource(2130839757);
      this.v.setImageResource(2130839757);
      break;
      str = "差";
      continue;
      str = "一般";
      continue;
      str = "良好";
      continue;
      str = "好";
      continue;
      str = "极好";
    }
  }
  
  private void b(List<af.a> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        g(((af.a)paramList.next()).getTagValue());
      }
    }
  }
  
  private void d(String paramString)
  {
    Button localButton = new Button(this);
    localButton.setText(paramString);
    localButton.setTag(Boolean.valueOf(false));
    localButton.setTextColor(getResources().getColor(2131624516));
    localButton.setTextSize(12.0F);
    localButton.setPadding(10, 0, 10, 0);
    localButton.setBackgroundResource(2130839371);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(10, 10, 10, 0);
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
          paramAnonymousView.setTextColor(RepairEvalActivity.this.getResources().getColor(2131624583));
          paramAnonymousView.setTag(Boolean.valueOf(true));
          RepairEvalActivity.a(RepairEvalActivity.this, str);
          return;
        }
        paramAnonymousView.setBackgroundResource(2130839371);
        paramAnonymousView.setTextColor(RepairEvalActivity.this.getResources().getColor(2131624516));
        paramAnonymousView.setTag(Boolean.valueOf(false));
        RepairEvalActivity.b(RepairEvalActivity.this, str);
      }
    });
    this.F.addView(localButton);
  }
  
  private void e()
  {
    this.w.addTextChangedListener(new TextWatcher()
    {
      private CharSequence b;
      private int c;
      private int d;
      
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        int i = paramAnonymousEditable.length();
        RepairEvalActivity.i(RepairEvalActivity.this).setText("" + i);
        this.c = RepairEvalActivity.j(RepairEvalActivity.this).getSelectionStart();
        this.d = RepairEvalActivity.j(RepairEvalActivity.this).getSelectionEnd();
        if (this.b.length() > RepairEvalActivity.k(RepairEvalActivity.this))
        {
          paramAnonymousEditable.delete(this.c - 1, this.d);
          i = this.d;
          RepairEvalActivity.j(RepairEvalActivity.this).setText(paramAnonymousEditable);
          RepairEvalActivity.j(RepairEvalActivity.this).setSelection(i);
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.b = paramAnonymousCharSequence;
      }
    });
  }
  
  private void e(String paramString)
  {
    this.P.add(paramString);
    Iterator localIterator = this.H.iterator();
    while (localIterator.hasNext())
    {
      af.b localb = (af.b)localIterator.next();
      if (paramString.equals(localb.getTagValue()))
      {
        paramString = new h();
        paramString.setEvaluateKey(Integer.valueOf(localb.getTagKey()));
        paramString.setEvaluateValue(localb.getTagValue());
        this.N.add(paramString);
      }
    }
  }
  
  private void f()
  {
    this.c.setText(this.M.getServicerName());
    this.d.setText("累计服务" + this.M.getServiceNum() + "次");
    if (!TextUtils.isEmpty(this.M.getServicerHeadPath())) {
      this.J.setController(com.freelxl.baselibrary.f.c.frescoController(this.M.getServicerHeadPath()));
    }
    findViewById(2131691963).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ah.callPhone(RepairEvalActivity.d(RepairEvalActivity.this), RepairEvalActivity.l(RepairEvalActivity.this).getServicerPhone());
      }
    });
  }
  
  private void f(String paramString)
  {
    this.P.remove(paramString);
    Iterator localIterator = this.H.iterator();
    while (localIterator.hasNext())
    {
      af.b localb = (af.b)localIterator.next();
      if (paramString.equals(localb.getTagValue())) {
        this.N.remove(localb);
      }
    }
  }
  
  private void g()
  {
    this.H = this.M.getPositiveTags();
    this.I = this.M.getNegativeTags();
    if ((this.H != null) && (this.H.size() > 0)) {
      a(this.H);
    }
    if ((this.I != null) && (this.I.size() > 0)) {
      b(this.I);
    }
  }
  
  private void g(String paramString)
  {
    Button localButton = new Button(this);
    localButton.setText(paramString);
    localButton.setTag(Boolean.valueOf(false));
    localButton.setTextColor(getResources().getColor(2131624513));
    localButton.setTextSize(12.0F);
    localButton.setPadding(10, 0, 10, 0);
    localButton.setBackgroundResource(2130839369);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(10, 10, 10, 0);
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
          paramAnonymousView.setBackgroundResource(2130839370);
          paramAnonymousView.setTextColor(RepairEvalActivity.this.getResources().getColor(2131624583));
          paramAnonymousView.setTag(Boolean.valueOf(true));
          RepairEvalActivity.c(RepairEvalActivity.this, str);
          return;
        }
        paramAnonymousView.setBackgroundResource(2130839369);
        paramAnonymousView.setTextColor(RepairEvalActivity.this.getResources().getColor(2131624513));
        paramAnonymousView.setTag(Boolean.valueOf(false));
        RepairEvalActivity.d(RepairEvalActivity.this, str);
      }
    });
    this.G.addView(localButton);
  }
  
  private void h()
  {
    this.b = ApplicationEx.c.getUser();
    if (this.z == 0)
    {
      com.freelxl.baselibrary.f.g.textToast(this.a, "请选择保洁员评价分数");
      return;
    }
    String str1 = VdsAgent.trackEditTextSilent(this.w).toString();
    int i = this.z;
    String str2 = a.toJSONString(this.N);
    String str3 = a.toJSONString(this.O);
    o.saveRepairEvaluate(this.a, this.X, this.b.getUid(), Long.valueOf(System.currentTimeMillis()), this.b.getLogin_name_mobile(), 12, this.L, "2", str1, this.M.getEvaluateProjectCode(), Integer.valueOf(i), str2, str3);
  }
  
  private void h(String paramString)
  {
    this.Q.add(paramString);
    Iterator localIterator = this.I.iterator();
    while (localIterator.hasNext())
    {
      af.a locala = (af.a)localIterator.next();
      if (paramString.equals(locala.getTagValue()))
      {
        paramString = new com.ziroom.ziroomcustomer.newServiceList.model.g();
        paramString.setEvaluateKey(Integer.valueOf(locala.getTagKey()));
        paramString.setEvaluateValue(locala.getTagValue());
        this.O.add(paramString);
      }
    }
  }
  
  private void i(String paramString)
  {
    this.Q.remove(paramString);
    Iterator localIterator = this.I.iterator();
    while (localIterator.hasNext())
    {
      af.a locala = (af.a)localIterator.next();
      if (paramString.equals(locala.getTagValue())) {
        this.O.remove(locala);
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
      return;
    case 2131690054: 
      b(1);
      return;
    case 2131690055: 
      b(2);
      return;
    case 2131690056: 
      b(3);
      return;
    case 2131690057: 
      b(4);
      return;
    case 2131690058: 
      b(5);
      return;
    case 2131689843: 
      h();
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903395);
    this.C = "自如维修";
    this.D = "http://pic.ziroom.com/sms2/pics/20151016/24505b49-894e-43f6-bf8c-9198c33ae16b.png";
    this.a = this;
    b();
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairEvalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */