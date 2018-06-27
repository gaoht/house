package com.pgyersdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.pgyersdk.views.b;
import com.pgyersdk.views.n;

public class FeedbackActivity
  extends Activity
{
  private static boolean d = false;
  private b a;
  private boolean b = false;
  private String c;
  
  private void a(boolean paramBoolean)
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    if (paramBoolean) {}
    for (localLayoutParams.flags |= 0x4000000;; localLayoutParams.flags &= 0xFBFFFFFF)
    {
      localWindow.setAttributes(localLayoutParams);
      return;
    }
  }
  
  public static void setBarBackgroundColor(String paramString)
  {
    b.b = paramString;
    b.a = paramString;
  }
  
  public static void setBarButtonPressedColor(String paramString)
  {
    com.pgyersdk.views.a.a = paramString;
  }
  
  public static void setBarImmersive(Boolean paramBoolean)
  {
    d = paramBoolean.booleanValue();
  }
  
  public static void setColorPickerBackgroundColor(String paramString)
  {
    b.c = paramString;
  }
  
  public void destroy()
  {
    this.a.d.c();
    com.pgyersdk.d.a.getInstance().destroy();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    destroy();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (d)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        a(true);
      }
      paramBundle = new com.e.a.a(this);
      paramBundle.a(true);
      paramBundle.a(Color.parseColor(b.a));
    }
    this.c = getIntent().getStringExtra("imgFile");
    this.a = new b(this, this.c);
    setContentView(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/activity/FeedbackActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */