package com.ziroom.ziroomcustomer.pay.huifu.activity;

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
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.f.c;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.account.ContactusDialog;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.SignedInfo;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBandCard;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBandCard.DataBean;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBandPrivinceAndCityList;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBandPrivinceAndCityList.DataBean;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBandPrivinceAndCityList.DataBean.ListBean;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBankData;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBankData.DataBean;
import com.ziroom.ziroomcustomer.payment.views.CommonTitle;
import com.ziroom.ziroomcustomer.payment.views.wheelview.WheelView;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddBandCardActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String[] A;
  private String B;
  private String C;
  private String D;
  private String E;
  private HuifuBandCard F;
  private boolean G = false;
  private String H = "";
  private boolean I = false;
  private String J = "";
  private Dialog K = null;
  private CommonTitle a;
  private LabeledEditText b;
  private LabeledEditText c;
  private LabeledEditText d;
  private LabeledEditText e;
  private TextView f;
  private TextView g;
  private List<HuifuBankData.DataBean> r;
  private HuifuBankData.DataBean s;
  private HuifuBandPrivinceAndCityList t;
  private HuifuBandPrivinceAndCityList.DataBean u;
  private HuifuBandPrivinceAndCityList.DataBean.ListBean v;
  private String w;
  private String x;
  private String y;
  private int z;
  
  private void a()
  {
    this.a = ((CommonTitle)findViewById(2131691272));
    this.a.showRightText(true, "下一步");
    this.a.setMiddleText("添加银行卡");
    this.a.setLeftButtonType(2);
    this.a.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        AddBandCardActivity.this.finish();
      }
    });
    this.a.setOnRightButtonClickListener(this);
  }
  
  private void a(final String[] paramArrayOfString)
  {
    View localView = getLayoutInflater().inflate(2130904035, null);
    this.K = new Dialog(this, 2131427586);
    this.K.setContentView(localView, new ViewGroup.LayoutParams(-1, -2));
    final Object localObject = this.K.getWindow();
    ((Window)localObject).setWindowAnimations(2131427844);
    localObject = ((Window)localObject).getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = getWindowManager().getDefaultDisplay().getHeight();
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).height = -2;
    this.K.onWindowAttributesChanged((WindowManager.LayoutParams)localObject);
    localObject = (WheelView)localView.findViewById(2131694517);
    ((WheelView)localObject).setAdapter(new com.ziroom.ziroomcustomer.payment.views.wheelview.a(paramArrayOfString));
    ((WheelView)localObject).setVisibleItems(5);
    ((TextView)localView.findViewById(2131694514)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        AddBandCardActivity.n(AddBandCardActivity.this).setText(paramArrayOfString[localObject.getCurrentItem()]);
        AddBandCardActivity.a(AddBandCardActivity.this, (HuifuBankData.DataBean)AddBandCardActivity.j(AddBandCardActivity.this).get(localObject.getCurrentItem()));
        AddBandCardActivity.o(AddBandCardActivity.this).dismiss();
      }
    });
    ((TextView)localView.findViewById(2131694513)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        AddBandCardActivity.o(AddBandCardActivity.this).dismiss();
      }
    });
    this.K.setCanceledOnTouchOutside(true);
    paramArrayOfString = this.K;
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
    this.B = getIntent().getStringExtra("contractCode");
    this.C = getIntent().getStringExtra("reserveCode");
    this.D = getIntent().getStringExtra("backRentOrderCode");
    this.E = getIntent().getStringExtra("bizType");
    this.g = ((TextView)findViewById(2131690912));
    this.f = ((TextView)findViewById(2131689845));
    this.b = ((LabeledEditText)findViewById(2131690913));
    this.c = ((LabeledEditText)findViewById(2131690914));
    this.d = ((LabeledEditText)findViewById(2131690915));
    this.e = ((LabeledEditText)findViewById(2131690916));
    this.e.getTextView().setFilters(new InputFilter[] { new InputFilter.LengthFilter(13) });
    this.e.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt1 = 3;
        if (AddBandCardActivity.a(AddBandCardActivity.this))
        {
          AddBandCardActivity.a(AddBandCardActivity.this, false);
          return;
        }
        AddBandCardActivity.a(AddBandCardActivity.this, true);
        AddBandCardActivity.a(AddBandCardActivity.this, "");
        paramAnonymousCharSequence = paramAnonymousCharSequence.toString().replace(" ", "");
        if (paramAnonymousCharSequence.length() > 3) {
          AddBandCardActivity.a(AddBandCardActivity.this, AddBandCardActivity.b(AddBandCardActivity.this) + paramAnonymousCharSequence.substring(0, 3) + " ");
        }
        for (;;)
        {
          if (paramAnonymousInt1 + 4 < paramAnonymousCharSequence.length())
          {
            AddBandCardActivity.a(AddBandCardActivity.this, AddBandCardActivity.b(AddBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousInt1 + 4) + " ");
            paramAnonymousInt1 += 4;
          }
          else
          {
            AddBandCardActivity.a(AddBandCardActivity.this, AddBandCardActivity.b(AddBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousCharSequence.length()));
            paramAnonymousInt1 = AddBandCardActivity.c(AddBandCardActivity.this).getText().length();
            AddBandCardActivity.c(AddBandCardActivity.this).setText(AddBandCardActivity.b(AddBandCardActivity.this));
            if ((paramAnonymousInt1 % 5 != 0) || (paramAnonymousInt2 != 0)) {}
          }
          try
          {
            if (paramAnonymousInt1 + 1 <= AddBandCardActivity.b(AddBandCardActivity.this).length())
            {
              AddBandCardActivity.c(AddBandCardActivity.this).setSelection(paramAnonymousInt1 + 1);
              return;
            }
            AddBandCardActivity.c(AddBandCardActivity.this).setSelection(AddBandCardActivity.b(AddBandCardActivity.this).length());
            return;
          }
          catch (Exception paramAnonymousCharSequence) {}
          if ((paramAnonymousInt2 == 1) && (paramAnonymousInt1 < AddBandCardActivity.b(AddBandCardActivity.this).length()))
          {
            AddBandCardActivity.c(AddBandCardActivity.this).setSelection(paramAnonymousInt1);
            return;
          }
          if ((paramAnonymousInt2 == 0) && (paramAnonymousInt1 < AddBandCardActivity.b(AddBandCardActivity.this).length()))
          {
            if ((paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 9))
            {
              AddBandCardActivity.c(AddBandCardActivity.this).setSelection(paramAnonymousInt1 + 1);
              return;
            }
            AddBandCardActivity.c(AddBandCardActivity.this).setSelection(paramAnonymousInt1);
            return;
          }
          AddBandCardActivity.c(AddBandCardActivity.this).setSelection(AddBandCardActivity.b(AddBandCardActivity.this).length());
          return;
          paramAnonymousInt1 = 0;
        }
      }
    });
    this.d.getTextView().setFilters(new InputFilter[] { new InputFilter.LengthFilter(30) });
    this.d.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt1 = 0;
        if (AddBandCardActivity.d(AddBandCardActivity.this))
        {
          AddBandCardActivity.b(AddBandCardActivity.this, false);
          return;
        }
        AddBandCardActivity.b(AddBandCardActivity.this, true);
        AddBandCardActivity.b(AddBandCardActivity.this, "");
        paramAnonymousCharSequence = paramAnonymousCharSequence.toString().replace(" ", "");
        while (paramAnonymousInt1 + 4 < paramAnonymousCharSequence.length())
        {
          AddBandCardActivity.b(AddBandCardActivity.this, AddBandCardActivity.e(AddBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousInt1 + 4) + " ");
          paramAnonymousInt1 += 4;
        }
        AddBandCardActivity.b(AddBandCardActivity.this, AddBandCardActivity.e(AddBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousCharSequence.length()));
        paramAnonymousInt1 = AddBandCardActivity.f(AddBandCardActivity.this).getText().length();
        AddBandCardActivity.f(AddBandCardActivity.this).setText(AddBandCardActivity.e(AddBandCardActivity.this));
        if ((paramAnonymousInt1 % 5 == 0) && (paramAnonymousInt2 == 0)) {}
        try
        {
          if (paramAnonymousInt1 + 1 <= AddBandCardActivity.e(AddBandCardActivity.this).length())
          {
            AddBandCardActivity.f(AddBandCardActivity.this).setSelection(paramAnonymousInt1 + 1);
            return;
          }
          AddBandCardActivity.f(AddBandCardActivity.this).setSelection(AddBandCardActivity.e(AddBandCardActivity.this).length());
          return;
        }
        catch (Exception paramAnonymousCharSequence) {}
        if ((paramAnonymousInt2 == 1) && (paramAnonymousInt1 < AddBandCardActivity.e(AddBandCardActivity.this).length()))
        {
          AddBandCardActivity.f(AddBandCardActivity.this).setSelection(paramAnonymousInt1);
          return;
        }
        if ((paramAnonymousInt2 == 0) && (paramAnonymousInt1 < AddBandCardActivity.e(AddBandCardActivity.this).length()))
        {
          AddBandCardActivity.f(AddBandCardActivity.this).setSelection(paramAnonymousInt1);
          return;
        }
        AddBandCardActivity.f(AddBandCardActivity.this).setSelection(AddBandCardActivity.e(AddBandCardActivity.this).length());
        return;
      }
    });
    getData("");
  }
  
  private void e()
  {
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.pay.common.b.a.getHuifuBankData(this, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        d.e("yangxj---", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        if (!paramAnonymousk.getSuccess().booleanValue()) {
          com.freelxl.baselibrary.f.g.textToast(AddBandCardActivity.this, paramAnonymousk.getMessage());
        }
        do
        {
          return;
          paramAnonymousk = (HuifuBankData)paramAnonymousk.getObject();
        } while ((paramAnonymousk == null) || (paramAnonymousk.getData() == null));
        if (paramAnonymousk.isSuccess())
        {
          AddBandCardActivity.a(AddBandCardActivity.this, paramAnonymousk.getData());
          int i = AddBandCardActivity.j(AddBandCardActivity.this).size();
          AddBandCardActivity.a(AddBandCardActivity.this, new String[i]);
          while (i > 0)
          {
            AddBandCardActivity.k(AddBandCardActivity.this)[(i - 1)] = ((HuifuBankData.DataBean)AddBandCardActivity.j(AddBandCardActivity.this).get(i - 1)).getBankName();
            i -= 1;
          }
          AddBandCardActivity.b(AddBandCardActivity.this, AddBandCardActivity.k(AddBandCardActivity.this));
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(AddBandCardActivity.this, paramAnonymousk.getError_message());
      }
    });
  }
  
  private void g()
  {
    com.ziroom.ziroomcustomer.pay.common.b.a.getHuifuBandProvinceAndCityList(this, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        d.e("yangxj---", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        if (!paramAnonymousk.getSuccess().booleanValue()) {
          com.freelxl.baselibrary.f.g.textToast(AddBandCardActivity.this, paramAnonymousk.getMessage());
        }
        do
        {
          return;
          AddBandCardActivity.a(AddBandCardActivity.this, (HuifuBandPrivinceAndCityList)paramAnonymousk.getObject());
        } while ((AddBandCardActivity.l(AddBandCardActivity.this) == null) || (AddBandCardActivity.l(AddBandCardActivity.this).getData() == null));
        if (!AddBandCardActivity.l(AddBandCardActivity.this).isSuccess())
        {
          com.freelxl.baselibrary.f.g.textToast(AddBandCardActivity.this, AddBandCardActivity.l(AddBandCardActivity.this).getError_message());
          return;
        }
        AddBandCardActivity.m(AddBandCardActivity.this);
      }
    });
  }
  
  private void h()
  {
    Object localObject1 = getLayoutInflater().inflate(2130904034, null);
    this.K = new Dialog(this, 2131427586);
    this.K.setContentView((View)localObject1, new ViewGroup.LayoutParams(-1, -2));
    Object localObject2 = this.K.getWindow();
    ((Window)localObject2).setWindowAnimations(2131427844);
    localObject2 = ((Window)localObject2).getAttributes();
    ((WindowManager.LayoutParams)localObject2).x = 0;
    ((WindowManager.LayoutParams)localObject2).y = getWindowManager().getDefaultDisplay().getHeight();
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).height = -2;
    this.K.onWindowAttributesChanged((WindowManager.LayoutParams)localObject2);
    localObject2 = (WheelView)((View)localObject1).findViewById(2131694515);
    if ((this.t == null) || (this.t.getData().size() == 0)) {
      return;
    }
    int j = this.t.getData().size();
    final Object localObject3 = new String[j];
    int i = 0;
    while (i < j)
    {
      localObject3[i] = ((HuifuBandPrivinceAndCityList.DataBean)this.t.getData().get(i)).getCardProvName();
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
        AddBandCardActivity.a(AddBandCardActivity.this, (HuifuBandPrivinceAndCityList.DataBean)AddBandCardActivity.l(AddBandCardActivity.this).getData().get(paramAnonymousInt2));
        paramAnonymousWheelView = AddBandCardActivity.p(AddBandCardActivity.this).getList();
        paramAnonymousInt2 = paramAnonymousWheelView.size();
        String[] arrayOfString = new String[paramAnonymousInt2];
        paramAnonymousInt1 = 0;
        while (paramAnonymousInt1 < paramAnonymousInt2)
        {
          arrayOfString[paramAnonymousInt1] = ((HuifuBandPrivinceAndCityList.DataBean.ListBean)paramAnonymousWheelView.get(paramAnonymousInt1)).getCardAreaName();
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
        if (AddBandCardActivity.p(AddBandCardActivity.this).getList().size() >= localObject3.getCurrentItem())
        {
          AddBandCardActivity.a(AddBandCardActivity.this, (HuifuBandPrivinceAndCityList.DataBean.ListBean)AddBandCardActivity.p(AddBandCardActivity.this).getList().get(localObject3.getCurrentItem()));
          AddBandCardActivity.r(AddBandCardActivity.this).setText(AddBandCardActivity.p(AddBandCardActivity.this).getCardProvName() + " " + AddBandCardActivity.q(AddBandCardActivity.this).getCardAreaName());
        }
        AddBandCardActivity.o(AddBandCardActivity.this).dismiss();
      }
    });
    ((TextView)((View)localObject1).findViewById(2131694513)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        AddBandCardActivity.o(AddBandCardActivity.this).dismiss();
      }
    });
    this.K.setCanceledOnTouchOutside(true);
    localObject1 = this.K;
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
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("is_newsign", "0");
    localHashMap.put("cert_type", paramString + "");
    com.freelxl.baselibrary.d.a.isLog(true);
    com.freelxl.baselibrary.d.a.get(q.O + e.n.p).tag(this).params(com.ziroom.ziroomcustomer.e.g.getPassportSign(localHashMap)).addHeader("Accept", "application/json; version=1").enqueue(new com.ziroom.commonlibrary.a.a(this, new c())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        dismissProgress();
        if ("success".equals(paramAnonymouse.get("status")))
        {
          paramAnonymouse = paramAnonymouse.get("data").toString();
          if ((ae.notNull(paramAnonymouse)) && (paramAnonymouse.length() > 5))
          {
            paramAnonymouse = (SignedInfo)com.alibaba.fastjson.a.parseObject(paramAnonymouse, SignedInfo.class);
            AddBandCardActivity.c(AddBandCardActivity.this, paramAnonymouse.getReal_name());
            AddBandCardActivity.d(AddBandCardActivity.this, paramAnonymouse.getPhone());
            AddBandCardActivity.e(AddBandCardActivity.this, paramAnonymouse.getCert_num());
            AddBandCardActivity.a(AddBandCardActivity.this, paramAnonymouse.getCert_type());
            AddBandCardActivity.h(AddBandCardActivity.this).setText(AddBandCardActivity.g(AddBandCardActivity.this));
          }
          return;
        }
        AddBandCardActivity.this.showToast(paramAnonymouse.get("error_message") + "");
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == 90) && (paramInt1 == 1)) {
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
      if (this.A == null)
      {
        f();
        return;
      }
      a(this.A);
      return;
    case 2131690914: 
      if (this.t == null)
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
    paramView = this.d.getText().replace(" ", "");
    Object localObject = this.e.getText().replace(" ", "");
    if ((this.b.getText().length() == 0) || (this.c.getText().length() == 0) || (((String)localObject).length() == 0) || (paramView.length() == 0))
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
    com.ziroom.ziroomcustomer.pay.common.b.a.getHuifuBandCard(this, this.E, String.valueOf(this.s.getBankCode()), this.v.getCardProvCode(), this.v.getCardAreaCode(), paramView, (String)localObject, this.y, this.w, this.x, this.B, this.C, this.D, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk)
      {
        d.e("yangxj--", paramAnonymousString + "------ro:" + com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
      }
      
      public void onSuccess(k paramAnonymousk)
      {
        d.e("yangxj--", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        if (!paramAnonymousk.getSuccess().booleanValue()) {
          com.freelxl.baselibrary.f.g.textToast(AddBandCardActivity.this, paramAnonymousk.getMessage());
        }
        do
        {
          return;
          AddBandCardActivity.a(AddBandCardActivity.this, (HuifuBandCard)paramAnonymousk.getObject());
        } while ((AddBandCardActivity.i(AddBandCardActivity.this) == null) || (AddBandCardActivity.i(AddBandCardActivity.this).data == null));
        if (AddBandCardActivity.i(AddBandCardActivity.this).isSuccess())
        {
          paramAnonymousk = new Intent(AddBandCardActivity.this, HuifuWebViewActivity.class);
          paramAnonymousk.putExtra("url", AddBandCardActivity.i(AddBandCardActivity.this).data.url);
          if (AddBandCardActivity.i(AddBandCardActivity.this).data.orderId == null) {
            AddBandCardActivity.i(AddBandCardActivity.this).data.orderId = AddBandCardActivity.i(AddBandCardActivity.this).data.url.substring(AddBandCardActivity.i(AddBandCardActivity.this).data.url.indexOf("=") + 1);
          }
          paramAnonymousk.putExtra("orderId", AddBandCardActivity.i(AddBandCardActivity.this).data.orderId);
          paramAnonymousk.putExtra("title", "汇付支付页面");
          AddBandCardActivity.this.startActivityForResult(paramAnonymousk, 1);
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(AddBandCardActivity.this, AddBandCardActivity.i(AddBandCardActivity.this).getError_message());
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/huifu/activity/AddBandCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */