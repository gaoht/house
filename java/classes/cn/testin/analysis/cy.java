package cn.testin.analysis;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.JsonWriter;
import android.util.Log;
import android.util.Pair;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class cy
  extends Handler
{
  Map<String, List<bv>> a = new HashMap();
  private fd c;
  private ch d = null;
  private Lock e;
  private bo f;
  private an g;
  private dl h;
  private Map<String, JSONObject> i;
  private List<String> j;
  private List<JSONObject> k;
  private List<JSONObject> l;
  private List<JSONObject> m;
  
  public cy(cu paramcu, Context paramContext, Looper paramLooper)
  {
    super(paramLooper);
    paramcu = new cf(paramContext.getPackageName(), paramContext);
    this.g = new an(paramContext, "VisualEditor");
    this.h = new dl(paramContext);
    this.f = new bo(paramcu, this.g, this.h);
    this.i = new HashMap();
    this.j = new ArrayList();
    this.k = new ArrayList();
    this.l = new ArrayList();
    this.m = new ArrayList();
    this.e = new ReentrantLock();
    this.e.lock();
  }
  
  private void a(JsonWriter paramJsonWriter)
  {
    try
    {
      paramJsonWriter.name("images");
      paramJsonWriter.beginArray();
      Iterator localIterator = this.g.a().iterator();
      while (localIterator.hasNext()) {
        paramJsonWriter.value((String)localIterator.next());
      }
      paramJsonWriter.endArray();
    }
    catch (Exception paramJsonWriter)
    {
      Log.e("VisualEditor", "Can't write images to server", paramJsonWriter);
      return;
    }
  }
  
  private void a(String paramString)
  {
    SharedPreferences.Editor localEditor = k().edit();
    if (TextUtils.isEmpty(paramString)) {
      localEditor.remove("visual.changes");
    }
    for (;;)
    {
      localEditor.remove("visualeditor.changes");
      localEditor.remove("visualeditor.bindings");
      localEditor.apply();
      e();
      return;
      localEditor.putString("visual.changes", paramString);
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("payload");
      if (paramJSONObject.has("config"))
      {
        this.d = this.f.c(paramJSONObject);
        Log.v("VisualEditor", "Initializing snapshot with configuration");
      }
      if (this.d == null)
      {
        Log.w("VisualEditor", "Testin editor is misconfigured, sent a snapshot request without a valid configuration.");
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      Log.e("VisualEditor", "Payload with snapshot config required with snapshot request", paramJSONObject);
      return;
    }
    catch (dg paramJSONObject)
    {
      Log.e("VisualEditor", "Editor sent malformed message with snapshot request", paramJSONObject);
      return;
    }
    paramJSONObject = this.c.c();
    localOutputStreamWriter = new OutputStreamWriter(paramJSONObject);
    try
    {
      localOutputStreamWriter.write("{");
      localOutputStreamWriter.write("\"type\": \"snapshot_response\",");
      localOutputStreamWriter.write("\"payload\": {");
      localOutputStreamWriter.write("\"activities\":");
      localOutputStreamWriter.flush();
      this.d.a(cu.c(this.b), paramJSONObject);
      long l2 = System.currentTimeMillis();
      localOutputStreamWriter.write(",\"snapshot_time_millis\": ");
      localOutputStreamWriter.write(Long.toString(l2 - l1));
      localOutputStreamWriter.write("}");
      localOutputStreamWriter.write("}");
      try
      {
        localOutputStreamWriter.close();
        ar.c("msg", paramJSONObject.toString());
        return;
      }
      catch (IOException paramJSONObject)
      {
        Log.e("VisualEditor", "Can't close writer.", paramJSONObject);
        return;
      }
      try
      {
        localOutputStreamWriter.close();
        ar.c("msg", paramJSONObject.toString());
        throw ((Throwable)localObject);
      }
      catch (IOException paramJSONObject)
      {
        for (;;)
        {
          Log.e("VisualEditor", "Can't close writer.", paramJSONObject);
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      Log.e("VisualEditor", "Can't write snapshot request to server", localIOException);
      try
      {
        localOutputStreamWriter.close();
        ar.c("msg", paramJSONObject.toString());
        return;
      }
      catch (IOException paramJSONObject)
      {
        Log.e("VisualEditor", "Can't close writer.", paramJSONObject);
        return;
      }
    }
    finally {}
  }
  
  private void b(JsonWriter paramJsonWriter)
  {
    try
    {
      paramJsonWriter.name("fonts");
      paramJsonWriter.beginArray();
      Iterator localIterator = this.h.a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramJsonWriter.beginObject();
        paramJsonWriter.name("fontName").value((String)localEntry.getKey());
        paramJsonWriter.name("fontPath").value((String)localEntry.getValue());
        paramJsonWriter.endObject();
      }
      paramJsonWriter.endArray();
    }
    catch (IOException paramJsonWriter)
    {
      Log.e("VisualEditor", "Can't write Fonts to server", paramJsonWriter);
      return;
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("payload").getJSONArray("actions");
      int n = 0;
      while (n < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(n);
        String str = localJSONObject.getString("name");
        this.i.put(str, localJSONObject);
        n += 1;
      }
      i();
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.e("VisualEditor", "Bad change request received", paramJSONObject);
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("payload").getJSONArray("actions");
      int n = 0;
      while (n < paramJSONObject.length())
      {
        String str = paramJSONObject.getString(n);
        this.i.remove(str);
        n += 1;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.e("VisualEditor", "Bad clear request received", paramJSONObject);
      i();
    }
  }
  
  /* Error */
  private void d(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc -51
    //   3: invokevirtual 211	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   6: ldc_w 371
    //   9: invokevirtual 339	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   12: astore_1
    //   13: aload_1
    //   14: invokevirtual 345	org/json/JSONArray:length	()I
    //   17: istore_3
    //   18: aload_0
    //   19: getfield 89	cn/testin/analysis/cy:k	Ljava/util/List;
    //   22: invokeinterface 374 1 0
    //   27: iconst_0
    //   28: istore_2
    //   29: iload_2
    //   30: iload_3
    //   31: if_icmpge +77 -> 108
    //   34: aload_1
    //   35: iload_2
    //   36: invokevirtual 348	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   39: astore 4
    //   41: aload_0
    //   42: getfield 89	cn/testin/analysis/cy:k	Ljava/util/List;
    //   45: aload 4
    //   47: invokeinterface 378 2 0
    //   52: pop
    //   53: iload_2
    //   54: iconst_1
    //   55: iadd
    //   56: istore_2
    //   57: goto -28 -> 29
    //   60: astore_1
    //   61: ldc 61
    //   63: ldc_w 380
    //   66: aload_1
    //   67: invokestatic 150	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   70: pop
    //   71: return
    //   72: astore 4
    //   74: ldc 61
    //   76: new 382	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 383	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 385
    //   86: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 390	org/json/JSONArray:toString	()Ljava/lang/String;
    //   93: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: aload 4
    //   101: invokestatic 150	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   104: pop
    //   105: goto -52 -> 53
    //   108: aload_0
    //   109: invokespecial 359	cn/testin/analysis/cy:i	()V
    //   112: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	cy
    //   0	113	1	paramJSONObject	JSONObject
    //   28	29	2	n	int
    //   17	15	3	i1	int
    //   39	7	4	localJSONObject	JSONObject
    //   72	28	4	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   0	13	60	org/json/JSONException
    //   34	53	72	org/json/JSONException
  }
  
  private void e()
  {
    Object localObject1 = k();
    Object localObject2 = ((SharedPreferences)localObject1).getString("visual.changes", null);
    try
    {
      this.l.clear();
      this.m.clear();
      if (localObject2 != null)
      {
        localObject2 = new JSONArray((String)localObject2);
        int i2 = ((JSONArray)localObject2).length();
        int n = 0;
        while (n < i2)
        {
          Object localObject3 = ((JSONArray)localObject2).getJSONObject(n);
          int i3 = ((JSONObject)localObject3).optInt("id");
          int i4 = ((JSONObject)localObject3).optInt("experiment_id");
          Object localObject4 = ((JSONObject)localObject3).optJSONArray("actions");
          int i1;
          if (localObject4 != null)
          {
            int i5 = ((JSONArray)localObject4).length();
            i1 = 0;
            while (i1 < i5)
            {
              JSONObject localJSONObject = ((JSONArray)localObject4).getJSONObject(i1);
              localJSONObject.put("exp_id", i4);
              localJSONObject.put("id", i3);
              this.l.add(localJSONObject);
              i1 += 1;
            }
          }
          localObject3 = ((JSONObject)localObject3).optJSONArray("event_bindings");
          if (localObject3 != null)
          {
            i1 = 0;
            while (i1 < ((JSONArray)localObject3).length())
            {
              localObject4 = ((JSONArray)localObject3).getJSONObject(i1);
              ((JSONObject)localObject4).put("exp_id", i4);
              ((JSONObject)localObject4).put("id", i3);
              this.m.add(localObject4);
              i1 += 1;
            }
          }
          n += 1;
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.i("VisualEditor", "JSON error when initializing saved changes, clearing persistent memory", localJSONException);
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).remove("visual.changes");
      ((SharedPreferences.Editor)localObject1).apply();
      j();
    }
  }
  
  private void f()
  {
    Log.v("VisualEditor", "connecting to editor");
    if ((this.c != null) && (this.c.b()))
    {
      Log.v("VisualEditor", "There is already a valid connection to an events editor.");
      return;
    }
    try
    {
      this.c = new fd(new URI(a.c + "/socket?appKey=" + a.e + "&type=android&module=visual"), new cw(this.b, null), cu.a(this.b));
      return;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      Log.e("VisualEditor", "Error parsing URI " + a.c + " for editor websocket", localURISyntaxException);
      return;
    }
    catch (di localdi)
    {
      Log.e("VisualEditor", "Error connecting to URI " + a.c, localdi);
      return;
    }
    catch (Exception localException)
    {
      Log.i("VisualEditor", "Can't create SSL Socket to connect to editor service", localException);
    }
  }
  
  private void g()
  {
    if ((this.c == null) || (!this.c.b())) {
      return;
    }
    localBufferedOutputStream = this.c.c();
    localJsonWriter1 = new JsonWriter(new OutputStreamWriter(localBufferedOutputStream));
    try
    {
      int n = al.i(cu.b(this.b));
      int i1 = al.j(cu.b(this.b));
      localJsonWriter1.beginObject();
      localJsonWriter1.name("type").value("device_info_response");
      localJsonWriter1.name("payload").beginObject();
      localJsonWriter1.name("$android_lib_version").value(a.f);
      localJsonWriter1.name("$android_os").value("Android");
      JsonWriter localJsonWriter2 = localJsonWriter1.name("$android_os_version");
      Object localObject1;
      if (Build.VERSION.RELEASE == null) {
        localObject1 = "UNKNOWN";
      }
      for (;;)
      {
        localJsonWriter2.value((String)localObject1);
        localJsonWriter2 = localJsonWriter1.name("$android_manufacturer");
        if (Build.MANUFACTURER == null)
        {
          localObject1 = "UNKNOWN";
          label176:
          localJsonWriter2.value((String)localObject1);
          localJsonWriter2 = localJsonWriter1.name("$android_brand");
          if (Build.BRAND != null) {
            break label514;
          }
          localObject1 = "UNKNOWN";
          label203:
          localJsonWriter2.value((String)localObject1);
          localJsonWriter2 = localJsonWriter1.name("$android_model");
          if (Build.MODEL != null) {
            break label521;
          }
          localObject1 = "UNKNOWN";
          localJsonWriter2.value((String)localObject1);
        }
        try
        {
          localObject1 = cu.b(this.b).getPackageManager().getPackageInfo(cu.b(this.b).getPackageName(), 0);
          localJsonWriter1.name("$android_app_version").value(((PackageInfo)localObject1).versionName);
          localJsonWriter1.name("$android_app_version_code").value(Integer.toString(((PackageInfo)localObject1).versionCode));
          localJsonWriter1.name("device_type").value("Android");
          localJsonWriter1.name("device_name").value(Build.BRAND + "/" + Build.MODEL);
          localJsonWriter1.name("scaled_density").value(Resources.getSystem().getDisplayMetrics().scaledDensity);
          localJsonWriter1.name("device_width").value(al.a(cu.b(this.b), n));
          localJsonWriter1.name("device_height").value(al.a(cu.b(this.b), i1));
          localJsonWriter1.name("device_width_px").value(n);
          localJsonWriter1.name("device_height_px").value(i1);
          b(localJsonWriter1);
          a(localJsonWriter1);
          localJsonWriter1.endObject();
          localJsonWriter1.endObject();
          try
          {
            localJsonWriter1.close();
            ar.a(localBufferedOutputStream.toString());
            return;
          }
          catch (IOException localIOException1)
          {
            Log.e("VisualEditor", "Can't close websocket writer", localIOException1);
            return;
          }
          String str = Build.VERSION.RELEASE;
          continue;
          str = Build.MANUFACTURER;
          break label176;
          label514:
          str = Build.BRAND;
          break label203;
          label521:
          str = Build.MODEL;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            Log.e("VisualEditor", "Exception getting app version name", localNameNotFoundException);
          }
        }
      }
      try
      {
        localJsonWriter1.close();
        ar.a(localBufferedOutputStream.toString());
        throw ((Throwable)localObject2);
      }
      catch (IOException localIOException4)
      {
        for (;;)
        {
          Log.e("VisualEditor", "Can't close websocket writer", localIOException4);
        }
      }
    }
    catch (IOException localIOException2)
    {
      localIOException2 = localIOException2;
      Log.e("VisualEditor", "Can't write device_info to server", localIOException2);
      try
      {
        localJsonWriter1.close();
        ar.a(localBufferedOutputStream.toString());
        return;
      }
      catch (IOException localIOException3)
      {
        Log.e("VisualEditor", "Can't close websocket writer", localIOException3);
        return;
      }
    }
    finally {}
  }
  
  private void h()
  {
    this.i.clear();
    this.k.clear();
    this.d = null;
    Log.v("VisualEditor", "Editor closed- freeing snapshot");
    i();
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.g.b(str);
    }
    a.m = false;
  }
  
  private void i()
  {
    j();
    d();
  }
  
  private void j()
  {
    int i2 = 0;
    Object localObject1 = new HashSet();
    Object localObject3 = new ArrayList();
    int i1 = this.l.size();
    int n = 0;
    if (n < i1)
    {
      JSONObject localJSONObject = (JSONObject)this.l.get(n);
      String str = this.f.a(localJSONObject);
      if (((Set)localObject1).contains(str)) {}
      for (;;)
      {
        n += 1;
        break;
        try
        {
          ((List)localObject3).add(this.f.b(localJSONObject));
        }
        catch (dh localdh1)
        {
          ((Set)localObject1).add(str);
          Log.e("VisualEditor", "Can't load assets for an edit, won't apply the change now", localdh1);
        }
        catch (dj localdj3)
        {
          Log.i("VisualEditor", localdj3.getMessage());
        }
        catch (dg localdg3)
        {
          Log.e("VisualEditor", "Bad persistent change request cannot be applied.", localdg3);
        }
      }
    }
    Object localObject4 = this.i.values().iterator();
    while (((Iterator)localObject4).hasNext())
    {
      Object localObject5 = (JSONObject)((Iterator)localObject4).next();
      try
      {
        localObject5 = this.f.b((JSONObject)localObject5);
        ((List)localObject3).add(localObject5);
        if (a.m) {
          this.j.addAll(((br)localObject5).b);
        }
      }
      catch (dh localdh2)
      {
        Log.v("VisualEditor", "Can't load assets for an edit, won't apply the change now", localdh2);
      }
      catch (dj localdj5)
      {
        Log.i("VisualEditor", localdj5.getMessage());
      }
      catch (dg localdg4)
      {
        Log.e("VisualEditor", "Bad editor change request cannot be applied.", localdg4);
      }
    }
    localObject4 = new ArrayList();
    n = 0;
    Object localObject6;
    label330:
    Object localObject7;
    if (n < ((List)localObject3).size())
    {
      localObject6 = (br)((List)localObject3).get(n);
      i1 = n + 1;
      if (i1 < ((List)localObject3).size())
      {
        localObject7 = (br)((List)localObject3).get(i1);
        if ((!((br)localObject6).a().equals(((br)localObject7).a())) || (!((br)localObject6).a.b().equals(((br)localObject7).a.b()))) {}
      }
      for (;;)
      {
        n += 1;
        break;
        i1 += 1;
        break label330;
        ((List)localObject4).add(localObject6);
      }
    }
    i1 = this.m.size();
    n = 0;
    if (n < i1)
    {
      localObject3 = (JSONObject)this.m.get(n);
      if (((Set)localObject1).contains(this.f.a((JSONObject)localObject3))) {}
      for (;;)
      {
        n += 1;
        break;
        try
        {
          ((List)localObject4).add(this.f.a((JSONObject)localObject3, this.b));
        }
        catch (dj localdj2)
        {
          Log.i("VisualEditor", localdj2.getMessage());
        }
        catch (dg localdg2)
        {
          Log.e("VisualEditor", "Bad persistent event binding cannot be applied.", localdg2);
        }
      }
    }
    i1 = this.k.size();
    n = i2;
    for (;;)
    {
      if (n < i1)
      {
        localObject1 = (JSONObject)this.k.get(n);
        try
        {
          ((List)localObject4).add(this.f.a((JSONObject)localObject1, this.b));
          n += 1;
        }
        catch (dj localdj1)
        {
          for (;;)
          {
            Log.i("VisualEditor", localdj1.getMessage());
          }
        }
        catch (dg localdg1)
        {
          for (;;)
          {
            Log.e("VisualEditor", "Bad editor event binding cannot be applied.", localdg1);
          }
        }
      }
    }
    Object localObject2 = new HashMap();
    Iterator localIterator = ((List)localObject4).iterator();
    while (localIterator.hasNext())
    {
      localObject4 = (br)localIterator.next();
      localObject6 = ((br)localObject4).a();
      if (((HashMap)localObject2).containsKey(localObject6)) {
        ((bv)((Pair)((HashMap)localObject2).get(localObject6)).second).a(((br)localObject4).a);
      } else {
        try
        {
          localObject7 = new bv(this.f.a(((br)localObject4).d), ((br)localObject4).c);
          ((bv)localObject7).a(((br)localObject4).a);
          ((HashMap)localObject2).put(localObject6, new Pair(((br)localObject4).c, localObject7));
        }
        catch (JSONException localJSONException)
        {
          Log.e("VisualEditor", "Bad persistent change request cannot be applied.Can't interpret instructions due to parse path");
        }
        catch (dj localdj4)
        {
          Log.i("VisualEditor", localdj4.getMessage());
        }
      }
    }
    this.a.clear();
    localIterator = ((HashMap)localObject2).values().iterator();
    if (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if (this.a.containsKey(localPair.first)) {
        localObject2 = (List)this.a.get(localPair.first);
      }
      for (;;)
      {
        ((List)localObject2).add(localPair.second);
        break;
        localObject2 = new ArrayList();
        this.a.put(localPair.first, localObject2);
      }
    }
    cu.a(this.b, true);
  }
  
  private SharedPreferences k()
  {
    return au.c(cu.b(this.b));
  }
  
  public void a()
  {
    this.e.unlock();
  }
  
  protected boolean b()
  {
    return (this.c != null) && (this.c.b());
  }
  
  public void c()
  {
    if (this.c != null) {
      this.c.a();
    }
  }
  
  public void d()
  {
    cu.c(this.b).a(this.a);
    this.a.clear();
    cu.a(this.b, false);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.e.lock();
    for (;;)
    {
      try
      {
        int n = paramMessage.what;
        switch (n)
        {
        }
      }
      catch (Exception paramMessage)
      {
        ar.b(paramMessage);
        return;
        d();
        continue;
      }
      finally
      {
        this.e.unlock();
      }
      this.e.unlock();
      return;
      e();
      continue;
      f();
      continue;
      g();
      continue;
      a((JSONObject)paramMessage.obj);
      continue;
      a((String)paramMessage.obj);
      continue;
      b((JSONObject)paramMessage.obj);
      continue;
      d((JSONObject)paramMessage.obj);
      continue;
      c((JSONObject)paramMessage.obj);
      continue;
      h();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */