package b;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class a
  extends Exception
{
  private List<Throwable> a;
  
  public a(String paramString, List<? extends Throwable> paramList) {}
  
  public a(String paramString, Throwable[] paramArrayOfThrowable)
  {
    this(paramString, Arrays.asList(paramArrayOfThrowable));
  }
  
  public a(List<? extends Throwable> paramList)
  {
    this("There were multiple errors.", paramList);
  }
  
  @Deprecated
  public Throwable[] getCauses()
  {
    return (Throwable[])this.a.toArray(new Throwable[this.a.size()]);
  }
  
  @Deprecated
  public List<Exception> getErrors()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.a == null) {
      return localArrayList;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Throwable localThrowable = (Throwable)localIterator.next();
      if ((localThrowable instanceof Exception)) {
        localArrayList.add((Exception)localThrowable);
      } else {
        localArrayList.add(new Exception(localThrowable));
      }
    }
    return localArrayList;
  }
  
  public List<Throwable> getInnerThrowables()
  {
    return this.a;
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    super.printStackTrace(paramPrintStream);
    Iterator localIterator = this.a.iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      Throwable localThrowable = (Throwable)localIterator.next();
      paramPrintStream.append("\n");
      paramPrintStream.append("  Inner throwable #");
      i += 1;
      paramPrintStream.append(Integer.toString(i));
      paramPrintStream.append(": ");
      localThrowable.printStackTrace(paramPrintStream);
      paramPrintStream.append("\n");
    }
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    super.printStackTrace(paramPrintWriter);
    Iterator localIterator = this.a.iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      Throwable localThrowable = (Throwable)localIterator.next();
      paramPrintWriter.append("\n");
      paramPrintWriter.append("  Inner throwable #");
      i += 1;
      paramPrintWriter.append(Integer.toString(i));
      paramPrintWriter.append(": ");
      localThrowable.printStackTrace(paramPrintWriter);
      paramPrintWriter.append("\n");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */