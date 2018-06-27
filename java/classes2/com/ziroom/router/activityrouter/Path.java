package com.ziroom.router.activityrouter;

import android.net.Uri;

public class Path
{
  private Path next;
  private final String value;
  
  private Path(String paramString)
  {
    this.value = paramString;
  }
  
  public static Path create(Uri paramUri)
  {
    Path localPath = new Path(paramUri.getScheme().concat("://"));
    Object localObject2 = paramUri.getPath();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = localObject1;
    if (((String)localObject1).endsWith("/")) {
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    parse(localPath, paramUri.getHost() + (String)localObject2);
    return localPath;
  }
  
  private boolean match(Path paramPath)
  {
    return (isArgument()) || (this.value.equals(paramPath.value));
  }
  
  public static boolean match(Path paramPath1, Path paramPath2)
  {
    if ((paramPath1 == null) || (paramPath2 == null)) {}
    while (paramPath1.length() != paramPath2.length()) {
      return false;
    }
    for (;;)
    {
      if (paramPath1 == null) {
        break label46;
      }
      if (!paramPath1.match(paramPath2)) {
        break;
      }
      paramPath1 = paramPath1.next;
      paramPath2 = paramPath2.next;
    }
    label46:
    return true;
  }
  
  private static void parse(Path paramPath, String paramString)
  {
    String[] arrayOfString = paramString.split("/");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString = new Path(arrayOfString[i]);
      paramPath.next = paramString;
      i += 1;
      paramPath = paramString;
    }
  }
  
  public String argument()
  {
    return this.value.substring(1);
  }
  
  public boolean isArgument()
  {
    return this.value.startsWith(":");
  }
  
  public boolean isHttp()
  {
    String str = this.value.toLowerCase();
    return (str.startsWith("http://")) || (str.startsWith("https://"));
  }
  
  public int length()
  {
    int i = 1;
    for (Path localPath = this; localPath.next != null; localPath = localPath.next) {
      i += 1;
    }
    return i;
  }
  
  public Path next()
  {
    return this.next;
  }
  
  public String value()
  {
    return this.value;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/router/activityrouter/Path.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */