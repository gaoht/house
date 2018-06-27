package com.alipay.sdk.j;

import android.content.Context;
import android.text.TextUtils;

public final class j
{
  public static String a(Context paramContext)
  {
    if (com.alipay.sdk.app.a.isSandBox()) {
      paramContext = "https://mobilegw.alipaydev.com/mgw.htm";
    }
    String str;
    do
    {
      return paramContext;
      if (paramContext == null) {
        return com.alipay.sdk.b.a.a;
      }
      str = com.alipay.sdk.b.a.a;
      paramContext = str;
    } while (!TextUtils.isEmpty(str));
    return com.alipay.sdk.b.a.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/j/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */