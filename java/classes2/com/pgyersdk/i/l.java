package com.pgyersdk.i;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class l
{
  private static final Pattern a = Pattern.compile("[0-9a-f]+", 2);
  
  public static String a(String paramString)
  {
    if (k.a(paramString)) {
      throw new IllegalArgumentException("App ID must not be null or empty.");
    }
    paramString = paramString.trim();
    Matcher localMatcher = a.matcher(paramString);
    if (paramString.length() != 32) {
      throw new IllegalArgumentException("App ID length must be 32 characters.");
    }
    if (!localMatcher.matches()) {
      throw new IllegalArgumentException("App ID must match regex pattern /[0-9a-f]+/i");
    }
    return paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/i/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */