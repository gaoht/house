package com.ziroom.datacenter.remote.responsebody.financial.b;

import com.ziroom.datacenter.a.a;
import java.io.Serializable;
import java.util.List;

public class l
  extends c
  implements Serializable
{
  List<u> f;
  @a
  private l g;
  
  public l getData()
  {
    return this;
  }
  
  public List<u> getGraphs()
  {
    return this.f;
  }
  
  public void setData(l paraml)
  {
    this.g = paraml;
  }
  
  public void setGraphs(List<u> paramList)
  {
    this.f = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */