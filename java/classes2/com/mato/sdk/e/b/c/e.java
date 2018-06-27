package com.mato.sdk.e.b.c;

import android.util.SparseArray;
import com.mato.sdk.b.g;

public final class e
{
  private static final String a = g.b("");
  private static SparseArray<String> b;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    b = localSparseArray;
    localSparseArray.append(1000, "网络检测启动失败，请联系客服（代码：1000）");
    b.append(2000, "localhost设置异常（代码：2000）");
    b.append(2001, "3gwap下sdk不启动且联网质量较差，建议到设置-移动网络-apn接入点里面切换为联网质量更好的3gnet（代码：2001）");
    b.append(2002, "cmwap下联网质量较差，建议到设置-移动网络-apn接入点里面切换为联网质量更好的cmnet（代码：2001）");
    b.append(2003, "ctwap下联网质量较差，建议到设置-移动网络-apn接入点里面切换为联网质量更好的ctnet（代码：2001）");
    b.append(3000, "您当前手机网络不稳定，波动大，网络不通畅（代码：3000）");
    b.append(3001, "您当前手机网络异常（代码：3001）");
    b.append(3002, "您当前手机网络不稳定，波动大（代码：3002）");
    b.append(3003, "您当前手机网络差（代码：3003）");
    b.append(3004, "您当前手机网络异常或者您当前域名解析服务设置有误（代码：3004）");
    b.append(3005, "您当前手机网络差，当前下载速率为%dKB/s（代码：3005）");
    b.append(3006, "您当前手机网络异常或者您当前域名解析服务设置有误（代码：3006）");
    b.append(3007, "您当前手机网络异常，无法访问（代码：3007）");
    b.append(3008, "您当前手机网络差，下载速率为%d（KB/s）（代码：3008）");
    b.append(4000, "%s网站连接不通畅（代码：4000）");
    b.append(4001, "%s网站连接不上（代码：4001）");
    b.append(4002, "%s网站连接不通畅（代码：4002）");
    b.append(4003, "%s网站连接不上（代码：4003）");
    b.append(4004, "%s网站出错（代码：4004）");
    b.append(4005, "%s网站站点%s异常（代码：4005）");
    b.append(4006, "%s网站站点%s连接不上或者站点%s出口网络不通（代码：4006）");
    b.append(5000, "网站加速服务连接不通畅（代码：5000）");
    b.append(5001, "网站加速服务%s网络连接不通畅（代码：5001）");
    b.append(5002, "网站加速服务%s网络连接不上（代码：5002）");
    b.append(5003, "网站加速服务%s出错（代码：5003）");
    b.append(5004, "网站加速服务域名解析出错（代码：5004）");
    b.append(5005, "网站加速服务连接失败（代码：5005）");
    b.append(5006, "网站加速服务%s连接不上或者网站加速服务%s出错（代码：5006）");
    b.append(5007, "网站加速服务%s连接不上（代码：5007）");
    b.append(6000, "网站加速服务%s到%s网站出错（代码：6000）");
  }
  
  public static String a(int paramInt)
  {
    String str2 = (String)b.get(paramInt);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */