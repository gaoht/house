package com.baidu.trace.api.entity;

import java.util.List;
import java.util.Map;

public class FilterCondition
{
  private List<String> a;
  private long b;
  private long c;
  private Map<String, String> d;
  
  public FilterCondition() {}
  
  public FilterCondition(List<String> paramList, long paramLong1, long paramLong2, Map<String, String> paramMap)
  {
    this.a = paramList;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramMap;
  }
  
  public long getActiveTime()
  {
    return this.b;
  }
  
  public Map<String, String> getColumns()
  {
    return this.d;
  }
  
  public List<String> getEntityNames()
  {
    return this.a;
  }
  
  public long getInActiveTime()
  {
    return this.c;
  }
  
  public void setActiveTime(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void setColumns(Map<String, String> paramMap)
  {
    this.d = paramMap;
  }
  
  public void setEntityNames(List<String> paramList)
  {
    this.a = paramList;
  }
  
  public void setInActiveTime(long paramLong)
  {
    this.c = paramLong;
  }
  
  public String toString()
  {
    return "FilterCondition [entityNames=" + this.a + ", activeTime=" + this.b + ", inActiveTime=" + this.c + ", columns=" + this.d + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/FilterCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */