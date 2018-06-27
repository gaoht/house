package com.a.a.b;

public final class d
  extends c
{
  public d()
  {
    setOption(24, true);
  }
  
  protected int a()
  {
    return 61;
  }
  
  protected String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "REQUIRE_XMP_META";
    case 4: 
      return "STRICT_ALIASING";
    case 8: 
      return "FIX_CONTROL_CHARS";
    case 16: 
      return "ACCEPT_LATIN_1";
    }
    return "OMIT_NORMALIZATION";
  }
  
  public boolean getAcceptLatin1()
  {
    return b(16);
  }
  
  public boolean getFixControlChars()
  {
    return b(8);
  }
  
  public boolean getOmitNormalization()
  {
    return b(32);
  }
  
  public boolean getRequireXMPMeta()
  {
    return b(1);
  }
  
  public boolean getStrictAliasing()
  {
    return b(4);
  }
  
  public d setAcceptLatin1(boolean paramBoolean)
  {
    setOption(16, paramBoolean);
    return this;
  }
  
  public d setFixControlChars(boolean paramBoolean)
  {
    setOption(8, paramBoolean);
    return this;
  }
  
  public d setOmitNormalization(boolean paramBoolean)
  {
    setOption(32, paramBoolean);
    return this;
  }
  
  public d setRequireXMPMeta(boolean paramBoolean)
  {
    setOption(1, paramBoolean);
    return this;
  }
  
  public d setStrictAliasing(boolean paramBoolean)
  {
    setOption(4, paramBoolean);
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */