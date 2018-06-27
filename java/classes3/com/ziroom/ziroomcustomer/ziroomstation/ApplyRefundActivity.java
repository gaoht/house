package com.ziroom.ziroomcustomer.ziroomstation;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import com.ziroom.ziroomcustomer.ziroomstation.b.c;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.b;
import com.ziroom.ziroomcustomer.ziroomstation.model.ReFundWayModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.ReFundWayModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.ReFundWayModel.DataBean.ListBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationBaseData;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationBaseData.DataEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApplyRefundActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView A;
  private LabeledEditText B;
  private LabeledEditText C;
  private LabeledEditText D;
  private LinearLayout E;
  private ImageView F;
  private String G;
  private StationBaseData H;
  private List<String> I;
  private List<String> J = new ArrayList();
  private int K = -1;
  private int L;
  private int M;
  private boolean N = false;
  private boolean O = false;
  private boolean P = false;
  private boolean Q = false;
  private boolean R = false;
  private boolean S = false;
  private AlertDialog T;
  public ReFundWayModel a;
  public String b;
  public ReFundWayModel.DataBean.ListBean c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View r;
  private View s;
  private Context t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void a()
  {
    this.F = ((ImageView)findViewById(2131690455));
    this.A = ((TextView)findViewById(2131690458));
    this.d = findViewById(2131690078);
    this.e = findViewById(2131690429);
    this.f = findViewById(2131690452);
    this.g = findViewById(2131690437);
    this.r = findViewById(2131690447);
    this.B = ((LabeledEditText)findViewById(2131690453));
    this.u = ((TextView)findViewById(2131690441));
    this.v = ((TextView)findViewById(2131690446));
    this.C = ((LabeledEditText)findViewById(2131690456));
    this.D = ((LabeledEditText)findViewById(2131690457));
    this.w = ((TextView)findViewById(2131690435));
    this.x = ((TextView)findViewById(2131690436));
    this.s = findViewById(2131690425);
    this.y = ((TextView)findViewById(2131690428));
    this.z = ((TextView)findViewById(2131690443));
    this.E = ((LinearLayout)findViewById(2131690444));
  }
  
  private void a(ReFundWayModel.DataBean.ListBean paramListBean)
  {
    View localView1 = LayoutInflater.from(this).inflate(2130903856, null);
    TextView localTextView1 = (TextView)localView1.findViewById(2131693882);
    TextView localTextView2 = (TextView)localView1.findViewById(2131691363);
    View localView2 = localView1.findViewById(2131693883);
    LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(2131693891);
    localTextView2.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ApplyRefundActivity.l(ApplyRefundActivity.this).dismiss();
      }
    });
    if (!ae.isNull(paramListBean.info))
    {
      localTextView1.setText(paramListBean.info);
      localTextView1.setTextSize(2, 14.0F);
      localView2.setVisibility(0);
      localLinearLayout.setVisibility(8);
      localTextView2.setText("我知道了");
    }
    this.T = new AlertDialog.Builder(this, 2131427592).create();
    paramListBean = this.T;
    if (!(paramListBean instanceof AlertDialog)) {
      paramListBean.show();
    }
    for (;;)
    {
      this.T.setCanceledOnTouchOutside(false);
      this.T.getWindow().setContentView(localView1);
      return;
      VdsAgent.showDialog((AlertDialog)paramListBean);
    }
  }
  
  private void b()
  {
    e();
    if (getIntent().getExtras() != null)
    {
      this.w.setText(getIntent().getExtras().getString("start", ""));
      this.x.setText(getIntent().getExtras().getString("end", ""));
      this.v.setText(getIntent().getExtras().getString("name", ""));
    }
  }
  
  private void e()
  {
    c.getBaseData(this.t, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        ApplyRefundActivity.a(ApplyRefundActivity.this, (StationBaseData)paramAnonymousk.getObject());
        if ((ApplyRefundActivity.a(ApplyRefundActivity.this) != null) && ("200".equals(ApplyRefundActivity.a(ApplyRefundActivity.this).getError_code()))) {
          ApplyRefundActivity.a(ApplyRefundActivity.this, ApplyRefundActivity.a(ApplyRefundActivity.this).getData().getBankName());
        }
        while ((ApplyRefundActivity.a(ApplyRefundActivity.this) == null) || (TextUtils.isEmpty(ApplyRefundActivity.a(ApplyRefundActivity.this).getError_message()))) {
          return;
        }
        af.showToast(ApplyRefundActivity.b(ApplyRefundActivity.this), ApplyRefundActivity.a(ApplyRefundActivity.this).getError_message());
      }
    }, com.ziroom.ziroomcustomer.ziroomstation.b.b.buildGetBaseData(this), true);
    c.getRefundWayInfo(this.t, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        if (paramAnonymousk.getSuccess().booleanValue())
        {
          ApplyRefundActivity.this.a = ((ReFundWayModel)paramAnonymousk.getObject());
          if ((ApplyRefundActivity.this.a != null) && ("200".equals(ApplyRefundActivity.this.a.error_code + "")))
          {
            i = 0;
            while (i < ApplyRefundActivity.this.a.data.list.size())
            {
              ApplyRefundActivity.c(ApplyRefundActivity.this).add(((ReFundWayModel.DataBean.ListBean)ApplyRefundActivity.this.a.data.list.get(i)).reason);
              i += 1;
            }
            ApplyRefundActivity.this.b = (ApplyRefundActivity.this.a.data.refundWay + "");
            switch (ApplyRefundActivity.this.a.data.refundWay)
            {
            default: 
              ApplyRefundActivity.f(ApplyRefundActivity.this).setText("提示:\n" + ApplyRefundActivity.this.a.data.refundNotice);
              com.ziroom.ziroomcustomer.ziroomstation.utils.b.b = ApplyRefundActivity.this.a.data.refundRule;
            }
          }
          while ((ApplyRefundActivity.this.a == null) || (TextUtils.isEmpty(ApplyRefundActivity.this.a.error_message))) {
            for (;;)
            {
              int i;
              return;
              ApplyRefundActivity.d(ApplyRefundActivity.this).setText("原路退回");
              ApplyRefundActivity.e(ApplyRefundActivity.this).setVisibility(8);
              continue;
              ApplyRefundActivity.d(ApplyRefundActivity.this).setText("退款至银行卡");
              ApplyRefundActivity.e(ApplyRefundActivity.this).setVisibility(0);
            }
          }
          af.showToast(ApplyRefundActivity.b(ApplyRefundActivity.this), ApplyRefundActivity.this.a.error_message);
          return;
        }
        af.showToast(ApplyRefundActivity.this, paramAnonymousk.getMessage());
      }
    }, com.ziroom.ziroomcustomer.ziroomstation.b.b.buildGetRefundWayInfo(this, this.G), true);
  }
  
  private void f()
  {
    this.F.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.u.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        ApplyRefundActivity localApplyRefundActivity = ApplyRefundActivity.this;
        if (!TextUtils.isEmpty(paramAnonymousEditable.toString().trim())) {}
        for (boolean bool = true;; bool = false)
        {
          ApplyRefundActivity.a(localApplyRefundActivity, bool);
          ApplyRefundActivity.g(ApplyRefundActivity.this);
          ApplyRefundActivity.b(ApplyRefundActivity.this, true);
          return;
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.D.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        ApplyRefundActivity localApplyRefundActivity = ApplyRefundActivity.this;
        if (!TextUtils.isEmpty(paramAnonymousEditable.toString().trim())) {}
        for (boolean bool = true;; bool = false)
        {
          ApplyRefundActivity.c(localApplyRefundActivity, bool);
          ApplyRefundActivity.g(ApplyRefundActivity.this);
          ApplyRefundActivity.d(ApplyRefundActivity.this, true);
          return;
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  private boolean g()
  {
    if ("2".equals(this.b))
    {
      if ((this.P) && (this.Q) && (this.N) && ((this.O) || (!"其他".equals(this.J.get(this.K - 1)))))
      {
        this.e.setBackgroundColor(Color.parseColor("#ffa000"));
        return true;
      }
      this.e.setBackgroundColor(Color.parseColor("#d1d1d1"));
      return false;
    }
    if ((this.N) && ((this.O) || (!"其他".equals(this.J.get(this.K - 1)))))
    {
      this.e.setBackgroundColor(Color.parseColor("#ffa000"));
      return true;
    }
    this.e.setBackgroundColor(Color.parseColor("#d1d1d1"));
    return false;
  }
  
  private void h()
  {
    if (this.R) {
      w.onEventToZiroomAndUmeng("zinn_payback_account");
    }
    if (this.S) {
      w.onEventToZiroomAndUmeng("zinn_payback_remark");
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
    case 2131690455: 
    case 2131690078: 
    case 2131690429: 
      do
      {
        do
        {
          return;
        } while (this.c == null);
        a(this.c);
        return;
        finish();
        return;
      } while (!g());
      if (this.K < 0)
      {
        af.showToast(this.t, "请选择退款原因！");
        return;
      }
      if (("其他".equals(this.J.get(this.K - 1))) && (TextUtils.isEmpty(this.u.getText().toString().trim())))
      {
        af.showToast(this.t, "请填写备注信息！");
        return;
      }
      if ("2".equals(this.b))
      {
        if (TextUtils.isEmpty(this.C.getText().toString()))
        {
          af.showToast(this.t, "请选择开户银行！");
          return;
        }
        if (TextUtils.isEmpty(this.D.getText().toString()))
        {
          af.showToast(this.t, "请输入银行卡号！");
          return;
        }
        if (!this.D.getText().toString().matches("\\d{12,23}?"))
        {
          af.showToast(this.t, "银行卡应该为12-23位纯数字");
          return;
        }
      }
      c.applyRefund(this.t, com.ziroom.ziroomcustomer.ziroomstation.b.b.buildApplyRefund(this, "", this.b, this.K, this.u.getText().toString(), this.C.getText().toString(), this.D.getText().toString(), this.G, this.v.getText().toString()), new i.a()
      {
        public void onParse(String paramAnonymousString, k paramAnonymousk) {}
        
        public void onSuccess(k paramAnonymousk)
        {
          paramAnonymousk = (com.ziroom.ziroomcustomer.ziroomstation.b.a)paramAnonymousk.getObject();
          if ((paramAnonymousk != null) && ("200".equals(paramAnonymousk.getError_code())))
          {
            af.showToast(ApplyRefundActivity.b(ApplyRefundActivity.this), "退款成功");
            ApplyRefundActivity.this.finish();
          }
          while ((paramAnonymousk == null) || (TextUtils.isEmpty(paramAnonymousk.getError_message()))) {
            return;
          }
          af.showToast(ApplyRefundActivity.b(ApplyRefundActivity.this), paramAnonymousk.getError_message());
        }
      }, true);
      w.onEventToZiroomAndUmeng("zinn_payback_submit");
      return;
    case 2131690452: 
      paramView = new Intent(this, StationWebActivity.class);
      paramView.putExtra("url", com.ziroom.ziroomcustomer.ziroomstation.utils.b.b);
      paramView.putExtra("title", "自如驿退款细则");
      startActivity(paramView);
      w.onEventToZiroomAndUmeng("zinn_payback_rules");
      return;
    case 2131690437: 
      paramView = new ArrayList();
      paramView.addAll(this.J);
      new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(this.t, "请选择退款原因", new a.b()
      {
        public void callBack(HashMap<Integer, String> paramAnonymousHashMap)
        {
          paramAnonymousHashMap = (String)paramAnonymousHashMap.get(Integer.valueOf(0));
          int i = 0;
          for (;;)
          {
            if (i < ApplyRefundActivity.c(ApplyRefundActivity.this).size())
            {
              if (((String)ApplyRefundActivity.c(ApplyRefundActivity.this).get(i)).equals(paramAnonymousHashMap))
              {
                ApplyRefundActivity.h(ApplyRefundActivity.this).setText(paramAnonymousHashMap);
                ApplyRefundActivity.a(ApplyRefundActivity.this, i + 1);
                ApplyRefundActivity.this.c = ((ReFundWayModel.DataBean.ListBean)ApplyRefundActivity.this.a.data.list.get(i));
                ApplyRefundActivity.e(ApplyRefundActivity.this, true);
                ApplyRefundActivity.g(ApplyRefundActivity.this);
              }
            }
            else {
              return;
            }
            i += 1;
          }
        }
      }, new List[] { paramView }).show();
      w.onEventToZiroomAndUmeng("zinn_payback_reason");
      return;
    }
    if ((this.I != null) && (this.I.size() == 0)) {
      e();
    }
    for (;;)
    {
      w.onEventToZiroomAndUmeng("zinn_payback_bank");
      return;
      paramView = new ArrayList();
      paramView.addAll(this.I);
      new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(this.t, "请选择退款银行", new a.b()
      {
        public void callBack(HashMap<Integer, String> paramAnonymousHashMap)
        {
          paramAnonymousHashMap = (String)paramAnonymousHashMap.get(Integer.valueOf(0));
          ApplyRefundActivity.i(ApplyRefundActivity.this).setText(paramAnonymousHashMap);
          ApplyRefundActivity.f(ApplyRefundActivity.this, true);
          ApplyRefundActivity.g(ApplyRefundActivity.this);
        }
      }, new List[] { paramView }).show();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903163);
    this.t = this;
    if (getIntent().getExtras() != null) {}
    for (this.G = getIntent().getExtras().getString("orderBid", "");; this.G = "")
    {
      a();
      b();
      f();
      this.L = getWindowManager().getDefaultDisplay().getHeight();
      this.M = (this.L / 3);
      return;
    }
  }
  
  protected void onDestroy()
  {
    h();
    super.onDestroy();
  }
  
  protected void onResume()
  {
    a("zinn_payback_duration");
    super.onResume();
    this.s.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        if ((paramAnonymousInt8 != 0) && (paramAnonymousInt4 != 0) && (paramAnonymousInt8 - paramAnonymousInt4 > ApplyRefundActivity.j(ApplyRefundActivity.this)))
        {
          paramAnonymousView = ApplyRefundActivity.k(ApplyRefundActivity.this).getLayoutParams();
          paramAnonymousView.height = 0;
          ApplyRefundActivity.k(ApplyRefundActivity.this).setLayoutParams(paramAnonymousView);
        }
        while ((paramAnonymousInt8 == 0) || (paramAnonymousInt4 == 0) || (paramAnonymousInt4 - paramAnonymousInt8 <= ApplyRefundActivity.j(ApplyRefundActivity.this))) {
          return;
        }
        paramAnonymousView = ApplyRefundActivity.k(ApplyRefundActivity.this).getLayoutParams();
        paramAnonymousView.height = n.dip2px(ApplyRefundActivity.b(ApplyRefundActivity.this), 52.0F);
        ApplyRefundActivity.k(ApplyRefundActivity.this).setLayoutParams(paramAnonymousView);
      }
    });
  }
  
  static class ViewHolder
  {
    @BindView(2131695765)
    TextView tvPriceAmount;
    @BindView(2131690454)
    TextView tvPriceTitle;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/ApplyRefundActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */