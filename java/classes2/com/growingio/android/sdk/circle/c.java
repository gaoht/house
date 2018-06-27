package com.growingio.android.sdk.circle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.AppOpsManager;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;
import com.growingio.android.sdk.a.e;
import com.growingio.android.sdk.a.g.b;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.AppState.ActivityStateListener;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.MessageProcessor;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.collection.VdsJsBridgeManager;
import com.growingio.android.sdk.collection.VdsJsBridgeManager.SnapshotCallback;
import com.growingio.android.sdk.models.f;
import com.growingio.android.sdk.models.l;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.PermissionUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(15)
public class c
  implements AppState.ActivityStateListener
{
  public static int a = 2005;
  private static AlertDialog r;
  private static final Object s = new Object();
  private static c t;
  private com.growingio.android.sdk.models.j A = new com.growingio.android.sdk.models.j()
  {
    public void b(com.growingio.android.sdk.models.i paramAnonymousi)
    {
      if (((paramAnonymousi.c instanceof WebView)) || (ClassExistHelper.instanceOfX5WebView(paramAnonymousi.c)))
      {
        paramAnonymousi = paramAnonymousi.c;
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = c.j(c.this).f().iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put(((f)localIterator.next()).b());
        }
        boolean bool = GConfig.s().u();
        if (VdsJsBridgeManager.isWebViewHooked(paramAnonymousi))
        {
          if (!bool) {
            break label136;
          }
          Util.a(paramAnonymousi, "_vds_hybrid.setTags", new Object[] { com.growingio.android.sdk.a.g.c().f() });
          Util.a(paramAnonymousi, "_vds_hybrid.setShowCircledTags", new Object[] { Boolean.valueOf(true) });
        }
      }
      return;
      label136:
      Util.a(paramAnonymousi, "_vds_hybrid.setTags", new Object[0]);
      Util.a(paramAnonymousi, "_vds_hybrid.setShowCircledTags", new Object[] { Boolean.valueOf(false) });
    }
  };
  private Runnable B = new Runnable()
  {
    public void run()
    {
      if ((c.this.b()) && (GConfig.s().u()))
      {
        if ((c.k(c.this) != null) && (c.k(c.this).getVisibility() == 0) && (!c.k(c.this).e()))
        {
          c.k(c.this).setTags(c.j(c.this).d());
          if (c.this.d() != null) {
            ViewHelper.a(c.this.d().getWindow().getDecorView(), "", c.l(c.this));
          }
        }
        ThreadUtils.a(this, 1500L);
      }
    }
  };
  private b C = new b()
  {
    public void a(String paramAnonymousString)
    {
      if ((c.e(c.this) != null) && (c.e(c.this).b()) && (c.e(c.this).a())) {
        c.e(c.this).a(paramAnonymousString);
      }
    }
  };
  private Runnable D = new Runnable()
  {
    public void run()
    {
      if ((c.m(c.this) != null) && (c.m(c.this).c()) && (!HybridEventEditDialog.a()))
      {
        c.m(c.this).g();
        c.m(c.this).d();
      }
    }
  };
  private String b;
  private boolean c;
  private boolean d;
  private boolean e;
  private String f;
  private String g;
  private String h;
  private a i;
  private m j;
  private h.a k;
  private b l;
  private int m;
  private Runnable n;
  private List<com.growingio.android.sdk.models.i> o;
  private WeakReference<Activity> p = new WeakReference(null);
  private com.growingio.android.sdk.circle.a.a q;
  private Runnable u = new Runnable()
  {
    public void run()
    {
      ThreadUtils.b(new Runnable()
      {
        public void run()
        {
          c.b(c.this).setContent("Web端圈选中");
        }
      });
    }
  };
  private Runnable v = new Runnable()
  {
    public void run()
    {
      c.this.k();
    }
  };
  private Runnable w = new Runnable()
  {
    public void run()
    {
      if ((c.this.d() == null) || (c.this.d().isFinishing())) {
        return;
      }
      ThreadUtils.b(new Runnable()
      {
        public void run()
        {
          new AlertDialog.Builder(c.e().d()).setTitle("圈选结束").setMessage("无法连接到Web端，请尝试重新扫描二维码").setPositiveButton("知道了", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
            {
              c.e().m();
            }
          }).create().show();
        }
      });
    }
  };
  private Runnable x = new Runnable()
  {
    public void run()
    {
      c.this.a("touch", null, null);
    }
  };
  private VdsJsBridgeManager.SnapshotCallback y = new VdsJsBridgeManager.SnapshotCallback()
  {
    public void a(List<com.growingio.android.sdk.models.i> paramAnonymousList)
    {
      if ((c.e(c.this) != null) && (c.e(c.this).b()) && (c.e(c.this).a()))
      {
        if (c.f(c.this) == null) {
          break label91;
        }
        c.f(c.this).addAll(paramAnonymousList);
      }
      for (;;)
      {
        if (c.g(c.this) == 0)
        {
          ThreadUtils.c(c.h(c.this));
          ThreadUtils.b(c.h(c.this));
        }
        return;
        label91:
        c.a(c.this, paramAnonymousList);
      }
    }
  };
  private com.growingio.android.sdk.models.j z = new com.growingio.android.sdk.models.j()
  {
    public void b(com.growingio.android.sdk.models.i paramAnonymousi)
    {
      if ((paramAnonymousi.c instanceof WebView))
      {
        paramAnonymousi = (WebView)paramAnonymousi.c;
        if (VdsJsBridgeManager.isWebViewHooked(paramAnonymousi))
        {
          c.i(c.this);
          Util.a(paramAnonymousi, "_vds_hybrid.snapshotAllElements", new Object[0]);
        }
      }
    }
  };
  
  private JSONObject A()
  {
    localJSONObject = new JSONObject();
    try
    {
      SparseArray localSparseArray = x().w();
      int i1 = 0;
      while (i1 < localSparseArray.size())
      {
        int i2 = localSparseArray.keyAt(i1);
        String str = String.valueOf(localSparseArray.get(i2));
        localJSONObject.put("cs" + String.valueOf(i2 + 1), str);
        i1 += 1;
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      LogUtil.d("GIO.CircleManager", "patch cs value error: ", localJSONException);
    }
  }
  
  private JSONObject B()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      int i1;
      try
      {
        localSparseArray = x().j();
        if (localSparseArray != null) {
          break label113;
        }
        return null;
      }
      catch (JSONException localJSONException)
      {
        SparseArray localSparseArray;
        int i2;
        String str2;
        String str1;
        LogUtil.d("GIO.CircleManager", "patch ps value error: ", localJSONException);
      }
      if (i1 < localSparseArray.size())
      {
        i2 = localSparseArray.keyAt(i1);
        str2 = String.valueOf(localSparseArray.get(i2));
        if (i2 == 0)
        {
          str1 = "pg";
          localJSONObject.put(str1, str2);
          i1 += 1;
        }
        else
        {
          str1 = "ps" + String.valueOf(i2);
        }
      }
      else
      {
        return localJSONObject;
        label113:
        i1 = 0;
      }
    }
  }
  
  private String a(String paramString1, String paramString2, com.growingio.android.sdk.models.i parami, List<com.growingio.android.sdk.models.i> paramList, com.growingio.android.sdk.models.g paramg)
  {
    Activity localActivity = d();
    if (localActivity == null) {
      return paramString1;
    }
    Object localObject;
    if (paramString1.equals("page"))
    {
      localObject = "";
      if ((paramg instanceof com.growingio.android.sdk.models.d))
      {
        localObject = ((com.growingio.android.sdk.models.d)paramg).d();
        paramString2 = (String)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramString2 = paramg.f;
        }
        paramString2 = "进入了" + paramString2;
      }
    }
    else
    {
      parami = new j(localActivity, paramList, parami).a();
    }
    for (;;)
    {
      try
      {
        parami.put("msgId", "user_action");
        parami.put("userAction", paramString1);
        parami.put("actionDesc", paramString2);
        parami.put("sdkVersion", "1.1.2_dcb91e54");
        parami.put("appVersion", GConfig.sAppVersion);
        parami.put("sdkConfig", z());
        parami.put("cs", A());
        parami.put("ps", B());
        if (paramString1.equals("page"))
        {
          if ((paramg instanceof com.growingio.android.sdk.models.d))
          {
            parami.put("domain", AppState.l().b());
            parami.put("page", paramg.f);
            paramString1 = parami.toString();
            return paramString1;
            paramString2 = (String)localObject;
            if (!(paramg instanceof l)) {
              break;
            }
            try
            {
              String str = paramg.c().getString("tl");
              paramString2 = str;
              localObject = str;
              if (!TextUtils.isEmpty(str)) {
                break;
              }
              localObject = str;
              paramString2 = paramg.c().getString("p");
            }
            catch (Exception paramString2)
            {
              paramString2.printStackTrace();
              paramString2 = (String)localObject;
            }
            break;
          }
          if (!(paramg instanceof l)) {
            continue;
          }
          parami.put("domain", paramg.c().getString("d"));
          parami.put("page", paramg.c().getString("p"));
          parami.put("query", paramg.c().optString("q"));
          continue;
        }
        parami.put("domain", AppState.l().b());
      }
      catch (Exception paramString1)
      {
        LogUtil.d("WebSocketProxy", "send screenshot info message error", paramString1);
        return "";
      }
      parami.put("page", x().b(localActivity));
    }
  }
  
  private void a(Pair<Integer, byte[]> paramPair)
  {
    LogUtil.d("GIO.CircleManager", new Object[] { "loginFailed" });
    String str;
    if (c())
    {
      str = "请重新扫描";
      w();
      if (((Integer)paramPair.first).intValue() != 422) {
        break label138;
      }
    }
    for (;;)
    {
      try
      {
        paramPair = new JSONObject(new String((byte[])paramPair.second)).getString("error");
        Activity localActivity = d();
        if ((localActivity != null) && (!localActivity.isFinishing())) {}
        try
        {
          new AlertDialog.Builder(d()).setTitle(str).setMessage(paramPair).setPositiveButton("知道了", null).create().show();
          return;
        }
        catch (WindowManager.BadTokenException paramPair)
        {
          return;
        }
        str = "请重新唤醒App";
      }
      catch (JSONException paramPair)
      {
        paramPair = "发生未知错误";
        continue;
      }
      label138:
      if (((Integer)paramPair.first).intValue() >= 500)
      {
        paramPair = "服务器错误，请稍后重新扫描二维码";
      }
      else if (((Integer)paramPair.first).intValue() == 0)
      {
        paramPair = "检测不到网络连接，请确保已接入互联网";
        str = "请连接网络";
      }
      else
      {
        paramPair = "发生未知错误";
      }
    }
  }
  
  private void a(String paramString)
  {
    LogUtil.d("GIO.CircleManager", new Object[] { "launchWebCircle()" });
    if (d() == null) {
      return;
    }
    h localh = h.a();
    if (!localh.b())
    {
      localh.a(paramString);
      return;
    }
    s();
    a(this.C);
    v();
    this.k = new h.a(NetworkConfig.a().g(), this.g, this.u, this.v, this.w);
    this.k.c();
    this.j.setContent("正在准备Web圈选……");
    ThreadUtils.a(new Runnable()
    {
      public void run()
      {
        MessageProcessor.e().a("/GioWindow/FloatViewContainer[0]/TextView[0]", null, false);
      }
    }, 1000L);
  }
  
  @TargetApi(19)
  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return true;
    }
    if (PermissionUtil.a(paramContext, "android.permission.SYSTEM_ALERT_WINDOW"))
    {
      LogUtil.d("GIO.CircleManager", new Object[] { "hasPermission true" });
      return true;
    }
    LogUtil.d("GIO.CircleManager", new Object[] { "hasPermission false" });
    try
    {
      AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
      if (localAppOpsManager == null) {
        return false;
      }
      int i1 = ((Integer)localAppOpsManager.getClass().getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(24), Integer.valueOf(Binder.getCallingUid()), paramContext.getApplicationContext().getPackageName() })).intValue();
      if (i1 == 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception paramContext) {}
  }
  
  private boolean a(Uri paramUri)
  {
    LogUtil.d("GIO.CircleManager", new Object[] { "isValidData" });
    if ((paramUri == null) || (paramUri.toString() == null)) {
      LogUtil.d("GIO.CircleManager", new Object[] { "isValidData:NULL" });
    }
    while ((paramUri != null) && (paramUri.isHierarchical()) && (paramUri.isAbsolute()) && (paramUri.getScheme().startsWith("growing.")))
    {
      return true;
      LogUtil.d("GIO.CircleManager", new Object[] { "isValidData:" + paramUri.toString() });
    }
    return false;
  }
  
  private String b(final com.growingio.android.sdk.models.i parami)
  {
    if (parami == null) {
      return "按钮";
    }
    if (!TextUtils.isEmpty(parami.k)) {
      return parami.k;
    }
    this.h = null;
    if (((parami.c instanceof ViewGroup)) && (!(parami.c instanceof WebView)) && (!ClassExistHelper.instanceOfX5WebView(parami.c)))
    {
      parami.a(new com.growingio.android.sdk.models.j()
      {
        float a = 0.0F;
        
        public boolean a(com.growingio.android.sdk.models.i paramAnonymousi)
        {
          return (paramAnonymousi == parami) || ((super.a(paramAnonymousi)) && (!Util.c(paramAnonymousi.c)));
        }
        
        public void b(com.growingio.android.sdk.models.i paramAnonymousi)
        {
          if ((!TextUtils.isEmpty(paramAnonymousi.k)) && (TextUtils.isGraphic(paramAnonymousi.k))) {
            if (!(paramAnonymousi.c instanceof TextView)) {
              break label68;
            }
          }
          label68:
          for (float f = ((TextView)paramAnonymousi.c).getTextSize();; f = 0.0F)
          {
            if (f > this.a)
            {
              this.a = f;
              c.a(c.this, paramAnonymousi.k);
            }
            return;
          }
        }
      });
      parami.b();
    }
    while (TextUtils.isEmpty(this.h))
    {
      return "按钮";
      this.h = parami.k;
    }
    return this.h;
  }
  
  private void b(String paramString, com.growingio.android.sdk.models.i parami, com.growingio.android.sdk.models.g paramg)
  {
    ThreadUtils.c(this.n);
    String str = "";
    if ("click".equals(paramString)) {
      str = "点击了" + b(parami);
    }
    for (;;)
    {
      if (this.l != null) {
        this.l.a(a(paramString, str, parami, this.o, paramg));
      }
      return;
      if ("touch".equals(paramString)) {
        str = "更新截图";
      } else if ("page".equals(paramString)) {
        str = "进入了";
      }
    }
  }
  
  private void b(List<com.growingio.android.sdk.models.i> paramList, String paramString1, String paramString2)
  {
    if (this.i != null) {
      this.i.setVisibility(8);
    }
    paramString1 = d();
    if (paramString1 != null)
    {
      paramString2 = x().b(paramString1);
      final HybridEventEditDialog localHybridEventEditDialog = new HybridEventEditDialog();
      localHybridEventEditDialog.a(paramString1, paramList, paramString2, x().b(), new Runnable()
      {
        public void run()
        {
          c.this.a(localHybridEventEditDialog, HybridEventEditDialog.class.getName());
        }
      });
    }
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool = true;
    LogUtil.d("GIO.CircleManager", new Object[] { "setIsEnable:" + paramBoolean });
    this.c = paramBoolean;
    if (paramBoolean)
    {
      this.d = "app".equalsIgnoreCase(this.b);
      if (!this.d) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.e = paramBoolean;
        return;
      }
    }
    this.d = false;
    this.e = false;
  }
  
  private boolean b(Intent paramIntent, Activity paramActivity)
  {
    boolean bool2 = false;
    try
    {
      bool1 = paramIntent.getBooleanExtra("START_CIRCLE", false);
      if (bool1)
      {
        f(paramActivity);
        paramIntent.removeExtra("START_CIRCLE");
        bool2 = true;
      }
      return bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e("GIO.CircleManager", "get START_CIRCLE error: " + localException.toString());
        boolean bool1 = false;
      }
    }
  }
  
  private void d(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 17)
    {
      Toast.makeText(paramActivity, "未检测到悬浮窗权限,请在设置-权限 中开启悬浮窗权限后继续圈选", 0).show();
      return;
    }
    e(paramActivity);
  }
  
  public static c e()
  {
    for (;;)
    {
      synchronized (s)
      {
        if (t == null)
        {
          t = new c();
          if (Build.VERSION.SDK_INT < 19) {
            break label64;
          }
          if (Build.VERSION.SDK_INT > 24) {
            a = 2002;
          }
        }
        else
        {
          return t;
        }
        a = 2005;
      }
      label64:
      a = 2002;
    }
  }
  
  @TargetApi(17)
  private void e(Activity paramActivity)
  {
    if (r == null)
    {
      r = new AlertDialog.Builder(paramActivity).setTitle("GrowingIO SDK提示").setMessage("使用圈选功能,需要您开启当前应用的悬浮窗权限").setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          c.a(null);
        }
      }).create();
      r.show();
    }
  }
  
  private void f(final Activity paramActivity)
  {
    new AlertDialog.Builder(paramActivity).setTitle("更新提醒").setMessage("请更新GrowingIO应用，然后重新开启圈选").setPositiveButton("更新应用", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("http://fir.im/GIOAndroidApp"));
        paramActivity.startActivity(paramAnonymousDialogInterface);
        ThreadUtils.a(new Runnable()
        {
          public void run()
          {
            c.this.m();
          }
        }, 1000L);
      }
    }).setNegativeButton("取消", null).create().show();
  }
  
  private GConfig p()
  {
    return GConfig.s();
  }
  
  private e q()
  {
    return e.a();
  }
  
  private void r()
  {
    LogUtil.d("GIO.CircleManager", new Object[] { "loginSuccess" });
    if (b()) {
      t();
    }
  }
  
  private void s()
  {
    x().a(this);
  }
  
  private void t()
  {
    LogUtil.d("GIO.CircleManager", new Object[] { "launchAppCircle()" });
    if (d() == null)
    {
      LogUtil.d("GIO.CircleManager", new Object[] { "launchAppCircle() getCurrentActivity() == null return" });
      return;
    }
    final Object localObject = h.a();
    if (!((h)localObject).b())
    {
      LogUtil.d("GIO.CircleManager", new Object[] { "launchAppCircle() manager.isPluginReady():false --> rmanager.loadPlugin()" });
      ((h)localObject).a(null);
      return;
    }
    if (!y().a())
    {
      if (y().b())
      {
        LogUtil.d("GIO.CircleManager", new Object[] { "launchAppCircle() getTagStore().isLoading() return" });
        return;
      }
      localObject = new ProgressDialog(d());
      y().a(new g.b()
      {
        public void a()
        {
          try
          {
            LogUtil.d("GIO.CircleManager", new Object[] { "launchAppCircle()->initSuccess()" });
            c.c(c.this);
            if (localObject.isShowing()) {
              localObject.dismiss();
            }
            return;
          }
          catch (IllegalArgumentException localIllegalArgumentException) {}
        }
      });
      ((ProgressDialog)localObject).requestWindowFeature(1);
      ((ProgressDialog)localObject).setMessage("正在加载历史标签");
      try
      {
        ((ProgressDialog)localObject).show();
        y().e();
        return;
      }
      catch (WindowManager.BadTokenException localBadTokenException)
      {
        for (;;)
        {
          Toast.makeText(d(), "正在加载历史标签", 1).show();
        }
      }
    }
    LogUtil.d("GIO.CircleManager", new Object[] { "launchAppCircle() -> addCircleView()" });
    g();
    HybridEventEditDialog.a(d());
    ThreadUtils.a(new Runnable()
    {
      public void run()
      {
        MessageProcessor.e().a("/GioWindow/FloatViewContainer[0]/CircleButton[0]", null, false);
      }
    }, 1000L);
  }
  
  private boolean u()
  {
    Object localObject = Build.MANUFACTURER;
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return false;
      if (((String)localObject).toLowerCase(Locale.getDefault()).contains("xiaomi")) {
        try
        {
          localObject = new Properties();
          ((Properties)localObject).load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
          localObject = ((Properties)localObject).getProperty("ro.miui.ui.version.name");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            boolean bool = ((String)localObject).equalsIgnoreCase("V8");
            if (bool) {
              return true;
            }
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
      }
    }
    return false;
  }
  
  private void v()
  {
    LogUtil.d("GIO.CircleManager", new Object[] { "addWebCircleView()" });
    if (this.j == null) {
      this.j = new m(d());
    }
    this.j.a();
    Activity localActivity = d();
    if (localActivity != null) {
      localActivity.getWindow().addFlags(128);
    }
  }
  
  private void w()
  {
    if (this.i != null)
    {
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.i.getLayoutParams();
      Point localPoint = new Point();
      localPoint.x = localLayoutParams.x;
      localPoint.y = localLayoutParams.y;
      p().a(localPoint.x, localPoint.y);
      this.i.d();
      this.i = null;
    }
    if (this.j != null)
    {
      this.j.b();
      this.j = null;
    }
    j();
  }
  
  private AppState x()
  {
    return AppState.l();
  }
  
  private com.growingio.android.sdk.a.g y()
  {
    return com.growingio.android.sdk.a.g.c();
  }
  
  private JSONObject z()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sdkVersion", "1.1.2_dcb91e54");
      localJSONObject.put("appVersion", GConfig.sAppVersion);
      localJSONObject.put("isUseId", GConfig.USE_ID);
      localJSONObject.put("isTrackingAllFragments", p().e());
      localJSONObject.put("isTrackWebView", p().q());
      localJSONObject.put("schema", GConfig.sGrowingScheme);
      localJSONObject.put("channel", p().p());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      LogUtil.e("GIO", localJSONException.getMessage());
    }
    return localJSONObject;
  }
  
  public void a(Activity paramActivity)
  {
    LogUtil.d("GIO.CircleManager", new Object[] { "onResumed" });
    h();
    i();
    if (((paramActivity instanceof ActivityGroup)) && (this.p.get() == null)) {
      this.p = new WeakReference(paramActivity);
    }
  }
  
  void a(DialogFragment paramDialogFragment, String paramString)
  {
    Activity localActivity2 = (Activity)this.p.get();
    Activity localActivity1 = localActivity2;
    if (localActivity2 == null) {
      localActivity1 = d();
    }
    if (localActivity1 == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((!paramDialogFragment.isAdded()) && (localActivity1.getFragmentManager().findFragmentByTag(paramString) == null))
        {
          paramDialogFragment.show(localActivity1.getFragmentManager(), paramString);
          return;
        }
      }
      catch (IllegalStateException paramDialogFragment)
      {
        paramDialogFragment.printStackTrace();
      }
    }
  }
  
  public void a(android.app.Fragment paramFragment)
  {
    i();
  }
  
  public void a(Intent paramIntent, Activity paramActivity)
  {
    LogUtil.d("GIO.CircleManager", new Object[] { "launchCircleIfNeed()" });
    if ((paramIntent == null) || (b(paramIntent, paramActivity))) {
      LogUtil.d("GIO.CircleManager", new Object[] { "Intent == NUll or isOldBi" });
    }
    Uri localUri;
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        localUri = paramIntent.getData();
      } while (!a(localUri));
      LogUtil.d("GIO.CircleManager", new Object[] { "isValidData:true" });
      if (d() == null) {
        x().a(paramActivity);
      }
      i.a();
      this.b = localUri.getQueryParameter("circleType");
      paramActivity = localUri.getQueryParameter("loginToken");
      str1 = localUri.getQueryParameter("source");
      str2 = localUri.getQueryParameter("wsHost");
      if ((this.b != null) && (paramActivity != null) && (str1 != null)) {
        LogUtil.d("GIO.CircleManager", new Object[] { "mCircleType:" + this.b + "\n loginToken:" + paramActivity + "\n source:" + str1 });
      }
      if ("heatmap".equals(this.b))
      {
        this.b = "app";
        com.growingio.android.sdk.circle.a.a.b().a();
        com.growingio.android.sdk.circle.a.a.b().a(true);
      }
      LogUtil.d("GIO.CircleManager", new Object[] { "loginToken:" + paramActivity + "\n mLoginToken:" + this.f + "\n" });
    } while ((TextUtils.isEmpty(this.b)) || (("app".equals(this.b)) && (TextUtils.equals(paramActivity, this.f))));
    paramIntent.setData(null);
    k();
    b(true);
    s();
    if (c())
    {
      this.g = localUri.getQueryParameter("circleRoomNumber");
      a(str2);
    }
    while (TextUtils.isEmpty(paramActivity))
    {
      LogUtil.d("GIO.CircleManager", new Object[] { "正常退出" });
      return;
    }
    if ("replace".equals(str1))
    {
      LogUtil.d("GIO.CircleManager", new Object[] { "launchCircleIfNeed()->sourceCode==replace->loginSuccess1" });
      r();
    }
    for (;;)
    {
      this.f = paramActivity;
      Log.i("GIO.CircleManager", "preparing app circle...");
      break;
      new g(new a()
      {
        public void a(Pair<Integer, byte[]> paramAnonymousPair)
        {
          if (c.this.d() != null)
          {
            if (((Integer)paramAnonymousPair.first).intValue() == 200)
            {
              LogUtil.d("GIO.CircleManager", new Object[] { "launchCircleIfNeed()->loginSuccess2" });
              c.a(c.this);
            }
          }
          else {
            return;
          }
          LogUtil.d("GIO.CircleManager", new Object[] { "launchCircleIfNeed()->loginFailed" });
          c.a(c.this, paramAnonymousPair);
        }
      }, paramActivity).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  public void a(android.support.v4.app.Fragment paramFragment)
  {
    i();
  }
  
  public void a(b paramb)
  {
    this.l = paramb;
  }
  
  public void a(com.growingio.android.sdk.models.i parami)
  {
    a("click", parami, null);
  }
  
  public void a(l paraml)
  {
    try
    {
      if (!paraml.c().getString("t").equals("page")) {
        return;
      }
      a("page", null, paraml);
      return;
    }
    catch (Exception paraml)
    {
      paraml.printStackTrace();
    }
  }
  
  public void a(final String paramString, final com.growingio.android.sdk.models.i parami, final com.growingio.android.sdk.models.g paramg)
  {
    if (d() == null) {
      return;
    }
    this.o = null;
    this.m = 0;
    VdsJsBridgeManager.getInstance().registerSnapshotCallback(this.y);
    ViewHelper.a(d().getWindow().getDecorView(), "", this.z);
    this.n = new Runnable()
    {
      public void run()
      {
        ThreadUtils.c(c.d(c.this));
        c.a(c.this, paramString, parami, paramg);
        c.a(c.this, null);
      }
    };
    if (this.m > 0)
    {
      ThreadUtils.a(this.n, 1500L);
      return;
    }
    ThreadUtils.b(this.n);
  }
  
  public void a(List<com.growingio.android.sdk.models.i> paramList, String paramString1, String paramString2)
  {
    if (c()) {
      VdsJsBridgeManager.getInstance().onSnapshotFinished(null, paramList);
    }
    while (!b()) {
      return;
    }
    b(paramList, paramString1, paramString2);
  }
  
  void a(boolean paramBoolean)
  {
    if ((a()) && (b()))
    {
      if (!paramBoolean) {
        break label66;
      }
      this.i.setTags(y().d());
    }
    for (;;)
    {
      GConfig.s().b(paramBoolean);
      if (d() != null) {
        ViewHelper.a(d().getWindow().getDecorView(), "", this.A);
      }
      return;
      label66:
      this.i.setTags(null);
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b(Activity paramActivity)
  {
    w();
    if (this.p.get() == paramActivity) {
      this.p.clear();
    }
  }
  
  public void b(android.app.Fragment paramFragment) {}
  
  public void b(android.support.v4.app.Fragment paramFragment) {}
  
  public boolean b()
  {
    LogUtil.d("GIO.CircleManager", new Object[] { "isAppCircleEnabled():" + this.d });
    return this.d;
  }
  
  public void c(Activity paramActivity) {}
  
  public boolean c()
  {
    LogUtil.d("GIO.CircleManager", new Object[] { "isWebCircleEnabled():" + this.e });
    return this.e;
  }
  
  public Activity d()
  {
    return x().i();
  }
  
  public void f()
  {
    if (c())
    {
      ThreadUtils.c(this.x);
      ThreadUtils.a(this.x, 1500L);
    }
  }
  
  @SuppressLint({"RtlHardcoded"})
  void g()
  {
    LogUtil.d("GIO.CircleManager", new Object[] { "addCircleView()" });
    Activity localActivity = d();
    if ((localActivity == null) || (!h.a().b())) {
      LogUtil.d("GIO.CircleManager", new Object[] { "addCircleView() 半途 return" });
    }
    for (;;)
    {
      return;
      if ((Build.VERSION.SDK_INT < 19) && (!PermissionUtil.d()))
      {
        Toast.makeText(localActivity, "请使用 Android 4.4 或更高版本进行圈选", 0).show();
        return;
      }
      try
      {
        if (this.i == null)
        {
          this.q = com.growingio.android.sdk.circle.a.a.b();
          this.q.a();
          this.i = new a(localActivity.getApplicationContext());
        }
        this.i.b();
        if ((u()) && (!a(localActivity)))
        {
          d(localActivity);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        d(localActivity);
      }
    }
  }
  
  void h()
  {
    LogUtil.d("GIO.CircleManager", new Object[] { "showCircleView()" });
    Object localObject = x().i();
    if (localObject == null) {
      LogUtil.d("GIO.CircleManager", new Object[] { "activity == null return " });
    }
    do
    {
      do
      {
        return;
        if (!b()) {
          break;
        }
        LogUtil.d("GIO.CircleManager", new Object[] { "showCircleView() -> isAppCircleEnabled():true" });
        localObject = ((Activity)localObject).getFragmentManager();
      } while (((((FragmentManager)localObject).findFragmentByTag(HybridEventEditDialog.class.getName()) != null) && (!((FragmentManager)localObject).findFragmentByTag(HybridEventEditDialog.class.getName()).isRemoving())) || ((((FragmentManager)localObject).findFragmentByTag(d.class.getName()) != null) && (!((FragmentManager)localObject).findFragmentByTag(d.class.getName()).isRemoving())));
      LogUtil.d("GIO.CircleManager", new Object[] { "showCircleView() -> addCircleView()" });
      g();
      return;
    } while (!c());
    LogUtil.d("GIO.CircleManager", new Object[] { "showCircleView() -> isWebCircleEnabled():true ->addWebCircleView()" });
    v();
  }
  
  void i()
  {
    ThreadUtils.c(this.D);
    ThreadUtils.a(this.D, 100L);
  }
  
  void j()
  {
    if (this.q != null) {
      this.q.e();
    }
  }
  
  void k()
  {
    LogUtil.d("GIO.CircleManager", new Object[] { "exit" });
    w();
    if (this.k != null)
    {
      this.k.d();
      this.k = null;
    }
    q().f();
    if (d() != null) {
      x().b(this);
    }
    b(false);
  }
  
  void l()
  {
    a(new d(), d.class.getName());
  }
  
  void m()
  {
    Activity localActivity = d();
    if (localActivity != null) {
      localActivity.finish();
    }
    ThreadUtils.a(new Runnable()
    {
      public void run()
      {
        Process.killProcess(Process.myPid());
      }
    }, 1000L);
  }
  
  public void n()
  {
    if ((this.i != null) && (a()) && (b()) && (GConfig.s().u()))
    {
      this.i.setTags(y().d());
      ThreadUtils.c(this.B);
      ThreadUtils.a(this.B, 1500L);
    }
  }
  
  void o()
  {
    LogUtil.d("GIO.CircleManager", new Object[] { "launchCircle()" });
    if (b()) {
      t();
    }
    while (!c()) {
      return;
    }
    a(null);
  }
  
  static abstract interface a
  {
    public abstract void a(Pair<Integer, byte[]> paramPair);
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */