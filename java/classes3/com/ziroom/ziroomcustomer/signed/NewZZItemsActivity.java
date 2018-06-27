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
import com.ziroom.ziroomcustomer.model.GoodList;
import com.ziroom.ziroomcustomer.my.MyStewardInfoActivity;
import com.ziroom.ziroomcustomer.signed.adapter.NewZZItemsAdapter;
import com.ziroom.ziroomcustomer.termination.a.e;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewZZItemsActivity
  extends BaseActivity
{
  private Handler A = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      case 69672: 
      default: 
        return false;
      case 69671: 
        if (locall.getSuccess().booleanValue()) {
          if (locall.getObject() != null)
          {
            NewZZItemsActivity.a(NewZZItemsActivity.this, (HashMap)locall.getObject());
            NewZZItemsActivity.a(NewZZItemsActivity.this, (List)NewZZItemsActivity.h(NewZZItemsActivity.this).get("goodlist"));
            if (NewZZItemsActivity.i(NewZZItemsActivity.this) != null)
            {
              NewZZItemsActivity.a(NewZZItemsActivity.this, new NewZZItemsAdapter(NewZZItemsActivity.c(NewZZItemsActivity.this), NewZZItemsActivity.i(NewZZItemsActivity.this)));
              NewZZItemsActivity.this.new_zz_items_list.setAdapter(NewZZItemsActivity.e(NewZZItemsActivity.this));
              NewZZItemsActivity.this.new_zz_items_text.setVisibility(8);
              NewZZItemsActivity.this.new_zz_items_list.setVisibility(0);
              paramAnonymousMessage = (String)NewZZItemsActivity.h(NewZZItemsActivity.this).get("goodsDocument");
              if (ae.notNull(paramAnonymousMessage))
              {
                paramAnonymousMessage = paramAnonymousMessage + "配置物品有问题？立即驳回";
                ah.setTextColor(NewZZItemsActivity.this.new_zz_items_content, paramAnonymousMessage, paramAnonymousMessage.length() - 4, 4);
              }
            }
          }
        }
        for (;;)
        {
          NewZZItemsActivity.this.dismissProgress();
          return false;
          NewZZItemsActivity.this.new_zz_items_text.setText("未获取到相关数据");
          NewZZItemsActivity.this.new_zz_items_text.setVisibility(0);
          NewZZItemsActivity.this.new_zz_items_list.setVisibility(8);
          break;
          NewZZItemsActivity.this.new_zz_items_text.setText("未获取到相关数据");
          NewZZItemsActivity.this.new_zz_items_text.setVisibility(0);
          NewZZItemsActivity.this.new_zz_items_list.setVisibility(8);
          continue;
          NewZZItemsActivity.this.showToast(locall.getMessage());
        }
      }
      if (locall.getSuccess().booleanValue())
      {
        com.freelxl.baselibrary.f.g.textToast(NewZZItemsActivity.c(NewZZItemsActivity.this), NewZZItemsActivity.this.getString(2131297496), 1);
        NewZZItemsActivity.this.finish();
      }
      for (;;)
      {
        NewZZItemsActivity.g(NewZZItemsActivity.this).dismiss();
        NewZZItemsActivity.this.dismissProgress();
        return false;
        NewZZItemsActivity.this.showDialog(locall.getMessage());
      }
    }
  });
  private View B;
  private TextView C;
  private TextView D;
  private TextView E;
  private TextView F;
  private Dialog G;
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
      NewZZItemsActivity.j(NewZZItemsActivity.this).dismiss();
    }
  };
  private Context b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  @BindView(2131697092)
  Button new_zz_items_btn;
  @BindView(2131697095)
  TextView new_zz_items_content;
  @BindView(2131697097)
  ListViewForScrollView new_zz_items_list;
  @BindView(2131697093)
  ScrollView new_zz_items_scroll;
  @BindView(2131697096)
  TextView new_zz_items_text;
  @BindView(2131697094)
  TextView new_zz_items_title;
  private String r;
  private Unbinder s;
  private HashMap<String, Object> t;
  private String u;
  private String v;
  private List<GoodList> w;
  private e x;
  private NewZZItemsAdapter y;
  private AlertDialog z;
  
  private void a()
  {
    this.c = getIntent().getStringExtra("isTermination");
    if (ae.isNull(this.c))
    {
      this.t = ((HashMap)getIntent().getSerializableExtra("bts_map"));
      this.u = getIntent().getStringExtra("contract_part_code");
      this.v = getIntent().getStringExtra("leas");
      if (this.t != null)
      {
        this.w = ((List)this.t.get("goodlist"));
        if (this.w != null)
        {
          this.y = new NewZZItemsAdapter(this.b, this.w);
          this.new_zz_items_list.setAdapter(this.y);
          this.new_zz_items_text.setVisibility(8);
          this.new_zz_items_list.setVisibility(0);
        }
        for (;;)
        {
          localObject = (String)this.t.get("goodsDocument");
          if (ae.notNull((String)localObject))
          {
            localObject = (String)localObject + "配置物品有问题？立即驳回";
            ah.setTextColor(this.new_zz_items_content, (String)localObject, ((String)localObject).length() - 4, 4);
          }
          return;
          this.new_zz_items_text.setText("未获取到相关数据");
          this.new_zz_items_text.setVisibility(0);
          this.new_zz_items_list.setVisibility(8);
        }
      }
      b();
      return;
    }
    this.d = getIntent().getStringExtra("isSuccess");
    if (ae.notNull(this.d)) {
      this.new_zz_items_btn.setVisibility(8);
    }
    this.u = getIntent().getStringExtra("contractCode");
    this.e = getIntent().getStringExtra("backRentOrderCode");
    this.f = getIntent().getStringExtra("loanState");
    this.g = getIntent().getStringExtra("gjPhone");
    this.r = (q.s + e.a.f);
    Object localObject = com.ziroom.ziroomcustomer.e.g.getViewPropertyGoosUrl(this.u, this.e);
    j.getReservationOrderText(this.b, new a(), (Map)localObject, true, this.r);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(this.u))
    {
      d.SundHandleConfirm(this.A, this.u, paramString, paramInt);
      showProgress("");
      return;
    }
    showToast("获取不到合同编号");
  }
  
  private void b()
  {
    d.getSundHandleList(this.A, this.u);
    showProgress("");
  }
  
  private void e()
  {
    Object localObject = LayoutInflater.from(this.b).inflate(2130903785, null);
    Button localButton1 = (Button)((View)localObject).findViewById(2131692249);
    Button localButton2 = (Button)((View)localObject).findViewById(2131690460);
    this.z = new AlertDialog.Builder(this.b).create();
    this.z.setView((View)localObject, 0, 0, 0, 0);
    localObject = this.z;
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
          NewZZItemsActivity.a(NewZZItemsActivity.this, "N", 69673);
        }
      });
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          NewZZItemsActivity.g(NewZZItemsActivity.this).dismiss();
        }
      });
      return;
      VdsAgent.showDialog((AlertDialog)localObject);
    }
  }
  
  @OnClick({2131691914, 2131697092, 2131690110, 2131697095})
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
      paramView = new Intent(this, NewZZKeysActivity.class);
      paramView.putExtra("contract_part_code", this.u);
      paramView.putExtra("isTermination", this.c);
      if (ae.isNull(this.c))
      {
        paramView.putExtra("bts_map", this.t);
        paramView.putExtra("leas", this.v);
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
      paramView.putExtra("contractCode", this.u);
      startActivity(paramView);
      return;
    } while (-1 == this.new_zz_items_content.getText().toString().indexOf("立即驳回"));
    e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904983);
    this.b = this;
    this.s = ButterKnife.bind(this);
    a();
    this.new_zz_items_title.setFocusable(true);
    this.new_zz_items_title.setFocusableInTouchMode(true);
    this.new_zz_items_title.requestFocus();
  }
  
  public void showDialog(String paramString)
  {
    this.B = View.inflate(this.b, 2130905165, null);
    this.C = ((TextView)this.B.findViewById(2131697639));
    this.F = ((TextView)this.B.findViewById(2131697638));
    this.E = ((TextView)this.B.findViewById(2131697637));
    this.D = ((TextView)this.B.findViewById(2131697634));
    this.C.setOnClickListener(this.a);
    this.F.setOnClickListener(this.a);
    this.D.setVisibility(8);
    this.C.setVisibility(0);
    this.F.setVisibility(0);
    this.E.setGravity(17);
    this.E.setText(paramString);
    this.C.setText("我知道了");
    this.F.setVisibility(8);
    if (this.G == null)
    {
      this.G = new Dialog(this.b, 2131427781);
      this.G.setContentView(this.B);
      this.G.setCanceledOnTouchOutside(false);
      this.G.setCancelable(false);
      paramString = this.G;
      if ((paramString instanceof Dialog)) {
        break label254;
      }
      paramString.show();
    }
    for (;;)
    {
      ApplicationEx.g = 2;
      this.G.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          NewZZItemsActivity.a(NewZZItemsActivity.this, null);
          NewZZItemsActivity.j(NewZZItemsActivity.this).dismiss();
          NewZZItemsActivity.a(NewZZItemsActivity.this, null);
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
        if (paramk.getUrl().equals(NewZZItemsActivity.a(NewZZItemsActivity.this)))
        {
          paramString = (e)a.parseObject(paramString.get("data").toString(), e.class);
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
        if (paramk.getUrl().equals(NewZZItemsActivity.a(NewZZItemsActivity.this)))
        {
          NewZZItemsActivity.a(NewZZItemsActivity.this, (e)paramk.getObject());
          if (NewZZItemsActivity.b(NewZZItemsActivity.this) == null) {
            break label382;
          }
          if (NewZZItemsActivity.b(NewZZItemsActivity.this).getGoodsList() == null) {
            break label292;
          }
          if (NewZZItemsActivity.b(NewZZItemsActivity.this).getGoodsList().size() <= 0) {
            break label254;
          }
          NewZZItemsActivity.a(NewZZItemsActivity.this, new NewZZItemsAdapter(NewZZItemsActivity.c(NewZZItemsActivity.this), NewZZItemsActivity.b(NewZZItemsActivity.this).getGoodsList(), NewZZItemsActivity.d(NewZZItemsActivity.this)));
          NewZZItemsActivity.this.new_zz_items_list.setAdapter(NewZZItemsActivity.e(NewZZItemsActivity.this));
          if (NewZZItemsActivity.b(NewZZItemsActivity.this).getTotalAccount() <= 0.0F) {
            break label367;
          }
          if (!ae.isNull(NewZZItemsActivity.f(NewZZItemsActivity.this))) {
            break label330;
          }
          paramk = "需赔付：" + NewZZItemsActivity.b(NewZZItemsActivity.this).getTotalAccount() + "元。如有疑问，联系管家。";
          label201:
          ah.setTextColor(NewZZItemsActivity.this.new_zz_items_content, paramk, 4, (NewZZItemsActivity.b(NewZZItemsActivity.this).getTotalAccount() + "").length() + 1);
        }
      }
      for (;;)
      {
        NewZZItemsActivity.this.dismissProgress();
        return;
        label254:
        NewZZItemsActivity.this.new_zz_items_text.setText("未获取到相关数据");
        NewZZItemsActivity.this.new_zz_items_text.setVisibility(0);
        NewZZItemsActivity.this.new_zz_items_list.setVisibility(8);
        break;
        label292:
        NewZZItemsActivity.this.new_zz_items_text.setText("未获取到相关数据");
        NewZZItemsActivity.this.new_zz_items_text.setVisibility(0);
        NewZZItemsActivity.this.new_zz_items_list.setVisibility(8);
        break;
        label330:
        paramk = "已赔付：" + NewZZItemsActivity.b(NewZZItemsActivity.this).getTotalAccount() + "元。如有疑问，联系管家。";
        break label201;
        label367:
        NewZZItemsActivity.this.new_zz_items_content.setText("如有疑问，联系管家。");
        continue;
        label382:
        NewZZItemsActivity.this.new_zz_items_text.setText("未获取到相关数据");
        NewZZItemsActivity.this.new_zz_items_text.setVisibility(0);
        NewZZItemsActivity.this.new_zz_items_list.setVisibility(8);
        continue;
        paramk = paramk.getMessage();
        NewZZItemsActivity.this.showToast(paramk);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/NewZZItemsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */