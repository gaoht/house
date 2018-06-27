package okhttp3;

import d.f;
import java.nio.charset.Charset;
import okhttp3.internal.Util;

public final class Credentials
{
  public static String basic(String paramString1, String paramString2)
  {
    return basic(paramString1, paramString2, Util.ISO_8859_1);
  }
  
  public static String basic(String paramString1, String paramString2, Charset paramCharset)
  {
    paramString1 = f.encodeString(paramString1 + ":" + paramString2, paramCharset).base64();
    return "Basic " + paramString1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/Credentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */