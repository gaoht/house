package com.baidu.trace.api.bos;

public final class BosGeneratePresignedUrlRequest
  extends BosObjectRequest
{
  private ImageProcessCommand a = null;
  private ImageWatermarkCommand b = null;
  private TextWatermarkCommand c = null;
  
  public BosGeneratePresignedUrlRequest() {}
  
  public BosGeneratePresignedUrlRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public BosGeneratePresignedUrlRequest(int paramInt, long paramLong, String paramString, BosObjectType paramBosObjectType)
  {
    super(paramInt, paramLong, paramString, paramBosObjectType);
  }
  
  public BosGeneratePresignedUrlRequest(int paramInt, long paramLong, String paramString, BosObjectType paramBosObjectType, ImageProcessCommand paramImageProcessCommand, ImageWatermarkCommand paramImageWatermarkCommand, TextWatermarkCommand paramTextWatermarkCommand)
  {
    this(paramInt, paramLong, paramString, paramBosObjectType);
  }
  
  public final ImageProcessCommand getImageProcessCommand()
  {
    return this.a;
  }
  
  public final ImageWatermarkCommand getImageWatermarkCommand()
  {
    return this.b;
  }
  
  public final TextWatermarkCommand getTextWatermarkCommand()
  {
    return this.c;
  }
  
  public final void setImageProcessCommand(ImageProcessCommand paramImageProcessCommand)
  {
    this.a = paramImageProcessCommand;
  }
  
  public final void setImageWatermarkCommand(ImageWatermarkCommand paramImageWatermarkCommand)
  {
    this.b = paramImageWatermarkCommand;
  }
  
  public final void setTextWatermarkCommand(TextWatermarkCommand paramTextWatermarkCommand)
  {
    this.c = paramTextWatermarkCommand;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("BosGeneratePresignedUrlRequest{");
    localStringBuffer.append("imageProcessCommand=").append(this.a);
    localStringBuffer.append(", imageWatermarkCommand=").append(this.b);
    localStringBuffer.append(", textWatermarkCommand=").append(this.c);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/bos/BosGeneratePresignedUrlRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */