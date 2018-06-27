package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.map.D;
import com.baidu.platform.comapi.map.e;
import com.baidu.platform.comapi.map.i;
import com.baidu.platform.comapi.map.k;
import javax.microedition.khronos.opengles.GL10;

class u
  implements k
{
  u(WearMapView paramWearMapView) {}
  
  public void a()
  {
    if ((WearMapView.a(this.a) == null) || (WearMapView.a(this.a).a() == null)) {
      return;
    }
    float f = WearMapView.a(this.a).a().D().a;
    int i;
    if (WearMapView.b(this.a) != f)
    {
      i = ((Integer)WearMapView.a().get((int)f)).intValue();
      int j = (int)(i / WearMapView.a(this.a).a().D().m);
      WearMapView.c(this.a).setPadding(j / 2, 0, j / 2, 0);
      if (i < 1000) {
        break label177;
      }
    }
    label177:
    for (String str = String.format(" %d公里 ", new Object[] { Integer.valueOf(i / 1000) });; str = String.format(" %d米 ", new Object[] { Integer.valueOf(i) }))
    {
      WearMapView.d(this.a).setText(str);
      WearMapView.e(this.a).setText(str);
      WearMapView.a(this.a, f);
      this.a.requestLayout();
      return;
    }
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(MotionEvent paramMotionEvent) {}
  
  public void a(GeoPoint paramGeoPoint) {}
  
  public void a(D paramD) {}
  
  public void a(String paramString) {}
  
  public void a(GL10 paramGL10, D paramD) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void b(GeoPoint paramGeoPoint) {}
  
  public void b(D paramD) {}
  
  public boolean b(String paramString)
  {
    return false;
  }
  
  public void c() {}
  
  public void c(GeoPoint paramGeoPoint) {}
  
  public void c(D paramD) {}
  
  public void d() {}
  
  public void d(GeoPoint paramGeoPoint) {}
  
  public void e() {}
  
  public void e(GeoPoint paramGeoPoint) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */