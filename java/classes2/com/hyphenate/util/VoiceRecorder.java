package com.hyphenate.util;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.format.Time;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class VoiceRecorder
{
  static final String EXTENSION = ".amr";
  static final String PREFIX = "voice";
  private File file;
  private Handler handler;
  private boolean isRecording = false;
  MediaRecorder recorder;
  private long startTime;
  private String voiceFileName = null;
  
  public VoiceRecorder(Handler paramHandler)
  {
    this.handler = paramHandler;
  }
  
  public void discardRecording()
  {
    if (this.recorder != null) {}
    try
    {
      this.recorder.stop();
      this.recorder.release();
      this.recorder = null;
      if ((this.file != null) && (this.file.exists()) && (!this.file.isDirectory())) {
        this.file.delete();
      }
      this.isRecording = false;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;) {}
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (this.recorder != null) {
      this.recorder.release();
    }
  }
  
  public String getVoiceFileName(String paramString)
  {
    Time localTime = new Time();
    localTime.setToNow();
    return paramString + localTime.toString().substring(0, 15) + ".amr";
  }
  
  public String getVoiceFilePath()
  {
    return PathUtil.getInstance().getVoicePath() + "/" + this.voiceFileName;
  }
  
  public boolean isRecording()
  {
    return this.isRecording;
  }
  
  public String startRecording(String paramString1, String paramString2, Context paramContext)
  {
    this.file = null;
    try
    {
      if (this.recorder != null)
      {
        this.recorder.release();
        this.recorder = null;
      }
      this.recorder = new MediaRecorder();
      this.recorder.setAudioSource(1);
      this.recorder.setOutputFormat(3);
      this.recorder.setAudioEncoder(1);
      this.recorder.setAudioChannels(1);
      this.recorder.setAudioSamplingRate(8000);
      this.recorder.setAudioEncodingBitRate(64);
      this.voiceFileName = getVoiceFileName(paramString2);
      this.file = new File(getVoiceFilePath());
      this.recorder.setOutputFile(this.file.getAbsolutePath());
      this.recorder.prepare();
      this.isRecording = true;
      this.recorder.start();
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        EMLog.e("voice", "prepare() failed");
      }
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          while (VoiceRecorder.this.isRecording)
          {
            Message localMessage = new Message();
            localMessage.what = (VoiceRecorder.this.recorder.getMaxAmplitude() * 13 / 32767);
            VoiceRecorder.this.handler.sendMessage(localMessage);
            SystemClock.sleep(100L);
          }
          return;
        }
        catch (Exception localException)
        {
          EMLog.e("voice", localException.toString());
        }
      }
    }).start();
    this.startTime = new Date().getTime();
    EMLog.d("voice", "start voice recording to file:" + this.file.getAbsolutePath());
    if (this.file == null) {
      return null;
    }
    return this.file.getAbsolutePath();
  }
  
  public int stopRecoding()
  {
    if (this.recorder != null)
    {
      this.isRecording = false;
      this.recorder.stop();
      this.recorder.release();
      this.recorder = null;
      if ((this.file == null) || (!this.file.exists()) || (!this.file.isFile())) {
        return 401;
      }
      if (this.file.length() == 0L)
      {
        this.file.delete();
        return 401;
      }
      int i = (int)(new Date().getTime() - this.startTime) / 1000;
      EMLog.d("voice", "voice recording finished. seconds:" + i + " file length:" + this.file.length());
      return i;
    }
    return 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/util/VoiceRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */