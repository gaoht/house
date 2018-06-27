package com.ziroom.ziroomcustomer.home;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newchat.ChatNewActivity;
import com.ziroom.ziroomcustomer.signed.HandleSureFragment;
import java.util.HashMap;
import java.util.LinkedList;

public class MainFragmentActivity
  extends BaseActivity
{
  public DrawerLayout a;
  public HashMap<String, Object> b;
  public String c;
  public String d;
  public String e;
  private long f;
  private MainFragmentActivity g;
  private FragmentManager r;
  private MenuFragment s;
  private Fragment t;
  private Fragment u;
  private Fragment v;
  private Fragment w;
  private LinkedList<Integer> x;
  private String y;
  
  private void a() {}
  
  private void a(FragmentTransaction paramFragmentTransaction)
  {
    if (this.t != null) {
      paramFragmentTransaction.hide(this.t);
    }
    if (this.v != null) {
      paramFragmentTransaction.hide(this.v);
    }
    if (this.u != null) {
      paramFragmentTransaction.hide(this.u);
    }
    if (this.w != null) {
      paramFragmentTransaction.hide(this.w);
    }
  }
  
  private void b()
  {
    this.r = getSupportFragmentManager();
    this.a = ((DrawerLayout)findViewById(2131696755));
    this.y = getIntent().getStringExtra("wuyesure");
    this.c = getIntent().getStringExtra("contract_part_code");
  }
  
  public void addViewIndex(int paramInt)
  {
    if ((this.x.size() > 0) && (((Integer)this.x.getLast()).intValue() == paramInt)) {
      return;
    }
    this.x.add(Integer.valueOf(paramInt));
  }
  
  public int getAppVersion()
  {
    PackageManager localPackageManager = getPackageManager();
    try
    {
      int i = localPackageManager.getPackageInfo(getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return 1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904860);
    this.g = this;
    this.x = new LinkedList();
    b();
    a();
    switchCurrentFragment(4);
    if (!TextUtils.isEmpty(this.y))
    {
      this.b = ((HashMap)getIntent().getSerializableExtra("bts_map"));
      this.d = getIntent().getStringExtra("lease");
      this.e = getIntent().getStringExtra("leas");
      Log.e("wuyejiaoge", "* *****MainFragmentActivity**contract_code****** ======  " + this.c);
      switchCurrentFragment(5);
    }
    do
    {
      return;
      switchCurrentFragment(1);
      localObject = getIntent().getStringExtra("from");
      paramBundle = getIntent().getStringExtra("uid");
    } while ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals("steward")));
    Object localObject = new Intent(this, ChatNewActivity.class);
    ((Intent)localObject).putExtra("from", "steward");
    ((Intent)localObject).putExtra("uid", paramBundle);
    startActivity((Intent)localObject);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (TextUtils.isEmpty(this.y)))
    {
      if (this.x.size() > 1)
      {
        this.x.removeLast();
        switchCurrentFragment(((Integer)this.x.getLast()).intValue());
        return true;
      }
      long l = System.currentTimeMillis();
      if (l - this.f > 2000L)
      {
        g.textToast(this, "再按一次可退出程序", 0);
        this.f = l;
        return true;
      }
      ApplicationEx.c.AppExit(this);
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
  
  public void openMenu()
  {
    this.a.openDrawer(8388611);
  }
  
  public void switchCurrentFragment(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.r.beginTransaction();
    a(localFragmentTransaction);
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 3: 
    default: 
    case 0: 
    case 4: 
      for (;;)
      {
        localFragmentTransaction.commit();
        return;
        if (this.t == null) {
          localFragmentTransaction.add(2131691097, this.t);
        }
        for (;;)
        {
          addViewIndex(paramInt);
          break;
          localFragmentTransaction.show(this.t);
        }
        if (this.s != null) {
          localFragmentTransaction.hide(this.s);
        }
        if (this.s == null)
        {
          this.s = new MenuFragment();
          localFragmentTransaction.add(2131694476, this.s);
        }
        else
        {
          localFragmentTransaction.show(this.s);
        }
      }
    }
    if (this.w == null)
    {
      this.w = new HandleSureFragment();
      localFragmentTransaction.add(2131691097, this.w);
    }
    for (;;)
    {
      addViewIndex(paramInt);
      break;
      localFragmentTransaction.show(this.w);
    }
  }
  
  public void updateHead()
  {
    if (this.s != null) {
      this.s.updateHead();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/MainFragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */