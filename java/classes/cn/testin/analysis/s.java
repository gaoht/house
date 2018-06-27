package cn.testin.analysis;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s
  extends r
{
  private final int b = 10;
  private final int c = 50;
  private String d;
  private Executor e;
  
  public s(Context paramContext)
  {
    super(paramContext);
    paramContext = am.a(paramContext);
    if (paramContext != null) {
      this.d = (paramContext + "/errlog/");
    }
    this.e = Executors.newSingleThreadExecutor();
  }
  
  private String a(JSONArray paramJSONArray)
  {
    ai localai = new ai();
    localai.put("from", a.g);
    localai.put("platform", al.c() + "");
    localai.put("platformVersion", al.d() + "");
    localai.put("model", al.b());
    localai.put("records", paramJSONArray);
    return localai.a().toString();
  }
  
  private List<String> b()
  {
    Object localObject = new File(this.d);
    ArrayList localArrayList = new ArrayList();
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).list();
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          String str = localObject[i];
          if (!str.endsWith(".temp")) {
            localArrayList.add(this.d + str);
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (al.l(this.a)) {
      this.e.execute(new t(this, ak.c));
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("errorTime", System.currentTimeMillis());
      ((JSONObject)localObject).put("errorData", paramString);
      paramString = UUID.randomUUID().toString();
      paramString = this.d + paramString;
      String str = paramString + ".temp";
      am.a(str, ((JSONObject)localObject).toString());
      localObject = new File(str);
      if ((((File)localObject).exists()) && (!((File)localObject).renameTo(new File(paramString)))) {
        ((File)localObject).delete();
      }
      paramString = b();
      if (paramString.size() > 50)
      {
        int i = 0;
        while (i < paramString.size() - 50)
        {
          new File((String)paramString.get(i)).delete();
          i += 1;
        }
      }
      if (paramString.size() >= 10) {
        a();
      }
      return;
    }
    catch (JSONException paramString)
    {
      ar.a(paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */