package com.unionpay.uppay;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.hce.f;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.views.l;
import com.unionpay.mobile.android.pboctransaction.nfc.b.b;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.pro.views.j;
import com.unionpay.mobile.android.pro.views.k;
import com.unionpay.mobile.android.pro.views.u;
import com.unionpay.mobile.android.pro.views.w;
import com.unionpay.mobile.android.utils.n;

public final class PayActivity
  extends BaseActivity
{
  public static String a = "";
  private com.unionpay.mobile.android.pro.pboc.engine.b c = null;
  private f d = null;
  private n e;
  private k f = null;
  
  static
  {
    System.loadLibrary("entryexpro");
  }
  
  public final com.unionpay.mobile.android.nocard.views.b a(int paramInt, com.unionpay.mobile.android.model.e parame)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      parame = new j(this);
      ((l)parame).a(a());
      return parame;
    case 2: 
      return new u(this, parame);
    case 6: 
      return new w(this, parame);
    case 17: 
      parame = new k(this, parame, (UPPayEngine)a(UPPayEngine.class.toString()));
      this.f = parame;
      this.f.r = d();
      this.f.b(this.b.isEnabled());
      return parame;
    }
    return new com.unionpay.mobile.android.pro.views.a(this, parame, (UPPayEngine)a(UPPayEngine.class.toString()));
  }
  
  public final Object a(String paramString)
  {
    if (com.unionpay.mobile.android.pro.pboc.engine.b.class.toString().equalsIgnoreCase(paramString))
    {
      if (this.c == null) {
        this.c = new com.unionpay.mobile.android.pro.pboc.engine.b(this, d());
      }
      return this.c;
    }
    if (f.class.toString().equalsIgnoreCase(paramString))
    {
      if (this.d == null) {
        this.d = new f(this);
      }
      return this.d;
    }
    return super.a(paramString);
  }
  
  public final boolean a()
  {
    if (Build.VERSION.SDK_INT < 10) {
      return false;
    }
    if (getPackageManager().checkPermission("android.permission.NFC", com.unionpay.mobile.android.utils.e.b(this)) == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    return ((NfcManager)getSystemService("nfc")).getDefaultAdapter() != null;
  }
  
  public final UPPayEngine e()
  {
    this.e = new n(this);
    return this.e;
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.f != null) && (this.f.getParent() != null)) {
      this.f.b(this.b.isEnabled());
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
    if (this.c != null)
    {
      this.c.a();
      this.c = null;
    }
    this.e.g();
    this.e = null;
    this.f = null;
    a = "";
  }
  
  @Instrumented
  protected final void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    Parcelable localParcelable = paramIntent.getParcelableExtra("android.nfc.extra.TAG");
    if (localParcelable != null)
    {
      Log.d("NFCTAG", paramIntent.getAction());
      paramIntent = new b.b(IsoDep.get((Tag)localParcelable));
      paramIntent.a();
      paramIntent = new com.unionpay.mobile.android.pboctransaction.nfc.a((com.unionpay.mobile.android.fully.a)a(UPPayEngine.class.toString()), paramIntent);
      if ((this.f != null) && (this.f.getParent() != null)) {
        this.f.a(paramIntent);
      }
    }
  }
  
  protected final void onResume()
  {
    super.onResume();
    if ((this.f != null) && (this.f.getParent() != null)) {
      this.f.b(this.b.isEnabled());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/uppay/PayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */