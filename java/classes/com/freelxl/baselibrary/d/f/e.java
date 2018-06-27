package com.freelxl.baselibrary.d.f;

import okhttp3.Response;
import okhttp3.ResponseBody;

public class e
  extends a<String>
{
  protected String a(Response paramResponse)
    throws Exception
  {
    if (paramResponse.isSuccessful()) {
      return paramResponse.body().string();
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */