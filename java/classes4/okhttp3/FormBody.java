package okhttp3;

import d.c;
import d.d;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

public final class FormBody
  extends RequestBody
{
  private static final MediaType CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded");
  private final List<String> encodedNames;
  private final List<String> encodedValues;
  
  FormBody(List<String> paramList1, List<String> paramList2)
  {
    this.encodedNames = Util.immutableList(paramList1);
    this.encodedValues = Util.immutableList(paramList2);
  }
  
  private long writeOrCountBytes(@Nullable d paramd, boolean paramBoolean)
  {
    long l = 0L;
    if (paramBoolean) {}
    for (paramd = new c();; paramd = paramd.buffer())
    {
      int j = this.encodedNames.size();
      int i = 0;
      while (i < j)
      {
        if (i > 0) {
          paramd.writeByte(38);
        }
        paramd.writeUtf8((String)this.encodedNames.get(i));
        paramd.writeByte(61);
        paramd.writeUtf8((String)this.encodedValues.get(i));
        i += 1;
      }
    }
    if (paramBoolean)
    {
      l = paramd.size();
      paramd.clear();
    }
    return l;
  }
  
  public long contentLength()
  {
    return writeOrCountBytes(null, true);
  }
  
  public MediaType contentType()
  {
    return CONTENT_TYPE;
  }
  
  public String encodedName(int paramInt)
  {
    return (String)this.encodedNames.get(paramInt);
  }
  
  public String encodedValue(int paramInt)
  {
    return (String)this.encodedValues.get(paramInt);
  }
  
  public String name(int paramInt)
  {
    return HttpUrl.percentDecode(encodedName(paramInt), true);
  }
  
  public int size()
  {
    return this.encodedNames.size();
  }
  
  public String value(int paramInt)
  {
    return HttpUrl.percentDecode(encodedValue(paramInt), true);
  }
  
  public void writeTo(d paramd)
    throws IOException
  {
    writeOrCountBytes(paramd, false);
  }
  
  public static final class Builder
  {
    private final Charset charset;
    private final List<String> names = new ArrayList();
    private final List<String> values = new ArrayList();
    
    public Builder()
    {
      this(null);
    }
    
    public Builder(Charset paramCharset)
    {
      this.charset = paramCharset;
    }
    
    public Builder add(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new NullPointerException("name == null");
      }
      if (paramString2 == null) {
        throw new NullPointerException("value == null");
      }
      this.names.add(HttpUrl.canonicalize(paramString1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
      this.values.add(HttpUrl.canonicalize(paramString2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
      return this;
    }
    
    public Builder addEncoded(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new NullPointerException("name == null");
      }
      if (paramString2 == null) {
        throw new NullPointerException("value == null");
      }
      this.names.add(HttpUrl.canonicalize(paramString1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
      this.values.add(HttpUrl.canonicalize(paramString2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
      return this;
    }
    
    public FormBody build()
    {
      return new FormBody(this.names, this.values);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/FormBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */