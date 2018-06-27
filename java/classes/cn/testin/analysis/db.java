package cn.testin.analysis;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import java.util.WeakHashMap;

@TargetApi(11)
public class db
  extends cz<Object>
{
  private final int c = "originalImageSize".hashCode();
  private WeakHashMap<View, Drawable> d;
  private an e;
  
  public db(String paramString, Object[] paramArrayOfObject, an paraman)
  {
    super(paramString, paramArrayOfObject);
    this.e = paraman;
    if (paramString.startsWith("setCompoundImages"))
    {
      if (!a(paramArrayOfObject)) {
        throw new NoSuchMethodException("Method setCompoundImages doesn't exit");
      }
      this.d = new WeakHashMap();
    }
  }
  
  private Rect a(TextView paramTextView, Drawable paramDrawable, int paramInt, boolean paramBoolean)
  {
    Rect localRect = (Rect)paramTextView.getTag(paramInt);
    Object localObject = localRect;
    if (localRect == null)
    {
      if (paramDrawable == null) {
        break label58;
      }
      localObject = paramDrawable.getBounds();
      paramTextView.setTag(paramInt, paramDrawable.getBounds());
    }
    label58:
    for (paramDrawable = (Drawable)localObject;; paramDrawable = new Rect())
    {
      paramTextView.setTag(paramInt, paramDrawable);
      localObject = paramDrawable;
      if (!paramBoolean) {
        break;
      }
      return (Rect)localObject;
    }
    return null;
  }
  
  private int c()
  {
    if (this.a.contains("left")) {
      return 0;
    }
    if (this.a.contains("top")) {
      return 1;
    }
    if (this.a.contains("right")) {
      return 2;
    }
    return 3;
  }
  
  private boolean c(View paramView)
  {
    if ((this.d != null) && (this.d.containsKey(paramView)))
    {
      Drawable localDrawable = (Drawable)this.d.get(paramView);
      return a((TextView)paramView) == localDrawable;
    }
    return false;
  }
  
  public Object a(View paramView, Object... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        if ((!this.a.startsWith("setCompoundImages")) || (c(paramView))) {
          continue;
        }
        if (!(paramVarArgs[0] instanceof bq)) {
          break label227;
        }
        ar.f("-----setCompoundImages---------");
        localTextView = (TextView)paramView;
        arrayOfDrawable = localTextView.getCompoundDrawables();
        paramVarArgs = (bq)paramVarArgs[0];
        localObject = paramVarArgs.a;
        boolean bool = paramVarArgs.b;
        i = c();
        paramVarArgs = this.e.b((String)localObject, null);
        localObject = arrayOfDrawable[i];
        if (paramVarArgs == null) {
          continue;
        }
        localObject = a(localTextView, (Drawable)localObject, this.c + i, bool);
        if ((!bool) || (localObject == null) || (((Rect)localObject).isEmpty())) {
          continue;
        }
        paramVarArgs.setBounds((Rect)localObject);
      }
      catch (Exception paramView)
      {
        TextView localTextView;
        Drawable[] arrayOfDrawable;
        Object localObject;
        int i;
        paramView.printStackTrace();
        break label227;
        paramVarArgs = (Object[])localObject;
        continue;
        if (!this.a.startsWith("getCompoundImages")) {
          break label227;
        }
        paramView = a((TextView)paramView);
        return paramView;
      }
      this.d.put(paramView, paramVarArgs);
      arrayOfDrawable[i] = paramVarArgs;
      localTextView.setCompoundDrawables(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      break label227;
      paramVarArgs.setBounds(0, 0, paramVarArgs.getIntrinsicWidth(), paramVarArgs.getIntrinsicHeight());
    }
    label227:
    return null;
  }
  
  public Object a(TextView paramTextView)
  {
    return paramTextView.getCompoundDrawables()[c()];
  }
  
  public boolean a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0)) {}
    while (!(paramArrayOfObject[0] instanceof bq)) {
      return false;
    }
    return true;
  }
  
  public Object b(View paramView)
  {
    return ((TextView)paramView).getCompoundDrawables()[c()];
  }
  
  public void b(View paramView, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && ((paramVarArgs[0] instanceof Drawable))) {}
    for (paramVarArgs = (Drawable)paramVarArgs[0];; paramVarArgs = null)
    {
      Drawable[] arrayOfDrawable = ((TextView)paramView).getCompoundDrawables();
      arrayOfDrawable[c()] = paramVarArgs;
      ((TextView)paramView).setCompoundDrawables(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */