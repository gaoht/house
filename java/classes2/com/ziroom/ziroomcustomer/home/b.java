package com.ziroom.ziroomcustomer.home;

import android.content.Context;
import android.content.res.Resources;
import com.freelxl.baselibrary.d.f.d;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.DataBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.DataBean.AboutZiroomBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.DataBean.AboutZiroomBean.ContentBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.DataBean.EntrustBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.DataBean.IntroduceBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.DataBean.IntroduceBean.ContentBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.DataBean.SelectNameBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.DataBean.SelectNameBean.ContentBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.DataBean.StoryBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.DataBean.StoryBean.ContentBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.DataBean.VideoBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.DataBean.VideoBean.ContentBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.DataBean.ZiroomProductBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.DataBean.ZiroomProductBean.ContentBean;
import com.ziroom.ziroomcustomer.home.bean.HomePageEntrustNew.Estimate;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.List;

public class b
{
  com.freelxl.baselibrary.d.c.a a = new com.freelxl.baselibrary.d.c.a(new d(HomePageEntrustNew.class))
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      g.textToast(ApplicationEx.c, "网络请求失败");
    }
    
    public void onSuccess(int paramAnonymousInt, HomePageEntrustNew paramAnonymousHomePageEntrustNew)
    {
      int j = 0;
      if ("success".equals(paramAnonymousHomePageEntrustNew.status))
      {
        if (paramAnonymousHomePageEntrustNew.getData() == null) {
          break label1369;
        }
        if (b.a(b.this) != null) {}
      }
      else
      {
        return;
      }
      Object localObject1;
      Object localObject2;
      int i;
      if ((paramAnonymousHomePageEntrustNew.data.select_name != null) && (paramAnonymousHomePageEntrustNew.data.entrust != null) && (paramAnonymousHomePageEntrustNew.data.select_name.content != null) && (paramAnonymousHomePageEntrustNew.data.select_name.content.size() > 0))
      {
        localObject1 = ((HomePageEntrustNew.DataBean.SelectNameBean.ContentBean)paramAnonymousHomePageEntrustNew.data.select_name.content.get(0)).img;
        localObject2 = paramAnonymousHomePageEntrustNew.data.select_name.title;
        String str1 = paramAnonymousHomePageEntrustNew.data.entrust.title;
        String str2 = paramAnonymousHomePageEntrustNew.data.entrust.subtitle;
        String str3 = b.b(b.this).getResources().getString(2131297310);
        String str4 = q.ai;
        b.a(b.this).bindEntrustTitle((String)localObject1, (String)localObject2, str1, str2, str3, str4);
        paramAnonymousInt = (int)(Math.random() * 100.0D);
        i = paramAnonymousHomePageEntrustNew.data.select_name.content.size();
        localObject1 = (HomePageEntrustNew.DataBean.SelectNameBean.ContentBean)paramAnonymousHomePageEntrustNew.data.select_name.content.get(paramAnonymousInt % i);
        b.a(b.this, new ContentBean());
        b.c(b.this).setPic(((HomePageEntrustNew.DataBean.SelectNameBean.ContentBean)localObject1).img);
        b.c(b.this).setTitle(((HomePageEntrustNew.DataBean.SelectNameBean.ContentBean)localObject1).title);
        b.c(b.this).setLink(((HomePageEntrustNew.DataBean.SelectNameBean.ContentBean)localObject1).target);
        if ((b.a(b.this) != null) && (b.a(b.this).getParentFragment() != null) && (b.a(b.this).getUserVisibleHint())) {
          ((a)b.a(b.this).getParentFragment()).onBrandImgReady(b.c(b.this));
        }
      }
      if (paramAnonymousHomePageEntrustNew.data.introduce != null)
      {
        localObject1 = new ArrayList();
        paramAnonymousInt = 0;
        while (paramAnonymousInt < paramAnonymousHomePageEntrustNew.data.introduce.content.size())
        {
          localObject2 = new ContentBean();
          ((ContentBean)localObject2).setPic(((HomePageEntrustNew.DataBean.IntroduceBean.ContentBean)paramAnonymousHomePageEntrustNew.data.introduce.content.get(paramAnonymousInt)).img);
          ((ContentBean)localObject2).setTitle(((HomePageEntrustNew.DataBean.IntroduceBean.ContentBean)paramAnonymousHomePageEntrustNew.data.introduce.content.get(paramAnonymousInt)).title);
          ((ContentBean)localObject2).setSubtitle(((HomePageEntrustNew.DataBean.IntroduceBean.ContentBean)paramAnonymousHomePageEntrustNew.data.introduce.content.get(paramAnonymousInt)).description);
          ((ContentBean)localObject2).setLink(((HomePageEntrustNew.DataBean.IntroduceBean.ContentBean)paramAnonymousHomePageEntrustNew.data.introduce.content.get(paramAnonymousInt)).target);
          ((List)localObject1).add(localObject2);
          paramAnonymousInt += 1;
        }
        b.a(b.this).bindOwnerEntrustDesc((List)localObject1);
      }
      if (paramAnonymousHomePageEntrustNew.data.about_ziroom != null)
      {
        localObject1 = new ArrayList();
        paramAnonymousInt = paramAnonymousHomePageEntrustNew.data.about_ziroom.content.size();
        if (paramAnonymousHomePageEntrustNew.data.about_ziroom.content.size() <= 5) {
          break label1379;
        }
        paramAnonymousInt = 5;
      }
      label1369:
      label1379:
      for (;;)
      {
        i = 0;
        if (i < paramAnonymousInt)
        {
          localObject2 = new ContentBean();
          ((ContentBean)localObject2).setPic(((HomePageEntrustNew.DataBean.AboutZiroomBean.ContentBean)paramAnonymousHomePageEntrustNew.data.about_ziroom.content.get(i)).img);
          if (i == 0) {
            ((ContentBean)localObject2).setTitle(((HomePageEntrustNew.DataBean.AboutZiroomBean.ContentBean)paramAnonymousHomePageEntrustNew.data.about_ziroom.content.get(i)).title);
          }
          for (;;)
          {
            ((ContentBean)localObject2).setLink(((HomePageEntrustNew.DataBean.AboutZiroomBean.ContentBean)paramAnonymousHomePageEntrustNew.data.about_ziroom.content.get(i)).target);
            ((List)localObject1).add(localObject2);
            i += 1;
            break;
            if (!ae.isNull(((ContentBean)((List)localObject1).get(0)).getTitle())) {
              ((ContentBean)localObject2).setTitle(((HomePageEntrustNew.DataBean.AboutZiroomBean.ContentBean)paramAnonymousHomePageEntrustNew.data.about_ziroom.content.get(i)).title);
            }
          }
        }
        b.a(b.this).bindKnowZiroom((List)localObject1, paramAnonymousHomePageEntrustNew.data.about_ziroom.title, paramAnonymousHomePageEntrustNew.data.about_ziroom.link, paramAnonymousHomePageEntrustNew.data.about_ziroom.subtitle);
        if (paramAnonymousHomePageEntrustNew.data.video != null)
        {
          localObject1 = new ArrayList();
          localObject2 = new ContentBean();
          ((ContentBean)localObject2).setPic(((HomePageEntrustNew.DataBean.VideoBean.ContentBean)paramAnonymousHomePageEntrustNew.data.video.content.get(0)).img);
          ((ContentBean)localObject2).setTitle(((HomePageEntrustNew.DataBean.VideoBean.ContentBean)paramAnonymousHomePageEntrustNew.data.video.content.get(0)).title);
          ((ContentBean)localObject2).setLink(((HomePageEntrustNew.DataBean.VideoBean.ContentBean)paramAnonymousHomePageEntrustNew.data.video.content.get(0)).target);
          ((List)localObject1).add(localObject2);
          b.a(b.this).bindOwnerEntrustProgress((List)localObject1, paramAnonymousHomePageEntrustNew.data.video.title);
        }
        if (paramAnonymousHomePageEntrustNew.data.ziroom_product != null)
        {
          localObject1 = new ArrayList();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < paramAnonymousHomePageEntrustNew.data.ziroom_product.content.size())
          {
            localObject2 = new ContentBean();
            ((ContentBean)localObject2).setPic(((HomePageEntrustNew.DataBean.ZiroomProductBean.ContentBean)paramAnonymousHomePageEntrustNew.data.ziroom_product.content.get(paramAnonymousInt)).img);
            ((ContentBean)localObject2).setTitle(((HomePageEntrustNew.DataBean.ZiroomProductBean.ContentBean)paramAnonymousHomePageEntrustNew.data.ziroom_product.content.get(paramAnonymousInt)).title);
            ((ContentBean)localObject2).setLink(((HomePageEntrustNew.DataBean.ZiroomProductBean.ContentBean)paramAnonymousHomePageEntrustNew.data.ziroom_product.content.get(paramAnonymousInt)).target);
            ((List)localObject1).add(localObject2);
            paramAnonymousInt += 1;
          }
          b.a(b.this).bindEntrustProduct((List)localObject1, paramAnonymousHomePageEntrustNew.data.ziroom_product.title, paramAnonymousHomePageEntrustNew.data.ziroom_product.subtitle);
        }
        if (paramAnonymousHomePageEntrustNew.data.story != null)
        {
          localObject1 = new ArrayList();
          paramAnonymousInt = j;
          while (paramAnonymousInt < paramAnonymousHomePageEntrustNew.data.story.content.size())
          {
            localObject2 = new ContentBean();
            ((ContentBean)localObject2).setPic(((HomePageEntrustNew.DataBean.StoryBean.ContentBean)paramAnonymousHomePageEntrustNew.data.story.content.get(paramAnonymousInt)).img);
            ((ContentBean)localObject2).setTitle(((HomePageEntrustNew.DataBean.StoryBean.ContentBean)paramAnonymousHomePageEntrustNew.data.story.content.get(paramAnonymousInt)).title);
            ((ContentBean)localObject2).setSubtitle(((HomePageEntrustNew.DataBean.StoryBean.ContentBean)paramAnonymousHomePageEntrustNew.data.story.content.get(paramAnonymousInt)).description);
            ((ContentBean)localObject2).setLink(((HomePageEntrustNew.DataBean.StoryBean.ContentBean)paramAnonymousHomePageEntrustNew.data.story.content.get(paramAnonymousInt)).target);
            ((List)localObject1).add(localObject2);
            paramAnonymousInt += 1;
          }
          b.a(b.this).bindOwnerStory((List)localObject1, paramAnonymousHomePageEntrustNew.data.story.title, paramAnonymousHomePageEntrustNew.data.story.link, paramAnonymousHomePageEntrustNew.data.story.subtitle);
        }
        b.a(b.this, paramAnonymousHomePageEntrustNew.data.fangwugujia);
        b.this.initEstimate();
        return;
        g.textToast(ApplicationEx.c, "首页请求失败");
        return;
      }
    }
  };
  private Context b;
  private HomePageFragment_Entrust c;
  private ContentBean d;
  private HomePageEntrustNew.Estimate e;
  
  public b(HomePageFragment_Entrust paramHomePageFragment_Entrust, Context paramContext)
  {
    this.b = paramContext;
    this.c = paramHomePageFragment_Entrust;
  }
  
  public void detach()
  {
    com.freelxl.baselibrary.d.a.cancel(this);
    this.b = null;
  }
  
  public ContentBean getBrandImg()
  {
    return this.d;
  }
  
  public void initEstimate()
  {
    if ((this.b == null) || (this.c == null) || (this.c.isDetached())) {
      return;
    }
    if ((this.e == null) || (!"on".equals(this.e.getGujia())))
    {
      this.c.initEstimatePrice(false);
      return;
    }
    this.c.initEstimatePrice(true);
  }
  
  public void loadData()
  {
    if (ah.checkNet(this.b)) {
      j.getHomeRentChild(this.b, 1, "yezhu", this.a);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */