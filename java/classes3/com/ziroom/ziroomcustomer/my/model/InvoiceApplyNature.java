package com.ziroom.ziroomcustomer.my.model;

public class InvoiceApplyNature
{
  private boolean fwAvaiable;
  private boolean fzAvaiable;
  private String notApplyInvoiceTodo;
  
  public String getNotApplyInvoiceTodo()
  {
    return this.notApplyInvoiceTodo;
  }
  
  public boolean isFwAvaiable()
  {
    return this.fwAvaiable;
  }
  
  public boolean isFzAvaiable()
  {
    return this.fzAvaiable;
  }
  
  public void setFwAvaiable(boolean paramBoolean)
  {
    this.fwAvaiable = paramBoolean;
  }
  
  public void setFzAvaiable(boolean paramBoolean)
  {
    this.fzAvaiable = paramBoolean;
  }
  
  public void setNotApplyInvoiceTodo(String paramString)
  {
    this.notApplyInvoiceTodo = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/InvoiceApplyNature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */