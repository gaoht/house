package com.ziroom.ziroomcustomer.pay.huifu.bean;

public class HuifuBaseJson
{
  private int error_code;
  private String error_message;
  private String status;
  
  public int getError_code()
  {
    return this.error_code;
  }
  
  public String getError_message()
  {
    return this.error_message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public boolean isSuccess()
  {
    return this.status.equals("success");
  }
  
  public void setError_code(int paramInt)
  {
    this.error_code = paramInt;
  }
  
  public void setError_message(String paramString)
  {
    this.error_message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/huifu/bean/HuifuBaseJson.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */