package com.airbnb.lottie;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.Settings.Global;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.BaseSavedState;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class LottieAnimationView
  extends AppCompatImageView
{
  private static final String a = LottieAnimationView.class.getSimpleName();
  private static final Map<String, aw> b = new HashMap();
  private static final Map<String, WeakReference<aw>> c = new HashMap();
  private final bf d = new bf()
  {
    public void onCompositionLoaded(aw paramAnonymousaw)
    {
      if (paramAnonymousaw != null) {
        LottieAnimationView.this.setComposition(paramAnonymousaw);
      }
      LottieAnimationView.a(LottieAnimationView.this, null);
    }
  };
  private final ax e = new ax();
  private a f;
  private String g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private q k;
  private aw l;
  
  public LottieAnimationView(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public LottieAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public LottieAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.LottieAnimationView);
    int m = paramAttributeSet.getInt(R.styleable.LottieAnimationView_lottie_cacheStrategy, a.a.ordinal());
    this.f = a.values()[m];
    String str = paramAttributeSet.getString(R.styleable.LottieAnimationView_lottie_fileName);
    if ((!isInEditMode()) && (str != null)) {
      setAnimation(str);
    }
    if (paramAttributeSet.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false))
    {
      this.e.playAnimation();
      this.i = true;
    }
    this.e.loop(paramAttributeSet.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false));
    setImageAssetsFolder(paramAttributeSet.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
    setProgress(paramAttributeSet.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0F));
    enableMergePathsForKitKatAndAbove(paramAttributeSet.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
    if (paramAttributeSet.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
      addColorFilter(new ca(paramAttributeSet.getColor(R.styleable.LottieAnimationView_lottie_colorFilter, 0)));
    }
    if (paramAttributeSet.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
      this.e.setScale(paramAttributeSet.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0F));
    }
    paramAttributeSet.recycle();
    if ((Build.VERSION.SDK_INT >= 17) && (Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F) == 0.0F)) {
      this.e.b();
    }
    e();
  }
  
  private void d()
  {
    if (this.k != null)
    {
      this.k.cancel();
      this.k = null;
    }
  }
  
  private void e()
  {
    int n = 1;
    if ((this.j) && (this.e.isAnimating())) {}
    for (int m = 1;; m = 0)
    {
      if (m != 0) {
        n = 2;
      }
      setLayerType(n, null);
      return;
    }
  }
  
  void a()
  {
    if (this.e != null) {
      this.e.recycleBitmaps();
    }
  }
  
  public void addAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.e.addAnimatorListener(paramAnimatorListener);
  }
  
  public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.e.addAnimatorUpdateListener(paramAnimatorUpdateListener);
  }
  
  public void addColorFilter(ColorFilter paramColorFilter)
  {
    this.e.addColorFilter(paramColorFilter);
  }
  
  public void addColorFilterToContent(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.e.addColorFilterToContent(paramString1, paramString2, paramColorFilter);
  }
  
  public void addColorFilterToLayer(String paramString, ColorFilter paramColorFilter)
  {
    this.e.addColorFilterToLayer(paramString, paramColorFilter);
  }
  
  public void cancelAnimation()
  {
    this.e.cancelAnimation();
    e();
  }
  
  public void clearColorFilters()
  {
    this.e.clearColorFilters();
  }
  
  public void enableMergePathsForKitKatAndAbove(boolean paramBoolean)
  {
    this.e.enableMergePathsForKitKatAndAbove(paramBoolean);
  }
  
  public long getDuration()
  {
    if (this.l != null) {
      return this.l.getDuration();
    }
    return 0L;
  }
  
  public String getImageAssetsFolder()
  {
    return this.e.getImageAssetsFolder();
  }
  
  public float getProgress()
  {
    return this.e.getProgress();
  }
  
  public float getScale()
  {
    return this.e.getScale();
  }
  
  public boolean hasMasks()
  {
    return this.e.hasMasks();
  }
  
  public boolean hasMatte()
  {
    return this.e.hasMatte();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (getDrawable() == this.e)
    {
      super.invalidateDrawable(this.e);
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  public boolean isAnimating()
  {
    return this.e.isAnimating();
  }
  
  public void loop(boolean paramBoolean)
  {
    this.e.loop(paramBoolean);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.i) && (this.h)) {
      playAnimation();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (isAnimating())
    {
      cancelAnimation();
      this.h = true;
    }
    a();
    super.onDetachedFromWindow();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.g = paramParcelable.a;
    if (!TextUtils.isEmpty(this.g)) {
      setAnimation(this.g);
    }
    setProgress(paramParcelable.b);
    loop(paramParcelable.d);
    if (paramParcelable.c) {
      playAnimation();
    }
    this.e.setImagesAssetsFolder(paramParcelable.e);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = this.g;
    localSavedState.b = this.e.getProgress();
    localSavedState.c = this.e.isAnimating();
    localSavedState.d = this.e.isLooping();
    localSavedState.e = this.e.getImageAssetsFolder();
    return localSavedState;
  }
  
  public void pauseAnimation()
  {
    float f1 = getProgress();
    this.e.cancelAnimation();
    setProgress(f1);
    e();
  }
  
  public void playAnimation()
  {
    this.e.playAnimation();
    e();
  }
  
  public void removeAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.e.removeAnimatorListener(paramAnimatorListener);
  }
  
  public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.e.removeAnimatorUpdateListener(paramAnimatorUpdateListener);
  }
  
  public void resumeAnimation()
  {
    this.e.resumeAnimation();
    e();
  }
  
  public void resumeReverseAnimation()
  {
    this.e.resumeReverseAnimation();
    e();
  }
  
  public void reverseAnimation()
  {
    this.e.reverseAnimation();
    e();
  }
  
  public void setAnimation(String paramString)
  {
    setAnimation(paramString, this.f);
  }
  
  public void setAnimation(final String paramString, final a parama)
  {
    this.g = paramString;
    if (c.containsKey(paramString))
    {
      WeakReference localWeakReference = (WeakReference)c.get(paramString);
      if (localWeakReference.get() != null) {
        setComposition((aw)localWeakReference.get());
      }
    }
    else if (b.containsKey(paramString))
    {
      setComposition((aw)b.get(paramString));
      return;
    }
    this.g = paramString;
    this.e.cancelAnimation();
    d();
    this.k = aw.a.fromAssetFileName(getContext(), paramString, new bf()
    {
      public void onCompositionLoaded(aw paramAnonymousaw)
      {
        if (parama == LottieAnimationView.a.c) {
          LottieAnimationView.b().put(paramString, paramAnonymousaw);
        }
        for (;;)
        {
          LottieAnimationView.this.setComposition(paramAnonymousaw);
          return;
          if (parama == LottieAnimationView.a.b) {
            LottieAnimationView.c().put(paramString, new WeakReference(paramAnonymousaw));
          }
        }
      }
    });
  }
  
  public void setAnimation(JSONObject paramJSONObject)
  {
    d();
    this.k = aw.a.fromJson(getResources(), paramJSONObject, this.d);
  }
  
  public void setComposition(aw paramaw)
  {
    this.e.setCallback(this);
    if (!this.e.setComposition(paramaw)) {
      return;
    }
    int m = ch.a(getContext());
    int n = ch.b(getContext());
    int i1 = paramaw.getBounds().width();
    int i2 = paramaw.getBounds().height();
    if ((i1 > m) || (i2 > n))
    {
      setScale(Math.min(Math.min(m / i1, n / i2), this.e.getScale()));
      Log.w("LOTTIE", String.format("Composition larger than the screen %dx%d vs %dx%d. Scaling down.", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(m), Integer.valueOf(n) }));
    }
    setImageDrawable(null);
    setImageDrawable(this.e);
    this.l = paramaw;
    requestLayout();
  }
  
  public void setImageAssetDelegate(ao paramao)
  {
    this.e.setImageAssetDelegate(paramao);
  }
  
  public void setImageAssetsFolder(String paramString)
  {
    this.e.setImagesAssetsFolder(paramString);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != this.e) {
      a();
    }
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    a();
  }
  
  public void setProgress(float paramFloat)
  {
    this.e.setProgress(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    this.e.setScale(paramFloat);
    if (getDrawable() == this.e)
    {
      setImageDrawable(null);
      setImageDrawable(this.e);
    }
  }
  
  public void setSpeed(float paramFloat)
  {
    this.e.setSpeed(paramFloat);
  }
  
  public Bitmap updateBitmap(String paramString, Bitmap paramBitmap)
  {
    return this.e.updateBitmap(paramString, paramBitmap);
  }
  
  public void useExperimentalHardwareAcceleration()
  {
    useExperimentalHardwareAcceleration(true);
  }
  
  public void useExperimentalHardwareAcceleration(boolean paramBoolean)
  {
    this.j = paramBoolean;
    e();
  }
  
  private static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public LottieAnimationView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new LottieAnimationView.SavedState(paramAnonymousParcel, null);
      }
      
      public LottieAnimationView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new LottieAnimationView.SavedState[paramAnonymousInt];
      }
    };
    String a;
    float b;
    boolean c;
    boolean d;
    String e;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readString();
      this.b = paramParcel.readFloat();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.c = bool1;
        if (paramParcel.readInt() != 1) {
          break label67;
        }
      }
      label67:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.d = bool1;
        this.e = paramParcel.readString();
        return;
        bool1 = false;
        break;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.a);
      paramParcel.writeFloat(this.b);
      if (this.c)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.d) {
          break label66;
        }
      }
      label66:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.e);
        return;
        paramInt = 0;
        break;
      }
    }
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/LottieAnimationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */