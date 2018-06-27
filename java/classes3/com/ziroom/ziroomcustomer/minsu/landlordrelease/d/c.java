package com.ziroom.ziroomcustomer.minsu.landlordrelease.d;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
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
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveLLReleaseRoomBasicBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveLLReleaseRoomHaveBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.Step3InitDealPolicyBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomInitInfoBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.LLSaveHouseDescBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.LandlordReleaseHouseDescBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomBasicBean;

public class c
  extends com.ziroom.ziroomcustomer.flux.c
{
  private MinsuBaseJson A;
  private MinsuBaseJson B;
  private MinsuBaseJson C;
  private MinsuBaseJson D;
  private MinsuBaseJson E;
  private String F;
  private String G;
  private String H;
  private String I;
  private String J;
  private String K;
  private String L;
  private String M;
  private String N;
  private String O;
  private String P;
  private String Q;
  private String R;
  private String S;
  private String T;
  private String U;
  private String V;
  private String W;
  private String X;
  private String Y;
  private String Z;
  private LandlordReleaseTypeLocationInfo b;
  private LandlordReleaseSaveTypeLocationBean c;
  private LandlordReleaseCityTreeBean d;
  private LandlordReleaseHouseDescBean e;
  private LLSaveHouseDescBean f;
  private LLSaveHouseDescBean g;
  private LandlordReleaseHousePriceBasicBean h;
  private LLReleaseRoomBasicBean i;
  private SaveLLReleaseRoomBasicBean j;
  private LLReleaseRoomHaveBean k;
  private SaveLLReleaseRoomHaveBean l;
  private AloneRoomInitInfoBean m;
  private SaveAloneRoomInitInfoBean n;
  private Step3InitDealPolicyBean o;
  private MinsuBaseJson p;
  private EditHouseRuleResult q;
  private LLReleaseCheckInfoInitBean r;
  private SaveCheckInfoInit s;
  private LandlordReleasePhotoBean t;
  private MinsuBaseJson u;
  private LandlordReleaseResultBean v;
  private MinsuBaseJson w;
  private LLReleaseManagerBean x;
  private String y;
  private String z;
  
  public c() {}
  
  public c(Object paramObject)
  {
    super(paramObject);
  }
  
  public String getAloneRoomInitInfoErrorMsg()
  {
    return this.P;
  }
  
  public MinsuBaseJson getCancelReleaseHouseResult()
  {
    return this.D;
  }
  
  public Step3InitDealPolicyBean getDealPolicyBean()
  {
    return this.o;
  }
  
  public MinsuBaseJson getDeletePictureResult()
  {
    return this.u;
  }
  
  public MinsuBaseJson getDownReleaseHouseResult()
  {
    return this.E;
  }
  
  public EditHouseRuleResult getEditHouseRuleResult()
  {
    return this.q;
  }
  
  public String getHouseDescErrorMsg()
  {
    return this.H;
  }
  
  public String getHousePriceBasicErrorMsg()
  {
    return this.J;
  }
  
  public String getHouseSaveErrorMsg()
  {
    return this.I;
  }
  
  public String getInitSetPriceBean()
  {
    return this.F;
  }
  
  public LLReleaseManagerBean getLLReleaseManagerBean()
  {
    return this.x;
  }
  
  public LandlordReleaseCityTreeBean getLandlordReleaseCityTreeBean()
  {
    return this.d;
  }
  
  public LandlordReleasePhotoBean getLandlordReleasePhotoList()
  {
    return this.t;
  }
  
  public LandlordReleaseSaveTypeLocationBean getLandlordReleaseSaveTypeLocationBean()
  {
    return this.c;
  }
  
  public LandlordReleaseTypeLocationInfo getLandlordReleaseTypeLocationInfo()
  {
    return this.b;
  }
  
  public String getLlrManagerStep2HouseBean()
  {
    return this.y;
  }
  
  public MinsuBaseJson getLlrManagerStep2HouseSaveResult()
  {
    return this.A;
  }
  
  public String getLlrManagerStep2RoomBean()
  {
    return this.z;
  }
  
  public MinsuBaseJson getLlrManagerStep2RoomSaveResult()
  {
    return this.B;
  }
  
  public String getReleaseCheckInfoInitErrorMsg()
  {
    return this.R;
  }
  
  public String getReleaseHouseErrorMsg()
  {
    return this.Y;
  }
  
  public MinsuBaseJson getReleaseHouseResult()
  {
    return this.C;
  }
  
  public LandlordReleaseResultBean getReleaseResult()
  {
    return this.v;
  }
  
  public String getRoomHaveListErrorMsg()
  {
    return this.N;
  }
  
  public String getRoomPriceBasicErrorMsg()
  {
    return this.L;
  }
  
  public String getSaveAloneRoomInitInfoErrorMsg()
  {
    return this.Q;
  }
  
  public String getSaveCheckInfoInitMsg()
  {
    return this.S;
  }
  
  public String getSaveHousePriceBasicErrorMsg()
  {
    return this.K;
  }
  
  public String getSaveLLReleaseRoomBasicErrorMsg()
  {
    return this.M;
  }
  
  public String getSaveLLReleaseRoomHaveErrorMsg()
  {
    return this.O;
  }
  
  public MinsuBaseJson getSavePolicyResult()
  {
    return this.p;
  }
  
  public String getSaveSetPriceBean()
  {
    return this.G;
  }
  
  public MinsuBaseJson getSetCoverPictureResult()
  {
    return this.w;
  }
  
  public AloneRoomInitInfoBean getmAloneRoomInitInfoBean()
  {
    return this.m;
  }
  
  public LLReleaseCheckInfoInitBean getmLLReleaseCheckInfoInitBean()
  {
    return this.r;
  }
  
  public LLReleaseRoomBasicBean getmLLReleaseRoomBasicBean()
  {
    return this.i;
  }
  
  public LLReleaseRoomHaveBean getmLLReleaseRoomHaveBean()
  {
    return this.k;
  }
  
  public LLSaveHouseDescBean getmLLSaveHouseDescBean()
  {
    return this.f;
  }
  
  public LLSaveHouseDescBean getmLLSaveHousePriceBean()
  {
    return this.g;
  }
  
  public LandlordReleaseHouseDescBean getmLandlordReleaseHouseDescBean()
  {
    return this.e;
  }
  
  public LandlordReleaseHousePriceBasicBean getmLandlordReleaseHousePriceBasicBean()
  {
    return this.h;
  }
  
  public SaveAloneRoomInitInfoBean getmSaveAloneRoomInitInfoBean()
  {
    return this.n;
  }
  
  public SaveCheckInfoInit getmSaveCheckInfoInit()
  {
    return this.s;
  }
  
  public SaveLLReleaseRoomBasicBean getmSaveLLReleaseRoomBasicBean()
  {
    return this.j;
  }
  
  public SaveLLReleaseRoomHaveBean getmSaveLLReleaseRoomHaveBean()
  {
    return this.l;
  }
  
  public void onAction(com.ziroom.ziroomcustomer.flux.a parama)
  {
    String str = parama.getType();
    int i1 = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i1)
      {
      }
      break;
    }
    for (;;)
    {
      a(new com.ziroom.ziroomcustomer.flux.a.a(parama.getType()));
      return;
      if (!str.equals("hous_desc")) {
        break;
      }
      i1 = 0;
      break;
      if (!str.equals("hous_desc_error")) {
        break;
      }
      i1 = 1;
      break;
      if (!str.equals("house_save_desc")) {
        break;
      }
      i1 = 2;
      break;
      if (!str.equals("house_save_desc_error")) {
        break;
      }
      i1 = 3;
      break;
      if (!str.equals("house_price_basic")) {
        break;
      }
      i1 = 4;
      break;
      if (!str.equals("house_price_basic_error")) {
        break;
      }
      i1 = 5;
      break;
      if (!str.equals("save_house_price_basic")) {
        break;
      }
      i1 = 6;
      break;
      if (!str.equals("save_house_price_basic_error")) {
        break;
      }
      i1 = 7;
      break;
      if (!str.equals("house_room_basic")) {
        break;
      }
      i1 = 8;
      break;
      if (!str.equals("house_room_basic_error")) {
        break;
      }
      i1 = 9;
      break;
      if (!str.equals("save_house_room_basic")) {
        break;
      }
      i1 = 10;
      break;
      if (!str.equals("save_house_room_basic_error")) {
        break;
      }
      i1 = 11;
      break;
      if (!str.equals("house_room_have_list")) {
        break;
      }
      i1 = 12;
      break;
      if (!str.equals("house_room_have_list_error")) {
        break;
      }
      i1 = 13;
      break;
      if (!str.equals("ll_release_edit_house_rule")) {
        break;
      }
      i1 = 14;
      break;
      if (!str.equals("house_room_save_have_list")) {
        break;
      }
      i1 = 15;
      break;
      if (!str.equals("house_room_save_have_list_ERROR")) {
        break;
      }
      i1 = 16;
      break;
      if (!str.equals("alone_room_init")) {
        break;
      }
      i1 = 17;
      break;
      if (!str.equals("alone_room_init_error")) {
        break;
      }
      i1 = 18;
      break;
      if (!str.equals("save_alone_room_init")) {
        break;
      }
      i1 = 19;
      break;
      if (!str.equals("save_alone_room_init_error")) {
        break;
      }
      i1 = 20;
      break;
      if (!str.equals("check_info_init")) {
        break;
      }
      i1 = 21;
      break;
      if (!str.equals("check_info_init_error")) {
        break;
      }
      i1 = 22;
      break;
      if (!str.equals("save_check_info_init")) {
        break;
      }
      i1 = 23;
      break;
      if (!str.equals("save_check_info_init_error")) {
        break;
      }
      i1 = 24;
      break;
      if (!str.equals("get_house_type_location")) {
        break;
      }
      i1 = 25;
      break;
      if (!str.equals("get_house_type_location_error")) {
        break;
      }
      i1 = 26;
      break;
      if (!str.equals("save_house_type_location")) {
        break;
      }
      i1 = 27;
      break;
      if (!str.equals("save_house_type_location_error")) {
        break;
      }
      i1 = 28;
      break;
      if (!str.equals("get_city_tree")) {
        break;
      }
      i1 = 29;
      break;
      if (!str.equals("get_city_tree_error")) {
        break;
      }
      i1 = 30;
      break;
      if (!str.equals("ll_release_step3")) {
        break;
      }
      i1 = 31;
      break;
      if (!str.equals("ll_release_step3_error")) {
        break;
      }
      i1 = 32;
      break;
      if (!str.equals("ll_release_step3_save")) {
        break;
      }
      i1 = 33;
      break;
      if (!str.equals("ll_release_step3_save_error")) {
        break;
      }
      i1 = 34;
      break;
      if (!str.equals("ll_manager_release")) {
        break;
      }
      i1 = 35;
      break;
      if (!str.equals("ll_manager_release_error")) {
        break;
      }
      i1 = 36;
      break;
      if (!str.equals("ll_r_manager_step_2_house")) {
        break;
      }
      i1 = 37;
      break;
      if (!str.equals("ll_r_manager_step_2_house_error")) {
        break;
      }
      i1 = 38;
      break;
      if (!str.equals("ll_r_manager_step_2_house_save")) {
        break;
      }
      i1 = 39;
      break;
      if (!str.equals("ll_r_manager_step_2_house_save_error")) {
        break;
      }
      i1 = 40;
      break;
      if (!str.equals("ll_r_manager_step_2_room")) {
        break;
      }
      i1 = 41;
      break;
      if (!str.equals("ll_r_manager_step_2_room_error")) {
        break;
      }
      i1 = 42;
      break;
      if (!str.equals("ll_r_manager_step_2_room_save")) {
        break;
      }
      i1 = 43;
      break;
      if (!str.equals("ll_r_manager_step_2_room_save_error")) {
        break;
      }
      i1 = 44;
      break;
      if (!str.equals("get_photo_list")) {
        break;
      }
      i1 = 45;
      break;
      if (!str.equals("get_photo_list_error")) {
        break;
      }
      i1 = 46;
      break;
      if (!str.equals("ll_r_manager_release_house")) {
        break;
      }
      i1 = 47;
      break;
      if (!str.equals("ll_r_manager_release_house_error")) {
        break;
      }
      i1 = 48;
      break;
      if (!str.equals("ll_r_manager_cancel_release")) {
        break;
      }
      i1 = 49;
      break;
      if (!str.equals("ll_r_manager_cancel_release_error")) {
        break;
      }
      i1 = 50;
      break;
      if (!str.equals("ll_r_manager_down_release")) {
        break;
      }
      i1 = 51;
      break;
      if (!str.equals("ll_r_manager_down_release_error")) {
        break;
      }
      i1 = 52;
      break;
      if (!str.equals("ll_r_manager_init_set_price")) {
        break;
      }
      i1 = 53;
      break;
      if (!str.equals("ll_r_manager_init_set_price_error")) {
        break;
      }
      i1 = 54;
      break;
      if (!str.equals("ll_r_manager_set_price_save")) {
        break;
      }
      i1 = 55;
      break;
      if (!str.equals("ll_r_manager_set_price_save_error")) {
        break;
      }
      i1 = 56;
      break;
      if (!str.equals("delete_picture")) {
        break;
      }
      i1 = 57;
      break;
      if (!str.equals("delete_picture_error")) {
        break;
      }
      i1 = 58;
      break;
      if (!str.equals("release_house")) {
        break;
      }
      i1 = 59;
      break;
      if (!str.equals("release_house_error")) {
        break;
      }
      i1 = 60;
      break;
      if (!str.equals("select_cover_picture")) {
        break;
      }
      i1 = 61;
      break;
      if (!str.equals("select_cover_picture_error")) {
        break;
      }
      i1 = 62;
      break;
      this.e = ((LandlordReleaseHouseDescBean)parama.getData());
      continue;
      this.H = ((String)parama.getData());
      continue;
      this.f = ((LLSaveHouseDescBean)parama.getData());
      continue;
      this.I = ((String)parama.getData());
      continue;
      this.h = ((LandlordReleaseHousePriceBasicBean)parama.getData());
      continue;
      this.J = ((String)parama.getData());
      continue;
      this.g = ((LLSaveHouseDescBean)parama.getData());
      continue;
      this.K = ((String)parama.getData());
      continue;
      this.i = ((LLReleaseRoomBasicBean)parama.getData());
      continue;
      this.L = ((String)parama.getData());
      continue;
      this.j = ((SaveLLReleaseRoomBasicBean)parama.getData());
      continue;
      this.M = ((String)parama.getData());
      continue;
      this.k = ((LLReleaseRoomHaveBean)parama.getData());
      continue;
      this.N = ((String)parama.getData());
      continue;
      this.q = ((EditHouseRuleResult)parama.getData());
      continue;
      this.l = ((SaveLLReleaseRoomHaveBean)parama.getData());
      continue;
      this.O = ((String)parama.getData());
      continue;
      this.m = ((AloneRoomInitInfoBean)parama.getData());
      continue;
      this.P = ((String)parama.getData());
      continue;
      this.n = ((SaveAloneRoomInitInfoBean)parama.getData());
      continue;
      this.Q = ((String)parama.getData());
      continue;
      this.r = ((LLReleaseCheckInfoInitBean)parama.getData());
      continue;
      this.R = ((String)parama.getData());
      continue;
      this.s = ((SaveCheckInfoInit)parama.getData());
      continue;
      this.S = ((String)parama.getData());
      continue;
      this.b = ((LandlordReleaseTypeLocationInfo)parama.getData());
      continue;
      this.T = ((String)parama.getData());
      continue;
      this.c = ((LandlordReleaseSaveTypeLocationBean)parama.getData());
      continue;
      this.U = ((String)parama.getData());
      continue;
      this.d = ((LandlordReleaseCityTreeBean)parama.getData());
      continue;
      this.V = ((String)parama.getData());
      continue;
      this.o = ((Step3InitDealPolicyBean)parama.getData());
      continue;
      this.p = ((MinsuBaseJson)parama.getData());
      continue;
      this.x = ((LLReleaseManagerBean)parama.getData());
      continue;
      this.y = ((String)parama.getData());
      continue;
      this.A = ((MinsuBaseJson)parama.getData());
      continue;
      this.z = ((String)parama.getData());
      continue;
      this.B = ((MinsuBaseJson)parama.getData());
      continue;
      this.t = ((LandlordReleasePhotoBean)parama.getData());
      continue;
      this.W = ((String)parama.getData());
      continue;
      this.C = ((MinsuBaseJson)parama.getData());
      continue;
      this.D = ((MinsuBaseJson)parama.getData());
      continue;
      this.E = ((MinsuBaseJson)parama.getData());
      continue;
      this.F = ((String)parama.getData());
      continue;
      this.G = ((String)parama.getData());
      continue;
      this.u = ((MinsuBaseJson)parama.getData());
      continue;
      this.X = ((String)parama.getData());
      continue;
      this.v = ((LandlordReleaseResultBean)parama.getData());
      continue;
      this.Y = ((String)parama.getData());
      continue;
      this.w = ((MinsuBaseJson)parama.getData());
      continue;
      this.Z = ((String)parama.getData());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */