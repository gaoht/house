package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.xiaomi.channel.commonutils.misc.b;
import java.util.Iterator;
import java.util.List;

public class ah
{
  private static volatile ah b;
  protected SharedPreferences a;
  
  private ah(Context paramContext)
  {
    this.a = paramContext.getSharedPreferences("mipush_extra", 0);
  }
  
  public static ah a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new ah(paramContext);
      }
      return b;
    }
    finally {}
  }
  
  private String a(int paramInt)
  {
    return "normal_oc_" + paramInt;
  }
  
  private void a(SharedPreferences.Editor paramEditor, Pair<Integer, Object> paramPair, String paramString)
  {
    if ((paramPair.second instanceof Integer)) {
      paramEditor.putInt(paramString, ((Integer)paramPair.second).intValue());
    }
    do
    {
      return;
      if ((paramPair.second instanceof Long))
      {
        paramEditor.putLong(paramString, ((Long)paramPair.second).longValue());
        return;
      }
      if ((paramPair.second instanceof String))
      {
        paramEditor.putString(paramString, (String)paramPair.second);
        return;
      }
    } while (!(paramPair.second instanceof Boolean));
    paramEditor.putBoolean(paramString, ((Boolean)paramPair.second).booleanValue());
  }
  
  private String b(int paramInt)
  {
    return "custom_oc_" + paramInt;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    String str = b(paramInt1);
    if (this.a.contains(str)) {
      paramInt2 = this.a.getInt(str, 0);
    }
    do
    {
      return paramInt2;
      str = a(paramInt1);
    } while (!this.a.contains(str));
    return this.a.getInt(str, 0);
  }
  
  public String a(int paramInt, String paramString)
  {
    String str = b(paramInt);
    if (this.a.contains(str)) {
      paramString = this.a.getString(str, null);
    }
    do
    {
      return paramString;
      str = a(paramInt);
    } while (!this.a.contains(str));
    return this.a.getString(str, null);
  }
  
  public void a(List<Pair<Integer, Object>> paramList)
  {
    if (b.a(paramList)) {
      return;
    }
    SharedPreferences.Editor localEditor = this.a.edit();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Pair localPair = (Pair)paramList.next();
      if ((localPair.first != null) && (localPair.second != null)) {
        a(localEditor, localPair, a(((Integer)localPair.first).intValue()));
      }
    }
    localEditor.commit();
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    String str = b(paramInt);
    if (this.a.contains(str)) {
      paramBoolean = this.a.getBoolean(str, false);
    }
    do
    {
      return paramBoolean;
      str = a(paramInt);
    } while (!this.a.contains(str));
    return this.a.getBoolean(str, false);
  }
  
  public void b(List<Pair<Integer, Object>> paramList)
  {
    if (b.a(paramList)) {
      return;
    }
    SharedPreferences.Editor localEditor = this.a.edit();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Pair localPair = (Pair)paramList.next();
      if (localPair.first != null)
      {
        String str = b(((Integer)localPair.first).intValue());
        if (localPair.second == null) {
          localEditor.remove(str);
        } else {
          a(localEditor, localPair, str);
        }
      }
    }
    localEditor.commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */