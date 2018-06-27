package com.superrtc.mediamanager;

import android.util.Log;
import java.net.URISyntaxException;
import org.json.JSONException;
import org.json.JSONObject;

public class XClientBridger
{
  private String a = "";
  private b b;
  private a c = new a()
  {
    public void onLog(int paramAnonymousInt, String paramAnonymousString)
    {
      Log.i("Xsignalclient", paramAnonymousString);
    }
  };
  private a d = this.c;
  
  static
  {
    System.loadLibrary("hyphenate_av");
    try
    {
      System.loadLibrary("xsignal_client");
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("Xsignalclient", "not xsignal_client " + localThrowable.getMessage());
    }
  }
  
  public XClientBridger(b paramb)
  {
    nativeRegisterXsignalclient();
    a(paramb);
  }
  
  private native int nativeRegisterXsignalclient();
  
  private native int nativejsonrecvstring(String paramString1, String paramString2);
  
  private native int nativejsonreq(String paramString1, String paramString2);
  
  private native void nativesetlogfunc();
  
  XClientBridger a(b paramb)
  {
    this.b = paramb;
    return this;
  }
  
  public void callbacklog(int paramInt, String paramString)
  {
    this.d.onLog(paramInt, paramString);
  }
  
  public int invokeWithDict(String paramString, String[] paramArrayOfString)
  {
    int i = nativejsonreq(paramString, this.a);
    int j = this.a.length();
    if (paramArrayOfString != null)
    {
      if (j <= 0) {
        break label41;
      }
      paramArrayOfString[0] = this.a;
    }
    while (i != 0)
    {
      return i;
      label41:
      paramArrayOfString[0] = "";
    }
    return 0;
  }
  
  public int jsonrecvstring(String paramString1, String paramString2)
  {
    return nativejsonrecvstring(paramString1, paramString2);
  }
  
  public int jsonreq(String paramString1, String paramString2)
  {
    return nativejsonreq(paramString1, paramString2);
  }
  
  /* Error */
  public String oninvoke(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 33
    //   2: new 35	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   9: ldc 108
    //   11: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 111	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   24: pop
    //   25: new 113	org/json/JSONTokener
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 115	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 119	org/json/JSONTokener:nextValue	()Ljava/lang/Object;
    //   38: checkcast 121	org/json/JSONObject
    //   41: astore_1
    //   42: new 121	org/json/JSONObject
    //   45: dup
    //   46: invokespecial 122	org/json/JSONObject:<init>	()V
    //   49: astore_2
    //   50: aload_0
    //   51: getfield 82	com/superrtc/mediamanager/XClientBridger:b	Lcom/superrtc/mediamanager/XClientBridger$b;
    //   54: aload_1
    //   55: invokeinterface 126 2 0
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 127	org/json/JSONObject:toString	()Ljava/lang/String;
    //   65: areturn
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 130	org/json/JSONException:printStackTrace	()V
    //   71: aconst_null
    //   72: astore_1
    //   73: goto -31 -> 42
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 130	org/json/JSONException:printStackTrace	()V
    //   81: aload_2
    //   82: astore_1
    //   83: goto -22 -> 61
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 131	java/net/URISyntaxException:printStackTrace	()V
    //   91: goto -10 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	XClientBridger
    //   0	94	1	paramString1	String
    //   0	94	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   34	42	66	org/json/JSONException
    //   50	61	76	org/json/JSONException
    //   50	61	86	java/net/URISyntaxException
    //   77	81	86	java/net/URISyntaxException
  }
  
  public int onsendstring(String paramString1, String paramString2)
  {
    Log.i("Xsignalclient", "onsendstring");
    return this.b.onJsonSendWithConn(paramString1, paramString2);
  }
  
  public void setlogfunc(a parama)
  {
    if (parama != null) {}
    for (;;)
    {
      try
      {
        this.d = parama;
        nativesetlogfunc();
        return;
      }
      finally {}
      this.d = this.c;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onLog(int paramInt, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract JSONObject onJsonCallback(JSONObject paramJSONObject)
      throws JSONException, URISyntaxException;
    
    public abstract int onJsonSendWithConn(String paramString1, String paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/mediamanager/XClientBridger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */