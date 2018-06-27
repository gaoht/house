package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.MobSDK;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.home.MainFragmentActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ZxingActivity
  extends BaseActivity
{
  private String A;
  private boolean B = false;
  private Handler C = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return false;
      }
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue())
      {
        if (paramAnonymousMessage.getObject() != null)
        {
          ZxingActivity.a(ZxingActivity.this, (HashMap)paramAnonymousMessage.getObject());
          Log.e("wuyejiaoge", "ZxingActivity--handler---Success  sunHandMap== " + ZxingActivity.j(ZxingActivity.this).size());
        }
        if (("5".equals(ZxingActivity.j(ZxingActivity.this).get("house_type") + "")) || ("8".equals(ZxingActivity.j(ZxingActivity.this).get("house_type") + "")))
        {
          ZxingActivity.a(ZxingActivity.this, new Intent(ZxingActivity.this, NewZZItemsActivity.class));
          label197:
          ZxingActivity.k(ZxingActivity.this).putExtra("wuyesure", "wuyesure");
          ZxingActivity.k(ZxingActivity.this).putExtra("contract_part_code", ZxingActivity.a(ZxingActivity.this));
          ZxingActivity.k(ZxingActivity.this).putExtra("bts_map", ZxingActivity.j(ZxingActivity.this));
          ZxingActivity.k(ZxingActivity.this).putExtra("leas", ZxingActivity.l(ZxingActivity.this));
          ZxingActivity.this.startActivity(ZxingActivity.k(ZxingActivity.this));
          new ApplicationEx().addActivity(ZxingActivity.this);
        }
      }
      for (;;)
      {
        ZxingActivity.this.dismissProgress();
        break;
        ZxingActivity.a(ZxingActivity.this, new Intent(ZxingActivity.this, MainFragmentActivity.class));
        break label197;
        Log.e("wuyejiaoge", "status is failure");
        ZxingActivity.this.showToast(paramAnonymousMessage.getMessage());
        ZxingActivity.a(ZxingActivity.this, new Intent(ZxingActivity.this, WaitDeliveryActivity.class));
        ZxingActivity.k(ZxingActivity.this).putExtra("wuyewaitdone", "wuyewaitdone");
        ZxingActivity.k(ZxingActivity.this).putExtra("contract_part_code", ZxingActivity.a(ZxingActivity.this));
        ZxingActivity.k(ZxingActivity.this).putExtra("lease", ZxingActivity.l(ZxingActivity.this));
        ZxingActivity.this.startActivity(ZxingActivity.k(ZxingActivity.this));
        new ApplicationEx().addActivity(ZxingActivity.this);
      }
    }
  });
  protected boolean a = false;
  View.OnClickListener b = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 2131693051: 
        if (!TextUtils.isEmpty(ZxingActivity.a(ZxingActivity.this)))
        {
          ZxingActivity.e(ZxingActivity.this);
          return;
        }
        ZxingActivity.this.showToast("获取不到合同号");
        return;
      case 2131693050: 
        if (ae.isNull(ZxingActivity.f(ZxingActivity.this)))
        {
          ZxingActivity.h(ZxingActivity.this).post(new Runnable()
          {
            public void run()
            {
              ZxingActivity.this.saveImageToGallery(ZxingActivity.g(ZxingActivity.this), ZxingActivity.this.createViewBitmap(ZxingActivity.h(ZxingActivity.this)));
              if (ae.notNull(ZxingActivity.f(ZxingActivity.this))) {
                ZxingActivity.a(ZxingActivity.this, ZxingActivity.f(ZxingActivity.this));
              }
            }
          });
          return;
        }
        ZxingActivity.a(ZxingActivity.this, ZxingActivity.f(ZxingActivity.this));
        return;
      case 2131692624: 
        ZxingActivity.i(ZxingActivity.this);
        return;
      }
      paramAnonymousView = new Intent(ZxingActivity.g(ZxingActivity.this), MainActivity.class);
      paramAnonymousView.putExtra("FRAGMENT_TYPE", 7);
      ZxingActivity.this.startActivity(paramAnonymousView);
      ZxingActivity.this.finish();
    }
  };
  private Context c;
  private ImageView d;
  private ImageView e;
  private TextView f;
  private Button g;
  private Button r;
  private ImageView s;
  private LinearLayout t;
  private String u;
  private Intent v;
  private HashMap<String, Object> w;
  private String x;
  private String y;
  private IWXAPI z;
  
  private void a()
  {
    Map localMap = com.ziroom.ziroomcustomer.e.g.buildCheckScan(this.u);
    com.freelxl.baselibrary.f.d.e("url", com.ziroom.ziroomcustomer.e.q.s + e.n.Z + localMap.toString());
    com.freelxl.baselibrary.d.a.isLog(true);
    com.freelxl.baselibrary.d.a.post(com.ziroom.ziroomcustomer.e.q.s + e.n.Z).params(ah.ConvertObjMap2String(localMap)).tag(this).enqueue(new com.ziroom.commonlibrary.a.a(this.c, new com.freelxl.baselibrary.d.f.c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
        u.e("LeaseHistoryLivingActivity", paramAnonymousThrowable.getMessage() + "");
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        com.freelxl.baselibrary.f.d.e("jsonObject", paramAnonymouse.toJSONString());
        if ("success".equals(paramAnonymouse.get("status")))
        {
          paramAnonymouse = com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data").toString());
          if (paramAnonymouse.getInteger("isScan").intValue() != 1) {
            break label125;
          }
          if (TextUtils.isEmpty(ZxingActivity.a(ZxingActivity.this))) {
            break label113;
          }
          ZxingActivity.b(ZxingActivity.this);
          if (!ae.notNull(paramAnonymouse.getString("lastScanTimeDesc"))) {
            break label159;
          }
          ZxingActivity.d(ZxingActivity.this).setVisibility(0);
          ZxingActivity.d(ZxingActivity.this).setText(paramAnonymouse.getString("lastScanTimeDesc"));
        }
        for (;;)
        {
          dismissProgress();
          return;
          label113:
          ZxingActivity.this.showToast("获取不到合同编号");
          break;
          label125:
          if (!ZxingActivity.c(ZxingActivity.this))
          {
            ZxingActivity.a(ZxingActivity.this, true);
            break;
          }
          ZxingActivity.this.showToast("抱歉，管家还没扫码哦～");
          break;
          label159:
          ZxingActivity.d(ZxingActivity.this).setVisibility(8);
        }
      }
    });
  }
  
  private void b()
  {
    if ("myziroom".equals(this.A))
    {
      Intent localIntent = new Intent(this, MainActivity.class);
      localIntent.putExtra("FRAGMENT_TYPE", 7);
      startActivity(localIntent);
      finish();
      return;
    }
    finish();
  }
  
  private void d(String paramString)
  {
    if (!this.z.isWXAppInstalled())
    {
      showToast("暂时只支持微信分享，请下载微信或者截图发给管家哦~");
      return;
    }
    Object localObject = new WXImageObject();
    ((WXImageObject)localObject).setImagePath(paramString);
    paramString = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
    paramString.title = null;
    paramString.description = null;
    localObject = new SendMessageToWX.Req();
    ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
    ((SendMessageToWX.Req)localObject).message = paramString;
    this.z.sendReq((BaseReq)localObject);
  }
  
  private void e()
  {
    this.f = ((TextView)findViewById(2131693048));
    this.t = ((LinearLayout)findViewById(2131693052));
    this.d = ((ImageView)findViewById(2131693049));
    this.e = ((ImageView)findViewById(2131693054));
    this.g = ((Button)findViewById(2131693051));
    this.r = ((Button)findViewById(2131693050));
    this.s = ((ImageView)findViewById(2131692624));
    this.u = getIntent().getStringExtra("contract_part_code");
    this.A = getIntent().getStringExtra("isMyZiroom");
    this.x = getIntent().getStringExtra("lease");
    if (TextUtils.isEmpty(this.u)) {
      showToast("获取不到合同编号");
    }
    Log.e("wuyejiaoge", "* *****ZxingActivity**contract_code****** ======  " + this.u);
    this.g.setOnClickListener(this.b);
    this.r.setOnClickListener(this.b);
    this.s.setOnClickListener(this.b);
    findViewById(2131690110).setOnClickListener(this.b);
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.e.d.getSundHandleList(this.C, this.u);
    showProgress("");
  }
  
  public Bitmap createViewBitmap(View paramView)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    return localBitmap;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903622);
    this.c = this;
    this.z = WXAPIFactory.createWXAPI(this.c.getApplicationContext(), "wxc2bae7e8ecb7d70b", true);
    this.z.registerApp("wxc2bae7e8ecb7d70b");
    MobSDK.init(this.c.getApplicationContext());
    e();
    a();
    try
    {
      if (!TextUtils.isEmpty(this.u))
      {
        paramBundle = f.createQRCode(this.u, 350);
        this.d.setImageBitmap(paramBundle);
        this.e.setImageBitmap(paramBundle);
        return;
      }
      com.freelxl.baselibrary.f.g.textToast(this, "获取不到合同编号", 0);
      return;
    }
    catch (com.google.c.q paramBundle)
    {
      Log.e("wuyejiaoge", "* *****ZxingActivity**create* contract_code***** " + paramBundle.getMessage());
      paramBundle.printStackTrace();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ApplicationEx.c.removeActivity(this);
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    this.u = paramIntent.getStringExtra("contract_part_code");
    this.x = paramIntent.getStringExtra("lease");
    this.A = paramIntent.getStringExtra("isMyZiroom");
  }
  
  public void saveImageToGallery(Context paramContext, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    paramContext = new File(Environment.getExternalStorageDirectory(), "Boohee");
    if (!paramContext.exists()) {
      paramContext.mkdir();
    }
    paramContext = new File(paramContext, System.currentTimeMillis() + ".jpg");
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramContext);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
      this.y = paramContext.getPath();
      localFileOutputStream.flush();
      localFileOutputStream.close();
      return;
    }
    catch (FileNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/ZxingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */