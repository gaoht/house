package com.baidu.trace.api.entity;

import com.baidu.trace.model.BaseRequest;
import java.util.Map;

public final class UpdateEntityRequest
  extends BaseRequest
{
  private String a;
  private String b;
  private Map<String, String> c;
  
  public UpdateEntityRequest() {}
  
  public UpdateEntityRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public UpdateEntityRequest(int paramInt, long paramLong, String paramString)
  {
    super(paramInt, paramLong);
    this.a = paramString;
  }
  
  public UpdateEntityRequest(int paramInt, long paramLong, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    super(paramInt, paramLong);
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramMap;
  }
  
  public final Map<String, String> getColumns()
  {
    return this.c;
  }
  
  public final String getEntityDesc()
  {
    return this.b;
  }
  
  public final String getEntityName()
  {
    return this.a;
  }
  
  public final void setColumns(Map<String, String> paramMap)
  {
    this.c = paramMap;
  }
  
  public final void setEntityDesc(String paramString)
  {
    this.b = paramString;
  }
  
  public final void setEntityName(String paramString)
  {
    this.a = paramString;
  }
  
  public final String toString()
  {
    return "UpdateEntityRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", entityName=" + this.a + ", entityDesc=" + this.b + ", columns=" + this.c + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/UpdateEntityRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */