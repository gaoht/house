package com.unionpay.tsmservice;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.unionpay.tsmservice.data.Amount;
import com.unionpay.tsmservice.request.AppDataUpdateRequestParams;
import com.unionpay.tsmservice.request.AppDeleteRequestParams;
import com.unionpay.tsmservice.request.AppDownloadApplyRequestParams;
import com.unionpay.tsmservice.request.AppDownloadRequestParams;
import com.unionpay.tsmservice.request.AppLockRequestParams;
import com.unionpay.tsmservice.request.AppUnlockRequestParams;
import com.unionpay.tsmservice.request.CheckSSamsungPayRequestParams;
import com.unionpay.tsmservice.request.CloseChannelRequestParams;
import com.unionpay.tsmservice.request.ECashTopUpRequestParams;
import com.unionpay.tsmservice.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.request.ExecuteCmdRequestParams;
import com.unionpay.tsmservice.request.GetAccountBalanceRequestParams;
import com.unionpay.tsmservice.request.GetAccountInfoRequestParams;
import com.unionpay.tsmservice.request.GetAppDetailRequestParams;
import com.unionpay.tsmservice.request.GetAppListRequestParams;
import com.unionpay.tsmservice.request.GetAppStatusRequestParams;
import com.unionpay.tsmservice.request.GetAssociatedAppRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoBySpayRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoRequestParams;
import com.unionpay.tsmservice.request.GetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.GetSMSAuthCodeRequestParams;
import com.unionpay.tsmservice.request.GetSeAppListRequestParams;
import com.unionpay.tsmservice.request.GetSeIdRequestParams;
import com.unionpay.tsmservice.request.GetTransElementsRequestParams;
import com.unionpay.tsmservice.request.GetTransRecordRequestParams;
import com.unionpay.tsmservice.request.HideAppApplyRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OpenChannelRequestParams;
import com.unionpay.tsmservice.request.RequestParams;
import com.unionpay.tsmservice.request.SendApduRequestParams;
import com.unionpay.tsmservice.request.SetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.SetSamsungDefWalletRequestParams;
import com.unionpay.tsmservice.result.AppDownloadApplyResult;
import com.unionpay.tsmservice.result.CheckSSamsungPayResult;
import com.unionpay.tsmservice.result.ECashTopUpResult;
import com.unionpay.tsmservice.result.EncryptDataResult;
import com.unionpay.tsmservice.result.GetAccountBalanceResult;
import com.unionpay.tsmservice.result.GetAccountInfoResult;
import com.unionpay.tsmservice.result.GetAppDetailResult;
import com.unionpay.tsmservice.result.GetAppListResult;
import com.unionpay.tsmservice.result.GetAssociatedAppResult;
import com.unionpay.tsmservice.result.GetCardInfoBySpayResult;
import com.unionpay.tsmservice.result.GetCardInfoResult;
import com.unionpay.tsmservice.result.GetDefaultCardResult;
import com.unionpay.tsmservice.result.GetSMSAuthCodeResult;
import com.unionpay.tsmservice.result.GetSeAppListResult;
import com.unionpay.tsmservice.result.GetSeIdResult;
import com.unionpay.tsmservice.result.GetTransElementsResult;
import com.unionpay.tsmservice.result.GetTransRecordResult;
import com.unionpay.tsmservice.result.InitResult;
import com.unionpay.tsmservice.result.OpenChannelResult;
import com.unionpay.tsmservice.result.SendApduResult;
import com.unionpay.tsmservice.utils.IUPJniInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UPTsmAddon
{
  private static UPTsmAddon a;
  private static ArrayList<UPTsmConnectionListener> b;
  private HashMap<String, ITsmCallback> A = new HashMap();
  private HashMap<String, ITsmCallback> B = new HashMap();
  private HashMap<String, ITsmCallback> C = new HashMap();
  private HashMap<String, ITsmCallback> D = new HashMap();
  private HashMap<String, ITsmCallback> E = new HashMap();
  private HashMap<String, ITsmCallback> F = new HashMap();
  private HashMap<String, ITsmCallback> G = new HashMap();
  private HashMap<String, ITsmCallback> H = new HashMap();
  private HashMap<String, ITsmCallback> I = new HashMap();
  private int[] J;
  private final Handler.Callback K = new UPTsmAddon.1(this);
  private final Handler L = new Handler(Looper.getMainLooper(), this.K);
  private Context c = null;
  private ServiceConnection d = null;
  private ITsmService e = null;
  private boolean f = false;
  private HashMap<String, ITsmCallback> g = new HashMap();
  private HashMap<String, ITsmCallback> h = new HashMap();
  private HashMap<String, ITsmCallback> i = new HashMap();
  private HashMap<String, ITsmCallback> j = new HashMap();
  private HashMap<String, ITsmCallback> k = new HashMap();
  private HashMap<String, ITsmCallback> l = new HashMap();
  private HashMap<String, ITsmCallback> m = new HashMap();
  private HashMap<String, ITsmCallback> n = new HashMap();
  private HashMap<String, ITsmCallback> o = new HashMap();
  private HashMap<String, ITsmCallback> p = new HashMap();
  private HashMap<String, ITsmCallback> q = new HashMap();
  private HashMap<String, ITsmCallback> r = new HashMap();
  private HashMap<String, ITsmCallback> s = new HashMap();
  private HashMap<String, ITsmCallback> t = new HashMap();
  private HashMap<String, ITsmCallback> u = new HashMap();
  private HashMap<String, ITsmCallback> v = new HashMap();
  private HashMap<String, ITsmCallback> w = new HashMap();
  private HashMap<String, ITsmCallback> x = new HashMap();
  private HashMap<String, ITsmCallback> y = new HashMap();
  private HashMap<String, ITsmCallback> z = new HashMap();
  
  static
  {
    try
    {
      System.loadLibrary("uptsmaddon");
      a = null;
      b = null;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  private UPTsmAddon(Context paramContext)
  {
    this.c = paramContext;
    this.J = new int[31];
    if (!a(paramContext)) {
      throw new RuntimeException();
    }
  }
  
  private static int a(int paramInt, RequestParams paramRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    return new SessionKeyReExchange(a, paramInt, paramRequestParams, paramITsmCallback).reExchangeKey();
  }
  
  private static int a(int paramInt, RequestParams paramRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback)
    throws RemoteException
  {
    return new SessionKeyReExchange(a, paramInt, paramRequestParams, paramITsmCallback, paramITsmProgressCallback).reExchangeKey();
  }
  
  private static HashMap<String, String> a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return new HashMap();
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (str1 != null)
      {
        String str2 = (String)paramHashMap.get(str1);
        if (str2 != null) {
          localHashMap.put(new String(str1), new String(str2));
        }
      }
    }
    return localHashMap;
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      boolean bool = IUPJniInterface.iJE(paramContext);
      return bool;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean b(String paramString)
  {
    try
    {
      boolean bool = IUPJniInterface.cSKV(paramString);
      return bool;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private static String c(String paramString)
  {
    try
    {
      paramString = IUPJniInterface.eMG(paramString);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private static String d(String paramString)
  {
    try
    {
      paramString = IUPJniInterface.dMG(paramString);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static UPTsmAddon getInstance(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    if (a == null) {
      a = new UPTsmAddon(paramContext.getApplicationContext());
    }
    if (b == null) {
      b = new ArrayList();
    }
    return a;
  }
  
  public void addConnectionListener(UPTsmConnectionListener paramUPTsmConnectionListener)
  {
    if (paramUPTsmConnectionListener != null) {
      b.add(paramUPTsmConnectionListener);
    }
  }
  
  public int appDataUpdate(AppDataUpdateRequestParams paramAppDataUpdateRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback)
    throws RemoteException
  {
    int i1;
    if ((paramAppDataUpdateRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label256;
        }
        if (b(this.c.getPackageName()))
        {
          AppDataUpdateRequestParams localAppDataUpdateRequestParams = new AppDataUpdateRequestParams();
          String str = paramAppDataUpdateRequestParams.getReserve();
          Object localObject = paramAppDataUpdateRequestParams.getAppID();
          if (!TextUtils.isEmpty(str)) {
            localAppDataUpdateRequestParams.setReserve(c(str));
          }
          if (localObject != null)
          {
            str = ((AppID)localObject).getAppAid();
            localObject = ((AppID)localObject).getAppVersion();
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
              localAppDataUpdateRequestParams.setAppID(new AppID(c(str), c((String)localObject)));
            }
          }
          int i2 = this.e.appDataUpdate(localAppDataUpdateRequestParams, new a(18, this.J[18], (byte)0), paramITsmProgressCallback);
          if (-2 == i2)
          {
            i1 = a(18, paramAppDataUpdateRequestParams, paramITsmCallback, paramITsmProgressCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramAppDataUpdateRequestParams = this.o;
          paramITsmProgressCallback = this.J;
          i1 = paramITsmProgressCallback[18];
          paramITsmProgressCallback[18] = (i1 + 1);
          paramAppDataUpdateRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(18, paramAppDataUpdateRequestParams, paramITsmCallback, paramITsmProgressCallback);
      continue;
      label256:
      i1 = -1;
    }
  }
  
  public int appDelete(AppDeleteRequestParams paramAppDeleteRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback)
    throws RemoteException
  {
    int i1;
    if ((paramAppDeleteRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      AppDeleteRequestParams localAppDeleteRequestParams;
      try
      {
        if (this.e == null) {
          break label769;
        }
        if (!b(this.c.getPackageName())) {
          break label756;
        }
        localAppDeleteRequestParams = new AppDeleteRequestParams();
        str1 = paramAppDeleteRequestParams.getReserve();
        localObject = paramAppDeleteRequestParams.getAppID();
        if (!TextUtils.isEmpty(str1)) {
          localAppDeleteRequestParams.setReserve(c(str1));
        }
        if (localObject != null)
        {
          str1 = ((AppID)localObject).getAppAid();
          localObject = ((AppID)localObject).getAppVersion();
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            localAppDeleteRequestParams.setAppID(new AppID(c(str1), c((String)localObject)));
          }
        }
        localObject = (HashMap)paramAppDeleteRequestParams.getParams();
        if (localObject == null)
        {
          i2 = this.e.appDelete(localAppDeleteRequestParams, new a(17, this.J[17], (byte)0), paramITsmProgressCallback);
          if (-2 == i2)
          {
            i1 = a(17, paramAppDeleteRequestParams, paramITsmCallback, paramITsmProgressCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramAppDeleteRequestParams = this.B;
          paramITsmProgressCallback = this.J;
          i1 = paramITsmProgressCallback[17];
          paramITsmProgressCallback[17] = (i1 + 1);
          paramAppDeleteRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      Object localObject = a((HashMap)localObject);
      String str1 = (String)((HashMap)localObject).get("cardHolderName");
      String str2 = (String)((HashMap)localObject).get("idType");
      String str3 = (String)((HashMap)localObject).get("idNo");
      String str4 = (String)((HashMap)localObject).get("pan");
      String str5 = (String)((HashMap)localObject).get("pin");
      String str6 = (String)((HashMap)localObject).get("expiryDate");
      String str7 = (String)((HashMap)localObject).get("cvn2");
      String str8 = (String)((HashMap)localObject).get("msisdn");
      String str9 = (String)((HashMap)localObject).get("smsAuthCode");
      String str10 = (String)((HashMap)localObject).get("ecashBalance");
      String str11 = (String)((HashMap)localObject).get("cardType");
      if (!TextUtils.isEmpty(str1)) {
        ((HashMap)localObject).put("cardHolderName", c(str1));
      }
      if (!TextUtils.isEmpty(str2)) {
        ((HashMap)localObject).put("idType", c(str2));
      }
      if (!TextUtils.isEmpty(str3)) {
        ((HashMap)localObject).put("idNo", c(str3));
      }
      if (!TextUtils.isEmpty(str4)) {
        ((HashMap)localObject).put("pan", c(str4));
      }
      if (!TextUtils.isEmpty(str5)) {
        ((HashMap)localObject).put("pin", str5);
      }
      if (!TextUtils.isEmpty(str6)) {
        ((HashMap)localObject).put("expiryDate", c(str6));
      }
      if (!TextUtils.isEmpty(str7)) {
        ((HashMap)localObject).put("cvn2", c(str7));
      }
      if (!TextUtils.isEmpty(str8)) {
        ((HashMap)localObject).put("msisdn", c(str8));
      }
      if (!TextUtils.isEmpty(str9)) {
        ((HashMap)localObject).put("smsAuthCode", c(str9));
      }
      if (!TextUtils.isEmpty(str10)) {
        ((HashMap)localObject).put("ecashBalance", c(str10));
      }
      if (!TextUtils.isEmpty(str11)) {
        ((HashMap)localObject).put("cardType", c(str11));
      }
      localAppDeleteRequestParams.setParams((HashMap)localObject);
      int i2 = this.e.appDelete(localAppDeleteRequestParams, new a(17, this.J[17], (byte)0), paramITsmProgressCallback);
      if (-2 == i2)
      {
        i1 = a(17, paramAppDeleteRequestParams, paramITsmCallback, paramITsmProgressCallback);
      }
      else
      {
        i1 = i2;
        if (i2 == 0)
        {
          paramAppDeleteRequestParams = this.B;
          paramITsmProgressCallback = this.J;
          i1 = paramITsmProgressCallback[17];
          paramITsmProgressCallback[17] = (i1 + 1);
          paramAppDeleteRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
          label756:
          i1 = a(17, paramAppDeleteRequestParams, paramITsmCallback, paramITsmProgressCallback);
          continue;
          label769:
          i1 = -1;
        }
      }
    }
  }
  
  public int appDownload(AppDownloadRequestParams paramAppDownloadRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback)
    throws RemoteException
  {
    int i1;
    if ((paramAppDownloadRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label280;
        }
        if (b(this.c.getPackageName()))
        {
          AppDownloadRequestParams localAppDownloadRequestParams = new AppDownloadRequestParams();
          String str2 = paramAppDownloadRequestParams.getReserve();
          Object localObject = paramAppDownloadRequestParams.getAppID();
          String str1 = paramAppDownloadRequestParams.getAppName();
          if (!TextUtils.isEmpty(str2)) {
            localAppDownloadRequestParams.setReserve(c(str2));
          }
          if (localObject != null)
          {
            str2 = ((AppID)localObject).getAppAid();
            localObject = ((AppID)localObject).getAppVersion();
            if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
              localAppDownloadRequestParams.setAppID(new AppID(c(str2), c((String)localObject)));
            }
          }
          if (!TextUtils.isEmpty(str1)) {
            localAppDownloadRequestParams.setAppName(c(str1));
          }
          int i2 = this.e.appDownload(localAppDownloadRequestParams, new a(16, this.J[16], (byte)0), paramITsmProgressCallback);
          if (-2 == i2)
          {
            i1 = a(16, paramAppDownloadRequestParams, paramITsmCallback, paramITsmProgressCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramAppDownloadRequestParams = this.A;
          paramITsmProgressCallback = this.J;
          i1 = paramITsmProgressCallback[16];
          paramITsmProgressCallback[16] = (i1 + 1);
          paramAppDownloadRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(16, paramAppDownloadRequestParams, paramITsmCallback, paramITsmProgressCallback);
      continue;
      label280:
      i1 = -1;
    }
  }
  
  public int appDownloadApply(AppDownloadApplyRequestParams paramAppDownloadApplyRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if ((paramAppDownloadApplyRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      Object localObject1;
      try
      {
        if (this.e == null) {
          break label790;
        }
        if (!b(this.c.getPackageName())) {
          break label779;
        }
        localObject1 = new AppDownloadApplyRequestParams();
        str1 = paramAppDownloadApplyRequestParams.getReserve();
        localObject2 = paramAppDownloadApplyRequestParams.getAppID();
        if (!TextUtils.isEmpty(str1)) {
          ((AppDownloadApplyRequestParams)localObject1).setReserve(c(str1));
        }
        if (localObject2 != null)
        {
          str1 = ((AppID)localObject2).getAppAid();
          localObject2 = ((AppID)localObject2).getAppVersion();
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
            ((AppDownloadApplyRequestParams)localObject1).setAppID(new AppID(c(str1), c((String)localObject2)));
          }
        }
        localObject2 = (HashMap)paramAppDownloadApplyRequestParams.getParams();
        if (localObject2 == null)
        {
          i2 = this.e.appDownloadApply((AppDownloadApplyRequestParams)localObject1, new a(15, this.J[15], (byte)0));
          if (-2 == i2)
          {
            i1 = a(15, paramAppDownloadApplyRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramAppDownloadApplyRequestParams = this.n;
          localObject1 = this.J;
          i1 = localObject1[15];
          localObject1[15] = (i1 + 1);
          paramAppDownloadApplyRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      Object localObject2 = a((HashMap)localObject2);
      String str1 = (String)((HashMap)localObject2).get("accountLimit");
      String str2 = (String)((HashMap)localObject2).get("accountType");
      String str3 = (String)((HashMap)localObject2).get("cardHolderName");
      String str4 = (String)((HashMap)localObject2).get("idType");
      String str5 = (String)((HashMap)localObject2).get("idNo");
      String str6 = (String)((HashMap)localObject2).get("pan");
      String str7 = (String)((HashMap)localObject2).get("pin");
      String str8 = (String)((HashMap)localObject2).get("expiryDate");
      String str9 = (String)((HashMap)localObject2).get("cvn2");
      String str10 = (String)((HashMap)localObject2).get("msisdn");
      String str11 = (String)((HashMap)localObject2).get("smsAuthCode");
      String str12 = (String)((HashMap)localObject2).get("cardType");
      if (!TextUtils.isEmpty(str1)) {
        ((HashMap)localObject2).put("accountLimit", c(str1));
      }
      if (!TextUtils.isEmpty(str2)) {
        ((HashMap)localObject2).put("accountType", c(str2));
      }
      if (!TextUtils.isEmpty(str3)) {
        ((HashMap)localObject2).put("cardHolderName", c(str3));
      }
      if (!TextUtils.isEmpty(str4)) {
        ((HashMap)localObject2).put("idType", c(str4));
      }
      if (!TextUtils.isEmpty(str5)) {
        ((HashMap)localObject2).put("idNo", c(str5));
      }
      if (!TextUtils.isEmpty(str6)) {
        ((HashMap)localObject2).put("pan", c(str6));
      }
      if (!TextUtils.isEmpty(str7)) {
        ((HashMap)localObject2).put("pin", str7);
      }
      if (!TextUtils.isEmpty(str8)) {
        ((HashMap)localObject2).put("expiryDate", c(str8));
      }
      if (!TextUtils.isEmpty(str9)) {
        ((HashMap)localObject2).put("cvn2", c(str9));
      }
      if (!TextUtils.isEmpty(str10)) {
        ((HashMap)localObject2).put("msisdn", c(str10));
      }
      if (!TextUtils.isEmpty(str11)) {
        ((HashMap)localObject2).put("smsAuthCode", c(str11));
      }
      if (!TextUtils.isEmpty(str12)) {
        ((HashMap)localObject2).put("cardType", c(str12));
      }
      ((AppDownloadApplyRequestParams)localObject1).setParams((HashMap)localObject2);
      int i2 = this.e.appDownloadApply((AppDownloadApplyRequestParams)localObject1, new a(15, this.J[15], (byte)0));
      if (-2 == i2)
      {
        i1 = a(15, paramAppDownloadApplyRequestParams, paramITsmCallback);
      }
      else
      {
        i1 = i2;
        if (i2 == 0)
        {
          paramAppDownloadApplyRequestParams = this.n;
          localObject1 = this.J;
          i1 = localObject1[15];
          localObject1[15] = (i1 + 1);
          paramAppDownloadApplyRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
          label779:
          i1 = a(15, paramAppDownloadApplyRequestParams, paramITsmCallback);
          continue;
          label790:
          i1 = -1;
        }
      }
    }
  }
  
  public int appLock(AppLockRequestParams paramAppLockRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if ((paramAppLockRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e != null)
        {
          if (b(this.c.getPackageName()))
          {
            AppLockRequestParams localAppLockRequestParams = new AppLockRequestParams();
            String str = paramAppLockRequestParams.getReserve();
            Object localObject = paramAppLockRequestParams.getAppID();
            if (!TextUtils.isEmpty(str)) {
              localAppLockRequestParams.setReserve(c(str));
            }
            if (localObject != null)
            {
              str = ((AppID)localObject).getAppAid();
              localObject = ((AppID)localObject).getAppVersion();
              if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
                localAppLockRequestParams.setAppID(new AppID(c(str), c((String)localObject)));
              }
            }
            int i2 = this.e.appLock(localAppLockRequestParams, paramITsmCallback);
            i1 = i2;
            if (-2 != i2) {
              continue;
            }
            i1 = a(26, paramAppLockRequestParams, paramITsmCallback);
            continue;
          }
          i1 = a(26, paramAppLockRequestParams, paramITsmCallback);
          continue;
        }
        i1 = -1;
      }
      finally {}
    }
  }
  
  public int appUnlock(AppUnlockRequestParams paramAppUnlockRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if ((paramAppUnlockRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e != null)
        {
          if (b(this.c.getPackageName()))
          {
            AppUnlockRequestParams localAppUnlockRequestParams = new AppUnlockRequestParams();
            String str = paramAppUnlockRequestParams.getReserve();
            Object localObject = paramAppUnlockRequestParams.getAppID();
            if (!TextUtils.isEmpty(str)) {
              localAppUnlockRequestParams.setReserve(c(str));
            }
            if (localObject != null)
            {
              str = ((AppID)localObject).getAppAid();
              localObject = ((AppID)localObject).getAppVersion();
              if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
                localAppUnlockRequestParams.setAppID(new AppID(c(str), c((String)localObject)));
              }
            }
            int i2 = this.e.appUnlock(localAppUnlockRequestParams, paramITsmCallback);
            i1 = i2;
            if (-2 != i2) {
              continue;
            }
            i1 = a(27, paramAppUnlockRequestParams, paramITsmCallback);
            continue;
          }
          i1 = a(27, paramAppUnlockRequestParams, paramITsmCallback);
          continue;
        }
        i1 = -1;
      }
      finally {}
    }
  }
  
  public void bind()
  {
    if (this.d == null) {
      this.d = new UPTsmAddon.2(this);
    }
    if (!this.f)
    {
      Intent localIntent = new Intent("com.unionpay.tsmservice.UPTsmService");
      localIntent.setPackage("com.unionpay.tsmservice");
      this.c.bindService(localIntent, this.d, 1);
    }
  }
  
  public int checkSSamsungPay(CheckSSamsungPayRequestParams paramCheckSSamsungPayRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if ((paramCheckSSamsungPayRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label188;
        }
        if (b(this.c.getPackageName()))
        {
          Object localObject = new CheckSSamsungPayRequestParams();
          if (paramCheckSSamsungPayRequestParams != null)
          {
            String str = paramCheckSSamsungPayRequestParams.getReserve();
            if (!TextUtils.isEmpty(str)) {
              ((CheckSSamsungPayRequestParams)localObject).setReserve(c(str));
            }
          }
          int i2 = this.e.checkSSamsungPay((CheckSSamsungPayRequestParams)localObject, new a(29, this.J[29], (byte)0));
          if (-2 == i2)
          {
            i1 = a(29, paramCheckSSamsungPayRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramCheckSSamsungPayRequestParams = this.H;
          localObject = this.J;
          i1 = localObject[29];
          localObject[29] = (i1 + 1);
          paramCheckSSamsungPayRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(29, paramCheckSSamsungPayRequestParams, paramITsmCallback);
      continue;
      label188:
      i1 = -1;
    }
  }
  
  public int closeChannel(CloseChannelRequestParams paramCloseChannelRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i2 = -3;
    int i1 = i2;
    if (paramCloseChannelRequestParams != null)
    {
      if (paramITsmCallback != null) {
        break label24;
      }
      i1 = i2;
    }
    for (;;)
    {
      return i1;
      try
      {
        label24:
        Object localObject = paramCloseChannelRequestParams.getChannel();
        i1 = i2;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        if (this.e == null) {
          break label222;
        }
        if (b(this.c.getPackageName()))
        {
          String str = c((String)localObject);
          localObject = new CloseChannelRequestParams();
          ((CloseChannelRequestParams)localObject).setChannel(str);
          str = paramCloseChannelRequestParams.getReserve();
          if (!TextUtils.isEmpty(str)) {
            ((CloseChannelRequestParams)localObject).setReserve(c(str));
          }
          i2 = this.e.closeChannel((CloseChannelRequestParams)localObject, new a(21, this.J[21], (byte)0));
          if (-2 == i2)
          {
            i1 = a(21, paramCloseChannelRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramCloseChannelRequestParams = this.D;
          localObject = this.J;
          i1 = localObject[21];
          localObject[21] = (i1 + 1);
          paramCloseChannelRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(21, paramCloseChannelRequestParams, paramITsmCallback);
      continue;
      label222:
      i1 = -1;
    }
  }
  
  public int eCashTopUp(ECashTopUpRequestParams paramECashTopUpRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if ((paramECashTopUpRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label316;
        }
        if (b(this.c.getPackageName()))
        {
          Object localObject1 = new ECashTopUpRequestParams();
          String str3 = paramECashTopUpRequestParams.getReserve();
          Object localObject2 = paramECashTopUpRequestParams.getAppID();
          String str1 = paramECashTopUpRequestParams.getType();
          String str2 = paramECashTopUpRequestParams.getAmount();
          if (!TextUtils.isEmpty(str3)) {
            ((ECashTopUpRequestParams)localObject1).setReserve(c(str3));
          }
          if (localObject2 != null)
          {
            str3 = ((AppID)localObject2).getAppAid();
            localObject2 = ((AppID)localObject2).getAppVersion();
            if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
              ((ECashTopUpRequestParams)localObject1).setAppID(new AppID(c(str3), c((String)localObject2)));
            }
          }
          localObject2 = paramECashTopUpRequestParams.getEncrpytPin();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((ECashTopUpRequestParams)localObject1).setEncrpytPin((String)localObject2);
          }
          if (!TextUtils.isEmpty(str1)) {
            ((ECashTopUpRequestParams)localObject1).setType(c(str1));
          }
          if (!TextUtils.isEmpty(str2)) {
            ((ECashTopUpRequestParams)localObject1).setAmount(c(str2));
          }
          int i2 = this.e.eCashTopUp((ECashTopUpRequestParams)localObject1, new a(19, this.J[19], (byte)0));
          if (-2 == i2)
          {
            i1 = a(19, paramECashTopUpRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramECashTopUpRequestParams = this.q;
          localObject1 = this.J;
          i1 = localObject1[19];
          localObject1[19] = (i1 + 1);
          paramECashTopUpRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(19, paramECashTopUpRequestParams, paramITsmCallback);
      continue;
      label316:
      i1 = -1;
    }
  }
  
  public int encryptData(EncryptDataRequestParams paramEncryptDataRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1 = 0;
    if ((paramEncryptDataRequestParams == null) || (paramITsmCallback == null))
    {
      i1 = -3;
      return i1;
    }
    for (;;)
    {
      try
      {
        if (this.e == null) {
          break label273;
        }
        if (b(this.c.getPackageName()))
        {
          Object localObject1 = new EncryptDataRequestParams();
          Object localObject2 = paramEncryptDataRequestParams.getReserve();
          ArrayList localArrayList = (ArrayList)paramEncryptDataRequestParams.getData();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((EncryptDataRequestParams)localObject1).setReserve(c((String)localObject2));
          }
          if (localArrayList != null)
          {
            i2 = localArrayList.size();
            if (i2 == 0)
            {
              i1 = -3;
              break;
            }
            localObject2 = new ArrayList();
            if (i1 < i2)
            {
              String str = (String)localArrayList.get(i1);
              if (TextUtils.isEmpty(str)) {
                break label278;
              }
              ((ArrayList)localObject2).add(c(str));
              break label278;
            }
            ((EncryptDataRequestParams)localObject1).setData((List)localObject2);
          }
          int i2 = this.e.encryptData((EncryptDataRequestParams)localObject1, new a(23, this.J[23], (byte)0));
          if (-2 == i2)
          {
            i1 = a(23, paramEncryptDataRequestParams, paramITsmCallback);
            break;
          }
          i1 = i2;
          if (i2 != 0) {
            break;
          }
          paramEncryptDataRequestParams = this.z;
          localObject1 = this.J;
          i1 = localObject1[23];
          localObject1[23] = (i1 + 1);
          paramEncryptDataRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          break;
        }
      }
      finally {}
      i1 = a(23, paramEncryptDataRequestParams, paramITsmCallback);
      break;
      label273:
      i1 = -1;
      break;
      label278:
      i1 += 1;
    }
  }
  
  public int exchangeKey(String paramString, String[] paramArrayOfString)
    throws RemoteException
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return -3;
    }
    if (this.e != null) {
      return this.e.exchangeKey(paramString, paramArrayOfString);
    }
    return -1;
  }
  
  public int executeCmd(ExecuteCmdRequestParams paramExecuteCmdRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback)
    throws RemoteException
  {
    int i1;
    if ((paramExecuteCmdRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label241;
        }
        if (b(this.c.getPackageName()))
        {
          ExecuteCmdRequestParams localExecuteCmdRequestParams = new ExecuteCmdRequestParams();
          String str1 = paramExecuteCmdRequestParams.getReserve();
          String str2 = paramExecuteCmdRequestParams.getSsid();
          String str3 = paramExecuteCmdRequestParams.getSign();
          if (!TextUtils.isEmpty(str1)) {
            localExecuteCmdRequestParams.setReserve(c(str1));
          }
          if (!TextUtils.isEmpty(str2)) {
            localExecuteCmdRequestParams.setSsid(c(str2));
          }
          if (!TextUtils.isEmpty(str3)) {
            localExecuteCmdRequestParams.setSign(c(str3));
          }
          int i2 = this.e.executeCmd(localExecuteCmdRequestParams, new a(25, this.J[25], (byte)0), paramITsmProgressCallback);
          if (-2 == i2)
          {
            i1 = a(25, paramExecuteCmdRequestParams, paramITsmCallback, paramITsmProgressCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramExecuteCmdRequestParams = this.F;
          paramITsmProgressCallback = this.J;
          i1 = paramITsmProgressCallback[25];
          paramITsmProgressCallback[25] = (i1 + 1);
          paramExecuteCmdRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(25, paramExecuteCmdRequestParams, paramITsmCallback, paramITsmProgressCallback);
      continue;
      label241:
      i1 = -1;
    }
  }
  
  public int getAccountBalance(GetAccountBalanceRequestParams paramGetAccountBalanceRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if ((paramGetAccountBalanceRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label268;
        }
        if (b(this.c.getPackageName()))
        {
          Object localObject1 = new GetAccountBalanceRequestParams();
          String str = paramGetAccountBalanceRequestParams.getReserve();
          Object localObject2 = paramGetAccountBalanceRequestParams.getAppID();
          if (!TextUtils.isEmpty(str)) {
            ((GetAccountBalanceRequestParams)localObject1).setReserve(c(str));
          }
          if (localObject2 != null)
          {
            str = ((AppID)localObject2).getAppAid();
            localObject2 = ((AppID)localObject2).getAppVersion();
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
              ((GetAccountBalanceRequestParams)localObject1).setAppID(new AppID(c(str), c((String)localObject2)));
            }
          }
          localObject2 = paramGetAccountBalanceRequestParams.getEncryptPin();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((GetAccountBalanceRequestParams)localObject1).setEncryptPin((String)localObject2);
          }
          int i2 = this.e.getAccountBalance((GetAccountBalanceRequestParams)localObject1, new a(8, this.J[8], (byte)0));
          if (-2 == i2)
          {
            i1 = a(8, paramGetAccountBalanceRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramGetAccountBalanceRequestParams = this.t;
          localObject1 = this.J;
          i1 = localObject1[8];
          localObject1[8] = (i1 + 1);
          paramGetAccountBalanceRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(8, paramGetAccountBalanceRequestParams, paramITsmCallback);
      continue;
      label268:
      i1 = -1;
    }
  }
  
  public int getAccountInfo(GetAccountInfoRequestParams paramGetAccountInfoRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if ((paramGetAccountInfoRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label247;
        }
        if (b(this.c.getPackageName()))
        {
          Object localObject1 = new GetAccountInfoRequestParams();
          String str = paramGetAccountInfoRequestParams.getReserve();
          Object localObject2 = paramGetAccountInfoRequestParams.getAppID();
          if (!TextUtils.isEmpty(str)) {
            ((GetAccountInfoRequestParams)localObject1).setReserve(c(str));
          }
          if (localObject2 != null)
          {
            str = ((AppID)localObject2).getAppAid();
            localObject2 = ((AppID)localObject2).getAppVersion();
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
              ((GetAccountInfoRequestParams)localObject1).setAppID(new AppID(c(str), c((String)localObject2)));
            }
          }
          int i2 = this.e.getAccountInfo((GetAccountInfoRequestParams)localObject1, new a(7, this.J[7], (byte)0));
          if (-2 == i2)
          {
            i1 = a(7, paramGetAccountInfoRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramGetAccountInfoRequestParams = this.s;
          localObject1 = this.J;
          i1 = localObject1[7];
          localObject1[7] = (i1 + 1);
          paramGetAccountInfoRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(7, paramGetAccountInfoRequestParams, paramITsmCallback);
      continue;
      label247:
      i1 = -1;
    }
  }
  
  public int getAppDetail(GetAppDetailRequestParams paramGetAppDetailRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if ((paramGetAppDetailRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label265;
        }
        if (b(this.c.getPackageName()))
        {
          Object localObject1 = new GetAppDetailRequestParams();
          String str2 = paramGetAppDetailRequestParams.getReserve();
          Object localObject2 = paramGetAppDetailRequestParams.getAppID();
          String str1 = paramGetAppDetailRequestParams.getTransType();
          if (!TextUtils.isEmpty(str2)) {
            ((GetAppDetailRequestParams)localObject1).setReserve(c(str2));
          }
          if (localObject2 != null)
          {
            str2 = ((AppID)localObject2).getAppAid();
            localObject2 = ((AppID)localObject2).getAppVersion();
            if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
              ((GetAppDetailRequestParams)localObject1).setAppID(new AppID(c(str2), c((String)localObject2)));
            }
          }
          if (!TextUtils.isEmpty(str1)) {
            ((GetAppDetailRequestParams)localObject1).setTransType(c(str1));
          }
          int i2 = this.e.getAppDetail((GetAppDetailRequestParams)localObject1, new a(4, this.J[4], (byte)0));
          if (-2 == i2)
          {
            i1 = a(4, paramGetAppDetailRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramGetAppDetailRequestParams = this.l;
          localObject1 = this.J;
          i1 = localObject1[4];
          localObject1[4] = (i1 + 1);
          paramGetAppDetailRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(4, paramGetAppDetailRequestParams, paramITsmCallback);
      continue;
      label265:
      i1 = -1;
    }
  }
  
  public int getAppList(GetAppListRequestParams paramGetAppListRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1 = 0;
    if ((paramGetAppListRequestParams == null) || (paramITsmCallback == null))
    {
      i1 = -3;
      return i1;
    }
    for (;;)
    {
      try
      {
        if (this.e == null) {
          break label264;
        }
        if (b(this.c.getPackageName()))
        {
          Object localObject1 = new GetAppListRequestParams();
          Object localObject2 = paramGetAppListRequestParams.getReserve();
          String str = paramGetAppListRequestParams.getKeyword();
          String[] arrayOfString = paramGetAppListRequestParams.getStatus();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((GetAppListRequestParams)localObject1).setReserve(c((String)localObject2));
          }
          if (!TextUtils.isEmpty(str)) {
            ((GetAppListRequestParams)localObject1).setKeyword(c(str));
          }
          if (arrayOfString != null)
          {
            i2 = arrayOfString.length;
            localObject2 = new String[i2];
            if (i1 < i2)
            {
              if (TextUtils.isEmpty(arrayOfString[i1])) {
                break label269;
              }
              localObject2[i1] = c(arrayOfString[i1]);
              break label269;
            }
            ((GetAppListRequestParams)localObject1).setStatus((String[])localObject2);
          }
          int i2 = this.e.getAppList((GetAppListRequestParams)localObject1, new a(2, this.J[2], (byte)0));
          if (-2 == i2)
          {
            i1 = a(2, paramGetAppListRequestParams, paramITsmCallback);
            break;
          }
          i1 = i2;
          if (i2 != 0) {
            break;
          }
          paramGetAppListRequestParams = this.j;
          localObject1 = this.J;
          i1 = localObject1[2];
          localObject1[2] = (i1 + 1);
          paramGetAppListRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          break;
        }
      }
      finally {}
      i1 = a(2, paramGetAppListRequestParams, paramITsmCallback);
      break;
      label264:
      i1 = -1;
      break;
      label269:
      i1 += 1;
    }
  }
  
  public int getAppStatus(GetAppStatusRequestParams paramGetAppStatusRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if ((paramGetAppStatusRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label241;
        }
        if (b(this.c.getPackageName()))
        {
          Object localObject1 = new GetAppStatusRequestParams();
          String str = paramGetAppStatusRequestParams.getReserve();
          Object localObject2 = paramGetAppStatusRequestParams.getAppID();
          if (!TextUtils.isEmpty(str)) {
            ((GetAppStatusRequestParams)localObject1).setReserve(c(str));
          }
          if (localObject2 != null)
          {
            str = ((AppID)localObject2).getAppAid();
            localObject2 = ((AppID)localObject2).getAppVersion();
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
              ((GetAppStatusRequestParams)localObject1).setAppID(new AppID(c(str), c((String)localObject2)));
            }
          }
          int i2 = this.e.getAppStatus((GetAppStatusRequestParams)localObject1, new a(5, this.J[5], (byte)0));
          if (-2 == i2)
          {
            i1 = a(5, paramGetAppStatusRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramGetAppStatusRequestParams = this.k;
          localObject1 = this.J;
          i1 = localObject1[5];
          localObject1[5] = (i1 + 1);
          paramGetAppStatusRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(5, paramGetAppStatusRequestParams, paramITsmCallback);
      continue;
      label241:
      i1 = -1;
    }
  }
  
  public int getAssociatedApp(GetAssociatedAppRequestParams paramGetAssociatedAppRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i2 = -3;
    int i1 = i2;
    if (paramGetAssociatedAppRequestParams != null)
    {
      if (paramITsmCallback != null) {
        break label24;
      }
      i1 = i2;
    }
    for (;;)
    {
      return i1;
      try
      {
        label24:
        Object localObject = paramGetAssociatedAppRequestParams.getEncryptPan();
        i1 = i2;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        if (this.e == null) {
          break label212;
        }
        if (b(this.c.getPackageName()))
        {
          GetAssociatedAppRequestParams localGetAssociatedAppRequestParams = new GetAssociatedAppRequestParams();
          String str = paramGetAssociatedAppRequestParams.getReserve();
          if (!TextUtils.isEmpty(str)) {
            localGetAssociatedAppRequestParams.setReserve(c(str));
          }
          localGetAssociatedAppRequestParams.setEncryptPan(c((String)localObject));
          i2 = this.e.getAssociatedApp(localGetAssociatedAppRequestParams, new a(1, this.J[1], (byte)0));
          if (-2 == i2)
          {
            i1 = a(1, paramGetAssociatedAppRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramGetAssociatedAppRequestParams = this.h;
          localObject = this.J;
          i1 = localObject[1];
          localObject[1] = (i1 + 1);
          paramGetAssociatedAppRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(1, paramGetAssociatedAppRequestParams, paramITsmCallback);
      continue;
      label212:
      i1 = -1;
    }
  }
  
  public int getCardInfo(GetCardInfoRequestParams paramGetCardInfoRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i3 = -3;
    int i1 = i3;
    if (paramGetCardInfoRequestParams != null)
    {
      if (paramITsmCallback != null) {
        break label24;
      }
      i1 = i3;
    }
    label24:
    Object localObject2;
    int i4;
    int i2;
    label57:
    do
    {
      for (;;)
      {
        return i1;
        try
        {
          localObject2 = paramGetCardInfoRequestParams.getAppAID();
          i4 = localObject2.length;
          i1 = i3;
          if (localObject2 != null)
          {
            i1 = i3;
            if (i4 != 0) {
              i2 = 0;
            }
          }
        }
        finally {}
      }
      i1 = i3;
    } while (i2 == i4);
    Object localObject1;
    if (this.e != null) {
      if (b(this.c.getPackageName()))
      {
        localObject1 = new String[i4];
        i1 = 0;
        break label296;
        localObject1[i1] = c(localObject2[i1]);
        break label317;
      }
    }
    label296:
    label317:
    label322:
    for (;;)
    {
      localObject2 = new GetCardInfoRequestParams();
      ((GetCardInfoRequestParams)localObject2).setAppAID((String[])localObject1);
      localObject1 = paramGetCardInfoRequestParams.getReserve();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((GetCardInfoRequestParams)localObject2).setReserve(c((String)localObject1));
      }
      i2 = this.e.getCardInfo((GetCardInfoRequestParams)localObject2, new a(6, this.J[6], (byte)0));
      if (-2 == i2)
      {
        i1 = a(6, paramGetCardInfoRequestParams, paramITsmCallback);
        break;
      }
      i1 = i2;
      if (i2 != 0) {
        break;
      }
      paramGetCardInfoRequestParams = this.y;
      localObject1 = this.J;
      i1 = localObject1[6];
      localObject1[6] = (i1 + 1);
      paramGetCardInfoRequestParams.put(String.valueOf(i1), paramITsmCallback);
      i1 = i2;
      break;
      i1 = a(6, paramGetCardInfoRequestParams, paramITsmCallback);
      break;
      i1 = -1;
      break;
      while ((i2 < i4) && (localObject2[i2] == null)) {
        i2 += 1;
      }
      break label57;
      for (;;)
      {
        if (i1 >= i4) {
          break label322;
        }
        if (localObject2[i1] != null) {
          break;
        }
        localObject1[i1] = localObject2[i1];
        i1 += 1;
      }
    }
  }
  
  public int getCardInfoBySamsungPay(GetCardInfoBySpayRequestParams paramGetCardInfoBySpayRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if ((paramGetCardInfoBySpayRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e != null)
        {
          if (b(this.c.getPackageName()))
          {
            Object localObject1 = new GetCardInfoBySpayRequestParams();
            Object localObject2 = paramGetCardInfoBySpayRequestParams.getReserve();
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ((GetCardInfoBySpayRequestParams)localObject1).setReserve(c((String)localObject2));
            }
            Object localObject3 = paramGetCardInfoBySpayRequestParams.getAmount();
            if (localObject3 != null)
            {
              localObject2 = ((Amount)localObject3).getCurrencyType();
              localObject3 = ((Amount)localObject3).getProductPrice();
              Amount localAmount = new Amount();
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                localAmount.setCurrencyType(c((String)localObject2));
              }
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                localAmount.setProductPrice(c((String)localObject3));
              }
              ((GetCardInfoBySpayRequestParams)localObject1).setAmount(localAmount);
            }
            this.G.put(String.valueOf(this.J[28]), paramITsmCallback);
            localObject2 = this.e;
            localObject3 = this.J;
            i1 = localObject3[28];
            localObject3[28] = (i1 + 1);
            int i2 = ((ITsmService)localObject2).getCardInfoBySamsungPay((GetCardInfoBySpayRequestParams)localObject1, new a(28, i1, (byte)0));
            if (i2 != 0)
            {
              localObject1 = this.G;
              localObject2 = this.J;
              i1 = localObject2[28] - 1;
              localObject2[28] = i1;
              ((HashMap)localObject1).remove(String.valueOf(i1));
            }
            i1 = i2;
            if (-2 != i2) {
              continue;
            }
            i1 = a(28, paramGetCardInfoBySpayRequestParams, paramITsmCallback);
            continue;
          }
          i1 = a(28, paramGetCardInfoBySpayRequestParams, paramITsmCallback);
          continue;
        }
        i1 = -1;
      }
      finally {}
    }
  }
  
  public Context getContext()
  {
    return this.c;
  }
  
  public int getDefaultCard(GetDefaultCardRequestParams paramGetDefaultCardRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if (paramITsmCallback == null) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label184;
        }
        if (b(this.c.getPackageName()))
        {
          Object localObject = new GetDefaultCardRequestParams();
          if (paramGetDefaultCardRequestParams != null)
          {
            String str = paramGetDefaultCardRequestParams.getReserve();
            if (!TextUtils.isEmpty(str)) {
              ((GetDefaultCardRequestParams)localObject).setReserve(c(str));
            }
          }
          int i2 = this.e.getDefaultCard((GetDefaultCardRequestParams)localObject, new a(13, this.J[13], (byte)0));
          if (-2 == i2)
          {
            i1 = a(13, paramGetDefaultCardRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramGetDefaultCardRequestParams = this.w;
          localObject = this.J;
          i1 = localObject[13];
          localObject[13] = (i1 + 1);
          paramGetDefaultCardRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(13, paramGetDefaultCardRequestParams, paramITsmCallback);
      continue;
      label184:
      i1 = -1;
    }
  }
  
  public int getListenerCount()
  {
    if (b != null) {
      return b.size();
    }
    return 0;
  }
  
  public int getPubKey(int paramInt, String[] paramArrayOfString)
    throws RemoteException
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return -3;
    }
    if (this.e != null) {
      return this.e.getPubKey(paramInt, paramArrayOfString);
    }
    return -1;
  }
  
  public int getSEAppList(GetSeAppListRequestParams paramGetSeAppListRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if (paramITsmCallback == null) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label178;
        }
        if (b(this.c.getPackageName()))
        {
          Object localObject = new GetSeAppListRequestParams();
          if (paramGetSeAppListRequestParams != null)
          {
            String str = paramGetSeAppListRequestParams.getReserve();
            if (!TextUtils.isEmpty(str)) {
              ((GetSeAppListRequestParams)localObject).setReserve(c(str));
            }
          }
          int i2 = this.e.getSEAppList((GetSeAppListRequestParams)localObject, new a(3, this.J[3], (byte)0));
          if (-2 == i2)
          {
            i1 = a(3, paramGetSeAppListRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramGetSeAppListRequestParams = this.i;
          localObject = this.J;
          i1 = localObject[3];
          localObject[3] = (i1 + 1);
          paramGetSeAppListRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(3, paramGetSeAppListRequestParams, paramITsmCallback);
      continue;
      label178:
      i1 = -1;
    }
  }
  
  public int getSMSAuthCode(GetSMSAuthCodeRequestParams paramGetSMSAuthCodeRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if ((paramGetSMSAuthCodeRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label295;
        }
        if (b(this.c.getPackageName()))
        {
          Object localObject1 = new GetSMSAuthCodeRequestParams();
          String str = paramGetSMSAuthCodeRequestParams.getReserve();
          Object localObject2 = paramGetSMSAuthCodeRequestParams.getAppID();
          if (!TextUtils.isEmpty(str)) {
            ((GetSMSAuthCodeRequestParams)localObject1).setReserve(c(str));
          }
          if (localObject2 != null)
          {
            str = ((AppID)localObject2).getAppAid();
            localObject2 = ((AppID)localObject2).getAppVersion();
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
              ((GetSMSAuthCodeRequestParams)localObject1).setAppID(new AppID(c(str), c((String)localObject2)));
            }
          }
          localObject2 = paramGetSMSAuthCodeRequestParams.getPan();
          str = paramGetSMSAuthCodeRequestParams.getMsisdn();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((GetSMSAuthCodeRequestParams)localObject1).setPan(c((String)localObject2));
          }
          if (!TextUtils.isEmpty(str)) {
            ((GetSMSAuthCodeRequestParams)localObject1).setMsisdn(c(str));
          }
          int i2 = this.e.getSMSAuthCode((GetSMSAuthCodeRequestParams)localObject1, new a(11, this.J[11], (byte)0));
          if (-2 == i2)
          {
            i1 = a(11, paramGetSMSAuthCodeRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramGetSMSAuthCodeRequestParams = this.p;
          localObject1 = this.J;
          i1 = localObject1[11];
          localObject1[11] = (i1 + 1);
          paramGetSMSAuthCodeRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(11, paramGetSMSAuthCodeRequestParams, paramITsmCallback);
      continue;
      label295:
      i1 = -1;
    }
  }
  
  public int getSeId(GetSeIdRequestParams paramGetSeIdRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if (paramITsmCallback == null) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e != null)
        {
          if (b(this.c.getPackageName()))
          {
            Object localObject1 = new GetSeIdRequestParams();
            if (paramGetSeIdRequestParams != null)
            {
              localObject2 = paramGetSeIdRequestParams.getReserve();
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                ((GetSeIdRequestParams)localObject1).setReserve(c((String)localObject2));
              }
            }
            this.x.put(String.valueOf(this.J[12]), paramITsmCallback);
            Object localObject2 = this.e;
            int[] arrayOfInt = this.J;
            i1 = arrayOfInt[12];
            arrayOfInt[12] = (i1 + 1);
            int i2 = ((ITsmService)localObject2).getSEId((GetSeIdRequestParams)localObject1, new a(12, i1, (byte)0));
            if (i2 != 0)
            {
              localObject1 = this.x;
              localObject2 = this.J;
              i1 = localObject2[12] - 1;
              localObject2[12] = i1;
              ((HashMap)localObject1).remove(String.valueOf(i1));
            }
            i1 = i2;
            if (-2 != i2) {
              continue;
            }
            i1 = a(12, paramGetSeIdRequestParams, paramITsmCallback);
            continue;
          }
          i1 = a(12, paramGetSeIdRequestParams, paramITsmCallback);
          continue;
        }
        i1 = -1;
      }
      finally {}
    }
  }
  
  public int getTransElements(GetTransElementsRequestParams paramGetTransElementsRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if ((paramGetTransElementsRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label271;
        }
        if (b(this.c.getPackageName()))
        {
          Object localObject1 = new GetTransElementsRequestParams();
          String str2 = paramGetTransElementsRequestParams.getReserve();
          Object localObject2 = paramGetTransElementsRequestParams.getAppID();
          String str1 = paramGetTransElementsRequestParams.getTransType();
          if (!TextUtils.isEmpty(str2)) {
            ((GetTransElementsRequestParams)localObject1).setReserve(c(str2));
          }
          if (localObject2 != null)
          {
            str2 = ((AppID)localObject2).getAppAid();
            localObject2 = ((AppID)localObject2).getAppVersion();
            if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
              ((GetTransElementsRequestParams)localObject1).setAppID(new AppID(c(str2), c((String)localObject2)));
            }
          }
          if (!TextUtils.isEmpty(str1)) {
            ((GetTransElementsRequestParams)localObject1).setTransType(c(str1));
          }
          int i2 = this.e.getTransElements((GetTransElementsRequestParams)localObject1, new a(9, this.J[9], (byte)0));
          if (-2 == i2)
          {
            i1 = a(9, paramGetTransElementsRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramGetTransElementsRequestParams = this.m;
          localObject1 = this.J;
          i1 = localObject1[9];
          localObject1[9] = (i1 + 1);
          paramGetTransElementsRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(9, paramGetTransElementsRequestParams, paramITsmCallback);
      continue;
      label271:
      i1 = -1;
    }
  }
  
  public int getTransRecord(GetTransRecordRequestParams paramGetTransRecordRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if ((paramGetTransRecordRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label247;
        }
        if (b(this.c.getPackageName()))
        {
          Object localObject1 = new GetTransRecordRequestParams();
          String str = paramGetTransRecordRequestParams.getReserve();
          Object localObject2 = paramGetTransRecordRequestParams.getAppID();
          if (!TextUtils.isEmpty(str)) {
            ((GetTransRecordRequestParams)localObject1).setReserve(c(str));
          }
          if (localObject2 != null)
          {
            str = ((AppID)localObject2).getAppAid();
            localObject2 = ((AppID)localObject2).getAppVersion();
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
              ((GetTransRecordRequestParams)localObject1).setAppID(new AppID(c(str), c((String)localObject2)));
            }
          }
          int i2 = this.e.getTransRecord((GetTransRecordRequestParams)localObject1, new a(10, this.J[10], (byte)0));
          if (-2 == i2)
          {
            i1 = a(10, paramGetTransRecordRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramGetTransRecordRequestParams = this.r;
          localObject1 = this.J;
          i1 = localObject1[10];
          localObject1[10] = (i1 + 1);
          paramGetTransRecordRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(10, paramGetTransRecordRequestParams, paramITsmCallback);
      continue;
      label247:
      i1 = -1;
    }
  }
  
  public int hideAppApply(HideAppApplyRequestParams paramHideAppApplyRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i2 = -3;
    int i1 = i2;
    if (paramHideAppApplyRequestParams != null)
    {
      if (paramITsmCallback != null) {
        break label24;
      }
      i1 = i2;
    }
    for (;;)
    {
      return i1;
      try
      {
        label24:
        Object localObject = paramHideAppApplyRequestParams.getApplyId();
        i1 = i2;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        if (this.e == null) {
          break label222;
        }
        if (b(this.c.getPackageName()))
        {
          String str = c((String)localObject);
          localObject = new HideAppApplyRequestParams();
          ((HideAppApplyRequestParams)localObject).setApplyId(str);
          str = paramHideAppApplyRequestParams.getReserve();
          if (!TextUtils.isEmpty(str)) {
            ((HideAppApplyRequestParams)localObject).setReserve(c(str));
          }
          i2 = this.e.hideAppApply((HideAppApplyRequestParams)localObject, new a(24, this.J[24], (byte)0));
          if (-2 == i2)
          {
            i1 = a(24, paramHideAppApplyRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramHideAppApplyRequestParams = this.E;
          localObject = this.J;
          i1 = localObject[24];
          localObject[24] = (i1 + 1);
          paramHideAppApplyRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(24, paramHideAppApplyRequestParams, paramITsmCallback);
      continue;
      label222:
      i1 = -1;
    }
  }
  
  public int init(InitRequestParams paramInitRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if (paramITsmCallback == null) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e != null)
        {
          if (b(this.c.getPackageName()))
          {
            Object localObject1 = new InitRequestParams();
            if (paramInitRequestParams != null)
            {
              localObject2 = paramInitRequestParams.getReserve();
              localObject3 = paramInitRequestParams.getSignature();
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                ((InitRequestParams)localObject1).setReserve(c((String)localObject2));
              }
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                ((InitRequestParams)localObject1).setSignature(c((String)localObject3));
              }
            }
            this.g.put(String.valueOf(this.J[0]), paramITsmCallback);
            Object localObject2 = this.e;
            Object localObject3 = this.J;
            i1 = localObject3[0];
            localObject3[0] = (i1 + 1);
            int i2 = ((ITsmService)localObject2).init((InitRequestParams)localObject1, new a(0, i1, (byte)0));
            if (i2 != 0)
            {
              localObject1 = this.g;
              localObject2 = this.J;
              i1 = localObject2[0] - 1;
              localObject2[0] = i1;
              ((HashMap)localObject1).remove(String.valueOf(i1));
            }
            i1 = i2;
            if (-2 != i2) {
              continue;
            }
            i1 = a(0, paramInitRequestParams, paramITsmCallback);
            continue;
          }
          i1 = a(0, paramInitRequestParams, paramITsmCallback);
          continue;
        }
        i1 = -1;
      }
      finally {}
    }
  }
  
  public boolean isConnected()
  {
    return this.f;
  }
  
  public int openChannel(OpenChannelRequestParams paramOpenChannelRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i2 = -3;
    int i1 = i2;
    if (paramOpenChannelRequestParams != null)
    {
      if (paramITsmCallback != null) {
        break label24;
      }
      i1 = i2;
    }
    for (;;)
    {
      return i1;
      try
      {
        label24:
        Object localObject = paramOpenChannelRequestParams.getAppAID();
        i1 = i2;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        if (this.e == null) {
          break label222;
        }
        if (b(this.c.getPackageName()))
        {
          String str = c((String)localObject);
          localObject = new OpenChannelRequestParams();
          ((OpenChannelRequestParams)localObject).setAppAID(str);
          str = paramOpenChannelRequestParams.getReserve();
          if (!TextUtils.isEmpty(str)) {
            ((OpenChannelRequestParams)localObject).setReserve(c(str));
          }
          i2 = this.e.openChannel((OpenChannelRequestParams)localObject, new a(20, this.J[20], (byte)0));
          if (-2 == i2)
          {
            i1 = a(20, paramOpenChannelRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramOpenChannelRequestParams = this.u;
          localObject = this.J;
          i1 = localObject[20];
          localObject[20] = (i1 + 1);
          paramOpenChannelRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(20, paramOpenChannelRequestParams, paramITsmCallback);
      continue;
      label222:
      i1 = -1;
    }
  }
  
  public void removeConnectionListener(UPTsmConnectionListener paramUPTsmConnectionListener)
  {
    if (paramUPTsmConnectionListener != null) {
      b.remove(paramUPTsmConnectionListener);
    }
  }
  
  public int sendApdu(SendApduRequestParams paramSendApduRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if ((paramSendApduRequestParams == null) || (paramITsmCallback == null)) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e == null) {
          break label232;
        }
        if (b(this.c.getPackageName()))
        {
          Object localObject = new SendApduRequestParams();
          String str1 = paramSendApduRequestParams.getReserve();
          String str2 = paramSendApduRequestParams.getChannel();
          String str3 = paramSendApduRequestParams.getHexApdu();
          if (!TextUtils.isEmpty(str1)) {
            ((SendApduRequestParams)localObject).setReserve(c(str1));
          }
          if (!TextUtils.isEmpty(str2)) {
            ((SendApduRequestParams)localObject).setChannel(c(str2));
          }
          if (!TextUtils.isEmpty(str3)) {
            ((SendApduRequestParams)localObject).setHexApdu(c(str3));
          }
          int i2 = this.e.sendApdu((SendApduRequestParams)localObject, new a(22, this.J[22], (byte)0));
          if (-2 == i2)
          {
            i1 = a(22, paramSendApduRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramSendApduRequestParams = this.v;
          localObject = this.J;
          i1 = localObject[22];
          localObject[22] = (i1 + 1);
          paramSendApduRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(22, paramSendApduRequestParams, paramITsmCallback);
      continue;
      label232:
      i1 = -1;
    }
  }
  
  public int setDefaultCard(SetDefaultCardRequestParams paramSetDefaultCardRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i2 = -3;
    int i1 = i2;
    if (paramSetDefaultCardRequestParams != null)
    {
      if (paramITsmCallback != null) {
        break label24;
      }
      i1 = i2;
    }
    for (;;)
    {
      return i1;
      try
      {
        label24:
        Object localObject = paramSetDefaultCardRequestParams.getAppAID();
        i1 = i2;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        if (this.e == null) {
          break label222;
        }
        if (b(this.c.getPackageName()))
        {
          String str = c((String)localObject);
          localObject = new SetDefaultCardRequestParams();
          ((SetDefaultCardRequestParams)localObject).setAppAID(str);
          str = paramSetDefaultCardRequestParams.getReserve();
          if (!TextUtils.isEmpty(str)) {
            ((SetDefaultCardRequestParams)localObject).setReserve(c(str));
          }
          i2 = this.e.setDefaultCard((SetDefaultCardRequestParams)localObject, new a(14, this.J[14], (byte)0));
          if (-2 == i2)
          {
            i1 = a(14, paramSetDefaultCardRequestParams, paramITsmCallback);
            continue;
          }
          i1 = i2;
          if (i2 != 0) {
            continue;
          }
          paramSetDefaultCardRequestParams = this.C;
          localObject = this.J;
          i1 = localObject[14];
          localObject[14] = (i1 + 1);
          paramSetDefaultCardRequestParams.put(String.valueOf(i1), paramITsmCallback);
          i1 = i2;
          continue;
        }
      }
      finally {}
      i1 = a(14, paramSetDefaultCardRequestParams, paramITsmCallback);
      continue;
      label222:
      i1 = -1;
    }
  }
  
  public int setSamsungDefaultWallet(SetSamsungDefWalletRequestParams paramSetSamsungDefWalletRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException
  {
    int i1;
    if (paramITsmCallback == null) {
      i1 = -3;
    }
    for (;;)
    {
      return i1;
      try
      {
        if (this.e != null)
        {
          if (b(this.c.getPackageName()))
          {
            Object localObject1 = new SetSamsungDefWalletRequestParams();
            if (paramSetSamsungDefWalletRequestParams != null)
            {
              localObject2 = paramSetSamsungDefWalletRequestParams.getReserve();
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                ((SetSamsungDefWalletRequestParams)localObject1).setReserve(c((String)localObject2));
              }
            }
            this.I.put(String.valueOf(this.J[30]), paramITsmCallback);
            Object localObject2 = this.e;
            int[] arrayOfInt = this.J;
            i1 = arrayOfInt[30];
            arrayOfInt[30] = (i1 + 1);
            int i2 = ((ITsmService)localObject2).setSamsungDefaultWallet((SetSamsungDefWalletRequestParams)localObject1, new a(30, i1, (byte)0));
            if (i2 != 0)
            {
              localObject1 = this.I;
              localObject2 = this.J;
              i1 = localObject2[30] - 1;
              localObject2[30] = i1;
              ((HashMap)localObject1).remove(String.valueOf(i1));
            }
            i1 = i2;
            if (-2 != i2) {
              continue;
            }
            i1 = a(30, paramSetSamsungDefWalletRequestParams, paramITsmCallback);
            continue;
          }
          i1 = a(30, paramSetSamsungDefWalletRequestParams, paramITsmCallback);
          continue;
        }
        i1 = -1;
      }
      finally {}
    }
  }
  
  public void unbind()
  {
    if ((this.d != null) && (this.f))
    {
      this.c.unbindService(this.d);
      this.f = false;
    }
  }
  
  public static abstract interface UPTsmConnectionListener
  {
    public abstract void onTsmConnected();
    
    public abstract void onTsmDisconnected();
  }
  
  private final class a
    extends ITsmCallback.Stub
  {
    private int b;
    private int c;
    
    private a(int paramInt1, int paramInt2)
    {
      this.b = paramInt1;
      this.c = paramInt2;
    }
    
    public final void onError(String paramString1, String paramString2)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("errorCode", paramString1);
      localBundle.putString("errorDesc", paramString2);
      paramString1 = UPTsmAddon.this;
      UPTsmAddon.a((ITsmCallback)UPTsmAddon.a(UPTsmAddon.this, this.b).get(String.valueOf(this.c)), localBundle);
      UPTsmAddon.a(UPTsmAddon.this, this.b).remove(String.valueOf(this.c));
      if (UPTsmAddon.a(UPTsmAddon.this, this.b).isEmpty()) {
        UPTsmAddon.b(UPTsmAddon.this)[this.b] = 0;
      }
    }
    
    public final void onResult(Bundle paramBundle)
      throws RemoteException
    {
      new Bundle();
      int i = this.b;
      Bundle localBundle = new Bundle();
      Parcel localParcel = Parcel.obtain();
      Object localObject2 = paramBundle.getString("errorCode");
      Object localObject1 = paramBundle.getString("result");
      localBundle.putString("errorCode", (String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = UPTsmAddon.this;
        localObject1 = Base64.decode(UPTsmAddon.a((String)localObject1), 0);
        if ((localObject1 != null) && (localObject1.length != 0))
        {
          localParcel.unmarshall((byte[])localObject1, 0, localObject1.length);
          localParcel.setDataPosition(0);
        }
        if (localParcel.dataSize() == 0)
        {
          localBundle.putString("errorCode", "010035");
          localObject1 = localBundle;
        }
      }
      for (;;)
      {
        localParcel.recycle();
        paramBundle = UPTsmAddon.this;
        UPTsmAddon.a((ITsmCallback)UPTsmAddon.a(UPTsmAddon.this, this.b).get(String.valueOf(this.c)), (Bundle)localObject1);
        UPTsmAddon.a(UPTsmAddon.this, this.b).remove(String.valueOf(this.c));
        if (UPTsmAddon.a(UPTsmAddon.this, this.b).isEmpty()) {
          UPTsmAddon.b(UPTsmAddon.this)[this.b] = 0;
        }
        return;
        localObject1 = paramBundle;
        switch (i)
        {
        case 5: 
        case 14: 
        case 16: 
        case 17: 
        case 18: 
        case 21: 
        case 24: 
        case 25: 
        case 26: 
        case 27: 
        default: 
          localObject1 = paramBundle;
          break;
        case 0: 
          localBundle.putParcelable("result", (InitResult)localParcel.readParcelable(InitResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 1: 
          localBundle.putParcelable("result", (GetAssociatedAppResult)localParcel.readParcelable(GetAssociatedAppResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 3: 
          localBundle.putParcelable("result", (GetSeAppListResult)localParcel.readParcelable(GetSeAppListResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 2: 
          localBundle.putParcelable("result", (GetAppListResult)localParcel.readParcelable(GetAppListResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 4: 
          localBundle.putParcelable("result", (GetAppDetailResult)localParcel.readParcelable(GetAppDetailResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 9: 
          localBundle.putParcelable("result", (GetTransElementsResult)localParcel.readParcelable(GetTransElementsResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 15: 
          localBundle.putParcelable("result", (AppDownloadApplyResult)localParcel.readParcelable(AppDownloadApplyResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 11: 
          localBundle.putParcelable("result", (GetSMSAuthCodeResult)localParcel.readParcelable(GetSMSAuthCodeResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 7: 
          localBundle.putParcelable("result", (GetAccountInfoResult)localParcel.readParcelable(GetAccountInfoResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 8: 
          localBundle.putParcelable("result", (GetAccountBalanceResult)localParcel.readParcelable(GetAccountBalanceResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 6: 
          localBundle.putParcelable("result", (GetCardInfoResult)localParcel.readParcelable(GetCardInfoResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 13: 
          localBundle.putParcelable("result", (GetDefaultCardResult)localParcel.readParcelable(GetDefaultCardResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 12: 
          localBundle.putParcelable("result", (GetSeIdResult)localParcel.readParcelable(GetSeIdResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 10: 
          localBundle.putParcelable("result", (GetTransRecordResult)localParcel.readParcelable(GetTransRecordResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 19: 
          localBundle.putParcelable("result", (ECashTopUpResult)localParcel.readParcelable(ECashTopUpResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 23: 
          localBundle.putParcelable("result", (EncryptDataResult)localParcel.readParcelable(EncryptDataResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 20: 
          localBundle.putParcelable("result", (OpenChannelResult)localParcel.readParcelable(OpenChannelResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 22: 
          localBundle.putParcelable("result", (SendApduResult)localParcel.readParcelable(SendApduResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 28: 
          localBundle.putParcelable("result", (GetCardInfoBySpayResult)localParcel.readParcelable(GetCardInfoBySpayResult.class.getClassLoader()));
          localObject1 = localBundle;
          break;
        case 29: 
          localBundle.putParcelable("result", (CheckSSamsungPayResult)localParcel.readParcelable(CheckSSamsungPayResult.class.getClassLoader()));
          localObject1 = localBundle;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/UPTsmAddon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */