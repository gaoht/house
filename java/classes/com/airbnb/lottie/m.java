package com.airbnb.lottie;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class m<V, O>
  implements k<O>
{
  final List<at<V>> a;
  final V b;
  
  m(V paramV)
  {
    this(Collections.emptyList(), paramV);
  }
  
  m(List<at<V>> paramList, V paramV)
  {
    this.a = paramList;
    this.b = paramV;
  }
  
  O a(V paramV)
  {
    return paramV;
  }
  
  public O getInitialValue()
  {
    return (O)a(this.b);
  }
  
  public boolean hasAnimation()
  {
    return !this.a.isEmpty();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseInitialValue=").append(this.b);
    if (!this.a.isEmpty()) {
      localStringBuilder.append(", values=").append(Arrays.toString(this.a.toArray()));
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */