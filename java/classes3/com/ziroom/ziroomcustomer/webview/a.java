package com.ziroom.ziroomcustomer.webview;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.webview.BridgeWebView;
import com.freelxl.baselibrary.webview.d;
import com.ziroom.commonlib.utils.s;
import com.ziroom.commonlibrary.login.LoginActivity;
import com.ziroom.router.activityrouter.Routers;
import com.ziroom.threelib.ziroomshare.c;
import com.ziroom.ziroomcustomer.account.AccountMainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.bestgoods.activity.GoodsDetailAc;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGuidanceActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGuidanceH5Activity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinShoppingCartActivity;
import com.ziroom.ziroomcustomer.findhouse.HouseListActivity;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.home.bean.MoreBean;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.MyAccountActivity;
import com.ziroom.ziroomcustomer.my.MyCouponActivity;
import com.ziroom.ziroomcustomer.my.OwnerZoneActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairCardListActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairOrderActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.RepairOrderNewActivity;
import com.ziroom.ziroomcustomer.newclean.activity.CleanIndexActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanGiftCardActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.activity.CleanStoredCardBuyActivity;
import com.ziroom.ziroomcustomer.newclean.mvp.CleanHomeActivity;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodCleanerSelectActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MoveTypeActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MovingIndexActivity;
import com.ziroom.ziroomcustomer.signed.o;
import com.ziroom.ziroomcustomer.social.activity.ac.AcEnrollActivity;
import com.ziroom.ziroomcustomer.social.activity.ac.AcMainActivity;
import com.ziroom.ziroomcustomer.social.activity.zz.ZzSocialChatDetailActivity;
import com.ziroom.ziroomcustomer.social.activity.zz.ZzSocialMySpaceActivity;
import com.ziroom.ziroomcustomer.sublet.activity.LeaseSubletSelectTimeActivity;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.y;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class a
{
  private Context a;
  private BridgeWebView b;
  private PlatformActionListener c = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
    {
      u.d("#########分享取消回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享取消");
    }
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      s.showToast("分享成功");
      paramAnonymousHashMap = new StringBuilder();
      if (a.a(a.this) == null) {}
      for (boolean bool = true;; bool = false)
      {
        u.d("#########分享完成回调: 平台  ", bool + "=====" + paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功====" + getClass().getSimpleName());
        return;
      }
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      s.showToast("分享失败");
      u.d("#########分享失败回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享失败====" + getClass().getSimpleName());
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  
  private void M(e parame)
  {
    if (parame != null)
    {
      int j = parame.getIntValue("amount");
      String str1 = "";
      Object localObject = com.alibaba.fastjson.a.parseArray(parame.get("orderIds").toString());
      int i = 0;
      if (i < ((com.alibaba.fastjson.b)localObject).size())
      {
        String str2 = (String)((com.alibaba.fastjson.b)localObject).get(i);
        if (i + 1 == ((com.alibaba.fastjson.b)localObject).size()) {}
        for (str1 = str1 + str2.toString();; str1 = str1 + str2.toString() + ",")
        {
          i += 1;
          break;
        }
      }
      localObject = parame.get("timeInterval").toString();
      parame = parame.getString("systemId");
      com.ziroom.ziroomcustomer.payment.a.startPayActivty((Activity)this.a, j, "h5toPayCenter", str1, parame, (String)localObject);
    }
  }
  
  private void N(e parame)
  {
    if ((parame != null) && (parame.containsKey("imgUrl")) && (!TextUtils.isEmpty(parame.getString("imgUrl")))) {
      com.freelxl.baselibrary.d.a.get(parame.getString("imgUrl")).tag(this.a).enqueue(new com.freelxl.baselibrary.d.c.a(new com.ziroom.commonlibrary.a.b.a())
      {
        public void onFailure(Throwable paramAnonymousThrowable) {}
        
        public void onSuccess(int paramAnonymousInt, Bitmap paramAnonymousBitmap)
        {
          if (paramAnonymousBitmap != null)
          {
            MediaStore.Images.Media.insertImage(a.a(a.this).getContentResolver(), paramAnonymousBitmap, "ziroom-webview-save-image", "ziroom-webview-save-image");
            com.freelxl.baselibrary.f.g.textToast(a.a(a.this), "保存图片成功！");
          }
        }
      });
    }
  }
  
  private void O(e parame)
  {
    Intent localIntent = new Intent(this.a, GoodsDetailAc.class);
    String str = parame.getString("productCode");
    parame = parame.getString("skuCode");
    u.e("noob", "productCode === " + str + "\t skuCode === " + parame);
    localIntent.putExtra("productCode", str);
    localIntent.putExtra("skuCode", parame);
    this.a.startActivity(localIntent);
  }
  
  private void P(e parame)
  {
    parame = new Intent(this.a, LoginActivity.class);
    this.a.startActivity(parame);
  }
  
  private void Q(e parame)
  {
    if ((parame != null) && (parame.containsKey("phoneNumber")))
    {
      parame = parame.getString("phoneNumber");
      if (!TextUtils.isEmpty(parame)) {
        ah.callPhone(this.a, parame);
      }
    }
  }
  
  private void R(e parame)
  {
    parame = new Intent(this.a, MoveTypeActivity.class);
    this.a.startActivity(parame);
  }
  
  private void S(e parame)
  {
    parame = new Intent(this.a, CleanHomeActivity.class);
    this.a.startActivity(parame);
  }
  
  private void T(e parame)
  {
    Object localObject;
    if ((parame != null) && (parame.containsKey("pdfUrl")))
    {
      parame = parame.getString("pdfUrl");
      localObject = parame.substring(parame.lastIndexOf("/"));
      File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/ziroom/file");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localObject = new File(localFile, (String)localObject);
      if (((File)localObject).exists()) {}
    }
    try
    {
      ((File)localObject).createNewFile();
      com.freelxl.baselibrary.d.a.get(parame).tag(this.a).enqueue(new com.ziroom.commonlibrary.a.a(this.a, new com.freelxl.baselibrary.d.f.b((File)localObject))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          com.freelxl.baselibrary.f.g.textToast(a.a(a.this), "pdf下载失败！");
        }
        
        public void onSuccess(int paramAnonymousInt, File paramAnonymousFile)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousFile);
          if ((paramAnonymousFile.exists()) && (paramAnonymousFile.isFile()))
          {
            Intent localIntent = new Intent("android.intent.action.VIEW");
            localIntent.addCategory("android.intent.category.DEFAULT");
            localIntent.addFlags(268435456);
            localIntent.setDataAndType(Uri.fromFile(paramAnonymousFile), "application/pdf");
            paramAnonymousFile = a.a(a.this).getPackageManager().queryIntentActivities(localIntent, 65536);
            if ((paramAnonymousFile != null) && (paramAnonymousFile.size() > 0)) {
              a.a(a.this).startActivity(localIntent);
            }
          }
          else
          {
            return;
          }
          com.freelxl.baselibrary.f.g.textToast(a.a(a.this), "设备不支持查看pdf文件，请安装pdf阅读软件！");
        }
      });
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.freelxl.baselibrary.f.g.textToast(this.a, "pdf创建失败！");
        localIOException.printStackTrace();
      }
    }
  }
  
  private void U(e parame)
  {
    parame = parame.getString("activity_url");
    JsBridgeWebActivity.start(this.a, "", parame, false, "", "", false);
  }
  
  private void g()
  {
    if (ApplicationEx.c.isLoginState())
    {
      Intent localIntent = new Intent(this.a, MyCouponActivity.class);
      this.a.startActivity(localIntent);
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
  }
  
  private void h()
  {
    if (ApplicationEx.c.isLoginState())
    {
      Routers.open(this.a, "ziroomCustomer://zrCreditModule/home");
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
  }
  
  private void i()
  {
    Intent localIntent = new Intent(this.a, MyAccountActivity.class);
    this.a.startActivity(localIntent);
  }
  
  private void j()
  {
    Intent localIntent = new Intent(this.a, CleanGiftCardActivity.class);
    this.a.startActivity(localIntent);
  }
  
  private void k()
  {
    if (!ApplicationEx.c.isLoginState())
    {
      LocalBroadcastManager.getInstance(this.a).registerReceiver(new BroadcastReceiver()new IntentFilter
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if (paramAnonymousIntent.getIntExtra("type", 0) == 1) {
            Routers.open(a.a(a.this), "ziroomCustomer://zrCreditModule/scorePromoteView");
          }
        }
      }, new IntentFilter("com.ziroom.commonlibrary.login.broadcast"));
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      af.showToast(this.a, "请先登录");
      return;
    }
    Routers.open(this.a, "ziroomCustomer://zrCreditModule/scorePromoteView");
  }
  
  protected void A(e parame)
  {
    parame = new Intent(this.a, OwnerZoneActivity.class);
    if (!(this.a instanceof Activity)) {
      parame.setFlags(268435456);
    }
    this.a.startActivity(parame);
  }
  
  protected void B(e parame)
  {
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences(y.a, 0).edit();
    String str = parame.getString("formInfoJson");
    parame = parame.getString("resultInfoJson");
    str = com.ziroom.ziroomcustomer.util.k.encrypt(str);
    parame = com.ziroom.ziroomcustomer.util.k.encrypt(parame);
    localEditor.putString("owner_estimate_form_info", str);
    localEditor.putString("owner_estimate_result_info", parame);
    localEditor.commit();
  }
  
  protected void C(e parame)
  {
    parame = parame.getString("submitted");
    y.putStringWithDes(this.a, "owner_estimate_submited_info", parame);
  }
  
  protected void D(e parame)
  {
    parame = new Intent(this.a, OwnerZoneActivity.class);
    if (!(this.a instanceof Activity)) {
      parame.setFlags(268435456);
    }
    this.a.startActivity(parame);
  }
  
  protected void E(e parame)
  {
    if ((this.a instanceof Activity)) {
      ((Activity)this.a).finish();
    }
  }
  
  protected void F(e parame)
  {
    com.ziroom.ziroomcustomer.minsu.f.k.toHouseDetail(this.a, parame.getString("fid"), parame.getString("rentWay"), "1".equals(parame.getString("isTop50")));
  }
  
  protected void G(e parame)
  {
    com.ziroom.ziroomcustomer.minsu.f.k.toStationProject(this.a, parame.getString("projectBid"));
  }
  
  protected void H(e parame)
  {
    if (parame != null)
    {
      Intent localIntent = new Intent(this.a, AcEnrollActivity.class);
      localIntent.putExtra("acCode", parame.getString("activityCode"));
      localIntent.putExtra("cityCode", parame.getString("cityCode"));
      if (!(this.a instanceof Activity)) {
        localIntent.setFlags(268435456);
      }
      this.a.startActivity(localIntent);
    }
  }
  
  protected void I(e parame)
  {
    if (parame != null)
    {
      Intent localIntent = new Intent(this.a, AcMainActivity.class);
      localIntent.putExtra("cityCode", parame.getString("cityCode"));
      if (!(this.a instanceof Activity)) {
        localIntent.setFlags(268435456);
      }
      this.a.startActivity(localIntent);
    }
  }
  
  protected void J(e parame)
  {
    if (parame != null)
    {
      if (ApplicationEx.c.isLoginState())
      {
        parame = new Intent(this.a, AccountMainActivity.class);
        if (!(this.a instanceof Activity)) {
          parame.setFlags(268435456);
        }
        this.a.startActivity(parame);
      }
    }
    else {
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
  }
  
  protected void K(e parame)
  {
    u.d("sjdgkj", "========= inviteToActivity " + com.alibaba.fastjson.a.toJSONString(parame));
    if (parame != null)
    {
      Intent localIntent = new Intent(this.a, ZzSocialChatDetailActivity.class);
      localIntent.putExtra("activityPic", parame.getString("activityPic"));
      localIntent.putExtra("activityTitle", parame.getString("activityTitle"));
      localIntent.putExtra("activityDesc", parame.getString("activityDesc"));
      localIntent.putExtra("activityStartTime", parame.getString("activityStartTime"));
      localIntent.putExtra("activityUrl", parame.getString("activityUrl"));
      this.a.startActivity(localIntent);
    }
  }
  
  protected void L(e parame)
  {
    Context localContext;
    String str1;
    String str2;
    if (parame != null)
    {
      localContext = this.a;
      str1 = parame.getString("title");
      str2 = parame.getString("linkUrl");
      if (TextUtils.isEmpty(parame.getString("shareContent"))) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      JsBridgeWebActivity.start(localContext, str1, str2, bool, parame.getString("shareContent"), parame.getString("shareImageUrl"), parame.getBoolean("isBackMain").booleanValue(), true);
      return;
    }
  }
  
  protected void a() {}
  
  protected void a(e parame)
  {
    u.d("JsBridgeHelper", "======JsBridgeHelper:" + parame.toJSONString());
  }
  
  protected void a(String paramString, e parame) {}
  
  protected void b()
  {
    if (!ApplicationEx.c.isLoginState())
    {
      LocalBroadcastManager.getInstance(this.a).registerReceiver(new BroadcastReceiver()new IntentFilter
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if (paramAnonymousIntent.getIntExtra("type", 0) == 1) {
            Routers.open(a.a(a.this), "ziroomCustomer://zrCreditModule/impowerView");
          }
        }
      }, new IntentFilter("com.ziroom.commonlibrary.login.broadcast"));
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      af.showToast(this.a, "请先登录");
      return;
    }
    Routers.open(this.a, "ziroomCustomer://zrCreditModule/impowerView");
  }
  
  protected void b(e parame)
  {
    u.d("JsBridgeHelper", "======JsBridgeHelper:" + parame.toJSONString());
  }
  
  protected void c()
  {
    sendLoginInfo();
  }
  
  protected void c(e parame)
  {
    u.d("JsBridgeHelper", "======JsBridgeHelper:" + parame.toJSONString());
  }
  
  protected void d()
  {
    e();
  }
  
  protected void d(e parame) {}
  
  public void destroy()
  {
    this.a = null;
    this.b = null;
  }
  
  public final void doCallH5(String paramString, e parame)
  {
    if (this.b != null)
    {
      e locale = new e();
      locale.put("type", "");
      locale.put("function", paramString);
      locale.put("parameter", parame);
      u.d("JsBridgeHelper", "=====doCallH5:" + locale.toJSONString());
      this.b.callHandler("regiterHanderAppToH5", locale.toJSONString(), null);
    }
  }
  
  protected void e()
  {
    String str1 = y.getStringWithDes(this.a, "owner_estimate_form_info");
    String str2 = y.getStringWithDes(this.a, "owner_estimate_result_info");
    String str3 = y.getStringWithDes(this.a, "owner_estimate_submited_info");
    e locale = new e();
    locale.put("formInfoJson", str1);
    locale.put("resultInfoJson", str2);
    locale.put("submitted", str3);
    doCallH5("sendHouseEstimateInfo", locale);
  }
  
  protected void e(e parame) {}
  
  protected void f() {}
  
  protected void f(e parame)
  {
    Intent localIntent = new Intent(this.a, YouPinShoppingCartActivity.class);
    String str = parame.getString("uid");
    parame = parame.getString("cityCode");
    u.e("noob", "uid === " + str + "\t cityCode === " + parame);
    localIntent.putExtra("uid", str);
    localIntent.putExtra("cityCode", parame);
    this.a.startActivity(localIntent);
  }
  
  protected void g(e parame)
  {
    parame = new Bundle();
    parame.putString("ServiceInfoId", "2c9084454b7835b0014b7842917e01d7");
    parame.putString("ServiceInfoName", "消杀保洁");
    Intent localIntent = new Intent(this.a, CleanIndexActivity.class);
    localIntent.putExtras(parame);
    this.a.startActivity(localIntent);
  }
  
  protected void h(e parame)
  {
    parame = new Bundle();
    parame.putString("ServiceInfoId", "2c9084454b7835b0014b78422b1e01cb");
    parame.putString("ServiceInfoName", "新居开荒");
    Intent localIntent = new Intent(this.a, CleanIndexActivity.class);
    localIntent.putExtras(parame);
    this.a.startActivity(localIntent);
  }
  
  protected void i(e parame)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      af.showToast(this.a, "请先登录");
      return;
    }
    parame = new Bundle();
    parame.putString("ServiceInfoId", "8a90a28956f928920156f9c0472f000a");
    parame.putString("ServiceInfoName", "民宿保洁");
    Intent localIntent = new Intent(this.a, CleanIndexActivity.class);
    localIntent.putExtras(parame);
    this.a.startActivity(localIntent);
  }
  
  public final void init(Context paramContext, BridgeWebView paramBridgeWebView)
  {
    this.a = paramContext;
    paramBridgeWebView.registerHandler("regiterHanderH5ToApp", new com.freelxl.baselibrary.webview.a()
    {
      public void handler(String paramAnonymousString, d paramAnonymousd)
      {
        if (!TextUtils.isEmpty(paramAnonymousString))
        {
          paramAnonymousString = e.parseObject(paramAnonymousString);
          if ((paramAnonymousString != null) && (paramAnonymousString.containsKey("function"))) {
            a.this.onCallBack(paramAnonymousString.getString("function"), paramAnonymousString.getJSONObject("parameter"));
          }
        }
      }
    });
    this.b = paramBridgeWebView;
  }
  
  protected void j(e parame)
  {
    parame = new Bundle();
    parame.putString("ServiceInfoId", "8a90a5d8580a5cb2015822c397920018");
    parame.putString("ServiceInfoName", "擦玻璃");
    Intent localIntent = new Intent(this.a, CleanIndexActivity.class);
    localIntent.putExtras(parame);
    this.a.startActivity(localIntent);
  }
  
  protected void k(e parame)
  {
    parame = new Bundle();
    parame.putString("ServiceInfoId", "8a90a5d85841edb0015847dd78a80014");
    parame.putString("ServiceInfoName", "专业除螨");
    Intent localIntent = new Intent(this.a, CleanIndexActivity.class);
    localIntent.putExtras(parame);
    this.a.startActivity(localIntent);
  }
  
  protected void l(e parame)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      af.showToast(this.a, "请先登录");
      return;
    }
    parame = new Bundle();
    parame.putInt("type", 0);
    Intent localIntent = new Intent(this.a, RepairOrderActivity.class);
    localIntent.putExtras(parame);
    this.a.startActivity(localIntent);
  }
  
  protected void m(e parame)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      af.showToast(this.a, "请先登录");
      return;
    }
    parame = new Bundle();
    parame.putInt("type", 1);
    Intent localIntent = new Intent(this.a, RepairOrderActivity.class);
    localIntent.putExtras(parame);
    this.a.startActivity(localIntent);
  }
  
  protected void n(e parame)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      af.showToast(this.a, "请先登录");
      return;
    }
    parame = new Bundle();
    parame.putInt("type", 2);
    Intent localIntent = new Intent(this.a, RepairOrderActivity.class);
    localIntent.putExtras(parame);
    this.a.startActivity(localIntent);
  }
  
  protected void o(e parame)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      af.showToast(this.a, "请先登录");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("serviceInfoId", parame.getString("serviceInfoId"));
    localBundle.putString("serviceInfoName", parame.getString("serviceInfoName"));
    parame = new Intent(this.a, RepairOrderNewActivity.class);
    parame.putExtras(localBundle);
    this.a.startActivity(parame);
  }
  
  public final void onCallBack(String paramString, e parame)
  {
    u.d("JsBridgeHelper", "=====funcName:" + paramString);
    if (parame != null) {
      u.d("JsBridgeHelper", "=====params:" + parame.toJSONString());
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        a(paramString, parame);
        return;
        if (paramString.equals("toRentMoreHouseList"))
        {
          i = 0;
          continue;
          if (paramString.equals("toRentHouseDetail"))
          {
            i = 1;
            continue;
            if (paramString.equals("h5UploadImage"))
            {
              i = 2;
              continue;
              if (paramString.equals("toApartmentProjectDetail"))
              {
                i = 3;
                continue;
                if (paramString.equals("hyUploadImg"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("hyUploadStuIdCard"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("share"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("getLoginInfo"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("getHouseEstimateInfo"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("saveHouseEstimateInfo"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("saveHouseEstimateSubmitted"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("yzToOwnerZone"))
                              {
                                i = 11;
                                continue;
                                if (paramString.equals("yzSureContracts"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString.equals("closeAppPage"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString.equals("openPdf"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString.equals("showTitleBar"))
                                      {
                                        i = 15;
                                        continue;
                                        if (paramString.equals("call"))
                                        {
                                          i = 16;
                                          continue;
                                          if (paramString.equals("login"))
                                          {
                                            i = 17;
                                            continue;
                                            if (paramString.equals("toCleanXiaosha"))
                                            {
                                              i = 18;
                                              continue;
                                              if (paramString.equals("toCleanKaihuang"))
                                              {
                                                i = 19;
                                                continue;
                                                if (paramString.equals("toCleanMinsu"))
                                                {
                                                  i = 20;
                                                  continue;
                                                  if (paramString.equals("toCleanCaboli"))
                                                  {
                                                    i = 21;
                                                    continue;
                                                    if (paramString.equals("toCleanChuman"))
                                                    {
                                                      i = 22;
                                                      continue;
                                                      if (paramString.equals("toRepairShuiluguanjian"))
                                                      {
                                                        i = 23;
                                                        continue;
                                                        if (paramString.equals("toRepairDengjudianlu"))
                                                        {
                                                          i = 24;
                                                          continue;
                                                          if (paramString.equals("toRepairKaisuohuansuo"))
                                                          {
                                                            i = 25;
                                                            continue;
                                                            if (paramString.equals("toRepairKongtiaoqingxi"))
                                                            {
                                                              i = 26;
                                                              continue;
                                                              if (paramString.equals("toUpinJiaju"))
                                                              {
                                                                i = 27;
                                                                continue;
                                                                if (paramString.equals("toCardRepair"))
                                                                {
                                                                  i = 28;
                                                                  continue;
                                                                  if (paramString.equals("toCleanRichang"))
                                                                  {
                                                                    i = 29;
                                                                    continue;
                                                                    if (paramString.equals("toCleanShendu"))
                                                                    {
                                                                      i = 30;
                                                                      continue;
                                                                      if (paramString.equals("toMoveXiaoban"))
                                                                      {
                                                                        i = 31;
                                                                        continue;
                                                                        if (paramString.equals("toMoveTruck"))
                                                                        {
                                                                          i = 32;
                                                                          continue;
                                                                          if (paramString.equals("toCardClean"))
                                                                          {
                                                                            i = 33;
                                                                            continue;
                                                                            if (paramString.equals("toMoveList"))
                                                                            {
                                                                              i = 34;
                                                                              continue;
                                                                              if (paramString.equals("toCleanList"))
                                                                              {
                                                                                i = 35;
                                                                                continue;
                                                                                if (paramString.equals("toMinsuHouseDetail"))
                                                                                {
                                                                                  i = 36;
                                                                                  continue;
                                                                                  if (paramString.equals("toStationHouseDetail"))
                                                                                  {
                                                                                    i = 37;
                                                                                    continue;
                                                                                    if (paramString.equals("socialActivityEnroll"))
                                                                                    {
                                                                                      i = 38;
                                                                                      continue;
                                                                                      if (paramString.equals("toSocialActivity"))
                                                                                      {
                                                                                        i = 39;
                                                                                        continue;
                                                                                        if (paramString.equals("toYouPinGoodsDetails"))
                                                                                        {
                                                                                          i = 40;
                                                                                          continue;
                                                                                          if (paramString.equals("toYouPinShoppingCart"))
                                                                                          {
                                                                                            i = 41;
                                                                                            continue;
                                                                                            if (paramString.equals("toPeriodCleanReservation"))
                                                                                            {
                                                                                              i = 42;
                                                                                              continue;
                                                                                              if (paramString.equals("toZiRoomScoreAuthorization"))
                                                                                              {
                                                                                                i = 43;
                                                                                                continue;
                                                                                                if (paramString.equals("toZiRoomScorePromote"))
                                                                                                {
                                                                                                  i = 44;
                                                                                                  continue;
                                                                                                  if (paramString.equals("inviteToActivity"))
                                                                                                  {
                                                                                                    i = 45;
                                                                                                    continue;
                                                                                                    if (paramString.equals("toAccount"))
                                                                                                    {
                                                                                                      i = 46;
                                                                                                      continue;
                                                                                                      if (paramString.equals("getShareData"))
                                                                                                      {
                                                                                                        i = 47;
                                                                                                        continue;
                                                                                                        if (paramString.equals("toMoveBargainActivity"))
                                                                                                        {
                                                                                                          i = 48;
                                                                                                          continue;
                                                                                                          if (paramString.equals("sureWithSubletRuleDescription"))
                                                                                                          {
                                                                                                            i = 49;
                                                                                                            continue;
                                                                                                            if (paramString.equals("sureWithReserveRuleDescription"))
                                                                                                            {
                                                                                                              i = 50;
                                                                                                              continue;
                                                                                                              if (paramString.equals("toMyZiroom"))
                                                                                                              {
                                                                                                                i = 51;
                                                                                                                continue;
                                                                                                                if (paramString.equals("toHouseListYJ5"))
                                                                                                                {
                                                                                                                  i = 52;
                                                                                                                  continue;
                                                                                                                  if (paramString.equals("openH5"))
                                                                                                                  {
                                                                                                                    i = 53;
                                                                                                                    continue;
                                                                                                                    if (paramString.equals("toGiftCardBuyVC"))
                                                                                                                    {
                                                                                                                      i = 54;
                                                                                                                      continue;
                                                                                                                      if (paramString.equals("toZiroomerContractList"))
                                                                                                                      {
                                                                                                                        i = 55;
                                                                                                                        continue;
                                                                                                                        if (paramString.equals("toCleanBedroom"))
                                                                                                                        {
                                                                                                                          i = 56;
                                                                                                                          continue;
                                                                                                                          if (paramString.equals("toZzSocialMySpace"))
                                                                                                                          {
                                                                                                                            i = 57;
                                                                                                                            continue;
                                                                                                                            if (paramString.equals("toPayCenter"))
                                                                                                                            {
                                                                                                                              i = 58;
                                                                                                                              continue;
                                                                                                                              if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeContract.ziroom.com"))
                                                                                                                              {
                                                                                                                                i = 59;
                                                                                                                                continue;
                                                                                                                                if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeDailycleaningOrderList.ziroom.com"))
                                                                                                                                {
                                                                                                                                  i = 60;
                                                                                                                                  continue;
                                                                                                                                  if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeFortnight.ziroom.com"))
                                                                                                                                  {
                                                                                                                                    i = 61;
                                                                                                                                    continue;
                                                                                                                                    if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeDailycleaning.ziroom.com"))
                                                                                                                                    {
                                                                                                                                      i = 62;
                                                                                                                                      continue;
                                                                                                                                      if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeXiaoSha.ziroom.com"))
                                                                                                                                      {
                                                                                                                                        i = 63;
                                                                                                                                        continue;
                                                                                                                                        if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeShendu.ziroom.com"))
                                                                                                                                        {
                                                                                                                                          i = 64;
                                                                                                                                          continue;
                                                                                                                                          if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeKaihuang.ziroom.com"))
                                                                                                                                          {
                                                                                                                                            i = 65;
                                                                                                                                            continue;
                                                                                                                                            if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeHousemoving.ziroom.com"))
                                                                                                                                            {
                                                                                                                                              i = 66;
                                                                                                                                              continue;
                                                                                                                                              if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeHousemovingOrderList.ziroom.com"))
                                                                                                                                              {
                                                                                                                                                i = 67;
                                                                                                                                                continue;
                                                                                                                                                if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeRepair.ziroom.com"))
                                                                                                                                                {
                                                                                                                                                  i = 68;
                                                                                                                                                  continue;
                                                                                                                                                  if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeRepairOrderList.ziroom.com"))
                                                                                                                                                  {
                                                                                                                                                    i = 69;
                                                                                                                                                    continue;
                                                                                                                                                    if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeKuanDai.ziroom.com"))
                                                                                                                                                    {
                                                                                                                                                      i = 70;
                                                                                                                                                      continue;
                                                                                                                                                      if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeHousekeeper.ziroom.com"))
                                                                                                                                                      {
                                                                                                                                                        i = 71;
                                                                                                                                                        continue;
                                                                                                                                                        if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeIintelligentlock.ziroom.com"))
                                                                                                                                                        {
                                                                                                                                                          i = 72;
                                                                                                                                                          continue;
                                                                                                                                                          if (paramString.equals("http://ZRQuestionDetailLinkToUrlTypeSuggestions.ziroom.com"))
                                                                                                                                                          {
                                                                                                                                                            i = 73;
                                                                                                                                                            continue;
                                                                                                                                                            if (paramString.equals("http://zrquestiondetaillinktourltypewallet.ziroom.com"))
                                                                                                                                                            {
                                                                                                                                                              i = 74;
                                                                                                                                                              continue;
                                                                                                                                                              if (paramString.equals("http://zrquestiondetaillinktourltypecredit.ziroom.com"))
                                                                                                                                                              {
                                                                                                                                                                i = 75;
                                                                                                                                                                continue;
                                                                                                                                                                if (paramString.equals("http://zrquestiondetaillinktourltypequalification.ziroom.com"))
                                                                                                                                                                {
                                                                                                                                                                  i = 76;
                                                                                                                                                                  continue;
                                                                                                                                                                  if (paramString.equals("http://zrquestiondetaillinktourltypecontractxueli.ziroom.com"))
                                                                                                                                                                  {
                                                                                                                                                                    i = 77;
                                                                                                                                                                    continue;
                                                                                                                                                                    if (paramString.equals("http://zrquestiondetaillinktourltypeschedule.ziroom.com"))
                                                                                                                                                                    {
                                                                                                                                                                      i = 78;
                                                                                                                                                                      continue;
                                                                                                                                                                      if (paramString.equals("http://zrquestiondetaillinktourltypesearch.ziroom.com"))
                                                                                                                                                                      {
                                                                                                                                                                        i = 79;
                                                                                                                                                                        continue;
                                                                                                                                                                        if (paramString.equals("http://zrquestiondetaillinktourltypeconsignation.ziroom.com"))
                                                                                                                                                                        {
                                                                                                                                                                          i = 80;
                                                                                                                                                                          continue;
                                                                                                                                                                          if (paramString.equals("toAccountManage"))
                                                                                                                                                                          {
                                                                                                                                                                            i = 81;
                                                                                                                                                                            continue;
                                                                                                                                                                            if (paramString.equals("toCredit"))
                                                                                                                                                                            {
                                                                                                                                                                              i = 82;
                                                                                                                                                                              continue;
                                                                                                                                                                              if (paramString.equals("toMyCoupon"))
                                                                                                                                                                              {
                                                                                                                                                                                i = 83;
                                                                                                                                                                                continue;
                                                                                                                                                                                if (paramString.equals("saveImage"))
                                                                                                                                                                                {
                                                                                                                                                                                  i = 84;
                                                                                                                                                                                  continue;
                                                                                                                                                                                  if (paramString.equals("toMinsuLandlordAngel")) {
                                                                                                                                                                                    i = 85;
                                                                                                                                                                                  }
                                                                                                                                                                                }
                                                                                                                                                                              }
                                                                                                                                                                            }
                                                                                                                                                                          }
                                                                                                                                                                        }
                                                                                                                                                                      }
                                                                                                                                                                    }
                                                                                                                                                                  }
                                                                                                                                                                }
                                                                                                                                                              }
                                                                                                                                                            }
                                                                                                                                                          }
                                                                                                                                                        }
                                                                                                                                                      }
                                                                                                                                                    }
                                                                                                                                                  }
                                                                                                                                                }
                                                                                                                                              }
                                                                                                                                            }
                                                                                                                                          }
                                                                                                                                        }
                                                                                                                                      }
                                                                                                                                    }
                                                                                                                                  }
                                                                                                                                }
                                                                                                                              }
                                                                                                                            }
                                                                                                                          }
                                                                                                                        }
                                                                                                                      }
                                                                                                                    }
                                                                                                                  }
                                                                                                                }
                                                                                                              }
                                                                                                            }
                                                                                                          }
                                                                                                        }
                                                                                                      }
                                                                                                    }
                                                                                                  }
                                                                                                }
                                                                                              }
                                                                                            }
                                                                                          }
                                                                                        }
                                                                                      }
                                                                                    }
                                                                                  }
                                                                                }
                                                                              }
                                                                            }
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    x(parame);
    return;
    y(parame);
    return;
    a(parame);
    return;
    z(parame);
    return;
    b(parame);
    return;
    c(parame);
    return;
    w(parame);
    return;
    c();
    return;
    d();
    return;
    B(parame);
    return;
    C(parame);
    return;
    A(parame);
    return;
    D(parame);
    return;
    E(parame);
    return;
    T(parame);
    return;
    e(parame);
    return;
    Q(parame);
    return;
    P(parame);
    return;
    g(parame);
    return;
    h(parame);
    return;
    i(parame);
    return;
    j(parame);
    return;
    k(parame);
    return;
    l(parame);
    return;
    m(parame);
    return;
    n(parame);
    return;
    o(parame);
    return;
    p(parame);
    return;
    q(parame);
    return;
    r(parame);
    return;
    s(parame);
    return;
    t(parame);
    return;
    u(parame);
    return;
    v(parame);
    return;
    R(parame);
    return;
    S(parame);
    return;
    F(parame);
    return;
    G(parame);
    return;
    H(parame);
    return;
    I(parame);
    return;
    O(parame);
    return;
    f(parame);
    return;
    PeriodCleanerSelectActivity.StartPeriodCleanActivity((Activity)this.a);
    return;
    b();
    return;
    k();
    return;
    K(parame);
    return;
    J(parame);
    return;
    d(parame);
    return;
    U(parame);
    return;
    sureWithSubletRuleDescription();
    return;
    sureWithReserveRuleDescription();
    return;
    a();
    f();
    return;
    L(parame);
    return;
    j();
    return;
    com.ziroom.ziroomcustomer.newchat.chatcenter.c.a.ToAotherActivity((Activity)this.a, new com.ziroom.ziroomcustomer.newchat.chatcenter.b.g(1, "ZRQuestionDetailLinkToUrlTypeContract", null, null));
    return;
    toCleanBedroom();
    return;
    toZzSocialMySpace(parame);
    return;
    M(parame);
    return;
    com.ziroom.ziroomcustomer.newchat.chatcenter.c.a.ToAotherActivity((Activity)this.a, new com.ziroom.ziroomcustomer.newchat.chatcenter.b.g(1, paramString, null, null));
    return;
    i();
    return;
    h();
    return;
    g();
    return;
    N(parame);
    return;
    com.ziroom.ziroomcustomer.minsu.f.k.toLandlordAngelActivity(this.a);
  }
  
  protected void p(e parame)
  {
    String str = ad.getOther(this.a, "youpinH5url");
    if (!TextUtils.isEmpty(str))
    {
      parame = new Intent(this.a, YouPinGuidanceH5Activity.class);
      parame.putExtra("youpinH5url", str);
    }
    for (;;)
    {
      if (parame != null) {
        this.a.startActivity(parame);
      }
      return;
      parame = new Intent(this.a, YouPinGuidanceActivity.class);
    }
  }
  
  protected void q(e parame)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      af.showToast(this.a, "请先登录");
      return;
    }
    parame = new Intent(this.a, RepairCardListActivity.class);
    this.a.startActivity(parame);
  }
  
  protected void r(e parame)
  {
    parame = new Intent(this.a, CleanIndexActivity.class);
    parame.putExtra("ServiceInfoId", "2c9084454b7835b0014b7841269101a9");
    parame.putExtra("ServiceInfoName", "日常保洁");
    this.a.startActivity(parame);
  }
  
  protected void s(e parame)
  {
    parame = new Intent(this.a, CleanIndexActivity.class);
    parame.putExtra("ServiceInfoId", "2c9084434b783482014b784188290209");
    parame.putExtra("ServiceInfoName", "深度保洁");
    this.a.startActivity(parame);
  }
  
  public void sendLoginInfo()
  {
    e locale = new e();
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    String str2;
    String str1;
    if (localUserInfo != null)
    {
      str2 = com.ziroom.commonlibrary.login.a.getToken(ApplicationEx.c);
      if (localUserInfo.getUid() == null)
      {
        str1 = "";
        locale.put("uid", str1);
        if (str2 != null) {
          break label102;
        }
        str1 = "";
        label55:
        locale.put("token", str1);
        if (localUserInfo.getPhone() != null) {
          break label107;
        }
        str1 = "";
        label75:
        locale.put("phone", str1);
      }
    }
    for (;;)
    {
      doCallH5("sendLoginInfo", locale);
      return;
      str1 = localUserInfo.getUid();
      break;
      label102:
      str1 = str2;
      break label55;
      label107:
      str1 = localUserInfo.getPhone();
      break label75;
      locale.put("uid", "");
      locale.put("token", "");
      locale.put("phone", "");
    }
  }
  
  public void sendResultOfPaymentToH5(int paramInt, String paramString)
  {
    e locale = new e();
    locale.put("resultType", Integer.valueOf(paramInt));
    locale.put("message", paramString);
    doCallH5("resultOfPaymentToH5", locale);
  }
  
  public void sureWithReserveRuleDescription()
  {
    Intent localIntent = ((Activity)this.a).getIntent();
    HouseDetail localHouseDetail = (HouseDetail)localIntent.getSerializableExtra("detail");
    int i = localIntent.getIntExtra("type", 3);
    new o(this.a).toSign(localHouseDetail, i);
  }
  
  public void sureWithSubletRuleDescription()
  {
    String str = ((Activity)this.a).getIntent().getStringExtra("lease");
    Intent localIntent = new Intent(this.a, LeaseSubletSelectTimeActivity.class);
    localIntent.putExtra("lease", str);
    this.a.startActivity(localIntent);
  }
  
  protected void t(e parame)
  {
    parame = new Intent(this.a, MovingIndexActivity.class);
    parame.putExtra("productCode", "2c9085f248ba3f3a0148bb156f6e0004");
    this.a.startActivity(parame);
  }
  
  public void toCleanBedroom()
  {
    Intent localIntent = new Intent(this.a, CleanIndexActivity.class);
    localIntent.putExtra("ServiceInfoId", "8a90a5d85841edb0015847dd11110000");
    localIntent.putExtra("ServiceInfoName", "卧室保洁");
    this.a.startActivity(localIntent);
  }
  
  public void toZzSocialMySpace(e parame)
  {
    if (parame != null)
    {
      Intent localIntent = new Intent(this.a, ZzSocialMySpaceActivity.class);
      localIntent.putExtra("be_uid", parame.getString("uid"));
      this.a.startActivity(localIntent);
    }
  }
  
  protected void u(e parame)
  {
    parame = new Intent(this.a, MovingIndexActivity.class);
    parame.putExtra("productCode", "8a90a5f8593e65b501593e65b5200000");
    this.a.startActivity(parame);
  }
  
  protected void v(e parame)
  {
    parame = new Intent(this.a, CleanStoredCardBuyActivity.class);
    this.a.startActivity(parame);
  }
  
  protected void w(e parame)
  {
    if (parame != null)
    {
      com.ziroom.commonlibrary.f.a.getInstance().setPaltFormShowFlag(10);
      com.ziroom.commonlibrary.f.a.setLocalIcon(2130839951);
      com.ziroom.commonlibrary.f.a.getInstance().shareFromCenter((FragmentActivity)this.a, parame.getString("linkUrl"), parame.getString("title"), parame.getString("content"), parame.getString("imageUrl"), this.c);
    }
  }
  
  protected void x(e parame)
  {
    if ((parame != null) && (parame.containsKey("children")))
    {
      MoreBean localMoreBean = (MoreBean)com.alibaba.fastjson.a.parseObject(parame.getJSONObject("children").toJSONString(), MoreBean.class);
      Intent localIntent = new Intent(this.a, HouseListActivity.class);
      if (parame.containsKey("keywords"))
      {
        SearchCondition localSearchCondition = new SearchCondition();
        localSearchCondition.setKeywords(parame.getString("keywords"));
        localIntent.putExtra("searchCondition", localSearchCondition);
      }
      localIntent.putExtra("more", localMoreBean);
      if (!(this.a instanceof Activity)) {
        localIntent.setFlags(268435456);
      }
      this.a.startActivity(localIntent);
    }
  }
  
  protected void y(e parame)
  {
    if (parame != null)
    {
      Intent localIntent = new Intent(this.a, RentHouseDetailActivity.class);
      localIntent.putExtra("id", parame.getString("house_code"));
      localIntent.putExtra("house_id", parame.getString("house_id"));
      if (!(this.a instanceof Activity)) {
        localIntent.setFlags(268435456);
      }
      this.a.startActivity(localIntent);
    }
  }
  
  protected void z(e parame)
  {
    u.d("JsBridgeHelper", "======JsBridgeHelper:" + parame.toJSONString());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/webview/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */