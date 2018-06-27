package okhttp3.internal.http;

import d.e;
import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

public final class RealResponseBody
  extends ResponseBody
{
  private final long contentLength;
  @Nullable
  private final String contentTypeString;
  private final e source;
  
  public RealResponseBody(@Nullable String paramString, long paramLong, e parame)
  {
    this.contentTypeString = paramString;
    this.contentLength = paramLong;
    this.source = parame;
  }
  
  public long contentLength()
  {
    return this.contentLength;
  }
  
  public MediaType contentType()
  {
    if (this.contentTypeString != null) {
      return MediaType.parse(this.contentTypeString);
    }
    return null;
  }
  
  public e source()
  {
    return this.source;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/okhttp3/internal/http/RealResponseBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */