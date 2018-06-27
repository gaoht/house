package com.ziroom.ziroomcustomer.gesturelock.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class a
{
  private final String a = "gesturelock";
  private Context b;
  private String c = "gesturelock";
  
  public a(Context paramContext, int paramInt)
  {
    this.b = paramContext;
    if (paramInt != -1) {
      this.c += paramInt;
    }
  }
  
  public String ReadStringPreference()
  {
    return this.b.getSharedPreferences("gesturelock", 0).getString(this.c, "null");
  }
  
  public void WriteStringPreference(String paramString)
  {
    SharedPreferences.Editor localEditor = this.b.getSharedPreferences("gesturelock", 0).edit();
    localEditor.putString(this.c, paramString);
    localEditor.apply();
  }
  
  public void clear()
  {
    this.b.getSharedPreferences("gesturelock", 0).edit().clear().apply();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/gesturelock/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */