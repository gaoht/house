package com.ziroom.ziroomcustomer.ziroomstation.model;

import java.util.List;

public class StationDescription
{
  public int count_star;
  public String evaluatorId;
  public String ext;
  public boolean hasImg;
  public String headerUrl;
  public List<String> imgUrls;
  public boolean isExpanded;
  public String nickname;
  public String orderCode;
  public List<String> room_types;
  public List<String> tags;
  public String text_date;
  public String text_desc;
  public String text_phone;
  
  public String toString()
  {
    return "StationDescription{hasImg=" + this.hasImg + ", text_phone='" + this.text_phone + '\'' + ", evaluatorId='" + this.evaluatorId + '\'' + ", text_date='" + this.text_date + '\'' + ", room_types=" + this.room_types + ", count_star=" + this.count_star + ", text_desc='" + this.text_desc + '\'' + ", tags=" + this.tags + ", orderCode='" + this.orderCode + '\'' + ", ext='" + this.ext + '\'' + ", imgUrls=" + this.imgUrls + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StationDescription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */