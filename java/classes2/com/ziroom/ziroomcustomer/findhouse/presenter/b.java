package com.ziroom.ziroomcustomer.findhouse.presenter;

import android.view.View.OnClickListener;
import com.ziroom.ziroomcustomer.a;
import com.ziroom.ziroomcustomer.findhouse.model.SurroundBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.PayType;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.ActivityArray;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.ActivityBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Banner;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Config;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Ensure;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.QuestionListBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.ResidentialInfo;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Roommate;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Service;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Share;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.SignDuration;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Space;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Sublet;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Tag;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.TipBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.TipBean.TipContent;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseRecommend;
import com.ziroom.ziroomcustomer.model.BookingOrderTextEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.KeeperInfo;
import java.util.LinkedHashMap;
import java.util.List;

public abstract interface b
{
  public static abstract interface a
    extends a<b.b>
  {
    public abstract void checkSubletCode(String paramString);
    
    public abstract void clickTabInitData(int paramInt);
    
    public abstract void contactSublet();
    
    public abstract void countTimeFinish();
    
    public abstract void doBook();
    
    public abstract void doSign();
    
    public abstract boolean getCollect();
    
    public abstract void getCollectFormServer();
    
    public abstract void init(String paramString);
    
    public abstract void init3D();
    
    public abstract void initAroundBaiduMap();
    
    public abstract void initAroundDetail();
    
    public abstract void initDistrictDetail();
    
    public abstract void initEnsureAll();
    
    public abstract void initHouseCode();
    
    public abstract void initHouseInfo();
    
    public abstract void initHxPicDetail();
    
    public abstract void initPayType();
    
    public abstract void initResblockHouseList();
    
    public abstract void initServiceAll();
    
    public abstract void initShare();
    
    public abstract void initSpaceAll();
    
    public abstract void initWillUnrent();
    
    public abstract boolean ismIsWillUnrent();
    
    public abstract void showActivitysPop();
    
    public abstract void showHouseTips();
    
    public abstract void showSignEndDate();
    
    public abstract void submitBtnA();
    
    public abstract void submitBtnB();
    
    public abstract void updateCollect();
    
    public abstract void updateHouseInfo(String paramString);
  }
  
  public static abstract interface b
    extends com.ziroom.ziroomcustomer.b<b.a>
  {
    public abstract void dismissSubletCode();
    
    public abstract void growingIo(int paramInt, String paramString1, String paramString2, String paramString3);
    
    public abstract void initHoustTips(RentHouseDetail.TipBean paramTipBean);
    
    public abstract void saveHouseCode2Clipboard(String paramString);
    
    public abstract void setPresenter(b.a parama);
    
    public abstract void show3D(String paramString);
    
    public abstract void show3D(String paramString1, String paramString2);
    
    public abstract void showActivitys(List<RentHouseDetail.ActivityArray> paramList);
    
    public abstract void showActivitysPop(List<RentHouseDetail.ActivityArray> paramList);
    
    public abstract void showAround(RentHouseDetail.ResidentialInfo paramResidentialInfo);
    
    public abstract void showAroundAll(RentHouseDetail.ResidentialInfo paramResidentialInfo);
    
    public abstract void showAroundBaiduMap(String paramString1, String paramString2, String paramString3, List<SurroundBean> paramList);
    
    public abstract void showAroundPoi(List<SurroundBean> paramList);
    
    public abstract void showBanner(RentHouseDetail.Banner paramBanner);
    
    public abstract void showBigPic(String paramString);
    
    public abstract void showBookDialog(BookingOrderTextEntity paramBookingOrderTextEntity);
    
    public abstract void showBottom(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, boolean paramBoolean4, long paramLong, boolean paramBoolean5);
    
    public abstract void showCarousel(List<String> paramList1, List<String> paramList2, LinkedHashMap<String, Integer> paramLinkedHashMap);
    
    public abstract void showCollection(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void showCoordination(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
    
    public abstract void showCountTimeFinish();
    
    public abstract void showEnsure(RentHouseDetail.Ensure paramEnsure);
    
    public abstract void showEnsureAll(RentHouseDetail.Ensure paramEnsure);
    
    public abstract void showHeader(String paramString);
    
    public abstract void showHouseCode(String paramString);
    
    public abstract void showHouseConfig(List<RentHouseDetail.Config> paramList);
    
    public abstract void showHouseInfo(String paramString1, String paramString2);
    
    public abstract void showHouseInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, List<RentHouseDetail.Tag> paramList, RentHouseDetail.ActivityBean paramActivityBean);
    
    public abstract void showHouseInfoSpace(RentHouseDetail.Space paramSpace);
    
    public abstract void showHouseTips(RentHouseDetail.TipBean.TipContent paramTipContent);
    
    public abstract void showHousekeeper(KeeperInfo paramKeeperInfo);
    
    public abstract void showHuxingInfo(String paramString);
    
    public abstract void showHxPicDetail(List<String> paramList1, List<String> paramList2, LinkedHashMap<String, Integer> paramLinkedHashMap);
    
    public abstract void showIntroduce(String paramString);
    
    public abstract void showNews(String paramString);
    
    public abstract void showPayType(PayType paramPayType);
    
    public abstract void showPicNumsign(int paramInt, String paramString);
    
    public abstract void showQuestions(RentHouseDetail.QuestionListBean paramQuestionListBean);
    
    public abstract void showRecommend(List<RentHouseRecommend> paramList);
    
    public abstract void showResblockIntroduce(RentHouseDetail.ResidentialInfo paramResidentialInfo);
    
    public abstract void showRoomInfo(String paramString, List<RentHouseDetail.Roommate> paramList);
    
    public abstract void showService(RentHouseDetail.Service paramService);
    
    public abstract void showServiceAll(RentHouseDetail.Service paramService);
    
    public abstract void showShare(String paramString1, RentHouseDetail.Share paramShare, int paramInt, String paramString2, View.OnClickListener paramOnClickListener);
    
    public abstract void showSignEndDate(RentHouseDetail.SignDuration paramSignDuration);
    
    public abstract void showSubleDialog();
    
    public abstract void showSubletDesc(RentHouseDetail.Sublet paramSublet);
    
    public abstract void showSubletRecommend(String paramString);
    
    public abstract void showSubsidiary(List<RentHouseDetail.Space> paramList, String paramString);
    
    public abstract void showSubsidiaryAll(List<RentHouseDetail.Space> paramList);
    
    public abstract void showToast(String paramString);
    
    public abstract void showWillUnrent(RentHouseDetail paramRentHouseDetail);
    
    public abstract void showWillUnrentPop(RentHouseDetail paramRentHouseDetail);
    
    public abstract void toAppointment(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
    
    public abstract void toBook(HouseDetail paramHouseDetail, String paramString1, String paramString2);
    
    public abstract void toCertInfoConfirm(HouseDetail paramHouseDetail, CertInfoEntity paramCertInfoEntity, String paramString, int paramInt);
    
    public abstract void toCertInput(CertInfoEntity paramCertInfoEntity, HouseDetail paramHouseDetail, String paramString, int paramInt);
    
    public abstract void toCertStatus(HouseDetail paramHouseDetail, CertInfoEntity paramCertInfoEntity, String paramString, int paramInt);
    
    public abstract void toDistrictDetail(RentHouseDetail paramRentHouseDetail);
    
    public abstract void toResblockHouseList(String paramString1, String paramString2);
    
    public abstract void toSign(HouseDetail paramHouseDetail, String paramString);
    
    public abstract void toSublet(String paramString1, String paramString2);
    
    public abstract void toSubletCode(String paramString1, String paramString2);
    
    public abstract void toSubletContact(String paramString1, String paramString2, String paramString3);
    
    public abstract void updataSubsidiary(int paramInt, RentHouseDetail.Space paramSpace);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/presenter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */