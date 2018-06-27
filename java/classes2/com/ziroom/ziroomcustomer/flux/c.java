package com.ziroom.ziroomcustomer.flux;

public abstract class c
{
  private static final org.greenrobot.eventbus.c b = ;
  protected final String a;
  
  public c()
  {
    this(null);
  }
  
  public c(Object paramObject)
  {
    if (paramObject != null)
    {
      this.a = paramObject.getClass().getName();
      return;
    }
    this.a = null;
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = new com.ziroom.ziroomcustomer.flux.a.a(parama.getType(), this.a);
    b.post(parama);
  }
  
  void a(a parama)
  {
    if ((this.a == null) || (parama.getTarget() == null) || (!this.a.equals(parama.getTarget()))) {
      return;
    }
    onAction(parama);
  }
  
  public void emitStoreChange(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    b.post(parama);
  }
  
  public abstract void onAction(a parama);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/flux/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */