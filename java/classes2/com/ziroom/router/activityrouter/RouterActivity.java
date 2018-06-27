package com.ziroom.router.activityrouter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class RouterActivity
  extends Activity
{
  private RouterCallback getRouterCallback()
  {
    if ((getApplication() instanceof RouterCallbackProvider)) {
      return ((RouterCallbackProvider)getApplication()).provideRouterCallback();
    }
    return null;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getRouterCallback();
    Uri localUri = getIntent().getData();
    if (localUri != null) {
      Routers.open(this, localUri, paramBundle);
    }
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/router/activityrouter/RouterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */