package com.ziroom.ziroomcustomer.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.home.bean.HouseDetailJs;
import com.ziroom.ziroomcustomer.home.bean.HouseDetailJs.ParamBean;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairCardListActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairOrderActivity;
import com.ziroom.ziroomcustomer.newclean.activity.CleanIndexActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanStoredCardBuyActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MovingIndexActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.RefactorMHMainActivity;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.u;
import java.util.Map;

public class b
{
  public void confirmChangeCard(BridgeWebView paramBridgeWebView, final a<Object> parama)
  {
    paramBridgeWebView.registerHandler("confirmChangeCard", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        com.freelxl.baselibrary.f.d.e("js  ", paramAnonymousString + "      ====");
        if (paramAnonymousString != null) {
          parama.onJsLinkCallBack(paramAnonymousString);
        }
      }
    });
  }
  
  public void finishBindCard(BridgeWebView paramBridgeWebView, final a<Object> parama)
  {
    paramBridgeWebView.registerHandler("finishBindCard", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        parama.onJsLinkCallBack("");
      }
    });
  }
  
  public void fiveBack(BridgeWebView paramBridgeWebView, com.freelxl.baselibrary.webview.a parama)
  {
    if (paramBridgeWebView != null) {
      paramBridgeWebView.registerHandler("fiveBack", parama);
    }
  }
  
  public void fiveGetToken(BridgeWebView paramBridgeWebView, com.freelxl.baselibrary.webview.a parama)
  {
    if (paramBridgeWebView != null) {
      paramBridgeWebView.registerHandler("fiveGetToken", parama);
    }
  }
  
  public void fiveH5LoginCallback(BridgeWebView paramBridgeWebView, String paramString)
  {
    if (paramBridgeWebView != null) {
      paramBridgeWebView.callHandler("fiveH5LoginCallback", paramString, null);
    }
  }
  
  public void fiveH5ShareCallback(BridgeWebView paramBridgeWebView)
  {
    if (paramBridgeWebView != null) {
      paramBridgeWebView.callHandler("fiveH5ShareCallback", "", null);
    }
  }
  
  public void fiveLogin(BridgeWebView paramBridgeWebView, com.freelxl.baselibrary.webview.a parama)
  {
    if (paramBridgeWebView != null) {
      paramBridgeWebView.registerHandler("fiveLogin", parama);
    }
  }
  
  public void fiveShare(BridgeWebView paramBridgeWebView, com.freelxl.baselibrary.webview.a parama)
  {
    if (paramBridgeWebView != null) {
      paramBridgeWebView.registerHandler("fiveShare", parama);
    }
  }
  
  public void getSignCallback(BridgeWebView paramBridgeWebView)
  {
    paramBridgeWebView.callHandler("getSignCallback", "", null);
  }
  
  public void goListPage(BridgeWebView paramBridgeWebView, com.freelxl.baselibrary.webview.a parama)
  {
    paramBridgeWebView.registerHandler("goListPage", parama);
  }
  
  public void h5ToApp(BridgeWebView paramBridgeWebView, final a parama)
  {
    paramBridgeWebView.registerHandler("regiterHanderH5ToApp", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        if (!TextUtils.isEmpty(paramAnonymousString))
        {
          paramAnonymousString = e.parseObject(paramAnonymousString);
          if ((paramAnonymousString != null) && (paramAnonymousString.containsKey("function"))) {
            parama.onCallBack(paramAnonymousString.getString("function"), paramAnonymousString.getJSONObject("parameter"));
          }
        }
      }
    });
  }
  
  public void toActivity(BridgeWebView paramBridgeWebView, final a<Object> parama)
  {
    paramBridgeWebView.registerHandler("toActivity", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        paramAnonymousString = com.alibaba.fastjson.a.parseObject(paramAnonymousString);
        if (paramAnonymousString != null) {
          parama.onJsLinkCallBack(paramAnonymousString.get("type"));
        }
      }
    });
  }
  
  public void toBuyServiceCard(BridgeWebView paramBridgeWebView, final a parama)
  {
    paramBridgeWebView.registerHandler("toBuyPage", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        parama.onJsLinkCallBack(paramAnonymousString);
      }
    });
  }
  
  public void toGoodsShelf(BridgeWebView paramBridgeWebView, final a<HouseDetailJs.ParamBean> parama)
  {
    paramBridgeWebView.registerHandler("toGoodsShelf", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        paramAnonymousString = (HouseDetailJs)com.alibaba.fastjson.a.parseObject(paramAnonymousString, HouseDetailJs.class);
        if (paramAnonymousString != null)
        {
          paramAnonymousString = paramAnonymousString.getParam();
          parama.onJsLinkCallBack(paramAnonymousString);
        }
      }
    });
  }
  
  public void toHouseDetail(BridgeWebView paramBridgeWebView, final a<HouseDetailJs.ParamBean> parama)
  {
    paramBridgeWebView.registerHandler("toHouseDetail", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        paramAnonymousString = (HouseDetailJs)com.alibaba.fastjson.a.parseObject(paramAnonymousString, HouseDetailJs.class);
        if (paramAnonymousString != null)
        {
          paramAnonymousString = paramAnonymousString.getParam();
          parama.onJsLinkCallBack(paramAnonymousString);
        }
      }
    });
  }
  
  public void toMoreHouseList(BridgeWebView paramBridgeWebView, final a<HouseDetailJs.ParamBean> parama)
  {
    paramBridgeWebView.registerHandler("toMoreHouseList", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        paramAnonymousString = (HouseDetailJs)com.alibaba.fastjson.a.parseObject(paramAnonymousString, HouseDetailJs.class);
        if (paramAnonymousString != null)
        {
          paramAnonymousString = paramAnonymousString.getParam();
          parama.onJsLinkCallBack(paramAnonymousString);
        }
      }
    });
  }
  
  public void toPhone(BridgeWebView paramBridgeWebView, final a<HouseDetailJs.ParamBean> parama)
  {
    paramBridgeWebView.registerHandler("toPhone", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        paramAnonymousString = (HouseDetailJs)com.alibaba.fastjson.a.parseObject(paramAnonymousString, HouseDetailJs.class);
        if (paramAnonymousString != null)
        {
          paramAnonymousString = paramAnonymousString.getParam();
          parama.onJsLinkCallBack(paramAnonymousString);
        }
      }
    });
  }
  
  public void toServiceActivity(final BridgeWebView paramBridgeWebView)
  {
    paramBridgeWebView.registerHandler("clean_richang", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        paramAnonymousString = new Intent(paramBridgeWebView.getContext(), CleanIndexActivity.class);
        paramAnonymousString.putExtra("ServiceInfoId", "2c9084454b7835b0014b7841269101a9");
        paramAnonymousString.putExtra("ServiceInfoName", "日常保洁");
        paramBridgeWebView.getContext().startActivity(paramAnonymousString);
      }
    });
    paramBridgeWebView.registerHandler("clean_shendu", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("ServiceInfoId", "2c9084434b783482014b784188290209");
        paramAnonymousString.putString("ServiceInfoName", "深度保洁");
        paramAnonymousd = new Intent(paramBridgeWebView.getContext(), CleanIndexActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramBridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramBridgeWebView.registerHandler("clean_xiaosha", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("ServiceInfoId", "2c9084454b7835b0014b7842917e01d7");
        paramAnonymousString.putString("ServiceInfoName", "消杀保洁");
        paramAnonymousd = new Intent(paramBridgeWebView.getContext(), CleanIndexActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramBridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramBridgeWebView.registerHandler("clean_kaihuang", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("ServiceInfoId", "2c9084454b7835b0014b78422b1e01cb");
        paramAnonymousString.putString("ServiceInfoName", "新居开荒");
        paramAnonymousd = new Intent(paramBridgeWebView.getContext(), CleanIndexActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramBridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramBridgeWebView.registerHandler("clean_minsu", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramBridgeWebView.getContext());
          af.showToast(paramBridgeWebView.getContext(), "请先登录");
          return;
        }
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("ServiceInfoId", "8a90a28956f928920156f9c0472f000a");
        paramAnonymousString.putString("ServiceInfoName", "民宿保洁");
        paramAnonymousd = new Intent(paramBridgeWebView.getContext(), CleanIndexActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramBridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramBridgeWebView.registerHandler("clean_caboli", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("ServiceInfoId", "8a90a5d8580a5cb2015822c397920018");
        paramAnonymousString.putString("ServiceInfoName", "擦玻璃");
        paramAnonymousd = new Intent(paramBridgeWebView.getContext(), CleanIndexActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramBridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramBridgeWebView.registerHandler("clean_chuman", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("ServiceInfoId", "8a90a5d85841edb0015847dd78a80014");
        paramAnonymousString.putString("ServiceInfoName", "专业除螨");
        paramAnonymousd = new Intent(paramBridgeWebView.getContext(), CleanIndexActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramBridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramBridgeWebView.registerHandler("move_xiaoban", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("serviceInfoId", "2c9085f248ba3f3a0148bb156f6e0004");
        paramAnonymousd = new Intent(paramBridgeWebView.getContext(), RefactorMHMainActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramBridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramBridgeWebView.registerHandler("move_truck", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("productCode", "8a90a5f8593e65b501593e65b5200000");
        paramAnonymousd = new Intent(paramBridgeWebView.getContext(), MovingIndexActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramBridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramBridgeWebView.registerHandler("repair_shuiluguanjian", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramBridgeWebView.getContext());
          af.showToast(paramBridgeWebView.getContext(), "请先登录");
          return;
        }
        paramAnonymousString = new Bundle();
        paramAnonymousString.putInt("type", 0);
        paramAnonymousd = new Intent(paramBridgeWebView.getContext(), RepairOrderActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramBridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramBridgeWebView.registerHandler("repair_dengjudianlu", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramBridgeWebView.getContext());
          af.showToast(paramBridgeWebView.getContext(), "请先登录");
          return;
        }
        paramAnonymousString = new Bundle();
        paramAnonymousString.putInt("type", 1);
        paramAnonymousd = new Intent(paramBridgeWebView.getContext(), RepairOrderActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramBridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramBridgeWebView.registerHandler("repair_kaisuohuansuo", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramBridgeWebView.getContext());
          af.showToast(paramBridgeWebView.getContext(), "请先登录");
          return;
        }
        paramAnonymousString = new Bundle();
        paramAnonymousString.putInt("type", 2);
        paramAnonymousd = new Intent(paramBridgeWebView.getContext(), RepairOrderActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramBridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramBridgeWebView.registerHandler("repair_kongtiaoqingxi", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramBridgeWebView.getContext());
          af.showToast(paramBridgeWebView.getContext(), "请先登录");
          return;
        }
        paramAnonymousString = new Bundle();
        paramAnonymousString.putInt("type", 3);
        paramAnonymousd = new Intent(paramBridgeWebView.getContext(), RepairOrderActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramBridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramBridgeWebView.registerHandler("card_repair", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramBridgeWebView.getContext());
          af.showToast(paramBridgeWebView.getContext(), "请先登录");
          return;
        }
        paramAnonymousString = new Intent(paramBridgeWebView.getContext(), RepairCardListActivity.class);
        paramBridgeWebView.getContext().startActivity(paramAnonymousString);
      }
    });
    paramBridgeWebView.registerHandler("card_clean", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramBridgeWebView.getContext());
          af.showToast(paramBridgeWebView.getContext(), "请先登录");
          return;
        }
        paramAnonymousString = new Intent(paramBridgeWebView.getContext(), CleanStoredCardBuyActivity.class);
        paramBridgeWebView.getContext().startActivity(paramAnonymousString);
      }
    });
    paramBridgeWebView.registerHandler("finish_web", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        ((Activity)paramBridgeWebView.getContext()).finish();
      }
    });
  }
  
  public void toServiceShare(BridgeWebView paramBridgeWebView, final a<String> parama)
  {
    paramBridgeWebView.registerHandler("evalshare_share", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        u.d("sdjgkjg", "===== zhixingle ..0");
        parama.onJsLinkCallBack("evalshare_share");
      }
    });
  }
  
  public void toSign(BridgeWebView paramBridgeWebView, final a<Object> parama)
  {
    paramBridgeWebView.registerHandler("toSign", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, com.freelxl.baselibrary.webview.d paramAnonymousd)
      {
        parama.onJsLinkCallBack("");
      }
    });
  }
  
  public static abstract interface a<T>
  {
    public abstract void onJsLinkCallBack(T paramT);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/webview/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */