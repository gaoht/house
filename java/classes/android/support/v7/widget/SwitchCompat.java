package android.support.v7.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.a.a.b;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.c.a;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import java.util.List;

public class SwitchCompat
  extends CompoundButton
{
  private static final int[] N = { 16842912 };
  private static final Property<SwitchCompat, Float> b = new Property(Float.class, "thumbPos")
  {
    public Float get(SwitchCompat paramAnonymousSwitchCompat)
    {
      return Float.valueOf(SwitchCompat.a(paramAnonymousSwitchCompat));
    }
    
    public void set(SwitchCompat paramAnonymousSwitchCompat, Float paramAnonymousFloat)
    {
      paramAnonymousSwitchCompat.setThumbPosition(paramAnonymousFloat.floatValue());
    }
  };
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private final TextPaint H = new TextPaint(1);
  private ColorStateList I;
  private Layout J;
  private Layout K;
  private TransformationMethod L;
  private final Rect M = new Rect();
  ObjectAnimator a;
  private Drawable c;
  private ColorStateList d = null;
  private PorterDuff.Mode e = null;
  private boolean f = false;
  private boolean g = false;
  private Drawable h;
  private ColorStateList i = null;
  private PorterDuff.Mode j = null;
  private boolean k = false;
  private boolean l = false;
  private int m;
  private int n;
  private int o;
  private boolean p;
  private CharSequence q;
  private CharSequence r;
  private boolean s;
  private int t;
  private int u;
  private float v;
  private float w;
  private VelocityTracker x = VelocityTracker.obtain();
  private int y;
  private float z;
  
  public SwitchCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.switchStyle);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources();
    this.H.density = ((Resources)localObject).getDisplayMetrics().density;
    paramAttributeSet = at.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.SwitchCompat, paramInt, 0);
    this.c = paramAttributeSet.getDrawable(R.styleable.SwitchCompat_android_thumb);
    if (this.c != null) {
      this.c.setCallback(this);
    }
    this.h = paramAttributeSet.getDrawable(R.styleable.SwitchCompat_track);
    if (this.h != null) {
      this.h.setCallback(this);
    }
    this.q = paramAttributeSet.getText(R.styleable.SwitchCompat_android_textOn);
    this.r = paramAttributeSet.getText(R.styleable.SwitchCompat_android_textOff);
    this.s = paramAttributeSet.getBoolean(R.styleable.SwitchCompat_showText, true);
    this.m = paramAttributeSet.getDimensionPixelSize(R.styleable.SwitchCompat_thumbTextPadding, 0);
    this.n = paramAttributeSet.getDimensionPixelSize(R.styleable.SwitchCompat_switchMinWidth, 0);
    this.o = paramAttributeSet.getDimensionPixelSize(R.styleable.SwitchCompat_switchPadding, 0);
    this.p = paramAttributeSet.getBoolean(R.styleable.SwitchCompat_splitTrack, false);
    localObject = paramAttributeSet.getColorStateList(R.styleable.SwitchCompat_thumbTint);
    if (localObject != null)
    {
      this.d = ((ColorStateList)localObject);
      this.f = true;
    }
    localObject = w.parseTintMode(paramAttributeSet.getInt(R.styleable.SwitchCompat_thumbTintMode, -1), null);
    if (this.e != localObject)
    {
      this.e = ((PorterDuff.Mode)localObject);
      this.g = true;
    }
    if ((this.f) || (this.g)) {
      b();
    }
    localObject = paramAttributeSet.getColorStateList(R.styleable.SwitchCompat_trackTint);
    if (localObject != null)
    {
      this.i = ((ColorStateList)localObject);
      this.k = true;
    }
    localObject = w.parseTintMode(paramAttributeSet.getInt(R.styleable.SwitchCompat_trackTintMode, -1), null);
    if (this.j != localObject)
    {
      this.j = ((PorterDuff.Mode)localObject);
      this.l = true;
    }
    if ((this.k) || (this.l)) {
      a();
    }
    paramInt = paramAttributeSet.getResourceId(R.styleable.SwitchCompat_switchTextAppearance, 0);
    if (paramInt != 0) {
      setSwitchTextAppearance(paramContext, paramInt);
    }
    paramAttributeSet.recycle();
    paramContext = ViewConfiguration.get(paramContext);
    this.u = paramContext.getScaledTouchSlop();
    this.y = paramContext.getScaledMinimumFlingVelocity();
    refreshDrawableState();
    setChecked(isChecked());
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  private Layout a(CharSequence paramCharSequence)
  {
    TextPaint localTextPaint;
    if (this.L != null)
    {
      paramCharSequence = this.L.getTransformation(paramCharSequence, this);
      localTextPaint = this.H;
      if (paramCharSequence == null) {
        break label62;
      }
    }
    label62:
    for (int i1 = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, this.H));; i1 = 0)
    {
      return new StaticLayout(paramCharSequence, localTextPaint, i1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      break;
    }
  }
  
  private void a()
  {
    if ((this.h != null) && ((this.k) || (this.l)))
    {
      this.h = this.h.mutate();
      if (this.k) {
        DrawableCompat.setTintList(this.h, this.i);
      }
      if (this.l) {
        DrawableCompat.setTintMode(this.h, this.j);
      }
      if (this.h.isStateful()) {
        this.h.setState(getDrawableState());
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Typeface localTypeface = null;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      setSwitchTypeface(localTypeface, paramInt2);
      return;
      localTypeface = Typeface.SANS_SERIF;
      continue;
      localTypeface = Typeface.SERIF;
      continue;
      localTypeface = Typeface.MONOSPACE;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(3);
    super.onTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f1 = 1.0F;; f1 = 0.0F)
    {
      this.a = ObjectAnimator.ofFloat(this, b, new float[] { f1 });
      this.a.setDuration(250L);
      if (Build.VERSION.SDK_INT >= 18) {
        this.a.setAutoCancel(true);
      }
      this.a.start();
      return;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.c == null) {}
    int i3;
    int i1;
    int i2;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    do
    {
      return false;
      i3 = getThumbOffset();
      this.c.getPadding(this.M);
      i1 = this.E;
      i2 = this.u;
      i3 = i3 + this.D - this.u;
      i4 = this.C;
      i5 = this.M.left;
      i6 = this.M.right;
      i7 = this.u;
      i8 = this.G;
      i9 = this.u;
    } while ((paramFloat1 <= i3) || (paramFloat1 >= i4 + i3 + i5 + i6 + i7) || (paramFloat2 <= i1 - i2) || (paramFloat2 >= i8 + i9));
    return true;
  }
  
  private void b()
  {
    if ((this.c != null) && ((this.f) || (this.g)))
    {
      this.c = this.c.mutate();
      if (this.f) {
        DrawableCompat.setTintList(this.c, this.d);
      }
      if (this.g) {
        DrawableCompat.setTintMode(this.c, this.e);
      }
      if (this.c.isStateful()) {
        this.c.setState(getDrawableState());
      }
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    this.t = 0;
    int i1;
    boolean bool2;
    float f1;
    if ((paramMotionEvent.getAction() == 1) && (isEnabled()))
    {
      i1 = 1;
      bool2 = isChecked();
      if (i1 == 0) {
        break label135;
      }
      this.x.computeCurrentVelocity(1000);
      f1 = this.x.getXVelocity();
      if (Math.abs(f1) <= this.y) {
        break label126;
      }
      if (!bb.isLayoutRtl(this)) {
        break label114;
      }
      if (f1 >= 0.0F) {
        break label108;
      }
    }
    for (;;)
    {
      if (bool1 != bool2) {
        playSoundEffect(0);
      }
      setChecked(bool1);
      a(paramMotionEvent);
      return;
      i1 = 0;
      break;
      label108:
      bool1 = false;
      continue;
      label114:
      if (f1 <= 0.0F)
      {
        bool1 = false;
        continue;
        label126:
        bool1 = getTargetCheckedState();
        continue;
        label135:
        bool1 = bool2;
      }
    }
  }
  
  private void c()
  {
    if (this.a != null) {
      this.a.cancel();
    }
  }
  
  private boolean getTargetCheckedState()
  {
    return this.z > 0.5F;
  }
  
  private int getThumbOffset()
  {
    if (bb.isLayoutRtl(this)) {}
    for (float f1 = 1.0F - this.z;; f1 = this.z) {
      return (int)(f1 * getThumbScrollRange() + 0.5F);
    }
  }
  
  private int getThumbScrollRange()
  {
    if (this.h != null)
    {
      Rect localRect2 = this.M;
      this.h.getPadding(localRect2);
      if (this.c != null) {}
      for (Rect localRect1 = w.getOpticalBounds(this.c);; localRect1 = w.a) {
        return this.A - this.C - localRect2.left - localRect2.right - localRect1.left - localRect1.right;
      }
    }
    return 0;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = this.M;
    int i2 = this.D;
    int i5 = this.E;
    int i7 = this.F;
    int i6 = this.G;
    int i8 = i2 + getThumbOffset();
    Object localObject;
    int i9;
    label139:
    int i4;
    int i3;
    if (this.c != null)
    {
      localObject = w.getOpticalBounds(this.c);
      if (this.h == null) {
        break label340;
      }
      this.h.getPadding(localRect);
      i9 = localRect.left;
      if (localObject == null) {
        break label320;
      }
      i1 = i2;
      if (((Rect)localObject).left > localRect.left) {
        i1 = i2 + (((Rect)localObject).left - localRect.left);
      }
      if (((Rect)localObject).top <= localRect.top) {
        break label314;
      }
      i2 = ((Rect)localObject).top - localRect.top + i5;
      i4 = i7;
      if (((Rect)localObject).right > localRect.right) {
        i4 = i7 - (((Rect)localObject).right - localRect.right);
      }
      if (((Rect)localObject).bottom <= localRect.bottom) {
        break label307;
      }
      i3 = i6 - (((Rect)localObject).bottom - localRect.bottom);
      label201:
      this.h.setBounds(i1, i2, i4, i3);
    }
    label307:
    label314:
    label320:
    label340:
    for (int i1 = i9 + i8;; i1 = i8)
    {
      if (this.c != null)
      {
        this.c.getPadding(localRect);
        i2 = i1 - localRect.left;
        i1 = i1 + this.C + localRect.right;
        this.c.setBounds(i2, i5, i1, i6);
        localObject = getBackground();
        if (localObject != null) {
          DrawableCompat.setHotspotBounds((Drawable)localObject, i2, i5, i1, i6);
        }
      }
      super.draw(paramCanvas);
      return;
      localObject = w.a;
      break;
      i3 = i6;
      break label201;
      i2 = i5;
      break label139;
      i3 = i6;
      i4 = i5;
      i1 = i2;
      i2 = i4;
      i4 = i7;
      break label201;
    }
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      super.drawableHotspotChanged(paramFloat1, paramFloat2);
    }
    if (this.c != null) {
      DrawableCompat.setHotspot(this.c, paramFloat1, paramFloat2);
    }
    if (this.h != null) {
      DrawableCompat.setHotspot(this.h, paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.c;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = false | localDrawable.setState(arrayOfInt);
      }
    }
    localDrawable = this.h;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool2) {
      invalidate();
    }
  }
  
  public int getCompoundPaddingLeft()
  {
    int i1;
    if (!bb.isLayoutRtl(this)) {
      i1 = super.getCompoundPaddingLeft();
    }
    int i2;
    do
    {
      return i1;
      i2 = super.getCompoundPaddingLeft() + this.A;
      i1 = i2;
    } while (TextUtils.isEmpty(getText()));
    return i2 + this.o;
  }
  
  public int getCompoundPaddingRight()
  {
    int i1;
    if (bb.isLayoutRtl(this)) {
      i1 = super.getCompoundPaddingRight();
    }
    int i2;
    do
    {
      return i1;
      i2 = super.getCompoundPaddingRight() + this.A;
      i1 = i2;
    } while (TextUtils.isEmpty(getText()));
    return i2 + this.o;
  }
  
  public boolean getShowText()
  {
    return this.s;
  }
  
  public boolean getSplitTrack()
  {
    return this.p;
  }
  
  public int getSwitchMinWidth()
  {
    return this.n;
  }
  
  public int getSwitchPadding()
  {
    return this.o;
  }
  
  public CharSequence getTextOff()
  {
    return this.r;
  }
  
  public CharSequence getTextOn()
  {
    return this.q;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.c;
  }
  
  public int getThumbTextPadding()
  {
    return this.m;
  }
  
  public ColorStateList getThumbTintList()
  {
    return this.d;
  }
  
  public PorterDuff.Mode getThumbTintMode()
  {
    return this.e;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.h;
  }
  
  public ColorStateList getTrackTintList()
  {
    return this.i;
  }
  
  public PorterDuff.Mode getTrackTintMode()
  {
    return this.j;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.jumpDrawablesToCurrentState();
      if (this.c != null) {
        this.c.jumpToCurrentState();
      }
      if (this.h != null) {
        this.h.jumpToCurrentState();
      }
      if ((this.a != null) && (this.a.isStarted()))
      {
        this.a.end();
        this.a = null;
      }
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, N);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1 = this.M;
    Object localObject3 = this.h;
    int i3;
    int i4;
    int i5;
    int i6;
    Object localObject2;
    label151:
    int i2;
    if (localObject3 != null)
    {
      ((Drawable)localObject3).getPadding((Rect)localObject1);
      i3 = this.E;
      i4 = this.G;
      i5 = ((Rect)localObject1).top;
      i6 = ((Rect)localObject1).bottom;
      localObject2 = this.c;
      if (localObject3 != null)
      {
        if ((!this.p) || (localObject2 == null)) {
          break label322;
        }
        Rect localRect = w.getOpticalBounds((Drawable)localObject2);
        ((Drawable)localObject2).copyBounds((Rect)localObject1);
        ((Rect)localObject1).left += localRect.left;
        ((Rect)localObject1).right -= localRect.right;
        i1 = paramCanvas.save();
        paramCanvas.clipRect((Rect)localObject1, Region.Op.DIFFERENCE);
        ((Drawable)localObject3).draw(paramCanvas);
        paramCanvas.restoreToCount(i1);
      }
      i2 = paramCanvas.save();
      if (localObject2 != null) {
        ((Drawable)localObject2).draw(paramCanvas);
      }
      if (!getTargetCheckedState()) {
        break label331;
      }
      localObject1 = this.J;
      label180:
      if (localObject1 != null)
      {
        localObject3 = getDrawableState();
        if (this.I != null) {
          this.H.setColor(this.I.getColorForState((int[])localObject3, 0));
        }
        this.H.drawableState = ((int[])localObject3);
        if (localObject2 == null) {
          break label340;
        }
        localObject2 = ((Drawable)localObject2).getBounds();
        i1 = ((Rect)localObject2).left;
      }
    }
    label322:
    label331:
    label340:
    for (int i1 = ((Rect)localObject2).right + i1;; i1 = getWidth())
    {
      i1 /= 2;
      int i7 = ((Layout)localObject1).getWidth() / 2;
      i3 = (i3 + i5 + (i4 - i6)) / 2;
      i4 = ((Layout)localObject1).getHeight() / 2;
      paramCanvas.translate(i1 - i7, i3 - i4);
      ((Layout)localObject1).draw(paramCanvas);
      paramCanvas.restoreToCount(i2);
      return;
      ((Rect)localObject1).setEmpty();
      break;
      ((Drawable)localObject3).draw(paramCanvas);
      break label151;
      localObject1 = this.K;
      break label180;
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("android.widget.Switch");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName("android.widget.Switch");
      if (!isChecked()) {
        break label57;
      }
    }
    CharSequence localCharSequence2;
    label57:
    for (CharSequence localCharSequence1 = this.q;; localCharSequence1 = this.r)
    {
      if (!TextUtils.isEmpty(localCharSequence1))
      {
        localCharSequence2 = paramAccessibilityNodeInfo.getText();
        if (!TextUtils.isEmpty(localCharSequence2)) {
          break;
        }
        paramAccessibilityNodeInfo.setText(localCharSequence1);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localCharSequence2).append(' ').append(localCharSequence1);
    paramAccessibilityNodeInfo.setText(localStringBuilder);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Rect localRect1;
    Rect localRect2;
    if (this.c != null)
    {
      localRect1 = this.M;
      if (this.h != null)
      {
        this.h.getPadding(localRect1);
        localRect2 = w.getOpticalBounds(this.c);
        paramInt2 = Math.max(0, localRect2.left - localRect1.left);
      }
    }
    for (paramInt1 = Math.max(0, localRect2.right - localRect1.right);; paramInt1 = i1)
    {
      if (bb.isLayoutRtl(this))
      {
        paramInt3 = getPaddingLeft() + paramInt2;
        paramInt4 = this.A + paramInt3 - paramInt2 - paramInt1;
        label113:
        switch (getGravity() & 0x70)
        {
        default: 
          paramInt2 = getPaddingTop();
          paramInt1 = this.B + paramInt2;
        }
      }
      for (;;)
      {
        this.D = paramInt3;
        this.E = paramInt2;
        this.G = paramInt1;
        this.F = paramInt4;
        return;
        localRect1.setEmpty();
        break;
        paramInt4 = getWidth() - getPaddingRight() - paramInt1;
        paramInt3 = paramInt1 + (paramInt2 + (paramInt4 - this.A));
        break label113;
        paramInt2 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - this.B / 2;
        paramInt1 = this.B + paramInt2;
        continue;
        paramInt1 = getHeight() - getPaddingBottom();
        paramInt2 = paramInt1 - this.B;
      }
      paramInt2 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = 0;
    if (this.s)
    {
      if (this.J == null) {
        this.J = a(this.q);
      }
      if (this.K == null) {
        this.K = a(this.r);
      }
    }
    Rect localRect = this.M;
    int i1;
    int i3;
    if (this.c != null)
    {
      this.c.getPadding(localRect);
      i2 = this.c.getIntrinsicWidth() - localRect.left - localRect.right;
      i1 = this.c.getIntrinsicHeight();
      if (!this.s) {
        break label303;
      }
      i3 = Math.max(this.J.getWidth(), this.K.getWidth()) + this.m * 2;
      label133:
      this.C = Math.max(i3, i2);
      if (this.h == null) {
        break label309;
      }
      this.h.getPadding(localRect);
    }
    for (int i2 = this.h.getIntrinsicHeight();; i2 = i4)
    {
      int i6 = localRect.left;
      int i5 = localRect.right;
      i4 = i5;
      i3 = i6;
      if (this.c != null)
      {
        localRect = w.getOpticalBounds(this.c);
        i3 = Math.max(i6, localRect.left);
        i4 = Math.max(i5, localRect.right);
      }
      i3 = Math.max(this.n, i4 + (i3 + this.C * 2));
      i1 = Math.max(i2, i1);
      this.A = i3;
      this.B = i1;
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredHeight() < i1) {
        setMeasuredDimension(getMeasuredWidthAndState(), i1);
      }
      return;
      i1 = 0;
      i2 = 0;
      break;
      label303:
      i3 = 0;
      break label133;
      label309:
      localRect.setEmpty();
    }
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (isChecked()) {}
    for (CharSequence localCharSequence = this.q;; localCharSequence = this.r)
    {
      if (localCharSequence != null) {
        paramAccessibilityEvent.getText().add(localCharSequence);
      }
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.x.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((isEnabled()) && (a(f1, f2)))
      {
        this.t = 1;
        this.v = f1;
        this.w = f2;
        continue;
        switch (this.t)
        {
        case 0: 
        default: 
          break;
        case 1: 
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((Math.abs(f1 - this.v) > this.u) || (Math.abs(f2 - this.w) > this.u))
          {
            this.t = 2;
            getParent().requestDisallowInterceptTouchEvent(true);
            this.v = f1;
            this.w = f2;
            return true;
          }
          break;
        case 2: 
          float f3 = paramMotionEvent.getX();
          int i1 = getThumbScrollRange();
          f1 = f3 - this.v;
          if (i1 != 0) {
            f1 /= i1;
          }
          for (;;)
          {
            f2 = f1;
            if (bb.isLayoutRtl(this)) {
              f2 = -f1;
            }
            f1 = a(f2 + this.z, 0.0F, 1.0F);
            if (f1 != this.z)
            {
              this.v = f3;
              setThumbPosition(f1);
            }
            return true;
            if (f1 > 0.0F) {
              f1 = 1.0F;
            } else {
              f1 = -1.0F;
            }
          }
          if (this.t == 2)
          {
            b(paramMotionEvent);
            super.onTouchEvent(paramMotionEvent);
            return true;
          }
          this.t = 0;
          this.x.clear();
        }
      }
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    if ((getWindowToken() != null) && (ViewCompat.isLaidOut(this)))
    {
      a(paramBoolean);
      return;
    }
    c();
    if (paramBoolean) {}
    for (float f1 = 1.0F;; f1 = 0.0F)
    {
      setThumbPosition(f1);
      return;
    }
  }
  
  public void setShowText(boolean paramBoolean)
  {
    if (this.s != paramBoolean)
    {
      this.s = paramBoolean;
      requestLayout();
    }
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    this.p = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.n = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.o = paramInt;
    requestLayout();
  }
  
  public void setSwitchTextAppearance(Context paramContext, int paramInt)
  {
    paramContext = at.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    ColorStateList localColorStateList = paramContext.getColorStateList(R.styleable.TextAppearance_android_textColor);
    if (localColorStateList != null)
    {
      this.I = localColorStateList;
      paramInt = paramContext.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
      if ((paramInt != 0) && (paramInt != this.H.getTextSize()))
      {
        this.H.setTextSize(paramInt);
        requestLayout();
      }
      a(paramContext.getInt(R.styleable.TextAppearance_android_typeface, -1), paramContext.getInt(R.styleable.TextAppearance_android_textStyle, -1));
      if (!paramContext.getBoolean(R.styleable.TextAppearance_textAllCaps, false)) {
        break label127;
      }
    }
    label127:
    for (this.L = new a(getContext());; this.L = null)
    {
      paramContext.recycle();
      return;
      this.I = getTextColors();
      break;
    }
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (((this.H.getTypeface() != null) && (!this.H.getTypeface().equals(paramTypeface))) || ((this.H.getTypeface() == null) && (paramTypeface != null)))
    {
      this.H.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setSwitchTypeface(Typeface paramTypeface, int paramInt)
  {
    boolean bool = false;
    if (paramInt > 0)
    {
      int i1;
      if (paramTypeface == null)
      {
        paramTypeface = Typeface.defaultFromStyle(paramInt);
        setSwitchTypeface(paramTypeface);
        if (paramTypeface == null) {
          break label88;
        }
        i1 = paramTypeface.getStyle();
        label31:
        paramInt = (i1 ^ 0xFFFFFFFF) & paramInt;
        paramTypeface = this.H;
        if ((paramInt & 0x1) != 0) {
          bool = true;
        }
        paramTypeface.setFakeBoldText(bool);
        paramTypeface = this.H;
        if ((paramInt & 0x2) == 0) {
          break label94;
        }
      }
      label88:
      label94:
      for (float f1 = -0.25F;; f1 = 0.0F)
      {
        paramTypeface.setTextSkewX(f1);
        return;
        paramTypeface = Typeface.create(paramTypeface, paramInt);
        break;
        i1 = 0;
        break label31;
      }
    }
    this.H.setFakeBoldText(false);
    this.H.setTextSkewX(0.0F);
    setSwitchTypeface(paramTypeface);
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    this.r = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    this.q = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    if (this.c != null) {
      this.c.setCallback(null);
    }
    this.c = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  void setThumbPosition(float paramFloat)
  {
    this.z = paramFloat;
    invalidate();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(b.getDrawable(getContext(), paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.m = paramInt;
    requestLayout();
  }
  
  public void setThumbTintList(ColorStateList paramColorStateList)
  {
    this.d = paramColorStateList;
    this.f = true;
    b();
  }
  
  public void setThumbTintMode(PorterDuff.Mode paramMode)
  {
    this.e = paramMode;
    this.g = true;
    b();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    if (this.h != null) {
      this.h.setCallback(null);
    }
    this.h = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(b.getDrawable(getContext(), paramInt));
  }
  
  public void setTrackTintList(ColorStateList paramColorStateList)
  {
    this.i = paramColorStateList;
    this.k = true;
    a();
  }
  
  public void setTrackTintMode(PorterDuff.Mode paramMode)
  {
    this.j = paramMode;
    this.l = true;
    a();
  }
  
  public void toggle()
  {
    if (!isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.c) || (paramDrawable == this.h);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/SwitchCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */