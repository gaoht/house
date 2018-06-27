package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Property;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.r;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.ZryuCycleViewPager;
import com.ziroom.ziroomcustomer.widget.ZryuCycleViewPager.a;
import com.ziroom.ziroomcustomer.widget.ZryuCycleViewPager.b;
import com.ziroom.ziroomcustomer.ziroomstation.model.ZSpaceImageItem;
import java.util.ArrayList;
import java.util.List;

public class ZryuScanZSpaceImageActivity
  extends BaseActivity
{
  private static final Property<ImageView, Matrix> M = new Property(Matrix.class, "animatedTransform")
  {
    public Matrix get(ImageView paramAnonymousImageView)
    {
      return null;
    }
    
    public void set(ImageView paramAnonymousImageView, Matrix paramAnonymousMatrix)
    {
      Drawable localDrawable = paramAnonymousImageView.getDrawable();
      if (localDrawable == null) {
        return;
      }
      if (paramAnonymousMatrix == null) {
        localDrawable.setBounds(0, 0, paramAnonymousImageView.getWidth(), paramAnonymousImageView.getHeight());
      }
      for (;;)
      {
        paramAnonymousImageView.invalidate();
        return;
        localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        if (paramAnonymousImageView.getImageMatrix() == null) {
          paramAnonymousImageView.setImageMatrix(new Matrix());
        }
        paramAnonymousImageView.setImageMatrix(paramAnonymousMatrix);
      }
    }
  };
  public static final String a;
  private static final AccelerateDecelerateInterpolator d = new AccelerateDecelerateInterpolator();
  private TextView A;
  private TextView B;
  private TextView C;
  private LinearLayout D;
  private RelativeLayout E;
  private String F;
  private ZryuCycleViewPager G;
  private boolean H = true;
  private RelativeLayout I;
  private int J;
  private ZryuCycleViewPager.a K = new ZryuCycleViewPager.a()
  {
    public void onImageClick(int paramAnonymousInt, View paramAnonymousView)
    {
      if (ZryuScanZSpaceImageActivity.b(ZryuScanZSpaceImageActivity.this))
      {
        ZryuScanZSpaceImageActivity.a(ZryuScanZSpaceImageActivity.this, false);
        ZryuScanZSpaceImageActivity.c(ZryuScanZSpaceImageActivity.this).setVisibility(4);
        ZryuScanZSpaceImageActivity.d(ZryuScanZSpaceImageActivity.this).setVisibility(4);
        return;
      }
      ZryuScanZSpaceImageActivity.a(ZryuScanZSpaceImageActivity.this, true);
      ZryuScanZSpaceImageActivity.c(ZryuScanZSpaceImageActivity.this).setVisibility(0);
      ZryuScanZSpaceImageActivity.d(ZryuScanZSpaceImageActivity.this).setVisibility(0);
    }
  };
  private ZryuCycleViewPager.b L = new ZryuCycleViewPager.b()
  {
    public void onPosChange(int paramAnonymousInt)
    {
      if (paramAnonymousInt > 5) {
        ZryuScanZSpaceImageActivity.a(ZryuScanZSpaceImageActivity.this, 5);
      }
      for (;;)
      {
        ZryuScanZSpaceImageActivity.f(ZryuScanZSpaceImageActivity.this).setText(paramAnonymousInt + "/" + ZryuScanZSpaceImageActivity.e(ZryuScanZSpaceImageActivity.this).size());
        ZryuScanZSpaceImageActivity.d(ZryuScanZSpaceImageActivity.this).setText(((ZSpaceImageItem)ZryuScanZSpaceImageActivity.e(ZryuScanZSpaceImageActivity.this).get(paramAnonymousInt - 1)).imageDesc);
        if (ZryuScanZSpaceImageActivity.g(ZryuScanZSpaceImageActivity.this) != null) {
          ZryuScanZSpaceImageActivity.a(ZryuScanZSpaceImageActivity.this, (Rect)ZryuScanZSpaceImageActivity.g(ZryuScanZSpaceImageActivity.this).get(ZryuScanZSpaceImageActivity.h(ZryuScanZSpaceImageActivity.this)));
        }
        return;
        ZryuScanZSpaceImageActivity.a(ZryuScanZSpaceImageActivity.this, paramAnonymousInt - 1);
      }
    }
  };
  public SimpleDraweeView b;
  public ImageView c;
  private float[] e = new float[9];
  private Rect f;
  private ArrayList<Rect> g;
  private int r;
  private int s;
  private int t;
  private int u;
  private Bitmap v;
  private AnimatorSet w;
  private AnimatorSet x;
  private List<ZSpaceImageItem> y;
  private int z;
  
  static
  {
    a = ZryuScanZSpaceImageActivity.class.getSimpleName();
  }
  
  private void a()
  {
    this.E = ((RelativeLayout)findViewById(2131693045));
    this.G = ((ZryuCycleViewPager)getSupportFragmentManager().findFragmentById(2131692934));
    this.D = ((LinearLayout)findViewById(2131693043));
    this.B = ((TextView)findViewById(2131693046));
    this.C = ((TextView)findViewById(2131693044));
    this.A = ((TextView)findViewById(2131692935));
    this.c = ((ImageView)findViewById(2131693047));
    this.I = ((RelativeLayout)findViewById(2131693042));
    if (TextUtils.isEmpty(this.F))
    {
      this.A.setVisibility(8);
      return;
    }
    this.A.setVisibility(0);
  }
  
  private void a(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    Object localObject1 = PropertyValuesHolder.ofInt("left", new int[] { this.b.getLeft(), paramInt1 });
    Object localObject2 = PropertyValuesHolder.ofInt("top", new int[] { this.b.getTop(), paramInt2 });
    Object localObject3 = PropertyValuesHolder.ofInt("right", new int[] { this.b.getRight(), paramInt1 + paramInt3 });
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofInt("bottom", new int[] { this.b.getBottom(), paramInt2 + paramInt4 });
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.b, new PropertyValuesHolder[] { localObject1, localObject2, localObject3, localPropertyValuesHolder });
    ((ObjectAnimator)localObject1).addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramAnonymousAnimator = (FrameLayout.LayoutParams)ZryuScanZSpaceImageActivity.this.b.getLayoutParams();
        paramAnonymousAnimator.height = paramInt4;
        paramAnonymousAnimator.width = paramInt3;
        paramAnonymousAnimator.setMargins(paramInt1, paramInt2, 0, 0);
        ZryuScanZSpaceImageActivity.m(ZryuScanZSpaceImageActivity.this).setVisibility(0);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localObject2 = getImageMatrix(this.b);
    ((Matrix)localObject2).getValues(this.e);
    localObject3 = getImageMatrix(this.c);
    localObject2 = ObjectAnimator.ofObject(this.b, M, new a(), new Matrix[] { localObject2, localObject3 });
    localObject3 = ObjectAnimator.ofFloat(this.I, "alpha", new float[] { 0.0F, 1.0F });
    this.w = new AnimatorSet();
    this.w.setDuration(500L);
    this.w.setInterpolator(d);
    this.w.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        ZryuScanZSpaceImageActivity.b(ZryuScanZSpaceImageActivity.this, null);
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (ZryuScanZSpaceImageActivity.n(ZryuScanZSpaceImageActivity.this) != null)
        {
          ZryuScanZSpaceImageActivity.b(ZryuScanZSpaceImageActivity.this, null);
          ZryuScanZSpaceImageActivity.this.b.setVisibility(4);
        }
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    this.w.playTogether(new Animator[] { localObject1, localObject2, localObject3 });
    if (this.w != null) {
      this.w.start();
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat)
  {
    if (!ae.isNull(((ZSpaceImageItem)this.y.get(this.z)).localPath))
    {
      localObject1 = r.getZoomBitmap(((ZSpaceImageItem)this.y.get(this.z)).localPath);
      this.v = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
      if (this.b != null) {
        this.b.setImageBitmap(this.v);
      }
    }
    this.b.setVisibility(0);
    this.D.setVisibility(4);
    Object localObject3 = new int[2];
    this.b.getLocationOnScreen((int[])localObject3);
    Object localObject1 = PropertyValuesHolder.ofInt("left", new int[] { localObject3[0], paramInt1 });
    Object localObject2 = PropertyValuesHolder.ofInt("top", new int[] { localObject3[1], paramInt2 });
    localObject3 = PropertyValuesHolder.ofInt("right", new int[] { localObject3[0] + this.b.getWidth(), paramInt1 + paramInt3 });
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofInt("bottom", new int[] { this.b.getBottom(), paramInt2 + paramInt4 });
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.b, new PropertyValuesHolder[] { localObject1, localObject2, localObject3, localPropertyValuesHolder });
    localObject2 = getImageMatrix(this.b);
    localObject3 = new Matrix();
    ((Matrix)localObject3).setValues(paramArrayOfFloat);
    this.b.setScaleType(ImageView.ScaleType.MATRIX);
    paramArrayOfFloat = ObjectAnimator.ofObject(this.b, M, new a(), new Matrix[] { localObject2, localObject3 });
    localObject2 = ObjectAnimator.ofFloat(this.I, "alpha", new float[] { 1.0F, 0.0F });
    this.x = new AnimatorSet();
    this.x.setDuration(500L);
    this.x.setInterpolator(new AccelerateInterpolator());
    this.x.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (ZryuScanZSpaceImageActivity.a(ZryuScanZSpaceImageActivity.this) != null) {
          ZryuScanZSpaceImageActivity.a(ZryuScanZSpaceImageActivity.this, null);
        }
        paramAnonymousAnimator = (Activity)ZryuScanZSpaceImageActivity.this.b.getContext();
        paramAnonymousAnimator.finish();
        paramAnonymousAnimator.overridePendingTransition(0, 0);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    this.x.playTogether(new Animator[] { localObject1, paramArrayOfFloat, localObject2 });
    this.x.start();
  }
  
  private void b()
  {
    this.G.setPosChangeListener(this.L);
    this.G.setCycle(true);
    this.G.setData(this, this.y, this.K, this.z, 1);
    this.G.setIsPageNumVisible(false);
  }
  
  private void e()
  {
    Object localObject = (FrameLayout)getWindow().getDecorView().findViewById(16908290);
    this.b = new SimpleDraweeView(this);
    this.b.setImageBitmap(this.v);
    this.D.setVisibility(4);
    ((FrameLayout)localObject).addView(this.b);
    localObject = getIntent().getExtras();
    this.g = getIntent().getParcelableArrayListExtra("image_origin_rect");
    this.f = ((Rect)this.g.get(this.z));
    localObject = (ImageView.ScaleType)((Bundle)localObject).getSerializable("image_scale_type");
    this.b.setScaleType((ImageView.ScaleType)localObject);
    localObject = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = this.f.width();
    ((FrameLayout.LayoutParams)localObject).height = this.f.height();
    ((FrameLayout.LayoutParams)localObject).setMargins(this.f.left, this.f.top - this.J, 0, 0);
  }
  
  private void f()
  {
    this.c.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        int[] arrayOfInt = new int[2];
        ZryuScanZSpaceImageActivity.this.c.getLocationOnScreen(arrayOfInt);
        ZryuScanZSpaceImageActivity.b(ZryuScanZSpaceImageActivity.this, arrayOfInt[0]);
        ZryuScanZSpaceImageActivity.c(ZryuScanZSpaceImageActivity.this, arrayOfInt[1]);
        ZryuScanZSpaceImageActivity.d(ZryuScanZSpaceImageActivity.this, ZryuScanZSpaceImageActivity.this.c.getWidth());
        ZryuScanZSpaceImageActivity.e(ZryuScanZSpaceImageActivity.this, ZryuScanZSpaceImageActivity.this.c.getHeight());
        ZryuScanZSpaceImageActivity.a(ZryuScanZSpaceImageActivity.this, ZryuScanZSpaceImageActivity.i(ZryuScanZSpaceImageActivity.this), ZryuScanZSpaceImageActivity.j(ZryuScanZSpaceImageActivity.this), ZryuScanZSpaceImageActivity.k(ZryuScanZSpaceImageActivity.this), ZryuScanZSpaceImageActivity.l(ZryuScanZSpaceImageActivity.this));
        ZryuScanZSpaceImageActivity.this.c.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
      }
    });
  }
  
  public static Matrix getImageMatrix(ImageView paramImageView)
  {
    Log.d(a, "getImageMatrix, imageView " + paramImageView);
    Rect localRect = new Rect(paramImageView.getLeft(), paramImageView.getTop(), paramImageView.getRight(), paramImageView.getBottom());
    Drawable localDrawable = paramImageView.getDrawable();
    ImageView.ScaleType localScaleType = paramImageView.getScaleType();
    Log.d(a, "getImageMatrix, scaleType " + localScaleType);
    if (localScaleType == ImageView.ScaleType.FIT_XY)
    {
      paramImageView = paramImageView.getImageMatrix();
      if (!paramImageView.isIdentity()) {
        return new Matrix(paramImageView);
      }
      int i = localDrawable.getIntrinsicWidth();
      int j = localDrawable.getIntrinsicHeight();
      if ((i > 0) && (j > 0))
      {
        float f1 = localRect.width() / i;
        float f2 = localRect.height() / j;
        paramImageView = new Matrix();
        paramImageView.setScale(f1, f2);
        return paramImageView;
      }
      return null;
    }
    return new Matrix(paramImageView.getImageMatrix());
  }
  
  public void onBackPressed()
  {
    if (this.w != null) {
      this.w.cancel();
    }
    a(this.f.left, this.f.top - this.J, this.f.width(), this.f.height(), this.e);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903621);
    this.F = getIntent().getStringExtra("panoramicUrl");
    this.z = getIntent().getIntExtra("position", 0);
    this.y = getIntent().getParcelableArrayListExtra("mImageList");
    a();
    b();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131692935: 
      do
      {
        return;
      } while (TextUtils.isEmpty(this.F));
      JsBridgeWebActivity.start(this, "全景看房", this.F);
      return;
    }
    if (this.w != null) {
      this.w.cancel();
    }
    a(this.f.left, this.f.top - this.J, this.f.width(), this.f.height(), this.e);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    Object localObject;
    if (this.J == 0)
    {
      localObject = new Rect();
      getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      this.J = ((Rect)localObject).top;
    }
    if (!ae.isNull(((ZSpaceImageItem)this.y.get(this.z)).localPath))
    {
      localObject = getIntent().getByteArrayExtra("image_res_id");
      this.v = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      int i = this.v.getWidth();
      int j = this.v.getHeight();
      int k = getWindowManager().getDefaultDisplay().getWidth();
      localObject = new Rect();
      this.c.getDrawingRect((Rect)localObject);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.width = k;
      localLayoutParams.height = (j * k / i);
      localLayoutParams.setMargins(((Rect)localObject).left, ((Rect)localObject).top - this.J, 0, 0);
    }
    e();
    f();
  }
  
  static class a
    implements TypeEvaluator<Matrix>
  {
    public static TypeEvaluator<Matrix> a = new TypeEvaluator()
    {
      public Matrix evaluate(float paramAnonymousFloat, Matrix paramAnonymousMatrix1, Matrix paramAnonymousMatrix2)
      {
        return null;
      }
    };
    float[] b = new float[9];
    float[] c = new float[9];
    Matrix d = new Matrix();
    
    public Matrix evaluate(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2)
    {
      paramMatrix1.getValues(this.b);
      paramMatrix2.getValues(this.c);
      int i = 0;
      while (i < 9)
      {
        float f1 = this.c[i];
        float f2 = this.b[i];
        this.c[i] = ((f1 - f2) * paramFloat + this.b[i]);
        i += 1;
      }
      this.d.setValues(this.c);
      return this.d;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuScanZSpaceImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */