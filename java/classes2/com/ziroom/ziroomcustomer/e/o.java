package com.ziroom.ziroomcustomer.e;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.freelxl.baselibrary.e.h;
import com.freelxl.baselibrary.e.i.a;
import com.ziroom.ziroomcustomer.model.CleanDailyService;
import com.ziroom.ziroomcustomer.model.CleanInfo;
import com.ziroom.ziroomcustomer.model.CleanPriceItem;
import com.ziroom.ziroomcustomer.model.CleanPriceSheet;
import com.ziroom.ziroomcustomer.model.CleanScoreItem;
import com.ziroom.ziroomcustomer.model.CleanScoreResult;
import com.ziroom.ziroomcustomer.model.CleanServiceBookTime;
import com.ziroom.ziroomcustomer.model.DialyCleanMsg;
import com.ziroom.ziroomcustomer.model.OrderDate;
import com.ziroom.ziroomcustomer.model.OrderInfo;
import com.ziroom.ziroomcustomer.model.RepairProgress;
import com.ziroom.ziroomcustomer.model.RepairRecord;
import com.ziroom.ziroomcustomer.model.RepairScore;
import com.ziroom.ziroomcustomer.model.RepairWork;
import com.ziroom.ziroomcustomer.model.Server;
import com.ziroom.ziroomcustomer.newServiceList.model.aa;
import com.ziroom.ziroomcustomer.newServiceList.model.ab;
import com.ziroom.ziroomcustomer.newServiceList.model.ae;
import com.ziroom.ziroomcustomer.newServiceList.model.av;
import com.ziroom.ziroomcustomer.newServiceList.model.ax;
import com.ziroom.ziroomcustomer.newServiceList.model.be;
import com.ziroom.ziroomcustomer.newServiceList.model.bk;
import com.ziroom.ziroomcustomer.newServiceList.model.bm;
import com.ziroom.ziroomcustomer.newServiceList.model.bn;
import com.ziroom.ziroomcustomer.newServiceList.model.bo;
import com.ziroom.ziroomcustomer.newServiceList.model.e;
import com.ziroom.ziroomcustomer.newServiceList.model.n;
import com.ziroom.ziroomcustomer.newServiceList.model.y;
import com.ziroom.ziroomcustomer.newServiceList.model.z;
import com.ziroom.ziroomcustomer.newchat.chatcenter.f;
import com.ziroom.ziroomcustomer.newchat.chatcenter.i;
import com.ziroom.ziroomcustomer.newclean.d.ai;
import com.ziroom.ziroomcustomer.newclean.d.aj;
import com.ziroom.ziroomcustomer.newclean.d.am;
import com.ziroom.ziroomcustomer.newclean.d.as;
import com.ziroom.ziroomcustomer.newclean.d.at;
import com.ziroom.ziroomcustomer.newclean.d.bp;
import com.ziroom.ziroomcustomer.newclean.d.bq;
import com.ziroom.ziroomcustomer.newclean.d.br;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHCapacity;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHCommitInfo;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHCostEstimates;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHCreateOrderResult;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHDicTag;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHFloorsFee;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHMoveDate;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHOrderDetail;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHServiceBookTime;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHSuccessHint;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHSysTime;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHTool;
import com.ziroom.ziroomcustomer.newrepair.b.w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class o
{
  public static final ExecutorService a = Executors.newFixedThreadPool(5);
  
  public static void MHCostEstimates(Context paramContext, Handler paramHandler, String paramString1, String paramString2, double paramDouble1, long paramLong1, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7)
  {
    b.getMHObject(paramContext, paramHandler, m.buildMHCostEstimates(paramString1, paramString2, paramDouble1, paramLong1, paramString3, paramString4, paramString5, paramString6, paramLong2, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, paramContext), q.j + "zrk/move/orderCostEstimates", 8215, MHCostEstimates.class);
  }
  
  public static void MHCreateOrder(Context paramContext, Handler paramHandler, MHCommitInfo paramMHCommitInfo, String paramString1, String paramString2, String paramString3)
  {
    b.getMHObject(paramContext, paramHandler, m.buildMHCreateOrder(paramMHCommitInfo, paramString1, paramString2, paramString3, paramContext), q.j + "zrk/move/createOrder", 8216, MHCreateOrderResult.class);
  }
  
  public static void ReviseOrder(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    b.getPostServiceDiver(paramContext, paramHandler, m.buildReviseOrder(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6), q.i + p.f.z, 69762);
  }
  
  public static void addNewMHEstimate(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    b.getMHStatus(paramContext, paramHandler, m.buildMHAddEstimate(paramString1, paramString2, paramString3, paramString4, paramMap1, paramMap2, com.ziroom.ziroomcustomer.base.b.d, System.currentTimeMillis()), q.j + p.d.e, 8225);
  }
  
  public static void cancelNewMHOrder(Context paramContext, Handler paramHandler, Map<String, String> paramMap, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    b.getMHStatus(paramContext, paramHandler, m.buildMHCancelOrder(paramMap, paramString1, paramString2, paramString3, paramLong), q.j + p.d.d, 8224);
  }
  
  public static void changeClean(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, OrderDate paramOrderDate1, OrderDate paramOrderDate2, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    b.getPostServiceDiver(paramContext, paramHandler, m.buildChangeClean(paramString1, paramString2, paramString3, paramString4, paramOrderDate1, paramOrderDate2, paramInt1, paramInt2, paramInt3, paramString5, paramString6), q.i + p.b.d, 4115);
  }
  
  public static void checkCapacity(Context paramContext, Handler paramHandler, String paramString1, Long paramLong1, Long paramLong2, Long paramLong3, String paramString2)
  {
    b.getMHObject(paramContext, paramHandler, m.buildMHCapacity(paramString1, paramLong1, paramLong2, paramLong3, paramString2), q.j + p.d.g, 8211, MHCapacity.class);
  }
  
  public static void finishAcceptance(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getMHStatus(paramContext, paramHandler, m.buildFinishAcceptance(paramString), q.j + p.d.j, 8242);
  }
  
  public static void getAcceptConfirm(Context paramContext, Handler paramHandler, String paramString1, Long paramLong, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    b.getPostRepairAcceptConfirm(paramContext, paramHandler, m.buildGetAcceptConfirm(paramString1, paramLong, paramString2, paramInt, paramString3, paramString4), q.m + p.f.i, 69969);
  }
  
  public static void getChatNums(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getPostTestService(paramContext, paramHandler, m.buildChatNums(paramString), q.k + p.b.aT, 69969);
  }
  
  public static void getCleanDataTime(Context paramContext, Handler paramHandler, String paramString1, String paramString2)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildCleanDataTime(paramString1, paramString2), q.j + p.b.ak, 69957, com.ziroom.ziroomcustomer.newclean.d.u.class);
  }
  
  public static void getCleanList(Context paramContext, Handler paramHandler, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    b.getPostServiceList(paramContext, paramHandler, m.buildGetCleanList(paramString1, paramString3, paramString2, paramInt1, paramInt2), q.i + p.b.b, 4113, CleanInfo.class);
  }
  
  public static void getCleanScore(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getGetServiceObject(paramContext, paramHandler, String.format(q.a + p.b.g, new Object[] { paramString }), 4118, CleanScoreResult.class);
  }
  
  public static void getCleanScoreItem(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getGetServiceList(paramContext, paramHandler, String.format(q.i + p.b.e, new Object[] { paramString, com.ziroom.ziroomcustomer.base.b.d }), 4116, CleanScoreItem.class);
  }
  
  public static void getCleanServicePriceItem(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getPostServiceList(paramContext, paramHandler, m.buildCleanServicePriceItem(paramString), q.i + p.b.j, 69641, CleanPriceItem.class);
  }
  
  public static void getCleanServicePriceSheet(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getPostServiceObject(paramContext, paramHandler, m.buildCleanServicePriceSheet(paramString), q.i + p.b.k, 69895, CleanPriceSheet.class);
  }
  
  public static void getCleanServices(Context paramContext, Handler paramHandler)
  {
    b.getPostServiceList(paramContext, paramHandler, m.buildServiceList("tybj"), q.i + p.b.i, 69639, CleanDailyService.class);
  }
  
  public static void getCleanServicesTime(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    b.getPostServiceList(paramContext, paramHandler, m.buildCleanServicesTime(paramString1, paramString2, paramString3), q.i + p.b.l, 69670, CleanServiceBookTime.class);
  }
  
  public static void getDialyCleanDetail(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getPostServiceObject(paramContext, paramHandler, m.buildDialyMsg(paramString), q.i + p.b.o, 69648, DialyCleanMsg.class);
  }
  
  public static void getDicTag(Context paramContext, Handler paramHandler, String paramString, long paramLong)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildMHDicTag(paramString, paramLong), q.j + "zrk/commons/dicTag", 8212, MHDicTag.class);
  }
  
  public static void getDicTag(Context paramContext, Handler paramHandler, String paramString, long paramLong, int paramInt)
  {
    b.getMHZeroList(paramContext, paramHandler, m.buildMHDicTag(paramString, paramLong), q.j + "zrk/commons/dicTag", paramInt, MHDicTag.class);
  }
  
  public static void getExterRepairCancleOrder(Context paramContext, Handler paramHandler, String paramString1, Long paramLong, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    b.getPostRepairCancle(paramContext, paramHandler, m.buildGetExterRepairCancleOrder(paramString1, paramLong, paramString2, paramInt, paramString3, paramString4, paramString5, paramString6, paramString7), q.m + p.f.e, 69960);
  }
  
  public static void getExternalRepairCancleDicTag(Context paramContext, Handler paramHandler, String paramString1, Long paramLong, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    b.getPostRepairCancleTag(paramContext, paramHandler, m.buildGetExterRepairOrderTag(paramString1, paramLong, paramString2, paramInt, paramString3, paramString4), q.m + p.f.f, 8212);
  }
  
  public static void getFourDicTag(Context paramContext, Handler paramHandler, String paramString, long paramLong)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildMHDicTag(paramString, paramLong), q.j + "zrk/commons/dicTag", 8342, MHDicTag.class);
  }
  
  public static void getGeneralTimePoint(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildGeneralTimePoint(paramString), q.j + p.b.ah, 69921, String.class);
  }
  
  public static void getGuideList(Context paramContext, Handler paramHandler)
  {
    b.getGetServiceObject(paramContext, paramHandler, String.format(q.a + p.g.b, new Object[0]), 65609, Server.class);
  }
  
  public static void getHotQuestions(Context paramContext, Handler paramHandler, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = m.buildHotQuestions(paramString1, paramString2, paramInt);
    com.ziroom.ziroomcustomer.util.u.e("dsjgkdj", com.alibaba.fastjson.a.toJSONString(paramString1));
    b.getPostTestServiceList(paramContext, paramHandler, paramString1, q.k + p.b.aO, 69958, i.class);
  }
  
  public static void getHotQuestions_2(Context paramContext, Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    paramString = m.buildHotQuestions_2(paramString, paramInt1, paramInt2);
    com.ziroom.ziroomcustomer.util.u.e("dsjgkdj", com.alibaba.fastjson.a.toJSONString(paramString));
    b.getPostTestServiceList(paramContext, paramHandler, paramString, q.k + p.b.bi, 69958, i.class);
  }
  
  public static void getMHFloorsFeeList(Handler paramHandler, Context paramContext, String paramString)
  {
    b.getMHZeroList(paramContext, paramHandler, m.buildMHFloorsFeeList(paramString), q.j + p.d.h, 8344, MHFloorsFee.class);
  }
  
  public static void getMHOrderDetail(Context paramContext, Handler paramHandler, Long paramLong, String paramString)
  {
    b.getMHObject(paramContext, paramHandler, m.buildMHOrderDetail(paramLong, paramString), q.j + "zrk/move/workOrderDetail", 8217, MHOrderDetail.class);
  }
  
  public static void getMHServicesTime(Context paramContext, Handler paramHandler, String paramString1, String paramString2)
  {
    b.getMHZeroList(paramContext, paramHandler, m.buildMHServiceTime(paramString1, paramString2), q.j + p.d.c, 8209, MHServiceBookTime.class);
  }
  
  public static void getMHSuccessHint(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    b.getMHZeroList(paramContext, paramHandler, m.buildMHSuccessHint(paramString1, paramString2, paramString3), q.j + p.d.k, 8221, MHSuccessHint.class);
  }
  
  public static void getMHToolList(Context paramContext, Handler paramHandler, String paramString1, String paramString2, int paramInt)
  {
    b.getMHZeroList(paramContext, paramHandler, m.buildMHToolList(paramString1, paramString2, paramInt), q.j + "zrk/commons/goods", 8213, MHTool.class);
  }
  
  public static void getMoveDateList(Context paramContext, Handler paramHandler)
  {
    b.getMHObject(paramContext, paramHandler, new HashMap(), q.j + p.d.i, 8241, MHMoveDate.class);
  }
  
  public static void getMySuggestions(Context paramContext, Handler paramHandler, String paramString)
  {
    paramString = m.buildMySuggests(paramString);
    com.ziroom.ziroomcustomer.util.u.e("sdjsg", com.alibaba.fastjson.a.toJSONString(paramString));
    b.getPostTestServiceList(paramContext, paramHandler, paramString, q.k + p.b.aS, 69968, com.ziroom.ziroomcustomer.newchat.chatcenter.l.class);
  }
  
  public static void getNetPhone(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getPostTestServiceList(paramContext, paramHandler, m.buildNetPhone(paramString), q.k + p.b.aV, 69970, f.class);
  }
  
  public static void getNewCleanCapacity(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    b.getDesPostServiceDiver(paramContext, paramHandler, m.buildNewCleanCapacity(paramContext, paramString1, paramString2, paramString3), q.j + p.b.w, 69765);
  }
  
  public static void getNewCleanCostEstimates(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, int paramInt, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, List<com.ziroom.ziroomcustomer.newclean.d.x> paramList, String paramString20)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewCleanCostEstimates(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramInt, paramString13, paramString14, paramString15, paramString16, paramString17, paramString18, paramString19, paramList, paramString20), q.j + p.b.A, 69768, com.ziroom.ziroomcustomer.newclean.d.t.class);
  }
  
  public static void getNewCleanGoods(Context paramContext, Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildNewCleanGoods(paramContext, paramString, paramInt1, paramInt2), q.j + p.b.x, 69765, com.ziroom.ziroomcustomer.newclean.d.ac.class);
  }
  
  public static void getNewComplainDetail(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewComplainDetail(paramContext, paramString), q.j + p.b.U, 69894, e.class);
  }
  
  public static void getNewComplainHistoryList(Context paramContext, Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildNewComplainHistoryList(paramContext, paramString, paramInt1, paramInt2), q.j + p.b.T, 69893, com.ziroom.ziroomcustomer.newServiceList.model.d.class);
  }
  
  public static void getNewComplainOngingList(Context paramContext, Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildNewComplainOngingList(paramContext, paramString, paramInt1, paramInt2), q.j + p.b.S, 69892, com.ziroom.ziroomcustomer.newServiceList.model.d.class);
  }
  
  public static void getNewCoupon(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, com.freelxl.baselibrary.d.c.a parama)
  {
    paramString1 = m.buildNewCoupon(paramContext, paramString1, paramString2, paramString3, paramString4);
    com.freelxl.baselibrary.d.a.post(q.j + p.b.z).tag(paramContext).params(paramString1).enqueue(parama);
  }
  
  public static void getNewCouponList(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, com.freelxl.baselibrary.d.c.a parama)
  {
    paramString1 = m.buildNewCouponList(paramContext, paramString1, paramString2, paramInt1, paramInt2);
    com.freelxl.baselibrary.d.a.post(q.j + p.b.y).tag(paramContext).params(paramString1).enqueue(parama);
  }
  
  public static void getNewCreateGOrder(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, double paramDouble, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt, List<com.ziroom.ziroomcustomer.newclean.d.x> paramList, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewCreateGOrder(paramContext, paramString1, paramString2, paramString3, paramString4, paramDouble, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramInt, paramList, paramString11, paramString12, paramString13, paramString14), q.j + p.b.P, 69889, at.class);
  }
  
  public static void getNewDialyCleanTimePeriod(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildNewDialyCleanTimePeriod(paramString), q.j + p.b.Y, 69906, com.ziroom.ziroomcustomer.newclean.d.bl.class);
  }
  
  public static void getNewGeneralAAddList(Context paramContext, Handler paramHandler, String paramString1, String paramString2, double paramDouble1, String paramString3, double paramDouble2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewGeneralAAddList(paramContext, paramString1, paramString2, paramDouble1, paramString3, paramDouble2, paramString4, paramString5, paramString6, paramString7, paramString8), q.j + p.b.N, 69785, com.ziroom.ziroomcustomer.newclean.d.bg.class);
  }
  
  public static void getNewGeneralAList(Context paramContext, Handler paramHandler, int paramInt1, int paramInt2, String paramString)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildNewGeneralAList(paramContext, paramInt1, paramInt2, paramString), q.j + p.b.M, 69784, com.ziroom.ziroomcustomer.newclean.d.c.class);
  }
  
  public static void getNewGeneralAModifyList(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    b.getDesPostServiceDiver(paramContext, paramHandler, m.buildNewGeneralAModifyList(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9), q.j + p.b.O, 69888);
  }
  
  public static void getNewGeneralCancle(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    b.getDesPostServiceDiver(paramContext, paramHandler, m.buildNewGeneralCancle(paramContext, paramString1, paramString2, paramString3), q.j + p.b.X, 69905);
  }
  
  public static void getNewGeneralCancleView(Context paramContext, Handler paramHandler, String paramString1, String paramString2)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewGeneralCancleView(paramContext, paramString1, paramString2), q.j + p.b.W, 69904, com.ziroom.ziroomcustomer.newServiceList.model.l.class);
  }
  
  public static void getNewGeneralDetail(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewGeneralDetail(paramContext, paramString), q.j + p.b.Q, 69890, as.class);
  }
  
  public static void getNewGeneralInfo(Context paramContext, Handler paramHandler, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildNewGeneralInfo(paramContext, paramString, paramInt1, paramInt2, paramInt3), q.j + p.b.R, 69891, com.ziroom.ziroomcustomer.newServiceList.model.o.class);
  }
  
  public static void getNewGeneralList(Context paramContext, Handler paramHandler, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildNewGeneralList(paramContext, paramString, paramInt1, paramInt2, paramInt3), q.j + p.b.I, 69781, com.ziroom.ziroomcustomer.newServiceList.model.p.class);
  }
  
  public static void getNewGeneralWorkerInfo(Context paramContext, Handler paramHandler, String paramString1, String paramString2)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewGeneralWorkerInfo(paramContext, paramString1, paramString2), q.j + p.b.V, 69897, bo.class);
  }
  
  public static void getNewMHHistoryList(Context paramContext, Handler paramHandler, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    b.getMHZeroList(paramContext, paramHandler, m.buildNewMHHistoryList(paramContext, paramString1, paramString2, paramInt1, paramInt2), q.j + p.c.o, 69779, com.ziroom.ziroomcustomer.newServiceList.model.r.class);
  }
  
  public static void getNewMHSysDate(Context paramContext, Handler paramHandler)
  {
    b.getMHObject(paramContext, paramHandler, m.buildMHGetSysDate(), q.j + p.d.b, 8210, MHSysTime.class);
  }
  
  public static void getNewRentDetail(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewRentDetail(paramContext, paramString), q.j + p.b.G, 69778, com.ziroom.ziroomcustomer.newServiceList.model.x.class);
  }
  
  public static void getNewRentHistoryList(Context paramContext, Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildNewRentHistoryList(paramContext, paramString, paramInt1, paramInt2), q.j + p.b.F, 69777, aa.class);
  }
  
  public static void getNewRentInfo(Context paramContext, Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildNewRentInfo(paramContext, paramString, paramInt1, paramInt2), q.j + p.b.H, 69780, z.class);
  }
  
  public static void getNewRentOngoingList(Context paramContext, Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildNewRentOngoingList(paramContext, paramString, paramInt1, paramInt2), q.j + p.b.E, 69778, aa.class);
  }
  
  public static void getNewRepairDetail(Context paramContext, Handler paramHandler, String paramString1, Long paramLong, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = m.buildGetRepairListDetail(paramString1, paramLong, paramString2, paramInt, paramString3, paramString4, paramString5);
    com.ziroom.ziroomcustomer.util.u.d("sjdk", "=====  " + com.alibaba.fastjson.a.toJSONString(paramString1));
    paramLong = new HashMap();
    paramInt = 0;
    if ("1".equals(paramString5))
    {
      paramInt = 69958;
      paramString2 = q.i + p.f.b;
      paramLong.put("json", com.alibaba.fastjson.a.toJSONString(paramString1));
      paramLong.put("versionNumberStr", "1.0.0");
      paramString1 = paramString2;
    }
    for (;;)
    {
      b.getPostRepairListDetail(paramContext, paramHandler, paramLong, paramString1, paramInt);
      return;
      if ("2".equals(paramString5))
      {
        paramInt = 69959;
        paramString2 = q.m + p.f.d;
        paramLong = paramString1;
        paramString1 = paramString2;
      }
      else
      {
        paramString1 = "";
      }
    }
  }
  
  public static void getNewRepairEvalInfo(Context paramContext, Handler paramHandler, String paramString1, Long paramLong, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    b.getPostRepairEvalInfo(paramContext, paramHandler, m.buildGetEvalInfo(paramString1, paramLong, paramString2, paramInt, paramString3, paramString4, paramString5), q.m + p.f.g, 69961);
  }
  
  public static void getNewSOrderInfo(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewSOrderInfo(paramContext, paramString1, paramString2, paramString3), q.j + p.b.K, 69783, am.class);
  }
  
  public static void getNewSOrderNums(Context paramContext, Handler paramHandler, List<String> paramList, String paramString1, String paramString2)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewSOrderNums(paramContext, paramList, paramString1, paramString2), q.j + p.b.J, 69782, aj.class);
  }
  
  public static void getNewTimeP(Context paramContext, Handler paramHandler, int paramInt1, int paramInt2, String paramString)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildNewTimeP(paramContext, paramInt1, paramInt2, paramString), q.j + p.b.L, 69896, ai.class);
  }
  
  public static void getNewWeekCleanDetail(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewWeekCleanDetail(paramString), q.j + p.b.ac, 69911, com.ziroom.ziroomcustomer.newServiceList.model.t.class);
  }
  
  public static void getNewWeekCleanTimeInfo(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, long paramLong, int paramInt2, String paramString5)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewWeekCleanTimeInfo(paramString1, paramString2, paramString3, paramString4, paramInt1, paramLong, paramInt2, paramString5), q.j + p.b.aa, 69909, bq.class);
  }
  
  public static void getNewWeekCleanTimePeriod(Context paramContext, Handler paramHandler, String paramString1, String paramString2)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewWeekCleanTimePeriod(paramString1, paramString2), q.j + p.b.Z, 69908, br.class);
  }
  
  public static void getNewWeekCleanerInfo(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewWeekCleanerInfo(paramString), q.j + p.b.ae, 69912, bn.class);
  }
  
  public static void getNewWeekEvaluateInfo(Context paramContext, Handler paramHandler, String paramString1, String paramString2)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewWeekEvaluateInfo(paramString1, paramString2), q.j + p.b.ad, 69922, com.ziroom.ziroomcustomer.newServiceList.model.bl.class);
  }
  
  public static void getNewWeekFollowInfo(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildNewWeekFollowInfo(paramString), q.j + p.b.af, 69913, bm.class);
  }
  
  public static void getNewWeekHistoryList(Context paramContext, Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildNewWeekHistoryList(paramContext, paramString, paramInt1, paramInt2), q.j + p.b.B, 69769, bk.class);
  }
  
  public static void getNewWeekOngoingList(Context paramContext, Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildNewWeekOngoingList(paramContext, paramString, paramInt1, paramInt2), q.j + p.b.C, 69776, bk.class);
  }
  
  public static void getRentListInfo(Context paramContext, Handler paramHandler, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramString = m.buildgetRentList(paramString, paramInt1, paramInt2, paramInt3);
    b.getRasGetService(paramContext, paramHandler, q.k + p.e.a + paramString, 69952, ab.class, 1);
  }
  
  public static void getRentNewDetailInfo(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getRasGetService(paramContext, paramHandler, q.k + p.e.b + paramString, 69953, com.ziroom.ziroomcustomer.newServiceList.model.ac.class, 0);
  }
  
  public static void getRentStarTag(Context paramContext, Handler paramHandler, int paramInt)
  {
    b.getRasGetService(paramContext, paramHandler, q.k + p.e.c + paramInt, 69955, y.class, 0);
  }
  
  public static void getRepairArticle(Context paramContext, Handler paramHandler, String paramString1, String paramString2)
  {
    b.getPostServiceList(paramContext, paramHandler, m.buildGetRepairArticle(paramString1, paramString2), q.i + p.f.w, 4199, com.ziroom.ziroomcustomer.newrepair.b.p.class);
  }
  
  public static void getRepairBannerPic(Context paramContext, String paramString, i.a<String> parama, boolean paramBoolean)
  {
    new com.freelxl.baselibrary.e.d(paramContext, new h(0, "http://horehd.ziroom.com/resource/carousel"), paramBoolean, ae.class, parama).request();
  }
  
  public static void getRepairCapacity(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    b.getRepairTime(paramContext, paramHandler, m.buildGetRepairCapacity(paramString1, paramString2, paramString3, paramInt), q.i + p.f.r, 4134);
  }
  
  public static void getRepairEngineer(Context paramContext, Handler paramHandler)
  {
    b.getPostServiceList(paramContext, paramHandler, m.buildGetRepairEngineer(), q.i + p.f.y, 4201, com.ziroom.ziroomcustomer.newrepair.b.q.class);
  }
  
  public static void getRepairList(Context paramContext, Handler paramHandler, String paramString1, Long paramLong, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b.getPostRepairList(paramContext, paramHandler, m.buildGetRepairList(paramString1, paramLong, paramString2, paramInt1, paramInt2, paramInt3, paramInt4), q.m + p.f.c, 4120);
  }
  
  public static void getRepairPlace(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getPostServiceList(paramContext, paramHandler, m.buildGetKJZTXM(paramString), q.i + p.f.u, 4197, com.ziroom.ziroomcustomer.newrepair.b.r.class);
  }
  
  public static void getRepairProgress(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getPostServiceList(paramContext, paramHandler, m.buildGetRepairProgress(paramString), q.i + p.f.j, 4121, RepairProgress.class);
  }
  
  public static void getRepairReason(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getPostServiceList(paramContext, paramHandler, m.buildGetRepairReason(paramString), q.i + p.f.x, 4200, com.ziroom.ziroomcustomer.newrepair.b.t.class);
  }
  
  public static void getRepairRecord(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getPostServiceList(paramContext, paramHandler, m.buildGetRepairRecord(paramString), q.i + p.f.k, 4128, RepairRecord.class);
  }
  
  public static void getRepairScore(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getPostServiceList(paramContext, paramHandler, m.buildGetRepairScore(paramString), q.i + p.f.p, 4132, RepairScore.class);
  }
  
  public static void getRepairScoreItem(Context paramContext, Handler paramHandler)
  {
    b.getRepairScoreItem(paramContext, paramHandler, q.i + p.f.n + "?city_code" + com.ziroom.ziroomcustomer.base.b.d, 4130, RepairScore.class);
  }
  
  public static void getRepairTime(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getRepairTime(paramContext, paramHandler, m.buildGetRepairTime(paramString), q.i + p.f.q, 4133);
  }
  
  public static void getRepairType(Context paramContext, Handler paramHandler, String paramString)
  {
    b.getPostServiceList(paramContext, paramHandler, m.buildGetRepairType(paramString), q.i + p.f.v, 4198, w.class);
  }
  
  public static void getSecondDicTag(Context paramContext, Handler paramHandler, String paramString, long paramLong)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildMHDicTag(paramString, paramLong), q.j + "zrk/commons/dicTag", 8340, MHDicTag.class);
  }
  
  public static void getServeCarouselPic(Context paramContext, String paramString, i.a<String> parama, boolean paramBoolean)
  {
    paramString = m.buildServeCarouselPic("1", paramString);
    new com.freelxl.baselibrary.e.d(paramContext, new h(0, "http://interfaces.ziroom.com/?_p=api_mobile&_a=getLunBoDatas" + paramString), paramBoolean, av.class, parama).request();
  }
  
  public static void getServicePageImage(Context paramContext, Handler paramHandler)
  {
    b.getPostServiceList(paramContext, paramHandler, m.buildUid(), q.a + p.g.a, 4104, ax.class);
  }
  
  public static void getServicePeopleImage(Context paramContext, Handler paramHandler)
  {
    b.getPostServiceList(paramContext, paramHandler, m.buildServicePeopleImage(), "http://interfaces.ziroom.com/" + p.g.f, 69907, be.class);
  }
  
  public static void getSubmitTag(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildSubmitTag(paramString1, paramString2, paramString3), q.j + p.b.aj, 69924, com.ziroom.ziroomcustomer.newServiceList.model.bg.class);
  }
  
  public static void getSysDate(Context paramContext, Handler paramHandler)
  {
    b.getGetServiceString(paramContext, paramHandler, String.format(q.i + p.g.c + "?city_code=" + com.ziroom.ziroomcustomer.base.b.d, new Object[0]), 65608);
  }
  
  public static void getThirdDicTag(Context paramContext, Handler paramHandler, String paramString, long paramLong)
  {
    b.getDesPostServiceList(paramContext, paramHandler, m.buildMHDicTag(paramString, paramLong), q.j + "zrk/commons/dicTag", 8341, MHDicTag.class);
  }
  
  public static void lockRepairCapacity(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, String paramString7, int paramInt2, int paramInt3, String paramString8)
  {
    b.getlockRepairCapacity(paramContext, paramHandler, m.buildLockRepairCapacity(paramString1, paramString2, paramString3, paramString4, paramInt1, paramString5, paramString6, paramString7, paramInt2, paramInt3, paramString8), q.i + p.f.s, 4135);
  }
  
  public static void makeCleanOrder(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, double paramDouble, int paramInt)
  {
    b.getPostServiceObject(paramContext, paramHandler, m.buildMakeCleanOrder(paramString1, paramString2, paramString3, paramString4, paramString5, paramDouble, paramInt), q.i + p.b.a, 65619, OrderInfo.class);
  }
  
  public static void markDialyCleanOrder(Context paramContext, Handler paramHandler, String paramString1, String paramString2, float paramFloat, int paramInt, String paramString3)
  {
    b.getPostServiceObject(paramContext, paramHandler, m.buildDialyCleanPay(paramString1, paramString2, paramFloat, paramInt, paramString3), q.i + p.b.p, 69650, OrderInfo.class);
  }
  
  public static void modifyContact(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    b.getPostServiceDiver(paramContext, paramHandler, m.buildModifyContact(paramString1, paramString2, paramString3), q.i + p.f.t, 4137);
  }
  
  public static void payNewMHOrder(Context paramContext, Handler paramHandler, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    b.getMHObjectDec(paramContext, paramHandler, m.buildMHPayOrder(paramString1, paramString3, paramInt1, paramInt2, paramString2), q.i + p.d.f, 8226, OrderInfo.class);
  }
  
  public static void requestMoveDates(Context paramContext, String paramString, com.ziroom.commonlibrary.a.a parama)
  {
    paramString = m.buildMoveDates(paramContext, paramString);
    k.request(paramContext, q.l, p.d.l, paramString, parama);
  }
  
  public static void requestMoveTimes(Context paramContext, String paramString, long paramLong, com.ziroom.commonlibrary.a.a parama)
  {
    paramString = m.buildMoveTimes(paramContext, paramString, paramLong);
    k.request(paramContext, q.l, p.d.m, paramString, parama);
  }
  
  public static void reserveClean(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, OrderDate paramOrderDate1, OrderDate paramOrderDate2, int paramInt1, String paramString8, int paramInt2, int paramInt3)
  {
    b.getPostServiceDiver(paramContext, paramHandler, m.buildReserveClean(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramOrderDate1, paramOrderDate2, paramInt1, paramString8, paramInt2, paramInt3), q.i + p.b.c, 4114);
  }
  
  public static void revokeRepair(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    b.getPostServiceDiver(paramContext, paramHandler, m.buildRevokeRepair(paramString1, paramString2, paramString3, paramString4), q.i + p.f.l, 4129);
  }
  
  public static void saveAppPoint(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("event", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("userUniqueKey", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("knowledgeId", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localHashMap.put("selfHelpMenu", paramString4);
    }
    com.ziroom.ziroomcustomer.util.u.e("dsjgkdj", com.alibaba.fastjson.a.toJSONString(localHashMap));
    b.getPostTestService(paramContext, paramHandler, localHashMap, q.k + p.b.bm, 69974);
  }
  
  public static void saveGeneralEvaluate(Context paramContext, Handler paramHandler, String paramString1, float paramFloat, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildsaveGeneralEvaluate(paramString1, paramFloat, paramString2, paramString3, paramString4, paramString5), q.j + p.b.ai, 69923, n.class);
  }
  
  public static void saveNewWeekEvaluate(Context paramContext, Handler paramHandler, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    b.getDesPostServiceDiver(paramContext, paramHandler, m.buildNewWeekEvaluate(paramString1, paramInt, paramString2, paramString3, paramString4), q.j + p.b.ag, 69920);
  }
  
  public static void saveQuestion_2(Context paramContext, Handler paramHandler, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("questionType", "INVALID");
    localHashMap.put("userUniqueKey", paramString2);
    com.ziroom.ziroomcustomer.util.u.e("dsjgkdj", com.alibaba.fastjson.a.toJSONString(localHashMap));
    b.getPutTestService(paramContext, paramHandler, localHashMap, q.k + p.b.bl + "/" + paramString1 + "/type", 69973, String.class);
  }
  
  public static void saveRepairEvaluate(Context paramContext, Handler paramHandler, String paramString1, Long paramLong, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, Integer paramInteger, String paramString7, String paramString8)
  {
    b.savePostRepairEvalInfo(paramContext, paramHandler, m.buildSaveEvalInfo(paramString1, paramLong, paramString2, paramInt, paramString3, paramString4, paramString5, paramString6, paramInteger, paramString7, paramString8), q.m + p.f.h, 69968);
  }
  
  public static void setAddCleanScore(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    b.getPostServiceDiver(paramContext, paramHandler, m.buildSetAddCleanScore(paramString1, paramString2, paramString3, paramInt), q.i + p.b.h, 65542);
  }
  
  public static void setChatSuggestion(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, List<String> paramList)
  {
    paramString1 = m.buildChatSuggestion(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramList);
    com.ziroom.ziroomcustomer.util.u.e("sdjsg", com.alibaba.fastjson.a.toJSONString(paramString1));
    b.getPostTestServiceObject(paramContext, paramHandler, paramString1, q.k + p.b.bs, 69961, com.ziroom.ziroomcustomer.newchat.chatcenter.m.class);
  }
  
  public static void setCleanScore(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, String paramString6, String paramString7, int paramInt2, List<Map<String, Object>> paramList)
  {
    b.getPostServiceDiver(paramContext, paramHandler, m.buildSetCleanScore(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramString6, paramString7, paramInt2, paramList), q.i + p.b.f, 4117);
  }
  
  public static void setNewWeekCleanOrder(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, String paramString6, String paramString7, String paramString8, long paramLong2, int paramInt1, int paramInt2, String paramString9)
  {
    b.getDesPostServiceObject(paramContext, paramHandler, m.buildNewWeekCleanOrder(paramString1, paramString2, paramString3, paramString4, paramString5, paramLong1, paramString6, paramString7, paramString8, paramLong2, paramInt1, paramInt2, paramString9), q.j + p.b.ab, 69910, bp.class);
  }
  
  public static void setReminder(Context paramContext, Handler paramHandler, String paramString)
  {
    try
    {
      b.getRasPostService(paramContext, paramHandler, m.buildReminder(paramString), q.k + p.e.e, 69972, String.class, 3);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void setRentEvaluate(Context paramContext, Handler paramHandler, String paramString1, int paramInt, String paramString2)
  {
    try
    {
      b.getRasPostService(paramContext, paramHandler, m.buildRentEvaluate(paramString1, paramInt, paramString2), q.k + p.e.d, 69956, String.class, 2);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void setRepairCommit(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, List<RepairWork> paramList, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15)
  {
    b.getPostServiceDiver(paramContext, paramHandler, m.buildSubmitRepair(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt1, paramInt2, paramList), q.i + p.f.a, 4119);
  }
  
  public static void setRepairScore(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, List<RepairScore> paramList)
  {
    b.getPostServiceDiver(paramContext, paramHandler, m.buildSetRepairScore(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, paramList), q.i + p.f.o, 4131);
  }
  
  public static void submitRepair(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, List<RepairWork> paramList)
  {
    b.getPostServiceDiver(paramContext, paramHandler, m.buildSubmitRepair(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt1, paramInt2, paramList), q.i + p.f.a, 4119);
  }
  
  public static void uploadImage(Context paramContext, Handler paramHandler, String paramString, byte[] paramArrayOfByte)
  {
    b.uploadImage(paramContext, paramHandler, paramString, paramArrayOfByte, q.j + p.g.g, 8343, String.class);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */