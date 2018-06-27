package com.growingio.android.sdk.collection;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class Diagnose
{
  String a;
  String b;
  HashMap<String, Integer> c;
  
  Diagnose(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = new HashMap();
  }
  
  Diagnose(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      for (;;)
      {
        try
        {
          this.a = paramString;
          this.c = new HashMap();
          paramString = paramJSONObject.keys();
          if (!paramString.hasNext()) {
            break;
          }
          String str = (String)paramString.next();
          if (str.equals("detail_date")) {
            this.b = paramJSONObject.getString("detail_date");
          } else {
            this.c.put(str, Integer.valueOf(paramJSONObject.getInt(str)));
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
    } while (this.b != null);
    this.b = DiagnoseLog.a.format(new Date());
  }
  
  String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.c != null)
      {
        Iterator localIterator = this.c.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject.put(str, this.c.get(str));
          continue;
          return localJSONObject.toString();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    for (;;)
    {
      localJSONObject.put("detail_date", this.b);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/collection/Diagnose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */