package com.xiaomi.measite.smack;

import com.xiaomi.smack.d;
import java.text.SimpleDateFormat;
import java.util.Date;

class b
  implements d
{
  b(a parama) {}
  
  public void a(com.xiaomi.smack.a parama)
  {
    com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + a.a(this.a).format(new Date()) + " Connection reconnected (" + a.b(this.a).hashCode() + ")");
  }
  
  public void a(com.xiaomi.smack.a parama, int paramInt, Exception paramException)
  {
    com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + a.a(this.a).format(new Date()) + " Connection closed (" + a.b(this.a).hashCode() + ")");
  }
  
  public void a(com.xiaomi.smack.a parama, Exception paramException)
  {
    com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + a.a(this.a).format(new Date()) + " Reconnection failed due to an exception (" + a.b(this.a).hashCode() + ")");
    paramException.printStackTrace();
  }
  
  public void b(com.xiaomi.smack.a parama)
  {
    com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + a.a(this.a).format(new Date()) + " Connection started (" + a.b(this.a).hashCode() + ")");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/measite/smack/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */