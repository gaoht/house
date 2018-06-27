package com.a.a.a;

import com.a.a.a;
import com.a.a.i;
import java.util.Calendar;
import java.util.Iterator;

public class n
  implements com.a.a.e
{
  private p b;
  private String c = null;
  
  static
  {
    if (!n.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public n()
  {
    this.b = new p(null, null, null);
  }
  
  public n(p paramp)
  {
    this.b = paramp;
  }
  
  private Object a(int paramInt, p paramp)
    throws com.a.a.c
  {
    String str = paramp.getValue();
    switch (paramInt)
    {
    default: 
      if ((str != null) || (paramp.getOptions().isCompositeProperty())) {
        return str;
      }
      break;
    case 1: 
      return new Boolean(i.convertToBoolean(str));
    case 2: 
      return new Integer(i.convertToInteger(str));
    case 3: 
      return new Long(i.convertToLong(str));
    case 4: 
      return new Double(i.convertToDouble(str));
    case 5: 
      return i.convertToDate(str);
    case 6: 
      return i.convertToDate(str).getCalendar();
    case 7: 
      return i.decodeBase64(str);
    }
    return "";
  }
  
  private void a(p paramp, int paramInt, String paramString, com.a.a.b.e parame, boolean paramBoolean)
    throws com.a.a.c
  {
    p localp = new p("[]", null);
    parame = q.a(parame, paramString);
    if (paramBoolean) {}
    for (int i = paramp.getChildrenLength() + 1;; i = paramp.getChildrenLength())
    {
      int j = paramInt;
      if (paramInt == -1) {
        j = i;
      }
      if ((1 > j) || (j > i)) {
        break;
      }
      if (!paramBoolean) {
        paramp.removeChild(j);
      }
      paramp.addChild(j, localp);
      a(localp, paramString, parame, false);
      return;
    }
    throw new com.a.a.c("Array index out of bounds", 104);
  }
  
  protected com.a.a.c.b a(String paramString1, final String paramString2, int paramInt)
    throws com.a.a.c
  {
    Object localObject = null;
    g.assertSchemaNS(paramString1);
    g.assertPropName(paramString2);
    paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
    paramString2 = q.a(this.b, paramString1, false, null);
    paramString1 = (String)localObject;
    if (paramString2 != null)
    {
      if ((paramInt != 0) && (paramString2.getOptions().isCompositeProperty())) {
        throw new com.a.a.c("Property must be simple when a value type is requested", 102);
      }
      paramString1 = new com.a.a.c.b()
      {
        public String getLanguage()
        {
          return null;
        }
        
        public com.a.a.b.e getOptions()
        {
          return paramString2.getOptions();
        }
        
        public String getValue()
        {
          if (this.a != null) {
            return this.a.toString();
          }
          return null;
        }
        
        public String toString()
        {
          return this.a.toString();
        }
      };
    }
    return paramString1;
  }
  
  void a(p paramp, Object paramObject, com.a.a.b.e parame, boolean paramBoolean)
    throws com.a.a.c
  {
    if (paramBoolean) {
      paramp.clear();
    }
    paramp.getOptions().mergeWith(parame);
    if (!paramp.getOptions().isCompositeProperty())
    {
      q.a(paramp, paramObject);
      return;
    }
    if ((paramObject != null) && (paramObject.toString().length() > 0)) {
      throw new com.a.a.c("Composite nodes can't have values", 102);
    }
    paramp.removeChildren();
  }
  
  public void appendArrayItem(String paramString1, String paramString2, com.a.a.b.e parame1, String paramString3, com.a.a.b.e parame2)
    throws com.a.a.c
  {
    g.assertSchemaNS(paramString1);
    g.assertArrayName(paramString2);
    com.a.a.b.e locale = parame1;
    if (parame1 == null) {
      locale = new com.a.a.b.e();
    }
    if (!locale.isOnlyArrayOptions()) {
      throw new com.a.a.c("Only array form flags allowed for arrayOptions", 103);
    }
    parame1 = q.a(locale, null);
    paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
    paramString2 = q.a(this.b, paramString1, false, null);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (!paramString2.getOptions().isArray()) {
        throw new com.a.a.c("The named property is not an array", 102);
      }
    }
    else if (parame1.isArray())
    {
      paramString2 = q.a(this.b, paramString1, true, parame1);
      paramString1 = paramString2;
      if (paramString2 == null) {
        throw new com.a.a.c("Failure creating array node", 102);
      }
    }
    else
    {
      throw new com.a.a.c("Explicit arrayOptions required to create new array", 103);
    }
    a(paramString1, -1, paramString3, parame2, true);
  }
  
  public void appendArrayItem(String paramString1, String paramString2, String paramString3)
    throws com.a.a.c
  {
    appendArrayItem(paramString1, paramString2, null, paramString3, null);
  }
  
  protected Object b(String paramString1, String paramString2, int paramInt)
    throws com.a.a.c
  {
    Object localObject = null;
    g.assertSchemaNS(paramString1);
    g.assertPropName(paramString2);
    paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
    paramString2 = q.a(this.b, paramString1, false, null);
    paramString1 = (String)localObject;
    if (paramString2 != null)
    {
      if ((paramInt != 0) && (paramString2.getOptions().isCompositeProperty())) {
        throw new com.a.a.c("Property must be simple when a value type is requested", 102);
      }
      paramString1 = a(paramInt, paramString2);
    }
    return paramString1;
  }
  
  public Object clone()
  {
    return new n((p)this.b.clone());
  }
  
  public int countArrayItems(String paramString1, String paramString2)
    throws com.a.a.c
  {
    g.assertSchemaNS(paramString1);
    g.assertArrayName(paramString2);
    paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
    paramString1 = q.a(this.b, paramString1, false, null);
    if (paramString1 == null) {
      return 0;
    }
    if (paramString1.getOptions().isArray()) {
      return paramString1.getChildrenLength();
    }
    throw new com.a.a.c("The named property is not an array", 102);
  }
  
  public void deleteArrayItem(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      g.assertSchemaNS(paramString1);
      g.assertArrayName(paramString2);
      deleteProperty(paramString1, com.a.a.g.composeArrayItemPath(paramString2, paramInt));
      return;
    }
    catch (com.a.a.c paramString1) {}
  }
  
  public void deleteProperty(String paramString1, String paramString2)
  {
    try
    {
      g.assertSchemaNS(paramString1);
      g.assertPropName(paramString2);
      paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
      paramString1 = q.a(this.b, paramString1, false, null);
      if (paramString1 != null) {
        q.a(paramString1);
      }
      return;
    }
    catch (com.a.a.c paramString1) {}
  }
  
  public void deleteQualifier(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      g.assertSchemaNS(paramString1);
      g.assertPropName(paramString2);
      deleteProperty(paramString1, paramString2 + com.a.a.g.composeQualifierPath(paramString3, paramString4));
      return;
    }
    catch (com.a.a.c paramString1) {}
  }
  
  public void deleteStructField(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      g.assertSchemaNS(paramString1);
      g.assertStructName(paramString2);
      deleteProperty(paramString1, paramString2 + com.a.a.g.composeStructFieldPath(paramString3, paramString4));
      return;
    }
    catch (com.a.a.c paramString1) {}
  }
  
  public boolean doesArrayItemExist(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      g.assertSchemaNS(paramString1);
      g.assertArrayName(paramString2);
      boolean bool = doesPropertyExist(paramString1, com.a.a.g.composeArrayItemPath(paramString2, paramInt));
      return bool;
    }
    catch (com.a.a.c paramString1) {}
    return false;
  }
  
  public boolean doesPropertyExist(String paramString1, String paramString2)
  {
    boolean bool = false;
    try
    {
      g.assertSchemaNS(paramString1);
      g.assertPropName(paramString2);
      paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
      paramString1 = q.a(this.b, paramString1, false, null);
      if (paramString1 != null) {
        bool = true;
      }
      return bool;
    }
    catch (com.a.a.c paramString1) {}
    return false;
  }
  
  public boolean doesQualifierExist(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      g.assertSchemaNS(paramString1);
      g.assertPropName(paramString2);
      paramString3 = com.a.a.g.composeQualifierPath(paramString3, paramString4);
      boolean bool = doesPropertyExist(paramString1, paramString2 + paramString3);
      return bool;
    }
    catch (com.a.a.c paramString1) {}
    return false;
  }
  
  public boolean doesStructFieldExist(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      g.assertSchemaNS(paramString1);
      g.assertStructName(paramString2);
      paramString3 = com.a.a.g.composeStructFieldPath(paramString3, paramString4);
      boolean bool = doesPropertyExist(paramString1, paramString2 + paramString3);
      return bool;
    }
    catch (com.a.a.c paramString1) {}
    return false;
  }
  
  public String dumpObject()
  {
    return getRoot().dumpNode(true);
  }
  
  public com.a.a.c.b getArrayItem(String paramString1, String paramString2, int paramInt)
    throws com.a.a.c
  {
    g.assertSchemaNS(paramString1);
    g.assertArrayName(paramString2);
    return getProperty(paramString1, com.a.a.g.composeArrayItemPath(paramString2, paramInt));
  }
  
  public com.a.a.c.b getLocalizedText(final String paramString1, String paramString2, String paramString3, String paramString4)
    throws com.a.a.c
  {
    g.assertSchemaNS(paramString1);
    g.assertArrayName(paramString2);
    g.assertSpecificLang(paramString4);
    if (paramString3 != null)
    {
      paramString3 = k.normalizeLangValue(paramString3);
      paramString4 = k.normalizeLangValue(paramString4);
      paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
      paramString1 = q.a(this.b, paramString1, false, null);
      if (paramString1 != null) {
        break label57;
      }
    }
    label57:
    int i;
    do
    {
      return null;
      paramString3 = null;
      break;
      paramString1 = q.b(paramString1, paramString3, paramString4);
      i = ((Integer)paramString1[0]).intValue();
      paramString1 = (p)paramString1[1];
    } while (i == 0);
    new com.a.a.c.b()
    {
      public String getLanguage()
      {
        return paramString1.getQualifier(1).getValue();
      }
      
      public com.a.a.b.e getOptions()
      {
        return paramString1.getOptions();
      }
      
      public String getValue()
      {
        return paramString1.getValue();
      }
      
      public String toString()
      {
        return paramString1.getValue().toString();
      }
    };
  }
  
  public String getObjectName()
  {
    if (this.b.getName() != null) {
      return this.b.getName();
    }
    return "";
  }
  
  public String getPacketHeader()
  {
    return this.c;
  }
  
  public com.a.a.c.b getProperty(String paramString1, String paramString2)
    throws com.a.a.c
  {
    return a(paramString1, paramString2, 0);
  }
  
  public byte[] getPropertyBase64(String paramString1, String paramString2)
    throws com.a.a.c
  {
    return (byte[])b(paramString1, paramString2, 7);
  }
  
  public Boolean getPropertyBoolean(String paramString1, String paramString2)
    throws com.a.a.c
  {
    return (Boolean)b(paramString1, paramString2, 1);
  }
  
  public Calendar getPropertyCalendar(String paramString1, String paramString2)
    throws com.a.a.c
  {
    return (Calendar)b(paramString1, paramString2, 6);
  }
  
  public a getPropertyDate(String paramString1, String paramString2)
    throws com.a.a.c
  {
    return (a)b(paramString1, paramString2, 5);
  }
  
  public Double getPropertyDouble(String paramString1, String paramString2)
    throws com.a.a.c
  {
    return (Double)b(paramString1, paramString2, 4);
  }
  
  public Integer getPropertyInteger(String paramString1, String paramString2)
    throws com.a.a.c
  {
    return (Integer)b(paramString1, paramString2, 2);
  }
  
  public Long getPropertyLong(String paramString1, String paramString2)
    throws com.a.a.c
  {
    return (Long)b(paramString1, paramString2, 3);
  }
  
  public String getPropertyString(String paramString1, String paramString2)
    throws com.a.a.c
  {
    return (String)b(paramString1, paramString2, 0);
  }
  
  public com.a.a.c.b getQualifier(String paramString1, String paramString2, String paramString3, String paramString4)
    throws com.a.a.c
  {
    g.assertSchemaNS(paramString1);
    g.assertPropName(paramString2);
    return getProperty(paramString1, paramString2 + com.a.a.g.composeQualifierPath(paramString3, paramString4));
  }
  
  public p getRoot()
  {
    return this.b;
  }
  
  public com.a.a.c.b getStructField(String paramString1, String paramString2, String paramString3, String paramString4)
    throws com.a.a.c
  {
    g.assertSchemaNS(paramString1);
    g.assertStructName(paramString2);
    return getProperty(paramString1, paramString2 + com.a.a.g.composeStructFieldPath(paramString3, paramString4));
  }
  
  public void insertArrayItem(String paramString1, String paramString2, int paramInt, String paramString3)
    throws com.a.a.c
  {
    insertArrayItem(paramString1, paramString2, paramInt, paramString3, null);
  }
  
  public void insertArrayItem(String paramString1, String paramString2, int paramInt, String paramString3, com.a.a.b.e parame)
    throws com.a.a.c
  {
    g.assertSchemaNS(paramString1);
    g.assertArrayName(paramString2);
    paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
    paramString1 = q.a(this.b, paramString1, false, null);
    if (paramString1 != null)
    {
      a(paramString1, paramInt, paramString3, parame, true);
      return;
    }
    throw new com.a.a.c("Specified array does not exist", 102);
  }
  
  public com.a.a.d iterator()
    throws com.a.a.c
  {
    return iterator(null, null, null);
  }
  
  public com.a.a.d iterator(com.a.a.b.b paramb)
    throws com.a.a.c
  {
    return iterator(null, null, paramb);
  }
  
  public com.a.a.d iterator(String paramString1, String paramString2, com.a.a.b.b paramb)
    throws com.a.a.c
  {
    return new m(this, paramString1, paramString2, paramb);
  }
  
  public void normalize(com.a.a.b.d paramd)
    throws com.a.a.c
  {
    com.a.a.b.d locald = paramd;
    if (paramd == null) {
      locald = new com.a.a.b.d();
    }
    r.a(this, locald);
  }
  
  public void setArrayItem(String paramString1, String paramString2, int paramInt, String paramString3)
    throws com.a.a.c
  {
    setArrayItem(paramString1, paramString2, paramInt, paramString3, null);
  }
  
  public void setArrayItem(String paramString1, String paramString2, int paramInt, String paramString3, com.a.a.b.e parame)
    throws com.a.a.c
  {
    g.assertSchemaNS(paramString1);
    g.assertArrayName(paramString2);
    paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
    paramString1 = q.a(this.b, paramString1, false, null);
    if (paramString1 != null)
    {
      a(paramString1, paramInt, paramString3, parame, false);
      return;
    }
    throw new com.a.a.c("Specified array does not exist", 102);
  }
  
  public void setLocalizedText(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws com.a.a.c
  {
    setLocalizedText(paramString1, paramString2, paramString3, paramString4, paramString5, null);
  }
  
  public void setLocalizedText(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.a.a.b.e parame)
    throws com.a.a.c
  {
    g.assertSchemaNS(paramString1);
    g.assertArrayName(paramString2);
    g.assertSpecificLang(paramString4);
    if (paramString3 != null) {}
    for (paramString3 = k.normalizeLangValue(paramString3);; paramString3 = null)
    {
      parame = k.normalizeLangValue(paramString4);
      paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
      paramString4 = q.a(this.b, paramString1, true, new com.a.a.b.e(7680));
      if (paramString4 != null) {
        break;
      }
      throw new com.a.a.c("Failed to find or create array node", 102);
    }
    if (!paramString4.getOptions().isArrayAltText())
    {
      if ((!paramString4.hasChildren()) && (paramString4.getOptions().isArrayAlternate())) {
        paramString4.getOptions().setArrayAltText(true);
      }
    }
    else {
      paramString2 = paramString4.iterateChildren();
    }
    int i;
    while (paramString2.hasNext())
    {
      paramString1 = (p)paramString2.next();
      if ((!paramString1.hasQualifier()) || (!"xml:lang".equals(paramString1.getQualifier(1).getName())))
      {
        throw new com.a.a.c("Language qualifier must be first", 102);
        throw new com.a.a.c("Specified property is no alt-text array", 102);
      }
      if ("x-default".equals(paramString1.getQualifier(1).getValue())) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((paramString1 != null) && (paramString4.getChildrenLength() > 1))
      {
        paramString4.removeChild(paramString1);
        paramString4.addChild(1, paramString1);
      }
      paramString2 = q.b(paramString4, paramString3, parame);
      int j = ((Integer)paramString2[0]).intValue();
      paramString2 = (p)paramString2[1];
      boolean bool = "x-default".equals(parame);
      switch (j)
      {
      default: 
        throw new com.a.a.c("Unexpected result from ChooseLocalizedText", 9);
      case 0: 
        q.a(paramString4, "x-default", paramString5);
        j = 1;
        i = j;
        if (!bool)
        {
          q.a(paramString4, parame, paramString5);
          i = j;
        }
        break;
      }
      for (;;)
      {
        if ((i == 0) && (paramString4.getChildrenLength() == 1)) {
          q.a(paramString4, "x-default", paramString5);
        }
        return;
        if (!bool)
        {
          if ((i != 0) && (paramString1 != paramString2) && (paramString1 != null) && (paramString1.getValue().equals(paramString2.getValue()))) {
            paramString1.setValue(paramString5);
          }
          paramString2.setValue(paramString5);
        }
        else
        {
          if ((!a) && ((i == 0) || (paramString1 != paramString2))) {
            throw new AssertionError();
          }
          paramString3 = paramString4.iterateChildren();
          label531:
          while (paramString3.hasNext())
          {
            parame = (p)paramString3.next();
            if (parame != paramString1)
            {
              String str = parame.getValue();
              if (paramString1 != null) {}
              for (paramString2 = paramString1.getValue();; paramString2 = null)
              {
                if (!str.equals(paramString2)) {
                  break label531;
                }
                parame.setValue(paramString5);
                break;
              }
            }
          }
          if (paramString1 != null)
          {
            paramString1.setValue(paramString5);
            continue;
            if ((i != 0) && (paramString1 != paramString2) && (paramString1 != null) && (paramString1.getValue().equals(paramString2.getValue()))) {
              paramString1.setValue(paramString5);
            }
            paramString2.setValue(paramString5);
            continue;
            q.a(paramString4, parame, paramString5);
            if (bool)
            {
              i = 1;
              continue;
              if ((paramString1 != null) && (paramString4.getChildrenLength() == 1)) {
                paramString1.setValue(paramString5);
              }
              q.a(paramString4, parame, paramString5);
              continue;
              q.a(paramString4, parame, paramString5);
              if (bool) {
                i = 1;
              }
            }
          }
        }
      }
      i = 0;
      paramString1 = null;
    }
  }
  
  public void setObjectName(String paramString)
  {
    this.b.setName(paramString);
  }
  
  public void setPacketHeader(String paramString)
  {
    this.c = paramString;
  }
  
  public void setProperty(String paramString1, String paramString2, Object paramObject)
    throws com.a.a.c
  {
    setProperty(paramString1, paramString2, paramObject, null);
  }
  
  public void setProperty(String paramString1, String paramString2, Object paramObject, com.a.a.b.e parame)
    throws com.a.a.c
  {
    g.assertSchemaNS(paramString1);
    g.assertPropName(paramString2);
    parame = q.a(parame, paramObject);
    paramString1 = com.a.a.a.a.c.expandXPath(paramString1, paramString2);
    paramString1 = q.a(this.b, paramString1, true, parame);
    if (paramString1 != null)
    {
      a(paramString1, paramObject, parame, false);
      return;
    }
    throw new com.a.a.c("Specified property does not exist", 102);
  }
  
  public void setPropertyBase64(String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws com.a.a.c
  {
    setProperty(paramString1, paramString2, paramArrayOfByte, null);
  }
  
  public void setPropertyBase64(String paramString1, String paramString2, byte[] paramArrayOfByte, com.a.a.b.e parame)
    throws com.a.a.c
  {
    setProperty(paramString1, paramString2, paramArrayOfByte, parame);
  }
  
  public void setPropertyBoolean(String paramString1, String paramString2, boolean paramBoolean)
    throws com.a.a.c
  {
    if (paramBoolean) {}
    for (String str = "True";; str = "False")
    {
      setProperty(paramString1, paramString2, str, null);
      return;
    }
  }
  
  public void setPropertyBoolean(String paramString1, String paramString2, boolean paramBoolean, com.a.a.b.e parame)
    throws com.a.a.c
  {
    if (paramBoolean) {}
    for (String str = "True";; str = "False")
    {
      setProperty(paramString1, paramString2, str, parame);
      return;
    }
  }
  
  public void setPropertyCalendar(String paramString1, String paramString2, Calendar paramCalendar)
    throws com.a.a.c
  {
    setProperty(paramString1, paramString2, paramCalendar, null);
  }
  
  public void setPropertyCalendar(String paramString1, String paramString2, Calendar paramCalendar, com.a.a.b.e parame)
    throws com.a.a.c
  {
    setProperty(paramString1, paramString2, paramCalendar, parame);
  }
  
  public void setPropertyDate(String paramString1, String paramString2, a parama)
    throws com.a.a.c
  {
    setProperty(paramString1, paramString2, parama, null);
  }
  
  public void setPropertyDate(String paramString1, String paramString2, a parama, com.a.a.b.e parame)
    throws com.a.a.c
  {
    setProperty(paramString1, paramString2, parama, parame);
  }
  
  public void setPropertyDouble(String paramString1, String paramString2, double paramDouble)
    throws com.a.a.c
  {
    setProperty(paramString1, paramString2, new Double(paramDouble), null);
  }
  
  public void setPropertyDouble(String paramString1, String paramString2, double paramDouble, com.a.a.b.e parame)
    throws com.a.a.c
  {
    setProperty(paramString1, paramString2, new Double(paramDouble), parame);
  }
  
  public void setPropertyInteger(String paramString1, String paramString2, int paramInt)
    throws com.a.a.c
  {
    setProperty(paramString1, paramString2, new Integer(paramInt), null);
  }
  
  public void setPropertyInteger(String paramString1, String paramString2, int paramInt, com.a.a.b.e parame)
    throws com.a.a.c
  {
    setProperty(paramString1, paramString2, new Integer(paramInt), parame);
  }
  
  public void setPropertyLong(String paramString1, String paramString2, long paramLong)
    throws com.a.a.c
  {
    setProperty(paramString1, paramString2, new Long(paramLong), null);
  }
  
  public void setPropertyLong(String paramString1, String paramString2, long paramLong, com.a.a.b.e parame)
    throws com.a.a.c
  {
    setProperty(paramString1, paramString2, new Long(paramLong), parame);
  }
  
  public void setQualifier(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws com.a.a.c
  {
    setQualifier(paramString1, paramString2, paramString3, paramString4, paramString5, null);
  }
  
  public void setQualifier(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.a.a.b.e parame)
    throws com.a.a.c
  {
    g.assertSchemaNS(paramString1);
    g.assertPropName(paramString2);
    if (!doesPropertyExist(paramString1, paramString2)) {
      throw new com.a.a.c("Specified property does not exist!", 102);
    }
    setProperty(paramString1, paramString2 + com.a.a.g.composeQualifierPath(paramString3, paramString4), paramString5, parame);
  }
  
  public void setStructField(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws com.a.a.c
  {
    setStructField(paramString1, paramString2, paramString3, paramString4, paramString5, null);
  }
  
  public void setStructField(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.a.a.b.e parame)
    throws com.a.a.c
  {
    g.assertSchemaNS(paramString1);
    g.assertStructName(paramString2);
    setProperty(paramString1, paramString2 + com.a.a.g.composeStructFieldPath(paramString3, paramString4), paramString5, parame);
  }
  
  public void sort()
  {
    this.b.sort();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */