package com.b.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

public class p
{
  public static int compare(String paramString1, String paramString2)
  {
    int i;
    if (paramString1 == null)
    {
      i = 1;
      if (paramString2 != null) {
        break label27;
      }
    }
    label27:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label32;
      }
      return 0;
      i = 0;
      break;
    }
    label32:
    if (i != 0) {
      return -1;
    }
    if (j != 0) {
      return 1;
    }
    return paramString1.compareTo(paramString2);
  }
  
  public static String fromStream(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  public static String join(Iterable<? extends CharSequence> paramIterable, String paramString)
  {
    int i = paramString.length();
    Object localObject = paramIterable.iterator();
    if (((Iterator)localObject).hasNext()) {}
    for (i = ((CharSequence)((Iterator)localObject).next()).length() + i + 0;; i = 0)
    {
      localObject = new StringBuilder(i);
      paramIterable = paramIterable.iterator();
      if (paramIterable.hasNext())
      {
        ((StringBuilder)localObject).append((CharSequence)paramIterable.next());
        while (paramIterable.hasNext())
        {
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append((CharSequence)paramIterable.next());
        }
      }
      return ((StringBuilder)localObject).toString();
    }
  }
  
  public static <T extends CharSequence> String join(T[] paramArrayOfT, String paramString)
  {
    int k = paramString.length();
    int m = paramArrayOfT.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j += paramArrayOfT[i].length() + k;
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder(j);
    j = 1;
    k = paramArrayOfT.length;
    i = 0;
    if (i < k)
    {
      T ? = paramArrayOfT[i];
      if (j == 0) {
        localStringBuilder.append(paramString);
      }
      for (;;)
      {
        localStringBuilder.append(?);
        i += 1;
        break;
        j = 0;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String urlEncode(String paramString)
  {
    return paramString.replace(" ", "%20");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */