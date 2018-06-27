package com.ziroom.ziroomcustomer.minsu.view.c;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.login.LoginActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuAddPicturesActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuApplyActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuHouseDetailActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuWebActivity;
import com.ziroom.ziroomcustomer.minsu.bean.OrderStatusEnum;
import com.ziroom.ziroomcustomer.minsu.dialog.i;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.LandlordOrderDetailActivity;
import com.ziroom.ziroomcustomer.util.ae;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private Activity a;
  private int b = -1;
  private WebView c;
  private i d;
  private List<String> e;
  
  public a(Activity paramActivity, WebView paramWebView, int paramInt)
  {
    this.a = paramActivity;
    this.b = paramInt;
    this.c = paramWebView;
  }
  
  private void a(String paramString, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.uploadUserPic(this.a, paramString, new a.2(this), paramInt);
  }
  
  @JavascriptInterface
  public void callPhone(String paramString)
  {
    k.callPhone(this.a, paramString);
  }
  
  @JavascriptInterface
  public void contactIM()
  {
    k.contactIM((BaseActivity)this.a);
  }
  
  @JavascriptInterface
  public void jsCallWebView(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("fid");
      int i = ((JSONObject)localObject).getInt("rentWay");
      ((JSONObject)localObject).getString("method");
      d.d("lanzhihong", "fid=====" + paramString);
      d.d("lanzhihong", "rentWay====" + i);
      localObject = new Intent(this.a, MinsuHouseDetailActivity.class);
      ((Intent)localObject).putExtra("fid", paramString);
      ((Intent)localObject).putExtra("rentWay", i);
      ((Intent)localObject).putExtra("tag", this.b);
      this.a.startActivity((Intent)localObject);
      v.onClick(this.a, "M-zhuanti_house");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onActivityResult(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = null;
      Bundle localBundle;
      if ((paramInt == 2) || (paramInt == 202))
      {
        localBundle = paramIntent.getExtras();
        if (localBundle != null) {
          str = ad.savePic((Bitmap)localBundle.get("data"));
        }
      }
      for (;;)
      {
        if ((paramInt == 1) || (paramInt == 2) || (paramInt == 202))
        {
          if (!new File(str).exists()) {
            break;
          }
          a(str, com.ziroom.ziroomcustomer.minsu.b.c.c.intValue());
        }
        return;
        if ((localBundle == null) && (paramIntent != null))
        {
          paramIntent = paramIntent.getData();
          str = ad.getRealFilePath2(this.a, paramIntent);
        }
        else
        {
          g.textToast(this.a, "无法保存");
          continue;
          if (paramInt == 1)
          {
            paramIntent = paramIntent.getData();
            str = ad.getRealFilePath2(this.a, paramIntent);
          }
          else if (paramInt == 204)
          {
            str = ad.savePic((Bitmap)paramIntent.getExtras().get("data"));
            k.cropPic(this.a, Uri.parse("file://" + str));
          }
          else if (paramInt == 203)
          {
            paramIntent = paramIntent.getData();
            str = ad.getRealFilePath2(this.a, paramIntent);
            k.cropPic(this.a, paramIntent);
          }
        }
      }
      ((MinsuWebActivity)this.a).dismissProgress();
      g.textToast(this.a, "图片获取失败");
      return;
    }
    ((MinsuWebActivity)this.a).dismissProgress();
  }
  
  @JavascriptInterface
  public void popToParent()
  {
    if (this.a != null) {
      this.a.finish();
    }
  }
  
  @JavascriptInterface
  public void setHouseDefaultPic(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.a, MinsuAddPicturesActivity.class);
    localIntent.putExtra("houseBaseFid", paramString1);
    localIntent.putExtra("houseRoomFid", paramString2);
    localIntent.putExtra("type", 1);
    this.a.startActivityForResult(localIntent, 114);
  }
  
  @JavascriptInterface
  public void share(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    com.ziroom.commonlibrary.f.a.getInstance().shareFromCenter((FragmentActivity)this.a, paramString1, paramString2, paramString3, paramString4);
  }
  
  @JavascriptInterface
  public void toCreateOrderPage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Intent localIntent = new Intent(this.a, MinsuApplyActivity.class);
    localIntent.putExtra("fid", paramString1);
    localIntent.putExtra("rentWay", Integer.parseInt(paramString2));
    localIntent.putExtra("status", OrderStatusEnum.YD);
    if ((ae.notNull(paramString3)) && (!"error".equals(paramString3))) {
      localIntent.putExtra("startTime", paramString3);
    }
    if ((ae.notNull(paramString4)) && (!"error".equals(paramString4))) {
      localIntent.putExtra("endTime", paramString4);
    }
    if ((ae.notNull(paramString5)) && (!"error".equals(paramString5))) {
      localIntent.putExtra("lName", paramString5);
    }
    if ((ae.notNull(paramString6)) && (!"error".equals(paramString6))) {
      localIntent.putExtra("tripPurpose", paramString6);
    }
    this.a.startActivity(localIntent);
  }
  
  @JavascriptInterface
  public void toCustomerIm(String paramString1, String paramString2, int paramInt)
  {
    k.toImPage(this.a, paramString1, paramString2, paramInt, 1, "MJavascriptInterface");
  }
  
  @JavascriptInterface
  public void toHouseDetail(String paramString1, String paramString2)
  {
    k.toHouseDetail(this.a, paramString1, paramString2, false);
  }
  
  @JavascriptInterface
  public void toLandlord()
  {
    k.landlordActivity(this.a);
  }
  
  @JavascriptInterface
  public void toLandlordDetail(String paramString)
  {
    k.toLandlordDetailActivty(this.a, paramString);
  }
  
  @JavascriptInterface
  public void toLandlordOrderDetail(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("orderSn", paramString);
    localIntent.setClass(this.a, LandlordOrderDetailActivity.class);
    this.a.startActivity(localIntent);
  }
  
  @JavascriptInterface
  public void toLoginPage()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.a, LoginActivity.class);
    this.a.startActivityForResult(localIntent, 121);
  }
  
  @JavascriptInterface
  public void uploadHousePic(String paramString1, String paramString2, String paramString3)
  {
    d.d("lanzhihong", "uploadHousePic");
  }
  
  @JavascriptInterface
  public void uploadHousePicNew(String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  @JavascriptInterface
  public void uploadHousePicV3(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(this.a, MinsuAddPicturesActivity.class);
    localIntent.putExtra("houseBaseFid", paramString1);
    localIntent.putExtra("houseRoomFid", paramString2);
    localIntent.putExtra("picType", paramString3);
    localIntent.putExtra("houseStatus", paramInt1);
    localIntent.putExtra("type", 0);
    localIntent.putExtra("picMaxNum", paramInt2);
    this.a.startActivityForResult(localIntent, 114);
  }
  
  @JavascriptInterface
  public void uploadUserPic(int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.b.c.c = Integer.valueOf(paramInt);
    this.a.runOnUiThread(new a.1(this, paramInt));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */