package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.io.Serializable;
import java.util.List;

public class MoveRecModel
  implements Serializable
{
  public List<ItemContentBean> itemContent;
  public String itemNum;
  public String picUrl;
  public String slogan;
  
  public static class ItemContentBean
    implements Serializable
  {
    public String content;
    public boolean isSelect;
    public String num;
    public String option;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MoveRecModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */