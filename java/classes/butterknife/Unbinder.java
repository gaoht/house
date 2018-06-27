package butterknife;

public abstract interface Unbinder
{
  public static final Unbinder EMPTY = new Unbinder()
  {
    public void unbind() {}
  };
  
  public abstract void unbind();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/butterknife/Unbinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */