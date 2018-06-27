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
import android.widget.PopupWindow;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.c.e;
import com.ziroom.ziroomcustomer.minsu.dialog.b.a;
import com.ziroom.ziroomcustomer.minsu.dialog.i;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.c;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class MinsuAddCerInfoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private final int A = 1;
  private String B;
  private String C;
  private Handler D = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if (paramAnonymousMessage.arg1 > 0)
      {
        MinsuAddCerInfoActivity.d(MinsuAddCerInfoActivity.this).setOnClickListener(null);
        MinsuAddCerInfoActivity.d(MinsuAddCerInfoActivity.this).setText(paramAnonymousMessage.arg1 + MinsuAddCerInfoActivity.e(MinsuAddCerInfoActivity.this));
        Message localMessage = obtainMessage(1);
        int i = paramAnonymousMessage.arg1 - 1;
        paramAnonymousMessage.arg1 = i;
        localMessage.arg1 = i;
        sendMessageDelayed(localMessage, 1000L);
        return;
      }
      MinsuAddCerInfoActivity.d(MinsuAddCerInfoActivity.this).setOnClickListener(MinsuAddCerInfoActivity.this);
      MinsuAddCerInfoActivity.d(MinsuAddCerInfoActivity.this).setText(MinsuAddCerInfoActivity.f(MinsuAddCerInfoActivity.this));
    }
  };
  String a;
  String b;
  int c = 0;
  String d;
  i e;
  private CommonTitle f;
  private com.ziroom.ziroomcustomer.minsu.c.d g;
  private com.ziroom.ziroomcustomer.minsu.c.d r;
  private e s;
  private com.ziroom.ziroomcustomer.minsu.c.d t;
  private TextView u;
  private com.ziroom.ziroomcustomer.minsu.dialog.b<com.ziroom.ziroomcustomer.minsu.b.a> v;
  private com.ziroom.ziroomcustomer.minsu.b.a w;
  private List<String> x;
  private final int y = 60;
  private final int z = 1000;
  
  private void a()
  {
    initTitle();
    b(g());
    f();
    e();
    b();
    h();
  }
  
  private void b()
  {
    findViewById(2131691206).setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    this.r = new com.ziroom.ziroomcustomer.minsu.c.d().init(findViewById(2131691202));
    if (ah.isMobile(this.b))
    {
      findViewById(2131691197).setVisibility(8);
      findViewById(2131691201).setVisibility(8);
      findViewById(2131691202).setVisibility(8);
      findViewById(2131691203).setVisibility(8);
      return;
    }
    findViewById(2131691197).setVisibility(0);
    findViewById(2131691201).setVisibility(0);
    findViewById(2131691202).setVisibility(0);
    findViewById(2131691203).setVisibility(0);
    this.u = ((TextView)findViewById(2131691200));
    this.u.setOnClickListener(this);
    findViewById(2131691198).getLayoutParams().width = paramInt;
    this.r.setKeyText(getString(2131296594)).setKeyLength(paramInt).setValueGravity(3).setValueHint(getString(2131296777));
  }
  
  private boolean d(String paramString)
  {
    switch (9.a[this.w.ordinal()])
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
    View localView = findViewById(2131691204);
    localView.setOnClickListener(this);
    this.s = new e().init(localView).setKeyText(getString(2131296628)).setValueGravity(3).setValueHint(getString(2131296626));
  }
  
  private void f()
  {
    this.t = new com.ziroom.ziroomcustomer.minsu.c.d().init(findViewById(2131691205)).setKeyText(getString(2131296622)).setValueGravity(3).setValueHint(getString(2131296619));
  }
  
  private int g()
  {
    this.g = new com.ziroom.ziroomcustomer.minsu.c.d().init(findViewById(2131691196));
    int i = (int)(ab.length((TextView)findViewById(2131694588), getString(2131297360)) + 0.5D);
    this.g.setKeyText(getString(2131297277)).setKeyLength(i).setValueGravity(3).setValueHint(getString(2131296575));
    if ((!TextUtils.isEmpty(this.a)) && (!c.isNumber(this.a))) {
      this.g.setValueText(this.a).setValueEnable(false);
    }
    return i;
  }
  
  private void h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.b.a.a);
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.b.a.b);
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.b.a.d);
    localArrayList.add(com.ziroom.ziroomcustomer.minsu.b.a.e);
    this.v = new com.ziroom.ziroomcustomer.minsu.dialog.b(this, new com.freelxl.baselibrary.a.a(this, localArrayList, 2130904541)
    {
      public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, com.ziroom.ziroomcustomer.minsu.b.a paramAnonymousa)
      {
        paramAnonymousb.setText(2131695219, com.ziroom.ziroomcustomer.minsu.b.a.getTypeString(MinsuAddCerInfoActivity.this, paramAnonymousa.getKey()));
      }
    }, null);
    this.v.setCallBack(new b.a()
    {
      public void onSelect(com.ziroom.ziroomcustomer.minsu.b.a paramAnonymousa)
      {
        MinsuAddCerInfoActivity.a(MinsuAddCerInfoActivity.this, paramAnonymousa);
        MinsuAddCerInfoActivity.b(MinsuAddCerInfoActivity.this).setValueText(MinsuAddCerInfoActivity.this.getString(MinsuAddCerInfoActivity.a(MinsuAddCerInfoActivity.this).getValue()));
      }
    });
  }
  
  private void i()
  {
    v.onClick(this, "M-Continue_to_order");
    Object localObject = this.a;
    String str1;
    if ((c.isNull(this.a)) || (c.isNumber(this.a)))
    {
      str1 = this.g.getValue();
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
      str1 = VdsAgent.trackEditTextSilent((EditText)findViewById(2131691199)).toString();
      str2 = this.r.getValue();
      if (c.isNull(this.w))
      {
        showToast(getString(2131296626));
        return;
      }
      str3 = this.t.getValue();
      if (f.isNull(str3))
      {
        showToast(getString(2131296619));
        return;
      }
    } while (d(str3));
    com.ziroom.ziroomcustomer.minsu.e.a.saveAuthMsg(this, (String)localObject, str1, str2, this.w.getKey() + "", this.t.getValue(), new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        MinsuBaseJson localMinsuBaseJson = (MinsuBaseJson)paramAnonymousk.getObject();
        StringBuilder localStringBuilder = new StringBuilder().append("-----");
        if (localMinsuBaseJson == null) {}
        for (String str = "null";; str = localMinsuBaseJson.toString())
        {
          com.freelxl.baselibrary.f.d.e("lanzhihong", str);
          if ((!paramAnonymousk.getSuccess().booleanValue()) || (!localMinsuBaseJson.checkSuccess(MinsuAddCerInfoActivity.this))) {
            break;
          }
          MinsuAddCerInfoActivity.this.showToast(MinsuAddCerInfoActivity.this.getString(2131297497));
          MinsuAddCerInfoActivity.this.setResult(-1);
          MinsuAddCerInfoActivity.this.finish();
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
  
  private void j()
  {
    String str = VdsAgent.trackEditTextSilent((EditText)findViewById(2131691199)).toString();
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
          com.freelxl.baselibrary.f.d.e("lanzhihong", str);
          if ((!paramAnonymousk.getSuccess().booleanValue()) || (!localMinsuBaseJson.checkSuccess(MinsuAddCerInfoActivity.this))) {
            break;
          }
          MinsuAddCerInfoActivity.this.showToast("已经发送验证码，请注意查收");
          MinsuAddCerInfoActivity.c(MinsuAddCerInfoActivity.this);
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
  
  private void k()
  {
    this.B = getString(2131296985);
    this.C = getString(2131296984);
    this.D.removeMessages(1);
    Message localMessage = this.D.obtainMessage(1);
    localMessage.arg1 = 60;
    localMessage.sendToTarget();
  }
  
  private void l()
  {
    if (ad.isKeyboardShown(findViewById(16908290)))
    {
      ad.hideSoftInput(this);
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          i locali = MinsuAddCerInfoActivity.this.e;
          View localView = MinsuAddCerInfoActivity.this.getWindow().getDecorView();
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
    i locali = this.e;
    View localView = getWindow().getDecorView();
    if (!(locali instanceof PopupWindow))
    {
      locali.showAtLocation(localView, 80, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)locali, localView, 80, 0, 0);
  }
  
  private void m()
  {
    this.x = new ArrayList();
    this.x.add(getString(com.ziroom.ziroomcustomer.minsu.b.a.a.getValue()));
    this.x.add(getString(com.ziroom.ziroomcustomer.minsu.b.a.b.getValue()));
    this.x.add(getString(com.ziroom.ziroomcustomer.minsu.b.a.d.getValue()));
    this.x.add(getString(com.ziroom.ziroomcustomer.minsu.b.a.e.getValue()));
    this.e = new i(this, new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        MinsuAddCerInfoActivity.this.e.dismiss();
        MinsuAddCerInfoActivity.a(MinsuAddCerInfoActivity.this, com.ziroom.ziroomcustomer.minsu.b.a.getCerType((String)MinsuAddCerInfoActivity.g(MinsuAddCerInfoActivity.this).get(paramAnonymousInt)));
        MinsuAddCerInfoActivity.b(MinsuAddCerInfoActivity.this).setValueText(MinsuAddCerInfoActivity.this.getString(MinsuAddCerInfoActivity.a(MinsuAddCerInfoActivity.this).getValue()));
      }
    }, this.x);
  }
  
  public void initTitle()
  {
    this.f = ((CommonTitle)findViewById(2131691272));
    this.f.showRightText(false, null);
    this.f.setMiddleText(getString(2131296629));
    this.f.setLeftButtonType(0);
    this.f.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuAddCerInfoActivity.this.finish();
      }
    });
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691204: 
      l();
      return;
    case 2131691206: 
      i();
      return;
    }
    j();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903258);
    this.a = getIntent().getStringExtra("username");
    this.b = getIntent().getStringExtra("mobile");
    this.c = getIntent().getIntExtra("idType", 0);
    this.d = getIntent().getStringExtra("idNumber");
    a();
    m();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.D.removeMessages(1);
  }
  
  public String stringFilter(String paramString)
    throws PatternSyntaxException
  {
    return Pattern.compile("[^a-zA-Z0-9一-龥]").matcher(paramString).replaceAll("").trim();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuAddCerInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */