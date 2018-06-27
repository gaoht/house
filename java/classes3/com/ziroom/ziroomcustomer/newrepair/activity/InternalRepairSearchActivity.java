package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newrepair.a.i;
import com.ziroom.ziroomcustomer.newrepair.a.i.a;
import com.ziroom.ziroomcustomer.newrepair.b.g;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class InternalRepairSearchActivity
  extends BaseActivity
{
  private Context a;
  private EditText b;
  private TextView c;
  private TextView d;
  private ListView e;
  private List<String> f = new ArrayList();
  private List<Object> g = new ArrayList();
  private String r = "";
  private i s;
  private boolean t = false;
  
  private void a()
  {
    this.b = ((EditText)findViewById(2131691022));
    this.c = ((TextView)findViewById(2131690169));
    this.d = ((TextView)findViewById(2131690175));
    this.e = ((ListView)findViewById(2131691023));
  }
  
  private void b()
  {
    this.t = getIntent().getBooleanExtra("isMyFragment", false);
    showSoftInput(this.a, this.b);
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        InternalRepairSearchActivity.this.finish();
      }
    });
    this.b.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 0)
        {
          InternalRepairSearchActivity.a(InternalRepairSearchActivity.this).setVisibility(0);
          InternalRepairSearchActivity.a(InternalRepairSearchActivity.this, paramAnonymousCharSequence.toString());
          InternalRepairSearchActivity.b(InternalRepairSearchActivity.this, InternalRepairSearchActivity.b(InternalRepairSearchActivity.this));
          InternalRepairSearchActivity.c(InternalRepairSearchActivity.this).setTextColor(-6710887);
          return;
        }
        InternalRepairSearchActivity.c(InternalRepairSearchActivity.this).setTextColor(-6710887);
        InternalRepairSearchActivity.a(InternalRepairSearchActivity.this, "");
        InternalRepairSearchActivity.a(InternalRepairSearchActivity.this).setVisibility(8);
        InternalRepairSearchActivity.d(InternalRepairSearchActivity.this).setVisibility(8);
      }
    });
  }
  
  private void d(String paramString)
  {
    n.getInternalRepairFaultTag(this.a, paramString, "", new com.freelxl.baselibrary.d.c.a(new m(g.class, new e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        j.showFailureMessage(InternalRepairSearchActivity.e(InternalRepairSearchActivity.this), paramAnonymousThrowable);
        InternalRepairSearchActivity.d(InternalRepairSearchActivity.this).setVisibility(0);
        InternalRepairSearchActivity.a(InternalRepairSearchActivity.this).setVisibility(8);
      }
      
      public void onSuccess(int paramAnonymousInt, g paramAnonymousg)
      {
        u.d("sdjgkd", "========    getInternalRepairFaultTag=" + com.alibaba.fastjson.a.toJSONString(paramAnonymousg));
        if (paramAnonymousg != null)
        {
          if ((paramAnonymousg.getRepairGoodsList() != null) && (paramAnonymousg.getRepairGoodsList().size() > 0))
          {
            InternalRepairSearchActivity.d(InternalRepairSearchActivity.this).setVisibility(8);
            InternalRepairSearchActivity.a(InternalRepairSearchActivity.this).setVisibility(0);
            InternalRepairSearchActivity.a(InternalRepairSearchActivity.this, new i(InternalRepairSearchActivity.e(InternalRepairSearchActivity.this), paramAnonymousg, InternalRepairSearchActivity.b(InternalRepairSearchActivity.this), InternalRepairSearchActivity.f(InternalRepairSearchActivity.this)));
            InternalRepairSearchActivity.a(InternalRepairSearchActivity.this).setAdapter(InternalRepairSearchActivity.g(InternalRepairSearchActivity.this));
            InternalRepairSearchActivity.g(InternalRepairSearchActivity.this).setOnFinishListener(new i.a()
            {
              public void isFinish()
              {
                InternalRepairSearchActivity.this.finish();
              }
            });
            return;
          }
          InternalRepairSearchActivity.d(InternalRepairSearchActivity.this).setVisibility(0);
          InternalRepairSearchActivity.a(InternalRepairSearchActivity.this).setVisibility(8);
          return;
        }
        InternalRepairSearchActivity.d(InternalRepairSearchActivity.this).setVisibility(0);
        InternalRepairSearchActivity.a(InternalRepairSearchActivity.this).setVisibility(8);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903230);
    this.a = this;
    a();
    b();
  }
  
  public void showSoftInput(final Context paramContext, final EditText paramEditText)
  {
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        paramEditText.requestFocus();
        ((InputMethodManager)paramContext.getSystemService("input_method")).toggleSoftInput(0, 2);
      }
    }, 300L);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/InternalRepairSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */