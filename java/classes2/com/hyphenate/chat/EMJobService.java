package com.hyphenate.chat;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;

@TargetApi(21)
public class EMJobService
  extends JobService
{
  private static final String TAG = "JobService";
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 1;
  }
  
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    try
    {
      startService(new Intent(getApplicationContext(), EMChatService.class));
      return false;
    }
    catch (Exception paramJobParameters)
    {
      for (;;)
      {
        paramJobParameters.printStackTrace();
      }
    }
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMJobService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */