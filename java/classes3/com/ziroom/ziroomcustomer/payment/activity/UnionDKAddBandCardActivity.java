package com.ziroom.ziroomcustomer.payment.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.newchat.chatcenter.QuestionDetailActivity;
import com.ziroom.ziroomcustomer.payment.b.o;
import com.ziroom.ziroomcustomer.payment.b.p;
import com.ziroom.ziroomcustomer.payment.d.c;
import com.ziroom.ziroomcustomer.payment.d.i;
import com.ziroom.ziroomcustomer.payment.views.CommonTitle;
import com.ziroom.ziroomcustomer.payment.views.wheelview.WheelView;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import java.util.List;

public class UnionDKAddBandCardActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private boolean A = false;
  private String B = "";
  private boolean C = false;
  private String D = "";
  private TextView E;
  private Dialog F = null;
  private LabeledEditText a;
  private LabeledEditText b;
  private LabeledEditText c;
  private TextView d;
  private Button e;
  private List<o> f;
  private o g;
  private String r;
  private String s;
  private String t;
  private String u;
  private String[] v;
  private String w;
  private String x;
  private Boolean y = Boolean.valueOf(false);
  private Boolean z = Boolean.valueOf(true);
  
  private void a()
  {
    CommonTitle localCommonTitle = (CommonTitle)findViewById(2131691272);
    localCommonTitle.setMiddleText("添加银行卡");
    localCommonTitle.setLeftButtonType(2);
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        UnionDKAddBandCardActivity.this.finish();
      }
    });
  }
  
  private void a(final String[] paramArrayOfString)
  {
    View localView = getLayoutInflater().inflate(2130904035, null);
    this.F = new Dialog(this, 2131427586);
    this.F.setContentView(localView, new ViewGroup.LayoutParams(-1, -2));
    final Object localObject = this.F.getWindow();
    ((Window)localObject).setWindowAnimations(2131427844);
    localObject = ((Window)localObject).getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = getWindowManager().getDefaultDisplay().getHeight();
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).height = -2;
    this.F.onWindowAttributesChanged((WindowManager.LayoutParams)localObject);
    localObject = (WheelView)localView.findViewById(2131694517);
    ((WheelView)localObject).setAdapter(new com.ziroom.ziroomcustomer.payment.views.wheelview.a(paramArrayOfString));
    ((WheelView)localObject).setVisibleItems(5);
    ((TextView)localView.findViewById(2131694514)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        UnionDKAddBandCardActivity.h(UnionDKAddBandCardActivity.this).setText(paramArrayOfString[localObject.getCurrentItem()]);
        UnionDKAddBandCardActivity.a(UnionDKAddBandCardActivity.this, (o)UnionDKAddBandCardActivity.p(UnionDKAddBandCardActivity.this).get(localObject.getCurrentItem()));
        UnionDKAddBandCardActivity.r(UnionDKAddBandCardActivity.this).dismiss();
      }
    });
    ((TextView)localView.findViewById(2131694513)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        UnionDKAddBandCardActivity.r(UnionDKAddBandCardActivity.this).dismiss();
      }
    });
    this.F.setCanceledOnTouchOutside(true);
    paramArrayOfString = this.F;
    if (!(paramArrayOfString instanceof Dialog))
    {
      paramArrayOfString.show();
      return;
    }
    VdsAgent.showDialog((Dialog)paramArrayOfString);
  }
  
  private void b()
  {
    setContentView(2130903539);
    this.E = ((TextView)findViewById(2131692612));
    this.d = ((TextView)findViewById(2131690912));
    this.a = ((LabeledEditText)findViewById(2131690913));
    this.b = ((LabeledEditText)findViewById(2131690915));
    this.c = ((LabeledEditText)findViewById(2131690916));
    this.e = ((Button)findViewById(2131691560));
    this.w = getIntent().getStringExtra("contractCode");
    this.x = getIntent().getStringExtra("cwOrderId");
    this.z = Boolean.valueOf(getIntent().getBooleanExtra("isSingle", true));
    e();
    this.c.getTextView().setFilters(new InputFilter[] { new InputFilter.LengthFilter(13) });
    this.c.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt1 = 3;
        if (UnionDKAddBandCardActivity.a(UnionDKAddBandCardActivity.this))
        {
          UnionDKAddBandCardActivity.a(UnionDKAddBandCardActivity.this, false);
          return;
        }
        UnionDKAddBandCardActivity.a(UnionDKAddBandCardActivity.this, true);
        UnionDKAddBandCardActivity.a(UnionDKAddBandCardActivity.this, "");
        paramAnonymousCharSequence = paramAnonymousCharSequence.toString().replace(" ", "");
        if (paramAnonymousCharSequence.length() > 3) {
          UnionDKAddBandCardActivity.a(UnionDKAddBandCardActivity.this, UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this) + paramAnonymousCharSequence.substring(0, 3) + " ");
        }
        for (;;)
        {
          if (paramAnonymousInt1 + 4 < paramAnonymousCharSequence.length())
          {
            UnionDKAddBandCardActivity.a(UnionDKAddBandCardActivity.this, UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousInt1 + 4) + " ");
            paramAnonymousInt1 += 4;
          }
          else
          {
            UnionDKAddBandCardActivity.a(UnionDKAddBandCardActivity.this, UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousCharSequence.length()));
            paramAnonymousInt1 = UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).getText().length();
            UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).setText(UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this));
            if ((paramAnonymousInt1 % 5 != 0) || (paramAnonymousInt2 != 0)) {}
          }
          try
          {
            if (paramAnonymousInt1 + 1 <= UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this).length())
            {
              UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).setSelection(paramAnonymousInt1 + 1);
              return;
            }
            UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).setSelection(UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this).length());
            return;
          }
          catch (Exception paramAnonymousCharSequence) {}
          if ((paramAnonymousInt2 == 1) && (paramAnonymousInt1 < UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this).length()))
          {
            UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).setSelection(paramAnonymousInt1);
            return;
          }
          if ((paramAnonymousInt2 == 0) && (paramAnonymousInt1 < UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this).length()))
          {
            if ((paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 9))
            {
              UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).setSelection(paramAnonymousInt1 + 1);
              return;
            }
            UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).setSelection(paramAnonymousInt1);
            return;
          }
          UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).setSelection(UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this).length());
          return;
          paramAnonymousInt1 = 0;
        }
      }
    });
    this.b.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt1 = 0;
        if (UnionDKAddBandCardActivity.d(UnionDKAddBandCardActivity.this))
        {
          UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this, false);
          return;
        }
        UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this, true);
        UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this, "");
        paramAnonymousCharSequence = paramAnonymousCharSequence.toString().replace(" ", "");
        while (paramAnonymousInt1 + 4 < paramAnonymousCharSequence.length())
        {
          UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this, UnionDKAddBandCardActivity.e(UnionDKAddBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousInt1 + 4) + " ");
          paramAnonymousInt1 += 4;
        }
        UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this, UnionDKAddBandCardActivity.e(UnionDKAddBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousCharSequence.length()));
        paramAnonymousInt1 = UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).getText().length();
        UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).setText(UnionDKAddBandCardActivity.e(UnionDKAddBandCardActivity.this));
        if ((paramAnonymousInt1 % 5 == 0) && (paramAnonymousInt2 == 0)) {}
        try
        {
          if (paramAnonymousInt1 + 1 <= UnionDKAddBandCardActivity.e(UnionDKAddBandCardActivity.this).length())
          {
            UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).setSelection(paramAnonymousInt1 + 1);
            return;
          }
          UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).setSelection(UnionDKAddBandCardActivity.e(UnionDKAddBandCardActivity.this).length());
          return;
        }
        catch (Exception paramAnonymousCharSequence) {}
        if ((paramAnonymousInt2 == 1) && (paramAnonymousInt1 < UnionDKAddBandCardActivity.e(UnionDKAddBandCardActivity.this).length()))
        {
          UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).setSelection(paramAnonymousInt1);
          return;
        }
        if ((paramAnonymousInt2 == 0) && (paramAnonymousInt1 < UnionDKAddBandCardActivity.e(UnionDKAddBandCardActivity.this).length()))
        {
          UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).setSelection(paramAnonymousInt1);
          return;
        }
        UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).setSelection(UnionDKAddBandCardActivity.e(UnionDKAddBandCardActivity.this).length());
        return;
      }
    });
    getData("");
  }
  
  private void e()
  {
    if (this.z.booleanValue()) {
      com.ziroom.ziroomcustomer.payment.d.b.getIsBandCardResult(this, this.x, 2, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(p.class))
      {
        public void onSuccess(int paramAnonymousInt, p paramAnonymousp)
        {
          boolean bool2 = true;
          super.onSuccess(paramAnonymousInt, paramAnonymousp);
          UnionDKAddBandCardActivity localUnionDKAddBandCardActivity = UnionDKAddBandCardActivity.this;
          if (paramAnonymousp.getIsBind() != 0)
          {
            bool1 = true;
            UnionDKAddBandCardActivity.a(localUnionDKAddBandCardActivity, Boolean.valueOf(bool1));
            if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue())
            {
              paramAnonymousp = (com.ziroom.ziroomcustomer.payment.b.b)paramAnonymousp.getBindBanks().get(0);
              UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).setText(paramAnonymousp.getBankNo());
              UnionDKAddBandCardActivity.h(UnionDKAddBandCardActivity.this).setText(paramAnonymousp.getBankName());
              UnionDKAddBandCardActivity.i(UnionDKAddBandCardActivity.this).setText(paramAnonymousp.getUserName());
              UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).setText(paramAnonymousp.getBankPhone());
              UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this, paramAnonymousp.getCertNo());
              paramAnonymousp = UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).getTextView();
              if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue()) {
                break label350;
              }
              bool1 = true;
              label155:
              paramAnonymousp.setEnabled(bool1);
              paramAnonymousp = UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).getTextView();
              if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue()) {
                break label355;
              }
              bool1 = true;
              label186:
              paramAnonymousp.setFocusable(bool1);
              paramAnonymousp = UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).getTextView();
              if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue()) {
                break label360;
              }
              bool1 = true;
              label217:
              paramAnonymousp.setEnabled(bool1);
              paramAnonymousp = UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).getTextView();
              if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue()) {
                break label365;
              }
              bool1 = true;
              label248:
              paramAnonymousp.setFocusable(bool1);
              paramAnonymousp = UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).getTextView();
              if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue()) {
                break label370;
              }
              bool1 = true;
              label279:
              paramAnonymousp.setFocusableInTouchMode(bool1);
              paramAnonymousp = UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).getTextView();
              if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue()) {
                break label375;
              }
              bool1 = true;
              label310:
              paramAnonymousp.setFocusableInTouchMode(bool1);
              paramAnonymousp = UnionDKAddBandCardActivity.h(UnionDKAddBandCardActivity.this);
              if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue()) {
                break label380;
              }
            }
          }
          label350:
          label355:
          label360:
          label365:
          label370:
          label375:
          label380:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            paramAnonymousp.setEnabled(bool1);
            return;
            bool1 = false;
            break;
            bool1 = false;
            break label155;
            bool1 = false;
            break label186;
            bool1 = false;
            break label217;
            bool1 = false;
            break label248;
            bool1 = false;
            break label279;
            bool1 = false;
            break label310;
          }
        }
      });
    }
    if (!this.z.booleanValue()) {
      com.ziroom.ziroomcustomer.payment.d.b.getUserIsBandCardResult(this, this.w, 2, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(p.class))
      {
        public void onSuccess(int paramAnonymousInt, p paramAnonymousp)
        {
          boolean bool2 = true;
          super.onSuccess(paramAnonymousInt, paramAnonymousp);
          UnionDKAddBandCardActivity localUnionDKAddBandCardActivity = UnionDKAddBandCardActivity.this;
          if (paramAnonymousp.getIsBind() != 0)
          {
            bool1 = true;
            UnionDKAddBandCardActivity.a(localUnionDKAddBandCardActivity, Boolean.valueOf(bool1));
            if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue())
            {
              paramAnonymousp = (com.ziroom.ziroomcustomer.payment.b.b)paramAnonymousp.getBindBanks().get(0);
              UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).setText(paramAnonymousp.getBankNo());
              UnionDKAddBandCardActivity.h(UnionDKAddBandCardActivity.this).setText(paramAnonymousp.getBankName());
              UnionDKAddBandCardActivity.i(UnionDKAddBandCardActivity.this).setText(paramAnonymousp.getUserName());
              UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).setText(paramAnonymousp.getBankPhone());
              UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this, paramAnonymousp.getCertNo());
              paramAnonymousp = UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).getTextView();
              if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue()) {
                break label350;
              }
              bool1 = true;
              label155:
              paramAnonymousp.setEnabled(bool1);
              paramAnonymousp = UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).getTextView();
              if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue()) {
                break label355;
              }
              bool1 = true;
              label186:
              paramAnonymousp.setFocusable(bool1);
              paramAnonymousp = UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).getTextView();
              if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue()) {
                break label360;
              }
              bool1 = true;
              label217:
              paramAnonymousp.setEnabled(bool1);
              paramAnonymousp = UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).getTextView();
              if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue()) {
                break label365;
              }
              bool1 = true;
              label248:
              paramAnonymousp.setFocusable(bool1);
              paramAnonymousp = UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this).getTextView();
              if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue()) {
                break label370;
              }
              bool1 = true;
              label279:
              paramAnonymousp.setFocusableInTouchMode(bool1);
              paramAnonymousp = UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this).getTextView();
              if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue()) {
                break label375;
              }
              bool1 = true;
              label310:
              paramAnonymousp.setFocusableInTouchMode(bool1);
              paramAnonymousp = UnionDKAddBandCardActivity.h(UnionDKAddBandCardActivity.this);
              if (UnionDKAddBandCardActivity.g(UnionDKAddBandCardActivity.this).booleanValue()) {
                break label380;
              }
            }
          }
          label350:
          label355:
          label360:
          label365:
          label370:
          label375:
          label380:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            paramAnonymousp.setEnabled(bool1);
            return;
            bool1 = false;
            break;
            bool1 = false;
            break label155;
            bool1 = false;
            break label186;
            bool1 = false;
            break label217;
            bool1 = false;
            break label248;
            bool1 = false;
            break label279;
            bool1 = false;
            break label310;
          }
        }
      });
    }
  }
  
  private void f()
  {
    if (!this.y.booleanValue()) {
      this.a.setOnClickListener(this);
    }
    this.e.setOnClickListener(this);
    this.E.setOnClickListener(this);
  }
  
  private void g()
  {
    com.ziroom.ziroomcustomer.payment.d.b.getUnionPayBankListResult(this, new i(this, new c(o.class))
    {
      public void onSuccess(int paramAnonymousInt, List<o> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        UnionDKAddBandCardActivity.a(UnionDKAddBandCardActivity.this, paramAnonymousList);
        paramAnonymousInt = UnionDKAddBandCardActivity.p(UnionDKAddBandCardActivity.this).size();
        UnionDKAddBandCardActivity.a(UnionDKAddBandCardActivity.this, new String[paramAnonymousInt]);
        while (paramAnonymousInt > 0)
        {
          UnionDKAddBandCardActivity.q(UnionDKAddBandCardActivity.this)[(paramAnonymousInt - 1)] = ((o)UnionDKAddBandCardActivity.p(UnionDKAddBandCardActivity.this).get(paramAnonymousInt - 1)).getBankName();
          paramAnonymousInt -= 1;
        }
        UnionDKAddBandCardActivity.b(UnionDKAddBandCardActivity.this, UnionDKAddBandCardActivity.q(UnionDKAddBandCardActivity.this));
      }
    });
  }
  
  private void h()
  {
    j.bankBindFailToast(this, new com.ziroom.ziroomcustomer.e.a.f(this, new com.ziroom.ziroomcustomer.e.c.f(com.alibaba.fastjson.e.class))
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse == null) {
          return;
        }
        Intent localIntent = new Intent(UnionDKAddBandCardActivity.this, QuestionDetailActivity.class);
        localIntent.putExtra("item_id", paramAnonymouse.getString("validType"));
        UnionDKAddBandCardActivity.this.startActivity(localIntent);
      }
    });
  }
  
  public void getData(String paramString)
  {
    com.ziroom.ziroomcustomer.payment.d.b.getUserMessageResult(this, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        paramAnonymousString = com.alibaba.fastjson.e.parseObject(paramAnonymousString);
        UnionDKAddBandCardActivity.c(UnionDKAddBandCardActivity.this, (String)paramAnonymousString.get("idCardNo"));
        UnionDKAddBandCardActivity.d(UnionDKAddBandCardActivity.this, (String)paramAnonymousString.get("userPhone"));
        UnionDKAddBandCardActivity.e(UnionDKAddBandCardActivity.this, (String)paramAnonymousString.get("username"));
        UnionDKAddBandCardActivity.f(UnionDKAddBandCardActivity.this, (String)paramAnonymousString.get("certType"));
        UnionDKAddBandCardActivity.i(UnionDKAddBandCardActivity.this).setText(UnionDKAddBandCardActivity.j(UnionDKAddBandCardActivity.this));
      }
    });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 3)
    {
      setResult(3);
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
      return;
    case 2131690913: 
      if (this.v == null)
      {
        g();
        return;
      }
      a(this.v);
      return;
    case 2131691560: 
      if (this.y.booleanValue())
      {
        paramView = new Intent(this, UnionDKPayProtocalActivity.class);
        paramView.putExtra("contractCode", this.w);
        paramView.putExtra("cwOrderId", this.x);
        paramView.putExtra("isSingle", this.z);
        paramView.putExtra("mUserName", this.t);
        paramView.putExtra("mUserCertType", this.u);
        paramView.putExtra("mUserCertNum", this.s);
        startActivityForResult(paramView, 3);
        return;
      }
      paramView = this.b.getText().replace(" ", "");
      String str = this.c.getText().replace(" ", "");
      if ((this.a.getText().length() == 0) || (str.length() == 0) || (paramView.length() == 0))
      {
        g.textToast(this, "请将信息填写完整");
        return;
      }
      if (str.length() != 11)
      {
        g.textToast(this, "电话号码位数不对");
        return;
      }
      if (!paramView.toString().matches("\\d{12,23}?"))
      {
        g.textToast(this, "银行卡应该为12-23位纯数字");
        return;
      }
      com.ziroom.ziroomcustomer.payment.d.b.getUnionPayBandCardResult(this, this.t, paramView.toString(), this.s, str.toString(), this.g.getBankCode(), this.g.getBankName(), this.g.getBankIconApp(), new i(this, new com.ziroom.ziroomcustomer.payment.d.e(String.class))
      {
        public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousObject);
          paramAnonymousObject = new Intent(UnionDKAddBandCardActivity.this, UnionDKPayProtocalActivity.class);
          ((Intent)paramAnonymousObject).putExtra("contractCode", UnionDKAddBandCardActivity.k(UnionDKAddBandCardActivity.this));
          ((Intent)paramAnonymousObject).putExtra("isSingle", UnionDKAddBandCardActivity.l(UnionDKAddBandCardActivity.this));
          ((Intent)paramAnonymousObject).putExtra("cwOrderId", UnionDKAddBandCardActivity.m(UnionDKAddBandCardActivity.this));
          ((Intent)paramAnonymousObject).putExtra("mUserName", UnionDKAddBandCardActivity.j(UnionDKAddBandCardActivity.this));
          ((Intent)paramAnonymousObject).putExtra("mUserCertType", UnionDKAddBandCardActivity.n(UnionDKAddBandCardActivity.this) + "");
          ((Intent)paramAnonymousObject).putExtra("mUserCertNum", UnionDKAddBandCardActivity.o(UnionDKAddBandCardActivity.this));
          UnionDKAddBandCardActivity.this.startActivityForResult((Intent)paramAnonymousObject, 3);
        }
      });
      return;
    }
    h();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
    f();
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/activity/UnionDKAddBandCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */