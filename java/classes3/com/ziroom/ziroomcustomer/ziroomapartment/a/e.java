package com.ziroom.ziroomcustomer.ziroomapartment.a;

import android.content.Context;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.freelxl.baselibrary.e.d;
import com.freelxl.baselibrary.e.h;
import com.freelxl.baselibrary.e.i.a;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomapartment.model.AppointmentModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillDetailModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillDetailModelV2;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuContractDetailModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuContractListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuCouponListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaHistoryDetailModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaluateGetModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuExchangeCouponModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuFirstProjectListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuHouseTypeListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuPayWayListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectDetailModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchCondition;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderDetailEntity;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Callback;

public class e
{
  public static void cancelZryuAppointList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.u);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void commitApply(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.a);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, AppointmentModel.class, parama).request();
  }
  
  public static void exchangeCoupon(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.B);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuExchangeCouponModel.class, parama).request();
  }
  
  public static void getBillDetail(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.C);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuBillDetailModel.class, parama).request();
  }
  
  public static void getBillDetailV2(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.y);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuBillDetailModelV2.class, parama).request();
  }
  
  public static void getContractBillList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.D);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuBillListModel.class, parama).request();
  }
  
  public static void getContractDetail(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.E);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuContractDetailModel.class, parama).request();
  }
  
  public static void getContractList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.F);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuContractListModel.class, parama).request();
  }
  
  public static void getCouponList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.A);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuCouponListModel.class, parama).request();
  }
  
  public static void getData(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.b);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, StationOrderDetailEntity.class, parama).request();
  }
  
  public static void getEvaHistoryDetail(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.r);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuEvaHistoryDetailModel.class, parama).request();
  }
  
  public static void getEvaluatePros(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.q);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuEvaluateGetModel.class, parama).request();
  }
  
  public static void getFirstProjectList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.o);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuFirstProjectListModel.class, parama).request();
  }
  
  public static void getHouseType(Context paramContext, i.a<String> parama, String paramString, boolean paramBoolean)
  {
    String str = q.E + f.g;
    h localh = new h(11, str);
    paramString = c.buildGetHouseType(paramContext, paramString);
    localh.setParams(paramString);
    u.d("ZryuService", "=========:" + str);
    u.d("ZryuService", "=========:" + paramString);
    new d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getHouseTypeList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.d);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuHouseTypeListModel.class, parama).request();
  }
  
  public static void getHouseTypeSearchCondition(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.m);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuSearchCondition.class, parama).request();
  }
  
  public static void getPayWayList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.G);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuPayWayListModel.class, parama).request();
  }
  
  public static void getPayWayListV2(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.z);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuPayWayListModel.class, parama).request();
  }
  
  public static void getProjectDetail(Context paramContext, i.a<String> parama, String paramString, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.e);
    HashMap localHashMap = new HashMap();
    localHashMap.put("projectId", paramString);
    paramString = b.convertor(paramContext, localHashMap);
    u.i("ZryuService", "map：" + com.alibaba.fastjson.a.toJSONString(paramString, new SerializerFeature[] { SerializerFeature.WriteMapNullValue }));
    localh.setParams(paramString);
    new d(paramContext, localh, paramBoolean, ZryuProjectDetailModel.class, parama).request();
  }
  
  public static void getProjectList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.f);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuProjectListModel.class, parama).request();
  }
  
  public static void getProjectListByConditionsV2(Context paramContext, Map<String, Object> paramMap, Callback paramCallback)
  {
    String str = q.E + f.x;
    paramMap = c.encryptPostObj(paramMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramMap).enqueue(paramCallback);
  }
  
  public static void getProjectListV2(Context paramContext, String paramString, Callback paramCallback)
  {
    String str = q.E + f.p;
    Map localMap = b.convertorStr(paramContext, new HashMap());
    localMap.put("cityCode", paramString);
    paramString = c.encryptPost(localMap);
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(paramString).enqueue(paramCallback);
  }
  
  public static void getProjectSearchCondition(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.k);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuSearchCondition.class, parama).request();
  }
  
  public static void getProjectSearchConditionV1(Context paramContext, Callback paramCallback)
  {
    String str = q.E + f.k;
    Map localMap = c.encryptPost(b.convertorStr(paramContext, new HashMap()));
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(localMap).enqueue(paramCallback);
  }
  
  public static void getRoom(Context paramContext, i.a<String> parama, String paramString1, String paramString2, Double paramDouble1, Double paramDouble2, Double paramDouble3, Double paramDouble4, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str = q.E + f.h;
    h localh = new h(11, str);
    paramString1 = c.buildGetRoom(paramContext, paramString1, paramString2, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramString3, paramString4, paramString5, paramInt1, paramInt2);
    localh.setParams(paramString1);
    u.d("ZryuService", "=========:" + str);
    u.d("ZryuService", "=========:" + paramString1);
    new d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getRoomSearchCondition(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.n);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, ZryuSearchCondition.class, parama).request();
  }
  
  public static void getSearchConditionsV2(Context paramContext, Callback paramCallback)
  {
    String str = q.E + f.w;
    Map localMap = c.encryptPost(b.convertorStr(paramContext, new HashMap()));
    com.freelxl.baselibrary.d.a.post(str).tag(paramContext).params(localMap).enqueue(paramCallback);
  }
  
  public static void getWillPayList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.I);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getZryuAppointList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.t);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getZryuUnEvaAppointList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.v);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void payOrder(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.H);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void submitEvaluatePros(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(11, q.E + f.s);
    localh.setParams(paramMap);
    new d(paramContext, localh, paramBoolean, com.freelxl.baselibrary.b.b.class, parama).request();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */