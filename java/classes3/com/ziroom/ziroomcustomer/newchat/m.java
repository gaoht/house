package com.ziroom.ziroomcustomer.newchat;

import org.json.JSONException;
import org.json.JSONObject;

public class m
{
  private int a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  
  public m(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
  }
  
  public static m getEntityFromJSONObject(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("order");
      paramJSONObject = new m(paramJSONObject.getInt("id"), paramJSONObject.getString("title"), paramJSONObject.getString("order_title"), paramJSONObject.getString("price"), paramJSONObject.getString("desc"), paramJSONObject.getString("img_url"), paramJSONObject.getString("item_url"));
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public String getDesc()
  {
    return this.e;
  }
  
  public int getId()
  {
    return this.a;
  }
  
  public String getImgUrl()
  {
    return this.f;
  }
  
  public String getItemUrl()
  {
    return this.g;
  }
  
  public JSONObject getJSONObject()
  {
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject2.put("id", this.a);
      localJSONObject2.put("title", this.b);
      localJSONObject2.put("order_title", this.c);
      localJSONObject2.put("price", this.d);
      localJSONObject2.put("desc", this.e);
      localJSONObject2.put("img_url", this.f);
      localJSONObject2.put("item_url", this.g);
      localJSONObject1.put("order", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject1;
  }
  
  public String getOrderTitle()
  {
    return this.c;
  }
  
  public String getPrice()
  {
    return this.d;
  }
  
  public String getTitle()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */