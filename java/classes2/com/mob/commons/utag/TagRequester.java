package com.mob.commons.utag;

import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.d;
import com.mob.tools.MobLog;
import com.mob.tools.RxMob;
import com.mob.tools.RxMob.QuickSubscribe;
import com.mob.tools.RxMob.Subscribable;
import com.mob.tools.RxMob.Subscriber;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DeviceHelper;
import java.util.HashMap;
import java.util.Map;

public final class TagRequester
  implements PublicMemberKeeper
{
  private static HashMap<String, Object> a;
  private static DeviceHelper b = DeviceHelper.getInstance(MobSDK.getContext());
  private static boolean c;
  private UserTagsResponse d;
  private UserTagError e;
  
  private static HashMap<String, Object> b(HashMap<String, Object> paramHashMap, String paramString)
    throws Throwable
  {
    return (HashMap)new MobCommunicator(1024, "e3e28dce5fe8fc1bb56a25964219d5dc2976edb171b99b1103c2c4f89ad0b66fb58669fe69eb0b5d11e8be990b0715b4de2b4e5a5dcce121f47f18063d5d99f9", "256f461cc45979b52264ac022ff1353ea5f8140d35686ffdae2faee09db2006c3b43c2bb74ce6f4c51698db6384c1c0ceca958208d65c7ed345a04ea6349ca39601818c3d5500565ba49ed49c0f4014b06980d17fc069c95d30092d0cfdaddf783ea96c5f8bdc42b6765d71a5d12192ef74646b41d92f1caeba3123e71938d39").requestSynchronized(paramHashMap, paramString, false);
  }
  
  /* Error */
  private static void d()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 89	com/mob/commons/d:l	()Ljava/util/HashMap;
    //   8: putstatic 91	com/mob/commons/utag/TagRequester:a	Ljava/util/HashMap;
    //   11: getstatic 91	com/mob/commons/utag/TagRequester:a	Ljava/util/HashMap;
    //   14: ifnull +47 -> 61
    //   17: getstatic 91	com/mob/commons/utag/TagRequester:a	Ljava/util/HashMap;
    //   20: ldc 93
    //   22: invokevirtual 97	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   25: ifeq +36 -> 61
    //   28: getstatic 91	com/mob/commons/utag/TagRequester:a	Ljava/util/HashMap;
    //   31: ldc 99
    //   33: invokevirtual 97	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   36: ifeq +25 -> 61
    //   39: getstatic 91	com/mob/commons/utag/TagRequester:a	Ljava/util/HashMap;
    //   42: ldc 101
    //   44: invokevirtual 97	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   47: ifeq +14 -> 61
    //   50: getstatic 91	com/mob/commons/utag/TagRequester:a	Ljava/util/HashMap;
    //   53: ldc 103
    //   55: invokevirtual 97	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   58: ifne +99 -> 157
    //   61: aconst_null
    //   62: invokestatic 106	com/mob/commons/d:a	(Ljava/util/HashMap;)V
    //   65: new 81	java/util/HashMap
    //   68: dup
    //   69: invokespecial 107	java/util/HashMap:<init>	()V
    //   72: putstatic 91	com/mob/commons/utag/TagRequester:a	Ljava/util/HashMap;
    //   75: getstatic 91	com/mob/commons/utag/TagRequester:a	Ljava/util/HashMap;
    //   78: ldc 93
    //   80: ldc 109
    //   82: invokevirtual 113	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: pop
    //   86: getstatic 91	com/mob/commons/utag/TagRequester:a	Ljava/util/HashMap;
    //   89: ldc 99
    //   91: bipush 80
    //   93: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: invokevirtual 113	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   99: pop
    //   100: getstatic 91	com/mob/commons/utag/TagRequester:a	Ljava/util/HashMap;
    //   103: ldc 101
    //   105: sipush 443
    //   108: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: invokevirtual 113	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: pop
    //   115: getstatic 91	com/mob/commons/utag/TagRequester:a	Ljava/util/HashMap;
    //   118: ldc 103
    //   120: ldc 120
    //   122: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: invokevirtual 113	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: iload_0
    //   130: ifeq +23 -> 153
    //   133: getstatic 60	com/mob/commons/utag/TagRequester:c	Z
    //   136: ifne +17 -> 153
    //   139: iconst_1
    //   140: putstatic 60	com/mob/commons/utag/TagRequester:c	Z
    //   143: new 12	com/mob/commons/utag/TagRequester$3
    //   146: dup
    //   147: invokespecial 121	com/mob/commons/utag/TagRequester$3:<init>	()V
    //   150: invokevirtual 124	com/mob/commons/utag/TagRequester$3:start	()V
    //   153: ldc 2
    //   155: monitorexit
    //   156: return
    //   157: invokestatic 129	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   160: astore_2
    //   161: aload_2
    //   162: invokestatic 133	com/mob/commons/d:k	()J
    //   165: invokevirtual 137	java/util/Calendar:setTimeInMillis	(J)V
    //   168: new 139	java/text/SimpleDateFormat
    //   171: dup
    //   172: ldc -115
    //   174: invokespecial 144	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   177: astore_3
    //   178: aload_3
    //   179: aload_2
    //   180: invokevirtual 148	java/util/Calendar:getTime	()Ljava/util/Date;
    //   183: invokevirtual 152	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   186: astore 4
    //   188: aload_2
    //   189: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   192: invokevirtual 137	java/util/Calendar:setTimeInMillis	(J)V
    //   195: aload 4
    //   197: aload_3
    //   198: aload_2
    //   199: invokevirtual 148	java/util/Calendar:getTime	()Ljava/util/Date;
    //   202: invokevirtual 152	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   205: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   208: istore_1
    //   209: iload_1
    //   210: ifeq -81 -> 129
    //   213: iconst_0
    //   214: istore_0
    //   215: goto -86 -> 129
    //   218: astore_2
    //   219: ldc 2
    //   221: monitorexit
    //   222: aload_2
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	214	0	i	int
    //   208	2	1	bool	boolean
    //   160	39	2	localCalendar	java.util.Calendar
    //   218	5	2	localObject	Object
    //   177	21	3	localSimpleDateFormat	java.text.SimpleDateFormat
    //   186	10	4	str	String
    // Exception table:
    //   from	to	target	type
    //   5	61	218	finally
    //   61	129	218	finally
    //   133	153	218	finally
    //   157	209	218	finally
  }
  
  private static HashMap<String, Object> e()
    throws Throwable
  {
    label283:
    for (;;)
    {
      try
      {
        HashMap localHashMap = d.m();
        Object localObject1;
        int i;
        if (localHashMap != null)
        {
          localObject1 = localHashMap;
          if (!localHashMap.isEmpty()) {}
        }
        else
        {
          localObject1 = a.get("defPort");
          if ((localObject1 == null) || (!(localObject1 instanceof Integer))) {
            break label283;
          }
          i = ((Integer)localObject1).intValue();
          if (i > 0) {
            continue;
          }
          localObject1 = "";
          localObject1 = "http://" + a.get("defHost") + (String)localObject1 + "/utag";
          localHashMap = new HashMap();
          localHashMap.put("duid", DeviceAuthorizer.authorize(null));
          localHashMap.put("mac", b.getMacAddress());
          localHashMap.put("imei", b.getIMEI());
          localHashMap.put("serialno", b.getSerialno());
          localHashMap.put("model", b.getModel());
          localHashMap.put("appkey", MobSDK.getAppkey());
          localHashMap.put("apppkg", b.getPackageName());
          localHashMap.put("appver", b.getAppVersionName());
          localHashMap.put("plat", Integer.valueOf(1));
          localObject1 = b(localHashMap, (String)localObject1);
        }
        try
        {
          i = Integer.parseInt(String.valueOf(a.get("tagExpire")));
          d.a((HashMap)localObject1, i);
          return (HashMap<String, Object>)localObject1;
          localObject1 = ":" + i;
        }
        catch (Throwable localThrowable)
        {
          MobLog.getInstance().w(localThrowable);
          i = 0;
          continue;
        }
        Object localObject3 = null;
      }
      finally {}
    }
  }
  
  public void request()
  {
    try
    {
      RxMob.create(new RxMob.QuickSubscribe()
      {
        protected void doNext(RxMob.Subscriber<HashMap<String, Object>> paramAnonymousSubscriber)
          throws Throwable
        {
          TagRequester.a();
          paramAnonymousSubscriber.onNext(TagRequester.b());
        }
      }).subscribeOnNewThreadAndObserveOnUIThread(new RxMob.Subscriber()
      {
        public void a(HashMap<String, Object> paramAnonymousHashMap)
        {
          if (TagRequester.a(TagRequester.this) != null) {
            TagRequester.a(TagRequester.this).onResponse(paramAnonymousHashMap);
          }
        }
        
        public void onError(Throwable paramAnonymousThrowable)
        {
          if (TagRequester.b(TagRequester.this) != null) {
            TagRequester.b(TagRequester.this).onError(paramAnonymousThrowable);
          }
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public TagRequester whenError(UserTagError paramUserTagError)
  {
    this.e = paramUserTagError;
    return this;
  }
  
  public TagRequester whenSuccess(UserTagsResponse paramUserTagsResponse)
  {
    this.d = paramUserTagsResponse;
    return this;
  }
  
  public static abstract interface UserTagsResponse
  {
    public abstract void onResponse(Map<String, Object> paramMap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/utag/TagRequester.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */