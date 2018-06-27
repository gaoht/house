package com.a.a.b;

public final class a
  extends c
{
  public a() {}
  
  public a(int paramInt)
    throws com.a.a.c
  {
    super(paramInt);
  }
  
  protected int a()
  {
    return 7680;
  }
  
  protected String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return "PROP_DIRECT";
    case 512: 
      return "ARRAY";
    case 1024: 
      return "ARRAY_ORDERED";
    case 2048: 
      return "ARRAY_ALTERNATE";
    }
    return "ARRAY_ALT_TEXT";
  }
  
  public boolean isArray()
  {
    return b(512);
  }
  
  public boolean isArrayAltText()
  {
    return b(4096);
  }
  
  public boolean isArrayAlternate()
  {
    return b(2048);
  }
  
  public boolean isArrayOrdered()
  {
    return b(1024);
  }
  
  public boolean isSimple()
  {
    return getOptions() == 0;
  }
  
  public a setArray(boolean paramBoolean)
  {
    setOption(512, paramBoolean);
    return this;
  }
  
  public a setArrayAltText(boolean paramBoolean)
  {
    setOption(7680, paramBoolean);
    return this;
  }
  
  public a setArrayAlternate(boolean paramBoolean)
  {
    setOption(3584, paramBoolean);
    return this;
  }
  
  public a setArrayOrdered(boolean paramBoolean)
  {
    setOption(1536, paramBoolean);
    return this;
  }
  
  public e toPropertyOptions()
    throws com.a.a.c
  {
    return new e(getOptions());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */