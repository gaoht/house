package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.push.a.a;
import com.huawei.hms.support.api.push.a.a.d;
import com.huawei.hms.support.api.push.a.b;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PushReceiver
  extends BroadcastReceiver
{
  private void a(Context paramContext, Intent paramIntent)
    throws UnsupportedEncodingException
  {
    Object localObject = paramIntent.getByteArrayExtra("device_token");
    if (localObject == null) {
      if (b.b()) {
        b.a("PushReceiver", "get a deviceToken, but it is null");
      }
    }
    for (;;)
    {
      return;
      localObject = new String((byte[])localObject, "UTF-8");
      if (b.b()) {
        b.a("PushReceiver", "get a deviceToken:" + com.huawei.hms.support.api.push.a.a.a.c.a((String)localObject));
      }
      boolean bool = new d(paramContext, "push_client_self_info").a("hasRequestToken");
      String str = com.huawei.hms.support.api.push.a.a.c.a(paramContext, "push_client_self_info", "token_info");
      if (b.b()) {
        b.a("PushReceiver", "my oldtoken is :" + com.huawei.hms.support.api.push.a.a.a.c.a(str));
      }
      if ((bool) || (!((String)localObject).equals(str)))
      {
        if (b.b()) {
          b.a("PushReceiver", "push client begin to receive the token");
        }
        Executors.newSingleThreadExecutor().execute(new b(paramContext, (String)localObject));
        Bundle localBundle = new Bundle();
        localBundle.putString("deviceToken", (String)localObject);
        localBundle.putByteArray("pushMsg", null);
        localBundle.putInt("receiveType", c.b.ordinal());
        if (paramIntent.getExtras() != null) {
          localBundle.putAll(paramIntent.getExtras());
        }
        Executors.newSingleThreadExecutor().execute(new a(paramContext, localBundle));
      }
      while ((bool) && (!((String)localObject).equals(str)))
      {
        if (b.b()) {
          b.a("PushReceiver", "begin to report active state tag");
        }
        a(paramContext, (String)localObject);
        return;
        if (b.b()) {
          b.a("PushReceiver", "get a deviceToken, but do not requested token, and new token is equals old token");
        }
      }
    }
  }
  
  private void a(Context paramContext, String paramString)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("tagKey", "应用激活状态");
      ((JSONObject)localObject).put("tagValue", "已激活");
      ((JSONObject)localObject).put("opType", 1);
      localJSONArray.put(localObject);
      if (b.b()) {
        b.a("PushReceiver", "report active state tag, jarray:" + localJSONArray);
      }
      localObject = new Intent("com.huawei.android.push.PLUGIN.TAG").setPackage("com.huawei.hwid");
      ((Intent)localObject).putExtra("content", localJSONArray.toString()).putExtra("cycle", 0L).putExtra("operType", 1).putExtra("plusType", 2).putExtra("token", paramString).putExtra("pkgName", paramContext.getPackageName()).putExtra("apkVersion", a.b(paramContext));
      paramContext.sendBroadcast((Intent)localObject);
      return;
    }
    catch (JSONException paramContext)
    {
      while (!b.b()) {}
      b.a("PushReceiver", "reportActiveStateTag error:" + paramContext.getMessage());
    }
  }
  
  private void b(Context paramContext, Intent paramIntent)
    throws UnsupportedEncodingException
  {
    f(paramContext, paramIntent);
    boolean bool = new d(paramContext, "push_switch").a("normal_msg_enable");
    if (b.b()) {
      b.a("PushReceiver", "closePush_Normal:" + bool);
    }
    if (bool) {
      if (b.b()) {
        b.a("PushReceiver", "close switch is true, message not dispatch");
      }
    }
    byte[] arrayOfByte;
    do
    {
      return;
      arrayOfByte = paramIntent.getByteArrayExtra("msg_data");
      paramIntent = paramIntent.getByteArrayExtra("device_token");
      if ((arrayOfByte != null) && (paramIntent != null)) {
        break;
      }
    } while (!b.b());
    b.a("PushReceiver", "PushReceiver receive a message, but message is empty.");
    return;
    if (b.b()) {
      b.a("PushReceiver", "PushReceiver receive a message success");
    }
    paramIntent = new String(paramIntent, "UTF-8");
    Bundle localBundle = new Bundle();
    localBundle.putString("deviceToken", paramIntent);
    localBundle.putByteArray("pushMsg", arrayOfByte);
    localBundle.putInt("receiveType", c.c.ordinal());
    Executors.newSingleThreadExecutor().execute(new a(paramContext, localBundle));
  }
  
  private void c(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("click");
    Bundle localBundle = new Bundle();
    localBundle.putString("pushMsg", paramIntent);
    localBundle.putInt("receiveType", c.e.ordinal());
    Executors.newSingleThreadExecutor().execute(new a(paramContext, localBundle));
  }
  
  private void d(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("clickBtn");
    int i = paramIntent.getIntExtra("notifyId", 0);
    paramIntent = new Bundle();
    paramIntent.putString("pushMsg", str);
    paramIntent.putInt("pushNotifyId", i);
    paramIntent.putInt("receiveType", c.f.ordinal());
    Executors.newSingleThreadExecutor().execute(new a(paramContext, paramIntent));
  }
  
  private void e(Context paramContext, Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("push_state", false);
    paramIntent = new Bundle();
    paramIntent.putBoolean("pushState", bool);
    paramIntent.putInt("receiveType", c.d.ordinal());
    Executors.newSingleThreadExecutor().execute(new a(paramContext, paramIntent));
  }
  
  private void f(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    do
    {
      return;
      paramIntent = paramIntent.getStringExtra("msgIdStr");
    } while ((TextUtils.isEmpty(paramIntent)) || (!a.a(paramContext)));
    Intent localIntent = new Intent("com.huawei.android.push.intent.MSG_RESPONSE");
    localIntent.putExtra("msgIdStr", paramIntent);
    localIntent.setPackage("android");
    localIntent.setFlags(32);
    if (b.b()) {
      b.a("PushReceiver", "send msg response broadcast to frameworkPush");
    }
    paramContext.sendBroadcast(localIntent);
  }
  
  public void onEvent(Context paramContext, Event paramEvent, Bundle paramBundle) {}
  
  public void onPushMsg(Context paramContext, byte[] paramArrayOfByte, String paramString) {}
  
  public boolean onPushMsg(Context paramContext, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    String str = "";
    if (paramBundle != null) {
      str = paramBundle.getString("deviceToken");
    }
    onPushMsg(paramContext, paramArrayOfByte, str);
    return true;
  }
  
  public void onPushState(Context paramContext, boolean paramBoolean) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (b.b()) {
        b.a("PushReceiver", "enter PushMsgReceiver:onReceive(Intent:" + paramIntent.getAction() + " pkgName:" + paramContext.getPackageName() + ")");
      }
      str = paramIntent.getAction();
      if (("com.huawei.android.push.intent.REGISTRATION".equals(str)) && (paramIntent.hasExtra("device_token")))
      {
        a(paramContext, paramIntent);
        return;
      }
      if (("com.huawei.android.push.intent.RECEIVE".equals(str)) && (paramIntent.hasExtra("msg_data")))
      {
        b(paramContext, paramIntent);
        return;
      }
    }
    catch (Exception paramContext)
    {
      String str;
      if (b.e())
      {
        b.d("PushReceiver", "call onReceive(intent:" + paramIntent + ") cause:" + paramContext.getMessage());
        return;
        if (("com.huawei.android.push.intent.CLICK".equals(str)) && (paramIntent.hasExtra("click")))
        {
          c(paramContext, paramIntent);
          return;
        }
        if (("com.huawei.android.push.intent.CLICK".equals(str)) && (paramIntent.hasExtra("clickBtn")))
        {
          d(paramContext, paramIntent);
          return;
        }
        if ("com.huawei.intent.action.PUSH_STATE".equals(str))
        {
          e(paramContext, paramIntent);
          return;
        }
        if (b.b()) {
          b.b("PushReceiver", "message can't be recognised:" + paramIntent.toUri(0));
        }
      }
    }
  }
  
  public void onToken(Context paramContext, String paramString) {}
  
  public void onToken(Context paramContext, String paramString, Bundle paramBundle)
  {
    onToken(paramContext, paramString);
  }
  
  public static enum Event
  {
    private Event() {}
  }
  
  private class a
    implements Runnable
  {
    private Context b;
    private Bundle c;
    
    public a(Context paramContext, Bundle paramBundle)
    {
      this.b = paramContext;
      this.c = paramBundle;
    }
    
    public void run()
    {
      try
      {
        if (this.c == null) {
          return;
        }
        i = this.c.getInt("receiveType");
        if ((i < 0) || (i >= PushReceiver.c.values().length))
        {
          if (!b.b()) {
            break label259;
          }
          b.a("PushReceiver", "invalid receiverType:" + i);
        }
      }
      catch (Exception localException)
      {
        int i;
        if (b.b())
        {
          b.a("PushReceiver", "call EventThread(ReceiveType cause:" + localException.getMessage());
          return;
          Object localObject = PushReceiver.c.values()[i];
          switch (a.a[localObject.ordinal()])
          {
          case 1: 
            PushReceiver.this.onToken(this.b, this.c.getString("deviceToken"), this.c);
            return;
          case 2: 
            localObject = this.c.getByteArray("pushMsg");
            if (localObject != null)
            {
              PushReceiver.this.onPushMsg(this.b, (byte[])localObject, this.c);
              return;
            }
            break;
          case 3: 
            PushReceiver.this.onPushState(this.b, this.c.getBoolean("pushState"));
            return;
          case 4: 
            PushReceiver.this.onEvent(this.b, PushReceiver.Event.NOTIFICATION_OPENED, this.c);
            return;
          case 5: 
            PushReceiver.this.onEvent(this.b, PushReceiver.Event.NOTIFICATION_CLICK_BTN, this.c);
          }
        }
      }
      label259:
      return;
    }
  }
  
  private static class b
    implements Runnable
  {
    Context a;
    String b;
    
    public b(Context paramContext, String paramString)
    {
      this.a = paramContext;
      this.b = paramString;
    }
    
    public void run()
    {
      d locald = new d(this.a, "push_client_self_info");
      locald.a("hasRequestToken", false);
      locald.d("token_info");
      com.huawei.hms.support.api.push.a.a.c.a(this.a, "push_client_self_info", "token_info", this.b);
    }
  }
  
  static enum c
  {
    private c() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/api/push/PushReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */