package b;

public class k<TResult>
{
  private final j<TResult> a = new j();
  
  public j<TResult> getTask()
  {
    return this.a;
  }
  
  public void setCancelled()
  {
    if (!trySetCancelled()) {
      throw new IllegalStateException("Cannot cancel a completed task.");
    }
  }
  
  public void setError(Exception paramException)
  {
    if (!trySetError(paramException)) {
      throw new IllegalStateException("Cannot set the error on a completed task.");
    }
  }
  
  public void setResult(TResult paramTResult)
  {
    if (!trySetResult(paramTResult)) {
      throw new IllegalStateException("Cannot set the result of a completed task.");
    }
  }
  
  public boolean trySetCancelled()
  {
    return this.a.a();
  }
  
  public boolean trySetError(Exception paramException)
  {
    return this.a.a(paramException);
  }
  
  public boolean trySetResult(TResult paramTResult)
  {
    return this.a.a(paramTResult);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */