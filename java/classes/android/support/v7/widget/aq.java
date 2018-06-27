package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class aq
  extends ContextWrapper
{
  private static final Object a = new Object();
  private static ArrayList<WeakReference<aq>> b;
  private final Resources c;
  private final Resources.Theme d;
  
  private aq(Context paramContext)
  {
    super(paramContext);
    if (ay.shouldBeUsed())
    {
      this.c = new ay(this, paramContext.getResources());
      this.d = this.c.newTheme();
      this.d.setTo(paramContext.getTheme());
      return;
    }
    this.c = new as(this, paramContext.getResources());
    this.d = null;
  }
  
  private static boolean a(Context paramContext)
  {
    if (((paramContext instanceof aq)) || ((paramContext.getResources() instanceof as)) || ((paramContext.getResources() instanceof ay))) {}
    while ((Build.VERSION.SDK_INT >= 21) && (!ay.shouldBeUsed())) {
      return false;
    }
    return true;
  }
  
  public static Context wrap(Context paramContext)
  {
    if (a(paramContext)) {}
    for (;;)
    {
      int i;
      synchronized (a)
      {
        if (b == null)
        {
          b = new ArrayList();
          paramContext = new aq(paramContext);
          b.add(new WeakReference(paramContext));
          return paramContext;
        }
        i = b.size() - 1;
        if (i >= 0)
        {
          localObject1 = (WeakReference)b.get(i);
          if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
            break label162;
          }
          b.remove(i);
          break label162;
        }
        i = b.size() - 1;
        if (i < 0) {
          continue;
        }
        localObject1 = (WeakReference)b.get(i);
        if (localObject1 == null) {
          break label169;
        }
        localObject1 = (aq)((WeakReference)localObject1).get();
        if ((localObject1 == null) || (((aq)localObject1).getBaseContext() != paramContext)) {
          break label174;
        }
        return (Context)localObject1;
      }
      return paramContext;
      label162:
      i -= 1;
      continue;
      label169:
      Object localObject1 = null;
      continue;
      label174:
      i -= 1;
    }
  }
  
  public AssetManager getAssets()
  {
    return this.c.getAssets();
  }
  
  public Resources getResources()
  {
    return this.c;
  }
  
  public Resources.Theme getTheme()
  {
    if (this.d == null) {
      return super.getTheme();
    }
    return this.d;
  }
  
  public void setTheme(int paramInt)
  {
    if (this.d == null)
    {
      super.setTheme(paramInt);
      return;
    }
    this.d.applyStyle(paramInt, true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */