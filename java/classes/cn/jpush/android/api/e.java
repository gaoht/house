package cn.jpush.android.api;

import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;

public final class e
{
  public static cn.jpush.android.d.a.e a = null;
  private static int b = 400;
  private static int c = 600;
  
  public static void a(WindowManager paramWindowManager, WebView paramWebView, ImageButton paramImageButton)
  {
    paramWindowManager.removeView(paramWebView);
    paramWindowManager.removeView(paramImageButton);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/api/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */