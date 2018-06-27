package com.mob.commons.utag;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.a;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.SQLiteHelper;
import com.mob.tools.utils.SQLiteHelper.SingleTableDB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class UserTager
  implements PublicMemberKeeper
{
  private static Handler a;
  private static SQLiteHelper.SingleTableDB b = SQLiteHelper.getDatabase(MobSDK.getContext(), "UserTag_1");
  private static Hashon c;
  private static DeviceHelper d;
  private HashMap<String, Object> e = new HashMap();
  private UserTagError f;
  
  static
  {
    b.addField("time", "text", true);
    b.addField("data", "text", true);
    c = new Hashon();
    d = DeviceHelper.getInstance(MobSDK.getContext());
    a = MobHandlerThread.newHandler("t", new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        }
        do
        {
          return false;
          paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
          UserTager.a((HashMap)paramAnonymousMessage[0], (UserTagError)paramAnonymousMessage[1]);
          UserTager.a();
          return false;
        } while (UserTager.b());
        UserTager.a();
        return false;
      }
    });
    c();
  }
  
  private void a(String paramString, Object paramObject)
  {
    this.e.put(paramString, paramObject);
  }
  
  private static boolean a(ArrayList<HashMap<String, Object>> paramArrayList)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("plat", Integer.valueOf(1));
      localHashMap.put("mac", d.getMacAddress());
      localHashMap.put("duid", DeviceAuthorizer.authorize(null));
      localHashMap.put("model", d.getModel());
      localHashMap.put("imei", d.getIMEI());
      localHashMap.put("serialno", d.getSerialno());
      localHashMap.put("appkey", MobSDK.getAppkey());
      localHashMap.put("apppkg", d.getPackageName());
      localHashMap.put("appver", d.getAppVersionName());
      localHashMap.put("datas", paramArrayList);
      new MobCommunicator(1024, "e3e28dce5fe8fc1bb56a25964219d5dc2976edb171b99b1103c2c4f89ad0b66fb58669fe69eb0b5d11e8be990b0715b4de2b4e5a5dcce121f47f18063d5d99f9", "256f461cc45979b52264ac022ff1353ea5f8140d35686ffdae2faee09db2006c3b43c2bb74ce6f4c51698db6384c1c0ceca958208d65c7ed345a04ea6349ca39601818c3d5500565ba49ed49c0f4014b06980d17fc069c95d30092d0cfdaddf783ea96c5f8bdc42b6765d71a5d12192ef74646b41d92f1caeba3123e71938d39").requestSynchronized(localHashMap, "http://api.utag.mob.com/bdata", false);
      return true;
    }
    catch (Throwable paramArrayList)
    {
      MobLog.getInstance().d(paramArrayList);
    }
    return false;
  }
  
  private static void b(ArrayList<HashMap<String, Object>> paramArrayList)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        HashMap localHashMap = (HashMap)paramArrayList.next();
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append('\'').append(localHashMap.get("___datetime")).append('\'');
      }
      SQLiteHelper.delete(b, "time in (" + localStringBuilder.toString() + ")", null);
    }
    catch (Throwable paramArrayList)
    {
      MobLog.getInstance().w(paramArrayList);
      return;
    }
  }
  
  private static void b(HashMap<String, Object> paramHashMap, UserTagError paramUserTagError)
  {
    Object localObject1 = paramHashMap.entrySet().iterator();
    Object localObject2;
    String str;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      str = (String)((Map.Entry)localObject2).getKey();
      if (str == null) {
        localObject1 = new IllegalArgumentException("found a key of null");
      }
    }
    for (;;)
    {
      label62:
      if (localObject1 != null) {
        if (paramUserTagError != null) {
          paramUserTagError.onError((Throwable)localObject1);
        }
      }
      do
      {
        return;
        if (str.length() > 30)
        {
          localObject1 = new IllegalArgumentException("key '" + str + "' is too long: " + str.length() + " > " + 30);
          break label62;
        }
        localObject2 = ((Map.Entry)localObject2).getValue();
        if ((localObject2 == null) || (!(localObject2 instanceof String))) {
          break;
        }
        localObject2 = (String)localObject2;
        if (((String)localObject2).length() <= 255) {
          break;
        }
        localObject1 = new IllegalArgumentException("value '" + (String)localObject2 + "' is too long: " + ((String)localObject2).length() + " > " + 255);
        break label62;
        try
        {
          long l = a.a();
          paramHashMap.put("___datetime", Long.valueOf(l));
          localObject1 = new ContentValues();
          ((ContentValues)localObject1).put("time", String.valueOf(l));
          ((ContentValues)localObject1).put("data", c.fromHashMap(paramHashMap));
          SQLiteHelper.insert(b, (ContentValues)localObject1);
          return;
        }
        catch (Throwable paramHashMap) {}
      } while (paramUserTagError == null);
      paramUserTagError.onError(paramHashMap);
      return;
      localObject1 = null;
    }
  }
  
  private static void c()
  {
    a.removeMessages(1);
    long l = 10000L;
    String str = d.getNetworkType();
    if ((str == null) || ("none".equals(str))) {
      l = 600000L;
    }
    a.sendEmptyMessageDelayed(1, l);
  }
  
  private static boolean d()
  {
    Object localObject = d.getNetworkType();
    if ((localObject == null) || ("none".equals(localObject))) {}
    do
    {
      do
      {
        return false;
      } while (a.D());
      localObject = e();
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
        break;
      }
    } while (!a((ArrayList)localObject));
    b((ArrayList)localObject);
    if (((ArrayList)localObject).size() == 50) {
      d();
    }
    return true;
  }
  
  private static ArrayList<HashMap<String, Object>> e()
  {
    try
    {
      Cursor localCursor = SQLiteHelper.query(b, new String[] { "data" }, null, null, null);
      if (localCursor == null) {
        return null;
      }
      if (!localCursor.moveToFirst())
      {
        localCursor.close();
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    do
    {
      localArrayList.add(c.fromJson(localThrowable.getString(0)));
    } while ((localArrayList.size() <= 50) && (localThrowable.moveToNext()));
    localThrowable.close();
    return localArrayList;
  }
  
  public void commit()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.e);
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.obj = new Object[] { localHashMap, this.f };
    a.sendMessage(localMessage);
  }
  
  public CustomTag set(String paramString)
  {
    return new CustomTag(this, paramString, null);
  }
  
  public UserTager whenError(UserTagError paramUserTagError)
  {
    this.f = paramUserTagError;
    return this;
  }
  
  public class CustomTag
    implements PublicMemberKeeper
  {
    private UserTager b;
    private String c;
    
    private CustomTag(UserTager paramUserTager, String paramString)
    {
      this.b = paramUserTager;
      this.c = paramString;
    }
    
    private UserTager a(Object paramObject)
    {
      UserTager.a(this.b, this.c, paramObject);
      return this.b;
    }
    
    public UserTager withValue(Boolean paramBoolean)
    {
      return a(paramBoolean);
    }
    
    public UserTager withValue(Number paramNumber)
    {
      return a(paramNumber);
    }
    
    public UserTager withValue(String paramString)
    {
      return a(paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/utag/UserTager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */