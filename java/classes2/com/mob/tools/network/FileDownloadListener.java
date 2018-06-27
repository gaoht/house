package com.mob.tools.network;

public abstract class FileDownloadListener
{
  private boolean isCanceled = false;
  
  public void cancel()
  {
    this.isCanceled = true;
  }
  
  public boolean isCanceled()
  {
    return this.isCanceled;
  }
  
  protected abstract void onProgress(int paramInt, long paramLong1, long paramLong2);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/network/FileDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */