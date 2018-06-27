package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;
import android.view.View.MeasureSpec;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.AssetsLoadUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BitmapDescriptorFactory
{
  static
  {
    if (!BitmapDescriptorFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static BitmapDescriptor fromAsset(String paramString)
  {
    Object localObject = BMapManager.getContext();
    if (localObject == null) {
      return null;
    }
    try
    {
      paramString = AssetsLoadUtil.loadAssetsFile(paramString, (Context)localObject);
      localObject = fromBitmap(paramString);
      if ((!a) && (paramString == null)) {
        throw new AssertionError();
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    paramString.recycle();
    return (BitmapDescriptor)localObject;
  }
  
  public static BitmapDescriptor fromAssetWithDpi(String paramString)
  {
    Object localObject = BMapManager.getContext();
    if (localObject == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap = AssetsLoadUtil.loadAssetsFile(paramString, (Context)localObject);
      if (localBitmap == null) {
        return null;
      }
      int i = SysOSUtil.getDensityDpi();
      if (i > 480)
      {
        paramString = new Matrix();
        paramString.postScale(2.0F, 2.0F);
        localObject = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramString, true);
        paramString = fromBitmap((Bitmap)localObject);
      }
      for (;;)
      {
        localBitmap.recycle();
        if (localObject == null) {
          break;
        }
        ((Bitmap)localObject).recycle();
        break;
        if ((i > 320) && (i <= 480))
        {
          paramString = new Matrix();
          paramString.postScale(1.5F, 1.5F);
          localObject = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramString, true);
          paramString = fromBitmap((Bitmap)localObject);
        }
        else
        {
          paramString = fromBitmap(localBitmap);
          localObject = null;
        }
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
  }
  
  public static BitmapDescriptor fromBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    return new BitmapDescriptor(paramBitmap);
  }
  
  public static BitmapDescriptor fromFile(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    try
    {
      Object localObject = BMapManager.getContext();
      if (localObject != null)
      {
        localObject = ((Context)localObject).openFileInput(paramString);
        paramString = BitmapFactory.decodeStream((InputStream)localObject);
        ((FileInputStream)localObject).close();
        if (paramString != null)
        {
          localObject = fromBitmap(paramString);
          paramString.recycle();
          return (BitmapDescriptor)localObject;
        }
      }
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static BitmapDescriptor fromPath(String paramString)
  {
    paramString = BitmapFactory.decodeFile(paramString);
    if ((paramString != null) && (paramString != null))
    {
      BitmapDescriptor localBitmapDescriptor = fromBitmap(paramString);
      paramString.recycle();
      return localBitmapDescriptor;
    }
    return null;
  }
  
  public static BitmapDescriptor fromResource(int paramInt)
  {
    Object localObject = BMapManager.getContext();
    if (localObject != null)
    {
      localObject = BitmapFactory.decodeResource(((Context)localObject).getResources(), paramInt);
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    BitmapDescriptor localBitmapDescriptor = fromBitmap((Bitmap)localObject);
    ((Bitmap)localObject).recycle();
    return localBitmapDescriptor;
  }
  
  public static BitmapDescriptor fromView(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    paramView.buildDrawingCache();
    Bitmap localBitmap = paramView.getDrawingCache();
    BitmapDescriptor localBitmapDescriptor = fromBitmap(localBitmap);
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    paramView.destroyDrawingCache();
    return localBitmapDescriptor;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/BitmapDescriptorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */