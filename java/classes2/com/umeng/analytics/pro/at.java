package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class at
{
  private static final String a = "fs_lc_tl";
  private final int b = 128;
  private final int c = 256;
  private final int d = 10;
  private Context e;
  private ar f = null;
  private aq g = null;
  private JSONObject h = null;
  private ar i;
  
  public at(Context paramContext)
  {
    if (paramContext == null) {}
    try
    {
      by.e("Context is null, can't track event");
      this.i = ar.b(paramContext);
      this.e = paramContext;
      this.f = ar.b(this.e);
      this.g = this.f.a(this.e);
      if (this.h == null) {
        a(paramContext);
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private JSONObject a(Map<String, Object> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      Object localObject;
      ArrayList localArrayList;
      int j;
      try
      {
        paramMap = paramMap.entrySet().iterator();
        boolean bool = paramMap.hasNext();
        if (bool)
        {
          try
          {
            localObject = (Map.Entry)paramMap.next();
            String str = (String)((Map.Entry)localObject).getKey();
            if (str == null) {
              continue;
            }
            str = bw.a(str, 128);
            localObject = ((Map.Entry)localObject).getValue();
            if (localObject == null) {
              continue;
            }
            if (!localObject.getClass().isArray()) {
              break label706;
            }
            if (!(localObject instanceof int[])) {
              break label180;
            }
            localObject = (int[])localObject;
            localArrayList = new ArrayList();
            j = 0;
            if (j < localObject.length)
            {
              localArrayList.add(Integer.valueOf(localObject[j]));
              j += 1;
              continue;
            }
            localJSONObject.put(str, localArrayList);
          }
          catch (Exception localException)
          {
            by.e(localException);
          }
          continue;
        }
        return localJSONObject;
      }
      catch (Exception paramMap) {}
      label180:
      if ((localObject instanceof double[]))
      {
        localObject = (double[])localObject;
        localArrayList = new ArrayList();
        j = 0;
        while (j < localObject.length)
        {
          localArrayList.add(Double.valueOf(localObject[j]));
          j += 1;
        }
        localJSONObject.put(localException, localArrayList);
      }
      else if ((localObject instanceof long[]))
      {
        localObject = (long[])localObject;
        localArrayList = new ArrayList();
        j = 0;
        while (j < localObject.length)
        {
          localArrayList.add(Long.valueOf(localObject[j]));
          j += 1;
        }
        localJSONObject.put(localException, localArrayList);
      }
      else if ((localObject instanceof float[]))
      {
        localObject = (float[])localObject;
        localArrayList = new ArrayList();
        j = 0;
        while (j < localObject.length)
        {
          localArrayList.add(Float.valueOf(localObject[j]));
          j += 1;
        }
        localJSONObject.put(localException, localArrayList);
      }
      else if ((localObject instanceof boolean[]))
      {
        localObject = (boolean[])localObject;
        localArrayList = new ArrayList();
        j = 0;
        while (j < localObject.length)
        {
          localArrayList.add(Boolean.valueOf(localObject[j]));
          j += 1;
        }
        localJSONObject.put(localException, localArrayList);
      }
      else if ((localObject instanceof byte[]))
      {
        localObject = (byte[])localObject;
        localArrayList = new ArrayList();
        j = 0;
        while (j < localObject.length)
        {
          localArrayList.add(Byte.valueOf(localObject[j]));
          j += 1;
        }
        localJSONObject.put(localException, localArrayList);
      }
      else if ((localObject instanceof short[]))
      {
        localObject = (short[])localObject;
        localArrayList = new ArrayList();
        j = 0;
        while (j < localObject.length)
        {
          localArrayList.add(Short.valueOf(localObject[j]));
          j += 1;
        }
        localJSONObject.put(localException, localArrayList);
      }
      else if ((localObject instanceof char[]))
      {
        localObject = (char[])localObject;
        localArrayList = new ArrayList();
        j = 0;
        while (j < localObject.length)
        {
          localArrayList.add(Character.valueOf(localObject[j]));
          j += 1;
        }
        localJSONObject.put(localException, localArrayList);
      }
      else
      {
        localJSONObject.put(localException, new ArrayList(Arrays.asList((Object[])localObject)));
        continue;
        label706:
        if ((localObject instanceof String)) {
          localJSONObject.put(localException, bw.a(localObject.toString(), 256));
        } else {
          localJSONObject.put(localException, localObject);
        }
      }
    }
  }
  
  private void a()
  {
    int m = 0;
    int k = 0;
    for (;;)
    {
      int j;
      try
      {
        if (!TextUtils.isEmpty(this.g.a))
        {
          String[] arrayOfString = this.g.a.split("!");
          JSONObject localJSONObject = new JSONObject();
          if (this.h != null)
          {
            j = 0;
            if (j < arrayOfString.length)
            {
              String str = bw.a(arrayOfString[j], 128);
              if (!this.h.has(str)) {
                break label190;
              }
              localJSONObject.put(str, this.h.get(str));
              break label190;
            }
          }
          this.h = new JSONObject();
          j = m;
          if (arrayOfString.length >= 10)
          {
            j = k;
            if (j < 10)
            {
              a(arrayOfString[j], localJSONObject);
              j += 1;
              continue;
            }
          }
          else if (j < arrayOfString.length)
          {
            a(arrayOfString[j], localJSONObject);
            j += 1;
            continue;
          }
          b(this.e);
          this.g.a = null;
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      label190:
      j += 1;
    }
  }
  
  private void a(Context paramContext)
  {
    try
    {
      paramContext = ba.a(paramContext).getString("fs_lc_tl", null);
      if (!TextUtils.isEmpty(paramContext)) {
        this.h = new JSONObject(paramContext);
      }
      a();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void a(String paramString, JSONObject paramJSONObject)
    throws JSONException
  {
    paramString = bw.a(paramString, 128);
    if (paramJSONObject.has(paramString))
    {
      a(paramString, ((Boolean)paramJSONObject.get(paramString)).booleanValue());
      return;
    }
    a(paramString, false);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    try
    {
      if ((!"$st_fl".equals(paramString)) && (!"dplus_st".equals(paramString)) && (!"du".equals(paramString)) && (!"id".equals(paramString)) && (!"ts".equals(paramString)) && (!this.h.has(paramString))) {
        this.h.put(paramString, paramBoolean);
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  private boolean a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      int j = paramString.trim().getBytes().length;
      if ((j > 0) && (j <= 128)) {
        return true;
      }
      by.e("Event id is empty or too long in tracking Event");
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return false;
  }
  
  private void b(Context paramContext)
  {
    try
    {
      if (this.h != null) {
        ba.a(this.e).edit().putString("fs_lc_tl", this.h.toString()).commit();
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private boolean b(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return true;
      try
      {
        if (paramString.trim().getBytes().length <= 256) {
          continue;
        }
        by.e("Event label or value is empty or too long in tracking Event");
        return false;
      }
      catch (Exception paramString)
      {
        for (;;) {}
      }
    }
  }
  
  private boolean b(Map<String, Object> paramMap)
  {
    if (paramMap != null) {}
    try
    {
      if (paramMap.isEmpty())
      {
        by.e("map is null or empty in onEvent");
        return false;
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (!a((String)localEntry.getKey())) {
          return false;
        }
        if (localEntry.getValue() == null) {
          return false;
        }
        if ((localEntry.getValue() instanceof String))
        {
          boolean bool = b(localEntry.getValue().toString());
          if (!bool) {
            return false;
          }
        }
      }
    }
    catch (Exception paramMap) {}
    return true;
  }
  
  public void a(Context paramContext, List<String> paramList)
  {
    try
    {
      if (this.e == null)
      {
        if (paramContext == null) {
          return;
        }
        this.e = paramContext;
        return;
      }
    }
    catch (Exception paramContext) {}
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      if (a(paramString1))
      {
        if (!b(paramString2)) {
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("id", paramString1);
        localJSONObject.put("ts", System.currentTimeMillis());
        if (paramLong > 0L) {
          localJSONObject.put("du", paramLong);
        }
        localJSONObject.put("__t", 2049);
        String str = paramString2;
        if (paramString2 == null) {
          str = "";
        }
        localJSONObject.put(paramString1, str);
        localJSONObject.put("__i", bd.g(this.e));
        localJSONObject.put("_umpname", ap.a);
        this.i.a(localJSONObject);
        return;
      }
    }
    catch (Throwable paramString1) {}
  }
  
  public void a(String paramString, Map<String, Object> paramMap) {}
  
  public void a(String paramString, Map<String, Object> paramMap, long paramLong)
  {
    for (;;)
    {
      int j;
      try
      {
        if (!a(paramString)) {
          return;
        }
        if (b(paramMap))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("id", paramString);
          localJSONObject.put("ts", System.currentTimeMillis());
          if (paramLong > 0L) {
            localJSONObject.put("du", paramLong);
          }
          localJSONObject.put("__t", 2049);
          paramString = paramMap.entrySet().iterator();
          j = 0;
          if ((j < 10) && (paramString.hasNext()))
          {
            paramMap = (Map.Entry)paramString.next();
            if (("$st_fl".equals(paramMap.getKey())) || ("dplus_st".equals(paramMap.getKey())) || ("du".equals(paramMap.getKey())) || ("id".equals(paramMap.getKey())) || ("ts".equals(paramMap.getKey()))) {
              break label284;
            }
            Object localObject = paramMap.getValue();
            if ((!(localObject instanceof String)) && (!(localObject instanceof Integer)) && (!(localObject instanceof Long))) {
              break label284;
            }
            localJSONObject.put((String)paramMap.getKey(), localObject);
            break label284;
          }
          localJSONObject.put("__i", bd.g(this.e));
          localJSONObject.put("_umpname", ap.a);
          this.i.a(localJSONObject);
          return;
        }
      }
      catch (Throwable paramString) {}
      return;
      label284:
      j += 1;
    }
  }
  
  public boolean a(List<String> paramList, int paramInt, final String paramString)
  {
    int j = 0;
    try
    {
      n localn = n.a();
      if (paramList == null)
      {
        by.e("cklist is null!");
      }
      else
      {
        if (paramList.size() <= 0)
        {
          by.e("the KeyList is null!");
          return false;
        }
        ArrayList localArrayList = new ArrayList(paramList);
        if (!localn.b((String)localArrayList.get(0)))
        {
          by.e("Primary key Invalid!");
          return false;
        }
        if (localArrayList.size() > 8)
        {
          paramList = (String)localArrayList.get(0);
          localArrayList.clear();
          localArrayList.add(paramList);
          localArrayList.add("__cc");
          localArrayList.add("illegal");
          if (localn.a(paramString)) {
            break label398;
          }
          by.e("label  Invalid!");
        }
        label398:
        for (paramList = "__illegal";; paramList = paramString)
        {
          paramString = new HashMap();
          paramString.put(localArrayList, new l(localArrayList, paramInt, paramList, System.currentTimeMillis()));
          bz.b(new cb()
          {
            public void a()
            {
              m.a(at.a(at.this)).a(new f()
              {
                public void a(Object paramAnonymous2Object, boolean paramAnonymous2Boolean)
                {
                  if (paramAnonymous2Object.equals("success")) {}
                }
              }, paramString);
            }
          });
          break label403;
          if (!localn.a(localArrayList))
          {
            paramList = (String)localArrayList.get(0);
            localArrayList.clear();
            localArrayList.add(paramList);
            localArrayList.add("__cc");
            localArrayList.add("illegal");
            break;
          }
          if (!localn.b(localArrayList))
          {
            paramList = (String)localArrayList.get(0);
            localArrayList.clear();
            localArrayList.add(paramList);
            localArrayList.add("__cc");
            localArrayList.add("illegal");
            break;
          }
          while (j < localArrayList.size())
          {
            paramList = (String)localArrayList.get(j);
            if (paramList.length() > 16)
            {
              localArrayList.remove(j);
              localArrayList.add(j, paramList.substring(0, 16));
            }
            j += 1;
          }
          break;
        }
      }
    }
    catch (Exception paramList)
    {
      label403:
      for (;;) {}
    }
    return true;
  }
  
  public void b(String paramString, Map<String, Object> paramMap)
  {
    for (;;)
    {
      int j;
      try
      {
        if (!a(paramString)) {
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("id", paramString);
        localJSONObject.put("ts", System.currentTimeMillis());
        localJSONObject.put("du", 0);
        localJSONObject.put("__t", 2050);
        paramString = paramMap.entrySet().iterator();
        j = 0;
        if ((j < 10) && (paramString.hasNext()))
        {
          paramMap = (Map.Entry)paramString.next();
          if ((!"$st_fl".equals(paramMap.getKey())) && (!"dplus_st".equals(paramMap.getKey())) && (!"du".equals(paramMap.getKey())) && (!"id".equals(paramMap.getKey())) && (!"ts".equals(paramMap.getKey())))
          {
            Object localObject = paramMap.getValue();
            if (((localObject instanceof String)) || ((localObject instanceof Integer)) || ((localObject instanceof Long))) {
              localJSONObject.put((String)paramMap.getKey(), localObject);
            }
          }
        }
        else
        {
          localJSONObject.put("__i", bd.g(this.e));
          this.i.a(localJSONObject);
          return;
        }
      }
      catch (Throwable paramString)
      {
        return;
      }
      j += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */