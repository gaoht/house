package com.unionpay.mobile.android.nocard.views.xlistview;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static List<Map<String, Object>> a(Context paramContext, List<com.unionpay.mobile.android.model.c> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    if (i < paramList.size())
    {
      com.unionpay.mobile.android.model.c localc = (com.unionpay.mobile.android.model.c)paramList.get(i);
      HashMap localHashMap;
      String str;
      if (localc != null)
      {
        localHashMap = new HashMap();
        localHashMap.put("text1", localc.e());
        if (localc.c() != 0) {
          break label171;
        }
        str = localc.b();
        label95:
        localHashMap.put("text2", str);
        if (paramBoolean)
        {
          if (localc.c() != 0) {
            break label244;
          }
          localHashMap.put("editable", Boolean.TRUE);
          localHashMap.put("icon", com.unionpay.mobile.android.resource.c.a(paramContext).a(1016));
        }
      }
      for (;;)
      {
        localArrayList.add(localHashMap);
        label171:
        do
        {
          i += 1;
          break;
        } while (TextUtils.isEmpty(localc.b()));
        str = localc.b().substring(0, 4) + " **** **** " + localc.b().substring(localc.b().length() - 4);
        break label95;
        label244:
        localHashMap.put("editable", Boolean.FALSE);
        localHashMap.put("icon", null);
      }
    }
    return localArrayList;
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("href_label", paramJSONObject.get("label"));
      localJSONObject.put("name", "");
      localJSONObject.put("value", "");
      localJSONObject.put("href_title", paramString);
      localJSONObject.put("label", com.unionpay.mobile.android.languages.c.bD.z);
      localJSONObject.put("required", "0");
      localJSONObject.put("href_url", paramJSONObject.get("href"));
      localJSONObject.put("error_info", com.unionpay.mobile.android.languages.c.bD.aF);
      localJSONObject.put("checked", "0");
      return localJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return localJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/xlistview/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */