package cn.jiguang.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.jiguang.c.f.a.a;
import cn.jiguang.d.d;

public abstract class BasePreferenceManager
{
  private static final String AES_ENCRYPTION_SEED;
  private static final String JPUSH_PREF;
  private static SharedPreferences mSharedPreferences;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[2];
    int m = 0;
    Object localObject1 = arrayOfString;
    Object localObject2 = "2U[z#$H\035>##^\023u!4U\026u MG";
    int i = 1;
    int j;
    int k;
    Object localObject4;
    int n;
    int i1;
    for (;;)
    {
      localObject2 = ((String)localObject2).toCharArray();
      j = localObject2.length;
      if (j > 1) {
        break label311;
      }
      k = 0;
      localObject4 = localObject1;
      n = m;
      localObject1 = localObject2;
      i1 = i;
      label50:
      m = k;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 83;
          label99:
          localObject2[k] = ((char)(i ^ i2));
          m += 1;
          if (j != 0) {
            break label163;
          }
          k = j;
        }
      }
      JPUSH_PREF = (String)localObject1;
      localObject2 = "\025}4(g\023\nERd\020x1Tad";
      i = 2;
      m = i2;
      localObject1 = localObject3;
      continue;
      AES_ENCRYPTION_SEED = (String)localObject1;
      localObject2 = "\004U\020h#4X\001u7q\026Uv28W\020ts%TUQ\026\002\033\020~0#B\005d}";
      i = -1;
      m = i2;
      localObject1 = localObject3;
    }
    label163:
    i = j;
    Object localObject3 = localObject4;
    int i2 = n;
    localObject2 = localObject1;
    int i3 = i1;
    for (;;)
    {
      i1 = i3;
      localObject1 = localObject2;
      n = i2;
      localObject4 = localObject3;
      j = i;
      k = m;
      if (i > m) {
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      case 1: 
      case 2: 
      default: 
        localObject3[i2] = localObject1;
        localObject2 = "\004U\020h#4X\001u7q\026Uv28W\020ts%TUQ\026\002\033\021u0#B\005d}";
        m = 1;
        localObject1 = arrayOfString;
        i = 0;
        break;
      case 0: 
        localObject3[i2] = localObject1;
        z = arrayOfString;
        mSharedPreferences = null;
        return;
        i = 81;
        break label99;
        i = 59;
        break label99;
        i = 117;
        break label99;
        i = 16;
        break label99;
        label311:
        k = 0;
        i3 = i;
        i2 = m;
        localObject3 = localObject1;
        i = j;
        m = k;
      }
    }
  }
  
  protected static void commitBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    init(paramContext);
    paramContext = mSharedPreferences.edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.apply();
  }
  
  protected static void commitBoolean(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = mSharedPreferences.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.apply();
  }
  
  protected static void commitInt(Context paramContext, String paramString, int paramInt)
  {
    init(paramContext);
    paramContext = mSharedPreferences.edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.apply();
  }
  
  protected static void commitInt(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = mSharedPreferences.edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.apply();
  }
  
  protected static void commitLong(Context paramContext, String paramString, long paramLong)
  {
    init(paramContext);
    paramContext = mSharedPreferences.edit();
    paramContext.putLong(paramString, paramLong);
    paramContext.apply();
  }
  
  protected static void commitLong(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = mSharedPreferences.edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.apply();
  }
  
  protected static void commitString(Context paramContext, String paramString1, String paramString2)
  {
    init(paramContext);
    paramContext = mSharedPreferences.edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.apply();
  }
  
  protected static void commitString(String paramString1, String paramString2)
  {
    if (mSharedPreferences != null)
    {
      SharedPreferences.Editor localEditor = mSharedPreferences.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.apply();
    }
  }
  
  protected static void commitStringWithEncryption(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = mSharedPreferences.edit();
    localEditor.putString(paramString1, getEncryptedString(paramString2));
    localEditor.apply();
  }
  
  protected static Boolean getBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    init(paramContext);
    return Boolean.valueOf(mSharedPreferences.getBoolean(paramString, paramBoolean));
  }
  
  protected static Boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return Boolean.valueOf(mSharedPreferences.getBoolean(paramString, paramBoolean));
  }
  
  public static String getDecryptString(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = a.b(paramString1, AES_ENCRYPTION_SEED);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      d.g("", z[1]);
    }
    return paramString2;
  }
  
  public static String getEncryptedString(String paramString)
  {
    try
    {
      paramString = a.a(paramString, AES_ENCRYPTION_SEED);
      return paramString;
    }
    catch (Exception paramString)
    {
      d.g("", z[0]);
    }
    return "";
  }
  
  protected static int getInt(Context paramContext, String paramString, int paramInt)
  {
    init(paramContext);
    return mSharedPreferences.getInt(paramString, paramInt);
  }
  
  protected static int getInt(String paramString, int paramInt)
  {
    return mSharedPreferences.getInt(paramString, paramInt);
  }
  
  protected static long getLong(Context paramContext, String paramString, long paramLong)
  {
    init(paramContext);
    return mSharedPreferences.getLong(paramString, paramLong);
  }
  
  protected static long getLong(String paramString, long paramLong)
  {
    return mSharedPreferences.getLong(paramString, paramLong);
  }
  
  protected static String getString(Context paramContext, String paramString1, String paramString2)
  {
    init(paramContext);
    return mSharedPreferences.getString(paramString1, paramString2);
  }
  
  protected static String getString(String paramString1, String paramString2)
  {
    return mSharedPreferences.getString(paramString1, paramString2);
  }
  
  protected static String getStringUnencrypted(String paramString1, String paramString2)
  {
    return getDecryptString(mSharedPreferences.getString(paramString1, paramString2), paramString2);
  }
  
  public static void init(Context paramContext)
  {
    if (mSharedPreferences == null) {
      mSharedPreferences = paramContext.getSharedPreferences(JPUSH_PREF, 0);
    }
  }
  
  public static void removeAll()
  {
    SharedPreferences.Editor localEditor = mSharedPreferences.edit();
    localEditor.clear();
    localEditor.commit();
  }
  
  public static void removeKey(String paramString)
  {
    SharedPreferences.Editor localEditor = mSharedPreferences.edit();
    localEditor.remove(paramString);
    localEditor.commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/api/BasePreferenceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */