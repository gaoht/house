package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class Server
{
  private List<ServerDetail> list;
  
  public List<ServerDetail> getList()
  {
    return this.list;
  }
  
  public void setList(List<ServerDetail> paramList)
  {
    this.list = paramList;
  }
  
  public String toString()
  {
    return "Server [list=" + this.list + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/Server.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */