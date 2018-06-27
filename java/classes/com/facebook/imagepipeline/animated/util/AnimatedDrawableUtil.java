package com.facebook.imagepipeline.animated.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import java.util.Arrays;

public class AnimatedDrawableUtil
{
  private static final int FRAME_DURATION_MS_FOR_MIN = 100;
  private static final int MIN_FRAME_DURATION_MS = 11;
  
  public static boolean isOutsideRange(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if ((paramInt1 == -1) || (paramInt2 == -1)) {
      bool1 = true;
    }
    do
    {
      return bool1;
      if (paramInt1 > paramInt2) {
        break;
      }
    } while ((paramInt3 >= paramInt1) && (paramInt3 <= paramInt2));
    return true;
    if ((paramInt3 < paramInt1) && (paramInt3 > paramInt2)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public void appendMemoryString(StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt < 1024)
    {
      paramStringBuilder.append(paramInt);
      paramStringBuilder.append("KB");
      return;
    }
    int i = paramInt / 1024;
    paramInt = paramInt % 1024 / 100;
    paramStringBuilder.append(i);
    paramStringBuilder.append(".");
    paramStringBuilder.append(paramInt);
    paramStringBuilder.append("MB");
  }
  
  public void fixFrameDurations(int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i] < 11) {
        paramArrayOfInt[i] = 100;
      }
      i += 1;
    }
  }
  
  public int getFrameForTimestampMs(int[] paramArrayOfInt, int paramInt)
  {
    int i = Arrays.binarySearch(paramArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -i - 1 - 1;
    }
    return paramInt;
  }
  
  public int[] getFrameTimeStampsFromDurations(int[] paramArrayOfInt)
  {
    int i = 0;
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    int j = 0;
    while (i < paramArrayOfInt.length)
    {
      arrayOfInt[i] = j;
      j += paramArrayOfInt[i];
      i += 1;
    }
    return arrayOfInt;
  }
  
  @SuppressLint({"NewApi"})
  public int getSizeOfBitmap(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramBitmap.getAllocationByteCount();
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getWidth() * paramBitmap.getHeight() * 4;
  }
  
  public int getTotalDurationFromFrameDurations(int[] paramArrayOfInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramArrayOfInt.length)
    {
      j += paramArrayOfInt[i];
      i += 1;
    }
    return j;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/animated/util/AnimatedDrawableUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */