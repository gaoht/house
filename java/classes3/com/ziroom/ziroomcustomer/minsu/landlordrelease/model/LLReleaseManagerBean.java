package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import java.io.Serializable;
import java.util.List;

public class LLReleaseManagerBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
    implements Serializable
  {
    public String buttonColor;
    public String buttonStr;
    public String defaultPic;
    public String houseSn;
    public int houseStatus;
    public String houseStatusName;
    public String labelColor;
    public List<TitleListBean> titleList;
    
    public static class TitleListBean
    {
      public boolean isEdit;
      public String text;
      public String title;
      public String value;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/LLReleaseManagerBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */