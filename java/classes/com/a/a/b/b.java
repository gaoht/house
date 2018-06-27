package com.a.a.b;

public final class b
  extends c
{
  protected int a()
  {
    return 5888;
  }
  
  protected String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 256: 
      return "JUST_CHILDREN";
    case 512: 
      return "JUST_LEAFNODES";
    case 1024: 
      return "JUST_LEAFNAME";
    }
    return "OMIT_QUALIFIERS";
  }
  
  public boolean isJustChildren()
  {
    return b(256);
  }
  
  public boolean isJustLeafname()
  {
    return b(1024);
  }
  
  public boolean isJustLeafnodes()
  {
    return b(512);
  }
  
  public boolean isOmitQualifiers()
  {
    return b(4096);
  }
  
  public b setJustChildren(boolean paramBoolean)
  {
    setOption(256, paramBoolean);
    return this;
  }
  
  public b setJustLeafname(boolean paramBoolean)
  {
    setOption(1024, paramBoolean);
    return this;
  }
  
  public b setJustLeafnodes(boolean paramBoolean)
  {
    setOption(512, paramBoolean);
    return this;
  }
  
  public b setOmitQualifiers(boolean paramBoolean)
  {
    setOption(4096, paramBoolean);
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */