package com.ziroom.datacenter.remote.e;

import android.content.Context;
import com.ziroom.datacenter.remote.responsebody.financial.b.n;
import com.ziroom.datacenter.remote.responsebody.financial.b.o;
import com.ziroom.datacenter.remote.responsebody.financial.b.p;
import com.ziroom.datacenter.remote.responsebody.financial.b.q;
import com.ziroom.datacenter.remote.responsebody.financial.b.r;
import com.ziroom.datacenter.remote.responsebody.financial.b.s;
import com.ziroom.datacenter.remote.responsebody.financial.b.t;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class d
{
  public static final void callbacktExceptionCreditResult(Context paramContext, com.ziroom.datacenter.remote.d.a.c.k paramk, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl callbacktExceptionCreditResult start");
    Object localObject = com.ziroom.a.a.a.a.check(paramk);
    if (localObject != null)
    {
      parama.onFailure((Throwable)localObject);
      return;
    }
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, parama, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.c.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl callbacktExceptionCreditResult onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.c paramAnonymousc)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl callbacktExceptionCreditResult onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousc);
        if (localNullPointerException != null)
        {
          parama.onFailure(localNullPointerException);
          return;
        }
        parama.onSuccess(paramAnonymousInt, paramAnonymousc);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userInfoApiController/callbacktExceptionCreditResult").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(paramk)).enqueue(parama);
  }
  
  public static final void callbacktUserNameCreditResult(Context paramContext, com.ziroom.datacenter.remote.d.a.c.l paraml, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl callbacktUserNameCreditResult start");
    Object localObject = com.ziroom.a.a.a.a.check(paraml);
    if (localObject != null)
    {
      parama.onFailure((Throwable)localObject);
      return;
    }
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, parama, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.c.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl callbacktUserNameCreditResult onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.c paramAnonymousc)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl callbacktUserNameCreditResult onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousc);
        if (localNullPointerException != null)
        {
          parama.onFailure(localNullPointerException);
          return;
        }
        parama.onSuccess(paramAnonymousInt, paramAnonymousc);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userInfoApiController/callbacktUserNameCreditResult").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(paraml)).enqueue(parama);
  }
  
  public static final void callbacktUserNameCreditResult(Context paramContext, com.ziroom.datacenter.remote.d.a.c.m paramm, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl callbacktUserNameCreditResult start");
    Object localObject = com.ziroom.a.a.a.a.check(paramm);
    if (localObject != null)
    {
      parama.onFailure((Throwable)localObject);
      return;
    }
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, parama, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.c.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl callbacktUserNameCreditResult onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.c paramAnonymousc)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl callbacktUserNameCreditResult onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        parama.onSuccess(paramAnonymousInt, paramAnonymousc);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userApi/callBackCreditSuccess").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(paramm)).enqueue(parama);
  }
  
  public static final void checkLimit(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl checkLimit start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, parama1, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.c.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl checkLimit onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.c paramAnonymousc)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl checkLimit onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousc);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymousc);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userInfoApiController/checkLimit").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void getAppeal(Context paramContext, com.ziroom.datacenter.remote.d.a.c.d paramd, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getAppeal start");
    Object localObject = com.ziroom.a.a.a.a.check(paramd);
    if (localObject != null)
    {
      parama.onFailure((Throwable)localObject);
      return;
    }
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, parama, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.c.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getAppeal onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.c paramAnonymousc)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getAppeal onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        parama.onSuccess(paramAnonymousInt, paramAnonymousc);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/lease/appeal").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(paramd)).enqueue(parama);
  }
  
  public static final void getBacklogs(Context paramContext, com.ziroom.datacenter.remote.d.a.c.e parame, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.a> parama)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getBacklogs start");
    Object localObject = com.ziroom.a.a.a.a.check(parame);
    if (localObject != null)
    {
      parama.onFailure((Throwable)localObject);
      return;
    }
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, parama, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.a.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getBacklogs onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.a paramAnonymousa)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getBacklogs onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousa);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousa);
        if (localNullPointerException != null)
        {
          parama.onFailure(localNullPointerException);
          return;
        }
        parama.onSuccess(paramAnonymousInt, paramAnonymousa);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userInfoApiController/getBacklogs").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parame)).enqueue(parama);
  }
  
  public static final void getBannerList(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.b> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getBannerList start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, parama1, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.b.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getBannerList onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.b paramAnonymousb)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getBannerList onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousb);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymousb);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userApi/getBannerList").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void getCouponByMedalCode(Context paramContext, com.ziroom.datacenter.remote.d.a.c.b paramb, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getCouponByMedalCode start");
    Object localObject = com.ziroom.a.a.a.a.check(paramb);
    if (localObject != null)
    {
      parama.onFailure((Throwable)localObject);
      return;
    }
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, parama, new com.ziroom.datacenter.remote.c.f(com.alibaba.fastjson.e.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getCouponByMedalCode onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getCouponByMedalCode onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/medal/getCouponByMedalCode").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(paramb)).enqueue(parama);
  }
  
  public static final void getEquities(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.b> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getEquities start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, parama1, new com.ziroom.datacenter.remote.c.f(com.alibaba.fastjson.b.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getEquities onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.b paramAnonymousb)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getEquities onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousb);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymousb);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/market/getEquities").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void getLeanBehaviorInfo(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.e> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getLeanBehaviorInfo start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, parama1, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.e.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getLeanBehaviorInfo onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.e paramAnonymouse)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getLeanBehaviorInfo onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymouse);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/lease/getLeanBehaviorInfo").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void getMedalByMedalCode(Context paramContext, com.ziroom.datacenter.remote.d.a.c.b paramb, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.g> parama)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getMedalByMedalCode start");
    Object localObject = com.ziroom.a.a.a.a.check(paramb);
    if (localObject != null)
    {
      parama.onFailure((Throwable)localObject);
      return;
    }
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, parama, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.g.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getMedalByMedalCode onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.g paramAnonymousg)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getMedalByMedalCode onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousg);
        if (localNullPointerException != null)
        {
          parama.onFailure(localNullPointerException);
          return;
        }
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/medal/getMedalByMedalByCode").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(paramb)).enqueue(parama);
  }
  
  public static final void getMedalListByUid(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.b.f>> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getMedalListByUid start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, parama1, new com.ziroom.datacenter.remote.c.f(new com.alibaba.fastjson.m() {}) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getMedalListByUid onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.b.f> paramAnonymousList)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getMedalListByUid onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousList);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/medal/getMedalListByUid").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void getPerformInfo(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.h> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getPerformInfo start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, parama1, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.h.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getPerformInfo onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.h paramAnonymoush)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getPerformInfo onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymoush);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymoush);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymoush);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/perform/getPerformInfo").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void getSingleAuthInfo(Context paramContext, com.ziroom.datacenter.remote.d.a.c.g paramg, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.i> parama)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getSingleAuthInfo start");
    Object localObject = com.ziroom.a.a.a.a.check(paramg);
    if (localObject != null)
    {
      parama.onFailure((Throwable)localObject);
      return;
    }
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, parama, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.i.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getSingleAuthInfo onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.i paramAnonymousi)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getSingleAuthInfo onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousi);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousi);
        if (localNullPointerException != null)
        {
          parama.onFailure(localNullPointerException);
          return;
        }
        parama.onSuccess(paramAnonymousInt, paramAnonymousi);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/user/getAuthUrl").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(paramg)).enqueue(parama);
  }
  
  public static final void getThirdAuthorizationInfo(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.b.j>> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getThirdAuthorizationInfo start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, parama1, new com.ziroom.datacenter.remote.c.f(new com.alibaba.fastjson.m() {}) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getThirdAuthorizationInfo onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.b.j> paramAnonymousList)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getThirdAuthorizationInfo onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousList);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/user/getAuthCompany").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void getUserBaseInfo(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.m> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserBaseInfo start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.b(parama1, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.m.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getUserBaseInfo onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.m paramAnonymousm)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserBaseInfo onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousm);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousm);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymousm);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userInfoApiController/getUserBaseInfo").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void getUserCreditScoreBrokenLineInfo(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.l> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserCreditScoreBrokenLineInfo start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, parama1, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.l.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getUserCreditScoreBrokenLineInfo onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.l paramAnonymousl)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserCreditScoreBrokenLineInfo onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousl);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousl);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymousl);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/user/getUserGraphs").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void getUserInfoScoreRecord(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<n> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserInfoScoreRecord start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, parama1, new com.ziroom.datacenter.remote.c.f(n.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getUserInfoScoreRecord onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, n paramAnonymousn)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserInfoScoreRecord onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousn);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousn);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymousn);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userInfoApiController/getUserInfoScoreRecord").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void getUserNameAuthInfo(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<s> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserNameAuthInfo start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, parama1, new com.ziroom.datacenter.remote.c.f(s.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getUserNameAuthInfo onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, s paramAnonymouss)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserNameAuthInfo onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymouss);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymouss);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymouss);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userInfoApiController/getUserNameAuthInfo").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void getUserNameCreditInfo(Context paramContext, com.ziroom.datacenter.remote.d.a.c.f paramf, final com.ziroom.datacenter.remote.b.a<o> parama)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserNameCreditInfo start");
    Object localObject = com.ziroom.a.a.a.a.check(paramf);
    if (localObject != null)
    {
      parama.onFailure((Throwable)localObject);
      return;
    }
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, parama, new com.ziroom.datacenter.remote.c.f(o.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getUserNameCreditInfo onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, o paramAnonymouso)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserNameCreditInfo onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymouso);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymouso);
        if (localNullPointerException != null)
        {
          parama.onFailure(localNullPointerException);
          return;
        }
        parama.onSuccess(paramAnonymousInt, paramAnonymouso);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userInfoApiController/getUserNameCreditInfo").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(paramf)).enqueue(parama);
  }
  
  public static final void getUserNegativeRecord(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<p> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserNegativeRecord start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, parama1, new com.ziroom.datacenter.remote.c.f(p.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getUserNegativeRecord onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, p paramAnonymousp)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserNegativeRecord onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousp);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousp);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymousp);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/user/getUserNegatives").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void getUserRankInfo(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<q> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserRankInfo start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, parama1, new com.ziroom.datacenter.remote.c.f(q.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getUserRankInfo onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, q paramAnonymousq)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserRankInfo onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousq);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousq);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymousq);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/user/searchUserRank").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void getUserScoreInfoByUid(Context paramContext, com.ziroom.datacenter.remote.d.a.c.i parami, final com.ziroom.datacenter.remote.b.a<r> parama)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserScoreInfoByUid start");
    Object localObject = com.ziroom.a.a.a.a.check(parami);
    if (localObject != null)
    {
      parama.onFailure((Throwable)localObject);
      return;
    }
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, parama, new com.ziroom.datacenter.remote.c.f(r.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getUserScoreInfoByUid onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, r paramAnonymousr)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserScoreInfoByUid onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousr);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousr);
        if (localNullPointerException != null)
        {
          parama.onFailure(localNullPointerException);
          return;
        }
        parama.onSuccess(paramAnonymousInt, paramAnonymousr);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userInfoApiController/getUserScoreInfo").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parami)).enqueue(parama);
  }
  
  public static final void getUserTotalScoreInfoByUid(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.k> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserTotalScoreInfoByUid start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, parama1, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.k.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getUserTotalScoreInfoByUid onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.k paramAnonymousk)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserTotalScoreInfoByUid onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousk);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousk);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymousk);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userInfoApiController/getUserTotalScoreInfoByUid").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void getUserZhiMaScoreRecord(Context paramContext, com.ziroom.datacenter.remote.d.a.c.a parama, final com.ziroom.datacenter.remote.b.a<t> parama1)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserZhiMaScoreRecord start");
    Object localObject = com.ziroom.a.a.a.a.check(parama);
    if (localObject != null)
    {
      parama1.onFailure((Throwable)localObject);
      return;
    }
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, parama1, new com.ziroom.datacenter.remote.c.f(t.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl getUserZhiMaScoreRecord onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, t paramAnonymoust)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl getUserZhiMaScoreRecord onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymoust);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymoust);
        if (localNullPointerException != null)
        {
          parama1.onFailure(localNullPointerException);
          return;
        }
        parama1.onSuccess(paramAnonymousInt, paramAnonymoust);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userInfoApiController/getUserHistoryScoreRecord").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(parama)).enqueue(parama1);
  }
  
  public static final void userAuthorization(Context paramContext, com.ziroom.datacenter.remote.d.a.c.h paramh, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl userAuthorization start");
    Object localObject = com.ziroom.a.a.a.a.check(paramh);
    if (localObject != null)
    {
      parama.onFailure((Throwable)localObject);
      return;
    }
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, parama, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.c.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl userAuthorization onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.c paramAnonymousc)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl userAuthorization onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousc);
        if (localNullPointerException != null)
        {
          parama.onFailure(localNullPointerException);
          return;
        }
        parama.onSuccess(paramAnonymousInt, paramAnonymousc);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userInfoApiController/userAuthorization").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(paramh)).enqueue(parama);
  }
  
  public static final void userEducationCredit(Context paramContext, com.ziroom.datacenter.remote.d.a.c.c paramc, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl userEducationCredit start");
    Object localObject = com.ziroom.a.a.a.a.check(paramc);
    if (localObject != null)
    {
      parama.onFailure((Throwable)localObject);
      return;
    }
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, parama, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.c.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl userEducationCredit onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.c paramAnonymousc)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl userEducationCredit onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousc);
        if (localNullPointerException != null)
        {
          parama.onFailure(localNullPointerException);
          return;
        }
        parama.onSuccess(paramAnonymousInt, paramAnonymousc);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userInfoApiController/userEducationCredit").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(paramc)).enqueue(parama);
  }
  
  public static final void userWorkCredit(Context paramContext, com.ziroom.datacenter.remote.d.a.c.j paramj, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl userWorkCredit start");
    Object localObject = com.ziroom.a.a.a.a.check(paramj);
    if (localObject != null)
    {
      parama.onFailure((Throwable)localObject);
      return;
    }
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, parama, new com.ziroom.datacenter.remote.c.f(com.ziroom.datacenter.remote.responsebody.financial.b.c.class) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.commonlib.utils.l.e("nh", "FinancialRequestImpl userWorkCredit onFailure");
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.c paramAnonymousc)
      {
        com.ziroom.commonlib.utils.l.d("nh", "FinancialRequestImpl userWorkCredit onSuccess");
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        NullPointerException localNullPointerException = com.ziroom.a.a.a.a.check(paramAnonymousc);
        if (localNullPointerException != null)
        {
          parama.onFailure(localNullPointerException);
          return;
        }
        parama.onSuccess(paramAnonymousInt, paramAnonymousc);
      }
    };
    localObject = new HashMap();
    ((HashMap)localObject).putAll(com.ziroom.datacenter.c.b.getHeader(paramContext));
    ((HashMap)localObject).put("needToken", "true");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "credit/api/userInfoApiController/userWorkCredit").tag(paramContext).headers((Map)localObject).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getGateWayParam(paramj)).enqueue(parama);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */