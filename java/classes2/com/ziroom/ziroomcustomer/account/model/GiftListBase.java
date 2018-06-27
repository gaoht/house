package com.ziroom.ziroomcustomer.account.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class GiftListBase
  extends b
{
  private DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public class DataBean
  {
    private List<GiftDrawBase> draws;
    private int undrawCount;
    private List<GiftUnDrawBase> undraws;
    
    public DataBean() {}
    
    public List<GiftDrawBase> getDraws()
    {
      return this.draws;
    }
    
    public int getUndrawCount()
    {
      return this.undrawCount;
    }
    
    public List<GiftUnDrawBase> getUndraws()
    {
      return this.undraws;
    }
    
    public void setDraws(List<GiftDrawBase> paramList)
    {
      this.draws = paramList;
    }
    
    public void setUndrawCount(int paramInt)
    {
      this.undrawCount = paramInt;
    }
    
    public void setUndraws(List<GiftUnDrawBase> paramList)
    {
      this.undraws = paramList;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/model/GiftListBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */