package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class PipelineDraweeController
  extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo>
{
  private static final Class<?> TAG = PipelineDraweeController.class;
  private final AnimatedDrawableFactory mAnimatedDrawableFactory;
  private CacheKey mCacheKey;
  private Supplier<DataSource<CloseableReference<CloseableImage>>> mDataSourceSupplier;
  private final DrawableFactory mDefaultDrawableFactory = new DrawableFactory()
  {
    public Drawable createDrawable(CloseableImage paramAnonymousCloseableImage)
    {
      if ((paramAnonymousCloseableImage instanceof CloseableStaticBitmap))
      {
        paramAnonymousCloseableImage = (CloseableStaticBitmap)paramAnonymousCloseableImage;
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(PipelineDraweeController.this.mResources, paramAnonymousCloseableImage.getUnderlyingBitmap());
        if ((paramAnonymousCloseableImage.getRotationAngle() == 0) || (paramAnonymousCloseableImage.getRotationAngle() == -1)) {
          return localBitmapDrawable;
        }
        return new OrientedDrawable(localBitmapDrawable, paramAnonymousCloseableImage.getRotationAngle());
      }
      if (PipelineDraweeController.this.mAnimatedDrawableFactory != null) {
        return PipelineDraweeController.this.mAnimatedDrawableFactory.create(paramAnonymousCloseableImage);
      }
      return null;
    }
    
    public boolean supportsImageType(CloseableImage paramAnonymousCloseableImage)
    {
      return true;
    }
  };
  private boolean mDrawDebugOverlay;
  @Nullable
  private final ImmutableList<DrawableFactory> mDrawableFactories;
  @Nullable
  private MemoryCache<CacheKey, CloseableImage> mMemoryCache;
  private final Resources mResources;
  
  public PipelineDraweeController(Resources paramResources, DeferredReleaser paramDeferredReleaser, AnimatedDrawableFactory paramAnimatedDrawableFactory, Executor paramExecutor, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier, String paramString, CacheKey paramCacheKey, Object paramObject)
  {
    this(paramResources, paramDeferredReleaser, paramAnimatedDrawableFactory, paramExecutor, paramMemoryCache, paramSupplier, paramString, paramCacheKey, paramObject, null);
  }
  
  public PipelineDraweeController(Resources paramResources, DeferredReleaser paramDeferredReleaser, AnimatedDrawableFactory paramAnimatedDrawableFactory, Executor paramExecutor, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier, String paramString, CacheKey paramCacheKey, Object paramObject, @Nullable ImmutableList<DrawableFactory> paramImmutableList)
  {
    super(paramDeferredReleaser, paramExecutor, paramString, paramObject);
    this.mResources = paramResources;
    this.mAnimatedDrawableFactory = paramAnimatedDrawableFactory;
    this.mMemoryCache = paramMemoryCache;
    this.mCacheKey = paramCacheKey;
    this.mDrawableFactories = paramImmutableList;
    init(paramSupplier);
  }
  
  private void init(Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier)
  {
    this.mDataSourceSupplier = paramSupplier;
    maybeUpdateDebugOverlay(null);
  }
  
  private void maybeUpdateDebugOverlay(@Nullable CloseableImage paramCloseableImage)
  {
    Object localObject2 = null;
    if (!this.mDrawDebugOverlay) {}
    do
    {
      return;
      localObject3 = getControllerOverlay();
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new DebugControllerOverlayDrawable();
        setControllerOverlay((Drawable)localObject1);
      }
    } while (!(localObject1 instanceof DebugControllerOverlayDrawable));
    Object localObject3 = (DebugControllerOverlayDrawable)localObject1;
    ((DebugControllerOverlayDrawable)localObject3).setControllerId(getId());
    Object localObject4 = getHierarchy();
    Object localObject1 = localObject2;
    if (localObject4 != null)
    {
      localObject4 = ScalingUtils.getActiveScaleTypeDrawable(((DraweeHierarchy)localObject4).getTopLevelDrawable());
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = ((ScaleTypeDrawable)localObject4).getScaleType();
      }
    }
    ((DebugControllerOverlayDrawable)localObject3).setScaleType((ScalingUtils.ScaleType)localObject1);
    if (paramCloseableImage != null)
    {
      ((DebugControllerOverlayDrawable)localObject3).setDimensions(paramCloseableImage.getWidth(), paramCloseableImage.getHeight());
      ((DebugControllerOverlayDrawable)localObject3).setImageSize(paramCloseableImage.getSizeInBytes());
      return;
    }
    ((DebugControllerOverlayDrawable)localObject3).reset();
  }
  
  protected Drawable createDrawable(CloseableReference<CloseableImage> paramCloseableReference)
  {
    Preconditions.checkState(CloseableReference.isValid(paramCloseableReference));
    paramCloseableReference = (CloseableImage)paramCloseableReference.get();
    maybeUpdateDebugOverlay(paramCloseableReference);
    if (this.mDrawableFactories != null)
    {
      localObject1 = this.mDrawableFactories.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (DrawableFactory)((Iterator)localObject1).next();
        if (((DrawableFactory)localObject2).supportsImageType(paramCloseableReference))
        {
          localObject2 = ((DrawableFactory)localObject2).createDrawable(paramCloseableReference);
          if (localObject2 != null) {
            return (Drawable)localObject2;
          }
        }
      }
    }
    Object localObject1 = this.mDefaultDrawableFactory.createDrawable(paramCloseableReference);
    if (localObject1 != null) {
      return (Drawable)localObject1;
    }
    throw new UnsupportedOperationException("Unrecognized image class: " + paramCloseableReference);
  }
  
  protected CloseableReference<CloseableImage> getCachedImage()
  {
    if ((this.mMemoryCache == null) || (this.mCacheKey == null)) {
      return null;
    }
    CloseableReference localCloseableReference = this.mMemoryCache.get(this.mCacheKey);
    if ((localCloseableReference != null) && (!((CloseableImage)localCloseableReference.get()).getQualityInfo().isOfFullQuality()))
    {
      localCloseableReference.close();
      return null;
    }
    return localCloseableReference;
  }
  
  protected DataSource<CloseableReference<CloseableImage>> getDataSource()
  {
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
    }
    return (DataSource)this.mDataSourceSupplier.get();
  }
  
  protected int getImageHash(@Nullable CloseableReference<CloseableImage> paramCloseableReference)
  {
    if (paramCloseableReference != null) {
      return paramCloseableReference.getValueHash();
    }
    return 0;
  }
  
  protected ImageInfo getImageInfo(CloseableReference<CloseableImage> paramCloseableReference)
  {
    Preconditions.checkState(CloseableReference.isValid(paramCloseableReference));
    return (ImageInfo)paramCloseableReference.get();
  }
  
  protected Resources getResources()
  {
    return this.mResources;
  }
  
  public void initialize(Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier, String paramString, CacheKey paramCacheKey, Object paramObject)
  {
    super.initialize(paramString, paramObject);
    init(paramSupplier);
    this.mCacheKey = paramCacheKey;
  }
  
  protected void releaseDrawable(@Nullable Drawable paramDrawable)
  {
    if ((paramDrawable instanceof DrawableWithCaches)) {
      ((DrawableWithCaches)paramDrawable).dropCaches();
    }
  }
  
  protected void releaseImage(@Nullable CloseableReference<CloseableImage> paramCloseableReference)
  {
    CloseableReference.closeSafely(paramCloseableReference);
  }
  
  public void setDrawDebugOverlay(boolean paramBoolean)
  {
    this.mDrawDebugOverlay = paramBoolean;
  }
  
  public void setHierarchy(@Nullable DraweeHierarchy paramDraweeHierarchy)
  {
    super.setHierarchy(paramDraweeHierarchy);
    maybeUpdateDebugOverlay(null);
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", this.mDataSourceSupplier).toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/drawee/backends/pipeline/PipelineDraweeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */