package com.megvii.zhimasdk.b;

import android.os.SystemClock;
import com.megvii.zhimasdk.b.a.n.e;
import com.megvii.zhimasdk.b.a.z;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;

class s
  implements com.megvii.zhimasdk.b.a.b.j
{
  private static final HashSet<Class<?>> a = new HashSet();
  private static final HashSet<Class<?>> b = new HashSet();
  private final int c;
  private final int d;
  
  static
  {
    a.add(z.class);
    a.add(UnknownHostException.class);
    a.add(SocketException.class);
    b.add(InterruptedIOException.class);
    b.add(SSLException.class);
  }
  
  public s(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public boolean a(IOException paramIOException, int paramInt, e parame)
  {
    boolean bool2 = true;
    Boolean localBoolean = (Boolean)parame.a("http.request_sent");
    int i;
    boolean bool1;
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      i = 1;
      if (paramInt <= this.c) {
        break label70;
      }
      bool1 = false;
    }
    for (;;)
    {
      if ((!bool1) || ((com.megvii.zhimasdk.b.a.b.c.j)parame.a("http.request") != null)) {
        break label118;
      }
      return false;
      i = 0;
      break;
      label70:
      bool1 = bool2;
      if (!a(a, paramIOException)) {
        if (a(b, paramIOException))
        {
          bool1 = false;
        }
        else
        {
          bool1 = bool2;
          if (i == 0) {
            bool1 = bool2;
          }
        }
      }
    }
    label118:
    if (bool1) {
      SystemClock.sleep(this.d);
    }
    for (;;)
    {
      return bool1;
      paramIOException.printStackTrace();
    }
  }
  
  protected boolean a(HashSet<Class<?>> paramHashSet, Throwable paramThrowable)
  {
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext()) {
      if (((Class)paramHashSet.next()).isInstance(paramThrowable)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */