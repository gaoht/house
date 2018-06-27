package com.mob.tools.utils;

import android.os.Handler.Callback;
import android.os.Message;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.util.HashSet;
import java.util.Iterator;

public class ApplicationTracker
{
  private static HashSet<Tracker> trackers = new HashSet();
  
  static
  {
    try
    {
      Object localObject1 = DeviceHelper.currentActivityThread();
      Object localObject2 = ReflectHelper.getInstanceField(localObject1, "mH");
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("mC");
      ((StringBuilder)localObject3).append("al");
      ((StringBuilder)localObject3).append("lb");
      ((StringBuilder)localObject3).append("ac");
      ((StringBuilder)localObject3).append("k");
      localObject3 = ((StringBuilder)localObject3).toString();
      ReflectHelper.setInstanceField(localObject2, (String)localObject3, new Handler.Callback()
      {
        public boolean handleMessage(Message paramAnonymousMessage)
        {
          Iterator localIterator = ApplicationTracker.trackers.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              ApplicationTracker.Tracker localTracker = (ApplicationTracker.Tracker)localIterator.next();
              try
              {
                switch (paramAnonymousMessage.what)
                {
                case 100: 
                  localTracker.onLaunchActivity(this.val$fThread, paramAnonymousMessage);
                }
              }
              catch (Throwable localThrowable)
              {
                MobLog.getInstance().w(localThrowable);
              }
              continue;
              localThrowable.onPauseActivity(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onPauseActivityFinishing(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onStopActivityShow(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onStopActivityHide(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onShowWindow(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onHideWindow(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onResumeActivity(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onSendResult(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onDestroyActivity(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onBindApplication(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onExitApplication(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onNewIntent(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onReceiver(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onCreateService(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onServiceArgs(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onStopService(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onConfigurationChanged(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onCleanUpContext(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onGcWhenIdle(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onBindService(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onUnbindService(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onDumpService(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onLowMemory(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onActivityConfigurationChanged(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onRelaunchActivity(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onProfilerControl(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onCreateBackupAgent(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onDestroyBackupAgent(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onSuicide(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onRemoveProvider(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onEnableJit(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onDispatchPackageBroadcast(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onScheduleCrash(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onDumpHeap(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onDumpActivity(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onSleeping(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onSetCoreSettings(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onUpdatePackageCompatibilityInfo(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onTrimMemory(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onDumpProvider(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onUnstableProviderDied(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onRequestAssistContextExtras(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onTranslucentConversionComplete(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onInstallProvider(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onOnNewActivityOptions(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onCancelVisibleBehind(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onBackgroundVisibleBehindChanged(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onEnterAnimationComplete(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onStartBinderTracking(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onStopBinderTrackingAndDump(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onMultiWindowModeChanged(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onPictureInPictureModeChanged(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onLocalVoiceInteractionStarted(this.val$fThread, paramAnonymousMessage);
              continue;
              localThrowable.onAttachAgent(this.val$fThread, paramAnonymousMessage);
            }
            else
            {
              return (this.val$backup != null) && (this.val$backup.handleMessage(paramAnonymousMessage));
            }
          }
        }
      });
      return;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
  }
  
  public static void addTracker(Tracker paramTracker)
  {
    trackers.add(paramTracker);
  }
  
  public static void removeTracker(Tracker paramTracker)
  {
    trackers.remove(paramTracker);
  }
  
  public static abstract class Tracker
  {
    protected void onActivityConfigurationChanged(Object paramObject, Message paramMessage) {}
    
    protected void onAttachAgent(Object paramObject, Message paramMessage) {}
    
    protected void onBackgroundVisibleBehindChanged(Object paramObject, Message paramMessage) {}
    
    protected void onBindApplication(Object paramObject, Message paramMessage) {}
    
    protected void onBindService(Object paramObject, Message paramMessage) {}
    
    protected void onCancelVisibleBehind(Object paramObject, Message paramMessage) {}
    
    protected void onCleanUpContext(Object paramObject, Message paramMessage) {}
    
    protected void onConfigurationChanged(Object paramObject, Message paramMessage) {}
    
    protected void onCreateBackupAgent(Object paramObject, Message paramMessage) {}
    
    protected void onCreateService(Object paramObject, Message paramMessage) {}
    
    protected void onDestroyActivity(Object paramObject, Message paramMessage) {}
    
    protected void onDestroyBackupAgent(Object paramObject, Message paramMessage) {}
    
    protected void onDispatchPackageBroadcast(Object paramObject, Message paramMessage) {}
    
    protected void onDumpActivity(Object paramObject, Message paramMessage) {}
    
    protected void onDumpHeap(Object paramObject, Message paramMessage) {}
    
    protected void onDumpProvider(Object paramObject, Message paramMessage) {}
    
    protected void onDumpService(Object paramObject, Message paramMessage) {}
    
    protected void onEnableJit(Object paramObject, Message paramMessage) {}
    
    protected void onEnterAnimationComplete(Object paramObject, Message paramMessage) {}
    
    protected void onExitApplication(Object paramObject, Message paramMessage) {}
    
    protected void onGcWhenIdle(Object paramObject, Message paramMessage) {}
    
    protected void onHideWindow(Object paramObject, Message paramMessage) {}
    
    protected void onInstallProvider(Object paramObject, Message paramMessage) {}
    
    protected void onLaunchActivity(Object paramObject, Message paramMessage) {}
    
    protected void onLocalVoiceInteractionStarted(Object paramObject, Message paramMessage) {}
    
    protected void onLowMemory(Object paramObject, Message paramMessage) {}
    
    protected void onMultiWindowModeChanged(Object paramObject, Message paramMessage) {}
    
    protected void onNewIntent(Object paramObject, Message paramMessage) {}
    
    protected void onOnNewActivityOptions(Object paramObject, Message paramMessage) {}
    
    protected void onPauseActivity(Object paramObject, Message paramMessage) {}
    
    protected void onPauseActivityFinishing(Object paramObject, Message paramMessage) {}
    
    protected void onPictureInPictureModeChanged(Object paramObject, Message paramMessage) {}
    
    protected void onProfilerControl(Object paramObject, Message paramMessage) {}
    
    protected void onReceiver(Object paramObject, Message paramMessage) {}
    
    protected void onRelaunchActivity(Object paramObject, Message paramMessage) {}
    
    protected void onRemoveProvider(Object paramObject, Message paramMessage) {}
    
    protected void onRequestAssistContextExtras(Object paramObject, Message paramMessage) {}
    
    protected void onResumeActivity(Object paramObject, Message paramMessage) {}
    
    protected void onScheduleCrash(Object paramObject, Message paramMessage) {}
    
    protected void onSendResult(Object paramObject, Message paramMessage) {}
    
    protected void onServiceArgs(Object paramObject, Message paramMessage) {}
    
    protected void onSetCoreSettings(Object paramObject, Message paramMessage) {}
    
    protected void onShowWindow(Object paramObject, Message paramMessage) {}
    
    protected void onSleeping(Object paramObject, Message paramMessage) {}
    
    protected void onStartBinderTracking(Object paramObject, Message paramMessage) {}
    
    protected void onStopActivityHide(Object paramObject, Message paramMessage) {}
    
    protected void onStopActivityShow(Object paramObject, Message paramMessage) {}
    
    protected void onStopBinderTrackingAndDump(Object paramObject, Message paramMessage) {}
    
    protected void onStopService(Object paramObject, Message paramMessage) {}
    
    protected void onSuicide(Object paramObject, Message paramMessage) {}
    
    protected void onTranslucentConversionComplete(Object paramObject, Message paramMessage) {}
    
    protected void onTrimMemory(Object paramObject, Message paramMessage) {}
    
    protected void onUnbindService(Object paramObject, Message paramMessage) {}
    
    protected void onUnstableProviderDied(Object paramObject, Message paramMessage) {}
    
    protected void onUpdatePackageCompatibilityInfo(Object paramObject, Message paramMessage) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/utils/ApplicationTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */