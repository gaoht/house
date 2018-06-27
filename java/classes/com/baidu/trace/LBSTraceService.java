package com.baidu.trace;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.lbsapi.auth.tracesdk.LBSAuthManager;
import com.baidu.trace.api.fence.CircleFence;
import com.baidu.trace.api.fence.Fence;
import com.baidu.trace.c.e;
import com.baidu.trace.c.f.a;
import com.baidu.trace.c.f.b;
import com.baidu.trace.c.h;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LocationMode;
import com.baidu.trace.model.ProtocolType;
import com.baidu.trace.model.TraceLocation;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class LBSTraceService
  extends Service
{
  private a a = new a(this);
  private ServiceBinder b = new ServiceBinder(this);
  private com.baidu.trace.b.d c = null;
  private bd d = null;
  private Context e;
  private s f;
  private boolean g = false;
  private IListener h = null;
  private boolean i = false;
  private boolean j = false;
  private com.baidu.trace.b.c k = new com.baidu.trace.b.c();
  private int l = LocationMode.High_Accuracy.ordinal();
  private int m = ProtocolType.HTTPS.ordinal();
  private f.b n = f.b.a;
  
  static
  {
    LBSTraceService.class.getSimpleName();
  }
  
  private static HashMap<String, String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = paramString.split("-\\|-");
        if ((paramString != null) && (paramString.length >= 10))
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("ak", paramString[0]);
          localHashMap.put("serviceId", paramString[1]);
          localHashMap.put("entityName", paramString[2]);
          localHashMap.put("mcode", paramString[3]);
          localHashMap.put("pcn", paramString[4]);
          localHashMap.put("md", paramString[5]);
          localHashMap.put("cpu", paramString[6]);
          localHashMap.put("locationMode", paramString[7]);
          localHashMap.put("protocolType", paramString[8]);
          localHashMap.put("isNeedObjectStorage", paramString[9]);
          return localHashMap;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((Trace.b != 30) && (Trace.b >= 2)) {
      bd.i = Trace.b * 1000;
    }
    if ((Trace.a != 5) && (Trace.a >= ar.c)) {
      ar.b = Trace.a * 1000;
    }
    bd.d();
    if (this.d != null)
    {
      if (this.d.isAlive())
      {
        this.d.a(paramBoolean1, paramBoolean2);
        return;
      }
      this.d.c();
      this.d = null;
    }
    this.d = new bd(this);
    this.d.a(paramBoolean1, paramBoolean2);
    this.d.start();
  }
  
  private boolean a(int paramInt, long paramLong)
  {
    Object localObject3 = this.f.a("pushInfo");
    Object localObject1;
    if (localObject3 == null)
    {
      localObject1 = paramLong + "_" + paramInt + ";";
      this.f.a("pushInfo", (String)localObject1);
      this.f.a();
      return true;
    }
    String[] arrayOfString = ((String)localObject3).split(";");
    int i2 = arrayOfString.length;
    int i1 = 0;
    if (i1 < i2)
    {
      String str = arrayOfString[i1];
      if (TextUtils.isEmpty(str)) {
        return true;
      }
      localObject1 = str.split("_");
      if (localObject1.length < 2) {
        localObject1 = ((String)localObject3).replace(str + ";", "");
      }
      for (;;)
      {
        i1 += 1;
        localObject3 = localObject1;
        break;
        long l1;
        try
        {
          l1 = Long.valueOf(localObject1[0]).longValue();
          int i3 = Integer.valueOf(localObject1[1]).intValue();
          if (paramInt == i3) {
            return false;
          }
        }
        catch (Exception localException)
        {
          return false;
        }
        localObject2 = localObject3;
        if (paramLong - l1 >= 900L) {
          localObject2 = ((String)localObject3).replace(str + ";", "");
        }
      }
    }
    Object localObject2 = (String)localObject3 + paramLong + "_" + paramInt + ";";
    this.f.a("pushInfo", (String)localObject2);
    this.f.a();
    return true;
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.d != null)
    {
      this.d.a(paramBoolean1, paramBoolean2);
      return;
    }
    a(paramBoolean1, paramBoolean2);
  }
  
  private void f(int paramInt)
  {
    if (this.h != null) {}
    try
    {
      this.h.startTraceCallback(19);
      for (this.i = false;; this.i = true)
      {
        this.n = f.b.b;
        if (!this.j) {
          break;
        }
        return;
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.addAction("com.baidu.trace.action.SOCKET_RECONNECT");
      registerReceiver(this.k, localIntentFilter);
      this.j = true;
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  private void i()
  {
    TraceJniInterface.a().socketDisconnection();
    if (this.c != null) {
      this.c.b();
    }
  }
  
  protected final void a()
  {
    if (f.b.d == this.n) {
      i();
    }
    do
    {
      return;
      if (this.j)
      {
        unregisterReceiver(this.k);
        this.j = false;
      }
      com.baidu.trace.b.d.a(false);
      if (this.d != null) {
        this.d.a(0L);
      }
      if (f.b.d == this.n)
      {
        i();
        return;
      }
      ax.a();
      aw.b();
      if (!a((short)16, e.a(), f.a.a))
      {
        a(10000);
        return;
      }
    } while (this.c == null);
    this.c.g();
  }
  
  protected final void a(int paramInt)
  {
    if (this.h != null) {}
    try
    {
      this.h.startTraceCallback(paramInt);
      this.n = f.b.a;
      TraceJniInterface.a().socketDisconnection();
      if (this.c != null) {
        this.c.b();
      }
      g();
      if (this.d != null)
      {
        this.d.a();
        if (this.d.a != null) {
          this.d.a.c();
        }
        this.d.c();
        this.d = null;
      }
      bd.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= ar.c) && (paramInt2 >= 2))
    {
      ar.b = paramInt1 * 1000;
      bd.i = paramInt2 * 1000;
      this.f.a("gather_interval", String.valueOf(paramInt1));
      this.f.a("pack_interval", String.valueOf(paramInt2));
      this.f.a();
    }
    bd.d();
    Trace.a(paramInt1, paramInt2);
  }
  
  protected final void a(Message paramMessage)
  {
    Object localObject = paramMessage.getData();
    int i1 = ((Bundle)localObject).getInt("pushId");
    byte b1 = ((Bundle)localObject).getByte("infoType");
    paramMessage = ((Bundle)localObject).getString("infoContent");
    long l1 = ((Bundle)localObject).getLong("timeStamp");
    localObject = ax.a((short)13, e.a());
    if ((localObject != null) && (this.c != null)) {
      this.c.a((byte[])localObject, null);
    }
    if ((a(i1, l1)) && (this.h != null)) {}
    try
    {
      this.h.pushCallback(b1, paramMessage);
      return;
    }
    catch (RemoteException paramMessage) {}
  }
  
  protected final boolean a(short paramShort, int paramInt, f.a parama)
  {
    if ((18 == paramShort) && (!TextUtils.isEmpty(g.a)) && (!TextUtils.isEmpty(g.c)) && (!TextUtils.isEmpty(g.d))) {}
    byte[] arrayOfByte;
    do
    {
      return true;
      arrayOfByte = ax.a(paramShort, paramInt);
      if (arrayOfByte == null) {
        return false;
      }
    } while (this.c == null);
    this.c.a(arrayOfByte, parama);
    return true;
  }
  
  protected final void b()
  {
    if (f.b.d == this.n) {
      i();
    }
    while (a((short)17, e.a(), f.a.b)) {
      return;
    }
    a(10000);
  }
  
  protected final void b(Message paramMessage)
  {
    if (this.h != null) {}
    try
    {
      this.h.pushCallback((byte)4, (String)paramMessage.obj);
      return;
    }
    catch (RemoteException paramMessage) {}
  }
  
  protected final boolean b(int paramInt)
  {
    am.a(paramInt);
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.e).edit();
    localEditor.putInt("cacheSize", paramInt);
    localEditor.apply();
    return true;
  }
  
  protected final void c()
  {
    if (f.b.d == this.n) {
      i();
    }
    for (;;)
    {
      return;
      this.n = f.b.c;
      if (this.c != null)
      {
        this.c.f();
        this.c.a(z.c);
      }
      if (this.d != null)
      {
        this.d.a(true, false);
        if (this.h == null) {}
      }
      try
      {
        this.h.startTraceCallback(124);
        if (!this.g) {
          continue;
        }
        a((short)18, e.a(), null);
        return;
        a(true, false);
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
    }
  }
  
  protected final boolean c(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    Trace.b(paramInt);
    ar.d = paramInt;
    this.f.a("loc_time_offset", String.valueOf(paramInt));
    this.f.a();
    return true;
  }
  
  protected final void d()
  {
    TraceJniInterface.a().socketDisconnection();
    if (this.c != null) {
      this.c.b();
    }
    e.d = 0;
    if (f.b.d == this.n)
    {
      e(0);
      return;
    }
    b(false, true);
    if (com.baidu.trace.b.d.a(this.e))
    {
      this.n = f.b.b;
      this.c.c();
      return;
    }
    f(19);
  }
  
  protected final boolean d(int paramInt)
  {
    if ((this.d != null) && (this.d.a != null))
    {
      this.d.a.a(paramInt);
      return true;
    }
    return false;
  }
  
  protected final void e()
  {
    com.baidu.trace.b.d.a(false);
    if (f.b.d == this.n)
    {
      e(0);
      return;
    }
    f(19);
    b(false, true);
  }
  
  protected final void e(int paramInt)
  {
    g();
    if (this.j)
    {
      unregisterReceiver(this.k);
      this.j = false;
    }
    this.n = f.b.a;
    e.d = 0;
    if (bd.e() > 0) {
      am.a(true);
    }
    if (!PreferenceManager.getDefaultSharedPreferences(this.e).getBoolean("same_process", true)) {
      am.a();
    }
    for (;;)
    {
      try
      {
        if (this.h != null)
        {
          if ((143 != paramInt) && (!bd.h)) {
            continue;
          }
          this.h.stopTraceCallback(143);
        }
      }
      catch (RemoteException localRemoteException)
      {
        continue;
      }
      stopSelf();
      return;
      if (141 == paramInt) {
        this.h.stopTraceCallback(142);
      } else {
        this.h.stopTraceCallback(143);
      }
    }
  }
  
  protected final void f()
    throws RemoteException
  {
    if (f.b.a == this.n)
    {
      if (this.h != null) {
        this.h.stopTraceCallback(27);
      }
      return;
    }
    if (this.c != null) {
      this.c.e();
    }
    if (f.b.d == this.n)
    {
      this.d.a(false, false);
      bd.d = false;
      this.h.stopTraceCallback(182);
    }
    this.n = f.b.d;
    this.d.a(false, false);
    bd.d = false;
    this.d.e = true;
  }
  
  protected final void g()
  {
    this.f.a("client", null);
    this.f.a("gather_interval", null);
    this.f.a("pack_interval", null);
    this.f.a("loc_time_offset", null);
    this.f.a();
  }
  
  public final IListener getClientListener()
  {
    return this.h;
  }
  
  public final int getLocationMode()
  {
    return this.l;
  }
  
  public final Context getServiceContext()
  {
    return this.e;
  }
  
  public final a getTraceHandler()
  {
    return this.a;
  }
  
  protected final void h()
  {
    if ((f.b.c == this.n) || (f.b.d == this.n)) {}
    while (this.c == null) {
      return;
    }
    this.n = f.b.b;
    this.c.b();
    this.c.c();
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return this.b;
  }
  
  public final void onCreate()
  {
    super.onCreate();
    this.e = getApplicationContext();
    this.f = new s(this.e);
    av.a(this.e);
    bc.a().a(this.a);
    this.c = com.baidu.trace.b.d.a();
    this.c.a(this.a, this.e);
    if (d.b == null) {
      d.b = LBSAuthManager.getInstance(this.e);
    }
    q.a(this.e, d.b);
    e.a(this.e);
    am.a(this.e);
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.e);
    if (((SharedPreferences)localObject).contains("cacheSize")) {
      am.a(((SharedPreferences)localObject).getInt("cacheSize", 0));
    }
    localObject = e.c;
    h.b();
    if (d.a == null) {
      d.a();
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    if ((this.c != null) && (f.b.d != this.n)) {
      this.c.b();
    }
    if (this.j)
    {
      unregisterReceiver(this.k);
      this.j = false;
    }
    try
    {
      stopForeground(true);
      if (this.d != null)
      {
        this.d.a();
        if (this.d.a != null) {
          this.d.a.c();
        }
        this.d.c();
        this.d = null;
      }
      if (this.c != null)
      {
        this.c.b();
        this.c = null;
      }
      if (this.f != null)
      {
        this.f.b();
        this.f = null;
      }
      if (!PreferenceManager.getDefaultSharedPreferences(this.e).getBoolean("same_process", true)) {
        d.b();
      }
      ax.b();
      c.b();
      g.b();
      aw.d();
      bd.b();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +751 -> 752
    //   4: aload_1
    //   5: ldc_w 594
    //   8: invokevirtual 599	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   11: ifeq +52 -> 63
    //   14: aload_0
    //   15: getfield 292	com/baidu/trace/LBSTraceService:e	Landroid/content/Context;
    //   18: invokestatic 440	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   21: invokeinterface 446 1 0
    //   26: astore 8
    //   28: aload_1
    //   29: ldc_w 594
    //   32: invokestatic 604	android/os/Process:myPid	()I
    //   35: invokevirtual 607	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   38: invokestatic 604	android/os/Process:myPid	()I
    //   41: if_icmpeq +105 -> 146
    //   44: aload 8
    //   46: ldc_w 489
    //   49: iconst_0
    //   50: invokeinterface 611 3 0
    //   55: pop
    //   56: aload 8
    //   58: invokeinterface 457 1 0
    //   63: aload_1
    //   64: ldc_w 613
    //   67: invokevirtual 599	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   70: ifeq +1697 -> 1767
    //   73: aload_1
    //   74: ldc_w 613
    //   77: iconst_0
    //   78: invokevirtual 607	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   81: istore_2
    //   82: iload_2
    //   83: ifne +1675 -> 1758
    //   86: aload_1
    //   87: ifnonnull +74 -> 161
    //   90: iconst_2
    //   91: newarray <illegal type>
    //   93: astore_1
    //   94: aload_1
    //   95: dup
    //   96: iconst_0
    //   97: ldc_w 614
    //   100: bastore
    //   101: dup
    //   102: iconst_1
    //   103: ldc_w 614
    //   106: bastore
    //   107: pop
    //   108: aload_1
    //   109: iconst_0
    //   110: baload
    //   111: istore 5
    //   113: aload_1
    //   114: iconst_1
    //   115: baload
    //   116: istore 4
    //   118: iload_2
    //   119: tableswitch	default:+25->144, 0:+1022->1141, 1:+1478->1597, 2:+1538->1657
    //   144: iconst_1
    //   145: ireturn
    //   146: aload 8
    //   148: ldc_w 489
    //   151: iconst_1
    //   152: invokeinterface 611 3 0
    //   157: pop
    //   158: goto -102 -> 56
    //   161: aload_1
    //   162: ldc_w 616
    //   165: invokevirtual 599	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   168: ifeq +1585 -> 1753
    //   171: aload_1
    //   172: ldc_w 616
    //   175: invokevirtual 620	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   178: astore_1
    //   179: aload_1
    //   180: ifnonnull +24 -> 204
    //   183: iconst_2
    //   184: newarray <illegal type>
    //   186: astore_1
    //   187: aload_1
    //   188: dup
    //   189: iconst_0
    //   190: ldc_w 614
    //   193: bastore
    //   194: dup
    //   195: iconst_1
    //   196: ldc_w 614
    //   199: bastore
    //   200: pop
    //   201: goto -93 -> 108
    //   204: aload_1
    //   205: ldc_w 622
    //   208: invokevirtual 625	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   211: ifeq +18 -> 229
    //   214: aload_0
    //   215: iconst_1
    //   216: aload_1
    //   217: ldc_w 622
    //   220: invokevirtual 629	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   223: checkcast 631	android/app/Notification
    //   226: invokevirtual 635	com/baidu/trace/LBSTraceService:startForeground	(ILandroid/app/Notification;)V
    //   229: aload_1
    //   230: ldc -116
    //   232: invokevirtual 625	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   235: ifeq +13 -> 248
    //   238: aload_0
    //   239: aload_1
    //   240: ldc -116
    //   242: invokevirtual 395	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   245: putfield 85	com/baidu/trace/LBSTraceService:l	I
    //   248: aload_1
    //   249: ldc -114
    //   251: invokevirtual 625	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   254: ifeq +13 -> 267
    //   257: aload_0
    //   258: aload_1
    //   259: ldc -114
    //   261: invokevirtual 395	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   264: putfield 94	com/baidu/trace/LBSTraceService:m	I
    //   267: aload_1
    //   268: ldc_w 637
    //   271: invokevirtual 625	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   274: ifeq +13 -> 287
    //   277: aload_1
    //   278: ldc_w 637
    //   281: invokevirtual 395	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   284: putstatic 200	com/baidu/trace/Trace:a	I
    //   287: aload_1
    //   288: ldc_w 639
    //   291: invokevirtual 625	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   294: ifeq +13 -> 307
    //   297: aload_1
    //   298: ldc_w 639
    //   301: invokevirtual 395	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   304: putstatic 194	com/baidu/trace/Trace:b	I
    //   307: aload_1
    //   308: ldc_w 448
    //   311: invokevirtual 625	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   314: ifeq +21 -> 335
    //   317: aload_1
    //   318: ldc_w 448
    //   321: invokevirtual 395	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   324: putstatic 640	com/baidu/trace/Trace:c	I
    //   327: aload_0
    //   328: getstatic 640	com/baidu/trace/Trace:c	I
    //   331: invokevirtual 641	com/baidu/trace/LBSTraceService:b	(I)Z
    //   334: pop
    //   335: aload_1
    //   336: ldc_w 643
    //   339: invokevirtual 625	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   342: ifeq +13 -> 355
    //   345: aload_1
    //   346: ldc_w 643
    //   349: invokevirtual 395	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   352: putstatic 470	com/baidu/trace/ar:d	I
    //   355: ldc -2
    //   357: astore 8
    //   359: aload_1
    //   360: ldc 122
    //   362: invokevirtual 625	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   365: ifeq +11 -> 376
    //   368: aload_1
    //   369: ldc 122
    //   371: invokevirtual 406	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   374: astore 8
    //   376: lconst_0
    //   377: lstore 6
    //   379: aload_1
    //   380: ldc -128
    //   382: invokevirtual 625	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   385: ifeq +11 -> 396
    //   388: aload_1
    //   389: ldc -128
    //   391: invokevirtual 412	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   394: lstore 6
    //   396: ldc -2
    //   398: astore 9
    //   400: aload_1
    //   401: ldc -126
    //   403: invokevirtual 625	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   406: ifeq +11 -> 417
    //   409: aload_1
    //   410: ldc -126
    //   412: invokevirtual 406	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   415: astore 9
    //   417: ldc -2
    //   419: astore 10
    //   421: aload_1
    //   422: ldc -124
    //   424: invokevirtual 625	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   427: ifeq +11 -> 438
    //   430: aload_1
    //   431: ldc -124
    //   433: invokevirtual 406	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   436: astore 10
    //   438: ldc -2
    //   440: astore 11
    //   442: aload_1
    //   443: ldc -122
    //   445: invokevirtual 625	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   448: ifeq +11 -> 459
    //   451: aload_1
    //   452: ldc -122
    //   454: invokevirtual 406	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   457: astore 11
    //   459: iconst_0
    //   460: istore 4
    //   462: aload_1
    //   463: ldc -112
    //   465: invokevirtual 625	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   468: ifeq +27 -> 495
    //   471: aload_1
    //   472: ldc -112
    //   474: invokevirtual 645	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   477: istore 4
    //   479: aload_0
    //   480: getfield 62	com/baidu/trace/LBSTraceService:g	Z
    //   483: ifeq +244 -> 727
    //   486: aload_0
    //   487: iload 4
    //   489: putfield 62	com/baidu/trace/LBSTraceService:g	Z
    //   492: iconst_0
    //   493: istore 4
    //   495: getstatic 464	com/baidu/trace/z:c	Ljava/lang/String;
    //   498: aload 9
    //   500: invokevirtual 649	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   503: ifeq +12 -> 515
    //   506: lload 6
    //   508: getstatic 650	com/baidu/trace/z:b	J
    //   511: lcmp
    //   512: ifeq +224 -> 736
    //   515: aload 8
    //   517: putstatic 651	com/baidu/trace/z:a	Ljava/lang/String;
    //   520: lload 6
    //   522: putstatic 650	com/baidu/trace/z:b	J
    //   525: aload 9
    //   527: putstatic 464	com/baidu/trace/z:c	Ljava/lang/String;
    //   530: aload 10
    //   532: putstatic 652	com/baidu/trace/z:d	Ljava/lang/String;
    //   535: aload 11
    //   537: putstatic 654	com/baidu/trace/z:e	Ljava/lang/String;
    //   540: getstatic 657	com/baidu/trace/c/f:a	Ljava/lang/String;
    //   543: putstatic 659	com/baidu/trace/z:l	Ljava/lang/String;
    //   546: getstatic 661	com/baidu/trace/c/f:b	Ljava/lang/String;
    //   549: putstatic 663	com/baidu/trace/z:m	Ljava/lang/String;
    //   552: aload_0
    //   553: invokevirtual 363	com/baidu/trace/LBSTraceService:g	()V
    //   556: new 665	java/lang/StringBuffer
    //   559: dup
    //   560: invokespecial 666	java/lang/StringBuffer:<init>	()V
    //   563: astore_1
    //   564: aload_1
    //   565: getstatic 651	com/baidu/trace/z:a	Ljava/lang/String;
    //   568: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   571: ldc_w 671
    //   574: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   577: getstatic 650	com/baidu/trace/z:b	J
    //   580: invokevirtual 674	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   583: ldc_w 671
    //   586: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   589: getstatic 464	com/baidu/trace/z:c	Ljava/lang/String;
    //   592: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   595: ldc_w 671
    //   598: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   601: getstatic 652	com/baidu/trace/z:d	Ljava/lang/String;
    //   604: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   607: ldc_w 671
    //   610: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   613: getstatic 654	com/baidu/trace/z:e	Ljava/lang/String;
    //   616: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   619: ldc_w 671
    //   622: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   625: getstatic 659	com/baidu/trace/z:l	Ljava/lang/String;
    //   628: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   631: ldc_w 671
    //   634: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   637: getstatic 663	com/baidu/trace/z:m	Ljava/lang/String;
    //   640: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   643: ldc_w 671
    //   646: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   649: aload_0
    //   650: getfield 85	com/baidu/trace/LBSTraceService:l	I
    //   653: invokevirtual 677	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   656: ldc_w 671
    //   659: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   662: aload_0
    //   663: getfield 94	com/baidu/trace/LBSTraceService:m	I
    //   666: invokevirtual 677	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   669: ldc_w 671
    //   672: invokevirtual 669	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   675: aload_0
    //   676: getfield 62	com/baidu/trace/LBSTraceService:g	Z
    //   679: invokevirtual 680	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   682: pop
    //   683: aload_1
    //   684: invokevirtual 681	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   687: astore_1
    //   688: aload_0
    //   689: getfield 222	com/baidu/trace/LBSTraceService:f	Lcom/baidu/trace/s;
    //   692: ldc_w 509
    //   695: aload_1
    //   696: invokevirtual 250	com/baidu/trace/s:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   699: aload_0
    //   700: getfield 222	com/baidu/trace/LBSTraceService:f	Lcom/baidu/trace/s;
    //   703: invokevirtual 252	com/baidu/trace/s:a	()V
    //   706: iconst_2
    //   707: newarray <illegal type>
    //   709: astore_1
    //   710: aload_1
    //   711: dup
    //   712: iconst_0
    //   713: ldc_w 682
    //   716: bastore
    //   717: dup
    //   718: iconst_1
    //   719: ldc_w 614
    //   722: bastore
    //   723: pop
    //   724: goto -616 -> 108
    //   727: aload_0
    //   728: iload 4
    //   730: putfield 62	com/baidu/trace/LBSTraceService:g	Z
    //   733: goto -238 -> 495
    //   736: iconst_2
    //   737: newarray <illegal type>
    //   739: astore_1
    //   740: aload_1
    //   741: iconst_0
    //   742: iconst_0
    //   743: bastore
    //   744: aload_1
    //   745: iconst_1
    //   746: iload 4
    //   748: bastore
    //   749: goto -641 -> 108
    //   752: aconst_null
    //   753: astore_1
    //   754: aload_0
    //   755: getfield 222	com/baidu/trace/LBSTraceService:f	Lcom/baidu/trace/s;
    //   758: ldc_w 509
    //   761: invokevirtual 229	com/baidu/trace/s:a	(Ljava/lang/String;)Ljava/lang/String;
    //   764: astore 8
    //   766: aload 8
    //   768: ifnull +294 -> 1062
    //   771: aload 8
    //   773: invokestatic 684	com/baidu/trace/LBSTraceService:a	(Ljava/lang/String;)Ljava/util/HashMap;
    //   776: astore 8
    //   778: aload 8
    //   780: astore_1
    //   781: aload_1
    //   782: ifnull +259 -> 1041
    //   785: aload_1
    //   786: invokeinterface 689 1 0
    //   791: bipush 10
    //   793: if_icmplt +248 -> 1041
    //   796: aload_1
    //   797: ldc 122
    //   799: invokeinterface 693 2 0
    //   804: checkcast 113	java/lang/String
    //   807: putstatic 651	com/baidu/trace/z:a	Ljava/lang/String;
    //   810: aload_1
    //   811: ldc -128
    //   813: invokeinterface 693 2 0
    //   818: checkcast 113	java/lang/String
    //   821: invokestatic 696	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   824: putstatic 650	com/baidu/trace/z:b	J
    //   827: aload_1
    //   828: ldc -126
    //   830: invokeinterface 693 2 0
    //   835: checkcast 113	java/lang/String
    //   838: putstatic 464	com/baidu/trace/z:c	Ljava/lang/String;
    //   841: aload_1
    //   842: ldc -124
    //   844: invokeinterface 693 2 0
    //   849: checkcast 113	java/lang/String
    //   852: putstatic 652	com/baidu/trace/z:d	Ljava/lang/String;
    //   855: aload_1
    //   856: ldc -122
    //   858: invokeinterface 693 2 0
    //   863: checkcast 113	java/lang/String
    //   866: putstatic 654	com/baidu/trace/z:e	Ljava/lang/String;
    //   869: aload_1
    //   870: ldc -120
    //   872: invokeinterface 693 2 0
    //   877: checkcast 113	java/lang/String
    //   880: putstatic 659	com/baidu/trace/z:l	Ljava/lang/String;
    //   883: aload_1
    //   884: ldc -118
    //   886: invokeinterface 693 2 0
    //   891: checkcast 113	java/lang/String
    //   894: putstatic 663	com/baidu/trace/z:m	Ljava/lang/String;
    //   897: aload_0
    //   898: aload_1
    //   899: ldc -116
    //   901: invokeinterface 693 2 0
    //   906: checkcast 113	java/lang/String
    //   909: invokestatic 699	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   912: putfield 85	com/baidu/trace/LBSTraceService:l	I
    //   915: aload_0
    //   916: aload_1
    //   917: ldc -114
    //   919: invokeinterface 693 2 0
    //   924: checkcast 113	java/lang/String
    //   927: invokestatic 699	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   930: putfield 94	com/baidu/trace/LBSTraceService:m	I
    //   933: aload_0
    //   934: getfield 94	com/baidu/trace/LBSTraceService:m	I
    //   937: ifne +130 -> 1067
    //   940: getstatic 702	com/baidu/trace/model/ProtocolType:HTTP	Lcom/baidu/trace/model/ProtocolType;
    //   943: astore 8
    //   945: aload 8
    //   947: putstatic 706	com/baidu/trace/c/a:b	Lcom/baidu/trace/model/ProtocolType;
    //   950: aload_0
    //   951: aload_1
    //   952: ldc -112
    //   954: invokeinterface 693 2 0
    //   959: checkcast 113	java/lang/String
    //   962: invokestatic 711	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   965: invokevirtual 714	java/lang/Boolean:booleanValue	()Z
    //   968: putfield 62	com/baidu/trace/LBSTraceService:g	Z
    //   971: aload_0
    //   972: getfield 222	com/baidu/trace/LBSTraceService:f	Lcom/baidu/trace/s;
    //   975: ldc_w 285
    //   978: invokevirtual 229	com/baidu/trace/s:a	(Ljava/lang/String;)Ljava/lang/String;
    //   981: invokestatic 109	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   984: ifeq +91 -> 1075
    //   987: iconst_0
    //   988: istore 4
    //   990: iload 4
    //   992: putstatic 283	com/baidu/trace/bd:d	Z
    //   995: aload_0
    //   996: getfield 222	com/baidu/trace/LBSTraceService:f	Lcom/baidu/trace/s;
    //   999: ldc_w 372
    //   1002: invokevirtual 229	com/baidu/trace/s:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1005: invokestatic 699	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1008: aload_0
    //   1009: getfield 222	com/baidu/trace/LBSTraceService:f	Lcom/baidu/trace/s;
    //   1012: ldc_w 377
    //   1015: invokevirtual 229	com/baidu/trace/s:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1018: invokestatic 699	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1021: invokestatic 380	com/baidu/trace/Trace:a	(II)Z
    //   1024: pop
    //   1025: aload_0
    //   1026: getfield 222	com/baidu/trace/LBSTraceService:f	Lcom/baidu/trace/s;
    //   1029: ldc_w 472
    //   1032: invokevirtual 229	com/baidu/trace/s:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1035: invokestatic 699	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1038: putstatic 470	com/baidu/trace/ar:d	I
    //   1041: aload_1
    //   1042: ifnull +700 -> 1742
    //   1045: aload_1
    //   1046: invokeinterface 717 1 0
    //   1051: iconst_0
    //   1052: istore_2
    //   1053: iconst_0
    //   1054: istore 4
    //   1056: iconst_0
    //   1057: istore 5
    //   1059: goto -941 -> 118
    //   1062: aconst_null
    //   1063: astore_1
    //   1064: goto -283 -> 781
    //   1067: getstatic 91	com/baidu/trace/model/ProtocolType:HTTPS	Lcom/baidu/trace/model/ProtocolType;
    //   1070: astore 8
    //   1072: goto -127 -> 945
    //   1075: aload_0
    //   1076: getfield 222	com/baidu/trace/LBSTraceService:f	Lcom/baidu/trace/s;
    //   1079: ldc_w 285
    //   1082: invokevirtual 229	com/baidu/trace/s:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1085: invokestatic 711	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1088: invokevirtual 714	java/lang/Boolean:booleanValue	()Z
    //   1091: istore 4
    //   1093: goto -103 -> 990
    //   1096: astore 8
    //   1098: aload_1
    //   1099: ifnull +643 -> 1742
    //   1102: aload_1
    //   1103: invokeinterface 717 1 0
    //   1108: iconst_0
    //   1109: istore_2
    //   1110: iconst_0
    //   1111: istore 4
    //   1113: iconst_0
    //   1114: istore 5
    //   1116: goto -998 -> 118
    //   1119: astore_1
    //   1120: aconst_null
    //   1121: astore 9
    //   1123: aload_1
    //   1124: astore 8
    //   1126: aload 9
    //   1128: ifnull +10 -> 1138
    //   1131: aload 9
    //   1133: invokeinterface 717 1 0
    //   1138: aload 8
    //   1140: athrow
    //   1141: aload_0
    //   1142: getfield 292	com/baidu/trace/LBSTraceService:e	Landroid/content/Context;
    //   1145: invokestatic 718	com/baidu/trace/z:a	(Landroid/content/Context;)V
    //   1148: invokestatic 318	com/baidu/trace/TraceJniInterface:a	()Lcom/baidu/trace/TraceJniInterface;
    //   1151: getstatic 651	com/baidu/trace/z:a	Ljava/lang/String;
    //   1154: invokevirtual 722	java/lang/String:getBytes	()[B
    //   1157: getstatic 464	com/baidu/trace/z:c	Ljava/lang/String;
    //   1160: invokevirtual 722	java/lang/String:getBytes	()[B
    //   1163: getstatic 650	com/baidu/trace/z:b	J
    //   1166: getstatic 652	com/baidu/trace/z:d	Ljava/lang/String;
    //   1169: invokevirtual 722	java/lang/String:getBytes	()[B
    //   1172: getstatic 654	com/baidu/trace/z:e	Ljava/lang/String;
    //   1175: invokevirtual 722	java/lang/String:getBytes	()[B
    //   1178: invokevirtual 726	com/baidu/trace/TraceJniInterface:setAppInfo	([B[BJ[B[B)V
    //   1181: invokestatic 318	com/baidu/trace/TraceJniInterface:a	()Lcom/baidu/trace/TraceJniInterface;
    //   1184: getstatic 728	com/baidu/trace/z:h	Ljava/lang/String;
    //   1187: invokevirtual 722	java/lang/String:getBytes	()[B
    //   1190: getstatic 730	com/baidu/trace/z:i	Ljava/lang/String;
    //   1193: invokevirtual 722	java/lang/String:getBytes	()[B
    //   1196: getstatic 732	com/baidu/trace/z:j	Ljava/lang/String;
    //   1199: invokevirtual 722	java/lang/String:getBytes	()[B
    //   1202: getstatic 734	com/baidu/trace/z:f	Ljava/lang/String;
    //   1205: invokevirtual 722	java/lang/String:getBytes	()[B
    //   1208: getstatic 736	com/baidu/trace/z:g	Ljava/lang/String;
    //   1211: invokevirtual 722	java/lang/String:getBytes	()[B
    //   1214: getstatic 738	com/baidu/trace/z:k	Ljava/lang/String;
    //   1217: invokevirtual 722	java/lang/String:getBytes	()[B
    //   1220: getstatic 659	com/baidu/trace/z:l	Ljava/lang/String;
    //   1223: invokevirtual 722	java/lang/String:getBytes	()[B
    //   1226: getstatic 663	com/baidu/trace/z:m	Ljava/lang/String;
    //   1229: invokevirtual 722	java/lang/String:getBytes	()[B
    //   1232: invokevirtual 742	com/baidu/trace/TraceJniInterface:setDeviceInfo	([B[B[B[B[B[B[B[B)V
    //   1235: getstatic 98	com/baidu/trace/c/f$b:a	Lcom/baidu/trace/c/f$b;
    //   1238: aload_0
    //   1239: getfield 100	com/baidu/trace/LBSTraceService:n	Lcom/baidu/trace/c/f$b;
    //   1242: if_acmpne +43 -> 1285
    //   1245: aload_0
    //   1246: iconst_1
    //   1247: iconst_0
    //   1248: invokespecial 477	com/baidu/trace/LBSTraceService:b	(ZZ)V
    //   1251: getstatic 745	com/baidu/trace/ar:a	Lcom/baidu/trace/aj;
    //   1254: ifnonnull +17 -> 1271
    //   1257: new 747	com/baidu/trace/aj
    //   1260: dup
    //   1261: aload_0
    //   1262: getfield 292	com/baidu/trace/LBSTraceService:e	Landroid/content/Context;
    //   1265: invokespecial 748	com/baidu/trace/aj:<init>	(Landroid/content/Context;)V
    //   1268: putstatic 745	com/baidu/trace/ar:a	Lcom/baidu/trace/aj;
    //   1271: new 433	com/baidu/trace/am
    //   1274: dup
    //   1275: iconst_1
    //   1276: getstatic 464	com/baidu/trace/z:c	Ljava/lang/String;
    //   1279: invokespecial 750	com/baidu/trace/am:<init>	(ILjava/lang/String;)V
    //   1282: invokevirtual 751	com/baidu/trace/am:start	()V
    //   1285: iload 5
    //   1287: ifeq +23 -> 1310
    //   1290: iconst_0
    //   1291: invokestatic 752	com/baidu/trace/bd:a	(Z)V
    //   1294: getstatic 755	com/baidu/trace/c/a:a	Ljava/util/concurrent/ExecutorService;
    //   1297: new 757	com/baidu/trace/aq
    //   1300: dup
    //   1301: aload_0
    //   1302: invokespecial 758	com/baidu/trace/aq:<init>	(Lcom/baidu/trace/LBSTraceService;)V
    //   1305: invokeinterface 764 2 0
    //   1310: aload_0
    //   1311: getfield 292	com/baidu/trace/LBSTraceService:e	Landroid/content/Context;
    //   1314: invokestatic 480	com/baidu/trace/b/d:a	(Landroid/content/Context;)Z
    //   1317: ifne +62 -> 1379
    //   1320: ldc_w 766
    //   1323: ldc_w 768
    //   1326: invokestatic 771	com/baidu/trace/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1329: aload_0
    //   1330: invokevirtual 772	com/baidu/trace/LBSTraceService:e	()V
    //   1333: goto -1189 -> 144
    //   1336: astore_1
    //   1337: iconst_0
    //   1338: newarray <illegal type>
    //   1340: astore_1
    //   1341: invokestatic 318	com/baidu/trace/TraceJniInterface:a	()Lcom/baidu/trace/TraceJniInterface;
    //   1344: aload_1
    //   1345: aload_1
    //   1346: getstatic 650	com/baidu/trace/z:b	J
    //   1349: aload_1
    //   1350: aload_1
    //   1351: invokevirtual 726	com/baidu/trace/TraceJniInterface:setAppInfo	([B[BJ[B[B)V
    //   1354: goto -173 -> 1181
    //   1357: astore_1
    //   1358: iconst_0
    //   1359: newarray <illegal type>
    //   1361: astore_1
    //   1362: invokestatic 318	com/baidu/trace/TraceJniInterface:a	()Lcom/baidu/trace/TraceJniInterface;
    //   1365: aload_1
    //   1366: aload_1
    //   1367: aload_1
    //   1368: aload_1
    //   1369: aload_1
    //   1370: aload_1
    //   1371: aload_1
    //   1372: aload_1
    //   1373: invokevirtual 742	com/baidu/trace/TraceJniInterface:setDeviceInfo	([B[B[B[B[B[B[B[B)V
    //   1376: goto -141 -> 1235
    //   1379: iload 5
    //   1381: ifeq +47 -> 1428
    //   1384: aload_0
    //   1385: getstatic 298	com/baidu/trace/c/f$b:b	Lcom/baidu/trace/c/f$b;
    //   1388: putfield 100	com/baidu/trace/LBSTraceService:n	Lcom/baidu/trace/c/f$b;
    //   1391: aload_0
    //   1392: getfield 58	com/baidu/trace/LBSTraceService:c	Lcom/baidu/trace/b/d;
    //   1395: ifnull +10 -> 1405
    //   1398: aload_0
    //   1399: getfield 58	com/baidu/trace/LBSTraceService:c	Lcom/baidu/trace/b/d;
    //   1402: invokevirtual 325	com/baidu/trace/b/d:b	()V
    //   1405: invokestatic 318	com/baidu/trace/TraceJniInterface:a	()Lcom/baidu/trace/TraceJniInterface;
    //   1408: invokevirtual 321	com/baidu/trace/TraceJniInterface:socketDisconnection	()V
    //   1411: aload_0
    //   1412: getfield 58	com/baidu/trace/LBSTraceService:c	Lcom/baidu/trace/b/d;
    //   1415: ifnull -1271 -> 144
    //   1418: aload_0
    //   1419: getfield 58	com/baidu/trace/LBSTraceService:c	Lcom/baidu/trace/b/d;
    //   1422: invokevirtual 481	com/baidu/trace/b/d:c	()V
    //   1425: goto -1281 -> 144
    //   1428: getstatic 775	com/baidu/trace/LBSTraceService$1:a	[I
    //   1431: aload_0
    //   1432: getfield 100	com/baidu/trace/LBSTraceService:n	Lcom/baidu/trace/c/f$b;
    //   1435: invokevirtual 776	com/baidu/trace/c/f$b:ordinal	()I
    //   1438: iaload
    //   1439: tableswitch	default:+29->1468, 1:+32->1471, 2:+57->1496, 3:+83->1522, 4:+114->1553
    //   1468: goto -1324 -> 144
    //   1471: aload_0
    //   1472: getfield 64	com/baidu/trace/LBSTraceService:h	Lcom/baidu/trace/IListener;
    //   1475: ifnull -1331 -> 144
    //   1478: aload_0
    //   1479: getfield 64	com/baidu/trace/LBSTraceService:h	Lcom/baidu/trace/IListener;
    //   1482: bipush 22
    //   1484: invokeinterface 296 2 0
    //   1489: goto -1345 -> 144
    //   1492: astore_1
    //   1493: goto -1349 -> 144
    //   1496: aload_0
    //   1497: getfield 64	com/baidu/trace/LBSTraceService:h	Lcom/baidu/trace/IListener;
    //   1500: ifnull -1356 -> 144
    //   1503: aload_0
    //   1504: getfield 64	com/baidu/trace/LBSTraceService:h	Lcom/baidu/trace/IListener;
    //   1507: sipush 181
    //   1510: invokeinterface 296 2 0
    //   1515: goto -1371 -> 144
    //   1518: astore_1
    //   1519: goto -1375 -> 144
    //   1522: aload_0
    //   1523: getstatic 298	com/baidu/trace/c/f$b:b	Lcom/baidu/trace/c/f$b;
    //   1526: putfield 100	com/baidu/trace/LBSTraceService:n	Lcom/baidu/trace/c/f$b;
    //   1529: aload_0
    //   1530: getfield 58	com/baidu/trace/LBSTraceService:c	Lcom/baidu/trace/b/d;
    //   1533: ifnull -1389 -> 144
    //   1536: aload_0
    //   1537: getfield 58	com/baidu/trace/LBSTraceService:c	Lcom/baidu/trace/b/d;
    //   1540: invokevirtual 325	com/baidu/trace/b/d:b	()V
    //   1543: aload_0
    //   1544: getfield 58	com/baidu/trace/LBSTraceService:c	Lcom/baidu/trace/b/d;
    //   1547: invokevirtual 481	com/baidu/trace/b/d:c	()V
    //   1550: goto -1406 -> 144
    //   1553: aload_0
    //   1554: getfield 64	com/baidu/trace/LBSTraceService:h	Lcom/baidu/trace/IListener;
    //   1557: ifnull +14 -> 1571
    //   1560: aload_0
    //   1561: getfield 64	com/baidu/trace/LBSTraceService:h	Lcom/baidu/trace/IListener;
    //   1564: bipush 25
    //   1566: invokeinterface 296 2 0
    //   1571: iload 4
    //   1573: ifeq -1429 -> 144
    //   1576: aload_0
    //   1577: getfield 62	com/baidu/trace/LBSTraceService:g	Z
    //   1580: ifeq -1436 -> 144
    //   1583: aload_0
    //   1584: bipush 18
    //   1586: invokestatic 349	com/baidu/trace/c/e:a	()I
    //   1589: aconst_null
    //   1590: invokevirtual 357	com/baidu/trace/LBSTraceService:a	(SILcom/baidu/trace/c/f$a;)Z
    //   1593: pop
    //   1594: goto -1450 -> 144
    //   1597: aload_0
    //   1598: getfield 64	com/baidu/trace/LBSTraceService:h	Lcom/baidu/trace/IListener;
    //   1601: ifnull +22 -> 1623
    //   1604: getstatic 283	com/baidu/trace/bd:d	Z
    //   1607: ifeq +44 -> 1651
    //   1610: bipush 54
    //   1612: istore_2
    //   1613: aload_0
    //   1614: getfield 64	com/baidu/trace/LBSTraceService:h	Lcom/baidu/trace/IListener;
    //   1617: iload_2
    //   1618: invokeinterface 779 2 0
    //   1623: iconst_1
    //   1624: putstatic 283	com/baidu/trace/bd:d	Z
    //   1627: aload_0
    //   1628: getfield 222	com/baidu/trace/LBSTraceService:f	Lcom/baidu/trace/s;
    //   1631: ldc_w 285
    //   1634: iconst_1
    //   1635: invokestatic 288	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1638: invokevirtual 250	com/baidu/trace/s:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1641: aload_0
    //   1642: getfield 222	com/baidu/trace/LBSTraceService:f	Lcom/baidu/trace/s;
    //   1645: invokevirtual 252	com/baidu/trace/s:a	()V
    //   1648: goto -1504 -> 144
    //   1651: bipush 52
    //   1653: istore_2
    //   1654: goto -41 -> 1613
    //   1657: aload_0
    //   1658: getfield 64	com/baidu/trace/LBSTraceService:h	Lcom/baidu/trace/IListener;
    //   1661: ifnull +22 -> 1683
    //   1664: getstatic 283	com/baidu/trace/bd:d	Z
    //   1667: ifeq +44 -> 1711
    //   1670: bipush 55
    //   1672: istore_2
    //   1673: aload_0
    //   1674: getfield 64	com/baidu/trace/LBSTraceService:h	Lcom/baidu/trace/IListener;
    //   1677: iload_2
    //   1678: invokeinterface 779 2 0
    //   1683: iconst_0
    //   1684: putstatic 283	com/baidu/trace/bd:d	Z
    //   1687: aload_0
    //   1688: getfield 222	com/baidu/trace/LBSTraceService:f	Lcom/baidu/trace/s;
    //   1691: ldc_w 285
    //   1694: iconst_0
    //   1695: invokestatic 288	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1698: invokevirtual 250	com/baidu/trace/s:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1701: aload_0
    //   1702: getfield 222	com/baidu/trace/LBSTraceService:f	Lcom/baidu/trace/s;
    //   1705: invokevirtual 252	com/baidu/trace/s:a	()V
    //   1708: goto -1564 -> 144
    //   1711: bipush 57
    //   1713: istore_2
    //   1714: goto -41 -> 1673
    //   1717: astore_1
    //   1718: goto -35 -> 1683
    //   1721: astore_1
    //   1722: goto -99 -> 1623
    //   1725: astore_1
    //   1726: goto -155 -> 1571
    //   1729: astore 8
    //   1731: aload_1
    //   1732: astore 9
    //   1734: goto -608 -> 1126
    //   1737: astore 8
    //   1739: goto -641 -> 1098
    //   1742: iconst_0
    //   1743: istore_2
    //   1744: iconst_0
    //   1745: istore 4
    //   1747: iconst_0
    //   1748: istore 5
    //   1750: goto -1632 -> 118
    //   1753: aconst_null
    //   1754: astore_1
    //   1755: goto -1576 -> 179
    //   1758: iconst_0
    //   1759: istore 4
    //   1761: iconst_0
    //   1762: istore 5
    //   1764: goto -1646 -> 118
    //   1767: iconst_0
    //   1768: istore_2
    //   1769: goto -1687 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1772	0	this	LBSTraceService
    //   0	1772	1	paramIntent	Intent
    //   0	1772	2	paramInt1	int
    //   0	1772	3	paramInt2	int
    //   116	345	4	i1	int
    //   477	1283	4	bool	boolean
    //   111	1652	5	i2	int
    //   377	144	6	l1	long
    //   26	1045	8	localObject1	Object
    //   1096	1	8	localException1	Exception
    //   1124	15	8	localIntent	Intent
    //   1729	1	8	localObject2	Object
    //   1737	1	8	localException2	Exception
    //   398	1335	9	localObject3	Object
    //   419	112	10	str1	String
    //   440	96	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   754	766	1096	java/lang/Exception
    //   771	778	1096	java/lang/Exception
    //   754	766	1119	finally
    //   771	778	1119	finally
    //   1148	1181	1336	java/lang/Exception
    //   1181	1235	1357	java/lang/Exception
    //   1478	1489	1492	java/lang/Exception
    //   1503	1515	1518	android/os/RemoteException
    //   1673	1683	1717	android/os/RemoteException
    //   1613	1623	1721	android/os/RemoteException
    //   1560	1571	1725	android/os/RemoteException
    //   785	945	1729	finally
    //   945	987	1729	finally
    //   990	1041	1729	finally
    //   1067	1072	1729	finally
    //   1075	1093	1729	finally
    //   785	945	1737	java/lang/Exception
    //   945	987	1737	java/lang/Exception
    //   990	1041	1737	java/lang/Exception
    //   1067	1072	1737	java/lang/Exception
    //   1075	1093	1737	java/lang/Exception
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    return super.onUnbind(paramIntent);
  }
  
  public final void setClientListener(IListener paramIListener)
  {
    this.h = paramIListener;
  }
  
  static class ServiceBinder
    extends IService.Stub
  {
    private WeakReference<LBSTraceService> service = null;
    
    public ServiceBinder(LBSTraceService paramLBSTraceService)
    {
      this.service = new WeakReference(paramLBSTraceService);
    }
    
    public void handleExtendedOperate(int paramInt)
      throws RemoteException
    {
      if (LBSTraceService.a((LBSTraceService)this.service.get()))
      {
        g.b();
        ((LBSTraceService)this.service.get()).a((short)18, e.a(), null);
      }
    }
    
    public boolean handleLocalFence(int paramInt, long paramLong, String paramString)
      throws RemoteException
    {
      Object localObject = LBSTraceService.e((LBSTraceService)this.service.get()).getSharedPreferences("com.baidu.trace_fence_status", 0).edit();
      switch (paramInt)
      {
      }
      for (;;)
      {
        return false;
        try
        {
          paramString = new JSONObject(paramString);
          localObject = CircleFence.buildLocalFence(paramLong, null, null, null, 0.0D, 0, CoordType.bd09ll);
          a.a(paramString, (CircleFence)localObject);
          if (ar.a == null) {
            continue;
          }
          ar.a.a(paramLong, (Fence)localObject);
        }
        catch (JSONException paramString) {}
        continue;
        CircleFence localCircleFence;
        try
        {
          paramString = new JSONObject(paramString);
          localCircleFence = CircleFence.buildLocalFence(paramLong, null, null, null, 0.0D, 0, CoordType.bd09ll);
          a.a(paramString, localCircleFence);
          if (ar.a == null) {
            continue;
          }
          ar.a.a(paramLong, localCircleFence);
          ((SharedPreferences.Editor)localObject).remove(String.valueOf(paramLong));
          ((SharedPreferences.Editor)localObject).apply();
        }
        catch (JSONException paramString) {}
        continue;
        if (ar.a != null)
        {
          paramString = paramString.split(",");
          try
          {
            int i = paramString.length;
            paramInt = 0;
            while (paramInt < i)
            {
              localCircleFence = paramString[paramInt];
              ar.a.a(Long.valueOf(localCircleFence).longValue());
              ((SharedPreferences.Editor)localObject).remove(localCircleFence);
              ((SharedPreferences.Editor)localObject).apply();
              paramInt += 1;
            }
            if (ar.a != null)
            {
              ar.a.c();
              ((SharedPreferences.Editor)localObject).clear();
              ((SharedPreferences.Editor)localObject).apply();
            }
          }
          catch (Exception paramString) {}
        }
      }
    }
    
    public boolean queryRealTimeLoc(TraceLocation paramTraceLocation)
      throws RemoteException
    {
      return false;
    }
    
    public void registerListener(IListener paramIListener)
      throws RemoteException
    {
      ((LBSTraceService)this.service.get()).setClientListener(paramIListener);
      if (LBSTraceService.d((LBSTraceService)this.service.get()))
      {
        paramIListener.startTraceCallback(19);
        LBSTraceService.a((LBSTraceService)this.service.get(), false);
      }
    }
    
    public boolean setCacheSize(int paramInt)
      throws RemoteException
    {
      return ((LBSTraceService)this.service.get()).b(paramInt);
    }
    
    public boolean setInterval(int paramInt1, int paramInt2)
      throws RemoteException
    {
      ((LBSTraceService)this.service.get()).a(paramInt1, paramInt2);
      return true;
    }
    
    public boolean setLocTimeOffset(int paramInt)
      throws RemoteException
    {
      return ((LBSTraceService)this.service.get()).c(paramInt);
    }
    
    public boolean setLocationMode(int paramInt)
      throws RemoteException
    {
      return ((LBSTraceService)this.service.get()).d(paramInt);
    }
    
    public boolean setProtocolType(int paramInt)
      throws RemoteException
    {
      if (paramInt == 0) {}
      for (ProtocolType localProtocolType = ProtocolType.HTTP;; localProtocolType = ProtocolType.HTTPS)
      {
        com.baidu.trace.c.a.b = localProtocolType;
        return true;
      }
    }
    
    public int startGather()
      throws RemoteException
    {
      return LBSTraceService.c((LBSTraceService)this.service.get());
    }
    
    public int stopGather()
      throws RemoteException
    {
      return LBSTraceService.b((LBSTraceService)this.service.get());
    }
    
    public void stopTrace(long paramLong, String paramString)
      throws RemoteException
    {
      try
      {
        ((LBSTraceService)this.service.get()).f();
        return;
      }
      catch (RemoteException paramString) {}
    }
    
    public void unregisterListener()
      throws RemoteException
    {
      ((LBSTraceService)this.service.get()).setClientListener(null);
    }
  }
  
  static final class a
    extends Handler
  {
    private WeakReference<LBSTraceService> a = null;
    
    public a(LBSTraceService paramLBSTraceService)
    {
      this.a = new WeakReference(paramLBSTraceService);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      LBSTraceService localLBSTraceService = (LBSTraceService)this.a.get();
      if (localLBSTraceService == null) {}
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1: 
          localLBSTraceService.a();
          return;
        case 19: 
          localLBSTraceService.e();
          return;
        case 4: 
          localLBSTraceService.d();
          return;
        case 28: 
          localLBSTraceService.b();
          return;
        case 29: 
          localLBSTraceService.c();
          return;
        case 30: 
          localLBSTraceService.a(paramMessage.arg1);
          return;
        case 141: 
          localLBSTraceService.e(paramMessage.arg1);
          return;
        case 161: 
          localLBSTraceService.a(paramMessage);
          return;
        case 163: 
          localLBSTraceService.b(paramMessage);
          return;
        case 23: 
          localLBSTraceService.g();
          return;
        case 24: 
          localLBSTraceService.h();
          return;
        }
      } while (!LBSTraceService.a(localLBSTraceService));
      localLBSTraceService.a((short)18, e.a(), null);
      return;
      LBSTraceService.a(localLBSTraceService, paramMessage.arg1);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/LBSTraceService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */