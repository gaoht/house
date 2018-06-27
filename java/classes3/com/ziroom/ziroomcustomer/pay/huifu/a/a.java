package com.ziroom.ziroomcustomer.pay.huifu.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBackMessage;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBankMessage;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBankMessage.DataBean;
import com.ziroom.ziroomcustomer.pay.huifu.views.a.a.b;

public class a
{
  private static com.ziroom.ziroomcustomer.pay.huifu.views.a.a a;
  private Context b;
  private Handler c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private int i;
  private HuifuBankMessage j;
  private String k = "";
  private String l = "";
  private String m = "";
  
  public a(Context paramContext, Handler paramHandler, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramContext, paramHandler, paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, "确定", "取消", "提示");
  }
  
  public a(Context paramContext, Handler paramHandler, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.b = paramContext;
    this.c = paramHandler;
    this.d = paramString6;
    this.e = paramString7;
    this.f = paramString8;
    this.g = paramString1;
    this.i = paramInt;
    this.k = paramString2;
    this.l = paramString3;
    this.m = paramString4;
    this.h = paramString5;
  }
  
  private void a(boolean paramBoolean)
  {
    com.ziroom.ziroomcustomer.pay.common.b.a.getHuifuBandMessage((Activity)this.b, this.h, this.g, this.i, this.k, this.l, this.m, paramBoolean, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        d.e("yangxj---", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        if (!paramAnonymousk.getSuccess().booleanValue()) {
          com.freelxl.baselibrary.f.g.textToast(a.b(a.this), paramAnonymousk.getMessage());
        }
        do
        {
          return;
          a.a(a.this, (HuifuBankMessage)paramAnonymousk.getObject());
        } while (a.a(a.this) == null);
        if (!a.a(a.this).isSuccess())
        {
          com.freelxl.baselibrary.f.g.textToast(a.b(a.this), a.a(a.this).getError_message());
          return;
        }
        a.a().show();
        a.a().setTipMessage("短信验证码已发送到" + a.a(a.this).data.user_mobile + "手机上，请注意查收");
        a.a().startGetMessage();
      }
    });
  }
  
  public void showMessageDialog()
  {
    a(true);
    a = new com.ziroom.ziroomcustomer.pay.huifu.views.a.a(this.b, this.d, this.e, "", this.f);
    a.setUpdateOnClickListener(new a.b()
    {
      public void BtnCancleOnClickListener(View paramAnonymousView)
      {
        a.a().dismiss();
      }
      
      public void BtnGetMessageOnClickListener(View paramAnonymousView)
      {
        a.a(a.this, false);
      }
      
      public void BtnYesOnClickListener(View paramAnonymousView, String paramAnonymousString)
      {
        if ((a.a(a.this) == null) || (a.a(a.this).data == null))
        {
          com.freelxl.baselibrary.f.g.textToast(a.b(a.this), "获取短息验证码失败");
          return;
        }
        if ((paramAnonymousString == null) || (paramAnonymousString.equals("")))
        {
          com.freelxl.baselibrary.f.g.textToast(a.b(a.this), "请输入验证码");
          return;
        }
        if (paramAnonymousString.length() != 6)
        {
          com.freelxl.baselibrary.f.g.textToast(a.b(a.this), "验证码不完整");
          return;
        }
        paramAnonymousView = new HuifuBackMessage();
        paramAnonymousView.mMessageCode = paramAnonymousString;
        paramAnonymousView.huifuBankMessage = a.a(a.this);
        paramAnonymousView.cityCode = a.c(a.this);
        com.freelxl.baselibrary.e.g.sendMessage(a.d(a.this), 8947848, paramAnonymousView);
        a.a().dismiss();
      }
      
      public void dismiss() {}
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/huifu/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */