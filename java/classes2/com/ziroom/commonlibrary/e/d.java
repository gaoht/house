package com.ziroom.commonlibrary.e;

import android.content.Context;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.f.g;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class d
{
  private IWXAPI a;
  
  public int doStartWXPay(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    int i = 1;
    if (!this.a.isWXAppInstalled())
    {
      g.textToast(paramContext, "请安装微信客户端！", 0);
      return 1;
    }
    if (f.isNull(paramString6))
    {
      g.textToast(paramContext, "支付失败，商户号为空！", 0);
      return 2;
    }
    if (this.a.getWXAppSupportAPI() >= 570425345) {}
    while (i != 0)
    {
      paramContext = new PayReq();
      paramContext.appId = "wx484d02e10be8f5c9";
      paramContext.partnerId = paramString6;
      paramContext.prepayId = paramString1;
      paramContext.nonceStr = paramString2;
      paramContext.timeStamp = paramString3;
      paramContext.packageValue = paramString4;
      paramContext.sign = paramString5;
      com.freelxl.baselibrary.f.d.e("wxx", paramContext.toString());
      com.freelxl.baselibrary.f.d.e("wxxx", "app_id = wx484d02e10be8f5c9,partnerId = " + paramString6 + ",prepayId = " + paramString1 + ",nonceStr = " + paramString2 + ",timeStamp = " + paramString3 + ",packageValue = " + paramString4 + ",sign = " + paramString5);
      this.a.sendReq(paramContext);
      return 0;
      i = 0;
    }
    return 3;
  }
  
  public void initWXAPI(Context paramContext)
  {
    this.a = WXAPIFactory.createWXAPI(paramContext, "wx484d02e10be8f5c9");
    this.a.registerApp("wx484d02e10be8f5c9");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */