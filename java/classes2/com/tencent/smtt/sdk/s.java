package com.tencent.smtt.sdk;

class s
  implements Runnable
{
  s(r paramr) {}
  
  public void run()
  {
    if ((!TbsShareManager.forceLoadX5FromTBSDemo(r.a(this.a).getContext())) && (TbsDownloader.needDownload(r.a(this.a).getContext(), false))) {
      TbsDownloader.startDownload(r.a(this.a).getContext());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */