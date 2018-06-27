package com.facebook.imagepipeline.animated.impl;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;

public class AnimatedDrawableDiagnosticsImpl
  implements AnimatedDrawableDiagnostics
{
  private static final Class<?> TAG = AnimatedDrawableDiagnostics.class;
  private AnimatedDrawableCachingBackend mAnimatedDrawableBackend;
  private final AnimatedDrawableUtil mAnimatedDrawableUtil;
  private final TextPaint mDebugTextPaint;
  private final DisplayMetrics mDisplayMetrics;
  private final RollingStat mDrawnFrames;
  private final RollingStat mDroppedFramesStat;
  private long mLastTimeStamp;
  private final StringBuilder sbTemp;
  
  public AnimatedDrawableDiagnosticsImpl(AnimatedDrawableUtil paramAnimatedDrawableUtil, DisplayMetrics paramDisplayMetrics)
  {
    this.mAnimatedDrawableUtil = paramAnimatedDrawableUtil;
    this.mDisplayMetrics = paramDisplayMetrics;
    this.mDroppedFramesStat = new RollingStat();
    this.mDrawnFrames = new RollingStat();
    this.sbTemp = new StringBuilder();
    this.mDebugTextPaint = new TextPaint();
    this.mDebugTextPaint.setColor(-16776961);
    this.mDebugTextPaint.setTextSize(convertDpToPx(14));
  }
  
  private int convertDpToPx(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, this.mDisplayMetrics);
  }
  
  public void drawDebugOverlay(Canvas paramCanvas, Rect paramRect)
  {
    int i = this.mDroppedFramesStat.getSum(10);
    int j = this.mDrawnFrames.getSum(10);
    int k = i + j;
    i = convertDpToPx(10);
    int m = convertDpToPx(20);
    int n = convertDpToPx(5);
    if (k > 0)
    {
      j = j * 100 / k;
      this.sbTemp.setLength(0);
      this.sbTemp.append(j);
      this.sbTemp.append("%");
      paramCanvas.drawText(this.sbTemp, 0, this.sbTemp.length(), i, m, this.mDebugTextPaint);
    }
    for (j = (int)(i + this.mDebugTextPaint.measureText(this.sbTemp, 0, this.sbTemp.length())) + n;; j = i)
    {
      k = this.mAnimatedDrawableBackend.getMemoryUsage();
      this.sbTemp.setLength(0);
      this.mAnimatedDrawableUtil.appendMemoryString(this.sbTemp, k);
      float f = this.mDebugTextPaint.measureText(this.sbTemp, 0, this.sbTemp.length());
      if (j + f > paramRect.width())
      {
        j = (int)(m + (this.mDebugTextPaint.getTextSize() + n));
        k = i;
      }
      for (;;)
      {
        paramCanvas.drawText(this.sbTemp, 0, this.sbTemp.length(), k, j, this.mDebugTextPaint);
        k = (int)(k + f) + n;
        this.sbTemp.setLength(0);
        this.mAnimatedDrawableBackend.appendDebugOptionString(this.sbTemp);
        if (this.mDebugTextPaint.measureText(this.sbTemp, 0, this.sbTemp.length()) + k > paramRect.width()) {
          j = (int)(j + (this.mDebugTextPaint.getTextSize() + n));
        }
        for (;;)
        {
          paramCanvas.drawText(this.sbTemp, 0, this.sbTemp.length(), i, j, this.mDebugTextPaint);
          return;
          i = k;
        }
        k = j;
        j = m;
      }
    }
  }
  
  public void incrementDrawnFrames(int paramInt)
  {
    this.mDrawnFrames.incrementStats(paramInt);
  }
  
  public void incrementDroppedFrames(int paramInt)
  {
    this.mDroppedFramesStat.incrementStats(paramInt);
    if (paramInt > 0) {
      FLog.v(TAG, "Dropped %d frames", Integer.valueOf(paramInt));
    }
  }
  
  public void onDrawMethodBegin()
  {
    this.mLastTimeStamp = SystemClock.uptimeMillis();
  }
  
  public void onDrawMethodEnd()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.mLastTimeStamp;
    FLog.v(TAG, "draw took %d", Long.valueOf(l1 - l2));
  }
  
  public void onNextFrameMethodBegin()
  {
    this.mLastTimeStamp = SystemClock.uptimeMillis();
  }
  
  public void onNextFrameMethodEnd()
  {
    long l = SystemClock.uptimeMillis() - this.mLastTimeStamp;
    if (l > 3L) {
      FLog.v(TAG, "onNextFrame took %d", Long.valueOf(l));
    }
  }
  
  public void onStartMethodBegin()
  {
    this.mLastTimeStamp = SystemClock.uptimeMillis();
  }
  
  public void onStartMethodEnd()
  {
    long l = SystemClock.uptimeMillis() - this.mLastTimeStamp;
    if (l > 3L) {
      FLog.v(TAG, "onStart took %d", Long.valueOf(l));
    }
  }
  
  public void setBackend(AnimatedDrawableCachingBackend paramAnimatedDrawableCachingBackend)
  {
    this.mAnimatedDrawableBackend = paramAnimatedDrawableCachingBackend;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/animated/impl/AnimatedDrawableDiagnosticsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */