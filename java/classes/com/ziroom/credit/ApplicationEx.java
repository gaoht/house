package com.ziroom.credit;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap.Config;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskCacheConfig.Builder;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig.Builder;
import com.facebook.imagepipeline.listener.RequestLoggingListener;
import com.freelxl.baselibrary.b.c;
import com.freelxl.baselibrary.f.i;
import java.util.HashSet;
import java.util.Set;
import okhttp3.OkHttpClient;

public class ApplicationEx
  extends Application
  implements Thread.UncaughtExceptionHandler
{
  public void AppExit(Context paramContext)
  {
    try
    {
      ((ActivityManager)paramContext.getSystemService("activity")).restartPackage(paramContext.getPackageName());
      return;
    }
    catch (Exception paramContext) {}
  }
  
  protected void a(Throwable paramThrowable) {}
  
  public void onCreate()
  {
    super.onCreate();
    int i = R.drawable.loading_1;
    int j = R.drawable.loading_2;
    int k = R.drawable.loading_3;
    int m = R.drawable.loading_4;
    Object localObject1 = new com.freelxl.baselibrary.b.a().setLOG_SWITCH(Boolean.valueOf(true)).setmImageRess(new int[] { i, j, k, m });
    c.getInstance().init((com.freelxl.baselibrary.b.a)localObject1);
    com.ziroom.commonlibrary.a.init(this, 2);
    localObject1 = com.freelxl.baselibrary.d.a.getInstance();
    Object localObject2 = new HashSet();
    ((Set)localObject2).add(new RequestLoggingListener());
    localObject1 = OkHttpImagePipelineConfigFactory.newBuilder(this, (OkHttpClient)localObject1).setBitmapsConfig(Bitmap.Config.RGB_565).setRequestListeners((Set)localObject2).setMainDiskCacheConfig(DiskCacheConfig.newBuilder(this).build()).setSmallImageDiskCacheConfig(DiskCacheConfig.newBuilder(this).build()).setDownsampleEnabled(true);
    localObject2 = (ActivityManager)getSystemService("activity");
    if (localObject2 != null) {
      ((ImagePipelineConfig.Builder)localObject1).setBitmapMemoryCacheParamsSupplier(new i((ActivityManager)localObject2));
    }
    Fresco.initialize(this, ((ImagePipelineConfig.Builder)localObject1).build());
  }
  
  public void onTerminate()
  {
    Fresco.getImagePipeline().clearMemoryCaches();
    super.onTerminate();
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (Fresco.getImagePipeline() == null);
    Fresco.getImagePipeline().clearMemoryCaches();
  }
  
  public void uncaughtException(Thread paramThread, final Throwable paramThrowable)
  {
    if (com.ziroom.ziroomcoloreggs.eggs.a.b) {
      new Thread(new Runnable()
      {
        public void run()
        {
          ApplicationEx.this.a(paramThrowable);
        }
      }).start();
    }
    try
    {
      Thread.sleep(2000L);
      System.exit(2);
      return;
    }
    catch (InterruptedException paramThread)
    {
      for (;;)
      {
        paramThread.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/credit/ApplicationEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */