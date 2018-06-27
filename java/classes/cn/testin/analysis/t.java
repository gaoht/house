package cn.testin.analysis;

import android.text.TextUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class t
  extends ag
  implements af
{
  private List<String> e;
  
  public t(s params, String paramString)
  {
    super(paramString, null, null);
    this.d = this;
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(String paramString)
  {
    if ((this.e != null) && (this.e.size() > 0))
    {
      paramString = this.e.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if (!TextUtils.isEmpty(str)) {
          new File(str).delete();
        }
      }
    }
  }
  
  protected Object[] a()
  {
    Object[] arrayOfObject = new Object[2];
    List localList = s.a(this.a);
    if (localList.size() > 0)
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          localJSONArray.put(new JSONObject(am.a(str)));
        }
        catch (JSONException localJSONException)
        {
          ar.a(localJSONException);
          new File(str).delete();
        }
      }
      if (localJSONArray.length() > 0)
      {
        arrayOfObject[0] = localList;
        arrayOfObject[1] = s.a(this.a, localJSONArray);
      }
    }
    return arrayOfObject;
  }
  
  public void run()
  {
    try
    {
      Object[] arrayOfObject = a();
      if (arrayOfObject != null)
      {
        this.e = ((List)arrayOfObject[0]);
        this.c = ((String)arrayOfObject[1]);
        if (!TextUtils.isEmpty(this.c)) {
          b();
        }
      }
      else
      {
        a(-1, null);
        return;
      }
    }
    catch (Exception localException)
    {
      ar.a(localException);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */