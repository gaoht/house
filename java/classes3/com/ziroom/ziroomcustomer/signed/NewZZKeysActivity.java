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
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.e.a;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.KeyCards;
import com.ziroom.ziroomcustomer.my.MyStewardInfoActivity;
import com.ziroom.ziroomcustomer.signed.adapter.NewZZKeysAdapter;
import com.ziroom.ziroomcustomer.termination.a.i;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewZZKeysActivity
  extends BaseActivity
{
  private AlertDialog A;
  private Handler B = new Handler(new Handler.Callback()
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
        com.freelxl.baselibrary.f.g.textToast(NewZZKeysActivity.c(NewZZKeysActivity.this), NewZZKeysActivity.this.getString(2131297496), 1);
        NewZZKeysActivity.this.finish();
      }
      for (;;)
      {
        NewZZKeysActivity.g(NewZZKeysActivity.this).dismiss();
        NewZZKeysActivity.this.dismissProgress();
        break;
        NewZZKeysActivity.this.showDialog(locall.getMessage());
      }
    }
  });
  private View C;
  private TextView D;
  private TextView E;
  private TextView F;
  private TextView G;
  private Dialog H;
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
      NewZZKeysActivity.h(NewZZKeysActivity.this).dismiss();
    }
  };
  private Context b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  @BindView(2131697102)
  Button new_zz_keys_btn;
  @BindView(2131697105)
  TextView new_zz_keys_content;
  @BindView(2131697107)
  ListViewForScrollView new_zz_keys_list;
  @BindView(2131697103)
  ScrollView new_zz_keys_scroll;
  @BindView(2131697106)
  TextView new_zz_keys_text;
  @BindView(2131697104)
  TextView new_zz_keys_title;
  private String r;
  private i s = new i();
  private Unbinder t;
  private HashMap<String, Object> u;
  private String v;
  private String w;
  private String x;
  private List<KeyCards> y;
  private NewZZKeysAdapter z;
  
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
        this.y = ((List)this.u.get("keycardslist"));
        this.x = ((String)this.u.get("keyDocument"));
        if (this.y == null) {
          break label236;
        }
        this.z = new NewZZKeysAdapter(this.b, this.y);
        this.new_zz_keys_list.setAdapter(this.z);
        this.new_zz_keys_list.setVisibility(0);
        this.new_zz_keys_text.setVisibility(8);
      }
      for (;;)
      {
        if (ae.notNull(this.x))
        {
          localObject = this.x + "钥匙门卡有问题？立即驳回";
          ah.setTextColor(this.new_zz_keys_content, (String)localObject, ((String)localObject).length() - 4, 4);
        }
        return;
        this.new_zz_keys_list.setVisibility(8);
        this.new_zz_keys_text.setVisibility(0);
        this.new_zz_keys_text.setText("未获取到相关数据");
        break;
        label236:
        this.new_zz_keys_list.setVisibility(8);
        this.new_zz_keys_text.setVisibility(0);
        this.new_zz_keys_text.setText("未获取到相关数据");
      }
    }
    this.d = getIntent().getStringExtra("isSuccess");
    if (ae.notNull(this.d)) {
      this.new_zz_keys_btn.setVisibility(8);
    }
    this.v = getIntent().getStringExtra("contract_part_code");
    this.e = getIntent().getStringExtra("backRentOrderCode");
    this.f = getIntent().getStringExtra("loanState");
    this.g = getIntent().getStringExtra("gjPhone");
    this.r = (q.s + e.a.g);
    Object localObject = com.ziroom.ziroomcustomer.e.g.getViewPropertyKeyUrl(this.e);
    j.getReservationOrderText(this.b, new a(), (Map)localObject, true, this.r);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(this.v))
    {
      d.SundHandleConfirm(this.B, this.v, paramString, paramInt);
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
    this.A = new AlertDialog.Builder(this.b).create();
    this.A.setView((View)localObject, 0, 0, 0, 0);
    localObject = this.A;
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
          NewZZKeysActivity.a(NewZZKeysActivity.this, "N", 69673);
        }
      });
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          NewZZKeysActivity.g(NewZZKeysActivity.this).dismiss();
        }
      });
      return;
      VdsAgent.showDialog((AlertDialog)localObject);
    }
  }
  
  @OnClick({2131691914, 2131697102, 2131690110, 2131697105})
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
      paramView = new Intent(this, NewZZLivingsActivity.class);
      paramView.putExtra("contract_part_code", this.v);
      paramView.putExtra("isTermination", this.c);
      if (ae.isNull(this.c))
      {
        paramView.putExtra("bts_map", this.u);
        paramView.putExtra("leas", this.w);
      }
      for (;;)
      {
        startActivity(paramView);
        ApplicationEx.c.addActivity(this);
        return;
        paramView.putExtra("backRentOrderCode", this.e);
        paramView.putExtra("loanState", this.f);
        paramView.putExtra("gjPhone", this.g);
      }
      paramView = new Intent(this.b, MyStewardInfoActivity.class);
      paramView.putExtra("contractCode", this.v);
      startActivity(paramView);
      return;
    } while (-1 == this.new_zz_keys_content.getText().toString().indexOf("立即驳回"));
    b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904986);
    this.b = this;
    this.t = ButterKnife.bind(this);
    a();
    this.new_zz_keys_title.setFocusable(true);
    this.new_zz_keys_title.setFocusableInTouchMode(true);
    this.new_zz_keys_title.requestFocus();
  }
  
  public void showDialog(String paramString)
  {
    this.C = View.inflate(this.b, 2130905165, null);
    this.D = ((TextView)this.C.findViewById(2131697639));
    this.G = ((TextView)this.C.findViewById(2131697638));
    this.F = ((TextView)this.C.findViewById(2131697637));
    this.E = ((TextView)this.C.findViewById(2131697634));
    this.D.setOnClickListener(this.a);
    this.G.setOnClickListener(this.a);
    this.E.setVisibility(8);
    this.D.setVisibility(0);
    this.G.setVisibility(0);
    this.F.setGravity(17);
    this.F.setText(paramString);
    this.D.setText("我知道了");
    this.G.setVisibility(8);
    if (this.H == null)
    {
      this.H = new Dialog(this.b, 2131427781);
      this.H.setContentView(this.C);
      this.H.setCanceledOnTouchOutside(false);
      this.H.setCancelable(false);
      paramString = this.H;
      if ((paramString instanceof Dialog)) {
        break label254;
      }
      paramString.show();
    }
    for (;;)
    {
      ApplicationEx.g = 2;
      this.H.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          NewZZKeysActivity.a(NewZZKeysActivity.this, null);
          NewZZKeysActivity.h(NewZZKeysActivity.this).dismiss();
          NewZZKeysActivity.a(NewZZKeysActivity.this, null);
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
      paramString = a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        if (paramk.getUrl().equals(NewZZKeysActivity.a(NewZZKeysActivity.this)))
        {
          paramString = (i)a.parseObject(paramString.get("data").toString(), i.class);
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
        if (paramk.getUrl().equals(NewZZKeysActivity.a(NewZZKeysActivity.this)))
        {
          NewZZKeysActivity.a(NewZZKeysActivity.this, (i)paramk.getObject());
          if (NewZZKeysActivity.b(NewZZKeysActivity.this) == null) {
            break label330;
          }
          if (NewZZKeysActivity.b(NewZZKeysActivity.this).getKeyCardsList() == null) {
            break label292;
          }
          if (NewZZKeysActivity.b(NewZZKeysActivity.this).getKeyCardsList().size() > 0)
          {
            NewZZKeysActivity.a(NewZZKeysActivity.this, new NewZZKeysAdapter(NewZZKeysActivity.c(NewZZKeysActivity.this), NewZZKeysActivity.b(NewZZKeysActivity.this).getKeyCardsList(), NewZZKeysActivity.d(NewZZKeysActivity.this)));
            NewZZKeysActivity.this.new_zz_keys_list.setAdapter(NewZZKeysActivity.e(NewZZKeysActivity.this));
          }
        }
        else
        {
          if (NewZZKeysActivity.b(NewZZKeysActivity.this).getTotalAccount() <= 0.0F) {
            break label405;
          }
          if (!ae.isNull(NewZZKeysActivity.f(NewZZKeysActivity.this))) {
            break label368;
          }
          paramk = "需赔付：" + NewZZKeysActivity.b(NewZZKeysActivity.this).getTotalAccount() + "元。如有疑问，联系管家。";
          label201:
          ah.setTextColor(NewZZKeysActivity.this.new_zz_keys_content, paramk, 4, (NewZZKeysActivity.b(NewZZKeysActivity.this).getTotalAccount() + "").length() + 1);
        }
      }
      for (;;)
      {
        NewZZKeysActivity.this.dismissProgress();
        return;
        NewZZKeysActivity.this.new_zz_keys_list.setVisibility(8);
        NewZZKeysActivity.this.new_zz_keys_text.setVisibility(0);
        NewZZKeysActivity.this.new_zz_keys_text.setText("未获取到相关数据");
        break;
        label292:
        NewZZKeysActivity.this.new_zz_keys_list.setVisibility(8);
        NewZZKeysActivity.this.new_zz_keys_text.setVisibility(0);
        NewZZKeysActivity.this.new_zz_keys_text.setText("未获取到相关数据");
        break;
        label330:
        NewZZKeysActivity.this.new_zz_keys_list.setVisibility(8);
        NewZZKeysActivity.this.new_zz_keys_text.setVisibility(0);
        NewZZKeysActivity.this.new_zz_keys_text.setText("未获取到相关数据");
        break;
        label368:
        paramk = "已赔付：" + NewZZKeysActivity.b(NewZZKeysActivity.this).getTotalAccount() + "元。如有疑问，联系管家。";
        break label201;
        label405:
        NewZZKeysActivity.this.new_zz_keys_content.setText("如有疑问，联系管家。");
        continue;
        paramk = paramk.getMessage();
        NewZZKeysActivity.this.showToast(paramk);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/NewZZKeysActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */