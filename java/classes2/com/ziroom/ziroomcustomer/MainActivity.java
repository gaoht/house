package com.ziroom.ziroomcustomer;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.update.UpdateUtil;
import com.ziroom.ziroomcustomer.base.update.UpdateUtil.NeedOtherCheckUpdate;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.home.HomePageFragmentRent;
import com.ziroom.ziroomcustomer.home.HomePageFragmentZYU;
import com.ziroom.ziroomcustomer.minsu.home.SojournHomeFragment;
import com.ziroom.ziroomcustomer.my.MyZiroomFragment;
import com.ziroom.ziroomcustomer.newServiceList.fragment.HomePageServiceFragment;
import com.ziroom.ziroomcustomer.newchat.ChatNewActivity;
import com.ziroom.ziroomcustomer.signed.s;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.c.d.a;
import com.ziroom.ziroomcustomer.util.c.d.b;
import com.ziroom.ziroomcustomer.util.c.d.c;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.ScrollControlerViewPager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static MainActivity b = null;
  private ImageView A;
  private ImageView B;
  private ImageView C;
  private ImageView D;
  private long E;
  private boolean F = false;
  private a G;
  private com.alibaba.fastjson.e H;
  public int a = 0;
  public ScrollControlerViewPager c;
  private int[] d = { 0, 1, 2, 4, 7 };
  private LinearLayout e;
  private TextView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private RelativeLayout u;
  private RelativeLayout v;
  private RelativeLayout w;
  private RelativeLayout x;
  private RelativeLayout y;
  private ImageView z;
  
  private void a()
  {
    if (com.ziroom.ziroomcustomer.util.c.g.checkSkin())
    {
      if (this.a >= 0)
      {
        int i = b(this.a);
        if (i >= 0) {
          updateTabStatus(i);
        }
      }
      return;
    }
    i();
  }
  
  private void a(Intent paramIntent)
  {
    if (this.c == null) {
      return;
    }
    if (paramIntent == null) {}
    for (this.a = this.d[0];; this.a = paramIntent.getIntExtra("FRAGMENT_TYPE", 0))
    {
      if (this.a >= 0)
      {
        int i = b(this.a);
        if (i >= 0) {
          this.c.setCurrentItem(i, false);
        }
      }
      this.F = paramIntent.getBooleanExtra("ISTOLOGIN", false);
      if (!this.F) {
        break;
      }
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      return;
    }
  }
  
  private void a(com.alibaba.fastjson.e parame)
  {
    String str1 = parame.getString("pic");
    String str2 = parame.getString("target");
    parame = parame.getString("activity_id");
    if (!ad.getBoolean(this, "shown_dialog_pic_id_" + parame))
    {
      a(str1, "", str2, "");
      ad.setBoolean(this, "shown_dialog_pic_id_" + parame, true);
    }
  }
  
  private void a(String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    final Dialog localDialog = new Dialog(this, 2131427591);
    View localView = getLayoutInflater().inflate(2130903812, null);
    TextView localTextView = (TextView)localView.findViewById(2131691289);
    final SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)localView.findViewById(2131693816);
    localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(paramString1, new ControllerListener()
    {
      public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable) {}
      
      public void onFinalImageSet(String paramAnonymousString, Object paramAnonymousObject, Animatable paramAnonymousAnimatable)
      {
        paramAnonymousString = (ImageInfo)paramAnonymousObject;
        if (paramAnonymousObject == null) {
          return;
        }
        paramAnonymousObject = localSimpleDraweeView.getLayoutParams();
        ((ViewGroup.LayoutParams)paramAnonymousObject).width = this.b;
        if (this.b * paramAnonymousString.getHeight() / paramAnonymousString.getWidth() > n.dip2px(MainActivity.this, 430.0F)) {}
        for (int i = n.dip2px(MainActivity.this, 430.0F);; i = this.b * paramAnonymousString.getHeight() / paramAnonymousString.getWidth())
        {
          ((ViewGroup.LayoutParams)paramAnonymousObject).height = i;
          localSimpleDraweeView.setLayoutParams((ViewGroup.LayoutParams)paramAnonymousObject);
          return;
        }
      }
      
      public void onIntermediateImageFailed(String paramAnonymousString, Throwable paramAnonymousThrowable) {}
      
      public void onIntermediateImageSet(String paramAnonymousString, Object paramAnonymousObject) {}
      
      public void onRelease(String paramAnonymousString) {}
      
      public void onSubmit(String paramAnonymousString, Object paramAnonymousObject) {}
    }));
    localSimpleDraweeView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = MainActivity.c(MainActivity.this).getString("app");
        if ("0".equals(paramAnonymousView)) {
          JsBridgeWebActivity.start(MainActivity.this, paramString2, paramString3, true, paramString4, "", false);
        }
        for (;;)
        {
          localDialog.dismiss();
          return;
          if (!"1".equals(paramAnonymousView)) {}
        }
      }
    });
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localDialog.dismiss();
      }
    });
    localDialog.setContentView(localView);
    if (!(localDialog instanceof Dialog))
    {
      localDialog.show();
      return;
    }
    VdsAgent.showDialog((Dialog)localDialog);
  }
  
  private int b(int paramInt)
  {
    int i = 0;
    while (i < this.d.length)
    {
      if (this.d[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void b()
  {
    new com.ziroom.ziroomcustomer.util.a().getAdvertisement();
  }
  
  private void e()
  {
    new com.ziroom.ziroomcustomer.f.a(this).checkPgyUpdate(false);
  }
  
  private void f()
  {
    this.z = ((ImageView)findViewById(2131697079));
    this.A = ((ImageView)findViewById(2131697082));
    this.B = ((ImageView)findViewById(2131697085));
    this.C = ((ImageView)findViewById(2131697088));
    this.D = ((ImageView)findViewById(2131696298));
    this.f = ((TextView)findViewById(2131697080));
    this.e = ((LinearLayout)findViewById(2131696284));
    this.g = ((TextView)findViewById(2131697083));
    this.r = ((TextView)findViewById(2131697086));
    this.s = ((TextView)findViewById(2131697089));
    this.t = ((TextView)findViewById(2131696299));
    this.u = ((RelativeLayout)findViewById(2131697078));
    this.v = ((RelativeLayout)findViewById(2131697081));
    this.w = ((RelativeLayout)findViewById(2131697084));
    this.x = ((RelativeLayout)findViewById(2131697087));
    this.y = ((RelativeLayout)findViewById(2131696297));
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
    j();
  }
  
  private void g()
  {
    com.ziroom.ziroomcustomer.util.c.d locald = com.ziroom.ziroomcustomer.util.c.g.getMainTab();
    if (locald != null) {
      if (locald.getColors() != null) {
        if (!ae.notNull(locald.getColors().getColor_button_selected())) {}
      }
    }
    int i;
    for (;;)
    {
      try
      {
        i = Color.parseColor(locald.getColors().getColor_button_selected());
        switch (this.a)
        {
        case 3: 
        case 5: 
        case 6: 
        default: 
          return;
        }
      }
      catch (Exception localException)
      {
        localException.getLocalizedMessage();
        i = Color.parseColor("#444444");
        continue;
      }
      i = Color.parseColor("#444444");
      continue;
      i = Color.parseColor("#444444");
      continue;
      i = Color.parseColor("#444444");
    }
    com.ziroom.ziroomcustomer.util.c.g.setImage(this.z, locald.getImages().getImage_yj_button_selected());
    this.f.setTextColor(i);
    return;
    com.ziroom.ziroomcustomer.util.c.g.setImage(this.A, locald.getImages().getImage_zryu_button_selected());
    this.g.setTextColor(i);
    return;
    com.ziroom.ziroomcustomer.util.c.g.setImage(this.B, locald.getImages().getImage_minsu_button_selected());
    this.r.setTextColor(i);
    return;
    com.ziroom.ziroomcustomer.util.c.g.setImage(this.C, locald.getImages().getImage_service_button_selected());
    this.s.setTextColor(i);
    return;
    com.ziroom.ziroomcustomer.util.c.g.setImage(this.D, locald.getImages().getImage_personalCenter_button_selected());
    this.t.setTextColor(i);
  }
  
  private void h()
  {
    com.ziroom.ziroomcustomer.util.c.d locald = com.ziroom.ziroomcustomer.util.c.g.getMainTab();
    if (locald != null)
    {
      if (locald.getColors() == null) {
        break label367;
      }
      if (!ae.notNull(locald.getColors().getColor_button_normal())) {
        break label344;
      }
    }
    for (;;)
    {
      try
      {
        i = Color.parseColor(locald.getColors().getColor_button_normal());
        j = i;
        if (ae.notNull(locald.getColors().getColor_background())) {}
        try
        {
          this.e.setBackgroundColor(Color.parseColor(locald.getColors().getColor_background()));
          j = i;
        }
        catch (Exception localException2)
        {
          localException2.getLocalizedMessage();
          j = i;
          continue;
        }
        if (locald.getValues() != null)
        {
          if (ae.notNull(locald.getValues().getValue_yj_button())) {
            this.f.setText(locald.getValues().getValue_yj_button());
          }
          if (ae.notNull(locald.getValues().getValue_zryu_button())) {
            this.g.setText(locald.getValues().getValue_zryu_button());
          }
          if (ae.notNull(locald.getValues().getValue_minsu_button())) {
            this.r.setText(locald.getValues().getValue_minsu_button());
          }
          if (ae.notNull(locald.getValues().getValue_service_button())) {
            this.s.setText(locald.getValues().getValue_service_button());
          }
          if (ae.notNull(locald.getValues().getValue_personalCenter_button())) {
            this.t.setText(locald.getValues().getValue_personalCenter_button());
          }
        }
        com.ziroom.ziroomcustomer.util.c.g.setImage(this.z, locald.getImages().getImage_yj_button_normal());
        this.f.setTextColor(j);
        com.ziroom.ziroomcustomer.util.c.g.setImage(this.A, locald.getImages().getImage_zryu_button_normal());
        this.g.setTextColor(j);
        com.ziroom.ziroomcustomer.util.c.g.setImage(this.B, locald.getImages().getImage_minsu_button_normal());
        this.r.setTextColor(j);
        com.ziroom.ziroomcustomer.util.c.g.setImage(this.C, locald.getImages().getImage_service_button_normal());
        this.s.setTextColor(j);
        com.ziroom.ziroomcustomer.util.c.g.setImage(this.D, locald.getImages().getImage_personalCenter_button_normal());
        this.t.setTextColor(j);
        return;
      }
      catch (Exception localException1)
      {
        localException1.getLocalizedMessage();
        i = Color.parseColor("#999999");
        continue;
      }
      label344:
      int i = Color.parseColor("#999999");
      continue;
      label367:
      int j = Color.parseColor("#999999");
    }
  }
  
  private void i()
  {
    this.z.setImageResource(2130840239);
    this.f.setText("合租/整租");
    this.f.setTextColor(Color.parseColor("#999999"));
    this.A.setImageResource(2130840236);
    this.g.setText("自如寓");
    this.g.setTextColor(Color.parseColor("#999999"));
    this.B.setImageResource(2130840260);
    this.r.setText("民宿/驿栈");
    this.r.setTextColor(Color.parseColor("#999999"));
    this.C.setImageResource(2130840269);
    this.s.setText("生活服务");
    this.s.setTextColor(Color.parseColor("#999999"));
    this.D.setImageResource(2130840269);
    this.t.setText("我的");
    this.t.setTextColor(Color.parseColor("#999999"));
    this.e.setBackgroundColor(Color.parseColor("#F9F9F9"));
    switch (this.a)
    {
    case 3: 
    case 5: 
    case 6: 
    default: 
      return;
    case 0: 
      this.f.setTextColor(Color.parseColor("#444444"));
      return;
    case 1: 
      this.g.setTextColor(Color.parseColor("#444444"));
      return;
    case 2: 
      this.r.setTextColor(Color.parseColor("#444444"));
      return;
    case 4: 
      this.s.setTextColor(Color.parseColor("#444444"));
      return;
    }
    this.t.setTextColor(Color.parseColor("#444444"));
  }
  
  private void j()
  {
    this.u.setVisibility(8);
    this.v.setVisibility(8);
    this.w.setVisibility(8);
    this.x.setVisibility(8);
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < this.d.length)
    {
      switch (this.d[i])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(Long.valueOf(0L));
        ((List)localObject).add(new HomePageFragmentRent());
        this.u.setVisibility(0);
        continue;
        localArrayList.add(Long.valueOf(1L));
        ((List)localObject).add(new HomePageFragmentZYU());
        this.v.setVisibility(0);
        continue;
        localArrayList.add(Long.valueOf(2L));
        ((List)localObject).add(SojournHomeFragment.getInstance());
        this.w.setVisibility(0);
        continue;
        localArrayList.add(Long.valueOf(4L));
        ((List)localObject).add(new HomePageServiceFragment());
        this.x.setVisibility(0);
        continue;
        localArrayList.add(Long.valueOf(7L));
        ((List)localObject).add(new MyZiroomFragment());
        this.y.setVisibility(0);
      }
    }
    localObject = new com.ziroom.ziroomcustomer.adapter.c(getSupportFragmentManager(), (List)localObject, localArrayList);
    this.c = ((ScrollControlerViewPager)findViewById(2131691141));
    this.c.setAdapter((PagerAdapter)localObject);
    this.c.setOffscreenPageLimit(this.d.length);
    this.c.setNoScroll(false);
    this.c.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        MainActivity.this.updateTabStatus(paramAnonymousInt);
        MainActivity.a(MainActivity.this, "5slide_tab" + paramAnonymousInt);
      }
    });
  }
  
  private void k()
  {
    if ((ApplicationEx.c.isLoginState()) && (ApplicationEx.c.getContracts() != null))
    {
      if ((ApplicationEx.c.getContracts().size() > 0) && (ApplicationEx.g == 1)) {
        new s(this).showDialog();
      }
      if (((ApplicationEx.g == 1) || (ApplicationEx.g == 2)) && (ApplicationEx.f))
      {
        ApplicationEx.setPackState(1, "MAC_badge");
        ApplicationEx.setPackState(1, "MZFC_badge");
      }
    }
  }
  
  private void l()
  {
    if (com.ziroom.ziroomcustomer.util.c.g.checkSkin())
    {
      h();
      return;
    }
    int i = Color.parseColor("#999999");
    this.z.setImageResource(2130840239);
    this.f.setTextColor(i);
    this.f.setText("合租/整租");
    this.A.setImageResource(2130840236);
    this.g.setTextColor(i);
    this.g.setText("自如寓");
    this.B.setImageResource(2130840260);
    this.r.setTextColor(i);
    this.r.setText("民宿/驿栈");
    this.C.setImageResource(2130840269);
    this.s.setTextColor(i);
    this.s.setText("生活服务");
    this.D.setImageResource(2130840328);
    this.t.setTextColor(i);
    this.t.setText("我的");
  }
  
  private void m()
  {
    j.getCommonJsonGate(this, q.o + q.ad, new com.ziroom.ziroomcustomer.e.a.e(this, new com.ziroom.ziroomcustomer.e.c.d())
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        if (paramAnonymouse != null)
        {
          MainActivity.a(MainActivity.this, paramAnonymouse);
          com.freelxl.baselibrary.f.d.i("MainActivity_ymq", paramAnonymouse.toJSONString());
          if ("1".equals(paramAnonymouse.getString("switch"))) {
            MainActivity.b(MainActivity.this, paramAnonymouse);
          }
        }
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 102) {
      j();
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i = -1;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if (i >= 0)
      {
        i = b(i);
        if (i >= 0) {
          updateTabStatus(i);
        }
      }
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 7;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    if ((getIntent().getFlags() & 0x400000) != 0)
    {
      finish();
      return;
    }
    setContentView(2130903252);
    b = this;
    ad.saveVersion(this, Integer.parseInt(ah.getAppVersion(ApplicationEx.c)));
    f();
    String str = getIntent().getStringExtra("from");
    paramBundle = getIntent().getStringExtra("uid");
    if ((!TextUtils.isEmpty(str)) && (str.equals("steward")))
    {
      str = getIntent().getStringExtra("friendname");
      Intent localIntent = new Intent(this, ChatNewActivity.class);
      localIntent.putExtra("from", "steward");
      localIntent.putExtra("uid", paramBundle);
      localIntent.putExtra("friendname", str);
      startActivity(localIntent);
    }
    k();
    b();
    b("5click_tab1");
    m();
    UpdateUtil.getInstance().checkUpdate(this, false);
    UpdateUtil.getInstance().setNeedOtherCheckUpdate(new UpdateUtil.NeedOtherCheckUpdate()
    {
      public void checkUpdate()
      {
        MainActivity.a(MainActivity.this);
      }
    });
    updateTabStatus(0);
    a(getIntent());
    this.G = new a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.ziroom.ziroomcustomer.main.title");
    registerReceiver(this.G, paramBundle);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131755008, paramMenu);
    return true;
  }
  
  protected void onDestroy()
  {
    if (this.G != null) {
      unregisterReceiver(this.G);
    }
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
    if (paramInt == 4)
    {
      long l = System.currentTimeMillis();
      if (l - this.E > 2000L)
      {
        com.freelxl.baselibrary.f.g.textToast(ApplicationEx.c, "再按一次可退出程序");
        this.E = l;
        return true;
      }
      ApplicationEx.c.AppExit(this);
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  @Instrumented
  protected void onNewIntent(Intent paramIntent)
  {
    VdsAgent.onNewIntent(this, paramIntent);
    super.onNewIntent(paramIntent);
    k();
    a(paramIntent);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    k();
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public void updateTabStatus(int paramInt)
  {
    int i = Color.parseColor("#444444");
    int j = this.d[paramInt];
    this.a = j;
    l();
    this.c.setCurrentItem(paramInt, false);
    if (com.ziroom.ziroomcustomer.util.c.g.checkSkin())
    {
      g();
      return;
    }
    switch (j)
    {
    case 3: 
    case 5: 
    case 6: 
    default: 
      return;
    case 0: 
      this.z.setImageResource(2130840238);
      this.f.setTextColor(i);
      return;
    case 1: 
      this.A.setImageResource(2130840235);
      this.g.setTextColor(i);
      return;
    case 2: 
      this.B.setImageResource(2130840259);
      this.r.setTextColor(i);
      return;
    case 4: 
      this.C.setImageResource(2130840265);
      this.s.setTextColor(i);
      return;
    }
    this.D.setImageResource(2130840327);
    this.t.setTextColor(i);
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      MainActivity.b(MainActivity.this);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */