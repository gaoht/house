package d;

import java.io.IOException;

public abstract class h
  implements t
{
  private final t delegate;
  
  public h(t paramt)
  {
    if (paramt == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.delegate = paramt;
  }
  
  public void close()
    throws IOException
  {
    this.delegate.close();
  }
  
  public final t delegate()
  {
    return this.delegate;
  }
  
  public long read(c paramc, long paramLong)
    throws IOException
  {
    return this.delegate.read(paramc, paramLong);
  }
  
  public u timeout()
  {
    return this.delegate.timeout();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */