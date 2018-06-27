package com.xiaomi.slim;

import android.text.TextUtils;
import com.xiaomi.push.protobuf.b.b;
import com.xiaomi.push.protobuf.b.f;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.ak.b;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

class c
{
  private ByteBuffer a = ByteBuffer.allocate(2048);
  private ByteBuffer b = ByteBuffer.allocate(4);
  private Adler32 c = new Adler32();
  private e d;
  private InputStream e;
  private f f;
  private volatile boolean g;
  
  c(InputStream paramInputStream, f paramf)
  {
    this.e = new BufferedInputStream(paramInputStream);
    this.f = paramf;
    this.d = new e();
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt)
  {
    int i = paramByteBuffer.position();
    int k;
    int j;
    do
    {
      k = this.e.read(paramByteBuffer.array(), i, paramInt);
      if (k == -1) {
        break;
      }
      j = paramInt - k;
      k = i + k;
      i = k;
      paramInt = j;
    } while (j > 0);
    paramByteBuffer.position(k);
    return;
    throw new EOFException();
  }
  
  private void d()
  {
    int i = 0;
    int j = 0;
    this.g = false;
    Object localObject1 = c();
    Object localObject2;
    Object localObject3;
    if ("CONN".equals(((b)localObject1).a()))
    {
      localObject1 = b.f.b(((b)localObject1).k());
      i = j;
      if (((b.f)localObject1).e())
      {
        this.f.a(((b.f)localObject1).d());
        i = 1;
      }
      if (((b.f)localObject1).h())
      {
        localObject2 = ((b.f)localObject1).i();
        localObject3 = new b();
        ((b)localObject3).a("SYNC", "CONF");
        ((b)localObject3).a(((b.b)localObject2).c(), null);
        this.f.a((b)localObject3);
      }
      com.xiaomi.channel.commonutils.logger.b.a("[Slim] CONN: host = " + ((b.f)localObject1).f());
    }
    if (i == 0)
    {
      com.xiaomi.channel.commonutils.logger.b.a("[Slim] Invalid CONN");
      throw new IOException("Invalid Connection");
      this.f.a((b)localObject1);
    }
    while (!this.g)
    {
      localObject1 = c();
      this.f.n();
      switch (((b)localObject1).m())
      {
      case 1: 
      default: 
        com.xiaomi.channel.commonutils.logger.b.a("[Slim] unknow blob type " + ((b)localObject1).m());
        break;
      case 2: 
        if (("SECMSG".equals(((b)localObject1).a())) && (TextUtils.isEmpty(((b)localObject1).b()))) {
          try
          {
            localObject2 = Integer.valueOf(((b)localObject1).c()).toString();
            localObject3 = ((b)localObject1).j();
            localObject2 = ak.a().b((String)localObject2, (String)localObject3);
            localObject2 = this.d.a(((b)localObject1).d(((ak.b)localObject2).i), this.f);
            this.f.b((com.xiaomi.smack.packet.d)localObject2);
          }
          catch (Exception localException1)
          {
            com.xiaomi.channel.commonutils.logger.b.a("[Slim] Parse packet from Blob " + ((b)localObject1).toString() + " failure:" + localException1.getMessage());
          }
        } else {
          this.f.a((b)localObject1);
        }
        break;
      case 3: 
        try
        {
          com.xiaomi.smack.packet.d locald = this.d.a(((b)localObject1).k(), this.f);
          this.f.b(locald);
        }
        catch (Exception localException2)
        {
          com.xiaomi.channel.commonutils.logger.b.a("[Slim] Parse packet from Blob " + ((b)localObject1).toString() + " failure:" + localException2.getMessage());
        }
      }
    }
  }
  
  private ByteBuffer e()
  {
    if (this.a.capacity() > 4096) {
      this.a = ByteBuffer.allocate(2048);
    }
    this.a.clear();
    a(this.a, b.n());
    int i = b.c(this.a.asReadOnlyBuffer());
    if (i > 32768) {
      throw new IOException("Blob size too large");
    }
    if (i + 4 > this.a.remaining())
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(b.n() + i);
      localByteBuffer.put(this.a.array(), 0, this.a.arrayOffset() + this.a.position());
      this.a = localByteBuffer;
    }
    a(this.a, i);
    this.b.clear();
    a(this.b, 4);
    this.b.position(0);
    i = this.b.getInt();
    this.c.reset();
    this.c.update(this.a.array(), 0, this.a.position());
    if (i != (int)this.c.getValue())
    {
      com.xiaomi.channel.commonutils.logger.b.a("CRC = " + (int)this.c.getValue() + " and " + i);
      throw new IOException("Corrupted Blob bad CRC");
    }
    return this.a;
  }
  
  void a()
  {
    try
    {
      d();
      return;
    }
    catch (IOException localIOException)
    {
      while (this.g) {}
      throw localIOException;
    }
  }
  
  void b()
  {
    this.g = true;
  }
  
  b c()
  {
    try
    {
      Object localObject = e();
      j = ((ByteBuffer)localObject).position();
      i = j;
    }
    catch (IOException localIOException1)
    {
      try
      {
        ((ByteBuffer)localObject).flip();
        localObject = b.b((ByteBuffer)localObject);
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + ((b)localObject).a() + ";chid=" + ((b)localObject).c() + ";len=" + j + "}");
        return (b)localObject;
      }
      catch (IOException localIOException2)
      {
        int j;
        int i;
        StringBuilder localStringBuilder;
        byte[] arrayOfByte;
        for (;;) {}
      }
      localIOException1 = localIOException1;
      j = 0;
    }
    if (j == 0) {
      i = this.a.position();
    }
    localStringBuilder = new StringBuilder().append("[Slim] read Blob [");
    arrayOfByte = this.a.array();
    j = i;
    if (i > b.n()) {
      j = b.n();
    }
    com.xiaomi.channel.commonutils.logger.b.a(com.xiaomi.channel.commonutils.misc.d.a(arrayOfByte, 0, j) + "] Err:" + localIOException1.getMessage());
    throw localIOException1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/slim/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */