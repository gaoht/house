package com.ziroom.ziroomcustomer.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.freelxl.baselibrary.webview.X5_BridgeWebView;
import com.freelxl.baselibrary.webview.d;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.home.bean.HouseDetailJs;
import com.ziroom.ziroomcustomer.home.bean.HouseDetailJs.ParamBean;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairCardListActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairOrderActivity;
import com.ziroom.ziroomcustomer.newclean.activity.CleanIndexActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanCardListActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MovingIndexActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.RefactorMHMainActivity;
import com.ziroom.ziroomcustomer.util.af;
import java.util.Map;

public class c
{
  public void confirmChangeCard(X5_BridgeWebView paramX5_BridgeWebView, final a<Object> parama)
  {
    paramX5_BridgeWebView.registerHandler("confirmChangeCard", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        parama.onJsLinkCallBack(paramAnonymousString);
      }
    });
  }
  
  public void finishBindCard(X5_BridgeWebView paramX5_BridgeWebView, final a<Object> parama)
  {
    paramX5_BridgeWebView.registerHandler("finishBindCard", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        parama.onJsLinkCallBack("");
      }
    });
  }
  
  public void fiveBack(X5_BridgeWebView paramX5_BridgeWebView, com.freelxl.baselibrary.webview.a parama)
  {
    if (paramX5_BridgeWebView != null) {
      paramX5_BridgeWebView.registerHandler("fiveBack", parama);
    }
  }
  
  public void fiveGetToken(X5_BridgeWebView paramX5_BridgeWebView, com.freelxl.baselibrary.webview.a parama)
  {
    if (paramX5_BridgeWebView != null) {
      paramX5_BridgeWebView.registerHandler("fiveGetToken", parama);
    }
  }
  
  public void fiveH5LoginCallback(X5_BridgeWebView paramX5_BridgeWebView, String paramString)
  {
    if (paramX5_BridgeWebView != null) {
      paramX5_BridgeWebView.callHandler("fiveH5LoginCallback", paramString, null);
    }
  }
  
  public void fiveH5ShareCallback(X5_BridgeWebView paramX5_BridgeWebView)
  {
    if (paramX5_BridgeWebView != null) {
      paramX5_BridgeWebView.callHandler("fiveH5ShareCallback", "", null);
    }
  }
  
  public void fiveLogin(X5_BridgeWebView paramX5_BridgeWebView, com.freelxl.baselibrary.webview.a parama)
  {
    if (paramX5_BridgeWebView != null) {
      paramX5_BridgeWebView.registerHandler("fiveLogin", parama);
    }
  }
  
  public void fiveShare(X5_BridgeWebView paramX5_BridgeWebView, com.freelxl.baselibrary.webview.a parama)
  {
    if (paramX5_BridgeWebView != null) {
      paramX5_BridgeWebView.registerHandler("fiveShare", parama);
    }
  }
  
  public void getSignCallback(X5_BridgeWebView paramX5_BridgeWebView)
  {
    paramX5_BridgeWebView.callHandler("getSignCallback", "", null);
  }
  
  public void goListPage(X5_BridgeWebView paramX5_BridgeWebView, com.freelxl.baselibrary.webview.a parama)
  {
    paramX5_BridgeWebView.registerHandler("goListPage", parama);
  }
  
  public void toActivity(X5_BridgeWebView paramX5_BridgeWebView, final a<Object> parama)
  {
    paramX5_BridgeWebView.registerHandler("toActivity", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        paramAnonymousString = com.alibaba.fastjson.a.parseObject(paramAnonymousString);
        if (paramAnonymousString != null) {
          parama.onJsLinkCallBack(paramAnonymousString.get("type"));
        }
      }
    });
  }
  
  public void toBuyServiceCard(X5_BridgeWebView paramX5_BridgeWebView, final a parama)
  {
    paramX5_BridgeWebView.registerHandler("toBuyPage", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        parama.onJsLinkCallBack(paramAnonymousString);
      }
    });
  }
  
  public void toGoodsShelf(X5_BridgeWebView paramX5_BridgeWebView, final a<HouseDetailJs.ParamBean> parama)
  {
    paramX5_BridgeWebView.registerHandler("toGoodsShelf", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
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
  
  public void toHouseDetail(X5_BridgeWebView paramX5_BridgeWebView, final a<HouseDetailJs.ParamBean> parama)
  {
    paramX5_BridgeWebView.registerHandler("toHouseDetail", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
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
  
  public void toMoreHouseList(X5_BridgeWebView paramX5_BridgeWebView, final a<HouseDetailJs.ParamBean> parama)
  {
    paramX5_BridgeWebView.registerHandler("toMoreHouseList", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
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
  
  public void toPhone(X5_BridgeWebView paramX5_BridgeWebView, final a<HouseDetailJs.ParamBean> parama)
  {
    paramX5_BridgeWebView.registerHandler("toPhone", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
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
  
  public void toServiceActivity(final X5_BridgeWebView paramX5_BridgeWebView)
  {
    paramX5_BridgeWebView.registerHandler("clean_richang", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        paramAnonymousString = new Intent(paramX5_BridgeWebView.getContext(), CleanIndexActivity.class);
        paramAnonymousString.putExtra("ServiceInfoId", "2c9084454b7835b0014b7841269101a9");
        paramAnonymousString.putExtra("ServiceInfoName", "日常保洁");
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousString);
      }
    });
    paramX5_BridgeWebView.registerHandler("clean_shendu", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("ServiceInfoId", "2c9084434b783482014b784188290209");
        paramAnonymousString.putString("ServiceInfoName", "深度保洁");
        paramAnonymousd = new Intent(paramX5_BridgeWebView.getContext(), CleanIndexActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramX5_BridgeWebView.registerHandler("clean_xiaosha", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("ServiceInfoId", "2c9084454b7835b0014b7842917e01d7");
        paramAnonymousString.putString("ServiceInfoName", "消杀保洁");
        paramAnonymousd = new Intent(paramX5_BridgeWebView.getContext(), CleanIndexActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramX5_BridgeWebView.registerHandler("clean_kaihuang", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("ServiceInfoId", "2c9084454b7835b0014b78422b1e01cb");
        paramAnonymousString.putString("ServiceInfoName", "新居开荒");
        paramAnonymousd = new Intent(paramX5_BridgeWebView.getContext(), CleanIndexActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramX5_BridgeWebView.registerHandler("clean_minsu", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramX5_BridgeWebView.getContext());
          af.showToast(paramX5_BridgeWebView.getContext(), "请先登录");
          return;
        }
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("ServiceInfoId", "8a90a28956f928920156f9c0472f000a");
        paramAnonymousString.putString("ServiceInfoName", "民宿保洁");
        paramAnonymousd = new Intent(paramX5_BridgeWebView.getContext(), CleanIndexActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramX5_BridgeWebView.registerHandler("clean_caboli", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("ServiceInfoId", "8a90a5d8580a5cb2015822c397920018");
        paramAnonymousString.putString("ServiceInfoName", "擦玻璃");
        paramAnonymousd = new Intent(paramX5_BridgeWebView.getContext(), CleanIndexActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramX5_BridgeWebView.registerHandler("clean_chuman", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("ServiceInfoId", "8a90a5d85841edb0015847dd78a80014");
        paramAnonymousString.putString("ServiceInfoName", "专业除螨");
        paramAnonymousd = new Intent(paramX5_BridgeWebView.getContext(), CleanIndexActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramX5_BridgeWebView.registerHandler("move_xiaoban", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("serviceInfoId", "2c9085f248ba3f3a0148bb156f6e0004");
        paramAnonymousd = new Intent(paramX5_BridgeWebView.getContext(), RefactorMHMainActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramX5_BridgeWebView.registerHandler("move_truck", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        paramAnonymousString = new Bundle();
        paramAnonymousString.putString("productCode", "8a90a5f8593e65b501593e65b5200000");
        paramAnonymousd = new Intent(paramX5_BridgeWebView.getContext(), MovingIndexActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramX5_BridgeWebView.registerHandler("repair_shuiluguanjian", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramX5_BridgeWebView.getContext());
          af.showToast(paramX5_BridgeWebView.getContext(), "请先登录");
          return;
        }
        paramAnonymousString = new Bundle();
        paramAnonymousString.putInt("type", 0);
        paramAnonymousd = new Intent(paramX5_BridgeWebView.getContext(), RepairOrderActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramX5_BridgeWebView.registerHandler("repair_dengjudianlu", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramX5_BridgeWebView.getContext());
          af.showToast(paramX5_BridgeWebView.getContext(), "请先登录");
          return;
        }
        paramAnonymousString = new Bundle();
        paramAnonymousString.putInt("type", 1);
        paramAnonymousd = new Intent(paramX5_BridgeWebView.getContext(), RepairOrderActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramX5_BridgeWebView.registerHandler("repair_kaisuohuansuo", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramX5_BridgeWebView.getContext());
          af.showToast(paramX5_BridgeWebView.getContext(), "请先登录");
          return;
        }
        paramAnonymousString = new Bundle();
        paramAnonymousString.putInt("type", 2);
        paramAnonymousd = new Intent(paramX5_BridgeWebView.getContext(), RepairOrderActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramX5_BridgeWebView.registerHandler("repair_kongtiaoqingxi", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramX5_BridgeWebView.getContext());
          af.showToast(paramX5_BridgeWebView.getContext(), "请先登录");
          return;
        }
        paramAnonymousString = new Bundle();
        paramAnonymousString.putInt("type", 3);
        paramAnonymousd = new Intent(paramX5_BridgeWebView.getContext(), RepairOrderActivity.class);
        paramAnonymousd.putExtras(paramAnonymousString);
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousd);
      }
    });
    paramX5_BridgeWebView.registerHandler("card_repair", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramX5_BridgeWebView.getContext());
          af.showToast(paramX5_BridgeWebView.getContext(), "请先登录");
          return;
        }
        paramAnonymousString = new Intent(paramX5_BridgeWebView.getContext(), RepairCardListActivity.class);
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousString);
      }
    });
    paramX5_BridgeWebView.registerHandler("card_clean", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        if (!ApplicationEx.c.isLoginState())
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(paramX5_BridgeWebView.getContext());
          af.showToast(paramX5_BridgeWebView.getContext(), "请先登录");
          return;
        }
        paramAnonymousString = new Intent(paramX5_BridgeWebView.getContext(), CleanCardListActivity.class);
        paramX5_BridgeWebView.getContext().startActivity(paramAnonymousString);
      }
    });
    paramX5_BridgeWebView.registerHandler("finish_web", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        ((Activity)paramX5_BridgeWebView.getContext()).finish();
      }
    });
  }
  
  public void toSign(X5_BridgeWebView paramX5_BridgeWebView, final a<Object> parama)
  {
    paramX5_BridgeWebView.registerHandler("toSign", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/webview/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */