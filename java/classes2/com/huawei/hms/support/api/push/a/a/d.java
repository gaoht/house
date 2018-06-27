package com.huawei.hms.support.api.push.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Map;

public class d
{
  protected SharedPreferences a;
  
  public d(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new NullPointerException("context is null!");
    }
    this.a = paramContext.getSharedPreferences(paramString, 4);
  }
  
  public Map<String, ?> a()
  {
    if (this.a != null) {
      return this.a.getAll();
    }
    return new HashMap();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.a == null) {}
    SharedPreferences.Editor localEditor;
    do
    {
      return;
      localEditor = this.a.edit();
    } while (localEditor == null);
    localEditor.putBoolean(paramString, paramBoolean).commit();
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (this.a != null) {
      bool = this.a.getBoolean(paramString, false);
    }
    return bool;
  }
  
  public boolean a(String paramString, Object paramObject)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    if ((paramObject instanceof String)) {
      localEditor.putString(paramString, String.valueOf(paramObject));
    }
    for (;;)
    {
      return localEditor.commit();
      if ((paramObject instanceof Integer)) {
        localEditor.putInt(paramString, ((Integer)paramObject).intValue());
      } else if ((paramObject instanceof Short)) {
        localEditor.putInt(paramString, ((Short)paramObject).shortValue());
      } else if ((paramObject instanceof Byte)) {
        localEditor.putInt(paramString, ((Byte)paramObject).byteValue());
      } else if ((paramObject instanceof Long)) {
        localEditor.putLong(paramString, ((Long)paramObject).longValue());
      } else if ((paramObject instanceof Float)) {
        localEditor.putFloat(paramString, ((Float)paramObject).floatValue());
      } else if ((paramObject instanceof Double)) {
        localEditor.putFloat(paramString, (float)((Double)paramObject).doubleValue());
      } else if ((paramObject instanceof Boolean)) {
        localEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (this.a == null) {}
    SharedPreferences.Editor localEditor;
    do
    {
      return false;
      localEditor = this.a.edit();
    } while (localEditor == null);
    return localEditor.putString(paramString1, paramString2).commit();
  }
  
  public String b(String paramString)
  {
    if (this.a != null) {
      return this.a.getString(paramString, "");
    }
    return "";
  }
  
  public boolean c(String paramString)
  {
    return (this.a != null) && (this.a.contains(paramString));
  }
  
  public boolean d(String paramString)
  {
    if ((this.a != null) && (this.a.contains(paramString)))
    {
      paramString = this.a.edit().remove(paramString);
      paramString.commit();
      return paramString.commit();
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/api/push/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */