package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.e;
import java.lang.ref.WeakReference;

public class ay
  extends Resources
{
  private final WeakReference<Context> a;
  
  public ay(Context paramContext, Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.a = new WeakReference(paramContext);
  }
  
  public static boolean shouldBeUsed()
  {
    return (e.isCompatVectorFromResourcesEnabled()) && (Build.VERSION.SDK_INT <= 20);
  }
  
  final Drawable a(int paramInt)
  {
    return super.getDrawable(paramInt);
  }
  
  public Drawable getDrawable(int paramInt)
    throws Resources.NotFoundException
  {
    Context localContext = (Context)this.a.get();
    if (localContext != null) {
      return g.get().a(localContext, this, paramInt);
    }
    return super.getDrawable(paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */