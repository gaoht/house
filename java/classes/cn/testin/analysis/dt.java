package cn.testin.analysis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public abstract class dt
  extends dq
  implements dn, Runnable
{
  protected URI a = null;
  private dr c = null;
  private Socket d = null;
  private InputStream e;
  private OutputStream f;
  private Proxy g = Proxy.NO_PROXY;
  private Thread h;
  private dw i;
  private Map<String, String> j;
  private CountDownLatch k = new CountDownLatch(1);
  private CountDownLatch l = new CountDownLatch(1);
  private int m = 0;
  
  static
  {
    if (!dt.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
  public dt(URI paramURI, dw paramdw, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException();
    }
    if (paramdw == null) {
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    this.a = paramURI;
    this.i = paramdw;
    this.j = paramMap;
    this.m = paramInt;
    this.c = new dr(this, paramdw);
  }
  
  private int h()
  {
    int i1 = this.a.getPort();
    int n = i1;
    String str;
    if (i1 == -1)
    {
      str = this.a.getScheme();
      if (str.equals("wss")) {
        n = 443;
      }
    }
    else
    {
      return n;
    }
    if (str.equals("ws")) {
      return 80;
    }
    throw new RuntimeException("unkonow scheme" + str);
  }
  
  private void i()
  {
    Object localObject2 = this.a.getPath();
    Object localObject3 = this.a.getQuery();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "/";
    }
    localObject2 = localObject1;
    if (localObject3 != null) {
      localObject2 = (String)localObject1 + "?" + (String)localObject3;
    }
    int n = h();
    localObject3 = new StringBuilder().append(this.a.getHost());
    if (n != 80) {}
    for (Object localObject1 = ":" + n;; localObject1 = "")
    {
      localObject3 = (String)localObject1;
      localObject1 = new eu();
      ((eu)localObject1).a((String)localObject2);
      ((eu)localObject1).a("Host", (String)localObject3);
      if (this.j == null) {
        break;
      }
      localObject2 = this.j.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((eu)localObject1).a((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
    }
    this.c.a((es)localObject1);
  }
  
  public InetSocketAddress a()
  {
    return this.c.a();
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean) {}
  
  public void a(dn paramdn, int paramInt, String paramString)
  {
    a(paramInt, paramString);
  }
  
  public final void a(dn paramdn, int paramInt, String paramString, boolean paramBoolean)
  {
    this.k.countDown();
    this.l.countDown();
    if (this.h != null) {
      this.h.interrupt();
    }
    try
    {
      if (this.d != null) {
        this.d.close();
      }
      b(paramInt, paramString, paramBoolean);
      return;
    }
    catch (IOException paramdn)
    {
      for (;;)
      {
        a(this, paramdn);
      }
    }
  }
  
  public void a(dn paramdn, eo parameo)
  {
    b(parameo);
  }
  
  public final void a(dn paramdn, ew paramew)
  {
    this.k.countDown();
    a((ey)paramew);
  }
  
  public final void a(dn paramdn, Exception paramException)
  {
    a(paramException);
  }
  
  public final void a(dn paramdn, String paramString)
  {
    a(paramString);
  }
  
  public final void a(dn paramdn, ByteBuffer paramByteBuffer)
  {
    a(paramByteBuffer);
  }
  
  public void a(eo parameo)
  {
    this.c.a(parameo);
  }
  
  public void a(ep paramep, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    this.c.a(paramep, paramByteBuffer, paramBoolean);
  }
  
  public abstract void a(ey paramey);
  
  public abstract void a(Exception paramException);
  
  public abstract void a(String paramString);
  
  public void a(Socket paramSocket)
  {
    if (this.d != null) {
      throw new IllegalStateException("socket has already been set");
    }
    this.d = paramSocket;
  }
  
  public void a(ByteBuffer paramByteBuffer) {}
  
  public void b()
  {
    if (this.h != null) {
      throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }
    this.h = new Thread(this);
    this.h.start();
  }
  
  public abstract void b(int paramInt, String paramString, boolean paramBoolean);
  
  public final void b(dn paramdn) {}
  
  public void b(dn paramdn, int paramInt, String paramString, boolean paramBoolean)
  {
    a(paramInt, paramString, paramBoolean);
  }
  
  public void b(eo parameo) {}
  
  public InetSocketAddress c(dn paramdn)
  {
    if (this.d != null) {
      return (InetSocketAddress)this.d.getLocalSocketAddress();
    }
    return null;
  }
  
  public boolean c()
  {
    b();
    this.k.await();
    return this.c.c();
  }
  
  public void d()
  {
    if (this.h != null) {
      this.c.a(1000);
    }
  }
  
  public boolean e()
  {
    return this.c.e();
  }
  
  public boolean f()
  {
    return this.c.f();
  }
  
  public boolean g()
  {
    return this.c.d();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	cn/testin/analysis/dt:d	Ljava/net/Socket;
    //   4: ifnonnull +185 -> 189
    //   7: aload_0
    //   8: new 221	java/net/Socket
    //   11: dup
    //   12: aload_0
    //   13: getfield 62	cn/testin/analysis/dt:g	Ljava/net/Proxy;
    //   16: invokespecial 298	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   19: putfield 55	cn/testin/analysis/dt:d	Ljava/net/Socket;
    //   22: aload_0
    //   23: getfield 55	cn/testin/analysis/dt:d	Ljava/net/Socket;
    //   26: invokevirtual 301	java/net/Socket:isBound	()Z
    //   29: ifne +32 -> 61
    //   32: aload_0
    //   33: getfield 55	cn/testin/analysis/dt:d	Ljava/net/Socket;
    //   36: new 277	java/net/InetSocketAddress
    //   39: dup
    //   40: aload_0
    //   41: getfield 51	cn/testin/analysis/dt:a	Ljava/net/URI;
    //   44: invokevirtual 149	java/net/URI:getHost	()Ljava/lang/String;
    //   47: aload_0
    //   48: invokespecial 146	cn/testin/analysis/dt:h	()I
    //   51: invokespecial 304	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   54: aload_0
    //   55: getfield 73	cn/testin/analysis/dt:m	I
    //   58: invokevirtual 308	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 55	cn/testin/analysis/dt:d	Ljava/net/Socket;
    //   66: invokevirtual 312	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   69: putfield 314	cn/testin/analysis/dt:e	Ljava/io/InputStream;
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 55	cn/testin/analysis/dt:d	Ljava/net/Socket;
    //   77: invokevirtual 318	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   80: putfield 96	cn/testin/analysis/dt:f	Ljava/io/OutputStream;
    //   83: aload_0
    //   84: invokespecial 320	cn/testin/analysis/dt:i	()V
    //   87: aload_0
    //   88: new 216	java/lang/Thread
    //   91: dup
    //   92: new 322	cn/testin/analysis/dv
    //   95: dup
    //   96: aload_0
    //   97: aconst_null
    //   98: invokespecial 325	cn/testin/analysis/dv:<init>	(Lcn/testin/analysis/dt;Lcn/testin/analysis/du;)V
    //   101: invokespecial 264	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   104: putfield 214	cn/testin/analysis/dt:h	Ljava/lang/Thread;
    //   107: aload_0
    //   108: getfield 214	cn/testin/analysis/dt:h	Ljava/lang/Thread;
    //   111: invokevirtual 267	java/lang/Thread:start	()V
    //   114: getstatic 327	cn/testin/analysis/dr:a	I
    //   117: newarray <illegal type>
    //   119: astore_2
    //   120: aload_0
    //   121: invokevirtual 328	cn/testin/analysis/dt:f	()Z
    //   124: ifne +106 -> 230
    //   127: aload_0
    //   128: getfield 314	cn/testin/analysis/dt:e	Ljava/io/InputStream;
    //   131: aload_2
    //   132: invokevirtual 334	java/io/InputStream:read	([B)I
    //   135: istore_1
    //   136: iload_1
    //   137: iconst_m1
    //   138: if_icmpeq +92 -> 230
    //   141: aload_0
    //   142: getfield 53	cn/testin/analysis/dt:c	Lcn/testin/analysis/dr;
    //   145: aload_2
    //   146: iconst_0
    //   147: iload_1
    //   148: invokestatic 340	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   151: invokevirtual 341	cn/testin/analysis/dr:a	(Ljava/nio/ByteBuffer;)V
    //   154: goto -34 -> 120
    //   157: astore_2
    //   158: aload_0
    //   159: getfield 53	cn/testin/analysis/dt:c	Lcn/testin/analysis/dr;
    //   162: invokevirtual 342	cn/testin/analysis/dr:b	()V
    //   165: getstatic 44	cn/testin/analysis/dt:b	Z
    //   168: ifne +61 -> 229
    //   171: aload_0
    //   172: getfield 55	cn/testin/analysis/dt:d	Ljava/net/Socket;
    //   175: invokevirtual 345	java/net/Socket:isClosed	()Z
    //   178: ifne +51 -> 229
    //   181: new 347	java/lang/AssertionError
    //   184: dup
    //   185: invokespecial 348	java/lang/AssertionError:<init>	()V
    //   188: athrow
    //   189: aload_0
    //   190: getfield 55	cn/testin/analysis/dt:d	Ljava/net/Socket;
    //   193: invokevirtual 345	java/net/Socket:isClosed	()Z
    //   196: ifeq -174 -> 22
    //   199: new 209	java/io/IOException
    //   202: dup
    //   203: invokespecial 349	java/io/IOException:<init>	()V
    //   206: athrow
    //   207: astore_2
    //   208: aload_0
    //   209: aload_0
    //   210: getfield 53	cn/testin/analysis/dt:c	Lcn/testin/analysis/dr;
    //   213: aload_2
    //   214: invokevirtual 229	cn/testin/analysis/dt:a	(Lcn/testin/analysis/dn;Ljava/lang/Exception;)V
    //   217: aload_0
    //   218: getfield 53	cn/testin/analysis/dt:c	Lcn/testin/analysis/dr;
    //   221: iconst_m1
    //   222: aload_2
    //   223: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   226: invokevirtual 354	cn/testin/analysis/dr:b	(ILjava/lang/String;)V
    //   229: return
    //   230: aload_0
    //   231: getfield 53	cn/testin/analysis/dt:c	Lcn/testin/analysis/dr;
    //   234: invokevirtual 342	cn/testin/analysis/dr:b	()V
    //   237: goto -72 -> 165
    //   240: astore_2
    //   241: aload_0
    //   242: aload_2
    //   243: invokevirtual 242	cn/testin/analysis/dt:a	(Ljava/lang/Exception;)V
    //   246: aload_0
    //   247: getfield 53	cn/testin/analysis/dt:c	Lcn/testin/analysis/dr;
    //   250: sipush 1006
    //   253: aload_2
    //   254: invokevirtual 355	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   257: invokevirtual 354	cn/testin/analysis/dr:b	(ILjava/lang/String;)V
    //   260: goto -95 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	dt
    //   135	13	1	n	int
    //   119	27	2	arrayOfByte	byte[]
    //   157	1	2	localIOException	IOException
    //   207	16	2	localException	Exception
    //   240	14	2	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   120	136	157	java/io/IOException
    //   141	154	157	java/io/IOException
    //   230	237	157	java/io/IOException
    //   0	22	207	java/lang/Exception
    //   22	61	207	java/lang/Exception
    //   61	87	207	java/lang/Exception
    //   189	207	207	java/lang/Exception
    //   120	136	240	java/lang/RuntimeException
    //   141	154	240	java/lang/RuntimeException
    //   230	237	240	java/lang/RuntimeException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */