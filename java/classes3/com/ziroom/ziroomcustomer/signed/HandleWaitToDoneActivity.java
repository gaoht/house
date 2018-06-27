package com.ziroom.ziroomcustomer.signed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.activity.EvaluateActivity;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.home.MainFragmentActivity;
import com.ziroom.ziroomcustomer.my.CreditWebActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MoveTypeActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class HandleWaitToDoneActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Intent A;
  private HashMap<String, Object> B;
  private String C = null;
  private String D = null;
  private String E = null;
  private String F = null;
  private String G = null;
  private LinearLayout H;
  private TextView I;
  private String J;
  private View K;
  private TextView L;
  private TextView M;
  private TextView N;
  private TextView O;
  private Dialog P;
  private Handler Q = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      Object localObject = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return false;
        if (((l)localObject).getSuccess().booleanValue())
        {
          if (((l)localObject).getObject() != null) {
            HandleWaitToDoneActivity.a(HandleWaitToDoneActivity.this, (HashMap)((l)localObject).getObject());
          }
          paramAnonymousMessage = HandleWaitToDoneActivity.this.getIntent().getStringExtra("lease");
          if (("5".equals(HandleWaitToDoneActivity.e(HandleWaitToDoneActivity.this).get("house_type") + "")) || ("8".equals(HandleWaitToDoneActivity.e(HandleWaitToDoneActivity.this).get("house_type") + "")))
          {
            HandleWaitToDoneActivity.a(HandleWaitToDoneActivity.this, new Intent(HandleWaitToDoneActivity.this, NewZZItemsActivity.class));
            HandleWaitToDoneActivity.f(HandleWaitToDoneActivity.this).putExtra("wuyesure", "wuyesure");
            HandleWaitToDoneActivity.f(HandleWaitToDoneActivity.this).putExtra("contract_part_code", HandleWaitToDoneActivity.this.a);
            HandleWaitToDoneActivity.f(HandleWaitToDoneActivity.this).putExtra("bts_map", HandleWaitToDoneActivity.e(HandleWaitToDoneActivity.this));
            HandleWaitToDoneActivity.f(HandleWaitToDoneActivity.this).putExtra("lease", paramAnonymousMessage);
            HandleWaitToDoneActivity.this.startActivity(HandleWaitToDoneActivity.f(HandleWaitToDoneActivity.this));
            HandleWaitToDoneActivity.this.finish();
          }
        }
        for (;;)
        {
          HandleWaitToDoneActivity.this.dismissProgress();
          return false;
          HandleWaitToDoneActivity.a(HandleWaitToDoneActivity.this, new Intent(HandleWaitToDoneActivity.this, MainFragmentActivity.class));
          break;
          HandleWaitToDoneActivity.this.showToast(((l)localObject).getMessage());
        }
        HandleWaitToDoneActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue()) {
          for (;;)
          {
            try
            {
              localObject = new JSONObject(paramAnonymousMessage.getObject().toString()).getJSONObject("data");
              if (!TextUtils.isEmpty(((JSONObject)localObject).optString("type")))
              {
                if (HandleWaitToDoneActivity.g(HandleWaitToDoneActivity.this) == null) {
                  continue;
                }
                HandleWaitToDoneActivity.c(HandleWaitToDoneActivity.this, "fwgj");
                HandleWaitToDoneActivity.d(HandleWaitToDoneActivity.this, "XYPJ2");
              }
              HandleWaitToDoneActivity.e(HandleWaitToDoneActivity.this, ((JSONObject)localObject).optString("userAccount"));
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              continue;
              HandleWaitToDoneActivity.this.showProgress("");
              d.checkHasEvaluate(HandleWaitToDoneActivity.i(HandleWaitToDoneActivity.this), HandleWaitToDoneActivity.this, ApplicationEx.c.getUserId(HandleWaitToDoneActivity.this), "ziroomer", HandleWaitToDoneActivity.h(HandleWaitToDoneActivity.this), HandleWaitToDoneActivity.j(HandleWaitToDoneActivity.this), HandleWaitToDoneActivity.k(HandleWaitToDoneActivity.this), paramAnonymousMessage.getCode());
              return false;
            }
            if (!TextUtils.isEmpty(HandleWaitToDoneActivity.h(HandleWaitToDoneActivity.this))) {
              continue;
            }
            HandleWaitToDoneActivity.this.showToast("未找到当前管家信息,无法评价!");
            return false;
            HandleWaitToDoneActivity.c(HandleWaitToDoneActivity.this, "salesZO");
            HandleWaitToDoneActivity.d(HandleWaitToDoneActivity.this, "SZOASE2");
          }
        }
        HandleWaitToDoneActivity.this.showToast(paramAnonymousMessage.getMessage());
        return false;
        HandleWaitToDoneActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          HandleWaitToDoneActivity.this.showToast("您已经评价过了!");
          return false;
        }
      } while (HandleWaitToDoneActivity.g(HandleWaitToDoneActivity.this) == null);
      Intent localIntent = new Intent(HandleWaitToDoneActivity.this, EvaluateActivity.class);
      localIntent.putExtra("old_contract_code", paramAnonymousMessage.getCode());
      localIntent.putExtra("questionType", HandleWaitToDoneActivity.k(HandleWaitToDoneActivity.this));
      localIntent.putExtra("uid", HandleWaitToDoneActivity.h(HandleWaitToDoneActivity.this));
      localIntent.putExtra("stewardType", HandleWaitToDoneActivity.j(HandleWaitToDoneActivity.this));
      localIntent.putExtra("type", 0);
      localIntent.putExtra("isBack", false);
      HandleWaitToDoneActivity.this.startActivity(localIntent);
      return false;
    }
  });
  public String a;
  public String b;
  private Context c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private ImageView u;
  private View v;
  private ImageView w;
  private Button x;
  private Button y;
  private String z;
  
  private void a()
  {
    d.getSundHandleList(this.Q, this.a);
    showProgress("");
  }
  
  private void b()
  {
    this.t = ((TextView)findViewById(2131697633));
    this.I = ((TextView)findViewById(2131697632));
    this.H = ((LinearLayout)findViewById(2131697627));
    this.s = ((TextView)findViewById(2131692065));
    this.y = ((Button)findViewById(2131697631));
    this.u = ((ImageView)findViewById(2131689895));
    this.r = ((TextView)findViewById(2131689533));
    this.x = ((Button)findViewById(2131697626));
    this.w = ((ImageView)findViewById(2131697623));
    this.d = ((TextView)findViewById(2131697624));
    this.e = ((TextView)findViewById(2131697628));
    this.f = ((TextView)findViewById(2131697629));
    this.g = ((TextView)findViewById(2131697625));
    this.v = findViewById(2131697630);
    this.z = getIntent().getStringExtra("wuyewaitdone");
    this.G = getIntent().getStringExtra("new_contract_code");
    this.a = getIntent().getStringExtra("contract_part_code");
    this.b = getIntent().getStringExtra("pay_status");
    this.C = getIntent().getStringExtra("old_contract_code");
  }
  
  private void d(String paramString)
  {
    d.getRentAgentCode(this.Q, this, paramString);
  }
  
  private void e()
  {
    this.s.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.u.setOnClickListener(this);
  }
  
  public void onBackPressed()
  {
    if (this.u.getVisibility() == 0) {
      finish();
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131692065: 
    case 2131697631: 
      do
      {
        return;
        paramView = new Intent(this, MainActivity.class);
        paramView.putExtra("FRAGMENT_TYPE", 7);
        startActivity(paramView);
        return;
        if ("返回首页".equals(this.y.getText().toString()))
        {
          paramView = new Intent(getApplicationContext(), MainActivity.class);
          paramView.putExtra("FRAGMENT_TYPE", 0);
          startActivity(paramView);
          return;
        }
        if ("找自如搬家".equals(this.y.getText().toString()))
        {
          paramView = new Intent(getApplicationContext(), MoveTypeActivity.class);
          paramView.putExtra("FRAGMENT_TYPE", 4);
          startActivity(paramView);
          return;
        }
      } while (!"找自如保洁".equals(this.y.getText().toString()));
      paramView = new Intent(getApplicationContext(), MainActivity.class);
      paramView.putExtra("FRAGMENT_TYPE", 4);
      paramView.addFlags(268435456);
      startActivity(paramView);
      return;
    case 2131689895: 
      finish();
      return;
    }
    paramView = new Intent(this, CreditWebActivity.class);
    paramView.putExtra("title", "整租保洁，随心预约");
    paramView.putExtra("url", this.J);
    startActivity(paramView);
    this.P.dismiss();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = this;
    requestWindowFeature(1);
    setContentView(2130905162);
    b();
    e();
    Map localMap;
    if (TextUtils.isEmpty(this.z)) {
      if (!TextUtils.isEmpty(this.b))
      {
        if (com.ziroom.ziroomcustomer.base.b.d == "440300") {
          this.I.setVisibility(0);
        }
        this.r.setText("签约完成");
        this.x.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.v.setVisibility(8);
        paramBundle = q.s + e.n.W;
        localMap = g.buildcheckWhole(this.a);
        j.getReservationOrderText(this.c, new a(), localMap, false, paramBundle);
        this.w.setImageResource(2130839795);
        this.d.setText(2131297449);
        this.d.setTextColor(Color.rgb(224, 114, 32));
        this.u.setVisibility(8);
        paramBundle = com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode();
        if ((paramBundle == null) || ((!paramBundle.equals("110000")) && (!paramBundle.equals("310000")) && (!paramBundle.equals("440300")) && (!paramBundle.equals("330100")) && (!paramBundle.equals("320100")))) {
          break label538;
        }
        this.y.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.C != null)
      {
        this.x.setText("给管家评价");
        this.x.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            HandleWaitToDoneActivity.this.showProgress("");
            HandleWaitToDoneActivity.a(HandleWaitToDoneActivity.this, HandleWaitToDoneActivity.c(HandleWaitToDoneActivity.this));
          }
        });
        if (ae.notNull(this.G))
        {
          paramBundle = q.s + e.n.W;
          localMap = g.buildcheckWhole(this.G);
          j.getReservationOrderText(this.c, new a(), localMap, false, paramBundle);
        }
        this.r.setText("签约完成");
        this.d.setText(2131297449);
        this.d.setTextColor(Color.rgb(224, 114, 32));
        this.e.setText(2131297299);
        this.y.setText("找自如保洁");
        this.f.setVisibility(8);
        this.u.setVisibility(8);
        this.s.setVisibility(0);
        this.s.setText("完成");
        this.v.setVisibility(8);
      }
      return;
      this.I.setVisibility(8);
      this.x.setText(2131297319);
      this.e.setText(2131297299);
      this.f.setText(2131297320);
      this.x.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (((TextView)paramAnonymousView).getText().equals("找自如做保洁"))
          {
            paramAnonymousView = new Intent(HandleWaitToDoneActivity.this.getApplicationContext(), MainActivity.class);
            paramAnonymousView.putExtra("serviceClean", "serviceClean");
            paramAnonymousView.addFlags(268435456);
            HandleWaitToDoneActivity.this.startActivity(paramAnonymousView);
            return;
          }
          paramAnonymousView = new Intent(HandleWaitToDoneActivity.this, HouseBillInfoActivity.class);
          paramAnonymousView.putExtra("uniqueCode", HandleWaitToDoneActivity.this.a);
          paramAnonymousView.putExtra("period", "1");
          paramAnonymousView.putExtra("payType", "fz");
          HandleWaitToDoneActivity.this.startActivityAndFinish(paramAnonymousView);
        }
      });
      break;
      label538:
      this.y.setVisibility(8);
      this.t.setVisibility(0);
      this.t.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(HandleWaitToDoneActivity.a(HandleWaitToDoneActivity.this), SignedWebActivity.class);
          paramAnonymousView.putExtra("url", "https://s.growingio.com/GevyEL");
          paramAnonymousView.putExtra("title", "自如客入住指南");
          HandleWaitToDoneActivity.this.startActivity(paramAnonymousView);
        }
      });
      continue;
      this.w.setImageResource(2130839903);
      paramBundle = this.w.getLayoutParams();
      paramBundle.width = ah.dip2px(getApplicationContext(), 106.0F);
      paramBundle.height = ah.dip2px(getApplicationContext(), 106.0F);
      this.w.setLayoutParams(paramBundle);
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.g.setVisibility(8);
      this.v.setVisibility(8);
      this.t.setVisibility(0);
      this.x.setText(2131297362);
      this.t.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(HandleWaitToDoneActivity.a(HandleWaitToDoneActivity.this), SignedWebActivity.class);
          paramAnonymousView.putExtra("url", "https://s.growingio.com/GevyEL");
          paramAnonymousView.putExtra("title", "自如客入住指南");
          HandleWaitToDoneActivity.this.startActivity(paramAnonymousView);
        }
      });
      this.x.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (!TextUtils.isEmpty(HandleWaitToDoneActivity.this.a))
          {
            HandleWaitToDoneActivity.b(HandleWaitToDoneActivity.this);
            return;
          }
          HandleWaitToDoneActivity.this.showToast("获取不到合同编号");
        }
      });
    }
  }
  
  public void showDialog(String paramString)
  {
    this.K = View.inflate(this.c, 2130905178, null);
    this.L = ((TextView)this.K.findViewById(2131697639));
    this.M = ((TextView)this.K.findViewById(2131697638));
    this.O = ((TextView)this.K.findViewById(2131697637));
    this.N = ((TextView)this.K.findViewById(2131697634));
    this.L.setOnClickListener(this);
    String str = paramString.substring(0, paramString.indexOf("|"));
    paramString = paramString.substring(paramString.indexOf("|") + 1);
    this.N.setText(str);
    this.L.setText("详情请点击查看");
    this.M.setVisibility(8);
    this.O.setText(paramString);
    if (this.P == null)
    {
      this.P = new Dialog(this.c, 2131427781);
      this.P.setContentView(this.K);
      this.P.setCanceledOnTouchOutside(false);
      this.P.setCancelable(false);
      paramString = this.P;
      if ((paramString instanceof Dialog)) {
        break label241;
      }
      paramString.show();
    }
    for (;;)
    {
      ApplicationEx.g = 2;
      this.P.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          HandleWaitToDoneActivity.a(HandleWaitToDoneActivity.this, null);
          HandleWaitToDoneActivity.d(HandleWaitToDoneActivity.this).dismiss();
          HandleWaitToDoneActivity.a(HandleWaitToDoneActivity.this, null);
        }
      });
      return;
      label241:
      VdsAgent.showDialog((Dialog)paramString);
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        paramString = a.parseObject(paramString.get("data").toString());
        paramk.setSuccess(Boolean.valueOf(true));
        paramk.setObject(paramString);
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (e)paramk.getObject();
        if (paramk.getInteger("isWhole").intValue() == 1)
        {
          HandleWaitToDoneActivity.this.showDialog(paramk.getString("text"));
          HandleWaitToDoneActivity.b(HandleWaitToDoneActivity.this, paramk.getString("url"));
        }
      }
      HandleWaitToDoneActivity.this.dismissProgress();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/HandleWaitToDoneActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */