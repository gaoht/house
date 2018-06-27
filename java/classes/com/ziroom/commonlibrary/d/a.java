package com.ziroom.commonlibrary.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Handler;
import android.os.Looper;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.R.string;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.Callback;

public class a
{
  private static final Handler a = new Handler(Looper.getMainLooper());
  private static final Executor b = new a.1();
  
  private static boolean a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getState() == NetworkInfo.State.CONNECTED)) {
        return true;
      }
    }
    return false;
  }
  
  public static void accountStatus(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    paramString2 = b.buildCommonHeaderWithToken(paramContext, paramString2);
    paramString1 = b.buildAccountStatus(paramString1);
    com.freelxl.baselibrary.d.a.get(c.a + "/account/status/v1").tag(paramContext).headers(paramString2).params(paramString1).enqueue(paramCallback);
  }
  
  public static void auth(Context paramContext, String paramString, boolean paramBoolean, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    paramString = b.buildCommonHeaderWithToken(paramContext, paramString);
    com.freelxl.baselibrary.d.a.post(c.a + "/auth/v1").tag(paramContext).headers(paramString).enqueue(paramCallback);
  }
  
  private static void b(Context paramContext)
  {
    g.textToast(paramContext, paramContext.getString(R.string.login_msg_net_error));
  }
  
  public static void bindEmail(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    paramString4 = b.buildCommonHeaderWithToken(paramContext, paramString4);
    paramString1 = b.buildBindingEmail(paramString1, paramString2, paramString3);
    com.freelxl.baselibrary.d.a.post(c.a + "/users/email/v1").tag(paramContext).headers(paramString4).params(paramString1).enqueue(paramCallback);
  }
  
  public static void bindEmailPut(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    paramString3 = b.buildCommonHeaderWithToken(paramContext, paramString3);
    paramString1 = b.buildBindingEmailPut(paramString1, paramString2);
    com.freelxl.baselibrary.d.a.put(c.a + "/users/email/v2").tag(paramContext).headers(paramString3).params(paramString1).enqueue(paramCallback);
  }
  
  public static void bindPhone(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    paramString4 = b.buildCommonHeaderWithToken(paramContext, paramString4);
    paramString1 = b.buildBindingPhone(paramString1, paramString2, paramString3);
    com.freelxl.baselibrary.d.a.post(c.a + "/users/phone/v1").tag(paramContext).headers(paramString4).params(paramString1).enqueue(paramCallback);
  }
  
  public static void bindPhonePut(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    paramString3 = b.buildCommonHeaderWithToken(paramContext, paramString3);
    paramString1 = b.buildBindingPhonePut(paramString1, paramString2);
    com.freelxl.baselibrary.d.a.put(c.a + "/users/phone/v2").tag(paramContext).headers(paramString3).params(paramString1).enqueue(paramCallback);
  }
  
  @Deprecated
  public static void login(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    Map localMap = b.buildCommonHeader(paramContext);
    paramString1 = b.buildLogin(paramString1, paramString2, null, paramString3);
    com.freelxl.baselibrary.d.a.post(c.a + "/login/v1").tag(paramContext).headers(localMap).params(paramString1).enqueue(paramCallback);
  }
  
  public static void loginDynamic(Context paramContext, String paramString1, String paramString2, int paramInt, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    Map localMap = b.buildCommonHeader(paramContext);
    paramString1 = b.buildLoginDynamic(paramString1, paramString2, paramInt);
    com.freelxl.baselibrary.d.a.post(c.a + "/dynamic/login/v1").tag(paramContext).headers(localMap).params(paramString1).enqueue(paramCallback);
  }
  
  public static void loginDynamic(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    Map localMap = b.buildCommonHeader(paramContext);
    paramString1 = b.buildLoginDynamic(paramString1, paramString2, paramBoolean);
    com.freelxl.baselibrary.d.a.post(c.a + "/dynamic/login/v1").tag(paramContext).headers(localMap).params(paramString1).enqueue(paramCallback);
  }
  
  public static void loginV2(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Callback paramCallback)
  {
    com.freelxl.baselibrary.f.d.d("net", "=========checknet:" + a(paramContext));
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    Map localMap = b.buildCommonHeader(paramContext);
    paramString1 = b.buildLoginV2(paramString2, paramString3, paramString1, paramString4, paramString5, paramString6, paramString7);
    com.freelxl.baselibrary.d.a.post(c.a + "/login/v2").tag(paramContext).headers(localMap).params(paramString1).enqueue(paramCallback);
  }
  
  public static void logout(Context paramContext, String paramString, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    paramString = b.buildCommonHeaderWithToken(paramContext, paramString);
    com.freelxl.baselibrary.d.a.post(c.a + "/logout/v1").tag(paramContext).headers(paramString).enqueue(paramCallback);
  }
  
  public static void modifyPassword(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    paramString3 = b.buildCommonHeaderWithToken(paramContext, paramString3);
    paramString1 = b.buildModifyPassword(paramString1, paramString2);
    com.freelxl.baselibrary.d.a.put(c.a + "/users/password/v1").tag(paramContext).headers(paramString3).params(paramString1).enqueue(paramCallback);
  }
  
  public static void modifyPasswordV2(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    paramString3 = b.buildCommonHeaderWithToken(paramContext, paramString3);
    paramString1 = b.buildModifyPasswordV2(paramInt, paramString1, paramString2);
    com.freelxl.baselibrary.d.a.put(c.a + "/users/password/v2").tag(paramContext).headers(paramString3).params(paramString1).enqueue(paramCallback);
  }
  
  public static void phoneBindVerifyCodeGetV1(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    paramString3 = b.buildCommonHeaderWithToken(paramContext, paramString3);
    paramString1 = b.buildPhoneBindVerifyCodeGetV3(paramString1, paramString2);
    com.freelxl.baselibrary.d.a.get(c.a + "/phone/bind/verify/code/v1").tag(paramContext).headers(paramString3).params(paramString1).enqueue(paramCallback);
  }
  
  public static void register(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    Map localMap = b.buildCommonHeader(paramContext);
    paramString1 = b.buildRegister(paramString1, paramString2, null, paramString3, paramString4);
    com.freelxl.baselibrary.d.a.post(c.a + "/register/v1").tag(paramContext).headers(localMap).params(paramString1).enqueue(paramCallback);
  }
  
  public static void resetPassword(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    Map localMap = b.buildCommonHeader(paramContext);
    paramString1 = b.buildResetPassword(paramString1, paramString2, paramString3, paramString4);
    com.freelxl.baselibrary.d.a.post(c.a + "/reset/password/v1").tag(paramContext).headers(localMap).params(paramString1).enqueue(paramCallback);
  }
  
  public static void setUsernamePass(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    paramString3 = b.buildCommonHeaderWithToken(paramContext, paramString3);
    paramString1 = b.setUsernamePass(paramString1, paramString2);
    com.freelxl.baselibrary.d.a.post(c.a + "/users/username/v1").tag(paramContext).headers(paramString3).params(paramString1).enqueue(paramCallback);
  }
  
  public static void threeInfo(Context paramContext, int paramInt, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    Map localMap = b.buildThreeInfo(paramInt);
    com.freelxl.baselibrary.d.a.get(c.a + "/three/info/v1").tag(paramContext).params(localMap).enqueue(paramCallback);
  }
  
  public static void threeLogin(Context paramContext, String paramString1, String paramString2, int paramInt, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    Map localMap = b.buildCommonHeader(paramContext);
    paramString1 = b.buildThreeLogin(paramString1, paramString2, paramInt);
    com.freelxl.baselibrary.d.a.post(c.a + "/three/login/v1").tag(paramContext).headers(localMap).params(paramString1).enqueue(paramCallback);
  }
  
  public static void userInfo(Context paramContext, String paramString, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    paramString = b.buildCommonHeaderWithToken(paramContext, paramString);
    com.freelxl.baselibrary.d.a.get(c.a + "/users/info/v1").tag(paramContext).headers(paramString).enqueue(paramCallback);
  }
  
  public static void verifyAccount(Context paramContext, String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    Map localMap = b.buildCommonHeader(paramContext);
    paramString1 = b.buildVerifyAccount(paramString1, paramString2, paramString3);
    com.freelxl.baselibrary.d.a.post(c.a + "/verify/account/v1").tag(paramContext).headers(localMap).params(paramString1).enqueue(paramCallback);
  }
  
  @Deprecated
  public static void verifyCodeGet(Context paramContext, String paramString1, String paramString2, int paramInt, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    Map localMap = b.buildCommonHeader(paramContext);
    paramString1 = b.buildVerifyCodeGet(paramString1, paramString2, paramInt, null, null);
    com.freelxl.baselibrary.d.a.get(c.a + "/verify/code/v1").tag(paramContext).headers(localMap).params(paramString1).enqueue(paramCallback);
  }
  
  public static void verifyCodeGetV2(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    Map localMap = b.buildCommonHeader(paramContext);
    paramString1 = b.buildVerifyCodeGet(paramString1, paramString2, paramInt, paramString3, paramString4);
    com.freelxl.baselibrary.d.a.get(c.a + "/verify/code/v2").tag(paramContext).headers(localMap).params(paramString1).enqueue(paramCallback);
  }
  
  public static void verifyCodeGetV3(Context paramContext, int paramInt1, int paramInt2, String paramString, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    paramString = b.buildCommonHeaderWithToken(paramContext, paramString);
    Map localMap = b.buildVerifyCodeGetV3(paramInt1, paramInt2);
    com.freelxl.baselibrary.d.a.get(c.a + "/verify/code/v3").tag(paramContext).headers(paramString).params(localMap).enqueue(paramCallback);
  }
  
  public static void verifyCodePost(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    Map localMap = b.buildCommonHeader(paramContext);
    paramString1 = b.buildVerifyCodePost(paramString1, paramString2, paramInt, paramString3);
    com.freelxl.baselibrary.d.a.post(c.a + "/verify/code/v1").tag(paramContext).headers(localMap).params(paramString1).enqueue(paramCallback);
  }
  
  public static void verifyCodePostV2(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    paramString2 = b.buildCommonHeaderWithToken(paramContext, paramString2);
    paramString1 = b.buildVerifyCodePostV2(paramInt1, paramInt2, paramString1);
    com.freelxl.baselibrary.d.a.post(c.a + "/verify/code/v2").tag(paramContext).headers(paramString2).params(paramString1).enqueue(paramCallback);
  }
  
  public static void verifyImgCodeGet(Context paramContext, String paramString, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    Map localMap = b.buildCommonHeader(paramContext);
    paramString = b.buildVerifyImgCodeGet(paramString);
    com.freelxl.baselibrary.d.a.get(c.a + "/img/verify/code/v1").tag(paramContext).headers(localMap).params(paramString).enqueue(paramCallback);
  }
  
  public static void verifyImgCodePost(Context paramContext, String paramString1, String paramString2, Callback paramCallback)
  {
    if (!a(paramContext))
    {
      b(paramContext);
      return;
    }
    Map localMap = b.buildCommonHeader(paramContext);
    paramString1 = b.buildVerifyImgCodePost(paramString1, paramString2);
    com.freelxl.baselibrary.d.a.post(c.a + "/img/verify/code/v1").tag(paramContext).headers(localMap).params(paramString1).enqueue(paramCallback);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/commonlibrary/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */