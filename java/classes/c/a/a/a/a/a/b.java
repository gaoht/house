package c.a.a.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class b
  implements Iterable<f>
{
  private final List<f> a = new LinkedList();
  private final Map<String, List<f>> b = new HashMap();
  
  public void addField(f paramf)
  {
    if (paramf == null) {
      return;
    }
    String str = paramf.getName().toLowerCase(Locale.US);
    List localList = (List)this.b.get(str);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.b.put(str, localObject);
    }
    ((List)localObject).add(paramf);
    this.a.add(paramf);
  }
  
  public f getField(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.toLowerCase(Locale.US);
    paramString = (List)this.b.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (f)paramString.get(0);
    }
    return null;
  }
  
  public List<f> getFields()
  {
    return new ArrayList(this.a);
  }
  
  public List<f> getFields(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.toLowerCase(Locale.US);
    paramString = (List)this.b.get(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {
      return Collections.emptyList();
    }
    return new ArrayList(paramString);
  }
  
  public Iterator<f> iterator()
  {
    return Collections.unmodifiableList(this.a).iterator();
  }
  
  public int removeFields(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    paramString = paramString.toLowerCase(Locale.US);
    paramString = (List)this.b.remove(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {
      return 0;
    }
    this.a.removeAll(paramString);
    return paramString.size();
  }
  
  public void setField(f paramf)
  {
    if (paramf == null) {
      return;
    }
    Object localObject = paramf.getName().toLowerCase(Locale.US);
    localObject = (List)this.b.get(localObject);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      addField(paramf);
      return;
    }
    ((List)localObject).clear();
    ((List)localObject).add(paramf);
    localObject = this.a.iterator();
    int i = 0;
    int k;
    for (int j = -1; ((Iterator)localObject).hasNext(); j = k)
    {
      k = j;
      if (((f)((Iterator)localObject).next()).getName().equalsIgnoreCase(paramf.getName()))
      {
        ((Iterator)localObject).remove();
        k = j;
        if (j == -1) {
          k = i;
        }
      }
      i += 1;
    }
    this.a.add(j, paramf);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/a/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */