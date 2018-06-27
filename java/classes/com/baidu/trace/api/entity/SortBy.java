package com.baidu.trace.api.entity;

import com.baidu.trace.model.SortType;

public class SortBy
{
  private String a;
  private SortType b;
  
  private SortBy(String paramString, SortType paramSortType)
  {
    this.a = paramString;
    this.b = paramSortType;
  }
  
  public static SortBy buildCustomKey(String paramString, SortType paramSortType)
  {
    return new SortBy(paramString, paramSortType);
  }
  
  public static SortBy buildEntityDesc(SortType paramSortType)
  {
    return new SortBy("entity_desc", paramSortType);
  }
  
  public static SortBy buildEntityName(SortType paramSortType)
  {
    return new SortBy("entity_name", paramSortType);
  }
  
  public static SortBy buildLocTime(SortType paramSortType)
  {
    return new SortBy("loc_time", paramSortType);
  }
  
  public String getFieldName()
  {
    return this.a;
  }
  
  public SortType getSortType()
  {
    return this.b;
  }
  
  public void setSortType(SortType paramSortType)
  {
    this.b = paramSortType;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("SortBy{");
    localStringBuffer.append("fieldName='").append(this.a).append('\'');
    localStringBuffer.append(", sortType=").append(this.b);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/SortBy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */