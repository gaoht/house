package com.baidu.mapapi.map;

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
import android.util.Log;
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
import com.baidu.platform.comapi.map.N;
import com.baidu.platform.comapi.map.e;
import java.io.File;

public final class MapView
  extends ViewGroup
{
  private static final String a = MapView.class.getSimpleName();
  private static String b;
  private static final SparseArray<Integer> n = new SparseArray();
  private com.baidu.platform.comapi.map.i c;
  private BaiduMap d;
  private ImageView e;
  private Bitmap f;
  private N g;
  private Point h;
  private Point i;
  private RelativeLayout j;
  private TextView k;
  private TextView l;
  private ImageView m;
  private int o = LogoPosition.logoPostionleftBottom.ordinal();
  private boolean p = true;
  private boolean q = true;
  private float r;
  private com.baidu.platform.comapi.map.k s;
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
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, null);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, null);
  }
  
  public MapView(Context paramContext, BaiduMapOptions paramBaiduMapOptions)
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
      this.f = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, true);
    }
    for (;;)
    {
      if (this.f != null)
      {
        this.e = new ImageView(paramContext);
        this.e.setImageBitmap(this.f);
        addView(this.e);
      }
      return;
      if ((i1 > 320) && (i1 <= 480))
      {
        localMatrix = new Matrix();
        localMatrix.postScale(1.5F, 1.5F);
        this.f = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, true);
      }
      else
      {
        this.f = ((Bitmap)localObject);
      }
    }
  }
  
  private void a(Context paramContext, BaiduMapOptions paramBaiduMapOptions)
  {
    BMapManager.init();
    a(paramContext, paramBaiduMapOptions, b);
    this.d = new BaiduMap(this.c);
    a(paramContext);
    b(paramContext);
    if ((paramBaiduMapOptions != null) && (!paramBaiduMapOptions.h)) {
      this.g.setVisibility(4);
    }
    c(paramContext);
    if ((paramBaiduMapOptions != null) && (!paramBaiduMapOptions.i)) {
      this.j.setVisibility(4);
    }
    if ((paramBaiduMapOptions != null) && (paramBaiduMapOptions.j != null)) {
      this.o = paramBaiduMapOptions.j.ordinal();
    }
    if ((paramBaiduMapOptions != null) && (paramBaiduMapOptions.l != null)) {
      this.i = paramBaiduMapOptions.l;
    }
    if ((paramBaiduMapOptions != null) && (paramBaiduMapOptions.k != null)) {
      this.h = paramBaiduMapOptions.k;
    }
  }
  
  private void a(Context paramContext, BaiduMapOptions paramBaiduMapOptions, String paramString)
  {
    if (paramBaiduMapOptions == null) {}
    for (this.c = new com.baidu.platform.comapi.map.i(paramContext, null, paramString);; this.c = new com.baidu.platform.comapi.map.i(paramContext, paramBaiduMapOptions.a(), paramString))
    {
      addView(this.c);
      this.s = new i(this);
      this.c.a().a(this.s);
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
        break label78;
      }
    }
    label78:
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
    float f1 = this.c.a().D().a;
    if (!this.g.a()) {
      return;
    }
    N localN = this.g;
    if (f1 <= this.c.a().b)
    {
      bool1 = false;
      localN.b(bool1);
      localN = this.g;
      if (f1 < this.c.a().a) {
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
    this.g = new N(paramContext, false);
    if (!this.g.a()) {
      return;
    }
    this.g.b(new j(this));
    this.g.a(new k(this));
    addView(this.g);
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
    b = paramString;
  }
  
  public static void setMapCustomEnable(boolean paramBoolean)
  {
    com.baidu.platform.comapi.map.i.a(paramBoolean);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof MapViewLayoutParams)) {
      super.addView(paramView, paramLayoutParams);
    }
  }
  
  public final LogoPosition getLogoPosition()
  {
    switch (this.o)
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
    this.d.a = this;
    return this.d;
  }
  
  public final int getMapLevel()
  {
    float f1 = this.c.a().D().a;
    return ((Integer)n.get((int)f1)).intValue();
  }
  
  public int getScaleControlViewHeight()
  {
    return this.x;
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
    b = paramBundle.getString("customMapPath");
    if (paramBundle == null)
    {
      a(paramContext, new BaiduMapOptions());
      return;
    }
    MapStatus localMapStatus = (MapStatus)paramBundle.getParcelable("mapstatus");
    if (this.h != null) {
      this.h = ((Point)paramBundle.getParcelable("scalePosition"));
    }
    if (this.i != null) {
      this.i = ((Point)paramBundle.getParcelable("zoomPosition"));
    }
    this.p = paramBundle.getBoolean("mZoomControlEnabled");
    this.q = paramBundle.getBoolean("mScaleControlEnabled");
    this.o = paramBundle.getInt("logoPosition");
    setPadding(paramBundle.getInt("paddingLeft"), paramBundle.getInt("paddingTop"), paramBundle.getInt("paddingRight"), paramBundle.getInt("paddingBottom"));
    a(paramContext, new BaiduMapOptions().mapStatus(localMapStatus));
  }
  
  public final void onDestroy()
  {
    this.c.b();
    if ((this.f != null) && (!this.f.isRecycled()))
    {
      this.f.recycle();
      this.f = null;
    }
    this.g.b();
    BMapManager.destroy();
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i2 = getChildCount();
    a(this.e);
    float f2;
    float f1;
    int i1;
    label113:
    View localView;
    if ((getWidth() - this.t - this.u - this.e.getMeasuredWidth() > 0) && (getHeight() - this.v - this.w - this.e.getMeasuredHeight() > 0))
    {
      f2 = (getWidth() - this.t - this.u) / getWidth();
      f1 = (getHeight() - this.v - this.w) / getHeight();
      i1 = 0;
      if (i1 >= i2) {
        return;
      }
      localView = getChildAt(i1);
      if (localView != null) {
        break label171;
      }
    }
    label171:
    label965:
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
        if (localView == this.c)
        {
          this.c.layout(0, 0, getWidth(), getHeight());
        }
        else
        {
          if (localView == this.e)
          {
            paramInt3 = (int)(this.t + 5.0F * f2);
            paramInt1 = (int)(this.u + 5.0F * f2);
            paramInt4 = (int)(this.v + 5.0F * f1);
            paramInt2 = (int)(this.w + 5.0F * f1);
            switch (this.o)
            {
            default: 
              paramInt2 = getHeight() - paramInt2;
              paramInt1 = this.e.getMeasuredWidth() + paramInt3;
              paramInt4 = paramInt2 - this.e.getMeasuredHeight();
            }
            for (;;)
            {
              this.e.layout(paramInt3, paramInt4, paramInt1, paramInt2);
              break;
              paramInt2 = paramInt4 + this.e.getMeasuredHeight();
              paramInt1 = this.e.getMeasuredWidth() + paramInt3;
              continue;
              paramInt2 = getHeight() - paramInt2;
              paramInt4 = paramInt2 - this.e.getMeasuredHeight();
              paramInt3 = (getWidth() - this.e.getMeasuredWidth() + this.t - this.u) / 2;
              paramInt1 = (getWidth() + this.e.getMeasuredWidth() + this.t - this.u) / 2;
              continue;
              paramInt2 = paramInt4 + this.e.getMeasuredHeight();
              paramInt3 = (getWidth() - this.e.getMeasuredWidth() + this.t - this.u) / 2;
              paramInt1 = (getWidth() + this.e.getMeasuredWidth() + this.t - this.u) / 2;
              continue;
              paramInt2 = getHeight() - paramInt2;
              paramInt4 = paramInt2 - this.e.getMeasuredHeight();
              paramInt1 = getWidth() - paramInt1;
              paramInt3 = paramInt1 - this.e.getMeasuredWidth();
              continue;
              paramInt2 = paramInt4 + this.e.getMeasuredHeight();
              paramInt1 = getWidth() - paramInt1;
              paramInt3 = paramInt1 - this.e.getMeasuredWidth();
            }
          }
          if (localView == this.g)
          {
            if (this.g.a())
            {
              a(this.g);
              if (this.i == null)
              {
                paramInt4 = (int)((getHeight() - 15) * f1 + this.v);
                int i3 = (int)((getWidth() - 15) * f2 + this.t);
                int i4 = this.g.getMeasuredWidth();
                paramInt3 = paramInt4 - this.g.getMeasuredHeight();
                paramInt2 = paramInt3;
                paramInt1 = paramInt4;
                if (this.o == 4)
                {
                  paramInt1 = paramInt4 - this.e.getMeasuredHeight();
                  paramInt2 = paramInt3 - this.e.getMeasuredHeight();
                }
                this.g.layout(i3 - i4, paramInt2, i3, paramInt1);
              }
              else
              {
                this.g.layout(this.i.x, this.i.y, this.i.x + this.g.getMeasuredWidth(), this.i.y + this.g.getMeasuredHeight());
              }
            }
          }
          else
          {
            if (localView != this.j) {
              break label965;
            }
            a(this.j);
            if (this.h == null)
            {
              paramInt2 = (int)(this.w + 5.0F * f1 + 56.0F);
              this.y = this.j.getMeasuredWidth();
              this.x = this.j.getMeasuredHeight();
              paramInt1 = (int)(this.t + 5.0F * f2);
              paramInt2 = getHeight() - paramInt2 - this.e.getMeasuredHeight();
              paramInt3 = this.y;
              paramInt4 = this.x;
              this.j.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
            }
            else
            {
              this.j.layout(this.h.x, this.h.y, this.h.x + this.j.getMeasuredWidth(), this.h.y + this.j.getMeasuredHeight());
            }
          }
        }
      }
      localObject = localView.getLayoutParams();
      if (localObject == null) {
        Log.e("test", "lp == null");
      }
    } while (!(localObject instanceof MapViewLayoutParams));
    MapViewLayoutParams localMapViewLayoutParams = (MapViewLayoutParams)localObject;
    if (localMapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode) {}
    for (Object localObject = localMapViewLayoutParams.b;; localObject = this.c.a().a((GeoPoint)localObject))
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
    this.c.onPause();
  }
  
  public final void onResume()
  {
    this.c.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if ((paramBundle == null) || (this.d == null)) {
      return;
    }
    paramBundle.putParcelable("mapstatus", this.d.getMapStatus());
    if (this.h != null) {
      paramBundle.putParcelable("scalePosition", this.h);
    }
    if (this.i != null) {
      paramBundle.putParcelable("zoomPosition", this.i);
    }
    paramBundle.putBoolean("mZoomControlEnabled", this.p);
    paramBundle.putBoolean("mScaleControlEnabled", this.q);
    paramBundle.putInt("logoPosition", this.o);
    paramBundle.putInt("paddingLeft", this.t);
    paramBundle.putInt("paddingTop", this.v);
    paramBundle.putInt("paddingRight", this.u);
    paramBundle.putInt("paddingBottom", this.w);
    paramBundle.putString("customMapPath", b);
  }
  
  public void removeView(View paramView)
  {
    if (paramView == this.e) {
      return;
    }
    super.removeView(paramView);
  }
  
  public final void setLogoPosition(LogoPosition paramLogoPosition)
  {
    if (paramLogoPosition == null) {
      this.o = LogoPosition.logoPostionleftBottom.ordinal();
    }
    this.o = paramLogoPosition.ordinal();
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
    this.h = paramPoint;
    requestLayout();
  }
  
  public void setZoomControlsPosition(Point paramPoint)
  {
    if (paramPoint == null) {}
    while ((paramPoint.x < 0) || (paramPoint.y < 0) || (paramPoint.x > getWidth()) || (paramPoint.y > getHeight())) {
      return;
    }
    this.i = paramPoint;
    requestLayout();
  }
  
  public void showScaleControl(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.j;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localRelativeLayout.setVisibility(i1);
      this.q = paramBoolean;
      return;
    }
  }
  
  public void showZoomControls(boolean paramBoolean)
  {
    N localN;
    if (this.g.a())
    {
      localN = this.g;
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (int i1 = 0;; i1 = 8)
    {
      localN.setVisibility(i1);
      this.p = paramBoolean;
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */