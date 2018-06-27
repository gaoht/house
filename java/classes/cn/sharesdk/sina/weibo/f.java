package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class f
  extends cn.sharesdk.framework.b
{
  private static f b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String[] g = { "follow_app_official_microblog" };
  private cn.sharesdk.framework.a.a h = cn.sharesdk.framework.a.a.a();
  
  private f(Platform paramPlatform)
  {
    super(paramPlatform);
  }
  
  public static f a(Platform paramPlatform)
  {
    try
    {
      if (b == null) {
        b = new f(paramPlatform);
      }
      paramPlatform = b;
      return paramPlatform;
    }
    finally {}
  }
  
  private void a(AuthorizeListener paramAuthorizeListener)
  {
    d locald = new d();
    locald.a(this.c, this.e, this.f);
    locald.a(paramAuthorizeListener);
    locald.show(MobSDK.getContext(), null);
  }
  
  public HashMap<String, Object> a(int paramInt1, int paramInt2, String paramString)
    throws Throwable
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("source", this.c));
    int i = 1;
    try
    {
      ResHelper.parseLong(paramString);
      if (i != 0)
      {
        localArrayList.add(new KVPair("uid", paramString));
        localArrayList.add(new KVPair("count", String.valueOf(paramInt1)));
        localArrayList.add(new KVPair("page", String.valueOf(paramInt2)));
        paramString = this.h.a("https://api.weibo.com/2/statuses/user_timeline.json", localArrayList, "/2/statuses/user_timeline.json", c());
        if (paramString == null) {
          break label156;
        }
        return new Hashon().fromJson(paramString);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i = 0;
        continue;
        localArrayList.add(new KVPair("screen_name", paramString));
      }
    }
    label156:
    return null;
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (paramString2 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        localArrayList.add(new KVPair((String)localEntry.getKey(), String.valueOf(localEntry.getValue())));
      }
    }
    localArrayList.add(new KVPair("source", this.c));
    if (this.f != null) {
      localArrayList.add(new KVPair("access_token", this.f));
    }
    if ((paramHashMap1 != null) && (paramHashMap1.size() > 0))
    {
      paramHashMap1 = paramHashMap1.entrySet().iterator();
      for (paramHashMap = null; paramHashMap1.hasNext(); paramHashMap = new KVPair((String)paramHashMap.getKey(), paramHashMap.getValue())) {
        paramHashMap = (Map.Entry)paramHashMap1.next();
      }
    }
    for (;;)
    {
      try
      {
        if ("GET".equals(paramString2.toUpperCase()))
        {
          paramString1 = new NetworkHelper().httpGet(paramString1, localArrayList, null, null);
          if ((paramString1 == null) || (paramString1.length() <= 0)) {
            break;
          }
          return new Hashon().fromJson(paramString1);
        }
        if ("POST".equals(paramString2.toUpperCase()))
        {
          paramString1 = new NetworkHelper().httpPost(paramString1, localArrayList, paramHashMap, null, null);
          continue;
        }
      }
      catch (Throwable paramString1)
      {
        cn.sharesdk.framework.utils.e.b().d(paramString1);
        paramString1 = null;
        continue;
      }
      paramHashMap = null;
    }
  }
  
  /* Error */
  public void a(final Platform.ShareParams paramShareParams, final PlatformActionListener paramPlatformActionListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 218	cn/sharesdk/framework/Platform$ShareParams:getImageData	()Landroid/graphics/Bitmap;
    //   4: ifnonnull +59 -> 63
    //   7: aload_1
    //   8: invokevirtual 221	cn/sharesdk/framework/Platform$ShareParams:getImagePath	()Ljava/lang/String;
    //   11: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +49 -> 63
    //   17: aload_1
    //   18: invokevirtual 230	cn/sharesdk/framework/Platform$ShareParams:getImageUrl	()Ljava/lang/String;
    //   21: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +39 -> 63
    //   27: new 232	java/io/File
    //   30: dup
    //   31: invokestatic 72	com/mob/MobSDK:getContext	()Landroid/content/Context;
    //   34: aload_1
    //   35: invokevirtual 230	cn/sharesdk/framework/Platform$ShareParams:getImageUrl	()Ljava/lang/String;
    //   38: invokestatic 238	com/mob/tools/utils/BitmapHelper:downloadBitmap	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   41: invokespecial 241	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 4
    //   46: aload 4
    //   48: invokevirtual 244	java/io/File:exists	()Z
    //   51: ifeq +12 -> 63
    //   54: aload_1
    //   55: aload 4
    //   57: invokevirtual 247	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: invokevirtual 250	cn/sharesdk/framework/Platform$ShareParams:setImagePath	(Ljava/lang/String;)V
    //   63: aload_1
    //   64: invokevirtual 254	cn/sharesdk/framework/Platform$ShareParams:getImageArray	()[Ljava/lang/String;
    //   67: ifnull +237 -> 304
    //   70: aload_1
    //   71: invokevirtual 254	cn/sharesdk/framework/Platform$ShareParams:getImageArray	()[Ljava/lang/String;
    //   74: arraylength
    //   75: ifle +229 -> 304
    //   78: aload_1
    //   79: invokevirtual 254	cn/sharesdk/framework/Platform$ShareParams:getImageArray	()[Ljava/lang/String;
    //   82: invokestatic 260	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   85: astore 4
    //   87: aload 4
    //   89: invokeinterface 263 1 0
    //   94: anewarray 27	java/lang/String
    //   97: astore 6
    //   99: aload 4
    //   101: invokeinterface 264 1 0
    //   106: astore 7
    //   108: iconst_0
    //   109: istore_3
    //   110: aload 7
    //   112: invokeinterface 158 1 0
    //   117: ifeq +181 -> 298
    //   120: aload 7
    //   122: invokeinterface 162 1 0
    //   127: checkcast 27	java/lang/String
    //   130: astore 5
    //   132: aload 5
    //   134: astore 4
    //   136: aload 5
    //   138: ldc_w 266
    //   141: invokevirtual 270	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   144: ifeq +13 -> 157
    //   147: invokestatic 72	com/mob/MobSDK:getContext	()Landroid/content/Context;
    //   150: aload 5
    //   152: invokestatic 238	com/mob/tools/utils/BitmapHelper:downloadBitmap	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 4
    //   157: new 232	java/io/File
    //   160: dup
    //   161: aload 4
    //   163: invokespecial 241	java/io/File:<init>	(Ljava/lang/String;)V
    //   166: astore 8
    //   168: aload 4
    //   170: astore 5
    //   172: aload 8
    //   174: invokevirtual 244	java/io/File:exists	()Z
    //   177: ifeq +94 -> 271
    //   180: aload 4
    //   182: astore 5
    //   184: aload 4
    //   186: ldc_w 272
    //   189: invokevirtual 270	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   192: ifeq +79 -> 271
    //   195: new 232	java/io/File
    //   198: dup
    //   199: invokestatic 72	com/mob/MobSDK:getContext	()Landroid/content/Context;
    //   202: ldc_w 274
    //   205: invokestatic 277	com/mob/tools/utils/ResHelper:getCachePath	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   208: new 279	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   215: invokestatic 286	java/lang/System:currentTimeMillis	()J
    //   218: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: aload 8
    //   223: invokevirtual 293	java/io/File:getName	()Ljava/lang/String;
    //   226: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokespecial 302	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: astore 8
    //   237: aload 8
    //   239: invokevirtual 247	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   242: astore 9
    //   244: aload 8
    //   246: invokevirtual 305	java/io/File:createNewFile	()Z
    //   249: pop
    //   250: aload 4
    //   252: astore 5
    //   254: aload 4
    //   256: aload 9
    //   258: invokestatic 309	com/mob/tools/utils/ResHelper:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   261: ifeq +10 -> 271
    //   264: aload 8
    //   266: invokevirtual 247	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   269: astore 5
    //   271: aload 6
    //   273: iload_3
    //   274: aload 5
    //   276: aastore
    //   277: iload_3
    //   278: iconst_1
    //   279: iadd
    //   280: istore_3
    //   281: goto -171 -> 110
    //   284: astore 4
    //   286: invokestatic 205	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   289: aload 4
    //   291: invokevirtual 210	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   294: pop
    //   295: goto -232 -> 63
    //   298: aload_1
    //   299: aload 6
    //   301: invokevirtual 313	cn/sharesdk/framework/Platform$ShareParams:setImageArray	([Ljava/lang/String;)V
    //   304: aload_1
    //   305: invokevirtual 316	cn/sharesdk/framework/Platform$ShareParams:getText	()Ljava/lang/String;
    //   308: astore 4
    //   310: aload 4
    //   312: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   315: ifne +17 -> 332
    //   318: aload_1
    //   319: aload_0
    //   320: invokevirtual 320	cn/sharesdk/sina/weibo/f:getPlatform	()Lcn/sharesdk/framework/Platform;
    //   323: aload 4
    //   325: iconst_0
    //   326: invokevirtual 326	cn/sharesdk/framework/Platform:getShortLintk	(Ljava/lang/String;Z)Ljava/lang/String;
    //   329: invokevirtual 329	cn/sharesdk/framework/Platform$ShareParams:setText	(Ljava/lang/String;)V
    //   332: new 8	cn/sharesdk/sina/weibo/f$2
    //   335: dup
    //   336: aload_0
    //   337: aload_2
    //   338: aload_1
    //   339: invokespecial 332	cn/sharesdk/sina/weibo/f$2:<init>	(Lcn/sharesdk/sina/weibo/f;Lcn/sharesdk/framework/PlatformActionListener;Lcn/sharesdk/framework/Platform$ShareParams;)V
    //   342: astore_2
    //   343: new 334	cn/sharesdk/sina/weibo/a
    //   346: dup
    //   347: invokespecial 335	cn/sharesdk/sina/weibo/a:<init>	()V
    //   350: astore 4
    //   352: aload 4
    //   354: aload_0
    //   355: getfield 59	cn/sharesdk/sina/weibo/f:c	Ljava/lang/String;
    //   358: invokevirtual 337	cn/sharesdk/sina/weibo/a:a	(Ljava/lang/String;)V
    //   361: aload 4
    //   363: aload_1
    //   364: invokevirtual 340	cn/sharesdk/sina/weibo/a:a	(Lcn/sharesdk/framework/Platform$ShareParams;)V
    //   367: aload 4
    //   369: aload_2
    //   370: invokevirtual 341	cn/sharesdk/sina/weibo/a:a	(Lcn/sharesdk/framework/authorize/AuthorizeListener;)V
    //   373: aload 4
    //   375: invokestatic 72	com/mob/MobSDK:getContext	()Landroid/content/Context;
    //   378: aconst_null
    //   379: invokevirtual 342	cn/sharesdk/sina/weibo/a:show	(Landroid/content/Context;Landroid/content/Intent;)V
    //   382: return
    //   383: astore 4
    //   385: invokestatic 205	cn/sharesdk/framework/utils/e:b	()Lcom/mob/tools/log/NLog;
    //   388: aload 4
    //   390: invokevirtual 210	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   393: pop
    //   394: goto -90 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	f
    //   0	397	1	paramShareParams	Platform.ShareParams
    //   0	397	2	paramPlatformActionListener	PlatformActionListener
    //   109	172	3	i	int
    //   44	211	4	localObject1	Object
    //   284	6	4	localThrowable1	Throwable
    //   308	66	4	localObject2	Object
    //   383	6	4	localThrowable2	Throwable
    //   130	145	5	localObject3	Object
    //   97	203	6	arrayOfString	String[]
    //   106	15	7	localIterator	Iterator
    //   166	99	8	localFile	java.io.File
    //   242	15	9	str	String
    // Exception table:
    //   from	to	target	type
    //   27	63	284	java/lang/Throwable
    //   78	108	383	java/lang/Throwable
    //   110	132	383	java/lang/Throwable
    //   136	157	383	java/lang/Throwable
    //   157	168	383	java/lang/Throwable
    //   172	180	383	java/lang/Throwable
    //   184	250	383	java/lang/Throwable
    //   254	271	383	java/lang/Throwable
    //   298	304	383	java/lang/Throwable
  }
  
  public void a(final AuthorizeListener paramAuthorizeListener, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramAuthorizeListener);
      return;
    }
    a(new SSOListener()
    {
      public void onCancel()
      {
        paramAuthorizeListener.onCancel();
      }
      
      public void onComplete(Bundle paramAnonymousBundle)
      {
        try
        {
          ResHelper.parseLong(paramAnonymousBundle.getString("expires_in"));
          paramAuthorizeListener.onComplete(paramAnonymousBundle);
          return;
        }
        catch (Throwable paramAnonymousBundle)
        {
          onFailed(paramAnonymousBundle);
        }
      }
      
      public void onFailed(Throwable paramAnonymousThrowable)
      {
        cn.sharesdk.framework.utils.e.b().d(paramAnonymousThrowable);
        f.a(f.this, paramAuthorizeListener);
      }
    });
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public void a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      this.g = paramArrayOfString;
    }
  }
  
  public boolean a()
  {
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new KVPair("client_id", this.c));
    ((ArrayList)localObject1).add(new KVPair("client_secret", this.d));
    ((ArrayList)localObject1).add(new KVPair("redirect_uri", this.e));
    ((ArrayList)localObject1).add(new KVPair("grant_type", "refresh_token"));
    ((ArrayList)localObject1).add(new KVPair("refresh_token", this.a.getDb().get("refresh_token")));
    try
    {
      localObject1 = this.h.b("https://api.weibo.com/oauth2/access_token", (ArrayList)localObject1, "/oauth2/access_token", c());
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return false;
      }
      if ((!((String)localObject1).contains("error")) && (!((String)localObject1).contains("error_code")))
      {
        Object localObject2 = new Hashon().fromJson((String)localObject1);
        localObject1 = String.valueOf(((HashMap)localObject2).get("uid"));
        String str1 = String.valueOf(((HashMap)localObject2).get("expires_in"));
        this.f = String.valueOf(((HashMap)localObject2).get("access_token"));
        String str2 = String.valueOf(((HashMap)localObject2).get("refresh_token"));
        localObject2 = String.valueOf(((HashMap)localObject2).get("remind_in"));
        this.a.getDb().putUserId((String)localObject1);
        this.a.getDb().putExpiresIn(Long.valueOf(str1).longValue());
        this.a.getDb().putToken(this.f);
        this.a.getDb().put("refresh_token", str2);
        this.a.getDb().put("remind_in", (String)localObject2);
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.b().d(localThrowable);
    }
    return false;
  }
  
  public String b(String paramString)
    throws Throwable
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("client_id", this.c));
    localArrayList.add(new KVPair("client_secret", this.d));
    localArrayList.add(new KVPair("redirect_uri", this.e));
    localArrayList.add(new KVPair("grant_type", "authorization_code"));
    localArrayList.add(new KVPair("code", paramString));
    paramString = this.h.b("https://api.weibo.com/oauth2/access_token", localArrayList, "/oauth2/access_token", c());
    ShareSDK.logApiEvent("/oauth2/access_token", c());
    return paramString;
  }
  
  public HashMap<String, Object> b(int paramInt1, int paramInt2, String paramString)
    throws Throwable
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("source", this.c));
    if (this.f != null) {
      localArrayList.add(new KVPair("access_token", this.f));
    }
    int i = 1;
    try
    {
      ResHelper.parseLong(paramString);
      if (i != 0)
      {
        localArrayList.add(new KVPair("uid", paramString));
        localArrayList.add(new KVPair("count", String.valueOf(paramInt1)));
        localArrayList.add(new KVPair("cursor", String.valueOf(paramInt2)));
        paramString = this.h.a("https://api.weibo.com/2/friendships/friends.json", localArrayList, "/2/friendships/friends.json", c());
        if (paramString == null) {
          break label185;
        }
        return new Hashon().fromJson(paramString);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i = 0;
        continue;
        localArrayList.add(new KVPair("screen_name", paramString));
      }
    }
    label185:
    return null;
  }
  
  public void b(final Platform.ShareParams paramShareParams, final PlatformActionListener paramPlatformActionListener)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramShareParams.getUrl()))
    {
      localObject = paramShareParams.getText();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label128;
      }
      paramShareParams.setText(this.a.getShortLintk((String)localObject, false));
    }
    for (;;)
    {
      paramPlatformActionListener = new AuthorizeListener()
      {
        public void onCancel()
        {
          if (paramPlatformActionListener != null) {
            paramPlatformActionListener.onCancel(f.j(f.this), 9);
          }
        }
        
        public void onComplete(Bundle paramAnonymousBundle)
        {
          Object localObject;
          if (paramPlatformActionListener != null)
          {
            localObject = new HashMap();
            ((HashMap)localObject).put("ShareParams", paramShareParams);
            paramPlatformActionListener.onComplete(f.e(f.this), 9, (HashMap)localObject);
          }
          if (paramAnonymousBundle != null)
          {
            localObject = paramAnonymousBundle.getString("uid");
            String str = paramAnonymousBundle.getString("access_token");
            paramAnonymousBundle = paramAnonymousBundle.getString("expire_in");
            if (!TextUtils.isEmpty(str))
            {
              f.a(f.this, str);
              f.g(f.this).getDb().putToken(f.f(f.this));
            }
            f.h(f.this).getDb().putUserId((String)localObject);
          }
          try
          {
            long l = ResHelper.parseLong(paramAnonymousBundle);
            f.i(f.this).getDb().putExpiresIn(l);
            return;
          }
          catch (Throwable paramAnonymousBundle) {}
        }
        
        public void onError(Throwable paramAnonymousThrowable)
        {
          if (paramPlatformActionListener != null) {
            paramPlatformActionListener.onError(f.d(f.this), 9, paramAnonymousThrowable);
          }
        }
      };
      localObject = new e();
      ((e)localObject).a(this.c, this.f);
      ((e)localObject).a(paramShareParams);
      ((e)localObject).a(paramPlatformActionListener);
      ((e)localObject).show(MobSDK.getContext(), null);
      return;
      localObject = paramShareParams.getText() + " " + paramShareParams.getUrl();
      break;
      label128:
      int i = ResHelper.getStringRes(MobSDK.getContext(), "ssdk_weibo_upload_content");
      if (i > 0) {
        paramShareParams.setText(MobSDK.getContext().getResources().getString(i));
      }
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    Object localObject = new Intent("android.intent.action.SEND");
    ((Intent)localObject).setPackage("com.sina.weibo");
    ((Intent)localObject).setType("image/*");
    ResolveInfo localResolveInfo = MobSDK.getContext().getPackageManager().resolveActivity((Intent)localObject, 0);
    localObject = localResolveInfo;
    if (localResolveInfo == null)
    {
      localObject = new Intent("android.intent.action.SEND");
      ((Intent)localObject).setPackage("com.sina.weibog3");
      ((Intent)localObject).setType("image/*");
      localObject = MobSDK.getContext().getPackageManager().resolveActivity((Intent)localObject, 0);
    }
    if (localObject != null) {
      bool = true;
    }
    return bool;
  }
  
  public HashMap<String, Object> c(int paramInt1, int paramInt2, String paramString)
    throws Throwable
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("source", this.c));
    if (this.f != null) {
      localArrayList.add(new KVPair("access_token", this.f));
    }
    int i = 1;
    try
    {
      ResHelper.parseLong(paramString);
      if (i != 0)
      {
        localArrayList.add(new KVPair("uid", paramString));
        localArrayList.add(new KVPair("count", String.valueOf(paramInt1)));
        localArrayList.add(new KVPair("page", String.valueOf(paramInt2)));
        paramString = this.h.a("https://api.weibo.com/2/friendships/friends/bilateral.json", localArrayList, "/2/friendships/friends/bilateral.json", c());
        if (paramString == null) {
          break label184;
        }
        return new Hashon().fromJson(paramString);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i = 0;
        continue;
        localArrayList.add(new KVPair("screen_name", paramString));
      }
    }
    label184:
    return null;
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public HashMap<String, Object> d(int paramInt1, int paramInt2, String paramString)
    throws Throwable
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("source", this.c));
    if (this.f != null) {
      localArrayList.add(new KVPair("access_token", this.f));
    }
    int i = 1;
    try
    {
      ResHelper.parseLong(paramString);
      if (i != 0)
      {
        localArrayList.add(new KVPair("uid", paramString));
        localArrayList.add(new KVPair("count", String.valueOf(paramInt1)));
        localArrayList.add(new KVPair("cursor", String.valueOf(paramInt2)));
        paramString = this.h.a("https://api.weibo.com/2/friendships/followers.json", localArrayList, "/2/friendships/followers.json", c());
        if (paramString == null) {
          break label185;
        }
        return new Hashon().fromJson(paramString);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i = 0;
        continue;
        localArrayList.add(new KVPair("screen_name", paramString));
      }
    }
    label185:
    return null;
  }
  
  public HashMap<String, Object> d(String paramString)
    throws Throwable
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("source", this.c));
    if (this.f != null) {
      localArrayList.add(new KVPair("access_token", this.f));
    }
    int i = 1;
    try
    {
      ResHelper.parseLong(paramString);
      if (i != 0)
      {
        localArrayList.add(new KVPair("uid", paramString));
        paramString = this.h.a("https://api.weibo.com/2/users/show.json", localArrayList, "/2/users/show.json", c());
        if (paramString == null) {
          break label137;
        }
        return new Hashon().fromJson(paramString);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i = 0;
        continue;
        localArrayList.add(new KVPair("screen_name", paramString));
      }
    }
    label137:
    return null;
  }
  
  public boolean d()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.sina.weibo.sdk.Intent.ACTION_WEIBO_REGISTER");
    String str = MobSDK.getContext().getPackageName();
    localIntent.putExtra("_weibo_sdkVersion", "0031405000");
    localIntent.putExtra("_weibo_appPackage", str);
    localIntent.putExtra("_weibo_appKey", this.c);
    localIntent.putExtra("_weibo_flag", 538116905);
    localIntent.putExtra("_weibo_sign", cn.sharesdk.sina.weibo.sdk.a.a(MobSDK.getContext(), str));
    cn.sharesdk.framework.utils.e.b().d("intent=" + localIntent + ", extra=" + localIntent.getExtras(), new Object[0]);
    MobSDK.getContext().sendBroadcast(localIntent, "com.sina.weibo.permission.WEIBO_SDK_PERMISSION");
    return true;
  }
  
  public HashMap<String, Object> e(String paramString)
    throws Throwable
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("source", this.c));
    localArrayList.add(new KVPair("access_token", this.f));
    int i = 1;
    try
    {
      ResHelper.parseLong(paramString);
      if (i != 0)
      {
        localArrayList.add(new KVPair("uid", paramString));
        paramString = this.h.b("https://api.weibo.com/2/friendships/create.json", localArrayList, "/2/friendships/create.json", c());
        if (paramString == null) {
          break label130;
        }
        return new Hashon().fromJson(paramString);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i = 0;
        continue;
        localArrayList.add(new KVPair("screen_name", paramString));
      }
    }
    label130:
    return null;
  }
  
  public String getAuthorizeUrl()
  {
    return "";
  }
  
  public cn.sharesdk.framework.authorize.b getAuthorizeWebviewClient(cn.sharesdk.framework.authorize.e parame)
  {
    return new b(parame);
  }
  
  public String getRedirectUri()
  {
    if (TextUtils.isEmpty(this.e)) {
      return "https://api.weibo.com/oauth2/default.html";
    }
    return this.e;
  }
  
  public cn.sharesdk.framework.authorize.d getSSOProcessor(cn.sharesdk.framework.authorize.c paramc)
  {
    paramc = new c(paramc);
    paramc.a(32973);
    paramc.a(this.c, this.e, this.g);
    return paramc;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/sina/weibo/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */