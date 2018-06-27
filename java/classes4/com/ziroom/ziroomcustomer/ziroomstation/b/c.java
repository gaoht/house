package com.ziroom.ziroomcustomer.ziroomstation.b;

import android.content.Context;
import com.freelxl.baselibrary.e.h;
import com.freelxl.baselibrary.e.i.a;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.ziroomstation.model.EvaluateResultModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.GetEvaluateInfoModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.HeaderImgModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoLabelListModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoPaySuccTextModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoSchemeModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoSelectedPeopleModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoToPayResultModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.OrderCreateResult;
import com.ziroom.ziroomcustomer.ziroomstation.model.OrderMoneyDetails;
import com.ziroom.ziroomcustomer.ziroomstation.model.ProjectDetailDto;
import com.ziroom.ziroomcustomer.ziroomstation.model.ReFundWayModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationBaseData;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationBookOrder;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationCoupon;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationListModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderDetailEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderListModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationRoom;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationRoomPassword;
import com.ziroom.ziroomcustomer.ziroomstation.model.UploadPicResultModel;
import java.util.Map;

public class c
{
  public static void applyRefund(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.o);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, a.class, parama).request();
  }
  
  public static void cancelOrder(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.m);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, a.class, parama).request();
  }
  
  public static void getBaseData(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.a);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, StationBaseData.class, parama).request();
  }
  
  public static void getEvaluateInfo(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(1, q.U + d.y);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, GetEvaluateInfoModel.class, parama).request();
  }
  
  public static void getEvaluateInfoParseDataBySelf(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(1, q.U + d.y);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void getHeaderImg(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.c);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, HeaderImgModel.class, parama).request();
  }
  
  public static void getOrderDetail(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.d);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, StationOrderDetailEntity.class, parama).request();
  }
  
  public static void getOrderMoney(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.M);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, OrderMoneyDetails.class, parama).request();
  }
  
  public static void getProjectInfo(Context paramContext, String paramString, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.f);
    localh.setParams(b.buildProjectInfo(paramContext, paramString));
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, ProjectDetailDto.class, parama).request();
  }
  
  public static void getRefundWayInfo(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.b);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, ReFundWayModel.class, parama).request();
  }
  
  public static void getStationBookOrderInfo(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.K);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, StationBookOrder.class, parama).request();
  }
  
  public static void getStationList(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.h);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, StationListModel.class, parama).request();
  }
  
  public static void getStationOrderDetailPassword(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.k);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, StationRoomPassword.class, parama).request();
  }
  
  public static void getStationOrderList(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.g);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, StationOrderListModel.class, parama).request();
  }
  
  public static void getStationRoomList(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.e);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, StationRoom.class, parama).request();
  }
  
  public static void getStationTickets(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.i);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, StationCoupon.class, parama).request();
  }
  
  public static void getStationUnEvaluateOrderList(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.p);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, StationOrderListModel.class, parama).request();
  }
  
  public static void getStationUnPayOrderList(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.q);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, StationOrderListModel.class, parama).request();
  }
  
  public static void getUserInfo(Context paramContext, String paramString, com.freelxl.baselibrary.d.c.a parama)
  {
    paramContext = b.buildGroupChatUserInfo(paramContext, paramString);
    com.freelxl.baselibrary.d.a.post(q.B + d.J).params(paramContext).enqueue(parama);
  }
  
  public static void getZraEvaluate(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, i.a<String> parama, boolean paramBoolean)
  {
    paramString = b.buildGetZraEvaluate(paramString, paramInt1, paramInt2, paramInt3);
    h localh = new h(1, q.U + d.A);
    localh.setParams(paramString);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void intoClear(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.r);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, com.freelxl.baselibrary.b.b.class, parama).request();
  }
  
  public static void intoGetLabelList(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.w);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, IntoLabelListModel.class, parama).request();
  }
  
  public static void intoGetSelectedBeds(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.x);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, IntoSelectedPeopleModel.class, parama).request();
  }
  
  public static void intoLockingBed(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.s);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, com.freelxl.baselibrary.b.b.class, parama).request();
  }
  
  public static void intoPayCash(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.t);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, IntoToPayResultModel.class, parama).request();
  }
  
  public static void intoPaySuccessText(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.v);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, IntoPaySuccTextModel.class, parama).request();
  }
  
  public static void intoScheme(Context paramContext, i.a<String> parama, Map<String, Object> paramMap, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.u);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, IntoSchemeModel.class, parama).request();
  }
  
  public static void payOrder(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.l);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, null, parama).request();
  }
  
  public static void putEvaluateInfo(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(1, q.U + d.z);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, EvaluateResultModel.class, parama).request();
  }
  
  public static void putEvaluatedSucc(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.D);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, com.freelxl.baselibrary.b.b.class, parama).request();
  }
  
  public static void redeTicket(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.n);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, a.class, parama).request();
  }
  
  public static void submitStationOrder(Context paramContext, Map<String, Object> paramMap, i.a<String> parama, boolean paramBoolean)
  {
    h localh = new h(9, q.T + d.j);
    localh.setParams(paramMap);
    new com.freelxl.baselibrary.e.d(paramContext, localh, paramBoolean, OrderCreateResult.class, parama).request();
  }
  
  public static void uploadPic(Context paramContext, byte[] paramArrayOfByte, Map<String, Object> paramMap, String paramString, i.a<String> parama, boolean paramBoolean)
  {
    new com.ziroom.ziroomcustomer.ziroomstation.utils.c(paramContext, paramBoolean, UploadPicResultModel.class, parama, q.T + d.B, paramString, paramMap, null, paramArrayOfByte).request();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */