package cn.testin.analysis;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

public class dd
  extends cz<Typeface>
{
  private int c = "lastFontValue".hashCode();
  private dl d;
  
  public dd(String paramString, Object[] paramArrayOfObject, dl paramdl)
  {
    super(paramString, paramArrayOfObject);
    this.a = paramString;
    this.b = paramArrayOfObject;
    this.d = paramdl;
    if ((this.a.equals("setTypeface")) && (!a(paramArrayOfObject))) {
      throw new NoSuchMethodException("Method " + this.a + " doesn't exit");
    }
  }
  
  public Object a(View paramView, Object... paramVarArgs)
  {
    if (this.a.equals("setTypeface")) {
      if (!a(paramVarArgs)) {}
    }
    while (!this.a.equals("getTypeface"))
    {
      try
      {
        paramVarArgs = (String)paramVarArgs[0];
        paramView.setTag(this.c, paramVarArgs);
        paramVarArgs = this.d.a(paramVarArgs);
        if (paramVarArgs != null) {
          ((TextView)paramView).setTypeface(paramVarArgs);
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          ar.a(paramView);
        }
      }
      return null;
    }
    return paramView.getTag(this.c);
  }
  
  public boolean a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0)) {}
    while (!(paramArrayOfObject[0] instanceof String)) {
      return false;
    }
    return true;
  }
  
  public void b(View paramView, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    for (paramVarArgs = (Typeface)paramVarArgs[0];; paramVarArgs = null)
    {
      ((TextView)paramView).setTypeface(paramVarArgs);
      paramView.setTag(this.c, null);
      return;
    }
  }
  
  public Typeface c(View paramView)
  {
    return ((TextView)paramView).getTypeface();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */