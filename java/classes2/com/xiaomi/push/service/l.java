package com.xiaomi.push.service;

import android.accounts.Account;
import android.accounts.OnAccountsUpdateListener;
import android.text.TextUtils;

class l
  implements OnAccountsUpdateListener
{
  l(k paramk) {}
  
  public void onAccountsUpdated(Account[] paramArrayOfAccount)
  {
    int j = 0;
    int i;
    Account localAccount;
    if ((paramArrayOfAccount != null) && (paramArrayOfAccount.length > 0))
    {
      int k = paramArrayOfAccount.length;
      i = 0;
      if (i >= k) {
        break label222;
      }
      localAccount = paramArrayOfAccount[i];
      if ((localAccount == null) || (!TextUtils.equals("com.xiaomi", localAccount.type))) {
        break label122;
      }
    }
    label122:
    label222:
    for (paramArrayOfAccount = localAccount;; paramArrayOfAccount = null)
    {
      i = j;
      if (paramArrayOfAccount != null)
      {
        i = j;
        if (!TextUtils.isEmpty(paramArrayOfAccount.name)) {
          i = 1;
        }
      }
      boolean bool = m.a(k.a(this.a)).c();
      if ((i != 0) && (!bool))
      {
        m.a(k.a(this.a)).a(paramArrayOfAccount.name);
        k.a(this.a, paramArrayOfAccount.name);
      }
      do
      {
        return;
        i += 1;
        break;
        if ((i == 0) && (bool))
        {
          m.a(k.a(this.a)).a();
          k.a(this.a, "0");
          return;
        }
      } while ((i == 0) || (!bool) || (TextUtils.equals(m.a(k.a(this.a)).b(), paramArrayOfAccount.name)));
      m.a(k.a(this.a)).a(paramArrayOfAccount.name);
      k.a(this.a, paramArrayOfAccount.name);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */