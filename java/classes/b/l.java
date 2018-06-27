package b;

class l
{
  private j<?> a;
  
  public l(j<?> paramj)
  {
    this.a = paramj;
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      j localj = this.a;
      if (localj != null)
      {
        j.b localb = j.getUnobservedExceptionHandler();
        if (localb != null) {
          localb.unobservedException(localj, new m(localj.getError()));
        }
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public void setObserved()
  {
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */