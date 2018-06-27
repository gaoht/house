package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.video.interfaces.IUserStateChangedListener;
import com.tencent.tbs.video.interfaces.a;

class at
{
  private static at e = null;
  av a = null;
  Context b;
  a c;
  IUserStateChangedListener d;
  
  private at(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.a = new av(this.b);
  }
  
  public static at a(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = new at(paramContext);
      }
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.c != null) {
      this.c.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  void a(Activity paramActivity, int paramInt)
  {
    this.a.a(paramActivity, paramInt);
  }
  
  public boolean a()
  {
    this.a.a();
    return this.a.b();
  }
  
  public boolean a(String paramString, Bundle paramBundle, a parama)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("videoUrl", paramString);
    }
    if (parama != null)
    {
      this.a.a();
      if (!this.a.b()) {
        return false;
      }
      this.c = parama;
      this.d = new au(this);
      this.c.a(this.d);
      localBundle.putInt("callMode", 3);
    }
    for (;;)
    {
      paramBundle = this.a;
      paramString = this;
      if (parama == null) {
        paramString = null;
      }
      paramBundle.a(localBundle, paramString);
      return true;
      localBundle.putInt("callMode", 1);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */