package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.widget.frescoview.ZoomableDraweeView;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b;
import com.ziroom.ziroomcustomer.minsu.f.k;
import java.io.File;

public class MinsuOnePicActivity
  extends BaseActivity
{
  private String a;
  private String b;
  
  private void a()
  {
    ZoomableDraweeView localZoomableDraweeView = (ZoomableDraweeView)findViewById(2131689744);
    int i = b.getScreenWidth(this);
    int j = b.getScreenHeight(this);
    if (i <= j) {}
    for (;;)
    {
      localZoomableDraweeView.getLayoutParams().width = i;
      localZoomableDraweeView.getLayoutParams().height = i;
      GenericDraweeHierarchy localGenericDraweeHierarchy = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(0).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
      Object localObject = ((FileBinaryResource)Fresco.getImagePipelineFactory().getMainFileCache().getResource(new SimpleCacheKey(Uri.parse(this.a).toString()))).getFile();
      if ((localObject != null) && (((File)localObject).exists()))
      {
        localObject = new BitmapDrawable(BitmapFactory.decodeFile(((File)localObject).getAbsolutePath()));
        if (localObject != null) {
          localGenericDraweeHierarchy.setPlaceholderImage((Drawable)localObject);
        }
      }
      localZoomableDraweeView.setHierarchy(localGenericDraweeHierarchy);
      localZoomableDraweeView.setController(((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setImageRequest(c.generateImageRequest(this.b, null).build())).setAutoPlayAnimations(false)).build());
      localZoomableDraweeView.setTapListener(new GestureDetector.SimpleOnGestureListener()
      {
        public boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
        {
          d.i("info", "onDoubleTap");
          MinsuOnePicActivity.this.finish();
          return true;
        }
        
        public boolean onDown(MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
        
        public boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
        {
          d.i("info", "onSingleTapConfirmed");
          return true;
        }
        
        public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
        {
          d.i("info", "onSingleTapUp");
          return true;
        }
      });
      return;
      i = j;
    }
  }
  
  public void finish()
  {
    super.finish();
    k.animFinishAlpha(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903318);
    this.a = getIntent().getStringExtra("url1");
    this.b = getIntent().getStringExtra("url2");
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuOnePicActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */