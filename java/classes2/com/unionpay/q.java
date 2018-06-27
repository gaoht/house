package com.unionpay;

import com.unionpay.utils.UPUtils;
import java.util.Iterator;
import org.json.JSONObject;

final class q
  implements ab
{
  q(UPPayWapActivity paramUPPayWapActivity) {}
  
  public final void a(String paramString, ac paramac)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = paramString.keys();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        UPUtils.a(this.a, paramString.getString(str), str);
      }
      while (paramac == null) {}
    }
    catch (Exception paramString)
    {
      if (paramac != null)
      {
        localObject = this.a;
        paramac.a(UPPayWapActivity.a("1", paramString.getMessage(), null));
      }
      return;
    }
    paramString = this.a;
    paramac.a(UPPayWapActivity.a("0", "success", null));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */