package d;

import java.io.Closeable;
import java.io.IOException;

public abstract interface t
  extends Closeable
{
  public abstract void close()
    throws IOException;
  
  public abstract long read(c paramc, long paramLong)
    throws IOException;
  
  public abstract u timeout();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/d/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */