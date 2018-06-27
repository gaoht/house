package com.g.a;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bt
  extends br
{
  public void b()
  {
    a("accounts", y.b(c.e));
  }
  
  public void setUserAccount(bn parambn)
  {
    if ((parambn == null) || (parambn.a_() == null)) {
      return;
    }
    if (this.b.isNull("accounts"))
    {
      new JSONArray().put(parambn.a_());
      a("accounts", parambn.a_());
      return;
    }
    try
    {
      this.b.getJSONArray("accounts").put(parambn.a_());
      return;
    }
    catch (JSONException parambn)
    {
      av.postSDKError(parambn);
      parambn.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */