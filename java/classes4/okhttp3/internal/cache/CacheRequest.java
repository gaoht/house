package okhttp3.internal.cache;

import d.s;
import java.io.IOException;

public abstract interface CacheRequest
{
  public abstract void abort();
  
  public abstract s body()
    throws IOException;
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/internal/cache/CacheRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */