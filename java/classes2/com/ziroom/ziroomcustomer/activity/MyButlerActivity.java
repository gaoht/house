package com.ziroom.ziroomcustomer.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.d;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.r;
import com.ziroom.ziroomcustomer.util.r.a;
import java.util.List;
import java.util.Map;

public class MyButlerActivity
  extends BaseActivity
  implements View.OnClickListener
{
  Handler a = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
        MyButlerActivity.this.dismissProgress();
      } while (!locall.getSuccess().booleanValue());
      MyButlerActivity.a(MyButlerActivity.this, (List)locall.getObject());
      if ((MyButlerActivity.a(MyButlerActivity.this) != null) && (MyButlerActivity.a(MyButlerActivity.this).size() > 1)) {
        MyButlerActivity.b(MyButlerActivity.this).setVisibility(0);
      }
      while ((MyButlerActivity.a(MyButlerActivity.this) != null) && (MyButlerActivity.a(MyButlerActivity.this).size() > 0))
      {
        ApplicationEx.c.setContracts(MyButlerActivity.a(MyButlerActivity.this));
        j.getContactHousekeeper(MyButlerActivity.this, new MyButlerActivity.a(MyButlerActivity.this), ((Contract)MyButlerActivity.a(MyButlerActivity.this).get(0)).getContract_code(), true);
        return;
        MyButlerActivity.b(MyButlerActivity.this).setVisibility(8);
      }
      MyButlerActivity.c(MyButlerActivity.this);
    }
  };
  private List<Contract> b;
  private ImageView c;
  private TextView d;
  private Button e;
  private String f;
  private String g = "";
  private String r;
  private UserInfo s;
  private ApplicationEx t;
  private Dialog u;
  private int v;
  private TextView w;
  private com.ziroom.ziroomcustomer.adapter.b x;
  
  private void a()
  {
    findViewById(2131696944).setVisibility(4);
    findViewById(2131696943).setVisibility(0);
  }
  
  private void b()
  {
    this.c = ((ImageView)findViewById(2131696945));
    this.d = ((TextView)findViewById(2131696946));
    this.e = ((Button)findViewById(2131696948));
    this.w.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void d(final String paramString)
  {
    View localView = LayoutInflater.from(this).inflate(2130903834, null);
    TextView localTextView = (TextView)localView.findViewById(2131689850);
    Button localButton1 = (Button)localView.findViewById(2131692249);
    Button localButton2 = (Button)localView.findViewById(2131690460);
    final AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.setView(localView, 0, 0, 0, 0);
    if (!(localAlertDialog instanceof AlertDialog)) {
      localAlertDialog.show();
    }
    for (;;)
    {
      localTextView.setText("确认要拨打" + paramString + "吗?");
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          localAlertDialog.dismiss();
          paramAnonymousView = new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramString));
          MyButlerActivity.this.startActivity(paramAnonymousView);
        }
      });
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          localAlertDialog.dismiss();
        }
      });
      return;
      VdsAgent.showDialog((AlertDialog)localAlertDialog);
    }
  }
  
  private void e()
  {
    r localr = new r();
    String str = q.d + e.d.e;
    str = str + this.r + ".png";
    localr.getImageBitmap(this.c, str, new r.a()
    {
      public void loadDefaultImage(ImageView paramAnonymousImageView) {}
      
      public void loadImage(ImageView paramAnonymousImageView, final Bitmap paramAnonymousBitmap)
      {
        MyButlerActivity.this.a.post(new Runnable()
        {
          public void run()
          {
            MyButlerActivity.d(MyButlerActivity.this).setBackgroundDrawable(new BitmapDrawable(paramAnonymousBitmap));
          }
        });
      }
    });
    if (!TextUtils.isEmpty(this.f)) {
      this.d.setText("管家  " + this.f);
    }
  }
  
  private void f()
  {
    this.u = new Dialog(this, 2131427692);
    Object localObject1 = getLayoutInflater().inflate(2130903804, null);
    Object localObject2 = (ListView)((View)localObject1).findViewById(2131693805);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131691288);
    ((ListView)localObject2).setDivider(new ColorDrawable(Color.parseColor("#E6E6E6")));
    ((ListView)localObject2).setDividerHeight(n.dip2px(this, 0.5F));
    this.x = new com.ziroom.ziroomcustomer.adapter.b(this, this.b);
    this.x.setCurLockRoomContract(this.v);
    ((ListView)localObject2).setAdapter(this.x);
    ((ListView)localObject2).setSelection(this.v);
    ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MyButlerActivity.e(MyButlerActivity.this).dismiss();
      }
    });
    int i = n.dip2px(this, 48.0F);
    if ((this.b != null) && (this.b.size() >= 3)) {
      i *= 3;
    }
    for (;;)
    {
      if ((this.b != null) && (this.b.size() >= 2)) {
        ((ListView)localObject2).setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          @Instrumented
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            MyButlerActivity.a(MyButlerActivity.this, paramAnonymousInt);
            MyButlerActivity.e(MyButlerActivity.this).dismiss();
            MyButlerActivity.f(MyButlerActivity.this).setCurLockRoomContract(paramAnonymousInt);
            j.getContactHousekeeper(MyButlerActivity.this, new MyButlerActivity.a(MyButlerActivity.this), ((Contract)MyButlerActivity.a(MyButlerActivity.this).get(paramAnonymousInt)).getContract_code(), true);
          }
        });
      }
      localObject3 = ((ListView)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = -1;
      ((ViewGroup.LayoutParams)localObject3).height = i;
      ((ListView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject2 = this.u.getWindow();
      ((Window)localObject2).getDecorView().setPadding(0, 0, 0, 0);
      localObject3 = ((Window)localObject2).getAttributes();
      ((WindowManager.LayoutParams)localObject3).width = -1;
      ((WindowManager.LayoutParams)localObject3).height = -2;
      ((Window)localObject2).setAttributes((WindowManager.LayoutParams)localObject3);
      ((Window)localObject2).getDecorView().setBackgroundColor(Color.parseColor("#FFFFFFFF"));
      ((Window)localObject2).setGravity(80);
      this.u.getWindow().setContentView((View)localObject1);
      localObject1 = this.u;
      if ((localObject1 instanceof Dialog)) {
        break;
      }
      ((Dialog)localObject1).show();
      return;
      i = -2;
    }
    VdsAgent.showDialog((Dialog)localObject1);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131696948: 
      d(this.g);
      return;
    case 2131689895: 
      finish();
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904948);
    this.t = ((ApplicationEx)getApplication());
    this.s = this.t.getUser();
    findViewById(2131689895).setOnClickListener(this);
    this.w = ((TextView)findViewById(2131696942));
    this.f = getIntent().getStringExtra("hire_commissioner_name");
    this.g = getIntent().getStringExtra("hire_commissioner_phone");
    this.r = getIntent().getStringExtra("hire_contract_code");
    b();
    if ((this.s != null) && (ae.notNull(this.g)))
    {
      e();
      return;
    }
    if (this.s != null)
    {
      this.b = ApplicationEx.c.getContracts();
      if ((this.b != null) && (this.b.size() > 1)) {
        this.w.setVisibility(0);
      }
      while ((this.b != null) && (this.b.size() > 0))
      {
        ApplicationEx.c.setContracts(this.b);
        j.getContactHousekeeper(this, new a(), ((Contract)this.b.get(0)).getContract_code(), true);
        return;
        this.w.setVisibility(8);
      }
      showProgress("");
      j.getContract(this, this.a, this.s.getUid());
      return;
    }
    a();
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
        paramString = a.parseObject(paramString.get("data").toString());
        paramk.setObject(new b(paramString.getString("hire_contract_code"), paramString.getString("hire_commissioner_name"), paramString.getString("hire_commissioner_phone")));
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (b)paramk.getObject();
        if (ae.notNull(paramk.getHire_commissioner_phone()))
        {
          MyButlerActivity.a(MyButlerActivity.this, paramk.getHire_commissioner_name());
          MyButlerActivity.b(MyButlerActivity.this, paramk.getHire_commissioner_phone());
          MyButlerActivity.c(MyButlerActivity.this, paramk.getHire_contract_code());
          MyButlerActivity.g(MyButlerActivity.this);
          return;
        }
        MyButlerActivity.c(MyButlerActivity.this);
        ((TextView)MyButlerActivity.this.findViewById(2131696943)).setText("获取管家联系方式失败");
        return;
      }
      paramk = paramk.getMessage();
      MyButlerActivity.c(MyButlerActivity.this);
      ((TextView)MyButlerActivity.this.findViewById(2131696943)).setText(paramk);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/MyButlerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */