package d;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class k
  implements t
{
  private final e a;
  private final Inflater b;
  private int c;
  private boolean d;
  
  k(e parame, Inflater paramInflater)
  {
    if (parame == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramInflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.a = parame;
    this.b = paramInflater;
  }
  
  public k(t paramt, Inflater paramInflater)
  {
    this(l.buffer(paramt), paramInflater);
  }
  
  private void a()
    throws IOException
  {
    if (this.c == 0) {
      return;
    }
    int i = this.c - this.b.getRemaining();
    this.c -= i;
    this.a.skip(i);
  }
  
  public void close()
    throws IOException
  {
    if (this.d) {
      return;
    }
    this.b.end();
    this.d = true;
    this.a.close();
  }
  
  public long read(c paramc, long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.d) {
      throw new IllegalStateException("closed");
    }
    if (paramLong == 0L) {
      return 0L;
    }
    for (;;)
    {
      boolean bool = refill();
      try
      {
        p localp = paramc.a(1);
        int i = (int)Math.min(paramLong, 8192 - localp.c);
        i = this.b.inflate(localp.a, localp.c, i);
        if (i > 0)
        {
          localp.c += i;
          paramc.b += i;
          return i;
        }
        if ((this.b.finished()) || (this.b.needsDictionary()))
        {
          a();
          if (localp.b == localp.c)
          {
            paramc.a = localp.pop();
            q.a(localp);
          }
        }
        else
        {
          if (!bool) {
            continue;
          }
          throw new EOFException("source exhausted prematurely");
        }
      }
      catch (DataFormatException paramc)
      {
        throw new IOException(paramc);
      }
    }
    return -1L;
  }
  
  public boolean refill()
    throws IOException
  {
    if (!this.b.needsInput()) {
      return false;
    }
    a();
    if (this.b.getRemaining() != 0) {
      throw new IllegalStateException("?");
    }
    if (this.a.exhausted()) {
      return true;
    }
    p localp = this.a.buffer().a;
    this.c = (localp.c - localp.b);
    this.b.setInput(localp.a, localp.b, this.c);
    return false;
  }
  
  public u timeout()
  {
    return this.a.timeout();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */