package com.baidu.trace.api.track;

import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.Point;
import java.util.Map;

public class AddPointRequest
  extends BaseRequest
{
  private String a;
  private Point b;
  private String c;
  private Map<String, String> d;
  
  public AddPointRequest() {}
  
  public AddPointRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public AddPointRequest(int paramInt, long paramLong, String paramString1, Point paramPoint, String paramString2, Map<String, String> paramMap)
  {
    this(paramInt, paramLong);
    this.a = paramString1;
    this.b = paramPoint;
    this.c = paramString2;
    this.d = paramMap;
  }
  
  public Map<String, String> getColumns()
  {
    return this.d;
  }
  
  public String getEntityName()
  {
    return this.a;
  }
  
  public String getObjectName()
  {
    return this.c;
  }
  
  public Point getPoint()
  {
    return this.b;
  }
  
  public void setColumns(Map<String, String> paramMap)
  {
    this.d = paramMap;
  }
  
  public void setEntityName(String paramString)
  {
    this.a = paramString;
  }
  
  public void setObjectName(String paramString)
  {
    this.c = paramString;
  }
  
  public void setPoint(Point paramPoint)
  {
    this.b = paramPoint;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("AddPointRequest{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append(", serviceId=").append(this.serviceId);
    localStringBuffer.append(", entityName='").append(this.a).append('\'');
    localStringBuffer.append(", point=").append(this.b);
    localStringBuffer.append(", objectName='").append(this.c).append('\'');
    localStringBuffer.append(", columns=").append(this.d);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/AddPointRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */