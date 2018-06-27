package okhttp3.internal.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

public final class HttpHeaders
{
  private static final Pattern PARAMETER = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
  private static final String QUOTED_STRING = "\"([^\"]*)\"";
  private static final String TOKEN = "([^ \"=]*)";
  
  public static long contentLength(Headers paramHeaders)
  {
    return stringToLong(paramHeaders.get("Content-Length"));
  }
  
  public static long contentLength(Response paramResponse)
  {
    return contentLength(paramResponse.headers());
  }
  
  public static boolean hasBody(Response paramResponse)
  {
    if (paramResponse.request().method().equals("HEAD")) {}
    do
    {
      return false;
      int i = paramResponse.code();
      if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304)) {
        return true;
      }
    } while ((contentLength(paramResponse) == -1L) && (!"chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding"))));
    return true;
  }
  
  public static boolean hasVaryAll(Headers paramHeaders)
  {
    return varyFields(paramHeaders).contains("*");
  }
  
  public static boolean hasVaryAll(Response paramResponse)
  {
    return hasVaryAll(paramResponse.headers());
  }
  
  public static List<Challenge> parseChallenges(Headers paramHeaders, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHeaders.values(paramString).iterator();
    label79:
    label118:
    label210:
    label237:
    label244:
    for (;;)
    {
      String str2;
      int i;
      String str1;
      Matcher localMatcher;
      Object localObject;
      if (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        i = str2.indexOf(' ');
        if (i == -1) {
          continue;
        }
        str1 = str2.substring(0, i);
        localMatcher = PARAMETER.matcher(str2);
        paramString = null;
        paramHeaders = null;
        if (!localMatcher.find(i)) {
          break label237;
        }
        if (str2.regionMatches(true, localMatcher.start(1), "realm", 0, 5))
        {
          localObject = localMatcher.group(3);
          paramHeaders = paramString;
          paramString = (String)localObject;
          if ((paramString == null) || (paramHeaders == null)) {
            break label210;
          }
        }
      }
      for (;;)
      {
        if (paramString == null) {
          break label244;
        }
        localObject = new Challenge(str1, paramString);
        paramString = (String)localObject;
        if (paramHeaders != null)
        {
          if (!paramHeaders.equalsIgnoreCase("UTF-8")) {
            break;
          }
          paramString = ((Challenge)localObject).withCharset(Util.UTF_8);
        }
        localArrayList.add(paramString);
        break;
        if (str2.regionMatches(true, localMatcher.start(1), "charset", 0, 7))
        {
          localObject = localMatcher.group(3);
          paramString = paramHeaders;
          paramHeaders = (Headers)localObject;
          break label118;
          i = localMatcher.end();
          localObject = paramString;
          paramString = paramHeaders;
          paramHeaders = (Headers)localObject;
          break label79;
          return localArrayList;
        }
        localObject = paramHeaders;
        paramHeaders = paramString;
        paramString = (String)localObject;
        break label118;
        localObject = paramHeaders;
        paramHeaders = paramString;
        paramString = (String)localObject;
      }
    }
  }
  
  public static int parseSeconds(String paramString, int paramInt)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if (l > 2147483647L) {
        return Integer.MAX_VALUE;
      }
      if (l < 0L) {
        return 0;
      }
      return (int)l;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public static void receiveHeaders(CookieJar paramCookieJar, HttpUrl paramHttpUrl, Headers paramHeaders)
  {
    if (paramCookieJar == CookieJar.NO_COOKIES) {}
    do
    {
      return;
      paramHeaders = Cookie.parseAll(paramHttpUrl, paramHeaders);
    } while (paramHeaders.isEmpty());
    paramCookieJar.saveFromResponse(paramHttpUrl, paramHeaders);
  }
  
  public static int skipUntil(String paramString1, int paramInt, String paramString2)
  {
    for (;;)
    {
      if ((paramInt >= paramString1.length()) || (paramString2.indexOf(paramString1.charAt(paramInt)) != -1)) {
        return paramInt;
      }
      paramInt += 1;
    }
  }
  
  public static int skipWhitespace(String paramString, int paramInt)
  {
    for (;;)
    {
      if (paramInt < paramString.length())
      {
        int i = paramString.charAt(paramInt);
        if ((i == 32) || (i == 9)) {}
      }
      else
      {
        return paramInt;
      }
      paramInt += 1;
    }
  }
  
  private static long stringToLong(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
  
  public static Set<String> varyFields(Headers paramHeaders)
  {
    Object localObject2 = Collections.emptySet();
    int k = paramHeaders.size();
    int i = 0;
    while (i < k) {
      if (!"Vary".equalsIgnoreCase(paramHeaders.name(i)))
      {
        i += 1;
      }
      else
      {
        Object localObject3 = paramHeaders.value(i);
        Object localObject1 = localObject2;
        if (((Set)localObject2).isEmpty()) {
          localObject1 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        }
        localObject3 = ((String)localObject3).split(",");
        int m = localObject3.length;
        int j = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (j >= m) {
            break;
          }
          ((Set)localObject1).add(localObject3[j].trim());
          j += 1;
        }
      }
    }
    return (Set<String>)localObject2;
  }
  
  private static Set<String> varyFields(Response paramResponse)
  {
    return varyFields(paramResponse.headers());
  }
  
  public static Headers varyHeaders(Headers paramHeaders1, Headers paramHeaders2)
  {
    paramHeaders2 = varyFields(paramHeaders2);
    if (paramHeaders2.isEmpty()) {
      return new Headers.Builder().build();
    }
    Headers.Builder localBuilder = new Headers.Builder();
    int i = 0;
    int j = paramHeaders1.size();
    while (i < j)
    {
      String str = paramHeaders1.name(i);
      if (paramHeaders2.contains(str)) {
        localBuilder.add(str, paramHeaders1.value(i));
      }
      i += 1;
    }
    return localBuilder.build();
  }
  
  public static Headers varyHeaders(Response paramResponse)
  {
    return varyHeaders(paramResponse.networkResponse().request().headers(), paramResponse.headers());
  }
  
  public static boolean varyMatches(Response paramResponse, Headers paramHeaders, Request paramRequest)
  {
    paramResponse = varyFields(paramResponse).iterator();
    while (paramResponse.hasNext())
    {
      String str = (String)paramResponse.next();
      if (!Util.equal(paramHeaders.values(str), paramRequest.headers(str))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/internal/http/HttpHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */