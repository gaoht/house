package com.baidu.trace.api.track;

import java.util.List;

public class FailInfo
{
  private List<ParamError> a;
  private List<InternalError> b;
  
  public FailInfo() {}
  
  public FailInfo(List<ParamError> paramList, List<InternalError> paramList1)
  {
    this.a = paramList;
    this.b = paramList1;
  }
  
  public List<InternalError> getInternalErrors()
  {
    return this.b;
  }
  
  public List<ParamError> getParamErrors()
  {
    return this.a;
  }
  
  public void setInternalErrors(List<InternalError> paramList)
  {
    this.b = paramList;
  }
  
  public void setParamErrors(List<ParamError> paramList)
  {
    this.a = paramList;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("FailInfo{");
    localStringBuffer.append("paramErrors=").append(this.a);
    localStringBuffer.append(", internalErrors=").append(this.b);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public class InternalError
  {
    String a;
    TrackPoint b;
    
    public InternalError() {}
    
    public InternalError(String paramString, TrackPoint paramTrackPoint)
    {
      this.a = paramString;
      this.b = paramTrackPoint;
    }
    
    public String getEntityName()
    {
      return this.a;
    }
    
    public TrackPoint getTrackPoint()
    {
      return this.b;
    }
    
    public void setEntityName(String paramString)
    {
      this.a = paramString;
    }
    
    public void setTrackPoint(TrackPoint paramTrackPoint)
    {
      this.b = paramTrackPoint;
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("InternalError{");
      localStringBuffer.append("entityName='").append(this.a).append('\'');
      localStringBuffer.append(", trackPoint=").append(this.b);
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
  }
  
  public class ParamError
    extends FailInfo.InternalError
  {
    private String c;
    
    public ParamError()
    {
      super();
    }
    
    public ParamError(String paramString1, TrackPoint paramTrackPoint, String paramString2)
    {
      super(paramString1, paramTrackPoint);
      this.c = paramString2;
    }
    
    public String getError()
    {
      return this.c;
    }
    
    public void setError(String paramString)
    {
      this.c = paramString;
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("ParamError{");
      localStringBuffer.append("entityName='").append(this.a).append('\'');
      localStringBuffer.append(", trackPoint=").append(this.b);
      localStringBuffer.append(", error='").append(this.c).append('\'');
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/FailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */