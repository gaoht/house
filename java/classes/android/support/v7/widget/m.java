package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.styleable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

class m
{
  private static final RectF a = new RectF();
  private static Hashtable<String, Method> b = new Hashtable();
  private int c = 0;
  private boolean d = false;
  private float e = -1.0F;
  private float f = -1.0F;
  private float g = -1.0F;
  private int[] h = new int[0];
  private boolean i = false;
  private TextPaint j;
  private final TextView k;
  private final Context l;
  
  m(TextView paramTextView)
  {
    this.k = paramTextView;
    this.l = this.k.getContext();
  }
  
  private int a(RectF paramRectF)
  {
    int i1 = this.h.length;
    if (i1 == 0) {
      throw new IllegalStateException("No available text sizes to choose from.");
    }
    int n = 0;
    int m = 1;
    i1 -= 1;
    while (m <= i1)
    {
      int i2 = (m + i1) / 2;
      if (a(this.h[i2], paramRectF))
      {
        n = m;
        m = i2 + 1;
      }
      else
      {
        i1 = i2 - 1;
        n = i1;
      }
    }
    return this.h[n];
  }
  
  @TargetApi(14)
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt)
  {
    float f1;
    float f2;
    if (Build.VERSION.SDK_INT >= 16)
    {
      f1 = this.k.getLineSpacingMultiplier();
      f2 = this.k.getLineSpacingExtra();
    }
    for (boolean bool = this.k.getIncludeFontPadding();; bool = ((Boolean)a(this.k, "getIncludeFontPadding", Boolean.valueOf(true))).booleanValue())
    {
      return new StaticLayout(paramCharSequence, this.j, paramInt, paramAlignment, f1, f2, bool);
      f1 = ((Float)a(this.k, "getLineSpacingMultiplier", Float.valueOf(1.0F))).floatValue();
      f2 = ((Float)a(this.k, "getLineSpacingExtra", Float.valueOf(0.0F))).floatValue();
    }
  }
  
  @TargetApi(23)
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    TextDirectionHeuristic localTextDirectionHeuristic = (TextDirectionHeuristic)a(this.k, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.j, paramInt1).setAlignment(paramAlignment).setLineSpacing(this.k.getLineSpacingExtra(), this.k.getLineSpacingMultiplier()).setIncludePad(this.k.getIncludeFontPadding()).setBreakStrategy(this.k.getBreakStrategy()).setHyphenationFrequency(this.k.getHyphenationFrequency());
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = Integer.MAX_VALUE;
    }
    return paramCharSequence.setMaxLines(paramInt1).setTextDirection(localTextDirectionHeuristic).build();
  }
  
  private <T> T a(Object paramObject, String paramString, T paramT)
  {
    m = 0;
    try
    {
      paramObject = a(paramString).invoke(paramObject, new Object[0]);
      paramT = (T)paramObject;
      if (paramObject != null) {}
    }
    catch (Exception paramObject)
    {
      do
      {
        m = 1;
        Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + paramString + "() method", (Throwable)paramObject);
      } while (0 == 0);
      return null;
    }
    finally
    {
      if ((0 != 0) || (m == 0)) {
        break label76;
      }
    }
    return paramT;
  }
  
  private Method a(String paramString)
  {
    try
    {
      Method localMethod2 = (Method)b.get(paramString);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localMethod1 = localMethod2;
        if (localMethod2 != null)
        {
          localMethod2.setAccessible(true);
          b.put(paramString, localMethod2);
          localMethod1 = localMethod2;
        }
      }
      return localMethod1;
    }
    catch (Exception localException)
    {
      Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + paramString + "() method", localException);
    }
    return null;
  }
  
  private void a(float paramFloat)
  {
    if (paramFloat != this.k.getPaint().getTextSize())
    {
      this.k.getPaint().setTextSize(paramFloat);
      if (Build.VERSION.SDK_INT < 18) {
        break label125;
      }
    }
    label125:
    for (boolean bool = this.k.isInLayout();; bool = false)
    {
      if (this.k.getLayout() != null) {
        this.d = false;
      }
      try
      {
        Method localMethod = a("nullLayouts");
        if (localMethod != null) {
          localMethod.invoke(this.k, new Object[0]);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", localException);
          continue;
          this.k.forceLayout();
        }
      }
      if (!bool)
      {
        this.k.requestLayout();
        this.k.invalidate();
        return;
      }
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
    throws IllegalArgumentException
  {
    if (paramFloat1 <= 0.0F) {
      throw new IllegalArgumentException("Minimum auto-size text size (" + paramFloat1 + "px) is less or equal to (0px)");
    }
    if (paramFloat2 <= paramFloat1) {
      throw new IllegalArgumentException("Maximum auto-size text size (" + paramFloat2 + "px) is less or equal to minimum auto-size " + "text size (" + paramFloat1 + "px)");
    }
    if (paramFloat3 <= 0.0F) {
      throw new IllegalArgumentException("The auto-size step granularity (" + paramFloat3 + "px) is less or equal to (0px)");
    }
    this.c = 1;
    this.f = paramFloat1;
    this.g = paramFloat2;
    this.e = paramFloat3;
    this.i = false;
  }
  
  private void a(TypedArray paramTypedArray)
  {
    int n = paramTypedArray.length();
    int[] arrayOfInt = new int[n];
    if (n > 0)
    {
      int m = 0;
      while (m < n)
      {
        arrayOfInt[m] = paramTypedArray.getDimensionPixelSize(m, -1);
        m += 1;
      }
      this.h = a(arrayOfInt);
      h();
    }
  }
  
  private boolean a(int paramInt, RectF paramRectF)
  {
    CharSequence localCharSequence = this.k.getText();
    int m;
    if (Build.VERSION.SDK_INT >= 16)
    {
      m = this.k.getMaxLines();
      if (this.j != null) {
        break label154;
      }
      this.j = new TextPaint();
      label43:
      this.j.set(this.k.getPaint());
      this.j.setTextSize(paramInt);
      localObject = (Layout.Alignment)a(this.k, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
      if (Build.VERSION.SDK_INT < 23) {
        break label164;
      }
    }
    label154:
    label164:
    for (Object localObject = a(localCharSequence, (Layout.Alignment)localObject, Math.round(paramRectF.right), m);; localObject = a(localCharSequence, (Layout.Alignment)localObject, Math.round(paramRectF.right)))
    {
      if ((m == -1) || ((((StaticLayout)localObject).getLineCount() <= m) && (((StaticLayout)localObject).getLineEnd(((StaticLayout)localObject).getLineCount() - 1) == localCharSequence.length()))) {
        break label184;
      }
      return false;
      m = -1;
      break;
      this.j.reset();
      break label43;
    }
    label184:
    return ((StaticLayout)localObject).getHeight() <= paramRectF.bottom;
  }
  
  private int[] a(int[] paramArrayOfInt)
  {
    int n = paramArrayOfInt.length;
    if (n == 0) {}
    ArrayList localArrayList;
    do
    {
      return paramArrayOfInt;
      Arrays.sort(paramArrayOfInt);
      localArrayList = new ArrayList();
      m = 0;
      while (m < n)
      {
        int i1 = paramArrayOfInt[m];
        if ((i1 > 0) && (Collections.binarySearch(localArrayList, Integer.valueOf(i1)) < 0)) {
          localArrayList.add(Integer.valueOf(i1));
        }
        m += 1;
      }
    } while (n == localArrayList.size());
    n = localArrayList.size();
    int[] arrayOfInt = new int[n];
    int m = 0;
    for (;;)
    {
      paramArrayOfInt = arrayOfInt;
      if (m >= n) {
        break;
      }
      arrayOfInt[m] = ((Integer)localArrayList.get(m)).intValue();
      m += 1;
    }
  }
  
  private boolean h()
  {
    int m = this.h.length;
    if (m > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.i = bool;
      if (this.i)
      {
        this.c = 1;
        this.f = this.h[0];
        this.g = this.h[(m - 1)];
        this.e = -1.0F;
      }
      return this.i;
    }
  }
  
  private boolean i()
  {
    if ((k()) && (this.c == 1)) {
      if ((!this.i) || (this.h.length == 0))
      {
        float f1 = Math.round(this.f);
        int m = 1;
        while (Math.round(this.e + f1) <= Math.round(this.g))
        {
          m += 1;
          f1 += this.e;
        }
        int[] arrayOfInt = new int[m];
        f1 = this.f;
        int n = 0;
        while (n < m)
        {
          arrayOfInt[n] = Math.round(f1);
          f1 += this.e;
          n += 1;
        }
        this.h = a(arrayOfInt);
      }
    }
    for (this.d = true;; this.d = false) {
      return this.d;
    }
  }
  
  private void j()
  {
    this.c = 0;
    this.f = -1.0F;
    this.g = -1.0F;
    this.e = -1.0F;
    this.h = new int[0];
    this.d = false;
  }
  
  private boolean k()
  {
    return !(this.k instanceof AppCompatEditText);
  }
  
  int a()
  {
    return this.c;
  }
  
  void a(int paramInt)
  {
    if (k()) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("Unknown auto-size text type: " + paramInt);
      case 0: 
        j();
      }
    }
    do
    {
      return;
      DisplayMetrics localDisplayMetrics = this.l.getResources().getDisplayMetrics();
      a(TypedValue.applyDimension(2, 12.0F, localDisplayMetrics), TypedValue.applyDimension(2, 112.0F, localDisplayMetrics), 1.0F);
    } while (!i());
    f();
  }
  
  void a(int paramInt, float paramFloat)
  {
    if (this.l == null) {}
    for (Resources localResources = Resources.getSystem();; localResources = this.l.getResources())
    {
      a(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
      return;
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (k())
    {
      DisplayMetrics localDisplayMetrics = this.l.getResources().getDisplayMetrics();
      a(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (i()) {
        f();
      }
    }
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.l.obtainStyledAttributes(paramAttributeSet, R.styleable.AppCompatTextView, paramInt, 0);
    if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
      this.c = paramAttributeSet.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
    }
    if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity)) {}
    for (float f1 = paramAttributeSet.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0F);; f1 = -1.0F)
    {
      if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize)) {}
      for (float f2 = paramAttributeSet.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0F);; f2 = -1.0F)
      {
        if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize)) {}
        for (float f3 = paramAttributeSet.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0F);; f3 = -1.0F)
        {
          if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes))
          {
            paramInt = paramAttributeSet.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0);
            if (paramInt > 0)
            {
              TypedArray localTypedArray = paramAttributeSet.getResources().obtainTypedArray(paramInt);
              a(localTypedArray);
              localTypedArray.recycle();
            }
          }
          paramAttributeSet.recycle();
          if (k())
          {
            if (this.c == 1)
            {
              if (!this.i)
              {
                paramAttributeSet = this.l.getResources().getDisplayMetrics();
                float f4 = f2;
                if (f2 == -1.0F) {
                  f4 = TypedValue.applyDimension(2, 12.0F, paramAttributeSet);
                }
                f2 = f3;
                if (f3 == -1.0F) {
                  f2 = TypedValue.applyDimension(2, 112.0F, paramAttributeSet);
                }
                f3 = f1;
                if (f1 == -1.0F) {
                  f3 = 1.0F;
                }
                a(f4, f2, f3);
              }
              i();
            }
            return;
          }
          this.c = 0;
          return;
        }
      }
    }
  }
  
  void a(int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    int m = 0;
    if (k())
    {
      int n = paramArrayOfInt.length;
      if (n > 0)
      {
        int[] arrayOfInt2 = new int[n];
        int[] arrayOfInt1;
        if (paramInt == 0)
        {
          arrayOfInt1 = Arrays.copyOf(paramArrayOfInt, n);
          this.h = a(arrayOfInt1);
          if (!h()) {
            throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(paramArrayOfInt));
          }
        }
        else
        {
          DisplayMetrics localDisplayMetrics = this.l.getResources().getDisplayMetrics();
          for (;;)
          {
            arrayOfInt1 = arrayOfInt2;
            if (m >= n) {
              break;
            }
            arrayOfInt2[m] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[m], localDisplayMetrics));
            m += 1;
          }
        }
      }
      else
      {
        this.i = false;
      }
      if (i()) {
        f();
      }
    }
  }
  
  int b()
  {
    return Math.round(this.e);
  }
  
  int c()
  {
    return Math.round(this.f);
  }
  
  int d()
  {
    return Math.round(this.g);
  }
  
  int[] e()
  {
    return this.h;
  }
  
  void f()
  {
    if (!g()) {}
    do
    {
      return;
      if (!this.d) {
        break;
      }
    } while ((this.k.getMeasuredHeight() <= 0) || (this.k.getMeasuredWidth() <= 0));
    int m;
    if (((Boolean)a(this.k, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue()) {
      m = 1048576;
    }
    for (;;)
    {
      int n = this.k.getHeight() - this.k.getCompoundPaddingBottom() - this.k.getCompoundPaddingTop();
      if ((m <= 0) || (n <= 0)) {
        break;
      }
      synchronized (a)
      {
        a.setEmpty();
        a.right = m;
        a.bottom = n;
        float f1 = a(a);
        if (f1 != this.k.getTextSize()) {
          a(0, f1);
        }
        this.d = true;
        return;
        m = this.k.getMeasuredWidth() - this.k.getTotalPaddingLeft() - this.k.getTotalPaddingRight();
      }
    }
  }
  
  boolean g()
  {
    return (k()) && (this.c != 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */