package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.l;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.account.AccountMainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.FeeItemListBean;
import com.ziroom.ziroomcustomer.minsu.bean.LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinSuUserSmartLock;
import com.ziroom.ziroomcustomer.minsu.bean.MinSuUserSmartLock.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCheckCardBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCheckCardBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactsListBean.ListUsualContactBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCustomerBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCustomerBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNewNeedPayBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNewNeedPayBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNewNeedPayBean.DataBean.DetailFeeBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderCancleBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderCancleBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderDetailBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderDetailBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderDetailBean.DataBean.DetialFeeBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderDetailBean.DataBean.UsualContactListBean;
import com.ziroom.ziroomcustomer.minsu.bean.OrderStatusEnum;
import com.ziroom.ziroomcustomer.minsu.dialog.i;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MinsuSignedActivity
  extends BaseActivity
  implements View.OnClickListener, PopupWindow.OnDismissListener, PlatformActionListener
{
  public static String a = "";
  public static String b = "";
  private OrderStatusEnum A;
  private String B;
  private String C;
  private String D;
  private int E;
  private int F = -1;
  private SimpleDraweeView G;
  private TextView H;
  private TextView I;
  private TextView J;
  private com.freelxl.baselibrary.a.a<MinsuContactsListBean.ListUsualContactBean> K;
  private String L;
  private Calendar M;
  private Calendar N;
  private MinsuNewNeedPayBean O;
  private ArrayList<MinsuContactsListBean.ListUsualContactBean> P = new ArrayList();
  private LinearLayout Q;
  private TextView R;
  private TextView S;
  private TextView T;
  private TextView U;
  private TextView V;
  private LinearLayout W;
  private CheckBox X;
  private TextView Y;
  private MinsuOrderDetailBean Z;
  private MinsuCustomerBean aa;
  private TextView ab;
  private int ac;
  private String ad;
  private String ae;
  private PopupWindow af;
  private LinearLayout ag;
  private LinearLayout ah;
  private String ai;
  private LinkedHashMap<String, String> aj = new LinkedHashMap();
  private String ak;
  private ArrayList<String> al = new ArrayList();
  private TextView am;
  private EditText an;
  private ObservableScrollView ao;
  private String ap;
  private TextView aq;
  private TextView ar;
  private RelativeLayout as;
  private TextView at;
  private ImageView au;
  private String av = "";
  private String aw = "";
  private PlatformActionListener ax = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      l.d("#########MeeT分享完成回调:平台", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享成功" + getClass().getSimpleName());
      MinsuSignedActivity.this.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      l.d("######### 1分享失败回调: 平台  ", paramAnonymousPlatform.getName() + "  action " + paramAnonymousInt + "====分享失败" + getClass().getSimpleName());
      paramAnonymousThrowable.printStackTrace();
      MinsuSignedActivity.this.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  private TextView ay;
  private Map<String, LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean> az;
  i c;
  com.ziroom.ziroomcustomer.minsu.view.a.b d;
  private TextView e;
  private TextView f;
  private LinearLayout g;
  private ListViewForScrollView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private TextView y;
  private CommonTitle z;
  
  private void a()
  {
    findViewById(2131691224).setVisibility(8);
    findViewById(2131691693).setVisibility(8);
  }
  
  private void a(Intent paramIntent)
  {
    if ("android.intent.action.VIEW".equals(paramIntent.getAction()))
    {
      paramIntent = paramIntent.getData();
      if (paramIntent != null) {
        this.L = paramIntent.getQueryParameter("orderSn");
      }
    }
  }
  
  private void a(final MinsuOrderDetailBean paramMinsuOrderDetailBean)
  {
    this.z.showRightIc(true, 2130838560);
    this.z.setOnRightButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = com.ziroom.threelib.ziroomshare.c.getInstance();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.setOnPlatformClickListener(new com.ziroom.threelib.ziroomshare.c.a()
          {
            public void onPlatformClick(Platform paramAnonymous2Platform)
            {
              v.onClick(MinsuSignedActivity.this, "M-Product_detail_share");
            }
          });
          paramAnonymousView.shareFromCenter(MinsuSignedActivity.this, paramMinsuOrderDetailBean.data.shareLinks, MinsuSignedActivity.this.getString(2131297145), MinsuSignedActivity.this.getString(2131297144).replace("city", paramMinsuOrderDetailBean.data.cityName), paramMinsuOrderDetailBean.data.picUrl, MinsuSignedActivity.n(MinsuSignedActivity.this));
        }
      }
    });
  }
  
  private void a(MinsuOrderDetailBean paramMinsuOrderDetailBean, boolean paramBoolean)
  {
    if (ae.notNull(paramMinsuOrderDetailBean.data.persistPswd))
    {
      this.ar.setVisibility(8);
      this.aq.setText("智能门锁密码：" + paramMinsuOrderDetailBean.data.persistPswd);
      this.aq.setVisibility(0);
      return;
    }
    if (ae.notNull(paramMinsuOrderDetailBean.data.dynaPswd))
    {
      if (!paramBoolean)
      {
        this.ar.setVisibility(8);
        this.aq.setText("智能门锁临时密码：" + paramMinsuOrderDetailBean.data.dynaPswd + "  (" + paramMinsuOrderDetailBean.data.dynaExpiredTimeStr + "失效)门锁异常,请联系房东或我们修复门锁");
        this.aq.setVisibility(0);
        return;
      }
      this.ar.setVisibility(8);
      this.aq.setText("智能门锁临时密码：" + paramMinsuOrderDetailBean.data.dynaPswd + "  (" + paramMinsuOrderDetailBean.data.dynaExpiredTimeStr + "失效)");
      this.aq.setVisibility(0);
      return;
    }
    a(paramBoolean, false);
  }
  
  private void a(final OrderStatusEnum paramOrderStatusEnum)
  {
    if ((paramOrderStatusEnum == OrderStatusEnum.DRZ) || (paramOrderStatusEnum == OrderStatusEnum.DQR))
    {
      this.w.setEnabled(false);
      com.ziroom.ziroomcustomer.minsu.e.a.ordreCancleMsg(this, this.L, new i.a()
      {
        public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
        
        public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
        {
          MinsuSignedActivity.d(MinsuSignedActivity.this).setEnabled(true);
          MinsuOrderCancleBean localMinsuOrderCancleBean = (MinsuOrderCancleBean)paramAnonymousk.getObject();
          if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuOrderCancleBean != null) && (localMinsuOrderCancleBean.checkSuccess(MinsuSignedActivity.this)))
          {
            MinsuSignedActivity.a(MinsuSignedActivity.this, localMinsuOrderCancleBean.data.msg, "取消订单");
            if (paramOrderStatusEnum == OrderStatusEnum.DRZ) {
              v.onClick(MinsuSignedActivity.this, "M-Confirm_cancel");
            }
            com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + localMinsuOrderCancleBean.toString());
            return;
          }
          if (localMinsuOrderCancleBean == null) {}
          for (paramAnonymousk = null;; paramAnonymousk = localMinsuOrderCancleBean.message)
          {
            ad.shouErrorMessage(paramAnonymousk);
            return;
          }
        }
      });
    }
    while (paramOrderStatusEnum != OrderStatusEnum.YRZ) {
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.checkOutOrderMsg(this, this.L, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuOrderCancleBean localMinsuOrderCancleBean = (MinsuOrderCancleBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuOrderCancleBean != null) && (localMinsuOrderCancleBean.checkSuccess(MinsuSignedActivity.this)))
        {
          MinsuSignedActivity.a(MinsuSignedActivity.this, localMinsuOrderCancleBean.data.msg, "退房");
          com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + localMinsuOrderCancleBean.toString());
          return;
        }
        if (localMinsuOrderCancleBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuOrderCancleBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void a(OrderStatusEnum paramOrderStatusEnum, MinsuOrderDetailBean paramMinsuOrderDetailBean, MinsuHouseDetailBean paramMinsuHouseDetailBean)
  {
    int k = 0;
    int m = 0;
    int j = 0;
    if (paramOrderStatusEnum == null) {}
    label1605:
    label1639:
    label1694:
    label1701:
    label1838:
    label1872:
    label1927:
    label1934:
    label2071:
    label2105:
    label2160:
    label2167:
    do
    {
      do
      {
        do
        {
          return;
          if (paramOrderStatusEnum != OrderStatusEnum.YD)
          {
            a();
            if (f.isNull(paramMinsuOrderDetailBean.data.msgInfo)) {
              this.T.setVisibility(8);
            }
            for (;;)
            {
              this.x.setText(paramMinsuOrderDetailBean.data.orderStatusName);
              this.H.setText(paramMinsuOrderDetailBean.data.houseName);
              this.X.setVisibility(8);
              this.Y.setVisibility(8);
              findViewById(2131691231).setVisibility(8);
              findViewById(2131691230).setVisibility(8);
              this.e.setText(paramMinsuOrderDetailBean.data.startTimeStr);
              this.f.setText(paramMinsuOrderDetailBean.data.endTimeStr);
              this.I.setText(paramMinsuOrderDetailBean.data.rentWayName);
              this.ab.setText(paramMinsuOrderDetailBean.data.orderSn);
              this.u.setText(" " + paramMinsuOrderDetailBean.data.detailFee.feeUnit + " " + ad.getPriceFormat(paramMinsuOrderDetailBean.data.detailFee.totalFee.intValue()));
              if (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(paramMinsuOrderDetailBean.data.depositMoney)) {
                this.v.setText(" " + paramMinsuOrderDetailBean.data.detailFee.feeUnit + " " + ad.getPriceFormat(paramMinsuOrderDetailBean.data.depositMoney.intValue()));
              }
              this.G.setController(com.freelxl.baselibrary.f.c.frescoController(paramMinsuOrderDetailBean.data.picUrl));
              this.ai = paramMinsuOrderDetailBean.data.picUrl;
              this.ap = paramMinsuOrderDetailBean.data.landlordMobile;
              this.V.setText(paramMinsuOrderDetailBean.data.houseAddr);
              if ((paramMinsuHouseDetailBean != null) && (paramMinsuHouseDetailBean.data != null)) {
                this.ap = paramMinsuHouseDetailBean.data.landlordMobile;
              }
              setPwdLockStatus(paramOrderStatusEnum, paramMinsuOrderDetailBean);
              this.ab.setVisibility(0);
              switch (29.a[paramOrderStatusEnum.ordinal()])
              {
              default: 
                return;
              case 1: 
                this.J.setVisibility(8);
                this.W.setVisibility(8);
                this.at.setVisibility(8);
                this.x.setVisibility(8);
                this.ab.setVisibility(8);
                this.y.setVisibility(8);
                this.Q.setVisibility(8);
                this.R.setVisibility(8);
                this.S.setVisibility(8);
                this.g.setVisibility(0);
                if ((ae.notNull(this.B)) && (ae.notNull(this.C)))
                {
                  this.e.setText(this.B);
                  this.f.setText(this.C);
                }
                this.w.setText("提交订单");
                this.w.setVisibility(0);
                this.w.setOnClickListener(new View.OnClickListener()
                {
                  @Instrumented
                  public void onClick(View paramAnonymousView)
                  {
                    VdsAgent.onClick(this, paramAnonymousView);
                    MinsuSignedActivity.j(MinsuSignedActivity.this);
                    if (MinsuSignedActivity.k(MinsuSignedActivity.this) == 1) {
                      v.onClick(MinsuSignedActivity.this, "M-Go_to_pay");
                    }
                    while (MinsuSignedActivity.k(MinsuSignedActivity.this) != 2) {
                      return;
                    }
                    v.onClick(MinsuSignedActivity.this, "M-Place_order");
                  }
                });
                return;
                this.T.setVisibility(0);
                this.T.setText(paramMinsuOrderDetailBean.data.msgInfo);
              }
            }
          }
          this.ac = paramMinsuHouseDetailBean.data.checkInLimit;
          if (f.isNull(paramMinsuHouseDetailBean.data.msgInfo)) {
            this.T.setVisibility(8);
          }
          for (;;)
          {
            this.H.setText(paramMinsuHouseDetailBean.data.houseName);
            this.I.setText(paramMinsuHouseDetailBean.data.rentWayName);
            this.G.setController(com.freelxl.baselibrary.f.c.frescoController(paramMinsuHouseDetailBean.data.defaultPic));
            this.ai = paramMinsuHouseDetailBean.data.defaultPic;
            break;
            this.T.setVisibility(0);
            this.T.setText(paramMinsuHouseDetailBean.data.msgInfo);
          }
          this.J.setVisibility(0);
          this.W.setVisibility(0);
          this.at.setVisibility(0);
          this.x.setVisibility(0);
          this.y.setVisibility(8);
          this.w.setVisibility(4);
          this.Q.setVisibility(8);
          this.R.setVisibility(8);
          this.S.setVisibility(8);
          this.g.setVisibility(8);
        } while (paramMinsuOrderDetailBean == null);
        a(paramMinsuOrderDetailBean);
        return;
        this.J.setVisibility(8);
        this.W.setVisibility(8);
        this.at.setVisibility(8);
        this.y.setVisibility(0);
        this.x.setVisibility(0);
        this.ad = paramMinsuOrderDetailBean.data.expireTime;
        this.y.setText("房东已经接受您的预订,请在" + paramMinsuOrderDetailBean.data.expireTime + "之前完成支付,否则订单将失效");
        this.Q.setVisibility(8);
        this.R.setVisibility(8);
        this.S.setVisibility(8);
        this.g.setVisibility(8);
        this.w.setVisibility(0);
        this.w.setText("去支付");
        this.w.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            MinsuSignedActivity.a(MinsuSignedActivity.this, null);
          }
        });
        return;
        this.J.setVisibility(0);
        this.W.setVisibility(0);
        this.at.setVisibility(0);
        this.y.setVisibility(8);
        this.x.setVisibility(0);
        this.g.setVisibility(8);
        this.Q.setVisibility(8);
        this.R.setVisibility(8);
        this.S.setVisibility(8);
        this.w.setVisibility(0);
        this.w.setText("取消订单");
        this.w.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            MinsuSignedActivity.a(MinsuSignedActivity.this, OrderStatusEnum.DRZ);
          }
        });
      } while (paramMinsuOrderDetailBean == null);
      a(paramMinsuOrderDetailBean);
      return;
      this.J.setVisibility(8);
      this.W.setVisibility(8);
      this.at.setVisibility(8);
      this.y.setVisibility(8);
      this.x.setVisibility(0);
      this.w.setVisibility(0);
      this.g.setVisibility(8);
      this.Q.setVisibility(8);
      this.R.setVisibility(8);
      this.S.setVisibility(8);
      this.w.setText("查看其它房源");
      this.w.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().push();
          com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().reset();
          com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setCityCode(MinsuSignedActivity.l(MinsuSignedActivity.this).data.cityCode);
          com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setCityName(MinsuSignedActivity.l(MinsuSignedActivity.this).data.cityName);
          com.ziroom.ziroomcustomer.minsu.f.k.toMinsuSearchList(MinsuSignedActivity.this);
          MinsuSignedActivity.this.finish();
        }
      });
      return;
      this.J.setVisibility(8);
      this.W.setVisibility(8);
      this.at.setVisibility(8);
      this.x.setVisibility(0);
      this.y.setVisibility(8);
      this.w.setVisibility(4);
      this.g.setVisibility(8);
      this.Q.setVisibility(8);
      this.R.setVisibility(8);
      this.S.setVisibility(8);
      return;
      this.J.setVisibility(8);
      this.W.setVisibility(8);
      this.at.setVisibility(8);
      this.x.setVisibility(0);
      this.y.setVisibility(8);
      this.w.setVisibility(4);
      this.g.setVisibility(8);
      this.Q.setVisibility(8);
      this.R.setVisibility(8);
      this.S.setVisibility(8);
      return;
      this.J.setVisibility(0);
      this.W.setVisibility(0);
      this.at.setVisibility(0);
      this.x.setVisibility(0);
      this.y.setVisibility(8);
      this.w.setVisibility(0);
      this.g.setVisibility(8);
      this.Q.setVisibility(0);
      this.R.setVisibility(0);
      this.S.setVisibility(0);
      this.w.setText("确认其他消费");
      this.w.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MinsuSignedActivity.m(MinsuSignedActivity.this);
        }
      });
      this.R.setText(ad.getPriceFormat(paramMinsuOrderDetailBean.data.otherMoney.intValue()));
      paramMinsuHouseDetailBean = this.S;
      StringBuilder localStringBuilder = new StringBuilder().append("明细:");
      if (ae.isNull(paramMinsuOrderDetailBean.data.otherMoneyDes))
      {
        paramOrderStatusEnum = "";
        paramMinsuHouseDetailBean.setText(paramOrderStatusEnum);
        paramOrderStatusEnum = this.S;
        if (paramMinsuOrderDetailBean.data.otherMoney.intValue() <= 0) {
          break label1694;
        }
        i = 0;
        paramOrderStatusEnum.setVisibility(i);
        paramOrderStatusEnum = this.Q;
        if (paramMinsuOrderDetailBean.data.otherMoney.intValue() <= 0) {
          break label1701;
        }
      }
      for (int i = j;; i = 8)
      {
        paramOrderStatusEnum.setVisibility(i);
        if (paramMinsuOrderDetailBean == null) {
          break;
        }
        a(paramMinsuOrderDetailBean);
        return;
        paramOrderStatusEnum = paramMinsuOrderDetailBean.data.otherMoneyDes;
        break label1605;
        i = 8;
        break label1639;
      }
      this.J.setVisibility(0);
      this.W.setVisibility(0);
      this.at.setVisibility(0);
      this.x.setVisibility(0);
      this.Q.setVisibility(0);
      this.R.setVisibility(0);
      this.y.setVisibility(8);
      this.w.setVisibility(4);
      this.g.setVisibility(8);
      this.R.setText(ad.getPriceFormat(paramMinsuOrderDetailBean.data.otherMoney.intValue()));
      paramMinsuHouseDetailBean = this.S;
      localStringBuilder = new StringBuilder().append("明细:");
      if (ae.isNull(paramMinsuOrderDetailBean.data.otherMoneyDes))
      {
        paramOrderStatusEnum = "";
        paramMinsuHouseDetailBean.setText(paramOrderStatusEnum);
        paramOrderStatusEnum = this.S;
        if (paramMinsuOrderDetailBean.data.otherMoney.intValue() <= 0) {
          break label1927;
        }
        i = 0;
        paramOrderStatusEnum.setVisibility(i);
        paramOrderStatusEnum = this.Q;
        if (paramMinsuOrderDetailBean.data.otherMoney.intValue() <= 0) {
          break label1934;
        }
      }
      for (i = k;; i = 8)
      {
        paramOrderStatusEnum.setVisibility(i);
        if (paramMinsuOrderDetailBean == null) {
          break;
        }
        a(paramMinsuOrderDetailBean);
        return;
        paramOrderStatusEnum = paramMinsuOrderDetailBean.data.otherMoneyDes;
        break label1838;
        i = 8;
        break label1872;
      }
      this.J.setVisibility(0);
      this.W.setVisibility(0);
      this.at.setVisibility(0);
      this.x.setVisibility(0);
      this.Q.setVisibility(0);
      this.R.setVisibility(0);
      this.y.setVisibility(8);
      this.g.setVisibility(8);
      this.w.setVisibility(4);
      this.R.setText(ad.getPriceFormat(paramMinsuOrderDetailBean.data.otherMoney.intValue()));
      paramMinsuHouseDetailBean = this.S;
      localStringBuilder = new StringBuilder().append("明细:");
      if (ae.isNull(paramMinsuOrderDetailBean.data.otherMoneyDes))
      {
        paramOrderStatusEnum = "";
        paramMinsuHouseDetailBean.setText(paramOrderStatusEnum);
        paramOrderStatusEnum = this.S;
        if (paramMinsuOrderDetailBean.data.otherMoney.intValue() <= 0) {
          break label2160;
        }
        i = 0;
        paramOrderStatusEnum.setVisibility(i);
        paramOrderStatusEnum = this.Q;
        if (paramMinsuOrderDetailBean.data.otherMoney.intValue() <= 0) {
          break label2167;
        }
      }
      for (i = m;; i = 8)
      {
        paramOrderStatusEnum.setVisibility(i);
        if (paramMinsuOrderDetailBean == null) {
          break;
        }
        a(paramMinsuOrderDetailBean);
        return;
        paramOrderStatusEnum = paramMinsuOrderDetailBean.data.otherMoneyDes;
        break label2071;
        i = 8;
        break label2105;
      }
      this.J.setVisibility(0);
      this.W.setVisibility(0);
      this.at.setVisibility(0);
      this.x.setVisibility(0);
      this.Q.setVisibility(8);
      this.R.setVisibility(8);
      this.S.setVisibility(8);
      this.y.setVisibility(8);
      this.g.setVisibility(8);
      this.w.setVisibility(0);
      this.w.setText("退房");
      this.w.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MinsuSignedActivity.a(MinsuSignedActivity.this, OrderStatusEnum.YRZ);
        }
      });
    } while (paramMinsuOrderDetailBean == null);
    a(paramMinsuOrderDetailBean);
    return;
    this.J.setVisibility(8);
    this.W.setVisibility(8);
    this.at.setVisibility(8);
    this.x.setVisibility(0);
    this.Q.setVisibility(8);
    this.R.setVisibility(8);
    this.S.setVisibility(8);
    this.y.setVisibility(8);
    this.g.setVisibility(8);
    this.w.setVisibility(4);
    this.w.setVisibility(0);
    this.w.setText("取消申请");
    this.w.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuSignedActivity.a(MinsuSignedActivity.this, OrderStatusEnum.DQR);
      }
    });
  }
  
  private void a(String paramString, final int paramInt)
  {
    e.newBuilder(this).setTitle("提示").setContent(paramString).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (paramInt == 1) {}
      }
    }).build().show();
  }
  
  private void a(final String paramString1, final String paramString2, final int paramInt, final String paramString3)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this).setTitle("提示").setBtnConfirmText(getString(2131296705)).setContent(getString(2131296706)).setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          paramAnonymousView = new Intent(MinsuSignedActivity.this, MinsuAddCerInfoActivity.class);
          paramAnonymousView.putExtra("username", paramString1);
          paramAnonymousView.putExtra("mobile", paramString2);
          paramAnonymousView.putExtra("idType", paramInt);
          paramAnonymousView.putExtra("idNumber", paramString3);
          MinsuSignedActivity.this.startActivityForResult(paramAnonymousView, 115);
          v.onClick(MinsuSignedActivity.this, "M-Go_to_fill");
        }
      }
    }).build().show();
  }
  
  private void a(Map<String, String> paramMap)
  {
    Object localObject1 = LayoutInflater.from(this).inflate(2130905056, null, false);
    ((View)localObject1).findViewById(2131691473).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
      }
    });
    Object localObject2 = (CommonTitle)((View)localObject1).findViewById(2131691272);
    ((CommonTitle)localObject2).showRightText(false, null);
    ((CommonTitle)localObject2).setLeftButtonType(4);
    ((CommonTitle)localObject2).setBottomLineVisible(false);
    ((CommonTitle)localObject2).setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuSignedActivity.q(MinsuSignedActivity.this).dismiss();
      }
    });
    localObject2 = (ListView)((View)localObject1).findViewById(2131691217);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramMap.entrySet());
    ((ListView)localObject2).setAdapter(new com.freelxl.baselibrary.a.a(this, localArrayList, 2130904446)
    {
      public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, Map.Entry<String, String> paramAnonymousEntry)
      {
        paramAnonymousb.setText(2131694973, (String)paramAnonymousEntry.getKey());
        paramAnonymousb.setText(2131694974, (String)paramAnonymousEntry.getValue());
      }
    });
    this.af = new PopupWindow(-1, -1);
    this.af.setContentView((View)localObject1);
    this.af.setFocusable(true);
    this.af.setOutsideTouchable(false);
    paramMap = this.af;
    localObject1 = this.w;
    int i = -ac.getScreenHeight(this) - this.w.getHeight() - 1;
    if (!(paramMap instanceof PopupWindow))
    {
      paramMap.showAsDropDown((View)localObject1, 0, i);
      return;
    }
    VdsAgent.showAsDropDown((PopupWindow)paramMap, (View)localObject1, 0, i);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) || (!paramBoolean2))
    {
      this.ar.setVisibility(0);
      this.ar.setText("点击获取密码");
      setPwdBunClickAble(true);
      this.aq.setVisibility(8);
      return;
    }
    if (this.Z.data.dynaNum == 2)
    {
      this.ar.setVisibility(0);
      this.ar.setText("点击获取密码");
      setPwdBunClickAble(true);
      this.aq.setVisibility(8);
      return;
    }
    this.ar.setText("点击获取临时密码");
    this.ar.setVisibility(0);
    setPwdBunClickAble(true);
    this.aq.setVisibility(8);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return (ae.isNull(paramString2)) || (!h.isMobile(paramString2)) || (ad.isNullOrNumber(paramString1));
  }
  
  private void b()
  {
    findViewById(2131691207).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        if (paramAnonymousInt8 - paramAnonymousInt4 > 0) {
          MinsuSignedActivity.a(MinsuSignedActivity.this).smoothScrollBy(0, com.ziroom.commonlibrary.widget.gridpasswordview.c.dp2px(MinsuSignedActivity.this, 210));
        }
      }
    });
  }
  
  private void b(int paramInt)
  {
    if (this.A != OrderStatusEnum.YD) {
      return;
    }
    d(paramInt);
  }
  
  private void b(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, MinsuDialogActivity.class);
    localIntent.putExtra("content", paramString1);
    localIntent.putExtra("title", paramString2);
    startActivityForResult(localIntent, 112);
  }
  
  private void c(final int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getOrderDetail(this, this.L, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuOrderDetailBean localMinsuOrderDetailBean = (MinsuOrderDetailBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuOrderDetailBean != null) && (localMinsuOrderDetailBean.checkSuccess(MinsuSignedActivity.this)))
        {
          if ((localMinsuOrderDetailBean.data.payStatus.intValue() == 1) && (localMinsuOrderDetailBean.data.orderStatus.intValue() == 33) && (paramInt == -1))
          {
            MinsuSignedActivity.this.showPaySuccessOrderFailurePage();
            return;
          }
          MinsuSignedActivity.b(MinsuSignedActivity.this, localMinsuOrderDetailBean.data.houseFid);
          MinsuSignedActivity.b(MinsuSignedActivity.this, localMinsuOrderDetailBean.data.rentWay.intValue());
          MinsuSignedActivity.a(MinsuSignedActivity.this, localMinsuOrderDetailBean);
          MinsuSignedActivity.b(MinsuSignedActivity.this).clear();
          MinsuSignedActivity.b(MinsuSignedActivity.this, MinsuSignedActivity.this.getOrderStatusEnum(localMinsuOrderDetailBean.data.orderStatusShowCode.intValue()));
          paramAnonymousk = localMinsuOrderDetailBean.data.usualContactList.iterator();
          while (paramAnonymousk.hasNext())
          {
            MinsuOrderDetailBean.DataBean.UsualContactListBean localUsualContactListBean = (MinsuOrderDetailBean.DataBean.UsualContactListBean)paramAnonymousk.next();
            MinsuContactsListBean.ListUsualContactBean localListUsualContactBean = new MinsuContactsListBean.ListUsualContactBean();
            localListUsualContactBean.conName = localUsualContactListBean.conName;
            localListUsualContactBean.cardType = localUsualContactListBean.cardType;
            localListUsualContactBean.cardValue = localUsualContactListBean.cardValue;
            localListUsualContactBean.userUid = localUsualContactListBean.userUid;
            localListUsualContactBean.conTel = localUsualContactListBean.conTel;
            localListUsualContactBean.isShowDel = 1;
            MinsuSignedActivity.b(MinsuSignedActivity.this).add(localListUsualContactBean);
          }
          MinsuSignedActivity.c(MinsuSignedActivity.this).setDatas(MinsuSignedActivity.b(MinsuSignedActivity.this));
          MinsuSignedActivity.c(MinsuSignedActivity.this).notifyDataSetChanged();
          MinsuSignedActivity.a(MinsuSignedActivity.this, MinsuSignedActivity.o(MinsuSignedActivity.this), localMinsuOrderDetailBean, null);
          MinsuSignedActivity.p(MinsuSignedActivity.this);
          com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + localMinsuOrderDetailBean.toString());
          return;
        }
        if (localMinsuOrderDetailBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuOrderDetailBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void d(int paramInt) {}
  
  private void d(String paramString)
  {
    int i;
    if (this.A == OrderStatusEnum.YD)
    {
      int j = this.O.data.totalFee.intValue();
      i = j;
      if (j <= 0)
      {
        if (ae.notNull(this.L)) {
          c(0);
        }
        if ((this.A == OrderStatusEnum.YD) && (ae.notNull(this.D)) && (ae.notNull(this.E + "")) && (ae.notNull(this.B)) && (ae.notNull(this.C))) {
          j();
        }
      }
    }
    else
    {
      i = this.Z.data.needPay.intValue();
    }
    Intent localIntent = new Intent(this, MinsuToPayActivity.class);
    localIntent.putExtra("orderMap", this.aj);
    localIntent.putExtra("feesList", this.ak);
    localIntent.putExtra("orderSn", this.L);
    localIntent.putExtra("price", i);
    String str = paramString;
    if (ae.isNull(paramString)) {
      str = this.Z.data.expireTime;
    }
    localIntent.putExtra("time", str);
    localIntent.putExtra("houseImg", this.ai);
    localIntent.putExtra("houseName", this.H.getText());
    localIntent.putExtra("rentWay", this.I.getText());
    startActivityForResult(localIntent, 118);
  }
  
  private void e()
  {
    this.ao = ((ObservableScrollView)findViewById(2131689506));
    this.V = ((TextView)findViewById(2131691378));
    this.W = ((LinearLayout)findViewById(2131691682));
    this.X = ((CheckBox)findViewById(2131689720));
    this.Y = ((TextView)findViewById(2131691695));
    this.w = ((TextView)findViewById(2131689956));
    this.u = ((TextView)findViewById(2131691236));
    this.v = ((TextView)findViewById(2131691238));
    this.t = ((TextView)findViewById(2131690666));
    this.s = ((TextView)findViewById(2131690049));
    this.r = ((ListViewForScrollView)findViewById(2131691217));
    this.g = ((LinearLayout)findViewById(2131691687));
    this.f = ((TextView)findViewById(2131691214));
    this.e = ((TextView)findViewById(2131691212));
    this.ah = ((LinearLayout)findViewById(2131691213));
    this.ag = ((LinearLayout)findViewById(2131691211));
    this.y = ((TextView)findViewById(2131691696));
    this.x = ((TextView)findViewById(2131691681));
    this.G = ((SimpleDraweeView)findViewById(2131691428));
    this.H = ((TextView)findViewById(2131691210));
    this.I = ((TextView)findViewById(2131691429));
    this.J = ((TextView)findViewById(2131691635));
    this.R = ((TextView)findViewById(2131691690));
    this.S = ((TextView)findViewById(2131691692));
    this.T = ((TextView)findViewById(2131691430));
    this.U = ((TextView)findViewById(2131691229));
    this.ab = ((TextView)findViewById(2131691680));
    this.Q = ((LinearLayout)findViewById(2131691689));
    this.am = ((TextView)findViewById(2131691688));
    this.aq = ((TextView)findViewById(2131691684));
    this.ar = ((TextView)findViewById(2131691685));
    this.as = ((RelativeLayout)findViewById(2131691683));
    this.at = ((TextView)findViewById(2131691686));
    this.J.setText("联系房东");
    this.J.setTextColor(getResources().getColor(2131624475));
    this.J.setBackgroundResource(2130839059);
    this.J.setOnClickListener(this);
    findViewById(2131691427).setOnClickListener(this);
    this.an = ((EditText)findViewById(2131691232));
    String str = getIntent().getStringExtra("tripPurpose");
    if (ae.notNull(str)) {
      this.an.setText(str);
    }
    this.an.addTextChangedListener(new a());
    this.K = new com.freelxl.baselibrary.a.a(this, this.P, 2130904293)
    {
      public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, MinsuContactsListBean.ListUsualContactBean paramAnonymousListUsualContactBean)
      {
        paramAnonymousb.setText(2131690049, "真实姓名 : " + paramAnonymousListUsualContactBean.conName);
        paramAnonymousb.setText(2131695224, com.ziroom.ziroomcustomer.minsu.b.a.getTypeString(this.a, paramAnonymousListUsualContactBean.cardType) + " : " + paramAnonymousListUsualContactBean.cardValue);
        paramAnonymousb.setText(2131690666, "联系方式 : " + paramAnonymousListUsualContactBean.conTel);
        paramAnonymousb.setTag(2131695223, paramAnonymousListUsualContactBean.fid);
        if (paramAnonymousListUsualContactBean.isShowDel == 0) {}
        for (int i = 0;; i = 8)
        {
          paramAnonymousb.setVisibility(2131695223, i);
          paramAnonymousb.setVisibility(2131695225, 8);
          paramAnonymousb.setOnClickListener(2131695223, new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              paramAnonymous2View = paramAnonymous2View.getTag().toString();
              Iterator localIterator = MinsuSignedActivity.b(MinsuSignedActivity.this).iterator();
              while (localIterator.hasNext()) {
                if (paramAnonymous2View.equals(((MinsuContactsListBean.ListUsualContactBean)localIterator.next()).fid))
                {
                  localIterator.remove();
                  MinsuSignedActivity.c(MinsuSignedActivity.this).notifyDataSetChanged();
                }
              }
            }
          });
          return;
        }
      }
    };
    this.r.setAdapter(this.K);
    this.X.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
        MinsuSignedActivity.d(MinsuSignedActivity.this).setEnabled(paramAnonymousBoolean);
        if (paramAnonymousBoolean)
        {
          MinsuSignedActivity.d(MinsuSignedActivity.this).setBackgroundColor(MinsuSignedActivity.this.getResources().getColor(2131624475));
          return;
        }
        MinsuSignedActivity.d(MinsuSignedActivity.this).setBackgroundColor(Color.parseColor("#e2e2e2"));
      }
    });
    this.Y.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MinsuSignedActivity.this, MinsuWebActivity.class);
        paramAnonymousView.putExtra("title", "服务协议");
        MinsuSignedActivity.this.startActivity(paramAnonymousView);
      }
    });
    findViewById(2131691697).setOnClickListener(this);
    this.ah.setOnClickListener(this);
    this.ag.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.ar.setOnClickListener(this);
    l();
  }
  
  private void f()
  {
    final Object localObject = new ArrayList();
    ((List)localObject).add(getString(2131296612));
    ((List)localObject).add(getString(2131296632));
    this.c = new i(this, new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (String)localObject.get(paramAnonymousInt);
        if (MinsuSignedActivity.this.getString(2131296612).equals(paramAnonymousAdapterView)) {
          if (ae.notNull(MinsuSignedActivity.e(MinsuSignedActivity.this))) {
            com.ziroom.ziroomcustomer.minsu.f.k.callPhone(MinsuSignedActivity.this, MinsuSignedActivity.e(MinsuSignedActivity.this));
          }
        }
        for (;;)
        {
          MinsuSignedActivity.this.c.dismiss();
          return;
          MinsuSignedActivity.f(MinsuSignedActivity.this);
        }
      }
    }, (List)localObject);
    if (ad.isKeyboardShown(findViewById(16908290)))
    {
      ad.hideSoftInput(this);
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          i locali = MinsuSignedActivity.this.c;
          View localView = MinsuSignedActivity.this.getWindow().getDecorView();
          if (!(locali instanceof PopupWindow))
          {
            locali.showAtLocation(localView, 80, 0, 0);
            return;
          }
          VdsAgent.showAtLocation((PopupWindow)locali, localView, 80, 0, 0);
        }
      }, 250L);
      return;
    }
    localObject = this.c;
    View localView = getWindow().getDecorView();
    if (!(localObject instanceof PopupWindow))
    {
      ((i)localObject).showAtLocation(localView, 80, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)localObject, localView, 80, 0, 0);
  }
  
  private void g()
  {
    v.onClick(this, "M-Add_coupon");
    if ((ae.isNull(this.B)) || (ae.isNull(this.C)))
    {
      showToast("请选择入住时间段");
      return;
    }
    com.ziroom.ziroomcustomer.minsu.f.k.toMinsuCouponListActivity(this, this.E, this.D, this.B, this.C);
  }
  
  private void h()
  {
    com.ziroom.ziroomcustomer.minsu.f.k.toCustomerListPage(this, this.ac, this.P);
  }
  
  private void i()
  {
    this.ay.setText("我有优惠券");
    this.ay.setCompoundDrawablesRelativeWithIntrinsicBounds(2130838746, 0, 0, 0);
    this.av = "";
  }
  
  private void j()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.needPayFee(this, this.D, this.E, this.B, this.C, this.av, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        paramAnonymousk.setObject(paramAnonymousString);
        com.freelxl.baselibrary.f.d.e("lanzhihong", "str======" + paramAnonymousString);
      }
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuSignedActivity.a(MinsuSignedActivity.this, (MinsuNewNeedPayBean)paramAnonymousk.getObject());
        if ((paramAnonymousk.getSuccess().booleanValue()) && (MinsuSignedActivity.g(MinsuSignedActivity.this) != null) && (MinsuSignedActivity.g(MinsuSignedActivity.this).checkSuccess(MinsuSignedActivity.this)))
        {
          com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + MinsuSignedActivity.g(MinsuSignedActivity.this).toString());
          MinsuSignedActivity.h(MinsuSignedActivity.this).setText(" " + MinsuSignedActivity.g(MinsuSignedActivity.this).data.feeUnit + " " + ad.getPriceFormat(MinsuSignedActivity.g(MinsuSignedActivity.this).data.detailFee.totalFee));
          MinsuSignedActivity.i(MinsuSignedActivity.this);
          return;
        }
        if (MinsuSignedActivity.g(MinsuSignedActivity.this) == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = MinsuSignedActivity.g(MinsuSignedActivity.this).message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void k()
  {
    Object localObject1;
    Object localObject2;
    if (this.aa != null)
    {
      localObject1 = this.aa.data.customerMobile;
      localObject1 = this.aa.data.realName;
      localObject2 = this.aa.data.showMobile;
      if (!a((String)localObject1, (String)localObject2)) {
        break label84;
      }
      a((String)localObject1, (String)localObject2, this.aa.data.idType, this.aa.data.idNo);
    }
    for (;;)
    {
      return;
      showToast("用户信息错误");
      return;
      label84:
      if ((ae.isNull(this.B)) || (ae.isNull(this.C)))
      {
        showToast("请选择入住时间段");
        return;
      }
      if ((this.P == null) || (this.P.isEmpty()))
      {
        showToast("请选择入住人");
        return;
      }
      if ((this.ac > 0) && (this.P.size() > this.ac))
      {
        showToast("该房源入住人数最多为" + this.ac);
        return;
      }
      localObject1 = new ArrayList();
      localObject2 = this.P.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(((MinsuContactsListBean.ListUsualContactBean)((Iterator)localObject2).next()).fid);
      }
    }
  }
  
  private void l()
  {
    this.ay = ((TextView)findViewById(2131691694));
    findViewById(2131691224).setOnClickListener(this);
  }
  
  private void m()
  {
    if ((this.A == OrderStatusEnum.DRZ) || (this.A == OrderStatusEnum.DQR)) {
      com.ziroom.ziroomcustomer.minsu.e.a.ordreCancle(this, this.L, new i.a()
      {
        public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
        
        public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
        {
          MinsuBaseJson localMinsuBaseJson = (MinsuBaseJson)paramAnonymousk.getObject();
          if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuBaseJson != null) && (localMinsuBaseJson.checkSuccess(MinsuSignedActivity.this)))
          {
            MinsuSignedActivity.this.showToast("取消成功!");
            MinsuSignedActivity.a(MinsuSignedActivity.this, 0);
            com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + localMinsuBaseJson.toString());
            return;
          }
          if (localMinsuBaseJson == null) {}
          for (paramAnonymousk = null;; paramAnonymousk = localMinsuBaseJson.message)
          {
            ad.shouErrorMessage(paramAnonymousk);
            return;
          }
        }
      });
    }
    while (this.A != OrderStatusEnum.YRZ) {
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.checkOutOrder(this, this.L, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuBaseJson localMinsuBaseJson = (MinsuBaseJson)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuBaseJson != null) && (localMinsuBaseJson.checkSuccess(MinsuSignedActivity.this)))
        {
          MinsuSignedActivity.this.showToast("退房成功!");
          MinsuSignedActivity.a(MinsuSignedActivity.this, 0);
          com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + localMinsuBaseJson.toString());
          return;
        }
        if (localMinsuBaseJson == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuBaseJson.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void n()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.confirmOtherMoney(this, this.L, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuBaseJson localMinsuBaseJson = (MinsuBaseJson)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuBaseJson != null) && (localMinsuBaseJson.checkSuccess(MinsuSignedActivity.this)))
        {
          MinsuSignedActivity.this.showToast("成功!");
          MinsuSignedActivity.a(MinsuSignedActivity.this, 0);
          com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + localMinsuBaseJson.toString());
          return;
        }
        if (localMinsuBaseJson == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuBaseJson.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void o()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getHouseListDetail(this, this.D, this.E, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuHouseDetailBean localMinsuHouseDetailBean = (MinsuHouseDetailBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHouseDetailBean != null) && (localMinsuHouseDetailBean.checkSuccess(MinsuSignedActivity.this)))
        {
          MinsuSignedActivity.a(MinsuSignedActivity.this, OrderStatusEnum.YD, null, localMinsuHouseDetailBean);
          MinsuSignedActivity.c(MinsuSignedActivity.this, localMinsuHouseDetailBean.data.orderType);
          com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + localMinsuHouseDetailBean.toString());
          return;
        }
        if (localMinsuHouseDetailBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuHouseDetailBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void p()
  {
    q();
    a(this.aj);
  }
  
  private void q()
  {
    this.aj.clear();
    if ((this.A == OrderStatusEnum.YD) && (this.O == null)) {
      if ((ae.notNull(this.B)) && (ae.notNull(this.C))) {
        j();
      }
    }
    for (;;)
    {
      return;
      if ((this.A == OrderStatusEnum.YD) && (this.O != null) && (this.O.data != null)) {
        s();
      }
      while ((this.aj != null) && (this.aj.size() < 1))
      {
        return;
        if ((this.A == OrderStatusEnum.YD) || (this.Z == null)) {
          break label123;
        }
        r();
      }
    }
    label123:
    showToast("暂无订单明细数据!");
  }
  
  private void r()
  {
    if (this.A == OrderStatusEnum.YD) {}
    while ((this.Z == null) || (this.Z.data == null) || (this.Z.data.detailFee == null)) {
      return;
    }
    String str1;
    label82:
    FeeItemListBean localFeeItemListBean;
    LinkedHashMap localLinkedHashMap;
    String str3;
    StringBuilder localStringBuilder;
    if (com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.Z.data.detailFee.feeUnit))
    {
      str1 = "";
      Iterator localIterator = this.Z.data.detailFee.feeItemList.iterator();
      if (!localIterator.hasNext()) {
        break label220;
      }
      localFeeItemListBean = (FeeItemListBean)localIterator.next();
      localLinkedHashMap = this.aj;
      str3 = localFeeItemListBean.name;
      localStringBuilder = new StringBuilder();
      if (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(localFeeItemListBean.symbol)) {
        break label211;
      }
    }
    label211:
    for (String str2 = "";; str2 = localFeeItemListBean.symbol)
    {
      localLinkedHashMap.put(str3, str2 + str1 + localFeeItemListBean.fee);
      if (localFeeItemListBean.colorType.intValue() == 0) {
        break label82;
      }
      this.al.add(localFeeItemListBean.name);
      break label82;
      str1 = this.Z.data.detailFee.feeUnit;
      break;
    }
    label220:
    this.ak = com.alibaba.fastjson.a.toJSONString(this.Z.data.detailFee.feeItemList);
  }
  
  private void s()
  {
    if ((this.O == null) || (this.O.data.totalFee == null) || (this.O.data.feeItemList == null)) {
      return;
    }
    if (com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.O.data.feeUnit)) {}
    for (String str = "";; str = this.O.data.feeUnit)
    {
      Iterator localIterator = this.O.data.feeItemList.iterator();
      while (localIterator.hasNext())
      {
        FeeItemListBean localFeeItemListBean = (FeeItemListBean)localIterator.next();
        this.aj.put(localFeeItemListBean.name, localFeeItemListBean.symbol + str + localFeeItemListBean.fee);
        if (localFeeItemListBean.colorType.intValue() != 0) {
          this.al.add(localFeeItemListBean.name);
        }
      }
    }
    this.ak = com.alibaba.fastjson.a.toJSONString(this.O.data.feeItemList);
  }
  
  private void t()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getCustomerVo(this, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuCustomerBean localMinsuCustomerBean = (MinsuCustomerBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuCustomerBean != null) && (localMinsuCustomerBean.checkSuccess(MinsuSignedActivity.this)))
        {
          if (localMinsuCustomerBean.data == null) {
            return;
          }
          MinsuSignedActivity.r(MinsuSignedActivity.this).setText(localMinsuCustomerBean.data.realName);
          MinsuSignedActivity.s(MinsuSignedActivity.this).setText(localMinsuCustomerBean.data.customerMobile);
          MinsuSignedActivity.t(MinsuSignedActivity.this).setText(localMinsuCustomerBean.data.idNo);
          MinsuSignedActivity.u(MinsuSignedActivity.this).setText(com.ziroom.ziroomcustomer.minsu.b.a.getTypeString(MinsuSignedActivity.this, localMinsuCustomerBean.data.idType));
          MinsuSignedActivity.a(MinsuSignedActivity.this, localMinsuCustomerBean);
          if ((MinsuSignedActivity.o(MinsuSignedActivity.this) == OrderStatusEnum.YD) && (MinsuSignedActivity.b(MinsuSignedActivity.this, MinsuSignedActivity.v(MinsuSignedActivity.this).data.realName, MinsuSignedActivity.v(MinsuSignedActivity.this).data.showMobile))) {
            MinsuSignedActivity.a(MinsuSignedActivity.this, MinsuSignedActivity.v(MinsuSignedActivity.this).data.realName, MinsuSignedActivity.v(MinsuSignedActivity.this).data.showMobile, MinsuSignedActivity.v(MinsuSignedActivity.this).data.idType, MinsuSignedActivity.v(MinsuSignedActivity.this).data.idNo);
          }
          com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + localMinsuCustomerBean.toString());
          return;
        }
        if (localMinsuCustomerBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuCustomerBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void u()
  {
    if ("点击获取密码".equals(this.ar.getText()))
    {
      getPwd();
      return;
    }
    getDynaPwd();
  }
  
  private void v()
  {
    com.ziroom.ziroomcustomer.minsu.f.k.toImPage(this, this.Z.data.landlordUid, this.D, this.E, 2, MinsuSignedActivity.class.getSimpleName());
  }
  
  private void w()
  {
    com.ziroom.ziroomcustomer.minsu.view.a.b localb;
    View localView;
    if (!aa.getString(this, "guide", "").equals("one"))
    {
      this.au = ((ImageView)findViewById(2131690751));
      this.d = new com.ziroom.ziroomcustomer.minsu.view.a.b(this, ab.dp2px(this, 5.0F), ab.dp2px(this, 17.0F));
      this.d.setOnDismissListener(this);
      localb = this.d;
      localView = findViewById(16908290);
      if ((localb instanceof PopupWindow)) {
        break label113;
      }
      localb.showAtLocation(localView, 0, 0, 0);
    }
    for (;;)
    {
      aa.putString(this, "guide", "one");
      this.au.setVisibility(4);
      return;
      label113:
      VdsAgent.showAtLocation((PopupWindow)localb, localView, 0, 0, 0);
    }
  }
  
  public void checkCard()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.checkCard(this, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuCheckCardBean localMinsuCheckCardBean = (MinsuCheckCardBean)paramAnonymousk.getObject();
        if ((localMinsuCheckCardBean != null) && (paramAnonymousk.getSuccess().booleanValue()) && (localMinsuCheckCardBean.checkSuccess(MinsuSignedActivity.this)))
        {
          if (!localMinsuCheckCardBean.data.cardFlag) {
            MinsuSignedActivity.this.showEditBankCardPage();
          }
        }
        else {
          return;
        }
        MinsuSignedActivity.x(MinsuSignedActivity.this);
      }
    });
  }
  
  public void getDynaPwd()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getUserDynaPswd(this, this.L, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinSuUserSmartLock localMinSuUserSmartLock = (MinSuUserSmartLock)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinSuUserSmartLock != null) && (localMinSuUserSmartLock.checkSuccess(MinsuSignedActivity.this)))
        {
          com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + localMinSuUserSmartLock.toString());
          MinsuSignedActivity.y(MinsuSignedActivity.this).setVisibility(0);
          MinsuSignedActivity.a(MinsuSignedActivity.this, "您本次临时密码是:" + localMinSuUserSmartLock.data.password + "  (" + localMinSuUserSmartLock.data.expiredTime + "后密码失效,临时密码只可获取两次,请尽快联系房东或我们修复门锁。)", 1);
          MinsuSignedActivity.z(MinsuSignedActivity.this).setVisibility(8);
          MinsuSignedActivity.A(MinsuSignedActivity.this).setVisibility(0);
          MinsuSignedActivity.A(MinsuSignedActivity.this).setText("智能门锁临时密码：" + localMinSuUserSmartLock.data.password + "  (" + localMinSuUserSmartLock.data.expiredTime + "失效)");
          MinsuSignedActivity.A(MinsuSignedActivity.this).setVisibility(0);
          return;
        }
        if ((localMinSuUserSmartLock != null) && (ae.notNull(localMinSuUserSmartLock.message)) && ("100002".equals(localMinSuUserSmartLock.message)))
        {
          MinsuSignedActivity.this.showTip("智能门锁出现故障,请及时联系房东或我们,如果门锁未能及时修复,您可在入住前30分钟获取临时密码");
          return;
        }
        if (localMinSuUserSmartLock == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinSuUserSmartLock.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  public OrderStatusEnum getOrderStatusEnum(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return OrderStatusEnum.DQR;
    case 2: 
      return OrderStatusEnum.DZF;
    case 3: 
      return OrderStatusEnum.DRZ;
    case 4: 
      return OrderStatusEnum.YQX;
    case 5: 
      return OrderStatusEnum.YJJ;
    case 6: 
      return OrderStatusEnum.YSX;
    case 7: 
      return OrderStatusEnum.YRZ;
    case 8: 
      return OrderStatusEnum.DFDQRXF;
    case 9: 
      return OrderStatusEnum.DNQRXF;
    case 10: 
      return OrderStatusEnum.TKZ;
    }
    return OrderStatusEnum.YWC;
  }
  
  public void getPwd()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getUserSmartLocks(this, this.L, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinSuUserSmartLock localMinSuUserSmartLock = (MinSuUserSmartLock)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinSuUserSmartLock != null) && (localMinSuUserSmartLock.checkSuccess(MinsuSignedActivity.this)))
        {
          com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + localMinSuUserSmartLock.toString());
          MinsuSignedActivity.y(MinsuSignedActivity.this).setVisibility(0);
          if (localMinSuUserSmartLock.data.status == 0)
          {
            MinsuSignedActivity.z(MinsuSignedActivity.this).setVisibility(0);
            MinsuSignedActivity.z(MinsuSignedActivity.this).setText("密码配置中");
            MinsuSignedActivity.this.setPwdBunClickAble(false);
            MinsuSignedActivity.A(MinsuSignedActivity.this).setVisibility(8);
            MinsuSignedActivity.this.showToast("密码配置中,请注意查收短信,密码将在入住前30分钟生效,请妥善保管您的密码。");
          }
          do
          {
            return;
            if (localMinSuUserSmartLock.data.status == 1)
            {
              MinsuSignedActivity.a(MinsuSignedActivity.this, true, false);
              return;
            }
          } while ((localMinSuUserSmartLock.data.status != 2) || (!ae.notNull(localMinSuUserSmartLock.data.password)));
          MinsuSignedActivity.z(MinsuSignedActivity.this).setVisibility(8);
          MinsuSignedActivity.A(MinsuSignedActivity.this).setVisibility(0);
          MinsuSignedActivity.A(MinsuSignedActivity.this).setText("智能门锁密码：" + localMinSuUserSmartLock.data.password);
          MinsuSignedActivity.A(MinsuSignedActivity.this).setVisibility(0);
          return;
        }
        if ((localMinSuUserSmartLock != null) && (ae.notNull(localMinSuUserSmartLock.message)) && ("100002".equals(localMinSuUserSmartLock.message)))
        {
          MinsuSignedActivity.a(MinsuSignedActivity.this, "您可在入住日前一天获取密码,请耐心等待", 1);
          return;
        }
        if ((localMinSuUserSmartLock != null) && (ae.notNull(localMinSuUserSmartLock.message)) && ("100006".equals(localMinSuUserSmartLock.message)))
        {
          MinsuSignedActivity.a(MinsuSignedActivity.this, "智能门锁出现故障,请及时联系房东或我们,如果门锁未能及时修复,您可在入住前30分钟获取临时密码", 1);
          return;
        }
        if (localMinSuUserSmartLock == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinSuUserSmartLock.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  public boolean getSmartLockSta(MinsuOrderDetailBean paramMinsuOrderDetailBean)
  {
    if ((paramMinsuOrderDetailBean == null) || (paramMinsuOrderDetailBean.data == null) || (paramMinsuOrderDetailBean.data.smartLockSta == null)) {}
    while ((this.Z.data.smartLockSta.intValue() == 1) || (this.Z.data.smartLockSta.intValue() == 3)) {
      return true;
    }
    return false;
  }
  
  public void initTitle()
  {
    this.z = ((CommonTitle)findViewById(2131691272));
    this.z.showRightText(false, null);
    if (this.A == OrderStatusEnum.YD) {
      if (ae.isNull(this.ae)) {
        this.z.setMiddleText("预订房间");
      }
    }
    for (;;)
    {
      this.z.setLeftButtonType(0);
      this.z.setOnLeftButtonClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MinsuSignedActivity.this.finish();
        }
      });
      return;
      this.z.setMiddleText("预订" + this.ae + "的房间");
      continue;
      this.z.setMiddleText("订单详情");
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    int i;
    String str;
    label348:
    Object localObject2;
    label532:
    long l;
    switch (paramInt1)
    {
    case 111: 
    case 114: 
    default: 
    case 110: 
    case 112: 
    case 117: 
    case 118: 
    case 113: 
      do
      {
        do
        {
          do
          {
            return;
          } while (paramInt2 != -1);
          this.P.clear();
          this.P.addAll((ArrayList)paramIntent.getSerializableExtra("contacts"));
          localObject1 = new StringBuilder().append(" -- ").append(this.P).append(" size = ");
          if (this.P == null) {}
          for (paramIntent = " null ";; paramIntent = " - " + this.P.size())
          {
            u.e("err", paramIntent);
            paramInt1 = 0;
            while (paramInt1 < this.P.size())
            {
              ((MinsuContactsListBean.ListUsualContactBean)this.P.get(paramInt1)).isShowDel = 0;
              paramInt1 += 1;
            }
          }
          this.K.notifyDataSetChanged();
          return;
        } while (paramInt2 != -1);
        m();
        return;
        c(0);
        return;
        if (paramInt2 == -1)
        {
          com.freelxl.baselibrary.f.d.e("error", "on activity result ");
          checkCard();
          c(-1);
          return;
        }
        c(0);
        return;
      } while (paramInt2 != -1);
      i();
      paramInt1 = paramIntent.getIntExtra("range", -1);
      i = paramIntent.getIntExtra("type", 0);
      localObject1 = paramIntent.getStringExtra("startTime");
      str = paramIntent.getStringExtra("endTime");
      switch (paramInt1)
      {
      case -1: 
      default: 
      case 0: 
      case 1: 
      case 2: 
        while ((ae.notNull(this.B)) && (ae.notNull(this.C)))
        {
          j();
          return;
          if (i == 1)
          {
            this.B = ((String)localObject1);
            this.e.setText(this.B);
          }
          else
          {
            this.C = str;
            this.f.setText(this.C);
            continue;
            if (i == 1)
            {
              this.B = paramIntent.getStringExtra("startTime");
              this.e.setText(this.B);
            }
            else
            {
              this.C = paramIntent.getStringExtra("endTime");
              this.f.setText(this.C);
            }
          }
        }
      case 3: 
        localObject2 = m.strToDate((String)localObject1, m.b);
        paramIntent = m.strToDate(str, m.b);
        if (i == 2)
        {
          if (m.strToDate(str, m.b).getTime() <= ((Date)localObject2).getTime()) {
            this.B = "";
          }
          this.C = str;
          paramInt1 = 0;
          l = (paramIntent.getTime() - ((Date)localObject2).getTime()) / 86400000L;
          paramIntent = Calendar.getInstance();
          paramIntent.setTime((Date)localObject2);
          paramInt2 = 0;
          label562:
          if (paramInt2 > l) {
            break label716;
          }
          paramIntent.add(5, 1);
          localObject2 = paramIntent.getTime();
          localObject2 = (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)this.az.get(m.getFormatDate((Date)localObject2, m.b));
          if (localObject2 == null) {
            break label875;
          }
          if (paramInt2 != 0) {
            break label673;
          }
          if ((((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject2).status == 0) || (((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject2).status == 4)) {
            break label875;
          }
          paramInt1 = 1;
        }
        break;
      }
      break;
    }
    label673:
    label716:
    label763:
    label875:
    for (;;)
    {
      paramInt2 += 1;
      break label562;
      if (m.strToDate((String)localObject1, m.b).getTime() >= paramIntent.getTime()) {
        this.C = "";
      }
      this.B = ((String)localObject1);
      break label532;
      if (paramInt2 == l)
      {
        if ((((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject2).status != 0) && (((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject2).status != 3)) {
          paramInt1 = 1;
        }
      }
      else if (((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject2).status != 0)
      {
        paramInt1 = 1;
        continue;
        if (paramInt1 != 0)
        {
          if (i != 2) {
            break label763;
          }
          this.B = "";
        }
        for (this.C = str;; this.C = "")
        {
          this.e.setText(this.B);
          this.f.setText(this.C);
          break;
          this.B = ((String)localObject1);
        }
        this.B = ((String)localObject1);
        this.e.setText(this.B);
        this.C = str;
        this.f.setText(this.C);
        break label348;
        if (paramInt2 != -1) {
          break;
        }
        t();
        return;
        if (paramInt2 != -1) {
          break;
        }
        this.av = paramIntent.getStringExtra("coupon");
        this.aw = paramIntent.getStringExtra("couponinfo");
        this.ay.setText(this.aw);
        this.ay.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        return;
      }
    }
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    showToast("分享取消");
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691427: 
      paramView = new Intent(this, MinsuHouseDetailActivity.class);
      paramView.putExtra("fid", this.D);
      paramView.putExtra("rentWay", this.E);
      paramView.putExtra("startTime", this.B);
      paramView.putExtra("endTime", this.C);
      startActivity(paramView);
      return;
    case 2131691635: 
      f();
      return;
    case 2131691697: 
      p();
      v.onClick(this, "M-Order_detail");
      return;
    case 2131691213: 
      b(2);
      return;
    case 2131691211: 
      b(1);
      return;
    case 2131689956: 
      k();
      return;
    case 2131691687: 
      h();
      return;
    case 2131691224: 
      g();
      return;
    }
    u();
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    showToast("分享成功");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903333);
    paramBundle = getIntent();
    this.A = ((OrderStatusEnum)paramBundle.getSerializableExtra("status"));
    this.D = paramBundle.getStringExtra("fid");
    this.L = paramBundle.getStringExtra("orderSn");
    this.ae = paramBundle.getStringExtra("lName");
    a(paramBundle);
    this.M = Calendar.getInstance();
    this.M.add(1, 1);
    this.N = Calendar.getInstance();
    this.N.add(1, -1);
    e();
    initTitle();
    if (this.A == OrderStatusEnum.YD)
    {
      GrowingIO.getInstance().setPageName(this, "下单页面");
      this.B = getIntent().getStringExtra("startTime");
      this.C = getIntent().getStringExtra("endTime");
      this.E = getIntent().getIntExtra("rentWay", 0);
      o();
      t();
    }
    for (;;)
    {
      b();
      return;
      GrowingIO.getInstance().setPageName(this, "订单详情页");
      c(0);
      t();
    }
  }
  
  public void onDismiss()
  {
    this.au.setVisibility(0);
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    showToast("分享失败");
    paramThrowable.printStackTrace();
    if ("SinaWeibo".equals(paramPlatform.getName()))
    {
      ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
      ShareSDK.removeCookieOnAuthorize(true);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (ae.notNull(this.L))
    {
      com.freelxl.baselibrary.f.d.e("error", "on resume");
      c(0);
    }
    if ((this.A == OrderStatusEnum.YD) && (ae.notNull(this.D)) && (ae.notNull(this.E + "")) && (ae.notNull(this.B)) && (ae.notNull(this.C))) {
      j();
    }
  }
  
  public void setPwdBunClickAble(boolean paramBoolean)
  {
    TextView localTextView = this.ar;
    if (paramBoolean)
    {
      i = 2130839059;
      localTextView.setBackgroundResource(i);
      this.ar.setClickable(paramBoolean);
      localTextView = this.ar;
      if (!paramBoolean) {
        break label59;
      }
    }
    label59:
    for (int i = getResources().getColor(2131624475);; i = getResources().getColor(2131624097))
    {
      localTextView.setTextColor(i);
      return;
      i = 2130839575;
      break;
    }
  }
  
  public void setPwdLockStatus(OrderStatusEnum paramOrderStatusEnum, MinsuOrderDetailBean paramMinsuOrderDetailBean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramMinsuOrderDetailBean == null) || (paramMinsuOrderDetailBean.data == null) || (paramMinsuOrderDetailBean.data.isLock == 0))
    {
      this.as.setVisibility(8);
      return;
    }
    switch (29.a[paramOrderStatusEnum.ordinal()])
    {
    default: 
      return;
    case 1: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    case 12: 
      this.as.setVisibility(8);
      return;
    case 4: 
    case 11: 
      this.as.setVisibility(0);
      boolean bool3 = getSmartLockSta(paramMinsuOrderDetailBean);
      if (paramMinsuOrderDetailBean.data.persistPswdStatus == null)
      {
        if (ae.notNull(paramMinsuOrderDetailBean.data.dynaPswd))
        {
          a(paramMinsuOrderDetailBean, bool3);
          return;
        }
        a(bool3, true);
        return;
      }
      if (paramMinsuOrderDetailBean.data.persistPswdStatus.intValue() == 2)
      {
        a(paramMinsuOrderDetailBean, bool3);
        return;
      }
      if (paramMinsuOrderDetailBean.data.persistPswdStatus.intValue() == 0)
      {
        this.ar.setVisibility(0);
        this.ar.setText("密码配置中");
        setPwdBunClickAble(false);
        this.aq.setVisibility(8);
        return;
      }
      if (paramMinsuOrderDetailBean.data.persistPswdStatus.intValue() == 6)
      {
        if (paramMinsuOrderDetailBean.data.isHalfHoure == 1) {}
        for (;;)
        {
          a(bool3, bool1);
          return;
          bool1 = false;
        }
      }
      if ((paramMinsuOrderDetailBean.data.persistPswdStatus.intValue() == 1) || (paramMinsuOrderDetailBean.data.persistPswdStatus.intValue() == 4))
      {
        if (paramMinsuOrderDetailBean.data.isHalfHoure == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(bool3, bool1);
          return;
        }
      }
      if ((paramMinsuOrderDetailBean.data.persistPswdStatus.intValue() == 3) || (paramMinsuOrderDetailBean.data.persistPswdStatus.intValue() == 5))
      {
        this.as.setVisibility(0);
        this.aq.setText("智能门锁密码: 密码已过期失效");
        this.aq.setVisibility(0);
        this.ar.setVisibility(8);
        return;
      }
      a(paramMinsuOrderDetailBean, bool3);
      return;
    }
    this.as.setVisibility(0);
    this.aq.setText("智能门锁密码: 密码已过期失效");
    this.aq.setVisibility(0);
    this.ar.setVisibility(8);
  }
  
  public void showEditBankCardPage()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setTitle("提示").setContent("请提供给我们一张您的银行卡，以便我们把押金或退款及时退还至银行卡！若未提供，可电脑登陆自如网-个人中心-我的钱包进行手动提现。").setButtonText("先不了", "这就去提供").setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(MinsuSignedActivity.this, AccountMainActivity.class);
        MinsuSignedActivity.this.startActivity(paramAnonymousView);
      }
    }).show();
  }
  
  public void showPaySuccessOrderFailurePage()
  {
    Intent localIntent = new Intent(this, MinsuOrderSuccessfulActivity.class);
    localIntent.putExtra("msg", "我们收到了您的支付款！可惜您超过了订单支付的时间，我们已经给您操作退款，请注意查收！试试看重新预订吧~");
    localIntent.putExtra("lName", "提示");
    localIntent.putExtra("type", 1);
    localIntent.putExtra("btnText", "确定");
    startActivityForResult(localIntent, 117);
  }
  
  public class a
    implements TextWatcher
  {
    public a() {}
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if (com.ziroom.ziroomcustomer.minsu.f.c.getLength(paramCharSequence.toString()) >= 256)
      {
        g.textToast(MinsuSignedActivity.this, "字数太长了！");
        paramCharSequence = paramCharSequence.subSequence(0, paramInt1) + "";
        MinsuSignedActivity.w(MinsuSignedActivity.this).setText(paramCharSequence);
        MinsuSignedActivity.w(MinsuSignedActivity.this).setSelection(paramCharSequence.length());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuSignedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */