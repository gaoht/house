package android.support.v7.view.menu;

class d<T>
{
  final T b;
  
  d(T paramT)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Wrapped Object can not be null.");
    }
    this.b = paramT;
  }
  
  public T getWrappedObject()
  {
    return (T)this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */