package com.b.b;

import java.util.HashMap;
import java.util.Map;

public class d<T>
{
  private final a<T> a = new a();
  private int b;
  
  public void addPath(T paramT, byte[]... paramVarArgs)
  {
    Object localObject = this.a;
    int m = paramVarArgs.length;
    int j = 0;
    int i = 0;
    while (j < m)
    {
      byte[] arrayOfByte = paramVarArgs[j];
      int n = arrayOfByte.length;
      int k = 0;
      while (k < n)
      {
        byte b1 = arrayOfByte[k];
        a locala2 = (a)a.b((a)localObject).get(Byte.valueOf(b1));
        a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a();
          a.b((a)localObject).put(Byte.valueOf(b1), locala1);
        }
        k += 1;
        i += 1;
        localObject = locala1;
      }
      j += 1;
    }
    ((a)localObject).setValue(paramT);
    this.b = Math.max(this.b, i);
  }
  
  public T find(byte[] paramArrayOfByte)
  {
    a locala = this.a;
    Object localObject = a.a(locala);
    int j = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        byte b1 = paramArrayOfByte[i];
        locala = (a)a.b(locala).get(Byte.valueOf(b1));
        if (locala != null) {}
      }
      else
      {
        return (T)localObject;
      }
      if (a.a(locala) != null) {
        localObject = a.a(locala);
      }
      i += 1;
    }
  }
  
  public int getMaxDepth()
  {
    return this.b;
  }
  
  public void setDefaultValue(T paramT)
  {
    this.a.setValue(paramT);
  }
  
  static class a<T>
  {
    private final Map<Byte, a<T>> a = new HashMap();
    private T b = null;
    
    public void setValue(T paramT)
    {
      if (this.b != null) {
        throw new RuntimeException("Value already set for this trie node");
      }
      this.b = paramT;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */