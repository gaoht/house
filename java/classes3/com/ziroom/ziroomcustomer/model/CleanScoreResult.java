package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class CleanScoreResult
{
  private int SATISFY;
  private List<CleanScoreItemResult> SCOREITEM;
  private String fid;
  
  public String getFid()
  {
    return this.fid;
  }
  
  public int getSATISFY()
  {
    return this.SATISFY;
  }
  
  public List<CleanScoreItemResult> getSCOREITEM()
  {
    return this.SCOREITEM;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setSATISFY(int paramInt)
  {
    this.SATISFY = paramInt;
  }
  
  public void setSCOREITEM(List<CleanScoreItemResult> paramList)
  {
    this.SCOREITEM = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanScoreResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */