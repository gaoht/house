package com.ziroom.ziroomcustomer.ziroomapartment.meetaapartdetail;

import com.ziroom.ziroomcustomer.b;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Space;
import com.ziroom.ziroomcustomer.home.bean.HomeRentItem;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.BaseHouseTypeInfoVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.CommentsVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.FacilitiesVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.LabelsVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.MiddleBannerVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.ProjectDetailInfoVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.ProjectZoVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.SocialVo;
import java.util.ArrayList;
import java.util.List;

public abstract interface a
{
  public static abstract interface a
    extends com.ziroom.ziroomcustomer.a
  {
    public abstract void call();
    
    public abstract List<ProjectDetailForAppVo.CommentsVo> getCommentsVoList();
    
    public abstract void getData(String paramString);
    
    public abstract ArrayList<String> getSliders();
    
    public abstract ArrayList<Integer> getSlidersTypeIndexs();
    
    public abstract ArrayList<String> getSlidersTypes();
    
    public abstract ArrayList<String> getUrl();
    
    public abstract List<ProjectDetailForAppVo.ProjectZoVo> getZoVoList();
    
    public abstract void showAllFacilities();
    
    public abstract void showCircleSeeHouse();
    
    public abstract void showShare();
    
    public abstract void toBook();
    
    public abstract void toMapRetrieve();
    
    public abstract void toMeeta();
  }
  
  public static abstract interface b
    extends b<a.a>
  {
    public abstract void setBtnB(boolean paramBoolean);
    
    public abstract void setFacilitiesVo(ArrayList<ProjectDetailForAppVo.FacilitiesVo> paramArrayList, String paramString);
    
    public abstract void setHouseTypeInfoVo(ProjectDetailForAppVo.BaseHouseTypeInfoVo paramBaseHouseTypeInfoVo, String paramString1, String paramString2);
    
    public abstract void setProjectRecommendVos(HomeRentItem paramHomeRentItem);
    
    public abstract void setSocialVoInfo(ProjectDetailForAppVo.SocialVo paramSocialVo);
    
    public abstract void setSpecialSubjectVo(HomeRentItem paramHomeRentItem);
    
    public abstract void setTags(ArrayList<ProjectDetailForAppVo.LabelsVo> paramArrayList);
    
    public abstract void setToInfo(ProjectDetailForAppVo.ProjectDetailInfoVo paramProjectDetailInfoVo);
    
    public abstract void setTopPic(ArrayList<String> paramArrayList);
    
    public abstract void showAllFacilities(List<RentHouseDetail.Space> paramList);
    
    public abstract void showCircleSeeHouse(String paramString);
    
    public abstract void showError(boolean paramBoolean);
    
    public abstract void showLunBoAd(ArrayList<ProjectDetailForAppVo.MiddleBannerVo> paramArrayList);
    
    public abstract void showLunBoCommentsVo(List<ProjectDetailForAppVo.CommentsVo> paramList, String paramString);
    
    public abstract void showLunBoZo(ArrayList<ProjectDetailForAppVo.ProjectZoVo> paramArrayList, String paramString);
    
    public abstract void showShare(String paramString1, String paramString2, String paramString3, String paramString4);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/meetaapartdetail/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */