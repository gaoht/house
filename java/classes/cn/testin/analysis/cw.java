package cn.testin.analysis;

import android.os.Message;
import org.json.JSONObject;

class cw
  implements ff
{
  private cw(cu paramcu) {}
  
  public void a()
  {
    Message localMessage = cu.f(this.a).obtainMessage(4);
    cu.f(this.a).sendMessage(localMessage);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (!cu.f(this.a).hasMessages(2))
    {
      ar.a("send MESSAGE_SEND_STATE_FOR_EDITING");
      Message localMessage = cu.f(this.a).obtainMessage(2);
      localMessage.obj = paramJSONObject;
      cu.f(this.a).sendMessage(localMessage);
    }
  }
  
  public void b()
  {
    Message localMessage = cu.f(this.a).obtainMessage(6);
    cu.f(this.a).sendMessage(localMessage);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    Message localMessage = cu.f(this.a).obtainMessage(3);
    localMessage.obj = paramJSONObject;
    cu.f(this.a).sendMessage(localMessage);
  }
  
  public void c(JSONObject paramJSONObject)
  {
    Message localMessage = cu.f(this.a).obtainMessage(8);
    localMessage.obj = paramJSONObject;
    cu.f(this.a).sendMessage(localMessage);
  }
  
  public void d(JSONObject paramJSONObject)
  {
    Message localMessage = cu.f(this.a).obtainMessage(5);
    localMessage.obj = paramJSONObject;
    cu.f(this.a).sendMessage(localMessage);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */