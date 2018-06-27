package com.ziroom.commonlib.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import java.io.File;

public class j
{
  private static AbstractDraweeControllerBuilder a(ControllerListener paramControllerListener, ImageRequest paramImageRequest)
  {
    if (paramControllerListener != null) {
      return ((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setImageRequest(paramImageRequest)).setControllerListener(paramControllerListener)).setAutoPlayAnimations(true);
    }
    return ((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setImageRequest(paramImageRequest)).setAutoPlayAnimations(true);
  }
  
  private static AbstractDraweeControllerBuilder a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, null, null, paramInt1, paramInt2);
  }
  
  private static AbstractDraweeControllerBuilder a(String paramString, ControllerListener paramControllerListener, Postprocessor paramPostprocessor)
  {
    return a(paramControllerListener, generateImageRequest(paramString, paramPostprocessor).build());
  }
  
  private static AbstractDraweeControllerBuilder a(String paramString, Postprocessor paramPostprocessor, ControllerListener paramControllerListener, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0)) {}
    for (paramString = generateImageRequest(paramString, paramPostprocessor).setResizeOptions(new ResizeOptions(paramInt1, paramInt2)).build();; paramString = generateImageRequest(paramString, paramPostprocessor).build()) {
      return a(paramControllerListener, paramString);
    }
  }
  
  public static AbstractDraweeController frescoController(String paramString)
  {
    return frescoController(paramString, null, null);
  }
  
  public static AbstractDraweeController frescoController(String paramString, ControllerListener paramControllerListener)
  {
    return frescoController(paramString, paramControllerListener, null);
  }
  
  public static AbstractDraweeController frescoController(String paramString, ControllerListener paramControllerListener, Postprocessor paramPostprocessor)
  {
    return generateController(paramControllerListener, generateImageRequest(paramString, paramPostprocessor).build());
  }
  
  public static AbstractDraweeController frescoController(String paramString, Postprocessor paramPostprocessor)
  {
    return frescoController(paramString, null, paramPostprocessor);
  }
  
  public static AbstractDraweeController frescoFromFileController(File paramFile)
  {
    return frescoFromFileController(paramFile, null);
  }
  
  public static AbstractDraweeController frescoFromFileController(File paramFile, ControllerListener paramControllerListener)
  {
    paramFile = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(paramFile)).setProgressiveRenderingEnabled(true).setAutoRotateEnabled(true).build();
    if (paramControllerListener != null) {
      return ((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true)).setImageRequest(paramFile)).setControllerListener(paramControllerListener)).build();
    }
    return ((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true)).setImageRequest(paramFile)).build();
  }
  
  public static AbstractDraweeController frescoFromResourceController(int paramInt)
  {
    return frescoFromResourceController(paramInt, null);
  }
  
  public static AbstractDraweeController frescoFromResourceController(int paramInt, ControllerListener paramControllerListener)
  {
    ImageRequest localImageRequest = ImageRequestBuilder.newBuilderWithResourceId(paramInt).setProgressiveRenderingEnabled(true).setAutoRotateEnabled(true).build();
    if (paramControllerListener != null) {
      return ((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setImageRequest(localImageRequest)).setControllerListener(paramControllerListener)).setAutoPlayAnimations(true)).build();
    }
    return ((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setImageRequest(localImageRequest)).setAutoPlayAnimations(true)).build();
  }
  
  public static void frescoHierarchyController(SimpleDraweeView paramSimpleDraweeView, int paramInt)
  {
    frescoHierarchyController(paramSimpleDraweeView, ScalingUtils.ScaleType.FIT_XY, paramInt);
  }
  
  public static void frescoHierarchyController(SimpleDraweeView paramSimpleDraweeView, ScalingUtils.ScaleType paramScaleType, int paramInt)
  {
    ((GenericDraweeHierarchy)paramSimpleDraweeView.getHierarchy()).setActualImageScaleType(paramScaleType);
    ((GenericDraweeHierarchy)paramSimpleDraweeView.getHierarchy()).setPlaceholderImage(paramInt, paramScaleType);
    ((GenericDraweeHierarchy)paramSimpleDraweeView.getHierarchy()).setFailureImage(paramInt, paramScaleType);
  }
  
  public static AbstractDraweeController frescoResizeController(String paramString, int paramInt1, int paramInt2)
  {
    return frescoResizeController(paramString, null, null, paramInt1, paramInt2);
  }
  
  public static AbstractDraweeController frescoResizeController(String paramString, ControllerListener paramControllerListener, int paramInt1, int paramInt2)
  {
    return frescoResizeController(paramString, null, paramControllerListener, paramInt1, paramInt2);
  }
  
  public static AbstractDraweeController frescoResizeController(String paramString, Postprocessor paramPostprocessor, int paramInt1, int paramInt2)
  {
    return frescoResizeController(paramString, paramPostprocessor, null, paramInt1, paramInt2);
  }
  
  public static AbstractDraweeController frescoResizeController(String paramString, Postprocessor paramPostprocessor, ControllerListener paramControllerListener, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0)) {}
    for (paramString = generateImageRequest(paramString, paramPostprocessor).setResizeOptions(new ResizeOptions(paramInt1, paramInt2)).build();; paramString = generateImageRequest(paramString, paramPostprocessor).build()) {
      return generateController(paramControllerListener, paramString);
    }
  }
  
  public static AbstractDraweeController generateController(ControllerListener paramControllerListener, ImageRequest paramImageRequest)
  {
    if (paramControllerListener != null) {
      return ((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setImageRequest(paramImageRequest)).setControllerListener(paramControllerListener)).setAutoPlayAnimations(true)).build();
    }
    return ((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setImageRequest(paramImageRequest)).setAutoPlayAnimations(true)).build();
  }
  
  public static ImageRequestBuilder generateImageRequest(String paramString, Postprocessor paramPostprocessor)
  {
    if (paramPostprocessor != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "";
      }
      return ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).setProgressiveRenderingEnabled(true).setPostprocessor(paramPostprocessor).setAutoRotateEnabled(true);
    }
    paramPostprocessor = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramPostprocessor = "";
    }
    return ImageRequestBuilder.newBuilderWithSource(Uri.parse(paramPostprocessor)).setProgressiveRenderingEnabled(true).setAutoRotateEnabled(true);
  }
  
  public static void loadHolderImage(SimpleDraweeView paramSimpleDraweeView, String paramString)
  {
    loadHolderImage(paramSimpleDraweeView, paramString, null, null);
  }
  
  public static void loadHolderImage(SimpleDraweeView paramSimpleDraweeView, String paramString, ControllerListener paramControllerListener)
  {
    loadHolderImage(paramSimpleDraweeView, paramString, paramControllerListener, null);
  }
  
  public static void loadHolderImage(SimpleDraweeView paramSimpleDraweeView, String paramString, ControllerListener paramControllerListener, Postprocessor paramPostprocessor)
  {
    if (paramSimpleDraweeView != null) {
      paramSimpleDraweeView.setController(a(paramString, paramControllerListener, paramPostprocessor).setOldController(paramSimpleDraweeView.getController()).build());
    }
  }
  
  public static void loadHolderImage(SimpleDraweeView paramSimpleDraweeView, String paramString, Postprocessor paramPostprocessor)
  {
    loadHolderImage(paramSimpleDraweeView, paramString, null, paramPostprocessor);
  }
  
  public static void loadHolderImageResize(SimpleDraweeView paramSimpleDraweeView, String paramString, int paramInt1, int paramInt2)
  {
    if (paramSimpleDraweeView != null) {
      paramSimpleDraweeView.setController(a(paramString, paramInt1, paramInt2).setOldController(paramSimpleDraweeView.getController()).build());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */