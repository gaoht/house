package com.alibaba.fastjson.serializer;

import java.util.Arrays;

public class Labels
{
  public static LabelFilter excludes(String... paramVarArgs)
  {
    return new DefaultLabelFilter(null, paramVarArgs);
  }
  
  public static LabelFilter includes(String... paramVarArgs)
  {
    return new DefaultLabelFilter(paramVarArgs, null);
  }
  
  private static class DefaultLabelFilter
    implements LabelFilter
  {
    private String[] excludes;
    private String[] includes;
    
    public DefaultLabelFilter(String[] paramArrayOfString1, String[] paramArrayOfString2)
    {
      if (paramArrayOfString1 != null)
      {
        this.includes = new String[paramArrayOfString1.length];
        System.arraycopy(paramArrayOfString1, 0, this.includes, 0, paramArrayOfString1.length);
        Arrays.sort(this.includes);
      }
      if (paramArrayOfString2 != null)
      {
        this.excludes = new String[paramArrayOfString2.length];
        System.arraycopy(paramArrayOfString2, 0, this.excludes, 0, paramArrayOfString2.length);
        Arrays.sort(this.excludes);
      }
    }
    
    public boolean apply(String paramString)
    {
      if (this.excludes != null) {
        if (Arrays.binarySearch(this.excludes, paramString) != -1) {}
      }
      while ((this.includes != null) && (Arrays.binarySearch(this.includes, paramString) >= 0))
      {
        return true;
        return false;
      }
      return false;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/Labels.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */