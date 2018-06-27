package com.xiaomi.network;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.network.a;
import com.xiaomi.channel.commonutils.network.c;
import com.xiaomi.channel.commonutils.network.d;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HostManagerV2
  extends HostManager
{
  private final int a = 80;
  private final int b = 5222;
  private int c = 80;
  
  protected HostManagerV2(Context paramContext, HostFilter paramHostFilter, HostManager.HttpGet paramHttpGet, String paramString)
  {
    this(paramContext, paramHostFilter, paramHttpGet, paramString, null, null);
  }
  
  protected HostManagerV2(Context paramContext, HostFilter paramHostFilter, HostManager.HttpGet paramHttpGet, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext, paramHostFilter, paramHttpGet, paramString1, paramString2, paramString3);
    addReservedHost("resolver.msg.xiaomi.net", "resolver.msg.xiaomi.net:5222");
  }
  
  static String a(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        int j = paramString.length();
        Object localObject = paramString.getBytes("UTF-8");
        i = 0;
        if (i < localObject.length)
        {
          int k = localObject[i];
          if ((k & 0xF0) != 240) {
            localObject[i] = ((byte)(k & 0xF ^ (byte)((k >> 4) + j & 0xF) | k & 0xF0));
          }
        }
        else
        {
          localObject = new String((byte[])localObject);
          return (String)localObject;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        return paramString;
      }
      i += 1;
    }
  }
  
  protected JSONObject a()
  {
    synchronized (this.mHostsMapping)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ver", 2);
      localJSONObject.put("data", toJSON());
      return localJSONObject;
    }
  }
  
  protected void b(String paramString)
  {
    synchronized (this.mHostsMapping)
    {
      this.mHostsMapping.clear();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("ver") != 2) {
        throw new JSONException("Bad version");
      }
    }
    paramString = paramString.optJSONArray("data");
    int i = 0;
    while (i < paramString.length())
    {
      Fallbacks localFallbacks = new Fallbacks().fromJSON(paramString.getJSONObject(i));
      this.mHostsMapping.put(localFallbacks.getHost(), localFallbacks);
      i += 1;
    }
  }
  
  protected boolean checkHostMapping()
  {
    synchronized (this.mHostsMapping)
    {
      if (!hostLoaded)
      {
        hostLoaded = true;
        this.mHostsMapping.clear();
        try
        {
          String str = loadHosts();
          if (!TextUtils.isEmpty(str))
          {
            b(str);
            b.b("loading the new hosts succeed");
            return true;
          }
        }
        catch (Throwable localThrowable)
        {
          b.a("load bucket failure: " + localThrowable.getMessage());
          return false;
        }
      }
      return true;
    }
  }
  
  protected String getHost()
  {
    return "resolver.msg.xiaomi.net";
  }
  
  protected String getRemoteFallbackJSON(ArrayList<String> paramArrayList, String paramString1, String paramString2)
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new a("type", paramString1));
    if (paramString1.equals("wap")) {
      localArrayList.add(new a("conpt", a(d.k(this.sAppContext))));
    }
    localArrayList.add(new a("uuid", paramString2));
    localArrayList.add(new a("list", join(paramArrayList, ",")));
    ??? = getLocalFallback("resolver.msg.xiaomi.net");
    Object localObject3 = String.format(Locale.US, "http://%1$s/gslb/?ver=3.0", new Object[] { "resolver.msg.xiaomi.net:" + this.c });
    Object localObject4;
    if (??? == null)
    {
      ((ArrayList)localObject1).add(localObject3);
      synchronized (mReservedHosts)
      {
        localObject3 = ((ArrayList)mReservedHosts.get("resolver.msg.xiaomi.net")).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          ((ArrayList)localObject1).add(String.format(Locale.US, "http://%1$s/gslb/?ver=3.0", new Object[] { localObject4 }));
        }
      }
      ??? = ((ArrayList)localObject1).iterator();
      localObject1 = null;
    }
    for (;;)
    {
      if (((Iterator)???).hasNext())
      {
        localObject1 = Uri.parse((String)((Iterator)???).next()).buildUpon();
        localObject3 = localArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (c)((Iterator)localObject3).next();
            ((Uri.Builder)localObject1).appendQueryParameter(((c)localObject4).a(), ((c)localObject4).b());
            continue;
            localObject1 = ((Fallback)???).a((String)localObject3);
            break;
          }
        }
      }
      try
      {
        if (this.sHttpGetter == null) {
          return d.a(this.sAppContext, new URL(((Uri.Builder)localObject1).toString()));
        }
        localObject1 = this.sHttpGetter.a(((Uri.Builder)localObject1).toString());
        return (String)localObject1;
      }
      catch (IOException localIOException) {}
      if (localObject1 == null) {
        break label424;
      }
      return super.getRemoteFallbackJSON(paramArrayList, paramString1, paramString2);
    }
    label424:
    return null;
  }
  
  public void persist()
  {
    synchronized (this.mHostsMapping)
    {
      try
      {
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(this.sAppContext.openFileOutput(getProcessName(), 0)));
        String str = a().toString();
        if (!TextUtils.isEmpty(str)) {
          localBufferedWriter.write(str);
        }
        localBufferedWriter.close();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          b.a("persist bucket failure: " + localException.getMessage());
        }
      }
      return;
    }
  }
  
  public void purge()
  {
    synchronized (this.mHostsMapping)
    {
      Iterator localIterator1 = this.mHostsMapping.values().iterator();
      if (localIterator1.hasNext()) {
        ((Fallbacks)localIterator1.next()).purge(true);
      }
    }
    int i = 0;
    for (;;)
    {
      if (i == 0)
      {
        Iterator localIterator2 = this.mHostsMapping.keySet().iterator();
        String str;
        do
        {
          if (!localIterator2.hasNext()) {
            break;
          }
          str = (String)localIterator2.next();
        } while (!((Fallbacks)this.mHostsMapping.get(str)).getFallbacks().isEmpty());
        this.mHostsMapping.remove(str);
        i = 0;
      }
      else
      {
        return;
        i = 1;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/network/HostManagerV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */