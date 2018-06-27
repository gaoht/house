package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.smack.f;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a
  implements com.xiaomi.smack.debugger.a
{
  public static boolean a;
  private SimpleDateFormat b = new SimpleDateFormat("hh:mm:ss aaa");
  private com.xiaomi.smack.a c = null;
  private a d = null;
  private a e = null;
  private com.xiaomi.smack.d f = null;
  private final String g = "[Slim] ";
  
  static
  {
    boolean bool = true;
    if (j.c() == 1) {}
    for (;;)
    {
      a = bool;
      return;
      bool = false;
    }
  }
  
  public a(com.xiaomi.smack.a parama)
  {
    this.c = parama;
    a();
  }
  
  private void a()
  {
    this.d = new a(true);
    this.e = new a(false);
    this.c.a(this.d, this.d);
    this.c.b(this.e, this.e);
    this.f = new b(this);
  }
  
  class a
    implements f, com.xiaomi.smack.filter.a
  {
    String a;
    
    a(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (this$1 = " RCV ";; this$1 = " Sent ")
      {
        this.a = a.this;
        return;
      }
    }
    
    public void a(com.xiaomi.slim.b paramb)
    {
      if (a.a)
      {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + a.a(a.this).format(new Date()) + this.a + paramb.toString());
        return;
      }
      com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + a.a(a.this).format(new Date()) + this.a + " Blob [" + paramb.a() + "," + paramb.c() + "," + paramb.h() + "]");
    }
    
    public boolean a(com.xiaomi.smack.packet.d paramd)
    {
      return true;
    }
    
    public void b(com.xiaomi.smack.packet.d paramd)
    {
      if (a.a)
      {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + a.a(a.this).format(new Date()) + this.a + " PKT " + paramd.c());
        return;
      }
      com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + a.a(a.this).format(new Date()) + this.a + " PKT [" + paramd.l() + "," + paramd.k() + "]");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/measite/smack/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */