package com.baidu.lbsapi.auth;

import java.util.Hashtable;

class i
  implements Runnable
{
  i(LBSAuthManager paramLBSAuthManager, int paramInt, boolean paramBoolean, String paramString1, String paramString2, Hashtable paramHashtable) {}
  
  public void run()
  {
    if (a.a) {
      a.a("status = " + this.a + "; forced = " + this.b + "checkAK = " + LBSAuthManager.a(this.f, this.c));
    }
    if ((this.a == 601) || (this.b) || (this.a == -1) || (LBSAuthManager.a(this.f, this.c)))
    {
      if (a.a) {
        a.a("authenticate sendAuthRequest");
      }
      String[] arrayOfString = b.b(LBSAuthManager.b());
      if (a.a) {
        a.a("authStrings.length:" + arrayOfString.length);
      }
      if ((arrayOfString != null) && (arrayOfString.length > 1))
      {
        if (a.a) {
          a.a("more sha1 auth");
        }
        LBSAuthManager.a(this.f, this.b, this.d, this.e, arrayOfString, this.c);
        return;
      }
      LBSAuthManager.a(this.f, this.b, this.d, this.e, this.c);
      return;
    }
    if (602 == this.a)
    {
      if (a.a) {
        a.a("authenticate wait  ");
      }
      LBSAuthManager.c().b();
      LBSAuthManager.a(this.f, null, this.c);
      return;
    }
    if (a.a) {
      a.a("authenticate else  ");
    }
    LBSAuthManager.a(this.f, null, this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/lbsapi/auth/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */