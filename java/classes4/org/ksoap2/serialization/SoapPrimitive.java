package org.ksoap2.serialization;

public class SoapPrimitive
  extends AttributeContainer
{
  public static final Object NullNilElement = new Object();
  public static final Object NullSkip = new Object();
  protected String name;
  protected String namespace;
  protected Object value;
  
  public SoapPrimitive(String paramString1, String paramString2, Object paramObject)
  {
    this.namespace = paramString1;
    this.name = paramString2;
    this.value = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof SoapPrimitive)) {
      return false;
    }
    paramObject = (SoapPrimitive)paramObject;
    label58:
    int i;
    if (this.name.equals(((SoapPrimitive)paramObject).name)) {
      if (this.namespace == null)
      {
        if (((SoapPrimitive)paramObject).namespace != null) {
          break label88;
        }
        if (this.value != null) {
          break label93;
        }
        if (((SoapPrimitive)paramObject).value != null) {
          break label88;
        }
        i = 1;
        if ((i == 0) || (!attributesAreEqual((AttributeContainer)paramObject))) {
          break label110;
        }
      }
    }
    for (;;)
    {
      return bool;
      if (this.namespace.equals(((SoapPrimitive)paramObject).namespace)) {
        break;
      }
      label88:
      label93:
      do
      {
        i = 0;
        break;
      } while (!this.value.equals(((SoapPrimitive)paramObject).value));
      break label58;
      label110:
      bool = false;
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNamespace()
  {
    return this.namespace;
  }
  
  public Object getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    int j = this.name.hashCode();
    if (this.namespace == null) {}
    for (int i = 0;; i = this.namespace.hashCode()) {
      return i ^ j;
    }
  }
  
  public String toString()
  {
    if (this.value != null) {
      return this.value.toString();
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/ksoap2/serialization/SoapPrimitive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */