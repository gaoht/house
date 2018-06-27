package com.ziroom.ziroomcustomer.payment.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.payment.activity.UnionDKAddBandCardActivity;
import com.ziroom.ziroomcustomer.payment.d.b;
import com.ziroom.ziroomcustomer.payment.d.e;
import com.ziroom.ziroomcustomer.payment.d.i;
import com.ziroom.ziroomcustomer.payment.views.a.a.b;

public class d
{
  private Activity a;
  private com.ziroom.ziroomcustomer.payment.views.a.a b;
  private a c;
  
  public d(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  private void a(String paramString)
  {
    b.getUnionCheckSMSResult(this.a, paramString, new i(this.a, new e(Object.class))
    {
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        if ("true".equals(paramAnonymousObject.toString()))
        {
          if (d.b(d.this) != null) {
            d.b(d.this).onSuccess("");
          }
          return;
        }
        g.textToast(d.a(d.this), "短信验证码错误!");
      }
    });
  }
  
  private void a(boolean paramBoolean)
  {
    b.getUnionSendSMSResult(this.a, new i(this.a, new e(Object.class), paramBoolean)
    {
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        if (paramAnonymousObject.toString().length() != 11)
        {
          g.textToast(d.a(d.this), "获取手机号码失败！");
          return;
        }
        d.c(d.this).show();
        d.c(d.this).setTipMessage("短信验证码已发送到" + paramAnonymousObject.toString() + "手机上，请注意查收");
        d.c(d.this).startGetMessage();
      }
    });
  }
  
  public void ToPay(String paramString, Boolean paramBoolean1, Boolean paramBoolean2, a parama)
  {
    this.c = parama;
    if ((!paramBoolean1.booleanValue()) || (!paramBoolean2.booleanValue()))
    {
      parama = new Intent(this.a, UnionDKAddBandCardActivity.class);
      parama.putExtra("cwOrderId", paramString);
      parama.putExtra("isBandUnionCard", paramBoolean1);
      parama.putExtra("isBandUnionDKContract", paramBoolean2);
      this.a.startActivityForResult(parama, 3);
      return;
    }
    showUnionDkPayPop(true);
  }
  
  public void showUnionDkPayPop(final boolean paramBoolean)
  {
    a(true);
    this.b = new com.ziroom.ziroomcustomer.payment.views.a.a(this.a, "确定", "取消", "", "付款确认");
    this.b.setUpdateOnClickListener(new a.b()
    {
      public void BtnCancleOnClickListener(View paramAnonymousView)
      {
        d.c(d.this).dismiss();
      }
      
      public void BtnGetMessageOnClickListener(View paramAnonymousView)
      {
        d.a(d.this, false);
      }
      
      public void BtnYesOnClickListener(View paramAnonymousView, String paramAnonymousString)
      {
        if ((paramAnonymousString == null) || (paramAnonymousString.equals("")))
        {
          g.textToast(d.a(d.this), "请输入验证码");
          return;
        }
        if (paramAnonymousString.length() != 6)
        {
          g.textToast(d.a(d.this), "验证码不完整");
          return;
        }
        if (paramBoolean) {
          if (d.b(d.this) != null) {
            d.b(d.this).onSuccess(paramAnonymousString);
          }
        }
        for (;;)
        {
          d.c(d.this).dismiss();
          return;
          d.a(d.this, paramAnonymousString);
        }
      }
      
      public void dismiss() {}
    });
  }
  
  public void showUnionDkPayPop(boolean paramBoolean, a parama)
  {
    this.c = parama;
    showUnionDkPayPop(paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void onSuccess(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */