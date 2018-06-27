package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.TypedValue;

class ao
{
  static final int[] a = { -16842910 };
  static final int[] b = { 16842908 };
  static final int[] c = { 16843518 };
  static final int[] d = { 16842919 };
  static final int[] e = { 16842912 };
  static final int[] f = { 16842913 };
  static final int[] g = { -16842919, -16842908 };
  static final int[] h = new int[0];
  private static final ThreadLocal<TypedValue> i = new ThreadLocal();
  private static final int[] j = new int[1];
  
  static int a(Context paramContext, int paramInt, float paramFloat)
  {
    paramInt = getThemeAttrColor(paramContext, paramInt);
    return ColorUtils.setAlphaComponent(paramInt, Math.round(Color.alpha(paramInt) * paramFloat));
  }
  
  private static TypedValue a()
  {
    TypedValue localTypedValue2 = (TypedValue)i.get();
    TypedValue localTypedValue1 = localTypedValue2;
    if (localTypedValue2 == null)
    {
      localTypedValue1 = new TypedValue();
      i.set(localTypedValue1);
    }
    return localTypedValue1;
  }
  
  public static ColorStateList createDisabledStateList(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { a, h }, new int[] { paramInt2, paramInt1 });
  }
  
  public static int getDisabledThemeAttrColor(Context paramContext, int paramInt)
  {
    Object localObject = getThemeAttrColorStateList(paramContext, paramInt);
    if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {
      return ((ColorStateList)localObject).getColorForState(a, ((ColorStateList)localObject).getDefaultColor());
    }
    localObject = a();
    paramContext.getTheme().resolveAttribute(16842803, (TypedValue)localObject, true);
    return a(paramContext, paramInt, ((TypedValue)localObject).getFloat());
  }
  
  public static int getThemeAttrColor(Context paramContext, int paramInt)
  {
    j[0] = paramInt;
    paramContext = at.obtainStyledAttributes(paramContext, null, j);
    try
    {
      paramInt = paramContext.getColor(0, 0);
      return paramInt;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public static ColorStateList getThemeAttrColorStateList(Context paramContext, int paramInt)
  {
    j[0] = paramInt;
    paramContext = at.obtainStyledAttributes(paramContext, null, j);
    try
    {
      ColorStateList localColorStateList = paramContext.getColorStateList(0);
      return localColorStateList;
    }
    finally
    {
      paramContext.recycle();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */