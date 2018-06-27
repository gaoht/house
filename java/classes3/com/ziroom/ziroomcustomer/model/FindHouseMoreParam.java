package com.ziroom.ziroomcustomer.model;

public class FindHouseMoreParam
{
  private int bolcony;
  private int heating;
  private int house_type;
  private int huxing;
  private int max_area;
  private int min_area;
  private int nearSubway;
  private int newCommunity;
  private int newRent;
  private int privateToilet;
  private int selectCount = 1;
  private int toSouth;
  
  public FindHouseMoreParam() {}
  
  public FindHouseMoreParam(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    this.house_type = paramInt1;
    this.huxing = paramInt2;
    this.min_area = paramInt3;
    this.max_area = paramInt4;
    this.nearSubway = paramInt5;
    this.privateToilet = paramInt6;
    this.bolcony = paramInt7;
    this.toSouth = paramInt8;
    this.newRent = paramInt9;
    this.newCommunity = paramInt10;
    this.heating = paramInt11;
    this.selectCount = paramInt12;
  }
  
  public int getBolcony()
  {
    return this.bolcony;
  }
  
  public int getHeating()
  {
    return this.heating;
  }
  
  public int getHouse_type()
  {
    return this.house_type;
  }
  
  public int getHuxing()
  {
    return this.huxing;
  }
  
  public int getMax_area()
  {
    return this.max_area;
  }
  
  public int getMin_area()
  {
    return this.min_area;
  }
  
  public int getNearSubway()
  {
    return this.nearSubway;
  }
  
  public int getNewCommunity()
  {
    return this.newCommunity;
  }
  
  public int getNewRent()
  {
    return this.newRent;
  }
  
  public int getPrivateToilet()
  {
    return this.privateToilet;
  }
  
  public int getSelectCount()
  {
    return this.selectCount;
  }
  
  public int getToSouth()
  {
    return this.toSouth;
  }
  
  public void setBolcony(int paramInt)
  {
    this.bolcony = paramInt;
  }
  
  public void setHeating(int paramInt)
  {
    this.heating = paramInt;
  }
  
  public void setHouse_type(int paramInt)
  {
    this.house_type = paramInt;
  }
  
  public void setHuxing(int paramInt)
  {
    this.huxing = paramInt;
  }
  
  public void setMax_area(int paramInt)
  {
    this.max_area = paramInt;
  }
  
  public void setMin_area(int paramInt)
  {
    this.min_area = paramInt;
  }
  
  public void setNearSubway(int paramInt)
  {
    this.nearSubway = paramInt;
  }
  
  public void setNewCommunity(int paramInt)
  {
    this.newCommunity = paramInt;
  }
  
  public void setNewRent(int paramInt)
  {
    this.newRent = paramInt;
  }
  
  public void setPrivateToilet(int paramInt)
  {
    this.privateToilet = paramInt;
  }
  
  public void setSelectCount(int paramInt)
  {
    this.selectCount = paramInt;
  }
  
  public void setToSouth(int paramInt)
  {
    this.toSouth = paramInt;
  }
  
  public String toString()
  {
    return "FindHouseMoreParam{\r\nhouse_type=" + this.house_type + "\r\n, huxing=" + this.huxing + "\r\n, min_area=" + this.min_area + "\r\n, max_area=" + this.max_area + "\r\n, nearSubway=" + this.nearSubway + "\r\n, privateToilet=" + this.privateToilet + "\r\n, bolcony=" + this.bolcony + "\r\n, toSouth=" + this.toSouth + "\r\n, newRent=" + this.newRent + "\r\n, newCommunity=" + this.newCommunity + "\r\n, heating=" + this.heating + "\r\n, selectCount=" + this.selectCount + "\r\n" + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/FindHouseMoreParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */