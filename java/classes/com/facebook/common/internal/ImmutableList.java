package com.facebook.common.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableList<E>
  extends ArrayList<E>
{
  private ImmutableList(List<E> paramList)
  {
    super(paramList);
  }
  
  public static <E> ImmutableList<E> copyOf(List<E> paramList)
  {
    return new ImmutableList(paramList);
  }
  
  public static <E> ImmutableList<E> of(E... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    Collections.addAll(localArrayList, paramVarArgs);
    return new ImmutableList(localArrayList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/common/internal/ImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */