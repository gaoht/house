package com.ziroom.commonlib.utils;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.util.SimpleArrayMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class p
{
  private static SimpleArrayMap<String, p> a = new SimpleArrayMap();
  private final SharedPreferences b;
  
  private p(String paramString)
  {
    this.b = d.a.getSharedPreferences(paramString, 0);
  }
  
  public static p getInstance()
  {
    return getInstance("");
  }
  
  public static p getInstance(String paramString)
  {
    String str = paramString;
    if (r.isNull(paramString)) {
      str = "ziroom_sp_file";
    }
    p localp = (p)a.get(str);
    paramString = localp;
    if (localp == null)
    {
      paramString = new p(str);
      a.put(str, paramString);
    }
    return paramString;
  }
  
  public void clear()
  {
    clear(false);
  }
  
  public void clear(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.edit().clear().commit();
      return;
    }
    this.b.edit().clear().apply();
  }
  
  public boolean contains(String paramString)
  {
    return this.b.contains(paramString);
  }
  
  public Map<String, ?> getAll()
  {
    return this.b.getAll();
  }
  
  public boolean getBoolean(String paramString)
  {
    return getBoolean(paramString, false);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.b.getBoolean(paramString, paramBoolean);
  }
  
  public Float getFloat(String paramString)
  {
    return getFloat(paramString, -1.0F);
  }
  
  public Float getFloat(String paramString, float paramFloat)
  {
    return Float.valueOf(this.b.getFloat(paramString, paramFloat));
  }
  
  public int getInt(String paramString)
  {
    return getInt(paramString, -1);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.b.getInt(paramString, paramInt);
  }
  
  public long getLong(String paramString)
  {
    return getLong(paramString, -1L);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.b.getLong(paramString, paramLong);
  }
  
  public String getString(String paramString)
  {
    return getString(paramString, "");
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return this.b.getString(paramString1, paramString2);
  }
  
  public Set<String> getStringSet(String paramString)
  {
    return getStringSet(paramString, Collections.emptySet());
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return this.b.getStringSet(paramString, paramSet);
  }
  
  public void putBoolean(String paramString, boolean paramBoolean)
  {
    putBoolean(paramString, paramBoolean, false);
  }
  
  public void putBoolean(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.b.edit().putBoolean(paramString, paramBoolean1).commit();
      return;
    }
    this.b.edit().putBoolean(paramString, paramBoolean1).apply();
  }
  
  public void putFloat(String paramString, float paramFloat)
  {
    putFloat(paramString, paramFloat, false);
  }
  
  public void putFloat(String paramString, float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.edit().putFloat(paramString, paramFloat).commit();
      return;
    }
    this.b.edit().putFloat(paramString, paramFloat).apply();
  }
  
  public void putInt(String paramString, int paramInt)
  {
    putInt(paramString, paramInt, false);
  }
  
  public void putInt(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.edit().putInt(paramString, paramInt).commit();
      return;
    }
    this.b.edit().putInt(paramString, paramInt).apply();
  }
  
  public void putLong(String paramString, long paramLong)
  {
    putLong(paramString, paramLong, false);
  }
  
  public void putLong(String paramString, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.edit().putLong(paramString, paramLong).commit();
      return;
    }
    this.b.edit().putLong(paramString, paramLong).apply();
  }
  
  public void putString(String paramString1, String paramString2)
  {
    putString(paramString1, paramString2, false);
  }
  
  public void putString(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.edit().putString(paramString1, paramString2).commit();
      return;
    }
    this.b.edit().putString(paramString1, paramString2).apply();
  }
  
  public void putStringSet(String paramString, Set<String> paramSet)
  {
    putStringSet(paramString, paramSet, false);
  }
  
  public void putStringSet(String paramString, Set<String> paramSet, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.edit().putStringSet(paramString, paramSet).commit();
      return;
    }
    this.b.edit().putStringSet(paramString, paramSet).apply();
  }
  
  public void remove(String paramString)
  {
    remove(paramString, false);
  }
  
  public void remove(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.edit().remove(paramString).commit();
      return;
    }
    this.b.edit().remove(paramString).apply();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */