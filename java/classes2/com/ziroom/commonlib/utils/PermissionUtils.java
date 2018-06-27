package com.ziroom.commonlib.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class PermissionUtils
{
  private static final List<String> a = ;
  private static PermissionUtils b;
  private b c;
  private c d;
  private a e;
  private d f;
  private Set<String> g = new LinkedHashSet();
  private List<String> h;
  private List<String> i;
  private List<String> j;
  private List<String> k;
  
  private PermissionUtils(String... paramVarArgs)
  {
    int i1 = paramVarArgs.length;
    int m = 0;
    while (m < i1)
    {
      String[] arrayOfString = o.getPermissions(paramVarArgs[m]);
      int i2 = arrayOfString.length;
      int n = 0;
      while (n < i2)
      {
        String str = arrayOfString[n];
        if (a.contains(str)) {
          this.g.add(str);
        }
        n += 1;
      }
      m += 1;
    }
    b = this;
  }
  
  private boolean a(Activity paramActivity)
  {
    if (this.c != null)
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext()) {
        if (paramActivity.shouldShowRequestPermissionRationale((String)localIterator.next()))
        {
          b(paramActivity);
          this.c.rationale(new PermissionUtils.b.a()
          {
            public void again(boolean paramAnonymousBoolean)
            {
              if (paramAnonymousBoolean)
              {
                PermissionUtils.a(PermissionUtils.this);
                return;
              }
              PermissionUtils.b(PermissionUtils.this);
            }
          });
        }
      }
      for (boolean bool = true;; bool = false)
      {
        this.c = null;
        return bool;
      }
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    return (Build.VERSION.SDK_INT < 23) || (ContextCompat.checkSelfPermission(d.a, paramString) == 0);
  }
  
  private void b()
  {
    this.j = new ArrayList();
    this.k = new ArrayList();
    PermissionActivity.start(d.a);
  }
  
  private void b(Activity paramActivity)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (a(str))
      {
        this.i.add(str);
      }
      else
      {
        this.j.add(str);
        if (!paramActivity.shouldShowRequestPermissionRationale(str)) {
          this.k.add(str);
        }
      }
    }
  }
  
  private void c()
  {
    if (this.d != null)
    {
      if ((this.h.size() == 0) || (this.g.size() == this.i.size()))
      {
        this.d.onGranted();
        this.d = null;
      }
    }
    else if (this.e != null)
    {
      if ((this.h.size() != 0) && (this.g.size() != this.i.size())) {
        break label147;
      }
      this.e.onGranted(this.i);
    }
    for (;;)
    {
      this.e = null;
      this.c = null;
      this.f = null;
      return;
      if (this.j.isEmpty()) {
        break;
      }
      this.d.onDenied();
      break;
      label147:
      if (!this.j.isEmpty()) {
        this.e.onDenied(this.k, this.j);
      }
    }
  }
  
  private void c(Activity paramActivity)
  {
    b(paramActivity);
    c();
  }
  
  public static List<String> getPermissions()
  {
    return getPermissions(d.a.getPackageName());
  }
  
  public static List<String> getPermissions(String paramString)
  {
    PackageManager localPackageManager = d.a.getPackageManager();
    try
    {
      paramString = Arrays.asList(localPackageManager.getPackageInfo(paramString, 4096).requestedPermissions);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return Collections.emptyList();
  }
  
  public static boolean isGranted(String... paramVarArgs)
  {
    int n = paramVarArgs.length;
    int m = 0;
    while (m < n)
    {
      if (!a(paramVarArgs[m])) {
        return false;
      }
      m += 1;
    }
    return true;
  }
  
  public static void launchAppDetailsSettings()
  {
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.parse("package:" + d.a.getPackageName()));
    d.a.startActivity(localIntent.addFlags(268435456));
  }
  
  public static PermissionUtils permission(String... paramVarArgs)
  {
    return new PermissionUtils(paramVarArgs);
  }
  
  public PermissionUtils callback(a parama)
  {
    this.e = parama;
    return this;
  }
  
  public PermissionUtils callback(c paramc)
  {
    this.d = paramc;
    return this;
  }
  
  public PermissionUtils rationale(b paramb)
  {
    this.c = paramb;
    return this;
  }
  
  public void request()
  {
    this.i = new ArrayList();
    this.h = new ArrayList();
    if (Build.VERSION.SDK_INT < 23)
    {
      this.i.addAll(this.g);
      c();
      return;
    }
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (a(str)) {
        this.i.add(str);
      } else {
        this.h.add(str);
      }
    }
    if (this.h.isEmpty())
    {
      c();
      return;
    }
    b();
  }
  
  public PermissionUtils theme(d paramd)
  {
    this.f = paramd;
    return this;
  }
  
  public static class PermissionActivity
    extends Activity
  {
    public static void start(Context paramContext)
    {
      Intent localIntent = new Intent(paramContext, PermissionActivity.class);
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
    }
    
    protected void onCreate(Bundle paramBundle)
    {
      if (PermissionUtils.c(PermissionUtils.a()) != null) {
        PermissionUtils.c(PermissionUtils.a()).onActivityCreate(this);
      }
      super.onCreate(paramBundle);
      if (PermissionUtils.a(PermissionUtils.a(), this)) {
        finish();
      }
      while (PermissionUtils.d(PermissionUtils.a()) == null) {
        return;
      }
      int i = PermissionUtils.d(PermissionUtils.a()).size();
      if (i <= 0)
      {
        finish();
        return;
      }
      requestPermissions((String[])PermissionUtils.d(PermissionUtils.a()).toArray(new String[i]), 1);
    }
    
    public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      PermissionUtils.b(PermissionUtils.a(), this);
      finish();
    }
  }
  
  public static abstract interface a
  {
    public abstract void onDenied(List<String> paramList1, List<String> paramList2);
    
    public abstract void onGranted(List<String> paramList);
  }
  
  public static abstract interface b
  {
    public abstract void rationale(a parama);
    
    public static abstract interface a
    {
      public abstract void again(boolean paramBoolean);
    }
  }
  
  public static abstract interface c
  {
    public abstract void onDenied();
    
    public abstract void onGranted();
  }
  
  public static abstract interface d
  {
    public abstract void onActivityCreate(Activity paramActivity);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/PermissionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */