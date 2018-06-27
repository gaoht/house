package okhttp3.internal.http2;

import d.f;
import okhttp3.internal.Util;

public final class Header
{
  public static final f PSEUDO_PREFIX = f.encodeUtf8(":");
  public static final f RESPONSE_STATUS = f.encodeUtf8(":status");
  public static final f TARGET_AUTHORITY = f.encodeUtf8(":authority");
  public static final f TARGET_METHOD = f.encodeUtf8(":method");
  public static final f TARGET_PATH = f.encodeUtf8(":path");
  public static final f TARGET_SCHEME = f.encodeUtf8(":scheme");
  final int hpackSize;
  public final f name;
  public final f value;
  
  public Header(f paramf1, f paramf2)
  {
    this.name = paramf1;
    this.value = paramf2;
    this.hpackSize = (paramf1.size() + 32 + paramf2.size());
  }
  
  public Header(f paramf, String paramString)
  {
    this(paramf, f.encodeUtf8(paramString));
  }
  
  public Header(String paramString1, String paramString2)
  {
    this(f.encodeUtf8(paramString1), f.encodeUtf8(paramString2));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Header))
    {
      paramObject = (Header)paramObject;
      bool1 = bool2;
      if (this.name.equals(((Header)paramObject).name))
      {
        bool1 = bool2;
        if (this.value.equals(((Header)paramObject).value)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (this.name.hashCode() + 527) * 31 + this.value.hashCode();
  }
  
  public String toString()
  {
    return Util.format("%s: %s", new Object[] { this.name.utf8(), this.value.utf8() });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/internal/http2/Header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */