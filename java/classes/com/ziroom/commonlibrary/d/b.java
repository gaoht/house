package com.ziroom.commonlibrary.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.freelxl.baselibrary.f.h;
import com.ziroom.commonlibrary.b.a;
import java.util.HashMap;
import java.util.Map;

public class b
{
  private static int a = 1;
  private static String b = "";
  private static String c = "";
  private static String d = "";
  
  private static String a(String paramString)
  {
    return h.toMd5(('c' + paramString + 'b').getBytes());
  }
  
  private static Map<String, String> a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = TextUtils.isEmpty(paramString2);
    boolean bool3 = TextUtils.isEmpty(paramString3);
    if ((bool1) && (bool2) && (bool3)) {
      throw new RuntimeException("手机号，邮箱，用户名需要存在一个！");
    }
    HashMap localHashMap = new HashMap();
    if (!bool1) {
      localHashMap.put("phone", paramString1);
    }
    do
    {
      return localHashMap;
      if (!bool2)
      {
        localHashMap.put("email", paramString2);
        return localHashMap;
      }
    } while (bool3);
    localHashMap.put("username", paramString3);
    return localHashMap;
  }
  
  public static Map<String, String> buildAccountStatus(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("phone不能为空！phone:" + paramString);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("phone", paramString);
    return localHashMap;
  }
  
  public static Map<String, String> buildBindingEmail(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      throw new IllegalArgumentException("email,vid均不能为空！email:" + paramString1 + ";vid:" + paramString3);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("email", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("password", a(paramString2));
    }
    localHashMap.put("vid", paramString3);
    return localHashMap;
  }
  
  public static Map<String, String> buildBindingEmailPut(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new IllegalArgumentException("newEmail,vidNew均不能为空！newEmail:" + paramString1 + ";newVid:" + paramString2);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("newEmail", paramString1);
    localHashMap.put("newVid", paramString2);
    return localHashMap;
  }
  
  public static Map<String, String> buildBindingPhone(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      throw new IllegalArgumentException("phone,vid均不能为空！phone:" + paramString1 + ";vid:" + paramString3);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("phone", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("password", a(paramString2));
    }
    localHashMap.put("vid", paramString3);
    return localHashMap;
  }
  
  public static Map<String, String> buildBindingPhonePut(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new IllegalArgumentException("newPhone,vidNew均不能为空！newPhone:" + paramString1 + ";newVid:" + paramString2);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("newPhone", paramString1);
    localHashMap.put("newVid", paramString2);
    return localHashMap;
  }
  
  public static Map<String, String> buildCommonHeader(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context不能为空");
    }
    if (TextUtils.isEmpty(b)) {
      b = h.getVersion(paramContext.getApplicationContext());
    }
    if (TextUtils.isEmpty(d)) {
      d = h.getDeviceId(paramContext.getApplicationContext());
    }
    if (TextUtils.isEmpty(c)) {
      c = Build.MANUFACTURER + "#" + Build.MODEL + "#" + d;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("Client-Version", b);
    localHashMap.put("Accept", "application/json");
    localHashMap.put("Sys", "app");
    localHashMap.put("Client-Type", a + "");
    localHashMap.put("User-Agent", c);
    localHashMap.put("Request-Id", com.ziroom.commonlibrary.g.b.buildRequestId());
    localHashMap.put("IMEI", d);
    localHashMap.put("longitude", a.getLongitude(paramContext) + "");
    localHashMap.put("latitude", a.getLatitude(paramContext) + "");
    return localHashMap;
  }
  
  public static Map<String, String> buildCommonHeaderWithToken(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("token不能为空");
    }
    paramContext = buildCommonHeader(paramContext);
    paramContext.put("token", paramString);
    return paramContext;
  }
  
  @Deprecated
  public static Map<String, String> buildLogin(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString4)) {
      throw new IllegalArgumentException("密码不能为空！");
    }
    paramString1 = a(paramString1, paramString2, paramString3);
    paramString1.put("password", a(paramString4));
    return paramString1;
  }
  
  public static Map<String, String> buildLoginDynamic(String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("phone", paramString1);
    localHashMap.put("vcode", paramString2);
    localHashMap.put("type", paramInt + "");
    return localHashMap;
  }
  
  public static Map<String, String> buildLoginDynamic(String paramString1, String paramString2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("phone", paramString1);
    localHashMap.put("vcode", paramString2);
    localHashMap.put("type", "5");
    if (paramBoolean) {
      localHashMap.put("needDefaultPassword", "1");
    }
    return localHashMap;
  }
  
  public static Map<String, String> buildLoginV2(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (TextUtils.isEmpty(paramString4)) {
      throw new IllegalArgumentException("密码不能为空！");
    }
    paramString1 = a(paramString1, paramString2, paramString3);
    paramString1.put("password", a(paramString4));
    if (!TextUtils.isEmpty(paramString5)) {
      paramString1.put("imgId", paramString5);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      paramString1.put("imgVValue", paramString6);
    }
    if (!TextUtils.isEmpty(paramString7)) {
      paramString1.put("imgVid", paramString7);
    }
    return paramString1;
  }
  
  public static Map<String, String> buildLogout(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("token不能为空！");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString);
    return localHashMap;
  }
  
  public static Map<String, String> buildModifyPassword(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new IllegalArgumentException("旧密码，新密码均不能为空！oldPassword:" + paramString1 + ";newPassword" + paramString2);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("oldPassword", a(paramString1));
    localHashMap.put("newPassword", a(paramString2));
    return localHashMap;
  }
  
  public static Map<String, String> buildModifyPasswordV2(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      throw new IllegalArgumentException("不存在此种账号类型！accountType:" + paramInt);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new IllegalArgumentException("vid，新密码均不能为空！vid:" + paramString1 + ";password" + paramString2);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("accountType", paramInt + "");
    localHashMap.put("vid", paramString1);
    localHashMap.put("password", a(paramString2));
    return localHashMap;
  }
  
  public static Map<String, String> buildPhoneBindVerifyCodeGetV3(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("手机号不能为空！");
    }
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("强制码不能为空！");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("phone", paramString1);
    localHashMap.put("forceCode", paramString2);
    return localHashMap;
  }
  
  public static Map<String, String> buildRegister(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString5))) {
      throw new IllegalArgumentException("密码或者vid不能为空！password:" + paramString4 + ";vid:" + paramString5);
    }
    paramString1 = a(paramString1, paramString2, paramString3);
    paramString1.put("password", a(paramString4));
    paramString1.put("vid", paramString5);
    paramString1.put("isLogin", "true");
    return paramString1;
  }
  
  public static Map<String, String> buildResetPassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString3))) {
      throw new IllegalArgumentException("密码或者vid不能为空！password:" + paramString4 + ";vid:" + paramString3);
    }
    paramString1 = a(paramString1, paramString2, null);
    paramString1.put("password", a(paramString4));
    paramString1.put("vid", paramString3);
    paramString1.put("isLogin", "true");
    return paramString1;
  }
  
  public static Map<String, String> buildThreeInfo(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new IllegalArgumentException("不存在此种第三方登录类型！type:" + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", paramInt + "");
    return localHashMap;
  }
  
  public static Map<String, String> buildThreeLogin(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new IllegalArgumentException("openId,accessToken均不能为空！openId:" + paramString1 + ";accessToken:" + paramString2);
    }
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new IllegalArgumentException("不存在此种第三方登录类型！type:" + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("openId", paramString1);
    localHashMap.put("accessToken", paramString2);
    localHashMap.put("type", paramInt + "");
    return localHashMap;
  }
  
  public static Map<String, String> buildUsersInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("token不能为空！");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString);
    return localHashMap;
  }
  
  public static Map<String, String> buildVerifyAccount(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3);
  }
  
  public static Map<String, String> buildVerifyCodeGet(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5)) {
      throw new IllegalArgumentException("不存在此种验证码类型！type:" + paramInt);
    }
    paramString1 = a(paramString1, paramString2, null);
    paramString1.put("type", paramInt + "");
    if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
    {
      paramString1.put("imgId", paramString3);
      paramString1.put("imgVValue", paramString4);
    }
    return paramString1;
  }
  
  public static Map<String, String> buildVerifyCodeGetV3(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 2) && (paramInt1 != 1) && (paramInt1 != 3)) {
      throw new IllegalArgumentException("不存在此种验证码类型！type:" + paramInt1);
    }
    if ((paramInt2 != 1) && (paramInt2 != 2)) {
      throw new IllegalArgumentException("不存在此种账号类型！accountType:" + paramInt2);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", paramInt1 + "");
    localHashMap.put("accountType", paramInt2 + "");
    return localHashMap;
  }
  
  public static Map<String, String> buildVerifyCodePost(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != 3)) {
      throw new IllegalArgumentException("不存在此种验证码类型！type:" + paramInt);
    }
    if (TextUtils.isEmpty(paramString3)) {
      throw new IllegalArgumentException("验证码不能为空！");
    }
    paramString1 = a(paramString1, paramString2, null);
    paramString1.put("type", paramInt + "");
    paramString1.put("vcode", paramString3);
    return paramString1;
  }
  
  public static Map<String, String> buildVerifyCodePostV2(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 != 2) && (paramInt1 != 1) && (paramInt1 != 3)) {
      throw new IllegalArgumentException("不存在此种验证码类型！type:" + paramInt1);
    }
    if ((paramInt2 != 1) && (paramInt2 != 2)) {
      throw new IllegalArgumentException("不存在此种账号类型！accountType:" + paramInt2);
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("验证码不能为空！");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", paramInt1 + "");
    localHashMap.put("accountType", paramInt2 + "");
    localHashMap.put("vcode", paramString);
    return localHashMap;
  }
  
  public static Map<String, String> buildVerifyImgCodeGet(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("图形验证码Id不能为空！");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("imgId", paramString);
    return localHashMap;
  }
  
  public static Map<String, String> buildVerifyImgCodePost(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new IllegalArgumentException("图形验证码Id和验证码值不能为空！");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("imgId", paramString1);
    localHashMap.put("imgVValue", paramString2);
    return localHashMap;
  }
  
  public static Map<String, String> setUsernamePass(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("username不能为空");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("username", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("password", a(paramString2));
    }
    return localHashMap;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/commonlibrary/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */