package android.support.v4.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.TypefaceCompat;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourcesCompat
{
  private static final String TAG = "ResourcesCompat";
  
  public static int getColor(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramResources.getColor(paramInt, paramTheme);
    }
    return paramResources.getColor(paramInt);
  }
  
  public static ColorStateList getColorStateList(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramResources.getColorStateList(paramInt, paramTheme);
    }
    return paramResources.getColorStateList(paramInt);
  }
  
  public static Drawable getDrawable(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramResources.getDrawable(paramInt, paramTheme);
    }
    return paramResources.getDrawable(paramInt);
  }
  
  public static Drawable getDrawableForDensity(Resources paramResources, int paramInt1, int paramInt2, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramResources.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
    }
    if (Build.VERSION.SDK_INT >= 15) {
      return paramResources.getDrawableForDensity(paramInt1, paramInt2);
    }
    return paramResources.getDrawable(paramInt1);
  }
  
  public static Typeface getFont(Context paramContext, int paramInt)
    throws Resources.NotFoundException
  {
    if (paramContext.isRestricted()) {
      return null;
    }
    return loadFont(paramContext, paramInt, new TypedValue(), 0, null);
  }
  
  public static Typeface getFont(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, TextView paramTextView)
    throws Resources.NotFoundException
  {
    if (paramContext.isRestricted()) {
      return null;
    }
    return loadFont(paramContext, paramInt1, paramTypedValue, paramInt2, paramTextView);
  }
  
  private static Typeface loadFont(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, TextView paramTextView)
  {
    Resources localResources = paramContext.getResources();
    localResources.getValue(paramInt1, paramTypedValue, true);
    paramContext = loadFont(paramContext, localResources, paramTypedValue, paramInt1, paramInt2, paramTextView);
    if (paramContext != null) {
      return paramContext;
    }
    throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(paramInt1));
  }
  
  private static Typeface loadFont(Context paramContext, Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, TextView paramTextView)
  {
    if (paramTypedValue.string == null) {
      throw new Resources.NotFoundException("Resource \"" + paramResources.getResourceName(paramInt1) + "\" (" + Integer.toHexString(paramInt1) + ") is not a Font: " + paramTypedValue);
    }
    String str = paramTypedValue.string.toString();
    if (!str.startsWith("res/")) {
      paramTypedValue = null;
    }
    Typeface localTypeface;
    do
    {
      return paramTypedValue;
      localTypeface = TypefaceCompat.findFromCache(paramResources, paramInt1, paramInt2);
      paramTypedValue = localTypeface;
    } while (localTypeface != null);
    try
    {
      if (str.toLowerCase().endsWith(".xml"))
      {
        paramTypedValue = FontResourcesParserCompat.parse(paramResources.getXml(paramInt1), paramResources);
        if (paramTypedValue == null)
        {
          Log.e("ResourcesCompat", "Failed to find font-family tag");
          return null;
        }
        return TypefaceCompat.createFromResourcesFamilyXml(paramContext, paramTypedValue, paramResources, paramInt1, paramInt2, paramTextView);
      }
      paramContext = TypefaceCompat.createFromResourcesFontFile(paramContext, paramResources, paramInt1, str, paramInt2);
      return paramContext;
    }
    catch (XmlPullParserException paramContext)
    {
      Log.e("ResourcesCompat", "Failed to parse xml resource " + str, paramContext);
      return null;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        Log.e("ResourcesCompat", "Failed to read xml resource " + str, paramContext);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/content/res/ResourcesCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */