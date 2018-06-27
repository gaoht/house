package cn.testin.analysis;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ad
  extends r
  implements b
{
  private final String b = "PV";
  private final int c = 21600000;
  private Map<String, Pair> d = new HashMap();
  private int e = 60;
  private int f = 10;
  private o g;
  private ConcurrentHashMap<Pair<String, String>, Long> h = new ConcurrentHashMap();
  private HashMap<Pair<String, String>, Long> i;
  
  public ad(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private long a(int paramInt)
  {
    Date localDate = new Date();
    long l;
    if (paramInt == 60) {
      l = a(localDate, "yyyy-MM-dd HH:mm");
    }
    for (;;)
    {
      return l / 1000L;
      if ((paramInt > 60) && (paramInt < 3600))
      {
        l = a(localDate, "yyyy-MM-dd HH");
        l = (localDate.getTime() - l) / (paramInt * 1000) * (paramInt * 1000) + l;
      }
      else if (paramInt == 3600)
      {
        l = a(localDate, "yyyy-MM-dd HH");
      }
      else if (paramInt > 3600)
      {
        l = a(localDate, "yyyy-MM-dd");
        l = (localDate.getTime() - l) / (paramInt * 1000) * (paramInt * 1000) + l;
      }
      else
      {
        l = localDate.getTime();
      }
    }
  }
  
  private long a(Date paramDate, String paramString)
  {
    paramString = new SimpleDateFormat(paramString);
    try
    {
      paramString = paramString.parse(paramString.format(new Date()));
      paramDate = paramString;
      long l = paramString.getTime();
      return l;
    }
    catch (ParseException paramString)
    {
      ar.a(paramString);
    }
    return paramDate.getTime();
  }
  
  private Pair a(String paramString)
  {
    synchronized (this.d)
    {
      if ((this.d == null) || (this.d.size() == 0)) {
        return null;
      }
      paramString = (Pair)this.d.get(paramString);
      return paramString;
    }
  }
  
  private void a(Map<String, Pair> paramMap, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("gatherInterval", paramInt1);
        localJSONObject1.put("toUploadCount", paramInt2);
        localJSONObject2 = new JSONObject();
        if (paramMap != null)
        {
          paramMap = paramMap.entrySet().iterator();
          while (paramMap.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)paramMap.next();
            Pair localPair = (Pair)localEntry.getValue();
            JSONObject localJSONObject3 = new JSONObject();
            localJSONObject3.put("componentsKey", localPair.first);
            localJSONObject3.put("expId", localPair.second);
            localJSONObject2.put((String)localEntry.getKey(), localJSONObject3);
            continue;
            paramMap = "";
          }
        }
      }
      catch (JSONException paramMap)
      {
        ar.a(paramMap);
      }
    }
    for (;;)
    {
      au.a(au.b(this.a), "eventsInfo", paramMap);
      return;
      localJSONObject1.put("events", localJSONObject2);
      paramMap = localJSONObject1.toString();
    }
  }
  
  private Map<Pair<String, String>, Long> d()
  {
    if (a.i == 1)
    {
      if (this.i == null) {
        this.i = new HashMap();
      }
      return this.i;
    }
    return this.h;
  }
  
  private void e()
  {
    synchronized (this.h)
    {
      au.a(au.b(this.a), "PVs", aq.c(this.h));
      return;
    }
  }
  
  private boolean f()
  {
    return !au.f(this.a);
  }
  
  private boolean g()
  {
    if (au.f(this.a)) {
      return false;
    }
    if (a.p) {
      return true;
    }
    return au.a("up");
  }
  
  private void h()
  {
    HashMap localHashMap = aq.c(au.a(au.b(this.a), "PVs"));
    if (localHashMap != null) {
      this.h.putAll(localHashMap);
    }
  }
  
  protected void a()
  {
    if (this.g == null) {
      this.g = new o();
    }
    c();
    h();
  }
  
  protected void a(Pair<String, String> paramPair)
  {
    try
    {
      if (b(paramPair)) {
        return;
      }
      d().put(paramPair, Long.valueOf(System.currentTimeMillis()));
      if (a.i != 1) {
        e();
      }
      a("PV", 1.0D, (String)paramPair.first, (String)paramPair.second);
      return;
    }
    catch (Exception paramPair)
    {
      ar.b(paramPair);
    }
  }
  
  public void a(k paramk)
  {
    for (;;)
    {
      synchronized (this.d)
      {
        this.d.clear();
        if ((paramk == null) || (paramk.c == null) || (paramk.c.h == null) || (paramk.c.h.isEmpty()))
        {
          this.g.a();
          this.h.clear();
          e();
          a(this.d, this.e, this.f);
          return;
        }
        this.e = paramk.c.a;
        this.f = paramk.c.b;
        HashSet localHashSet = new HashSet();
        paramk = paramk.c.h.iterator();
        Object localObject;
        if (paramk.hasNext())
        {
          m localm = (m)paramk.next();
          localObject = localm.i;
          Pair localPair = av.a(localm.g, localm.c);
          if ((localObject == null) || (localObject.length <= 0) || (localm.e != 1)) {
            continue;
          }
          localHashSet.add(localPair);
          int k = localObject.length;
          int j = 0;
          if (j < k)
          {
            localm = localObject[j];
            this.d.put(localm, localPair);
            j += 1;
            continue;
          }
          continue;
        }
        paramk = new HashMap(this.h).keySet().iterator();
        if (paramk.hasNext())
        {
          localObject = (Pair)paramk.next();
          if (localHashSet.contains(localObject)) {
            continue;
          }
          this.h.remove(localObject);
        }
      }
      e();
    }
  }
  
  protected void a(String paramString, double paramDouble)
  {
    Pair localPair = a(paramString);
    if (localPair == null)
    {
      ar.d(paramString + "未定义或未获取到相关实验信息");
      return;
    }
    a(paramString, paramDouble, (String)localPair.first, (String)localPair.second);
  }
  
  public void a(String paramString1, double paramDouble, String paramString2, String paramString3)
  {
    if (!f()) {}
    int j;
    do
    {
      return;
      if ((!"PV".equals(paramString1)) && (!c(av.a(paramString3, paramString2))))
      {
        ar.e(paramString1 + "相关实验未触发");
        return;
      }
      long l = a(this.e);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("name", paramString1);
      localContentValues.put("value", Double.valueOf(paramDouble));
      localContentValues.put("expId", paramString3);
      localContentValues.put("componentsKey", paramString2);
      localContentValues.put("timestamp", Long.valueOf(l));
      j = this.g.a(localContentValues);
    } while ((a.i != 1) && (j < this.f));
    b();
  }
  
  protected void b()
  {
    if (!g()) {}
    while ((a.j) && (!at.d(a.d))) {
      return;
    }
    au.a("up", true);
    a(new ae(this, ak.b));
  }
  
  protected boolean b(Pair paramPair)
  {
    if (a.i == 1) {
      return false;
    }
    Map localMap = d();
    if (!localMap.containsKey(paramPair)) {
      return false;
    }
    long l2 = System.currentTimeMillis();
    paramPair = (Long)localMap.get(paramPair);
    if (paramPair == null) {}
    for (long l1 = 0L; l2 - l1 < 21600000L; l1 = paramPair.longValue()) {
      return true;
    }
    return false;
  }
  
  protected void c()
  {
    Object localObject1 = au.a(au.b(this.a), "eventsInfo");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    HashMap localHashMap1;
    for (;;)
    {
      HashMap localHashMap2;
      Object localObject2;
      try
      {
        localHashMap1 = new HashMap();
        localHashMap2 = new HashMap();
        localObject1 = new JSONObject((String)localObject1);
        this.e = ((JSONObject)localObject1).optInt("gatherInterval");
        this.f = ((JSONObject)localObject1).optInt("toUploadCount");
        JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject("events");
        Iterator localIterator = localJSONObject.keys();
        if (!localIterator.hasNext()) {
          break;
        }
        String str1 = (String)localIterator.next();
        localObject2 = localJSONObject.optJSONObject(str1);
        if (((JSONObject)localObject2).length() == 0) {
          continue;
        }
        localObject1 = ((JSONObject)localObject2).optString("expId");
        String str2 = ((JSONObject)localObject2).optString("componentsKey");
        localObject2 = (String)localObject1 + "," + str2;
        if (localHashMap2.containsKey(localObject2))
        {
          localObject1 = (Pair)localHashMap2.get(localObject2);
          localHashMap1.put(str1, localObject1);
          continue;
        }
        localPair = av.a(localJSONException, str2);
      }
      catch (JSONException localJSONException)
      {
        ar.a(localJSONException);
        return;
      }
      Pair localPair;
      localHashMap2.put(localObject2, localPair);
    }
    this.d.putAll(localHashMap1);
  }
  
  protected boolean c(Pair paramPair)
  {
    return d().containsKey(paramPair);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */