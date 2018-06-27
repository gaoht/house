package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.style;
import android.view.LayoutInflater;

public class d
  extends ContextWrapper
{
  private int a;
  private Resources.Theme b;
  private LayoutInflater c;
  private Configuration d;
  private Resources e;
  
  public d()
  {
    super(null);
  }
  
  public d(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramInt;
  }
  
  public d(Context paramContext, Resources.Theme paramTheme)
  {
    super(paramContext);
    this.b = paramTheme;
  }
  
  private Resources a()
  {
    if (this.e == null)
    {
      if (this.d != null) {
        break label27;
      }
      this.e = super.getResources();
    }
    for (;;)
    {
      return this.e;
      label27:
      if (Build.VERSION.SDK_INT >= 17) {
        this.e = createConfigurationContext(this.d).getResources();
      }
    }
  }
  
  private void b()
  {
    if (this.b == null) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.b = getResources().newTheme();
        Resources.Theme localTheme = getBaseContext().getTheme();
        if (localTheme != null) {
          this.b.setTo(localTheme);
        }
      }
      a(this.b, this.a, bool);
      return;
    }
  }
  
  protected void a(Resources.Theme paramTheme, int paramInt, boolean paramBoolean)
  {
    paramTheme.applyStyle(paramInt, true);
  }
  
  public void applyOverrideConfiguration(Configuration paramConfiguration)
  {
    if (this.e != null) {
      throw new IllegalStateException("getResources() or getAssets() has already been called");
    }
    if (this.d != null) {
      throw new IllegalStateException("Override configuration has already been set");
    }
    this.d = new Configuration(paramConfiguration);
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public AssetManager getAssets()
  {
    return getResources().getAssets();
  }
  
  public Configuration getOverrideConfiguration()
  {
    return this.d;
  }
  
  public Resources getResources()
  {
    return a();
  }
  
  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.c == null) {
        this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      return this.c;
    }
    return getBaseContext().getSystemService(paramString);
  }
  
  public Resources.Theme getTheme()
  {
    if (this.b != null) {
      return this.b;
    }
    if (this.a == 0) {
      this.a = R.style.Theme_AppCompat_Light;
    }
    b();
    return this.b;
  }
  
  public int getThemeResId()
  {
    return this.a;
  }
  
  public void setTheme(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      b();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */