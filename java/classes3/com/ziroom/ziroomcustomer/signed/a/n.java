package com.ziroom.ziroomcustomer.signed.a;

import java.io.Serializable;
import java.util.List;

public class n
  implements Serializable
{
  String a;
  String b;
  List<l> c;
  
  public String getDesc()
  {
    return this.b;
  }
  
  public List<l> getList()
  {
    return this.c;
  }
  
  public String getRelated()
  {
    return this.a;
  }
  
  public void setDesc(String paramString)
  {
    this.b = paramString;
  }
  
  public void setList(List<l> paramList)
  {
    this.c = paramList;
  }
  
  public void setRelated(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    return "SignerCareerList{related='" + this.a + '\'' + ", desc='" + this.b + '\'' + ", list=" + this.c + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */