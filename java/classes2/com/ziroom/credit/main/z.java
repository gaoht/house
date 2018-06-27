package com.ziroom.credit.main;

import android.app.Activity;
import android.view.View;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.datacenter.remote.responsebody.financial.b.i;
import com.ziroom.datacenter.remote.responsebody.financial.b.s;
import com.ziroom.router.activityrouter.Routers;
import java.util.Arrays;
import java.util.List;

public class z<T extends com.ziroom.credit.base.c>
  extends com.ziroom.credit.base.a
  implements y.a
{
  private List<String> b = Arrays.asList(new String[] { "信用一般", "信用良好", "信用优秀", "信用极好" });
  private List<String> c = Arrays.asList(new String[] { "30", "70", "100", "150" });
  private com.ziroom.datacenter.remote.responsebody.financial.b.a d;
  
  public z(T paramT)
  {
    super(paramT);
  }
  
  private void a()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(getView().getViewContext()).setTitle("提示").setBtnConfirmText("确定").setContent("很抱歉，芝麻信用暂时仅支持持有中国大陆居民身份证的用户").build().show();
  }
  
  private void b()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(getView().getViewContext()).setTitle("提示").setBtnConfirmText("去认证").setContent("授权芝麻信用，请先完成实名认证").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          Routers.open(z.this.getView().getViewContext(), "ziroomCustomer://zrRentModule/nameAuthenticationMethod");
        }
      }
    }).build().show();
  }
  
  private void c()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(getView().getViewContext()).setTitle("提示").setBtnConfirmText("去认证").setContent("请联系客服400-100-1111进行认证").build().show();
  }
  
  public void getSingleAuthInfo()
  {
    com.ziroom.datacenter.remote.e.c.getSingleAuthInfo((Activity)getView().getViewContext(), 1, new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, i paramAnonymousi)
      {
        if (!z.this.getView().isActive()) {}
        while (paramAnonymousi == null) {
          return;
        }
        ((y.b)z.this.getView()).gotoSignerCareerInfoActivity(paramAnonymousi);
      }
    });
  }
  
  public void getZhimaUrl()
  {
    com.ziroom.datacenter.remote.e.c.getUserNameAuthInfo((Activity)getView().getViewContext(), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, s paramAnonymouss)
      {
        if (!z.this.getView().isActive()) {}
        do
        {
          do
          {
            return;
          } while (paramAnonymouss == null);
          paramAnonymouss = paramAnonymouss.getAuthUrl();
        } while (com.ziroom.commonlib.utils.r.isNull(paramAnonymouss));
        ((y.b)z.this.getView()).setZhimaUrl(paramAnonymouss);
      }
    });
  }
  
  public void setMaimaiOnClick()
  {
    if (this.d.getMmRelStatus() == 0) {
      getSingleAuthInfo();
    }
  }
  
  public void setRealNameOnClick()
  {
    if (this.d.getCertType() != 1)
    {
      if ((this.d.getIdentityStatus() == 3) || (this.d.getIdentityStatus() == 5))
      {
        Routers.open(getView().getViewContext(), "ziroomCustomer://zrRentModule/nameAuthenticationMethod");
        return;
      }
      c();
      return;
    }
    Routers.open(getView().getViewContext(), "ziroomCustomer://zrRentModule/nameAuthenticationMethod");
  }
  
  public void setZhimaOnClick()
  {
    if ((this.d.getIdentityStatus() != 4) && (this.d.getCertType() <= 1))
    {
      b();
      return;
    }
    if (this.d.getCertType() != 1)
    {
      a();
      return;
    }
    getZhimaUrl();
  }
  
  public void start()
  {
    com.ziroom.datacenter.remote.e.c.getUserScoreInfoByUid((Activity)getView().getViewContext(), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.r paramAnonymousr)
      {
        String str2 = null;
        if (!z.this.getView().isActive()) {}
        while (paramAnonymousr == null) {
          return;
        }
        y.b localb = (y.b)z.this.getView();
        String str1;
        if (paramAnonymousr.getLevel() - 1 < z.a(z.this).size())
        {
          str1 = (String)z.a(z.this).get(paramAnonymousr.getLevel() - 1);
          str2 = (String)z.b(z.this).get(paramAnonymousr.getLevel() - 1);
        }
        for (;;)
        {
          localb.setUserScoreInfo(paramAnonymousr.getZiroomScore() + "", paramAnonymousr.getLevelName(), str1, str2);
          return;
          str1 = null;
        }
      }
    });
    com.ziroom.datacenter.remote.e.c.getBacklogs((Activity)getView().getViewContext(), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.a paramAnonymousa)
      {
        if (!z.this.getView().isActive()) {}
        y.b localb;
        do
        {
          return;
          localb = (y.b)z.this.getView();
        } while (paramAnonymousa == null);
        z.a(z.this, paramAnonymousa);
        localb.setDataCount(paramAnonymousa.getBacklogCount());
        if ((paramAnonymousa.getCertType() == 2) || (paramAnonymousa.getCertType() == 3)) {
          localb.setZhimaVisibility(false);
        }
        if (paramAnonymousa.getAuthStatus() == 0) {
          localb.setZhimaVisibility(true);
        }
        if ((paramAnonymousa.getEducationStatus() == 5) || (paramAnonymousa.getEducationStatus() == 3)) {
          localb.setEducationVisibility(true);
        }
        if ((paramAnonymousa.getIdentityStatus() != 4) && (paramAnonymousa.getIdentityStatus() != 2)) {
          localb.setRealNameVisibility(true);
        }
        if (paramAnonymousa.getLinkedinStatus() != 1) {
          localb.setLinkedVisibility(true);
        }
        if ((paramAnonymousa.getWorkStatus() == 5) || (paramAnonymousa.getWorkStatus() == 3)) {
          localb.setWorkVisibility(true);
        }
        if (paramAnonymousa.getMmRelStatus() == 0) {
          localb.setMaimaiVisibility(true);
        }
        localb.setBillsData(paramAnonymousa.getBillList());
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */