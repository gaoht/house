package com.facebook.imagepipeline.nativecode;

import com.facebook.common.soloader.SoLoaderShim;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImagePipelineNativeLoader
{
  public static final List<String> DEPENDENCIES = Collections.unmodifiableList(new ArrayList());
  public static final String DSO_NAME = "imagepipeline";
  
  public static void load()
  {
    SoLoaderShim.loadLibrary("imagepipeline");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/nativecode/ImagePipelineNativeLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */