package com.ziroom.datacenter.remote.e;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.parser.Feature;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.datacenter.remote.f.d.a;
import com.ziroom.datacenter.remote.f.d.b;
import com.ziroom.datacenter.remote.f.d.c;
import com.ziroom.datacenter.remote.f.d.d;
import com.ziroom.datacenter.remote.f.d.e;
import com.ziroom.datacenter.remote.f.d.f;
import com.ziroom.datacenter.remote.f.d.g;
import com.ziroom.datacenter.remote.f.d.h;
import com.ziroom.datacenter.remote.f.d.i;
import com.ziroom.datacenter.remote.f.d.j;
import com.ziroom.datacenter.remote.f.d.k;
import com.ziroom.datacenter.remote.responsebody.financial.CertInfoEntity;
import com.ziroom.datacenter.remote.responsebody.financial.chat.ChatMapMoveHouse;
import com.ziroom.datacenter.remote.responsebody.financial.clean.CleanSupply;
import com.ziroom.datacenter.remote.responsebody.financial.clean.aa;
import com.ziroom.datacenter.remote.responsebody.financial.clean.ab;
import com.ziroom.datacenter.remote.responsebody.financial.clean.ac;
import com.ziroom.datacenter.remote.responsebody.financial.clean.ad;
import com.ziroom.datacenter.remote.responsebody.financial.clean.ae;
import com.ziroom.datacenter.remote.responsebody.financial.clean.af;
import com.ziroom.datacenter.remote.responsebody.financial.clean.y;
import com.ziroom.datacenter.remote.responsebody.financial.clean.z;
import com.ziroom.datacenter.remote.responsebody.financial.move.MovingVanGoods;
import com.ziroom.datacenter.remote.responsebody.financial.move.MovingVanServiceCategory;
import com.ziroom.datacenter.remote.responsebody.financial.youpin.YouPinAddressMo;
import com.ziroom.datacenter.remote.responsebody.financial.youpin.YouPinCouponMo;
import com.ziroom.datacenter.remote.responsebody.financial.youpin.YouPinSKUMo;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
{
  public static void InternalRepairGetDesc(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.repair.b> parama)
  {
    paramString1 = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.repair.b.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.repair.b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        parama.onSuccess(paramAnonymousInt, paramAnonymousb);
      }
    };
    parama = new HashMap();
    parama.put("keywords", "");
    parama.put("goodsCode", paramString2);
    paramString2 = new HashMap();
    paramString2.put("json", com.alibaba.fastjson.a.toJSONString(parama));
    com.ziroom.datacenter.c.b.internalRepairBaseParams(paramString2);
    paramString2.put("sign", com.ziroom.datacenter.c.b.signParams(paramString2));
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.s + d.h.u, paramString2, paramString1);
  }
  
  public static void addYouPinShoppingCart(Context paramContext, List<Object> paramList, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(String.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("cartKey", com.alibaba.fastjson.a.toJSONString(paramList));
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.y, localHashMap, parama);
  }
  
  public static void addYouPinShoppingCartCheck(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(String.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("productCode", paramString);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.x, localHashMap, parama);
  }
  
  public static void bindingGoodsCoupon(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(String.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("typeCode", paramString);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, com.ziroom.datacenter.remote.f.b.w + d.k.j, localHashMap, parama);
  }
  
  public static void callbacktExceptionCreditResult(Activity paramActivity, String paramString, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    com.ziroom.datacenter.remote.d.a.c.k localk = new com.ziroom.datacenter.remote.d.a.c.k();
    localk.setExceptionCode(paramString);
    d.callbacktExceptionCreditResult(paramActivity, localk, parama);
  }
  
  public static void callbacktUserNameCreditResult(Activity paramActivity, String paramString, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    com.ziroom.datacenter.remote.d.a.c.m localm = new com.ziroom.datacenter.remote.d.a.c.m();
    localm.setToken(paramString);
    d.callbacktUserNameCreditResult(paramActivity, localm, parama);
  }
  
  public static void callbacktUserNameCreditResult(Activity paramActivity, String paramString1, String paramString2, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    com.ziroom.datacenter.remote.d.a.c.l locall = new com.ziroom.datacenter.remote.d.a.c.l();
    locall.setZhimaSign(paramString1);
    locall.setZhimaParams(paramString2);
    locall.setRealNameFlag("");
    d.callbacktUserNameCreditResult(paramActivity, locall, parama);
  }
  
  public static void cancelInternalRepairOrder(Context paramContext, String paramString, List<String> paramList, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.g> parama)
  {
    com.ziroom.datacenter.remote.a.a local122 = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(null))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    parama = com.ziroom.commonlib.utils.b.getUserInfo();
    if (parama == null) {
      return;
    }
    parama = parama.getPhone();
    String str = com.ziroom.commonlib.utils.e.getNowDate();
    HashMap localHashMap = new HashMap();
    localHashMap.put("signDate", str);
    localHashMap.put("loginPhone", parama);
    localHashMap.put("result", com.ziroom.commonlib.utils.g.toMd5((SignKeyUtil.getSignKey() + parama + str).getBytes()));
    int j = paramList.size();
    if (j == 1) {
      localHashMap.put("wxxmId", paramList.get(0));
    }
    for (;;)
    {
      localHashMap.put("desc", paramString);
      paramString = new HashMap();
      paramString.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
      com.ziroom.datacenter.c.b.internalRepairBaseParams(paramString);
      paramString.put("sign", com.ziroom.datacenter.c.b.signParams(paramString));
      com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.s + d.g.s, paramString, local122);
      return;
      parama = "";
      int i = 0;
      if (i < j)
      {
        if (i != j - 1) {}
        for (parama = parama + (String)paramList.get(i) + "|";; parama = parama + (String)paramList.get(i))
        {
          i += 1;
          break;
        }
      }
      localHashMap.put("wxxmId", parama);
    }
  }
  
  public static void checkLimit(Activity paramActivity, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    d.checkLimit(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void confirmGoodsOrder(Context paramContext, com.ziroom.datacenter.remote.d.a.g.a parama, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.e> parama1)
  {
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.e.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama1.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    parama = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(parama), new com.alibaba.fastjson.m() {}, new Feature[0]);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.m, parama, parama1);
  }
  
  public static void confirmInternalRepairPlan(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.g> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(null))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailBillId", paramString1);
    localHashMap.put("wxxmId", paramString2);
    paramString1 = new HashMap();
    paramString1.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    com.ziroom.datacenter.c.b.internalRepairBaseParams(paramString1);
    paramString1.put("sign", com.ziroom.datacenter.c.b.signParams(paramString1));
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.s + d.g.z, paramString1, parama);
  }
  
  public static void createMvOrder(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.c(new com.ziroom.datacenter.remote.c.j(String.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("productCode", paramString1);
    locale.put("userToken", paramString2);
    locale.put("channelCode", paramString3);
    locale.put("channelName", paramString4);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/createOrder", locale, parama);
  }
  
  public static void delGestureLock(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.r())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    paramString1 = com.ziroom.datacenter.c.b.buildCommonHeaderWithToken(paramContext, paramString1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("password", com.ziroom.commonlib.utils.g.toMd5(('c' + paramString2 + 'b').getBytes()));
    com.ziroom.datacenter.c.a.requestWithHeaderV2ByGet(paramContext, com.ziroom.datacenter.remote.f.b.p + "gestures/v1", paramString1, localHashMap, parama);
  }
  
  public static void getAcarusLKillingProject(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.c> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.clean.c.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.c paramAnonymousc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        parama.onSuccess(paramAnonymousInt, paramAnonymousc);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("serviceInfoId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "5.0");
    com.ziroom.datacenter.c.a.requestJson(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.bw, locale, parama);
  }
  
  public static void getAccountCards(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.c> parama)
  {
    com.ziroom.datacenter.c.a.requestCommonAccountByGet(paramContext, "account/bankcard/binded.json", new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.l(com.ziroom.datacenter.remote.responsebody.financial.c.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.c paramAnonymousc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        parama.onSuccess(paramAnonymousInt, paramAnonymousc);
      }
    });
  }
  
  public static void getAccountDetails(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.a.a> parama)
  {
    com.ziroom.datacenter.c.a.requestCommonAccountByGet(paramContext, "account/withdraw/detail.json", new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.l(com.ziroom.datacenter.remote.responsebody.financial.a.a.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.a.a paramAnonymousa)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousa);
        parama.onSuccess(paramAnonymousInt, paramAnonymousa);
      }
    });
  }
  
  public static void getAccountWithdraw(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.a> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.k(com.ziroom.datacenter.remote.responsebody.a.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.a paramAnonymousa)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousa);
        parama.onSuccess(paramAnonymousInt, paramAnonymousa);
      }
    };
    paramString = com.ziroom.datacenter.c.b.buildWithdraw(paramString);
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.m + "account/balance/total.json", paramString, parama);
  }
  
  public static void getAddBandCard(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.commonlib.ziroomhttp.f.b())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlib.utils.m.getToken());
    localHashMap.put("is_newsign", "0");
    localHashMap.put("cert_type", paramString + "");
    com.ziroom.commonlib.ziroomhttp.a.get(com.ziroom.datacenter.remote.f.b.n + d.j.p).tag(paramContext).addHeader("Accept", "application/json; version=1").params(com.ziroom.datacenter.c.b.getPassportSign(localHashMap)).enqueue(parama);
  }
  
  public static void getAppeal(Activity paramActivity, String paramString, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    com.ziroom.datacenter.remote.d.a.c.d locald = new com.ziroom.datacenter.remote.d.a.c.d();
    locald.setWorkOrder(paramString);
    d.getAppeal(paramActivity, locald, parama);
  }
  
  public static void getBacklogs(Activity paramActivity, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.a> parama)
  {
    com.ziroom.datacenter.remote.d.a.c.e locale = new com.ziroom.datacenter.remote.d.a.c.e();
    locale.setVer(2);
    d.getBacklogs(paramActivity, locale, parama);
  }
  
  public static void getBalanceSums(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.a> parama)
  {
    com.ziroom.datacenter.c.a.requestCommonAccountByGet(paramContext, "account/balance/total.json", new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.l(com.ziroom.datacenter.remote.responsebody.financial.a.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.a paramAnonymousa)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousa);
        parama.onSuccess(paramAnonymousInt, paramAnonymousa);
      }
    });
  }
  
  public static void getBankList(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b> parama)
  {
    com.ziroom.datacenter.c.a.requestCommonAccountByGet(paramContext, "account/bankcard/list.json", new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.l(com.ziroom.datacenter.remote.responsebody.financial.b.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        parama.onSuccess(paramAnonymousInt, paramAnonymousb);
      }
    });
  }
  
  public static void getBannerList(Activity paramActivity, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.b> parama)
  {
    d.getBannerList(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void getBestGoodsAddressList(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<YouPinAddressMo>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(YouPinAddressMo.class, false))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<YouPinAddressMo> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", "1");
    localHashMap.put("pageSize", "1000");
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.g.c, localHashMap, parama);
  }
  
  public static void getBindCards(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.a> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.l(com.ziroom.datacenter.remote.responsebody.a.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.a paramAnonymousa)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousa);
        parama.onSuccess(paramAnonymousInt, paramAnonymousa);
      }
    };
    paramString1 = com.ziroom.datacenter.c.b.buildAddCards(paramString1, paramString2, paramString3, paramString4, paramString5);
    com.ziroom.datacenter.c.a.requestWithHeaderByPost(paramContext, com.ziroom.datacenter.remote.f.b.m + d.f.a, paramString1, parama);
  }
  
  public static void getBiweeklyCleanAllDate(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.b> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.g(new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.b paramAnonymousb)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousb);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("workBillId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("dataSource", Integer.valueOf(12));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.aq, locale, parama);
  }
  
  public static void getBiweeklyCleanAllTime(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.b> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.g(new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        parama.onSuccess(paramAnonymousInt, paramAnonymousb);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("dataSource", Integer.valueOf(12));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.ar, locale, parama);
  }
  
  public static void getBiweeklyCleanContractValidate(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(String.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("rentContractCode", paramString1);
    locale.put("hireContractCode", paramString2);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("dataSource", Integer.valueOf(12));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.al, locale, parama);
  }
  
  public static void getBiweeklyCleanMonthList(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.h(new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("rentContractCode", paramString1);
    locale.put("hireContractCode", paramString2);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("dataSource", Integer.valueOf(12));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.an, locale, parama);
  }
  
  public static void getBiweeklyCleanerAllEvalList(Context paramContext, String paramString, int paramInt1, int paramInt2, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.clean.b>> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.i(com.ziroom.datacenter.remote.responsebody.financial.clean.b.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.clean.b> paramAnonymousList)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("cleanId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "2");
    locale.put("page", Integer.valueOf(paramInt1));
    locale.put("pageSize", Integer.valueOf(paramInt2));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.aD, locale, parama);
  }
  
  public static void getBiweeklyCleanerInfo(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.a> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.clean.a.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.a paramAnonymousa)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousa);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("cleanId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "2");
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.as, locale, parama);
  }
  
  public static void getBiweeklyCleanerInfoByContract(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<z> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(z.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, z paramAnonymousz)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousz);
        parama.onSuccess(paramAnonymousInt, paramAnonymousz);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("rentContractCode", paramString1);
    locale.put("hireContractCode", paramString2);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("dataSource", Integer.valueOf(12));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.at, locale, parama);
  }
  
  public static void getBusinessType(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.chat.a>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.u(com.ziroom.datacenter.remote.responsebody.financial.chat.a.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.chat.a> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    com.ziroom.datacenter.c.a.requestJson(paramContext, com.ziroom.datacenter.remote.f.b.q + d.a.a, localHashMap, parama);
  }
  
  public static void getCertInfo(Context paramContext, String paramString, int paramInt, final com.ziroom.datacenter.remote.b.a<CertInfoEntity> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.l(CertInfoEntity.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, CertInfoEntity paramAnonymousCertInfoEntity)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousCertInfoEntity);
        parama.onSuccess(paramAnonymousInt, paramAnonymousCertInfoEntity);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString);
    localHashMap.put("is_newsign", String.valueOf(paramInt));
    com.ziroom.datacenter.c.b.getPassportSign(localHashMap);
    com.ziroom.datacenter.c.a.requestWithHeaderV1ByGet(paramContext, com.ziroom.datacenter.remote.f.b.m + "account/cert/select.json", localHashMap, parama);
  }
  
  public static void getCertList(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.b())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    Object localObject = new HashMap();
    ((Map)localObject).put("osType", "android");
    ((Map)localObject).put("appVersionStr", com.ziroom.commonlib.utils.f.getVersion());
    localObject = com.ziroom.datacenter.c.b.getCommonHouseSign((Map)localObject);
    paramContext = com.ziroom.datacenter.c.b.getHeader(paramContext);
    paramContext.put("Accept", "application/json; version=2");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + d.e.K).headers(paramContext).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getParam((Map)localObject)).enqueue(parama);
  }
  
  public static void getClasssQueations(Context paramContext, int paramInt1, int paramInt2, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.chat.l>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.c(com.ziroom.datacenter.remote.responsebody.financial.chat.l.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.chat.l> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("clientType", "ZIROOM_APP");
    locale.put("pageNum", Integer.valueOf(paramInt1));
    locale.put("pageSize", Integer.valueOf(paramInt2));
    com.ziroom.datacenter.c.a.requestGateWayService(paramContext, com.ziroom.datacenter.remote.f.b.l + "zmcApi/lore/categories", locale, parama);
  }
  
  public static void getCleanBottomCleaner(Context paramContext, double paramDouble1, double paramDouble2, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.clean.n>> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.c(com.ziroom.datacenter.remote.responsebody.financial.clean.n.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.clean.n> paramAnonymousList)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("longitude", Double.valueOf(paramDouble1));
    locale.put("latitude", Double.valueOf(paramDouble2));
    com.ziroom.datacenter.c.a.requestGateWayCommonService(paramContext, com.ziroom.datacenter.remote.f.b.l + "cleanApi/zrk/generalclean/findNearbyCleaner", locale, parama);
  }
  
  public static void getCleanCardLeft(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.j> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.clean.j.class, new com.ziroom.datacenter.remote.c.a.b()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.j paramAnonymousj)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousj);
        parama.onSuccess(paramAnonymousInt, paramAnonymousj);
      }
    };
    Map localMap = com.ziroom.datacenter.c.b.buildCleanCardLeft(paramContext, com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.aM, localMap, parama);
  }
  
  public static void getCleanDataTime(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.clean.g>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.clean.g.class, true))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.clean.g> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    paramString1 = com.ziroom.datacenter.c.b.buildCleanDataTime(paramString1, paramString2);
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.ak, paramString1, parama);
  }
  
  public static void getCleanTopLunBoPic(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.clean.v>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.c(com.ziroom.datacenter.remote.responsebody.financial.clean.v.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.clean.v> paramAnonymousList)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", Integer.valueOf(2));
    com.ziroom.datacenter.c.a.requestGateWayCommonService(paramContext, com.ziroom.datacenter.remote.f.b.l + "cleanApi/zrk/display/clean/slider", locale, parama);
  }
  
  public static void getCleanTyepList(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.m> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.d(com.ziroom.datacenter.remote.responsebody.financial.clean.m.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.m paramAnonymousm)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousm);
        parama.onSuccess(paramAnonymousInt, paramAnonymousm);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", Integer.valueOf(2));
    com.ziroom.datacenter.c.a.requestGateWayCommonService(paramContext, com.ziroom.datacenter.remote.f.b.l + "cleanApi/zrk/display/clean/products/v1", locale, parama);
  }
  
  public static void getCleanerCapacity(Context paramContext, com.ziroom.datacenter.remote.d.a.b.i parami, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.clean.i>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.clean.i.class, true))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.clean.i> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    parami = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(parami), new com.alibaba.fastjson.m() {}, new Feature[0]);
    parami.put("timestamp", System.currentTimeMillis() + "");
    parami.put("uid", com.ziroom.commonlib.utils.m.getUid());
    parami.put("cityCode", com.ziroom.commonlib.utils.c.b);
    parami.put("dataSource", "12");
    parami = com.ziroom.datacenter.c.b.createPostEncode(com.alibaba.fastjson.a.toJSONString(parami));
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.bb, parami, parama);
  }
  
  public static void getCleanerEvalInfo(Context paramContext, com.ziroom.datacenter.remote.d.a.b.j paramj, final com.ziroom.datacenter.remote.b.a<List<y>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(y.class, true))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<y> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    paramj = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramj), new com.alibaba.fastjson.m() {}, new Feature[0]);
    paramj.put("timestamp", System.currentTimeMillis() + "");
    paramj.put("cityCode", com.ziroom.commonlib.utils.c.b);
    paramj.put("dataSource", "12");
    paramj = com.ziroom.datacenter.c.b.createPostEncode(com.alibaba.fastjson.a.toJSONString(paramj));
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.ba, paramj, parama);
  }
  
  public static void getCleanerInfo(Context paramContext, com.ziroom.datacenter.remote.d.a.b.k paramk, final com.ziroom.datacenter.remote.b.a<List<z>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(z.class, true))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<z> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    paramk = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramk), new com.alibaba.fastjson.m() {}, new Feature[0]);
    paramk.put("timestamp", System.currentTimeMillis() + "");
    paramk.put("uid", com.ziroom.commonlib.utils.m.getUid());
    paramk.put("cityCode", com.ziroom.commonlib.utils.c.b);
    paramk.put("dataSource", "12");
    paramk = com.ziroom.datacenter.c.b.createPostEncode(com.alibaba.fastjson.a.toJSONString(paramk));
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.aZ, paramk, parama);
  }
  
  public static void getCommonCleanCapacity(Context paramContext, com.ziroom.datacenter.remote.d.a.b.i parami, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.clean.i>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.clean.i.class, true))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.clean.i> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    parami = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(parami), new com.alibaba.fastjson.m() {}, new Feature[0]);
    parami.put("timestamp", System.currentTimeMillis() + "");
    parami.put("uid", com.ziroom.commonlib.utils.m.getUid());
    parami.put("cityCode", com.ziroom.commonlib.utils.c.b);
    parami.put("dataSource", "12");
    parami = com.ziroom.datacenter.c.b.createPostEncode(com.alibaba.fastjson.a.toJSONString(parami));
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.aX, parami, parama);
  }
  
  public static void getCommonDicTag(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.clean.k>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.c(com.ziroom.datacenter.remote.responsebody.financial.clean.k.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.clean.k> paramAnonymousList)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("dicType", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + "zrk/commons/dicTag", locale, parama);
  }
  
  public static void getCommonJson(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.clean.u>> parama)
  {
    paramString = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.i(com.ziroom.datacenter.remote.responsebody.financial.clean.u.class, new com.ziroom.datacenter.remote.c.a.d()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.clean.u> paramAnonymousList)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.ziroom.commonlib.ziroomhttp.a.get("http://contentful.ziroom.com/online/combine/b53b3a3d6ab90ce0268229151c9bde11.json").tag(paramContext).enqueue(paramString);
  }
  
  public static void getCommonJsonGate(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.c> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.d(com.ziroom.datacenter.remote.responsebody.c.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.c paramAnonymousc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        parama.onSuccess(paramAnonymousInt, paramAnonymousc);
      }
    };
    Map localMap1 = com.ziroom.datacenter.c.b.getCommonHouseSign(new HashMap());
    Map localMap2 = com.ziroom.datacenter.c.b.getHeader(paramContext);
    localMap2.put("Accept", "application/json; version=2");
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "contentful/ziruke-app/v1/fuwu/weixiu.json").tag(paramContext).headers(localMap2).setBodyString("application/json;charset=UTF-8", com.ziroom.datacenter.c.b.getParam(localMap1)).enqueue(parama);
  }
  
  public static void getCommonTemplateOnCityV2(Context paramContext, Integer paramInteger, final com.ziroom.datacenter.remote.b.a<ab> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.d(ab.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, ab paramAnonymousab)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousab);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("noteCode", paramInteger);
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    com.ziroom.datacenter.c.a.requestGateWayCommonService(paramContext, com.ziroom.datacenter.remote.f.b.l + "cleanApi/zrk/commons/template/city/v2", locale, parama);
  }
  
  public static void getComplainTime(Context paramContext, com.ziroom.datacenter.remote.d.a.a.a parama, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.chat.e> parama1)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.k(com.ziroom.datacenter.remote.responsebody.financial.chat.e.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.chat.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama1.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    parama1 = new HashMap();
    com.ziroom.datacenter.c.a.requestJson(paramContext, com.ziroom.datacenter.remote.f.b.q + d.b.br, parama1, parama);
  }
  
  public static void getComplainTips(Context paramContext, String paramString1, String paramString2, String paramString3, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.chat.g>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.u(com.ziroom.datacenter.remote.responsebody.financial.chat.g.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.chat.g> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", paramString1);
    localHashMap.put("pageSize", paramString2);
    localHashMap.put("publicType", paramString3);
    com.ziroom.datacenter.c.a.requestJson(paramContext, com.ziroom.datacenter.remote.f.b.q + d.b.bo, localHashMap, parama);
  }
  
  public static void getComplainTypeOne(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.chat.m> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.k(com.ziroom.datacenter.remote.responsebody.financial.chat.m.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.chat.m paramAnonymousm)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousm);
        parama.onSuccess(paramAnonymousInt, paramAnonymousm);
      }
    };
    HashMap localHashMap = new HashMap();
    com.ziroom.datacenter.c.a.requestJson(paramContext, com.ziroom.datacenter.remote.f.b.q + d.b.bp, localHashMap, parama);
  }
  
  public static void getComplainTypeTwo(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.chat.m> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.k(com.ziroom.datacenter.remote.responsebody.financial.chat.m.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.chat.m paramAnonymousm)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousm);
        parama.onSuccess(paramAnonymousInt, paramAnonymousm);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString);
    com.ziroom.datacenter.c.a.requestJson(paramContext, com.ziroom.datacenter.remote.f.b.q + d.b.bq, localHashMap, parama);
  }
  
  public static void getCouponByMedalCode(Activity paramActivity, String paramString, com.ziroom.datacenter.remote.b.a parama)
  {
    com.ziroom.datacenter.remote.d.a.c.b localb = new com.ziroom.datacenter.remote.d.a.c.b();
    localb.setMedalCode(paramString);
    d.getCouponByMedalCode(paramActivity, localb, parama);
  }
  
  public static void getDeliverRegion(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.youpin.h>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.youpin.h.class, false, "list"))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.youpin.h> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.o, parama);
  }
  
  public static void getDicTag(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.b> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.g(new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        parama.onSuccess(paramAnonymousInt, paramAnonymousb);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("dicType", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "2");
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + "zrk/commons/dicTag", locale, parama);
  }
  
  public static void getEquities(Activity paramActivity, com.ziroom.datacenter.remote.b.a parama)
  {
    d.getEquities(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void getGeneralCleanPay(Context paramContext, String paramString, float paramFloat, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.g> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.g.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    Map localMap = com.ziroom.datacenter.c.b.getCardCommon(paramContext);
    localMap.put("terminalType", "android");
    localMap.put("terminalVersion", com.ziroom.commonlib.utils.f.getVersion());
    localMap.put("orderId", paramString);
    localMap.put("money", Float.valueOf(paramFloat));
    localMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.aL, com.ziroom.datacenter.c.b.convertObjMap2String(localMap), parama);
  }
  
  public static void getGeneralCleanQuestion(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.q> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.clean.q.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.q paramAnonymousq)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousq);
        parama.onSuccess(paramAnonymousInt, paramAnonymousq);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("workBillId", paramString);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.bP, locale, parama);
  }
  
  public static void getGeneralCostEvaluation(Context paramContext, com.ziroom.datacenter.remote.d.a.b.d paramd, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.clean.e.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    paramd = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramd), new com.alibaba.fastjson.m() {}, new Feature[0]);
    paramd.put("timestamp", System.currentTimeMillis() + "");
    paramd.put("cityCode", com.ziroom.commonlib.utils.c.b);
    paramd.put("uid", com.ziroom.commonlib.utils.m.getUid());
    paramd.put("version", "V1.4");
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.A, paramd, parama);
  }
  
  public static void getGeneralCreateOrder(Context paramContext, com.ziroom.datacenter.remote.responsebody.financial.clean.e parame, String paramString1, String paramString2, String paramString3, final com.ziroom.datacenter.remote.b.a<ac> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.n(ac.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, ac paramAnonymousac)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousac);
        parama.onSuccess(paramAnonymousInt, paramAnonymousac);
      }
    };
    parame = com.ziroom.datacenter.c.b.buildNewCreateGOrder(parame, paramString1, paramString2, paramString3);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.P, parame, parama);
  }
  
  public static void getGeneralDefaultMessage(Context paramContext, String paramString1, String paramString2, String paramString3, final com.ziroom.datacenter.remote.b.a<ad> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.n(ad.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, ad paramAnonymousad)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousad);
        parama.onSuccess(paramAnonymousInt, paramAnonymousad);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("uid", paramString2);
    locale.put("serviceInfoId", paramString1);
    locale.put("zhengZu", paramString3);
    locale.put("version", "V1.4");
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.K, locale, parama);
  }
  
  public static void getGeneralDetail(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<ae> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(ae.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, ae paramAnonymousae)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousae);
        parama.onSuccess(paramAnonymousInt, paramAnonymousae);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("cleanId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.bN, locale, parama);
  }
  
  public static void getGeneralItem(Context paramContext, int paramInt1, int paramInt2, String paramString, final com.ziroom.datacenter.remote.b.a<List<aa>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.i(aa.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<aa> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("page", Integer.valueOf(paramInt1));
    locale.put("pageSize", Integer.valueOf(paramInt2));
    locale.put("serviceInfoId", paramString);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.L, locale, parama);
  }
  
  public static void getGeneralOrderCancle(Context paramContext, String paramString1, String paramString2, String paramString3, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(String.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("cleanId", paramString1);
    locale.put("uid", paramString2);
    locale.put("reason", paramString3);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.X, locale, parama);
  }
  
  public static void getGeneralOrderControl(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<af> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(af.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, af paramAnonymousaf)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousaf);
        parama.onSuccess(paramAnonymousInt, paramAnonymousaf);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("orderCode", paramString);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.bM, locale, parama);
  }
  
  public static void getGestureLock(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.r())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    paramString = com.ziroom.datacenter.c.b.buildCommonHeaderWithToken(paramContext, paramString);
    com.ziroom.datacenter.c.a.requestWithHeaderV2ByGet(paramContext, com.ziroom.datacenter.remote.f.b.p + "gestures/v1", paramString, parama);
  }
  
  public static void getGoodsCoupon(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<YouPinCouponMo>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(YouPinCouponMo.class, false, "list"))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<YouPinCouponMo> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("productCode", paramString);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.i, localHashMap, parama);
  }
  
  public static void getGoodsCouponList(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.d>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.d.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.d> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("serviceInfoId", paramString1);
    localHashMap.put("totalPrice", paramString2 + "");
    localHashMap.put("page", "1");
    localHashMap.put("pageSize", "1000");
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.k, localHashMap, parama);
  }
  
  public static void getGoodsDetailData(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.k> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.youpin.k.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.k paramAnonymousk)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousk);
        parama.onSuccess(paramAnonymousInt, paramAnonymousk);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("productCode", paramString1);
    localHashMap.put("skuCode", paramString2);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.f, localHashMap, parama);
  }
  
  public static void getGoodsEvalList(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.youpin.i>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.youpin.i.class, false, "list"))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.youpin.i> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("productCode", paramString);
    localHashMap.put("page", "1");
    localHashMap.put("pageSize", "10000");
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, com.ziroom.datacenter.remote.f.b.w + d.k.l, localHashMap, parama);
  }
  
  public static void getGoodsPropertyV2(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.l> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.youpin.l.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.l paramAnonymousl)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousl);
        parama.onSuccess(paramAnonymousInt, paramAnonymousl);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("productCode", paramString1);
    localHashMap.put("skuCode", paramString2);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.g, localHashMap, parama);
  }
  
  public static void getHotQuestionLabel(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.chat.k>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.u(com.ziroom.datacenter.remote.responsebody.financial.chat.k.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.chat.k> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("wordType", "HOTSPOT");
    localHashMap.put("hotspot", String.valueOf(true));
    com.ziroom.datacenter.c.a.requestJsonWithParams(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.by, localHashMap, parama);
  }
  
  public static void getHuifuBandCard(Context paramContext, com.ziroom.datacenter.remote.d.a.f.c paramc, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.c.j> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.p(com.ziroom.datacenter.remote.responsebody.financial.c.j.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.c.j paramAnonymousj)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousj);
        parama.onSuccess(paramAnonymousInt, paramAnonymousj);
      }
    };
    paramc = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramc), new com.alibaba.fastjson.m() {}, new Feature[0]);
    com.ziroom.datacenter.c.b.appendCommenParams(paramc);
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.v + "/api/other/HFbindBank.do", paramc, parama);
  }
  
  public static void getHuifuBandProvinceAndCityList(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.c.l>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.o(com.ziroom.datacenter.remote.responsebody.financial.c.l.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.c.l> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(3));
    com.ziroom.datacenter.c.a.requestAPIHOSTSTransferUnion(paramContext, localHashMap, parama);
  }
  
  public static void getHuifuBankData(Context paramContext, com.ziroom.datacenter.remote.d.a.f.c paramc, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.c.k>> parama)
  {
    paramc = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.o(com.ziroom.datacenter.remote.responsebody.financial.c.k.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.c.k> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    parama = new HashMap();
    parama.put("interfaceId", Integer.valueOf(5));
    com.ziroom.datacenter.c.a.requestAPIHOSTSTransferUnion(paramContext, parama, paramc);
  }
  
  public static void getInternalOrderDetail(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.repair.a> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.repair.a.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.repair.a paramAnonymousa)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousa);
        parama.onSuccess(paramAnonymousInt, paramAnonymousa);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderCode", paramString1);
    localHashMap.put("orderCodeType", paramString2);
    paramString1 = new HashMap();
    paramString1.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    com.ziroom.datacenter.c.b.internalRepairBaseParams(paramString1);
    paramString1.put("sign", com.ziroom.datacenter.c.b.signParams(paramString1));
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.s + d.g.w, localHashMap, parama);
  }
  
  public static void getInternalRepairEvalList(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.repair.h>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.repair.h.class, false))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.repair.h> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    Map localMap = com.ziroom.datacenter.c.b.internalRepairBaseParams(null);
    localMap.put("sign", com.ziroom.datacenter.c.b.signParams(localMap));
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.s + d.g.u, localMap, parama);
  }
  
  public static void getInternalRepairFaultTag(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.repair.c> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.repair.c.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.repair.c paramAnonymousc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        parama.onSuccess(paramAnonymousInt, paramAnonymousc);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("keywords", paramString1);
    locale.put("goodsCode", paramString2);
    com.ziroom.datacenter.c.a.requestCommonRepairWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.s + d.g.E, locale, parama);
  }
  
  public static void getInternalRepairGoodList(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.repair.d>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.i(com.ziroom.datacenter.remote.responsebody.financial.repair.d.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.repair.d> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.ziroom.datacenter.c.a.requestCommonRepairWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.s + d.g.G, null, parama);
  }
  
  public static void getInternalRepairPlanDetail(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.repair.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.repair.e.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.repair.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailBillId", paramString);
    paramString = new HashMap();
    paramString.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    com.ziroom.datacenter.c.b.internalRepairBaseParams(paramString);
    paramString.put("sign", com.ziroom.datacenter.c.b.signParams(paramString));
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.s + d.g.y, paramString, parama);
  }
  
  public static void getInternalRepairTime(Context paramContext, String paramString1, String paramString2, String paramString3, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.repair.o> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.repair.o.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.repair.o paramAnonymouso)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouso);
        parama.onSuccess(paramAnonymousInt, paramAnonymouso);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("zhutiCode", paramString1);
    localHashMap.put("cityCode", com.ziroom.commonlib.utils.c.b);
    localHashMap.put("goodsId", paramString2);
    localHashMap.put("tagId", paramString3);
    paramString1 = new HashMap();
    paramString1.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    com.ziroom.datacenter.c.b.internalRepairBaseParams(paramString1);
    paramString1.put("sign", com.ziroom.datacenter.c.b.signParams(paramString1));
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.s + d.g.C, paramString1, parama);
  }
  
  public static void getIsBandCardResult(Context paramContext, String paramString, int paramInt, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.c.b> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.p(com.ziroom.datacenter.remote.responsebody.financial.c.b.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.c.b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        parama.onSuccess(paramAnonymousInt, paramAnonymousb);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("cwOrderId", paramString);
    localHashMap.put("type", Integer.valueOf(paramInt));
    localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonUnion(paramContext, com.ziroom.datacenter.remote.f.b.v + "/api/other/getBindBankInfo.do", localHashMap, parama);
  }
  
  public static void getLataComInfo(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.chat.f> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.v(com.ziroom.datacenter.remote.responsebody.financial.chat.f.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.chat.f paramAnonymousf)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousf);
        parama.onSuccess(paramAnonymousInt, paramAnonymousf);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestJson(paramContext, com.ziroom.datacenter.remote.f.b.q + d.b.bn, localHashMap, parama);
  }
  
  public static void getLeanBehaviorInfo(Activity paramActivity, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.e> parama)
  {
    d.getLeanBehaviorInfo(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void getMHCostEstimates(Context paramContext, com.ziroom.datacenter.remote.d.a.d.a parama, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.b> parama1)
  {
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.move.b.class, new com.ziroom.datacenter.remote.c.a.b()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        parama1.onSuccess(paramAnonymousInt, paramAnonymousb);
      }
    };
    parama = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(parama), new com.alibaba.fastjson.m() {}, new Feature[0]);
    if ((paramString != null) && (paramString.length() > 0)) {
      parama.put("promoCodeId", paramString);
    }
    parama = com.ziroom.datacenter.c.b.createPostEncode(com.alibaba.fastjson.a.toJSONString(parama));
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.t + "zrk/move/orderCostEstimates", parama, parama1);
  }
  
  public static void getMHFloorsFeeList(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.move.c>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.move.c.class, true))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.move.c> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", com.ziroom.commonlib.utils.c.b);
    localHashMap.put("serviceInfoId", paramString);
    com.ziroom.datacenter.c.a.requestCommonMove(paramContext, com.ziroom.datacenter.remote.f.b.t + d.d.h, localHashMap, parama);
  }
  
  public static void getMHServiceEntity(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<ChatMapMoveHouse>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.u(ChatMapMoveHouse.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<ChatMapMoveHouse> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    Map localMap = com.ziroom.datacenter.c.b.buildMHService();
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.t + d.d.a, localMap, parama);
  }
  
  public static void getMHToolList(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.move.l>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.move.l.class, true))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.move.l> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", paramString1);
    localHashMap.put("serviceInfoId", paramString2);
    com.ziroom.datacenter.c.a.requestCommonMove(paramContext, com.ziroom.datacenter.remote.f.b.t + "zrk/commons/goods", localHashMap, parama);
  }
  
  public static void getMateCoupon(Context paramContext, com.ziroom.datacenter.remote.d.a.b.e parame, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.l> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.clean.l.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.l paramAnonymousl)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousl);
        parama.onSuccess(paramAnonymousInt, paramAnonymousl);
      }
    };
    parame = com.ziroom.datacenter.c.b.getMvCommon(paramContext, (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(parame), new com.alibaba.fastjson.m() {}, new Feature[0]));
    parame.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.bE, parame, parama);
  }
  
  public static void getMedalByMedalByCode(Activity paramActivity, String paramString, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.g> parama)
  {
    com.ziroom.datacenter.remote.d.a.c.b localb = new com.ziroom.datacenter.remote.d.a.c.b();
    localb.setMedalCode(paramString);
    d.getMedalByMedalCode(paramActivity, localb, parama);
  }
  
  public static void getMedalListByUid(Activity paramActivity, com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.b.f>> parama)
  {
    d.getMedalListByUid(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void getMoveDetail(Context paramContext, String paramString, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.q> parama)
  {
    getMovingVanDetail(paramContext, paramString, parama);
  }
  
  public static void getMoveOrderControl(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.s> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.move.s.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.s paramAnonymouss)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouss);
        parama.onSuccess(paramAnonymousInt, paramAnonymouss);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("orderCode", paramString);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/orderActionControl", locale, parama);
  }
  
  public static void getMoveOrderState(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.move.e>> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.i(com.ziroom.datacenter.remote.responsebody.financial.move.e.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.move.e> paramAnonymousList)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("orderCode", paramString);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/orderOperateSteps", locale, parama);
  }
  
  public static void getMoveOrderSuccessTip(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.o> parama)
  {
    paramString = new com.ziroom.commonlib.ziroomhttp.c.c(new com.ziroom.datacenter.remote.c.d(com.ziroom.datacenter.remote.responsebody.financial.move.o.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.o paramAnonymouso)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymouso);
      }
    };
    parama = new com.alibaba.fastjson.e();
    parama.put("cityCode", com.ziroom.commonlib.utils.c.b);
    com.ziroom.datacenter.c.a.requestGateWayCommonService(paramContext, com.ziroom.datacenter.remote.f.b.l + "smsApi/zrk/move/customerOrder/createSuccessNotice", parama, paramString);
  }
  
  public static void getMoveSecondList(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.move.j>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.c(com.ziroom.datacenter.remote.responsebody.financial.move.j.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.move.j> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", Integer.valueOf(2));
    com.ziroom.datacenter.c.a.requestGateWayCommonService(paramContext, com.ziroom.datacenter.remote.f.b.l + "cleanApi/zrk/display/move/products/v1", locale, parama);
  }
  
  public static void getMovingVanData(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.h> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.n(com.ziroom.datacenter.remote.responsebody.financial.move.h.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.h paramAnonymoush)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymoush);
        parama.onSuccess(paramAnonymousInt, paramAnonymoush);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("serviceItemCode", paramString);
    locale.put("serviceProductCode", "2c9085f248ba3f3a0148bb151aca0003");
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + d.c.p, locale, parama);
  }
  
  public static void getMovingVanDetail(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.q> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.c(new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.move.q.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.q paramAnonymousq)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousq);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("orderCode", paramString);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/orderDetail", locale, parama);
  }
  
  public static void getMovingVanEvalInfo(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.p> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.c(new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.move.p.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.p paramAnonymousp)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousp);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("orderCode", paramString);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/orderEvaluateInfo", locale, parama);
  }
  
  public static void getMovingVanGoodsNum(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.r> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.c(new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.move.r.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.r paramAnonymousr)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousr);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("productCode", paramString);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + d.b.bH, locale, parama);
  }
  
  public static void getMovingVanTimeCityIsCan(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.f> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.d(com.ziroom.datacenter.remote.responsebody.financial.move.f.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.f paramAnonymousf)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousf);
        parama.onSuccess(paramAnonymousInt, paramAnonymousf);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("interfaceVesion", "2.0");
    com.ziroom.datacenter.c.a.requestGateWayCommonService(paramContext, com.ziroom.datacenter.remote.f.b.l + "smsApi/zrk/move/customerOrder/isTimeBlocks", locale, parama);
  }
  
  public static void getMovingVanTimePoint(Context paramContext, String paramString, long paramLong, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.k> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.n(com.ziroom.datacenter.remote.responsebody.financial.move.k.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.k paramAnonymousk)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousk);
        parama.onSuccess(paramAnonymousInt, paramAnonymousk);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("serviceItemCode", paramString);
    locale.put("serviceProductCode", "2c9085f248ba3f3a0148bb151aca0003");
    locale.put("bookableDate", Long.valueOf(paramLong));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + d.c.q, locale, parama);
  }
  
  public static void getMvEstimateCost(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.j(String.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("userToken", paramString2);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/estimateCost", locale, parama);
  }
  
  public static void getMvGoodsList(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<MovingVanGoods>> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.c(new com.ziroom.datacenter.remote.c.i(MovingVanGoods.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<MovingVanGoods> paramAnonymousList)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("productCode", paramString);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/materielList", locale, parama);
  }
  
  public static void getMvServiceList(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<MovingVanServiceCategory>> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.c(new com.ziroom.datacenter.remote.c.i(MovingVanServiceCategory.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<MovingVanServiceCategory> paramAnonymousList)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("productCode", paramString);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/serviceItemList", locale, parama);
  }
  
  public static void getMvToken(Context paramContext, String paramString1, String paramString2, String paramString3, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.h(new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("connectName", paramString2);
    locale.put("connectPhone", paramString3);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/getShoppingCartToken", locale, parama);
  }
  
  public static void getMyComplainList(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.chat.q>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.u(com.ziroom.datacenter.remote.responsebody.financial.chat.q.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.chat.q> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestJson(paramContext, com.ziroom.datacenter.remote.f.b.q + d.b.aS, localHashMap, parama);
  }
  
  public static void getNetPhone(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.chat.i>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.u(com.ziroom.datacenter.remote.responsebody.financial.chat.i.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.chat.i> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseSourceCode", paramString);
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.q + d.b.aV).params(localHashMap).tag(paramContext).enqueue(parama);
  }
  
  public static void getNewCleanGoods(Context paramContext, String paramString, int paramInt1, int paramInt2, final com.ziroom.datacenter.remote.b.a<List<CleanSupply>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(CleanSupply.class, true))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<CleanSupply> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    paramString = com.ziroom.datacenter.c.b.buildNewCleanGoods(paramContext, paramString, paramInt1, paramInt2);
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.x, paramString, parama);
  }
  
  public static void getNewCoupon(Context paramContext, String paramString1, String paramString2, String paramString3, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.g> parama)
  {
    paramString3 = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(null))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    parama = new HashMap();
    parama.put("categoryCode", paramString1);
    parama.put("serviceInfoId", paramString2);
    com.ziroom.datacenter.c.a.requestCommonYouPinAllCityByPost(paramContext, d.g.f, parama, paramString3);
  }
  
  public static void getNewGeneralAList(Context paramContext, int paramInt1, int paramInt2, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.clean.d>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.clean.d.class, true))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.clean.d> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    Map localMap = com.ziroom.datacenter.c.b.buildNewGeneralAList(paramContext, paramInt1, paramInt2);
    String str = com.ziroom.datacenter.remote.f.b.t + d.b.M;
    localMap = com.ziroom.datacenter.c.b.convertObjMap2String(localMap);
    com.ziroom.commonlib.ziroomhttp.a.post(str).tag(paramContext).params(localMap).enqueue(parama);
  }
  
  public static void getPerformInfo(Activity paramActivity, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.h> parama)
  {
    d.getPerformInfo(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void getQueationDetail(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.chat.j> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.d(com.ziroom.datacenter.remote.responsebody.financial.chat.j.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.chat.j paramAnonymousj)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousj);
        parama.onSuccess(paramAnonymousInt, paramAnonymousj);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("userType", "CUSTOMER");
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("loreGroupId", paramString);
    locale.put("loreTrackSource", "ZIROOMER_APP_MAIN_PAGE_RECOMMEND");
    com.ziroom.datacenter.c.a.requestGateWayService(paramContext, com.ziroom.datacenter.remote.f.b.l + "zmcApi/lore/detail", locale, parama);
  }
  
  public static void getQueationEventAdd(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.e())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("clientType", "ZIROOM_APP");
    locale.put("eventType", "ZIROOM_APP_CONTACT_SERVICE");
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("userType", "CUSTOMER");
    locale.put("loreLogicCode", paramString);
    com.ziroom.datacenter.c.a.requestGateWayService(paramContext, com.ziroom.datacenter.remote.f.b.l + "zmcApi/lore/event/add", locale, parama);
  }
  
  public static void getQueryCityInfo(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.youpin.e.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("code", paramString);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.q, localHashMap, parama);
  }
  
  public static void getQuestionnaire(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.r> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.clean.r.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.r paramAnonymousr)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousr);
        parama.onSuccess(paramAnonymousInt, paramAnonymousr);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("workBillId", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", "2");
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.ay, locale, parama);
  }
  
  public static void getRecommendDuration(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.h> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.clean.h.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.h paramAnonymoush)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymoush);
        parama.onSuccess(paramAnonymousInt, paramAnonymoush);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("uid", paramString2);
    locale.put("serviceInfoId", paramString1);
    locale.put("zhengZu", paramString3);
    locale.put("addressId", paramString4);
    locale.put("version", "V1.4");
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.bJ, locale, parama);
  }
  
  public static void getRepairArticle(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.repair.f>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.repair.f.class, false))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.repair.f> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("kjCode", paramString1);
    localHashMap.put("ztCode", paramString2);
    localHashMap.put("city_code", com.ziroom.commonlib.utils.c.b);
    new HashMap().put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.s + d.h.w, localHashMap, parama);
  }
  
  public static void getRepairEngineer(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.repair.g>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.repair.g.class, false))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.repair.g> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    Map localMap = com.ziroom.datacenter.c.b.buildGetRepairEngineer();
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.s + d.h.y, localMap, parama);
  }
  
  public static void getRepairPlace(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.repair.j>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.repair.j.class, false))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.repair.j> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("czhth", paramString);
    localHashMap.put("city_code", com.ziroom.commonlib.utils.c.b);
    paramString = new HashMap();
    paramString.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    com.ziroom.datacenter.c.b.internalRepairBaseParams(paramString);
    paramString.put("sign", com.ziroom.datacenter.c.b.signParams(paramString));
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.s + d.h.u, paramString, parama);
  }
  
  public static void getRepairReason(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.repair.k>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.repair.k.class, false))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.repair.k> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("xmCode", paramString);
    localHashMap.put("city_code", com.ziroom.commonlib.utils.c.b);
    new HashMap().put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.s + d.h.x, localHashMap, parama);
  }
  
  public static void getRepairScore(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.repair.m> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.repair.m.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.repair.m paramAnonymousm)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousm);
        parama.onSuccess(paramAnonymousInt, paramAnonymousm);
      }
    };
    paramString = com.ziroom.datacenter.c.b.buildGetRepairScore(paramString);
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.s + d.h.p, paramString, parama);
  }
  
  public static void getRepairScoreItem(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.repair.l>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.repair.d.class, false, "scoreList"))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.repair.l> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.ziroom.datacenter.c.a.requestCommonRepairWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.s + d.h.n + "?city_code" + com.ziroom.commonlib.utils.c.b, null, parama);
  }
  
  public static void getRepairTime(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.g> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(null))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    paramString = com.ziroom.datacenter.c.b.buildGetRepairTime(paramString);
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.s + d.h.q, paramString, parama);
  }
  
  public static void getRepairType(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.repair.p>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.a(com.ziroom.datacenter.remote.responsebody.financial.repair.p.class, false, "scoreList"))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.repair.p> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    paramString = com.ziroom.datacenter.c.b.buildGetRepairType(paramString);
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.s + d.h.v, paramString, parama);
  }
  
  public static void getRepairTypeList(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.repair.i>> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.i(com.ziroom.datacenter.remote.responsebody.financial.repair.i.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.repair.i> paramAnonymousList)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", com.ziroom.commonlib.utils.f.getAppVersion());
    locale.put("appVersion", "1.0");
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.o + d.h.A, locale, parama);
  }
  
  public static void getSKUInfo(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<YouPinSKUMo> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(YouPinSKUMo.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, YouPinSKUMo paramAnonymousYouPinSKUMo)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousYouPinSKUMo);
        parama.onSuccess(paramAnonymousInt, paramAnonymousYouPinSKUMo);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("productCode", paramString1);
    localHashMap.put("properties", paramString2);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, com.ziroom.datacenter.remote.f.b.w + d.k.h, localHashMap, parama);
  }
  
  public static void getSelfForm(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.chat.h>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.c(com.ziroom.datacenter.remote.responsebody.financial.chat.h.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.chat.h> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("clientType", "ZIROOM_APP");
    com.ziroom.datacenter.c.a.requestGateWayService(paramContext, com.ziroom.datacenter.remote.f.b.l + "zmcApi/lore/self/form", locale, parama);
  }
  
  public static void getServiceDic(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.move.i>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.i(com.ziroom.datacenter.remote.responsebody.financial.move.i.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.move.i> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("dictionaryName", paramString);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "base/dictionary/dictionaryList", locale, parama);
  }
  
  public static void getServiceListNotReadNumber(Context paramContext, List<String> paramList, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.f> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.clean.f.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.f paramAnonymousf)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousf);
        parama.onSuccess(paramAnonymousInt, paramAnonymousf);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("expands", com.alibaba.fastjson.a.toJSON(paramList));
    locale.put("loginPhone", paramString);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.J, locale, parama);
  }
  
  public static void getSingleAuthInfo(Activity paramActivity, int paramInt, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.i> parama)
  {
    com.ziroom.datacenter.remote.d.a.c.g localg = new com.ziroom.datacenter.remote.d.a.c.g();
    localg.setKey(paramInt);
    d.getSingleAuthInfo(paramActivity, localg, parama);
  }
  
  public static void getSkillGroupType(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.chat.o> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.v(com.ziroom.datacenter.remote.responsebody.financial.chat.o.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.chat.o paramAnonymouso)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouso);
        parama.onSuccess(paramAnonymousInt, paramAnonymouso);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("businessTypeId", paramString1);
    if (!com.ziroom.commonlib.utils.r.isNull(paramString2)) {
      locale.put("questionTypeId", paramString2);
    }
    com.ziroom.datacenter.c.a.requestJson(paramContext, com.ziroom.datacenter.remote.f.b.q + d.a.c, locale, parama);
  }
  
  public static void getSmallMoveCommonDicTag(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.move.n>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.c(com.ziroom.datacenter.remote.responsebody.financial.move.n.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.move.n> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("dictionaryName", paramString);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    com.ziroom.datacenter.c.a.requestGateWayCommonService(paramContext, com.ziroom.datacenter.remote.f.b.l + "smsApi/base/dictionary/moveSpecialNeedList", locale, parama);
  }
  
  public static void getSmallMoveDetail(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.g> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.move.g.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.g paramAnonymousg)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("workOrderId", paramString);
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + "zrk/move/workOrderDetail", locale, parama);
  }
  
  public static void getSmallMoveGoodsNum(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.t> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.move.t.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.t paramAnonymoust)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymoust);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("serviceItemCode", paramString);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.l + d.b.bG, locale, parama);
  }
  
  public static void getSortCouponList(Context paramContext, Integer paramInteger, com.ziroom.datacenter.remote.d.a.b.h paramh, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(String.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    paramh = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramh), new com.alibaba.fastjson.m() {}, new Feature[0]);
    paramh.put("uid", com.ziroom.commonlib.utils.m.getUid());
    if (paramInteger.intValue() == 1) {
      paramh.put("isAppoint", paramInteger + "");
    }
    paramh.put("version", com.ziroom.commonlib.utils.f.getAppVersion());
    com.ziroom.datacenter.c.b.getMvCommon(paramContext, paramh);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.bF, paramh, parama);
  }
  
  public static void getSubmitTag(Context paramContext, String paramString1, String paramString2, String paramString3, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.clean.t>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.i(com.ziroom.datacenter.remote.responsebody.financial.clean.t.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.clean.t> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("fcityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("fserviceinfoid", paramString1);
    locale.put("docType", paramString2);
    locale.put("fversion", paramString3);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.aj, locale, parama);
  }
  
  public static void getSugChildTypeList(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.chat.b>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.u(com.ziroom.datacenter.remote.responsebody.financial.chat.b.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.chat.b> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("complainTypeId", paramString);
    com.ziroom.datacenter.c.a.requestJsonWithParams(paramContext, com.ziroom.datacenter.remote.f.b.q + d.b.bA, localHashMap, parama);
  }
  
  public static void getSugTypeList(Context paramContext, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.chat.d>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.u(com.ziroom.datacenter.remote.responsebody.financial.chat.d.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.chat.d> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    com.ziroom.datacenter.c.a.requestJsonWithParams(paramContext, com.ziroom.datacenter.remote.f.b.q + d.b.aU, localHashMap, parama);
  }
  
  public static void getSuggestDetail(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.chat.c> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.v(com.ziroom.datacenter.remote.responsebody.financial.chat.c.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.chat.c paramAnonymousc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        parama.onSuccess(paramAnonymousInt, paramAnonymousc);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("consulltId", paramString);
    com.ziroom.datacenter.c.a.requestJson(paramContext, com.ziroom.datacenter.remote.f.b.q + d.b.bv, localHashMap, parama);
  }
  
  public static void getSuggestType(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.chat.s> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.k(com.ziroom.datacenter.remote.responsebody.financial.chat.s.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.chat.s paramAnonymouss)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymouss);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityId", com.ziroom.commonlib.utils.c.b);
    com.ziroom.datacenter.c.a.requestJson(paramContext, com.ziroom.datacenter.remote.f.b.q + d.b.bt, localHashMap, parama);
  }
  
  public static void getSystemTime(Context paramContext, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.k(String.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.l + "/clock").tag(paramContext).enqueue(parama);
  }
  
  public static void getThirdAuthoizationInfo(Activity paramActivity, com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.b.j>> parama)
  {
    d.getThirdAuthorizationInfo(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void getUnbindCards(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    paramContext = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.b())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    parama = com.ziroom.datacenter.c.b.convertObjMap2String(com.ziroom.datacenter.c.b.buildBalance());
    com.ziroom.commonlib.ziroomhttp.a.get(com.ziroom.datacenter.remote.f.b.m + d.f.c).params(parama).enqueue(paramContext);
  }
  
  public static void getUnionCheckSignResult(Context paramContext, String paramString1, String paramString2, String paramString3, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.c.d> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.q(com.ziroom.datacenter.remote.responsebody.financial.c.d.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.c.d paramAnonymousd)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousd);
        parama.onSuccess(paramAnonymousInt, paramAnonymousd);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("encrypStr", paramString2);
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("interfaceId", paramString3);
    localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestZRFNHOSTSTransferUnion(paramContext, localHashMap, parama);
  }
  
  public static void getUnionPayAssembleDataResult(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.c.a> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.q(com.ziroom.datacenter.remote.responsebody.financial.c.a.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.c.a paramAnonymousa)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousa);
        parama.onSuccess(paramAnonymousInt, paramAnonymousa);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString1);
    localHashMap.put("interfaceId", paramString2);
    localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestZRFNHOSTSTransferUnion(paramContext, localHashMap, parama);
  }
  
  public static void getUnionPayBandCardResult(Context paramContext, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.p(String.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    HashMap localHashMap = new HashMap();
    if (!"0".equals(com.ziroom.commonlib.utils.m.getUid())) {
      localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    }
    com.ziroom.datacenter.c.a.requestCommonUnion(paramContext, com.ziroom.datacenter.remote.f.b.v + "/api/other/getUserInfo.do", localHashMap, parama);
  }
  
  public static void getUnionPayBandCardResultTransfer(Context paramContext, com.ziroom.datacenter.remote.d.a.f.e parame, final com.ziroom.datacenter.remote.b.a<Object> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.p(Object.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        parama.onSuccess(paramAnonymousInt, paramAnonymousObject);
      }
    };
    parame = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(parame), new com.alibaba.fastjson.m() {}, new Feature[0]);
    parame.put("uid", com.ziroom.commonlib.utils.m.getUid());
    parame.put("interfaceId", Integer.valueOf(12));
    com.ziroom.datacenter.c.a.requestAPIHOSTSTransferUnion(paramContext, parame, parama);
  }
  
  public static void getUnionPayBankListResult(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.c.f> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.q(com.ziroom.datacenter.remote.responsebody.financial.c.f.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.c.f paramAnonymousf)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousf);
        parama.onSuccess(paramAnonymousInt, paramAnonymousf);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(1));
    com.ziroom.datacenter.c.a.requestZRFNHOSTSTransferUnion(paramContext, localHashMap, parama);
  }
  
  public static void getUnionPayBindBankCardToContractResult(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.c.g> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.q(com.ziroom.datacenter.remote.responsebody.financial.c.g.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.c.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonUnion(paramContext, com.ziroom.datacenter.remote.f.b.k + "payment/unionpay/bindBankCardToContract", localHashMap, parama);
  }
  
  public static void getUnionPayIsBandCardResult(Context paramContext, com.ziroom.datacenter.remote.d.a.f.e parame, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.c.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.q(com.ziroom.datacenter.remote.responsebody.financial.c.e.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.c.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    parame = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(parame), new com.alibaba.fastjson.m() {}, new Feature[0]);
    parame.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.b.appendCommenParams(parame);
    parame = com.ziroom.datacenter.c.b.convertObjMap2String(parame);
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.k + "payment/unionpay/bindBankCard", parame, parama);
  }
  
  public static void getUnionPayNoticeResult(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.c.h> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.q(com.ziroom.datacenter.remote.responsebody.financial.c.h.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.c.h paramAnonymoush)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymoush);
        parama.onSuccess(paramAnonymousInt, paramAnonymoush);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(6));
    com.ziroom.datacenter.c.a.requestZRFNHOSTSTransferUnion(paramContext, localHashMap, parama);
  }
  
  public static void getUnionPayProtocolResult(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.c.i> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.q(com.ziroom.datacenter.remote.responsebody.financial.c.i.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.c.i paramAnonymousi)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousi);
        parama.onSuccess(paramAnonymousInt, paramAnonymousi);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(7));
    localHashMap.put("contractCode", paramString);
    localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestZRFNHOSTSTransferUnion(paramContext, localHashMap, parama);
  }
  
  public static void getUnionPaySingleAssembleDataResult(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.c.a> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.q(com.ziroom.datacenter.remote.responsebody.financial.c.a.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.c.a paramAnonymousa)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousa);
        parama.onSuccess(paramAnonymousInt, paramAnonymousa);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("cwOrderId", paramString);
    localHashMap.put("agreeType", "1");
    localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonUnion(paramContext, com.ziroom.datacenter.remote.f.b.v + "/api/attestation/assembleData.do", localHashMap, parama);
  }
  
  public static void getUnionPaySingleProtocolResult(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.p(String.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("agreeType", "1");
    localHashMap.put("cwOrderId", paramString);
    localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonUnion(paramContext, com.ziroom.datacenter.remote.f.b.v + "/api/attestation/toAgreement.do", localHashMap, parama);
  }
  
  public static void getUnionSingleCheckSignResult(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.p(String.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("encrypt", paramString2);
    localHashMap.put("cwOrderId", paramString1);
    localHashMap.put("agreeType", "1");
    localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonUnion(paramContext, com.ziroom.datacenter.remote.f.b.v + "/api/attestation/checkSign.do", localHashMap, parama);
  }
  
  public static void getUnreadNum(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.j(com.alibaba.fastjson.e.class, new com.ziroom.datacenter.remote.c.a.c()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    com.ziroom.datacenter.c.a.requestGateWayService(paramContext, com.ziroom.datacenter.remote.f.b.l + "push/api/push/client/count", locale, parama);
  }
  
  public static void getUserBaseInfo(Activity paramActivity, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.m> parama)
  {
    d.getUserBaseInfo(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void getUserCreditScoreBrokenLineInfo(Activity paramActivity, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.l> parama)
  {
    d.getUserCreditScoreBrokenLineInfo(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void getUserInfoScoreRecord(Activity paramActivity, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.n> parama)
  {
    d.getUserInfoScoreRecord(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void getUserIsBandCardResult(Context paramContext, String paramString, int paramInt, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.c.b> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.p(com.ziroom.datacenter.remote.responsebody.financial.c.b.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.c.b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        parama.onSuccess(paramAnonymousInt, paramAnonymousb);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("contractCode", paramString);
    localHashMap.put("type", Integer.valueOf(paramInt));
    localHashMap.put("interfaceId", Integer.valueOf(10));
    localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestAPIHOSTSTransferUnion(paramContext, localHashMap, parama);
  }
  
  public static void getUserIsContont(Context paramContext, String paramString1, String paramString2, String paramString3, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.s())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    com.ziroom.datacenter.c.a.requestCommonGet(paramContext, "http://kefu.easemob.com/v1/webimplugin/tenant/" + paramString1 + "/visitors/" + paramString2 + "/CurrentServiceSession?techChannelInfo=" + URLEncoder.encode(paramString3), null, parama);
  }
  
  public static void getUserMessageResult(Context paramContext, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.p(String.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    HashMap localHashMap = new HashMap();
    if (!"0".equals(com.ziroom.commonlib.utils.m.getUid())) {
      localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    }
    com.ziroom.datacenter.c.b.appendCommenParams(localHashMap);
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.v + "/api/other/getUserInfo.do", localHashMap, parama);
  }
  
  public static void getUserNameAuthInfo(Activity paramActivity, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.s> parama)
  {
    d.getUserNameAuthInfo(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void getUserNameCreditInfo(Activity paramActivity, com.ziroom.datacenter.remote.d.a.c.f paramf, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.o> parama)
  {
    d.getUserNameCreditInfo(paramActivity, paramf, parama);
  }
  
  public static void getUserNegativeRecord(Activity paramActivity, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.p> parama)
  {
    d.getUserNegativeRecord(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void getUserRankInfo(Activity paramActivity, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.q> parama)
  {
    d.getUserRankInfo(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void getUserScoreInfoByUid(Activity paramActivity, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.r> parama)
  {
    com.ziroom.datacenter.remote.d.a.c.i locali = new com.ziroom.datacenter.remote.d.a.c.i();
    locali.setVer(1);
    d.getUserScoreInfoByUid(paramActivity, locali, parama);
  }
  
  public static void getUserTotalScoreInfoByUid(Activity paramActivity, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.k> parama)
  {
    d.getUserTotalScoreInfoByUid(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void getUserZhimaScoreRecord(Activity paramActivity, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.t> parama)
  {
    d.getUserZhiMaScoreRecord(paramActivity, new com.ziroom.datacenter.remote.d.a.c.a(), parama);
  }
  
  public static void getWithDraw(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.a> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.k(com.ziroom.datacenter.remote.responsebody.a.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.a paramAnonymousa)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousa);
        parama.onSuccess(paramAnonymousInt, paramAnonymousa);
      }
    };
    paramString = com.ziroom.datacenter.c.b.buildWithdraw(paramString);
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.m + d.f.a, paramString, parama);
  }
  
  public static void getYPBestGoodsList(Context paramContext, String paramString, Integer paramInteger, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.d> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.youpin.d.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.d paramAnonymousd)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousd);
        parama.onSuccess(paramAnonymousInt, paramAnonymousd);
      }
    };
    HashMap localHashMap = new HashMap();
    if (paramString == null)
    {
      localHashMap.put("styleCode", "");
      if (paramInteger != null) {
        break label109;
      }
      localHashMap.put("roomRegion", "");
    }
    for (;;)
    {
      localHashMap.put("page", "1");
      localHashMap.put("pageSize", "1000");
      com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.b, localHashMap, parama);
      return;
      localHashMap.put("styleCode", paramString);
      break;
      label109:
      localHashMap.put("roomRegion", String.valueOf(paramInteger));
    }
  }
  
  public static void getYPHomePage(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.n> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.youpin.n.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.n paramAnonymousn)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousn);
        parama.onSuccess(paramAnonymousInt, paramAnonymousn);
      }
    };
    HashMap localHashMap = new HashMap();
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.a, localHashMap, parama);
  }
  
  public static void getYPOrderDetailsAc(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.q> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.youpin.q.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.q paramAnonymousq)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousq);
        parama.onSuccess(paramAnonymousInt, paramAnonymousq);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("maintainOrderCode", paramString);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.d, localHashMap, parama);
  }
  
  public static void getYPOrderList(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.r> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.youpin.r.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.r paramAnonymousr)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousr);
        parama.onSuccess(paramAnonymousInt, paramAnonymousr);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", "1");
    localHashMap.put("pageSize", "1000");
    if (paramString == null) {
      localHashMap.put("orderState", "");
    }
    for (;;)
    {
      com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.c, localHashMap, parama);
      return;
      localHashMap.put("orderState", paramString + "");
    }
  }
  
  public static void getYouBackChangeGoodsInfo(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.a> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.youpin.a.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.a paramAnonymousa)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousa);
        parama.onSuccess(paramAnonymousInt, paramAnonymousa);
      }
    };
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.B, parama);
  }
  
  public static void getYouBackOrderDetailsInfo(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.b> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.youpin.b.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        parama.onSuccess(paramAnonymousInt, paramAnonymousb);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("retreatOrderCode", paramString);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.z, localHashMap, parama);
  }
  
  public static void getYouPinCombinationInfo(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.f> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.youpin.f.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.f paramAnonymousf)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousf);
        parama.onSuccess(paramAnonymousInt, paramAnonymousf);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("groupCode", paramString);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.u, localHashMap, parama);
  }
  
  public static void getYouPinDeliverAreaDesc(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.g> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.youpin.g.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.t, parama);
  }
  
  public static void getYouPinOrderDetailsInfo(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.p> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.youpin.p.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.p paramAnonymousp)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousp);
        parama.onSuccess(paramAnonymousInt, paramAnonymousp);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("maintainOrderCode", paramString);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.e, localHashMap, parama);
  }
  
  public static void getYouPinShoppingCartInfo(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.w> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.youpin.w.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.w paramAnonymousw)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousw);
        parama.onSuccess(paramAnonymousInt, paramAnonymousw);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("userCode", paramString);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.A, localHashMap, parama);
  }
  
  public static void getYoupinGoodsList(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.d> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.youpin.d.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.d paramAnonymousd)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousd);
        parama.onSuccess(paramAnonymousInt, paramAnonymousd);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("categoryCode", paramString1);
    localHashMap.put("categoryClass", paramString2);
    localHashMap.put("page", "1");
    localHashMap.put("pageSize", "1000");
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.s, localHashMap, parama);
  }
  
  public static void getYoupinGuidanceInfo(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.m> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.youpin.m.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.m paramAnonymousm)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousm);
        parama.onSuccess(paramAnonymousInt, paramAnonymousm);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("groupCode", paramString);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.p, localHashMap, parama);
  }
  
  public static void getYoupinProducType(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.youpin.s>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.i(com.ziroom.datacenter.remote.responsebody.financial.youpin.s.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.youpin.s> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("parentCode", paramString);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.r, localHashMap, parama);
  }
  
  public static void getZuAddressList(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.clean.d>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.i(com.ziroom.datacenter.remote.responsebody.financial.clean.d.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.clean.d> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("fid", paramString);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", com.ziroom.commonlib.utils.f.getAppVersion());
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.aW, locale, parama);
  }
  
  public static void getreCommendCleaner(Context paramContext, com.ziroom.datacenter.remote.d.a.b.f paramf, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.s> parama)
  {
    paramf = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.clean.s.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.s paramAnonymouss)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouss);
        parama.onSuccess(paramAnonymousInt, paramAnonymouss);
      }
    };
    parama = new com.alibaba.fastjson.e();
    parama.put("uid", com.ziroom.commonlib.utils.m.getUid());
    parama.put("cityCode", com.ziroom.commonlib.utils.c.b);
    parama.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    parama.put("dataSource", Integer.valueOf(12));
    parama.put("versionNum", "2");
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.bI, parama, paramf);
  }
  
  public static void giveUpInternalRepairPlan(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.g> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(null))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailBillId", paramString);
    paramString = new HashMap();
    paramString.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    com.ziroom.datacenter.c.b.internalRepairBaseParams(paramString);
    paramString.put("sign", com.ziroom.datacenter.c.b.signParams(paramString));
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.s + d.g.B, paramString, parama);
  }
  
  public static void goToPay(Context paramContext, com.ziroom.datacenter.remote.d.a.f.d paramd, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.c.l>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.o(com.ziroom.datacenter.remote.responsebody.financial.c.l.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.c.l> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("cwOrderIds", paramd.getCwOrderIds());
    localHashMap.put("systemId", paramd.getSystemId());
    localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    localHashMap.put("token", com.ziroom.commonlib.utils.m.getToken());
    localHashMap.put("totalFee", Integer.valueOf(paramd.getTotalFee()));
    localHashMap.put("externalPay", com.alibaba.fastjson.e.toJSONString(paramd.getExternalPay()));
    localHashMap.put("acountPay", com.alibaba.fastjson.e.toJSONString(paramd.getAcountPay()));
    localHashMap.put("coupons", com.alibaba.fastjson.e.toJSONString(paramd.getCoupons()));
    localHashMap.put("expiredDate", paramd.getExpiredDate());
    localHashMap.put("sourceType", "android");
    localHashMap.put("payChannel", Integer.valueOf(paramd.getPayChannel()));
    localHashMap.put("smsCode", paramd.getSmsCode());
    localHashMap.put("smsOrderDate", paramd.getSmsOrderDate());
    localHashMap.put("smsOrderId", paramd.getSmsOrderId());
    com.ziroom.datacenter.c.a.requestCommonUnion(paramContext, com.ziroom.datacenter.remote.f.b.v + "/api/pay/generPayment", localHashMap, parama);
  }
  
  public static void lockRepairCapacity(Context paramContext, com.ziroom.datacenter.remote.d.a.e.b paramb, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.g> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(null))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    Map localMap = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramb), new com.alibaba.fastjson.m() {}, new Feature[0]);
    localMap.put("result", com.ziroom.commonlib.utils.g.toMd5((SignKeyUtil.getSignKey() + paramb.getLoginPhone() + paramb.getSignDate()).getBytes()));
    localMap.put("city_code", com.ziroom.commonlib.utils.c.b);
    paramb = new HashMap();
    paramb.put("json", com.alibaba.fastjson.a.toJSONString(localMap));
    com.ziroom.datacenter.c.a.requestCommonPost(paramContext, com.ziroom.datacenter.remote.f.b.s + d.h.s, paramb, parama);
  }
  
  public static void makeInternalRepairOrder(Context paramContext, com.ziroom.datacenter.remote.d.a.e.a parama, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.repair.n> parama1)
  {
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.repair.n.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.repair.n paramAnonymousn)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousn);
        parama1.onSuccess(paramAnonymousInt, paramAnonymousn);
      }
    };
    Object localObject = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(parama), new com.alibaba.fastjson.m() {}, new Feature[0]);
    parama = new HashMap();
    parama.put("json", com.alibaba.fastjson.a.toJSONString(localObject));
    localObject = com.ziroom.datacenter.c.b.signParams(parama);
    parama = com.ziroom.datacenter.c.b.internalRepairBaseParams(parama);
    parama.put("sign", localObject);
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.s + d.g.r, parama, parama1);
  }
  
  public static void passInternalPlan(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.g> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(null))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailBillId", paramString);
    paramString = new HashMap();
    paramString.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    com.ziroom.datacenter.c.b.internalRepairBaseParams(paramString);
    paramString.put("sign", com.ziroom.datacenter.c.b.signParams(paramString));
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.s + d.g.A, paramString, parama);
  }
  
  public static void payForInternalOrder(Context paramContext, com.ziroom.datacenter.remote.d.a.e.c paramc, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.f> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.f.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.f paramAnonymousf)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousf);
        parama.onSuccess(paramAnonymousInt, paramAnonymousf);
      }
    };
    paramc = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramc), new com.alibaba.fastjson.m() {}, new Feature[0]);
    paramc.put("cityCode", com.ziroom.commonlib.utils.c.b);
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", com.alibaba.fastjson.a.toJSONString(paramc));
    com.ziroom.datacenter.c.b.internalRepairBaseParams(localHashMap);
    localHashMap.put("sign", com.ziroom.datacenter.c.b.signParams(localHashMap));
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.s + d.g.D, localHashMap, parama);
  }
  
  public static void payGoodsOrder(Context paramContext, String paramString1, String paramString2, String paramString3, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.f> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(com.ziroom.datacenter.remote.responsebody.financial.f.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.f paramAnonymousf)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousf);
        parama.onSuccess(paramAnonymousInt, paramAnonymousf);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("money", paramString1);
    localHashMap.put("payKind", "1");
    localHashMap.put("couponCode", paramString2);
    localHashMap.put("strGoodsOrderPrices", paramString3);
    com.ziroom.commonlib.utils.l.d("LogUtil ", "========优品 支付订单 操作========" + localHashMap.toString());
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.n, localHashMap, parama);
  }
  
  public static void postBiweeklyCleanEval(Context paramContext, com.ziroom.datacenter.remote.d.a.b.a parama, final com.ziroom.datacenter.remote.b.a<String> parama1)
  {
    parama1 = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(String.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama1.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    parama = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(parama), new com.alibaba.fastjson.m() {}, new Feature[0]);
    parama.put("uid", com.ziroom.commonlib.utils.m.getUid());
    parama.put("timestamp", System.currentTimeMillis() + "");
    parama.put("cityCode", com.ziroom.commonlib.utils.c.b);
    parama.put("dataSource", "12");
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.ax, parama, parama1);
  }
  
  public static void postBiweeklyCleanEval(Context paramContext, com.ziroom.datacenter.remote.d.a.b.b paramb, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.h(new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    paramb = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramb), new com.alibaba.fastjson.m() {}, new Feature[0]);
    paramb.put("uid", com.ziroom.commonlib.utils.m.getUid());
    paramb.put("timestamp", System.currentTimeMillis() + "");
    paramb.put("cityCode", com.ziroom.commonlib.utils.c.b);
    paramb.put("dataSource", "12");
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.aw, paramb, parama);
  }
  
  public static void postBiweeklyCleanModify(Context paramContext, com.ziroom.datacenter.remote.d.a.b.c paramc, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.h(new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    paramc = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramc), new com.alibaba.fastjson.m() {}, new Feature[0]);
    paramc.put("uid", com.ziroom.commonlib.utils.m.getUid());
    paramc.put("timestamp", System.currentTimeMillis() + "");
    paramc.put("cityCode", com.ziroom.commonlib.utils.c.b);
    paramc.put("dataSource", "12");
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.ao, paramc, parama);
  }
  
  public static void postComplain(Context paramContext, com.ziroom.datacenter.remote.d.a.a.a parama, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama1)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.t())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama1.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama1.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    parama1 = new HashMap();
    com.ziroom.datacenter.c.a.requestJson(paramContext, com.ziroom.datacenter.remote.f.b.q + d.b.bs, parama1, parama);
  }
  
  public static void postQuestionnaire(Context paramContext, String paramString, Map<String, Integer> paramMap, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(String.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    com.alibaba.fastjson.e locale1 = new com.alibaba.fastjson.e();
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      com.alibaba.fastjson.b localb = new com.alibaba.fastjson.b();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        com.alibaba.fastjson.e locale2 = new com.alibaba.fastjson.e();
        locale2.put("id", localEntry.getKey());
        locale2.put("score", localEntry.getValue());
        localb.add(locale2);
      }
      locale1.put("pointItems", localb);
    }
    locale1.put("workBillId", paramString);
    locale1.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale1.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale1.put("dataSource", Integer.valueOf(12));
    locale1.put("versionNum", "2");
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.az, locale1, parama);
  }
  
  public static void promptInternalRepairOrder(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.g> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(null))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailBillId", paramString);
    paramString = new HashMap();
    paramString.put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
    com.ziroom.datacenter.c.b.internalRepairBaseParams(paramString);
    paramString.put("sign", com.ziroom.datacenter.c.b.signParams(paramString));
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.s + d.g.t, paramString, parama);
  }
  
  public static void requestDeleteCleanAddress(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(String.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("fid", paramString);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("dataSource", Integer.valueOf(12));
    locale.put("versionNum", com.ziroom.commonlib.utils.f.getAppVersion());
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.bR, locale, parama);
  }
  
  public static void requestIsHaveNoPay(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.m> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.d(com.ziroom.datacenter.remote.responsebody.financial.move.m.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.m paramAnonymousm)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousm);
        parama.onSuccess(paramAnonymousInt, paramAnonymousm);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("interfaceVesion", Integer.valueOf(1));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    com.ziroom.datacenter.c.a.requestGateWayService(paramContext, com.ziroom.datacenter.remote.f.b.l + "smsApi/zrk/move/customerOrder/noPayOrderList", locale, parama);
  }
  
  public static void requestIsUserInfo(Context paramContext, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.w> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.clean.w.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.w paramAnonymousw)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousw);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("serviceType", "2c9085f24af1d728014b004be6b50d3b");
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("clientCode", com.ziroom.commonlib.utils.f.getDeviceId(paramContext));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.aI, locale, parama);
  }
  
  public static void requestMoveDates(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.h> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.n(com.ziroom.datacenter.remote.responsebody.financial.move.h.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.h paramAnonymoush)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymoush);
        parama.onSuccess(paramAnonymousInt, paramAnonymoush);
      }
    };
    paramString = com.ziroom.datacenter.c.b.buildMoveDates(paramContext, paramString);
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.r + d.d.l, paramString, parama);
  }
  
  public static void requestMoveTimes(Context paramContext, String paramString, long paramLong, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.k> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.n(com.ziroom.datacenter.remote.responsebody.financial.move.k.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.k paramAnonymousk)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousk);
        parama.onSuccess(paramAnonymousInt, paramAnonymousk);
      }
    };
    paramString = com.ziroom.datacenter.c.b.buildMoveTimes(paramContext, paramString, paramLong);
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.r + d.d.m, paramString, parama);
  }
  
  public static void requestPeriodToUrl(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.p> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.d(com.ziroom.datacenter.remote.responsebody.financial.clean.p.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.p paramAnonymousp)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousp);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("mobile", paramString);
    com.ziroom.datacenter.c.a.requestGateWayService(paramContext, com.ziroom.datacenter.remote.f.b.l + "cleanApi/zrk/promotion/outer/clean/week", locale, parama);
  }
  
  public static void requestServicePayment(Context paramContext, com.ziroom.datacenter.remote.d.a.b.g paramg, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.o> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.d(com.ziroom.datacenter.remote.responsebody.financial.clean.o.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.o paramAnonymouso)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouso);
        parama.onSuccess(paramAnonymousInt, paramAnonymouso);
      }
    };
    paramg = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramg), new com.alibaba.fastjson.m() {}, new Feature[0]);
    paramg.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestGateWayService(paramContext, com.ziroom.datacenter.remote.f.b.l + "cleanApi/zrk/receipt/pay", new com.alibaba.fastjson.e(paramg), parama, true);
  }
  
  public static void requestYouPinGroupList(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.x> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.youpin.x.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.x paramAnonymousx)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousx);
        parama.onSuccess(paramAnonymousInt, paramAnonymousx);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("groupCode", paramString1);
    localHashMap.put("productCode", paramString2);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.u, localHashMap, parama);
  }
  
  public static void requestYouPinGroupPropertyList(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.j> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.youpin.j.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.j paramAnonymousj)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousj);
        parama.onSuccess(paramAnonymousInt, paramAnonymousj);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("groupCode", paramString);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.w, localHashMap, parama);
  }
  
  public static void requestYouPinPromise(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.youpin.t> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.youpin.t.class, new com.ziroom.datacenter.remote.c.a.e()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.youpin.t paramAnonymoust)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymoust);
        parama.onSuccess(paramAnonymousInt, paramAnonymoust);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("productCode", paramString);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.k.v, localHashMap, parama);
  }
  
  public static void saveAppPoint(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, final com.ziroom.datacenter.remote.b.a<List<com.ziroom.datacenter.remote.responsebody.financial.chat.i>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.u(com.ziroom.datacenter.remote.responsebody.financial.chat.i.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.datacenter.remote.responsebody.financial.chat.i> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("event", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("userUniqueKey", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("knowledgeId", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localHashMap.put("selfHelpMenu", paramString4);
    }
    com.ziroom.commonlib.utils.l.e("dsjgkdj", com.alibaba.fastjson.a.toJSONString(localHashMap));
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.q + d.b.bm).params(localHashMap).tag(paramContext).enqueue(parama);
  }
  
  public static void saveGeneralCleanQuestion(Context paramContext, List<Object> paramList, String paramString, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.j(String.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("pointItems", paramList);
    locale.put("workBillId", paramString);
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.bQ, locale, parama);
  }
  
  public static void saveGoodsEval(Context paramContext, com.ziroom.datacenter.remote.d.a.g.b paramb, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.g> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(null))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    paramb = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramb), new com.alibaba.fastjson.m() {}, new Feature[0]);
    com.ziroom.datacenter.c.a.requestCommonYouPinPost(paramContext, d.h.h, paramb, parama);
  }
  
  public static void saveInternalRepairEval(Context paramContext, com.ziroom.datacenter.remote.d.a.e.d paramd, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.g> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(null))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    paramd = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramd), new com.alibaba.fastjson.m() {}, new Feature[0]);
    HashMap localHashMap = new HashMap();
    localHashMap.put("json", com.alibaba.fastjson.a.toJSONString(paramd));
    com.ziroom.datacenter.c.b.internalRepairBaseParams(localHashMap);
    localHashMap.put("sign", com.ziroom.datacenter.c.b.signParams(localHashMap));
    com.ziroom.datacenter.c.a.requestCommonPostV2(paramContext, com.ziroom.datacenter.remote.f.b.s + d.g.v, localHashMap, parama);
  }
  
  public static void saveSmallMoveEval(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap1, Map<String, String> paramMap2, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.move.d> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.j(com.ziroom.datacenter.remote.responsebody.financial.move.d.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.move.d paramAnonymousd)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousd);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    if ((paramMap1 != null) && (paramMap1.size() > 0)) {
      locale.put("evaluatePositiveTag", paramMap1);
    }
    if ((paramMap2 != null) && (paramMap2.size() > 0)) {
      locale.put("evaluateNegativeTag", paramMap2);
    }
    if ((paramString4 != null) && (paramString4.length() > 0)) {
      locale.put("content", paramString4);
    }
    locale.put("userId", paramString1);
    locale.put("workOrderId", paramString2);
    locale.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    locale.put("scroe", paramString3);
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("evaluateSource", Integer.valueOf(12));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.d.e, locale, parama);
  }
  
  public static void searchPayStatic(Context paramContext, String paramString, int paramInt, final com.ziroom.datacenter.remote.b.a<Object> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.p(Object.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        parama.onSuccess(paramAnonymousInt, paramAnonymousObject);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderCode", paramString);
    localHashMap.put("payChanel", Integer.valueOf(paramInt));
    com.ziroom.datacenter.c.a.requestCommonUnion(paramContext, com.ziroom.datacenter.remote.f.b.v + "/api/pay/queryState", localHashMap, parama);
  }
  
  public static void searchQuestionByText(Context paramContext, String paramString, int paramInt, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.chat.n> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.v(com.ziroom.datacenter.remote.responsebody.financial.chat.n.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.chat.n paramAnonymousn)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousn);
        parama.onSuccess(paramAnonymousInt, paramAnonymousn);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("fuzzyName", paramString);
    localHashMap.put("cityCode", com.ziroom.commonlib.utils.c.b);
    localHashMap.put("pageSize", paramInt + "");
    localHashMap.put("pageNumber", "0");
    localHashMap.put("hotspot", "1");
    com.ziroom.datacenter.c.a.requestJsonWithParams(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.bz, localHashMap, parama);
  }
  
  public static void selectMyCleanerList(Context paramContext, com.ziroom.datacenter.remote.d.a.b.l paraml, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.x> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.d(com.ziroom.datacenter.remote.responsebody.financial.clean.x.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.x paramAnonymousx)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousx);
        parama.onSuccess(paramAnonymousInt, paramAnonymousx);
      }
    };
    paraml = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paraml), new com.alibaba.fastjson.m() {}, new Feature[0]);
    paraml.put("uid", com.ziroom.commonlib.utils.m.getUid());
    paraml.put("cityCode", com.ziroom.commonlib.utils.c.b);
    paraml.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    paraml.put("dataSource", Integer.valueOf(12));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.bf, com.ziroom.datacenter.c.b.convertObjMap2String(paraml), parama);
  }
  
  public static void selectNearCleanerList(Context paramContext, com.ziroom.datacenter.remote.d.a.b.m paramm, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.clean.x> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.d(com.ziroom.datacenter.remote.responsebody.financial.clean.x.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.clean.x paramAnonymousx)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousx);
        parama.onSuccess(paramAnonymousInt, paramAnonymousx);
      }
    };
    paramm = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramm), new com.alibaba.fastjson.m() {}, new Feature[0]);
    paramm.put("uid", com.ziroom.commonlib.utils.m.getUid());
    paramm.put("cityCode", com.ziroom.commonlib.utils.c.b);
    paramm.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    paramm.put("dataSource", Integer.valueOf(12));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.t + d.b.bg, com.ziroom.datacenter.c.b.convertObjMap2String(paramm), parama);
  }
  
  public static void sendCancelPayStatus(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<Object> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.p(Object.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        parama.onSuccess(paramAnonymousInt, paramAnonymousObject);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("interfaceId", Integer.valueOf(38));
    localHashMap.put("orderCode", paramString);
    localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestAPIHOSTSTransferUnion(paramContext, localHashMap, parama);
  }
  
  public static void setGestureLock(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.r())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    paramString1 = com.ziroom.datacenter.c.b.buildCommonHeaderWithToken(paramContext, paramString1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("password", paramString2);
    com.ziroom.datacenter.c.a.requestWithHeaderV2ByGet(paramContext, com.ziroom.datacenter.remote.f.b.p + "gestures/v1", paramString1, localHashMap, parama);
  }
  
  public static void setRepairScore(Context paramContext, com.ziroom.datacenter.remote.d.a.e.e parame, List<com.ziroom.datacenter.remote.responsebody.financial.repair.l> paramList, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.g> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(null))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    Map localMap = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(parame), new com.alibaba.fastjson.m() {}, new Feature[0]);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.ziroom.datacenter.remote.responsebody.financial.repair.l locall = (com.ziroom.datacenter.remote.responsebody.financial.repair.l)paramList.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("SCOREITEM", locall.getFID());
      localHashMap.put("SCOREVALUE", locall.getVALUE());
      localArrayList.add(localHashMap);
    }
    localMap.put("scoreList", localArrayList);
    localMap.put("result", com.ziroom.commonlib.utils.g.toMd5((SignKeyUtil.getSignKey() + parame.getLoginPhone() + parame.getSignDate()).getBytes()));
    localMap.put("city_code", com.ziroom.commonlib.utils.c.b);
    new HashMap().put("json", com.alibaba.fastjson.a.toJSONString(localMap));
    com.ziroom.datacenter.c.a.requestCommonRepairWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.s + d.h.o, null, parama);
  }
  
  public static void submitMovingEval(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.c(new com.ziroom.datacenter.remote.c.j(String.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("orderCode", paramString1);
    locale.put("uname", paramString2);
    locale.put("evaluationScore", Integer.valueOf(paramInt));
    locale.put("evaluationContent", paramString3);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/orderEvaluateCommit", locale, parama);
  }
  
  public static void submitMvCancleReason(Context paramContext, String paramString1, String paramString2, final com.ziroom.datacenter.remote.b.a<String> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.j(String.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("orderCode", paramString1);
    locale.put("cancelContent", paramString2);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/cancelOrder", locale, parama);
  }
  
  public static void submitRepair(Context paramContext, com.ziroom.datacenter.remote.d.a.e.f paramf, List<com.ziroom.datacenter.remote.responsebody.financial.repair.q> paramList, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.g> parama)
  {
    com.ziroom.datacenter.remote.a.a local106 = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.m(null))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.g paramAnonymousg)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousg);
        parama.onSuccess(paramAnonymousInt, paramAnonymousg);
      }
    };
    Map localMap = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramf), new com.alibaba.fastjson.m() {}, new Feature[0]);
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      parama = (com.ziroom.datacenter.remote.responsebody.financial.repair.q)localIterator1.next();
      parama.setSupEmpId(parama.getLockSupEmpId());
      parama.setSupplierId(parama.getLockSupplierId());
      Iterator localIterator2 = parama.getWxxmList().iterator();
      while (localIterator2.hasNext())
      {
        com.ziroom.datacenter.remote.responsebody.financial.repair.r localr = (com.ziroom.datacenter.remote.responsebody.financial.repair.r)localIterator2.next();
        if (com.ziroom.commonlib.utils.r.isNull(localr.getPic()))
        {
          Object localObject = "";
          if (localr.getUrl() != null)
          {
            int i = 0;
            if (i < localr.getUrl().length)
            {
              parama = (com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.g>)localObject;
              if (com.ziroom.commonlib.utils.r.notNull(localr.getUrl()[i])) {
                if (!com.ziroom.commonlib.utils.r.isNull((String)localObject)) {
                  break label204;
                }
              }
              label204:
              for (parama = localr.getUrl()[i];; parama = (String)localObject + "," + localr.getUrl()[i])
              {
                i += 1;
                localObject = parama;
                break;
              }
            }
            localr.setPic((String)localObject);
            localr.setImage(null);
            localr.setUrl(null);
          }
        }
      }
    }
    localMap.put("workBillList", com.alibaba.fastjson.a.toJSON(paramList));
    localMap.put("result", com.ziroom.commonlib.utils.g.toMd5((SignKeyUtil.getSignKey() + paramf.getLoginPhone() + paramf.getSignDate()).getBytes()));
    localMap.put("city_code", com.ziroom.commonlib.utils.c.b);
    new HashMap().put("json", com.alibaba.fastjson.a.toJSONString(localMap));
    com.ziroom.datacenter.c.a.requestCommonRepairWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.s + d.h.a, null, local106);
  }
  
  public static void suggestCommit(Context paramContext, com.ziroom.datacenter.remote.d.a.a.b paramb, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.chat.r> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.k(com.ziroom.datacenter.remote.responsebody.financial.chat.r.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.chat.r paramAnonymousr)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousr);
        parama.onSuccess(paramAnonymousInt, paramAnonymousr);
      }
    };
    paramb = (Map)com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.a.toJSONString(paramb), new com.alibaba.fastjson.m() {}, new Feature[0]);
    paramb.put("cityCode", com.ziroom.commonlib.utils.c.b);
    paramb.put("source", "01");
    com.ziroom.datacenter.c.a.requestJson(paramContext, com.ziroom.datacenter.remote.f.b.q + d.b.bu, paramb, parama);
  }
  
  public static void updateMvAddress(Context paramContext, String paramString1, String paramString2, String paramString3, com.ziroom.datacenter.remote.responsebody.financial.move.a parama1, com.ziroom.datacenter.remote.responsebody.financial.move.a parama2, int paramInt, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.c(new com.ziroom.datacenter.remote.c.h(new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("appointmentAddress", parama1);
    locale.put("targetAddress", parama2);
    locale.put("distance", Integer.valueOf(paramInt));
    parama1 = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    parama1.put("productCode", paramString1);
    parama1.put("uid", paramString2);
    parama1.put("userToken", paramString3);
    parama1.put("appointmentAddressDO", locale);
    parama1.put("updateType", Integer.valueOf(2));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/updateShoppingCartInfo", parama1, parama);
  }
  
  public static void updateMvCoupon(Context paramContext, String paramString1, String paramString2, String paramString3, com.alibaba.fastjson.b paramb, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.c(new com.ziroom.datacenter.remote.c.h(new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", paramString2);
    locale.put("userToken", paramString3);
    locale.put("couponDOs", paramb);
    locale.put("updateType", Integer.valueOf(5));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/updateShoppingCartInfo", locale, parama);
  }
  
  public static void updateMvGoods(Context paramContext, String paramString1, String paramString2, com.alibaba.fastjson.b paramb, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.c(new com.ziroom.datacenter.remote.c.h(new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("userToken", paramString2);
    locale.put("materialsDOs", paramb);
    locale.put("updateType", Integer.valueOf(4));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/updateShoppingCartInfo", locale, parama);
  }
  
  public static void updateMvPhone(Context paramContext, String paramString1, String paramString2, String paramString3, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.c(new com.ziroom.datacenter.remote.c.h(new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("userToken", paramString2);
    locale.put("connectPhone", paramString3);
    locale.put("updateType", Integer.valueOf(7));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/updateShoppingCartInfo", locale, parama);
  }
  
  public static void updateMvRequirement(Context paramContext, String paramString1, String paramString2, com.alibaba.fastjson.e parame, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.c(new com.ziroom.datacenter.remote.c.h(new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("productCode", paramString1);
    locale.put("userToken", paramString2);
    locale.put("specialNeedDO", parame);
    locale.put("updateType", Integer.valueOf(6));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/updateShoppingCartInfo", locale, parama);
  }
  
  public static void updateMvService(Context paramContext, String paramString1, String paramString2, com.alibaba.fastjson.b paramb, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.h(new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("userToken", paramString2);
    locale.put("serviceItemDOs", paramb);
    locale.put("updateType", Integer.valueOf(3));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/updateShoppingCartInfo", locale, parama);
  }
  
  public static void updateMvTime(Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.commonlib.ziroomhttp.c.a(new com.ziroom.datacenter.remote.c.j(com.alibaba.fastjson.e.class, new com.ziroom.datacenter.remote.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    com.alibaba.fastjson.e locale = com.ziroom.datacenter.c.b.getMvCommon(paramContext);
    locale.put("productCode", paramString1);
    locale.put("uid", com.ziroom.commonlib.utils.m.getUid());
    locale.put("userToken", paramString2);
    locale.put("appointmentDate", Long.valueOf(paramLong1));
    locale.put("appointmentTime", Long.valueOf(paramLong2));
    locale.put("updateType", Integer.valueOf(1));
    com.ziroom.datacenter.c.a.requestCommonCleanWithEncode(paramContext, com.ziroom.datacenter.remote.f.b.r + "zrk/move/customerOrder/updateShoppingCartInfo", locale, parama);
  }
  
  public static void uploadImg(Context paramContext, File paramFile, final com.ziroom.datacenter.remote.b.a<List<String>> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.w())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<String> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        parama.onSuccess(paramAnonymousInt, paramAnonymousList);
      }
    };
    com.ziroom.commonlib.ziroomhttp.a.post(com.ziroom.datacenter.remote.f.b.t + d.i.g).tag(paramContext).setWriteTimeOut(10).addFormDataPart("iosImage", paramFile.getName(), "image/jpg", paramFile.getAbsolutePath()).enqueue(parama);
  }
  
  public static void userAuthorization(Activity paramActivity, String paramString, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    com.ziroom.datacenter.remote.d.a.c.h localh = new com.ziroom.datacenter.remote.d.a.c.h();
    localh.setPhone(paramString);
    d.userAuthorization(paramActivity, localh, parama);
  }
  
  public static void userAuthorization(Context paramContext, String paramString, final com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.l(com.ziroom.datacenter.remote.responsebody.financial.b.c.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.c paramAnonymousc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        parama.onSuccess(paramAnonymousInt, paramAnonymousc);
      }
    };
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.commonlib.utils.m.getUid());
    localHashMap.put("phone", paramString);
    localHashMap.put("interfaceId", Integer.valueOf(32));
    com.ziroom.datacenter.c.a.requestCommonUnion(paramContext, com.ziroom.datacenter.remote.f.b.k + "interfaceTransfer/transfer", localHashMap, parama);
  }
  
  public static void userEducationCredit(Activity paramActivity, com.ziroom.datacenter.remote.d.a.c.c paramc, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    d.userEducationCredit(paramActivity, paramc, parama);
  }
  
  public static void userWorkCredit(Activity paramActivity, com.ziroom.datacenter.remote.d.a.c.j paramj, com.ziroom.datacenter.remote.b.a<com.ziroom.datacenter.remote.responsebody.financial.b.c> parama)
  {
    d.userWorkCredit(paramActivity, paramj, parama);
  }
  
  public static void validMatchSupplierScopeByCoord(Context paramContext, double paramDouble1, double paramDouble2, final com.ziroom.datacenter.remote.b.a<com.alibaba.fastjson.e> parama)
  {
    parama = new com.ziroom.datacenter.remote.a.a(paramContext, new com.ziroom.datacenter.remote.c.b())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        parama.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        parama.onSuccess(paramAnonymousInt, paramAnonymouse);
      }
    };
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("productCode", "2c9084454b7835b0014b7841269101a9");
    locale.put("longitude", Double.valueOf(paramDouble1));
    locale.put("latitude", Double.valueOf(paramDouble2));
    locale.put("cityCode", com.ziroom.commonlib.utils.c.b);
    locale.put("osType", Integer.valueOf(12));
    com.ziroom.datacenter.c.a.requestGateWayCommonService(paramContext, com.ziroom.datacenter.remote.f.b.l + "cleanApi/zrk/generalCleanSupplier/validMatchSupplierScopeByCoord", locale, parama);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */