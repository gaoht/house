package com.ziroom.ziroomcustomer.util.a;

import android.text.TextUtils;
import com.ziroom.ziroomcustomer.util.u;

public class b
{
  public void onCertInitEnd(String paramString) {}
  
  public void onCertInitStart() {}
  
  public void onError(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      u.d("ITrusListener", paramString);
    }
  }
  
  public void onSignEnd(String paramString) {}
  
  public void onSignStart() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */