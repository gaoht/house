package com.ziroom.ziroomcustomer.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class BizcircleDetail
  extends b
{
  public List<xzheng> data;
  
  public static class squan
  {
    public String bizcircle_code;
    public String bizcircle_name;
  }
  
  public class xzheng
  {
    public List<BizcircleDetail.squan> bizcircle;
    public String xzheng_name;
    
    public xzheng() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/BizcircleDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */