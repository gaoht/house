package cn.testin.analysis;

import android.view.View;

public abstract class cz<T>
{
  protected String a;
  protected Object[] b;
  
  public cz(String paramString, Object[] paramArrayOfObject)
  {
    this.a = paramString;
    this.b = paramArrayOfObject;
  }
  
  public static cz a(Class<?> paramClass1, String paramString, Object[] paramArrayOfObject, Class<?> paramClass2, an paraman, dl paramdl)
  {
    if ((paramString.contains("Width")) || (paramString.contains("Height"))) {
      return new de(paramString, paramArrayOfObject);
    }
    if (paramString.contains("CompoundImages")) {
      return new db(paramString, paramArrayOfObject, paraman);
    }
    if ((paramString.contains("Drawable")) || (paramString.contains("Background"))) {
      return new dc(paramString, paramArrayOfObject, paraman);
    }
    if (paramString.contains("Typeface")) {
      return new dd(paramString, paramArrayOfObject, paramdl);
    }
    return new da(paramClass1, paramString, paramArrayOfObject, paramClass2);
  }
  
  public Object a(View paramView)
  {
    return a(paramView, this.b);
  }
  
  public abstract Object a(View paramView, Object... paramVarArgs);
  
  public abstract boolean a(Object... paramVarArgs);
  
  public Object[] a()
  {
    return this.b;
  }
  
  public abstract T b(View paramView);
  
  public String b()
  {
    return this.a;
  }
  
  public abstract void b(View paramView, Object... paramVarArgs);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */