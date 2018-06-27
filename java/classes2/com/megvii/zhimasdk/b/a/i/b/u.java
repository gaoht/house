package com.megvii.zhimasdk.b.a.i.b;

import java.net.URI;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class u
  extends AbstractList<Object>
{
  private final Set<URI> a = new HashSet();
  private final List<URI> b = new ArrayList();
  
  public URI a(int paramInt)
  {
    return (URI)this.b.get(paramInt);
  }
  
  public boolean a(URI paramURI)
  {
    return this.a.contains(paramURI);
  }
  
  public void add(int paramInt, Object paramObject)
  {
    this.b.add(paramInt, (URI)paramObject);
    this.a.add((URI)paramObject);
  }
  
  public URI b(int paramInt)
  {
    URI localURI = (URI)this.b.remove(paramInt);
    this.a.remove(localURI);
    if (this.b.size() != this.a.size()) {
      this.a.addAll(this.b);
    }
    return localURI;
  }
  
  public void b(URI paramURI)
  {
    this.a.add(paramURI);
    this.b.add(paramURI);
  }
  
  public boolean contains(Object paramObject)
  {
    return this.a.contains(paramObject);
  }
  
  public Object set(int paramInt, Object paramObject)
  {
    URI localURI = (URI)this.b.set(paramInt, (URI)paramObject);
    this.a.remove(localURI);
    this.a.add((URI)paramObject);
    if (this.b.size() != this.a.size()) {
      this.a.addAll(this.b);
    }
    return localURI;
  }
  
  public int size()
  {
    return this.b.size();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */