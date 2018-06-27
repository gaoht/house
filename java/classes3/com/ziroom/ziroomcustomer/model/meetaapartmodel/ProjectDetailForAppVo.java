package com.ziroom.ziroomcustomer.model.meetaapartmodel;

import java.util.ArrayList;
import java.util.List;

public class ProjectDetailForAppVo
{
  public int bookPage;
  public BaseCommentsVo commentsVos;
  public BaseFacilitiesVo facilitiesVos;
  public List<BaseFacilitiesVo> facilitiesVosMore;
  public BaseHouseTypeInfoVo houseTypeInfoVos;
  public ArrayList<LabelsVo> labelsVos;
  public ArrayList<MiddleBannerVo> middleBanners;
  public ProjectDetailInfoVo projectDetailInfoVo;
  public BaseProjectInfoVo projectRecommendVos;
  public BaseProjectZoVo projectZoVos;
  public SocialVo socialVo;
  public BaseSpecialSubjectVo specialSubjectVos;
  
  public static class BaseCommentsVo
    extends ProjectDetailForAppVo.BaseProjectDetailVo
  {
    public ArrayList<ProjectDetailForAppVo.CommentsVo> list;
  }
  
  public static class BaseFacilitiesVo
    extends ProjectDetailForAppVo.BaseProjectDetailVo
  {
    public ArrayList<ProjectDetailForAppVo.FacilitiesVo> list;
    public String title;
  }
  
  public static class BaseHouseTypeInfoVo
    extends ProjectDetailForAppVo.BaseProjectDetailVo
  {
    public ArrayList<ProjectDetailForAppVo.HouseTypeInfoVo> list;
    public String title;
  }
  
  public static class BaseProjectDetailVo
  {
    public String title;
  }
  
  public static class BaseProjectInfoVo
    extends ProjectDetailForAppVo.BaseProjectDetailVo
  {
    public ArrayList<ProjectDetailForAppVo.ProjectInfoVo> list;
  }
  
  public static class BaseProjectZoVo
    extends ProjectDetailForAppVo.BaseProjectDetailVo
  {
    public ArrayList<ProjectDetailForAppVo.ProjectZoVo> list;
  }
  
  public static class BaseSpecialSubjectVo
    extends ProjectDetailForAppVo.BaseProjectDetailVo
  {
    public ArrayList<ProjectDetailForAppVo.SpecialSubjectVo> list;
  }
  
  public static class CmsProjectLabelImgsVo
  {
    public String clickUrl;
    public String imgUrl;
  }
  
  public static class CmsProjectLabelsVo
  {
    public String label;
    public ArrayList<ProjectDetailForAppVo.CmsProjectLabelImgsVo> labelImgsVos;
  }
  
  public static class CommentsVo
  {
    public String content;
    public String headerUrl;
    public String nickName;
    public String remark;
  }
  
  public static class FacilitiesVo
  {
    public String facilitiesName;
    public String iconUrl;
  }
  
  public static class HouseTypeInfoVo
  {
    public boolean book;
    public int bookCount;
    public String bookName;
    public int female;
    public String houseTypeId;
    public int isRoomFull;
    public int male;
    public String name;
    public String pic;
    public String priceRange;
    public String roomFulTag;
    public ArrayList<String> roomIds;
    public String[] roomTags;
    public boolean sign;
    public int signCount;
  }
  
  public static class LabelsVo
  {
    public String bulletContent;
    public String bulletImageUrl;
    public String bulletLogoUrl;
    public String bulletMainTitle;
    public String labelIcon;
    public String labelName;
  }
  
  public static class MiddleBannerVo
  {
    public String app;
    public String description;
    public String img;
    public String target;
    public String title;
  }
  
  public static class ProjectDetailInfoVo
  {
    public String addressText;
    public int bookState;
    public String bookUrl;
    public String briefInfo;
    public String cityId;
    public String houseTypeCount;
    public Double lat;
    public Double lng;
    public String panoramicUrl;
    public String proAddr;
    public String projectId;
    public String projectName;
    public String roomCount;
    public String shareUrl;
    public String slogan;
    public String telePhone;
    public ArrayList<ProjectDetailForAppVo.CmsProjectLabelsVo> topPicList;
  }
  
  public static class ProjectInfoVo
  {
    public String address;
    public boolean book;
    public int bookCount;
    public int isNewDetail;
    public String name;
    public String pic;
    public String priceRange;
    public String projectId;
    public boolean sign;
    public int signCount;
  }
  
  public static class ProjectZoVo
  {
    public String headPic;
    public String selfIntro;
    public String zoName;
  }
  
  public static class SocialVo
  {
    public String clickUrl;
    public int femaleCount;
    public String imageUrl;
    public String isShow;
    public int maleCount;
    public int realRoomCount;
    public String roomCount;
    public String title;
  }
  
  public static class SpecialSubjectVo
  {
    public String description;
    public String headerUrl;
    public String img;
    public String projectAddress;
    public String shareMainTitle;
    public String shareSubTitle;
    public String targetUrl;
    public String title;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/meetaapartmodel/ProjectDetailForAppVo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */