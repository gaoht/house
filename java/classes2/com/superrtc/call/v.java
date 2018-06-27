package com.superrtc.call;

import android.content.Context;
import java.util.List;

public abstract interface v
{
  public abstract void dispose();
  
  public abstract List<c.a> getSupportedFormats();
  
  public abstract boolean getSupportedGetCameraFormats();
  
  public abstract t getSurfaceTextureHelper();
  
  public abstract void startCapture(int paramInt1, int paramInt2, int paramInt3, Context paramContext, a parama);
  
  public abstract void stopCapture()
    throws InterruptedException;
  
  public static abstract interface a
  {
    public abstract void onByteBufferFrameCaptured(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong);
    
    public abstract void onCapturerStarted(boolean paramBoolean);
    
    public abstract void onOutputFormatRequest(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void onTextureFrameCaptured(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, int paramInt4, long paramLong);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */