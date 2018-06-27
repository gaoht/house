package com.superrtc.mediamanager;

public class f
{
  public void invokeBlock(final b.b paramb, final Object paramObject, final b.a parama, e parame)
  {
    if (paramb == null) {
      return;
    }
    if (e.f != null)
    {
      e.f.execute(new Runnable()
      {
        public void run()
        {
          paramb.onDone(paramObject, parama);
        }
      });
      return;
    }
    paramb.onDone(paramObject, parama);
  }
  
  public void invokeOnExitConference(final int paramInt, final String paramString, final e parame)
  {
    if (parame.e == null) {
      return;
    }
    if (e.f != null)
    {
      e.f.execute(new Runnable()
      {
        public void run()
        {
          parame.e.passiveCloseReason(parame, paramInt, paramString);
        }
      });
      return;
    }
    parame.e.passiveCloseReason(parame, paramInt, paramString);
  }
  
  public void invokeOnMemberExit(final b.c paramc, final e parame, int paramInt)
  {
    if (parame.e == null) {
      return;
    }
    if (e.f != null)
    {
      e.f.execute(new Runnable()
      {
        public void run()
        {
          parame.e.exitMember(parame, paramc);
        }
      });
      return;
    }
    parame.e.exitMember(parame, paramc);
  }
  
  public void invokeOnMemberJoin(final b.c paramc, final e parame)
  {
    if (parame.e == null) {
      return;
    }
    if (e.f != null)
    {
      e.f.execute(new Runnable()
      {
        public void run()
        {
          parame.e.joinMember(parame, paramc);
        }
      });
      return;
    }
    parame.e.joinMember(parame, paramc);
  }
  
  public void invokeOnNotice(final a.b paramb, final String paramString1, final String paramString2, final Object paramObject, final e parame)
  {
    if (parame.e == null) {
      return;
    }
    if (e.f != null)
    {
      e.f.execute(new Runnable()
      {
        public void run()
        {
          parame.e.notice(parame, paramb, paramString1, paramString2, paramObject);
        }
      });
      return;
    }
    parame.e.notice(parame, paramb, paramString1, paramString2, paramObject);
  }
  
  public void invokeOnStopStream(final g paramg, final e parame)
  {
    if (parame.e == null) {
      return;
    }
    if (e.f != null)
    {
      e.f.execute(new Runnable()
      {
        public void run()
        {
          parame.e.removeStream(parame, paramg);
        }
      });
      return;
    }
    parame.e.removeStream(parame, paramg);
  }
  
  public void invokeOnStreamPublish(final g paramg, final e parame)
  {
    if (parame.e == null) {
      return;
    }
    if (e.f != null)
    {
      e.f.execute(new Runnable()
      {
        public void run()
        {
          parame.e.addStream(parame, paramg);
        }
      });
      return;
    }
    parame.e.addStream(parame, paramg);
  }
  
  public void invokeOnUpdateStream(final g paramg, final e parame)
  {
    if (parame.e == null) {
      return;
    }
    if (e.f != null)
    {
      e.f.execute(new Runnable()
      {
        public void run()
        {
          parame.e.updateStream(parame, paramg);
        }
      });
      return;
    }
    parame.e.updateStream(parame, paramg);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/mediamanager/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */