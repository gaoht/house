package com.ziroom.ziroomcustomer.payment.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.ziroom.ziroomcustomer.payment.activity.HuifuAddBandCardActivity;
import com.ziroom.ziroomcustomer.payment.d.e;
import com.ziroom.ziroomcustomer.payment.views.a.b;

public class b
{
  a a;
  private com.ziroom.ziroomcustomer.payment.views.a b;
  private Context c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private com.ziroom.ziroomcustomer.payment.b.i i;
  private Boolean j = Boolean.valueOf(true);
  
  public b(Context paramContext, Boolean paramBoolean, String paramString1, String paramString2, a parama)
  {
    this(paramContext, paramBoolean, paramString1, paramString2, "确定", "取消", "提示", parama);
  }
  
  public b(Context paramContext, Boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, a parama)
  {
    this.c = paramContext;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.j = paramBoolean;
    this.g = paramString1;
    this.h = paramString2;
    this.a = parama;
  }
  
  private void a(boolean paramBoolean)
  {
    com.ziroom.ziroomcustomer.payment.d.b.getPayMessageCode((Activity)this.c, this.g, new com.ziroom.ziroomcustomer.payment.d.i(this.c, new e(com.ziroom.ziroomcustomer.payment.b.i.class), paramBoolean)
    {
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.payment.b.i paramAnonymousi)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousi);
        b.a(b.this, paramAnonymousi);
        b.c(b.this).show();
        b.c(b.this).setTipMessage("短信验证码已发送到" + b.a(b.this).getUser_mobile() + "手机上，请注意查收");
        b.c(b.this).startGetMessage();
      }
    });
  }
  
  private void b(boolean paramBoolean)
  {
    com.ziroom.ziroomcustomer.payment.d.b.getReBandMessageCode((Activity)this.c, this.h, new com.ziroom.ziroomcustomer.payment.d.i(this.c, new com.ziroom.ziroomcustomer.payment.d.g(com.ziroom.ziroomcustomer.payment.b.i.class), paramBoolean)
    {
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.payment.b.i paramAnonymousi)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousi);
        b.a(b.this, paramAnonymousi);
        b.c(b.this).show();
        b.c(b.this).setTipMessage("短信验证码已发送到" + b.a(b.this).getUser_mobile() + "手机上，请注意查收");
        b.c(b.this).startGetMessage();
      }
    });
  }
  
  public void ToPay(Boolean paramBoolean, String paramString)
  {
    if (!paramBoolean.booleanValue())
    {
      paramBoolean = new Intent(this.c, HuifuAddBandCardActivity.class);
      paramBoolean.putExtra("cwOrderId", paramString);
      ((Activity)this.c).startActivityForResult(paramBoolean, 2);
      return;
    }
    showMessageDialog();
  }
  
  public void showMessageDialog()
  {
    if (this.j.booleanValue()) {
      a(true);
    }
    for (;;)
    {
      this.b = new com.ziroom.ziroomcustomer.payment.views.a(this.c, this.d, this.e, "", this.f);
      this.b.setUpdateOnClickListener(new a.b()
      {
        public void BtnCancleOnClickListener(View paramAnonymousView)
        {
          b.c(b.this).dismiss();
        }
        
        public void BtnGetMessageOnClickListener(View paramAnonymousView)
        {
          if (b.d(b.this).booleanValue())
          {
            b.a(b.this, false);
            return;
          }
          b.b(b.this, false);
        }
        
        public void BtnYesOnClickListener(View paramAnonymousView, String paramAnonymousString)
        {
          if (b.a(b.this) == null)
          {
            com.freelxl.baselibrary.f.g.textToast(b.b(b.this), "获取短息验证码失败");
            return;
          }
          if ((paramAnonymousString == null) || (paramAnonymousString.equals("")))
          {
            com.freelxl.baselibrary.f.g.textToast(b.b(b.this), "请输入验证码");
            return;
          }
          if (paramAnonymousString.length() != 6)
          {
            com.freelxl.baselibrary.f.g.textToast(b.b(b.this), "验证码不完整");
            return;
          }
          b.this.a.onClick(paramAnonymousString, b.a(b.this));
          b.c(b.this).dismiss();
        }
        
        public void dismiss() {}
      });
      return;
      b(true);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onClick(String paramString, com.ziroom.ziroomcustomer.payment.b.i parami);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */