package c.a.a.a.a.a;

public class a
{
  private final String a;
  private final b b;
  private final c.a.a.a.a.a.a.b c;
  
  public a(String paramString, c.a.a.a.a.a.a.b paramb)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Name may not be null");
    }
    if (paramb == null) {
      throw new IllegalArgumentException("Body may not be null");
    }
    this.a = paramString;
    this.c = paramb;
    this.b = new b();
    a(paramb);
    b(paramb);
    c(paramb);
  }
  
  protected void a(c.a.a.a.a.a.a.b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("form-data; name=\"");
    localStringBuilder.append(getName());
    localStringBuilder.append("\"");
    if (paramb.getFilename() != null)
    {
      localStringBuilder.append("; filename=\"");
      localStringBuilder.append(paramb.getFilename());
      localStringBuilder.append("\"");
    }
    addField("Content-Disposition", localStringBuilder.toString());
  }
  
  public void addField(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Field name may not be null");
    }
    this.b.addField(new f(paramString1, paramString2));
  }
  
  protected void b(c.a.a.a.a.a.a.b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramb.getMimeType());
    if (paramb.getCharset() != null)
    {
      localStringBuilder.append("; charset=");
      localStringBuilder.append(paramb.getCharset());
    }
    addField("Content-Type", localStringBuilder.toString());
  }
  
  protected void c(c.a.a.a.a.a.a.b paramb)
  {
    addField("Content-Transfer-Encoding", paramb.getTransferEncoding());
  }
  
  public c.a.a.a.a.a.a.b getBody()
  {
    return this.c;
  }
  
  public b getHeader()
  {
    return this.b;
  }
  
  public String getName()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/a/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */