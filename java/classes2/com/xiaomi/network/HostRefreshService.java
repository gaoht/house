package com.xiaomi.network;

import android.app.IntentService;
import android.content.Intent;

public class HostRefreshService
  extends IntentService
{
  protected void onHandleIntent(Intent paramIntent)
  {
    HostManager.getInstance().refreshFallbacks();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/network/HostRefreshService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */