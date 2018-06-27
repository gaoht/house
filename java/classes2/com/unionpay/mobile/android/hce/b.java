package com.unionpay.mobile.android.hce;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.unionpay.mobile.android.hce.service.b.a;

public final class b
  extends b.a
{
  private int a;
  private String b;
  private Handler c;
  
  public b(int paramInt, String paramString, Handler paramHandler)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramHandler;
  }
  
  public final void a(String paramString)
    throws RemoteException
  {
    switch (this.a)
    {
    default: 
      return;
    case 2003: 
      localBundle = new Bundle();
      localBundle.putString("pkgName", this.b);
      localBundle.putBoolean("success", false);
      localBundle.putString("errCode", paramString);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("success", false);
    localBundle.putString("errCode", paramString);
    this.c.sendMessage(Message.obtain(this.c, 2004, localBundle));
  }
  
  public final void a(String paramString1, String paramString2)
    throws RemoteException
  {
    switch (this.a)
    {
    default: 
      return;
    case 2003: 
      localBundle = new Bundle();
      localBundle.putString("pkgName", this.b);
      localBundle.putBoolean("success", true);
      localBundle.putString("result", paramString1);
      localBundle.putString("reserved", paramString2);
      this.c.sendMessage(Message.obtain(this.c, 2003, localBundle));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("success", true);
    localBundle.putString("result", paramString1);
    localBundle.putString("reserved", paramString2);
    this.c.sendMessage(Message.obtain(this.c, 2004, localBundle));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/hce/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */