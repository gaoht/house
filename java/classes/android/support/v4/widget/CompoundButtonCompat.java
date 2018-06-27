package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class CompoundButtonCompat
{
  private static final CompoundButtonCompatBaseImpl IMPL = new CompoundButtonCompatBaseImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      IMPL = new CompoundButtonCompatApi23Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      IMPL = new CompoundButtonCompatApi21Impl();
      return;
    }
  }
  
  public static Drawable getButtonDrawable(CompoundButton paramCompoundButton)
  {
    return IMPL.getButtonDrawable(paramCompoundButton);
  }
  
  public static ColorStateList getButtonTintList(CompoundButton paramCompoundButton)
  {
    return IMPL.getButtonTintList(paramCompoundButton);
  }
  
  public static PorterDuff.Mode getButtonTintMode(CompoundButton paramCompoundButton)
  {
    return IMPL.getButtonTintMode(paramCompoundButton);
  }
  
  public static void setButtonTintList(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    IMPL.setButtonTintList(paramCompoundButton, paramColorStateList);
  }
  
  public static void setButtonTintMode(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    IMPL.setButtonTintMode(paramCompoundButton, paramMode);
  }
  
  static class CompoundButtonCompatApi21Impl
    extends CompoundButtonCompat.CompoundButtonCompatBaseImpl
  {
    public ColorStateList getButtonTintList(CompoundButton paramCompoundButton)
    {
      return paramCompoundButton.getButtonTintList();
    }
    
    public PorterDuff.Mode getButtonTintMode(CompoundButton paramCompoundButton)
    {
      return paramCompoundButton.getButtonTintMode();
    }
    
    public void setButtonTintList(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
    {
      paramCompoundButton.setButtonTintList(paramColorStateList);
    }
    
    public void setButtonTintMode(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
    {
      paramCompoundButton.setButtonTintMode(paramMode);
    }
  }
  
  static class CompoundButtonCompatApi23Impl
    extends CompoundButtonCompat.CompoundButtonCompatApi21Impl
  {
    public Drawable getButtonDrawable(CompoundButton paramCompoundButton)
    {
      return paramCompoundButton.getButtonDrawable();
    }
  }
  
  static class CompoundButtonCompatBaseImpl
  {
    private static final String TAG = "CompoundButtonCompat";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;
    
    public Drawable getButtonDrawable(CompoundButton paramCompoundButton)
    {
      if (!sButtonDrawableFieldFetched) {}
      try
      {
        sButtonDrawableField = CompoundButton.class.getDeclaredField("mButtonDrawable");
        sButtonDrawableField.setAccessible(true);
        sButtonDrawableFieldFetched = true;
        if (sButtonDrawableField == null) {}
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          try
          {
            paramCompoundButton = (Drawable)sButtonDrawableField.get(paramCompoundButton);
            return paramCompoundButton;
          }
          catch (IllegalAccessException paramCompoundButton)
          {
            Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", paramCompoundButton);
            sButtonDrawableField = null;
          }
          localNoSuchFieldException = localNoSuchFieldException;
          Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", localNoSuchFieldException);
        }
      }
      return null;
    }
    
    public ColorStateList getButtonTintList(CompoundButton paramCompoundButton)
    {
      if ((paramCompoundButton instanceof TintableCompoundButton)) {
        return ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintList();
      }
      return null;
    }
    
    public PorterDuff.Mode getButtonTintMode(CompoundButton paramCompoundButton)
    {
      if ((paramCompoundButton instanceof TintableCompoundButton)) {
        return ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintMode();
      }
      return null;
    }
    
    public void setButtonTintList(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
    {
      if ((paramCompoundButton instanceof TintableCompoundButton)) {
        ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintList(paramColorStateList);
      }
    }
    
    public void setButtonTintMode(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
    {
      if ((paramCompoundButton instanceof TintableCompoundButton)) {
        ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintMode(paramMode);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/widget/CompoundButtonCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */