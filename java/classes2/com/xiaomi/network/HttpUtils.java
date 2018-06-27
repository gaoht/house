package com.xiaomi.network;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.network.c;
import com.xiaomi.channel.commonutils.network.d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class HttpUtils
{
  static int a(int paramInt1, int paramInt2)
  {
    return (paramInt2 + 243) / 1448 * 132 + 1080 + paramInt1 + paramInt2;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt2 + 200) / 1448 * 132 + 1011 + paramInt2 + paramInt1 + paramInt3;
  }
  
  private static int a(HttpProcessor paramHttpProcessor, String paramString1, List<c> paramList, String paramString2)
  {
    if (paramHttpProcessor.a() == 1) {
      return a(paramString1.length(), a(paramString2));
    }
    if (paramHttpProcessor.a() == 2)
    {
      int i = a(paramList);
      return a(paramString1.length(), i, a(paramString2));
    }
    return -1;
  }
  
  static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = paramString.getBytes("UTF-8").length;
      return i;
    }
    catch (UnsupportedEncodingException paramString) {}
    return 0;
  }
  
  static int a(List<c> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    c localc;
    int j;
    if (paramList.hasNext())
    {
      localc = (c)paramList.next();
      j = i;
      if (!TextUtils.isEmpty(localc.a())) {
        j = i + localc.a().length();
      }
      if (TextUtils.isEmpty(localc.b())) {
        break label85;
      }
    }
    label85:
    for (i = localc.b().length() + j;; i = j)
    {
      break;
      return i * 2;
    }
  }
  
  public static String a(Context paramContext, String paramString, List<c> paramList)
  {
    return a(paramContext, paramString, paramList, new DefaultHttpGetProcessor(), true);
  }
  
  public static String a(Context paramContext, String paramString, List<c> paramList, HttpProcessor paramHttpProcessor, boolean paramBoolean)
  {
    if (d.d(paramContext)) {}
    for (;;)
    {
      Object localObject1;
      try
      {
        localArrayList = new ArrayList();
        Object localObject2 = null;
        localObject1 = localArrayList;
        if (paramBoolean)
        {
          localObject3 = HostManager.getInstance().getFallbacksByURL(paramString);
          localObject2 = localObject3;
          localObject1 = localArrayList;
          if (localObject3 != null)
          {
            localObject1 = ((Fallback)localObject3).a(paramString);
            localObject2 = localObject3;
          }
        }
        if (!((ArrayList)localObject1).contains(paramString)) {
          ((ArrayList)localObject1).add(paramString);
        }
        paramString = null;
        Object localObject3 = ((ArrayList)localObject1).iterator();
        localObject1 = paramString;
        if (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          if (paramList == null) {
            break label294;
          }
          localArrayList = new ArrayList(paramList);
          long l = System.currentTimeMillis();
          localObject1 = paramString;
          try
          {
            if (!paramHttpProcessor.a(paramContext, str, localArrayList)) {
              return paramString;
            }
            localObject1 = paramString;
            paramString = paramHttpProcessor.b(paramContext, str, localArrayList);
            localObject1 = paramString;
            if (TextUtils.isEmpty(paramString)) {
              continue;
            }
            localObject1 = paramString;
            if (localObject2 == null) {
              break label291;
            }
            localObject1 = paramString;
            ((Fallback)localObject2).a(str, System.currentTimeMillis() - l, a(paramHttpProcessor, str, localArrayList, paramString));
            return paramString;
          }
          catch (IOException paramString)
          {
            if (localObject2 != null) {
              ((Fallback)localObject2).a(str, System.currentTimeMillis() - l, a(paramHttpProcessor, str, localArrayList, (String)localObject1), paramString);
            }
            paramString.printStackTrace();
            paramString = (String)localObject1;
          }
          continue;
          if (localObject2 != null)
          {
            localObject1 = paramString;
            ((Fallback)localObject2).a(str, System.currentTimeMillis() - l, a(paramHttpProcessor, str, localArrayList, paramString), null);
          }
          continue;
          localObject1 = null;
        }
      }
      catch (MalformedURLException paramContext)
      {
        paramContext.printStackTrace();
      }
      label291:
      return (String)localObject1;
      label294:
      ArrayList localArrayList = null;
    }
  }
  
  public static class DefaultHttpGetProcessor
    extends HttpProcessor
  {
    public DefaultHttpGetProcessor()
    {
      super();
    }
    
    public String b(Context paramContext, String paramString, List<c> paramList)
    {
      if (paramList == null) {
        return d.a(paramContext, new URL(paramString));
      }
      paramString = Uri.parse(paramString).buildUpon();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        c localc = (c)paramList.next();
        paramString.appendQueryParameter(localc.a(), localc.b());
      }
      return d.a(paramContext, new URL(paramString.toString()));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/network/HttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */