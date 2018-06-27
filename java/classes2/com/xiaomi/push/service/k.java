package com.xiaomi.push.service;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.ArrayList;
import java.util.Iterator;

public class k
{
  private static volatile k c;
  private Context a;
  private AccountManager b;
  private ArrayList<a> d;
  private OnAccountsUpdateListener e;
  
  private k(Context paramContext)
  {
    this.a = paramContext;
    if (f.b(this.a))
    {
      this.b = AccountManager.get(this.a);
      this.d = new ArrayList();
    }
  }
  
  public static k a(Context paramContext)
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new k(paramContext);
      }
      return c;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    if ((this.d == null) || (this.d.size() < 1)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).a(paramString, this.a);
      }
    }
  }
  
  private void d()
  {
    if (this.e != null) {
      return;
    }
    this.e = new l(this);
  }
  
  private String e()
  {
    Account localAccount = f.a(this.a);
    if (localAccount == null) {
      return "";
    }
    return localAccount.name;
  }
  
  public void a(a parama)
  {
    if (this.d == null) {
      this.d = new ArrayList();
    }
    if (parama != null)
    {
      int i = this.d.size();
      this.d.add(parama);
      if ((i == 0) && (!a())) {
        b.a("MIIDManager startMIIDUpdateListener failed cause lack of GET_ACCOUNTS permission");
      }
    }
  }
  
  public boolean a()
  {
    try
    {
      if (!f.b(this.a)) {
        return false;
      }
      if (this.e == null) {
        d();
      }
      this.b.addOnAccountsUpdatedListener(this.e, null, true);
      return true;
    }
    catch (Exception localException)
    {
      b.d(localException.toString());
    }
    return false;
  }
  
  public void b()
  {
    if (!f.b(this.a)) {}
    while (this.e == null) {
      return;
    }
    this.b.removeOnAccountsUpdatedListener(this.e);
  }
  
  public void b(a parama)
  {
    if (this.d == null) {}
    do
    {
      do
      {
        return;
      } while (parama == null);
      this.d.remove(parama);
    } while (this.d.size() != 0);
    b();
  }
  
  public String c()
  {
    String str = e();
    if (!TextUtils.isEmpty(str))
    {
      m.a(this.a).a(str);
      return str;
    }
    m.a(this.a).a("0");
    return "0";
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, Context paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */