package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.AssetsLoadUtil;
import com.baidu.platform.comapi.map.D;
import com.baidu.platform.comapi.map.N;
import com.baidu.platform.comapi.map.e;
import com.baidu.platform.comapi.map.i;
import com.baidu.platform.comapi.map.k;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

@TargetApi(20)
public class WearMapView
  extends ViewGroup
  implements View.OnApplyWindowInsetsListener
{
  public static final int BT_INVIEW = 1;
  private static final String b = MapView.class.getSimpleName();
  private static String c;
  private static int q = 0;
  private static int r = 0;
  private static int s = 10;
  private static final SparseArray<Integer> u = new SparseArray();
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  a a = a.a;
  private i d;
  private BaiduMap e;
  private ImageView f;
  private Bitmap g;
  private N h;
  private boolean i = true;
  private Point j;
  private Point k;
  private RelativeLayout l;
  private SwipeDismissView m;
  public AnimationTask mTask;
  public Timer mTimer;
  public b mTimerHandler;
  private TextView n;
  private TextView o;
  private ImageView p;
  private boolean t = true;
  private boolean v = true;
  private boolean w = true;
  private float x;
  private k y;
  private int z;
  
  static
  {
    u.append(3, Integer.valueOf(2000000));
    u.append(4, Integer.valueOf(1000000));
    u.append(5, Integer.valueOf(500000));
    u.append(6, Integer.valueOf(200000));
    u.append(7, Integer.valueOf(100000));
    u.append(8, Integer.valueOf(50000));
    u.append(9, Integer.valueOf(25000));
    u.append(10, Integer.valueOf(20000));
    u.append(11, Integer.valueOf(10000));
    u.append(12, Integer.valueOf(5000));
    u.append(13, Integer.valueOf(2000));
    u.append(14, Integer.valueOf(1000));
    u.append(15, Integer.valueOf(500));
    u.append(16, Integer.valueOf(200));
    u.append(17, Integer.valueOf(100));
    u.append(18, Integer.valueOf(50));
    u.append(19, Integer.valueOf(20));
    u.append(20, Integer.valueOf(10));
    u.append(21, Integer.valueOf(5));
    u.append(22, Integer.valueOf(2));
  }
  
  public WearMapView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public WearMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, null);
  }
  
  public WearMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, null);
  }
  
  public WearMapView(Context paramContext, BaiduMapOptions paramBaiduMapOptions)
  {
    super(paramContext);
    a(paramContext, paramBaiduMapOptions);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    return paramInt1 - (int)Math.sqrt(Math.pow(paramInt1, 2.0D) - Math.pow(paramInt2, 2.0D));
  }
  
  private void a(int paramInt)
  {
    if (this.d == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.d.onPause();
      b();
      return;
    }
    this.d.onResume();
    c();
  }
  
  private static void a(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    paramContext.getSize(localPoint);
    q = localPoint.x;
    r = localPoint.y;
  }
  
  private void a(Context paramContext, BaiduMapOptions paramBaiduMapOptions)
  {
    a(paramContext);
    setOnApplyWindowInsetsListener(this);
    this.mTimerHandler = new b(paramContext);
    this.mTimer = new Timer();
    if ((this.mTimer != null) && (this.mTask != null)) {
      this.mTask.cancel();
    }
    this.mTask = new AnimationTask();
    this.mTimer.schedule(this.mTask, 5000L);
    BMapManager.init();
    a(paramContext, paramBaiduMapOptions, c);
    this.e = new BaiduMap(this.d);
    this.d.a().p(false);
    this.d.a().o(false);
    c(paramContext);
    d(paramContext);
    b(paramContext);
    if ((paramBaiduMapOptions != null) && (!paramBaiduMapOptions.h)) {
      this.h.setVisibility(4);
    }
    e(paramContext);
    if ((paramBaiduMapOptions != null) && (!paramBaiduMapOptions.i)) {
      this.l.setVisibility(4);
    }
    if ((paramBaiduMapOptions != null) && (paramBaiduMapOptions.l != null)) {
      this.k = paramBaiduMapOptions.l;
    }
    if ((paramBaiduMapOptions != null) && (paramBaiduMapOptions.k != null)) {
      this.j = paramBaiduMapOptions.k;
    }
  }
  
  private void a(Context paramContext, BaiduMapOptions paramBaiduMapOptions, String paramString)
  {
    if (paramBaiduMapOptions == null) {}
    for (this.d = new i(paramContext, null, paramString);; this.d = new i(paramContext, paramBaiduMapOptions.a(), paramString))
    {
      addView(this.d);
      this.y = new u(this);
      this.d.a().a(this.y);
      return;
    }
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-2, -2);
    }
    int i1 = localLayoutParams1.width;
    if (i1 > 0)
    {
      i1 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
      i2 = localLayoutParams1.height;
      if (i2 <= 0) {
        break label80;
      }
    }
    label80:
    for (int i2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);; i2 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(i1, i2);
      return;
      i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      break;
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "TranslationY", new float[] { 0.0F, -50.0F }), ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F }) });
      localAnimatorSet.addListener(new x(this, paramView));
      localAnimatorSet.setDuration(1200L);
      localAnimatorSet.start();
      return;
    }
    paramView.setVisibility(0);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(paramView, "TranslationY", new float[] { -50.0F, 0.0F }), ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F }) });
    localAnimatorSet.setDuration(1200L);
    localAnimatorSet.start();
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.i) {
      return;
    }
    a(this.h, paramBoolean);
  }
  
  private void b()
  {
    if (this.d == null) {}
    while (this.t) {
      return;
    }
    d();
    this.t = true;
  }
  
  private void b(Context paramContext)
  {
    this.m = new SwipeDismissView(paramContext, this);
    paramContext = new ViewGroup.LayoutParams((int)(paramContext.getResources().getDisplayMetrics().density * 34.0F + 0.5F), r);
    this.m.setBackgroundColor(Color.argb(0, 0, 0, 0));
    this.m.setLayoutParams(paramContext);
    addView(this.m);
  }
  
  private void c()
  {
    if (this.d == null) {}
    while (!this.t) {
      return;
    }
    e();
    this.t = false;
  }
  
  private void c(Context paramContext)
  {
    Object localObject = "logo_h.png";
    int i1 = SysOSUtil.getDensityDpi();
    if (i1 < 180) {
      localObject = "logo_l.png";
    }
    localObject = AssetsLoadUtil.loadAssetsFile((String)localObject, paramContext);
    Matrix localMatrix;
    if (i1 > 480)
    {
      localMatrix = new Matrix();
      localMatrix.postScale(2.0F, 2.0F);
      this.g = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, true);
    }
    for (;;)
    {
      if (this.g != null)
      {
        this.f = new ImageView(paramContext);
        this.f.setImageBitmap(this.g);
        addView(this.f);
      }
      return;
      if ((i1 > 320) && (i1 <= 480))
      {
        localMatrix = new Matrix();
        localMatrix.postScale(1.5F, 1.5F);
        this.g = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, true);
      }
      else
      {
        this.g = ((Bitmap)localObject);
      }
    }
  }
  
  private void d()
  {
    if (this.d == null) {
      return;
    }
    this.d.c();
  }
  
  private void d(Context paramContext)
  {
    this.h = new N(paramContext, true);
    if (!this.h.a()) {
      return;
    }
    this.h.b(new v(this));
    this.h.a(new w(this));
    addView(this.h);
  }
  
  private void e()
  {
    if (this.d == null) {
      return;
    }
    this.d.d();
  }
  
  private void e(Context paramContext)
  {
    this.l = new RelativeLayout(paramContext);
    Object localObject = new ViewGroup.LayoutParams(-2, -2);
    this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.n = new TextView(paramContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.n.setTextColor(Color.parseColor("#FFFFFF"));
    this.n.setTextSize(2, 11.0F);
    this.n.setTypeface(this.n.getTypeface(), 1);
    this.n.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.n.setId(Integer.MAX_VALUE);
    this.l.addView(this.n);
    this.o = new TextView(paramContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.o.setTextColor(Color.parseColor("#000000"));
    this.o.setTextSize(2, 11.0F);
    this.o.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.l.addView(this.o);
    this.p = new ImageView(paramContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, this.n.getId());
    this.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramContext = AssetsLoadUtil.loadAssetsFile("icon_scale.9.png", paramContext);
    localObject = paramContext.getNinePatchChunk();
    NinePatch.isNinePatchChunk((byte[])localObject);
    paramContext = new NinePatchDrawable(paramContext, (byte[])localObject, new Rect(), null);
    this.p.setBackgroundDrawable(paramContext);
    this.l.addView(this.p);
    addView(this.l);
  }
  
  public static void setCustomMapStylePath(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new RuntimeException("customMapStylePath String is illegal");
    }
    if (!new File(paramString).exists()) {
      throw new RuntimeException("please check whether the customMapStylePath file exits");
    }
    c = paramString;
  }
  
  public static void setMapCustomEnable(boolean paramBoolean)
  {
    i.a(paramBoolean);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof MapViewLayoutParams)) {
      super.addView(paramView, paramLayoutParams);
    }
  }
  
  public final BaiduMap getMap()
  {
    this.e.c = this;
    return this.e;
  }
  
  public final int getMapLevel()
  {
    float f1 = this.d.a().D().a;
    return ((Integer)u.get((int)f1)).intValue();
  }
  
  public int getScaleControlViewHeight()
  {
    return this.D;
  }
  
  public int getScaleControlViewWidth()
  {
    return this.E;
  }
  
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    if (paramWindowInsets.isRound())
    {
      this.a = a.a;
      return paramWindowInsets;
    }
    this.a = a.b;
    return paramWindowInsets;
  }
  
  public void onCreate(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    c = paramBundle.getString("customMapPath");
    if (paramBundle == null)
    {
      a(paramContext, new BaiduMapOptions());
      return;
    }
    MapStatus localMapStatus = (MapStatus)paramBundle.getParcelable("mapstatus");
    if (this.j != null) {
      this.j = ((Point)paramBundle.getParcelable("scalePosition"));
    }
    if (this.k != null) {
      this.k = ((Point)paramBundle.getParcelable("zoomPosition"));
    }
    this.v = paramBundle.getBoolean("mZoomControlEnabled");
    this.w = paramBundle.getBoolean("mScaleControlEnabled");
    setPadding(paramBundle.getInt("paddingLeft"), paramBundle.getInt("paddingTop"), paramBundle.getInt("paddingRight"), paramBundle.getInt("paddingBottom"));
    a(paramContext, new BaiduMapOptions().mapStatus(localMapStatus));
  }
  
  public final void onDestroy()
  {
    this.d.b();
    if ((this.g != null) && (!this.g.isRecycled()))
    {
      this.g.recycle();
      this.g = null;
    }
    this.h.b();
    BMapManager.destroy();
    if (this.mTask != null) {
      this.mTask.cancel();
    }
  }
  
  public final void onDismiss()
  {
    removeAllViews();
  }
  
  public final void onEnterAmbient(Bundle paramBundle)
  {
    a(0);
  }
  
  public void onExitAmbient()
  {
    a(1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if (this.h.getVisibility() == 0)
      {
        if (this.mTimer != null)
        {
          if (this.mTask != null)
          {
            this.mTimer.cancel();
            this.mTask.cancel();
          }
          this.mTimer = null;
          this.mTask = null;
        }
      }
      else if (this.h.getVisibility() == 4)
      {
        if (this.mTimer != null)
        {
          if (this.mTask != null) {
            this.mTask.cancel();
          }
          this.mTimer.cancel();
          this.mTask = null;
          this.mTimer = null;
        }
        a(false);
        continue;
        this.mTimer = new Timer();
        if ((this.mTimer != null) && (this.mTask != null)) {
          this.mTask.cancel();
        }
        this.mTask = new AnimationTask();
        this.mTimer.schedule(this.mTask, 5000L);
      }
    }
  }
  
  @TargetApi(20)
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    a(this.f);
    float f2;
    float f1;
    label112:
    View localView;
    if ((getWidth() - this.z - this.A - this.f.getMeasuredWidth() > 0) && (getHeight() - this.B - this.C - this.f.getMeasuredHeight() > 0))
    {
      f2 = (getWidth() - this.z - this.A) / getWidth();
      f1 = (getHeight() - this.B - this.C) / getHeight();
      paramInt1 = 0;
      if (paramInt1 >= paramInt4) {
        return;
      }
      localView = getChildAt(paramInt1);
      if (localView != this.d) {
        break label187;
      }
      this.d.layout(0, 0, getWidth(), getHeight());
    }
    label187:
    int i1;
    int i2;
    float f3;
    label825:
    do
    {
      for (;;)
      {
        paramInt1 += 1;
        break label112;
        this.z = 0;
        this.A = 0;
        this.C = 0;
        this.B = 0;
        f2 = 1.0F;
        f1 = 1.0F;
        break;
        if (localView == this.f)
        {
          i1 = (int)(this.C + 12.0F * f1);
          paramInt2 = 0;
          paramInt3 = 0;
          if (this.a == a.a)
          {
            a(this.h);
            paramInt2 = q / 2;
            paramInt3 = a(paramInt2, this.h.getMeasuredWidth() / 2);
            paramInt2 = q / 2 - a(paramInt2, paramInt2 - paramInt3) + s;
          }
          paramInt3 = r - paramInt3 - i1;
          i1 = this.f.getMeasuredHeight();
          paramInt2 = q - paramInt2;
          i2 = this.f.getMeasuredWidth();
          this.f.layout(paramInt2 - i2, paramInt3 - i1, paramInt2, paramInt3);
        }
        else if (localView == this.h)
        {
          if (this.h.a())
          {
            a(this.h);
            if (this.k == null)
            {
              paramInt2 = 0;
              if (this.a == a.a) {
                paramInt2 = a(r / 2, this.h.getMeasuredWidth() / 2);
              }
              f3 = this.B;
              paramInt2 = (int)(paramInt2 + (12.0F * f1 + f3));
              paramInt3 = (q - this.h.getMeasuredWidth()) / 2;
              i1 = this.h.getMeasuredWidth();
              i2 = this.h.getMeasuredHeight();
              this.h.layout(paramInt3, paramInt2, i1 + paramInt3, i2 + paramInt2);
            }
            else
            {
              this.h.layout(this.k.x, this.k.y, this.k.x + this.h.getMeasuredWidth(), this.k.y + this.h.getMeasuredHeight());
            }
          }
        }
        else if (localView == this.l)
        {
          paramInt3 = 0;
          paramInt2 = 0;
          if (this.a == a.a)
          {
            a(this.h);
            paramInt3 = q / 2;
            paramInt2 = a(paramInt3, this.h.getMeasuredWidth() / 2);
            paramInt3 = q / 2 - a(paramInt3, paramInt3 - paramInt2) + s;
          }
          a(this.l);
          if (this.j == null)
          {
            i1 = (int)(this.C + 12.0F * f1);
            this.E = this.l.getMeasuredWidth();
            this.D = this.l.getMeasuredHeight();
            f3 = this.z;
            paramInt3 = (int)(paramInt3 + (f3 + 5.0F * f2));
            paramInt2 = r - i1 - paramInt2;
            i1 = this.E;
            i2 = this.l.getMeasuredHeight();
            this.l.layout(paramInt3, paramInt2 - i2, i1 + paramInt3, paramInt2);
          }
          else
          {
            this.l.layout(this.j.x, this.j.y, this.j.x + this.l.getMeasuredWidth(), this.j.y + this.l.getMeasuredHeight());
          }
        }
        else
        {
          if (localView != this.m) {
            break label825;
          }
          a(this.m);
          paramInt2 = this.m.getMeasuredWidth();
          paramInt3 = r;
          this.m.layout(0, 0, paramInt2, paramInt3);
        }
      }
      localObject = localView.getLayoutParams();
    } while (!(localObject instanceof MapViewLayoutParams));
    MapViewLayoutParams localMapViewLayoutParams = (MapViewLayoutParams)localObject;
    if (localMapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode) {}
    for (Object localObject = localMapViewLayoutParams.b;; localObject = this.d.a().a((GeoPoint)localObject))
    {
      a(localView);
      paramInt2 = localView.getMeasuredWidth();
      paramInt3 = localView.getMeasuredHeight();
      f3 = localMapViewLayoutParams.d;
      float f4 = localMapViewLayoutParams.e;
      i1 = (int)(((Point)localObject).x - f3 * paramInt2);
      i2 = (int)(((Point)localObject).y - f4 * paramInt3);
      i2 = localMapViewLayoutParams.f + i2;
      localView.layout(i1, i2, i1 + paramInt2, i2 + paramInt3);
      break;
      localObject = CoordUtil.ll2mc(localMapViewLayoutParams.a);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if ((paramBundle == null) || (this.e == null)) {
      return;
    }
    paramBundle.putParcelable("mapstatus", this.e.getMapStatus());
    if (this.j != null) {
      paramBundle.putParcelable("scalePosition", this.j);
    }
    if (this.k != null) {
      paramBundle.putParcelable("zoomPosition", this.k);
    }
    paramBundle.putBoolean("mZoomControlEnabled", this.v);
    paramBundle.putBoolean("mScaleControlEnabled", this.w);
    paramBundle.putInt("paddingLeft", this.z);
    paramBundle.putInt("paddingTop", this.B);
    paramBundle.putInt("paddingRight", this.A);
    paramBundle.putInt("paddingBottom", this.C);
    paramBundle.putString("customMapPath", c);
  }
  
  public void removeView(View paramView)
  {
    if (paramView == this.f) {
      return;
    }
    super.removeView(paramView);
  }
  
  public void setOnDismissCallbackListener(OnDismissCallback paramOnDismissCallback)
  {
    if (this.m == null) {
      return;
    }
    this.m.setCallback(paramOnDismissCallback);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.z = paramInt1;
    this.B = paramInt2;
    this.A = paramInt3;
    this.C = paramInt4;
  }
  
  public void setScaleControlPosition(Point paramPoint)
  {
    if (paramPoint == null) {}
    while ((paramPoint.x < 0) || (paramPoint.y < 0) || (paramPoint.x > getWidth()) || (paramPoint.y > getHeight())) {
      return;
    }
    this.j = paramPoint;
    requestLayout();
  }
  
  public void setShape(a parama)
  {
    this.a = parama;
  }
  
  public void setViewAnimitionEnable(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setZoomControlsPosition(Point paramPoint)
  {
    if (paramPoint == null) {}
    while ((paramPoint.x < 0) || (paramPoint.y < 0) || (paramPoint.x > getWidth()) || (paramPoint.y > getHeight())) {
      return;
    }
    this.k = paramPoint;
    requestLayout();
  }
  
  public void showScaleControl(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.l;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localRelativeLayout.setVisibility(i1);
      this.w = paramBoolean;
      return;
    }
  }
  
  public void showZoomControls(boolean paramBoolean)
  {
    N localN;
    if (this.h.a())
    {
      localN = this.h;
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (int i1 = 0;; i1 = 8)
    {
      localN.setVisibility(i1);
      this.v = paramBoolean;
      return;
    }
  }
  
  public class AnimationTask
    extends TimerTask
  {
    public AnimationTask() {}
    
    public void run()
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      WearMapView.this.mTimerHandler.sendMessage(localMessage);
    }
  }
  
  public static abstract interface OnDismissCallback
  {
    public abstract void onDismiss();
    
    public abstract void onNotify();
  }
  
  static enum a
  {
    private a() {}
  }
  
  private class b
    extends Handler
  {
    private final WeakReference<Context> b;
    
    public b(Context paramContext)
    {
      this.b = new WeakReference(paramContext);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((Context)this.b.get() == null) {}
      do
      {
        return;
        super.handleMessage(paramMessage);
        switch (paramMessage.what)
        {
        default: 
          return;
        }
      } while (WearMapView.f(WearMapView.this) == null);
      WearMapView.a(WearMapView.this, true);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/WearMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */