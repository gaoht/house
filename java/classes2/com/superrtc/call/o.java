package com.superrtc.call;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;

public class o
{
  private static float a = 0.5625F;
  
  private static float a(c paramc)
  {
    switch (1.a[paramc.ordinal()])
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      return 1.0F;
    case 2: 
      return 0.0F;
    }
    return a;
  }
  
  private static Point a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((paramFloat1 == 0.0F) || (paramFloat2 == 0.0F)) {
      return new Point(paramInt1, paramInt2);
    }
    return new Point(Math.min(paramInt1, Math.round(paramInt2 / paramFloat1 * paramFloat2)), Math.min(paramInt2, Math.round(paramInt1 / paramFloat1 / paramFloat2)));
  }
  
  private static void a(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[12] -= (paramArrayOfFloat[0] + paramArrayOfFloat[4]) * 0.5F;
    paramArrayOfFloat[13] -= (paramArrayOfFloat[1] + paramArrayOfFloat[5]) * 0.5F;
    paramArrayOfFloat[12] += 0.5F;
    paramArrayOfFloat[13] += 0.5F;
  }
  
  public static Point getDisplaySize(c paramc, float paramFloat, int paramInt1, int paramInt2)
  {
    return a(a(paramc), paramFloat, paramInt1, paramInt2);
  }
  
  public static float[] getLayoutMatrix(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 > paramFloat1)
    {
      paramFloat2 = paramFloat1 / paramFloat2;
      paramFloat1 = 1.0F;
    }
    for (;;)
    {
      float f = paramFloat1;
      if (paramBoolean) {
        f = paramFloat1 * -1.0F;
      }
      float[] arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
      Matrix.scaleM(arrayOfFloat, 0, f, paramFloat2, 1.0F);
      a(arrayOfFloat);
      return arrayOfFloat;
      paramFloat1 = paramFloat2 / paramFloat1;
      paramFloat2 = 1.0F;
    }
  }
  
  public static final float[] horizontalFlipMatrix()
  {
    return new float[] { -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F };
  }
  
  public static final float[] identityMatrix()
  {
    return new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  }
  
  public static float[] multiplyMatrices(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat = new float[16];
    Matrix.multiplyMM(arrayOfFloat, 0, paramArrayOfFloat1, 0, paramArrayOfFloat2, 0);
    return arrayOfFloat;
  }
  
  public static float[] rotateTextureMatrix(float[] paramArrayOfFloat, float paramFloat)
  {
    float[] arrayOfFloat = new float[16];
    Matrix.setRotateM(arrayOfFloat, 0, paramFloat, 0.0F, 0.0F, 1.0F);
    a(arrayOfFloat);
    return multiplyMatrices(paramArrayOfFloat, arrayOfFloat);
  }
  
  public static final float[] verticalFlipMatrix()
  {
    return new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  public static abstract interface a
  {
    public abstract void drawOes(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract void drawRgb(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract void drawYuv(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void release();
  }
  
  public static abstract interface b
  {
    public abstract void onFirstFrameRendered();
    
    public abstract void onFrameResolutionChanged(int paramInt1, int paramInt2, int paramInt3);
  }
  
  public static enum c
  {
    private c() {}
  }
  
  public static class d
  {
    private ByteBuffer a;
    
    public void uploadYuvData(int[] paramArrayOfInt1, int paramInt1, int paramInt2, int[] paramArrayOfInt2, ByteBuffer[] paramArrayOfByteBuffer)
    {
      int[] arrayOfInt1 = new int[3];
      arrayOfInt1[0] = paramInt1;
      arrayOfInt1[1] = (paramInt1 / 2);
      arrayOfInt1[2] = (paramInt1 / 2);
      int[] arrayOfInt2 = new int[3];
      arrayOfInt2[0] = paramInt2;
      arrayOfInt2[1] = (paramInt2 / 2);
      arrayOfInt2[2] = (paramInt2 / 2);
      paramInt2 = 0;
      paramInt1 = 0;
      while (paramInt1 < 3)
      {
        int i = paramInt2;
        if (paramArrayOfInt2[paramInt1] > arrayOfInt1[paramInt1]) {
          i = Math.max(paramInt2, arrayOfInt1[paramInt1] * arrayOfInt2[paramInt1]);
        }
        paramInt1 += 1;
        paramInt2 = i;
      }
      if ((paramInt2 > 0) && ((this.a == null) || (this.a.capacity() < paramInt2))) {
        this.a = ByteBuffer.allocateDirect(paramInt2);
      }
      paramInt1 = 0;
      if (paramInt1 < 3)
      {
        GLES20.glActiveTexture(33984 + paramInt1);
        GLES20.glBindTexture(3553, paramArrayOfInt1[paramInt1]);
        if (paramArrayOfInt2[paramInt1] == arrayOfInt1[paramInt1]) {}
        for (ByteBuffer localByteBuffer = paramArrayOfByteBuffer[paramInt1];; localByteBuffer = this.a)
        {
          GLES20.glTexImage2D(3553, 0, 6409, arrayOfInt1[paramInt1], arrayOfInt2[paramInt1], 0, 6409, 5121, localByteBuffer);
          paramInt1 += 1;
          break;
          VideoRenderer.nativeCopyPlane(paramArrayOfByteBuffer[paramInt1], arrayOfInt1[paramInt1], arrayOfInt2[paramInt1], paramArrayOfInt2[paramInt1], this.a, arrayOfInt1[paramInt1]);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */