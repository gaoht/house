package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import java.util.Set;
import javax.annotation.Nullable;

public class PipelineDraweeControllerBuilderSupplier
  implements Supplier<PipelineDraweeControllerBuilder>
{
  private final Set<ControllerListener> mBoundControllerListeners;
  private final Context mContext;
  private final ImagePipeline mImagePipeline;
  private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;
  
  public PipelineDraweeControllerBuilderSupplier(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PipelineDraweeControllerBuilderSupplier(Context paramContext, @Nullable DraweeConfig paramDraweeConfig)
  {
    this(paramContext, ImagePipelineFactory.getInstance(), paramDraweeConfig);
  }
  
  public PipelineDraweeControllerBuilderSupplier(Context paramContext, ImagePipelineFactory paramImagePipelineFactory, @Nullable DraweeConfig paramDraweeConfig)
  {
    this(paramContext, paramImagePipelineFactory, null, paramDraweeConfig);
  }
  
  public PipelineDraweeControllerBuilderSupplier(Context paramContext, ImagePipelineFactory paramImagePipelineFactory, Set<ControllerListener> paramSet, @Nullable DraweeConfig paramDraweeConfig)
  {
    this.mContext = paramContext;
    this.mImagePipeline = paramImagePipelineFactory.getImagePipeline();
    paramImagePipelineFactory = paramImagePipelineFactory.getAnimatedFactory();
    if (paramImagePipelineFactory != null) {}
    for (paramImagePipelineFactory = paramImagePipelineFactory.getAnimatedDrawableFactory(paramContext);; paramImagePipelineFactory = null)
    {
      PipelineDraweeControllerFactory localPipelineDraweeControllerFactory;
      Resources localResources;
      DeferredReleaser localDeferredReleaser;
      UiThreadImmediateExecutorService localUiThreadImmediateExecutorService;
      MemoryCache localMemoryCache;
      if ((paramDraweeConfig != null) && (paramDraweeConfig.getPipelineDraweeControllerFactory() != null))
      {
        this.mPipelineDraweeControllerFactory = paramDraweeConfig.getPipelineDraweeControllerFactory();
        localPipelineDraweeControllerFactory = this.mPipelineDraweeControllerFactory;
        localResources = paramContext.getResources();
        localDeferredReleaser = DeferredReleaser.getInstance();
        localUiThreadImmediateExecutorService = UiThreadImmediateExecutorService.getInstance();
        localMemoryCache = this.mImagePipeline.getBitmapMemoryCache();
        if (paramDraweeConfig == null) {
          break label150;
        }
      }
      label150:
      for (paramContext = paramDraweeConfig.getCustomDrawableFactories();; paramContext = null)
      {
        if (paramDraweeConfig != null) {
          localSupplier = paramDraweeConfig.getDebugOverlayEnabledSupplier();
        }
        localPipelineDraweeControllerFactory.init(localResources, localDeferredReleaser, paramImagePipelineFactory, localUiThreadImmediateExecutorService, localMemoryCache, paramContext, localSupplier);
        this.mBoundControllerListeners = paramSet;
        return;
        this.mPipelineDraweeControllerFactory = new PipelineDraweeControllerFactory();
        break;
      }
    }
  }
  
  public PipelineDraweeControllerBuilder get()
  {
    return new PipelineDraweeControllerBuilder(this.mContext, this.mPipelineDraweeControllerFactory, this.mImagePipeline, this.mBoundControllerListeners);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilderSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */