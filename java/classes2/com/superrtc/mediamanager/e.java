package com.superrtc.mediamanager;

import com.superrtc.a.f;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  public static f f;
  public String a;
  public String b;
  public String c;
  public String d;
  public a e;
  public k g;
  public b.b h;
  public String i;
  public boolean j;
  public int k;
  private c l;
  private JSONObject m;
  
  public e(c paramc, String paramString1, JSONObject paramJSONObject, String paramString2)
    throws JSONException
  {
    this.l = paramc;
    this.c = paramString1;
    this.m = paramJSONObject;
    this.b = paramJSONObject.optString("memName");
    this.a = paramJSONObject.optString("tktId");
    this.i = paramString2;
    this.j = false;
  }
  
  public static abstract interface a
  {
    public abstract void addStream(e parame, g paramg);
    
    public abstract void exitMember(e parame, b.c paramc);
    
    public abstract void joinMember(e parame, b.c paramc);
    
    public abstract void notice(e parame, a.b paramb, String paramString1, String paramString2, Object paramObject);
    
    public abstract void passiveCloseReason(e parame, int paramInt, String paramString);
    
    public abstract void removeStream(e parame, g paramg);
    
    public abstract void updateStream(e parame, g paramg);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/mediamanager/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */