package cn.testin.analysis;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class de
  extends cz
{
  public de(String paramString, Object[] paramArrayOfObject)
  {
    super(paramString, paramArrayOfObject);
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.equals("setWidth")) && (!paramString.equals("setHeight")) && (!paramString.equals("getWidth")) && (!paramString.equals("getHeight")))) {
      throw new NoSuchMethodException("Method LayoutParams." + this.a + " doesn't exit");
    }
    if ((paramString.startsWith("set")) && (!a(paramArrayOfObject))) {
      throw new NoSuchMethodException("Method LayoutParams." + this.a + " doesn't exit");
    }
  }
  
  public Object a(View paramView, Object... paramVarArgs)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null) {
      return null;
    }
    if (this.a.equals("setWidth"))
    {
      if (!a(paramVarArgs)) {
        return null;
      }
      localLayoutParams.width = ((Integer)paramVarArgs[0]).intValue();
      paramView.setLayoutParams(localLayoutParams);
    }
    do
    {
      for (;;)
      {
        return null;
        if (!this.a.equals("setHeight")) {
          break;
        }
        if (!a(paramVarArgs)) {
          return null;
        }
        localLayoutParams.height = ((Integer)paramVarArgs[0]).intValue();
        paramView.setLayoutParams(localLayoutParams);
      }
      if (this.a.equals("getWidth")) {
        return Integer.valueOf(localLayoutParams.width);
      }
    } while (!this.a.equals("getHeight"));
    return Integer.valueOf(localLayoutParams.height);
  }
  
  public boolean a(Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    do
    {
      return false;
      paramVarArgs = paramVarArgs[0].getClass();
    } while ((paramVarArgs != Integer.TYPE) && (paramVarArgs != Integer.class));
    return true;
  }
  
  public Object b(View paramView)
  {
    try
    {
      paramView = a(paramView);
      return paramView;
    }
    catch (df paramView)
    {
      paramView.printStackTrace();
    }
    return null;
  }
  
  public void b(View paramView, Object... paramVarArgs)
  {
    a(paramView, paramVarArgs);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */