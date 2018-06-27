package com.facebook.imagepipeline.backends.okhttp3;

import android.content.Context;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineConfig.Builder;
import okhttp3.OkHttpClient;

public class OkHttpImagePipelineConfigFactory
{
  public static ImagePipelineConfig.Builder newBuilder(Context paramContext, OkHttpClient paramOkHttpClient)
  {
    return ImagePipelineConfig.newBuilder(paramContext).setNetworkFetcher(new OkHttpNetworkFetcher(paramOkHttpClient));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/backends/okhttp3/OkHttpImagePipelineConfigFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */