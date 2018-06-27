package com.ziroom.ziroomcustomer.model.apartment.zramain;

import java.util.List;

public class ZraMainCommonBean
{
  public List<SubBean> list;
  public String title;
  
  public static class SubBean
  {
    public String bigPic;
    public String desc;
    public String headPic;
    public String price;
    public List<SmallPic> smallList;
    public String subTitle;
    public String target;
    public String title;
    public String titleTag;
    public String type;
    
    public static class SmallPic
    {
      public String smaPic;
      public String smaTitle;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/apartment/zramain/ZraMainCommonBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */