package com.ziroom.ziroomcustomer.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.support.multidex.MultiDexApplication;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.parser.Feature;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.SDKInitializer;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskCacheConfig.Builder;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig.Builder;
import com.facebook.imagepipeline.listener.RequestLoggingListener;
import com.freelxl.baselibrary.f.i;
import com.growingio.android.sdk.collection.Configuration;
import com.growingio.android.sdk.collection.GrowingIO;
import com.hyphenate.EMConnectionListener;
import com.hyphenate.EMGroupChangeListener;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMGroupManager;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Type;
import com.hyphenate.chat.EMMucSharedFile;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.chat.EMPushManager;
import com.hyphenate.util.NetUtils;
import com.itrus.raapi.implement.ClientForAndroid;
import com.mato.sdk.proxy.Proxy;
import com.tencent.smtt.sdk.QbSdk;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.MobclickAgent.UMAnalyticsConfig;
import com.ziroom.commonlib.utils.h;
import com.ziroom.commonlib.utils.q;
import com.ziroom.commonlibrary.login.a.c;
import com.ziroom.ziroomcustomer.WelcomeActivity;
import com.ziroom.ziroomcustomer.activity.FiveYearWebViewActivity;
import com.ziroom.ziroomcustomer.minsu.chat.MinsuChatActivity;
import com.ziroom.ziroomcustomer.minsu.chat.MinsuGroupChatActivity;
import com.ziroom.ziroomcustomer.minsu.chat.b.a;
import com.ziroom.ziroomcustomer.model.AlternateListing;
import com.ziroom.ziroomcustomer.model.AreaInfo;
import com.ziroom.ziroomcustomer.model.CleanDailyService;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.HomeIndex;
import com.ziroom.ziroomcustomer.model.HouseListSearchResult;
import com.ziroom.ziroomcustomer.model.IkeyRaConfig;
import com.ziroom.ziroomcustomer.model.MHExplain;
import com.ziroom.ziroomcustomer.model.MapMoveHouse;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.model.ax;
import com.ziroom.ziroomcustomer.service.LoginReceiver;
import com.ziroom.ziroomcustomer.service.MyMessageReceiver;
import com.ziroom.ziroomcustomer.service.f;
import com.ziroom.ziroomcustomer.signed.s;
import com.ziroom.ziroomcustomer.social.activity.zz.ZzSocialFriendListActivity;
import com.ziroom.ziroomcustomer.util.MessageUtil;
import com.ziroom.ziroomcustomer.util.ab;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.c.c.a;
import com.ziroom.ziroomcustomer.util.c.g;
import com.ziroom.ziroomcustomer.util.t;
import com.ziroom.ziroomcustomer.util.t.a;
import com.ziroom.ziroomcustomer.util.y;
import com.ziroom.ziroomcustomer.widget.BadgeView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import okhttp3.OkHttpClient;

public class ApplicationEx
  extends MultiDexApplication
  implements Thread.UncaughtExceptionHandler
{
  public static String a = "ApplicationEx";
  public static PendingIntent b;
  public static ApplicationEx c = null;
  public static boolean d;
  public static boolean e;
  public static boolean f = false;
  public static int g;
  public static String h;
  public static String i;
  public static Map<String, BadgeView> j;
  private static final String q = c() + "ziroom.txt";
  private static Stack<Activity> r;
  private static HashMap<String, Object> s;
  private static List<WeakReference<Activity>> u;
  private String A = "";
  private AreaInfo B;
  private MHExplain C;
  private ArrayList<HouseListSearchResult> D;
  private ArrayList<HomeIndex> E;
  private List<CleanDailyService> F;
  private List<MapMoveHouse> G;
  private double[] H;
  private BDLocation I;
  private String J;
  private long K = -1L;
  private String L = "";
  private boolean M;
  private boolean N;
  private String O;
  private List<Activity> P;
  private com.ziroom.ziroomcustomer.minsu.chat.b Q;
  private int R;
  private int S;
  private List<ax> T;
  private boolean U;
  private MyMessageReceiver V;
  private List<Activity> W = new ArrayList();
  private Handler X = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      com.ziroom.ziroomcustomer.e.l locall = (com.ziroom.ziroomcustomer.e.l)paramAnonymousMessage.obj;
      int i;
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 4145: 
        do
        {
          do
          {
            return;
          } while (!locall.getSuccess().booleanValue());
          paramAnonymousMessage = (List)locall.getObject();
        } while ((paramAnonymousMessage == null) || (paramAnonymousMessage.size() <= 0));
        ApplicationEx.this.setContracts(paramAnonymousMessage);
        i = 0;
        paramAnonymousMessage = paramAnonymousMessage.iterator();
        label89:
        if (paramAnonymousMessage.hasNext())
        {
          if (!"0".equals(((Contract)paramAnonymousMessage.next()).getIsZiroom())) {
            break label182;
          }
          i = 1;
        }
        break;
      }
      label182:
      for (;;)
      {
        break label89;
        if (i == 0) {
          break;
        }
        new s(ApplicationEx.this.getApplicationContext()).getTurnSign();
        return;
        if (!locall.getSuccess().booleanValue()) {
          break;
        }
        paramAnonymousMessage = (com.alibaba.fastjson.e)locall.getObject();
        ApplicationEx.h = paramAnonymousMessage.getString("title");
        ApplicationEx.i = paramAnonymousMessage.getString("content");
        return;
      }
    }
  };
  private int Y;
  private String Z;
  private String aa;
  private com.freelxl.baselibrary.d.c.a<UserInfo> ab = new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.x())
  {
    public void onFailure(Throwable paramAnonymousThrowable) {}
    
    public void onSuccess(int paramAnonymousInt, UserInfo paramAnonymousUserInfo)
    {
      ApplicationEx.this.setUser(paramAnonymousUserInfo);
      if ((paramAnonymousUserInfo != null) && (ae.notNull(paramAnonymousUserInfo.getUid())))
      {
        com.ziroom.ziroomcustomer.e.d.getContract(ApplicationEx.c, ApplicationEx.d(ApplicationEx.this), paramAnonymousUserInfo.getUid());
        if (!ae.isNull(ApplicationEx.e(ApplicationEx.this))) {}
      }
    }
  };
  private long ac;
  private boolean ad = false;
  private boolean ae = false;
  private Handler af = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if ((ApplicationEx.i(ApplicationEx.this)) && (ApplicationEx.j(ApplicationEx.this)))
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", " 开始同步 环信");
        com.ziroom.ziroomcustomer.minsu.chat.j.syncImList(ApplicationEx.c, 1);
      }
    }
  };
  private BroadcastReceiver ag = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (g.checkSkin())
      {
        com.freelxl.baselibrary.widget.a.setImageGif(g.a + com.ziroom.ziroomcustomer.util.ad.getSkinSign(ApplicationEx.c) + "/" + g.getLoadingJson().getResources().getResource_refreshJson());
        return;
      }
      com.freelxl.baselibrary.widget.a.setImageGif(null);
    }
  };
  public ClientForAndroid k;
  public IkeyRaConfig l;
  public HashMap<String, String> m;
  public int n;
  public BroadcastReceiver o = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("type", 0);
      int j = paramAnonymousIntent.getIntExtra("status", 0);
      com.ziroom.ziroomcustomer.util.u.e("huanxin", "  环信 = " + EMClient.getInstance().isLoggedInBefore());
      if ((i == 17) && (j == 1))
      {
        ApplicationEx.a(ApplicationEx.this, true);
        ApplicationEx.h(ApplicationEx.this).sendEmptyMessage(1);
      }
    }
  };
  public BroadcastReceiver p = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      ApplicationEx.b(ApplicationEx.this, true);
      ApplicationEx.h(ApplicationEx.this).sendEmptyMessage(1);
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", " 登录 成功 了  ！ 登陆 环信");
    }
  };
  private final Object t = new Object();
  private UserInfo v;
  private String w;
  private boolean x;
  private Activity y;
  private List<Contract> z = null;
  
  private void a(int paramInt, com.alibaba.fastjson.b paramb)
  {
    HashMap localHashMap = new HashMap();
    if ((paramb != null) && (paramb.size() > 0))
    {
      paramb = paramb.iterator();
      while (paramb.hasNext())
      {
        Object localObject = (com.alibaba.fastjson.e)paramb.next();
        String str = ((com.alibaba.fastjson.e)localObject).getString("source");
        localObject = ((com.alibaba.fastjson.e)localObject).getString("mona");
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          localHashMap.put(str, localObject);
        }
      }
      com.ziroom.ziroomcustomer.util.x.init(localHashMap, paramInt);
    }
  }
  
  private void a(Context paramContext)
  {
    int i1 = Process.myPid();
    String str = com.ziroom.ziroomcustomer.util.j.getInstance().getAppName(i1, paramContext);
    if ((str == null) || (!str.equalsIgnoreCase(paramContext.getPackageName())))
    {
      com.ziroom.ziroomcustomer.util.u.e(a, "enter the service process!");
      return;
    }
    paramContext = new EMOptions();
    paramContext.setAcceptInvitationAlways(false);
    paramContext.setRequireAck(true);
    paramContext.setSortMessageByServerTime(true);
    paramContext.setRequireDeliveryAck(false);
    if (com.ziroom.ziroomcustomer.util.b.isEMUI()) {
      com.ziroom.ziroomcustomer.util.u.e("huanxin", "  初始化 huawei推送 ");
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.util.u.e("huanxin", "ApplicationEx ----Login-----初始化成功了 ");
      if (EMClient.getInstance() != null)
      {
        if (this != null) {
          EMClient.getInstance().init(getApplicationContext(), paramContext);
        }
        EMClient.getInstance().setDebugMode(false);
      }
      b();
      a();
      l();
      initNotifier();
      return;
      if (com.ziroom.ziroomcustomer.util.b.isMIUI())
      {
        com.ziroom.ziroomcustomer.util.u.e("huanxin", "  初始化 xiaomi推送 ");
        paramContext.setMipushConfig("2882303761517229920", "5241722961920");
        h();
      }
    }
  }
  
  private HashMap<String, String> b(Context paramContext)
  {
    paramContext = new LinkedHashMap();
    paramContext.put("time", com.ziroom.ziroomcustomer.util.m.GetNowDateTime());
    paramContext.put("MANUFACTURER", Build.MANUFACTURER);
    paramContext.put("versionName", "5.6.0");
    paramContext.put("versionCode", "131");
    paramContext.put("MODEL", String.valueOf(Build.MODEL));
    paramContext.put("SDK_INT", String.valueOf(Build.VERSION.SDK_INT));
    return paramContext;
  }
  
  private static String c()
  {
    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
  }
  
  private void d()
  {
    Object localObject = com.ziroom.ziroomcustomer.util.ad.getNetPicConfig(this);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = com.alibaba.fastjson.e.parseObject((String)localObject);
      String str = ((com.alibaba.fastjson.e)localObject).getString("maa_switch");
      if ((!TextUtils.isEmpty(str)) && ("on".equals(str))) {
        e();
      }
      str = ((com.alibaba.fastjson.e)localObject).getString("mona_switch");
      if ((TextUtils.isEmpty(str)) || (!"on".equals(str))) {
        break label112;
      }
      a(((com.alibaba.fastjson.e)localObject).getInteger("mona_compression_ratio").intValue(), ((com.alibaba.fastjson.e)localObject).getJSONArray("mona_domain_mapping"));
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.e.j.getNetPicConfig(this, new com.freelxl.baselibrary.d.c.c(new com.ziroom.ziroomcustomer.e.c.d())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          com.ziroom.ziroomcustomer.util.ad.saveNetPicConfig(ApplicationEx.this, "");
        }
        
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          if (paramAnonymouse != null)
          {
            com.ziroom.ziroomcustomer.util.ad.saveNetPicConfig(ApplicationEx.this, paramAnonymouse.toJSONString());
            String str = paramAnonymouse.getString("maa_switch");
            if ((!TextUtils.isEmpty(str)) && ("on".equals(str))) {
              ApplicationEx.a(ApplicationEx.this);
            }
            str = paramAnonymouse.getString("mona_switch");
            if ((!TextUtils.isEmpty(str)) && ("on".equals(str)))
            {
              paramAnonymousInt = paramAnonymouse.getInteger("mona_compression_ratio").intValue();
              paramAnonymouse = paramAnonymouse.getJSONArray("mona_domain_mapping");
              ApplicationEx.a(ApplicationEx.this, paramAnonymousInt, paramAnonymouse);
            }
          }
          else
          {
            return;
          }
          ApplicationEx.a(ApplicationEx.this, 100, null);
        }
      });
      return;
      label112:
      a(100, null);
    }
  }
  
  public static void deleteBadgeView()
  {
    if ((j != null) && (j.size() > 0))
    {
      Iterator localIterator = j.values().iterator();
      while (localIterator.hasNext()) {
        ((BadgeView)localIterator.next()).hide();
      }
    }
  }
  
  private void e()
  {
    Log.d("Maa", "===" + Proxy.start(this));
  }
  
  private void f()
  {
    com.ziroom.commonlibrary.login.a.verifyToken(this, new a.c()
    {
      public void onVerifyFinish(boolean paramAnonymousBoolean)
      {
        com.freelxl.baselibrary.f.d.d("ApplicationEx", "=====user:" + paramAnonymousBoolean + ":" + this.a);
        UserInfo localUserInfo;
        Object localObject;
        if ((paramAnonymousBoolean) && (this.a != null))
        {
          localUserInfo = com.ziroom.ziroomcustomer.b.u.queryUserInfo(ApplicationEx.c, this.a);
          StringBuilder localStringBuilder = new StringBuilder().append("=====user:");
          if (localUserInfo == null)
          {
            localObject = "null";
            com.freelxl.baselibrary.f.d.d("ApplicationEx", (String)localObject);
            ApplicationEx.this.setUser(localUserInfo);
            localObject = (com.ziroom.commonlib.a.d)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(localUserInfo), new ApplicationEx.14.1(this), new Feature[0]);
            com.ziroom.commonlib.utils.l.d("转换之后的bean ", localObject.toString());
            com.ziroom.commonlib.utils.b.setUserInfo((com.ziroom.commonlib.a.d)localObject);
            localObject = com.ziroom.ziroomcustomer.b.d.query(ApplicationEx.c, this.a);
            if ((localObject != null) && (((List)localObject).size() > 0)) {
              ApplicationEx.this.setContracts((List)localObject);
            }
            ApplicationEx.this.setLoginState(true);
            if (ae.notNull(this.a)) {
              com.ziroom.ziroomcustomer.e.j.getUserInfo(ApplicationEx.c, com.ziroom.commonlibrary.login.a.getToken(ApplicationEx.c), ApplicationEx.b(ApplicationEx.this));
            }
          }
        }
        for (;;)
        {
          ApplicationEx.c(ApplicationEx.this);
          return;
          localObject = localUserInfo.getNickName();
          break;
          com.ziroom.ziroomcustomer.util.ad.clearUser(ApplicationEx.c);
          ApplicationEx.this.setLoginState(false);
          ApplicationEx.deleteBadgeView();
        }
      }
    });
    com.ziroom.ziroomcustomer.e.d.getText(this.X);
  }
  
  private void g()
  {
    b.initCity();
    com.ziroom.commonlib.utils.c.initCity();
    t.addListener(new t.a()
    {
      public void onReceiveLocation(boolean paramAnonymousBoolean, BDLocation paramAnonymousBDLocation)
      {
        com.ziroom.ziroomcustomer.util.u.d("Application", "onReceiveLocation:" + paramAnonymousBoolean);
        Object localObject = b.getCityCodeFromSP();
        String str;
        if ((paramAnonymousBoolean) && (paramAnonymousBDLocation != null) && (!TextUtils.isEmpty(paramAnonymousBDLocation.getCity())))
        {
          str = paramAnonymousBDLocation.getCity();
          if (!str.endsWith("市")) {
            break label274;
          }
          str = str.substring(0, str.length() - 1);
        }
        label274:
        for (;;)
        {
          com.ziroom.ziroomcustomer.util.u.d("Application", "onReceiveLocation:" + str);
          y.putString(ApplicationEx.c, "zr_lat_key", paramAnonymousBDLocation.getLatitude() + "");
          y.putString(ApplicationEx.c, "zr_lng_key", paramAnonymousBDLocation.getLongitude() + "");
          y.putString(ApplicationEx.c, "zr_geo_city_key", str);
          y.putString(ApplicationEx.c, "zr_geo_address_key", paramAnonymousBDLocation.getAddrStr());
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            paramAnonymousBDLocation = b.getCityList().iterator();
            while (paramAnonymousBDLocation.hasNext())
            {
              localObject = (com.ziroom.ziroomcustomer.base.a.b)paramAnonymousBDLocation.next();
              if (((com.ziroom.ziroomcustomer.base.a.b)localObject).getName().equals(str)) {
                b.changeCity(((com.ziroom.ziroomcustomer.base.a.b)localObject).getCode());
              }
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              b.changeCity("110000");
            }
            do
            {
              return;
            } while (!TextUtils.isEmpty((CharSequence)localObject));
            b.changeCity("110000");
            return;
          }
        }
      }
    });
    t.startLocate();
  }
  
  private void h()
  {
    this.ac = SystemClock.elapsedRealtime();
  }
  
  private long i()
  {
    return SystemClock.elapsedRealtime() - this.ac;
  }
  
  private void j()
  {
    try
    {
      if (EMClient.getInstance() != null)
      {
        Field localField = EMClient.class.getDeclaredField("sdkInited");
        localField.setAccessible(true);
        if (((Boolean)localField.get(EMClient.getInstance())).booleanValue()) {
          com.ziroom.ziroomcustomer.newchat.a.register(this);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void k()
  {
    Intent localIntent = new Intent(getString(2131296569));
    LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
    com.ziroom.commonlibrary.login.a.logoutNoProgress(c, new com.ziroom.commonlibrary.login.a.a()
    {
      public void onLogoutFinish(boolean paramAnonymousBoolean) {}
    });
    setImconnect(false);
    if (FiveYearWebViewActivity.b != 10) {
      com.ziroom.ziroomcustomer.minsu.f.ad.showImDialog(null);
    }
  }
  
  private void l()
  {
    this.V = MyMessageReceiver.getInstance();
    this.V.setApplicationContext(getApplicationContext());
    IntentFilter localIntentFilter = new IntentFilter();
    try
    {
      localIntentFilter.setPriority(3);
      localIntentFilter.setPriority(1000);
      localIntentFilter.addAction("com.ziroom.ziroomcustomer.MESSAGE_RECEIVED_ACTION");
      registerReceiver(this.V, localIntentFilter);
      localIntentFilter = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
      LocalBroadcastManager.getInstance(this).registerReceiver(this.o, localIntentFilter);
      localIntentFilter = new IntentFilter("action_em_login_succ");
      LocalBroadcastManager.getInstance(this).registerReceiver(this.p, localIntentFilter);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.ziroom.ziroomcustomer.main.title");
      registerReceiver(this.ag, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.ziroom.ziroomcustomer.util.u.e("huanxin", "--ApplicationEx-------receiveMsgBroadCast------Exception-- ");
        localException.printStackTrace();
      }
    }
  }
  
  private void m()
  {
    com.ziroom.ziroomcustomer.d.a.a.a = getResources().getDrawable(2130838864);
    com.ziroom.ziroomcustomer.d.a.a.b = getResources().getDrawable(2130838349);
  }
  
  public static void setBadgeView(BadgeView paramBadgeView, String paramString)
  {
    if (j == null) {
      j = new HashMap();
    }
    j.put(paramString, paramBadgeView);
  }
  
  public static void setPackState(int paramInt, String paramString)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        if ((j != null) && (j.get(paramString) != null))
        {
          if (!"MA_badge".equals(paramString)) {
            continue;
          }
          d = false;
          if (!e) {
            ((BadgeView)j.get(paramString)).hide();
          }
        }
        return;
        if ("MAC_badge".equals(paramString))
        {
          d = false;
          if (d) {
            continue;
          }
          ((BadgeView)j.get(paramString)).hide();
          continue;
        }
        ((BadgeView)j.get(paramString)).hide();
      }
      finally {}
      continue;
      if ((paramInt == 1) && (j != null) && (j.get(paramString) != null)) {
        if ("MA_badge".equals(paramString))
        {
          d = true;
          if (!((BadgeView)j.get("MAC_badge")).isShown()) {
            ((BadgeView)j.get(paramString)).show();
          }
        }
        else if ("MAC_badge".equals(paramString))
        {
          e = true;
          if (!((BadgeView)j.get("MA_badge")).isShown()) {
            ((BadgeView)j.get(paramString)).show();
          }
        }
        else
        {
          ((BadgeView)j.get(paramString)).show();
        }
      }
    }
  }
  
  public void AppExit(Context paramContext)
  {
    try
    {
      ((ActivityManager)paramContext.getSystemService("activity")).restartPackage(paramContext.getPackageName());
      return;
    }
    catch (Exception paramContext) {}
  }
  
  protected void a()
  {
    com.ziroom.ziroomcustomer.util.u.d(a, "init listener");
    EMConnectionListener local17 = new EMConnectionListener()
    {
      public void onConnected()
      {
        com.ziroom.ziroomcustomer.util.u.e("huanxin", "ApplicationEx --IM ConnectionListener---onConnected-- ");
        ApplicationEx.this.setImconnect(true);
      }
      
      public void onDisconnected(int paramAnonymousInt)
      {
        com.ziroom.ziroomcustomer.util.u.e("huanxin", "error = " + paramAnonymousInt);
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", "onDisconnected  Thread name = " + Thread.currentThread().getName() + " thread id = " + Thread.currentThread().getId() + " is main = " + ApplicationEx.this.getMainLooper().isCurrentThread());
        if (paramAnonymousInt == 207)
        {
          com.ziroom.ziroomcustomer.util.u.e("huanxin", "ApplicationEx ----IM ConnectionListener-----显示帐号已经被移除 ");
          ApplicationEx.this.setImconnect(false);
          return;
        }
        if (paramAnonymousInt == 206)
        {
          com.ziroom.ziroomcustomer.util.u.e("huanxin", "ApplicationEx---IM ConnectionListener -------显示帐号在其他设备登陆dialog2 ");
          try
          {
            com.ziroom.ziroomcustomer.newchat.a.logout4T(ApplicationEx.c, new ApplicationEx.17.1(this));
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            return;
          }
        }
        if (NetUtils.hasNetwork(ApplicationEx.c))
        {
          com.ziroom.ziroomcustomer.util.u.e("huanxin", "ApplicationEx ----IM ConnectionListener-----连接不到聊天服务器 ");
          ApplicationEx.this.setImconnect(false);
          return;
        }
        com.ziroom.ziroomcustomer.util.u.e("huanxin", "ApplicationEx ----IM ConnectionListener-----当前网络不可用，请检查网络设置 ");
      }
    };
    EMClient.getInstance().addConnectionListener(local17);
  }
  
  protected void a(Throwable paramThrowable)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1 = b(getApplicationContext()).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = (String)((Map.Entry)localObject3).getKey();
      localObject3 = (String)((Map.Entry)localObject3).getValue();
      localStringBuffer.append((String)localObject2).append(" = ").append((String)localObject3).append("\n");
    }
    localStringBuffer.append("\n\n");
    localObject1 = new StringWriter();
    Object localObject2 = new PrintWriter((Writer)localObject1);
    paramThrowable.printStackTrace((PrintWriter)localObject2);
    ((PrintWriter)localObject2).close();
    localStringBuffer.append(((StringWriter)localObject1).toString());
    Log.e(a, ((StringWriter)localObject1).toString());
    paramThrowable = new File(com.ziroom.ziroomcoloreggs.eggs.a.c);
    if (!paramThrowable.exists()) {
      paramThrowable.mkdirs();
    }
    paramThrowable = new File(paramThrowable, q);
    if (paramThrowable.exists()) {
      localStringBuffer.insert(0, "\n\n--------------------------------\n\n");
    }
    try
    {
      paramThrowable = new FileOutputStream(paramThrowable, true);
      paramThrowable.write(localStringBuffer.toString().getBytes());
      paramThrowable.close();
      return;
    }
    catch (FileNotFoundException paramThrowable)
    {
      paramThrowable.printStackTrace();
      return;
    }
    catch (IOException paramThrowable)
    {
      paramThrowable.printStackTrace();
    }
  }
  
  public void addActivity(Activity paramActivity)
  {
    if (r == null) {
      r = new Stack();
    }
    r.add(paramActivity);
  }
  
  public void addToZryuSign(Activity paramActivity)
  {
    if (u == null) {
      u = new ArrayList();
    }
    if (paramActivity != null) {
      u.add(new WeakReference(paramActivity));
    }
  }
  
  protected void b()
  {
    EMMessageListener local4 = new EMMessageListener()
    {
      public void onCmdMessageReceived(List<EMMessage> paramAnonymousList) {}
      
      public void onMessageChanged(EMMessage paramAnonymousEMMessage, Object paramAnonymousObject)
      {
        LocalBroadcastManager.getInstance(ApplicationEx.c).sendBroadcast(new Intent(ApplicationEx.this.getString(2131296572)));
      }
      
      public void onMessageDelivered(List<EMMessage> paramAnonymousList)
      {
        LocalBroadcastManager.getInstance(ApplicationEx.c).sendBroadcast(new Intent(ApplicationEx.this.getString(2131296572)));
      }
      
      public void onMessageRead(List<EMMessage> paramAnonymousList)
      {
        LocalBroadcastManager.getInstance(ApplicationEx.c).sendBroadcast(new Intent(ApplicationEx.this.getString(2131296572)));
      }
      
      public void onMessageRecalled(List<EMMessage> paramAnonymousList) {}
      
      public void onMessageReceived(List<EMMessage> paramAnonymousList)
      {
        com.ziroom.ziroomcustomer.minsu.chat.j.logMsg(paramAnonymousList);
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          EMMessage localEMMessage = (EMMessage)paramAnonymousList.next();
          com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz_xiaomi", " msg id = " + localEMMessage.getMsgId() + " " + ApplicationEx.g(ApplicationEx.this));
          if (!com.ziroom.ziroomcustomer.util.j.getInstance().hasActivity())
          {
            List localList = EMClient.getInstance().pushManager().getNoPushGroups();
            if ((localEMMessage.getChatType() != EMMessage.ChatType.GroupChat) || (localList == null) || (!localList.contains(localEMMessage.getTo()))) {
              if ((com.ziroom.ziroomcustomer.util.b.isMIUI()) && (ApplicationEx.g(ApplicationEx.this) < 3000L))
              {
                new Handler(Looper.getMainLooper()).postDelayed(new ApplicationEx.4.1(this, localEMMessage), 700L);
              }
              else
              {
                com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("wz_xiaomi", " msg id ******* = " + localEMMessage.getMsgId());
                com.ziroom.ziroomcustomer.util.j.getInstance().getChatNewMsg(ApplicationEx.this.getApplicationContext(), localEMMessage.getMsgId(), localEMMessage.getFrom());
              }
            }
          }
        }
        LocalBroadcastManager.getInstance(ApplicationEx.c).sendBroadcast(new Intent(ApplicationEx.this.getString(2131296572)));
      }
    };
    EMGroupChangeListener local5 = new EMGroupChangeListener()
    {
      public void onAdminAdded(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public void onAdminRemoved(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public void onAnnouncementChanged(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public void onAutoAcceptInvitationFromGroup(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        com.ziroom.ziroomcustomer.minsu.chat.d.c.loadIM();
        com.ziroom.ziroomcustomer.minsu.chat.d.c.sendGroupsChange(ApplicationEx.c);
      }
      
      public void onGroupDestroyed(String paramAnonymousString1, String paramAnonymousString2)
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin wz_info ");
        com.ziroom.ziroomcustomer.minsu.chat.d.c.sendExitGroup(ApplicationEx.c, paramAnonymousString1);
      }
      
      public void onInvitationAccepted(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3) {}
      
      public void onInvitationDeclined(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3) {}
      
      public void onInvitationReceived(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4) {}
      
      public void onMemberExited(String paramAnonymousString1, String paramAnonymousString2)
      {
        com.ziroom.ziroomcustomer.minsu.chat.d.c.sendGroupMemberChange(ApplicationEx.c, paramAnonymousString1);
      }
      
      public void onMemberJoined(String paramAnonymousString1, String paramAnonymousString2)
      {
        com.ziroom.ziroomcustomer.minsu.chat.d.c.sendGroupMemberChange(ApplicationEx.c, paramAnonymousString1);
      }
      
      public void onMuteListAdded(String paramAnonymousString, List<String> paramAnonymousList, long paramAnonymousLong) {}
      
      public void onMuteListRemoved(String paramAnonymousString, List<String> paramAnonymousList) {}
      
      public void onOwnerChanged(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3) {}
      
      public void onRequestToJoinAccepted(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3) {}
      
      public void onRequestToJoinDeclined(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4) {}
      
      public void onRequestToJoinReceived(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4) {}
      
      public void onSharedFileAdded(String paramAnonymousString, EMMucSharedFile paramAnonymousEMMucSharedFile) {}
      
      public void onSharedFileDeleted(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public void onUserRemoved(String paramAnonymousString1, String paramAnonymousString2)
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin wz_info  当前用户被移除群 ");
        com.ziroom.ziroomcustomer.minsu.chat.d.c.sendExitGroup(ApplicationEx.c, paramAnonymousString1);
      }
    };
    try
    {
      if ((EMClient.getInstance() != null) && (EMClient.getInstance().chatManager() != null))
      {
        EMClient.getInstance().chatManager().addMessageListener(local4);
        EMClient.getInstance().groupManager().addGroupChangeListener(local5);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", " --**** " + localException.getMessage());
    }
  }
  
  public void clearData(String paramString)
  {
    if (s == null) {
      return;
    }
    s.remove(paramString);
  }
  
  public void clearIndexList()
  {
    this.D.clear();
    this.E.clear();
    this.D = null;
    this.E = null;
  }
  
  public com.ziroom.ziroomcustomer.minsu.chat.b createNotifier()
  {
    return new com.ziroom.ziroomcustomer.minsu.chat.b();
  }
  
  public void finishAllActivity()
  {
    if (r == null) {
      return;
    }
    int i2 = r.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (r.get(i1) != null) {
        ((Activity)r.get(i1)).finish();
      }
      i1 += 1;
    }
    r.clear();
  }
  
  public void finishZryuSign()
  {
    if (u != null)
    {
      Iterator localIterator = u.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((Activity)localWeakReference.get()).finish();
        }
      }
      u.clear();
    }
  }
  
  public List<CleanDailyService> getCleanDailyServices()
  {
    return this.F;
  }
  
  public List<Contract> getContracts()
  {
    return this.z;
  }
  
  public Activity getCurrentActivity()
  {
    return this.y;
  }
  
  public Object getData(String paramString)
  {
    if (s == null) {
      return null;
    }
    return s.get(paramString);
  }
  
  public MHExplain getExplain()
  {
    return this.C;
  }
  
  public String getFiveImgUrl()
  {
    return this.Z;
  }
  
  public int getFiveYearIsOpen()
  {
    return this.Y;
  }
  
  public String getFiveYearUrl()
  {
    return this.aa;
  }
  
  public void getHttpAppID()
  {
    com.ziroom.datacenter.remote.e.a.getHttpAppID(getApplicationContext(), new a());
  }
  
  public String getHuaWeiToken()
  {
    return this.w;
  }
  
  public List<ax> getImageInfos()
  {
    return this.T;
  }
  
  public ArrayList<HomeIndex> getIndexLists()
  {
    return this.E;
  }
  
  public double[] getLatlng_array()
  {
    return this.H;
  }
  
  public ArrayList<HouseListSearchResult> getLists()
  {
    return this.D;
  }
  
  public BDLocation getLocation()
  {
    return this.I;
  }
  
  public int getMisuNum()
  {
    return this.S;
  }
  
  public MyMessageReceiver getMsgReceiver()
  {
    return this.V;
  }
  
  public String getMyAreaId()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("myareaid", 0);
    if (this.v == null) {
      return localSharedPreferences.getString("myareaid", "");
    }
    return localSharedPreferences.getString(this.v.getUid(), "");
  }
  
  public AreaInfo getMyAreaInfo()
  {
    return this.B;
  }
  
  public com.ziroom.ziroomcustomer.minsu.chat.b getNotifier()
  {
    return this.Q;
  }
  
  public IkeyRaConfig getRaConfig()
  {
    return this.l;
  }
  
  public String getSmDeviceId()
  {
    if (TextUtils.isEmpty(this.O))
    {
      SharedPreferences localSharedPreferences = getSharedPreferences(getPackageName() + "_dna", 0);
      if (localSharedPreferences == null) {
        return "";
      }
      this.O = localSharedPreferences.getString("device_id", "");
      if (this.O != "") {
        return this.O;
      }
    }
    if (this.O == null) {
      return "";
    }
    return this.O;
  }
  
  public String getSmDeviceIdSync(int paramInt)
  {
    if (TextUtils.isEmpty(this.O))
    {
      SharedPreferences localSharedPreferences = getSharedPreferences(getPackageName() + "_dna", 0);
      if (localSharedPreferences == null) {
        return "";
      }
      this.O = localSharedPreferences.getString("device_id", "");
      if (TextUtils.isEmpty(this.O))
      {
        SystemClock.sleep(paramInt);
        this.O = localSharedPreferences.getString("device_id", "");
      }
      if (TextUtils.isEmpty(this.O)) {
        return "";
      }
      return this.O;
    }
    if (this.O == null) {
      return "";
    }
    return this.O;
  }
  
  public long getTimeDiff()
  {
    return this.K;
  }
  
  public int getUnReadNum()
  {
    return this.R;
  }
  
  public UserInfo getUser()
  {
    return this.v;
  }
  
  public String getUserId(Activity paramActivity)
  {
    if (this.v == null)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramActivity);
      return "";
    }
    return this.v.getUid();
  }
  
  public HashMap<String, String> getUserMap()
  {
    return this.m;
  }
  
  public String getVersionCode()
  {
    return this.J;
  }
  
  public List<Activity> getmActivity()
  {
    return this.P;
  }
  
  public List<MapMoveHouse> getmList()
  {
    return this.G;
  }
  
  public void initNotifier()
  {
    this.Q = createNotifier();
    this.Q.init(c);
    this.Q.setNotificationInfoProvider(new b.a()
    {
      private String a(EMMessage paramAnonymousEMMessage)
      {
        if ("ZIROOM_MINSU_IM".equals(paramAnonymousEMMessage.getStringAttribute("ziroomFlag", "")))
        {
          if ("1".equals(paramAnonymousEMMessage.getStringAttribute("msgSenderType", ""))) {
            return "房东" + paramAnonymousEMMessage.getStringAttribute("nicName", "");
          }
          if ("2".equals(paramAnonymousEMMessage.getStringAttribute("msgSenderType", ""))) {
            return "房客" + paramAnonymousEMMessage.getStringAttribute("nicName", "");
          }
        }
        else if ("ZIROOM_ZRY_IM".equals(paramAnonymousEMMessage.getStringAttribute("ziroomFlag", "")))
        {
          return paramAnonymousEMMessage.getStringAttribute("nicName", "");
        }
        return paramAnonymousEMMessage.getStringAttribute("nicName", "");
      }
      
      public String getDisplayedText(EMMessage paramAnonymousEMMessage)
      {
        String str2 = com.ziroom.ziroomcustomer.minsu.chat.j.getMessageDigest(paramAnonymousEMMessage, ApplicationEx.c);
        String str1 = str2;
        if (paramAnonymousEMMessage.getType() == EMMessage.Type.TXT) {
          str1 = str2.replaceAll("\\[.{2,3}\\]", "[表情]");
        }
        paramAnonymousEMMessage = a(paramAnonymousEMMessage);
        if (TextUtils.isEmpty(paramAnonymousEMMessage)) {
          return str1;
        }
        return paramAnonymousEMMessage + ":" + str1;
      }
      
      public String getLatestText(EMMessage paramAnonymousEMMessage, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        String str = com.ziroom.ziroomcustomer.minsu.chat.j.getMessageDigest(paramAnonymousEMMessage, ApplicationEx.c);
        return a(paramAnonymousEMMessage) + ":" + str;
      }
      
      public Intent getLaunchIntent(EMMessage paramAnonymousEMMessage)
      {
        if ("ZIROOM_MINSU_IM".equals(paramAnonymousEMMessage.getStringAttribute("ziroomFlag", ""))) {
          try
          {
            if (Integer.parseInt(paramAnonymousEMMessage.getStringAttribute("msgSenderType", "")) == 2) {}
            for (int i = 1;; i = 2)
            {
              Intent localIntent1 = new Intent(ApplicationEx.c, MinsuChatActivity.class);
              localIntent1.putExtra("userId", paramAnonymousEMMessage.getFrom());
              localIntent1.putExtra("chatType", 1);
              localIntent1.putExtra("msgSenderType", i);
              return localIntent1;
            }
            if (!"ZIROOM_ZRY_IM".equals(paramAnonymousEMMessage.getStringAttribute("ziroomFlag", ""))) {
              break label135;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        Intent localIntent2 = new Intent(ApplicationEx.c, MinsuGroupChatActivity.class);
        localIntent2.putExtra("msgSenderType", 1);
        localIntent2.putExtra("userId", paramAnonymousEMMessage.getTo());
        return localIntent2;
        label135:
        if ("ZIROOM_CHANGZU_IM".equals(paramAnonymousEMMessage.getStringAttribute("ziroomFlag", ""))) {
          return new Intent(ApplicationEx.c, ZzSocialFriendListActivity.class);
        }
        return null;
      }
      
      public int getSmallIcon(EMMessage paramAnonymousEMMessage)
      {
        return 0;
      }
      
      public String getTitle(EMMessage paramAnonymousEMMessage)
      {
        return "新消息";
      }
    });
  }
  
  public boolean isFlag()
  {
    return this.U;
  }
  
  public boolean isImconnect()
  {
    return this.M;
  }
  
  public boolean isImlogin()
  {
    return this.N;
  }
  
  public boolean isLoginState()
  {
    return this.x;
  }
  
  public void onCreate()
  {
    super.onCreate();
    ah.getBrowserPackageName(this);
    int i1 = Process.myPid();
    Object localObject1 = ah.getAppName(this, i1);
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin", " app  pid = " + i1 + " app name = " + (String)localObject1);
    c = this;
    if (com.ziroom.commonlib.utils.d.a == null) {
      com.ziroom.commonlib.utils.d.a = this;
    }
    String str = com.mcxiaoke.packer.helper.a.getChannel(this);
    if (TextUtils.isEmpty(str)) {
      str = "ziroom";
    }
    for (;;)
    {
      com.ziroom.commonlibrary.g.b.a.init(this, "6844032B776C4875A42F7B56957B8A08", str);
      MobclickAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(this, "5269d8a156240bece000cbce", str));
      QbSdk.initX5Environment(this, null);
      if (q.getWebType() != 0) {}
      h.setsEnvironment(4);
      Object localObject2 = new com.freelxl.baselibrary.b.a().setLOG_SWITCH(Boolean.valueOf(false)).setmImageRess(new int[] { 2130838982, 2130838983, 2130838984, 2130838985 });
      com.freelxl.baselibrary.b.c.getInstance().init((com.freelxl.baselibrary.b.a)localObject2);
      com.ziroom.commonlibrary.a.init(this, h.getsEnvironment());
      if ((localObject1 != null) && (((String)localObject1).equalsIgnoreCase("com.ziroom.ziroomcustomer")))
      {
        com.ziroom.ziroomcustomer.a.a.init();
        g();
        d();
        new Thread(new Runnable()
        {
          public void run()
          {
            com.ziroom.ziroomcustomer.b.e locale = new com.ziroom.ziroomcustomer.b.e(ApplicationEx.c);
            locale.getSession();
            locale.onCreate();
          }
        }).start();
        registerActivityLifecycleCallbacks(new e());
      }
      localObject1 = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
      LocalBroadcastManager.getInstance(this).registerReceiver(LoginReceiver.getInstance(), (IntentFilter)localObject1);
      localObject1 = com.freelxl.baselibrary.d.a.getInstance();
      localObject2 = new HashSet();
      ((Set)localObject2).add(new RequestLoggingListener());
      localObject1 = OkHttpImagePipelineConfigFactory.newBuilder(this, (OkHttpClient)localObject1).setBitmapsConfig(Bitmap.Config.RGB_565).setRequestListeners((Set)localObject2).setMainDiskCacheConfig(DiskCacheConfig.newBuilder(this).build()).setSmallImageDiskCacheConfig(DiskCacheConfig.newBuilder(this).build()).setDownsampleEnabled(true);
      localObject2 = (ActivityManager)getSystemService("activity");
      if (localObject2 != null) {
        ((ImagePipelineConfig.Builder)localObject1).setBitmapMemoryCacheParamsSupplier(new i((ActivityManager)localObject2));
      }
      Fresco.initialize(this, ((ImagePipelineConfig.Builder)localObject1).build());
      this.w = y.getString(this, "huawei_token");
      f.getSupportList(c, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.m(com.alibaba.fastjson.e.class, new com.ziroom.ziroomcustomer.e.c.a.c()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          com.ziroom.ziroomcustomer.service.e.init(ApplicationEx.c, 1);
        }
        
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          if (paramAnonymouse != null)
          {
            com.ziroom.ziroomcustomer.service.e.e = paramAnonymouse.getInteger(com.ziroom.ziroomcustomer.service.d.e).intValue();
            com.ziroom.ziroomcustomer.service.e.f = paramAnonymouse.getInteger(com.ziroom.ziroomcustomer.service.d.c).intValue();
            com.ziroom.ziroomcustomer.service.e.g = paramAnonymouse.getInteger(com.ziroom.ziroomcustomer.service.d.f).intValue();
            y.putInt(ApplicationEx.c, com.ziroom.ziroomcustomer.service.d.e, com.ziroom.ziroomcustomer.service.e.e);
            y.putInt(ApplicationEx.c, com.ziroom.ziroomcustomer.service.d.c, com.ziroom.ziroomcustomer.service.e.f);
            y.putInt(ApplicationEx.c, com.ziroom.ziroomcustomer.service.d.f, com.ziroom.ziroomcustomer.service.e.g);
            com.ziroom.ziroomcustomer.service.e.init(ApplicationEx.c);
            return;
          }
          com.ziroom.ziroomcustomer.service.e.init(ApplicationEx.c, 1);
        }
      }, com.ziroom.ziroomcustomer.service.d.buildGetSupportList(c, com.ziroom.ziroomcustomer.service.d.a));
      SDKInitializer.initialize(this);
      a(this);
      f();
      m();
      com.ziroom.ziroomcustomer.f.a.register(this);
      c.initUpdataUrl();
      GrowingIO.startWithConfiguration(this, new Configuration().setDebugMode(false).setDeviceId(ah.getDeviceId(this)).useID().trackAllFragments().setChannel(str));
      com.growingio.android.sdk.collection.GConfig.DEBUG = false;
      GrowingIO.getInstance().setCS4("td", com.ziroom.commonlibrary.g.b.a.getDeviceId(this));
      this.n = getResources().getInteger(2131558401);
      g.checkUpdata(this.n + "");
      if (g.checkSkin()) {
        com.freelxl.baselibrary.widget.a.setImageGif(g.a + com.ziroom.ziroomcustomer.util.ad.getSkinSign(c) + "/" + g.getLoadingJson().getResources().getResource_refreshJson());
      }
      com.ziroom.ziroomcustomer.ziroomapartment.a.getProjectMap(c);
      return;
    }
  }
  
  public void onTerminate()
  {
    unregisterReceiver(this.V);
    unregisterReceiver(this.o);
    unregisterReceiver(this.p);
    unregisterReceiver(this.ag);
    Fresco.getImagePipeline().clearMemoryCaches();
    super.onTerminate();
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (Fresco.getImagePipeline() == null);
    Fresco.getImagePipeline().clearMemoryCaches();
  }
  
  public void putData(String paramString, Object paramObject)
  {
    if (s == null) {
      s = new HashMap();
    }
    s.put(paramString, paramObject);
  }
  
  public void removeActivity(Activity paramActivity)
  {
    if (r == null) {
      r = new Stack();
    }
    r.remove(paramActivity);
  }
  
  public void removeFromZryuSign(Activity paramActivity)
  {
    if (u != null)
    {
      Iterator localIterator = u.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() == paramActivity)) {
          u.remove(localWeakReference);
        }
      }
    }
  }
  
  public void setCleanDailyServices(List<CleanDailyService> paramList)
  {
    this.F = paramList;
  }
  
  public void setContracts(List<Contract> paramList)
  {
    this.z = paramList;
  }
  
  public void setCurrentActivity(Activity paramActivity)
  {
    this.y = paramActivity;
  }
  
  public void setExplain(MHExplain paramMHExplain)
  {
    this.C = paramMHExplain;
  }
  
  public void setFlag(boolean paramBoolean)
  {
    this.U = paramBoolean;
  }
  
  public void setHuaWeiToken(String paramString)
  {
    this.w = paramString;
  }
  
  public void setImageInfos(List<ax> paramList)
  {
    this.T = paramList;
  }
  
  public void setImconnect(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }
  
  public void setImlogin(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }
  
  public void setIndexLists(ArrayList<HomeIndex> paramArrayList)
  {
    this.E = paramArrayList;
  }
  
  public void setLatlng_array(double[] paramArrayOfDouble)
  {
    this.H = paramArrayOfDouble;
  }
  
  public void setLists(ArrayList<HouseListSearchResult> paramArrayList)
  {
    this.D = paramArrayList;
  }
  
  public void setLocation(BDLocation paramBDLocation)
  {
    this.I = paramBDLocation;
  }
  
  public void setLoginState(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public void setMisuNum(int paramInt)
  {
    this.S = paramInt;
    MessageUtil.setMinsuCustomServiceMsgNum(paramInt);
  }
  
  public void setMyAreaId(String paramString)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("myareaid", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    if (this.v == null) {
      if (localSharedPreferences.getString("myareaid", "").equals("")) {
        localEditor.putString("myareaid", paramString);
      }
    }
    for (;;)
    {
      localEditor.commit();
      return;
      localEditor.putString(this.v.getUid(), paramString);
      localEditor.putString("myareaid", paramString);
    }
  }
  
  public void setMyAreaInfo(AreaInfo paramAreaInfo)
  {
    this.B = paramAreaInfo;
  }
  
  public void setRaConfig(IkeyRaConfig paramIkeyRaConfig)
  {
    this.l = paramIkeyRaConfig;
  }
  
  public void setTimeDiff(long paramLong)
  {
    this.K = paramLong;
  }
  
  public void setUnReadNum(int paramInt)
  {
    this.R = paramInt;
    MessageUtil.setCustomServiceMsgNum(paramInt);
  }
  
  public void setUser(UserInfo paramUserInfo)
  {
    if ((paramUserInfo != null) && (!TextUtils.isEmpty(paramUserInfo.getUid())))
    {
      this.v = paramUserInfo;
      com.ziroom.commonlibrary.receiver.JPushReceiver.a = paramUserInfo.getUid();
      com.ziroom.ziroomcustomer.service.e.setAliasAndTags(this, this.w, ah.toMd5(paramUserInfo.getUid().getBytes()), null);
      AlternateListing.syncData(this, paramUserInfo.getUid());
      return;
    }
    this.v = paramUserInfo;
    com.ziroom.commonlibrary.receiver.JPushReceiver.a = "";
    com.ziroom.ziroomcustomer.service.e.setAliasAndTags(this, this.w, "", null);
  }
  
  public void setUserMap(HashMap<String, String> paramHashMap)
  {
    this.m = paramHashMap;
  }
  
  public void setVersionCode(String paramString)
  {
    this.J = paramString;
  }
  
  public void setmActivity(Activity paramActivity)
  {
    if (this.P == null) {
      this.P = new ArrayList();
    }
    this.P.add(paramActivity);
  }
  
  public void setmList(List<MapMoveHouse> paramList)
  {
    this.G = paramList;
  }
  
  public void uncaughtException(Thread paramThread, final Throwable paramThrowable)
  {
    if (d.a) {
      new Thread(new Runnable()
      {
        public void run()
        {
          ApplicationEx.this.a(paramThrowable);
        }
      }).start();
    }
    paramThread = new Intent(this, WelcomeActivity.class);
    paramThread.addFlags(335544320);
    long l1 = ab.getInstance().getAppResetTime();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < 10000L) {}
    for (;;)
    {
      ab.getInstance().saveAppResetTime(l2);
      try
      {
        Thread.sleep(2000L);
        System.exit(2);
        return;
        b = PendingIntent.getActivity(getApplicationContext(), 0, paramThread, 268435456);
        ((AlarmManager)getSystemService("alarm")).set(1, System.currentTimeMillis() + 500L, b);
      }
      catch (InterruptedException paramThread)
      {
        for (;;)
        {
          paramThread.printStackTrace();
        }
      }
    }
  }
  
  static class a
    extends com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.a.a>
  {
    public void onFailure(Throwable paramThrowable) {}
    
    public void onSuccess(int paramInt, com.ziroom.datacenter.remote.responsebody.a.a parama)
    {
      if ((parama != null) && (parama.isSuccessful()))
      {
        parama = parama.getData().getAppId();
        if (!TextUtils.isEmpty(parama))
        {
          com.ziroom.commonlib.utils.b.setAppId(parama);
          com.ziroom.commonlib.utils.d.a = ApplicationEx.c;
          q.putOtherString("appid_value", parama);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/base/ApplicationEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */