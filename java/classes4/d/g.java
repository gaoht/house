package d;

import java.io.IOException;

public abstract class g
  implements s
{
  private final s delegate;
  
  public g(s params)
  {
    if (params == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.delegate = params;
  }
  
  public void close()
    throws IOException
  {
    this.delegate.close();
  }
  
  public final s delegate()
  {
    return this.delegate;
  }
  
  public void flush()
    throws IOException
  {
    this.delegate.flush();
  }
  
  public u timeout()
  {
    return this.delegate.timeout();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
  }
  
  public void write(c paramc, long paramLong)
    throws IOException
  {
    this.delegate.write(paramc, paramLong);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */