package com.ziroom.ziroomcustomer.newclean.mvp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.baidu.location.BDLocation;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.model.c.a;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.b.g;
import com.ziroom.ziroomcustomer.newclean.b.k;
import com.ziroom.ziroomcustomer.newclean.b.l;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanUesrIsNewMo;
import com.ziroom.ziroomcustomer.newclean.d.o;
import com.ziroom.ziroomcustomer.newclean.d.o.a;
import com.ziroom.ziroomcustomer.newclean.d.p;
import com.ziroom.ziroomcustomer.newclean.d.q;
import com.ziroom.ziroomcustomer.newclean.d.z;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class b
  implements a.a
{
  private WeakReference<a.b> a;
  private List<String> b = new ArrayList();
  private List<String> c = new ArrayList();
  private l d;
  private k e;
  private List<o.a> f = new ArrayList();
  private List<o.a> g = new ArrayList();
  
  public b(a.b paramb)
  {
    this.a = new WeakReference(paramb);
    if (paramb != null) {
      paramb.setPresenter(this);
    }
  }
  
  private void a()
  {
    com.ziroom.ziroomcustomer.e.n.getCleanHomeBanner(((a.b)this.a.get()).getViewContext(), new d(((a.b)this.a.get()).getViewContext(), new e(q.class))
    {
      public void onSuccess(int paramAnonymousInt, final List<q> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList == null) || (paramAnonymousList == null)) {}
        do
        {
          return;
          b.a(b.this).clear();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < paramAnonymousList.size())
          {
            b.a(b.this).add(((q)paramAnonymousList.get(paramAnonymousInt)).getImg());
            paramAnonymousInt += 1;
          }
          ((a.b)b.b(b.this).get()).getmCbBanner().setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
          {
            public com.ziroom.ziroomcustomer.newServiceList.view.c createHolder()
            {
              return new com.ziroom.ziroomcustomer.newServiceList.view.c();
            }
          }, b.a(b.this)).setPageIndicator(new int[] { 2130839319, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
          {
            public void onItemClick(int paramAnonymous2Int) {}
          });
          ((a.b)b.b(b.this).get()).getmCbBanner().startTurning(3000L);
          ((a.b)b.b(b.this).get()).getmCbBanner().setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
          {
            public void onItemClick(int paramAnonymous2Int)
            {
              if (!TextUtils.isEmpty(((q)paramAnonymousList.get(paramAnonymous2Int)).getTarget()))
              {
                String str1 = ((q)paramAnonymousList.get(paramAnonymous2Int)).getTarget();
                String str2 = ((q)paramAnonymousList.get(paramAnonymous2Int)).getTitle();
                String str3 = ((q)paramAnonymousList.get(paramAnonymous2Int)).getDescription();
                String str4 = ((q)paramAnonymousList.get(paramAnonymous2Int)).getImg();
                JsBridgeWebActivity.start(((a.b)b.b(b.this).get()).getViewContext(), str2, str1, true, str3, str4, false);
              }
            }
          });
        } while ((b.a(b.this) == null) || (b.a(b.this).size() <= 0));
        if (b.a(b.this).size() == 1)
        {
          ((a.b)b.b(b.this).get()).getmCbBanner().setPointViewVisible(false);
          ((a.b)b.b(b.this).get()).getmCbBanner().setCanLoop(false);
          return;
        }
        ((a.b)b.b(b.this).get()).getmCbBanner().setPointViewVisible(true);
        ((a.b)b.b(b.this).get()).getmCbBanner().setCanLoop(true);
      }
    });
  }
  
  private void a(BDLocation paramBDLocation)
  {
    double d2 = 0.0D;
    double d1;
    if (paramBDLocation != null)
    {
      d1 = paramBDLocation.getLongitude();
      d2 = paramBDLocation.getLatitude();
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.e.n.getCleanBottomCleaner(((a.b)this.a.get()).getViewContext(), d1, d2, new com.freelxl.baselibrary.d.c.a(new e(z.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          if (b.h(b.this)) {
            ((a.b)b.b(b.this).get()).getLvCleaner().setVisibility(8);
          }
        }
        
        public void onSuccess(int paramAnonymousInt, List<z> paramAnonymousList)
        {
          if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
          {
            ((a.b)b.b(b.this).get()).getLvCleaner().setVisibility(0);
            ((a.b)b.b(b.this).get()).getmLlCleanerTitle().setVisibility(0);
            paramAnonymousList = new com.ziroom.ziroomcustomer.newclean.b.m(((a.b)b.b(b.this).get()).getViewContext(), paramAnonymousList);
            ((a.b)b.b(b.this).get()).getLvCleaner().setAdapter(paramAnonymousList);
            return;
          }
          ((a.b)b.b(b.this).get()).getLvCleaner().setVisibility(8);
          ((a.b)b.b(b.this).get()).getmLlCleanerTitle().setVisibility(8);
        }
      });
      return;
      d1 = 0.0D;
    }
  }
  
  private void b()
  {
    com.ziroom.ziroomcustomer.e.n.getCleanHomeCenterBanner(((a.b)this.a.get()).getViewContext(), new d(((a.b)this.a.get()).getViewContext(), new e(q.class))
    {
      public void onSuccess(int paramAnonymousInt, final List<q> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          ((a.b)b.b(b.this).get()).getCardCenter().setVisibility(0);
          b.c(b.this).clear();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < paramAnonymousList.size())
          {
            b.c(b.this).add(((q)paramAnonymousList.get(paramAnonymousInt)).getImg());
            paramAnonymousInt += 1;
          }
          ((a.b)b.b(b.this).get()).getmCbCenterBanner().setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
          {
            public com.ziroom.ziroomcustomer.newServiceList.view.c createHolder()
            {
              return new com.ziroom.ziroomcustomer.newServiceList.view.c();
            }
          }, b.c(b.this)).setPageIndicator(new int[] { 2130839319, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
          {
            public void onItemClick(int paramAnonymous2Int) {}
          });
          ((a.b)b.b(b.this).get()).getmCbCenterBanner().startTurning(3000L);
          ((a.b)b.b(b.this).get()).getmCbCenterBanner().setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
          {
            public void onItemClick(int paramAnonymous2Int)
            {
              if (!TextUtils.isEmpty(((q)paramAnonymousList.get(paramAnonymous2Int)).getTarget()))
              {
                String str1 = ((q)paramAnonymousList.get(paramAnonymous2Int)).getTitle();
                String str2 = ((q)paramAnonymousList.get(paramAnonymous2Int)).getTarget();
                String str3 = ((q)paramAnonymousList.get(paramAnonymous2Int)).getDescription();
                String str4 = ((q)paramAnonymousList.get(paramAnonymous2Int)).getImg();
                JsBridgeWebActivity.start(((a.b)b.b(b.this).get()).getViewContext(), str1, str2, true, str3, str4, false);
              }
            }
          });
          if ((b.c(b.this) != null) && (b.c(b.this).size() > 0))
          {
            if (b.c(b.this).size() == 1)
            {
              ((a.b)b.b(b.this).get()).getmCbCenterBanner().setPointViewVisible(false);
              ((a.b)b.b(b.this).get()).getmCbCenterBanner().setCanLoop(false);
            }
          }
          else {
            return;
          }
          ((a.b)b.b(b.this).get()).getmCbCenterBanner().setPointViewVisible(true);
          ((a.b)b.b(b.this).get()).getmCbCenterBanner().setCanLoop(true);
          return;
        }
        ((a.b)b.b(b.this).get()).getCardCenter().setVisibility(8);
      }
    });
  }
  
  private void c()
  {
    String str = j.getUid();
    com.ziroom.ziroomcustomer.e.n.requestIsUserInfo(((a.b)this.a.get()).getViewContext(), str, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.m(CleanUesrIsNewMo.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, CleanUesrIsNewMo paramAnonymousCleanUesrIsNewMo)
      {
        if (paramAnonymousCleanUesrIsNewMo != null)
        {
          ((a.b)b.b(b.this).get()).setCardTip(paramAnonymousCleanUesrIsNewMo);
          return;
        }
        ((a.b)b.b(b.this).get()).setCardTip(null);
      }
    });
  }
  
  private void d()
  {
    String str = j.getUid();
    com.ziroom.ziroomcustomer.e.n.getCleanHomeList(((a.b)this.a.get()).getViewContext(), str, new com.freelxl.baselibrary.d.c.a(new f(o.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, o paramAnonymouso)
      {
        if (paramAnonymouso != null)
        {
          if ((paramAnonymouso.getDefaults() != null) && (paramAnonymouso.getDefaults().size() > 0))
          {
            b.d(b.this).clear();
            b.d(b.this).addAll(paramAnonymouso.getDefaults());
            b.e(b.this).setData(b.d(b.this));
          }
          if ((paramAnonymouso.getEasys() != null) && (paramAnonymouso.getEasys().size() > 0))
          {
            ((a.b)b.b(b.this).get()).getmLlChoiceTitle().setVisibility(0);
            ((a.b)b.b(b.this).get()).geGvChoice().setVisibility(0);
            b.f(b.this).clear();
            b.f(b.this).addAll(paramAnonymouso.getEasys());
            b.g(b.this).setData(b.f(b.this));
          }
        }
        else
        {
          return;
        }
        ((a.b)b.b(b.this).get()).geGvChoice().setVisibility(8);
        ((a.b)b.b(b.this).get()).getmLlChoiceTitle().setVisibility(8);
      }
    });
  }
  
  private void e()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null)
    {
      ((a.b)this.a.get()).setServeOrder(null);
      return;
    }
    localObject = ((UserInfo)localObject).getUid();
    com.ziroom.ziroomcustomer.e.n.getCleanHomeLastOrder(((a.b)this.a.get()).getViewContext(), (String)localObject, new com.freelxl.baselibrary.d.c.a(new f(com.ziroom.ziroomcustomer.newclean.d.n.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.newclean.d.n paramAnonymousn)
      {
        if (paramAnonymousn != null) {
          ((a.b)b.b(b.this).get()).setServeOrder(paramAnonymousn);
        }
      }
    });
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.e.n.getCommonTemplate(((a.b)this.a.get()).getViewContext(), Integer.valueOf(51), new com.freelxl.baselibrary.d.c.a(new e(p.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, List<p> paramAnonymousList)
      {
        if (paramAnonymousList != null)
        {
          if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
          {
            ((a.b)b.b(b.this).get()).getRvPraise().setVisibility(0);
            paramAnonymousList = new g(((a.b)b.b(b.this).get()).getViewContext(), paramAnonymousList);
            ((a.b)b.b(b.this).get()).getRvPraise().setLayoutManager(new LinearLayoutManager(((a.b)b.b(b.this).get()).getViewContext(), 0, false));
            ((a.b)b.b(b.this).get()).getRvPraise().setAdapter(paramAnonymousList);
          }
        }
        else {
          return;
        }
        ((a.b)b.b(b.this).get()).getRvPraise().setVisibility(8);
      }
    });
  }
  
  private void g()
  {
    com.ziroom.ziroomcustomer.e.n.getCommonTemplateOnCityV2(((a.b)this.a.get()).getViewContext(), Integer.valueOf(20), new com.freelxl.baselibrary.d.c.a(new f(com.ziroom.ziroomcustomer.newServiceList.model.c.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, final com.ziroom.ziroomcustomer.newServiceList.model.c paramAnonymousc)
      {
        if ((paramAnonymousc != null) && (paramAnonymousc.getCleanListPage() != null) && (paramAnonymousc.getCleanListPage().getValid() == 1))
        {
          ((a.b)b.b(b.this).get()).getIvInvite().setVisibility(0);
          ((a.b)b.b(b.this).get()).getIvInvite().setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousc.getCleanListPage().getImage()));
          ((a.b)b.b(b.this).get()).getIvInvite().setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              paramAnonymous2View = ApplicationEx.c.getUser();
              if (paramAnonymous2View == null)
              {
                com.ziroom.commonlibrary.login.a.startLoginActivity(((a.b)b.b(b.this).get()).getViewContext());
                return;
              }
              paramAnonymous2View = paramAnonymousc.getCleanListPage().getUrl() + "?uid=" + paramAnonymous2View.getUid();
              String str1 = paramAnonymousc.getCleanListPage().getImage();
              if ((paramAnonymousc.getCleanListPage().getShareDisplay() != null) && (paramAnonymousc.getCleanListPage().getShareDisplay().intValue() == 1))
              {
                String str2 = paramAnonymousc.getCleanListPage().getShareTitle();
                JsBridgeWebActivity.start(((a.b)b.b(b.this).get()).getViewContext(), str2, paramAnonymous2View, true, "", str1, false);
                return;
              }
              JsBridgeWebActivity.start(((a.b)b.b(b.this).get()).getViewContext(), "", paramAnonymous2View, false, "", str1, false);
            }
          });
          return;
        }
        ((a.b)b.b(b.this).get()).getIvInvite().setVisibility(8);
      }
    });
  }
  
  private boolean h()
  {
    return (getView() != null) && (((a.b)this.a.get()).isActive());
  }
  
  public void detachView()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public Object getView()
  {
    if (this.a != null) {
      return this.a.get();
    }
    return null;
  }
  
  public void reAgainLogin()
  {
    if (h()) {
      d();
    }
  }
  
  public void start()
  {
    if (h())
    {
      a();
      b();
      c();
      this.d = new l(((a.b)this.a.get()).getViewContext(), this.f);
      ((a.b)this.a.get()).getGvClean().setHorizontalSpacing(com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(((a.b)this.a.get()).getViewContext()) * 14 / 375);
      ((a.b)this.a.get()).getGvClean().setAdapter(this.d);
      this.e = new k(((a.b)this.a.get()).getViewContext(), this.g);
      ((a.b)this.a.get()).geGvChoice().setHorizontalSpacing(com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(((a.b)this.a.get()).getViewContext()) * 40 / 375);
      ((a.b)this.a.get()).geGvChoice().setAdapter(this.e);
      d();
      e();
      f();
      a(ApplicationEx.c.getLocation());
      g();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */