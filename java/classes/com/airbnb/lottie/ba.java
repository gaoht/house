package com.airbnb.lottie;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

class ba
{
  private final List<n<?, Path>> a;
  private final List<az> b;
  
  ba(List<az> paramList)
  {
    this.b = paramList;
    this.a = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      this.a.add(((az)paramList.get(i)).b().createAnimation());
      i += 1;
    }
  }
  
  List<az> a()
  {
    return this.b;
  }
  
  List<n<?, Path>> b()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */