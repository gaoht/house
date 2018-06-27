package com.ziroom.ziroomcustomer.findhouse.model;

public class HouselistSuggestBean
{
  public static final int TYPE_BIZCIRCLE = 1;
  public static final int TYPE_RESBLOCK = 2;
  private int count;
  private String id;
  private long lastTime;
  private String name;
  private int type;
  
  public int getCount()
  {
    return this.count;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public long getLastTime()
  {
    return this.lastTime;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setLastTime(long paramLong)
  {
    this.lastTime = paramLong;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String toString()
  {
    return "HouselistSuggestBean{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", count='" + this.count + '\'' + ", lastTime=" + this.lastTime + ", type=" + this.type + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/HouselistSuggestBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */