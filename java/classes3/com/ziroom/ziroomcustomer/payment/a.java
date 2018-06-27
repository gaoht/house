package com.ziroom.ziroomcustomer.payment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.payment.activity.JDPayWebViewActivity;
import com.ziroom.ziroomcustomer.payment.activity.PaymentActivity;
import com.ziroom.ziroomcustomer.payment.b.m;
import com.ziroom.ziroomcustomer.payment.d.b;
import com.ziroom.ziroomcustomer.payment.d.i;

public class a
{
  private static void b(Activity paramActivity, int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.ziroom.ziroomcustomer.payresult");
    localIntent.putExtra("code", paramInt);
    localIntent.putExtra("message", paramString1);
    localIntent.putExtra("payType", paramString2);
    paramActivity.sendBroadcast(localIntent);
  }
  
  public static void onActivityResult(final Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 16) && (paramInt2 == 16) && (paramIntent != null))
    {
      final String str = paramIntent.getStringExtra("payType");
      b.SearchPayStatic(paramActivity, paramIntent.getStringExtra("orderCode"), Integer.parseInt(paramIntent.getStringExtra("payChanel")), new i(paramActivity, new com.ziroom.ziroomcustomer.payment.d.e(Object.class))
      {
        public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousObject);
          if (paramAnonymousObject != null)
          {
            paramAnonymousObject = com.alibaba.fastjson.e.parseObject(paramAnonymousObject.toString());
            if ((paramAnonymousObject != null) && ("9".equals(((com.alibaba.fastjson.e)paramAnonymousObject).get("status").toString()))) {
              a.a(paramActivity, 1, "支付成功", str);
            }
            do
            {
              return;
              if ((paramAnonymousObject != null) && ("8".equals(((com.alibaba.fastjson.e)paramAnonymousObject).get("status").toString())))
              {
                g.textToast(paramActivity, "支付失败");
                return;
              }
            } while ((paramAnonymousObject == null) || (!"3".equals(((com.alibaba.fastjson.e)paramAnonymousObject).get("status").toString())));
            a.a(paramActivity, 2, "支付中...", str);
            return;
          }
          g.textToast(paramActivity, "支付失败");
        }
      });
    }
  }
  
  public static void startPayActivty(Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    startPayActivty(paramActivity, paramInt, paramString1, paramString2, paramString3, null);
  }
  
  public static void startPayActivty(final Activity paramActivity, final int paramInt, final String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    b.getPayCenterMessage(paramActivity, paramString2, paramString3, new i(paramActivity, new com.ziroom.ziroomcustomer.payment.d.e(m.class))
    {
      public void onSuccess(int paramAnonymousInt, m paramAnonymousm)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousm);
        if (f.notNull(paramAnonymousm.getPayType()))
        {
          localIntent = new Intent(paramActivity, JDPayWebViewActivity.class);
          localIntent.putExtra("title", "京东支付");
          localIntent.putExtra("url", paramAnonymousm.getUrl());
          localIntent.putExtra("payType", paramString1);
          localIntent.putExtra("payChanel", paramAnonymousm.getPayType());
          localIntent.putExtra("orderCode", paramAnonymousm.getOrderCode());
          paramActivity.startActivityForResult(localIntent, 16);
          return;
        }
        Intent localIntent = new Intent(paramActivity, PaymentActivity.class);
        localIntent.putExtra("payType", paramString1);
        localIntent.putExtra("cwOrderIds", paramString2);
        localIntent.putExtra("systemId", paramString3);
        localIntent.putExtra("time", paramString4);
        localIntent.putExtra("payMoney", paramInt);
        localIntent.putExtra("PayMesssageBean", com.alibaba.fastjson.e.toJSONString(paramAnonymousm));
        paramActivity.startActivityForResult(localIntent, 16);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */