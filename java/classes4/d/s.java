package d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public abstract interface s
  extends Closeable, Flushable
{
  public abstract void close()
    throws IOException;
  
  public abstract void flush()
    throws IOException;
  
  public abstract u timeout();
  
  public abstract void write(c paramc, long paramLong)
    throws IOException;
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/d/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */