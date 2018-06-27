package com.airbnb.lottie;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v4.util.LongSparseArray;
import android.util.DisplayMetrics;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aw
{
  private final Map<String, List<av>> a = new HashMap();
  private final Map<String, ay> b = new HashMap();
  private final LongSparseArray<av> c = new LongSparseArray();
  private final List<av> d = new ArrayList();
  private final Rect e;
  private final long f;
  private final long g;
  private final int h;
  private final float i;
  
  private aw(Rect paramRect, long paramLong1, long paramLong2, int paramInt, float paramFloat)
  {
    this.e = paramRect;
    this.f = paramLong1;
    this.g = paramLong2;
    this.h = paramInt;
    this.i = paramFloat;
  }
  
  long a()
  {
    return this.g;
  }
  
  av a(long paramLong)
  {
    return (av)this.c.get(paramLong);
  }
  
  List<av> a(String paramString)
  {
    return (List)this.a.get(paramString);
  }
  
  List<av> b()
  {
    return this.d;
  }
  
  Map<String, ay> c()
  {
    return this.b;
  }
  
  float d()
  {
    return (float)getDuration() * this.h / 1000.0F;
  }
  
  public Rect getBounds()
  {
    return this.e;
  }
  
  public float getDpScale()
  {
    return this.i;
  }
  
  public long getDuration()
  {
    return ((float)(this.g - this.f) / this.h * 1000.0F);
  }
  
  public boolean hasImages()
  {
    return !this.b.isEmpty();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LottieComposition:\n");
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((av)localIterator.next()).a("\t"));
    }
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    static aw a(Resources paramResources, InputStream paramInputStream)
    {
      try
      {
        byte[] arrayOfByte = new byte[paramInputStream.available()];
        paramInputStream.read(arrayOfByte);
        paramResources = a(paramResources, new JSONObject(new String(arrayOfByte, "UTF-8")));
        return paramResources;
      }
      catch (IOException paramResources)
      {
        Log.e("LOTTIE", "Failed to load composition.", new IllegalStateException("Unable to find file.", paramResources));
        return null;
      }
      catch (JSONException paramResources)
      {
        for (;;)
        {
          Log.e("LOTTIE", "Failed to load composition.", new IllegalStateException("Unable to load JSON.", paramResources));
          ch.a(paramInputStream);
        }
      }
      finally
      {
        ch.a(paramInputStream);
      }
    }
    
    static aw a(Resources paramResources, JSONObject paramJSONObject)
    {
      float f = paramResources.getDisplayMetrics().density;
      int i = paramJSONObject.optInt("w", -1);
      int j = paramJSONObject.optInt("h", -1);
      if ((i != -1) && (j != -1)) {}
      for (paramResources = new Rect(0, 0, (int)(i * f), (int)(j * f));; paramResources = null)
      {
        paramResources = new aw(paramResources, paramJSONObject.optLong("ip", 0L), paramJSONObject.optLong("op", 0L), paramJSONObject.optInt("fr", 0), f, null);
        JSONArray localJSONArray = paramJSONObject.optJSONArray("assets");
        b(localJSONArray, paramResources);
        a(localJSONArray, paramResources);
        a(paramJSONObject, paramResources);
        return paramResources;
      }
    }
    
    private static void a(List<av> paramList, LongSparseArray<av> paramLongSparseArray, av paramav)
    {
      paramList.add(paramav);
      paramLongSparseArray.put(paramav.c(), paramav);
    }
    
    private static void a(JSONArray paramJSONArray, aw paramaw)
    {
      if (paramJSONArray == null) {
        return;
      }
      int k = paramJSONArray.length();
      int i = 0;
      label13:
      Object localObject;
      JSONArray localJSONArray;
      if (i < k)
      {
        localObject = paramJSONArray.optJSONObject(i);
        localJSONArray = ((JSONObject)localObject).optJSONArray("layers");
        if (localJSONArray != null) {
          break label47;
        }
      }
      for (;;)
      {
        i += 1;
        break label13;
        break;
        label47:
        ArrayList localArrayList = new ArrayList(localJSONArray.length());
        LongSparseArray localLongSparseArray = new LongSparseArray();
        int j = 0;
        while (j < localJSONArray.length())
        {
          av localav = av.a.a(localJSONArray.optJSONObject(j), paramaw);
          localLongSparseArray.put(localav.c(), localav);
          localArrayList.add(localav);
          j += 1;
        }
        localObject = ((JSONObject)localObject).optString("id");
        aw.c(paramaw).put(localObject, localArrayList);
      }
    }
    
    private static void a(JSONObject paramJSONObject, aw paramaw)
    {
      paramJSONObject = paramJSONObject.optJSONArray("layers");
      if (paramJSONObject == null) {}
      for (;;)
      {
        return;
        int j = paramJSONObject.length();
        int i = 0;
        while (i < j)
        {
          av localav = av.a.a(paramJSONObject.optJSONObject(i), paramaw);
          a(aw.a(paramaw), aw.b(paramaw), localav);
          i += 1;
        }
      }
    }
    
    private static void b(JSONArray paramJSONArray, aw paramaw)
    {
      if (paramJSONArray == null) {
        return;
      }
      int j = paramJSONArray.length();
      int i = 0;
      label12:
      Object localObject;
      if (i < j)
      {
        localObject = paramJSONArray.optJSONObject(i);
        if (((JSONObject)localObject).has("p")) {
          break label41;
        }
      }
      for (;;)
      {
        i += 1;
        break label12;
        break;
        label41:
        localObject = ay.a.a((JSONObject)localObject);
        aw.d(paramaw).put(((ay)localObject).getId(), localObject);
      }
    }
    
    public static q fromAssetFileName(Context paramContext, String paramString, bf parambf)
    {
      try
      {
        InputStream localInputStream = paramContext.getAssets().open(paramString);
        return fromInputStream(paramContext, localInputStream, parambf);
      }
      catch (IOException paramContext)
      {
        throw new IllegalStateException("Unable to find file " + paramString, paramContext);
      }
    }
    
    public static aw fromFileSync(Context paramContext, String paramString)
    {
      try
      {
        InputStream localInputStream = paramContext.getAssets().open(paramString);
        return a(paramContext.getResources(), localInputStream);
      }
      catch (IOException paramContext)
      {
        throw new IllegalStateException("Unable to find file " + paramString, paramContext);
      }
    }
    
    public static q fromInputStream(Context paramContext, InputStream paramInputStream, bf parambf)
    {
      paramContext = new ac(paramContext.getResources(), parambf);
      paramContext.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new InputStream[] { paramInputStream });
      return paramContext;
    }
    
    public static q fromJson(Resources paramResources, JSONObject paramJSONObject, bf parambf)
    {
      paramResources = new ar(paramResources, parambf);
      paramResources.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { paramJSONObject });
      return paramResources;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */