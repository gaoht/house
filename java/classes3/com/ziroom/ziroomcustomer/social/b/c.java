package com.ziroom.ziroomcustomer.social.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;

public class c
{
  private static Toast a;
  private static View b;
  
  public static void showToast(Context paramContext, int paramInt)
  {
    showToast(paramContext, paramInt, 0);
  }
  
  public static void showToast(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    if (b == null) {
      b = ((LayoutInflater)paramContext.getApplicationContext().getSystemService("layout_inflater")).inflate(2130904650, null);
    }
    if (a == null) {
      a = Toast.makeText(paramContext.getApplicationContext(), paramInt1, paramInt2);
    }
    a.setView(b);
    a.setGravity(16842927, 0, 0);
    paramContext = a;
    if (!(paramContext instanceof Toast))
    {
      paramContext.show();
      return;
    }
    VdsAgent.showToast((Toast)paramContext);
  }
  
  public static void showToast(Context paramContext, String paramString)
  {
    showToast(paramContext, paramString, 0);
  }
  
  public static void showToast(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    if (b == null) {
      b = ((LayoutInflater)paramContext.getApplicationContext().getSystemService("layout_inflater")).inflate(2130904650, null);
    }
    if (a == null) {
      a = Toast.makeText(paramContext.getApplicationContext(), paramString, paramInt);
    }
    a.setView(b);
    a.setGravity(16842927, 0, 0);
    paramContext = a;
    if (!(paramContext instanceof Toast))
    {
      paramContext.show();
      return;
    }
    VdsAgent.showToast((Toast)paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */