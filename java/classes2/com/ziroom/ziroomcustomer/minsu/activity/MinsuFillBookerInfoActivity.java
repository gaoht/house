package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.dialog.b.a;
import com.ziroom.ziroomcustomer.minsu.dialog.i;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.c;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.List;

public class MinsuFillBookerInfoActivity
  extends BaseActivity
{
  i a;
  private CommonTitle b;
  private com.ziroom.ziroomcustomer.minsu.dialog.b<com.ziroom.ziroomcustomer.minsu.b.a> c;
  @BindView(2131691204)
  LinearLayout cer_type_area;
  @BindView(2131691206)
  TextView commit;
  @BindView(2131691281)
  TextView customer_cer_type;
  @BindView(2131691282)
  EditText customer_cer_value;
  @BindView(2131691299)
  EditText customer_code;
  @BindView(2131691280)
  EditText customer_name;
  @BindView(2131691298)
  EditText customer_phone;
  private com.ziroom.ziroomcustomer.minsu.b.a d;
  private List<String> e;
  private String f;
  private String g;
  @BindView(2131691200)
  TextView get_auth_code;
  @BindView(2131691297)
  LinearLayout phone_code_area;
  private int r = 0;
  private String s;
  @BindView(2131690150)
  ObservableScrollView sv_content;
  private final int t = 60;
  private final int u = 1000;
  private final int v = 1;
  private String w;
  private String x;
  private Handler y = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if (paramAnonymousMessage.arg1 > 0)
      {
        MinsuFillBookerInfoActivity.this.get_auth_code.setEnabled(false);
        MinsuFillBookerInfoActivity.this.get_auth_code.setText(paramAnonymousMessage.arg1 + MinsuFillBookerInfoActivity.d(MinsuFillBookerInfoActivity.this));
        Message localMessage = obtainMessage(1);
        int i = paramAnonymousMessage.arg1 - 1;
        paramAnonymousMessage.arg1 = i;
        localMessage.arg1 = i;
        sendMessageDelayed(localMessage, 1000L);
        return;
      }
      MinsuFillBookerInfoActivity.this.get_auth_code.setEnabled(true);
      MinsuFillBookerInfoActivity.this.get_auth_code.setText(MinsuFillBookerInfoActivity.e(MinsuFillBookerInfoActivity.this));
    }
  };
  
  private void a()
  {
    initTitle();
    b();
    if ((!c.isNull(this.g)) && (ah.isMobile(this.g))) {
      this.phone_code_area.setVisibility(8);
    }
    if ((!c.isNull(Integer.valueOf(this.r))) && (!c.isNull(this.s)))
    {
      this.customer_cer_type.setText(com.ziroom.ziroomcustomer.minsu.b.a.getTypeString(this, this.r));
      this.customer_cer_value.setText(this.s);
      this.d = com.ziroom.ziroomcustomer.minsu.b.a.getCerType(this.r);
    }
    e();
  }
  
  private void b()
  {
    if ((!TextUtils.isEmpty(this.f)) && (!c.isNumber(this.f)))
    {
      this.customer_name.setText(this.f);
      this.customer_name.setEnabled(false);
    }
  }
  
  private boolean d(String paramString)
  {
    switch (2.a[this.d.ordinal()])
    {
    }
    do
    {
      do
      {
        do
        {
          return false;
          paramString = new com.ziroom.ziroomcustomer.minsu.f.b().IDCardValidate(paramString);
        } while (TextUtils.isEmpty(paramString));
        g.textToast(this, paramString);
        return true;
      } while (com.ziroom.ziroomcustomer.minsu.f.b.checkId(paramString));
      g.textToast(this, getString(2131296618));
      return true;
    } while (c.isTaiwanCard(paramString));
    g.textToast(this, getString(2131296618));
    return true;
  }
  
  private void e()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.b.a.a);
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.b.a.b);
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.b.a.d);
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.b.a.e);
    this.c = new com.ziroom.ziroomcustomer.minsu.dialog.b(this, new com.freelxl.baselibrary.a.a(this, localArrayList, 2130904541)
    {
      public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, com.ziroom.ziroomcustomer.minsu.b.a paramAnonymousa)
      {
        paramAnonymousb.setText(2131695219, com.ziroom.ziroomcustomer.minsu.b.a.getTypeString(MinsuFillBookerInfoActivity.this, paramAnonymousa.getKey()));
      }
    }, null);
    this.c.setCallBack(new b.a()
    {
      public void onSelect(com.ziroom.ziroomcustomer.minsu.b.a paramAnonymousa)
      {
        MinsuFillBookerInfoActivity.a(MinsuFillBookerInfoActivity.this, paramAnonymousa);
        MinsuFillBookerInfoActivity.this.customer_cer_type.setText(MinsuFillBookerInfoActivity.this.getString(MinsuFillBookerInfoActivity.b(MinsuFillBookerInfoActivity.this).getValue()));
      }
    });
  }
  
  private void f()
  {
    v.onClick(this, "M-Continue_to_order");
    Object localObject = this.f;
    String str1;
    if ((c.isNull(this.f)) || (c.isNumber(this.f)))
    {
      str1 = VdsAgent.trackEditTextSilent(this.customer_name) + "";
      localObject = str1;
      if (f.isNull(str1)) {
        showToast(getString(2131297276));
      }
    }
    String str2;
    String str3;
    do
    {
      return;
      str1 = VdsAgent.trackEditTextSilent(this.customer_phone) + "";
      str2 = VdsAgent.trackEditTextSilent(this.customer_code) + "";
      if (c.isNull(this.d))
      {
        showToast(getString(2131296626));
        return;
      }
      str3 = VdsAgent.trackEditTextSilent(this.customer_cer_value) + "";
      if (f.isNull(str3))
      {
        showToast(getString(2131296619));
        return;
      }
    } while (d(str3));
    com.ziroom.ziroomcustomer.minsu.e.a.saveAuthMsg(this, (String)localObject, str1, str2, this.d.getKey() + "", VdsAgent.trackEditTextSilent(this.customer_cer_value) + "", new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        MinsuBaseJson localMinsuBaseJson = (MinsuBaseJson)paramAnonymousk.getObject();
        StringBuilder localStringBuilder = new StringBuilder().append("-----");
        if (localMinsuBaseJson == null) {}
        for (String str = "null";; str = localMinsuBaseJson.toString())
        {
          d.e("lanzhihong", str);
          if ((!paramAnonymousk.getSuccess().booleanValue()) || (!localMinsuBaseJson.checkSuccess(MinsuFillBookerInfoActivity.this))) {
            break;
          }
          MinsuFillBookerInfoActivity.this.showToast(MinsuFillBookerInfoActivity.this.getString(2131297497));
          MinsuFillBookerInfoActivity.this.setResult(-1);
          MinsuFillBookerInfoActivity.this.finish();
          return;
        }
        if (localMinsuBaseJson == null) {}
        for (paramAnonymousk = "";; paramAnonymousk = localMinsuBaseJson.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void g()
  {
    String str = VdsAgent.trackEditTextSilent(this.customer_phone).toString();
    if (!ah.isMobile(str))
    {
      showToast("手机号码不正确！");
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.getMobileCodeAuthMsg(this, str, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        MinsuBaseJson localMinsuBaseJson = (MinsuBaseJson)paramAnonymousk.getObject();
        StringBuilder localStringBuilder = new StringBuilder().append("-----");
        if (localMinsuBaseJson == null) {}
        for (String str = "null";; str = localMinsuBaseJson.toString())
        {
          d.e("lanzhihong", str);
          if ((!paramAnonymousk.getSuccess().booleanValue()) || (!localMinsuBaseJson.checkSuccess(MinsuFillBookerInfoActivity.this))) {
            break;
          }
          MinsuFillBookerInfoActivity.this.showToast("已经发送验证码，请注意查收");
          MinsuFillBookerInfoActivity.c(MinsuFillBookerInfoActivity.this);
          return;
        }
        if (localMinsuBaseJson == null) {}
        for (paramAnonymousk = "";; paramAnonymousk = localMinsuBaseJson.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void h()
  {
    this.w = getString(2131296985);
    this.x = getString(2131296984);
    this.y.removeMessages(1);
    Message localMessage = this.y.obtainMessage(1);
    localMessage.arg1 = 60;
    localMessage.sendToTarget();
  }
  
  private void i()
  {
    if (ad.isKeyboardShown(findViewById(16908290)))
    {
      ad.hideSoftInput(this);
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          i locali = MinsuFillBookerInfoActivity.this.a;
          View localView = MinsuFillBookerInfoActivity.this.getWindow().getDecorView();
          if (!(locali instanceof PopupWindow))
          {
            locali.showAtLocation(localView, 80, 0, 0);
            return;
          }
          VdsAgent.showAtLocation((PopupWindow)locali, localView, 80, 0, 0);
        }
      }, 250L);
      return;
    }
    i locali = this.a;
    View localView = getWindow().getDecorView();
    if (!(locali instanceof PopupWindow))
    {
      locali.showAtLocation(localView, 80, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)locali, localView, 80, 0, 0);
  }
  
  private void j()
  {
    this.e = new ArrayList();
    this.e.add(getString(com.ziroom.ziroomcustomer.minsu.b.a.a.getValue()));
    this.e.add(getString(com.ziroom.ziroomcustomer.minsu.b.a.b.getValue()));
    this.e.add(getString(com.ziroom.ziroomcustomer.minsu.b.a.d.getValue()));
    this.e.add(getString(com.ziroom.ziroomcustomer.minsu.b.a.e.getValue()));
    this.a = new i(this, new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        MinsuFillBookerInfoActivity.this.a.dismiss();
        MinsuFillBookerInfoActivity.a(MinsuFillBookerInfoActivity.this, com.ziroom.ziroomcustomer.minsu.b.a.getCerType((String)MinsuFillBookerInfoActivity.f(MinsuFillBookerInfoActivity.this).get(paramAnonymousInt)));
        MinsuFillBookerInfoActivity.this.customer_cer_type.setText(MinsuFillBookerInfoActivity.this.getString(MinsuFillBookerInfoActivity.b(MinsuFillBookerInfoActivity.this).getValue()));
      }
    }, this.e);
  }
  
  public void initTitle()
  {
    this.b = ((CommonTitle)findViewById(2131691272));
    this.b.showRightText(false, null);
    this.b.setMiddleText("");
    this.b.setLeftButtonType(4);
    this.b.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuFillBookerInfoActivity.this.finish();
      }
    });
    this.b.setBottomLineAlpha(0.0F);
  }
  
  @OnClick({2131691200, 2131691204, 2131691206})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691200: 
      g();
      return;
    case 2131691204: 
      i();
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903275);
    ButterKnife.bind(this);
    this.f = getIntent().getStringExtra("username");
    this.g = getIntent().getStringExtra("mobile");
    this.r = getIntent().getIntExtra("idType", 0);
    this.s = getIntent().getStringExtra("idNumber");
    a();
    j();
    this.sv_content.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        MinsuFillBookerInfoActivity.a(MinsuFillBookerInfoActivity.this).setBottomLineAlpha(f);
      }
    });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.y.removeMessages(1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuFillBookerInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */