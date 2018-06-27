package com.superrtc.call;

import android.opengl.GLES20;

public class j
{
  private final int a;
  private final int b;
  private final int c;
  private int d;
  private int e;
  
  public j(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Invalid pixel format: " + paramInt);
    }
    this.c = paramInt;
    this.b = k.generateTexture(3553);
    this.d = 0;
    this.e = 0;
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    this.a = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, this.a);
    k.checkNoGLES2Error("Generate framebuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.b, 0);
    k.checkNoGLES2Error("Attach texture to framebuffer");
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public int getFrameBufferId()
  {
    return this.a;
  }
  
  public int getHeight()
  {
    return this.e;
  }
  
  public int getTextureId()
  {
    return this.b;
  }
  
  public int getWidth()
  {
    return this.d;
  }
  
  public void release()
  {
    GLES20.glDeleteTextures(1, new int[] { this.b }, 0);
    GLES20.glDeleteFramebuffers(1, new int[] { this.a }, 0);
    this.d = 0;
    this.e = 0;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      throw new IllegalArgumentException("Invalid size: " + paramInt1 + "x" + paramInt2);
    }
    if ((paramInt1 == this.d) && (paramInt2 == this.e)) {
      return;
    }
    this.d = paramInt1;
    this.e = paramInt2;
    GLES20.glBindFramebuffer(36160, this.a);
    k.checkNoGLES2Error("glBindFramebuffer");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.b);
    GLES20.glTexImage2D(3553, 0, this.c, paramInt1, paramInt2, 0, this.c, 5121, null);
    paramInt1 = GLES20.glCheckFramebufferStatus(36160);
    if (paramInt1 != 36053) {
      throw new IllegalStateException("Framebuffer not complete, status: " + paramInt1);
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glBindTexture(3553, 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */