package com.unionpay;

import com.unionpay.utils.UPUtils;

final class r
  implements ab
{
  r(UPPayWapActivity paramUPPayWapActivity) {}
  
  public final void a(String paramString, ac paramac)
  {
    paramString = UPUtils.a(this.a, paramString);
    if (paramac != null)
    {
      UPPayWapActivity localUPPayWapActivity = this.a;
      paramac.a(UPPayWapActivity.a("0", "success", paramString));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */