package cn.testin.analysis;

import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import java.util.WeakHashMap;

@TargetApi(11)
public class dc
  extends cz<Object>
{
  private static int e = "originalImageSize".hashCode();
  private WeakHashMap<View, Drawable> c;
  private an d;
  
  public dc(String paramString, Object[] paramArrayOfObject, an paraman)
  {
    super(paramString, paramArrayOfObject);
    this.d = paraman;
    if ((this.a.equals("setImageDrawable")) || (this.a.equals("setBackground")))
    {
      if (!a(paramArrayOfObject)) {
        throw new NoSuchMethodException("Method " + this.a + " doesn't exit");
      }
      this.c = new WeakHashMap();
    }
  }
  
  private Pair<Integer, Integer> a(ImageView paramImageView, boolean paramBoolean)
  {
    int j = 0;
    Pair localPair = (Pair)paramImageView.getTag(e);
    Object localObject = localPair;
    if (localPair == null)
    {
      localObject = paramImageView.getDrawable();
      if (localObject == null) {
        break label84;
      }
      j = ((Drawable)localObject).getIntrinsicWidth();
    }
    label84:
    for (int i = ((Drawable)localObject).getIntrinsicHeight();; i = 0)
    {
      localObject = new Pair(Integer.valueOf(j), Integer.valueOf(i));
      paramImageView.setTag(e, localObject);
      if (paramBoolean) {
        return (Pair<Integer, Integer>)localObject;
      }
      return null;
    }
  }
  
  private boolean a(View paramView, Drawable paramDrawable)
  {
    if ((this.c != null) && (this.c.containsKey(paramView))) {
      return paramDrawable == (Drawable)this.c.get(paramView);
    }
    return false;
  }
  
  public Object a(View paramView, Object... paramVarArgs)
  {
    if (this.a.equals("setImageDrawable"))
    {
      if ((!a(paramView, ((ImageView)paramView).getDrawable())) && ((paramVarArgs[0] instanceof bq)))
      {
        ar.f("--------setImage---------");
        try
        {
          paramVarArgs = (bq)paramVarArgs[0];
          String str = paramVarArgs.a;
          paramVarArgs = this.d.b(str, a((ImageView)paramView, paramVarArgs.b));
          if (paramVarArgs != null) {
            ((ImageView)paramView).setImageDrawable(paramVarArgs);
          }
          for (;;)
          {
            this.c.put(paramView, paramVarArgs);
            break;
            paramVarArgs = ((ImageView)paramView).getDrawable();
          }
          if (!this.a.equals("setBackground")) {
            break label202;
          }
        }
        catch (Exception paramView)
        {
          ar.a(paramView);
        }
      }
    }
    else if ((!a(paramView, paramView.getBackground())) && ((paramVarArgs[0] instanceof Number)))
    {
      paramVarArgs = new ColorDrawable(((Number)paramVarArgs[0]).intValue());
      this.c.put(paramView, paramVarArgs);
      if (Build.VERSION.SDK_INT < 16)
      {
        paramView.setBackgroundDrawable(paramVarArgs);
      }
      else
      {
        paramView.setBackground(paramVarArgs);
        break label239;
        label202:
        if (this.a.equals("getDrawable")) {
          return ((ImageView)paramView).getDrawable();
        }
        if (this.a.equals("getBackground")) {
          return paramView.getBackground();
        }
      }
    }
    label239:
    return null;
  }
  
  public boolean a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0)) {}
    while ((!(paramArrayOfObject[0] instanceof bq)) && (!(paramArrayOfObject[0] instanceof Number))) {
      return false;
    }
    return true;
  }
  
  public Object b(View paramView)
  {
    if (this.a.contains("Drawable")) {
      return ((ImageView)paramView).getDrawable();
    }
    return paramView.getBackground();
  }
  
  public void b(View paramView, Object... paramVarArgs)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVarArgs != null)
    {
      localObject1 = localObject2;
      if (paramVarArgs.length > 0)
      {
        localObject1 = localObject2;
        if ((paramVarArgs[0] instanceof Drawable)) {
          localObject1 = (Drawable)paramVarArgs[0];
        }
      }
    }
    if (this.a.equals("setImageDrawable")) {
      ((ImageView)paramView).setImageDrawable((Drawable)localObject1);
    }
    while (!this.a.equals("setBackground")) {
      return;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable((Drawable)localObject1);
      return;
    }
    paramView.setBackground((Drawable)localObject1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */