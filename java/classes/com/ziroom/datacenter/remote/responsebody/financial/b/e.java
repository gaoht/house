package com.ziroom.datacenter.remote.responsebody.financial.b;

import com.ziroom.datacenter.a.a;
import java.util.List;

public class e
  extends c
{
  @a
  private e f;
  private int g;
  private int h;
  private String i;
  private List<Object> j;
  
  public e getData()
  {
    return this;
  }
  
  public int getDefScore()
  {
    return this.h;
  }
  
  public List<Object> getPerformInfo()
  {
    return this.j;
  }
  
  public String getRemark()
  {
    return this.i;
  }
  
  public int getTotalScore()
  {
    return this.g;
  }
  
  public void setData(e parame)
  {
    this.f = parame;
  }
  
  public void setDefScore(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setPerformInfo(List<Object> paramList)
  {
    this.j = paramList;
  }
  
  public void setRemark(String paramString)
  {
    this.i = paramString;
  }
  
  public void setTotalScore(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */