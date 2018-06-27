package com.ziroom.ziroomcustomer.payment.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
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
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.account.ContactusDialog;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.payment.b.f;
import com.ziroom.ziroomcustomer.payment.b.h;
import com.ziroom.ziroomcustomer.payment.b.j;
import com.ziroom.ziroomcustomer.payment.d.c;
import com.ziroom.ziroomcustomer.payment.d.i;
import com.ziroom.ziroomcustomer.payment.views.CommonTitle;
import com.ziroom.ziroomcustomer.payment.views.wheelview.WheelView;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import java.util.List;

public class HuifuAddBandCardActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String A;
  private boolean B = false;
  private String C = "";
  private boolean D = false;
  private String E = "";
  private Dialog F = null;
  private LabeledEditText a;
  private LabeledEditText b;
  private LabeledEditText c;
  private LabeledEditText d;
  private TextView e;
  private TextView f;
  private List<com.ziroom.ziroomcustomer.payment.b.g> g;
  private com.ziroom.ziroomcustomer.payment.b.g r;
  private List<j> s;
  private j t;
  private h u;
  private String v;
  private String w;
  private String x;
  private String y;
  private String[] z;
  
  private void a()
  {
    CommonTitle localCommonTitle = (CommonTitle)findViewById(2131691272);
    localCommonTitle.showRightText(true, "下一步");
    localCommonTitle.setMiddleText("添加银行卡");
    localCommonTitle.setLeftButtonType(2);
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        HuifuAddBandCardActivity.this.finish();
      }
    });
    localCommonTitle.setOnRightButtonClickListener(this);
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
        HuifuAddBandCardActivity.n(HuifuAddBandCardActivity.this).setText(paramArrayOfString[localObject.getCurrentItem()]);
        HuifuAddBandCardActivity.a(HuifuAddBandCardActivity.this, (com.ziroom.ziroomcustomer.payment.b.g)HuifuAddBandCardActivity.j(HuifuAddBandCardActivity.this).get(localObject.getCurrentItem()));
        HuifuAddBandCardActivity.o(HuifuAddBandCardActivity.this).dismiss();
      }
    });
    ((TextView)localView.findViewById(2131694513)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        HuifuAddBandCardActivity.o(HuifuAddBandCardActivity.this).dismiss();
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
    setContentView(2130903209);
    this.A = getIntent().getStringExtra("cwOrderId");
    this.f = ((TextView)findViewById(2131690912));
    this.e = ((TextView)findViewById(2131689845));
    this.a = ((LabeledEditText)findViewById(2131690913));
    this.b = ((LabeledEditText)findViewById(2131690914));
    this.c = ((LabeledEditText)findViewById(2131690915));
    this.d = ((LabeledEditText)findViewById(2131690916));
    this.d.getTextView().setFilters(new InputFilter[] { new InputFilter.LengthFilter(13) });
    this.d.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt1 = 3;
        if (HuifuAddBandCardActivity.a(HuifuAddBandCardActivity.this))
        {
          HuifuAddBandCardActivity.a(HuifuAddBandCardActivity.this, false);
          return;
        }
        HuifuAddBandCardActivity.a(HuifuAddBandCardActivity.this, true);
        HuifuAddBandCardActivity.a(HuifuAddBandCardActivity.this, "");
        paramAnonymousCharSequence = paramAnonymousCharSequence.toString().replace(" ", "");
        if (paramAnonymousCharSequence.length() > 3) {
          HuifuAddBandCardActivity.a(HuifuAddBandCardActivity.this, HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this) + paramAnonymousCharSequence.substring(0, 3) + " ");
        }
        for (;;)
        {
          if (paramAnonymousInt1 + 4 < paramAnonymousCharSequence.length())
          {
            HuifuAddBandCardActivity.a(HuifuAddBandCardActivity.this, HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousInt1 + 4) + " ");
            paramAnonymousInt1 += 4;
          }
          else
          {
            HuifuAddBandCardActivity.a(HuifuAddBandCardActivity.this, HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousCharSequence.length()));
            paramAnonymousInt1 = HuifuAddBandCardActivity.c(HuifuAddBandCardActivity.this).getText().length();
            HuifuAddBandCardActivity.c(HuifuAddBandCardActivity.this).setText(HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this));
            if ((paramAnonymousInt1 % 5 != 0) || (paramAnonymousInt2 != 0)) {}
          }
          try
          {
            if (paramAnonymousInt1 + 1 <= HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this).length())
            {
              HuifuAddBandCardActivity.c(HuifuAddBandCardActivity.this).setSelection(paramAnonymousInt1 + 1);
              return;
            }
            HuifuAddBandCardActivity.c(HuifuAddBandCardActivity.this).setSelection(HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this).length());
            return;
          }
          catch (Exception paramAnonymousCharSequence) {}
          if ((paramAnonymousInt2 == 1) && (paramAnonymousInt1 < HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this).length()))
          {
            HuifuAddBandCardActivity.c(HuifuAddBandCardActivity.this).setSelection(paramAnonymousInt1);
            return;
          }
          if ((paramAnonymousInt2 == 0) && (paramAnonymousInt1 < HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this).length()))
          {
            if ((paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 9))
            {
              HuifuAddBandCardActivity.c(HuifuAddBandCardActivity.this).setSelection(paramAnonymousInt1 + 1);
              return;
            }
            HuifuAddBandCardActivity.c(HuifuAddBandCardActivity.this).setSelection(paramAnonymousInt1);
            return;
          }
          HuifuAddBandCardActivity.c(HuifuAddBandCardActivity.this).setSelection(HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this).length());
          return;
          paramAnonymousInt1 = 0;
        }
      }
    });
    this.c.getTextView().setFilters(new InputFilter[] { new InputFilter.LengthFilter(30) });
    this.c.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt1 = 0;
        if (HuifuAddBandCardActivity.d(HuifuAddBandCardActivity.this))
        {
          HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this, false);
          return;
        }
        HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this, true);
        HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this, "");
        paramAnonymousCharSequence = paramAnonymousCharSequence.toString().replace(" ", "");
        while (paramAnonymousInt1 + 4 < paramAnonymousCharSequence.length())
        {
          HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this, HuifuAddBandCardActivity.e(HuifuAddBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousInt1 + 4) + " ");
          paramAnonymousInt1 += 4;
        }
        HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this, HuifuAddBandCardActivity.e(HuifuAddBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousCharSequence.length()));
        paramAnonymousInt1 = HuifuAddBandCardActivity.f(HuifuAddBandCardActivity.this).getText().length();
        HuifuAddBandCardActivity.f(HuifuAddBandCardActivity.this).setText(HuifuAddBandCardActivity.e(HuifuAddBandCardActivity.this));
        if ((paramAnonymousInt1 % 5 == 0) && (paramAnonymousInt2 == 0)) {}
        try
        {
          if (paramAnonymousInt1 + 1 <= HuifuAddBandCardActivity.e(HuifuAddBandCardActivity.this).length())
          {
            HuifuAddBandCardActivity.f(HuifuAddBandCardActivity.this).setSelection(paramAnonymousInt1 + 1);
            return;
          }
          HuifuAddBandCardActivity.f(HuifuAddBandCardActivity.this).setSelection(HuifuAddBandCardActivity.e(HuifuAddBandCardActivity.this).length());
          return;
        }
        catch (Exception paramAnonymousCharSequence) {}
        if ((paramAnonymousInt2 == 1) && (paramAnonymousInt1 < HuifuAddBandCardActivity.e(HuifuAddBandCardActivity.this).length()))
        {
          HuifuAddBandCardActivity.f(HuifuAddBandCardActivity.this).setSelection(paramAnonymousInt1);
          return;
        }
        if ((paramAnonymousInt2 == 0) && (paramAnonymousInt1 < HuifuAddBandCardActivity.e(HuifuAddBandCardActivity.this).length()))
        {
          HuifuAddBandCardActivity.f(HuifuAddBandCardActivity.this).setSelection(paramAnonymousInt1);
          return;
        }
        HuifuAddBandCardActivity.f(HuifuAddBandCardActivity.this).setSelection(HuifuAddBandCardActivity.e(HuifuAddBandCardActivity.this).length());
        return;
      }
    });
    getData("");
  }
  
  private void e()
  {
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.payment.d.b.getHuifuBankData(this, new i(this, new c(com.ziroom.ziroomcustomer.payment.b.g.class))
    {
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.ziroomcustomer.payment.b.g> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        HuifuAddBandCardActivity.a(HuifuAddBandCardActivity.this, paramAnonymousList);
        paramAnonymousInt = HuifuAddBandCardActivity.j(HuifuAddBandCardActivity.this).size();
        HuifuAddBandCardActivity.a(HuifuAddBandCardActivity.this, new String[paramAnonymousInt]);
        while (paramAnonymousInt > 0)
        {
          HuifuAddBandCardActivity.k(HuifuAddBandCardActivity.this)[(paramAnonymousInt - 1)] = ((com.ziroom.ziroomcustomer.payment.b.g)HuifuAddBandCardActivity.j(HuifuAddBandCardActivity.this).get(paramAnonymousInt - 1)).getBankName();
          paramAnonymousInt -= 1;
        }
        HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this, HuifuAddBandCardActivity.k(HuifuAddBandCardActivity.this));
      }
    });
  }
  
  private void g()
  {
    com.ziroom.ziroomcustomer.payment.d.b.getHuifuBandProvinceAndCityList(this, new i(this, new c(j.class))
    {
      public void onSuccess(int paramAnonymousInt, List<j> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        HuifuAddBandCardActivity.b(HuifuAddBandCardActivity.this, paramAnonymousList);
        if (HuifuAddBandCardActivity.l(HuifuAddBandCardActivity.this) == null) {
          return;
        }
        HuifuAddBandCardActivity.m(HuifuAddBandCardActivity.this);
      }
    });
  }
  
  private void h()
  {
    Object localObject1 = getLayoutInflater().inflate(2130904034, null);
    this.F = new Dialog(this, 2131427586);
    this.F.setContentView((View)localObject1, new ViewGroup.LayoutParams(-1, -2));
    Object localObject2 = this.F.getWindow();
    ((Window)localObject2).setWindowAnimations(2131427844);
    localObject2 = ((Window)localObject2).getAttributes();
    ((WindowManager.LayoutParams)localObject2).x = 0;
    ((WindowManager.LayoutParams)localObject2).y = getWindowManager().getDefaultDisplay().getHeight();
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).height = -2;
    this.F.onWindowAttributesChanged((WindowManager.LayoutParams)localObject2);
    localObject2 = (WheelView)((View)localObject1).findViewById(2131694515);
    if (this.s == null) {
      return;
    }
    int j = this.s.size();
    final Object localObject3 = new String[j];
    int i = 0;
    while (i < j)
    {
      localObject3[i] = ((j)this.s.get(i)).getCardProvName();
      i += 1;
    }
    ((WheelView)localObject2).setAdapter(new com.ziroom.ziroomcustomer.payment.views.wheelview.a((Object[])localObject3));
    ((WheelView)localObject2).setVisibleItems(5);
    localObject3 = (WheelView)((View)localObject1).findViewById(2131694516);
    ((WheelView)localObject3).setVisibleItems(5);
    ((WheelView)localObject2).addChangingListener(new com.ziroom.ziroomcustomer.payment.views.wheelview.b()
    {
      public void onChanged(WheelView paramAnonymousWheelView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        HuifuAddBandCardActivity.a(HuifuAddBandCardActivity.this, (j)HuifuAddBandCardActivity.l(HuifuAddBandCardActivity.this).get(paramAnonymousInt2));
        paramAnonymousWheelView = HuifuAddBandCardActivity.p(HuifuAddBandCardActivity.this).getList();
        paramAnonymousInt2 = paramAnonymousWheelView.size();
        String[] arrayOfString = new String[paramAnonymousInt2];
        paramAnonymousInt1 = 0;
        while (paramAnonymousInt1 < paramAnonymousInt2)
        {
          arrayOfString[paramAnonymousInt1] = ((h)paramAnonymousWheelView.get(paramAnonymousInt1)).getCardAreaName();
          paramAnonymousInt1 += 1;
        }
        localObject3.setAdapter(new com.ziroom.ziroomcustomer.payment.views.wheelview.a(arrayOfString));
      }
    });
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2, 5.0F);
    localLayoutParams1.gravity = 3;
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2, 5.0F);
    localLayoutParams2.gravity = 5;
    ((WheelView)localObject2).setLayoutParams(localLayoutParams1);
    ((WheelView)localObject3).setLayoutParams(localLayoutParams2);
    ((TextView)((View)localObject1).findViewById(2131694514)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (HuifuAddBandCardActivity.p(HuifuAddBandCardActivity.this).getList().size() >= localObject3.getCurrentItem())
        {
          HuifuAddBandCardActivity.a(HuifuAddBandCardActivity.this, (h)HuifuAddBandCardActivity.p(HuifuAddBandCardActivity.this).getList().get(localObject3.getCurrentItem()));
          HuifuAddBandCardActivity.r(HuifuAddBandCardActivity.this).setText(HuifuAddBandCardActivity.p(HuifuAddBandCardActivity.this).getCardProvName() + " " + HuifuAddBandCardActivity.q(HuifuAddBandCardActivity.this).getCardAreaName());
        }
        HuifuAddBandCardActivity.o(HuifuAddBandCardActivity.this).dismiss();
      }
    });
    ((TextView)((View)localObject1).findViewById(2131694513)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        HuifuAddBandCardActivity.o(HuifuAddBandCardActivity.this).dismiss();
      }
    });
    this.F.setCanceledOnTouchOutside(true);
    localObject1 = this.F;
    if (!(localObject1 instanceof Dialog)) {
      ((Dialog)localObject1).show();
    }
    for (;;)
    {
      ((WheelView)localObject2).setCurrentItem(1);
      ((WheelView)localObject2).setCurrentItem(0);
      return;
      VdsAgent.showDialog((Dialog)localObject1);
    }
  }
  
  public void getData(String paramString)
  {
    com.ziroom.ziroomcustomer.payment.d.b.getUserMessageResult(this, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        paramAnonymousString = com.alibaba.fastjson.e.parseObject(paramAnonymousString);
        HuifuAddBandCardActivity.c(HuifuAddBandCardActivity.this, (String)paramAnonymousString.get("idCardNo"));
        HuifuAddBandCardActivity.d(HuifuAddBandCardActivity.this, (String)paramAnonymousString.get("userPhone"));
        HuifuAddBandCardActivity.e(HuifuAddBandCardActivity.this, (String)paramAnonymousString.get("username"));
        HuifuAddBandCardActivity.f(HuifuAddBandCardActivity.this, (String)paramAnonymousString.get("certType"));
        HuifuAddBandCardActivity.h(HuifuAddBandCardActivity.this).setText(HuifuAddBandCardActivity.g(HuifuAddBandCardActivity.this));
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == 90) && (paramInt1 == 1))
    {
      setResult(2);
      finish();
    }
    do
    {
      return;
      if ((paramInt2 == 91) && (paramInt1 == 1))
      {
        com.freelxl.baselibrary.f.g.textToast(this, "绑卡失败");
        return;
      }
    } while ((paramInt2 != 92) || (paramInt1 != 1));
    com.freelxl.baselibrary.f.g.textToast(this, "绑卡数据处理中，请联系客服");
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
      if (this.z == null)
      {
        f();
        return;
      }
      a(this.z);
      return;
    case 2131690914: 
      if (this.s == null)
      {
        g();
        return;
      }
      h();
      return;
    case 2131689845: 
      paramView = new ContactusDialog();
      localObject = getSupportFragmentManager();
      if (!(paramView instanceof DialogFragment))
      {
        paramView.show((FragmentManager)localObject, null);
        return;
      }
      VdsAgent.showDialogFragment((DialogFragment)paramView, (FragmentManager)localObject, null);
      return;
    }
    paramView = this.c.getText().replace(" ", "");
    Object localObject = this.d.getText().replace(" ", "");
    if ((this.a.getText().length() == 0) || (this.b.getText().length() == 0) || (((String)localObject).length() == 0) || (paramView.length() == 0))
    {
      com.freelxl.baselibrary.f.g.textToast(this, "请将信息填写完整");
      return;
    }
    if (((String)localObject).length() != 11)
    {
      com.freelxl.baselibrary.f.g.textToast(this, "电话号码位数不对");
      return;
    }
    if (!paramView.matches("\\d{12,23}?"))
    {
      com.freelxl.baselibrary.f.g.textToast(this, "银行卡应该为12-23位纯数字");
      return;
    }
    com.ziroom.ziroomcustomer.payment.d.b.getHuifuBandCard(this, String.valueOf(this.r.getBankCode()), this.u.getCardProvCode(), this.u.getCardAreaCode(), paramView, (String)localObject, this.x, this.v, this.w, this.A, new i(this, new com.ziroom.ziroomcustomer.payment.d.e(f.class))
    {
      public void onSuccess(int paramAnonymousInt, f paramAnonymousf)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousf);
        Intent localIntent = new Intent(HuifuAddBandCardActivity.this, PayWebViewActivity.class);
        localIntent.putExtra("url", paramAnonymousf.getUrl());
        if (paramAnonymousf.getOrderId() == null) {
          paramAnonymousf.setOrderId(paramAnonymousf.getUrl().substring(paramAnonymousf.getUrl().indexOf("=") + 1));
        }
        localIntent.putExtra("orderId", paramAnonymousf.getOrderId());
        localIntent.putExtra("cwOrderId", HuifuAddBandCardActivity.i(HuifuAddBandCardActivity.this));
        localIntent.putExtra("title", "汇付支付页面");
        HuifuAddBandCardActivity.this.startActivityForResult(localIntent, 1);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
    e();
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/activity/HuifuAddBandCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */