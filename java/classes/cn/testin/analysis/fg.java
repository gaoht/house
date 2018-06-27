package cn.testin.analysis;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.net.URI;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

class fg
  extends dt
{
  public fg(fd paramfd, URI paramURI, int paramInt)
  {
    super(paramURI, new eb(), null, paramInt);
    paramfd = paramURI.getScheme();
    if ((!TextUtils.isEmpty(paramfd)) && (paramfd.equals("wss")))
    {
      paramfd = a.r;
      if (paramfd == null) {}
    }
    try
    {
      a(paramfd.createSocket());
      return;
    }
    catch (IOException paramfd)
    {
      throw new InterruptedException();
    }
  }
  
  public void a(dn paramdn, er paramer)
  {
    super.a(paramdn, paramer);
  }
  
  public void a(dn paramdn, er paramer, ey paramey)
  {
    super.a(paramdn, paramer, paramey);
  }
  
  public void a(ey paramey)
  {
    ar.c("EditorConnection", "Websocket connected");
    a.m = true;
    if (fd.a(this.c) != null) {
      fd.a(this.c).a();
    }
  }
  
  public void a(Exception paramException)
  {
    ar.a(paramException);
    if ((paramException != null) && (paramException.getMessage() != null))
    {
      Log.e("EditorConnection", "Websocket Error: " + paramException.getMessage());
      return;
    }
    Log.e("EditorConnection", "Unknown websocket error occurred");
  }
  
  public void a(String paramString)
  {
    ar.c("EditorConnection", "Received message from editor:\n" + paramString);
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      str = localJSONObject.getString("type");
      if (str.equals("device_info_request"))
      {
        fd.b(this.c).a();
        return;
      }
      if (str.equals("snapshot_request"))
      {
        fd.b(this.c).a(localJSONObject);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Log.e("EditorConnection", "Bad JSON received:" + paramString, localJSONException);
      return;
    }
    if (str.equals("change_request"))
    {
      fd.b(this.c).b(localJSONException);
      return;
    }
    if (str.equals("event_binding_request"))
    {
      fd.b(this.c).d(localJSONException);
      return;
    }
    if (str.equals("clear_request"))
    {
      fd.b(this.c).c(localJSONException);
      return;
    }
    boolean bool = str.equals("tweak_request");
    if (bool) {}
  }
  
  public void b(int paramInt, String paramString, boolean paramBoolean)
  {
    ar.c("EditorConnection", "WebSocket closed. Code: " + paramInt + ", reason: " + paramString + "\nURI: " + fd.c(this.c));
    a.m = false;
    fd.b(this.c).b();
    if (fd.a(this.c) != null) {
      fd.a(this.c).a(paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */