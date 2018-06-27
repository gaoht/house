package com.ziroom.ziroomcustomer.minsu.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.ziroom.ziroomcustomer.base.ApplicationEx;

public class ZrIntentService
  extends IntentService
{
  public final String a = ZrIntentService.class.getSimpleName();
  
  public ZrIntentService()
  {
    super("ZrIntentService");
  }
  
  private void a(String paramString)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(this.a, "Thread name = " + Thread.currentThread().getName() + " thread id = " + Thread.currentThread().getId() + " is main = " + getMainLooper().isCurrentThread());
    com.ziroom.ziroomcustomer.newchat.a.createAndLogin(ApplicationEx.c, paramString);
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(this.a, "Thread name = " + Thread.currentThread().getName() + " thread id = " + Thread.currentThread().getId() + " is main = " + getMainLooper().isCurrentThread());
  }
  
  private void b(String paramString)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(this.a, "Thread name = " + Thread.currentThread().getName() + " thread id = " + Thread.currentThread().getId() + " is main = " + getMainLooper().isCurrentThread());
    com.ziroom.ziroomcustomer.newchat.a.logout4T(ApplicationEx.c, null);
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(this.a, "Thread name = " + Thread.currentThread().getName() + " thread id = " + Thread.currentThread().getId() + " is main = " + getMainLooper().isCurrentThread());
  }
  
  public static void imLogout4T(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, ZrIntentService.class);
    localIntent.setAction("com.ziroom.ziroomcustomer.minsu.service.action.IMREGISTERLOGIN");
    localIntent.putExtra("com.ziroom.ziroomcustomer.minsu.service.extra.ACCOUNT", paramString);
    paramContext.startService(localIntent);
  }
  
  public static void imRegisterLogin(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, ZrIntentService.class);
    localIntent.setAction("com.ziroom.ziroomcustomer.minsu.service.action.IMREGISTERLOGIN");
    localIntent.putExtra("com.ziroom.ziroomcustomer.minsu.service.extra.ACCOUNT", paramString);
    paramContext.startService(localIntent);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getAction();
      if (!"com.ziroom.ziroomcustomer.minsu.service.action.IMREGISTERLOGIN".equals(str)) {
        break label29;
      }
      a(paramIntent.getStringExtra("com.ziroom.ziroomcustomer.minsu.service.extra.ACCOUNT"));
    }
    label29:
    while (!"com.ziroom.ziroomcustomer.minsu.service.action.IMLOGOUT".equals(str)) {
      return;
    }
    b(paramIntent.getStringExtra("com.ziroom.ziroomcustomer.minsu.service.extra.ACCOUNT"));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/service/ZrIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */