package com.ziroom.ziroomcustomer.ziroomapartment.meetaapartdetail;

import android.content.Context;
import android.content.Intent;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.findhouse.model.SurroundBean;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Config;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.Space;
import com.ziroom.ziroomcustomer.findhouse.view.ResblockMapActivity;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.home.bean.HomeRentItem;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.BaseCommentsVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.BaseFacilitiesVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.BaseProjectInfoVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.BaseProjectZoVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.BaseSpecialSubjectVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.CmsProjectLabelImgsVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.CmsProjectLabelsVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.CommentsVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.FacilitiesVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.ProjectDetailInfoVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.ProjectInfoVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.ProjectZoVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.SocialVo;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.SpecialSubjectVo;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class b
  implements a.a
{
  public String a;
  List<ProjectDetailForAppVo.CommentsVo> b = new ArrayList();
  List<ProjectDetailForAppVo.ProjectZoVo> c = new ArrayList();
  List<ProjectDetailForAppVo.BaseFacilitiesVo> d;
  String e = "{\"projectDetailInfoVo\": { \"projectName\": \"北京亚运村15自如寓\", \"slogan\": \"双线相约 ，设计之寓\", \"projectId\": \"17\", \"telePhone\": \"400-100-1111,776666\", \"panoramicUrl\": \"http://map.qq.com/?type=poi&what=%E8%87%AA%E5%A6%82%E5%AF%93(%E6%AC%A2%E4%B9%90%E8%B0%B77%E5%8F%B7%E5%B7%A5%E5%9C%BA)&c=8#pano=100130JF140911044423000&heading=7&pitch=-9&zoom=1\", \"briefInfo\": \"<p>位于奥体中心东侧500米，距鸟巢2.4公里。日本设计大师深津泰彦先生作品，日式极简风格，配有天台可供观景。共享公区更配有健身区、咖啡吧、影音区、书吧等。本栋自如寓建筑面积为6020平方米。</p>\", \"lng\": 116.419892, \"lat\": 39.991642, \"proAddr\": \"北京市朝阳区安苑东里三区5号楼\", \"shareUrl\": \"http://m.ziroomapartment.com/zra_mst/BJ/project/apart/17.html?type=1\", \"roomCount\": \"228个房间\", \"houseTypeCount\": \"4个房型\", \"topPicList\": [ { \"label\": \"公区\", \"labelImgsVos\": [ { \"imgUrl\": \"http://pic.ziroom.com//apartment/upload/20170316/1489658215378-2-gongqu.jpg\", \"clickUrl\": null }, { \"imgUrl\": \"http://pic.ziroom.com//apartment/upload/20170316/1489658210135-1-gongqu.jpg\", \"clickUrl\": null } ] }, { \"label\": \"露台\", \"labelImgsVos\": [ { \"imgUrl\": \"http://pic.ziroom.com//apartment/upload/20170316/1489658233764-3-lutai.jpg\", \"clickUrl\": null } ] }, { \"label\": \"厨房\", \"labelImgsVos\": [ { \"imgUrl\": \"http://pic.ziroom.com//apartment/upload/20170316/1489658242640-4-chufang.jpg\", \"clickUrl\": null } ] }, { \"label\": \"健身房\", \"labelImgsVos\": [ { \"imgUrl\": \"http://pic.ziroom.com//apartment/upload/20170316/1489658252443-5-jianshenfang.jpg\", \"clickUrl\": null } ] } ], \"cityId\": \"110000\" }, \"labelsVos\": [ { \"labelName\": \"标签名1（不超过8个字）\", \"bulletMainTitle\": \"弹层主标题1（不超过12个字）\", \"bulletSubTitle\": \"弹层副标题1（不超过18个字）\", \"bulletContent\": \"弹层内容1\", \"bulletImageUrl\": \"弹层图片链接地址1\" }, { \"labelName\": \"标签名2（不超过8个字）\", \"bulletMainTitle\": \"弹层主标题2（不超过12个字）\", \"bulletSubTitle\": \"弹层副标题2（不超过18个字）\", \"bulletContent\": \"弹层内容2\", \"bulletImageUrl\": \"弹层图片链接地址2\" }, { \"labelName\": \"标签名3（不超过8个字）\", \"bulletMainTitle\": \"弹层主标题3（不超过12个字）\", \"bulletSubTitle\": \"弹层副标题3（不超过18个字）\", \"bulletContent\": \"弹层内容3\", \"bulletImageUrl\": \"弹层图片链接地址3\" } ], \"commentsVos\": { \"title\": \"自如客说\", \"list\": [ { \"nickName\": \"自如客姓名1\", \"headerUrl\": \"自如客头像地址1\", \"content\": \"评价内容1\" }, { \"nickName\": \"自如客姓名2\", \"headerUrl\": \"自如客头像地址2\", \"content\": \"评价内容2\" }, { \"nickName\": \"自如客姓名3\", \"headerUrl\": \"自如客头像地址3\", \"content\": \"评价内容3\" } ] }, \"middleBanners\": [ { \"img\": \"http://image.ziroom.com/g2/M00/41/B3/ChAFD1qmM0WAQ4p1AAERcm3HIpg015.jpg（封面图片链接地址1）\", \"title\": \"\", \"description\": \"\", \"target\": \"运营位落地页链接1\", \"app\": \"0（落地页是H5）\" }, { \"img\": \"http://image.ziroom.com/g2/M00/41/B2/ChAFD1qmMnyARWtSAAPkuzG4DYc908.jpg（封面图片链接地址2）\", \"title\": \"\", \"description\": \"\", \"target\": \"运营位落地页链接2\", \"app\": \"0（落地页是H5）\" } ], \"socialVo\": { \"title\": \"入住信息栏目标题\", \"clickUrl\": null, \"imageUrl\": null, \"maleCount\": 207, \"femaleCount\": 162, \"roomCount\": \"0\", \"realRoomCount\": 0 }, \"specialSubjectVos\": { \"title\": \"寓客人物\", \"list\": [ { \"img\": \"http://image.ziroom.com/g2/M00/41/B2/ChAFD1qmMnyARWtSAAPkuzG4DYc908.jpg（图片链接地址1）\", \"title\": \"首页标题1（分享标题）\", \"description\": \"首页描述1（分享副标题）\", \"headerUrl\": \"头像图片链接地址1\", \"targetUrl\": \"http://image.ziroom.com/g2/M00/41/B2/ChAFD1qmMnyARWtSAAPkuzG4DYc908.jpg（落地页地址）\" }, { \"img\": \"http://image.ziroom.com/g2/M00/41/B2/ChAFD1qmMnyARWtSAAPkuzG4DYc908.jpg（落地页地址2）\", \"title\": \"首页标题2（分享标题）\", \"description\": \"首页描述2（分享副标题）\", \"headerUrl\": \"头像图片链接地址2\", \"targetUrl\": \"http://image.ziroom.com/g2/M00/41/B2/ChAFD1qmMnyARWtSAAPkuzG4DYc908.jpg（落地页地址）\" } ] }, \"projectZoVos\": { \"title\": \"精选管家\", \"list\": [ { \"zoName\": \"闾一鑫\", \"headPic\": \"/apartment/upload/20160902/1472831402897-1447382239783-luyixin_x.jpg\", \"selfIntro\": \"自幼学习音乐，接受专业教育，多重化人格，德国式的严谨、法国式的浪漫、中国式的人情味在他身上都有体现（水瓶座的怪逼……）；拿得了螺丝刀，穿的了西装，用的了抹布，聊的了音乐（水瓶座的怪逼……）；能写文案，能组织活动，能设计海报，能主持节目（水瓶座的怪逼……），因此被楼内的自如客称为“万能的大鑫子”。也许我还存在很多缺点，但我愿意在您的指引下细心改进。\" }, { \"zoName\": \"田小芳\", \"headPic\": \"\", \"selfIntro\": \"\" }, { \"zoName\": \"卜书杰\", \"headPic\": \"\", \"selfIntro\": \"\" }, { \"zoName\": null, \"headPic\": \"/apartment/upload/20160902/1472831278849-1468809183417-liming_x.jpg\", \"selfIntro\": \"我并不是个天才，但是我聪敏好学；我并不是个男人，但是我踏实能干。生活中，我追求的是品质，工作中，我追求的是质量和效率！我是李敏，我为自己“带盐”！我想告诉你的是，生活不止眼前的苟且，除了诗和远方，还有自如寓，这儿，永远是你的家！\" }, { \"zoName\": \"孔令富\", \"headPic\": \"/apartment/upload/20160902/1472831062793-1468809496631-konglingfu_x.jpg\", \"selfIntro\": \"我是一个热爱篮球、桌游、美食、电影、旅游……（总结为一句话就是爱好广泛）的九零后非典型处女座大男孩儿，身为北方人的我为人豪爽，性格外向活泼开朗，喜欢结交朋友（自来熟类型），乐于尝试新鲜事物，很开心能够加入自如寓这个大家庭，我在这儿等你。\" } ] }, \"projectRecommendVos\": { \"title\": \"为您推荐\", \"list\": [ { \"name\": \"北京上地凌云自如寓\", \"priceRange\": \"4199.0 - 7199.0\", \"pic\": \"/apartment/upload/20170316/1489654022196-shangdi.jpg\", \"bookCount\": 46, \"signCount\": 0, \"bookName\": \"可预订\", \"signName\": \"\", \"projectId\": \"21\", \"address\": \"北京市海淀区安宁庄西三条九号院宜品上层四单元\" } ] }, \"houseTypeInfoVos\": { \"title\": \"房型简介\", \"list\": [ { \"name\": \"CK\", \"priceRange\": \"4903.0 - 3599.0\", \"pic\": \"/apartment/upload/20160901/1472713165274-yycCK.jpg\", \"bookCount\": 161, \"signCount\": 0, \"bookName\": \"可预订\", \"signName\": \"\", \"houseTypeId\": \"ff80808148e981940148e9ac8da70013\", \"male\": null, \"female\": null, \"roomIds\": [ \"1002048\" ] }, { \"name\": \"EK-A\", \"priceRange\": \"6300.0 - 5700.0\", \"pic\": \"/apartment/upload/20170216/1487213702090-301900556514068474.jpg\", \"bookCount\": 11, \"signCount\": 0, \"bookName\": \"可预订\", \"signName\": \"\", \"houseTypeId\": \"ff80808148f9ac210148f9b02ea6000b\", \"male\": null, \"female\": null, \"roomIds\": [ \"1001843\" ] }, { \"name\": \"SLK\", \"priceRange\": \"8188.0 - 8188.0\", \"pic\": \"/apartment/upload/20160901/1472713295406-yycSLK.jpg\", \"bookCount\": 3, \"signCount\": 0, \"bookName\": \"可预订\", \"signName\": \"\", \"houseTypeId\": \"ff80808148f9ac210148f9b9c8040016\", \"male\": null, \"female\": null, \"roomIds\": [ \"1002018\", \"1002030\", \"1002036\", \"1002044\" ] }, { \"name\": \"EK-B\", \"priceRange\": \"5900.0 - 4480.0\", \"pic\": \"/apartment/upload/20160901/1472713244721-yycEKB.jpg\", \"bookCount\": 7, \"signCount\": 0, \"bookName\": \"可预订\", \"signName\": \"\", \"houseTypeId\": \"ff8080814911e87f014911ef3d680003\", \"male\": null, \"female\": null, \"roomIds\": [ \"1001944\", \"1001983\", \"1001985\" ] } ] }, \"facilitiesVos\": null }";
  private WeakReference<a.b> f;
  private ArrayList<String> g;
  private ArrayList<String> h;
  private ArrayList<Integer> i;
  private ArrayList<String> j;
  private ProjectDetailForAppVo k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  
  public b(a.b paramb)
  {
    if (paramb != null)
    {
      this.f = new WeakReference(paramb);
      paramb.setPresenter(this);
    }
  }
  
  private void a(ProjectDetailForAppVo.BaseSpecialSubjectVo paramBaseSpecialSubjectVo)
  {
    HomeRentItem localHomeRentItem = new HomeRentItem();
    localHomeRentItem.setTitle(paramBaseSpecialSubjectVo.title);
    ArrayList localArrayList = new ArrayList();
    if (paramBaseSpecialSubjectVo.list != null)
    {
      int i1 = 0;
      while (i1 < paramBaseSpecialSubjectVo.list.size())
      {
        ContentBean localContentBean = new ContentBean();
        localContentBean.img = ((ProjectDetailForAppVo.SpecialSubjectVo)paramBaseSpecialSubjectVo.list.get(i1)).img;
        localContentBean.pic = ((ProjectDetailForAppVo.SpecialSubjectVo)paramBaseSpecialSubjectVo.list.get(i1)).headerUrl;
        localContentBean.setLink(((ProjectDetailForAppVo.SpecialSubjectVo)paramBaseSpecialSubjectVo.list.get(i1)).targetUrl);
        localContentBean.setDescribe(((ProjectDetailForAppVo.SpecialSubjectVo)paramBaseSpecialSubjectVo.list.get(i1)).description);
        localContentBean.setTitle(((ProjectDetailForAppVo.SpecialSubjectVo)paramBaseSpecialSubjectVo.list.get(i1)).title);
        localArrayList.add(localContentBean);
        i1 += 1;
      }
    }
    localHomeRentItem.setContent(localArrayList);
    paramBaseSpecialSubjectVo = getView();
    if ((paramBaseSpecialSubjectVo != null) && (paramBaseSpecialSubjectVo.isActive())) {
      paramBaseSpecialSubjectVo.setSpecialSubjectVo(localHomeRentItem);
    }
  }
  
  private void a(ProjectDetailForAppVo paramProjectDetailForAppVo)
  {
    boolean bool = true;
    a.b localb = getView();
    if ((localb != null) && (localb.isActive()) && (paramProjectDetailForAppVo != null) && (paramProjectDetailForAppVo != null))
    {
      this.k = paramProjectDetailForAppVo;
      b(paramProjectDetailForAppVo);
      b(paramProjectDetailForAppVo);
      setSliders(paramProjectDetailForAppVo.projectDetailInfoVo.topPicList);
      localb.setTopPic(this.g);
      localb.setToInfo(paramProjectDetailForAppVo.projectDetailInfoVo);
      localb.setTags(paramProjectDetailForAppVo.labelsVos);
      localb.setSocialVoInfo(paramProjectDetailForAppVo.socialVo);
      localb.showLunBoAd(paramProjectDetailForAppVo.middleBanners);
      if (paramProjectDetailForAppVo.projectDetailInfoVo == null) {
        break label307;
      }
      if (paramProjectDetailForAppVo.projectDetailInfoVo.bookState != 1) {
        break label302;
      }
      localb.setBtnB(bool);
    }
    for (;;)
    {
      if ((paramProjectDetailForAppVo.facilitiesVos != null) && (paramProjectDetailForAppVo.facilitiesVos.list != null) && (paramProjectDetailForAppVo.facilitiesVos.list.size() > 0)) {
        localb.setFacilitiesVo(paramProjectDetailForAppVo.facilitiesVos.list, paramProjectDetailForAppVo.facilitiesVos.title);
      }
      localb.setHouseTypeInfoVo(paramProjectDetailForAppVo.houseTypeInfoVos, this.a, this.q);
      if ((paramProjectDetailForAppVo.commentsVos != null) && (paramProjectDetailForAppVo.commentsVos.list != null)) {
        localb.showLunBoCommentsVo(paramProjectDetailForAppVo.commentsVos.list, paramProjectDetailForAppVo.commentsVos.title);
      }
      if ((paramProjectDetailForAppVo.projectZoVos != null) && (paramProjectDetailForAppVo.projectZoVos.list != null)) {
        localb.showLunBoZo(paramProjectDetailForAppVo.projectZoVos.list, paramProjectDetailForAppVo.projectZoVos.title);
      }
      if (paramProjectDetailForAppVo.specialSubjectVos != null) {
        a(paramProjectDetailForAppVo.specialSubjectVos);
      }
      if (paramProjectDetailForAppVo.projectRecommendVos != null) {
        setRecommendVo(paramProjectDetailForAppVo.projectRecommendVos);
      }
      return;
      label302:
      bool = false;
      break;
      label307:
      localb.setBtnB(false);
    }
  }
  
  private void b(ProjectDetailForAppVo paramProjectDetailForAppVo)
  {
    if (paramProjectDetailForAppVo.projectDetailInfoVo != null)
    {
      this.q = paramProjectDetailForAppVo.projectDetailInfoVo.projectName;
      this.m = ("自如寓--" + paramProjectDetailForAppVo.projectDetailInfoVo.projectName);
      this.l = paramProjectDetailForAppVo.projectDetailInfoVo.panoramicUrl;
      this.n = paramProjectDetailForAppVo.projectDetailInfoVo.shareUrl;
      if ((paramProjectDetailForAppVo.projectDetailInfoVo.topPicList != null) && (paramProjectDetailForAppVo.projectDetailInfoVo.topPicList.size() > 0) && (((ProjectDetailForAppVo.CmsProjectLabelsVo)paramProjectDetailForAppVo.projectDetailInfoVo.topPicList.get(0)).labelImgsVos != null) && (((ProjectDetailForAppVo.CmsProjectLabelsVo)paramProjectDetailForAppVo.projectDetailInfoVo.topPicList.get(0)).labelImgsVos.size() > 0)) {
        this.o = ((ProjectDetailForAppVo.CmsProjectLabelImgsVo)((ProjectDetailForAppVo.CmsProjectLabelsVo)paramProjectDetailForAppVo.projectDetailInfoVo.topPicList.get(0)).labelImgsVos.get(0)).imgUrl;
      }
      this.p = paramProjectDetailForAppVo.projectDetailInfoVo.proAddr;
    }
  }
  
  public void call()
  {
    if (this.k == null) {}
    while (this.k.projectDetailInfoVo == null) {
      return;
    }
    ah.callPhone(getView().getViewContext(), this.k.projectDetailInfoVo.telePhone);
  }
  
  public void detachView() {}
  
  public List<ProjectDetailForAppVo.CommentsVo> getCommentsVoList()
  {
    return this.b;
  }
  
  public void getData(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("projectId", paramString);
    this.a = paramString;
    paramString = getView();
    if (paramString != null) {
      j.getMeeTaApartDtl(paramString.getViewContext(), localHashMap, new com.ziroom.ziroomcustomer.e.a.c(paramString.getViewContext(), new m(ProjectDetailForAppVo.class, new com.ziroom.ziroomcustomer.e.c.a.c()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          paramAnonymousThrowable = b.this.getView();
          if ((paramAnonymousThrowable != null) && (paramAnonymousThrowable.isActive())) {
            paramAnonymousThrowable.showError(true);
          }
        }
        
        public void onSuccess(int paramAnonymousInt, ProjectDetailForAppVo paramAnonymousProjectDetailForAppVo)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousProjectDetailForAppVo);
          a.b localb = b.this.getView();
          if ((localb != null) && (localb.isActive()))
          {
            localb.showError(false);
            b.a(b.this, paramAnonymousProjectDetailForAppVo);
          }
        }
      });
    }
  }
  
  public ArrayList<String> getSliders()
  {
    return this.g;
  }
  
  public ArrayList<Integer> getSlidersTypeIndexs()
  {
    return this.i;
  }
  
  public ArrayList<String> getSlidersTypes()
  {
    return this.h;
  }
  
  public ArrayList<String> getUrl()
  {
    return this.j;
  }
  
  public a.b getView()
  {
    if (this.f != null) {
      return (a.b)this.f.get();
    }
    return null;
  }
  
  public List<ProjectDetailForAppVo.ProjectZoVo> getZoVoList()
  {
    return this.c;
  }
  
  public void setRecommendVo(ProjectDetailForAppVo.BaseProjectInfoVo paramBaseProjectInfoVo)
  {
    HomeRentItem localHomeRentItem = new HomeRentItem();
    localHomeRentItem.setTitle(paramBaseProjectInfoVo.title);
    ArrayList localArrayList = new ArrayList();
    if (paramBaseProjectInfoVo.list != null)
    {
      int i1 = 0;
      while (i1 < paramBaseProjectInfoVo.list.size())
      {
        ContentBean localContentBean = new ContentBean();
        localContentBean.img = ((ProjectDetailForAppVo.ProjectInfoVo)paramBaseProjectInfoVo.list.get(i1)).pic;
        localContentBean.describe = ((ProjectDetailForAppVo.ProjectInfoVo)paramBaseProjectInfoVo.list.get(i1)).priceRange;
        localContentBean.title = ((ProjectDetailForAppVo.ProjectInfoVo)paramBaseProjectInfoVo.list.get(i1)).name;
        localContentBean.subtitle = ((ProjectDetailForAppVo.ProjectInfoVo)paramBaseProjectInfoVo.list.get(i1)).address;
        localContentBean.isNewDetail = ((ProjectDetailForAppVo.ProjectInfoVo)paramBaseProjectInfoVo.list.get(i1)).isNewDetail;
        localContentBean.projectId = ((ProjectDetailForAppVo.ProjectInfoVo)paramBaseProjectInfoVo.list.get(i1)).projectId;
        localArrayList.add(localContentBean);
        i1 += 1;
      }
    }
    localHomeRentItem.setContent(localArrayList);
    paramBaseProjectInfoVo = getView();
    if ((paramBaseProjectInfoVo != null) && (paramBaseProjectInfoVo.isActive())) {
      paramBaseProjectInfoVo.setProjectRecommendVos(localHomeRentItem);
    }
  }
  
  public void setSliders(ArrayList<ProjectDetailForAppVo.CmsProjectLabelsVo> paramArrayList)
  {
    this.j = new ArrayList();
    this.g = new ArrayList();
    this.h = new ArrayList();
    this.i = new ArrayList();
    if (paramArrayList == null) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (ProjectDetailForAppVo.CmsProjectLabelsVo)paramArrayList.next();
      this.h.add(((ProjectDetailForAppVo.CmsProjectLabelsVo)localObject).label);
      this.i.add(Integer.valueOf(this.g.size()));
      localObject = ((ProjectDetailForAppVo.CmsProjectLabelsVo)localObject).labelImgsVos.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ProjectDetailForAppVo.CmsProjectLabelImgsVo localCmsProjectLabelImgsVo = (ProjectDetailForAppVo.CmsProjectLabelImgsVo)((Iterator)localObject).next();
        this.g.add(localCmsProjectLabelImgsVo.imgUrl);
        this.j.add(localCmsProjectLabelImgsVo.clickUrl + "");
      }
    }
    u.d("mSliders---->", this.g.size() + "----");
  }
  
  public void showAllFacilities()
  {
    if (this.k == null) {}
    ArrayList localArrayList1;
    Object localObject1;
    do
    {
      do
      {
        return;
        this.d = this.k.facilitiesVosMore;
      } while ((this.d == null) || (this.d.size() <= 0));
      localArrayList1 = new ArrayList();
      int i1 = 0;
      while (i1 < this.d.size())
      {
        Object localObject2 = (ProjectDetailForAppVo.BaseFacilitiesVo)this.d.get(i1);
        localObject1 = new RentHouseDetail.Space();
        ((RentHouseDetail.Space)localObject1).setName(((ProjectDetailForAppVo.BaseFacilitiesVo)localObject2).title);
        ArrayList localArrayList2 = new ArrayList();
        localObject2 = ((ProjectDetailForAppVo.BaseFacilitiesVo)localObject2).list.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ProjectDetailForAppVo.FacilitiesVo localFacilitiesVo = (ProjectDetailForAppVo.FacilitiesVo)((Iterator)localObject2).next();
          RentHouseDetail.Config localConfig = new RentHouseDetail.Config();
          localConfig.setName(localFacilitiesVo.facilitiesName);
          localConfig.setIcon(localFacilitiesVo.iconUrl);
          localArrayList2.add(localConfig);
        }
        ((RentHouseDetail.Space)localObject1).setConfig(localArrayList2);
        localArrayList1.add(localObject1);
        i1 += 1;
      }
      localObject1 = getView();
    } while ((localObject1 == null) || (!((a.b)localObject1).isActive()));
    ((a.b)localObject1).showAllFacilities(localArrayList1);
  }
  
  public void showCircleSeeHouse()
  {
    a.b localb = getView();
    if ((localb != null) && (localb.isActive())) {
      localb.showCircleSeeHouse(this.l);
    }
  }
  
  public void showShare()
  {
    a.b localb = getView();
    if ((localb != null) && (localb.isActive())) {
      localb.showShare(this.m, this.n, this.o, this.p);
    }
  }
  
  public void start() {}
  
  public void toBook()
  {
    if (this.k == null) {}
    while (this.k.projectDetailInfoVo == null) {
      return;
    }
    if (ApplicationEx.c.getUser() == null)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(getView().getViewContext());
      return;
    }
    String str = this.k.projectDetailInfoVo.bookUrl + "?projectId=" + this.a + "&uid=" + ApplicationEx.c.getUser().getUid() + "&phone=" + ApplicationEx.c.getUser().getPhone() + "&name=" + ApplicationEx.c.getUser().getRealName();
    JsBridgeWebActivity.start(getView().getViewContext(), "", str);
  }
  
  public void toMapRetrieve()
  {
    if (this.k == null) {}
    while (this.k.projectDetailInfoVo == null) {
      return;
    }
    Intent localIntent = new Intent(getView().getViewContext(), ResblockMapActivity.class);
    localIntent.putExtra("surround", (Serializable)com.alibaba.fastjson.a.parseArray(this.k.projectDetailInfoVo.addressText, SurroundBean.class));
    localIntent.putExtra("lat", this.k.projectDetailInfoVo.lat + "");
    localIntent.putExtra("lng", this.k.projectDetailInfoVo.lng + "");
    localIntent.putExtra("resblock_name", this.k.projectDetailInfoVo.projectName);
    getView().getViewContext().startActivity(localIntent);
  }
  
  public void toMeeta()
  {
    if (this.k == null) {}
    while (this.k.socialVo == null) {
      return;
    }
    Intent localIntent = new Intent(getView().getViewContext(), MeetaCircleActivity.class);
    localIntent.putExtra("projectId", this.a);
    localIntent.putExtra("url", this.k.socialVo.clickUrl);
    getView().getViewContext().startActivity(localIntent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/meetaapartdetail/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */