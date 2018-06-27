package butterknife.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.TypedValue;
import android.view.View;
import java.lang.reflect.Array;
import java.util.List;

public final class Utils
{
  private static final boolean HAS_SUPPORT_V4 = ;
  private static final TypedValue VALUE = new TypedValue();
  
  private Utils()
  {
    throw new AssertionError("No instances.");
  }
  
  @SafeVarargs
  public static <T> T[] arrayOf(T... paramVarArgs)
  {
    return filterNull(paramVarArgs);
  }
  
  public static <T> T castParam(Object paramObject, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    return (T)paramObject;
  }
  
  public static <T> T castView(View paramView, int paramInt, String paramString, Class<T> paramClass)
  {
    try
    {
      paramClass = paramClass.cast(paramView);
      return paramClass;
    }
    catch (ClassCastException paramClass)
    {
      paramView = getResourceEntryName(paramView, paramInt);
      throw new IllegalStateException("View '" + paramView + "' with ID " + paramInt + " for " + paramString + " was of the wrong type. See cause for more info.", paramClass);
    }
  }
  
  private static <T> T[] filterNull(T[] paramArrayOfT)
  {
    int m = paramArrayOfT.length;
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < m)
    {
      localObject = paramArrayOfT[j];
      if (localObject == null) {
        break label81;
      }
      int k = i + 1;
      paramArrayOfT[i] = localObject;
      i = k;
    }
    label81:
    for (;;)
    {
      j += 1;
      break;
      if (i == m) {
        return paramArrayOfT;
      }
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
      System.arraycopy(paramArrayOfT, 0, localObject, 0, i);
      return (T[])localObject;
    }
  }
  
  public static <T> T findOptionalViewAsType(View paramView, int paramInt, String paramString, Class<T> paramClass)
  {
    return (T)castView(paramView.findViewById(paramInt), paramInt, paramString, paramClass);
  }
  
  public static View findRequiredView(View paramView, int paramInt, String paramString)
  {
    View localView = paramView.findViewById(paramInt);
    if (localView != null) {
      return localView;
    }
    paramView = getResourceEntryName(paramView, paramInt);
    throw new IllegalStateException("Required view '" + paramView + "' with ID " + paramInt + " for " + paramString + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
  }
  
  public static <T> T findRequiredViewAsType(View paramView, int paramInt, String paramString, Class<T> paramClass)
  {
    return (T)castView(findRequiredView(paramView, paramInt, paramString), paramInt, paramString, paramClass);
  }
  
  public static int getColor(Resources paramResources, Resources.Theme paramTheme, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return paramResources.getColor(paramInt);
    }
    return paramResources.getColor(paramInt, paramTheme);
  }
  
  public static ColorStateList getColorStateList(Resources paramResources, Resources.Theme paramTheme, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return paramResources.getColorStateList(paramInt);
    }
    return paramResources.getColorStateList(paramInt, paramTheme);
  }
  
  public static Drawable getDrawable(Resources paramResources, Resources.Theme paramTheme, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return paramResources.getDrawable(paramInt);
    }
    return paramResources.getDrawable(paramInt, paramTheme);
  }
  
  public static float getFloat(Resources paramResources, int paramInt)
  {
    TypedValue localTypedValue = VALUE;
    paramResources.getValue(paramInt, localTypedValue, true);
    if (localTypedValue.type == 4) {
      return localTypedValue.getFloat();
    }
    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(paramInt) + " type #0x" + Integer.toHexString(localTypedValue.type) + " is not valid");
  }
  
  private static String getResourceEntryName(View paramView, int paramInt)
  {
    if (paramView.isInEditMode()) {
      return "<unavailable while editing>";
    }
    return paramView.getContext().getResources().getResourceEntryName(paramInt);
  }
  
  public static Drawable getTintedDrawable(Resources paramResources, Resources.Theme paramTheme, int paramInt1, int paramInt2)
  {
    if (HAS_SUPPORT_V4) {
      return SupportV4.getTintedDrawable(paramResources, paramTheme, paramInt1, paramInt2);
    }
    throw new RuntimeException("Android support-v4 library is required for @BindDrawable with tint.");
  }
  
  private static boolean hasSupportV4()
  {
    try
    {
      Class.forName("android.support.v4.graphics.drawable.DrawableCompat");
      return true;
    }
    catch (VerifyError localVerifyError)
    {
      return false;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  @SafeVarargs
  public static <T> List<T> listOf(T... paramVarArgs)
  {
    return new ImmutableList(filterNull(paramVarArgs));
  }
  
  static class SupportV4
  {
    private static final TypedValue OUT_VALUE = new TypedValue();
    
    static Drawable getTintedDrawable(Resources paramResources, Resources.Theme paramTheme, int paramInt1, int paramInt2)
    {
      if (!paramTheme.resolveAttribute(paramInt2, OUT_VALUE, true)) {
        throw new Resources.NotFoundException("Required tint color attribute with name " + paramResources.getResourceEntryName(paramInt2) + " and attribute ID " + paramInt2 + " was not found.");
      }
      Drawable localDrawable = DrawableCompat.wrap(Utils.getDrawable(paramResources, paramTheme, paramInt1).mutate());
      DrawableCompat.setTint(localDrawable, Utils.getColor(paramResources, paramTheme, OUT_VALUE.resourceId));
      return localDrawable;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/butterknife/internal/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */