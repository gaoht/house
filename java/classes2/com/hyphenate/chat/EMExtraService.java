package com.hyphenate.chat;

import android.util.Pair;
import com.hyphenate.cloud.EMHttpClient;
import com.hyphenate.cloud.HttpClientConfig;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.EMLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class EMExtraService
{
  private static final String TAG = EMExtraService.class.getSimpleName();
  private static final EMExtraService me = new EMExtraService();
  
  public static EMExtraService getInstance()
  {
    return me;
  }
  
  protected List<EMContact> getRobotsFromServer()
    throws HyphenateException
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = HttpClientConfig.getBaseUrlByAppKey() + "/robots";
    for (;;)
    {
      int i;
      try
      {
        localObject = EMHttpClient.getInstance().sendRequestWithToken((String)localObject, null, EMHttpClient.GET);
        if ((localObject != null) && (((Integer)((Pair)localObject).first).intValue() == 200))
        {
          localObject = new JSONObject((String)((Pair)localObject).second);
          if (!((JSONObject)localObject).has("entities")) {
            break;
          }
          localObject = ((JSONObject)localObject).getJSONArray("entities");
          i = 0;
          if (i >= ((JSONArray)localObject).length()) {
            break;
          }
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          EMContact localEMContact = new EMContact();
          localEMContact.username = localJSONObject.getString("username").toLowerCase();
          if (localJSONObject.has("name")) {
            localEMContact.nick = localJSONObject.getString("name");
          }
          if (localJSONObject.has("activated"))
          {
            bool = localJSONObject.getBoolean("activated");
            if (!bool) {
              break label269;
            }
            localArrayList.add(localEMContact);
            break label269;
          }
        }
        else
        {
          if (localObject != null)
          {
            EMLog.e(TAG, "getRobotUsers resp statusCode:" + ((Pair)localObject).first);
            return localArrayList;
          }
          EMLog.e(TAG, "getRobotUsers resp result is null");
          return localArrayList;
        }
      }
      catch (HyphenateException localHyphenateException)
      {
        throw localHyphenateException;
      }
      catch (JSONException localJSONException)
      {
        throw new HyphenateException(localJSONException.getMessage());
      }
      boolean bool = false;
      continue;
      label269:
      i += 1;
    }
    return localJSONException;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMExtraService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */