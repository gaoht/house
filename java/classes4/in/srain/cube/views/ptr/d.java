package in.srain.cube.views.ptr;

public abstract class d
  implements Runnable
{
  private Runnable a;
  private byte b = 0;
  
  public void reset()
  {
    this.b = 0;
  }
  
  public void resume()
  {
    if (this.a != null) {
      this.a.run();
    }
    this.b = 2;
  }
  
  public void setResumeAction(Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }
  
  public void takeOver()
  {
    takeOver(null);
  }
  
  public void takeOver(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.a = paramRunnable;
    }
    switch (this.b)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.b = 1;
      run();
      return;
    }
    resume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/in/srain/cube/views/ptr/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */