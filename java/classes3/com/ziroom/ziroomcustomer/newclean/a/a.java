package com.ziroom.ziroomcustomer.newclean.a;

import android.content.Context;
import android.text.TextUtils;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.h;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.d.al;
import com.ziroom.ziroomcustomer.newclean.d.ap;
import com.ziroom.ziroomcustomer.newclean.d.ba;
import com.ziroom.ziroomcustomer.newclean.d.x;
import java.net.UnknownHostException;
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
  
  public void getCleanAddressInfo(final Context paramContext)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    String str = ((UserInfo)localObject).getRealName();
    localObject = ((UserInfo)localObject).getUid();
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    n.requestBedroomAddress(paramContext, str, (String)localObject, new com.freelxl.baselibrary.d.c.c(new com.ziroom.ziroomcustomer.e.c.e(com.ziroom.ziroomcustomer.newclean.d.e.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.ziroomcustomer.newclean.d.e> paramAnonymousList)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("clean_get_bedroom_address", paramAnonymousList), paramContext);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
      }
    });
  }
  
  public void getRecommondCoupon(final Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = a(paramContext);
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    n.getMateCoupon(paramContext, 2, paramString1, paramString2, paramString3, paramString4, str, new com.freelxl.baselibrary.d.c.c(new m(ba.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, ba paramAnonymousba)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
        if (paramAnonymousba != null) {
          a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("clean_recommond_coupon", paramAnonymousba), paramContext);
        }
      }
    });
  }
  
  public void setCleanAddressInfo(Context paramContext, com.ziroom.ziroomcustomer.newclean.d.c paramc, String paramString, int paramInt, boolean paramBoolean)
  {
    com.ziroom.ziroomcustomer.newclean.d.c localc = paramc;
    if (paramc == null) {
      localc = new com.ziroom.ziroomcustomer.newclean.d.c();
    }
    localc.setIsCleanSameCity(paramString);
    localc.setResultCode(paramInt);
    localc.setHaveData(paramBoolean);
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("clean_set_address_info", localc), paramContext);
  }
  
  public void setCleanCoupon(Context paramContext, al paramal, int paramInt)
  {
    al localal = paramal;
    if (paramal == null) {
      localal = new al();
    }
    localal.setResultCode(paramInt);
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("clean_set_coupon_info", localal), paramContext);
  }
  
  public void setCleanSpecialNeed(Context paramContext, String paramString1, String paramString2)
  {
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    String str1;
    if (!TextUtils.isEmpty(paramString2))
    {
      String str2 = paramString1 + "," + paramString2;
      String[] arrayOfString = com.ziroom.ziroomcustomer.newclean.view.a.getSpaceTar(paramString2);
      paramString2 = "";
      str1 = paramString2;
      if (arrayOfString.length > 0)
      {
        int i = 0;
        str1 = paramString2;
        if (i < arrayOfString.length)
        {
          if (i == 0) {}
          for (paramString2 = arrayOfString[0];; paramString2 = paramString2 + " " + arrayOfString[i])
          {
            i += 1;
            break;
          }
        }
      }
      str1 = str1 + " " + paramString1;
      paramString1 = str2;
      paramString2 = paramString1;
    }
    for (;;)
    {
      locale.put("remark", paramString2);
      locale.put("showremark", str1);
      this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("clean_set_special_info", locale), paramContext);
      return;
      paramString2 = paramString1;
      str1 = paramString1;
    }
  }
  
  public void setCommitOrderInfo(final Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, List<x> paramList, int paramInt, String paramString12, String paramString13)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null)
    {
      this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_login", null), paramContext);
      return;
    }
    String str = ((UserInfo)localObject).getLoginName();
    localObject = ((UserInfo)localObject).getUid();
    this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_show_loading", null), paramContext);
    n.requestCreateBedOrder(paramContext, (String)localObject, paramString2, paramString3, paramString6, "", paramString7, "", "", paramString4, paramString1, "", paramString10, 12, str, paramString5, paramString9, "", "", "", "", paramList, paramString8, j.getChannelCode(paramString2), "", paramString11, paramInt, paramString12, paramString13, new com.freelxl.baselibrary.d.c.c(new h(ap.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable, paramContext);
      }
      
      public void onSuccess(int paramAnonymousInt, ap paramAnonymousap)
      {
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_dismiss_loading", null), paramContext);
        if (paramAnonymousap == null)
        {
          a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("type_toast", "服务异常，请稍后重试"), paramContext);
          return;
        }
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("clean_create_order", paramAnonymousap), paramContext);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */