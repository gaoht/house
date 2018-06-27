package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class EvaluateSign
  implements Serializable
{
  private List<EvaluateWithStar> questions;
  private String uid;
  
  public List<EvaluateWithStar> getQuestions()
  {
    return this.questions;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public void setQuestions(List<EvaluateWithStar> paramList)
  {
    this.questions = paramList;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/EvaluateSign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */