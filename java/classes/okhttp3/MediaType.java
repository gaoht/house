package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class MediaType
{
  private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  private static final String QUOTED = "\"([^\"]*)\"";
  private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
  private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  @Nullable
  private final String charset;
  private final String mediaType;
  private final String subtype;
  private final String type;
  
  private MediaType(String paramString1, String paramString2, String paramString3, @Nullable String paramString4)
  {
    this.mediaType = paramString1;
    this.type = paramString2;
    this.subtype = paramString3;
    this.charset = paramString4;
  }
  
  @Nullable
  public static MediaType parse(String paramString)
  {
    Object localObject1 = TYPE_SUBTYPE.matcher(paramString);
    if (!((Matcher)localObject1).lookingAt()) {}
    String str2;
    String str3;
    Object localObject2;
    label124:
    label212:
    for (;;)
    {
      return null;
      str2 = ((Matcher)localObject1).group(1).toLowerCase(Locale.US);
      str3 = ((Matcher)localObject1).group(2).toLowerCase(Locale.US);
      Matcher localMatcher = PARAMETER.matcher(paramString);
      int i = ((Matcher)localObject1).end();
      for (localObject2 = null;; localObject2 = localObject1)
      {
        if (i >= paramString.length()) {
          break label214;
        }
        localMatcher.region(i, paramString.length());
        if (!localMatcher.lookingAt()) {
          break;
        }
        str1 = localMatcher.group(1);
        localObject1 = localObject2;
        if (str1 != null)
        {
          if (str1.equalsIgnoreCase("charset")) {
            break label124;
          }
          localObject1 = localObject2;
        }
        i = localMatcher.end();
      }
      String str1 = localMatcher.group(2);
      if (str1 != null)
      {
        localObject1 = str1;
        if (str1.startsWith("'"))
        {
          localObject1 = str1;
          if (str1.endsWith("'"))
          {
            localObject1 = str1;
            if (str1.length() <= 2) {}
          }
        }
      }
      for (localObject1 = str1.substring(1, str1.length() - 1);; localObject1 = localMatcher.group(3))
      {
        if ((localObject2 != null) && (!((String)localObject1).equalsIgnoreCase((String)localObject2))) {
          break label212;
        }
        break;
      }
    }
    label214:
    return new MediaType(paramString, str2, str3, (String)localObject2);
  }
  
  @Nullable
  public Charset charset()
  {
    return charset(null);
  }
  
  @Nullable
  public Charset charset(@Nullable Charset paramCharset)
  {
    Charset localCharset = paramCharset;
    try
    {
      if (this.charset != null) {
        localCharset = Charset.forName(this.charset);
      }
      return localCharset;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return paramCharset;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof MediaType)) && (((MediaType)paramObject).mediaType.equals(this.mediaType));
  }
  
  public int hashCode()
  {
    return this.mediaType.hashCode();
  }
  
  public String subtype()
  {
    return this.subtype;
  }
  
  public String toString()
  {
    return this.mediaType;
  }
  
  public String type()
  {
    return this.type;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/okhttp3/MediaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */