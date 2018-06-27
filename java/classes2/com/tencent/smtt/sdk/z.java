package com.tencent.smtt.sdk;

class z
  implements Runnable
{
  z(y paramy) {}
  
  public void run()
  {
    if ((!TbsShareManager.forceLoadX5FromTBSDemo(y.a(this.a).getContext())) && (TbsDownloader.needDownload(y.a(this.a).getContext(), false))) {
      TbsDownloader.startDownload(y.a(this.a).getContext());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */