package android.support.v4.content;

import java.util.ArrayList;

public final class MimeTypeFilter
{
  public static String matches(String paramString, String[] paramArrayOfString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      paramString = paramString.split("/");
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (mimeTypeAgainstFilter(paramString, str.split("/"))) {
          return str;
        }
        i += 1;
      }
    }
  }
  
  public static String matches(String[] paramArrayOfString, String paramString)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      return null;
      paramString = paramString.split("/");
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (mimeTypeAgainstFilter(str.split("/"), paramString)) {
          return str;
        }
        i += 1;
      }
    }
  }
  
  public static boolean matches(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    return mimeTypeAgainstFilter(paramString1.split("/"), paramString2.split("/"));
  }
  
  public static String[] matchesMany(String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    if (paramArrayOfString == null) {
      return new String[0];
    }
    ArrayList localArrayList = new ArrayList();
    paramString = paramString.split("/");
    int j = paramArrayOfString.length;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (mimeTypeAgainstFilter(str.split("/"), paramString)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  private static boolean mimeTypeAgainstFilter(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (paramArrayOfString2.length != 2) {
      throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
    }
    if ((paramArrayOfString2[0].isEmpty()) || (paramArrayOfString2[1].isEmpty())) {
      throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
    }
    if (paramArrayOfString1.length != 2) {}
    while (((!"*".equals(paramArrayOfString2[0])) && (!paramArrayOfString2[0].equals(paramArrayOfString1[0]))) || ((!"*".equals(paramArrayOfString2[1])) && (!paramArrayOfString2[1].equals(paramArrayOfString1[1])))) {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/content/MimeTypeFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */