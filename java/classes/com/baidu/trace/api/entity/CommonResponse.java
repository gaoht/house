package com.baidu.trace.api.entity;

import com.baidu.trace.model.BaseResponse;
import java.util.List;

public class CommonResponse
  extends BaseResponse
{
  protected int a;
  protected int b;
  protected List<EntityInfo> c;
  
  public CommonResponse() {}
  
  public CommonResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public CommonResponse(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, List<EntityInfo> paramList)
  {
    super(paramInt1, paramInt2, paramString);
    this.a = paramInt3;
    this.b = paramInt4;
    this.c = paramList;
  }
  
  public List<EntityInfo> getEntities()
  {
    return this.c;
  }
  
  public int getSize()
  {
    return this.b;
  }
  
  public int getTotal()
  {
    return this.a;
  }
  
  public void setEntities(List<EntityInfo> paramList)
  {
    this.c = paramList;
  }
  
  public void setSize(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setTotal(int paramInt)
  {
    this.a = paramInt;
  }
  
  public String toString()
  {
    return "CommonResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", total=" + this.a + ", size=" + this.b + ", entities=" + this.c + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/CommonResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */