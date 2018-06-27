package cn.testin.analysis;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class dl
{
  private Context a;
  private final Map<String, Typeface> b = new HashMap();
  private Map<String, dm> c;
  private dk d;
  
  public dl(Context paramContext)
  {
    this.a = paramContext;
    this.d = new dk();
    b();
  }
  
  private void b()
  {
    this.c = new HashMap();
    this.c.put("Sans", new dm(this, "sans", 0));
    this.c.put("Sans-Bold", new dm(this, "sans", 1));
    this.c.put("Sans-Italic", new dm(this, "sans", 2));
    this.c.put("Sans-Bold-Italic", new dm(this, "sans", 3));
    this.c.put("SanSerif", new dm(this, "sans-serif", 0));
    this.c.put("SanSerif-Bold", new dm(this, "sans-serif", 1));
    this.c.put("SanSerif-Italic", new dm(this, "sans-serif", 2));
    this.c.put("SanSerif-Bold-Italic", new dm(this, "sans-serif", 3));
    this.c.put("Serif", new dm(this, "serif", 0));
    this.c.put("Serif-Bold", new dm(this, "serif", 1));
    this.c.put("Serif-Italic", new dm(this, "serif", 2));
    this.c.put("Serif-Bold-Italic", new dm(this, "serif", 3));
    this.c.put("Monospace", new dm(this, "monospace", 0));
  }
  
  private Map<String, String> c()
  {
    localHashMap = new HashMap();
    AssetManager localAssetManager = this.a.getAssets();
    try
    {
      String[] arrayOfString = localAssetManager.list("fonts");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        String str1 = "fonts/" + str2;
        if ((!TextUtils.isEmpty(str1)) && (str1.endsWith(".ttf")))
        {
          Object localObject2 = this.d.a(this.a, str1);
          Object localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = str2.substring(0, str2.lastIndexOf(".ttf"));
          }
          localObject2 = Typeface.createFromAsset(localAssetManager, str1);
          localHashMap.put(localObject1, str1);
          this.b.put(str1, localObject2);
        }
        i += 1;
      }
      return localHashMap;
    }
    catch (Exception localException)
    {
      ar.f("Failed to load/parse assets font ");
    }
  }
  
  private Map<String, String> d()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject2 = (dm)((Map.Entry)localObject1).getValue();
      localObject1 = (String)((Map.Entry)localObject1).getKey();
      try
      {
        localObject2 = Typeface.create(dm.a((dm)localObject2), dm.b((dm)localObject2));
        this.b.put(localObject1, localObject2);
        localHashMap.put(localObject1, localObject1);
      }
      catch (Exception localException)
      {
        ar.f("Failed to load/parse " + (String)localObject1 + " font ");
      }
    }
    return localHashMap;
  }
  
  public Typeface a(String paramString)
  {
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {
      return (Typeface)localObject2;
    }
    if (this.b.containsKey(paramString)) {}
    for (Object localObject1 = (Typeface)this.b.get(paramString);; localObject1 = null)
    {
      if (localObject1 == null) {
        for (;;)
        {
          try
          {
            if (!this.c.containsKey(paramString)) {
              continue;
            }
            localObject2 = (dm)this.c.get(paramString);
            localObject2 = Typeface.create(dm.a((dm)localObject2), dm.b((dm)localObject2));
            localObject1 = localObject2;
            localObject2 = localObject1;
            if (localObject1 == null) {
              break;
            }
            try
            {
              this.b.put(paramString, localObject1);
              return (Typeface)localObject1;
            }
            catch (Exception localException1) {}
          }
          catch (Exception localException2)
          {
            Typeface localTypeface;
            continue;
          }
          ar.f("Failed to create " + paramString + " font ");
          return (Typeface)localObject1;
          localTypeface = Typeface.createFromAsset(this.a.getAssets(), paramString);
          localObject1 = localTypeface;
        }
      }
      return (Typeface)localObject1;
    }
  }
  
  public Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(d());
    localHashMap.putAll(c());
    return localHashMap;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */