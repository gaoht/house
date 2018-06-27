package com.ziroom.ziroomcustomer.model;

import com.alibaba.fastjson.e;
import java.io.Serializable;
import java.util.List;

public class EvaluateWithStar
  implements Serializable
{
  private String answers;
  private String collectId;
  private String evaluateType;
  private String evaluatedPersonCode;
  private String evsceneCode;
  private e ext;
  private String mark;
  private List<EvaluateOption> options;
  private String orderCode;
  private String photoUrl;
  private String proName;
  private int rate;
  private String starCode;
  private String suggestCode;
  private String suggestContent;
  private String tip;
  private String title;
  private String type;
  
  public String getAnswers()
  {
    return this.answers;
  }
  
  public String getCollectId()
  {
    return this.collectId;
  }
  
  public String getEvaluateType()
  {
    return this.evaluateType;
  }
  
  public String getEvaluatedPersonCode()
  {
    return this.evaluatedPersonCode;
  }
  
  public String getEvsceneCode()
  {
    return this.evsceneCode;
  }
  
  public e getExt()
  {
    return this.ext;
  }
  
  public String getMark()
  {
    return this.mark;
  }
  
  public List<EvaluateOption> getOptions()
  {
    return this.options;
  }
  
  public String getOrderCode()
  {
    return this.orderCode;
  }
  
  public String getPhotoUrl()
  {
    return this.photoUrl;
  }
  
  public String getProName()
  {
    return this.proName;
  }
  
  public int getRate()
  {
    return this.rate;
  }
  
  public String getStarCode()
  {
    return this.starCode;
  }
  
  public String getSuggestCode()
  {
    return this.suggestCode;
  }
  
  public String getSuggestContent()
  {
    return this.suggestContent;
  }
  
  public String getTip()
  {
    return this.tip;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setAnswers(String paramString)
  {
    this.answers = paramString;
  }
  
  public void setCollectId(String paramString)
  {
    this.collectId = paramString;
  }
  
  public void setEvaluateType(String paramString)
  {
    this.evaluateType = paramString;
  }
  
  public void setEvaluatedPersonCode(String paramString)
  {
    this.evaluatedPersonCode = paramString;
  }
  
  public void setEvsceneCode(String paramString)
  {
    this.evsceneCode = paramString;
  }
  
  public void setExt(e parame)
  {
    this.ext = parame;
  }
  
  public void setMark(String paramString)
  {
    this.mark = paramString;
  }
  
  public void setOptions(List<EvaluateOption> paramList)
  {
    this.options = paramList;
  }
  
  public void setOrderCode(String paramString)
  {
    this.orderCode = paramString;
  }
  
  public void setPhotoUrl(String paramString)
  {
    this.photoUrl = paramString;
  }
  
  public void setProName(String paramString)
  {
    this.proName = paramString;
  }
  
  public void setRate(int paramInt)
  {
    this.rate = paramInt;
  }
  
  public void setStarCode(String paramString)
  {
    this.starCode = paramString;
  }
  
  public void setSuggestCode(String paramString)
  {
    this.suggestCode = paramString;
  }
  
  public void setSuggestContent(String paramString)
  {
    this.suggestContent = paramString;
  }
  
  public void setTip(String paramString)
  {
    this.tip = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/EvaluateWithStar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */