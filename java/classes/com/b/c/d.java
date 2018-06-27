package com.b.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class d
{
  private final List<b> a = new ArrayList();
  
  public <T extends b> void addDirectory(T paramT)
  {
    this.a.add(paramT);
  }
  
  public boolean containsDirectoryOfType(Class<? extends b> paramClass)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (paramClass.isAssignableFrom(((b)localIterator.next()).getClass())) {
        return true;
      }
    }
    return false;
  }
  
  public Iterable<b> getDirectories()
  {
    return this.a;
  }
  
  public <T extends b> Collection<T> getDirectoriesOfType(Class<T> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (paramClass.isAssignableFrom(localb.getClass())) {
        localArrayList.add(localb);
      }
    }
    return localArrayList;
  }
  
  public int getDirectoryCount()
  {
    return this.a.size();
  }
  
  public <T extends b> T getFirstDirectoryOfType(Class<T> paramClass)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (paramClass.isAssignableFrom(localb.getClass())) {
        return localb;
      }
    }
    return null;
  }
  
  public boolean hasErrors()
  {
    Iterator localIterator = getDirectories().iterator();
    while (localIterator.hasNext()) {
      if (((b)localIterator.next()).hasErrors()) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    int i = getDirectoryCount();
    if (i == 1) {}
    for (String str = "directory";; str = "directories") {
      return String.format("Metadata (%d %s)", new Object[] { Integer.valueOf(i), str });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */