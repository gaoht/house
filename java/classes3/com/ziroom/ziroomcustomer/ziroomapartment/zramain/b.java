package com.ziroom.ziroomcustomer.ziroomapartment.zramain;

import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.home.bean.ContentBean.SmallPic;
import com.ziroom.ziroomcustomer.home.bean.HomeRentItem;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.ActivityBean;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.ActivityBean.LunboBeanXXXXXX;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.BannerBean;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.BusinessBean;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.HeadBean;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.HouseBean;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.HouseBean.LunboBeanXX;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.IconBean;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.MoreBean;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.MoreBean.LunboBeanXXXXXXX;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.ZiroomerBean;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.ZiroomerBean.LunboBeanXXXXX;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.ZryBean;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.ZryBean.LunboBeanXXXX;
import com.ziroom.ziroomcustomer.model.apartment.zramain.ZraMainBean.ZryBean.LunboBeanXXXX.ThumbnailsBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class b
  implements a.a
{
  WeakReference<a.b> a;
  
  public b(a.b paramb)
  {
    this.a = new WeakReference(paramb);
    paramb = getView();
    if (paramb != null) {
      paramb.setPresenter(this);
    }
  }
  
  public void detachView() {}
  
  public a.b getView()
  {
    if (this.a != null) {
      return (a.b)this.a.get();
    }
    return null;
  }
  
  public void start()
  {
    int k = 0;
    ZraMainBean localZraMainBean = (ZraMainBean)e.parseObject("{\n        \"head\": {\n            \"title\": \"自如寓\",\n            \"subtitle\": \"城市独栋高品质青年社区\",\n            \"lunbo\": {\n                \"img\": \"http://image.ziroom.com/g2/M00/3C/71/ChAFfVqipxWAUwu0AAd3D4AjrVI823.jpg\",\n                \"title\": \"分享标题\",\n                \"description\": \"分享副标题\",\n                \"allBoolParamas\": 0,\n                \"target\": \"http://zhuanti.ziroom.com/zhuanti/minsu/activity/yaoqing/index.html\",\n                \"app\": \"0\"\n            }\n        },\n        \"icon\": {\n            \"lunbo\": [{\n                    \"img\": \"http://image.ziroom.com/g2/M00/3D/E1/ChAFD1qjt-6AKAlFAAAT4nYmgU4361.png\",\n                    \"title\": \"入口文案\",\n                    \"description\": \"\",\n                    \"target\": \"\",\n                    \"app\": \"0\"\n                },\n                {\n                    \"img\": \"http://image.ziroom.com/g2/M00/3D/E1/ChAFD1qjt-6AKAlFAAAT4nYmgU4361.png\",\n                    \"title\": \"入口文案\",\n                    \"description\": \"\",\n                    \"target\": \"\",\n                    \"app\": \"1\"\n                },\n                {\n                    \"img\": \"http://image.ziroom.com/g2/M00/3D/E1/ChAFD1qjt-6AKAlFAAAT4nYmgU4361.png\",\n                    \"title\": \"入口文案\",\n                    \"description\": \"\",\n                    \"target\": \"\",\n                    \"app\": \"1\"\n                },\n                {\n                    \"img\": \"http://image.ziroom.com/g2/M00/3D/E1/ChAFD1qjt-6AKAlFAAAT4nYmgU4361.png\",\n                    \"title\": \"入口文案\",\n                    \"description\": \"\",\n                    \"target\": \"\",\n                    \"app\": \"1\"\n                }\n            ]\n        },\n        \"house\": {\n            \"title\": \"推荐房型\",\n            \"lunbo\": [{\n                    \"img\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                    \"title\": \"自如寓名+房型名\",\n                    \"description\": \"描述一下房型的特点\",\n                    \"target\": \"房型ID\",\n                    \"price\": \"￥3999-4999\",\n                    \"app\": \"2\"\n                },\n                {\n                    \"img\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                    \"title\": \"MEETA自如寓·超赞房型\",\n                    \"description\": \"可以养宠物\",\n                    \"target\": \"房型ID\",\n                    \"price\": \"￥2999-3299\",\n                    \"app\": \"2\"\n                }\n            ]\n        },\n        \"banner\": {\n            \"lunbo\": [{\n                    \"img\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                    \"title\": \"H5页面标题即分享标题\",\n                    \"description\": \"分享副标题\",\n                    \"allBoolParamas\": 0,\n                    \"target\": \"http://zhuanti.ziroom.com/zhuanti/minsu/activity/yaoqing/index.html\",\n                    \"app\": \"0\"\n                },\n                {\n                    \"img\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                    \"title\": \"H5页面标题即分享标题\",\n                    \"description\": \"分享副标题\",\n                    \"allBoolParamas\": 0,\n                    \"target\": \"http://zhuanti.ziroom.com/zhuanti/minsu/activity/yaoqing/index.html\",\n                    \"app\": \"0\"\n                }\n            ]\n        },\n        \"zry\": {\n            \"title\": \"推荐自如寓\",\n            \"lunbo\": [{\n                    \"img\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                    \"title\": \"标题\",\n                    \"subtitle\": \"副标题\",\n                    \"projectName\": \"项目名称\",\n                    \"shortRentLabel\": \"可短租\",\n                    \"projectInfoLabel\": \"五方桥 | 8个户型 | 105个房间\",\n                    \"price\": \"￥2999起\",\n                    \"target\": \"09\",\n                    \"app\": \"1\",\n                    \"thumbnails\": [{\n                        \"target\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                        \"description\": \"公区\"\n                    }, {\n                        \"target\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                        \"description\": \"健身房\"\n                    }, {\n                        \"target\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                        \"description\": \"宠物区\"\n                    }]\n\n\n                },\n                {\n                    \"img\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                    \"title\": \"标题\",\n                    \"subtitle\": \"副标题\",\n                    \"projectName\": \"项目名称\",\n                    \"shortRentLabel\": \"可短租\",\n                    \"projectInfoLabel\": \"五方桥 | 8个户型 | 105个房间\",\n                    \"price\": \"￥2999起\",\n                    \"target\": \"09\",\n                    \"app\": \"1\",\n                    \"thumbnails\": [{\n                        \"target\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                        \"description\": \"公区\"\n                    }, {\n                        \"target\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                        \"description\": \"健身房\"\n                    }, {\n                        \"target\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                        \"description\": \"宠物区\"\n                    }]\n\n\n                }\n            ]\n        },\n        \"ziroomer\": {\n            \"title\": \"寓客人物\",\n            \"lunbo\": [{\n                    \"img\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg&|http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                    \"title\": \"标题即分享标题\",\n                    \"headImg\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg&|http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                    \"description\": \"描述即分享副标题\",\n                    \"target\": \"http://zhuanti.ziroom.com/zhuanti/minsu/activity/yaoqing/index.html\",\n                    \"app\": \"0\"\n                },\n                {\n                    \"img\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg&|http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                    \"title\": \"标题即分享标题\",\n                    \"headImg\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg&|http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                    \"description\": \"描述即分享副标题\",\n                    \"target\": \"http://zhuanti.ziroom.com/zhuanti/minsu/activity/yaoqing/index.html\",\n                    \"app\": \"0\"\n                }\n            ]\n        },\n        \"activity\": {\n            \"title\": \"社区活动\",\n            \"lunbo\": [{\n                    \"img\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                    \"title\": \"标题即分享标题\",\n                    \"description\": \"描述即分享副标题\",\n                    \"target\": \"http://zhuanti.ziroom.com/zhuanti/minsu/activity/yaoqing/index.html\",\n                    \"app\": \"0\"\n                },\n                {\n                    \"img\": \"http://image.ziroom.com/g2/M00/3C/86/ChAFD1qizBqAfZXTAAG9p8dl_Y0068.jpg\",\n                    \"title\": \"标题即分享标题\",\n                    \"description\": \"描述即分享副标题\",\n                    \"target\": \"http://zhuanti.ziroom.com/zhuanti/minsu/activity/yaoqing/index.html\",\n                    \"app\": \"0\"\n                }\n            ]\n        },\n        \"more\": {\n            \"title\": \"更多推荐自如寓\",\n            \"lunbo\": [{\n                    \"img\": \"http://image.ziroom.com/g2/M00/3A/C6/ChAFD1qiAeqAO-HEAAeUg902y6s442.jpg\",\n                    \"title\": \"标题\",\n                    \"description\": \"\",\n                    \"target\": \"项目ID\",\n                    \"address\": \"项目地址\",\n                    \"price\": \"￥2999/月起\",\n                    \"app\": \"1\"\n                },\n                {\n                    \"img\": \"http://image.ziroom.com/g2/M00/3C/86/ChAFD1qizBqAfZXTAAG9p8dl_Y0068.jpg\",\n                    \"title\": \"标题\",\n                    \"description\": \"\",\n                    \"target\": \"项目ID\",\n                    \"address\": \"项目地址\",\n                    \"price\": \"￥2999/月起\",\n                    \"app\": \"1\"\n                }\n            ]\n        },\n        \"business\": {\n            \"business_mail\": \"yeq34@ziroom.com\",\n            \"business_tel\": \"4001001111转778888\"\n        }\n    }", ZraMainBean.class);
    if (localZraMainBean != null)
    {
      Object localObject1 = localZraMainBean.head;
      a.b localb = getView();
      localb.showTop((ZraMainBean.HeadBean)localObject1);
      if (localZraMainBean.icon != null) {
        localb.showBanner(localZraMainBean.icon.lunbo);
      }
      ArrayList localArrayList;
      int i;
      ContentBean localContentBean;
      Object localObject2;
      if (localZraMainBean.house != null)
      {
        localObject1 = new HomeRentItem();
        ((HomeRentItem)localObject1).setTitle(localZraMainBean.house.title);
        localArrayList = new ArrayList();
        if ((localZraMainBean.house.lunbo != null) && (localZraMainBean.house.lunbo.size() > 0))
        {
          i = 0;
          while (i < localZraMainBean.house.lunbo.size())
          {
            localContentBean = new ContentBean();
            localObject2 = (ZraMainBean.HouseBean.LunboBeanXX)localZraMainBean.house.lunbo.get(i);
            localContentBean.pic = ((ZraMainBean.HouseBean.LunboBeanXX)localObject2).img;
            localContentBean.title = ((ZraMainBean.HouseBean.LunboBeanXX)localObject2).title;
            localContentBean.subtitle = ((ZraMainBean.HouseBean.LunboBeanXX)localObject2).description;
            localContentBean.price = ((ZraMainBean.HouseBean.LunboBeanXX)localObject2).price;
            localContentBean.app = ((ZraMainBean.HouseBean.LunboBeanXX)localObject2).app;
            localContentBean.target = ((ZraMainBean.HouseBean.LunboBeanXX)localObject2).target;
            localArrayList.add(localContentBean);
            i += 1;
          }
        }
        ((HomeRentItem)localObject1).setContent(localArrayList);
        localb.showRecommendHouseType((HomeRentItem)localObject1);
      }
      if (localZraMainBean.banner != null) {
        localb.showLunboAd(localZraMainBean.banner.lunbo);
      }
      if (localZraMainBean.zry != null)
      {
        localObject1 = new HomeRentItem();
        ((HomeRentItem)localObject1).setTitle(localZraMainBean.zry.title);
        localArrayList = new ArrayList();
        if ((localZraMainBean.house.lunbo != null) && (localZraMainBean.zry.lunbo.size() > 0))
        {
          i = 0;
          while (i < localZraMainBean.zry.lunbo.size())
          {
            localContentBean = new ContentBean();
            localObject2 = (ZraMainBean.ZryBean.LunboBeanXXXX)localZraMainBean.zry.lunbo.get(i);
            if (localObject2 != null)
            {
              localContentBean.pic = ((ZraMainBean.ZryBean.LunboBeanXXXX)localObject2).img;
              localContentBean.title = ((ZraMainBean.ZryBean.LunboBeanXXXX)localObject2).projectName;
              localContentBean.titleTag = ((ZraMainBean.ZryBean.LunboBeanXXXX)localObject2).shortRentLabel;
              localContentBean.subtitle = ((ZraMainBean.ZryBean.LunboBeanXXXX)localObject2).projectInfoLabel;
              localContentBean.price = ((ZraMainBean.ZryBean.LunboBeanXXXX)localObject2).price;
              localContentBean.app = ((ZraMainBean.ZryBean.LunboBeanXXXX)localObject2).app;
              localContentBean.target = ((ZraMainBean.ZryBean.LunboBeanXXXX)localObject2).target;
              localContentBean.share_title = ((ZraMainBean.ZryBean.LunboBeanXXXX)localObject2).title;
              localContentBean.share_content = ((ZraMainBean.ZryBean.LunboBeanXXXX)localObject2).subtitle;
              localContentBean.smallList = new ArrayList();
              if ((((ZraMainBean.ZryBean.LunboBeanXXXX)localObject2).thumbnails != null) && (((ZraMainBean.ZryBean.LunboBeanXXXX)localObject2).thumbnails.size() > 0))
              {
                int j = 0;
                while (j < ((ZraMainBean.ZryBean.LunboBeanXXXX)localObject2).thumbnails.size())
                {
                  ContentBean.SmallPic localSmallPic = new ContentBean.SmallPic();
                  localSmallPic.smaPic = ((ZraMainBean.ZryBean.LunboBeanXXXX.ThumbnailsBean)((ZraMainBean.ZryBean.LunboBeanXXXX)localObject2).thumbnails.get(j)).target;
                  localSmallPic.smaTitle = ((ZraMainBean.ZryBean.LunboBeanXXXX.ThumbnailsBean)((ZraMainBean.ZryBean.LunboBeanXXXX)localObject2).thumbnails.get(j)).description;
                  localContentBean.smallList.add(localSmallPic);
                  j += 1;
                }
              }
            }
            localArrayList.add(localContentBean);
            i += 1;
          }
        }
        ((HomeRentItem)localObject1).setContent(localArrayList);
        localb.showRecommendApartment((HomeRentItem)localObject1);
      }
      if (localZraMainBean.ziroomer != null)
      {
        localObject1 = new HomeRentItem();
        ((HomeRentItem)localObject1).setTitle(localZraMainBean.ziroomer.title);
        localArrayList = new ArrayList();
        if ((localZraMainBean.ziroomer.lunbo != null) && (localZraMainBean.ziroomer.lunbo.size() > 0))
        {
          i = 0;
          while (i < localZraMainBean.ziroomer.lunbo.size())
          {
            localContentBean = new ContentBean();
            localObject2 = (ZraMainBean.ZiroomerBean.LunboBeanXXXXX)localZraMainBean.ziroomer.lunbo.get(i);
            localContentBean.pic = ((ZraMainBean.ZiroomerBean.LunboBeanXXXXX)localObject2).img;
            localContentBean.headPic = ((ZraMainBean.ZiroomerBean.LunboBeanXXXXX)localObject2).headImg;
            localContentBean.title = ((ZraMainBean.ZiroomerBean.LunboBeanXXXXX)localObject2).title;
            localContentBean.subtitle = ((ZraMainBean.ZiroomerBean.LunboBeanXXXXX)localObject2).description;
            localContentBean.app = ((ZraMainBean.ZiroomerBean.LunboBeanXXXXX)localObject2).app;
            localContentBean.target = ((ZraMainBean.ZiroomerBean.LunboBeanXXXXX)localObject2).target;
            localArrayList.add(localContentBean);
            i += 1;
          }
        }
        ((HomeRentItem)localObject1).setContent(localArrayList);
        localb.showPerson((HomeRentItem)localObject1);
      }
      if (localZraMainBean.activity != null)
      {
        localObject1 = new HomeRentItem();
        ((HomeRentItem)localObject1).setTitle(localZraMainBean.activity.title);
        localArrayList = new ArrayList();
        if ((localZraMainBean.activity.lunbo != null) && (localZraMainBean.activity.lunbo.size() > 0))
        {
          i = 0;
          while (i < localZraMainBean.activity.lunbo.size())
          {
            localContentBean = new ContentBean();
            localObject2 = (ZraMainBean.ActivityBean.LunboBeanXXXXXX)localZraMainBean.activity.lunbo.get(i);
            localContentBean.pic = ((ZraMainBean.ActivityBean.LunboBeanXXXXXX)localObject2).img;
            localContentBean.title = ((ZraMainBean.ActivityBean.LunboBeanXXXXXX)localObject2).title;
            localContentBean.subtitle = ((ZraMainBean.ActivityBean.LunboBeanXXXXXX)localObject2).description;
            localContentBean.app = ((ZraMainBean.ActivityBean.LunboBeanXXXXXX)localObject2).app;
            localContentBean.target = ((ZraMainBean.ActivityBean.LunboBeanXXXXXX)localObject2).target;
            localArrayList.add(localContentBean);
            i += 1;
          }
        }
        ((HomeRentItem)localObject1).setContent(localArrayList);
        localb.showSocialAc((HomeRentItem)localObject1);
      }
      if (localZraMainBean.more != null)
      {
        localObject1 = new HomeRentItem();
        ((HomeRentItem)localObject1).setTitle(localZraMainBean.more.title);
        localArrayList = new ArrayList();
        if ((localZraMainBean.more.lunbo != null) && (localZraMainBean.more.lunbo.size() > 0))
        {
          i = k;
          while (i < localZraMainBean.more.lunbo.size())
          {
            localContentBean = new ContentBean();
            localObject2 = (ZraMainBean.MoreBean.LunboBeanXXXXXXX)localZraMainBean.more.lunbo.get(i);
            localContentBean.pic = ((ZraMainBean.MoreBean.LunboBeanXXXXXXX)localObject2).img;
            localContentBean.title = ((ZraMainBean.MoreBean.LunboBeanXXXXXXX)localObject2).title;
            localContentBean.subtitle = ((ZraMainBean.MoreBean.LunboBeanXXXXXXX)localObject2).description;
            localContentBean.app = ((ZraMainBean.MoreBean.LunboBeanXXXXXXX)localObject2).app;
            localContentBean.target = ((ZraMainBean.MoreBean.LunboBeanXXXXXXX)localObject2).target;
            localContentBean.price = ((ZraMainBean.MoreBean.LunboBeanXXXXXXX)localObject2).price;
            localArrayList.add(localContentBean);
            i += 1;
          }
        }
        ((HomeRentItem)localObject1).setContent(localArrayList);
        localb.showMoreZra((HomeRentItem)localObject1);
      }
      if (localZraMainBean.business != null) {
        localb.showBusinessInfo(localZraMainBean.business.business_mail, localZraMainBean.business.business_tel);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/zramain/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */