package com.a.a.b;

public final class e
  extends c
{
  public e() {}
  
  public e(int paramInt)
    throws com.a.a.c
  {
    super(paramInt);
  }
  
  protected int a()
  {
    return -2147475470;
  }
  
  protected String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2: 
      return "URI";
    case 16: 
      return "HAS_QUALIFIER";
    case 32: 
      return "QUALIFIER";
    case 64: 
      return "HAS_LANGUAGE";
    case 128: 
      return "HAS_TYPE";
    case 256: 
      return "STRUCT";
    case 512: 
      return "ARRAY";
    case 1024: 
      return "ARRAY_ORDERED";
    case 2048: 
      return "ARRAY_ALTERNATE";
    case 4096: 
      return "ARRAY_ALT_TEXT";
    }
    return "SCHEMA_NODE";
  }
  
  public void assertConsistency(int paramInt)
    throws com.a.a.c
  {
    if (((paramInt & 0x100) > 0) && ((paramInt & 0x200) > 0)) {
      throw new com.a.a.c("IsStruct and IsArray options are mutually exclusive", 103);
    }
    if (((paramInt & 0x2) > 0) && ((paramInt & 0x300) > 0)) {
      throw new com.a.a.c("Structs and arrays can't have \"value\" options", 103);
    }
  }
  
  public boolean equalArrayTypes(e parame)
  {
    return (isArray() == parame.isArray()) && (isArrayOrdered() == parame.isArrayOrdered()) && (isArrayAlternate() == parame.isArrayAlternate()) && (isArrayAltText() == parame.isArrayAltText());
  }
  
  public boolean getHasLanguage()
  {
    return b(64);
  }
  
  public boolean getHasQualifiers()
  {
    return b(16);
  }
  
  public boolean getHasType()
  {
    return b(128);
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
  
  public boolean isCompositeProperty()
  {
    return (getOptions() & 0x300) > 0;
  }
  
  public boolean isOnlyArrayOptions()
  {
    return (getOptions() & 0xE1FF) == 0;
  }
  
  public boolean isQualifier()
  {
    return b(32);
  }
  
  public boolean isSchemaNode()
  {
    return b(Integer.MIN_VALUE);
  }
  
  public boolean isSimple()
  {
    return (getOptions() & 0x300) == 0;
  }
  
  public boolean isStruct()
  {
    return b(256);
  }
  
  public boolean isURI()
  {
    return b(2);
  }
  
  public void mergeWith(e parame)
    throws com.a.a.c
  {
    if (parame != null) {
      setOptions(getOptions() | parame.getOptions());
    }
  }
  
  public e setArray(boolean paramBoolean)
  {
    setOption(512, paramBoolean);
    return this;
  }
  
  public e setArrayAltText(boolean paramBoolean)
  {
    setOption(4096, paramBoolean);
    return this;
  }
  
  public e setArrayAlternate(boolean paramBoolean)
  {
    setOption(2048, paramBoolean);
    return this;
  }
  
  public e setArrayOrdered(boolean paramBoolean)
  {
    setOption(1024, paramBoolean);
    return this;
  }
  
  public e setHasLanguage(boolean paramBoolean)
  {
    setOption(64, paramBoolean);
    return this;
  }
  
  public e setHasQualifiers(boolean paramBoolean)
  {
    setOption(16, paramBoolean);
    return this;
  }
  
  public e setHasType(boolean paramBoolean)
  {
    setOption(128, paramBoolean);
    return this;
  }
  
  public e setQualifier(boolean paramBoolean)
  {
    setOption(32, paramBoolean);
    return this;
  }
  
  public e setSchemaNode(boolean paramBoolean)
  {
    setOption(Integer.MIN_VALUE, paramBoolean);
    return this;
  }
  
  public e setStruct(boolean paramBoolean)
  {
    setOption(256, paramBoolean);
    return this;
  }
  
  public e setURI(boolean paramBoolean)
  {
    setOption(2, paramBoolean);
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */