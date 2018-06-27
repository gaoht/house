package com.ziroom.ziroomcustomer.minsu.searchlist.model;

public enum SearchTab
{
  MINSU(8, ""),  STATION(8, ""),  STRATEGY(8, "");
  
  private String suggestMsg;
  private int visibility;
  
  private SearchTab(int paramInt, String paramString)
  {
    this.visibility = paramInt;
    this.suggestMsg = paramString;
  }
  
  public String getSuggestMsg()
  {
    return this.suggestMsg;
  }
  
  public int getVisibility()
  {
    return this.visibility;
  }
  
  public void setSuggestMsg(String paramString)
  {
    this.suggestMsg = paramString;
  }
  
  public void setVisibility(int paramInt)
  {
    this.visibility = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/model/SearchTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */