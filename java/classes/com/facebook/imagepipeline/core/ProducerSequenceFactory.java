package com.facebook.imagepipeline.core;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.HashMap;
import java.util.Map;

public class ProducerSequenceFactory
{
  @VisibleForTesting
  Producer<EncodedImage> mBackgroundLocalFileFetchToEncodedMemorySequence;
  @VisibleForTesting
  Producer<EncodedImage> mBackgroundNetworkFetchToEncodedMemorySequence;
  @VisibleForTesting
  Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> mCloseableImagePrefetchSequences;
  private Producer<EncodedImage> mCommonNetworkFetchToEncodedMemorySequence;
  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mDataFetchSequence;
  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalAssetFetchSequence;
  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalContentUriFetchSequence;
  @VisibleForTesting
  Producer<CloseableReference<PooledByteBuffer>> mLocalFileEncodedImageProducerSequence;
  @VisibleForTesting
  Producer<Void> mLocalFileFetchToEncodedMemoryPrefetchSequence;
  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalImageFileFetchSequence;
  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalResourceFetchSequence;
  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalVideoFileFetchSequence;
  @VisibleForTesting
  Producer<CloseableReference<PooledByteBuffer>> mNetworkEncodedImageProducerSequence;
  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mNetworkFetchSequence;
  @VisibleForTesting
  Producer<Void> mNetworkFetchToEncodedMemoryPrefetchSequence;
  private final NetworkFetcher mNetworkFetcher;
  @VisibleForTesting
  Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mPostprocessorSequences;
  private final ProducerFactory mProducerFactory;
  private final boolean mResizeAndRotateEnabledForNetwork;
  private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
  private final boolean mUseDownsamplingRatio;
  private final boolean mWebpSupportEnabled;
  
  public ProducerSequenceFactory(ProducerFactory paramProducerFactory, NetworkFetcher paramNetworkFetcher, boolean paramBoolean1, boolean paramBoolean2, ThreadHandoffProducerQueue paramThreadHandoffProducerQueue, boolean paramBoolean3)
  {
    this.mProducerFactory = paramProducerFactory;
    this.mNetworkFetcher = paramNetworkFetcher;
    this.mResizeAndRotateEnabledForNetwork = paramBoolean1;
    this.mWebpSupportEnabled = paramBoolean2;
    this.mPostprocessorSequences = new HashMap();
    this.mCloseableImagePrefetchSequences = new HashMap();
    this.mThreadHandoffProducerQueue = paramThreadHandoffProducerQueue;
    this.mUseDownsamplingRatio = paramBoolean3;
  }
  
  private Producer<EncodedImage> getBackgroundLocalFileFetchToEncodeMemorySequence()
  {
    try
    {
      if (this.mBackgroundLocalFileFetchToEncodedMemorySequence == null)
      {
        localProducer = newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newLocalFileFetchProducer());
        this.mBackgroundLocalFileFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(localProducer, this.mThreadHandoffProducerQueue);
      }
      Producer localProducer = this.mBackgroundLocalFileFetchToEncodedMemorySequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<EncodedImage> getBackgroundNetworkFetchToEncodedMemorySequence()
  {
    try
    {
      if (this.mBackgroundNetworkFetchToEncodedMemorySequence == null) {
        this.mBackgroundNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(getCommonNetworkFetchToEncodedMemorySequence(), this.mThreadHandoffProducerQueue);
      }
      Producer localProducer = this.mBackgroundNetworkFetchToEncodedMemorySequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getBasicDecodedImageSequence(ImageRequest paramImageRequest)
  {
    Preconditions.checkNotNull(paramImageRequest);
    paramImageRequest = paramImageRequest.getSourceUri();
    Preconditions.checkNotNull(paramImageRequest, "Uri is null.");
    if (UriUtil.isNetworkUri(paramImageRequest)) {
      return getNetworkFetchSequence();
    }
    if (UriUtil.isLocalFileUri(paramImageRequest))
    {
      if (MediaUtils.isVideo(MediaUtils.extractMime(paramImageRequest.getPath()))) {
        return getLocalVideoFileFetchSequence();
      }
      return getLocalImageFileFetchSequence();
    }
    if (UriUtil.isLocalContentUri(paramImageRequest)) {
      return getLocalContentUriFetchSequence();
    }
    if (UriUtil.isLocalAssetUri(paramImageRequest)) {
      return getLocalAssetFetchSequence();
    }
    if (UriUtil.isLocalResourceUri(paramImageRequest)) {
      return getLocalResourceFetchSequence();
    }
    if (UriUtil.isDataUri(paramImageRequest)) {
      return getDataFetchSequence();
    }
    throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + getShortenedUriString(paramImageRequest));
  }
  
  private Producer<EncodedImage> getCommonNetworkFetchToEncodedMemorySequence()
  {
    try
    {
      if (this.mCommonNetworkFetchToEncodedMemorySequence == null)
      {
        this.mCommonNetworkFetchToEncodedMemorySequence = ProducerFactory.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newNetworkFetchProducer(this.mNetworkFetcher)));
        this.mCommonNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newResizeAndRotateProducer(this.mCommonNetworkFetchToEncodedMemorySequence, this.mResizeAndRotateEnabledForNetwork, this.mUseDownsamplingRatio);
      }
      Producer localProducer = this.mCommonNetworkFetchToEncodedMemorySequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getDataFetchSequence()
  {
    try
    {
      if (this.mDataFetchSequence == null)
      {
        Object localObject3 = this.mProducerFactory.newDataFetchProducer();
        localObject1 = localObject3;
        if (WebpSupportStatus.sIsWebpSupportRequired) {
          if (this.mWebpSupportEnabled)
          {
            localObject1 = localObject3;
            if (WebpSupportStatus.sWebpBitmapFactory != null) {}
          }
          else
          {
            localObject1 = this.mProducerFactory.newWebpTranscodeProducer((Producer)localObject3);
          }
        }
        localObject3 = this.mProducerFactory;
        localObject1 = ProducerFactory.newAddImageTransformMetaDataProducer((Producer)localObject1);
        this.mDataFetchSequence = newBitmapCacheGetToDecodeSequence(this.mProducerFactory.newResizeAndRotateProducer((Producer)localObject1, true, this.mUseDownsamplingRatio));
      }
      Object localObject1 = this.mDataFetchSequence;
      return (Producer<CloseableReference<CloseableImage>>)localObject1;
    }
    finally {}
  }
  
  private Producer<Void> getDecodedImagePrefetchSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    try
    {
      if (!this.mCloseableImagePrefetchSequences.containsKey(paramProducer))
      {
        Object localObject = this.mProducerFactory;
        localObject = ProducerFactory.newSwallowResultProducer(paramProducer);
        this.mCloseableImagePrefetchSequences.put(paramProducer, localObject);
      }
      paramProducer = (Producer)this.mCloseableImagePrefetchSequences.get(paramProducer);
      return paramProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalAssetFetchSequence()
  {
    try
    {
      if (this.mLocalAssetFetchSequence == null) {
        this.mLocalAssetFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalAssetFetchProducer());
      }
      Producer localProducer = this.mLocalAssetFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalContentUriFetchSequence()
  {
    try
    {
      if (this.mLocalContentUriFetchSequence == null) {
        this.mLocalContentUriFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalContentUriFetchProducer(), new ThumbnailProducer[] { this.mProducerFactory.newLocalContentUriThumbnailFetchProducer(), this.mProducerFactory.newLocalExifThumbnailProducer() });
      }
      Producer localProducer = this.mLocalContentUriFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<Void> getLocalFileFetchToEncodedMemoryPrefetchSequence()
  {
    try
    {
      if (this.mLocalFileFetchToEncodedMemoryPrefetchSequence == null) {
        this.mLocalFileFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
      }
      Producer localProducer = this.mLocalFileFetchToEncodedMemoryPrefetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalImageFileFetchSequence()
  {
    try
    {
      if (this.mLocalImageFileFetchSequence == null) {
        this.mLocalImageFileFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalFileFetchProducer());
      }
      Producer localProducer = this.mLocalImageFileFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalResourceFetchSequence()
  {
    try
    {
      if (this.mLocalResourceFetchSequence == null) {
        this.mLocalResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalResourceFetchProducer());
      }
      Producer localProducer = this.mLocalResourceFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalVideoFileFetchSequence()
  {
    try
    {
      if (this.mLocalVideoFileFetchSequence == null) {
        this.mLocalVideoFileFetchSequence = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newLocalVideoThumbnailProducer());
      }
      Producer localProducer = this.mLocalVideoFileFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getNetworkFetchSequence()
  {
    try
    {
      if (this.mNetworkFetchSequence == null) {
        this.mNetworkFetchSequence = newBitmapCacheGetToDecodeSequence(getCommonNetworkFetchToEncodedMemorySequence());
      }
      Producer localProducer = this.mNetworkFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<Void> getNetworkFetchToEncodedMemoryPrefetchSequence()
  {
    try
    {
      if (this.mNetworkFetchToEncodedMemoryPrefetchSequence == null) {
        this.mNetworkFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
      }
      Producer localProducer = this.mNetworkFetchToEncodedMemoryPrefetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getPostprocessorSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    try
    {
      if (!this.mPostprocessorSequences.containsKey(paramProducer))
      {
        Object localObject = this.mProducerFactory.newPostprocessorProducer(paramProducer);
        localObject = this.mProducerFactory.newPostprocessorBitmapMemoryCacheProducer((Producer)localObject);
        this.mPostprocessorSequences.put(paramProducer, localObject);
      }
      paramProducer = (Producer)this.mPostprocessorSequences.get(paramProducer);
      return paramProducer;
    }
    finally {}
  }
  
  private static String getShortenedUriString(Uri paramUri)
  {
    String str = String.valueOf(paramUri);
    paramUri = str;
    if (str.length() > 30) {
      paramUri = str.substring(0, 30) + "...";
    }
    return paramUri;
  }
  
  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    paramProducer = this.mProducerFactory.newBitmapMemoryCacheProducer(paramProducer);
    paramProducer = this.mProducerFactory.newBitmapMemoryCacheKeyMultiplexProducer(paramProducer);
    paramProducer = this.mProducerFactory.newBackgroundThreadHandoffProducer(paramProducer, this.mThreadHandoffProducerQueue);
    return this.mProducerFactory.newBitmapMemoryCacheGetProducer(paramProducer);
  }
  
  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToDecodeSequence(Producer<EncodedImage> paramProducer)
  {
    return newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newDecodeProducer(paramProducer));
  }
  
  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> paramProducer)
  {
    return newBitmapCacheGetToLocalTransformSequence(paramProducer, new ThumbnailProducer[] { this.mProducerFactory.newLocalExifThumbnailProducer() });
  }
  
  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> paramProducer, ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    return newBitmapCacheGetToDecodeSequence(newLocalTransformationsSequence(newEncodedCacheMultiplexToTranscodeSequence(paramProducer), paramArrayOfThumbnailProducer));
  }
  
  private Producer<EncodedImage> newDiskCacheSequence(Producer<EncodedImage> paramProducer)
  {
    paramProducer = this.mProducerFactory.newDiskCacheWriteProducer(paramProducer);
    paramProducer = this.mProducerFactory.newMediaVariationsProducer(paramProducer);
    return this.mProducerFactory.newDiskCacheReadProducer(paramProducer);
  }
  
  private Producer<EncodedImage> newEncodedCacheMultiplexToTranscodeSequence(Producer<EncodedImage> paramProducer)
  {
    Object localObject = paramProducer;
    if (WebpSupportStatus.sIsWebpSupportRequired) {
      if (this.mWebpSupportEnabled)
      {
        localObject = paramProducer;
        if (WebpSupportStatus.sWebpBitmapFactory != null) {}
      }
      else
      {
        localObject = this.mProducerFactory.newWebpTranscodeProducer(paramProducer);
      }
    }
    paramProducer = newDiskCacheSequence((Producer)localObject);
    paramProducer = this.mProducerFactory.newEncodedMemoryCacheProducer(paramProducer);
    return this.mProducerFactory.newEncodedCacheKeyMultiplexProducer(paramProducer);
  }
  
  private Producer<EncodedImage> newLocalThumbnailProducer(ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    paramArrayOfThumbnailProducer = this.mProducerFactory.newThumbnailBranchProducer(paramArrayOfThumbnailProducer);
    return this.mProducerFactory.newResizeAndRotateProducer(paramArrayOfThumbnailProducer, true, this.mUseDownsamplingRatio);
  }
  
  private Producer<EncodedImage> newLocalTransformationsSequence(Producer<EncodedImage> paramProducer, ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    paramProducer = ProducerFactory.newAddImageTransformMetaDataProducer(paramProducer);
    paramProducer = this.mProducerFactory.newResizeAndRotateProducer(paramProducer, true, this.mUseDownsamplingRatio);
    paramProducer = this.mProducerFactory.newThrottlingProducer(paramProducer);
    ProducerFactory localProducerFactory = this.mProducerFactory;
    return ProducerFactory.newBranchOnSeparateImagesProducer(newLocalThumbnailProducer(paramArrayOfThumbnailProducer), paramProducer);
  }
  
  private static void validateEncodedImageRequest(ImageRequest paramImageRequest)
  {
    Preconditions.checkNotNull(paramImageRequest);
    if (paramImageRequest.getLowestPermittedRequestLevel().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return;
    }
  }
  
  public Producer<Void> getDecodedImagePrefetchProducerSequence(ImageRequest paramImageRequest)
  {
    return getDecodedImagePrefetchSequence(getBasicDecodedImageSequence(paramImageRequest));
  }
  
  public Producer<CloseableReference<CloseableImage>> getDecodedImageProducerSequence(ImageRequest paramImageRequest)
  {
    Producer localProducer2 = getBasicDecodedImageSequence(paramImageRequest);
    Producer localProducer1 = localProducer2;
    if (paramImageRequest.getPostprocessor() != null) {
      localProducer1 = getPostprocessorSequence(localProducer2);
    }
    return localProducer1;
  }
  
  public Producer<Void> getEncodedImagePrefetchProducerSequence(ImageRequest paramImageRequest)
  {
    validateEncodedImageRequest(paramImageRequest);
    paramImageRequest = paramImageRequest.getSourceUri();
    if (UriUtil.isNetworkUri(paramImageRequest)) {
      return getNetworkFetchToEncodedMemoryPrefetchSequence();
    }
    if (UriUtil.isLocalFileUri(paramImageRequest)) {
      return getLocalFileFetchToEncodedMemoryPrefetchSequence();
    }
    throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + getShortenedUriString(paramImageRequest));
  }
  
  public Producer<CloseableReference<PooledByteBuffer>> getEncodedImageProducerSequence(ImageRequest paramImageRequest)
  {
    validateEncodedImageRequest(paramImageRequest);
    paramImageRequest = paramImageRequest.getSourceUri();
    if (UriUtil.isNetworkUri(paramImageRequest)) {
      return getNetworkFetchEncodedImageProducerSequence();
    }
    if (UriUtil.isLocalFileUri(paramImageRequest)) {
      return getLocalFileFetchEncodedImageProducerSequence();
    }
    throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + getShortenedUriString(paramImageRequest));
  }
  
  public Producer<CloseableReference<PooledByteBuffer>> getLocalFileFetchEncodedImageProducerSequence()
  {
    try
    {
      if (this.mLocalFileEncodedImageProducerSequence == null) {
        this.mLocalFileEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
      }
      return this.mLocalFileEncodedImageProducerSequence;
    }
    finally {}
  }
  
  public Producer<CloseableReference<PooledByteBuffer>> getNetworkFetchEncodedImageProducerSequence()
  {
    try
    {
      if (this.mNetworkEncodedImageProducerSequence == null) {
        this.mNetworkEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
      }
      return this.mNetworkEncodedImageProducerSequence;
    }
    finally {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/core/ProducerSequenceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */