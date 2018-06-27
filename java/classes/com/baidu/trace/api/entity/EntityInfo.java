package com.baidu.trace.api.entity;

import java.util.Map;

public final class EntityInfo
{
  private String a;
  private String b;
  private String c;
  private String d;
  private Map<String, String> e;
  private LatestLocation f;
  
  public EntityInfo() {}
  
  public EntityInfo(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, LatestLocation paramLatestLocation)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramMap;
    this.f = paramLatestLocation;
  }
  
  public final Map<String, String> getColumns()
  {
    return this.e;
  }
  
  public final String getCreateTime()
  {
    return this.d;
  }
  
  public final String getEntityDesc()
  {
    return this.b;
  }
  
  public final String getEntityName()
  {
    return this.a;
  }
  
  public final LatestLocation getLatestLocation()
  {
    return this.f;
  }
  
  public final String getModifyTime()
  {
    return this.c;
  }
  
  public final void setColumns(Map<String, String> paramMap)
  {
    this.e = paramMap;
  }
  
  public final void setCreateTime(String paramString)
  {
    this.d = paramString;
  }
  
  public final void setEntityDesc(String paramString)
  {
    this.b = paramString;
  }
  
  public final void setEntityName(String paramString)
  {
    this.a = paramString;
  }
  
  public final void setLatestLocation(LatestLocation paramLatestLocation)
  {
    this.f = paramLatestLocation;
  }
  
  public final void setModifyTime(String paramString)
  {
    this.c = paramString;
  }
  
  public final String toString()
  {
    return "EntityInfo [entityName=" + this.a + ", entityDesc=" + this.b + ", modifyTime=" + this.c + ", createTime=" + this.d + ", columns=" + this.e + ", latestLocation=" + this.f + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/EntityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */