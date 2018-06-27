package com.facebook.imagepipeline.animated.base;

public class AnimatedDrawableFrameInfo
{
  public final BlendOperation blendOperation;
  public final DisposalMethod disposalMethod;
  public final int frameNumber;
  public final int height;
  public final int width;
  public final int xOffset;
  public final int yOffset;
  
  public AnimatedDrawableFrameInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, BlendOperation paramBlendOperation, DisposalMethod paramDisposalMethod)
  {
    this.frameNumber = paramInt1;
    this.xOffset = paramInt2;
    this.yOffset = paramInt3;
    this.width = paramInt4;
    this.height = paramInt5;
    this.blendOperation = paramBlendOperation;
    this.disposalMethod = paramDisposalMethod;
  }
  
  public static enum BlendOperation
  {
    BLEND_WITH_PREVIOUS,  NO_BLEND;
    
    private BlendOperation() {}
  }
  
  public static enum DisposalMethod
  {
    DISPOSE_DO_NOT,  DISPOSE_TO_BACKGROUND,  DISPOSE_TO_PREVIOUS;
    
    private DisposalMethod() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/animated/base/AnimatedDrawableFrameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */