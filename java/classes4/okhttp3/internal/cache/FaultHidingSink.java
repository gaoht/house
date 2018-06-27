package okhttp3.internal.cache;

import d.c;
import d.g;
import d.s;
import java.io.IOException;

class FaultHidingSink
  extends g
{
  private boolean hasErrors;
  
  FaultHidingSink(s params)
  {
    super(params);
  }
  
  public void close()
    throws IOException
  {
    if (this.hasErrors) {
      return;
    }
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      this.hasErrors = true;
      onException(localIOException);
    }
  }
  
  public void flush()
    throws IOException
  {
    if (this.hasErrors) {
      return;
    }
    try
    {
      super.flush();
      return;
    }
    catch (IOException localIOException)
    {
      this.hasErrors = true;
      onException(localIOException);
    }
  }
  
  protected void onException(IOException paramIOException) {}
  
  public void write(c paramc, long paramLong)
    throws IOException
  {
    if (this.hasErrors)
    {
      paramc.skip(paramLong);
      return;
    }
    try
    {
      super.write(paramc, paramLong);
      return;
    }
    catch (IOException paramc)
    {
      this.hasErrors = true;
      onException(paramc);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/internal/cache/FaultHidingSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */