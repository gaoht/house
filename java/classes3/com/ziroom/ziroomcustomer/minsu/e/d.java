package com.ziroom.ziroomcustomer.minsu.e;

import android.app.Activity;
import android.content.Context;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.freelxl.baselibrary.d.b.b;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.h;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.n;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.f.t;
import com.ziroom.ziroomcustomer.minsu.f.w;
import com.ziroom.ziroomcustomer.newServiceList.utils.f;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import okhttp3.Callback;

@Instrumented
public class d
{
  private static com.freelxl.baselibrary.d.c.a a(Activity paramActivity, final Class paramClass, final i.a parama)
  {
    if (paramClass == null) {}
    for (Object localObject = new com.freelxl.baselibrary.d.f.e();; localObject = new com.freelxl.baselibrary.d.f.d(paramClass)) {
      new s(paramActivity, (com.freelxl.baselibrary.d.f.a)localObject)
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          k localk = new k();
          localk.setSuccess(Boolean.valueOf(false));
          if (paramClass == null) {
            parama.onParse("", localk);
          }
          for (;;)
          {
            super.onFailure(paramAnonymousThrowable);
            return;
            parama.onSuccess(localk);
          }
        }
        
        public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
        {
          k localk = new k();
          localk.setObject(paramAnonymousObject);
          localk.setSuccess(Boolean.valueOf(true));
          if (paramClass == null) {
            parama.onParse(paramAnonymousObject.toString(), localk);
          }
          for (;;)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymousObject);
            return;
            parama.onSuccess(localk);
          }
        }
      };
    }
  }
  
  private static com.freelxl.baselibrary.d.c.a a(Activity paramActivity, final Class paramClass, boolean paramBoolean, final i.a parama)
  {
    if (paramBoolean) {
      return a(paramActivity, paramClass, parama);
    }
    if (paramClass == null) {}
    for (Object localObject = new com.freelxl.baselibrary.d.f.e();; localObject = new com.freelxl.baselibrary.d.f.d(paramClass)) {
      new t(paramActivity, (com.freelxl.baselibrary.d.f.a)localObject)
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          k localk = new k();
          localk.setSuccess(Boolean.valueOf(false));
          if (paramClass == null) {
            parama.onParse("", localk);
          }
          for (;;)
          {
            super.onFailure(paramAnonymousThrowable);
            return;
            parama.onSuccess(localk);
          }
        }
        
        public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
        {
          k localk = new k();
          localk.setObject(paramAnonymousObject);
          localk.setSuccess(Boolean.valueOf(true));
          if (paramClass == null)
          {
            parama.onParse(paramAnonymousObject.toString(), localk);
            return;
          }
          parama.onSuccess(localk);
        }
      };
    }
  }
  
  private static com.freelxl.baselibrary.d.c.a b(Activity paramActivity, final Class paramClass, final i.a parama)
  {
    if (paramClass == null) {}
    for (Object localObject = new w();; localObject = new r(paramClass)) {
      new s(paramActivity, (com.freelxl.baselibrary.d.f.a)localObject)
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          k localk = new k();
          localk.setSuccess(Boolean.valueOf(false));
          if (paramClass == null) {
            parama.onParse("", localk);
          }
          for (;;)
          {
            super.onFailure(paramAnonymousThrowable);
            return;
            parama.onSuccess(localk);
          }
        }
        
        public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
        {
          k localk = new k();
          localk.setObject(paramAnonymousObject);
          localk.setSuccess(Boolean.valueOf(true));
          if (paramClass == null) {
            parama.onParse(paramAnonymousObject.toString(), localk);
          }
          for (;;)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymousObject);
            return;
            parama.onSuccess(localk);
          }
        }
      };
    }
  }
  
  public static Map<String, String> getCmsSign(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    paramMap = String.valueOf(m.TimeS2L(m.GetNowDateTime(), m.c)).substring(0, 10);
    ((Map)localObject).put("timestamp", paramMap);
    ((Map)localObject).put("sign", h.toMd5(("1" + paramMap + SignKeyUtil.getHouseKey()).getBytes()));
    ((Map)localObject).put("uid", "1");
    return (Map<String, String>)localObject;
  }
  
  public static Map<String, String> getHeaderMap(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str1 = getUid();
    String str2 = getToken();
    localHashMap.put("Client-Version", h.getAppVersion(ApplicationEx.c));
    localHashMap.put("Client-Type", "1");
    localHashMap.put("User-Agent", ad.getUserAgent(paramContext));
    if (ae.notNull(str1)) {
      localHashMap.put("uid", str1);
    }
    if (ae.notNull(str2)) {
      localHashMap.put("token", str2);
    }
    localHashMap.put("source", "1");
    if (ae.notNull(com.ziroom.ziroomcustomer.minsu.b.c.a)) {
      localHashMap.put("cityCode", com.ziroom.ziroomcustomer.minsu.b.c.a);
    }
    localHashMap.put("traceInfo", com.alibaba.fastjson.e.toJSONString(new com.alibaba.fastjson.e(ad.getPhoneInfo()), new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static Map<String, String> getHeaderMap2(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str1 = getUid();
    String str2 = getToken();
    localHashMap.put("Client-Version", h.getAppVersion(ApplicationEx.c));
    localHashMap.put("Client-Type", "1");
    localHashMap.put("User-Agent", ad.getUserAgent(paramContext));
    if (ae.notNull(str1)) {
      localHashMap.put("uid", str1);
    }
    if (ae.notNull(str2)) {
      localHashMap.put("token", str2);
    }
    localHashMap.put("source", "1");
    if (ae.notNull(com.ziroom.ziroomcustomer.minsu.b.c.a)) {
      localHashMap.put("cityCode", com.ziroom.ziroomcustomer.minsu.b.c.a);
    }
    localHashMap.put("traceInfo", com.alibaba.fastjson.e.toJSONString(new com.alibaba.fastjson.e(ad.getPhoneInfo2()), new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    return localHashMap;
  }
  
  public static String getToken()
  {
    return com.ziroom.commonlibrary.login.a.getToken(ApplicationEx.c);
  }
  
  public static String getUid()
  {
    return com.ziroom.commonlibrary.login.a.getUid(ApplicationEx.c);
  }
  
  public static String map2GetUrl(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString.contains("?")) {
      localStringBuilder.append("&");
    }
    for (;;)
    {
      if (paramMap != null)
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            paramMap = (Map.Entry)localIterator.next();
            String str = (String)paramMap.getKey();
            Object localObject = paramMap.getValue();
            if (localObject != null)
            {
              paramMap = (Map<String, String>)localObject;
              if ((localObject instanceof String)) {}
              try
              {
                paramMap = URLEncoder.encode(localObject.toString(), "UTF-8");
                localStringBuilder.append(str).append("=").append(paramMap).append("&");
                continue;
                localStringBuilder.append("?");
              }
              catch (UnsupportedEncodingException paramMap)
              {
                for (;;)
                {
                  paramMap.printStackTrace();
                  paramMap = (Map<String, String>)localObject;
                }
              }
            }
          }
        }
      }
    }
    return paramString + localStringBuilder.toString();
  }
  
  public static void request(Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, Class paramClass, i.a<String> parama)
  {
    requestNoDES(paramActivity, paramString1, paramString2, signMethod(paramString3), paramBoolean, b(paramActivity, paramClass, parama));
  }
  
  public static void request(Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, Callback paramCallback)
  {
    requestNoDES(paramActivity, paramString1, paramString2, signMethod(paramString3), paramBoolean, paramCallback);
  }
  
  public static void request(Activity paramActivity, String paramString1, String paramString2, Map<String, Object> paramMap, Class paramClass, i.a<String> parama)
  {
    request(paramActivity, paramString1, paramString2, paramMap, true, paramClass, parama);
  }
  
  public static void request(Activity paramActivity, String paramString1, String paramString2, Map paramMap, Callback paramCallback)
  {
    request(paramActivity, paramString1, paramString2, paramMap, true, paramCallback);
  }
  
  public static void request(Activity paramActivity, String paramString1, String paramString2, Map<String, Object> paramMap, boolean paramBoolean, Class paramClass, i.a<String> parama)
  {
    requestNoDES(paramActivity, paramString1, paramString2, signMethod(paramMap), paramBoolean, b(paramActivity, paramClass, parama));
  }
  
  public static void request(Activity paramActivity, String paramString1, String paramString2, Map paramMap, boolean paramBoolean, Callback paramCallback)
  {
    requestNoDES(paramActivity, paramString1, paramString2, signMethod(paramMap), paramBoolean, paramCallback);
  }
  
  public static void requestCMS(Activity paramActivity, String paramString, Map<String, String> paramMap, boolean paramBoolean, Callback paramCallback)
  {
    requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.c, paramString, paramMap, paramBoolean, paramCallback);
  }
  
  public static void requestGateWay(Activity paramActivity, String paramString1, String paramString2, com.alibaba.fastjson.e parame, Callback paramCallback)
  {
    Map localMap = f.getGateWayHeader(paramActivity);
    localMap.put("needToken", "true");
    String str1 = getUid();
    String str2 = getToken();
    localMap.put("Client-Version", h.getAppVersion(ApplicationEx.c));
    localMap.put("Client-Type", "1");
    localMap.put("User-Agent", ad.getUserAgent(paramActivity));
    if (ae.notNull(str1)) {
      localMap.put("uid", str1);
    }
    if (ae.notNull(str2)) {
      localMap.put("token", str2);
    }
    localMap.put("source", "1");
    if (ae.notNull(com.ziroom.ziroomcustomer.minsu.b.c.a)) {
      localMap.put("cityCode", com.ziroom.ziroomcustomer.minsu.b.c.a);
    }
    localMap.put("traceInfo", com.alibaba.fastjson.e.toJSONString(new com.alibaba.fastjson.e(ad.getPhoneInfo2()), new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    com.freelxl.baselibrary.d.a.post(paramString1 + "bnbApi" + paramString2).tag(paramActivity).headers(localMap).setBodyString("application/json;charset=UTF-8", f.getGateWayParam(parame)).enqueue(paramCallback);
  }
  
  public static void requestGateWayPath(Activity paramActivity, boolean paramBoolean, String paramString1, String paramString2, com.alibaba.fastjson.e parame, Callback paramCallback)
  {
    Map localMap = f.getGateWayHeader(paramActivity);
    localMap.put("needToken", String.valueOf(paramBoolean));
    String str1 = getUid();
    String str2 = getToken();
    localMap.put("Client-Version", h.getAppVersion(ApplicationEx.c));
    localMap.put("Client-Type", "1");
    localMap.put("User-Agent", ad.getUserAgent(paramActivity));
    if (ae.notNull(str1)) {
      localMap.put("uid", str1);
    }
    if (ae.notNull(str2)) {
      localMap.put("token", str2);
    }
    localMap.put("source", "1");
    if (ae.notNull(com.ziroom.ziroomcustomer.minsu.b.c.a)) {
      localMap.put("cityCode", com.ziroom.ziroomcustomer.minsu.b.c.a);
    }
    localMap.put("traceInfo", com.alibaba.fastjson.e.toJSONString(new com.alibaba.fastjson.e(ad.getPhoneInfo2()), new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    com.freelxl.baselibrary.d.a.post(q.o + paramString1 + paramString2).tag(paramActivity).headers(localMap).setBodyString("application/json;charset=UTF-8", f.getGateWayParam(parame)).enqueue(paramCallback);
  }
  
  public static void requestGet(Activity paramActivity, String paramString1, String paramString2, Map<String, Object> paramMap, boolean paramBoolean, Class paramClass, i.a<MinsuHouseBean> parama)
  {
    requestGet(paramActivity, paramString1, paramString2, ad.ConvertObjMap2String(paramMap), paramBoolean, a(paramActivity, paramClass, paramBoolean, parama));
  }
  
  public static void requestGet(Activity paramActivity, String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.get(paramString1 + paramString2).headers(getHeaderMap(paramActivity)).params(paramMap).tag(paramActivity).enqueue(paramCallback);
  }
  
  public static void requestNoDES(Activity paramActivity, String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.post(paramString1 + paramString2).params(paramMap).tag(paramActivity).headers(getHeaderMap(paramActivity)).enqueue(paramCallback);
  }
  
  public static void requestNoDES(Activity paramActivity, String paramString, Map<String, String> paramMap, boolean paramBoolean, Class paramClass, i.a<String> parama)
  {
    requestCMS(paramActivity, paramString, paramMap, paramBoolean, a(paramActivity, paramClass, paramBoolean, parama));
  }
  
  public static void requestNoDES(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.post(paramString1 + paramString2).params(paramMap).tag(paramContext).headers(getHeaderMap(paramContext)).enqueue(paramCallback);
  }
  
  public static void requestNoDES2(Activity paramActivity, String paramString1, String paramString2, Map<String, String> paramMap, Callback paramCallback)
  {
    com.freelxl.baselibrary.d.a.post(paramString1 + paramString2).params(paramMap).tag(paramActivity).headers(getHeaderMap2(paramActivity)).enqueue(paramCallback);
  }
  
  public static void setCommonParameter(Map paramMap)
  {
    String str2 = getUid();
    if (!paramMap.containsKey("uid"))
    {
      String str1 = str2;
      if (ae.isNull(str2)) {
        str1 = "";
      }
      paramMap.put("uid", str1);
    }
  }
  
  public static Map<String, String> signMethod(String paramString)
  {
    String str = com.freelxl.baselibrary.f.a.c.createEncryption("DES").encrypt(paramString, SignKeyUtil.getIvKeyFromC(), SignKeyUtil.getKeyFromC());
    paramString = h.toMd5(paramString.getBytes());
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", str);
    localHashMap.put("hPtJ39Xs", paramString);
    localHashMap.put("source", "1");
    if (ae.notNull(com.ziroom.ziroomcustomer.minsu.b.c.a)) {
      localHashMap.put("cityCode", com.ziroom.ziroomcustomer.minsu.b.c.a);
    }
    return localHashMap;
  }
  
  public static Map<String, String> signMethod(Map paramMap)
  {
    setCommonParameter(paramMap);
    String str = com.freelxl.baselibrary.f.a.c.createEncryption("DES").encrypt(com.alibaba.fastjson.a.toJSONString(paramMap), SignKeyUtil.getIvKeyFromC(), SignKeyUtil.getKeyFromC());
    paramMap = h.toMd5(com.alibaba.fastjson.a.toJSONString(paramMap).getBytes());
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", str);
    localHashMap.put("hPtJ39Xs", paramMap);
    return localHashMap;
  }
  
  public static String uploadFile(String paramString1, Map<String, String> paramMap1, Map<String, String> paramMap2, String paramString2, String paramString3)
  {
    String str1 = ad.createFileName();
    String str2 = n.compressAndGenImage(str1, n.getBitmap(paramString3), 2048);
    if (ae.notNull(str2))
    {
      paramString3 = str2;
      paramString2 = str1;
    }
    paramMap2 = signMethod(paramMap2);
    for (;;)
    {
      try
      {
        paramString1 = new StringBuffer(com.ziroom.ziroomcustomer.minsu.b.d.f + paramString1);
        paramString1.append("?");
        paramString1.append("2y5QfvAy");
        paramString1.append("=");
        paramString1.append(((String)paramMap2.get("2y5QfvAy")).toString());
        paramString1.append("&");
        paramString1.append("hPtJ39Xs");
        paramString1.append("=");
        paramString1.append(((String)paramMap2.get("hPtJ39Xs")).toString());
        com.freelxl.baselibrary.f.d.e("lanzhihong", paramString1.toString());
        paramString1 = new URL(paramString1.toString());
        if (!(paramString1 instanceof URL))
        {
          paramString1 = paramString1.openConnection();
          paramString1 = (HttpURLConnection)paramString1;
          paramString1.setDoInput(true);
          paramString1.setDoOutput(true);
          paramString1.setUseCaches(false);
          paramString1.setRequestMethod("POST");
          paramString1.setRequestProperty("Connection", "Keep-Alive");
          paramString1.setRequestProperty("Charset", "UTF-8");
          paramString1.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + "*****");
          if ((paramMap1 == null) || (paramMap1.isEmpty())) {
            break;
          }
          paramMap1 = paramMap1.entrySet().iterator();
          if (!paramMap1.hasNext()) {
            break;
          }
          paramMap2 = (Map.Entry)paramMap1.next();
          paramString1.setRequestProperty((String)paramMap2.getKey(), ((String)paramMap2.getValue()).toString());
          continue;
        }
        paramString1 = HttpInstrumentation.openConnection((URL)paramString1);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
    }
    paramMap1 = new DataOutputStream(paramString1.getOutputStream());
    paramMap1.writeBytes("--" + "*****" + "\r\n");
    paramMap1.writeBytes("Content-Disposition: form-data; name=\"file\";filename=\"" + paramString2 + "\"" + "\r\n");
    paramMap1.writeBytes("\r\n");
    paramMap2 = new FileInputStream(paramString3);
    paramString2 = new byte['Ѐ'];
    int i;
    for (;;)
    {
      i = paramMap2.read(paramString2);
      if (i == -1) {
        break;
      }
      paramMap1.write(paramString2, 0, i);
    }
    paramMap1.writeBytes("\r\n");
    paramMap1.writeBytes("--" + "*****" + "--" + "\r\n");
    paramMap2.close();
    paramMap1.flush();
    paramString1 = paramString1.getInputStream();
    paramMap2 = new StringBuffer();
    for (;;)
    {
      i = paramString1.read();
      if (i == -1) {
        break;
      }
      paramMap2.append((char)i);
    }
    paramMap1.close();
    paramString1 = paramMap2.toString().trim();
    return paramString1;
  }
  
  public static String uploadUserFile(String paramString1, Map<String, String> paramMap1, Map<String, String> paramMap2, String paramString2, String paramString3)
  {
    String str1 = ad.createFileName();
    String str2 = n.compressAndGenImage(str1, n.getBitmap(paramString3), 2048);
    if (ae.notNull(str2))
    {
      paramString3 = str2;
      paramString2 = str1;
    }
    paramMap2 = signMethod(paramMap2);
    for (;;)
    {
      try
      {
        paramString1 = new StringBuffer(com.ziroom.ziroomcustomer.minsu.b.d.f + paramString1);
        paramString1.append("?");
        paramString1.append("2y5QfvAy");
        paramString1.append("=");
        paramString1.append(((String)paramMap2.get("2y5QfvAy")).toString());
        paramString1.append("&");
        paramString1.append("hPtJ39Xs");
        paramString1.append("=");
        paramString1.append(((String)paramMap2.get("hPtJ39Xs")).toString());
        com.freelxl.baselibrary.f.d.e("lanzhihong", paramString1.toString());
        paramString1 = new URL(paramString1.toString());
        if (!(paramString1 instanceof URL))
        {
          paramString1 = paramString1.openConnection();
          paramString1 = (HttpURLConnection)paramString1;
          paramString1.setDoInput(true);
          paramString1.setDoOutput(true);
          paramString1.setUseCaches(false);
          paramString1.setRequestMethod("POST");
          paramString1.setRequestProperty("Connection", "Keep-Alive");
          paramString1.setRequestProperty("Charset", "UTF-8");
          paramString1.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + "*****");
          if ((paramMap1 == null) || (paramMap1.isEmpty())) {
            break;
          }
          paramMap1 = paramMap1.entrySet().iterator();
          if (!paramMap1.hasNext()) {
            break;
          }
          paramMap2 = (Map.Entry)paramMap1.next();
          paramString1.setRequestProperty((String)paramMap2.getKey(), ((String)paramMap2.getValue()).toString());
          continue;
        }
        paramString1 = HttpInstrumentation.openConnection((URL)paramString1);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
    }
    paramMap1 = new DataOutputStream(paramString1.getOutputStream());
    paramMap1.writeBytes("--" + "*****" + "\r\n");
    paramMap1.writeBytes("Content-Disposition: form-data; name=\"file\";filename=\"" + paramString2 + "\"" + "\r\n");
    paramMap1.writeBytes("\r\n");
    paramMap2 = new FileInputStream(paramString3);
    paramString2 = new byte['Ѐ'];
    int i;
    for (;;)
    {
      i = paramMap2.read(paramString2);
      if (i == -1) {
        break;
      }
      paramMap1.write(paramString2, 0, i);
    }
    paramMap1.writeBytes("\r\n");
    paramMap1.writeBytes("--" + "*****" + "--" + "\r\n");
    paramMap2.close();
    paramMap1.flush();
    paramString1 = paramString1.getInputStream();
    paramMap2 = new StringBuffer();
    for (;;)
    {
      i = paramString1.read();
      if (i == -1) {
        break;
      }
      paramMap2.append((char)i);
    }
    paramMap1.close();
    paramString1 = paramMap2.toString().trim();
    return paramString1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */