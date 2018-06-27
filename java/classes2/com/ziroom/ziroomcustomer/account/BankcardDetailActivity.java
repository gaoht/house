package com.ziroom.ziroomcustomer.account;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.b.b;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.account.model.BankList;
import com.ziroom.ziroomcustomer.account.model.BankList.DataBean;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.newchat.chatcenter.QuestionDetailActivity;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BankcardDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String A;
  private String B;
  private ArrayList<String> C;
  private com.ziroom.ziroomcustomer.ziroomstation.dialog.a D;
  private Map<String, String> E = new HashMap();
  private boolean F = false;
  private String G = "";
  private boolean H = false;
  private String I = "";
  private TextView J;
  private ViewTreeObserver.OnGlobalLayoutListener K = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      if (BankcardDetailActivity.k(BankcardDetailActivity.this).getRootView().getHeight() - BankcardDetailActivity.k(BankcardDetailActivity.this).getHeight() <= BankcardDetailActivity.this.getWindow().findViewById(16908290).getTop())
      {
        BankcardDetailActivity.l(BankcardDetailActivity.this).setVisibility(0);
        return;
      }
      BankcardDetailActivity.l(BankcardDetailActivity.this).setVisibility(8);
    }
  };
  private boolean L = false;
  private ViewGroup M;
  private View.OnClickListener N = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      BankcardDetailActivity.m(BankcardDetailActivity.this);
    }
  };
  private TextView a;
  private TextView b;
  private RelativeLayout c;
  private RelativeLayout d;
  private Intent e;
  private ImageView f;
  private EditText g;
  private EditText r;
  private EditText s;
  private EditText t;
  private EditText u;
  private boolean v = false;
  private String w;
  private String x;
  private String y;
  private String z;
  
  private void b()
  {
    Map localMap = com.ziroom.ziroomcustomer.e.g.buildBalance();
    j.getBankList(this, new c(), localMap, true);
  }
  
  private void e()
  {
    this.x = getIntent().getStringExtra("name");
    this.c = ((RelativeLayout)findViewById(2131693169));
    this.d = ((RelativeLayout)findViewById(2131693171));
    this.f = ((ImageView)findViewById(2131693166));
    this.a = ((TextView)findViewById(2131693177));
    this.b = ((TextView)findViewById(2131693167));
    this.r = ((EditText)findViewById(2131693172));
    this.s = ((EditText)findViewById(2131693170));
    this.g = ((EditText)findViewById(2131693174));
    this.t = ((EditText)findViewById(2131693168));
    this.u = ((EditText)findViewById(2131693176));
    this.J = ((TextView)findViewById(2131689835));
    this.t.setText(this.x);
    this.t.setEnabled(false);
    this.u.setFilters(new InputFilter[] { new InputFilter.LengthFilter(13) });
    this.g.setFilters(new InputFilter[] { new InputFilter.LengthFilter(30) });
    f();
    a();
  }
  
  private void f()
  {
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.b.setOnClickListener(this);
    g();
    this.g.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt1 = 0;
        if (BankcardDetailActivity.a(BankcardDetailActivity.this))
        {
          BankcardDetailActivity.a(BankcardDetailActivity.this, false);
          return;
        }
        BankcardDetailActivity.a(BankcardDetailActivity.this, true);
        BankcardDetailActivity.a(BankcardDetailActivity.this, "");
        paramAnonymousCharSequence = paramAnonymousCharSequence.toString().replace(" ", "");
        while (paramAnonymousInt1 + 4 < paramAnonymousCharSequence.length())
        {
          BankcardDetailActivity.a(BankcardDetailActivity.this, BankcardDetailActivity.b(BankcardDetailActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousInt1 + 4) + " ");
          paramAnonymousInt1 += 4;
        }
        BankcardDetailActivity.a(BankcardDetailActivity.this, BankcardDetailActivity.b(BankcardDetailActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousCharSequence.length()));
        paramAnonymousInt1 = VdsAgent.trackEditTextSilent(BankcardDetailActivity.c(BankcardDetailActivity.this)).length();
        BankcardDetailActivity.c(BankcardDetailActivity.this).setText(BankcardDetailActivity.b(BankcardDetailActivity.this));
        if ((paramAnonymousInt1 % 5 == 0) && (paramAnonymousInt2 == 0)) {}
        for (;;)
        {
          try
          {
            if (paramAnonymousInt1 + 1 <= BankcardDetailActivity.b(BankcardDetailActivity.this).length())
            {
              BankcardDetailActivity.c(BankcardDetailActivity.this).setSelection(paramAnonymousInt1 + 1);
              return;
            }
            BankcardDetailActivity.c(BankcardDetailActivity.this).setSelection(BankcardDetailActivity.b(BankcardDetailActivity.this).length());
            continue;
          }
          catch (Exception paramAnonymousCharSequence)
          {
            return;
            if ((paramAnonymousInt2 == 1) && (paramAnonymousInt1 < BankcardDetailActivity.b(BankcardDetailActivity.this).length()))
            {
              BankcardDetailActivity.c(BankcardDetailActivity.this).setSelection(paramAnonymousInt1);
              continue;
            }
          }
          finally
          {
            BankcardDetailActivity.d(BankcardDetailActivity.this);
          }
          if ((paramAnonymousInt2 == 0) && (paramAnonymousInt1 < BankcardDetailActivity.b(BankcardDetailActivity.this).length())) {
            BankcardDetailActivity.c(BankcardDetailActivity.this).setSelection(paramAnonymousInt1);
          } else {
            BankcardDetailActivity.c(BankcardDetailActivity.this).setSelection(BankcardDetailActivity.b(BankcardDetailActivity.this).length());
          }
        }
      }
    });
    this.t.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        BankcardDetailActivity.d(BankcardDetailActivity.this);
      }
    });
    this.u.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt1 = 3;
        if (BankcardDetailActivity.e(BankcardDetailActivity.this))
        {
          BankcardDetailActivity.b(BankcardDetailActivity.this, false);
          return;
        }
        BankcardDetailActivity.b(BankcardDetailActivity.this, true);
        BankcardDetailActivity.b(BankcardDetailActivity.this, "");
        paramAnonymousCharSequence = paramAnonymousCharSequence.toString().replace(" ", "");
        if (paramAnonymousCharSequence.length() > 3) {
          BankcardDetailActivity.b(BankcardDetailActivity.this, BankcardDetailActivity.f(BankcardDetailActivity.this) + paramAnonymousCharSequence.substring(0, 3) + " ");
        }
        for (;;)
        {
          if (paramAnonymousInt1 + 4 < paramAnonymousCharSequence.length())
          {
            BankcardDetailActivity.b(BankcardDetailActivity.this, BankcardDetailActivity.f(BankcardDetailActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousInt1 + 4) + " ");
            paramAnonymousInt1 += 4;
          }
          else
          {
            BankcardDetailActivity.b(BankcardDetailActivity.this, BankcardDetailActivity.f(BankcardDetailActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousCharSequence.length()));
            paramAnonymousInt1 = VdsAgent.trackEditTextSilent(BankcardDetailActivity.g(BankcardDetailActivity.this)).length();
            BankcardDetailActivity.g(BankcardDetailActivity.this).setText(BankcardDetailActivity.f(BankcardDetailActivity.this));
            if ((paramAnonymousInt1 % 5 == 0) && (paramAnonymousInt2 == 0)) {}
            for (;;)
            {
              try
              {
                if (paramAnonymousInt1 + 1 <= BankcardDetailActivity.f(BankcardDetailActivity.this).length())
                {
                  BankcardDetailActivity.g(BankcardDetailActivity.this).setSelection(paramAnonymousInt1 + 1);
                  return;
                }
                BankcardDetailActivity.g(BankcardDetailActivity.this).setSelection(BankcardDetailActivity.f(BankcardDetailActivity.this).length());
                continue;
              }
              catch (Exception paramAnonymousCharSequence)
              {
                return;
                if ((paramAnonymousInt2 == 1) && (paramAnonymousInt1 < BankcardDetailActivity.f(BankcardDetailActivity.this).length()))
                {
                  BankcardDetailActivity.g(BankcardDetailActivity.this).setSelection(paramAnonymousInt1);
                  continue;
                }
              }
              finally
              {
                BankcardDetailActivity.d(BankcardDetailActivity.this);
              }
              if ((paramAnonymousInt2 == 0) && (paramAnonymousInt1 < BankcardDetailActivity.f(BankcardDetailActivity.this).length()))
              {
                if ((paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 9)) {
                  BankcardDetailActivity.g(BankcardDetailActivity.this).setSelection(paramAnonymousInt1 + 1);
                } else {
                  BankcardDetailActivity.g(BankcardDetailActivity.this).setSelection(paramAnonymousInt1);
                }
              }
              else {
                BankcardDetailActivity.g(BankcardDetailActivity.this).setSelection(BankcardDetailActivity.f(BankcardDetailActivity.this).length());
              }
            }
            paramAnonymousInt1 = 0;
          }
        }
      }
    });
  }
  
  private void g()
  {
    this.J.setHighlightColor(getResources().getColor(17170445));
    int i = this.J.length();
    SpannableString localSpannableString = new SpannableString(this.J.getText().toString() + "银行卡验证未通过？");
    localSpannableString.setSpan(new a(this.N), i, "银行卡验证未通过？".length() + i, 33);
    this.J.setText(localSpannableString);
    this.J.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private void h()
  {
    this.w = VdsAgent.trackEditTextSilent(this.g).toString();
    this.x = VdsAgent.trackEditTextSilent(this.t).toString();
    this.z = VdsAgent.trackEditTextSilent(this.r).toString();
    this.y = VdsAgent.trackEditTextSilent(this.s).toString();
    this.B = VdsAgent.trackEditTextSilent(this.u).toString();
    this.B = this.B.replace(" ", "");
    this.w = this.w.replace(" ", "");
    if ((!TextUtils.isEmpty(this.w)) && (!TextUtils.isEmpty(this.x)) && (!TextUtils.isEmpty(this.z)) && (!TextUtils.isEmpty(this.y)) && (this.B.length() == 11))
    {
      this.a.setEnabled(true);
      this.a.setBackground(getResources().getDrawable(2130838035));
      this.v = true;
      return;
    }
    this.v = false;
    this.a.setEnabled(false);
    this.a.setBackground(getResources().getDrawable(2130839643));
  }
  
  private void i()
  {
    j.bankBindFailToast(this, new com.ziroom.ziroomcustomer.e.a.f(this, new com.ziroom.ziroomcustomer.e.c.f(e.class))
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse == null) {
          return;
        }
        Intent localIntent = new Intent(BankcardDetailActivity.this, QuestionDetailActivity.class);
        localIntent.putExtra("item_id", paramAnonymouse.getString("validType"));
        BankcardDetailActivity.this.startActivity(localIntent);
      }
    });
  }
  
  protected void a()
  {
    if (this.L) {
      return;
    }
    this.M = ((ViewGroup)findViewById(2131690936));
    this.M.getViewTreeObserver().addOnGlobalLayoutListener(this.K);
    this.L = true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2184) && (paramInt2 == -1) && (paramIntent != null) && (!"".equals(paramIntent.getStringExtra("cityname"))))
    {
      this.r.setText(paramIntent.getStringExtra("cityname"));
      h();
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131693168: 
    case 2131693173: 
    case 2131693174: 
    case 2131693175: 
    case 2131693176: 
    default: 
    case 2131693166: 
    case 2131693177: 
    case 2131693169: 
    case 2131693170: 
      do
      {
        do
        {
          do
          {
            return;
            finish();
            overridePendingTransition(2130968678, 0);
            return;
          } while (!this.v);
          if (!this.w.matches("\\d{12,23}?"))
          {
            com.freelxl.baselibrary.f.g.textToast(ApplicationEx.c, "银行卡应该为12-23位纯数字");
            return;
          }
          paramView = com.ziroom.ziroomcustomer.e.g.buildAddCards(this.z, this.A, this.w, this.y, this.B);
          j.getBindCards(this, new b(), paramView, true);
          return;
        } while (this.D == null);
        this.D.show();
        return;
      } while (this.D == null);
      this.D.show();
      return;
    case 2131693171: 
      this.e = new Intent(this, CityListActivity.class);
      startActivityForResult(this.e, 2184);
      return;
    case 2131693172: 
      this.e = new Intent(this, CityListActivity.class);
      startActivityForResult(this.e, 2184);
      return;
    }
    paramView = new ContactusDialog();
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (!(paramView instanceof DialogFragment))
    {
      paramView.show(localFragmentManager, null);
      return;
    }
    VdsAgent.showDialogFragment((DialogFragment)paramView, localFragmentManager, null);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903656);
    e();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.L) {
      this.M.getViewTreeObserver().removeGlobalOnLayoutListener(this.K);
    }
  }
  
  class a
    extends ClickableSpan
  {
    private final View.OnClickListener b;
    
    public a(View.OnClickListener paramOnClickListener)
    {
      this.b = paramOnClickListener;
    }
    
    @Instrumented
    public void onClick(View paramView)
    {
      VdsAgent.onClick(this, paramView);
      this.b.onClick(paramView);
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setColor(BankcardDetailActivity.this.getResources().getColor(2131624608));
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (b)paramk.getObject();
        if ("success".equals(paramk.status))
        {
          BankcardDetailActivity.this.finish();
          com.freelxl.baselibrary.f.g.textToast(ApplicationEx.c, "银行卡绑定成功");
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(ApplicationEx.c, paramk.error_message);
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(ApplicationEx.c, "银行卡绑定失败");
    }
  }
  
  class c
    implements i.a<String>
  {
    c() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        BankcardDetailActivity.a(BankcardDetailActivity.this, new ArrayList());
        paramk = (BankList)paramk.getObject();
        if ((paramk.getData() != null) && (paramk.getData().size() > 0))
        {
          paramk = paramk.getData().iterator();
          while (paramk.hasNext())
          {
            BankList.DataBean localDataBean = (BankList.DataBean)paramk.next();
            BankcardDetailActivity.h(BankcardDetailActivity.this).add(localDataBean.getBankName());
            BankcardDetailActivity.i(BankcardDetailActivity.this).put(localDataBean.getBankName(), localDataBean.getBankCode() + "");
          }
        }
        BankcardDetailActivity.a(BankcardDetailActivity.this, new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(BankcardDetailActivity.this, "", new a.b()
        {
          public void callBack(HashMap<Integer, String> paramAnonymousHashMap)
          {
            paramAnonymousHashMap = (String)paramAnonymousHashMap.get(Integer.valueOf(0));
            BankcardDetailActivity.j(BankcardDetailActivity.this).setText(paramAnonymousHashMap);
            BankcardDetailActivity.c(BankcardDetailActivity.this, (String)BankcardDetailActivity.i(BankcardDetailActivity.this).get(paramAnonymousHashMap));
            BankcardDetailActivity.d(BankcardDetailActivity.this);
          }
        }, new List[] { BankcardDetailActivity.h(BankcardDetailActivity.this) }));
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(ApplicationEx.c, "获取银行卡列表失败");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/BankcardDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */