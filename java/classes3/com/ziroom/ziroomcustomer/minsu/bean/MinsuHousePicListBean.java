package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuHousePicListBean
  extends MinsuBaseJson
{
  public List<DataBean> data;
  
  public static class DataBean
  {
    public String fid;
    public int heightPixel;
    public int isDefault;
    public int picType;
    public String picUrl;
    public int widthPixel;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuHousePicListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */