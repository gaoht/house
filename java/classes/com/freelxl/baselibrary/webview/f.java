package com.freelxl.baselibrary.webview;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public static List<f> toArrayList(String paramString)
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      int i = 0;
      if (i < localJSONArray.length())
      {
        f localf = new f();
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        if (localJSONObject.has("handlerName"))
        {
          paramString = localJSONObject.getString("handlerName");
          label61:
          localf.setHandlerName(paramString);
          if (!localJSONObject.has("callbackId")) {
            break label184;
          }
          paramString = localJSONObject.getString("callbackId");
          label85:
          localf.setCallbackId(paramString);
          if (!localJSONObject.has("responseData")) {
            break label189;
          }
          paramString = localJSONObject.getString("responseData");
          label109:
          localf.setResponseData(paramString);
          if (!localJSONObject.has("responseId")) {
            break label194;
          }
          paramString = localJSONObject.getString("responseId");
          label133:
          localf.setResponseId(paramString);
          if (!localJSONObject.has("data")) {
            break label199;
          }
        }
        label184:
        label189:
        label194:
        label199:
        for (paramString = localJSONObject.getString("data");; paramString = null)
        {
          localf.setData(paramString);
          localArrayList.add(localf);
          i += 1;
          break;
          paramString = null;
          break label61;
          paramString = null;
          break label85;
          paramString = null;
          break label109;
          paramString = null;
          break label133;
        }
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static f toObject(String paramString)
  {
    Object localObject = null;
    localf = new f();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("handlerName"))
      {
        paramString = localJSONObject.getString("handlerName");
        localf.setHandlerName(paramString);
        if (!localJSONObject.has("callbackId")) {
          break label133;
        }
        paramString = localJSONObject.getString("callbackId");
        label56:
        localf.setCallbackId(paramString);
        if (!localJSONObject.has("responseData")) {
          break label138;
        }
        paramString = localJSONObject.getString("responseData");
        label77:
        localf.setResponseData(paramString);
        if (!localJSONObject.has("responseId")) {
          break label143;
        }
      }
      label133:
      label138:
      label143:
      for (paramString = localJSONObject.getString("responseId");; paramString = null)
      {
        localf.setResponseId(paramString);
        paramString = (String)localObject;
        if (localJSONObject.has("data")) {
          paramString = localJSONObject.getString("data");
        }
        localf.setData(paramString);
        return localf;
        paramString = null;
        break;
        paramString = null;
        break label56;
        paramString = null;
        break label77;
      }
      return localf;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String getCallbackId()
  {
    return this.a;
  }
  
  public String getData()
  {
    return this.d;
  }
  
  public String getHandlerName()
  {
    return this.e;
  }
  
  public String getResponseData()
  {
    return this.c;
  }
  
  public String getResponseId()
  {
    return this.b;
  }
  
  public void setCallbackId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setData(String paramString)
  {
    this.d = paramString;
  }
  
  public void setHandlerName(String paramString)
  {
    this.e = paramString;
  }
  
  public void setResponseData(String paramString)
  {
    this.c = paramString;
  }
  
  public void setResponseId(String paramString)
  {
    this.b = paramString;
  }
  
  public String toJson()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("callbackId", getCallbackId());
      ((JSONObject)localObject).put("data", getData());
      ((JSONObject)localObject).put("handlerName", getHandlerName());
      ((JSONObject)localObject).put("responseData", getResponseData());
      ((JSONObject)localObject).put("responseId", getResponseId());
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/webview/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */