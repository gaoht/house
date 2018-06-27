package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.design.R.color;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;

class FloatingActionButtonImpl
{
  static final Interpolator ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
  static final int ANIM_STATE_HIDING = 1;
  static final int ANIM_STATE_NONE = 0;
  static final int ANIM_STATE_SHOWING = 2;
  static final int[] EMPTY_STATE_SET = new int[0];
  static final int[] ENABLED_STATE_SET;
  static final int[] FOCUSED_ENABLED_STATE_SET;
  static final long PRESSED_ANIM_DELAY = 100L;
  static final long PRESSED_ANIM_DURATION = 100L;
  static final int[] PRESSED_ENABLED_STATE_SET = { 16842919, 16842910 };
  static final int SHOW_HIDE_ANIM_DURATION = 200;
  int mAnimState = 0;
  CircularBorderDrawable mBorderDrawable;
  Drawable mContentBackground;
  float mElevation;
  private ViewTreeObserver.OnPreDrawListener mPreDrawListener;
  float mPressedTranslationZ;
  Drawable mRippleDrawable;
  private float mRotation;
  ShadowDrawableWrapper mShadowDrawable;
  final ShadowViewDelegate mShadowViewDelegate;
  Drawable mShapeDrawable;
  private final StateListAnimator mStateListAnimator;
  private final Rect mTmpRect = new Rect();
  final VisibilityAwareImageButton mView;
  
  static
  {
    FOCUSED_ENABLED_STATE_SET = new int[] { 16842908, 16842910 };
    ENABLED_STATE_SET = new int[] { 16842910 };
  }
  
  FloatingActionButtonImpl(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    this.mView = paramVisibilityAwareImageButton;
    this.mShadowViewDelegate = paramShadowViewDelegate;
    this.mStateListAnimator = new StateListAnimator();
    this.mStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createAnimator(new ElevateToTranslationZAnimation()));
    this.mStateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createAnimator(new ElevateToTranslationZAnimation()));
    this.mStateListAnimator.addState(ENABLED_STATE_SET, createAnimator(new ResetElevationAnimation()));
    this.mStateListAnimator.addState(EMPTY_STATE_SET, createAnimator(new DisabledElevationAnimation()));
    this.mRotation = this.mView.getRotation();
  }
  
  private ValueAnimator createAnimator(ShadowAnimatorImpl paramShadowAnimatorImpl)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(ANIM_INTERPOLATOR);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramShadowAnimatorImpl);
    localValueAnimator.addUpdateListener(paramShadowAnimatorImpl);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  private static ColorStateList createColorStateList(int paramInt)
  {
    return new ColorStateList(new int[][] { FOCUSED_ENABLED_STATE_SET, PRESSED_ENABLED_STATE_SET, new int[0] }, new int[] { paramInt, paramInt, 0 });
  }
  
  private void ensurePreDrawListener()
  {
    if (this.mPreDrawListener == null) {
      this.mPreDrawListener = new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          FloatingActionButtonImpl.this.onPreDraw();
          return true;
        }
      };
    }
  }
  
  private boolean shouldAnimateVisibilityChange()
  {
    return (ViewCompat.isLaidOut(this.mView)) && (!this.mView.isInEditMode());
  }
  
  private void updateFromViewRotation()
  {
    if (Build.VERSION.SDK_INT == 19)
    {
      if (this.mRotation % 90.0F == 0.0F) {
        break label79;
      }
      if (this.mView.getLayerType() != 1) {
        this.mView.setLayerType(1, null);
      }
    }
    for (;;)
    {
      if (this.mShadowDrawable != null) {
        this.mShadowDrawable.setRotation(-this.mRotation);
      }
      if (this.mBorderDrawable != null) {
        this.mBorderDrawable.setRotation(-this.mRotation);
      }
      return;
      label79:
      if (this.mView.getLayerType() != 0) {
        this.mView.setLayerType(0, null);
      }
    }
  }
  
  CircularBorderDrawable createBorderDrawable(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = this.mView.getContext();
    CircularBorderDrawable localCircularBorderDrawable = newCircularDrawable();
    localCircularBorderDrawable.setGradientColors(ContextCompat.getColor(localContext, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(localContext, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(localContext, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(localContext, R.color.design_fab_stroke_end_outer_color));
    localCircularBorderDrawable.setBorderWidth(paramInt);
    localCircularBorderDrawable.setBorderTint(paramColorStateList);
    return localCircularBorderDrawable;
  }
  
  GradientDrawable createShapeDrawable()
  {
    GradientDrawable localGradientDrawable = newGradientDrawableForShape();
    localGradientDrawable.setShape(1);
    localGradientDrawable.setColor(-1);
    return localGradientDrawable;
  }
  
  final Drawable getContentBackground()
  {
    return this.mContentBackground;
  }
  
  float getElevation()
  {
    return this.mElevation;
  }
  
  void getPadding(Rect paramRect)
  {
    this.mShadowDrawable.getPadding(paramRect);
  }
  
  void hide(final InternalVisibilityChangedListener paramInternalVisibilityChangedListener, final boolean paramBoolean)
  {
    if (isOrWillBeHidden()) {
      return;
    }
    this.mView.animate().cancel();
    if (shouldAnimateVisibilityChange())
    {
      this.mAnimState = 1;
      this.mView.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter()
      {
        private boolean mCancelled;
        
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          this.mCancelled = true;
        }
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          FloatingActionButtonImpl.this.mAnimState = 0;
          if (!this.mCancelled)
          {
            paramAnonymousAnimator = FloatingActionButtonImpl.this.mView;
            if (!paramBoolean) {
              break label59;
            }
          }
          label59:
          for (int i = 8;; i = 4)
          {
            paramAnonymousAnimator.internalSetVisibility(i, paramBoolean);
            if (paramInternalVisibilityChangedListener != null) {
              paramInternalVisibilityChangedListener.onHidden();
            }
            return;
          }
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          FloatingActionButtonImpl.this.mView.internalSetVisibility(0, paramBoolean);
          this.mCancelled = false;
        }
      });
      return;
    }
    VisibilityAwareImageButton localVisibilityAwareImageButton = this.mView;
    if (paramBoolean) {}
    for (int i = 8;; i = 4)
    {
      localVisibilityAwareImageButton.internalSetVisibility(i, paramBoolean);
      if (paramInternalVisibilityChangedListener == null) {
        break;
      }
      paramInternalVisibilityChangedListener.onHidden();
      return;
    }
  }
  
  boolean isOrWillBeHidden()
  {
    if (this.mView.getVisibility() == 0) {
      if (this.mAnimState != 1) {}
    }
    while (this.mAnimState != 2)
    {
      return true;
      return false;
    }
    return false;
  }
  
  boolean isOrWillBeShown()
  {
    if (this.mView.getVisibility() != 0) {
      if (this.mAnimState != 2) {}
    }
    while (this.mAnimState != 1)
    {
      return true;
      return false;
    }
    return false;
  }
  
  void jumpDrawableToCurrentState()
  {
    this.mStateListAnimator.jumpToCurrentState();
  }
  
  CircularBorderDrawable newCircularDrawable()
  {
    return new CircularBorderDrawable();
  }
  
  GradientDrawable newGradientDrawableForShape()
  {
    return new GradientDrawable();
  }
  
  void onAttachedToWindow()
  {
    if (requirePreDrawListener())
    {
      ensurePreDrawListener();
      this.mView.getViewTreeObserver().addOnPreDrawListener(this.mPreDrawListener);
    }
  }
  
  void onCompatShadowChanged() {}
  
  void onDetachedFromWindow()
  {
    if (this.mPreDrawListener != null)
    {
      this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mPreDrawListener);
      this.mPreDrawListener = null;
    }
  }
  
  void onDrawableStateChanged(int[] paramArrayOfInt)
  {
    this.mStateListAnimator.setState(paramArrayOfInt);
  }
  
  void onElevationsChanged(float paramFloat1, float paramFloat2)
  {
    if (this.mShadowDrawable != null)
    {
      this.mShadowDrawable.setShadowSize(paramFloat1, this.mPressedTranslationZ + paramFloat1);
      updatePadding();
    }
  }
  
  void onPaddingUpdated(Rect paramRect) {}
  
  void onPreDraw()
  {
    float f = this.mView.getRotation();
    if (this.mRotation != f)
    {
      this.mRotation = f;
      updateFromViewRotation();
    }
  }
  
  boolean requirePreDrawListener()
  {
    return true;
  }
  
  void setBackgroundDrawable(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    this.mShapeDrawable = DrawableCompat.wrap(createShapeDrawable());
    DrawableCompat.setTintList(this.mShapeDrawable, paramColorStateList);
    if (paramMode != null) {
      DrawableCompat.setTintMode(this.mShapeDrawable, paramMode);
    }
    this.mRippleDrawable = DrawableCompat.wrap(createShapeDrawable());
    DrawableCompat.setTintList(this.mRippleDrawable, createColorStateList(paramInt1));
    if (paramInt2 > 0)
    {
      this.mBorderDrawable = createBorderDrawable(paramInt2, paramColorStateList);
      paramColorStateList = new Drawable[3];
      paramColorStateList[0] = this.mBorderDrawable;
      paramColorStateList[1] = this.mShapeDrawable;
      paramColorStateList[2] = this.mRippleDrawable;
    }
    for (;;)
    {
      this.mContentBackground = new LayerDrawable(paramColorStateList);
      this.mShadowDrawable = new ShadowDrawableWrapper(this.mView.getContext(), this.mContentBackground, this.mShadowViewDelegate.getRadius(), this.mElevation, this.mElevation + this.mPressedTranslationZ);
      this.mShadowDrawable.setAddPaddingForCorners(false);
      this.mShadowViewDelegate.setBackgroundDrawable(this.mShadowDrawable);
      return;
      this.mBorderDrawable = null;
      paramColorStateList = new Drawable[2];
      paramColorStateList[0] = this.mShapeDrawable;
      paramColorStateList[1] = this.mRippleDrawable;
    }
  }
  
  void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.mShapeDrawable != null) {
      DrawableCompat.setTintList(this.mShapeDrawable, paramColorStateList);
    }
    if (this.mBorderDrawable != null) {
      this.mBorderDrawable.setBorderTint(paramColorStateList);
    }
  }
  
  void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mShapeDrawable != null) {
      DrawableCompat.setTintMode(this.mShapeDrawable, paramMode);
    }
  }
  
  final void setElevation(float paramFloat)
  {
    if (this.mElevation != paramFloat)
    {
      this.mElevation = paramFloat;
      onElevationsChanged(paramFloat, this.mPressedTranslationZ);
    }
  }
  
  final void setPressedTranslationZ(float paramFloat)
  {
    if (this.mPressedTranslationZ != paramFloat)
    {
      this.mPressedTranslationZ = paramFloat;
      onElevationsChanged(this.mElevation, paramFloat);
    }
  }
  
  void setRippleColor(int paramInt)
  {
    if (this.mRippleDrawable != null) {
      DrawableCompat.setTintList(this.mRippleDrawable, createColorStateList(paramInt));
    }
  }
  
  void show(final InternalVisibilityChangedListener paramInternalVisibilityChangedListener, final boolean paramBoolean)
  {
    if (isOrWillBeShown()) {}
    do
    {
      return;
      this.mView.animate().cancel();
      if (shouldAnimateVisibilityChange())
      {
        this.mAnimState = 2;
        if (this.mView.getVisibility() != 0)
        {
          this.mView.setAlpha(0.0F);
          this.mView.setScaleY(0.0F);
          this.mView.setScaleX(0.0F);
        }
        this.mView.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(200L).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            FloatingActionButtonImpl.this.mAnimState = 0;
            if (paramInternalVisibilityChangedListener != null) {
              paramInternalVisibilityChangedListener.onShown();
            }
          }
          
          public void onAnimationStart(Animator paramAnonymousAnimator)
          {
            FloatingActionButtonImpl.this.mView.internalSetVisibility(0, paramBoolean);
          }
        });
        return;
      }
      this.mView.internalSetVisibility(0, paramBoolean);
      this.mView.setAlpha(1.0F);
      this.mView.setScaleY(1.0F);
      this.mView.setScaleX(1.0F);
    } while (paramInternalVisibilityChangedListener == null);
    paramInternalVisibilityChangedListener.onShown();
  }
  
  final void updatePadding()
  {
    Rect localRect = this.mTmpRect;
    getPadding(localRect);
    onPaddingUpdated(localRect);
    this.mShadowViewDelegate.setShadowPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  private class DisabledElevationAnimation
    extends FloatingActionButtonImpl.ShadowAnimatorImpl
  {
    DisabledElevationAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return 0.0F;
    }
  }
  
  private class ElevateToTranslationZAnimation
    extends FloatingActionButtonImpl.ShadowAnimatorImpl
  {
    ElevateToTranslationZAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return FloatingActionButtonImpl.this.mElevation + FloatingActionButtonImpl.this.mPressedTranslationZ;
    }
  }
  
  static abstract interface InternalVisibilityChangedListener
  {
    public abstract void onHidden();
    
    public abstract void onShown();
  }
  
  private class ResetElevationAnimation
    extends FloatingActionButtonImpl.ShadowAnimatorImpl
  {
    ResetElevationAnimation()
    {
      super(null);
    }
    
    protected float getTargetShadowSize()
    {
      return FloatingActionButtonImpl.this.mElevation;
    }
  }
  
  private abstract class ShadowAnimatorImpl
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener
  {
    private float mShadowSizeEnd;
    private float mShadowSizeStart;
    private boolean mValidValues;
    
    private ShadowAnimatorImpl() {}
    
    protected abstract float getTargetShadowSize();
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      FloatingActionButtonImpl.this.mShadowDrawable.setShadowSize(this.mShadowSizeEnd);
      this.mValidValues = false;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      if (!this.mValidValues)
      {
        this.mShadowSizeStart = FloatingActionButtonImpl.this.mShadowDrawable.getShadowSize();
        this.mShadowSizeEnd = getTargetShadowSize();
        this.mValidValues = true;
      }
      FloatingActionButtonImpl.this.mShadowDrawable.setShadowSize(this.mShadowSizeStart + (this.mShadowSizeEnd - this.mShadowSizeStart) * paramValueAnimator.getAnimatedFraction());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/design/widget/FloatingActionButtonImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */