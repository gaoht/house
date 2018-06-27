package com.a.a;

import java.util.Calendar;

public abstract interface e
  extends Cloneable
{
  public abstract void appendArrayItem(String paramString1, String paramString2, com.a.a.b.e parame1, String paramString3, com.a.a.b.e parame2)
    throws c;
  
  public abstract void appendArrayItem(String paramString1, String paramString2, String paramString3)
    throws c;
  
  public abstract Object clone();
  
  public abstract int countArrayItems(String paramString1, String paramString2)
    throws c;
  
  public abstract void deleteArrayItem(String paramString1, String paramString2, int paramInt);
  
  public abstract void deleteProperty(String paramString1, String paramString2);
  
  public abstract void deleteQualifier(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void deleteStructField(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract boolean doesArrayItemExist(String paramString1, String paramString2, int paramInt);
  
  public abstract boolean doesPropertyExist(String paramString1, String paramString2);
  
  public abstract boolean doesQualifierExist(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract boolean doesStructFieldExist(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract String dumpObject();
  
  public abstract com.a.a.c.b getArrayItem(String paramString1, String paramString2, int paramInt)
    throws c;
  
  public abstract com.a.a.c.b getLocalizedText(String paramString1, String paramString2, String paramString3, String paramString4)
    throws c;
  
  public abstract String getObjectName();
  
  public abstract String getPacketHeader();
  
  public abstract com.a.a.c.b getProperty(String paramString1, String paramString2)
    throws c;
  
  public abstract byte[] getPropertyBase64(String paramString1, String paramString2)
    throws c;
  
  public abstract Boolean getPropertyBoolean(String paramString1, String paramString2)
    throws c;
  
  public abstract Calendar getPropertyCalendar(String paramString1, String paramString2)
    throws c;
  
  public abstract a getPropertyDate(String paramString1, String paramString2)
    throws c;
  
  public abstract Double getPropertyDouble(String paramString1, String paramString2)
    throws c;
  
  public abstract Integer getPropertyInteger(String paramString1, String paramString2)
    throws c;
  
  public abstract Long getPropertyLong(String paramString1, String paramString2)
    throws c;
  
  public abstract String getPropertyString(String paramString1, String paramString2)
    throws c;
  
  public abstract com.a.a.c.b getQualifier(String paramString1, String paramString2, String paramString3, String paramString4)
    throws c;
  
  public abstract com.a.a.c.b getStructField(String paramString1, String paramString2, String paramString3, String paramString4)
    throws c;
  
  public abstract void insertArrayItem(String paramString1, String paramString2, int paramInt, String paramString3)
    throws c;
  
  public abstract void insertArrayItem(String paramString1, String paramString2, int paramInt, String paramString3, com.a.a.b.e parame)
    throws c;
  
  public abstract d iterator()
    throws c;
  
  public abstract d iterator(com.a.a.b.b paramb)
    throws c;
  
  public abstract d iterator(String paramString1, String paramString2, com.a.a.b.b paramb)
    throws c;
  
  public abstract void normalize(com.a.a.b.d paramd)
    throws c;
  
  public abstract void setArrayItem(String paramString1, String paramString2, int paramInt, String paramString3)
    throws c;
  
  public abstract void setArrayItem(String paramString1, String paramString2, int paramInt, String paramString3, com.a.a.b.e parame)
    throws c;
  
  public abstract void setLocalizedText(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws c;
  
  public abstract void setLocalizedText(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.a.a.b.e parame)
    throws c;
  
  public abstract void setObjectName(String paramString);
  
  public abstract void setProperty(String paramString1, String paramString2, Object paramObject)
    throws c;
  
  public abstract void setProperty(String paramString1, String paramString2, Object paramObject, com.a.a.b.e parame)
    throws c;
  
  public abstract void setPropertyBase64(String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws c;
  
  public abstract void setPropertyBase64(String paramString1, String paramString2, byte[] paramArrayOfByte, com.a.a.b.e parame)
    throws c;
  
  public abstract void setPropertyBoolean(String paramString1, String paramString2, boolean paramBoolean)
    throws c;
  
  public abstract void setPropertyBoolean(String paramString1, String paramString2, boolean paramBoolean, com.a.a.b.e parame)
    throws c;
  
  public abstract void setPropertyCalendar(String paramString1, String paramString2, Calendar paramCalendar)
    throws c;
  
  public abstract void setPropertyCalendar(String paramString1, String paramString2, Calendar paramCalendar, com.a.a.b.e parame)
    throws c;
  
  public abstract void setPropertyDate(String paramString1, String paramString2, a parama)
    throws c;
  
  public abstract void setPropertyDate(String paramString1, String paramString2, a parama, com.a.a.b.e parame)
    throws c;
  
  public abstract void setPropertyDouble(String paramString1, String paramString2, double paramDouble)
    throws c;
  
  public abstract void setPropertyDouble(String paramString1, String paramString2, double paramDouble, com.a.a.b.e parame)
    throws c;
  
  public abstract void setPropertyInteger(String paramString1, String paramString2, int paramInt)
    throws c;
  
  public abstract void setPropertyInteger(String paramString1, String paramString2, int paramInt, com.a.a.b.e parame)
    throws c;
  
  public abstract void setPropertyLong(String paramString1, String paramString2, long paramLong)
    throws c;
  
  public abstract void setPropertyLong(String paramString1, String paramString2, long paramLong, com.a.a.b.e parame)
    throws c;
  
  public abstract void setQualifier(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws c;
  
  public abstract void setQualifier(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.a.a.b.e parame)
    throws c;
  
  public abstract void setStructField(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws c;
  
  public abstract void setStructField(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.a.a.b.e parame)
    throws c;
  
  public abstract void sort();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */