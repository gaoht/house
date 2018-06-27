package com.ziroom.ziroomcustomer.minsu.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.a.a;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLHouseListBean.Data.DataBean;
import com.ziroom.ziroomcustomer.minsu.f.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class o
  extends a<MinsuLLHouseListBean.Data.DataBean>
{
  String d;
  String e;
  private a f;
  
  public o(Activity paramActivity, List<MinsuLLHouseListBean.Data.DataBean> paramList)
  {
    super(paramActivity, paramList, 2130904334);
  }
  
  public void convert(b paramb, MinsuLLHouseListBean.Data.DataBean paramDataBean) {}
  
  public void convert(final b paramb, final MinsuLLHouseListBean.Data.DataBean paramDataBean, final int paramInt)
  {
    Object localObject = (SimpleDraweeView)paramb.getView(2131695297);
    ((SimpleDraweeView)localObject).setController(com.freelxl.baselibrary.f.c.frescoController(paramDataBean.defaultPic));
    ((SimpleDraweeView)localObject).setHierarchy(com.ziroom.ziroomcustomer.minsu.f.d.getHierarchy(this.a));
    paramb.setText(2131691319, paramDataBean.name);
    paramb.setText(2131695298, this.a.getString(2131297123).replace("count", paramDataBean.housePv + ""));
    if (paramDataBean.rentWay == 0)
    {
      localObject = "整套出租";
      paramb.setText(2131695300, (String)localObject);
      if (TextUtils.isEmpty(paramDataBean.orderTypeStr)) {
        break label340;
      }
      paramb.setVisibility(2131695301, 0);
      paramb.setText(2131695302, paramDataBean.orderTypeStr);
      label138:
      paramb.setText(2131695299, this.a.getString(2131297093) + paramDataBean.houseEvaScore);
      paramb.setText(2131695071, paramDataBean.statusName);
      if (paramDataBean.whetherBookPhoto != 1) {
        break label352;
      }
      paramb.setVisibility(2131695315, 0);
    }
    for (;;)
    {
      paramb.setOnClickListener(2131695313, new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ((paramDataBean.status == 10) || ((paramDataBean.rentWay == 1) && (TextUtils.isEmpty(paramDataBean.houseRoomFid))))
          {
            g.textToast(o.a(o.this), o.b(o.this).getResources().getString(2131297130));
            return;
          }
          new StringBuilder().append(com.ziroom.ziroomcustomer.minsu.b.d.g).append("/houseMgt/43e881/calendarDetail").toString();
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("houseBaseFid", paramDataBean.houseBaseFid);
          paramAnonymousView.put("houseRoomFid", paramDataBean.houseRoomFid);
          paramAnonymousView.put("rentWay", paramDataBean.rentWay + "");
          o.c(o.this).onItemClick(paramDataBean.houseBaseFid, paramDataBean.houseRoomFid, paramDataBean.rentWay, paramInt, false);
          Activity localActivity = (Activity)o.d(o.this);
          String str1 = paramDataBean.houseBaseFid;
          String str2 = paramDataBean.houseRoomFid;
          String str3 = paramDataBean.bedFid;
          int i = paramDataBean.rentWay;
          if (paramDataBean.rentWay == 0) {}
          for (paramAnonymousView = paramDataBean.houseName;; paramAnonymousView = paramDataBean.name)
          {
            k.toMinsuLLHouseCalendar(localActivity, str1, str2, str3, i, paramAnonymousView);
            return;
          }
        }
      });
      paramb.setOnClickListener(2131695314, new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (paramDataBean.isIssue == 1) {
            k.toReleaseManager(o.e(o.this), paramDataBean.houseBaseFid, paramDataBean.houseRoomFid, paramDataBean.rentWay, paramDataBean.roomType);
          }
          for (paramAnonymousView = Boolean.valueOf(false);; paramAnonymousView = Boolean.valueOf(true))
          {
            o.c(o.this).onItemClick(paramDataBean.houseBaseFid, paramDataBean.houseRoomFid, paramDataBean.rentWay, paramInt, paramAnonymousView.booleanValue());
            return;
            k.toHouseRelease((Activity)o.f(o.this), paramDataBean.houseBaseFid, paramDataBean.houseRoomFid, paramDataBean.rentWay, paramDataBean.operateSeq, null, 171, paramDataBean.roomType);
          }
        }
      });
      paramb.setOnClickListener(2131695315, new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (((o.g(o.this) instanceof Activity)) && (!TextUtils.isEmpty(paramDataBean.houseBaseFid)))
          {
            com.ziroom.ziroomcustomer.minsu.landlord.activity.MinsuLandLordMainNewActivity.b = paramDataBean.houseBaseFid;
            k.toMinsuInfoActivity1((Activity)o.h(o.this), 88, paramDataBean.houseBaseFid, 0, "", -1, "我已阅读并同意", 130);
            return;
          }
          com.ziroom.ziroomcustomer.minsu.landlord.activity.MinsuLandLordMainNewActivity.b = null;
        }
      });
      if ((TextUtils.isEmpty(paramDataBean.refuseReason)) || (TextUtils.isEmpty(paramDataBean.refuseReason.trim()))) {
        break label687;
      }
      localObject = new StringBuilder(paramDataBean.refuseReason.trim());
      while ((((StringBuilder)localObject).length() > 0) && (((StringBuilder)localObject).charAt(0) == '\n')) {
        ((StringBuilder)localObject).deleteCharAt(0);
      }
      if (paramDataBean.roomType == 0)
      {
        localObject = "独立房间";
        break;
      }
      localObject = "共享客厅";
      break;
      label340:
      paramb.setVisibility(2131695301, 8);
      break label138;
      label352:
      paramb.setVisibility(2131695315, 8);
    }
    while ((((StringBuilder)localObject).length() > 0) && (((StringBuilder)localObject).charAt(((StringBuilder)localObject).length() - 1) == '\n')) {
      ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
    }
    paramb.setText(2131695308, "原因：" + ((StringBuilder)localObject).toString());
    paramb.setText(2131695306, "原因：" + ((StringBuilder)localObject).toString());
    paramb.getView(2131695307).setVisibility(4);
    paramb.getView(2131695308).getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      boolean a = true;
      
      public boolean onPreDraw()
      {
        if (this.a)
        {
          this.a = false;
          if (((TextView)paramb.getView(2131695308)).getLineCount() <= 1)
          {
            paramb.setVisibility(2131695305, 8);
            paramb.setVisibility(2131695307, 8);
            paramb.setVisibility(2131695304, 0);
          }
        }
        else
        {
          return true;
        }
        paramb.setVisibility(2131695305, 0);
        paramb.setVisibility(2131695304, 0);
        paramb.setVisibility(2131695307, 8);
        paramb.setOnClickListener(2131695305, new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            o.4.this.b.setVisibility(2131695304, 8);
            o.4.this.b.setVisibility(2131695307, 0);
          }
        });
        paramb.setOnClickListener(2131695309, new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            o.4.this.b.setVisibility(2131695304, 0);
            o.4.this.b.setVisibility(2131695307, 8);
          }
        });
        return true;
      }
    });
    if (!TextUtils.isEmpty(paramDataBean.bookStartTime))
    {
      paramb.setVisibility(2131695310, 0);
      paramb.setText(2131694698, "预约摄影时间：" + paramDataBean.bookStartTime);
      if (TextUtils.isEmpty(paramDataBean.photoStatName))
      {
        paramb.setText(2131695312, "");
        label562:
        paramb.setOnClickListener(2131695311, new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            k.toMinsuInfoActivity1((Activity)o.i(o.this), 88, 0, "", 0, 65535);
          }
        });
        label577:
        if (((paramDataBean.rentWay != 0) || (paramDataBean.houseStatus != 30)) && ((paramDataBean.rentWay != 1) || (paramDataBean.roomStatus != 30))) {
          break label760;
        }
        paramb.setVisibility(2131695318, 0);
        paramb.setText(2131695318, this.a.getString(2131297057));
        paramb.setOnClickListener(2131695318, new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (!TextUtils.isEmpty(com.ziroom.ziroomcustomer.minsu.b.c.b)) {
              k.callPhone(o.j(o.this), com.ziroom.ziroomcustomer.minsu.b.c.b);
            }
          }
        });
        label653:
        if (!"0".equals(paramDataBean.isTodayDiscount)) {
          break label773;
        }
        paramb.setVisibility(2131695316, 8);
        paramb.setVisibility(2131695317, 8);
      }
    }
    label687:
    label760:
    label773:
    do
    {
      return;
      paramb.setVisibility(2131695307, 8);
      paramb.setVisibility(2131695304, 8);
      break;
      paramb.setText(2131695312, "（" + paramDataBean.photoStatName + "）");
      break label562;
      paramb.setVisibility(2131695310, 8);
      break label577;
      paramb.setVisibility(2131695318, 8);
      break label653;
      if ("1".equals(paramDataBean.isTodayDiscount))
      {
        paramb.setVisibility(2131695316, 0);
        paramb.setVisibility(2131695317, 8);
        paramb.setVisibility(2131695318, 8);
        paramb.setOnClickListener(2131695316, new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            k.toMinsuSetHouseTodayDiscountActivity((Activity)o.k(o.this), paramDataBean.houseBaseFid, paramDataBean.rentWay, paramDataBean.houseRoomFid, o.this.d, o.this.e, 65535);
          }
        });
        return;
      }
    } while (!"2".equals(paramDataBean.isTodayDiscount));
    paramb.setVisibility(2131695316, 8);
    paramb.setVisibility(2131695317, 0);
    paramb.setVisibility(2131695318, 8);
    paramb.setText(2131695317, paramDataBean.todayDiscount);
  }
  
  public void setHouseTodayHint(String paramString1, String paramString2)
  {
    this.d = paramString1;
    this.e = paramString2;
  }
  
  public void setOnClickListener(a parama)
  {
    this.f = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onItemClick(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */