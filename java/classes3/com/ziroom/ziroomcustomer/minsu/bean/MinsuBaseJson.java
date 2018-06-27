package com.ziroom.ziroomcustomer.minsu.bean;

import android.app.Activity;
import com.ziroom.commonlibrary.g.a.a;
import java.io.Serializable;

public class MinsuBaseJson
  implements Serializable
{
  public String message;
  public String status;
  
  public MinsuBaseJson() {}
  
  public MinsuBaseJson(String paramString1, String paramString2)
  {
    this.status = paramString1;
    this.message = paramString2;
  }
  
  public boolean checkSuccess(Activity paramActivity)
  {
    boolean bool = false;
    if ("0".equals(this.status)) {
      bool = true;
    }
    while (!"-1".equals(this.status)) {
      return bool;
    }
    a.handleMessage(paramActivity, "40005");
    return false;
  }
  
  public boolean checkSuccessNoLogin()
  {
    boolean bool = false;
    if ("0".equals(this.status)) {
      bool = true;
    }
    while (!"-1".equals(this.status)) {
      return bool;
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuBaseJson.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */