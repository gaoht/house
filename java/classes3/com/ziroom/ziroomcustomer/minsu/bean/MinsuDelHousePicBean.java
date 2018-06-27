package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuDelHousePicBean
  extends MinsuBaseJson
{
  public List<DataBean> data;
  
  public static class DataBean
  {
    public String fid;
    public int isDefault;
    public int picType;
    public String picUrl;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuDelHousePicBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */