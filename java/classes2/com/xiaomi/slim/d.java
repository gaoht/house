package com.xiaomi.slim;

import android.os.Build;
import android.os.Build.VERSION;
import com.xiaomi.push.protobuf.b.b;
import com.xiaomi.push.protobuf.b.e;
import com.xiaomi.push.service.at;
import com.xiaomi.smack.a;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

public class d
{
  ByteBuffer a = ByteBuffer.allocate(2048);
  private ByteBuffer b = ByteBuffer.allocate(4);
  private Adler32 c = new Adler32();
  private a d;
  private OutputStream e;
  private int f;
  private int g;
  
  d(OutputStream paramOutputStream, a parama)
  {
    this.e = new BufferedOutputStream(paramOutputStream);
    this.d = parama;
    paramOutputStream = TimeZone.getDefault();
    this.f = (paramOutputStream.getRawOffset() / 3600000);
    if (paramOutputStream.useDaylightTime()) {}
    for (int i = 1;; i = 0)
    {
      this.g = i;
      return;
    }
  }
  
  public int a(b paramb)
  {
    int i = paramb.l();
    if (i > 32768)
    {
      com.xiaomi.channel.commonutils.logger.b.a("Blob size=" + i + " should be less than " + 32768 + " Drop blob chid=" + paramb.c() + " id=" + paramb.h());
      return 0;
    }
    if (this.a.capacity() > 4096) {
      this.a = ByteBuffer.allocate(2048);
    }
    this.a.clear();
    this.a = paramb.a(this.a);
    this.c.reset();
    this.c.update(this.a.array(), 0, this.a.position());
    i = (int)this.c.getValue();
    this.b.putInt(0, i);
    this.e.write(this.a.array(), 0, this.a.position());
    this.e.write(this.b.array(), 0, 4);
    this.e.flush();
    i = this.a.position() + 4;
    com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + paramb.a() + ";chid=" + paramb.c() + ";len=" + i + "}");
    return i;
  }
  
  public void a()
  {
    b.e locale = new b.e();
    locale.a(106);
    locale.a(Build.MODEL);
    locale.b(Build.VERSION.INCREMENTAL);
    locale.c(at.e());
    locale.b(26);
    locale.d(this.d.e());
    locale.e(this.d.d());
    locale.f(Locale.getDefault().toString());
    locale.c(Build.VERSION.SDK_INT);
    Object localObject = this.d.c().a();
    if (localObject != null) {
      locale.a(b.b.b((byte[])localObject));
    }
    localObject = new b();
    ((b)localObject).a(0);
    ((b)localObject).a("CONN", null);
    ((b)localObject).a(0L, "xiaomi.com", null);
    ((b)localObject).a(locale.c(), null);
    a((b)localObject);
    com.xiaomi.channel.commonutils.logger.b.a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=" + 26 + " hash=" + at.e() + " tz=" + this.f + ":" + this.g + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
  }
  
  public void b()
  {
    b localb = new b();
    localb.a("CLOSE", null);
    a(localb);
    this.e.close();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/slim/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */