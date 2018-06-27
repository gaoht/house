package com.mob.commons.filesys;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.MobProduct;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FileUploader
  implements PublicMemberKeeper
{
  private static String a = "http://up.sdk.mob.com";
  
  private static String a()
  {
    return a + "/image";
  }
  
  private static String a(MobProduct paramMobProduct)
    throws Throwable
  {
    Object localObject = new NetworkHelper();
    paramMobProduct = a(paramMobProduct, "1234567890abcdeffedcba0987654321");
    NetworkHelper.NetworkTimeOut localNetworkTimeOut = new NetworkHelper.NetworkTimeOut();
    localNetworkTimeOut.readTimout = 30000;
    localNetworkTimeOut.connectionTimeout = 5000;
    paramMobProduct = ((NetworkHelper)localObject).httpPost(f(), null, null, paramMobProduct, localNetworkTimeOut);
    localObject = new Hashon().fromJson(paramMobProduct);
    if ((localObject != null) && ("200".equals(String.valueOf(((HashMap)localObject).get("status"))))) {
      try
      {
        localObject = (String)((HashMap)((HashMap)localObject).get("res")).get("token");
        return (String)localObject;
      }
      catch (Throwable localThrowable)
      {
        throw new Throwable(paramMobProduct, localThrowable);
      }
    }
    throw new Throwable(paramMobProduct);
  }
  
  private static Throwable a(long paramLong1, long paramLong2)
  {
    return new Throwable("{\"status\": ,\"error\":\"max size: " + paramLong2 + ", file size: " + paramLong1 + "\"}");
  }
  
  private static ArrayList<KVPair<String>> a(MobProduct paramMobProduct, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("sign", Data.MD5(paramString + MobSDK.getAppSecret())));
    localArrayList.add(new KVPair("key", MobSDK.getAppkey()));
    localArrayList.add(new KVPair("token", paramString));
    localArrayList.add(new KVPair("product", paramMobProduct.getProductTag()));
    localArrayList.add(new KVPair("cliid", DeviceAuthorizer.authorize(paramMobProduct)));
    return localArrayList;
  }
  
  private static HashMap<String, Object> a(MobProduct paramMobProduct, String paramString1, HashMap<String, Object> paramHashMap, String paramString2, long paramLong)
    throws Throwable
  {
    Object localObject = new File(paramString1);
    if (((File)localObject).length() > paramLong) {
      throw a(((File)localObject).length(), paramLong);
    }
    localObject = new NetworkHelper();
    paramMobProduct = a(paramMobProduct, a(paramMobProduct));
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new KVPair(str, String.valueOf(paramHashMap.get(str))));
    }
    paramString1 = new KVPair("file", paramString1);
    paramHashMap = new NetworkHelper.NetworkTimeOut();
    paramHashMap.readTimout = 30000;
    paramHashMap.connectionTimeout = 5000;
    paramMobProduct = ((NetworkHelper)localObject).httpPost(paramString2, localArrayList, paramString1, paramMobProduct, paramHashMap);
    paramString1 = new Hashon().fromJson(paramMobProduct);
    if ((paramString1 != null) && ("200".equals(String.valueOf(paramString1.get("status"))))) {
      return (HashMap)paramString1.get("res");
    }
    throw new Throwable(paramMobProduct);
  }
  
  private static HashMap<String, Object> a(MobProduct paramMobProduct, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
    throws Throwable
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localHashMap.put("sm", Integer.valueOf(i));
      if (!TextUtils.isEmpty(paramString2)) {
        localHashMap.put("zoomScaleWidths", paramString2);
      }
      return a(paramMobProduct, paramString1, localHashMap, paramString3, 10485760L);
    }
  }
  
  private static String b()
  {
    return a + "/avatar";
  }
  
  private static String c()
  {
    return a + "/video";
  }
  
  private static String d()
  {
    return a + "/audio";
  }
  
  private static String e()
  {
    return a + "/file";
  }
  
  private static String f()
  {
    return a + "/getToken";
  }
  
  public static void setUploadServer(String paramString)
  {
    String str = paramString;
    if (paramString.endsWith("/")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    a = str;
  }
  
  public static UploadedAudio uploadAudio(MobProduct paramMobProduct, String paramString, boolean paramBoolean)
    throws Throwable
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localHashMap.put("sm", Integer.valueOf(i));
      return new UploadedAudio(a(paramMobProduct, paramString, localHashMap, d(), 209715200L));
    }
  }
  
  public static UploadedAvatar uploadAvatar(MobProduct paramMobProduct, String paramString)
    throws Throwable
  {
    return uploadAvatar(paramMobProduct, paramString, false, new int[0]);
  }
  
  public static UploadedAvatar uploadAvatar(MobProduct paramMobProduct, String paramString, boolean paramBoolean, int... paramVarArgs)
    throws Throwable
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVarArgs != null)
    {
      localObject1 = localObject2;
      if (paramVarArgs.length > 0)
      {
        String str = "";
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          int k = paramVarArgs[i];
          str = str + "," + k;
          i += 1;
        }
        localObject1 = localObject2;
        if (str.length() > 0) {
          localObject1 = str.substring(1);
        }
      }
    }
    return new UploadedAvatar(a(paramMobProduct, paramString, paramBoolean, (String)localObject1, b()));
  }
  
  public static UploadedFile uploadFile(MobProduct paramMobProduct, String paramString, boolean paramBoolean)
    throws Throwable
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localHashMap.put("sm", Integer.valueOf(i));
      return new UploadedFile(a(paramMobProduct, paramString, localHashMap, e(), 52428800L));
    }
  }
  
  public static UploadedImage uploadImage(MobProduct paramMobProduct, String paramString)
    throws Throwable
  {
    return uploadImage(paramMobProduct, paramString, false, new int[0]);
  }
  
  public static UploadedImage uploadImage(MobProduct paramMobProduct, String paramString, boolean paramBoolean, int... paramVarArgs)
    throws Throwable
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVarArgs != null)
    {
      localObject1 = localObject2;
      if (paramVarArgs.length > 0)
      {
        String str = "";
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          int k = paramVarArgs[i];
          str = str + "," + k;
          i += 1;
        }
        localObject1 = localObject2;
        if (str.length() > 0) {
          localObject1 = str.substring(1);
        }
      }
    }
    return new UploadedImage(a(paramMobProduct, paramString, paramBoolean, (String)localObject1, a()));
  }
  
  public static UploadedVideo uploadVideo(MobProduct paramMobProduct, String paramString, boolean paramBoolean)
    throws Throwable
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localHashMap.put("sm", Integer.valueOf(i));
      return new UploadedVideo(a(paramMobProduct, paramString, localHashMap, c(), 209715200L));
    }
  }
  
  public static class UploadedAudio
    extends FileUploader.UploadedFile
  {
    public final int durationUSec;
    
    public UploadedAudio(HashMap<String, Object> paramHashMap)
    {
      super();
      int i = -1;
      try
      {
        int j = Integer.parseInt(String.valueOf(paramHashMap.get("time")));
        i = j;
      }
      catch (Throwable paramHashMap)
      {
        for (;;) {}
      }
      this.durationUSec = i;
    }
  }
  
  public static class UploadedAvatar
    extends FileUploader.UploadedImage
  {
    public UploadedAvatar(HashMap<String, Object> paramHashMap)
    {
      super();
    }
  }
  
  public static class UploadedFile
    implements PublicMemberKeeper
  {
    public final String id;
    public final String url;
    
    public UploadedFile(HashMap<String, Object> paramHashMap)
    {
      if (paramHashMap.containsKey("src")) {}
      for (this.url = ((String)paramHashMap.get("src")); paramHashMap.containsKey("id"); this.url = null)
      {
        this.id = ((String)paramHashMap.get("id"));
        return;
      }
      this.id = null;
    }
  }
  
  public static class UploadedImage
    extends FileUploader.UploadedFile
  {
    public final HashMap<String, String> zoomList;
    
    public UploadedImage(HashMap<String, Object> paramHashMap)
    {
      super();
      try
      {
        paramHashMap = (HashMap)paramHashMap.get("list");
        this.zoomList = paramHashMap;
        return;
      }
      catch (Throwable paramHashMap)
      {
        for (;;)
        {
          paramHashMap = null;
        }
      }
    }
  }
  
  public static class UploadedVideo
    extends FileUploader.UploadedFile
  {
    public final int durationUSec;
    public final int height;
    public final int width;
    
    public UploadedVideo(HashMap<String, Object> paramHashMap)
    {
      super();
      try
      {
        j = Integer.parseInt(String.valueOf(paramHashMap.get("time")));
      }
      catch (Throwable paramHashMap)
      {
        for (;;)
        {
          int m;
          label52:
          i = -1;
          int j = -1;
        }
      }
      try
      {
        i = Integer.parseInt(String.valueOf(paramHashMap.get("height")));
      }
      catch (Throwable paramHashMap)
      {
        i = -1;
        break label52;
      }
      try
      {
        m = Integer.parseInt(String.valueOf(paramHashMap.get("width")));
        k = m;
      }
      catch (Throwable paramHashMap)
      {
        break label52;
      }
      this.durationUSec = j;
      this.width = k;
      this.height = i;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/filesys/FileUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */