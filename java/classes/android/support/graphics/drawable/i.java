package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.PathParser.PathDataNode;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i
  extends h
{
  static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
  private f b;
  private PorterDuffColorFilter d;
  private ColorFilter e;
  private boolean f;
  private boolean g = true;
  private Drawable.ConstantState h;
  private final float[] i = new float[9];
  private final Matrix j = new Matrix();
  private final Rect k = new Rect();
  
  i()
  {
    this.b = new f();
  }
  
  i(f paramf)
  {
    this.b = paramf;
    this.d = a(this.d, paramf.c, paramf.d);
  }
  
  static int a(int paramInt, float paramFloat)
  {
    return (int)(Color.alpha(paramInt) * paramFloat) << 24 | 0xFFFFFF & paramInt;
  }
  
  private static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    }
    do
    {
      return paramMode;
      return PorterDuff.Mode.SRC_OVER;
      return PorterDuff.Mode.SRC_IN;
      return PorterDuff.Mode.SRC_ATOP;
      return PorterDuff.Mode.MULTIPLY;
      return PorterDuff.Mode.SCREEN;
    } while (Build.VERSION.SDK_INT < 11);
    return PorterDuff.Mode.ADD;
  }
  
  private void a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    f localf = this.b;
    e locale = localf.b;
    Stack localStack = new Stack();
    localStack.push(locale.a);
    int i1 = paramXmlPullParser.getEventType();
    int i2 = paramXmlPullParser.getDepth();
    int m = 1;
    if ((i1 != 1) && ((paramXmlPullParser.getDepth() >= i2 + 1) || (i1 != 3)))
    {
      Object localObject;
      c localc;
      int n;
      if (i1 == 2)
      {
        localObject = paramXmlPullParser.getName();
        localc = (c)localStack.peek();
        if ("path".equals(localObject))
        {
          localObject = new b();
          ((b)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localc.a.add(localObject);
          if (((b)localObject).getPathName() != null) {
            locale.h.put(((b)localObject).getPathName(), localObject);
          }
          m = 0;
          n = localf.a;
          localf.a = (((b)localObject).o | n);
          label188:
          n = m;
        }
      }
      for (;;)
      {
        i1 = paramXmlPullParser.next();
        m = n;
        break;
        if ("clip-path".equals(localObject))
        {
          localObject = new a();
          ((a)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localc.a.add(localObject);
          if (((a)localObject).getPathName() != null) {
            locale.h.put(((a)localObject).getPathName(), localObject);
          }
          localf.a |= ((a)localObject).o;
          break label188;
        }
        if ("group".equals(localObject))
        {
          localObject = new c();
          ((c)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localc.a.add(localObject);
          localStack.push(localObject);
          if (((c)localObject).getGroupName() != null) {
            locale.h.put(((c)localObject).getGroupName(), localObject);
          }
          localf.a |= ((c)localObject).c;
        }
        break label188;
        n = m;
        if (i1 == 3)
        {
          n = m;
          if ("group".equals(paramXmlPullParser.getName()))
          {
            localStack.pop();
            n = m;
          }
        }
      }
    }
    if (m != 0)
    {
      paramResources = new StringBuffer();
      if (paramResources.length() > 0) {
        paramResources.append(" or ");
      }
      paramResources.append("path");
      throw new XmlPullParserException("no " + paramResources + " defined");
    }
  }
  
  private void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException
  {
    f localf = this.b;
    e locale = localf.b;
    localf.d = a(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
    ColorStateList localColorStateList = paramTypedArray.getColorStateList(1);
    if (localColorStateList != null) {
      localf.c = localColorStateList;
    }
    localf.e = TypedArrayUtils.getNamedBoolean(paramTypedArray, paramXmlPullParser, "autoMirrored", 5, localf.e);
    locale.d = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportWidth", 7, locale.d);
    locale.e = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportHeight", 8, locale.e);
    if (locale.d <= 0.0F) {
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }
    if (locale.e <= 0.0F) {
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }
    locale.b = paramTypedArray.getDimension(3, locale.b);
    locale.c = paramTypedArray.getDimension(2, locale.c);
    if (locale.b <= 0.0F) {
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
    }
    if (locale.c <= 0.0F) {
      throw new XmlPullParserException(paramTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
    }
    locale.setAlpha(TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "alpha", 4, locale.getAlpha()));
    paramTypedArray = paramTypedArray.getString(0);
    if (paramTypedArray != null)
    {
      locale.g = paramTypedArray;
      locale.h.put(paramTypedArray, locale);
    }
  }
  
  private boolean a()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return (isAutoMirrored()) && (DrawableCompat.getLayoutDirection(this) == 1);
    }
    return false;
  }
  
  public static i create(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new i();
      ((i)localObject).c = ResourcesCompat.getDrawable(paramResources, paramInt, paramTheme);
      ((i)localObject).h = new g(((i)localObject).c.getConstantState());
      return (i)localObject;
    }
    try
    {
      localObject = paramResources.getXml(paramInt);
      localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt != 2) {
        throw new XmlPullParserException("No start tag found");
      }
    }
    catch (XmlPullParserException paramResources)
    {
      AttributeSet localAttributeSet;
      Log.e("VectorDrawableCompat", "parser error", paramResources);
      return null;
      paramResources = createFromXmlInner(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
      return paramResources;
    }
    catch (IOException paramResources)
    {
      for (;;)
      {
        Log.e("VectorDrawableCompat", "parser error", paramResources);
      }
    }
  }
  
  public static i createFromXmlInner(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    i locali = new i();
    locali.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return locali;
  }
  
  PorterDuffColorFilter a(PorterDuffColorFilter paramPorterDuffColorFilter, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  Object a(String paramString)
  {
    return this.b.b.h.get(paramString);
  }
  
  void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean canApplyTheme()
  {
    if (this.c != null) {
      DrawableCompat.canApplyTheme(this.c);
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.c != null) {
      this.c.draw(paramCanvas);
    }
    Object localObject;
    int m;
    int n;
    do
    {
      do
      {
        return;
        copyBounds(this.k);
      } while ((this.k.width() <= 0) || (this.k.height() <= 0));
      if (this.e != null) {
        break;
      }
      localObject = this.d;
      paramCanvas.getMatrix(this.j);
      this.j.getValues(this.i);
      float f2 = Math.abs(this.i[0]);
      float f1 = Math.abs(this.i[4]);
      float f4 = Math.abs(this.i[1]);
      float f3 = Math.abs(this.i[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      m = (int)(f2 * this.k.width());
      n = (int)(f1 * this.k.height());
      m = Math.min(2048, m);
      n = Math.min(2048, n);
    } while ((m <= 0) || (n <= 0));
    int i1 = paramCanvas.save();
    paramCanvas.translate(this.k.left, this.k.top);
    if (a())
    {
      paramCanvas.translate(this.k.width(), 0.0F);
      paramCanvas.scale(-1.0F, 1.0F);
    }
    this.k.offsetTo(0, 0);
    this.b.createCachedBitmapIfNeeded(m, n);
    if (!this.g) {
      this.b.updateCachedBitmap(m, n);
    }
    for (;;)
    {
      this.b.drawCachedBitmapWithRootAlpha(paramCanvas, (ColorFilter)localObject, this.k);
      paramCanvas.restoreToCount(i1);
      return;
      localObject = this.e;
      break;
      if (!this.b.canReuseCache())
      {
        this.b.updateCachedBitmap(m, n);
        this.b.updateCacheStates();
      }
    }
  }
  
  public int getAlpha()
  {
    if (this.c != null) {
      return DrawableCompat.getAlpha(this.c);
    }
    return this.b.b.getRootAlpha();
  }
  
  public int getChangingConfigurations()
  {
    if (this.c != null) {
      return this.c.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.b.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if ((this.c != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new g(this.c.getConstantState());
    }
    this.b.a = getChangingConfigurations();
    return this.b;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.c != null) {
      return this.c.getIntrinsicHeight();
    }
    return (int)this.b.b.c;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.c != null) {
      return this.c.getIntrinsicWidth();
    }
    return (int)this.b.b.b;
  }
  
  public int getOpacity()
  {
    if (this.c != null) {
      return this.c.getOpacity();
    }
    return -3;
  }
  
  public float getPixelSize()
  {
    if ((this.b == null) || (this.b.b == null) || (this.b.b.b == 0.0F) || (this.b.b.c == 0.0F) || (this.b.b.e == 0.0F) || (this.b.b.d == 0.0F)) {
      return 1.0F;
    }
    float f1 = this.b.b.b;
    float f2 = this.b.b.c;
    float f3 = this.b.b.d;
    float f4 = this.b.b.e;
    return Math.min(f3 / f1, f4 / f2);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    if (this.c != null)
    {
      this.c.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    if (this.c != null)
    {
      DrawableCompat.inflate(this.c, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    f localf = this.b;
    localf.b = new e();
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, a.a);
    a(localTypedArray, paramXmlPullParser);
    localTypedArray.recycle();
    localf.a = getChangingConfigurations();
    localf.k = true;
    a(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.d = a(this.d, localf.c, localf.d);
  }
  
  public void invalidateSelf()
  {
    if (this.c != null)
    {
      this.c.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    if (this.c != null) {
      return DrawableCompat.isAutoMirrored(this.c);
    }
    return this.b.e;
  }
  
  public boolean isStateful()
  {
    if (this.c != null) {
      return this.c.isStateful();
    }
    return (super.isStateful()) || ((this.b != null) && (this.b.c != null) && (this.b.c.isStateful()));
  }
  
  public Drawable mutate()
  {
    if (this.c != null) {
      this.c.mutate();
    }
    while ((this.f) || (super.mutate() != this)) {
      return this;
    }
    this.b = new f(this.b);
    this.f = true;
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.c != null) {
      this.c.setBounds(paramRect);
    }
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.c != null) {
      return this.c.setState(paramArrayOfInt);
    }
    paramArrayOfInt = this.b;
    if ((paramArrayOfInt.c != null) && (paramArrayOfInt.d != null))
    {
      this.d = a(this.d, paramArrayOfInt.c, paramArrayOfInt.d);
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (this.c != null)
    {
      this.c.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.c != null) {
      this.c.setAlpha(paramInt);
    }
    while (this.b.b.getRootAlpha() == paramInt) {
      return;
    }
    this.b.b.setRootAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.c != null)
    {
      DrawableCompat.setAutoMirrored(this.c, paramBoolean);
      return;
    }
    this.b.e = paramBoolean;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.c != null)
    {
      this.c.setColorFilter(paramColorFilter);
      return;
    }
    this.e = paramColorFilter;
    invalidateSelf();
  }
  
  public void setTint(int paramInt)
  {
    if (this.c != null)
    {
      DrawableCompat.setTint(this.c, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    if (this.c != null) {
      DrawableCompat.setTintList(this.c, paramColorStateList);
    }
    f localf;
    do
    {
      return;
      localf = this.b;
    } while (localf.c == paramColorStateList);
    localf.c = paramColorStateList;
    this.d = a(this.d, paramColorStateList, localf.d);
    invalidateSelf();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.c != null) {
      DrawableCompat.setTintMode(this.c, paramMode);
    }
    f localf;
    do
    {
      return;
      localf = this.b;
    } while (localf.d == paramMode);
    localf.d = paramMode;
    this.d = a(this.d, localf.c, paramMode);
    invalidateSelf();
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.c != null) {
      return this.c.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    if (this.c != null)
    {
      this.c.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }
  
  private static class a
    extends i.d
  {
    public a() {}
    
    public a(a parama)
    {
      super();
    }
    
    private void a(TypedArray paramTypedArray)
    {
      String str = paramTypedArray.getString(0);
      if (str != null) {
        this.n = str;
      }
      paramTypedArray = paramTypedArray.getString(1);
      if (paramTypedArray != null) {
        this.m = PathParser.createNodesFromPathData(paramTypedArray);
      }
    }
    
    public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData")) {
        return;
      }
      paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, a.d);
      a(paramResources);
      paramResources.recycle();
    }
    
    public boolean isClipPath()
    {
      return true;
    }
  }
  
  private static class b
    extends i.d
  {
    int a = 0;
    float b = 0.0F;
    int c = 0;
    float d = 1.0F;
    int e = 0;
    float f = 1.0F;
    float g = 0.0F;
    float h = 1.0F;
    float i = 0.0F;
    Paint.Cap j = Paint.Cap.BUTT;
    Paint.Join k = Paint.Join.MITER;
    float l = 4.0F;
    private int[] p;
    
    public b() {}
    
    public b(b paramb)
    {
      super();
      this.p = paramb.p;
      this.a = paramb.a;
      this.b = paramb.b;
      this.d = paramb.d;
      this.c = paramb.c;
      this.e = paramb.e;
      this.f = paramb.f;
      this.g = paramb.g;
      this.h = paramb.h;
      this.i = paramb.i;
      this.j = paramb.j;
      this.k = paramb.k;
      this.l = paramb.l;
    }
    
    private Paint.Cap a(int paramInt, Paint.Cap paramCap)
    {
      switch (paramInt)
      {
      default: 
        return paramCap;
      case 0: 
        return Paint.Cap.BUTT;
      case 1: 
        return Paint.Cap.ROUND;
      }
      return Paint.Cap.SQUARE;
    }
    
    private Paint.Join a(int paramInt, Paint.Join paramJoin)
    {
      switch (paramInt)
      {
      default: 
        return paramJoin;
      case 0: 
        return Paint.Join.MITER;
      case 1: 
        return Paint.Join.ROUND;
      }
      return Paint.Join.BEVEL;
    }
    
    private void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      this.p = null;
      if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData")) {
        return;
      }
      String str = paramTypedArray.getString(0);
      if (str != null) {
        this.n = str;
      }
      str = paramTypedArray.getString(2);
      if (str != null) {
        this.m = PathParser.createNodesFromPathData(str);
      }
      this.c = TypedArrayUtils.getNamedColor(paramTypedArray, paramXmlPullParser, "fillColor", 1, this.c);
      this.f = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.f);
      this.j = a(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1), this.j);
      this.k = a(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1), this.k);
      this.l = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.l);
      this.a = TypedArrayUtils.getNamedColor(paramTypedArray, paramXmlPullParser, "strokeColor", 3, this.a);
      this.d = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.d);
      this.b = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.b);
      this.h = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.h);
      this.i = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.i);
      this.g = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.g);
      this.e = TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "fillType", 13, this.e);
    }
    
    public void applyTheme(Resources.Theme paramTheme)
    {
      if (this.p == null) {}
    }
    
    public boolean canApplyTheme()
    {
      return this.p != null;
    }
    
    float getFillAlpha()
    {
      return this.f;
    }
    
    int getFillColor()
    {
      return this.c;
    }
    
    float getStrokeAlpha()
    {
      return this.d;
    }
    
    int getStrokeColor()
    {
      return this.a;
    }
    
    float getStrokeWidth()
    {
      return this.b;
    }
    
    float getTrimPathEnd()
    {
      return this.h;
    }
    
    float getTrimPathOffset()
    {
      return this.i;
    }
    
    float getTrimPathStart()
    {
      return this.g;
    }
    
    public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, a.c);
      a(paramResources, paramXmlPullParser);
      paramResources.recycle();
    }
    
    void setFillAlpha(float paramFloat)
    {
      this.f = paramFloat;
    }
    
    void setFillColor(int paramInt)
    {
      this.c = paramInt;
    }
    
    void setStrokeAlpha(float paramFloat)
    {
      this.d = paramFloat;
    }
    
    void setStrokeColor(int paramInt)
    {
      this.a = paramInt;
    }
    
    void setStrokeWidth(float paramFloat)
    {
      this.b = paramFloat;
    }
    
    void setTrimPathEnd(float paramFloat)
    {
      this.h = paramFloat;
    }
    
    void setTrimPathOffset(float paramFloat)
    {
      this.i = paramFloat;
    }
    
    void setTrimPathStart(float paramFloat)
    {
      this.g = paramFloat;
    }
  }
  
  private static class c
  {
    final ArrayList<Object> a = new ArrayList();
    float b = 0.0F;
    int c;
    private final Matrix d = new Matrix();
    private float e = 0.0F;
    private float f = 0.0F;
    private float g = 1.0F;
    private float h = 1.0F;
    private float i = 0.0F;
    private float j = 0.0F;
    private final Matrix k = new Matrix();
    private int[] l;
    private String m = null;
    
    public c() {}
    
    public c(c paramc, ArrayMap<String, Object> paramArrayMap)
    {
      this.b = paramc.b;
      this.e = paramc.e;
      this.f = paramc.f;
      this.g = paramc.g;
      this.h = paramc.h;
      this.i = paramc.i;
      this.j = paramc.j;
      this.l = paramc.l;
      this.m = paramc.m;
      this.c = paramc.c;
      if (this.m != null) {
        paramArrayMap.put(this.m, this);
      }
      this.k.set(paramc.k);
      ArrayList localArrayList = paramc.a;
      int n = 0;
      while (n < localArrayList.size())
      {
        paramc = localArrayList.get(n);
        if ((paramc instanceof c))
        {
          paramc = (c)paramc;
          this.a.add(new c(paramc, paramArrayMap));
          n += 1;
        }
        else
        {
          if ((paramc instanceof i.b)) {}
          for (paramc = new i.b((i.b)paramc);; paramc = new i.a((i.a)paramc))
          {
            this.a.add(paramc);
            if (paramc.n == null) {
              break;
            }
            paramArrayMap.put(paramc.n, paramc);
            break;
            if (!(paramc instanceof i.a)) {
              break label315;
            }
          }
          label315:
          throw new IllegalStateException("Unknown object in the tree!");
        }
      }
    }
    
    private void a()
    {
      this.k.reset();
      this.k.postTranslate(-this.e, -this.f);
      this.k.postScale(this.g, this.h);
      this.k.postRotate(this.b, 0.0F, 0.0F);
      this.k.postTranslate(this.i + this.e, this.j + this.f);
    }
    
    private void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      this.l = null;
      this.b = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "rotation", 5, this.b);
      this.e = paramTypedArray.getFloat(1, this.e);
      this.f = paramTypedArray.getFloat(2, this.f);
      this.g = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "scaleX", 3, this.g);
      this.h = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "scaleY", 4, this.h);
      this.i = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "translateX", 6, this.i);
      this.j = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "translateY", 7, this.j);
      paramTypedArray = paramTypedArray.getString(0);
      if (paramTypedArray != null) {
        this.m = paramTypedArray;
      }
      a();
    }
    
    public String getGroupName()
    {
      return this.m;
    }
    
    public Matrix getLocalMatrix()
    {
      return this.k;
    }
    
    public float getPivotX()
    {
      return this.e;
    }
    
    public float getPivotY()
    {
      return this.f;
    }
    
    public float getRotation()
    {
      return this.b;
    }
    
    public float getScaleX()
    {
      return this.g;
    }
    
    public float getScaleY()
    {
      return this.h;
    }
    
    public float getTranslateX()
    {
      return this.i;
    }
    
    public float getTranslateY()
    {
      return this.j;
    }
    
    public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, a.b);
      a(paramResources, paramXmlPullParser);
      paramResources.recycle();
    }
    
    public void setPivotX(float paramFloat)
    {
      if (paramFloat != this.e)
      {
        this.e = paramFloat;
        a();
      }
    }
    
    public void setPivotY(float paramFloat)
    {
      if (paramFloat != this.f)
      {
        this.f = paramFloat;
        a();
      }
    }
    
    public void setRotation(float paramFloat)
    {
      if (paramFloat != this.b)
      {
        this.b = paramFloat;
        a();
      }
    }
    
    public void setScaleX(float paramFloat)
    {
      if (paramFloat != this.g)
      {
        this.g = paramFloat;
        a();
      }
    }
    
    public void setScaleY(float paramFloat)
    {
      if (paramFloat != this.h)
      {
        this.h = paramFloat;
        a();
      }
    }
    
    public void setTranslateX(float paramFloat)
    {
      if (paramFloat != this.i)
      {
        this.i = paramFloat;
        a();
      }
    }
    
    public void setTranslateY(float paramFloat)
    {
      if (paramFloat != this.j)
      {
        this.j = paramFloat;
        a();
      }
    }
  }
  
  private static class d
  {
    protected PathParser.PathDataNode[] m = null;
    String n;
    int o;
    
    public d() {}
    
    public d(d paramd)
    {
      this.n = paramd.n;
      this.o = paramd.o;
      this.m = PathParser.deepCopyNodes(paramd.m);
    }
    
    public void applyTheme(Resources.Theme paramTheme) {}
    
    public boolean canApplyTheme()
    {
      return false;
    }
    
    public PathParser.PathDataNode[] getPathData()
    {
      return this.m;
    }
    
    public String getPathName()
    {
      return this.n;
    }
    
    public boolean isClipPath()
    {
      return false;
    }
    
    public String nodesToString(PathParser.PathDataNode[] paramArrayOfPathDataNode)
    {
      String str = " ";
      int i = 0;
      while (i < paramArrayOfPathDataNode.length)
      {
        str = str + paramArrayOfPathDataNode[i].mType + ":";
        float[] arrayOfFloat = paramArrayOfPathDataNode[i].mParams;
        int j = 0;
        while (j < arrayOfFloat.length)
        {
          str = str + arrayOfFloat[j] + ",";
          j += 1;
        }
        i += 1;
      }
      return str;
    }
    
    public void printVPath(int paramInt)
    {
      String str = "";
      int i = 0;
      while (i < paramInt)
      {
        str = str + "    ";
        i += 1;
      }
      Log.v("VectorDrawableCompat", str + "current path is :" + this.n + " pathData is " + nodesToString(this.m));
    }
    
    public void setPathData(PathParser.PathDataNode[] paramArrayOfPathDataNode)
    {
      if (!PathParser.canMorph(this.m, paramArrayOfPathDataNode))
      {
        this.m = PathParser.deepCopyNodes(paramArrayOfPathDataNode);
        return;
      }
      PathParser.updateNodes(this.m, paramArrayOfPathDataNode);
    }
    
    public void toPath(Path paramPath)
    {
      paramPath.reset();
      if (this.m != null) {
        PathParser.PathDataNode.nodesToPath(this.m, paramPath);
      }
    }
  }
  
  private static class e
  {
    private static final Matrix k = new Matrix();
    final i.c a;
    float b = 0.0F;
    float c = 0.0F;
    float d = 0.0F;
    float e = 0.0F;
    int f = 255;
    String g = null;
    final ArrayMap<String, Object> h = new ArrayMap();
    private final Path i;
    private final Path j;
    private final Matrix l = new Matrix();
    private Paint m;
    private Paint n;
    private PathMeasure o;
    private int p;
    
    public e()
    {
      this.a = new i.c();
      this.i = new Path();
      this.j = new Path();
    }
    
    public e(e parame)
    {
      this.a = new i.c(parame.a, this.h);
      this.i = new Path(parame.i);
      this.j = new Path(parame.j);
      this.b = parame.b;
      this.c = parame.c;
      this.d = parame.d;
      this.e = parame.e;
      this.p = parame.p;
      this.f = parame.f;
      this.g = parame.g;
      if (parame.g != null) {
        this.h.put(parame.g, this);
      }
    }
    
    private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return paramFloat1 * paramFloat4 - paramFloat2 * paramFloat3;
    }
    
    private float a(Matrix paramMatrix)
    {
      float f1 = 0.0F;
      float[] arrayOfFloat = new float[4];
      float[] tmp9_7 = arrayOfFloat;
      tmp9_7[0] = 0.0F;
      float[] tmp13_9 = tmp9_7;
      tmp13_9[1] = 1.0F;
      float[] tmp17_13 = tmp13_9;
      tmp17_13[2] = 1.0F;
      float[] tmp21_17 = tmp17_13;
      tmp21_17[3] = 0.0F;
      tmp21_17;
      paramMatrix.mapVectors(arrayOfFloat);
      float f3 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
      float f4 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
      float f2 = a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
      f3 = Math.max(f3, f4);
      if (f3 > 0.0F) {
        f1 = Math.abs(f2) / f3;
      }
      return f1;
    }
    
    private void a(i.c paramc, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      i.c.a(paramc).set(paramMatrix);
      i.c.a(paramc).preConcat(i.c.b(paramc));
      paramCanvas.save();
      int i1 = 0;
      if (i1 < paramc.a.size())
      {
        paramMatrix = paramc.a.get(i1);
        if ((paramMatrix instanceof i.c)) {
          a((i.c)paramMatrix, i.c.a(paramc), paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ((paramMatrix instanceof i.d)) {
            a(paramc, (i.d)paramMatrix, paramCanvas, paramInt1, paramInt2, paramColorFilter);
          }
        }
      }
      paramCanvas.restore();
    }
    
    private void a(i.c paramc, i.d paramd, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      float f2 = paramInt1 / this.d;
      float f3 = paramInt2 / this.e;
      float f1 = Math.min(f2, f3);
      paramc = i.c.a(paramc);
      this.l.set(paramc);
      this.l.postScale(f2, f3);
      f2 = a(paramc);
      if (f2 == 0.0F) {
        return;
      }
      paramd.toPath(this.i);
      paramc = this.i;
      this.j.reset();
      if (paramd.isClipPath())
      {
        this.j.addPath(paramc, this.l);
        paramCanvas.clipPath(this.j);
        return;
      }
      paramd = (i.b)paramd;
      float f6;
      float f4;
      label267:
      Paint localPaint;
      Path localPath;
      if ((paramd.g != 0.0F) || (paramd.h != 1.0F))
      {
        f6 = paramd.g;
        float f7 = paramd.i;
        f4 = paramd.h;
        float f5 = paramd.i;
        if (this.o == null) {
          this.o = new PathMeasure();
        }
        this.o.setPath(this.i, false);
        f3 = this.o.getLength();
        f6 = (f6 + f7) % 1.0F * f3;
        f4 = (f4 + f5) % 1.0F * f3;
        paramc.reset();
        if (f6 > f4)
        {
          this.o.getSegment(f6, f3, paramc, true);
          this.o.getSegment(0.0F, f4, paramc, true);
          paramc.rLineTo(0.0F, 0.0F);
        }
      }
      else
      {
        this.j.addPath(paramc, this.l);
        if (paramd.c != 0)
        {
          if (this.n == null)
          {
            this.n = new Paint();
            this.n.setStyle(Paint.Style.FILL);
            this.n.setAntiAlias(true);
          }
          localPaint = this.n;
          localPaint.setColor(i.a(paramd.c, paramd.f));
          localPaint.setColorFilter(paramColorFilter);
          localPath = this.j;
          if (paramd.e != 0) {
            break label540;
          }
        }
      }
      label540:
      for (paramc = Path.FillType.WINDING;; paramc = Path.FillType.EVEN_ODD)
      {
        localPath.setFillType(paramc);
        paramCanvas.drawPath(this.j, localPaint);
        if (paramd.a == 0) {
          break;
        }
        if (this.m == null)
        {
          this.m = new Paint();
          this.m.setStyle(Paint.Style.STROKE);
          this.m.setAntiAlias(true);
        }
        paramc = this.m;
        if (paramd.k != null) {
          paramc.setStrokeJoin(paramd.k);
        }
        if (paramd.j != null) {
          paramc.setStrokeCap(paramd.j);
        }
        paramc.setStrokeMiter(paramd.l);
        paramc.setColor(i.a(paramd.a, paramd.d));
        paramc.setColorFilter(paramColorFilter);
        paramc.setStrokeWidth(f2 * f1 * paramd.b);
        paramCanvas.drawPath(this.j, paramc);
        return;
        this.o.getSegment(f6, f4, paramc, true);
        break label267;
      }
    }
    
    public void draw(Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      a(this.a, k, paramCanvas, paramInt1, paramInt2, paramColorFilter);
    }
    
    public float getAlpha()
    {
      return getRootAlpha() / 255.0F;
    }
    
    public int getRootAlpha()
    {
      return this.f;
    }
    
    public void setAlpha(float paramFloat)
    {
      setRootAlpha((int)(255.0F * paramFloat));
    }
    
    public void setRootAlpha(int paramInt)
    {
      this.f = paramInt;
    }
  }
  
  private static class f
    extends Drawable.ConstantState
  {
    int a;
    i.e b;
    ColorStateList c = null;
    PorterDuff.Mode d = i.a;
    boolean e;
    Bitmap f;
    ColorStateList g;
    PorterDuff.Mode h;
    int i;
    boolean j;
    boolean k;
    Paint l;
    
    public f()
    {
      this.b = new i.e();
    }
    
    public f(f paramf)
    {
      if (paramf != null)
      {
        this.a = paramf.a;
        this.b = new i.e(paramf.b);
        if (i.e.a(paramf.b) != null) {
          i.e.a(this.b, new Paint(i.e.a(paramf.b)));
        }
        if (i.e.b(paramf.b) != null) {
          i.e.b(this.b, new Paint(i.e.b(paramf.b)));
        }
        this.c = paramf.c;
        this.d = paramf.d;
        this.e = paramf.e;
      }
    }
    
    public boolean canReuseBitmap(int paramInt1, int paramInt2)
    {
      return (paramInt1 == this.f.getWidth()) && (paramInt2 == this.f.getHeight());
    }
    
    public boolean canReuseCache()
    {
      return (!this.k) && (this.g == this.c) && (this.h == this.d) && (this.j == this.e) && (this.i == this.b.getRootAlpha());
    }
    
    public void createCachedBitmapIfNeeded(int paramInt1, int paramInt2)
    {
      if ((this.f == null) || (!canReuseBitmap(paramInt1, paramInt2)))
      {
        this.f = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        this.k = true;
      }
    }
    
    public void drawCachedBitmapWithRootAlpha(Canvas paramCanvas, ColorFilter paramColorFilter, Rect paramRect)
    {
      paramColorFilter = getPaint(paramColorFilter);
      paramCanvas.drawBitmap(this.f, null, paramRect, paramColorFilter);
    }
    
    public int getChangingConfigurations()
    {
      return this.a;
    }
    
    public Paint getPaint(ColorFilter paramColorFilter)
    {
      if ((!hasTranslucentRoot()) && (paramColorFilter == null)) {
        return null;
      }
      if (this.l == null)
      {
        this.l = new Paint();
        this.l.setFilterBitmap(true);
      }
      this.l.setAlpha(this.b.getRootAlpha());
      this.l.setColorFilter(paramColorFilter);
      return this.l;
    }
    
    public boolean hasTranslucentRoot()
    {
      return this.b.getRootAlpha() < 255;
    }
    
    public Drawable newDrawable()
    {
      return new i(this);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new i(this);
    }
    
    public void updateCacheStates()
    {
      this.g = this.c;
      this.h = this.d;
      this.i = this.b.getRootAlpha();
      this.j = this.e;
      this.k = false;
    }
    
    public void updateCachedBitmap(int paramInt1, int paramInt2)
    {
      this.f.eraseColor(0);
      Canvas localCanvas = new Canvas(this.f);
      this.b.draw(localCanvas, paramInt1, paramInt2, null);
    }
  }
  
  private static class g
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState a;
    
    public g(Drawable.ConstantState paramConstantState)
    {
      this.a = paramConstantState;
    }
    
    public boolean canApplyTheme()
    {
      return this.a.canApplyTheme();
    }
    
    public int getChangingConfigurations()
    {
      return this.a.getChangingConfigurations();
    }
    
    public Drawable newDrawable()
    {
      i locali = new i();
      locali.c = ((VectorDrawable)this.a.newDrawable());
      return locali;
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      i locali = new i();
      locali.c = ((VectorDrawable)this.a.newDrawable(paramResources));
      return locali;
    }
    
    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      i locali = new i();
      locali.c = ((VectorDrawable)this.a.newDrawable(paramResources, paramTheme));
      return locali;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/graphics/drawable/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */