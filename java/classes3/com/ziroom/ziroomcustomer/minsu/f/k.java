package com.ziroom.ziroomcustomer.minsu.f;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.LoginActivity;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuApplyActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuAppointmentPhotographerActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuCityListActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuCommonReplyAddActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuCommonReplyListActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuCouponActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuCouponListActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuCustomerDetailsActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuCustomersListActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuEvaCommitActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuEvaSuccessActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuEvaluetionActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuFragmentWrapperActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuHouseDetailActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuHouseListSearchActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuHouseTypeActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuImproveHouseRankActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuInfoActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuLLApplyDetailActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuLLEvaListActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuNpsActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuOnePicActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuPersonActiity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuPriceActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuSearchTabLocationActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuSearchTimesSelectingActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuServicelistActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuSetHouseTodayDiscountActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuSignedActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuTimesSelectingActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuTopHouseDetailActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuWebActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactsListBean.ListUsualContactBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaCommitBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailConfigBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuImReplyCommonBean.DataBean.ListMsgBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchHouseInfoBean;
import com.ziroom.ziroomcustomer.minsu.bean.OrderStatusEnum;
import com.ziroom.ziroomcustomer.minsu.chat.j;
import com.ziroom.ziroomcustomer.minsu.dialog.h;
import com.ziroom.ziroomcustomer.minsu.e.d;
import com.ziroom.ziroomcustomer.minsu.e.e;
import com.ziroom.ziroomcustomer.minsu.home.b.a.b;
import com.ziroom.ziroomcustomer.minsu.homecolumn.MinsuArticleColumnActivity;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.LandlordOrderDetailActivity;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.MinsuLandLordMainNewActivity;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.MinsuLandlordHouseAvtivity;
import com.ziroom.ziroomcustomer.minsu.landlordangel.LandlordAngelActivity;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.HousePriceSettingActivity;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.LandlordReleaseManagerActivity;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.MinsuLLCanlendarActivity;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.MinsuLLDaysEditActivity;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.MinsuReleaseActivity;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLCalendarDayInfoBean;
import com.ziroom.ziroomcustomer.minsu.mapsojourn.MinsuMapFindActivity;
import com.ziroom.ziroomcustomer.minsu.searchlist.BrowsingHistoryActivity;
import com.ziroom.ziroomcustomer.minsu.searchlist.MinsuSearchListActivity;
import com.ziroom.ziroomcustomer.minsu.searchlist.SearchListLocationActivity;
import com.ziroom.ziroomcustomer.minsu.tenant.MinsuLandlordDetailActivty;
import com.ziroom.ziroomcustomer.minsu.webchecklist.WebCheckListActivity;
import com.ziroom.ziroomcustomer.minsu.webchecklist.c.b;
import com.ziroom.ziroomcustomer.my.MyCouponActivity;
import com.ziroom.ziroomcustomer.my.MyZiroomFragment;
import com.ziroom.ziroomcustomer.newchat.l;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity.a;
import com.ziroom.ziroomcustomer.ziroomstation.SearchTimesSelectingActivity;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.InventoryCalendarActivity;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.StationProjectDetailActivity;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class k
{
  public static void CmsToOldWebActivity(Activity paramActivity, a.b paramb)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, MinsuWebActivity.class);
    localIntent.putExtra("url", paramb.getTarget());
    ad.putIntentShare(localIntent, paramb.getDescription());
    localIntent.putExtra("picUrl", paramb.getImg());
    b(paramActivity, localIntent);
  }
  
  public static void CmsToWebActivity(Activity paramActivity, a.b paramb)
  {
    Object localObject = paramb.getDescription();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = ((String)localObject).split("&\\|");
    int i = localObject.length;
    String str1 = a((String[])localObject, i);
    String str2 = b((String[])localObject, i);
    boolean bool = a(c((String[])localObject, i));
    new JsBridgeWebActivity.a(paramActivity, paramb.getTarget()).title(str1).showShare(bool).shareContent(str2).shareImg(paramb.getImg()).backMain(false).mainType(0).starJsBridgeActivity();
  }
  
  public static void CmsToWebActivity(Activity paramActivity, b paramb)
  {
    String str1 = paramb.getTitle();
    String str2 = paramb.getDescription();
    new JsBridgeWebActivity.a(paramActivity, paramb.getTarget()).title(str1).showShare(true).shareContent(str2).shareImg(paramb.getImg()).backMain(false).mainType(0).starJsBridgeActivity();
  }
  
  public static void CmsToWebActivitySimple(Activity paramActivity, a.b paramb)
  {
    String str1 = paramb.getTitle();
    String str2 = paramb.getDescription();
    new JsBridgeWebActivity.a(paramActivity, paramb.getTarget()).title(str1).showShare(true).shareContent(str2).shareImg(paramb.getImg()).backMain(false).mainType(0).starJsBridgeActivity();
  }
  
  private static String a(String[] paramArrayOfString, int paramInt)
  {
    String str = "";
    if (paramInt >= 1) {
      str = paramArrayOfString[0];
    }
    return str;
  }
  
  private static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("tab", paramInt);
    a(paramContext, localBundle);
  }
  
  private static void a(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, MinsuSearchListActivity.class);
    localIntent.putExtras(paramBundle);
    b(paramContext, localIntent);
  }
  
  private static void a(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    paramFragment.startActivityForResult(paramIntent, paramInt);
  }
  
  private static boolean a(String paramString)
  {
    if (ae.notNull(paramString)) {
      paramString = paramString.split("=");
    }
    return (paramString.length < 2) || ((Integer.parseInt(paramString[1]) & 0x1) != 0);
  }
  
  public static void animFinishAlpha(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968586, 2130968680);
  }
  
  public static void animStartAlpha(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130968676, 2130968588);
  }
  
  private static String b(String[] paramArrayOfString, int paramInt)
  {
    String str = "";
    if (paramInt >= 2) {
      str = paramArrayOfString[1];
    }
    return str;
  }
  
  private static void b(Context paramContext, Intent paramIntent)
  {
    paramContext.startActivity(paramIntent);
  }
  
  private static String c(String[] paramArrayOfString, int paramInt)
  {
    String str = "";
    if (paramInt >= 3) {
      str = paramArrayOfString[2];
    }
    return str;
  }
  
  public static void callPhone(final Context paramContext, final String paramString)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130903834, null);
    TextView localTextView = (TextView)localView.findViewById(2131689850);
    Button localButton1 = (Button)localView.findViewById(2131692249);
    Button localButton2 = (Button)localView.findViewById(2131690460);
    AlertDialog localAlertDialog = new AlertDialog.Builder(paramContext, 2131427591).create();
    if (!(localAlertDialog instanceof AlertDialog)) {
      localAlertDialog.show();
    }
    for (;;)
    {
      localAlertDialog.getWindow().setContentView(localView);
      localTextView.setText("确认要拨打" + paramString + "吗?");
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          this.a.dismiss();
          paramString.replace("-", ",");
          paramAnonymousView = new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramString));
          k.a(paramContext, paramAnonymousView);
        }
      });
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          this.a.dismiss();
        }
      });
      return;
      VdsAgent.showDialog((AlertDialog)localAlertDialog);
    }
  }
  
  public static void callService(Context paramContext)
  {
    String str2 = aa.getString(ApplicationEx.c, "telphone", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = com.ziroom.ziroomcustomer.minsu.b.c.b;
    }
    callPhone(paramContext, str1);
  }
  
  public static void contactIM(BaseActivity paramBaseActivity)
  {
    if (!ApplicationEx.c.isImconnect())
    {
      com.ziroom.ziroomcustomer.newchat.a.register(paramBaseActivity);
      if (l.getNetWorkType(paramBaseActivity)) {
        paramBaseActivity.showProgressNoCancel("", 8000L);
      }
      for (;;)
      {
        new Thread()
        {
          public void run()
          {
            super.run();
            try
            {
              if (l.getNetWorkType(this.a)) {
                Thread.sleep(8000L);
              }
              for (;;)
              {
                Intent localIntent = new Intent(this.a, com.ziroom.ziroomcustomer.minsu.activity.MinsuChatActivity.class);
                localIntent.putExtra("chatForm", "minsu");
                k.a(this.a, localIntent);
                return;
                Thread.sleep(18000L);
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                localInterruptedException.printStackTrace();
              }
            }
          }
        }.start();
        return;
        paramBaseActivity.showProgressNoCancel("", 18000L);
      }
    }
    Intent localIntent = new Intent(paramBaseActivity, com.ziroom.ziroomcustomer.minsu.activity.MinsuChatActivity.class);
    localIntent.putExtra("chatForm", "minsu");
    b(paramBaseActivity, localIntent);
  }
  
  public static void cropPic(Activity paramActivity, Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    String str = ad.createFileName();
    Object localObject = new File(com.ziroom.ziroomcustomer.minsu.b.c.e);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("com.android.camera.action.CROP");
    ((Intent)localObject).setDataAndType(paramUri, "image/*");
    ((Intent)localObject).putExtra("crop", "true");
    ((Intent)localObject).putExtra("aspectX", 1);
    ((Intent)localObject).putExtra("aspectY", 1);
    ((Intent)localObject).putExtra("outputX", 240);
    ((Intent)localObject).putExtra("outputY", 240);
    ((Intent)localObject).putExtra("return-data", true);
    ((Intent)localObject).putExtra("scale", true);
    ((Intent)localObject).putExtra("scaleUpIfNeeded", true);
    ((Intent)localObject).putExtra("output", Uri.parse("file:///sdcard/ziroomminsu/" + str));
    a(paramActivity, (Intent)localObject, 202);
  }
  
  public static void cropPic(Fragment paramFragment, Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    String str = ad.createFileName();
    Object localObject = new File(com.ziroom.ziroomcustomer.minsu.b.c.e);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("com.android.camera.action.CROP");
    ((Intent)localObject).setDataAndType(paramUri, "image/*");
    ((Intent)localObject).putExtra("crop", "true");
    ((Intent)localObject).putExtra("aspectX", 1);
    ((Intent)localObject).putExtra("aspectY", 1);
    ((Intent)localObject).putExtra("outputX", 240);
    ((Intent)localObject).putExtra("outputY", 240);
    ((Intent)localObject).putExtra("return-data", true);
    ((Intent)localObject).putExtra("scale", true);
    ((Intent)localObject).putExtra("scaleUpIfNeeded", true);
    ((Intent)localObject).putExtra("output", Uri.parse("file:///sdcard/ziroomminsu/" + str));
    ((Intent)localObject).putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
    a(paramFragment, (Intent)localObject, 202);
  }
  
  public static Uri cropPic2(Activity paramActivity, Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    String str = ad.createFileName();
    Object localObject = new File(com.ziroom.ziroomcustomer.minsu.b.c.e);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("com.android.camera.action.CROP");
    ((Intent)localObject).setDataAndType(paramUri, "image/*");
    ((Intent)localObject).putExtra("crop", "true");
    ((Intent)localObject).putExtra("aspectX", 1);
    ((Intent)localObject).putExtra("aspectY", 1);
    ((Intent)localObject).putExtra("outputX", 240);
    ((Intent)localObject).putExtra("outputY", 240);
    ((Intent)localObject).putExtra("scale", true);
    ((Intent)localObject).putExtra("scaleUpIfNeeded", true);
    paramUri = Uri.parse("file:///sdcard/ziroomminsu/" + str);
    ((Intent)localObject).putExtra("output", paramUri);
    ((Intent)localObject).putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
    a(paramActivity, (Intent)localObject, 202);
    return paramUri;
  }
  
  public static Uri cropPic2(Fragment paramFragment, Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    String str = ad.createFileName();
    Object localObject = new File(com.ziroom.ziroomcustomer.minsu.b.c.e);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("com.android.camera.action.CROP");
    ((Intent)localObject).setDataAndType(paramUri, "image/*");
    ((Intent)localObject).putExtra("crop", "true");
    ((Intent)localObject).putExtra("aspectX", 1);
    ((Intent)localObject).putExtra("aspectY", 1);
    ((Intent)localObject).putExtra("outputX", 240);
    ((Intent)localObject).putExtra("outputY", 240);
    ((Intent)localObject).putExtra("scale", true);
    ((Intent)localObject).putExtra("scaleUpIfNeeded", true);
    paramUri = Uri.parse("file:///sdcard/ziroomminsu/" + str);
    ((Intent)localObject).putExtra("output", paramUri);
    ((Intent)localObject).putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
    a(paramFragment, (Intent)localObject, 202);
    return paramUri;
  }
  
  public static void goBackWeb(Context paramContext, String paramString)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
      return;
    }
    paramString = e.convertUrl(paramString);
    Intent localIntent = new Intent(paramContext, MinsuWebActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("isLoadTitle", false);
    localIntent.putExtra("needBack", true);
    b(paramContext, localIntent);
  }
  
  public static void goLLHouseList(Context paramContext)
  {
    goLLHouseList(paramContext, null);
  }
  
  public static void goLLHouseList(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, MinsuLandlordHouseAvtivity.class);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.addFlags(268435456);
    b(paramContext, localIntent);
  }
  
  public static void goWeb(Context paramContext, String paramString)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
      return;
    }
    paramString = e.convertUrl(paramString);
    Intent localIntent = new Intent(paramContext, MinsuWebActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("isLoadTitle", false);
    b(paramContext, localIntent);
  }
  
  public static void goWeb(Context paramContext, String paramString1, String paramString2)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
      return;
    }
    paramString1 = e.convertUrl(paramString1, paramString2);
    paramString2 = new Intent(paramContext, MinsuWebActivity.class);
    paramString2.putExtra("url", paramString1);
    paramString2.putExtra("isLoadTitle", false);
    b(paramContext, paramString2);
  }
  
  public static void goWeb(Context paramContext, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3)
  {
    goWeb(paramContext, paramString1, paramBoolean1, paramBoolean2, paramString2, paramBoolean3, false);
  }
  
  public static void goWeb(Context paramContext, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((paramBoolean1) && (!ApplicationEx.c.isLoginState()))
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
      return;
    }
    paramString1 = e.convertUrl(paramString1);
    Intent localIntent = new Intent(paramContext, MinsuWebActivity.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("isLoadTitle", paramBoolean2);
    localIntent.putExtra("title", paramString2);
    localIntent.putExtra("needBack", paramBoolean3);
    localIntent.putExtra("isInnerUrl", paramBoolean4);
    b(paramContext, localIntent);
  }
  
  public static void goWebNew(Context paramContext, String paramString)
  {
    JsBridgeWebActivity.start(paramContext, "", paramString);
  }
  
  public static void goWebNoLogin(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, MinsuWebActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("isLoadTitle", false);
    b(paramContext, localIntent);
  }
  
  public static void landlordActivity(Context paramContext)
  {
    landlordActivity(paramContext, null);
  }
  
  public static void landlordActivity(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, MinsuLandLordMainNewActivity.class);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    b(paramContext, localIntent);
    ad.setIsMinsuLandlord(true);
  }
  
  public static void managerHouseRelease(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, LandlordReleaseManagerActivity.class);
    localIntent.putExtra("fid", paramString);
    localIntent.putExtra("rentWay", paramInt);
    a(paramActivity, localIntent, 133);
  }
  
  public static void toAppointmentPhotographer(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, MinsuAppointmentPhotographerActivity.class);
    localIntent.putExtra("houseFid", paramString);
    b(paramActivity, localIntent);
  }
  
  public static void toChatActivity(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, com.ziroom.ziroomcustomer.minsu.activity.MinsuChatActivity.class);
    localIntent.putExtra("toChatUsername", paramString);
    localIntent.putExtra("msgSenderType", paramInt);
    b(paramContext, localIntent);
  }
  
  public static void toChecklist(Activity paramActivity)
  {
    b(paramActivity, new Intent(paramActivity, WebCheckListActivity.class));
  }
  
  public static void toComomReplyList(Activity paramActivity)
  {
    b(paramActivity, new Intent(paramActivity, MinsuCommonReplyListActivity.class));
    animStartAlpha(paramActivity);
  }
  
  public static void toCouponListActivity(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, MyCouponActivity.class);
    if ((paramContext instanceof Activity)) {}
    for (;;)
    {
      b(paramContext, localIntent);
      return;
      localIntent.addFlags(268435456);
    }
  }
  
  public static void toCustomTimeSelectActivityForResult(Activity paramActivity, Date paramDate, Calendar paramCalendar1, Calendar paramCalendar2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.set(5, 1);
    localCalendar1.add(2, 6);
    Intent localIntent = new Intent(paramActivity, SearchTimesSelectingActivity.class);
    localIntent.putExtra("canSelectDate", paramDate);
    localIntent.putExtra("lastDate", localCalendar2);
    localIntent.putExtra("nextDate", localCalendar1);
    if (paramCalendar1 == null)
    {
      paramDate = "";
      localIntent.putExtra("startDate", paramDate);
      if (paramCalendar2 != null) {
        break label131;
      }
    }
    label131:
    for (paramDate = "";; paramDate = m.getFormatDate(paramCalendar2.getTime(), m.b))
    {
      localIntent.putExtra("endDate", paramDate);
      a(paramActivity, localIntent, 113);
      animStartAlpha(paramActivity);
      return;
      paramDate = m.getFormatDate(paramCalendar1.getTime(), m.b);
      break;
    }
  }
  
  public static void toCustomerDetailsActivity(Activity paramActivity, MinsuContactsListBean.ListUsualContactBean paramListUsualContactBean)
  {
    Intent localIntent = new Intent(paramActivity, MinsuCustomerDetailsActivity.class);
    if (paramListUsualContactBean != null) {
      localIntent.putExtra("data", paramListUsualContactBean);
    }
    a(paramActivity, localIntent, 102);
    animStartAlpha(paramActivity);
  }
  
  public static void toCustomerEvaCommitActivity(Activity paramActivity, String paramString, int paramInt)
  {
    toEvaCommitActivity(paramActivity, paramString, paramInt);
  }
  
  public static void toCustomerListPage(Activity paramActivity, int paramInt, ArrayList<MinsuContactsListBean.ListUsualContactBean> paramArrayList)
  {
    Intent localIntent = new Intent(paramActivity, MinsuCustomersListActivity.class);
    localIntent.putExtra("limit", paramInt);
    localIntent.putExtra("data", paramArrayList);
    a(paramActivity, localIntent, 110);
    animStartAlpha(paramActivity);
  }
  
  public static void toEditCommonReply(Activity paramActivity, MinsuImReplyCommonBean.DataBean.ListMsgBean paramListMsgBean)
  {
    Intent localIntent = new Intent(paramActivity, MinsuCommonReplyAddActivity.class);
    localIntent.putExtra("data", paramListMsgBean);
    a(paramActivity, localIntent, 131);
    animStartAlpha(paramActivity);
  }
  
  public static void toEvaActivity(Context paramContext, String paramString, h paramh)
  {
    Intent localIntent = new Intent(paramContext, MinsuEvaluetionActivity.class);
    localIntent.putExtra("orderSn", paramString);
    localIntent.putExtra("userType", paramh);
    b(paramContext, localIntent);
  }
  
  public static void toEvaActivityForResult(Activity paramActivity, int paramInt, String paramString, h paramh)
  {
    Intent localIntent = new Intent(paramActivity, MinsuEvaluetionActivity.class);
    localIntent.putExtra("orderSn", paramString);
    localIntent.putExtra("userType", paramh);
    a(paramActivity, localIntent, paramInt);
  }
  
  public static void toEvaCommitActivity(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, MinsuEvaCommitActivity.class);
    localIntent.putExtra("orderSn", paramString);
    localIntent.putExtra("evaType", paramInt);
    b(paramActivity, localIntent);
    animStartAlpha(paramActivity);
  }
  
  public static void toEvaCommitActivityForResult(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, MinsuEvaCommitActivity.class);
    localIntent.putExtra("orderSn", paramString);
    localIntent.putExtra("evaType", paramInt2);
    a(paramActivity, localIntent, paramInt1);
    animStartAlpha(paramActivity);
  }
  
  public static void toFragmengWraperActivity(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity, MinsuFragmentWrapperActivity.class);
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, 132);
    animStartAlpha(paramActivity);
  }
  
  public static void toFragmengWraperActivity(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, MinsuFragmentWrapperActivity.class);
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramInt);
    animStartAlpha(paramActivity);
  }
  
  public static void toHouseDetail(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((ae.isNull(paramString1)) || (ae.isNull(paramString2))) {
      return;
    }
    if (paramBoolean) {}
    for (Intent localIntent = new Intent(paramContext, MinsuTopHouseDetailActivity.class);; localIntent = new Intent(paramContext, MinsuHouseDetailActivity.class))
    {
      localIntent.putExtra("fid", paramString1);
      localIntent.putExtra("rentWay", Integer.parseInt(paramString2));
      b(paramContext, localIntent);
      return;
    }
  }
  
  public static void toHouseDetail(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if ((ae.isNull(paramString1)) || (ae.isNull(paramString2))) {
      return;
    }
    if (paramBoolean) {}
    for (Intent localIntent = new Intent(paramContext, MinsuTopHouseDetailActivity.class);; localIntent = new Intent(paramContext, MinsuHouseDetailActivity.class))
    {
      localIntent.putExtra("fid", paramString1);
      localIntent.putExtra("from", paramString3);
      localIntent.putExtra("rentWay", Integer.parseInt(paramString2));
      b(paramContext, localIntent);
      return;
    }
  }
  
  public static void toHouseRelease(Activity paramActivity)
  {
    toHouseRelease(paramActivity, null, null, -1, 0);
  }
  
  public static void toHouseRelease(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    toHouseRelease(paramActivity, paramString1, paramString2, paramInt1, paramInt2, null);
  }
  
  public static void toHouseRelease(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    toHouseRelease(paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramString3, -1, 0);
  }
  
  public static void toHouseRelease(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent(paramActivity, MinsuReleaseActivity.class);
    localIntent.putExtra("from", paramString3);
    if ((paramInt2 > 0) && (paramInt2 < 7))
    {
      localIntent.putExtra("step", paramInt2);
      localIntent.putExtra("houseBaseFid", paramString1);
      localIntent.putExtra("roomFid", paramString2);
      localIntent.putExtra("rentWay", paramInt1);
      localIntent.putExtra("roomType", paramInt4);
    }
    a(paramActivity, localIntent, paramInt3);
  }
  
  public static void toImPage(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    if (!com.ziroom.commonlibrary.login.a.getLoginState(paramActivity))
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramActivity);
      return;
    }
    if ((ae.notNull(paramString1)) && (paramString1.equals(d.getUid())))
    {
      paramActivity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          g.textToast(this.a, this.a.getString(2131296555));
        }
      });
      return;
    }
    Intent localIntent = new Intent(paramActivity, com.ziroom.ziroomcustomer.minsu.chat.MinsuChatActivity.class);
    localIntent.putExtra("userId", j.appendEMPrefix(paramString1));
    localIntent.putExtra("fid", paramString2);
    localIntent.putExtra("rentWay", paramInt1);
    localIntent.putExtra("msgSenderType", paramInt2);
    if ((MinsuSignedActivity.class.getSimpleName().equals(paramString3)) || (MyZiroomFragment.class.getSimpleName().equals(paramString3))) {
      localIntent.putExtra("from", "MinsuOrderSigned");
    }
    for (;;)
    {
      b(paramActivity, localIntent);
      return;
      localIntent.putExtra("from", paramString3);
    }
  }
  
  public static void toImPage(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt2, String paramString12, String paramString13)
  {
    if (!com.ziroom.commonlibrary.login.a.getLoginState(paramContext))
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
      return;
    }
    if ((ae.notNull(paramString1)) && (paramString1.equals(d.getUid())))
    {
      g.textToast(paramContext, paramContext.getString(2131296555));
      return;
    }
    Intent localIntent = new Intent(paramContext, com.ziroom.ziroomcustomer.minsu.chat.MinsuChatActivity.class);
    localIntent.putExtra("userId", j.appendEMPrefix(paramString1));
    localIntent.putExtra("fid", paramString2);
    localIntent.putExtra("isTop50Online", paramString3);
    localIntent.putExtra("rentWay", paramInt1);
    localIntent.putExtra("rentWayName", paramString4);
    localIntent.putExtra("housePicUrl", paramString5);
    localIntent.putExtra("msgSenderType", paramInt2);
    localIntent.putExtra("houseName", paramString6);
    localIntent.putExtra("lName", paramString7);
    localIntent.putExtra("from", paramString12);
    localIntent.putExtra("startDate", paramString8);
    localIntent.putExtra("endDate", paramString9);
    localIntent.putExtra("personNum", paramString10);
    localIntent.putExtra("purpose", paramString11);
    localIntent.putExtra("action", paramString13);
    b(paramContext, localIntent);
  }
  
  public static void toInventoryCalendarActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent(paramActivity, InventoryCalendarActivity.class);
    localIntent.putExtra("originalStartDate", paramString1);
    localIntent.putExtra("endDate", paramString2);
    localIntent.putExtra("houseTypeBid", paramString3);
    localIntent.putExtra("houseName", paramString4);
    b(paramActivity, localIntent);
    animStartAlpha(paramActivity);
  }
  
  public static void toLLApplyDetail(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent = new Intent(paramActivity, MinsuLLApplyDetailActivity.class);
    localIntent.putExtra("fid", paramString1);
    localIntent.putExtra("rentWay", paramInt);
    localIntent.putExtra("startTime", paramString2);
    localIntent.putExtra("endTime", paramString3);
    localIntent.putExtra("houseName", paramString4);
    localIntent.putExtra("person", paramString5);
    b(paramActivity, localIntent);
    animStartAlpha(paramActivity);
  }
  
  public static void toLLCalendarDaysEdit(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, ArrayList<String> paramArrayList, HashMap<String, LLCalendarDayInfoBean> paramHashMap, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, MinsuLLDaysEditActivity.class);
    localIntent.putExtra("houseName", paramString1);
    localIntent.putExtra("houseBaseFid", paramString2);
    localIntent.putExtra("houseRoomFid", paramString3);
    localIntent.putExtra("bedFid", paramString4);
    localIntent.putExtra("rentWay", paramInt1);
    localIntent.putExtra("selectDatesStr", paramArrayList);
    localIntent.putExtra("selectData", paramHashMap);
    a(paramActivity, localIntent, paramInt2);
    animStartAlpha(paramActivity);
  }
  
  public static void toLLEvaListActivity(Activity paramActivity)
  {
    b(paramActivity, new Intent(paramActivity, MinsuLLEvaListActivity.class));
  }
  
  public static void toLLOrderDetail(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, LandlordOrderDetailActivity.class);
    localIntent.putExtra("orderSn", paramString);
    b(paramActivity, localIntent);
  }
  
  public static void toLandlordAngelActivity(Context paramContext)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(paramContext);
      return;
    }
    b(paramContext, new Intent(paramContext, LandlordAngelActivity.class));
  }
  
  public static void toLandlordDetailActivty(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, MinsuLandlordDetailActivty.class);
    localIntent.putExtra("uid", paramString);
    b(paramContext, localIntent);
  }
  
  public static void toLandlordStoryList(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, MinsuArticleColumnActivity.class);
    localIntent.putExtra("type", 2);
    b(paramActivity, localIntent);
    animStartAlpha(paramActivity);
  }
  
  public static void toLocationInfo(Activity paramActivity)
  {
    a(paramActivity, new Intent(paramActivity, SearchListLocationActivity.class), 134);
    animStartAlpha(paramActivity);
  }
  
  public static void toLoginActivity(Context paramContext)
  {
    b(paramContext, new Intent(paramContext, LoginActivity.class));
  }
  
  public static void toMainActivity(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, MainActivity.class);
    localIntent.putExtra("FRAGMENT_TYPE", 2);
    b(paramActivity, localIntent);
    paramActivity.finish();
    ad.setIsMinsuLandlord(false);
  }
  
  public static void toMinsuApplyActivity(Activity paramActivity, OrderStatusEnum paramOrderStatusEnum, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Intent localIntent = new Intent(paramActivity, MinsuApplyActivity.class);
    localIntent.putExtra("status", paramOrderStatusEnum);
    localIntent.putExtra("fid", paramString1);
    localIntent.putExtra("houseName", paramString2);
    localIntent.putExtra("rentWay", paramInt);
    localIntent.putExtra("startTime", paramString3);
    localIntent.putExtra("endTime", paramString4);
    localIntent.putExtra("lName", paramString5);
    if (ae.notNull(paramString6)) {
      localIntent.putExtra("tripPurpose", paramString6);
    }
    b(paramActivity, localIntent);
  }
  
  public static void toMinsuCityListActivityForResult(Activity paramActivity)
  {
    toMinsuCityListActivityForResult(paramActivity, null);
  }
  
  public static void toMinsuCityListActivityForResult(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, MinsuCityListActivity.class);
    localIntent.putExtra("from", paramString);
    a(paramActivity, localIntent, 111);
    animStartAlpha(paramActivity);
  }
  
  public static void toMinsuCouponActivity(Activity paramActivity, Intent paramIntent)
  {
    paramIntent.setClass(paramActivity, MinsuCouponActivity.class);
    b(paramActivity, paramIntent);
    animStartAlpha(paramActivity);
  }
  
  public static void toMinsuCouponListActivity(Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramActivity, MinsuCouponListActivity.class);
    localIntent.putExtra("fid", paramString1);
    localIntent.putExtra("rentWay", paramInt);
    localIntent.putExtra("startTime", paramString2);
    localIntent.putExtra("endTime", paramString3);
    a(paramActivity, localIntent, 116);
    animStartAlpha(paramActivity);
  }
  
  public static void toMinsuCouponListActivity(Context paramContext)
  {
    b(paramContext, new Intent(paramContext, MinsuCouponListActivity.class));
  }
  
  public static void toMinsuEvaSuccessPage(Activity paramActivity, h paramh, MinsuEvaCommitBean paramMinsuEvaCommitBean)
  {
    Intent localIntent = new Intent(paramActivity, MinsuEvaSuccessActivity.class);
    localIntent.putExtra("userType", paramh);
    localIntent.putExtra("shareInfo", paramMinsuEvaCommitBean);
    b(paramActivity, localIntent);
    animStartAlpha(paramActivity);
  }
  
  public static void toMinsuHistory(Activity paramActivity)
  {
    b(paramActivity, new Intent(paramActivity, BrowsingHistoryActivity.class));
    animStartAlpha(paramActivity);
  }
  
  public static void toMinsuHouseListSearch(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, MinsuHouseListSearchActivity.class);
    localIntent.putExtra("key", com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getKeyword());
    localIntent.putExtra("cityCode", com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getCityCode());
    a(paramActivity, localIntent, 120);
  }
  
  public static void toMinsuHouseTypeActivityForResult(Activity paramActivity)
  {
    a(paramActivity, new Intent(paramActivity, MinsuHouseTypeActivity.class), 126);
    animStartAlpha(paramActivity);
  }
  
  public static void toMinsuImproveHouseRankActivity(Context paramContext)
  {
    b(paramContext, new Intent(paramContext, MinsuImproveHouseRankActivity.class));
  }
  
  public static void toMinsuInfoActivity(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, MinsuInfoActivity.class);
    localIntent.putExtra("code", paramInt1);
    localIntent.putExtra("rentWay", paramInt2);
    localIntent.putExtra("fid", paramString);
    localIntent.putExtra("isExitAnim", true);
    b(paramActivity, localIntent);
    animStartAlpha(paramActivity);
  }
  
  public static void toMinsuInfoActivity1(Activity paramActivity, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent(paramActivity, MinsuInfoActivity.class);
    localIntent.putExtra("code", paramInt1);
    localIntent.putExtra("rentWay", paramInt2);
    localIntent.putExtra("fid", paramString);
    localIntent.putExtra("special", paramInt3);
    localIntent.putExtra("isExitAnim", true);
    a(paramActivity, localIntent, paramInt4);
    animStartAlpha(paramActivity);
  }
  
  public static void toMinsuInfoActivity1(Activity paramActivity, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, String paramString3, int paramInt4)
  {
    Intent localIntent = new Intent(paramActivity, MinsuInfoActivity.class);
    localIntent.putExtra("code", paramInt1);
    localIntent.putExtra("houseBaseFid", paramString1);
    localIntent.putExtra("rentWay", paramInt2);
    localIntent.putExtra("fid", paramString2);
    localIntent.putExtra("special", paramInt3);
    localIntent.putExtra("isExitAnim", true);
    localIntent.putExtra("customConfirmText", paramString3);
    a(paramActivity, localIntent, paramInt4);
    animStartAlpha(paramActivity);
  }
  
  public static void toMinsuLLHouseCalendar(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    Intent localIntent = new Intent(paramActivity, MinsuLLCanlendarActivity.class);
    localIntent.putExtra("houseBaseFid", paramString1);
    localIntent.putExtra("houseRoomFid", paramString2);
    localIntent.putExtra("bedFid", paramString3);
    localIntent.putExtra("rentWay", paramInt);
    localIntent.putExtra("houseName", paramString4);
    b(paramActivity, localIntent);
  }
  
  public static void toMinsuMap(Activity paramActivity)
  {
    b(paramActivity, new Intent(paramActivity, MinsuMapFindActivity.class));
  }
  
  public static void toMinsuPersonActivityForResult(Activity paramActivity, Integer paramInteger)
  {
    toMinsuPersonActivityForResult(paramActivity, paramInteger, null);
  }
  
  public static void toMinsuPersonActivityForResult(Activity paramActivity, Integer paramInteger, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, MinsuPersonActiity.class);
    if ((paramInteger == null) || (paramInteger.intValue() <= 0)) {}
    for (int i = 1;; i = paramInteger.intValue())
    {
      localIntent.putExtra("personNum", i);
      localIntent.putExtra("from", paramString);
      a(paramActivity, localIntent, 125);
      animStartAlpha(paramActivity);
      return;
    }
  }
  
  public static void toMinsuPriceActivityForResult(Activity paramActivity)
  {
    a(paramActivity, new Intent(paramActivity, MinsuPriceActivity.class), 124);
    animStartAlpha(paramActivity);
  }
  
  public static void toMinsuSearchList(Context paramContext)
  {
    a(paramContext, 0);
  }
  
  public static void toMinsuSearchTabActivity(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, MinsuSearchTabLocationActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt);
    localIntent.putExtras(localBundle);
    a(paramActivity, localIntent, 123);
    animStartAlpha(paramActivity);
  }
  
  public static void toMinsuSearchTabActivity(Activity paramActivity, int paramInt, MinsuSearchHouseInfoBean paramMinsuSearchHouseInfoBean, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity, MinsuSearchTabLocationActivity.class);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("index", paramInt);
    localBundle.putSerializable("search", paramMinsuSearchHouseInfoBean);
    localIntent.putExtras(localBundle);
    a(paramActivity, localIntent, 123);
    animStartAlpha(paramActivity);
  }
  
  public static void toMinsuServiceListActivity(Activity paramActivity, List<MinsuHouseDetailConfigBean> paramList)
  {
    Intent localIntent = new Intent(paramActivity, MinsuServicelistActivity.class);
    localIntent.putExtra("houseConfigs", (Serializable)paramList);
    b(paramActivity, localIntent);
    animStartAlpha(paramActivity);
  }
  
  public static void toMinsuSetHouseTodayDiscountActivity(Activity paramActivity, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, MinsuSetHouseTodayDiscountActivity.class);
    localIntent.putExtra("houseFid", paramString1);
    localIntent.putExtra("rentWay", paramInt1);
    localIntent.putExtra("roomFid", paramString2);
    localIntent.putExtra("setHintUrl", paramString3);
    localIntent.putExtra("saveHint", paramString4);
    a(paramActivity, localIntent, paramInt2);
    animStartAlpha(paramActivity);
  }
  
  public static void toMinsuTimeSelectActivityForResult(Activity paramActivity, Calendar paramCalendar1, Calendar paramCalendar2)
  {
    toMinsuTimeSelectActivityForResult(paramActivity, paramCalendar1, paramCalendar2, null);
  }
  
  public static void toMinsuTimeSelectActivityForResult(Activity paramActivity, Calendar paramCalendar1, Calendar paramCalendar2, String paramString)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.set(5, 1);
    localCalendar1.add(2, 6);
    Intent localIntent = new Intent(paramActivity, MinsuSearchTimesSelectingActivity.class);
    localIntent.putExtra("from", paramString);
    localIntent.putExtra("lastDate", localCalendar2);
    localIntent.putExtra("nextDate", localCalendar1);
    if (paramCalendar1 == null)
    {
      paramCalendar1 = "";
      localIntent.putExtra("startDate", paramCalendar1);
      if (paramCalendar2 != null) {
        break label131;
      }
    }
    label131:
    for (paramCalendar1 = "";; paramCalendar1 = m.getFormatDate(paramCalendar2.getTime(), m.b))
    {
      localIntent.putExtra("endDate", paramCalendar1);
      a(paramActivity, localIntent, 113);
      animStartAlpha(paramActivity);
      return;
      paramCalendar1 = m.getFormatDate(paramCalendar1.getTime(), m.b);
      break;
    }
  }
  
  public static void toMinsuTimeSelectingActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    toMinsuTimeSelectingActivity(paramActivity, paramString1, paramString2, paramString3, paramInt1, paramInt2, false);
  }
  
  public static void toMinsuTimeSelectingActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, MinsuTimesSelectingActivity.class);
    localIntent.putExtra("startDate", paramString1);
    localIntent.putExtra("endDate", paramString2);
    localIntent.putExtra("fid", paramString3);
    localIntent.putExtra("rentWay", paramInt1);
    localIntent.putExtra("minDay", paramInt2);
    localIntent.putExtra("isToNext", paramBoolean);
    a(paramActivity, localIntent, 113);
    animStartAlpha(paramActivity);
  }
  
  public static void toNps(Activity paramActivity, String paramString1, h paramh, MinsuEvaCommitBean paramMinsuEvaCommitBean, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, MinsuNpsActivity.class);
    localIntent.putExtra("orderSn", paramString1);
    localIntent.putExtra("userType", paramh);
    localIntent.putExtra("shareInfo", paramMinsuEvaCommitBean);
    localIntent.putExtra("tips", paramString2);
    b(paramActivity, localIntent);
    animStartAlpha(paramActivity);
  }
  
  public static void toOnePic(Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, MinsuOnePicActivity.class);
    localIntent.putExtra("url1", paramString1);
    localIntent.putExtra("url2", paramString2);
    b(paramActivity, localIntent);
    animStartAlpha(paramActivity);
  }
  
  public static void toRefreshHeartList(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, MinsuArticleColumnActivity.class);
    localIntent.putExtra("type", 1);
    b(paramActivity, localIntent);
    animStartAlpha(paramActivity);
  }
  
  public static void toReleaseManager(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, LandlordReleaseManagerActivity.class);
    localIntent.putExtra("houseBaseFid", paramString1);
    localIntent.putExtra("roomFid", paramString2);
    localIntent.putExtra("rentWay", paramInt1);
    localIntent.putExtra("roomType", paramInt2);
    b(paramContext, localIntent);
  }
  
  public static void toSetPrice(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Intent localIntent = new Intent(paramActivity, HousePriceSettingActivity.class);
    localIntent.putExtra("houseBaseFid", paramString1);
    localIntent.putExtra("roomFid", paramString2);
    localIntent.putExtra("rentWay", paramInt);
    localIntent.putExtra("from", paramString3);
    b(paramActivity, localIntent);
  }
  
  public static void toSetPrice2(Activity paramActivity, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, HousePriceSettingActivity.class);
    localIntent.putExtra("houseBaseFid", paramString1);
    localIntent.putExtra("roomFid", paramString2);
    localIntent.putExtra("rentWay", paramInt1);
    localIntent.putExtra("from", paramString3);
    a(paramActivity, localIntent, paramInt2);
  }
  
  public static void toStationProject(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Intent localIntent = new Intent(paramContext, StationProjectDetailActivity.class);
      localIntent.putExtra("projectBid", paramString);
      b(paramContext, localIntent);
    }
  }
  
  public static void toStationProjectApp(Context paramContext, String paramString1, Calendar paramCalendar1, Calendar paramCalendar2, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Intent localIntent = new Intent(paramContext, StationProjectDetailActivity.class);
      localIntent.putExtra("projectBid", paramString1);
      localIntent.putExtra("dateStart", paramCalendar1);
      localIntent.putExtra("dateEnd", paramCalendar2);
      localIntent.putExtra("startDate", paramString2);
      localIntent.putExtra("endDate", paramString3);
      b(paramContext, localIntent);
    }
  }
  
  public static void toStationSearchList(Context paramContext)
  {
    a(paramContext, 1);
  }
  
  public static void toStrategySearchList(Context paramContext)
  {
    a(paramContext, 2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */