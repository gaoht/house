package com.unionpay.mobile.android.plugin;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.views.l;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.widgets.m;
import java.util.ArrayList;

public abstract class BaseActivity
  extends Activity
  implements a, b
{
  public static IntentFilter[] FILTERS;
  public static String[][] TECHLISTS;
  private static int f = 0;
  private ArrayList<com.unionpay.mobile.android.nocard.views.b> a = null;
  protected NfcAdapter b;
  private l c = null;
  private a d = null;
  private m e = null;
  private PendingIntent g;
  
  static
  {
    try
    {
      TECHLISTS = new String[][] { { IsoDep.class.getName() }, { NfcV.class.getName() }, { NfcF.class.getName() } };
      FILTERS = new IntentFilter[] { new IntentFilter("android.nfc.action.TECH_DISCOVERED", "*/*") };
      return;
    }
    catch (Exception localException) {}
  }
  
  public Object a(String paramString)
  {
    com.unionpay.mobile.android.model.b localb = null;
    if (paramString == null) {
      localb = this.d.a;
    }
    do
    {
      return localb;
      if (paramString.equalsIgnoreCase(UPPayEngine.class.toString())) {
        return this.d.b;
      }
    } while (!paramString.equalsIgnoreCase(m.class.toString()));
    return this.e;
  }
  
  public final void a(int paramInt)
  {
    int j = this.a.size() - 1;
    int i = j;
    for (;;)
    {
      com.unionpay.mobile.android.nocard.views.b localb;
      if (i >= 0)
      {
        localb = (com.unionpay.mobile.android.nocard.views.b)this.a.get(i);
        if (localb.h() == paramInt)
        {
          localb.r();
          setContentView(localb);
        }
      }
      else
      {
        return;
      }
      if (i == j) {
        localb.s();
      }
      this.a.remove(i);
      i -= 1;
    }
  }
  
  public final void a(com.unionpay.mobile.android.nocard.views.b paramb)
  {
    int i = this.a.size();
    if (i > 0) {
      ((com.unionpay.mobile.android.nocard.views.b)this.a.get(i - 1)).s();
    }
    paramb.r();
    this.a.add(paramb);
    setContentView(paramb);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public final void b()
  {
    int i = this.a.size();
    if (i > 0)
    {
      ((com.unionpay.mobile.android.nocard.views.b)this.a.get(i - 1)).s();
      this.a.remove(i - 1);
      if (this.a.size() != 0)
      {
        ((com.unionpay.mobile.android.nocard.views.b)this.a.get(this.a.size() - 1)).r();
        setContentView((View)this.a.get(this.a.size() - 1));
      }
    }
  }
  
  public final void c()
  {
    if (this.a != null) {
      this.a.clear();
    }
    if (this.c != null) {
      this.c.A();
    }
    this.c = null;
    com.unionpay.mobile.android.languages.c.bD = null;
    com.unionpay.mobile.android.model.b.bk = false;
    com.unionpay.mobile.android.model.b.bb = null;
    com.unionpay.mobile.android.model.b.bl = false;
    int i = f - 1;
    f = i;
    if (i == 0) {
      com.unionpay.mobile.android.resource.c.a(this).a();
    }
    this.e.c();
    this.e = null;
    this.d.b = null;
    this.d.a = null;
    this.d = null;
    ((ViewGroup)getWindow().getDecorView().findViewById(16908290)).removeAllViews();
  }
  
  public final String d()
  {
    return this.d.a.a;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.c != null) {
      this.c.x();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    j.a("uppay", "PayActivityEx.onCreate() +++");
    com.unionpay.mobile.android.languages.c.a();
    com.unionpay.mobile.android.global.a.a(this);
    this.a = new ArrayList(1);
    this.d = new a(e());
    this.e = new m(this);
    com.unionpay.sdk.UPAgent.LOG_ON = false;
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    this.c = ((l)a(1, null));
    setContentView(this.c);
    getWindow().addFlags(8192);
    f += 1;
    j.a("uppay", "PayActivityEx.onCreate() ---");
    if (a())
    {
      this.b = NfcAdapter.getDefaultAdapter(this);
      this.g = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(536870912), 0);
      onNewIntent(getIntent());
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.a.size() > 0) {
        ((com.unionpay.mobile.android.nocard.views.b)this.a.get(this.a.size() - 1)).l();
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if ((a()) && (this.b != null)) {
      this.b.disableForegroundDispatch(this);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.e.a()) {
      this.e.b();
    }
    if ((a()) && (this.b != null)) {
      this.b.enableForegroundDispatch(this, this.g, FILTERS, TECHLISTS);
    }
  }
  
  private final class a
  {
    public com.unionpay.mobile.android.model.b a = null;
    public UPPayEngine b = null;
    
    public a(UPPayEngine paramUPPayEngine)
    {
      this.b = paramUPPayEngine;
      this.b.a(this.a);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/plugin/BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */