package com.ziroom.ziroomcustomer.minsu.e;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.freelxl.baselibrary.d.b.b;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.g;
import com.hyphenate.chat.EMClient;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.minsu.bean.ContactVosBean;
import com.ziroom.ziroomcustomer.minsu.bean.LeaseCalendarBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinSuUserSmartLock;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCheckCardBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCityBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCmsBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactsSaveResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactsUpdateResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponInfoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCreateOrderBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCustomerBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuDelHousePicBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationDetailBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuFindBookerContactsBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseIsCollectResutBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHousePicBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHousePicListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLandlordEvaBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLockNumBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNeedPayBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNeedPayV4Bean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNewNeedPayBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderCancleBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderDetailBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuPayVo;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchConditionBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchSortBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuUPPayBean;
import com.ziroom.ziroomcustomer.minsu.bean.UnReadMsgNumBean;
import com.ziroom.ziroomcustomer.minsu.chat.j;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.m;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveHouseRoomListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.UploadResultBean;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import okhttp3.Callback;

public class a
{
  public static void BrowsingHistory(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("par", paramString);
    paramString = ad.ConvertObjMap2String(localHashMap);
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/searchInit/list", paramString, false, parama);
  }
  
  public static void HomeServer(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    d.requestNoDES2(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/firstPageQuery/fillFirstPageInfo", new HashMap(), parama);
  }
  
  public static void HomeTop50HosueList(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/search/top50HouseListArticles", localHashMap, false, parama);
  }
  
  public static void MinsuLandlordData(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    d.requestNoDES2(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.k, "/firstPageService/ea61d2/fillFirstPageInfo", new HashMap(), parama);
  }
  
  public static void TodaySpecialList(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.requestNoDES2(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/search/todayDiscountArticles", localHashMap, parama);
  }
  
  private static void a(Activity paramActivity, Integer paramInteger, String paramString1, String paramString2, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString2);
    localHashMap.put("evaUserType", Integer.valueOf(paramInt));
    localHashMap.put("content", paramString1);
    localHashMap.put("landlordSatisfied", paramInteger);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/landlordEva/ea61d2/saveEvaOrReply", localHashMap, parama);
  }
  
  public static void achieveCoupon(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actSn", paramString);
    localHashMap.put("uid", d.getUid());
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseDetailCoupon/ea61d2/achieveCoupon", localHashMap, false, parama);
  }
  
  public static void addCommonReply(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", d.getUid());
    localHashMap.put("msgType", "2");
    localHashMap.put("content", paramString);
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.h, "/imReply/43e881/addCustomization", localHashMap, true, parama);
  }
  
  public static void appointmentPhotographer(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, s params)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("landlordUid", paramString1);
    localHashMap.put("houseFid", paramString2);
    localHashMap.put("startTimeStr", paramString3);
    localHashMap.put("bookOrderRemark", paramString4);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseMgt/ea61d2/bookPhoto", localHashMap, true, params);
  }
  
  public static void cancelCollectHouse(Activity paramActivity, String paramString, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseFid", paramString);
    localHashMap.put("rentWay", String.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customerColl/ea61d2/unCollectHouse", localHashMap, parama);
  }
  
  public static void cancelRelease(Activity paramActivity, String paramString1, String paramString2, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("landlordUid", d.getUid());
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseMgt/ea61d2/cancleHouse", localHashMap, parama);
  }
  
  public static void checkBackInfoLL(Activity paramActivity, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/checkInfo", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void checkCard(Activity paramActivity, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customer/ea61d2/checkCard", localHashMap, true, MinsuCheckCardBean.class, parama);
  }
  
  public static void checkCoupon(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("couponSn", paramString1);
    localHashMap.put("fid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("startTime", paramString3);
    localHashMap.put("endTime", paramString4);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/checkCoupon", localHashMap, true, MinsuCouponInfoBean.class, parama);
  }
  
  public static void checkImgCode(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("imgId", paramString2);
    localHashMap.put("areaCode", paramString1);
    localHashMap.put("imgCode", paramString3);
    localHashMap.put("phone", paramString4);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/checkImgCode", localHashMap, true, parama);
  }
  
  public static void checkOutOrder(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/checkOutOrder", localHashMap, MinsuBaseJson.class, parama);
  }
  
  public static void checkOutOrderMsg(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/checkOutOrderMsg", localHashMap, MinsuOrderCancleBean.class, parama);
  }
  
  public static void checkRemarkCount(Activity paramActivity, String paramString, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString);
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderLan/ea61d2/checkRemarkCount", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void cityList(Activity paramActivity, boolean paramBoolean, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/base/ee5f86/cityList", localHashMap, paramBoolean, MinsuCityBean.class, parama);
  }
  
  public static void cityListHot(Activity paramActivity, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/base/ee5f86/cityListHot", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void collHouseList(Activity paramActivity, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customerColl/ea61d2/collHouseList", localHashMap, MinsuHouseCollectBean.class, parama);
  }
  
  public static void collectHouse(Activity paramActivity, String paramString, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseFid", paramString);
    localHashMap.put("rentWay", String.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customerColl/ea61d2/collectHouse", localHashMap, true, parama);
  }
  
  public static void collectHouse(Activity paramActivity, String paramString, int paramInt, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseFid", paramString);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customerColl/ea61d2/collectHouse", localHashMap, MinsuHouseCollectResultBean.class, parama);
  }
  
  public static void confirmOtherMoney(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/confirmOtherMoney", localHashMap, MinsuBaseJson.class, parama);
  }
  
  public static void couponList(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", Integer.valueOf(paramInt1));
    localHashMap.put("limit", Integer.valueOf(paramInt2));
    localHashMap.put("fid", paramString1);
    localHashMap.put("rentWay", paramString2);
    localHashMap.put("startTime", paramString3);
    localHashMap.put("endTime", paramString4);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/couponList", localHashMap, true, MinsuCouponListBean.class, parama);
  }
  
  public static void createOrder(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, List<String> paramList, String paramString4, String paramString5, String paramString6, String paramString7, i.a<String> parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fid", paramString1);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("userTel", paramString2);
    localHashMap.put("userName", paramString3);
    localHashMap.put("sourceType", "3");
    localHashMap.put("tenantFids", paramList);
    localHashMap.put("startTime", paramString4);
    localHashMap.put("endTime", paramString5);
    localHashMap.put("tripPurpose", paramString6);
    localHashMap.put("couponSn", paramString7);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/createOrder", localHashMap, MinsuCreateOrderBean.class, parama);
  }
  
  public static void customerCommitEvaluate(Activity paramActivity, Class paramClass, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString2);
    localHashMap.put("evaUserType", "2");
    localHashMap.put("content", paramString1);
    localHashMap.put("houseClean", Integer.valueOf(paramInt1));
    localHashMap.put("descriptionMatch", Integer.valueOf(paramInt2));
    localHashMap.put("safetyDegree", Integer.valueOf(paramInt3));
    localHashMap.put("trafficPosition", Integer.valueOf(paramInt4));
    localHashMap.put("costPerformance", Integer.valueOf(paramInt5));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/tenantEva/ea61d2/tenEvaluate", localHashMap, paramClass, parama);
  }
  
  public static void delCommonReply(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", d.getUid());
    localHashMap.put("fid", paramString);
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.h, "/imReply/43e881/deleteCustomization", localHashMap, true, parama);
  }
  
  public static void delHousePicList(Activity paramActivity, List<MinsuHousePicBean> paramList, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("picList", com.alibaba.fastjson.a.toJSONString(paramList));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/house/ea61d2/deleteHousePic", localHashMap, true, MinsuBaseJson.class, parama);
  }
  
  public static void delOrderRemark(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString1);
    localHashMap.put("fid", paramString2);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderLan/ea61d2/delRemark", localHashMap, true, parama);
  }
  
  public static void deleteContact(Activity paramActivity, String paramString, s params)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fid", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/contact/ea61d2/deleteContact", localHashMap, true, params);
  }
  
  public static void deleteHouse(Activity paramActivity, String paramString1, String paramString2, int paramInt, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("houseRoomFid", paramString2);
    localHashMap.put("rentWay", paramInt + "");
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseMgt/ea61d2/deleteHouse", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void deleteReleasePicture(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("housePicFid", paramString2);
    localHashMap.put("picType", Integer.valueOf(paramInt));
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("houseRoomFid", paramString3);
    }
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/housePic/ea61d2/deleteHousePic", localHashMap, true, parama);
  }
  
  public static void downHouseRelease(Activity paramActivity, String paramString1, String paramString2, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("landlordUid", d.getUid());
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseMgt/ea61d2/upDownHouse", localHashMap, parama);
  }
  
  public static void editCommonReply(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", d.getUid());
    localHashMap.put("fid", paramString1);
    localHashMap.put("content", paramString2);
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.h, "/imReply/43e881/updateCustomization", localHashMap, true, parama);
  }
  
  public static void evalConfig(Activity paramActivity, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/conf/ee5f86/evalconfig", localHashMap, false, paramCallback);
  }
  
  public static void exitGroup(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("groupId", paramString1);
    localHashMap.put("projectBid", paramString2);
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.h, "/imApp/43e881/exitGroup", localHashMap, true, parama);
  }
  
  public static void findBookerContacts(Activity paramActivity, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/contact/ea61d2/findBookerContacts", localHashMap, MinsuFindBookerContactsBean.class, parama);
  }
  
  public static void findContacts(Activity paramActivity, int paramInt1, int paramInt2, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("limit", Integer.valueOf(paramInt1));
    localHashMap.put("page", Integer.valueOf(paramInt2));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/contact/ea61d2/findContactsV2", localHashMap, paramCallback);
  }
  
  public static void getAloneRoomInitInfo(Activity paramActivity, String paramString1, String paramString2, Integer paramInteger, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", paramInteger);
    localHashMap.put("rentRoomNum", Integer.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/initRoomMsg", localHashMap, true, parama);
  }
  
  public static void getApplyDetailLL(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", d.getUid());
    localHashMap.put("fid", paramString1);
    localHashMap.put("rentWay", paramInt + "");
    localHashMap.put("startTime", paramString2 + "");
    localHashMap.put("endTime", paramString3 + "");
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.h, "/imOrder/43e881/getNeedPay", localHashMap, false, paramCallback);
  }
  
  public static void getAppointmentPhotographerTime(Activity paramActivity, String paramString, s params)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("landlordUid", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseMgt/ea61d2/bookPhotoTime", localHashMap, true, params);
  }
  
  public static void getAuthInfo(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.get(com.ziroom.ziroomcustomer.minsu.b.d.f + "/personal/ea61d2/getCustomerAuthInfo").headers(d.getHeaderMap(paramContext)).enqueue(parama);
  }
  
  public static void getBankInfoLL(Activity paramActivity, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/initEditBank", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void getCertification(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/getCertification", new HashMap(), true, parama);
  }
  
  public static void getCheckInfoInitMsg(Activity paramActivity, String paramString1, String paramString2, Integer paramInteger, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", paramInteger);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/initCheckInMsg", localHashMap, true, parama);
  }
  
  public static void getCheckListData(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.l, "", localHashMap, false, parama);
  }
  
  public static void getCityTree(Activity paramActivity, s params)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/initCityTree", localHashMap, true, params);
  }
  
  public static void getCms(Activity paramActivity, String paramString, i.a<String> parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString);
    d.requestNoDES(paramActivity, "/?_p=api_mobile&_a=getLunBoDatas", d.getCmsSign(localHashMap), true, MinsuCmsBean.class, parama);
  }
  
  public static void getCms(Activity paramActivity, String paramString, boolean paramBoolean, i.a<String> parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString);
    d.requestNoDES(paramActivity, "/?_p=api_mobile&_a=getLunBoDatas", d.getCmsSign(localHashMap), paramBoolean, MinsuCmsBean.class, parama);
  }
  
  public static void getCollectList(Activity paramActivity, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", Integer.valueOf(paramInt));
    localHashMap.put("limit", Integer.valueOf(10));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customerColl/ea61d2/collHouseList", localHashMap, parama);
  }
  
  public static void getConfig(Activity paramActivity, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/conf/ee5f86/inf", localHashMap, false, paramCallback);
  }
  
  public static void getContactInfo(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    d.request((Activity)paramContext, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/getContactInfo", new HashMap(), true, parama);
  }
  
  public static void getCustomerInfo(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/getCustomerInfo", new HashMap(), true, parama);
  }
  
  public static void getCustomerVo(Activity paramActivity, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customer/ea61d2/getCustomerVo", localHashMap, MinsuCustomerBean.class, parama);
  }
  
  public static void getCustomerVo(Activity paramActivity, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customer/ea61d2/getCustomerVo", localHashMap, paramCallback);
  }
  
  public static void getEvaWaitNum(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/tenantEva/ea61d2/waitnum", localHashMap, true, parama);
  }
  
  public static void getEvaluateWaitNum(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", d.getUid());
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/tenantEva/ea61d2/waitnum", localHashMap, true, parama);
  }
  
  public static void getHomeCms(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.a, "", localHashMap, false, parama);
  }
  
  public static void getHouseDesc(Activity paramActivity, String paramString1, String paramString2, Integer paramInteger, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", paramInteger);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/initHouseDesc", localHashMap, true, parama);
  }
  
  public static void getHouseDetail(Activity paramActivity, String paramString1, int paramInt, String paramString2, boolean paramBoolean, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fid", paramString1);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("startTime", paramString2);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/tenantHouse/8541d0/houseDetail", localHashMap, paramBoolean, MinsuHouseDetailBean.class, parama);
  }
  
  public static void getHouseDetailV1(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fid", paramString1);
    localHashMap.put("rentWay", paramInt + "");
    localHashMap.put("startTime", paramString2);
    localHashMap.put("endTime", paramString3);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/tenantHouse/8541d0/houseDetailV1", localHashMap, paramCallback);
  }
  
  public static void getHouseEvaluate(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fid", paramString);
    localHashMap.put("limit", Integer.valueOf(paramInt1));
    localHashMap.put("page", Integer.valueOf(paramInt2));
    localHashMap.put("rentWay", Integer.valueOf(paramInt3));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/tenantHouse/8541d0/houseEvaluate", localHashMap, MinsuEvaluationBean.class, parama);
  }
  
  public static void getHouseListDetail(Activity paramActivity, String paramString, int paramInt, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fid", paramString);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/tenantHouse/8541d0/houseListDetail", localHashMap, MinsuHouseDetailBean.class, parama);
  }
  
  public static void getHouseManagerBase(Activity paramActivity, String paramString1, String paramString2, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseMgt/ea61d2/getHouseBase", localHashMap, parama);
  }
  
  public static void getHousePrcie(Activity paramActivity, String paramString1, String paramString2, Integer paramInteger, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", paramInteger);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/initHousePrice", localHashMap, true, parama);
  }
  
  public static void getHouseRoom(Activity paramActivity, String paramString1, String paramString2, int paramInt, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("houseRoomFid", paramString2);
    localHashMap.put("rentWay", paramInt + "");
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseMgt/ea61d2/getHouseRoom", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void getIdentityInfo(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    d.request((Activity)paramContext, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/getIdentityInfo", new HashMap(), true, parama);
  }
  
  public static void getIntroduce(Context paramContext, Map<String, String> paramMap, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.get(com.ziroom.ziroomcustomer.minsu.b.d.f + "/personal/ea61d2/introduce").headers(d.getHeaderMap(paramContext)).enqueue(parama);
  }
  
  public static void getLLHouseCalendar(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, com.freelxl.baselibrary.d.c.a parama)
  {
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("houseBaseFid", paramString1);
    locale.put("houseRoomFid", paramString2);
    locale.put("bedFid", paramString3);
    locale.put("rentWay", Integer.valueOf(paramInt1));
    locale.put("requestNum", Integer.valueOf(paramInt2));
    d.requestGateWay(paramActivity, q.o, "/houseMgt/ea61d2/landHouseCalendar", locale, parama);
  }
  
  public static void getLandlordDetail(Activity paramActivity, String paramString1, int paramInt, String paramString2, boolean paramBoolean, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("landlordUid", paramString1);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("houseFid", paramString2);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customer/8541d0/landlordintro", localHashMap, paramBoolean, MinsuLandlordBean.class, parama);
  }
  
  public static void getLandlordDetailNew(Activity paramActivity, String paramString, boolean paramBoolean, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("landlordUid", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customer/8541d0/landlordIntroduceNew", localHashMap, paramBoolean, MinsuLandlordBean.class, parama);
  }
  
  public static void getLandlordEva(Activity paramActivity, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", Integer.valueOf(paramInt1));
    localHashMap.put("limit", Integer.valueOf(paramInt2));
    localHashMap.put("landlordUid", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/landlordEva/8541d0/evaList", localHashMap, paramBoolean, MinsuLandlordEvaBean.class, parama);
  }
  
  public static void getLandlordOrderDetail(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderLan/ea61d2/orderDetail", localHashMap, true, parama);
  }
  
  public static void getLandlordRefuseReason(Activity paramActivity, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", paramString3);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderLan/ea61d2/refuseReason", localHashMap, true, parama);
  }
  
  public static void getLandlordStoryList(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    d.requestGet(paramActivity, q.ak, "minsuapp/cf004fdc76fa1a4f25f62e0eb5261ca3.json", new HashMap(), true, parama);
  }
  
  public static void getLimitRules(Activity paramActivity, s params)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/housePic/8541d0/limitRules", localHashMap, true, params);
  }
  
  public static void getLlBanner(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.get("http://contentful.ziroom.com/online/minsuapp/8b4066554730ddfaa0266346bdc1b202.json").enqueue(parama);
  }
  
  public static void getLlInfo(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.get(com.ziroom.ziroomcustomer.minsu.b.d.f + "/personal/ea61d2/showBasicDetail").headers(d.getHeaderMap(paramContext)).enqueue(parama);
  }
  
  public static void getLlInfoCenter(Context paramContext, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.get(com.ziroom.ziroomcustomer.minsu.b.d.f + "/personal/ea61d2/initPersonalCenter").headers(d.getHeaderMap(paramContext)).enqueue(parama);
  }
  
  public static void getLocation(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", paramString);
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/searchInit/location", localHashMap, true, MinsuSearchConditionBean.class, parama);
  }
  
  public static void getLocationInfo(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getCityCode());
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/searchInit/locationNestingStructure", localHashMap, true, parama);
  }
  
  public static void getLocationSort(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", paramString);
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/searchInit/locationSort", localHashMap, true, parama);
  }
  
  public static void getLockCount(Activity paramActivity, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/lock", localHashMap, MinsuLockNumBean.class, parama);
  }
  
  public static void getLottieData(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    Object localObject = ApplicationEx.c;
    boolean bool = ((ApplicationEx)localObject).isLoginState();
    localObject = ((ApplicationEx)localObject).getUser();
    HashMap localHashMap = new HashMap();
    if ((bool) && (localObject != null)) {
      localHashMap.put("uid", ((UserInfo)localObject).getUid());
    }
    for (localObject = "/reduction/43e881/firstSingleReduction";; localObject = "/reduction/ee5f86/firstSingleReduction")
    {
      d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, (String)localObject, localHashMap, false, parama);
      return;
    }
  }
  
  public static void getMapCms(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.b, "", localHashMap, false, parama);
  }
  
  public static void getMinSuCouponConfigInfo(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    String str = m.getLottieVersion();
    HashMap localHashMap = new HashMap();
    localHashMap.put("mgVersion", str);
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/conf/ee5f86/getMG", localHashMap, false, parama);
  }
  
  public static void getMobileCodeAuthMsg(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("mobile", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customer/ea61d2/getMobileCodeAuthMsg", localHashMap, true, MinsuBaseJson.class, parama);
  }
  
  public static void getNeedPayFee(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("couponSn", paramString4);
    localHashMap.put("fid", paramString1);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("startTime", paramString2);
    localHashMap.put("endTime", paramString3);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/getNeedPayFee", localHashMap, true, MinsuNeedPayBean.class, parama);
  }
  
  public static void getOrderDetail(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/showDetail", localHashMap, true, MinsuOrderDetailBean.class, parama);
  }
  
  public static void getOrderNum(Activity paramActivity, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/showOrderNum", localHashMap, paramCallback);
  }
  
  public static void getOrdreLast(Activity paramActivity, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/showLast", localHashMap, paramCallback);
  }
  
  public static void getOrdreList(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", "" + paramInt2);
    localHashMap.put("limit", "" + paramInt3);
    localHashMap.put("tenantOrderStatus", Integer.valueOf(paramInt1));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/showList", localHashMap, MinsuOrderBean.class, parama);
  }
  
  public static void getPhotoList(Activity paramActivity, String paramString1, int paramInt, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("roomFid", paramString2);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/housePic/ea61d2/housePhotosList", localHashMap, true, parama);
  }
  
  public static void getRecommendNps(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/nps/ea61d2/getRecommendNps", localHashMap, parama);
  }
  
  public static void getRefreshHeartList(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    d.requestGet(paramActivity, q.ak, "minsuapp/05049e90fa4f5039a8cadc6acbb4b2cc.json", new HashMap(), true, parama);
  }
  
  public static void getReleaseTypeLocationInfo(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString1))
    {
      localHashMap.put("houseBaseFid", paramString1);
      localHashMap.put("roomType", Integer.valueOf(paramInt1));
      if (paramInt2 == 1) {
        localHashMap.put("roomFid", paramString2);
      }
      localHashMap.put("rentWay", Integer.valueOf(paramInt2));
    }
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/initTypeLocation", localHashMap, true, parama);
  }
  
  public static void getRoomBasicInfo(Activity paramActivity, String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", paramInteger1);
    localHashMap.put("roomType", paramInteger2);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/initRoomModel", localHashMap, true, parama);
  }
  
  public static void getRoomHaveListInfo(Activity paramActivity, String paramString1, String paramString2, Integer paramInteger, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", paramInteger);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/initRoomList", localHashMap, true, parama);
  }
  
  public static void getSort(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", paramString);
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/searchInit/sort", localHashMap, true, MinsuSearchSortBean.class, parama);
  }
  
  public static void getTodayDiscountStartDate(Activity paramActivity, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/conf/ee5f86/getTodayDiscountStartDate", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void getTopHouseDetail(Activity paramActivity, String paramString1, int paramInt, String paramString2, s params)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fid", paramString1);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("startTime", paramString2);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/tenantHouse/8541d0/houseDetailTOP50", localHashMap, true, params);
  }
  
  public static void getUserDynaPswd(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/smart/ea61d2/getUserDynaPswd", localHashMap, true, MinSuUserSmartLock.class, parama);
  }
  
  public static void getUserSmartLocks(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/smart/ea61d2/getUserSmartLocks", localHashMap, true, MinSuUserSmartLock.class, parama);
  }
  
  public static void getZRYNotice(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.get("http://contentful.ziroom.com/online/combine/093f65e080a295f8076b1c5722a46aa2.json").tag(paramActivity).enqueue(parama);
  }
  
  public static void hasOnlineHouse(Activity paramActivity, s params)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseMgt/ea61d2/hasOnlineHouse", localHashMap, true, params);
  }
  
  public static void houseDetailCouponBar(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseDetailCoupon/ee5f86/couponBarShow", localHashMap, false, parama);
  }
  
  public static void houseDetailCouponList(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", d.getUid());
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseDetailCoupon/ee5f86/couponListShow", localHashMap, false, parama);
  }
  
  public static void houseListDetail(Activity paramActivity, String paramString, int paramInt, i.a<String> parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fid", paramString);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/tenantHouse/8541d0/houseListDetail", localHashMap, MinsuHouseDetailBean.class, parama);
  }
  
  public static void housePicList(Activity paramActivity, MinsuHousePicBean paramMinsuHousePicBean, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramMinsuHousePicBean.houseBaseFid);
    localHashMap.put("houseRoomFid", paramMinsuHousePicBean.houseRoomFid);
    localHashMap.put("picType", paramMinsuHousePicBean.picType);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/house/ea61d2/housePicMsgList", localHashMap, true, MinsuHousePicListBean.class, parama);
  }
  
  public static void houseRoomListLL(Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("landlordUid", d.getUid());
    localHashMap.put("page", paramInt1 + "");
    localHashMap.put("limit", paramInt2 + "");
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseMgt/ea61d2/houseRoomListNew", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void imFindRelationShip(Activity paramActivity, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fromUid", paramString1);
    localHashMap.put("toUid", paramString2);
    localHashMap.put("ziroomFlag", paramString3);
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.h, "/imApp/43e881/queryMsgUserRel", localHashMap, true, parama);
  }
  
  public static void imReclyCommon(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", d.getUid());
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.h, "/imReply/43e881/queryCustomizationByUid", localHashMap, true, parama);
  }
  
  public static void imSaveChangZhuMsgLog(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgId", paramString1);
    localHashMap.put("fromUid", j.removeEMPrefix(paramString2));
    localHashMap.put("toUid", j.removeEMPrefix(paramString3));
    localHashMap.put("content", paramString4);
    localHashMap.put("ext", paramString5);
    localHashMap.put("chatType", paramString6);
    localHashMap.put("ziroomFlag", paramString7);
    localHashMap.put("type", paramString8);
    localHashMap.put("chatStatu", paramInt + "");
    u.d("imSaveMsgLog", "=========   " + com.alibaba.fastjson.a.toJSONString(localHashMap));
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.h, "/imApp/43e881/saveMsgLog", localHashMap, true, parama);
  }
  
  public static void imSaveMsgLog(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgId", paramString1);
    localHashMap.put("fromUid", j.removeEMPrefix(paramString2));
    localHashMap.put("toUid", j.removeEMPrefix(paramString3));
    localHashMap.put("content", paramString4);
    localHashMap.put("ext", paramString5);
    localHashMap.put("chatType", paramString6);
    localHashMap.put("ziroomFlag", paramString7);
    localHashMap.put("type", paramString8);
    localHashMap.put("chatStatu", paramInt + "");
    u.d("imSaveMsgLog", "=========   " + com.alibaba.fastjson.a.toJSONString(localHashMap));
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.h, "/imApp/43e881/saveMsgLog", localHashMap, true, parama);
  }
  
  public static void improveHouseRank(Activity paramActivity, s params)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseMgt/ea61d2/improveHouseRank", localHashMap, true, params);
  }
  
  public static void initEditReceiveLL(Activity paramActivity, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/initEditReceive", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void initEditbankLL(Activity paramActivity, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/initEditCheck", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void initLLCalendarEdit(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, List<String> paramList, com.freelxl.baselibrary.d.c.a parama)
  {
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("houseBaseFid", paramString1);
    locale.put("houseRoomFid", paramString2);
    locale.put("bedFid", paramString3);
    locale.put("rentWay", Integer.valueOf(paramInt));
    locale.put("selectDates", paramList);
    d.requestGateWay(paramActivity, q.o, "/house/ea61d2/calendarEditInit", locale, parama);
  }
  
  public static void initPolicy(Activity paramActivity, String paramString1, String paramString2, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/initDealPolicy", localHashMap, parama);
  }
  
  public static void initSearchBase(Activity paramActivity, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/searchInit/initSearchBaseData", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void initSearchBaseData(Activity paramActivity, boolean paramBoolean, String paramString, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", paramString);
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/searchInit/initSearchBaseData", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void initSetPrice(Activity paramActivity, String paramString1, String paramString2, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseMgt/ea61d2/initSetPrice", localHashMap, parama);
  }
  
  public static void isCollectHouse(Activity paramActivity, String paramString, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fid", paramString);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customerColl/ea61d2/isCollection", localHashMap, parama);
  }
  
  public static void isCollectHouse(Activity paramActivity, String paramString, int paramInt, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fid", paramString);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customerColl/ea61d2/isCollection", localHashMap, MinsuHouseIsCollectResutBean.class, parama);
  }
  
  public static void landShareHouseList(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("landlordUid", d.getUid());
    localHashMap.put("startTime", paramString1);
    localHashMap.put("endTime", paramString2);
    localHashMap.put("personCount", paramString3);
    localHashMap.put("page", paramInt1 + "");
    localHashMap.put("limit", paramInt2 + "");
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/search/landShareHouseList", localHashMap, true, parama);
  }
  
  public static void landlist(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, i.a<MinsuHouseBean> parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("landlordUid", paramString1);
    localHashMap.put("fid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt1));
    localHashMap.put("page", Integer.valueOf(paramInt2));
    localHashMap.put("limit", Integer.valueOf(paramInt3));
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/search/landList", localHashMap, paramBoolean, MinsuHouseBean.class, parama);
  }
  
  public static void landlistOk(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("landlordUid", paramString1);
    localHashMap.put("fid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt1));
    localHashMap.put("page", Integer.valueOf(paramInt2));
    localHashMap.put("limit", Integer.valueOf(paramInt3));
    if (paramBoolean2) {
      localHashMap.put("isTop50Online", Integer.valueOf(1));
    }
    paramString1 = ad.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.get(com.ziroom.ziroomcustomer.minsu.b.d.e + "/search/landList").headers(d.getHeaderMap(paramActivity)).params(paramString1).tag(paramActivity).enqueue(parama);
  }
  
  public static void landlistOkNew(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("landlordUid", paramString1);
    localHashMap.put("fid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt1));
    localHashMap.put("page", Integer.valueOf(paramInt2));
    localHashMap.put("limit", Integer.valueOf(paramInt3));
    if (paramBoolean2) {
      localHashMap.put("isTop50Online", Integer.valueOf(1));
    }
    paramString1 = ad.ConvertObjMap2String(localHashMap);
    com.freelxl.baselibrary.d.a.get(com.ziroom.ziroomcustomer.minsu.b.d.e + "/search/getSimilarHouse").headers(d.getHeaderMap(paramActivity)).params(paramString1).tag(paramActivity).enqueue(parama);
  }
  
  public static void lastHouse(Activity paramActivity, boolean paramBoolean, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/search/lasthouse", localHashMap, paramBoolean, parama);
  }
  
  public static void leaseCalendar(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    if (paramInt == 0) {
      localHashMap.put("houseBaseFid", paramString1);
    }
    for (;;)
    {
      localHashMap.put("rentWay", Integer.valueOf(paramInt));
      localHashMap.put("startDate", paramString2);
      localHashMap.put("endDate", paramString3);
      d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/house/8541d0/calendar", localHashMap, parama);
      return;
      localHashMap.put("houseRoomFid", paramString1);
    }
  }
  
  public static void leaseCalendar(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    if (paramInt == 0) {
      localHashMap.put("houseBaseFid", paramString1);
    }
    for (;;)
    {
      localHashMap.put("rentWay", Integer.valueOf(paramInt));
      localHashMap.put("startDate", paramString2);
      localHashMap.put("endDate", paramString3);
      d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/house/8541d0/calendar", localHashMap, LeaseCalendarBean.class, parama);
      return;
      localHashMap.put("houseRoomFid", paramString1);
    }
  }
  
  public static void listCoupon(Activity paramActivity, int paramInt1, int paramInt2, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", Integer.valueOf(paramInt1));
    localHashMap.put("limit", Integer.valueOf(paramInt2));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/cms/ea61d2/listAll", localHashMap, true, MinsuCouponListBean.class, parama);
  }
  
  public static void llCommitEva(Activity paramActivity, int paramInt, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    a(paramActivity, Integer.valueOf(paramInt), paramString1, paramString2, 1, parama);
  }
  
  public static void llCommitReply(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    a(paramActivity, null, paramString1, paramString2, 10, parama);
  }
  
  public static void llEvaWaitNum(Activity paramActivity, s params)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/landlordEva/ea61d2/waitnum", localHashMap, true, params);
  }
  
  public static void llQueryLanEvaInfo(Activity paramActivity, String paramString, int paramInt, s params)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString);
    localHashMap.put("evaUserType", Integer.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/evaluate/ea61d2/queryEvaInfo", localHashMap, true, params);
  }
  
  public static void managerInitDescAndBaseInfoEntire(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString);
    localHashMap.put("rentWay", Integer.valueOf(0));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/initDescAndBaseInfoEntire", localHashMap, parama);
  }
  
  public static void managerInitDescAndBaseInfoSublet(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(1));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/initDescAndBaseInfoSublet", localHashMap, parama);
  }
  
  public static void managerInitTypeLocation(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/initTypeLocation", localHashMap, parama);
  }
  
  public static void mapSearchHouse(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    Object localObject = com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().generateRequestMap();
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      locale.put((String)localEntry.getKey(), localEntry.getValue());
    }
    d.requestGateWayPath(paramActivity, false, "searchApi", "/search/mapSearchHouse", locale, parama);
  }
  
  public static void mapSearchHouseCity(Activity paramActivity, boolean paramBoolean, com.freelxl.baselibrary.d.c.a parama)
  {
    Object localObject = com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().generateRequestMap();
    if (paramBoolean)
    {
      ((Map)localObject).put("longitude", "");
      ((Map)localObject).put("latitude", "");
    }
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      locale.put((String)localEntry.getKey(), localEntry.getValue());
    }
    d.requestGateWayPath(paramActivity, false, "searchApi", "/search/mapSearchHouse", locale, parama);
  }
  
  public static void needPayFee(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("couponSn", paramString4);
    localHashMap.put("fid", paramString1);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("startTime", paramString2);
    localHashMap.put("endTime", paramString3);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/needPay", localHashMap, true, MinsuNewNeedPayBean.class, parama);
  }
  
  public static void needPayV3(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, boolean paramBoolean, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("couponSn", paramString4);
    localHashMap.put("fid", paramString1);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("startTime", paramString2);
    localHashMap.put("endTime", paramString3);
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localHashMap.put("isAutoCoupon", Integer.valueOf(paramInt));
      d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/needPayV3", localHashMap, true, MinsuNeedPayV4Bean.class, parama);
      return;
    }
  }
  
  public static void orderListLL(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("lanOrderType", paramInt1 + "");
    localHashMap.put("page", paramInt2 + "");
    localHashMap.put("limit", paramInt3 + "");
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderLan/ea61d2/showList", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void ordreCancle(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/cancleOrder", localHashMap, MinsuBaseJson.class, parama);
  }
  
  public static void ordreCancleMsg(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/cancleOrderMsg", localHashMap, MinsuOrderCancleBean.class, parama);
  }
  
  public static void personalCenterLL(Activity paramActivity, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/accountInfo", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void putImData(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("tenantUid", j.removeEMPrefix(paramString1));
    localHashMap.put("landlordUid", j.removeEMPrefix(paramString2));
    localHashMap.put("msgContent", paramString3);
    localHashMap.put("msgSentType", paramString4);
    localHashMap.put("sendNum", paramString5);
    localHashMap.put("endDate", paramString6);
    localHashMap.put("startDate", paramString7);
    localHashMap.put("fid", paramString8);
    localHashMap.put("houseCard", paramString9 + "");
    localHashMap.put("houseName", paramString10);
    localHashMap.put("housePicUrl", paramString11);
    localHashMap.put("personNum", paramString12);
    localHashMap.put("rentWay", paramString13);
    localHashMap.put("ziroomFlag", "ZIROOM_MINSU_IM");
    localHashMap.put("uid", paramString14);
    localHashMap.put("huanxinMsgId", paramString15);
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.h, "/imApp/43e881/saveImMsg", localHashMap, true, parama);
  }
  
  public static void putImData(Context paramContext, String paramString1, String paramString2, long paramLong, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("phoneModel", Build.MODEL);
    localHashMap.put("phoneBrand", Build.BRAND);
    localHashMap.put("osVersion", Build.VERSION.RELEASE);
    localHashMap.put("etWork", ad.netType2Int(ad.GetNetworkType()) + "");
    localHashMap.put("uid", com.ziroom.commonlibrary.login.a.getUid(paramContext));
    localHashMap.put("versionCode", "100032");
    localHashMap.put("huanxinId", EMClient.getInstance().getCurrentUser());
    localHashMap.put("equipmentIden", ah.getDeviceId(paramContext));
    localHashMap.put("systemIden", "android");
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("errorDescribe", paramString1);
    }
    localHashMap.put("failType", paramString2);
    if (paramLong > 0L) {
      localHashMap.put("loginConsumeTime", paramLong + "");
    }
    paramString1 = parama;
    if (parama == null) {
      paramString1 = new com.freelxl.baselibrary.d.c.a(new com.freelxl.baselibrary.d.f.e())
      {
        public void onFailure(Throwable paramAnonymousThrowable) {}
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString) {}
      };
    }
    d.requestNoDES(paramContext, com.ziroom.ziroomcustomer.minsu.b.d.h, "/imApp/43e881/saveImMsg", localHashMap, paramString1);
  }
  
  public static void putImErrorData(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("tenantUid", j.removeEMPrefix(paramString1));
    localHashMap.put("landlordUid", j.removeEMPrefix(paramString2));
    localHashMap.put("msgContent", paramString3);
    localHashMap.put("msgSentType", paramString4);
    localHashMap.put("sendNum", paramString5);
    localHashMap.put("endDate", paramString6);
    localHashMap.put("startDate", paramString7);
    localHashMap.put("fid", paramString8);
    localHashMap.put("houseCard", paramString9 + "");
    localHashMap.put("houseName", paramString10);
    localHashMap.put("housePicUrl", paramString11);
    localHashMap.put("personNum", paramString12);
    localHashMap.put("rentWay", paramString13);
    localHashMap.put("ziroomFlag", "ZIROOM_MINSU_IM");
    localHashMap.put("uid", paramString14);
    localHashMap.put("huanxinMsgId", paramString15);
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.h, "/imApp/43e881/imMsgError", localHashMap, true, parama);
  }
  
  public static void query(Activity paramActivity, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, Integer paramInteger4, Integer paramInteger5, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, boolean paramBoolean, i.a parama)
  {
    paramString11 = new HashMap();
    paramString11.put("q", paramString1);
    paramString11.put("startTime", paramString2);
    paramString11.put("endTime", paramString3);
    paramString11.put("cityCode", paramString4);
    paramString11.put("limit", Integer.valueOf(paramInt1));
    paramString11.put("page", Integer.valueOf(paramInt2));
    paramString11.put("priceStart", paramInteger4);
    paramString11.put("priceEnd", paramInteger5);
    paramString11.put("priceEnd", paramInteger5);
    paramString11.put("rentWay", paramInteger1);
    paramString11.put("orderType", paramInteger3);
    paramString11.put("hotReginScenic", paramString6);
    paramString11.put("hotReginBusiness", paramString7);
    paramString11.put("subway", paramString9);
    paramString11.put("areaCode", paramString10);
    paramString11.put("sortType", paramString8);
    paramString11.put("lineFid", paramString12);
    paramString11.put("houseType", paramString13);
    paramString11.put("longTermDiscount", paramString14);
    paramString11.put("jiaxinDiscount", paramString15);
    if (ae.notNull(paramString5)) {
      paramString11.put("personCount", paramString5);
    }
    if (paramInteger2 != null) {
      paramString11.put("roomCount", paramInteger2);
    }
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/search/query", paramString11, paramBoolean, MinsuHouseBean.class, parama);
  }
  
  public static void queryEvaluate(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("limit", Integer.valueOf(paramInt1));
    localHashMap.put("page", Integer.valueOf(paramInt2));
    localHashMap.put("requestType", Integer.valueOf(paramInt3));
    localHashMap.put("orderEvalType", Integer.valueOf(paramInt4));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/evaluate/ea61d2/queryEvaList", localHashMap, parama);
  }
  
  public static void queryEvaluateInfo(Activity paramActivity, String paramString, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/tenantEva/ea61d2/queryEvaluateInfo", localHashMap, MinsuEvaluationDetailBean.class, parama);
  }
  
  public static void queryGroupUserInfo(Activity paramActivity, String paramString, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("groupId", paramString);
    localHashMap.put("page", Integer.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customer/ea61d2/queryGroupUserInfo", localHashMap, true, parama);
  }
  
  public static void queryMinsu(Activity paramActivity, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    queryMinsu(paramActivity, paramInt, null, parama);
  }
  
  public static void queryMinsu(Activity paramActivity, int paramInt, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    Map localMap = com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().generateRequestMap();
    if (!TextUtils.isEmpty(paramString))
    {
      localMap.put("facetType", paramString);
      localMap.remove("limit");
    }
    for (;;)
    {
      d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/search/query", localMap, true, parama);
      return;
      localMap.put("page", String.valueOf(paramInt));
    }
  }
  
  public static void queryStation(Activity paramActivity, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    Map localMap = com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().generateRequestMap();
    localMap.put("page", String.valueOf(paramInt));
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/zry/query", localMap, true, parama);
  }
  
  public static void queryStrategy(Activity paramActivity, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    Map localMap = com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().generateRequestMap();
    localMap.put("page", String.valueOf(paramInt));
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/strategy/query", localMap, true, parama);
  }
  
  public static void queryStrategyFromStation(Activity paramActivity, int paramInt, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("limit", "10");
    localHashMap.put("cityCode", paramString1);
    localHashMap.put("hotReginBusiness", paramString2);
    localHashMap.put("page", String.valueOf(paramInt));
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/strategy/query", localHashMap, true, parama);
  }
  
  public static void releaseHouse(Activity paramActivity, String paramString1, String paramString2, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("roomFid", paramString2);
    }
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("landlordUid", d.getUid());
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/housePic/ea61d2/issueHouse", localHashMap, parama);
  }
  
  public static void requestImUserInfo(Activity paramActivity, List<String> paramList, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uidList", com.alibaba.fastjson.a.toJSONString(paramList));
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.h, "/imApp/43e881/queryLiveness", localHashMap, true, parama);
  }
  
  public static void saveAdvise(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("complain", paramString);
    paramString = d.signMethod(locale.toJSONString());
    com.freelxl.baselibrary.d.a.post(com.ziroom.ziroomcustomer.minsu.b.d.f + "/personal/ea61d2/saveAdvise").headers(d.getHeaderMap(paramContext)).params(paramString).enqueue(parama);
  }
  
  public static void saveAloneRoomInitInfo(Activity paramActivity, String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2, String paramString3, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Integer paramInteger7, String paramString4, double paramDouble1, double paramDouble2, Integer paramInteger8, Integer paramInteger9, Integer paramInteger10, String paramString5, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", paramInteger1);
    localHashMap.put("rentRoomNum", paramInteger2);
    localHashMap.put("roomName", paramString3);
    localHashMap.put("houseArea", paramInteger3);
    localHashMap.put("leasePrice", paramInteger4);
    localHashMap.put("weekendPriceSwitch", paramInteger5);
    localHashMap.put("weekPrice", paramInteger6);
    localHashMap.put("fullDayRateSwitch", paramInteger7);
    localHashMap.put("weekdays", paramString4);
    localHashMap.put("sevenDiscountRate", Double.valueOf(paramDouble1));
    localHashMap.put("thirtyDiscountRate", Double.valueOf(paramDouble2));
    localHashMap.put("cleaningFees", paramInteger8);
    localHashMap.put("isToilet", paramInteger9);
    localHashMap.put("checkInLimit", paramInteger10);
    localHashMap.put("bedArrays", paramString5);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/saveRoomMsg", localHashMap, true, parama);
  }
  
  public static void saveAuthInfo(Context paramContext, String paramString1, int paramInt, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("realName", paramString1);
    locale.put("idType", Integer.valueOf(paramInt));
    locale.put("idNo", paramString2);
    paramString1 = d.signMethod(locale.toJSONString());
    com.freelxl.baselibrary.d.a.post(com.ziroom.ziroomcustomer.minsu.b.d.f + "/personal/ea61d2/saveCustomerAuthInfo").headers(d.getHeaderMap(paramContext)).params(paramString1).enqueue(parama);
  }
  
  public static void saveAuthMsg(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("realName", paramString1);
    localHashMap.put("mobile", paramString2);
    localHashMap.put("authCode", paramString3);
    localHashMap.put("idType", paramString4);
    localHashMap.put("idNo", paramString5);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customer/ea61d2/saveAuthMsg", localHashMap, true, MinsuBaseJson.class, parama);
  }
  
  public static void saveBankInfoLL(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bankcardHolder", paramString1);
    localHashMap.put("bankName", paramString2);
    localHashMap.put("bankcardNo", paramString3);
    localHashMap.put("province", paramString4);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/saveBank", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void saveCheckInfoInitMsg(Activity paramActivity, String paramString1, String paramString2, Integer paramInteger, int paramInt, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", paramInteger);
    localHashMap.put("minDay", Integer.valueOf(paramInt));
    localHashMap.put("checkInTime", paramString3);
    localHashMap.put("checkOutTime", paramString4);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/saveCheckInMsg", localHashMap, true, parama);
  }
  
  public static void saveContacts(Activity paramActivity, List<ContactVosBean> paramList, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("listContactVos", paramList);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/contact/ea61d2/saveContacts", localHashMap, MinsuContactsSaveResultBean.class, parama);
  }
  
  public static void saveCustomerInfo(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("nickName", paramString1);
    localHashMap.put("customerIntroduce", paramString2);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/saveCustomerInfo", localHashMap, true, parama);
  }
  
  public static void saveDescAndBaseInfoEntire(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, Double paramDouble, String paramString6, Integer paramInteger, String paramString7, List paramList1, List paramList2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("houseName", paramString3);
    localHashMap.put("houseDesc", paramString4);
    localHashMap.put("houseAroundDesc", paramString5);
    localHashMap.put("houseArea", paramDouble);
    localHashMap.put("houseFacility", paramString6);
    localHashMap.put("checkInLimit", paramInteger);
    localHashMap.put("houseModel", paramString7);
    localHashMap.put("houseRoomList", paramList1);
    localHashMap.put("delRoomFidList", paramList2);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/saveDescAndBaseInfoEntire", localHashMap, parama);
  }
  
  public static void saveDescAndBaseInfoSublet(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Integer paramInteger1, String paramString5, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("houseDesc", paramString3);
    localHashMap.put("houseAroundDesc", paramString4);
    localHashMap.put("isTogetherLandlord", paramInteger1);
    localHashMap.put("supportArray", paramString5);
    localHashMap.put("roomNum", paramInteger2);
    localHashMap.put("parlorNum", paramInteger3);
    localHashMap.put("toiletNum", paramInteger4);
    localHashMap.put("kitchenNum", paramInteger5);
    localHashMap.put("balconyNum", paramInteger6);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/saveDescAndBaseInfoSublet", localHashMap, parama);
  }
  
  public static void saveHouseDescInfo(Activity paramActivity, String paramString1, Integer paramInteger, String paramString2, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("rentWay", paramInteger);
    localHashMap.put("houseName", paramString2);
    localHashMap.put("houseDesc", paramString3);
    localHashMap.put("houseAroundDesc", paramString4);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/saveHouseDesc", localHashMap, true, parama);
  }
  
  public static void saveHousePrcie(Activity paramActivity, String paramString1, String paramString2, int paramInt1, Integer paramInteger1, String paramString3, int paramInt2, int paramInt3, int paramInt4, String paramString4, double paramDouble1, int paramInt5, double paramDouble2, double paramDouble3, Integer paramInteger2, String paramString5, List<SaveHouseRoomListBean> paramList, List<String> paramList1, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt1));
    localHashMap.put("houseArea", paramInteger1);
    localHashMap.put("houseFacility", paramString3);
    localHashMap.put("leasePrice", Integer.valueOf(paramInt2));
    localHashMap.put("cleaningFees", Integer.valueOf(paramInt3));
    localHashMap.put("weekendPriceSwitch", Integer.valueOf(paramInt4));
    localHashMap.put("weekendPriceType", paramString4);
    localHashMap.put("weekendPriceVal", Double.valueOf(paramDouble1));
    localHashMap.put("fullDayRateSwitch", Integer.valueOf(paramInt5));
    localHashMap.put("sevenDiscountRate", Double.valueOf(paramDouble2));
    localHashMap.put("thirtyDiscountRate", Double.valueOf(paramDouble3));
    localHashMap.put("checkInLimit", paramInteger2);
    localHashMap.put("houseModel", paramString5);
    localHashMap.put("houseRoomList", paramList);
    localHashMap.put("delRoomFidList", paramList1);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/saveHousePrice", localHashMap, true, parama);
  }
  
  public static void saveIntroduce(Context paramContext, Map<String, String> paramMap, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.post(com.ziroom.ziroomcustomer.minsu.b.d.f + "/personal/ea61d2/saveIntroduce").headers(d.getHeaderMap(paramContext)).params(d.signMethod(paramMap)).enqueue(parama);
  }
  
  public static void saveLLCalendarEdit(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, List<String> paramList, Integer paramInteger1, Integer paramInteger2, com.freelxl.baselibrary.d.c.a parama)
  {
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("houseBaseFid", paramString1);
    locale.put("houseRoomFid", paramString2);
    locale.put("bedFid", paramString3);
    locale.put("rentWay", Integer.valueOf(paramInt));
    locale.put("selectDates", paramList);
    locale.put("lockStatus", paramInteger1);
    locale.put("specialPrice", paramInteger2);
    d.requestGateWay(paramActivity, q.o, "/house/ea61d2/calendarEditSave", locale, parama);
  }
  
  public static void saveNps(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("score", paramString1);
    localHashMap.put("orderSn", paramString2);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/nps/ea61d2/saveNps", localHashMap, parama);
  }
  
  public static void saveOrderRemark(Activity paramActivity, String paramString1, String paramString2, com.freelxl.baselibrary.d.c.a parama)
  {
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    locale.put("orderSn", paramString1);
    locale.put("remark", paramString2);
    d.requestGateWay(paramActivity, q.o, "/orderLan/ea61d2/saveOrderRemark", locale, parama);
  }
  
  public static void savePolicy(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3, String paramString5, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt1));
    localHashMap.put("orderType", Integer.valueOf(paramInt2));
    localHashMap.put("houseRules", paramString3);
    localHashMap.put("houseRulesArray", paramString4);
    localHashMap.put("depositMoney", Integer.valueOf(paramInt3));
    localHashMap.put("cancellationPolicy", paramString5);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/saveDealPolicy", localHashMap, parama);
  }
  
  public static void saveReceType(Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", paramString1);
    localHashMap.put("code", paramString2);
    localHashMap.put("value", paramString3);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/saveType", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void saveReleaseTypeLocation(Activity paramActivity, String paramString1, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Double paramDouble1, Double paramDouble2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("rentWay", paramInteger1);
    localHashMap.put("roomType", paramInteger2);
    localHashMap.put("houseType", paramInteger3);
    localHashMap.put("regionCode", paramString2);
    localHashMap.put("regionName", paramString3);
    localHashMap.put("houseStreet", paramString4);
    if (!TextUtils.isEmpty(paramString5)) {
      localHashMap.put("communityName", paramString5);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      localHashMap.put("houseNumber", paramString6);
    }
    localHashMap.put("longitude", paramDouble1);
    localHashMap.put("latitude", paramDouble2);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/saveTypeLocation", localHashMap, true, parama);
  }
  
  public static void saveRoomBasicInfo(Activity paramActivity, String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2, int paramInt1, String paramString3, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", paramInteger1);
    localHashMap.put("roomType", paramInteger2);
    localHashMap.put("isTogetherLandlord", Integer.valueOf(paramInt1));
    localHashMap.put("supportArray", paramString3);
    localHashMap.put("roomNum", Integer.valueOf(paramInt2));
    localHashMap.put("parlorNum", Integer.valueOf(paramInt3));
    localHashMap.put("toiletNum", Integer.valueOf(paramInt4));
    localHashMap.put("kitchenNum", Integer.valueOf(paramInt5));
    localHashMap.put("balconyNum", Integer.valueOf(paramInt6));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/saveRoomModel", localHashMap, true, parama);
  }
  
  public static void saveSetPrice(Activity paramActivity, String paramString1, String paramString2, int paramInt, Integer paramInteger1, Integer paramInteger2, String paramString3, Double paramDouble1, Integer paramInteger3, Double paramDouble2, Double paramDouble3, Integer paramInteger4, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    localHashMap.put("leasePrice", paramInteger1);
    localHashMap.put("weekendPriceSwitch", paramInteger2);
    localHashMap.put("weekendPriceType", paramString3);
    localHashMap.put("weekendPriceVal", paramDouble1);
    localHashMap.put("fullDayRateSwitch", paramInteger3);
    localHashMap.put("sevenDiscountRate", paramDouble2);
    localHashMap.put("thirtyDiscountRate", paramDouble3);
    localHashMap.put("cleaningFees", paramInteger4);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseMgt/ea61d2/savePrice", localHashMap, parama);
  }
  
  public static void searchList(Activity paramActivity, String paramString, boolean paramBoolean, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("par", paramString);
    d.requestGet(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/searchInit/list", localHashMap, paramBoolean, MinsuHouseBean.class, parama);
  }
  
  public static void setConfirmOtherMoney(Activity paramActivity, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString1);
    localHashMap.put("otherMoney", paramString2);
    localHashMap.put("paramValue", paramString3);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderLan/ea61d2/confirmOtherMoney", localHashMap, true, parama);
  }
  
  public static void setCoverPicture(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("housePicFid", paramString2);
    localHashMap.put("picType", Integer.valueOf(paramInt1));
    localHashMap.put("isDefault", Integer.valueOf(paramInt2));
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("houseRoomFid", paramString3);
    }
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/housePic/ea61d2/setDefaultPic", localHashMap, true, parama);
  }
  
  public static void setDefaultPic(Activity paramActivity, MinsuHousePicBean paramMinsuHousePicBean, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramMinsuHousePicBean.houseBaseFid);
    localHashMap.put("houseRoomFid", paramMinsuHousePicBean.houseRoomFid);
    localHashMap.put("housePicFid", paramMinsuHousePicBean.housePicFid);
    localHashMap.put("picType", paramMinsuHousePicBean.picType);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/house/ea61d2/setDefaultPic", localHashMap, true, MinsuBaseJson.class, parama);
  }
  
  public static void setHouseTodayDiscount(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("createUid", d.getUid());
    localHashMap.put("houseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", paramString3);
    localHashMap.put("discount", paramString4);
    localHashMap.put("endTimeStr", paramString5);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseMgt/ea61d2/setHouseTodayDiscount", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void setHouseTodayDiscountHint(Activity paramActivity, boolean paramBoolean, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("createUid", d.getUid());
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseMgt/ea61d2/houseTodayDiscountHint", localHashMap, paramBoolean, paramCallback);
  }
  
  public static void setLandlordAcceptOrder(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderLan/ea61d2/acceptOrder", localHashMap, true, parama);
  }
  
  public static void setLandlordRefuseOrder(Activity paramActivity, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderSn", paramString1);
    localHashMap.put("refuseCode", paramString2);
    localHashMap.put("refuseReason", paramString3);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderLan/ea61d2/refusedOrder", localHashMap, true, parama);
  }
  
  public static void showMsgByCode(Activity paramActivity, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("code", paramString);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/tipMsg/8541d0/showMsgByCode", localHashMap, true, parama);
  }
  
  public static void showRules(Activity paramActivity, String paramString1, String paramString2, int paramInt, s params)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("code", paramString1);
    localHashMap.put("fid", paramString2);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/rules/8541d0/showRules", localHashMap, true, params);
  }
  
  public static void syncImList(Context paramContext, int paramInt, Callback paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", d.getUid());
    localHashMap.put("page", paramInt + "");
    com.freelxl.baselibrary.d.a.post(com.ziroom.ziroomcustomer.minsu.b.d.h + "/imApp/43e881/syncLoginUserMsg").params(localHashMap).tag(paramContext).headers(d.getHeaderMap(paramContext)).enqueue(paramCallback);
  }
  
  public static void toLandlordRole(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/toLandlordRole", localHashMap, true, parama);
  }
  
  public static void toPay(Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3, List<MinsuPayVo> paramList, String paramString4, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cityCode", "801300");
    localHashMap.put("sourceType", "3");
    localHashMap.put("toPayType", Integer.valueOf(paramInt));
    localHashMap.put("totalFee", paramString3);
    localHashMap.put("bizeCode", paramString1);
    localHashMap.put("orderSn", paramString2);
    localHashMap.put("payList", paramList);
    localHashMap.put("payType", paramString4);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/pay/ea61d2/toPay", localHashMap, MinsuUPPayBean.class, parama);
  }
  
  public static void top50HosueList(Activity paramActivity, int paramInt1, int paramInt2, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", paramInt1 + "");
    localHashMap.put("limit", paramInt2 + "");
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/search/top50HouseList", localHashMap, true, parama);
  }
  
  public static void top50HosueListInit(Activity paramActivity, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.requestNoDES(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.e, "/searchInit/top50HouseListInit", localHashMap, true, parama);
  }
  
  public static void unCollectHouse(Activity paramActivity, String paramString, int paramInt, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseFid", paramString);
    localHashMap.put("rentWay", Integer.valueOf(paramInt));
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/customerColl/ea61d2/unCollectHouse", localHashMap, MinsuHouseCancelCollectResultBean.class, parama);
  }
  
  public static void unReadMsgNum(Activity paramActivity, i.a parama)
  {
    HashMap localHashMap = new HashMap();
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/im/ea61d2/unReadMsgNum", localHashMap, false, UnReadMsgNumBean.class, parama);
  }
  
  public static void updateContacts(Activity paramActivity, ContactVosBean paramContactVosBean, i.a<String> parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fid", paramContactVosBean.fid);
    localHashMap.put("conName", paramContactVosBean.conName);
    localHashMap.put("conTel", paramContactVosBean.conTel);
    localHashMap.put("cardType", Integer.valueOf(paramContactVosBean.cardType));
    localHashMap.put("cardValue", paramContactVosBean.cardValue);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/contact/ea61d2/updateContactV2", localHashMap, MinsuContactsUpdateResultBean.class, parama);
  }
  
  public static void updateLlInfo(Context paramContext, Map<String, String> paramMap, com.freelxl.baselibrary.d.c.a parama)
  {
    com.freelxl.baselibrary.d.a.post(com.ziroom.ziroomcustomer.minsu.b.d.f + "/personal/ea61d2/updateCustomerInfo").headers(d.getHeaderMap(paramContext)).params(d.signMethod(paramMap)).enqueue(parama);
  }
  
  public static void updateRoomNumAndRoomInfo(Activity paramActivity, String paramString1, String paramString2, Integer paramInteger, int paramInt, ArrayList<String> paramArrayList, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("houseBaseFid", paramString1);
    localHashMap.put("roomFid", paramString2);
    localHashMap.put("rentWay", paramInteger);
    localHashMap.put("rentRoomNum", Integer.valueOf(paramInt));
    localHashMap.put("delRoomFidList", paramArrayList);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/houseIssue/ea61d2/updateRoomNumAndRoomMsg", localHashMap, true, parama);
  }
  
  public static void uploadHousePic(final Activity paramActivity, String paramString1, final String paramString2, final String paramString3, final String paramString4, final String paramString5, final a parama)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        Object localObject1 = new HashMap();
        ((Map)localObject1).put("houseBaseFid", this.a);
        ((Map)localObject1).put("houseRoomFid", paramString2);
        ((Map)localObject1).put("picType", paramString3);
        Object localObject2 = new File(paramString4);
        Object localObject3;
        if ((localObject2 != null) && (((File)localObject2).exists()))
        {
          localObject1 = d.uploadFile("/house/ea61d2/saveHousePic", this.e, (Map)localObject1, paramString5, ((File)localObject2).getPath());
          localObject2 = com.freelxl.baselibrary.f.a.c.createEncryption("DES");
          localObject3 = ((com.freelxl.baselibrary.f.a.d)localObject2).decrypt((String)localObject1, SignKeyUtil.getIvKeyFromC(), SignKeyUtil.getKeyFromC());
          u.d("lanzhihong", "picInfo===" + (String)localObject3);
          if (!ae.notNull((String)localObject3)) {
            break label246;
          }
          localObject3 = (MinsuDelHousePicBean)com.alibaba.fastjson.a.parseObject((String)localObject3, MinsuDelHousePicBean.class);
          if ((!((MinsuDelHousePicBean)localObject3).checkSuccess(paramActivity)) || (parama == null) || (!ae.notNull(paramString4))) {
            break label229;
          }
          parama.onSuccess((MinsuDelHousePicBean)localObject3, paramString4);
        }
        for (;;)
        {
          com.freelxl.baselibrary.f.d.e("lanzhihong", "result===" + ((com.freelxl.baselibrary.f.a.d)localObject2).decrypt((String)localObject1, SignKeyUtil.getIvKeyFromC(), SignKeyUtil.getKeyFromC()));
          return;
          label229:
          parama.onError((MinsuDelHousePicBean)localObject3, paramString4);
          continue;
          label246:
          ((BaseActivity)paramActivity).dismissProgress();
          paramActivity.runOnUiThread(new Runnable()
          {
            public void run()
            {
              g.textToast(a.1.this.g, "图片上传失败");
            }
          });
        }
      }
    }).start();
  }
  
  public static void uploadImg(Context paramContext, File paramFile, int paramInt, com.freelxl.baselibrary.d.c.a parama)
  {
    Object localObject = new com.alibaba.fastjson.e();
    ((com.alibaba.fastjson.e)localObject).put("picType", Integer.valueOf(paramInt));
    localObject = d.signMethod(((com.alibaba.fastjson.e)localObject).toJSONString());
    com.freelxl.baselibrary.d.a.post(com.ziroom.ziroomcustomer.minsu.b.d.f + "/customer/ea61d2/customerIconAuth").headers(d.getHeaderMap(paramContext)).addFormDataPart("2y5QfvAy", (String)((Map)localObject).get("2y5QfvAy")).addFormDataPart("hPtJ39Xs", (String)((Map)localObject).get("hPtJ39Xs")).addFormDataPart("file", paramFile.getName(), "multipart/form-data", paramFile.getAbsolutePath()).enqueue(parama);
  }
  
  public static void uploadPicture(final Activity paramActivity, String paramString1, final String paramString2, final int paramInt, final String paramString3, final String paramString4, final b paramb)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        Object localObject = new HashMap();
        ((Map)localObject).put("houseBaseFid", this.a);
        ((Map)localObject).put("houseRoomFid", paramString2);
        ((Map)localObject).put("picType", paramInt + "");
        File localFile = new File(paramString3);
        if ((localFile != null) && (localFile.exists()))
        {
          localObject = d.uploadFile("/house/ea61d2/saveHousePic", this.e, (Map)localObject, paramString4, localFile.getPath());
          localObject = com.freelxl.baselibrary.f.a.c.createEncryption("DES").decrypt((String)localObject, SignKeyUtil.getIvKeyFromC(), SignKeyUtil.getKeyFromC());
          if (!ae.notNull((String)localObject)) {
            break label200;
          }
          localObject = (UploadResultBean)com.alibaba.fastjson.a.parseObject((String)localObject, UploadResultBean.class);
          if ((((UploadResultBean)localObject).checkSuccess(paramActivity)) && (paramb != null) && (ae.notNull(paramString3))) {
            paramb.onSuccess((UploadResultBean)localObject, paramString3);
          }
        }
        else
        {
          return;
        }
        paramb.onError((UploadResultBean)localObject, paramString3);
        return;
        label200:
        ((BaseActivity)paramActivity).dismissProgress();
        paramActivity.runOnUiThread(new Runnable()
        {
          public void run()
          {
            g.textToast(a.4.this.g, "图片上传失败");
          }
        });
      }
    }).start();
  }
  
  public static void uploadUserPic(Activity paramActivity, final String paramString, final a parama, final int paramInt)
  {
    if ((paramActivity == null) || (ae.isNull(paramString))) {
      return;
    }
    paramActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        new Thread(new Runnable()
        {
          public void run()
          {
            Object localObject = new HashMap();
            ((Map)localObject).put("token", d.getToken());
            ((Map)localObject).put("uid", d.getUid());
            ((Map)localObject).put("picType", a.2.this.b + "");
            File localFile = new File(a.2.this.c);
            if ((localFile != null) && (localFile.exists()))
            {
              localObject = d.uploadUserFile("/fileUpload/ea61d2/picUpload", this.a, (Map)localObject, a.2.this.c, localFile.getPath());
              localObject = com.freelxl.baselibrary.f.a.c.createEncryption("DES").decrypt((String)localObject, SignKeyUtil.getIvKeyFromC(), SignKeyUtil.getKeyFromC());
              com.freelxl.baselibrary.f.d.e("lanzhihong", "result===" + (String)localObject);
              if ((a.2.this.d != null) || (ae.notNull((String)localObject))) {
                a.2.this.d.onSuccess(null, (String)localObject);
              }
            }
          }
        }).start();
      }
    });
  }
  
  public static void validateSmsCode(Activity paramActivity, String paramString1, String paramString2, String paramString3, com.freelxl.baselibrary.d.c.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("smsCode", paramString2);
    localHashMap.put("phone", paramString1);
    localHashMap.put("areaCode", paramString3);
    d.request(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.f, "/personal/ea61d2/validateSmsCode", localHashMap, true, parama);
  }
  
  public static abstract interface a
  {
    public abstract void onError(MinsuDelHousePicBean paramMinsuDelHousePicBean, String paramString);
    
    public abstract void onSuccess(MinsuDelHousePicBean paramMinsuDelHousePicBean, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void onError(UploadResultBean paramUploadResultBean, String paramString);
    
    public abstract void onSuccess(UploadResultBean paramUploadResultBean, String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */