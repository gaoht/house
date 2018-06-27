package com.mob;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.mob.commons.MobProduct;
import com.mob.commons.MobProductCollector;
import com.mob.commons.a;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class MobUser
  implements PublicMemberKeeper
{
  private static MobCommunicator a = new MobCommunicator(1024, "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f", "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1");
  private static Handler b = MobHandlerThread.newHandler("m", new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return false;
      case 1: 
        paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
        MobUser.b((String)paramAnonymousMessage[0], (String)paramAnonymousMessage[1], (String)paramAnonymousMessage[2], (HashMap)paramAnonymousMessage[3], (String)paramAnonymousMessage[4]);
        return false;
      case 2: 
        MobUser.b((MobUser.OnUserGotListener)paramAnonymousMessage.obj);
        return false;
      }
      MobUser.b();
      return false;
    }
  });
  private static String c;
  private static MobUser d = new MobUser();
  private boolean e;
  private String f;
  private String g;
  private String h;
  private HashMap<String, Object> i;
  private String j;
  private String k;
  private long l;
  private HashSet<UserWatcher> m = new HashSet();
  
  static HashMap<String, String> a(String[] paramArrayOfString)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("appUserIds", paramArrayOfString);
      localHashMap.put("appkey", MobSDK.getAppkey());
      paramArrayOfString = (HashMap)a.requestSynchronized(localHashMap, "http://api.u.mob.com/exchange", false);
      return paramArrayOfString;
    }
    catch (Throwable paramArrayOfString)
    {
      MobLog.getInstance().d(paramArrayOfString);
    }
    return null;
  }
  
  static void a()
  {
    b.sendEmptyMessage(3);
  }
  
  static void a(OnUserGotListener paramOnUserGotListener)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.obj = paramOnUserGotListener;
    b.sendMessage(localMessage);
  }
  
  static void a(UserWatcher paramUserWatcher)
  {
    synchronized (d.m)
    {
      d.m.add(paramUserWatcher);
      return;
    }
  }
  
  static void a(String paramString1, String paramString2, String paramString3, HashMap<String, Object> paramHashMap, String paramString4)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramString1, paramString2, paramString3, paramHashMap, paramString4 };
    b.sendMessage(localMessage);
  }
  
  private static void a(String paramString1, String paramString2, HashMap<String, Object> paramHashMap)
  {
    if (d.k == null)
    {
      d.g = paramString1;
      d.h = paramString2;
      d.i = paramHashMap;
      return;
    }
    if (!d.f())
    {
      d(d.f, paramString1, paramString2, paramHashMap, d.j);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("mobUserId", d.k);
    if (TextUtils.isEmpty(paramString1))
    {
      localObject = "";
      label92:
      localHashMap.put("nickname", localObject);
      if (!TextUtils.isEmpty(paramString2)) {
        break label228;
      }
      localObject = "";
      label111:
      localHashMap.put("avatar", localObject);
      if (paramHashMap == null) {
        break label233;
      }
    }
    label228:
    label233:
    for (Object localObject = new HashMap();; localObject = paramHashMap)
    {
      localHashMap.put("appUserMap", localObject);
      try
      {
        a.requestSynchronized(localHashMap, "http://api.u.mob.com/modify", false);
        d.g = paramString1;
        d.h = paramString2;
        d.i = paramHashMap;
        paramString1 = d.m.iterator();
        while (paramString1.hasNext()) {
          ((UserWatcher)paramString1.next()).onUserStateChange(d);
        }
        localObject = paramString1;
      }
      catch (Throwable paramString1)
      {
        MobLog.getInstance().w(paramString1);
        return;
      }
      break label92;
      localObject = paramString2;
      break label111;
    }
  }
  
  static void b(UserWatcher paramUserWatcher)
  {
    synchronized (d.m)
    {
      d.m.remove(paramUserWatcher);
      return;
    }
  }
  
  private static void c(OnUserGotListener paramOnUserGotListener)
  {
    if ((d.k == null) || (!d.f())) {
      d(d.f, d.g, d.h, d.i, d.j);
    }
    if (paramOnUserGotListener != null) {
      UIHandler.sendEmptyMessage(0, new Handler.Callback()
      {
        public boolean handleMessage(Message paramAnonymousMessage)
        {
          this.a.onUserGot(MobUser.c());
          return false;
        }
      });
    }
  }
  
  private static void c(String paramString1, String paramString2, String paramString3, HashMap<String, Object> paramHashMap, String paramString4)
  {
    if ((d.k == null) || (!d.f()) || (!ResHelper.isEqual(paramString1, d.f)))
    {
      d(paramString1, paramString2, paramString3, paramHashMap, paramString4);
      return;
    }
    a(paramString2, paramString3, paramHashMap);
  }
  
  private static String d()
  {
    if (c == null)
    {
      localObject = MobProductCollector.getProducts();
      if (!((List)localObject).isEmpty()) {
        break label32;
      }
    }
    label32:
    for (Object localObject = null;; localObject = (MobProduct)((List)localObject).get(0))
    {
      c = DeviceAuthorizer.authorize((MobProduct)localObject);
      return c;
    }
  }
  
  private static void d(String paramString1, String paramString2, String paramString3, HashMap<String, Object> paramHashMap, String paramString4)
  {
    if (d.k != null) {
      e();
    }
    Object localObject2 = new HashMap();
    Object localObject3 = MobProductCollector.getProducts();
    Object localObject1 = new ArrayList();
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((ArrayList)localObject1).add(((MobProduct)((Iterator)localObject3).next()).getProductTag());
    }
    ((HashMap)localObject2).put("sdks", localObject1);
    if (!TextUtils.isEmpty(paramString1)) {
      ((HashMap)localObject2).put("appUserId", paramString1);
    }
    ((HashMap)localObject2).put("appkey", MobSDK.getAppkey());
    if (TextUtils.isEmpty(paramString2))
    {
      localObject1 = "";
      ((HashMap)localObject2).put("nickname", localObject1);
      if (!TextUtils.isEmpty(paramString3)) {
        break label377;
      }
      localObject1 = "";
      label147:
      ((HashMap)localObject2).put("avatar", localObject1);
      if (paramHashMap != null) {
        break label383;
      }
    }
    label377:
    label383:
    for (localObject1 = new HashMap();; localObject1 = paramHashMap)
    {
      ((HashMap)localObject2).put("appUserMap", localObject1);
      ((HashMap)localObject2).put("duid", d());
      if (!TextUtils.isEmpty(paramString4)) {
        ((HashMap)localObject2).put("sign", paramString4);
      }
      try
      {
        localObject1 = (HashMap)a.requestSynchronized((HashMap)localObject2, "http://api.u.mob.com/login", false);
        localObject2 = (String)((HashMap)localObject1).get("mobUserId");
        long l1 = Long.parseLong(String.valueOf(((HashMap)localObject1).get("loginExpireAt")));
        a.a();
        d.f = paramString1;
        d.e = TextUtils.isEmpty(paramString1);
        d.g = paramString2;
        d.h = paramString3;
        d.i = paramHashMap;
        d.j = paramString4;
        d.k = ((String)localObject2);
        d.l = l1;
        paramString1 = d.m.iterator();
        while (paramString1.hasNext()) {
          ((UserWatcher)paramString1.next()).onUserStateChange(d);
        }
        return;
      }
      catch (Throwable paramString1)
      {
        MobLog.getInstance().w(paramString1);
      }
      localObject1 = paramString2;
      break;
      localObject1 = paramString3;
      break label147;
    }
  }
  
  private static void e()
  {
    int n = 0;
    Object localObject;
    if (d.k != null)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("mobUserId", d.k);
    }
    try
    {
      a.requestSynchronized((HashMap)localObject, "http://api.u.mob.com/logout", false);
      if ((d.k != null) || (d.f != null) || (d.g != null) || (d.h != null) || (d.i != null) || (d.j != null) || (!d.e) || (d.l != 0L)) {
        n = 1;
      }
      d.k = null;
      d.f = null;
      d.g = null;
      d.h = null;
      d.i = null;
      d.j = null;
      d.e = true;
      d.l = 0L;
      if (n != 0)
      {
        localObject = d.m.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((UserWatcher)((Iterator)localObject).next()).onUserStateChange(d);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        MobLog.getInstance().w(localThrowable);
      }
    }
  }
  
  private boolean f()
  {
    return a.a() < this.l;
  }
  
  public String getAvatar()
  {
    return this.h;
  }
  
  public HashMap<String, Object> getExtraInfo()
  {
    return this.i;
  }
  
  public String getId()
  {
    return this.f;
  }
  
  public String getMobUserId()
  {
    return this.k;
  }
  
  public String getNickName()
  {
    return this.g;
  }
  
  public boolean isAnonymous()
  {
    return this.e;
  }
  
  public static abstract interface OnUserGotListener
  {
    public abstract void onUserGot(MobUser paramMobUser);
  }
  
  public static abstract interface UserWatcher
  {
    public abstract void onUserStateChange(MobUser paramMobUser);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/MobUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */