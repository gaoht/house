package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.c.a;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.AlternateListing;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.model.InitiateTipsBean;
import com.ziroom.ziroomcustomer.my.widget.InitiateAppointTipsActivity;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.v;
import com.ziroom.ziroomcustomer.util.w;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InitiateAppointActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView A;
  private TextView B;
  private String C;
  private String D;
  private int E;
  private String F;
  private String G;
  private String H;
  private String I;
  private String J;
  private String K;
  private String L;
  private boolean M = true;
  private UserInfo N;
  private boolean O = true;
  private int P = 50;
  private String Q = "";
  private String R = "";
  private String S;
  private String T;
  private String U;
  private int V;
  private InitiateTipsBean W;
  private String X;
  private String Y;
  private Handler Z = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      InitiateAppointActivity.this.dismissProgress();
      switch (paramAnonymousMessage.what)
      {
      }
    }
  };
  protected boolean a;
  private Handler aa = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (locall.getSuccess().booleanValue())
      {
        com.ziroom.commonlibrary.g.b.a.onAppointmentSubmitSuccess();
        com.ziroom.ziroomcustomer.b.a.delete(InitiateAppointActivity.this, InitiateAppointActivity.f(InitiateAppointActivity.this).getUid(), InitiateAppointActivity.g(InitiateAppointActivity.this), InitiateAppointActivity.h(InitiateAppointActivity.this), InitiateAppointActivity.i(InitiateAppointActivity.this));
        InitiateAppointActivity.this.showToast("约看成功，管家很快会联系您");
        if (!TextUtils.isEmpty(InitiateAppointActivity.f(InitiateAppointActivity.this).getUid()))
        {
          paramAnonymousMessage = new ArrayList();
          paramAnonymousMessage.add(InitiateAppointActivity.this.getAlternateListing());
          d.removeAlternateListing(InitiateAppointActivity.this, InitiateAppointActivity.j(InitiateAppointActivity.this), paramAnonymousMessage);
        }
        if ("157".equals(locall.getCode())) {
          com.ziroom.ziroomcustomer.dialog.c.newBuilder(InitiateAppointActivity.this).setContent(locall.getMessage()).setButtonText("我知道了").setTitle("友情提示!").setOnButtonClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              if (InitiateAppointActivity.k(InitiateAppointActivity.this) == null)
              {
                InitiateAppointActivity.this.finish();
                return;
              }
              InitiateAppointActivity.l(InitiateAppointActivity.this);
            }
          }).build().show();
        }
        for (;;)
        {
          InitiateAppointActivity.a(InitiateAppointActivity.this, ApplicationEx.c.getUser());
          InitiateAppointActivity.this.a = ApplicationEx.c.isLoginState();
          InitiateAppointActivity.this.dismissProgress();
          return;
          InitiateAppointActivity.l(InitiateAppointActivity.this);
        }
      }
      if ("504209".equals(locall.getCode())) {
        InitiateAppointActivity.this.showToast(locall.getMessage());
      }
      for (;;)
      {
        InitiateAppointActivity.this.finish();
        break;
        InitiateAppointActivity.this.showToast(locall.getMessage());
      }
    }
  };
  TextWatcher b = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (VdsAgent.trackEditTextSilent(InitiateAppointActivity.a(InitiateAppointActivity.this)).toString().length() > InitiateAppointActivity.b(InitiateAppointActivity.this))
      {
        InitiateAppointActivity.a(InitiateAppointActivity.this).setText(InitiateAppointActivity.c(InitiateAppointActivity.this) + "");
        InitiateAppointActivity.this.showToast("请不要输入大于" + InitiateAppointActivity.b(InitiateAppointActivity.this) + "个字符");
      }
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      InitiateAppointActivity.a(InitiateAppointActivity.this, paramAnonymousCharSequence.toString());
    }
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  a.a c = new a.a()
  {
    public void showHour(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      Calendar localCalendar = Calendar.getInstance();
      if ("随时可看".equals(paramAnonymousString1))
      {
        InitiateAppointActivity.e(InitiateAppointActivity.this).setText(paramAnonymousString1);
        InitiateAppointActivity.d(InitiateAppointActivity.this, paramAnonymousString1);
        return;
      }
      if ("今天".equals(paramAnonymousString1))
      {
        InitiateAppointActivity.e(InitiateAppointActivity.this).setText(paramAnonymousString1 + " " + paramAnonymousString2);
        if (ae.isNull(paramAnonymousString3))
        {
          InitiateAppointActivity.d(InitiateAppointActivity.this, localCalendar.get(2) + 1 + "月" + localCalendar.get(5) + "日 " + paramAnonymousString2);
          return;
        }
        InitiateAppointActivity.d(InitiateAppointActivity.this, paramAnonymousString3 + " " + paramAnonymousString2);
        return;
      }
      if ("明天".equals(paramAnonymousString1))
      {
        InitiateAppointActivity.e(InitiateAppointActivity.this).setText(paramAnonymousString1 + " " + paramAnonymousString2);
        if (ae.isNull(paramAnonymousString3))
        {
          if (m.getDateAfter(localCalendar.getTime(), 1).getYear() == localCalendar.getTime().getYear())
          {
            InitiateAppointActivity.d(InitiateAppointActivity.this, localCalendar.get(2) + 1 + "月" + localCalendar.get(5) + "日 " + paramAnonymousString2);
            return;
          }
          InitiateAppointActivity.d(InitiateAppointActivity.this, localCalendar.get(1) + "年" + (localCalendar.get(2) + 1) + "月" + localCalendar.get(5) + "日 " + paramAnonymousString2);
          return;
        }
        InitiateAppointActivity.d(InitiateAppointActivity.this, paramAnonymousString3 + " " + paramAnonymousString2);
        return;
      }
      InitiateAppointActivity.d(InitiateAppointActivity.this, paramAnonymousString3 + " " + paramAnonymousString2);
      InitiateAppointActivity.e(InitiateAppointActivity.this).setText(paramAnonymousString1 + " " + paramAnonymousString2);
    }
  };
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private EditText s;
  private EditText t;
  private EditText u;
  private EditText v;
  private ImageView w;
  private ImageView x;
  private SimpleDraweeView y;
  private TextView z;
  
  private void a()
  {
    this.g = ((TextView)findViewById(2131689852));
    this.d = ((TextView)findViewById(2131690049));
    this.e = ((TextView)findViewById(2131690666));
    this.r = ((TextView)findViewById(2131689997));
    this.f = ((TextView)findViewById(2131690983));
    this.s = ((EditText)findViewById(2131689810));
    this.t = ((EditText)findViewById(2131689811));
    this.u = ((EditText)findViewById(2131690987));
    this.v = ((EditText)findViewById(2131690989));
    this.w = ((ImageView)findViewById(2131690982));
    this.x = ((ImageView)findViewById(2131689492));
    this.y = ((SimpleDraweeView)findViewById(2131689908));
    this.z = ((TextView)findViewById(2131690978));
    this.A = ((TextView)findViewById(2131690979));
    this.B = ((TextView)findViewById(2131690980));
  }
  
  private void a(List<com.alibaba.fastjson.e> paramList)
  {
    paramList = new a(this, this.c, paramList, 0);
    paramList.setCanceledOnTouchOutside(true);
    Window localWindow = paramList.getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setGravity(80);
    paramList.show();
    paramList.getTv_choose().setText("");
  }
  
  private boolean a(TextView paramTextView1, TextView paramTextView2)
  {
    if (!checkNet(getApplicationContext()))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 1);
      return false;
    }
    this.J = paramTextView1.getText().toString().trim();
    this.K = paramTextView2.getText().toString().trim();
    if (ae.isNull(this.J))
    {
      g.textToast(getApplicationContext(), "请输入姓名", 0);
      return false;
    }
    if ((ae.isNull(this.K)) || (!ah.isMobile(this.K)))
    {
      g.textToast(getApplicationContext(), "请输入正确的手机号！", 0);
      return false;
    }
    return true;
  }
  
  private void b()
  {
    this.r.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.s.addTextChangedListener(new a(this.d));
    this.t.addTextChangedListener(new a(this.e));
    this.x.setOnClickListener(this);
    this.s.setOnFocusChangeListener(new v(this, "seeroom_start_name"));
    this.u.setOnClickListener(this);
    this.t.setOnFocusChangeListener(new v(this, "seeroom_start_phone"));
    this.v.addTextChangedListener(this.b);
  }
  
  private void e()
  {
    Object localObject = getIntent();
    this.C = ((Intent)localObject).getStringExtra("house_code");
    this.D = ((Intent)localObject).getStringExtra("mHouse_id");
    this.E = ((Intent)localObject).getIntExtra("mHouse_type", 3);
    this.F = ((Intent)localObject).getStringExtra("villageId");
    this.G = ((Intent)localObject).getStringExtra("house_title");
    this.H = ((Intent)localObject).getStringExtra("house_price");
    this.I = ((Intent)localObject).getStringExtra("house_area");
    this.z.setText(this.G);
    this.A.setText(this.H);
    this.B.setText(this.I);
    localObject = ((Intent)localObject).getStringExtra("house_photo");
    com.freelxl.baselibrary.f.c.frescoHierarchyController(this.y, 2130838349);
    this.y.setController(com.freelxl.baselibrary.f.c.frescoController((String)localObject));
    j.getAppointInfo(this, this.C, this.D, this.R, new com.ziroom.ziroomcustomer.e.a.e(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("is_display")))
        {
          InitiateAppointActivity.a(InitiateAppointActivity.this, paramAnonymouse.getInteger("is_display").intValue());
          if ((InitiateAppointActivity.d(InitiateAppointActivity.this) == 1) && (paramAnonymouse.containsKey("popup")))
          {
            InitiateAppointActivity.b(InitiateAppointActivity.this, paramAnonymouse.getString("popup"));
            InitiateAppointActivity.c(InitiateAppointActivity.this, paramAnonymouse.getString("skipUrl"));
          }
        }
      }
    });
    j.getAppointTips(this, new com.ziroom.ziroomcustomer.findhouse.b.b(this, new com.ziroom.ziroomcustomer.findhouse.b.e(InitiateTipsBean.class))
    {
      public void onSuccess(int paramAnonymousInt, InitiateTipsBean paramAnonymousInitiateTipsBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousInitiateTipsBean);
        InitiateAppointActivity.a(InitiateAppointActivity.this, paramAnonymousInitiateTipsBean);
      }
    });
    f();
  }
  
  private void f()
  {
    this.a = ApplicationEx.c.isLoginState();
    if (this.a)
    {
      this.N = ApplicationEx.c.getUser();
      if (this.N != null)
      {
        UserInfo localUserInfo = ApplicationEx.c.getUser();
        this.J = ad.getOther(this, this.S);
        this.K = ad.getOther(this, this.T);
        this.M = "1".equals(ad.getOther(this, this.U));
        if (localUserInfo != null)
        {
          if ((ae.isNull(this.J)) && (!TextUtils.isEmpty(localUserInfo.getUser_name()))) {
            this.J = localUserInfo.getUser_name();
          }
          if ((ae.isNull(this.K)) && (!TextUtils.isEmpty(localUserInfo.getLogin_name_mobile()))) {
            this.K = localUserInfo.getLogin_name_mobile();
          }
        }
        this.t.setGravity(21);
        this.s.setText(this.J);
        this.t.setText(this.K);
        if (this.M)
        {
          this.f.setText("男");
          this.w.setBackgroundResource(2130839822);
          return;
        }
        this.f.setText("女");
        this.w.setBackgroundResource(2130839823);
        return;
      }
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  private void g()
  {
    if (this.W == null)
    {
      finish();
      return;
    }
    Intent localIntent = new Intent(this, InitiateAppointTipsActivity.class);
    localIntent.putExtra("initiateTipsBean", this.W);
    localIntent.putExtra("isDisplayCoupon", this.V);
    localIntent.putExtra("couponUrl", this.X);
    localIntent.putExtra("skipUrl", this.Y);
    startActivity(localIntent);
    finish();
  }
  
  private void h()
  {
    ad.putOther(this, this.S, this.J);
    ad.putOther(this, this.T, this.K);
    String str2 = this.U;
    if (this.M) {}
    for (String str1 = "1";; str1 = "2")
    {
      ad.putOther(this, str2, str1);
      return;
    }
  }
  
  private List<com.alibaba.fastjson.e> i()
  {
    ArrayList localArrayList1 = new ArrayList();
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    Calendar localCalendar = Calendar.getInstance();
    int j = localCalendar.getTime().getYear();
    int k = localCalendar.get(5);
    int m = localCalendar.getTime().getHours();
    Object localObject = new ArrayList();
    ((List)localObject).add("全天");
    ((List)localObject).add("");
    ((List)localObject).add("");
    ((List)localObject).add("");
    ((List)localObject).add("");
    locale.put("name", "随时可看");
    locale.put("time", localObject);
    localArrayList1.add(locale);
    int i = 0;
    if (i <= 9)
    {
      locale = new com.alibaba.fastjson.e();
      localObject = Calendar.getInstance();
      Date localDate = m.getDateAfter(localCalendar.getTime(), i);
      ((Calendar)localObject).setTime(localDate);
      ArrayList localArrayList2 = new ArrayList();
      if (((Calendar)localObject).get(5) == k) {
        if ((m >= 0) && (m < 12))
        {
          localArrayList2.add("全天");
          localArrayList2.add("上午");
          localArrayList2.add("下午");
          localArrayList2.add("晚上");
          label257:
          locale.put("name", "今天");
        }
      }
      for (;;)
      {
        localArrayList2.add("");
        localArrayList2.add("");
        localArrayList2.add("");
        localArrayList2.add("");
        locale.put("date", ((Calendar)localObject).get(1) + "-" + m.unitFormat(((Calendar)localObject).get(2) + 1) + "-" + m.unitFormat(((Calendar)localObject).get(5)));
        locale.put("time", localArrayList2);
        localArrayList1.add(locale);
        i += 1;
        break;
        if ((12 <= m) && (m < 18))
        {
          localArrayList2.add("下午");
          localArrayList2.add("晚上");
          break label257;
        }
        if (18 > m) {
          break label257;
        }
        localArrayList2.add("晚上");
        break label257;
        if (m.getDaysBetween(localCalendar.getTime(), ((Calendar)localObject).getTime()) == 1L)
        {
          localArrayList2.add("全天");
          localArrayList2.add("上午");
          localArrayList2.add("下午");
          localArrayList2.add("晚上");
          locale.put("name", "明天");
        }
        else if (localDate.getYear() == j)
        {
          localArrayList2.add("全天");
          localArrayList2.add("上午");
          localArrayList2.add("下午");
          localArrayList2.add("晚上");
          locale.put("name", ((Calendar)localObject).get(2) + 1 + "月" + ((Calendar)localObject).get(5) + "日 " + m.getWeekOfDate(localDate));
        }
        else
        {
          localArrayList2.add("全天");
          localArrayList2.add("上午");
          localArrayList2.add("下午");
          localArrayList2.add("晚上");
          locale.put("name", ((Calendar)localObject).get(1) + "年" + (((Calendar)localObject).get(2) + 1) + "月" + ((Calendar)localObject).get(5) + "日 " + m.getWeekOfDate(localDate));
        }
      }
    }
    return localArrayList1;
  }
  
  public AlternateListing getAlternateListing()
  {
    Object localObject = ApplicationEx.c.getUser();
    String str = "";
    if (localObject != null) {
      str = ((UserInfo)localObject).getUid();
    }
    localObject = new AlternateListing();
    ((AlternateListing)localObject).setCityCode(com.ziroom.ziroomcustomer.base.b.d);
    ((AlternateListing)localObject).setUid(str);
    ((AlternateListing)localObject).setHouse_type(this.E);
    ((AlternateListing)localObject).setHouse_id(this.D);
    ((AlternateListing)localObject).setId(this.C);
    ((AlternateListing)localObject).setTo_see_state("");
    return (AlternateListing)localObject;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131689492: 
    case 2131690982: 
    case 2131689997: 
      do
      {
        return;
        w.onEvent(this, "seeroom_start_return");
        finish();
        return;
        if (this.M)
        {
          this.M = false;
          this.f.setText("女");
          this.w.setBackgroundResource(2130839823);
        }
        for (;;)
        {
          w.onEvent(this, "seeroom_start_gendar");
          return;
          this.M = true;
          this.f.setText("男");
          this.w.setBackgroundResource(2130839822);
        }
      } while (!this.O);
      com.ziroom.commonlibrary.g.b.a.onAppointmentSubmit();
      this.O = false;
      w.onEvent(this, "seeroom_start_submit");
      this.N = ApplicationEx.c.getUser();
      this.a = ApplicationEx.c.isLoginState();
      if (this.a) {
        if (a(this.s, this.t))
        {
          h();
          Handler localHandler = this.aa;
          String str1 = this.N.getUid();
          String str2 = this.J;
          String str3 = this.K;
          String str4 = this.D;
          String str5 = this.C;
          int i = this.E;
          String str6 = this.F;
          String str7 = this.L;
          String str8 = VdsAgent.trackEditTextSilent(this.v).toString();
          if (!this.M) {
            break label344;
          }
          paramView = "1";
          d.initiateAppoint(localHandler, str1, str2, str3, str4, str5, i, str6, str7, str8, paramView);
          showProgress("");
          if ((this.E != 3) && (this.E != 4)) {
            break label351;
          }
          paramView = "entire_reserve_start_submit";
          label328:
          w.onEventToZiroomAndUmeng(paramView);
        }
      }
      for (;;)
      {
        new Thread()
        {
          public void run()
          {
            SystemClock.sleep(300L);
            if ((InitiateAppointActivity.this != null) && (!InitiateAppointActivity.this.isFinishing())) {
              InitiateAppointActivity.a(InitiateAppointActivity.this, true);
            }
          }
        }.start();
        return;
        label344:
        paramView = "2";
        break;
        label351:
        paramView = "joint_reserve_start_submit";
        break label328;
        com.ziroom.commonlibrary.login.a.startLoginActivity(this, VdsAgent.trackEditTextSilent(this.t).toString());
      }
    }
    a(i());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setSoftInputMode(32);
    setContentView(2130903222);
    if (ApplicationEx.c.getUser() != null)
    {
      this.R = ApplicationEx.c.getUser().getUid();
      this.S = (this.R + "_" + "zryu_custom_name");
      this.T = (this.R + "_" + "zryu_custom_phone");
      this.U = (this.R + "_" + "zryu_custom_issir");
    }
    a();
    b();
    e();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    f();
  }
  
  static class a
    implements TextWatcher
  {
    private TextView a;
    
    public a(TextView paramTextView)
    {
      this.a = paramTextView;
    }
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if (TextUtils.isEmpty(paramCharSequence))
      {
        this.a.setTextColor(Color.parseColor("#111111"));
        return;
      }
      this.a.setTextColor(Color.parseColor("#a3a3a3"));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/InitiateAppointActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */