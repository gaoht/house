package cn.testin.analysis;

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ec
  extends dw
{
  protected boolean f = false;
  protected List<eo> g = new LinkedList();
  protected ByteBuffer h;
  private final Random i = new Random();
  
  public dy a(er paramer)
  {
    if ((paramer.c("Origin")) && (a(paramer))) {
      return dy.a;
    }
    return dy.b;
  }
  
  public dy a(er paramer, ey paramey)
  {
    if ((paramer.b("WebSocket-Origin").equals(paramey.b("Origin"))) && (a(paramey))) {
      return dy.a;
    }
    return dy.b;
  }
  
  public es a(es parames)
  {
    parames.a("Upgrade", "WebSocket");
    parames.a("Connection", "Upgrade");
    if (!parames.c("Origin")) {
      parames.a("Origin", "random" + this.i.nextInt());
    }
    return parames;
  }
  
  public et a(er paramer, ez paramez)
  {
    paramez.a("Web Socket Protocol Handshake");
    paramez.a("Upgrade", "WebSocket");
    paramez.a("Connection", paramer.b("Connection"));
    paramez.a("WebSocket-Origin", paramer.b("Origin"));
    paramez.a("WebSocket-Location", "ws://" + paramer.b("Host") + paramer.a());
    return paramez;
  }
  
  public ByteBuffer a(eo parameo)
  {
    if (parameo.f() != ep.b) {
      throw new RuntimeException("only text frames supported");
    }
    parameo = parameo.c();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(parameo.remaining() + 2);
    localByteBuffer.put((byte)0);
    parameo.mark();
    localByteBuffer.put(parameo);
    parameo.reset();
    localByteBuffer.put((byte)-1);
    localByteBuffer.flip();
    return localByteBuffer;
  }
  
  public void a()
  {
    this.f = false;
    this.h = null;
  }
  
  public dx b()
  {
    return dx.a;
  }
  
  public dw c()
  {
    return new ec();
  }
  
  public List<eo> c(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = e(paramByteBuffer);
    if (paramByteBuffer == null) {
      throw new ef(1002);
    }
    return paramByteBuffer;
  }
  
  public ByteBuffer d()
  {
    return ByteBuffer.allocate(b);
  }
  
  protected List<eo> e(ByteBuffer paramByteBuffer)
  {
    Object localObject2 = null;
    while (paramByteBuffer.hasRemaining())
    {
      byte b = paramByteBuffer.get();
      if (b == 0)
      {
        if (this.f) {
          throw new eg("unexpected START_OF_FRAME");
        }
        this.f = true;
      }
      else if (b == -1)
      {
        if (!this.f) {
          throw new eg("unexpected END_OF_FRAME");
        }
        if (this.h != null)
        {
          this.h.flip();
          localObject1 = new eq();
          ((eq)localObject1).a(this.h);
          ((eq)localObject1).a(true);
          ((eq)localObject1).a(ep.b);
          this.g.add(localObject1);
          this.h = null;
          paramByteBuffer.mark();
        }
        this.f = false;
      }
      else
      {
        localObject1 = localObject2;
        if (!this.f) {
          return localObject1;
        }
        if (this.h == null) {
          this.h = d();
        }
        for (;;)
        {
          this.h.put(b);
          break;
          if (!this.h.hasRemaining()) {
            this.h = f(this.h);
          }
        }
      }
    }
    Object localObject1 = this.g;
    this.g = new LinkedList();
    return (List<eo>)localObject1;
  }
  
  public ByteBuffer f(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.flip();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(a(paramByteBuffer.capacity() * 2));
    localByteBuffer.put(paramByteBuffer);
    return localByteBuffer;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */