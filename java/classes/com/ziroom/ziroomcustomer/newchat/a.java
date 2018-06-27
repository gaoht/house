package com.ziroom.ziroomcustomer.newchat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.chat.j;
import com.ziroom.ziroomcustomer.minsu.service.ZrIntentService;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.Random;

public class a
{
  public static final String a = a.class.getSimpleName();
  
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Random localRandom = new Random();
    int i = 0;
    while (i < 8)
    {
      localStringBuilder.append(localRandom.nextInt(10));
      i += 1;
    }
    i = Integer.parseInt(localStringBuilder.toString());
    return "customer_" + i;
  }
  
  private static void a(Context paramContext, EMCallBack paramEMCallBack)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(a, "Thread name = " + Thread.currentThread().getName() + " thread id = " + Thread.currentThread().getId() + " is main = " + paramContext.getMainLooper().isCurrentThread());
    EMClient.getInstance().logout(false, new a.2(paramContext, paramEMCallBack));
  }
  
  private static void a(Context paramContext, String paramString)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(a, "Thread name = " + Thread.currentThread().getName() + " thread id = " + Thread.currentThread().getId() + " is main = " + paramContext.getMainLooper().isCurrentThread());
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", "ChatUtils -------- logoutAndLogin ");
    EMClient.getInstance().logout(true, new a.3(paramContext, paramString));
  }
  
  private static void b(String paramString1, String paramString2, Context paramContext)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", "ChatUtils ----开始登陆!---- " + paramString1);
    long l = System.currentTimeMillis();
    EMClient.getInstance().login(paramString1, paramString2, new a.1(paramContext, l));
  }
  
  public static void createAndLogin(Context paramContext, String paramString)
  {
    int i;
    try
    {
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(a, "Thread name = " + Thread.currentThread().getName() + " thread id = " + Thread.currentThread().getId() + " is main = " + paramContext.getMainLooper().isCurrentThread());
      EMClient.getInstance().createAccount(paramString, "home,link/");
      if (EMClient.getInstance().isLoggedInBefore()) {
        a(paramContext, paramString);
      }
      for (;;)
      {
        paramContext.getSharedPreferences("im_user_Info", 0).edit().putBoolean("imRegisterState", true).apply();
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", "ChatUtils -------- register----注册成功 并 开始登陆" + paramString);
        return;
        b(paramString, "home,link/", paramContext);
      }
      String str;
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", "ChatUtils ----网络异常，请检查网络");
    }
    catch (HyphenateException localHyphenateException)
    {
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(a, "Thread name = " + Thread.currentThread().getName() + " thread id = " + Thread.currentThread().getId() + " is main = " + paramContext.getMainLooper().isCurrentThread());
      str = localHyphenateException.getMessage();
      i = localHyphenateException.getErrorCode();
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", "ChatUtils -------- errorCode = " + i);
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", "ChatUtils -------- errorMsg = " + str);
      if (i != 2) {
        break label314;
      }
    }
    if (!EMClient.getInstance().isLoggedInBefore())
    {
      b(paramString, "home,link/", paramContext);
      label290:
      if (EMClient.getInstance().isLoggedInBefore()) {
        break label383;
      }
      b(paramString, "home,link/", paramContext);
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", "ChatUtils ----注册失败");
      return;
      label314:
      if (i == 203)
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", "ChatUtils ----用户已存在！" + paramString);
        break;
      }
      if (i == 202)
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", "ChatUtils ----注册失败，无权限！");
        break;
      }
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", "ChatUtils ----注册失败");
      break;
      a(paramContext, paramString);
      break label290;
      label383:
      a(paramContext, paramString);
    }
  }
  
  public static void logout4T(Context paramContext, EMCallBack paramEMCallBack)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", "ChatUtils TTTT----退出登录 开始---- ");
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(a, "Thread name = " + Thread.currentThread().getName() + " thread id = " + Thread.currentThread().getId() + " is main = " + paramContext.getMainLooper().isCurrentThread());
    a(paramContext, paramEMCallBack);
  }
  
  public static void register(Context paramContext)
  {
    boolean bool = ApplicationEx.c.isLoginState();
    Object localObject2 = ah.getDeviceId(paramContext);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = a();
    }
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin deviceId: ", (String)localObject1);
    if (!bool)
    {
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin deviceId: ", "deviceId登录 " + (String)localObject1);
      localObject2 = localObject1;
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(a, "Thread name = " + Thread.currentThread().getName() + " thread id = " + Thread.currentThread().getId() + " is main = " + paramContext.getMainLooper().isCurrentThread());
      ZrIntentService.imRegisterLogin(paramContext, (String)localObject2);
      return;
      UserInfo localUserInfo = ApplicationEx.c.getUser();
      localObject2 = localObject1;
      if (localUserInfo != null) {
        if (TextUtils.isEmpty(localUserInfo.getUid()))
        {
          com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin deviceId: ", "登录中 deviceId登录 " + (String)localObject1);
          localObject2 = localObject1;
        }
        else
        {
          localObject2 = j.appendEMPrefix(localUserInfo.getUid());
          com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin deviceId: ", "登录中 login_name_mobile登录 " + (String)localObject2);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */