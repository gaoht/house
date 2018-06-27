package com.ziroom.ziroomcustomer.newchat.chatcenter;

import java.io.Serializable;

public class i
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  private String d;
  private boolean e;
  private boolean f;
  
  public String getHighlightName()
  {
    return this.c;
  }
  
  public String getId()
  {
    return this.a;
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public String getSource()
  {
    return this.d;
  }
  
  public boolean isImageKnowledge()
  {
    return this.e;
  }
  
  public boolean isVideoKnowledge()
  {
    return this.f;
  }
  
  public void setHighlightName(String paramString)
  {
    this.c = paramString;
  }
  
  public void setId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setImageKnowledge(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setSource(String paramString)
  {
    this.d = paramString;
  }
  
  public void setVideoKnowledge(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */