package com.ziroom.datacenter.remote.responsebody.financial.youpin;

import java.util.List;

public class p
{
  private String a;
  private String b;
  private String c;
  private int d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private Double l;
  private Double m;
  private Double n;
  private Double o;
  private a p;
  private b q;
  private List<Object> r;
  private List<Object> s;
  private List<Object> t;
  private Integer u;
  
  public String getAddress()
  {
    return this.g;
  }
  
  public String getConnectionName()
  {
    return this.h;
  }
  
  public String getConnectionPhone()
  {
    return this.i;
  }
  
  public String getCreateTime()
  {
    return this.f;
  }
  
  public Double getFreight()
  {
    return this.m;
  }
  
  public List<Object> getGoodsList()
  {
    return this.r;
  }
  
  public a getInvoiceInfo()
  {
    return this.p;
  }
  
  public Integer getIsPay()
  {
    return this.u;
  }
  
  public String getLogicCode()
  {
    return this.a;
  }
  
  public List<Object> getLogistics()
  {
    return this.t;
  }
  
  public String getOrderCode()
  {
    return this.k;
  }
  
  public Double getOrderPrice()
  {
    return this.o;
  }
  
  public int getOrderStatus()
  {
    return this.d;
  }
  
  public String getOrderStatusName()
  {
    return this.e;
  }
  
  public String getProductCode()
  {
    return this.b;
  }
  
  public String getProductName()
  {
    return this.c;
  }
  
  public List<Object> getRecords()
  {
    return this.s;
  }
  
  public b getRetreatInfo()
  {
    return this.q;
  }
  
  public Double getTotalCouponPrice()
  {
    return this.n;
  }
  
  public Double getTotalOrderPrice()
  {
    return this.l;
  }
  
  public String getUserMessage()
  {
    return this.j;
  }
  
  public void setAddress(String paramString)
  {
    this.g = paramString;
  }
  
  public void setConnectionName(String paramString)
  {
    this.h = paramString;
  }
  
  public void setConnectionPhone(String paramString)
  {
    this.i = paramString;
  }
  
  public void setCreateTime(String paramString)
  {
    this.f = paramString;
  }
  
  public void setFreight(Double paramDouble)
  {
    this.m = paramDouble;
  }
  
  public void setGoodsList(List<Object> paramList)
  {
    this.r = paramList;
  }
  
  public void setInvoiceInfo(a parama)
  {
    this.p = parama;
  }
  
  public void setIsPay(Integer paramInteger)
  {
    this.u = paramInteger;
  }
  
  public void setLogicCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setLogistics(List<Object> paramList)
  {
    this.t = paramList;
  }
  
  public void setOrderCode(String paramString)
  {
    this.k = paramString;
  }
  
  public void setOrderPrice(Double paramDouble)
  {
    this.o = paramDouble;
  }
  
  public void setOrderStatus(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setOrderStatusName(String paramString)
  {
    this.e = paramString;
  }
  
  public void setProductCode(String paramString)
  {
    this.b = paramString;
  }
  
  public void setProductName(String paramString)
  {
    this.c = paramString;
  }
  
  public void setRecords(List<Object> paramList)
  {
    this.s = paramList;
  }
  
  public void setRetreatInfo(b paramb)
  {
    this.q = paramb;
  }
  
  public void setTotalCouponPrice(Double paramDouble)
  {
    this.n = paramDouble;
  }
  
  public void setTotalOrderPrice(Double paramDouble)
  {
    this.l = paramDouble;
  }
  
  public void setUserMessage(String paramString)
  {
    this.j = paramString;
  }
  
  public class a
  {
    private int b;
    private String c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;
    private String i;
    
    public a() {}
    
    public String getInvoiceContent()
    {
      return this.g;
    }
    
    public String getInvoiceIdentityNo()
    {
      return this.h;
    }
    
    public int getInvoiceStatus()
    {
      return this.b;
    }
    
    public String getInvoiceStatusName()
    {
      return this.c;
    }
    
    public String getInvoiceTitle()
    {
      return this.f;
    }
    
    public int getInvoiceType()
    {
      return this.d;
    }
    
    public int getPayerType()
    {
      return this.e;
    }
    
    public String getShowUrl()
    {
      return this.i;
    }
    
    public void setInvoiceContent(String paramString)
    {
      this.g = paramString;
    }
    
    public void setInvoiceIdentityNo(String paramString)
    {
      this.h = paramString;
    }
    
    public void setInvoiceStatus(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void setInvoiceStatusName(String paramString)
    {
      this.c = paramString;
    }
    
    public void setInvoiceTitle(String paramString)
    {
      this.f = paramString;
    }
    
    public void setInvoiceType(int paramInt)
    {
      this.d = paramInt;
    }
    
    public void setPayerType(int paramInt)
    {
      this.e = paramInt;
    }
    
    public void setShowUrl(String paramString)
    {
      this.i = paramString;
    }
  }
  
  public class b
  {
    private String b;
    private Integer c;
    private Integer d;
    private Double e;
    private Double f;
    private Double g;
    
    public b() {}
    
    public Double getAssemblyCost()
    {
      return this.g;
    }
    
    public Double getFreight()
    {
      return this.f;
    }
    
    public Double getRetreatFee()
    {
      return this.e;
    }
    
    public String getRetreatOrderCode()
    {
      return this.b;
    }
    
    public Integer getRetreatStatus()
    {
      return this.d;
    }
    
    public Integer getRetreatType()
    {
      return this.c;
    }
    
    public void setAssemblyCost(Double paramDouble)
    {
      this.g = paramDouble;
    }
    
    public void setFreight(Double paramDouble)
    {
      this.f = paramDouble;
    }
    
    public void setRetreatFee(Double paramDouble)
    {
      this.e = paramDouble;
    }
    
    public void setRetreatOrderCode(String paramString)
    {
      this.b = paramString;
    }
    
    public void setRetreatStatus(Integer paramInteger)
    {
      this.d = paramInteger;
    }
    
    public void setRetreatType(Integer paramInteger)
    {
      this.c = paramInteger;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/youpin/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */