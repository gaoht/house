package com.a.a.b;

public final class f
  extends c
{
  private int a = 2048;
  private String b = "\n";
  private String c = "  ";
  private int d = 0;
  private boolean e = false;
  
  public f() {}
  
  public f(int paramInt)
    throws com.a.a.c
  {
    super(paramInt);
  }
  
  protected int a()
  {
    return 13168;
  }
  
  protected String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 16: 
      return "OMIT_PACKET_WRAPPER";
    case 32: 
      return "READONLY_PACKET";
    case 64: 
      return "USE_COMPACT_FORMAT";
    case 256: 
      return "INCLUDE_THUMBNAIL_PAD";
    case 512: 
      return "EXACT_PACKET_LENGTH";
    case 4096: 
      return "OMIT_XMPMETA_ELEMENT";
    }
    return "NORMALIZED";
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    try
    {
      f localf = new f(getOptions());
      localf.setBaseIndent(this.d);
      localf.setIndent(this.c);
      localf.setNewline(this.b);
      localf.setPadding(this.a);
      return localf;
    }
    catch (com.a.a.c localc) {}
    return null;
  }
  
  public int getBaseIndent()
  {
    return this.d;
  }
  
  public boolean getEncodeUTF16BE()
  {
    return (getOptions() & 0x3) == 2;
  }
  
  public boolean getEncodeUTF16LE()
  {
    return (getOptions() & 0x3) == 3;
  }
  
  public String getEncoding()
  {
    if (getEncodeUTF16BE()) {
      return "UTF-16BE";
    }
    if (getEncodeUTF16LE()) {
      return "UTF-16LE";
    }
    return "UTF-8";
  }
  
  public boolean getExactPacketLength()
  {
    return b(512);
  }
  
  public boolean getIncludeThumbnailPad()
  {
    return b(256);
  }
  
  public String getIndent()
  {
    return this.c;
  }
  
  public String getNewline()
  {
    return this.b;
  }
  
  public boolean getOmitPacketWrapper()
  {
    return b(16);
  }
  
  public boolean getOmitVersionAttribute()
  {
    return this.e;
  }
  
  public boolean getOmitXmpMetaElement()
  {
    return b(4096);
  }
  
  public int getPadding()
  {
    return this.a;
  }
  
  public boolean getReadOnlyPacket()
  {
    return b(32);
  }
  
  public boolean getSort()
  {
    return b(8192);
  }
  
  public boolean getUseCanonicalFormat()
  {
    return b(128);
  }
  
  public boolean getUseCompactFormat()
  {
    return b(64);
  }
  
  public f setBaseIndent(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public f setEncodeUTF16BE(boolean paramBoolean)
  {
    setOption(3, false);
    setOption(2, paramBoolean);
    return this;
  }
  
  public f setEncodeUTF16LE(boolean paramBoolean)
  {
    setOption(3, false);
    setOption(3, paramBoolean);
    return this;
  }
  
  public f setExactPacketLength(boolean paramBoolean)
  {
    setOption(512, paramBoolean);
    return this;
  }
  
  public f setIncludeThumbnailPad(boolean paramBoolean)
  {
    setOption(256, paramBoolean);
    return this;
  }
  
  public f setIndent(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public f setNewline(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public f setOmitPacketWrapper(boolean paramBoolean)
  {
    setOption(16, paramBoolean);
    return this;
  }
  
  public f setOmitXmpMetaElement(boolean paramBoolean)
  {
    setOption(4096, paramBoolean);
    return this;
  }
  
  public f setPadding(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public f setReadOnlyPacket(boolean paramBoolean)
  {
    setOption(32, paramBoolean);
    return this;
  }
  
  public f setSort(boolean paramBoolean)
  {
    setOption(8192, paramBoolean);
    return this;
  }
  
  public f setUseCanonicalFormat(boolean paramBoolean)
  {
    setOption(128, paramBoolean);
    return this;
  }
  
  public f setUseCompactFormat(boolean paramBoolean)
  {
    setOption(64, paramBoolean);
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */