package com.ziroom.commonlibrary.e;

import android.app.Activity;
import android.text.TextUtils;
import com.alipay.sdk.app.PayTask;

public class a
{
  public static void toALiPay(Activity paramActivity, final String paramString, final a parama)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        String str = new com.ziroom.commonlibrary.c.a(new PayTask(this.a).pay(paramString, true)).getResultStatus();
        if (TextUtils.equals(str, "9000")) {
          if (parama != null) {
            parama.onSuccess();
          }
        }
        do
        {
          do
          {
            return;
            if (!TextUtils.equals(str, "8000")) {
              break;
            }
          } while (parama == null);
          parama.onWaiting();
          return;
        } while (parama == null);
        parama.onError();
      }
    }).start();
  }
  
  public static void toALiPay(Activity paramActivity, final String paramString, final b paramb, final int paramInt)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        String str = new com.ziroom.commonlibrary.c.a(new PayTask(this.a).pay(paramString, true)).getResultStatus();
        if (TextUtils.equals(str, "9000")) {
          if (paramb != null) {
            paramb.onSuccess(paramInt, new String[] { "支付成功" });
          }
        }
        do
        {
          do
          {
            do
            {
              return;
              if (!TextUtils.equals(str, "8000")) {
                break;
              }
            } while (paramb == null);
            paramb.onWaiting(paramInt, new String[] { str, "支付结果确认中" });
            return;
            if (!TextUtils.equals(str, "6001")) {
              break;
            }
          } while (paramb == null);
          paramb.onCancel(paramInt, new String[] { "用户取消了支付" });
          return;
        } while (paramb == null);
        paramb.onFail(paramInt, new String[] { str, "支付失败" });
      }
    }).start();
  }
  
  public static abstract interface a
  {
    public abstract void onError();
    
    public abstract void onSuccess();
    
    public abstract void onWaiting();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */