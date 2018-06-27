package com.ziroom.ziroomcustomer.newmovehouse.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.c.c;
import com.ziroom.commonlibrary.receiver.JPushReceiver;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.c.a.f;
import com.ziroom.ziroomcustomer.e.c.a.h;
import com.ziroom.ziroomcustomer.e.c.k;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.d.al;
import com.ziroom.ziroomcustomer.newclean.d.ba;
import com.ziroom.ziroomcustomer.newmovehouse.model.Address;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingEvalInfo;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanGoods;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanGoodsNum;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanOrderState;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanService;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanServiceCategory;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanServiceItem;
import com.ziroom.ziroomcustomer.newmovehouse.model.ServiceDicItem;
import com.ziroom.ziroomcustomer.util.ad;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static a b;
  final com.ziroom.ziroomcustomer.flux.b a;
  
  private a(com.ziroom.ziroomcustomer.flux.b paramb)
  {
    this.a = paramb;
  }
  
  private String a(Object paramObject)
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null)
    {
      this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_login", null), paramObject);
      return null;
    }
    return localUserInfo.getUid();
  }
  
  private void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, e parame, final String paramString4, final String paramString5)
  {
    n.updateMvRequirement(paramContext, paramString1, paramString2, paramString3, parame, new c(new k(new h()) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        a.a(a.this, paramContext, paramString1, paramString2, paramString3, paramString4, paramString5);
      }
    });
  }
  
  private void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, String paramString4, final e parame, final String paramString5, final String paramString6)
  {
    n.updateMvPhone(paramContext, paramString1, paramString2, paramString3, paramString4, new c(new k(new h()) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        a.a(a.this, paramContext, paramString1, paramString2, paramString3, parame, paramString5, paramString6);
      }
    });
  }
  
  private void a(final Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    n.createMvOrder(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, new c(new m(String.class, new h()) {})
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_submit", paramAnonymousString), paramContext);
      }
    });
  }
  
  private void a(Throwable paramThrowable, Object paramObject)
  {
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramObject);
    if ((paramThrowable instanceof com.freelxl.baselibrary.d.d.a))
    {
      this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_toast", paramThrowable.getMessage()), paramObject);
      return;
    }
    if ((paramThrowable instanceof com.ziroom.commonlibrary.a.b))
    {
      this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_toast", paramThrowable.getMessage()), paramObject);
      return;
    }
    if ((paramThrowable instanceof UnknownHostException))
    {
      this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_toast", "网络请求失败，请检查网络连接"), paramObject);
      return;
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_toast", "服务器请求异常！"), paramObject);
  }
  
  public static a getInstance(com.ziroom.ziroomcustomer.flux.b paramb)
  {
    if (b == null) {
      b = new a(paramb);
    }
    return b;
  }
  
  public void createMvOrder(Context paramContext, String paramString1, String paramString2, String paramString3, e parame, String paramString4, String paramString5)
  {
    String str = a(paramContext);
    if (str == null) {
      return;
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    a(paramContext, paramString1, str, paramString2, paramString3, parame, paramString4, paramString5);
  }
  
  public void getEstimateCost(final Context paramContext, String paramString1, String paramString2)
  {
    String str = a(paramContext);
    if (str == null) {
      return;
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    n.getMvEstimateCost(paramContext, paramString1, str, paramString2, new c(new k(new h()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_get_estimate_cost", paramAnonymouse), paramContext);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
      }
    });
  }
  
  public void getMovingVanDetail(final Object paramObject, Context paramContext, String paramString)
  {
    String str = a(paramObject);
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramObject);
    n.getMovingVanDetail(paramContext, paramString, str, new c(new m(MovingVanDetail.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MovingVanDetail paramAnonymousMovingVanDetail)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("moving_van_order_detail", paramAnonymousMovingVanDetail), paramObject);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramObject);
      }
    });
  }
  
  public void getMovingVanState(final Object paramObject, Context paramContext, String paramString)
  {
    String str = a(paramObject);
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramObject);
    n.getMovingVanState(paramContext, paramString, str, new c(new m(MovingVanOrderState.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MovingVanOrderState paramAnonymousMovingVanOrderState)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("moving_van_order_state", paramAnonymousMovingVanOrderState), paramObject);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramObject);
      }
    });
  }
  
  public void getMvCancleReason(final Context paramContext, String paramString)
  {
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    n.getServiceDic(paramContext, paramString, new c(new l(ServiceDicItem.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, List<ServiceDicItem> paramAnonymousList)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_cancle_reason", paramAnonymousList), paramContext);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
      }
    });
  }
  
  public void initMovingEval(final Context paramContext, String paramString)
  {
    String str = a(paramContext);
    if (str == null)
    {
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).finish();
      }
      return;
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    n.getMovingVanEvalInfo(paramContext, paramString, str, new c(new m(MovingEvalInfo.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, MovingEvalInfo paramAnonymousMovingEvalInfo)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_eval_init", paramAnonymousMovingEvalInfo), paramContext);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
      }
    });
  }
  
  public void initMvData(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (a(paramContext) == null)
    {
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).finish();
      }
      return;
    }
    Object localObject = ApplicationEx.c.getUser();
    if ((localObject != null) && (ApplicationEx.c.isLoginState()) && (!TextUtils.isEmpty(((UserInfo)localObject).getPhone()))) {
      updateMovingVanPhone(paramContext, ((UserInfo)localObject).getPhone());
    }
    localObject = new e();
    ((e)localObject).put("productCode", paramString1);
    ((e)localObject).put("productCategoryCode", paramString2);
    ((e)localObject).put("mvToken", paramString3);
    paramString1 = ad.getMovingVanAddressData(paramContext, "service_moving_van_start_address");
    paramString2 = ad.getMovingVanAddressData(paramContext, "service_moving_van_end_address");
    if (!TextUtils.isEmpty(paramString1.getOrderAddress())) {
      ((e)localObject).put("outKeepAddress", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2.getOrderAddress())) {
      ((e)localObject).put("inKeepAddress", paramString2);
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_init", localObject), paramContext);
  }
  
  public void initMvGoods(final Context paramContext, String paramString1, String paramString2, List<MovingVanGoods> paramList)
  {
    String str = a(paramContext);
    if (str == null)
    {
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).finish();
      }
      return;
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    final e locale = new e();
    locale.put("productCode", paramString1);
    locale.put("token", paramString2);
    locale.put("goodsSelected", paramList);
    n.getMvGoodsList(paramContext, paramString1, str, new c(new l(MovingVanGoods.class, new h()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
        locale.put("goods", null);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_goods_init", locale), paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, List<MovingVanGoods> paramAnonymousList)
      {
        locale.put("goods", paramAnonymousList);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_goods_init", locale), paramContext);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
      }
    });
  }
  
  public void initMvIndex(final Context paramContext, String paramString, boolean paramBoolean)
  {
    String str2;
    final e locale;
    UserInfo localUserInfo;
    Object localObject1;
    String str1;
    if (!paramBoolean)
    {
      str2 = a(paramContext);
      if (str2 == null) {}
      do
      {
        return;
        locale = new e();
        locale.put("productCode", paramString);
        if ((paramString != null) && (paramString.equals("2c9085f248ba3f3a0148bb156f6e0004")))
        {
          this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_index_init", locale), paramContext);
          return;
        }
      } while ((paramString == null) || (!paramString.equals("8a90a5f8593e65b501593e65b5200000")));
      this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
      localUserInfo = ApplicationEx.c.getUser();
      localObject1 = "";
      str1 = "";
      localObject2 = localObject1;
      if (localUserInfo == null) {
        break label309;
      }
      localObject2 = localObject1;
      if (!ApplicationEx.c.isLoginState()) {
        break label309;
      }
      if (!TextUtils.isEmpty(localUserInfo.getRealName())) {
        localObject1 = localUserInfo.getRealName();
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty(localUserInfo.getPhone())) {
        break label309;
      }
    }
    for (Object localObject2 = localUserInfo.getPhone();; localObject2 = str1)
    {
      n.getMvToken(paramContext, paramString, str2, (String)localObject1, (String)localObject2, new c(new k(new h()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          a.a(a.this, paramAnonymousThrowable, paramContext);
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("userToken")))
          {
            locale.put("token", paramAnonymouse.getString("userToken"));
            locale.put("productCategoryCode", paramAnonymouse.getString("productCategoryCode"));
            a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_index_init", locale), paramContext);
          }
          a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
        }
      });
      return;
      localObject1 = new e();
      ((e)localObject1).put("productCode", paramString);
      if ((paramString != null) && (paramString.equals("2c9085f248ba3f3a0148bb156f6e0004")))
      {
        this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_index_init", localObject1), paramContext);
        return;
      }
      if ((paramString == null) || (!paramString.equals("8a90a5f8593e65b501593e65b5200000"))) {
        break;
      }
      this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_index_init", localObject1), paramContext);
      return;
      label309:
      localObject1 = localObject2;
    }
  }
  
  public void initMvService(Context paramContext, String paramString)
  {
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_bulky_item_init", paramString), paramContext);
  }
  
  public void initMvServices(final Context paramContext, final String paramString1, final String paramString2, final List<MovingVanService> paramList)
  {
    String str = a(paramContext);
    if (str == null)
    {
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).finish();
      }
      return;
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    n.getMvServiceList(paramContext, paramString1, str, new c(new l(MovingVanServiceCategory.class, new h()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, List<MovingVanServiceCategory> paramAnonymousList)
      {
        e locale = new e();
        locale.put("productCode", paramString1);
        locale.put("token", paramString2);
        locale.put("services", paramAnonymousList);
        locale.put("servicesSelected", paramList);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_bulky_init", locale), paramContext);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
      }
    });
  }
  
  public void initMvTool(final Context paramContext, String paramString)
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    String str = "";
    if (localUserInfo != null) {
      str = localUserInfo.getUid();
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    n.getMovingVanGoodsNum(paramContext, paramString, str, new c(new m(MovingVanGoodsNum.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, MovingVanGoodsNum paramAnonymousMovingVanGoodsNum)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_get_goods_num", paramAnonymousMovingVanGoodsNum), paramContext);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
      }
    });
  }
  
  public void submitMovingEval(final Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    String str2 = a(paramContext);
    if (str2 == null) {
      return;
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    String str1 = "";
    if (localUserInfo != null) {
      str1 = localUserInfo.getRealName();
    }
    n.submitMovingEval(paramContext, paramString1, str1, paramInt, paramString2, str2, "", null, new com.freelxl.baselibrary.d.c.a(new m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_eval_submit", paramAnonymousString), paramContext);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
      }
    });
  }
  
  public void submitMvCancleReason(final Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    String str2 = a(paramContext);
    String str1 = paramString1;
    if ("其他原因".equals(paramString1)) {
      if (!TextUtils.isEmpty(paramString2)) {
        break label66;
      }
    }
    label66:
    for (str1 = paramString1;; str1 = paramString1 + "," + paramString2)
    {
      n.submitMvCancleReason(paramContext, paramString3, str1, str2, new com.freelxl.baselibrary.d.c.a(new m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          a.a(a.this, paramAnonymousThrowable, paramContext);
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("submit_mv_van_canale_reason", paramAnonymousString), paramContext);
          a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
        }
      });
      return;
    }
  }
  
  public void submitMvGoods(final Context paramContext, String paramString1, String paramString2, final List<MovingVanGoods> paramList)
  {
    String str = a(paramContext);
    if (str == null) {
      return;
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    com.alibaba.fastjson.b localb = new com.alibaba.fastjson.b();
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MovingVanGoods localMovingVanGoods = (MovingVanGoods)localIterator.next();
        e locale = new e();
        locale.put("materialsCode", localMovingVanGoods.logicCode);
        locale.put("buyNumber", Integer.valueOf(localMovingVanGoods.buyNumber));
        localb.add(locale);
      }
    }
    n.updateMvGoods(paramContext, paramString1, str, paramString2, localb, new c(new k(new h()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_goods_submit", paramList), paramContext);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
      }
    });
  }
  
  public void submitMvServices(final Context paramContext, String paramString1, String paramString2, List<MovingVanServiceItem> paramList)
  {
    String str = a(paramContext);
    if (str == null) {
      return;
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    com.alibaba.fastjson.b localb = new com.alibaba.fastjson.b();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MovingVanServiceItem localMovingVanServiceItem = (MovingVanServiceItem)paramList.next();
        e locale = new e();
        locale.put("serviceItemCode", localMovingVanServiceItem.getLogicCode());
        locale.put("buyNumber", Integer.valueOf(localMovingVanServiceItem.getBuyNumber()));
        localb.add(locale);
      }
    }
    n.updateMvService(paramContext, paramString1, str, paramString2, localb, new c(new k(new h()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_bulky_submit", null), paramContext);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
      }
    });
  }
  
  public void updateMovingVanAdd(final Context paramContext, String paramString1, String paramString2, Address paramAddress1, Address paramAddress2, int paramInt)
  {
    String str = a(paramContext);
    if (str == null) {}
    while ((paramAddress1 == null) || (paramAddress2 == null)) {
      return;
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    n.updateMvAddress(paramContext, paramString1, str, paramString2, paramAddress1, paramAddress2, paramInt, new c(new k(new h()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_out_add", null), paramContext);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_in_add", null), paramContext);
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_add", null), paramContext);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
      }
    });
  }
  
  public void updateMovingVanAddLocal(Context paramContext, String paramString1, String paramString2, Address paramAddress1, Address paramAddress2)
  {
    if (a(paramContext) == null) {
      return;
    }
    if ((paramAddress1 != null) && (paramAddress2 == null))
    {
      this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_out_add", paramAddress1), paramContext);
      return;
    }
    if ((paramAddress2 != null) && (paramAddress1 == null))
    {
      this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_in_add", paramAddress2), paramContext);
      return;
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_out_add", paramAddress1), paramContext);
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_in_add", paramAddress2), paramContext);
  }
  
  public void updateMovingVanCoupons(final Context paramContext, String paramString1, String paramString2, final al paramal)
  {
    String str = a(paramContext);
    if (str == null) {
      return;
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    if (paramal != null)
    {
      if (TextUtils.isEmpty(paramal.getPromoId()))
      {
        n.updateMvCoupon(paramContext, paramString1, str, paramString2, null, new c(new k(new h()))
        {
          public void onFailure(Throwable paramAnonymousThrowable)
          {
            a.a(a.this, paramAnonymousThrowable, paramContext);
          }
          
          public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
          {
            float f = paramal.getPromoPrice();
            a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_coupons", Float.valueOf(f)), paramContext);
            a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
          }
        });
        return;
      }
      com.alibaba.fastjson.b localb = new com.alibaba.fastjson.b();
      e locale = new e();
      locale.put("couponCode", paramal.getPromoId());
      locale.put("couponPrice", Float.valueOf(paramal.getPromoPrice()));
      localb.add(locale);
      n.updateMvCoupon(paramContext, paramString1, str, paramString2, localb, new c(new k(new h()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          a.a(a.this, paramAnonymousThrowable, paramContext);
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          float f = paramal.getPromoPrice();
          a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_coupons", Float.valueOf(f)), paramContext);
          a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
        }
      });
      return;
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_coupons", null), paramContext);
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
  }
  
  public void updateMovingVanGoods(Context paramContext, List<MovingVanGoods> paramList)
  {
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_goods", paramList), paramContext);
  }
  
  public void updateMovingVanMateCoupon(long paramLong, final Context paramContext, String paramString)
  {
    n.getMateCoupon(paramContext, 1, "", paramString, paramString, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(paramLong)), JPushReceiver.a, new com.freelxl.baselibrary.d.c.a(new m(ba.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, ba paramAnonymousba)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_get_mode_coupon", paramAnonymousba), paramContext);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
      }
    });
  }
  
  public void updateMovingVanPhone(Context paramContext, String paramString)
  {
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_phone", paramString), paramContext);
  }
  
  public void updateMovingVanRequirements(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    e locale = new e();
    locale.put("tag", paramString1);
    locale.put("msg", paramString3);
    locale.put("tagIds", paramString2);
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_requirement", locale), paramContext);
  }
  
  public void updateMovingVanServices(Context paramContext, List<MovingVanService> paramList)
  {
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_service", paramList), paramContext);
  }
  
  public void updateMovingVanTime(Context paramContext, String paramString1, String paramString2, final long paramLong1, long paramLong2, final String paramString3, final String paramString4)
  {
    String str = a(paramContext);
    if (str == null) {
      return;
    }
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    n.updateMvTime(paramContext, paramString1, str, paramString2, paramLong1, paramLong2, new c(new k(new h()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, this.d);
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        paramAnonymouse = new e();
        paramAnonymouse.put("date", Long.valueOf(paramLong1));
        paramAnonymouse.put("time", Long.valueOf(paramString4));
        paramAnonymouse.put("showTime", paramString3);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_time", paramAnonymouse), this.d);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), this.d);
        a.this.updateMovingVanMateCoupon(paramString4, this.d, this.e);
      }
    });
  }
  
  public void updateMvAddressFloor(Context paramContext, int paramInt1, int paramInt2, Address paramAddress)
  {
    int j = 0;
    int i = paramInt2;
    if (paramInt2 == 0)
    {
      i = 0;
      j = 1;
    }
    paramAddress.floors = i;
    paramAddress.isElevator = j;
    e locale = new e();
    locale.put("isStart", Integer.valueOf(paramInt1));
    locale.put("address", paramAddress);
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_update_address_floor", locale), paramContext);
  }
  
  public void updateMvCancleReason(Context paramContext, int paramInt)
  {
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_canale_updae", Integer.valueOf(paramInt)), paramContext);
  }
  
  public void updateMvGoods(Context paramContext, String paramString, int paramInt)
  {
    e locale = new e();
    locale.put("logicCode", paramString);
    locale.put("changeNum", Integer.valueOf(paramInt));
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_goods_update", locale), paramContext);
  }
  
  public void updateMvServices(Context paramContext, String paramString, int paramInt)
  {
    e locale = new e();
    locale.put("logicCode", paramString);
    locale.put("changeNum", Integer.valueOf(paramInt));
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("service_mv_van_bulky_update", locale), paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */