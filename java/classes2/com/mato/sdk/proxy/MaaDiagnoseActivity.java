package com.mato.sdk.proxy;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import com.mato.sdk.e.b.h;

public class MaaDiagnoseActivity
  extends Activity
{
  private static final String a = "MaaDiagnoseActivity";
  private WebView b;
  private h c;
  
  private void a()
  {
    this.b = new WebView(getApplicationContext());
    this.b.setId(100);
    this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    setContentView(this.b);
    this.b.requestFocusFromTouch();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = new WebView(getApplicationContext());
    this.b.setId(100);
    this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    setContentView(this.b);
    this.b.requestFocusFromTouch();
    this.c = new h(this, this.b);
    this.c.a();
  }
  
  public void onDestroy()
  {
    if (this.c != null) {
      this.c.b();
    }
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/MaaDiagnoseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */