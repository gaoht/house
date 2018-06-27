package com.ziroom.ziroomcustomer.newchat.chatcenter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.b.c;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.h;
import com.ziroom.ziroomcustomer.e.c.v;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newchat.chatcenter.a.d;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.k;
import com.ziroom.ziroomcustomer.newchat.chatcenter.views.LineWrapLayout;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.af;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SerachQuestionActivity
  extends BaseActivity
{
  private ScrollView A;
  private ListView B;
  private List<String> C = new ArrayList();
  private a D;
  private Handler E = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (locall.getSuccess().booleanValue()) {
        SerachQuestionActivity.e(SerachQuestionActivity.this, "感谢您的反馈，我们会不断完善知识内容");
      }
      for (;;)
      {
        SerachQuestionActivity.this.dismissProgress();
        return;
        af.showToast(SerachQuestionActivity.g(SerachQuestionActivity.this), locall.getMessage());
      }
    }
  };
  private Context a;
  private TextView b;
  private ListViewForScrollView c;
  private EditText d;
  private List<i> e;
  private d f;
  private TextView g;
  private TextView r;
  private TextView s;
  private UserInfo t;
  private List<b> u;
  private String v;
  private RelativeLayout w;
  private TextView x;
  private TextView y;
  private LineWrapLayout z;
  
  private void a()
  {
    int i = 0;
    if (this.t != null) {}
    for (String str = this.t.getUid();; str = "ziruCustomer")
    {
      this.u = c.query(this.a, str);
      if ((this.u == null) || (this.u.size() <= 0)) {
        break label242;
      }
      this.C.clear();
      this.g.setVisibility(8);
      this.B.setVisibility(0);
      this.r.setVisibility(0);
      this.y.setVisibility(0);
      while (i < this.u.size())
      {
        if ((i >= 0) && (i < 5)) {
          this.C.add(((b)this.u.get(i)).getQuestion_name());
        }
        i += 1;
      }
    }
    this.D = new a(this.a, this.C);
    this.B.setAdapter(this.D);
    for (;;)
    {
      this.B.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramAnonymousView = (String)SerachQuestionActivity.a(SerachQuestionActivity.this).get(paramAnonymousInt);
          SerachQuestionActivity.b(SerachQuestionActivity.this).setVisibility(8);
          SerachQuestionActivity.c(SerachQuestionActivity.this).setVisibility(8);
          SerachQuestionActivity.d(SerachQuestionActivity.this).setVisibility(8);
          SerachQuestionActivity.e(SerachQuestionActivity.this).setVisibility(8);
          b localb = new b();
          localb.setQuestion_name(paramAnonymousView);
          if (SerachQuestionActivity.f(SerachQuestionActivity.this) != null) {}
          for (paramAnonymousAdapterView = SerachQuestionActivity.f(SerachQuestionActivity.this).getUid();; paramAnonymousAdapterView = "ziruCustomer")
          {
            localb.setUid(paramAnonymousAdapterView);
            c.save(SerachQuestionActivity.g(SerachQuestionActivity.this), localb);
            SerachQuestionActivity.a(SerachQuestionActivity.this, paramAnonymousView);
            SerachQuestionActivity.h(SerachQuestionActivity.this).setText(paramAnonymousView);
            return;
          }
        }
      });
      this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          if ((SerachQuestionActivity.i(SerachQuestionActivity.this) != null) && (SerachQuestionActivity.i(SerachQuestionActivity.this).size() > 0))
          {
            com.ziroom.ziroomcustomer.util.u.e("dsfgjkfd", paramAnonymousInt + "");
            paramAnonymousAdapterView = ((i)SerachQuestionActivity.i(SerachQuestionActivity.this).get(paramAnonymousInt)).getId();
            paramAnonymousView = new Intent(SerachQuestionActivity.g(SerachQuestionActivity.this), QuestionDetailActivity.class);
            paramAnonymousView.putExtra("item_id", paramAnonymousAdapterView);
            paramAnonymousView.putExtra("source", "APP_KNOWLEDGE_SEARCH");
            SerachQuestionActivity.this.startActivity(paramAnonymousView);
          }
        }
      });
      this.d.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (paramAnonymousCharSequence.length() > 0) {
            SerachQuestionActivity.b(SerachQuestionActivity.this, paramAnonymousCharSequence.toString());
          }
        }
      });
      this.d.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if (paramAnonymousInt == 3)
          {
            if (TextUtils.isEmpty(VdsAgent.trackEditTextSilent(SerachQuestionActivity.h(SerachQuestionActivity.this)).toString().trim())) {
              SerachQuestionActivity.this.showToast("请先输入内容");
            }
          }
          else {
            return false;
          }
          paramAnonymousTextView = VdsAgent.trackEditTextSilent(SerachQuestionActivity.h(SerachQuestionActivity.this)).toString().trim();
          SerachQuestionActivity.a(SerachQuestionActivity.this, paramAnonymousTextView);
          paramAnonymousKeyEvent = new b();
          paramAnonymousKeyEvent.setQuestion_name(paramAnonymousTextView);
          if (SerachQuestionActivity.f(SerachQuestionActivity.this) != null) {}
          for (paramAnonymousTextView = SerachQuestionActivity.f(SerachQuestionActivity.this).getUid();; paramAnonymousTextView = "ziruCustomer")
          {
            paramAnonymousKeyEvent.setUid(paramAnonymousTextView);
            c.save(SerachQuestionActivity.g(SerachQuestionActivity.this), paramAnonymousKeyEvent);
            SerachQuestionActivity.c(SerachQuestionActivity.this).setVisibility(8);
            SerachQuestionActivity.d(SerachQuestionActivity.this).setVisibility(8);
            SerachQuestionActivity.e(SerachQuestionActivity.this).setVisibility(8);
            return true;
          }
        }
      });
      return;
      label242:
      g();
    }
  }
  
  private void b()
  {
    n.getHotQuestionLabel(this, new h(this, new com.ziroom.ziroomcustomer.e.c.u(k.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        SerachQuestionActivity.j(SerachQuestionActivity.this).setVisibility(8);
        SerachQuestionActivity.k(SerachQuestionActivity.this).setVisibility(8);
      }
      
      public void onSuccess(int paramAnonymousInt, List<k> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        SerachQuestionActivity.j(SerachQuestionActivity.this).setVisibility(0);
        SerachQuestionActivity.k(SerachQuestionActivity.this).setVisibility(0);
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          k localk = (k)paramAnonymousList.next();
          SerachQuestionActivity.j(SerachQuestionActivity.this).addView(SerachQuestionActivity.c(SerachQuestionActivity.this, localk.getWord()));
        }
      }
    });
  }
  
  private void d(String paramString)
  {
    n.searchQuestionByText(this, paramString, 15, new h(this, new v(j.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        SerachQuestionActivity.n(SerachQuestionActivity.this).setVisibility(8);
      }
      
      public void onSuccess(int paramAnonymousInt, j paramAnonymousj)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousj);
        SerachQuestionActivity.a(SerachQuestionActivity.this, paramAnonymousj.getResults());
        SerachQuestionActivity.d(SerachQuestionActivity.this, paramAnonymousj.getUserQuestionId());
        if ((SerachQuestionActivity.i(SerachQuestionActivity.this) != null) && (SerachQuestionActivity.i(SerachQuestionActivity.this).size() > 0))
        {
          SerachQuestionActivity.b(SerachQuestionActivity.this).setVisibility(8);
          com.ziroom.ziroomcustomer.util.u.e("sdggg", com.alibaba.fastjson.a.toJSONString(SerachQuestionActivity.i(SerachQuestionActivity.this)));
          SerachQuestionActivity.a(SerachQuestionActivity.this, new d(SerachQuestionActivity.g(SerachQuestionActivity.this), SerachQuestionActivity.i(SerachQuestionActivity.this)));
          SerachQuestionActivity.m(SerachQuestionActivity.this).setAdapter(SerachQuestionActivity.l(SerachQuestionActivity.this));
          SerachQuestionActivity.l(SerachQuestionActivity.this).notifyDataSetChanged();
          SerachQuestionActivity.n(SerachQuestionActivity.this).setVisibility(0);
          SerachQuestionActivity.o(SerachQuestionActivity.this).setVisibility(0);
          return;
        }
        SerachQuestionActivity.o(SerachQuestionActivity.this).setVisibility(0);
        SerachQuestionActivity.b(SerachQuestionActivity.this).setVisibility(0);
        SerachQuestionActivity.a(SerachQuestionActivity.this, new d(SerachQuestionActivity.g(SerachQuestionActivity.this), SerachQuestionActivity.i(SerachQuestionActivity.this)));
        SerachQuestionActivity.m(SerachQuestionActivity.this).setAdapter(SerachQuestionActivity.l(SerachQuestionActivity.this));
        SerachQuestionActivity.l(SerachQuestionActivity.this).notifyDataSetChanged();
        SerachQuestionActivity.n(SerachQuestionActivity.this).setVisibility(8);
      }
    });
  }
  
  private void e()
  {
    this.y = ((TextView)findViewById(2131690173));
    this.b = ((TextView)findViewById(2131690169));
    this.d = ((EditText)findViewById(2131690168));
    this.c = ((ListViewForScrollView)findViewById(2131690176));
    this.g = ((TextView)findViewById(2131690175));
    this.r = ((TextView)findViewById(2131690172));
    this.s = ((TextView)findViewById(2131690170));
    this.w = ((RelativeLayout)findViewById(2131690177));
    this.x = ((TextView)findViewById(2131690179));
    this.z = ((LineWrapLayout)findViewById(2131690171));
    this.B = ((ListView)findViewById(2131689827));
    this.A = ((ScrollView)findViewById(2131690174));
    this.x.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SerachQuestionActivity.q(SerachQuestionActivity.this);
      }
    });
    this.t = ApplicationEx.c.getUser();
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SerachQuestionActivity.this.finish();
      }
    });
    this.y.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        c.delete(SerachQuestionActivity.this);
        SerachQuestionActivity.c(SerachQuestionActivity.this).setVisibility(8);
        SerachQuestionActivity.d(SerachQuestionActivity.this).setVisibility(8);
        SerachQuestionActivity.e(SerachQuestionActivity.this).setVisibility(8);
      }
    });
    String str = getIntent().getStringExtra("search");
    if (f.notNull(str))
    {
      this.d.setText(str);
      d(str);
    }
  }
  
  private void e(String paramString)
  {
    n.searchQuestionByText(this, paramString, 15, new com.freelxl.baselibrary.d.c.a(new v(j.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        if ((paramAnonymousThrowable instanceof com.freelxl.baselibrary.d.d.a))
        {
          g.textToast(SerachQuestionActivity.this, paramAnonymousThrowable.getMessage());
          return;
        }
        if ((paramAnonymousThrowable instanceof com.ziroom.commonlibrary.a.b))
        {
          g.textToast(SerachQuestionActivity.this, paramAnonymousThrowable.getMessage());
          return;
        }
        g.textToast(SerachQuestionActivity.this, "网络请求失败，请检查网络连接！");
      }
      
      public void onSuccess(int paramAnonymousInt, j paramAnonymousj)
      {
        SerachQuestionActivity.a(SerachQuestionActivity.this, paramAnonymousj.getResults());
        SerachQuestionActivity.d(SerachQuestionActivity.this, paramAnonymousj.getUserQuestionId());
        if ((SerachQuestionActivity.i(SerachQuestionActivity.this) != null) && (SerachQuestionActivity.i(SerachQuestionActivity.this).size() > 0))
        {
          SerachQuestionActivity.b(SerachQuestionActivity.this).setVisibility(8);
          com.ziroom.ziroomcustomer.util.u.e("sdggg", com.alibaba.fastjson.a.toJSONString(SerachQuestionActivity.i(SerachQuestionActivity.this)));
          SerachQuestionActivity.a(SerachQuestionActivity.this, new d(SerachQuestionActivity.g(SerachQuestionActivity.this), SerachQuestionActivity.i(SerachQuestionActivity.this)));
          SerachQuestionActivity.m(SerachQuestionActivity.this).setAdapter(SerachQuestionActivity.l(SerachQuestionActivity.this));
          SerachQuestionActivity.l(SerachQuestionActivity.this).notifyDataSetChanged();
          SerachQuestionActivity.n(SerachQuestionActivity.this).setVisibility(0);
          SerachQuestionActivity.o(SerachQuestionActivity.this).setVisibility(0);
        }
        for (;;)
        {
          SerachQuestionActivity.p(SerachQuestionActivity.this);
          return;
          SerachQuestionActivity.o(SerachQuestionActivity.this).setVisibility(0);
          SerachQuestionActivity.b(SerachQuestionActivity.this).setVisibility(0);
          SerachQuestionActivity.a(SerachQuestionActivity.this, new d(SerachQuestionActivity.g(SerachQuestionActivity.this), SerachQuestionActivity.i(SerachQuestionActivity.this)));
          SerachQuestionActivity.m(SerachQuestionActivity.this).setAdapter(SerachQuestionActivity.l(SerachQuestionActivity.this));
          SerachQuestionActivity.l(SerachQuestionActivity.this).notifyDataSetChanged();
          SerachQuestionActivity.n(SerachQuestionActivity.this).setVisibility(8);
        }
      }
    });
  }
  
  private TextView f(String paramString)
  {
    TextView localTextView = new TextView(this.a);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localTextView.setText(paramString);
    localTextView.setPadding(a(6.0F), a(6.0F), a(6.0F), a(6.0F));
    localTextView.setTextSize(2, 12.0F);
    localTextView.setTextColor(this.a.getResources().getColor(2131624417));
    localTextView.setGravity(17);
    localTextView.setBackgroundResource(2130837959);
    localTextView.setMaxWidth(getWindowManager().getDefaultDisplay().getWidth() - a(40.0F));
    localTextView.setMaxLines(1);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        String str = ((TextView)paramAnonymousView).getText().toString();
        b localb = new b();
        localb.setQuestion_name(str);
        if (SerachQuestionActivity.f(SerachQuestionActivity.this) != null) {}
        for (paramAnonymousView = SerachQuestionActivity.f(SerachQuestionActivity.this).getUid();; paramAnonymousView = "ziruCustomer")
        {
          localb.setUid(paramAnonymousView);
          c.save(SerachQuestionActivity.g(SerachQuestionActivity.this), localb);
          SerachQuestionActivity.h(SerachQuestionActivity.this).setText(str);
          SerachQuestionActivity.a(SerachQuestionActivity.this, str);
          return;
        }
      }
    });
    return localTextView;
  }
  
  private void f()
  {
    if (!TextUtils.isEmpty(this.v))
    {
      localObject = ApplicationEx.c.getUser();
      if (localObject != null) {
        break label42;
      }
    }
    label42:
    for (Object localObject = "";; localObject = ((UserInfo)localObject).getUid())
    {
      o.saveQuestion_2(this.a, this.E, this.v, (String)localObject);
      return;
    }
  }
  
  private void g()
  {
    this.d.requestFocus();
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        InputMethodManager localInputMethodManager = (InputMethodManager)SerachQuestionActivity.this.getSystemService("input_method");
        localInputMethodManager.showSoftInput(SerachQuestionActivity.h(SerachQuestionActivity.this), 2);
        localInputMethodManager.toggleSoftInput(2, 1);
      }
    }, 300L);
  }
  
  private void g(String paramString)
  {
    final Dialog localDialog = new Dialog(this, 2131427591);
    View localView = getLayoutInflater().inflate(2130904173, null);
    TextView localTextView = (TextView)localView.findViewById(2131691289);
    ((TextView)localView.findViewById(2131693113)).setText(paramString);
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localDialog.dismiss();
      }
    });
    localDialog.setContentView(localView);
    if (!(localDialog instanceof Dialog))
    {
      localDialog.show();
      return;
    }
    VdsAgent.showDialog((Dialog)localDialog);
  }
  
  protected int a(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903131);
    this.a = this;
    e();
    a();
    b();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
    finish();
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/SerachQuestionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */