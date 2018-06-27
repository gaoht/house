package com.facebook.common.internal;

public class Ints
{
  public static int max(int... paramVarArgs)
  {
    int i = 1;
    if (paramVarArgs.length > 0) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      int k;
      for (j = paramVarArgs[0]; i < paramVarArgs.length; j = k)
      {
        k = j;
        if (paramVarArgs[i] > j) {
          k = paramVarArgs[i];
        }
        i += 1;
      }
    }
    return j;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/common/internal/Ints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */