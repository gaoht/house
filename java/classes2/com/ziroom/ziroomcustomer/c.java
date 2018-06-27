package com.ziroom.ziroomcustomer;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;

public class c
{
  public static void demoWithNoParams(Context paramContext, Bundle paramBundle) {}
  
  public static void demoWithParams(Context paramContext, Bundle paramBundle)
  {
    long l = paramBundle.getLong("updatetime");
    paramBundle.getString("name");
    int i = paramBundle.getInt("id");
    paramContext = Toast.makeText(paramContext, "demoWithParams &id=" + i + "&updatetime=" + l + "&id=" + i, 0);
    if (!(paramContext instanceof Toast))
    {
      paramContext.show();
      return;
    }
    VdsAgent.showToast((Toast)paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */