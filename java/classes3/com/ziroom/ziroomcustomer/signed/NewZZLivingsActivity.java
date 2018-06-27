package com.ziroom.ziroomcustomer.signed;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.b.b;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import com.ziroom.ziroomcustomer.activity.NewLeaseInfoActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.e.a;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.Fees;
import com.ziroom.ziroomcustomer.my.MyStewardInfoActivity;
import com.ziroom.ziroomcustomer.signed.adapter.NewZZLivingsAdapter;
import com.ziroom.ziroomcustomer.termination.CostSettlementActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewZZLivingsActivity
  extends BaseActivity
{
  private String A = null;
  private String B = null;
  private String C = null;
  private AlertDialog D;
  private View E;
  private TextView F;
  private TextView G;
  private TextView H;
  private TextView I;
  private Dialog J;
  private Handler K = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return false;
      }
      if (locall.getSuccess().booleanValue())
      {
        com.freelxl.baselibrary.f.g.textToast(NewZZLivingsActivity.c(NewZZLivingsActivity.this), NewZZLivingsActivity.this.getString(2131297496), 1);
        NewZZLivingsActivity.this.finish();
      }
      for (;;)
      {
        NewZZLivingsActivity.g(NewZZLivingsActivity.this).dismiss();
        NewZZLivingsActivity.this.dismissProgress();
        break;
        NewZZLivingsActivity.this.showDialog(locall.getMessage());
      }
    }
  });
  View.OnClickListener a = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      }
      NewZZLivingsActivity.h(NewZZLivingsActivity.this).dismiss();
    }
  };
  private Context b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  @BindView(2131697111)
  Button new_zz_livings_btn;
  @BindView(2131697114)
  TextView new_zz_livings_content;
  @BindView(2131697116)
  ListViewForScrollView new_zz_livings_list;
  @BindView(2131697112)
  ScrollView new_zz_livings_scroll;
  @BindView(2131697115)
  TextView new_zz_livings_text;
  @BindView(2131697113)
  TextView new_zz_livings_title;
  private String r;
  private com.ziroom.ziroomcustomer.termination.a.g s = new com.ziroom.ziroomcustomer.termination.a.g();
  private Unbinder t;
  private HashMap<String, Object> u;
  private String v;
  private String w;
  private List<Fees> x;
  private NewZZLivingsAdapter y;
  private String z;
  
  private void a()
  {
    this.c = getIntent().getStringExtra("isTermination");
    if (ae.isNull(this.c))
    {
      this.u = ((HashMap)getIntent().getSerializableExtra("bts_map"));
      this.v = getIntent().getStringExtra("contract_part_code");
      this.w = getIntent().getStringExtra("leas");
      if (this.u != null)
      {
        this.x = ((List)this.u.get("feeslist"));
        if (this.x != null)
        {
          this.y = new NewZZLivingsAdapter(this.b, this.x);
          this.new_zz_livings_list.setAdapter(this.y);
        }
        for (;;)
        {
          localObject = (String)this.u.get("goodsDocument");
          if (ae.notNull((String)localObject))
          {
            localObject = (String)localObject + "生活费用有问题？立即驳回";
            ah.setTextColor(this.new_zz_livings_content, (String)localObject, ((String)localObject).length() - 4, 4);
          }
          return;
          this.new_zz_livings_list.setVisibility(8);
          this.new_zz_livings_text.setVisibility(0);
          this.new_zz_livings_text.setText("未获取到相关数据");
        }
      }
      this.new_zz_livings_list.setVisibility(8);
      this.new_zz_livings_text.setVisibility(0);
      this.new_zz_livings_text.setText("未获取到相关数据");
      return;
    }
    this.d = getIntent().getStringExtra("isSuccess");
    if (ae.notNull(this.d)) {
      this.new_zz_livings_btn.setVisibility(8);
    }
    this.v = getIntent().getStringExtra("contract_part_code");
    this.e = getIntent().getStringExtra("backRentOrderCode");
    this.f = getIntent().getStringExtra("loanState");
    this.g = getIntent().getStringExtra("gjPhone");
    this.r = (q.s + e.a.h);
    Object localObject = com.ziroom.ziroomcustomer.e.g.getViewPropertyExpendsUrl(this.e);
    j.getReservationOrderText(this.b, new a(), (Map)localObject, true, this.r);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(this.v))
    {
      d.SundHandleConfirm(this.K, this.v, paramString, paramInt);
      showProgress("");
      return;
    }
    showToast("获取不到合同编号");
  }
  
  private void b()
  {
    Object localObject = LayoutInflater.from(this.b).inflate(2130903785, null);
    Button localButton1 = (Button)((View)localObject).findViewById(2131692249);
    Button localButton2 = (Button)((View)localObject).findViewById(2131690460);
    this.D = new AlertDialog.Builder(this.b).create();
    this.D.setView((View)localObject, 0, 0, 0, 0);
    localObject = this.D;
    if (!(localObject instanceof AlertDialog)) {
      ((AlertDialog)localObject).show();
    }
    for (;;)
    {
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          NewZZLivingsActivity.a(NewZZLivingsActivity.this, "N", 69673);
        }
      });
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          NewZZLivingsActivity.g(NewZZLivingsActivity.this).dismiss();
        }
      });
      return;
      VdsAgent.showDialog((AlertDialog)localObject);
    }
  }
  
  private void d(String paramString)
  {
    if (ae.isNull(this.v))
    {
      showToast("合同号获取失败");
      return;
    }
    com.freelxl.baselibrary.d.a.isLog(true);
    paramString = com.ziroom.ziroomcustomer.e.g.buildSundHandleConfirm(this.v, paramString);
    com.freelxl.baselibrary.d.a.get(q.s + e.n.z).tag(this).params(ah.ConvertObjMap2String(paramString)).enqueue(new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        NewZZLivingsActivity.a(NewZZLivingsActivity.this, (String)paramAnonymouse.get("contract_state"));
        if ("2".equals(NewZZLivingsActivity.i(NewZZLivingsActivity.this).get("contractStrategy") + ""))
        {
          paramAnonymouse = new Intent(NewZZLivingsActivity.c(NewZZLivingsActivity.this), NewLeaseInfoActivity.class);
          paramAnonymouse.putExtra("contract_code", NewZZLivingsActivity.j(NewZZLivingsActivity.this));
          paramAnonymouse.putExtra("className", "NewZZLivingsActivity");
          NewZZLivingsActivity.this.startActivity(paramAnonymouse);
          NewZZLivingsActivity.this.finish();
          return;
        }
        if (ae.isNull(NewZZLivingsActivity.k(NewZZLivingsActivity.this)))
        {
          paramAnonymouse = new Intent(NewZZLivingsActivity.c(NewZZLivingsActivity.this).getApplicationContext(), HandleWaitToDoneActivity.class);
          paramAnonymouse.putExtra("pay_status", "yzf");
          paramAnonymouse.putExtra("contract_part_code", NewZZLivingsActivity.j(NewZZLivingsActivity.this));
          NewZZLivingsActivity.this.startActivity(paramAnonymouse);
          return;
        }
        NewZZLivingsActivity.this.finish();
      }
    });
  }
  
  @OnClick({2131691914, 2131697111, 2131690110, 2131697114})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      finish();
      return;
      if (ae.isNull(this.c))
      {
        d("Y");
        return;
      }
      paramView = new Intent(this.b, CostSettlementActivity.class);
      paramView.putExtra("backRentOrderCode", this.e);
      paramView.putExtra("loanState", this.f);
      paramView.putExtra("contractCode", this.v);
      startActivity(paramView);
      return;
      paramView = new Intent(this.b, MyStewardInfoActivity.class);
      paramView.putExtra("contractCode", this.v);
      startActivity(paramView);
      return;
    } while (-1 == this.new_zz_livings_content.getText().toString().indexOf("立即驳回"));
    b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904988);
    this.b = this;
    this.t = ButterKnife.bind(this);
    a();
    this.new_zz_livings_title.setFocusable(true);
    this.new_zz_livings_title.setFocusableInTouchMode(true);
    this.new_zz_livings_title.requestFocus();
  }
  
  public void showDialog(String paramString)
  {
    this.E = View.inflate(this.b, 2130905165, null);
    this.F = ((TextView)this.E.findViewById(2131697639));
    this.I = ((TextView)this.E.findViewById(2131697638));
    this.H = ((TextView)this.E.findViewById(2131697637));
    this.G = ((TextView)this.E.findViewById(2131697634));
    this.F.setOnClickListener(this.a);
    this.I.setOnClickListener(this.a);
    this.G.setVisibility(8);
    this.F.setVisibility(0);
    this.I.setVisibility(0);
    this.H.setGravity(17);
    this.H.setText(paramString);
    this.F.setText("我知道了");
    this.I.setVisibility(8);
    if (this.J == null)
    {
      this.J = new Dialog(this.b, 2131427781);
      this.J.setContentView(this.E);
      this.J.setCanceledOnTouchOutside(false);
      this.J.setCancelable(false);
      paramString = this.J;
      if ((paramString instanceof Dialog)) {
        break label254;
      }
      paramString.show();
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.base.ApplicationEx.g = 2;
      this.J.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          NewZZLivingsActivity.a(NewZZLivingsActivity.this, null);
          NewZZLivingsActivity.h(NewZZLivingsActivity.this).dismiss();
          NewZZLivingsActivity.a(NewZZLivingsActivity.this, null);
        }
      });
      return;
      label254:
      VdsAgent.showDialog((Dialog)paramString);
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        if (paramk.getUrl().equals(NewZZLivingsActivity.a(NewZZLivingsActivity.this)))
        {
          paramString = (com.ziroom.ziroomcustomer.termination.a.g)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), com.ziroom.ziroomcustomer.termination.a.g.class);
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(paramString);
        }
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue()) {
        if (paramk.getUrl().equals(NewZZLivingsActivity.a(NewZZLivingsActivity.this)))
        {
          NewZZLivingsActivity.a(NewZZLivingsActivity.this, (com.ziroom.ziroomcustomer.termination.a.g)paramk.getObject());
          if (NewZZLivingsActivity.b(NewZZLivingsActivity.this) == null) {
            break label382;
          }
          if (NewZZLivingsActivity.b(NewZZLivingsActivity.this).getExpendsList() == null) {
            break label292;
          }
          if (NewZZLivingsActivity.b(NewZZLivingsActivity.this).getExpendsList().size() <= 0) {
            break label254;
          }
          NewZZLivingsActivity.a(NewZZLivingsActivity.this, new NewZZLivingsAdapter(NewZZLivingsActivity.c(NewZZLivingsActivity.this), NewZZLivingsActivity.d(NewZZLivingsActivity.this), NewZZLivingsActivity.b(NewZZLivingsActivity.this).getExpendsList()));
          NewZZLivingsActivity.this.new_zz_livings_list.setAdapter(NewZZLivingsActivity.e(NewZZLivingsActivity.this));
          if (NewZZLivingsActivity.b(NewZZLivingsActivity.this).getTotalAccount() <= 0.0F) {
            break label367;
          }
          if (!ae.isNull(NewZZLivingsActivity.f(NewZZLivingsActivity.this))) {
            break label330;
          }
          paramk = "需赔付：" + NewZZLivingsActivity.b(NewZZLivingsActivity.this).getTotalAccount() + "元。如有疑问，联系管家。";
          label201:
          ah.setTextColor(NewZZLivingsActivity.this.new_zz_livings_content, paramk, 4, (NewZZLivingsActivity.b(NewZZLivingsActivity.this).getTotalAccount() + "").length() + 1);
        }
      }
      for (;;)
      {
        NewZZLivingsActivity.this.dismissProgress();
        return;
        label254:
        NewZZLivingsActivity.this.new_zz_livings_list.setVisibility(8);
        NewZZLivingsActivity.this.new_zz_livings_text.setVisibility(0);
        NewZZLivingsActivity.this.new_zz_livings_text.setText("未获取到相关数据");
        break;
        label292:
        NewZZLivingsActivity.this.new_zz_livings_list.setVisibility(8);
        NewZZLivingsActivity.this.new_zz_livings_text.setVisibility(0);
        NewZZLivingsActivity.this.new_zz_livings_text.setText("未获取到相关数据");
        break;
        label330:
        paramk = "已赔付:" + NewZZLivingsActivity.b(NewZZLivingsActivity.this).getTotalAccount() + "元。如有疑问，联系管家。";
        break label201;
        label367:
        NewZZLivingsActivity.this.new_zz_livings_content.setText("如有疑问，联系管家。");
        continue;
        label382:
        NewZZLivingsActivity.this.new_zz_livings_list.setVisibility(8);
        NewZZLivingsActivity.this.new_zz_livings_text.setVisibility(0);
        NewZZLivingsActivity.this.new_zz_livings_text.setText("未获取到相关数据");
        continue;
        paramk = paramk.getMessage();
        NewZZLivingsActivity.this.showToast(paramk);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/NewZZLivingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */