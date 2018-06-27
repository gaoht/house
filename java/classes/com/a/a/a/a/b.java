package com.a.a.a.a;

import java.util.ArrayList;
import java.util.List;

public class b
{
  private List a = new ArrayList(5);
  
  public void add(d paramd)
  {
    this.a.add(paramd);
  }
  
  public d getSegment(int paramInt)
  {
    return (d)this.a.get(paramInt);
  }
  
  public int size()
  {
    return this.a.size();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    while (i < size())
    {
      localStringBuffer.append(getSegment(i));
      if (i < size() - 1)
      {
        int j = getSegment(i + 1).getKind();
        if ((j == 1) || (j == 2)) {
          localStringBuffer.append('/');
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */