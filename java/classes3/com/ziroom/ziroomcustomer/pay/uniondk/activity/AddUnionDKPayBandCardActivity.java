package com.ziroom.ziroomcustomer.pay.uniondk.activity;

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
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.b.b;
import com.freelxl.baselibrary.d.f.c;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.SignedInfo;
import com.ziroom.ziroomcustomer.newchat.chatcenter.QuestionDetailActivity;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayAddBandCard;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayBandCardList;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayBandCardList.DataBean;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayIsBandCard;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayIsBandCard.DataBean;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayIsBandCard.DataBean.CardInfoListBean;
import com.ziroom.ziroomcustomer.payment.views.CommonTitle;
import com.ziroom.ziroomcustomer.payment.views.wheelview.WheelView;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddUnionDKPayBandCardActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String A = "";
  private boolean B = false;
  private String C = "";
  private TextView D;
  private Dialog E = null;
  private CommonTitle a;
  private LabeledEditText b;
  private LabeledEditText c;
  private LabeledEditText d;
  private TextView e;
  private Button f;
  private List<UnionDKPayBandCardList.DataBean> g;
  private UnionDKPayBandCardList.DataBean r;
  private String s;
  private String t;
  private String u;
  private int v;
  private String[] w;
  private String x;
  private Boolean y = Boolean.valueOf(false);
  private boolean z = false;
  
  private void a()
  {
    this.a = ((CommonTitle)findViewById(2131691272));
    this.a.setMiddleText("添加银行卡");
    this.a.setLeftButtonType(2);
    this.a.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        AddUnionDKPayBandCardActivity.this.finish();
      }
    });
  }
  
  private void a(final String[] paramArrayOfString)
  {
    View localView = getLayoutInflater().inflate(2130904035, null);
    this.E = new Dialog(this, 2131427586);
    this.E.setContentView(localView, new ViewGroup.LayoutParams(-1, -2));
    final Object localObject = this.E.getWindow();
    ((Window)localObject).setWindowAnimations(2131427844);
    localObject = ((Window)localObject).getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = getWindowManager().getDefaultDisplay().getHeight();
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).height = -2;
    this.E.onWindowAttributesChanged((WindowManager.LayoutParams)localObject);
    localObject = (WheelView)localView.findViewById(2131694517);
    ((WheelView)localObject).setAdapter(new com.ziroom.ziroomcustomer.payment.views.wheelview.a(paramArrayOfString));
    ((WheelView)localObject).setVisibleItems(5);
    ((TextView)localView.findViewById(2131694514)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        AddUnionDKPayBandCardActivity.h(AddUnionDKPayBandCardActivity.this).setText(paramArrayOfString[localObject.getCurrentItem()]);
        AddUnionDKPayBandCardActivity.a(AddUnionDKPayBandCardActivity.this, (UnionDKPayBandCardList.DataBean)AddUnionDKPayBandCardActivity.n(AddUnionDKPayBandCardActivity.this).get(localObject.getCurrentItem()));
        AddUnionDKPayBandCardActivity.p(AddUnionDKPayBandCardActivity.this).dismiss();
      }
    });
    ((TextView)localView.findViewById(2131694513)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        AddUnionDKPayBandCardActivity.p(AddUnionDKPayBandCardActivity.this).dismiss();
      }
    });
    this.E.setCanceledOnTouchOutside(true);
    paramArrayOfString = this.E;
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
    this.D = ((TextView)findViewById(2131692612));
    this.e = ((TextView)findViewById(2131690912));
    this.b = ((LabeledEditText)findViewById(2131690913));
    this.c = ((LabeledEditText)findViewById(2131690915));
    this.d = ((LabeledEditText)findViewById(2131690916));
    this.f = ((Button)findViewById(2131691560));
    this.x = getIntent().getStringExtra("contractCode");
    e();
    this.d.getTextView().setFilters(new InputFilter[] { new InputFilter.LengthFilter(13) });
    this.d.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt1 = 3;
        if (AddUnionDKPayBandCardActivity.a(AddUnionDKPayBandCardActivity.this))
        {
          AddUnionDKPayBandCardActivity.a(AddUnionDKPayBandCardActivity.this, false);
          return;
        }
        AddUnionDKPayBandCardActivity.a(AddUnionDKPayBandCardActivity.this, true);
        AddUnionDKPayBandCardActivity.a(AddUnionDKPayBandCardActivity.this, "");
        paramAnonymousCharSequence = paramAnonymousCharSequence.toString().replace(" ", "");
        if (paramAnonymousCharSequence.length() > 3) {
          AddUnionDKPayBandCardActivity.a(AddUnionDKPayBandCardActivity.this, AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this) + paramAnonymousCharSequence.substring(0, 3) + " ");
        }
        for (;;)
        {
          if (paramAnonymousInt1 + 4 < paramAnonymousCharSequence.length())
          {
            AddUnionDKPayBandCardActivity.a(AddUnionDKPayBandCardActivity.this, AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousInt1 + 4) + " ");
            paramAnonymousInt1 += 4;
          }
          else
          {
            AddUnionDKPayBandCardActivity.a(AddUnionDKPayBandCardActivity.this, AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousCharSequence.length()));
            paramAnonymousInt1 = AddUnionDKPayBandCardActivity.c(AddUnionDKPayBandCardActivity.this).getText().length();
            AddUnionDKPayBandCardActivity.c(AddUnionDKPayBandCardActivity.this).setText(AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this));
            if ((paramAnonymousInt1 % 5 != 0) || (paramAnonymousInt2 != 0)) {}
          }
          try
          {
            if (paramAnonymousInt1 + 1 <= AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this).length())
            {
              AddUnionDKPayBandCardActivity.c(AddUnionDKPayBandCardActivity.this).setSelection(paramAnonymousInt1 + 1);
              return;
            }
            AddUnionDKPayBandCardActivity.c(AddUnionDKPayBandCardActivity.this).setSelection(AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this).length());
            return;
          }
          catch (Exception paramAnonymousCharSequence) {}
          if ((paramAnonymousInt2 == 1) && (paramAnonymousInt1 < AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this).length()))
          {
            AddUnionDKPayBandCardActivity.c(AddUnionDKPayBandCardActivity.this).setSelection(paramAnonymousInt1);
            return;
          }
          if ((paramAnonymousInt2 == 0) && (paramAnonymousInt1 < AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this).length()))
          {
            if ((paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 9))
            {
              AddUnionDKPayBandCardActivity.c(AddUnionDKPayBandCardActivity.this).setSelection(paramAnonymousInt1 + 1);
              return;
            }
            AddUnionDKPayBandCardActivity.c(AddUnionDKPayBandCardActivity.this).setSelection(paramAnonymousInt1);
            return;
          }
          AddUnionDKPayBandCardActivity.c(AddUnionDKPayBandCardActivity.this).setSelection(AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this).length());
          return;
          paramAnonymousInt1 = 0;
        }
      }
    });
    this.c.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt1 = 0;
        if (AddUnionDKPayBandCardActivity.d(AddUnionDKPayBandCardActivity.this))
        {
          AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this, false);
          return;
        }
        AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this, true);
        AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this, "");
        paramAnonymousCharSequence = paramAnonymousCharSequence.toString().replace(" ", "");
        while (paramAnonymousInt1 + 4 < paramAnonymousCharSequence.length())
        {
          AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this, AddUnionDKPayBandCardActivity.e(AddUnionDKPayBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousInt1 + 4) + " ");
          paramAnonymousInt1 += 4;
        }
        AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this, AddUnionDKPayBandCardActivity.e(AddUnionDKPayBandCardActivity.this) + paramAnonymousCharSequence.substring(paramAnonymousInt1, paramAnonymousCharSequence.length()));
        paramAnonymousInt1 = AddUnionDKPayBandCardActivity.f(AddUnionDKPayBandCardActivity.this).getText().length();
        AddUnionDKPayBandCardActivity.f(AddUnionDKPayBandCardActivity.this).setText(AddUnionDKPayBandCardActivity.e(AddUnionDKPayBandCardActivity.this));
        if ((paramAnonymousInt1 % 5 == 0) && (paramAnonymousInt2 == 0)) {}
        try
        {
          if (paramAnonymousInt1 + 1 <= AddUnionDKPayBandCardActivity.e(AddUnionDKPayBandCardActivity.this).length())
          {
            AddUnionDKPayBandCardActivity.f(AddUnionDKPayBandCardActivity.this).setSelection(paramAnonymousInt1 + 1);
            return;
          }
          AddUnionDKPayBandCardActivity.f(AddUnionDKPayBandCardActivity.this).setSelection(AddUnionDKPayBandCardActivity.e(AddUnionDKPayBandCardActivity.this).length());
          return;
        }
        catch (Exception paramAnonymousCharSequence) {}
        if ((paramAnonymousInt2 == 1) && (paramAnonymousInt1 < AddUnionDKPayBandCardActivity.e(AddUnionDKPayBandCardActivity.this).length()))
        {
          AddUnionDKPayBandCardActivity.f(AddUnionDKPayBandCardActivity.this).setSelection(paramAnonymousInt1);
          return;
        }
        if ((paramAnonymousInt2 == 0) && (paramAnonymousInt1 < AddUnionDKPayBandCardActivity.e(AddUnionDKPayBandCardActivity.this).length()))
        {
          AddUnionDKPayBandCardActivity.f(AddUnionDKPayBandCardActivity.this).setSelection(paramAnonymousInt1);
          return;
        }
        AddUnionDKPayBandCardActivity.f(AddUnionDKPayBandCardActivity.this).setSelection(AddUnionDKPayBandCardActivity.e(AddUnionDKPayBandCardActivity.this).length());
        return;
      }
    });
    getData("");
  }
  
  private void e()
  {
    com.ziroom.ziroomcustomer.pay.common.b.a.getUnionPayIsBandCardResult(this, this.x, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        boolean bool2 = true;
        d.e("yangxj--------银联代扣", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        if (!paramAnonymousk.getSuccess().booleanValue()) {
          com.freelxl.baselibrary.f.g.textToast(AddUnionDKPayBandCardActivity.this, paramAnonymousk.getMessage());
        }
        do
        {
          do
          {
            do
            {
              return;
              paramAnonymousk = (UnionDKPayIsBandCard)paramAnonymousk.getObject();
            } while (paramAnonymousk == null);
            if (!paramAnonymousk.isSuccess())
            {
              com.freelxl.baselibrary.f.g.textToast(AddUnionDKPayBandCardActivity.this, paramAnonymousk.getError_message());
              return;
            }
          } while (paramAnonymousk.data == null);
          AddUnionDKPayBandCardActivity localAddUnionDKPayBandCardActivity = AddUnionDKPayBandCardActivity.this;
          if (paramAnonymousk.data.isBindUid == 0) {
            break;
          }
          bool1 = true;
          AddUnionDKPayBandCardActivity.a(localAddUnionDKPayBandCardActivity, Boolean.valueOf(bool1));
        } while (!AddUnionDKPayBandCardActivity.g(AddUnionDKPayBandCardActivity.this).booleanValue());
        paramAnonymousk = (UnionDKPayIsBandCard.DataBean.CardInfoListBean)paramAnonymousk.data.cardInfoList.get(0);
        AddUnionDKPayBandCardActivity.f(AddUnionDKPayBandCardActivity.this).setText(paramAnonymousk.bankCardNo);
        AddUnionDKPayBandCardActivity.h(AddUnionDKPayBandCardActivity.this).setText(paramAnonymousk.bankName);
        AddUnionDKPayBandCardActivity.i(AddUnionDKPayBandCardActivity.this).setText(paramAnonymousk.userName);
        AddUnionDKPayBandCardActivity.c(AddUnionDKPayBandCardActivity.this).setText(paramAnonymousk.mobile);
        AddUnionDKPayBandCardActivity.c(AddUnionDKPayBandCardActivity.this, paramAnonymousk.certificateNum);
        paramAnonymousk = AddUnionDKPayBandCardActivity.f(AddUnionDKPayBandCardActivity.this).getTextView();
        if (!AddUnionDKPayBandCardActivity.g(AddUnionDKPayBandCardActivity.this).booleanValue())
        {
          bool1 = true;
          label223:
          paramAnonymousk.setEnabled(bool1);
          paramAnonymousk = AddUnionDKPayBandCardActivity.f(AddUnionDKPayBandCardActivity.this).getTextView();
          if (AddUnionDKPayBandCardActivity.g(AddUnionDKPayBandCardActivity.this).booleanValue()) {
            break label422;
          }
          bool1 = true;
          label254:
          paramAnonymousk.setFocusable(bool1);
          paramAnonymousk = AddUnionDKPayBandCardActivity.c(AddUnionDKPayBandCardActivity.this).getTextView();
          if (AddUnionDKPayBandCardActivity.g(AddUnionDKPayBandCardActivity.this).booleanValue()) {
            break label427;
          }
          bool1 = true;
          label285:
          paramAnonymousk.setEnabled(bool1);
          paramAnonymousk = AddUnionDKPayBandCardActivity.c(AddUnionDKPayBandCardActivity.this).getTextView();
          if (AddUnionDKPayBandCardActivity.g(AddUnionDKPayBandCardActivity.this).booleanValue()) {
            break label432;
          }
          bool1 = true;
          label316:
          paramAnonymousk.setFocusable(bool1);
          paramAnonymousk = AddUnionDKPayBandCardActivity.f(AddUnionDKPayBandCardActivity.this).getTextView();
          if (AddUnionDKPayBandCardActivity.g(AddUnionDKPayBandCardActivity.this).booleanValue()) {
            break label437;
          }
          bool1 = true;
          label347:
          paramAnonymousk.setFocusableInTouchMode(bool1);
          paramAnonymousk = AddUnionDKPayBandCardActivity.c(AddUnionDKPayBandCardActivity.this).getTextView();
          if (AddUnionDKPayBandCardActivity.g(AddUnionDKPayBandCardActivity.this).booleanValue()) {
            break label442;
          }
          bool1 = true;
          label378:
          paramAnonymousk.setFocusableInTouchMode(bool1);
          paramAnonymousk = AddUnionDKPayBandCardActivity.h(AddUnionDKPayBandCardActivity.this);
          if (AddUnionDKPayBandCardActivity.g(AddUnionDKPayBandCardActivity.this).booleanValue()) {
            break label447;
          }
        }
        label422:
        label427:
        label432:
        label437:
        label442:
        label447:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          paramAnonymousk.setEnabled(bool1);
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label223;
          bool1 = false;
          break label254;
          bool1 = false;
          break label285;
          bool1 = false;
          break label316;
          bool1 = false;
          break label347;
          bool1 = false;
          break label378;
        }
      }
    });
  }
  
  private void f()
  {
    if (!this.y.booleanValue()) {
      this.b.setOnClickListener(this);
    }
    this.f.setOnClickListener(this);
    this.D.setOnClickListener(this);
  }
  
  private void g()
  {
    showProgress("");
    com.ziroom.ziroomcustomer.pay.common.b.a.getUnionPayBankListResult(this, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        AddUnionDKPayBandCardActivity.this.dismissProgress();
        d.e("yangxj---", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        if (!paramAnonymousk.getSuccess().booleanValue()) {
          com.freelxl.baselibrary.f.g.textToast(AddUnionDKPayBandCardActivity.this, paramAnonymousk.getMessage());
        }
        do
        {
          return;
          paramAnonymousk = (UnionDKPayBandCardList)paramAnonymousk.getObject();
        } while ((paramAnonymousk == null) || (paramAnonymousk.data == null));
        if (paramAnonymousk.isSuccess())
        {
          AddUnionDKPayBandCardActivity.a(AddUnionDKPayBandCardActivity.this, paramAnonymousk.data);
          int i = AddUnionDKPayBandCardActivity.n(AddUnionDKPayBandCardActivity.this).size();
          AddUnionDKPayBandCardActivity.a(AddUnionDKPayBandCardActivity.this, new String[i]);
          while (i > 0)
          {
            AddUnionDKPayBandCardActivity.o(AddUnionDKPayBandCardActivity.this)[(i - 1)] = ((UnionDKPayBandCardList.DataBean)AddUnionDKPayBandCardActivity.n(AddUnionDKPayBandCardActivity.this).get(i - 1)).bankName;
            i -= 1;
          }
          AddUnionDKPayBandCardActivity.b(AddUnionDKPayBandCardActivity.this, AddUnionDKPayBandCardActivity.o(AddUnionDKPayBandCardActivity.this));
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(AddUnionDKPayBandCardActivity.this, paramAnonymousk.getError_message());
      }
    });
  }
  
  private void h()
  {
    j.bankBindFailToast(this, new com.ziroom.ziroomcustomer.e.a.f(this, new com.ziroom.ziroomcustomer.e.c.f(e.class))
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse == null) {
          return;
        }
        Intent localIntent = new Intent(AddUnionDKPayBandCardActivity.this, QuestionDetailActivity.class);
        localIntent.putExtra("item_id", paramAnonymouse.getString("validType"));
        AddUnionDKPayBandCardActivity.this.startActivity(localIntent);
      }
    });
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
            AddUnionDKPayBandCardActivity.d(AddUnionDKPayBandCardActivity.this, paramAnonymouse.getReal_name());
            AddUnionDKPayBandCardActivity.e(AddUnionDKPayBandCardActivity.this, paramAnonymouse.getPhone());
            AddUnionDKPayBandCardActivity.c(AddUnionDKPayBandCardActivity.this, paramAnonymouse.getCert_num());
            AddUnionDKPayBandCardActivity.a(AddUnionDKPayBandCardActivity.this, paramAnonymouse.getCert_type());
            AddUnionDKPayBandCardActivity.i(AddUnionDKPayBandCardActivity.this).setText(AddUnionDKPayBandCardActivity.j(AddUnionDKPayBandCardActivity.this));
          }
          return;
        }
        AddUnionDKPayBandCardActivity.this.showToast(paramAnonymouse.get("error_message") + "");
      }
    });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 3) && (paramInt2 == -1))
    {
      setResult(-1);
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
      if (this.w == null)
      {
        g();
        return;
      }
      a(this.w);
      return;
    case 2131691560: 
      if (this.y.booleanValue())
      {
        paramView = new Intent(this, UnionDKPayProtocalActivity.class);
        paramView.putExtra("contractCode", this.x);
        paramView.putExtra("mUserName", this.u);
        paramView.putExtra("mUserCertType", this.v + "");
        paramView.putExtra("mUserCertNum", this.t);
        startActivityForResult(paramView, 3);
        return;
      }
      paramView = this.c.getText().replace(" ", "");
      String str = this.d.getText().replace(" ", "");
      if ((this.b.getText().length() == 0) || (str.length() == 0) || (paramView.length() == 0))
      {
        com.freelxl.baselibrary.f.g.textToast(this, "请将信息填写完整");
        return;
      }
      if (str.length() != 11)
      {
        com.freelxl.baselibrary.f.g.textToast(this, "电话号码位数不对");
        return;
      }
      if (!paramView.toString().matches("\\d{12,23}?"))
      {
        com.freelxl.baselibrary.f.g.textToast(this, "银行卡应该为12-23位纯数字");
        return;
      }
      showProgress("");
      com.ziroom.ziroomcustomer.pay.common.b.a.getUnionPayBandCardResult(this, this.u, paramView.toString(), this.t, str.toString(), this.r.bankCode, this.r.bankName, this.r.bankIconApp, new i.a()
      {
        public void onParse(String paramAnonymousString, k paramAnonymousk)
        {
          d.e("yangxj--", paramAnonymousString + "------ro:" + com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        }
        
        public void onSuccess(k paramAnonymousk)
        {
          d.e("yangxj--", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
          AddUnionDKPayBandCardActivity.this.dismissProgress();
          if (!paramAnonymousk.getSuccess().booleanValue()) {
            com.freelxl.baselibrary.f.g.textToast(AddUnionDKPayBandCardActivity.this, paramAnonymousk.getMessage());
          }
          do
          {
            return;
            paramAnonymousk = (UnionDKPayAddBandCard)paramAnonymousk.getObject();
          } while ((paramAnonymousk == null) || (paramAnonymousk.data == null));
          if (paramAnonymousk.isSuccess())
          {
            AddUnionDKPayBandCardActivity.a(AddUnionDKPayBandCardActivity.this, Boolean.valueOf(true));
            paramAnonymousk = new Intent(AddUnionDKPayBandCardActivity.this, UnionDKPayProtocalActivity.class);
            paramAnonymousk.putExtra("contractCode", AddUnionDKPayBandCardActivity.k(AddUnionDKPayBandCardActivity.this));
            paramAnonymousk.putExtra("mUserName", AddUnionDKPayBandCardActivity.j(AddUnionDKPayBandCardActivity.this));
            paramAnonymousk.putExtra("mUserCertType", AddUnionDKPayBandCardActivity.l(AddUnionDKPayBandCardActivity.this) + "");
            paramAnonymousk.putExtra("mUserCertNum", AddUnionDKPayBandCardActivity.m(AddUnionDKPayBandCardActivity.this));
            AddUnionDKPayBandCardActivity.this.startActivityForResult(paramAnonymousk, 3);
            return;
          }
          com.freelxl.baselibrary.f.g.textToast(AddUnionDKPayBandCardActivity.this, paramAnonymousk.getError_message());
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/uniondk/activity/AddUnionDKPayBandCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */