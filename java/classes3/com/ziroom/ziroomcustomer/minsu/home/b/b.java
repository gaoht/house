package com.ziroom.ziroomcustomer.minsu.home.b;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBeanToday.DataBean;
import java.util.List;

public class b
  extends com.freelxl.baselibrary.b.b
{
  private String a;
  private a b;
  
  public a getData()
  {
    return this.b;
  }
  
  public String getMessage()
  {
    return this.a;
  }
  
  public void setData(a parama)
  {
    this.b = parama;
  }
  
  public void setMessage(String paramString)
  {
    this.a = paramString;
  }
  
  public static class a
  {
    private b a;
    private MinsuHouseBeanToday.DataBean b;
    private a c;
    
    public a getMINSUINVENTORY()
    {
      return this.c;
    }
    
    public MinsuHouseBeanToday.DataBean getTODAYDISCOUNT()
    {
      return this.b;
    }
    
    public b getTOP50()
    {
      return this.a;
    }
    
    public void setMINSUINVENTORY(a parama)
    {
      this.c = parama;
    }
    
    public void setTODAYDISCOUNT(MinsuHouseBeanToday.DataBean paramDataBean)
    {
      this.b = paramDataBean;
    }
    
    public void setTOP50(b paramb)
    {
      this.a = paramb;
    }
    
    public static class a
    {
      private a a;
      private String b;
      private String c;
      private List<MinsuHouseBean.DataBean.ListBean> d;
      
      public a getCover()
      {
        return this.a;
      }
      
      public List<MinsuHouseBean.DataBean.ListBean> getHouse()
      {
        return this.d;
      }
      
      public String getSubtitle()
      {
        return this.b;
      }
      
      public String getTitle()
      {
        return this.c;
      }
      
      public void setCover(a parama)
      {
        this.a = parama;
      }
      
      public void setHouse(List<MinsuHouseBean.DataBean.ListBean> paramList)
      {
        this.d = paramList;
      }
      
      public void setSubtitle(String paramString)
      {
        this.b = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.c = paramString;
      }
      
      public static class a
      {
        private String a;
        private String b;
        private String c;
        private String d;
        
        public String getImg()
        {
          return this.a;
        }
        
        public String getTarget()
        {
          return this.d;
        }
        
        public String getTitle()
        {
          return this.b;
        }
        
        public String getType()
        {
          return this.c;
        }
        
        public void setImg(String paramString)
        {
          this.a = paramString;
        }
        
        public void setTarget(String paramString)
        {
          this.d = paramString;
        }
        
        public void setTitle(String paramString)
        {
          this.b = paramString;
        }
        
        public void setType(String paramString)
        {
          this.c = paramString;
        }
      }
    }
    
    public static class b
    {
      private int a;
      private String b;
      private String c;
      private String d;
      private List<a> e;
      
      public String getEnTitle()
      {
        return this.b;
      }
      
      public List<a> getList()
      {
        return this.e;
      }
      
      public String getTop50ListShareTitle()
      {
        return this.c;
      }
      
      public int getTotal()
      {
        return this.a;
      }
      
      public String getZhTitle()
      {
        return this.d;
      }
      
      public void setEnTitle(String paramString)
      {
        this.b = paramString;
      }
      
      public void setList(List<a> paramList)
      {
        this.e = paramList;
      }
      
      public void setTop50ListShareTitle(String paramString)
      {
        this.c = paramString;
      }
      
      public void setTotal(int paramInt)
      {
        this.a = paramInt;
      }
      
      public void setZhTitle(String paramString)
      {
        this.d = paramString;
      }
      
      public static class a
      {
        private String a;
        private String b;
        private int c;
        private String d;
        private List<String> e;
        
        public String getFid()
        {
          return this.a;
        }
        
        public String getHouseName()
        {
          return this.b;
        }
        
        public List<String> getIndivLabelTipsList()
        {
          return this.e;
        }
        
        public String getPicUrl()
        {
          return this.d;
        }
        
        public int getRentWay()
        {
          return this.c;
        }
        
        public void setFid(String paramString)
        {
          this.a = paramString;
        }
        
        public void setHouseName(String paramString)
        {
          this.b = paramString;
        }
        
        public void setIndivLabelTipsList(List<String> paramList)
        {
          this.e = paramList;
        }
        
        public void setPicUrl(String paramString)
        {
          this.d = paramString;
        }
        
        public void setRentWay(int paramInt)
        {
          this.c = paramInt;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/home/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */