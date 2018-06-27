package com.ziroom.ziroomcustomer.payment.e;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.ziroom.commonlibrary.e.b;
import com.ziroom.commonlibrary.e.d;
import com.ziroom.ziroomcustomer.util.u;

public class e
{
  private d a = new d();
  private String b = "android";
  private b c;
  private int d;
  private Activity e;
  private BroadcastReceiver f = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      u.d("sjdkgh", "=====  zhifu chenggong le  wxReceiver");
      e.b(e.this).onSuccess(e.a(e.this), new String[] { "支付成功" });
    }
  };
  private BroadcastReceiver g = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      Log.e("sjdkgh", "error");
      if (paramAnonymousIntent.getIntExtra("code", 0) == -2)
      {
        e.b(e.this).onCancel(e.a(e.this), new String[] { "用户取消了支付" });
        return;
      }
      e.b(e.this).onFail(e.a(e.this), new String[] { "支付失败" });
    }
  };
  
  public e(Activity paramActivity, b paramb, int paramInt)
  {
    this.c = paramb;
    this.d = paramInt;
    this.e = paramActivity;
    this.a.initWXAPI(this.e);
    this.e.registerReceiver(this.f, new IntentFilter("com.ziroom.ziroomcustomer.activity_1"));
    this.e.registerReceiver(this.g, new IntentFilter("com.ziroom.ziroomcustomer.activity_2"));
  }
  
  public void UnregisterReceiver()
  {
    this.e.unregisterReceiver(this.f);
    this.e.unregisterReceiver(this.g);
  }
  
  public void wxPay(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    u.d("sjdkgh", "=====  zhifu chenggong le  wxPay");
    if (TextUtils.isEmpty(paramString6))
    {
      this.a.doStartWXPay(this.e, paramString1, paramString2, paramString3, paramString4, paramString5, "1248814701");
      return;
    }
    this.a.doStartWXPay(this.e, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */