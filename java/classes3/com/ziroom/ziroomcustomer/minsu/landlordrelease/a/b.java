package com.ziroom.ziroomcustomer.minsu.landlordrelease.a;

import android.app.Activity;
import android.content.Context;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.f.t;
import com.ziroom.ziroomcustomer.minsu.f.w;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.EditHouseRuleResult;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseCheckInfoInitBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseManagerBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseRoomHaveBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseCityTreeBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleasePhotoBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseResultBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseSaveTypeLocationBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseTypeLocationInfo;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveAloneRoomInitInfoBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveCheckInfoInit;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveHouseRoomListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveLLReleaseRoomBasicBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveLLReleaseRoomHaveBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomInitInfoBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.LLSaveHouseDescBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.LandlordReleaseHouseDescBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomBasicBean;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private static b b;
  final com.ziroom.ziroomcustomer.flux.b a;
  
  private b(com.ziroom.ziroomcustomer.flux.b paramb)
  {
    this.a = paramb;
  }
  
  public static b getInstance(com.ziroom.ziroomcustomer.flux.b paramb)
  {
    if (b == null) {
      b = new b(paramb);
    }
    return b;
  }
  
  public void cancelReleaseHouse(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.cancelRelease(paramActivity, paramString1, paramString2, paramInt, new s(paramActivity, new r(MinsuBaseJson.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_cancel_release_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuBaseJson paramAnonymousMinsuBaseJson)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuBaseJson);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_cancel_release", paramAnonymousMinsuBaseJson), paramObject);
      }
    });
  }
  
  public void deletePicture(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.deleteReleasePicture(paramActivity, paramString1, paramString2, paramInt, paramString3, new s(paramActivity, new r(MinsuBaseJson.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("delete_picture_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuBaseJson paramAnonymousMinsuBaseJson)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuBaseJson);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("delete_picture", paramAnonymousMinsuBaseJson), paramObject);
      }
    });
  }
  
  public void downReleaseHouse(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.downHouseRelease(paramActivity, paramString1, paramString2, paramInt, new s(paramActivity, new r(MinsuBaseJson.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_down_release_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuBaseJson paramAnonymousMinsuBaseJson)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuBaseJson);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_down_release", paramAnonymousMinsuBaseJson), paramObject);
      }
    });
  }
  
  public void editHouseRuleResult(EditHouseRuleResult paramEditHouseRuleResult)
  {
    this.a.dispatch(new com.ziroom.ziroomcustomer.flux.a("ll_release_edit_house_rule", paramEditHouseRuleResult));
  }
  
  public void getAloneRoomInfo(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, Integer paramInteger, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getAloneRoomInitInfo(paramActivity, paramString1, paramString2, paramInteger, paramInt, new t(paramActivity, new r(AloneRoomInitInfoBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("alone_room_init_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, AloneRoomInitInfoBean paramAnonymousAloneRoomInitInfoBean)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("alone_room_init", paramAnonymousAloneRoomInitInfoBean), paramObject);
      }
    });
  }
  
  public void getCheckInfoInit(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, Integer paramInteger)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getCheckInfoInitMsg(paramActivity, paramString1, paramString2, paramInteger, new t(paramActivity, new r(LLReleaseCheckInfoInitBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("check_info_init_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, LLReleaseCheckInfoInitBean paramAnonymousLLReleaseCheckInfoInitBean)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("check_info_init", paramAnonymousLLReleaseCheckInfoInitBean), paramObject);
      }
    });
  }
  
  public void getCityTree(final Object paramObject, Activity paramActivity)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getCityTree(paramActivity, new s(paramActivity, new r(LandlordReleaseCityTreeBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("get_city_tree_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, LandlordReleaseCityTreeBean paramAnonymousLandlordReleaseCityTreeBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousLandlordReleaseCityTreeBean);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("get_city_tree", paramAnonymousLandlordReleaseCityTreeBean), paramObject);
      }
    });
  }
  
  public void getHouseManagerBase(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, Integer paramInteger)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getHouseManagerBase(paramActivity, paramString1, paramString2, paramInteger.intValue(), new s(paramActivity, new r(LLReleaseManagerBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_manager_release_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, LLReleaseManagerBean paramAnonymousLLReleaseManagerBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousLLReleaseManagerBean);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_manager_release", paramAnonymousLLReleaseManagerBean), paramObject);
      }
    });
  }
  
  public void getLandlordReleaseHouseDesc(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, Integer paramInteger)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getHouseDesc(paramActivity, paramString1, paramString2, paramInteger, new t(paramActivity, new r(LandlordReleaseHouseDescBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("hous_desc_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, LandlordReleaseHouseDescBean paramAnonymousLandlordReleaseHouseDescBean)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("hous_desc", paramAnonymousLandlordReleaseHouseDescBean), paramObject);
      }
    });
  }
  
  public void getLandlordReleaseHousePrice(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, Integer paramInteger)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getHousePrcie(paramActivity, paramString1, paramString2, paramInteger, new t(paramActivity, new r(LandlordReleaseHousePriceBasicBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("house_price_basic_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, LandlordReleaseHousePriceBasicBean paramAnonymousLandlordReleaseHousePriceBasicBean)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("house_price_basic", paramAnonymousLandlordReleaseHousePriceBasicBean), paramObject);
      }
    });
  }
  
  public void getLandlordReleaseRoomBasicInfo(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getRoomBasicInfo(paramActivity, paramString1, paramString2, paramInteger1, paramInteger2, new t(paramActivity, new r(LLReleaseRoomBasicBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("house_room_basic_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, LLReleaseRoomBasicBean paramAnonymousLLReleaseRoomBasicBean)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("house_room_basic", paramAnonymousLLReleaseRoomBasicBean), paramObject);
      }
    });
  }
  
  public void getLandlordReleaseRoomListInfo(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, Integer paramInteger)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getRoomHaveListInfo(paramActivity, paramString1, paramString2, paramInteger, new t(paramActivity, new r(LLReleaseRoomHaveBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("house_room_have_list_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, LLReleaseRoomHaveBean paramAnonymousLLReleaseRoomHaveBean)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("house_room_have_list", paramAnonymousLLReleaseRoomHaveBean), paramObject);
      }
    });
  }
  
  public void getPhotoList(final Object paramObject, Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getPhotoList(paramActivity, paramString1, paramInt, paramString2, new s(paramActivity, new r(LandlordReleasePhotoBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("get_photo_list_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, LandlordReleasePhotoBean paramAnonymousLandlordReleasePhotoBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousLandlordReleasePhotoBean);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("get_photo_list", paramAnonymousLandlordReleasePhotoBean), paramObject);
      }
    });
  }
  
  public void getReleaseTypeLocationInfo(final Object paramObject, Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getReleaseTypeLocationInfo(paramActivity, paramString1, paramInt1, paramString2, paramInt2, new s(paramActivity, new r(LandlordReleaseTypeLocationInfo.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("get_house_type_location_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, LandlordReleaseTypeLocationInfo paramAnonymousLandlordReleaseTypeLocationInfo)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousLandlordReleaseTypeLocationInfo);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("get_house_type_location", paramAnonymousLandlordReleaseTypeLocationInfo), paramObject);
      }
    });
  }
  
  public void initDescAndBaseInfoEntire(final Object paramObject, Activity paramActivity, String paramString)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.managerInitDescAndBaseInfoEntire(paramActivity, paramString, new s(paramActivity, new w())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_step_2_house_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_step_2_house", paramAnonymousString), paramObject);
      }
    });
  }
  
  public void initDescAndBaseInfoSublet(final Object paramObject, Activity paramActivity, String paramString1, String paramString2)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.managerInitDescAndBaseInfoSublet(paramActivity, paramString1, paramString2, new s(paramActivity, new w())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_step_2_room_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_step_2_room", paramAnonymousString), paramObject);
      }
    });
  }
  
  public void initPolicy(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, Integer paramInteger)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.initPolicy(paramActivity, paramString1, paramString2, paramInteger.intValue(), new s(paramActivity, new r(Step3InitDealPolicyBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_release_step3_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, Step3InitDealPolicyBean paramAnonymousStep3InitDealPolicyBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousStep3InitDealPolicyBean);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_release_step3", paramAnonymousStep3InitDealPolicyBean), paramObject);
      }
    });
  }
  
  public void initSetPrice(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.initSetPrice(paramActivity, paramString1, paramString2, paramInt, new s(paramActivity, new w())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_init_set_price_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_init_set_price", paramAnonymousString), paramObject);
      }
    });
  }
  
  public void releaseFirstHouse(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.releaseHouse(paramActivity, paramString1, paramString2, paramInt, new s(paramActivity, new r(LandlordReleaseResultBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("release_house_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, LandlordReleaseResultBean paramAnonymousLandlordReleaseResultBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousLandlordReleaseResultBean);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("release_house", paramAnonymousLandlordReleaseResultBean), paramObject);
      }
    });
  }
  
  public void releaseHouse(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.releaseHouse(paramActivity, paramString1, paramString2, paramInt, new s(paramActivity, new r(MinsuBaseJson.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_release_house_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuBaseJson paramAnonymousMinsuBaseJson)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuBaseJson);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_release_house", paramAnonymousMinsuBaseJson), paramObject);
      }
    });
  }
  
  public void saveAloneRoomInfo(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2, String paramString3, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Integer paramInteger7, String paramString4, double paramDouble1, double paramDouble2, Integer paramInteger8, Integer paramInteger9, Integer paramInteger10, String paramString5)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.saveAloneRoomInitInfo(paramActivity, paramString1, paramString2, paramInteger1, paramInteger2, paramString3, paramInteger3, paramInteger4, paramInteger5, paramInteger6, paramInteger7, paramString4, paramDouble1, paramDouble2, paramInteger8, paramInteger9, paramInteger10, paramString5, new s(paramActivity, new r(SaveAloneRoomInitInfoBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("save_alone_room_init_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, SaveAloneRoomInitInfoBean paramAnonymousSaveAloneRoomInitInfoBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousSaveAloneRoomInitInfoBean);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("save_alone_room_init", paramAnonymousSaveAloneRoomInitInfoBean), paramObject);
      }
    });
  }
  
  public void saveCheckInfoInit(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, Integer paramInteger, int paramInt, String paramString3, String paramString4)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.saveCheckInfoInitMsg(paramActivity, paramString1, paramString2, paramInteger, paramInt, paramString3, paramString4, new t(paramActivity, new r(SaveCheckInfoInit.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("save_check_info_init_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, SaveCheckInfoInit paramAnonymousSaveCheckInfoInit)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("save_check_info_init", paramAnonymousSaveCheckInfoInit), paramObject);
      }
    });
  }
  
  public void saveDescAndBaseInfoEntire(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, Double paramDouble, String paramString6, Integer paramInteger, String paramString7, List paramList1, List paramList2)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.saveDescAndBaseInfoEntire(paramActivity, paramString1, paramString2, paramInt, paramString3, paramString4, paramString5, paramDouble, paramString6, paramInteger, paramString7, paramList1, paramList2, new s(paramActivity, new r(MinsuBaseJson.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_step_2_house_save_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuBaseJson paramAnonymousMinsuBaseJson)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuBaseJson);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_step_2_house_save", paramAnonymousMinsuBaseJson), paramObject);
      }
    });
  }
  
  public void saveDescAndBaseInfoSublet(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Integer paramInteger1, String paramString5, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.saveDescAndBaseInfoSublet(paramActivity, paramString1, paramString2, paramInt, paramString3, paramString4, paramInteger1, paramString5, paramInteger2, paramInteger3, paramInteger4, paramInteger5, paramInteger6, new s(paramActivity, new r(MinsuBaseJson.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_step_2_room_save_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuBaseJson paramAnonymousMinsuBaseJson)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuBaseJson);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_step_2_room_save", paramAnonymousMinsuBaseJson), paramObject);
      }
    });
  }
  
  public void saveHouseDesc(Object paramObject, Activity paramActivity, String paramString1, Integer paramInteger, String paramString2, String paramString3, String paramString4)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.saveHouseDescInfo(paramActivity, paramString1, paramInteger, paramString2, paramString3, paramString4, new t(paramActivity, new r(LLSaveHouseDescBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("house_save_desc_error", paramAnonymousThrowable.getMessage()), null);
      }
      
      public void onSuccess(int paramAnonymousInt, LLSaveHouseDescBean paramAnonymousLLSaveHouseDescBean)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("house_save_desc", paramAnonymousLLSaveHouseDescBean), null);
      }
    });
  }
  
  public void saveLLReleaseHousePrice(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, int paramInt1, Integer paramInteger1, String paramString3, int paramInt2, int paramInt3, int paramInt4, String paramString4, double paramDouble1, int paramInt5, double paramDouble2, double paramDouble3, Integer paramInteger2, String paramString5, List<SaveHouseRoomListBean> paramList, List<String> paramList1)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.saveHousePrcie(paramActivity, paramString1, paramString2, paramInt1, paramInteger1, paramString3, paramInt2, paramInt3, paramInt4, paramString4, paramDouble1, paramInt5, paramDouble2, paramDouble3, paramInteger2, paramString5, paramList, paramList1, new t(paramActivity, new r(LLSaveHouseDescBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("save_house_price_basic_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, LLSaveHouseDescBean paramAnonymousLLSaveHouseDescBean)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("save_house_price_basic", paramAnonymousLLSaveHouseDescBean), paramObject);
      }
    });
  }
  
  public void saveLandlordReleaseRoomBasicInfo(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2, int paramInt1, String paramString3, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.saveRoomBasicInfo(paramActivity, paramString1, paramString2, paramInteger1, paramInteger2, paramInt1, paramString3, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, new t(paramActivity, new r(SaveLLReleaseRoomBasicBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("save_house_room_basic_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, SaveLLReleaseRoomBasicBean paramAnonymousSaveLLReleaseRoomBasicBean)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("save_house_room_basic", paramAnonymousSaveLLReleaseRoomBasicBean), paramObject);
      }
    });
  }
  
  public void savePolicy(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3, String paramString5)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.savePolicy(paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramString3, paramString4, paramInt3, paramString5, new s(paramActivity, new r(MinsuBaseJson.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_release_step3_save_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuBaseJson paramAnonymousMinsuBaseJson)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuBaseJson);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_release_step3_save", paramAnonymousMinsuBaseJson), paramObject);
      }
    });
  }
  
  public void saveReleaseTypeLocation(final Object paramObject, Activity paramActivity, String paramString1, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Double paramDouble1, Double paramDouble2)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.saveReleaseTypeLocation(paramActivity, paramString1, paramInteger1, paramInteger2, paramInteger3, paramString2, paramString3, paramString4, paramString5, paramString6, paramDouble1, paramDouble2, new s(paramActivity, new r(LandlordReleaseSaveTypeLocationBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("save_house_type_location_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, LandlordReleaseSaveTypeLocationBean paramAnonymousLandlordReleaseSaveTypeLocationBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousLandlordReleaseSaveTypeLocationBean);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("save_house_type_location", paramAnonymousLandlordReleaseSaveTypeLocationBean), paramObject);
      }
    });
  }
  
  public void saveSetPrice(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, double paramDouble1, int paramInt4, double paramDouble2, double paramDouble3, int paramInt5)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.saveSetPrice(paramActivity, paramString1, paramString2, paramInt1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString3, Double.valueOf(paramDouble1), Integer.valueOf(paramInt4), Double.valueOf(paramDouble2), Double.valueOf(paramDouble3), Integer.valueOf(paramInt5), new s(paramActivity, new w())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_set_price_save_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("ll_r_manager_set_price_save", paramAnonymousString), paramObject);
      }
    });
  }
  
  public void setCoverPicture(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.setCoverPicture(paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramString3, new s(paramActivity, new r(MinsuBaseJson.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("select_cover_picture_error", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuBaseJson paramAnonymousMinsuBaseJson)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuBaseJson);
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("select_cover_picture", paramAnonymousMinsuBaseJson), paramObject);
      }
    });
  }
  
  public void updateRoomNumAndRoomMsgInfo(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, Integer paramInteger, int paramInt, ArrayList<String> paramArrayList)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.updateRoomNumAndRoomInfo(paramActivity, paramString1, paramString2, paramInteger, paramInt, paramArrayList, new t(paramActivity, new r(SaveLLReleaseRoomHaveBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("house_room_save_have_list_ERROR", paramAnonymousThrowable.getMessage()), paramObject);
      }
      
      public void onSuccess(int paramAnonymousInt, SaveLLReleaseRoomHaveBean paramAnonymousSaveLLReleaseRoomHaveBean)
      {
        b.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("house_room_save_have_list", paramAnonymousSaveLLReleaseRoomHaveBean), paramObject);
      }
    });
  }
  
  public void uploadPicture(Object paramObject, Activity paramActivity, String paramString1, String paramString2, int paramInt) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */