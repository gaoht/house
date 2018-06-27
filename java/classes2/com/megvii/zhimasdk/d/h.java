package com.megvii.zhimasdk.d;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import com.megvii.livenessdetection.Detector.DetectionType;
import com.megvii.zhimasdk.R.raw;

public class h
{
  public MediaPlayer a;
  private Context b;
  
  public h(Context paramContext)
  {
    this.b = paramContext;
    this.a = new MediaPlayer();
  }
  
  public void a()
  {
    this.b = null;
    if (this.a != null)
    {
      this.a.reset();
      this.a.release();
      this.a = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    this.a.reset();
    try
    {
      AssetFileDescriptor localAssetFileDescriptor = this.b.getResources().openRawResourceFd(paramInt);
      this.a.setDataSource(localAssetFileDescriptor.getFileDescriptor(), localAssetFileDescriptor.getStartOffset(), localAssetFileDescriptor.getLength());
      localAssetFileDescriptor.close();
      this.a.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
      {
        public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
        {
          h.this.a.start();
        }
      });
      this.a.prepareAsync();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(final Detector.DetectionType paramDetectionType)
  {
    if (this.a == null) {
      return;
    }
    this.a.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        h.this.a(h.this.b(paramDetectionType));
        if (h.this.a == null) {
          return;
        }
        h.this.a.setOnCompletionListener(null);
      }
    });
  }
  
  public int b(Detector.DetectionType paramDetectionType)
  {
    switch (3.a[paramDetectionType.ordinal()])
    {
    default: 
      return -1;
    case 1: 
      return R.raw.meglive_pitch_down;
    case 2: 
    case 3: 
    case 4: 
      return R.raw.meglive_yaw;
    case 5: 
      return R.raw.meglive_mouth_open;
    }
    return R.raw.meglive_eye_blink;
  }
  
  public void b()
  {
    if (this.a != null) {
      this.a.reset();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */