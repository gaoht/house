package b;

import java.util.Locale;
import java.util.concurrent.CancellationException;

public class d
{
  private final f a;
  
  d(f paramf)
  {
    this.a = paramf;
  }
  
  public boolean isCancellationRequested()
  {
    return this.a.isCancellationRequested();
  }
  
  public e register(Runnable paramRunnable)
  {
    return this.a.a(paramRunnable);
  }
  
  public void throwIfCancellationRequested()
    throws CancellationException
  {
    this.a.a();
  }
  
  public String toString()
  {
    return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] { getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.a.isCancellationRequested()) });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */