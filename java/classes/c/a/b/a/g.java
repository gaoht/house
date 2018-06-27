package c.a.b.a;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class g
  implements c
{
  private byte[] a;
  private TreeMap<String, String> b = new TreeMap(String.CASE_INSENSITIVE_ORDER);
  
  public void a(String paramString1, String paramString2)
  {
    this.b.put(paramString1, paramString2);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  public String b(String paramString)
  {
    String str = (String)this.b.get(paramString);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    return paramString;
  }
  
  public Iterator<String> c()
  {
    return Collections.unmodifiableSet(this.b.keySet()).iterator();
  }
  
  public boolean c(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public byte[] d()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */