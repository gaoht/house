package com.baidu.trace.api.track;

import com.baidu.trace.model.BaseRequest;
import java.util.List;
import java.util.Map;

public class AddPointsRequest
  extends BaseRequest
{
  private Map<String, List<TrackPoint>> a = null;
  
  public AddPointsRequest() {}
  
  public AddPointsRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public AddPointsRequest(int paramInt, long paramLong, Map<String, List<TrackPoint>> paramMap)
  {
    super(paramInt, paramLong);
    this.a = paramMap;
  }
  
  public Map<String, List<TrackPoint>> getPoints()
  {
    return this.a;
  }
  
  public void setPoints(Map<String, List<TrackPoint>> paramMap)
  {
    this.a = paramMap;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("AddPointsRequest{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append(", serviceId=").append(this.serviceId);
    localStringBuffer.append(", points=").append(this.a);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/AddPointsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */