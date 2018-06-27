package com.baidu.mapapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
import com.baidu.platform.comapi.map.E;
import com.baidu.platform.comapi.map.N;
import com.baidu.platform.comapi.map.e;
import com.baidu.platform.comapi.map.k;
import java.io.File;

public final class TextureMapView
  extends ViewGroup
{
  private static final String a = TextureMapView.class.getSimpleName();
  private static String i;
  private static final SparseArray<Integer> n = new SparseArray();
  private E b;
  private BaiduMap c;
  private ImageView d;
  private Bitmap e;
  private N f;
  private Point g;
  private Point h;
  private RelativeLayout j;
  private TextView k;
  private TextView l;
  private ImageView m;
  private float o;
  private k p;
  private int q = LogoPosition.logoPostionleftBottom.ordinal();
  private boolean r = true;
  private boolean s = true;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  
  static
  {
    n.append(3, Integer.valueOf(2000000));
    n.append(4, Integer.valueOf(1000000));
    n.append(5, Integer.valueOf(500000));
    n.append(6, Integer.valueOf(200000));
    n.append(7, Integer.valueOf(100000));
    n.append(8, Integer.valueOf(50000));
    n.append(9, Integer.valueOf(25000));
    n.append(10, Integer.valueOf(20000));
    n.append(11, Integer.valueOf(10000));
    n.append(12, Integer.valueOf(5000));
    n.append(13, Integer.valueOf(2000));
    n.append(14, Integer.valueOf(1000));
    n.append(15, Integer.valueOf(500));
    n.append(16, Integer.valueOf(200));
    n.append(17, Integer.valueOf(100));
    n.append(18, Integer.valueOf(50));
    n.append(19, Integer.valueOf(20));
    n.append(20, Integer.valueOf(10));
    n.append(21, Integer.valueOf(5));
    n.append(22, Integer.valueOf(2));
  }
  
  public TextureMapView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public TextureMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, null);
  }
  
  public TextureMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, null);
  }
  
  public TextureMapView(Context paramContext, BaiduMapOptions paramBaiduMapOptions)
  {
    super(paramContext);
    a(paramContext, paramBaiduMapOptions);
  }
  
  private void a(Context paramContext)
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
      this.e = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, true);
    }
    for (;;)
    {
      if (this.e != null)
      {
        this.d = new ImageView(paramContext);
        this.d.setImageBitmap(this.e);
        addView(this.d);
      }
      return;
      if ((i1 > 320) && (i1 <= 480))
      {
        localMatrix = new Matrix();
        localMatrix.postScale(1.5F, 1.5F);
        this.e = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, true);
      }
      else
      {
        this.e = ((Bitmap)localObject);
      }
    }
  }
  
  private void a(Context paramContext, BaiduMapOptions paramBaiduMapOptions)
  {
    setBackgroundColor(-1);
    BMapManager.init();
    a(paramContext, paramBaiduMapOptions, i);
    this.c = new BaiduMap(this.b);
    a(paramContext);
    b(paramContext);
    if ((paramBaiduMapOptions != null) && (!paramBaiduMapOptions.h)) {
      this.f.setVisibility(4);
    }
    c(paramContext);
    if ((paramBaiduMapOptions != null) && (!paramBaiduMapOptions.i)) {
      this.j.setVisibility(4);
    }
    if ((paramBaiduMapOptions != null) && (paramBaiduMapOptions.j != null)) {
      this.q = paramBaiduMapOptions.j.ordinal();
    }
    if ((paramBaiduMapOptions != null) && (paramBaiduMapOptions.l != null)) {
      this.h = paramBaiduMapOptions.l;
    }
    if ((paramBaiduMapOptions != null) && (paramBaiduMapOptions.k != null)) {
      this.g = paramBaiduMapOptions.k;
    }
  }
  
  private void a(Context paramContext, BaiduMapOptions paramBaiduMapOptions, String paramString)
  {
    i = paramString;
    if (paramBaiduMapOptions == null) {}
    for (this.b = new E(paramContext, null, paramString);; this.b = new E(paramContext, paramBaiduMapOptions.a(), paramString))
    {
      addView(this.b);
      this.p = new q(this);
      this.b.b().a(this.p);
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
  
  private void b()
  {
    boolean bool2 = false;
    float f1 = this.b.b().D().a;
    if (!this.f.a()) {
      return;
    }
    N localN = this.f;
    if (f1 <= this.b.b().b)
    {
      bool1 = false;
      localN.b(bool1);
      localN = this.f;
      if (f1 < this.b.b().a) {
        break label91;
      }
    }
    label91:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      localN.a(bool1);
      return;
      bool1 = true;
      break;
    }
  }
  
  private void b(Context paramContext)
  {
    this.f = new N(paramContext);
    if (!this.f.a()) {
      return;
    }
    this.f.b(new r(this));
    this.f.a(new s(this));
    addView(this.f);
  }
  
  private void c(Context paramContext)
  {
    this.j = new RelativeLayout(paramContext);
    Object localObject = new ViewGroup.LayoutParams(-2, -2);
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.k = new TextView(paramContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.k.setTextColor(Color.parseColor("#FFFFFF"));
    this.k.setTextSize(2, 11.0F);
    this.k.setTypeface(this.k.getTypeface(), 1);
    this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.k.setId(Integer.MAX_VALUE);
    this.j.addView(this.k);
    this.l = new TextView(paramContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.l.setTextColor(Color.parseColor("#000000"));
    this.l.setTextSize(2, 11.0F);
    this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.j.addView(this.l);
    this.m = new ImageView(paramContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, this.k.getId());
    this.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramContext = AssetsLoadUtil.loadAssetsFile("icon_scale.9.png", paramContext);
    localObject = paramContext.getNinePatchChunk();
    NinePatch.isNinePatchChunk((byte[])localObject);
    paramContext = new NinePatchDrawable(paramContext, (byte[])localObject, new Rect(), null);
    this.m.setBackgroundDrawable(paramContext);
    this.j.addView(this.m);
    addView(this.j);
  }
  
  public static void setCustomMapStylePath(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new RuntimeException("customMapStylePath String is illegal");
    }
    if (!new File(paramString).exists()) {
      throw new RuntimeException("please check whether the customMapStylePath file exits");
    }
    i = paramString;
  }
  
  public static void setMapCustomEnable(boolean paramBoolean)
  {
    E.a(paramBoolean);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof MapViewLayoutParams)) {
      super.addView(paramView, paramLayoutParams);
    }
  }
  
  public final LogoPosition getLogoPosition()
  {
    switch (this.q)
    {
    default: 
      return LogoPosition.logoPostionleftBottom;
    case 1: 
      return LogoPosition.logoPostionleftTop;
    case 2: 
      return LogoPosition.logoPostionCenterBottom;
    case 3: 
      return LogoPosition.logoPostionCenterTop;
    case 4: 
      return LogoPosition.logoPostionRightBottom;
    }
    return LogoPosition.logoPostionRightTop;
  }
  
  public final BaiduMap getMap()
  {
    this.c.b = this;
    return this.c;
  }
  
  public final int getMapLevel()
  {
    float f1 = this.b.b().D().a;
    return ((Integer)n.get((int)f1)).intValue();
  }
  
  public int getScaleControlViewHeight()
  {
    return this.y;
  }
  
  public int getScaleControlViewWidth()
  {
    return this.y;
  }
  
  public void onCreate(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    i = paramBundle.getString("customMapPath");
    if (paramBundle == null)
    {
      a(paramContext, new BaiduMapOptions());
      return;
    }
    MapStatus localMapStatus = (MapStatus)paramBundle.getParcelable("mapstatus");
    if (this.g != null) {
      this.g = ((Point)paramBundle.getParcelable("scalePosition"));
    }
    if (this.h != null) {
      this.h = ((Point)paramBundle.getParcelable("zoomPosition"));
    }
    this.r = paramBundle.getBoolean("mZoomControlEnabled");
    this.s = paramBundle.getBoolean("mScaleControlEnabled");
    this.q = paramBundle.getInt("logoPosition");
    setPadding(paramBundle.getInt("paddingLeft"), paramBundle.getInt("paddingTop"), paramBundle.getInt("paddingRight"), paramBundle.getInt("paddingBottom"));
    a(paramContext, new BaiduMapOptions().mapStatus(localMapStatus));
  }
  
  public final void onDestroy()
  {
    this.b.e();
    if ((this.e != null) && (!this.e.isRecycled())) {
      this.e.recycle();
    }
    this.f.b();
    BMapManager.destroy();
  }
  
  @SuppressLint({"NewApi"})
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = getChildCount();
    a(this.d);
    float f2;
    float f1;
    int i1;
    label113:
    View localView;
    if ((getWidth() - this.t - this.u - this.d.getMeasuredWidth() > 0) && (getHeight() - this.v - this.w - this.d.getMeasuredHeight() > 0))
    {
      f2 = (getWidth() - this.t - this.u) / getWidth();
      f1 = (getHeight() - this.v - this.w) / getHeight();
      i1 = 0;
      if (i1 >= i2) {
        return;
      }
      localView = getChildAt(i1);
      if (localView != this.b) {
        break label192;
      }
      this.b.layout(0, 0, getWidth(), getHeight());
    }
    label192:
    label957:
    do
    {
      for (;;)
      {
        i1 += 1;
        break label113;
        this.t = 0;
        this.u = 0;
        this.w = 0;
        this.v = 0;
        f2 = 1.0F;
        f1 = 1.0F;
        break;
        if (localView == this.d)
        {
          paramInt3 = (int)(this.t + 5.0F * f2);
          paramInt1 = (int)(this.u + 5.0F * f2);
          paramInt4 = (int)(this.v + 5.0F * f1);
          paramInt2 = (int)(this.w + 5.0F * f1);
          switch (this.q)
          {
          default: 
            paramInt2 = getHeight() - paramInt2;
            paramInt1 = this.d.getMeasuredWidth() + paramInt3;
            paramInt4 = paramInt2 - this.d.getMeasuredHeight();
          }
          for (;;)
          {
            this.d.layout(paramInt3, paramInt4, paramInt1, paramInt2);
            break;
            paramInt2 = paramInt4 + this.d.getMeasuredHeight();
            paramInt1 = this.d.getMeasuredWidth() + paramInt3;
            continue;
            paramInt2 = getHeight() - paramInt2;
            paramInt4 = paramInt2 - this.d.getMeasuredHeight();
            paramInt3 = (getWidth() - this.d.getMeasuredWidth() + this.t - this.u) / 2;
            paramInt1 = (getWidth() + this.d.getMeasuredWidth() + this.t - this.u) / 2;
            continue;
            paramInt2 = paramInt4 + this.d.getMeasuredHeight();
            paramInt3 = (getWidth() - this.d.getMeasuredWidth() + this.t - this.u) / 2;
            paramInt1 = (getWidth() + this.d.getMeasuredWidth() + this.t - this.u) / 2;
            continue;
            paramInt2 = getHeight() - paramInt2;
            paramInt4 = paramInt2 - this.d.getMeasuredHeight();
            paramInt1 = getWidth() - paramInt1;
            paramInt3 = paramInt1 - this.d.getMeasuredWidth();
            continue;
            paramInt2 = paramInt4 + this.d.getMeasuredHeight();
            paramInt1 = getWidth() - paramInt1;
            paramInt3 = paramInt1 - this.d.getMeasuredWidth();
          }
        }
        if (localView == this.f)
        {
          if (this.f.a())
          {
            a(this.f);
            if (this.h == null)
            {
              paramInt4 = (int)((getHeight() - 15) * f1 + this.v);
              int i3 = (int)((getWidth() - 15) * f2 + this.t);
              int i4 = this.f.getMeasuredWidth();
              paramInt3 = paramInt4 - this.f.getMeasuredHeight();
              paramInt2 = paramInt3;
              paramInt1 = paramInt4;
              if (this.q == 4)
              {
                paramInt1 = paramInt4 - this.d.getMeasuredHeight();
                paramInt2 = paramInt3 - this.d.getMeasuredHeight();
              }
              this.f.layout(i3 - i4, paramInt2, i3, paramInt1);
            }
            else
            {
              this.f.layout(this.h.x, this.h.y, this.h.x + this.f.getMeasuredWidth(), this.h.y + this.f.getMeasuredHeight());
            }
          }
        }
        else
        {
          if (localView != this.j) {
            break label957;
          }
          a(this.j);
          if (this.g == null)
          {
            paramInt2 = (int)(this.w + 5.0F * f1 + 56.0F);
            this.y = this.j.getMeasuredWidth();
            this.x = this.j.getMeasuredHeight();
            paramInt1 = (int)(this.t + 5.0F * f2);
            paramInt2 = getHeight() - paramInt2 - this.d.getMeasuredHeight();
            paramInt3 = this.y;
            paramInt4 = this.x;
            this.j.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
          }
          else
          {
            this.j.layout(this.g.x, this.g.y, this.g.x + this.j.getMeasuredWidth(), this.g.y + this.j.getMeasuredHeight());
          }
        }
      }
      localObject = localView.getLayoutParams();
    } while (!(localObject instanceof MapViewLayoutParams));
    MapViewLayoutParams localMapViewLayoutParams = (MapViewLayoutParams)localObject;
    if (localMapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode) {}
    for (Object localObject = localMapViewLayoutParams.b;; localObject = this.b.b().a((GeoPoint)localObject))
    {
      a(localView);
      paramInt1 = localView.getMeasuredWidth();
      paramInt2 = localView.getMeasuredHeight();
      float f3 = localMapViewLayoutParams.d;
      float f4 = localMapViewLayoutParams.e;
      paramInt3 = (int)(((Point)localObject).x - f3 * paramInt1);
      paramInt4 = (int)(((Point)localObject).y - f4 * paramInt2);
      paramInt4 = localMapViewLayoutParams.f + paramInt4;
      localView.layout(paramInt3, paramInt4, paramInt3 + paramInt1, paramInt4 + paramInt2);
      break;
      localObject = CoordUtil.ll2mc(localMapViewLayoutParams.a);
    }
  }
  
  public final void onPause()
  {
    this.b.d();
  }
  
  public final void onResume()
  {
    this.b.c();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if ((paramBundle == null) || (this.c == null)) {
      return;
    }
    paramBundle.putParcelable("mapstatus", this.c.getMapStatus());
    if (this.g != null) {
      paramBundle.putParcelable("scalePosition", this.g);
    }
    if (this.h != null) {
      paramBundle.putParcelable("zoomPosition", this.h);
    }
    paramBundle.putBoolean("mZoomControlEnabled", this.r);
    paramBundle.putBoolean("mScaleControlEnabled", this.s);
    paramBundle.putInt("logoPosition", this.q);
    paramBundle.putInt("paddingLeft", this.t);
    paramBundle.putInt("paddingTop", this.v);
    paramBundle.putInt("paddingRight", this.u);
    paramBundle.putInt("paddingBottom", this.w);
    paramBundle.putString("customMapPath", i);
  }
  
  public void removeView(View paramView)
  {
    if (paramView == this.d) {
      return;
    }
    super.removeView(paramView);
  }
  
  public final void setLogoPosition(LogoPosition paramLogoPosition)
  {
    if (paramLogoPosition == null) {
      this.q = LogoPosition.logoPostionleftBottom.ordinal();
    }
    this.q = paramLogoPosition.ordinal();
    requestLayout();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.t = paramInt1;
    this.v = paramInt2;
    this.u = paramInt3;
    this.w = paramInt4;
  }
  
  public void setScaleControlPosition(Point paramPoint)
  {
    if (paramPoint == null) {}
    while ((paramPoint.x < 0) || (paramPoint.y < 0) || (paramPoint.x > getWidth()) || (paramPoint.y > getHeight())) {
      return;
    }
    this.g = paramPoint;
    requestLayout();
  }
  
  public void setZoomControlsPosition(Point paramPoint)
  {
    if (paramPoint == null) {}
    while ((paramPoint.x < 0) || (paramPoint.y < 0) || (paramPoint.x > getWidth()) || (paramPoint.y > getHeight())) {
      return;
    }
    this.h = paramPoint;
    requestLayout();
  }
  
  public void showScaleControl(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.j;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localRelativeLayout.setVisibility(i1);
      this.s = paramBoolean;
      return;
    }
  }
  
  public void showZoomControls(boolean paramBoolean)
  {
    N localN;
    if (this.f.a())
    {
      localN = this.f;
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (int i1 = 0;; i1 = 8)
    {
      localN.setVisibility(i1);
      this.r = paramBoolean;
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/TextureMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */