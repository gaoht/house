package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.graphics.drawable.c;
import android.support.graphics.drawable.i;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.LruCache;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.a.a.b;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.color;
import android.support.v7.appcompat.R.drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class g
{
  private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
  private static g b;
  private static final b c = new b(6);
  private static final int[] d = { R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha };
  private static final int[] e = { R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha };
  private static final int[] f = { R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light };
  private static final int[] g = { R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult };
  private static final int[] h = { R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material };
  private static final int[] i = { R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material };
  private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> j;
  private ArrayMap<String, c> k;
  private SparseArrayCompat<String> l;
  private final Object m = new Object();
  private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> n = new WeakHashMap(0);
  private TypedValue o;
  private boolean p;
  
  private static long a(TypedValue paramTypedValue)
  {
    return paramTypedValue.assetCookie << 32 | paramTypedValue.data;
  }
  
  private ColorStateList a(Context paramContext)
  {
    return e(paramContext, ao.getThemeAttrColor(paramContext, R.attr.colorButtonNormal));
  }
  
  static PorterDuff.Mode a(int paramInt)
  {
    PorterDuff.Mode localMode = null;
    if (paramInt == R.drawable.abc_switch_thumb_material) {
      localMode = PorterDuff.Mode.MULTIPLY;
    }
    return localMode;
  }
  
  private static PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int[] paramArrayOfInt)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return getPorterDuffColorFilter(paramColorStateList.getColorForState(paramArrayOfInt, 0), paramMode);
  }
  
  private Drawable a(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable)
  {
    Object localObject = a(paramContext, paramInt);
    if (localObject != null)
    {
      paramContext = paramDrawable;
      if (w.canSafelyMutateDrawable(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramContext = DrawableCompat.wrap(paramContext);
      DrawableCompat.setTintList(paramContext, (ColorStateList)localObject);
      paramDrawable = a(paramInt);
      localObject = paramContext;
      if (paramDrawable != null)
      {
        DrawableCompat.setTintMode(paramContext, paramDrawable);
        localObject = paramContext;
      }
    }
    do
    {
      do
      {
        return (Drawable)localObject;
        if (paramInt == R.drawable.abc_seekbar_track_material)
        {
          localObject = (LayerDrawable)paramDrawable;
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), ao.getThemeAttrColor(paramContext, R.attr.colorControlNormal), a);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), ao.getThemeAttrColor(paramContext, R.attr.colorControlNormal), a);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), ao.getThemeAttrColor(paramContext, R.attr.colorControlActivated), a);
          return paramDrawable;
        }
        if ((paramInt == R.drawable.abc_ratingbar_material) || (paramInt == R.drawable.abc_ratingbar_indicator_material) || (paramInt == R.drawable.abc_ratingbar_small_material))
        {
          localObject = (LayerDrawable)paramDrawable;
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), ao.getDisabledThemeAttrColor(paramContext, R.attr.colorControlNormal), a);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), ao.getThemeAttrColor(paramContext, R.attr.colorControlActivated), a);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), ao.getThemeAttrColor(paramContext, R.attr.colorControlActivated), a);
          return paramDrawable;
        }
        localObject = paramDrawable;
      } while (a(paramContext, paramInt, paramDrawable));
      localObject = paramDrawable;
    } while (!paramBoolean);
    return null;
  }
  
  private Drawable a(Context paramContext, long paramLong)
  {
    LongSparseArray localLongSparseArray;
    synchronized (this.m)
    {
      localLongSparseArray = (LongSparseArray)this.n.get(paramContext);
      if (localLongSparseArray == null) {
        return null;
      }
      Object localObject2 = (WeakReference)localLongSparseArray.get(paramLong);
      if (localObject2 == null) {
        break label90;
      }
      localObject2 = (Drawable.ConstantState)((WeakReference)localObject2).get();
      if (localObject2 != null)
      {
        paramContext = ((Drawable.ConstantState)localObject2).newDrawable(paramContext.getResources());
        return paramContext;
      }
    }
    localLongSparseArray.delete(paramLong);
    label90:
    return null;
  }
  
  private void a(Context paramContext, int paramInt, ColorStateList paramColorStateList)
  {
    if (this.j == null) {
      this.j = new WeakHashMap();
    }
    SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.j.get(paramContext);
    SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
    if (localSparseArrayCompat2 == null)
    {
      localSparseArrayCompat1 = new SparseArrayCompat();
      this.j.put(paramContext, localSparseArrayCompat1);
    }
    localSparseArrayCompat1.append(paramInt, paramColorStateList);
  }
  
  private static void a(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (w.canSafelyMutateDrawable(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = a;
    }
    localDrawable.setColorFilter(getPorterDuffColorFilter(paramInt, paramDrawable));
  }
  
  static void a(Drawable paramDrawable, ar paramar, int[] paramArrayOfInt)
  {
    if ((w.canSafelyMutateDrawable(paramDrawable)) && (paramDrawable.mutate() != paramDrawable)) {
      Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }
    label64:
    label92:
    label104:
    for (;;)
    {
      return;
      ColorStateList localColorStateList;
      if ((paramar.d) || (paramar.c)) {
        if (paramar.d)
        {
          localColorStateList = paramar.a;
          if (!paramar.c) {
            break label92;
          }
          paramar = paramar.b;
          paramDrawable.setColorFilter(a(localColorStateList, paramar, paramArrayOfInt));
        }
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT > 23) {
          break label104;
        }
        paramDrawable.invalidateSelf();
        return;
        localColorStateList = null;
        break;
        paramar = a;
        break label64;
        paramDrawable.clearColorFilter();
      }
    }
  }
  
  private static void a(g paramg)
  {
    if (Build.VERSION.SDK_INT < 24)
    {
      paramg.a("vector", new d());
      if (Build.VERSION.SDK_INT >= 11) {
        paramg.a("animated-vector", new a());
      }
    }
  }
  
  private void a(String paramString, c paramc)
  {
    if (this.k == null) {
      this.k = new ArrayMap();
    }
    this.k.put(paramString, paramc);
  }
  
  static boolean a(Context paramContext, int paramInt, Drawable paramDrawable)
  {
    PorterDuff.Mode localMode = a;
    int i1;
    int i2;
    if (a(d, paramInt))
    {
      i1 = R.attr.colorControlNormal;
      i2 = 1;
      paramInt = -1;
    }
    for (;;)
    {
      if (i2 != 0)
      {
        Drawable localDrawable = paramDrawable;
        if (w.canSafelyMutateDrawable(paramDrawable)) {
          localDrawable = paramDrawable.mutate();
        }
        localDrawable.setColorFilter(getPorterDuffColorFilter(ao.getThemeAttrColor(paramContext, i1), localMode));
        if (paramInt != -1) {
          localDrawable.setAlpha(paramInt);
        }
        return true;
        if (a(f, paramInt))
        {
          i1 = R.attr.colorControlActivated;
          i2 = 1;
          paramInt = -1;
          continue;
        }
        if (a(g, paramInt))
        {
          localMode = PorterDuff.Mode.MULTIPLY;
          i2 = 1;
          i1 = 16842801;
          paramInt = -1;
          continue;
        }
        if (paramInt == R.drawable.abc_list_divider_mtrl_alpha)
        {
          i1 = 16842800;
          paramInt = Math.round(40.8F);
          i2 = 1;
          continue;
        }
        if (paramInt == R.drawable.abc_dialog_material_background)
        {
          i1 = 16842801;
          i2 = 1;
          paramInt = -1;
        }
      }
      else
      {
        return false;
      }
      paramInt = -1;
      i1 = 0;
      i2 = 0;
    }
  }
  
  private boolean a(Context paramContext, long paramLong, Drawable paramDrawable)
  {
    Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
    if (localConstantState != null) {
      synchronized (this.m)
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)this.n.get(paramContext);
        paramDrawable = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          paramDrawable = new LongSparseArray();
          this.n.put(paramContext, paramDrawable);
        }
        paramDrawable.put(paramLong, new WeakReference(localConstantState));
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(Drawable paramDrawable)
  {
    return ((paramDrawable instanceof i)) || ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()));
  }
  
  private static boolean a(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int i2 = paramArrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (paramArrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  private ColorStateList b(Context paramContext)
  {
    return e(paramContext, 0);
  }
  
  private Drawable b(Context paramContext, int paramInt)
  {
    if (this.o == null) {
      this.o = new TypedValue();
    }
    TypedValue localTypedValue = this.o;
    paramContext.getResources().getValue(paramInt, localTypedValue, true);
    long l1 = a(localTypedValue);
    Object localObject1 = a(paramContext, l1);
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = localObject1;
    }
    do
    {
      return (Drawable)localObject2;
      if (paramInt == R.drawable.abc_cab_background_top_material) {
        localObject1 = new LayerDrawable(new Drawable[] { getDrawable(paramContext, R.drawable.abc_cab_background_internal_bg), getDrawable(paramContext, R.drawable.abc_cab_background_top_mtrl_alpha) });
      }
      localObject2 = localObject1;
    } while (localObject1 == null);
    ((Drawable)localObject1).setChangingConfigurations(localTypedValue.changingConfigurations);
    a(paramContext, l1, (Drawable)localObject1);
    return (Drawable)localObject1;
  }
  
  private ColorStateList c(Context paramContext)
  {
    return e(paramContext, ao.getThemeAttrColor(paramContext, R.attr.colorAccent));
  }
  
  private Drawable c(Context paramContext, int paramInt)
  {
    if ((this.k != null) && (!this.k.isEmpty()))
    {
      if (this.l != null)
      {
        localObject1 = (String)this.l.get(paramInt);
        if (("appcompat_skip_skip".equals(localObject1)) || ((localObject1 != null) && (this.k.get(localObject1) == null)))
        {
          localObject1 = null;
          return (Drawable)localObject1;
        }
      }
      else
      {
        this.l = new SparseArrayCompat();
      }
      if (this.o == null) {
        this.o = new TypedValue();
      }
      TypedValue localTypedValue = this.o;
      Object localObject1 = paramContext.getResources();
      ((Resources)localObject1).getValue(paramInt, localTypedValue, true);
      long l1 = a(localTypedValue);
      Drawable localDrawable = a(paramContext, l1);
      if (localDrawable != null) {
        return localDrawable;
      }
      Object localObject2 = localDrawable;
      XmlResourceParser localXmlResourceParser;
      AttributeSet localAttributeSet;
      if (localTypedValue.string != null)
      {
        localObject2 = localDrawable;
        if (localTypedValue.string.toString().endsWith(".xml"))
        {
          localObject2 = localDrawable;
          try
          {
            localXmlResourceParser = ((Resources)localObject1).getXml(paramInt);
            localObject2 = localDrawable;
            localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
            int i1;
            do
            {
              localObject2 = localDrawable;
              i1 = localXmlResourceParser.next();
            } while ((i1 != 2) && (i1 != 1));
            if (i1 != 2)
            {
              localObject2 = localDrawable;
              throw new XmlPullParserException("No start tag found");
            }
          }
          catch (Exception paramContext)
          {
            Log.e("AppCompatDrawableManager", "Exception while inflating drawable", paramContext);
          }
        }
      }
      for (paramContext = (Context)localObject2;; paramContext = (Context)localObject1)
      {
        localObject1 = paramContext;
        if (paramContext != null) {
          break;
        }
        this.l.append(paramInt, "appcompat_skip_skip");
        return paramContext;
        localObject2 = localDrawable;
        localObject1 = localXmlResourceParser.getName();
        localObject2 = localDrawable;
        this.l.append(paramInt, localObject1);
        localObject2 = localDrawable;
        c localc = (c)this.k.get(localObject1);
        localObject1 = localDrawable;
        if (localc != null)
        {
          localObject2 = localDrawable;
          localObject1 = localc.createFromXmlInner(paramContext, localXmlResourceParser, localAttributeSet, paramContext.getTheme());
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          ((Drawable)localObject1).setChangingConfigurations(localTypedValue.changingConfigurations);
          localObject2 = localObject1;
          boolean bool = a(paramContext, l1, (Drawable)localObject1);
          if (!bool) {}
        }
      }
    }
    return null;
  }
  
  private ColorStateList d(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    ColorStateList localColorStateList = ao.getThemeAttrColorStateList(paramContext, R.attr.colorSwitchThumbNormal);
    if ((localColorStateList != null) && (localColorStateList.isStateful()))
    {
      arrayOfInt[0] = ao.a;
      arrayOfInt1[0] = localColorStateList.getColorForState(arrayOfInt[0], 0);
      arrayOfInt[1] = ao.e;
      arrayOfInt1[1] = ao.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = ao.h;
      arrayOfInt1[2] = localColorStateList.getDefaultColor();
    }
    for (;;)
    {
      return new ColorStateList(arrayOfInt, arrayOfInt1);
      arrayOfInt[0] = ao.a;
      arrayOfInt1[0] = ao.getDisabledThemeAttrColor(paramContext, R.attr.colorSwitchThumbNormal);
      arrayOfInt[1] = ao.e;
      arrayOfInt1[1] = ao.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = ao.h;
      arrayOfInt1[2] = ao.getThemeAttrColor(paramContext, R.attr.colorSwitchThumbNormal);
    }
  }
  
  private ColorStateList d(Context paramContext, int paramInt)
  {
    if (this.j != null)
    {
      paramContext = (SparseArrayCompat)this.j.get(paramContext);
      if (paramContext != null) {
        return (ColorStateList)paramContext.get(paramInt);
      }
      return null;
    }
    return null;
  }
  
  private ColorStateList e(Context paramContext, int paramInt)
  {
    int i3 = ao.getThemeAttrColor(paramContext, R.attr.colorControlHighlight);
    int i1 = ao.getDisabledThemeAttrColor(paramContext, R.attr.colorButtonNormal);
    paramContext = ao.a;
    int[] arrayOfInt1 = ao.d;
    int i2 = ColorUtils.compositeColors(i3, paramInt);
    int[] arrayOfInt2 = ao.b;
    i3 = ColorUtils.compositeColors(i3, paramInt);
    return new ColorStateList(new int[][] { paramContext, arrayOfInt1, arrayOfInt2, ao.h }, new int[] { i1, i2, i3, paramInt });
  }
  
  private void e(Context paramContext)
  {
    if (this.p) {}
    do
    {
      return;
      this.p = true;
      paramContext = getDrawable(paramContext, R.drawable.abc_vector_test);
    } while ((paramContext != null) && (a(paramContext)));
    this.p = false;
    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
  }
  
  public static g get()
  {
    if (b == null)
    {
      b = new g();
      a(b);
    }
    return b;
  }
  
  public static PorterDuffColorFilter getPorterDuffColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    PorterDuffColorFilter localPorterDuffColorFilter2 = c.a(paramInt, paramMode);
    PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
    if (localPorterDuffColorFilter2 == null)
    {
      localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
      c.a(paramInt, paramMode, localPorterDuffColorFilter1);
    }
    return localPorterDuffColorFilter1;
  }
  
  ColorStateList a(Context paramContext, int paramInt)
  {
    ColorStateList localColorStateList1 = d(paramContext, paramInt);
    ColorStateList localColorStateList2 = localColorStateList1;
    if (localColorStateList1 == null)
    {
      if (paramInt != R.drawable.abc_edit_text_material) {
        break label49;
      }
      localColorStateList1 = b.getColorStateList(paramContext, R.color.abc_tint_edittext);
    }
    for (;;)
    {
      localColorStateList2 = localColorStateList1;
      if (localColorStateList1 != null)
      {
        a(paramContext, paramInt, localColorStateList1);
        localColorStateList2 = localColorStateList1;
      }
      return localColorStateList2;
      label49:
      if (paramInt == R.drawable.abc_switch_track_mtrl_alpha) {
        localColorStateList1 = b.getColorStateList(paramContext, R.color.abc_tint_switch_track);
      } else if (paramInt == R.drawable.abc_switch_thumb_material) {
        localColorStateList1 = d(paramContext);
      } else if (paramInt == R.drawable.abc_btn_default_mtrl_shape) {
        localColorStateList1 = a(paramContext);
      } else if (paramInt == R.drawable.abc_btn_borderless_material) {
        localColorStateList1 = b(paramContext);
      } else if (paramInt == R.drawable.abc_btn_colored_material) {
        localColorStateList1 = c(paramContext);
      } else if ((paramInt == R.drawable.abc_spinner_mtrl_am_alpha) || (paramInt == R.drawable.abc_spinner_textfield_background_material)) {
        localColorStateList1 = b.getColorStateList(paramContext, R.color.abc_tint_spinner);
      } else if (a(e, paramInt)) {
        localColorStateList1 = ao.getThemeAttrColorStateList(paramContext, R.attr.colorControlNormal);
      } else if (a(h, paramInt)) {
        localColorStateList1 = b.getColorStateList(paramContext, R.color.abc_tint_default);
      } else if (a(i, paramInt)) {
        localColorStateList1 = b.getColorStateList(paramContext, R.color.abc_tint_btn_checkable);
      } else if (paramInt == R.drawable.abc_seekbar_thumb_material) {
        localColorStateList1 = b.getColorStateList(paramContext, R.color.abc_tint_seek_thumb);
      }
    }
  }
  
  Drawable a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    e(paramContext);
    Object localObject2 = c(paramContext, paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = b(paramContext, paramInt);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ContextCompat.getDrawable(paramContext, paramInt);
    }
    localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = a(paramContext, paramInt, paramBoolean, (Drawable)localObject2);
    }
    if (localObject1 != null) {
      w.a((Drawable)localObject1);
    }
    return (Drawable)localObject1;
  }
  
  Drawable a(Context paramContext, ay paramay, int paramInt)
  {
    Drawable localDrawable2 = c(paramContext, paramInt);
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null) {
      localDrawable1 = paramay.a(paramInt);
    }
    if (localDrawable1 != null) {
      return a(paramContext, paramInt, false, localDrawable1);
    }
    return null;
  }
  
  public Drawable getDrawable(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, false);
  }
  
  public void onConfigurationChanged(Context paramContext)
  {
    synchronized (this.m)
    {
      paramContext = (LongSparseArray)this.n.get(paramContext);
      if (paramContext != null) {
        paramContext.clear();
      }
      return;
    }
  }
  
  private static class a
    implements g.c
  {
    public Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = c.createFromXmlInner(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", paramContext);
      }
      return null;
    }
  }
  
  private static class b
    extends LruCache<Integer, PorterDuffColorFilter>
  {
    public b(int paramInt)
    {
      super();
    }
    
    private static int b(int paramInt, PorterDuff.Mode paramMode)
    {
      return (paramInt + 31) * 31 + paramMode.hashCode();
    }
    
    PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode)
    {
      return (PorterDuffColorFilter)get(Integer.valueOf(b(paramInt, paramMode)));
    }
    
    PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode, PorterDuffColorFilter paramPorterDuffColorFilter)
    {
      return (PorterDuffColorFilter)put(Integer.valueOf(b(paramInt, paramMode)), paramPorterDuffColorFilter);
    }
  }
  
  private static abstract interface c
  {
    public abstract Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme);
  }
  
  private static class d
    implements g.c
  {
    public Drawable createFromXmlInner(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = i.createFromXmlInner(paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("VdcInflateDelegate", "Exception while inflating <vector>", paramContext);
      }
      return null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */