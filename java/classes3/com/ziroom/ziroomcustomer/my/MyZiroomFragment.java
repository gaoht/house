package com.ziroom.ziroomcustomer.my;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.u;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.commonlibrary.login.a.b;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.datacenter.remote.responsebody.financial.b.m;
import com.ziroom.router.activityrouter.Routers;
import com.ziroom.ziroomcustomer.account.AccountMainActivity;
import com.ziroom.ziroomcustomer.activity.IntellectLockActivity;
import com.ziroom.ziroomcustomer.activity.LeaseActivity;
import com.ziroom.ziroomcustomer.activity.MessageCenterActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.e.h;
import com.ziroom.ziroomcustomer.e.e.p;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxFragment;
import com.ziroom.ziroomcustomer.gesturelock.GestureLockActivity;
import com.ziroom.ziroomcustomer.home.view.PZAcitivitiesItemView;
import com.ziroom.ziroomcustomer.home.view.PZAcitivitiesItemView.a;
import com.ziroom.ziroomcustomer.home.view.PZAcitivitiesItemView.a.a;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuMyActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuSignedActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCmsBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCmsBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.dialog.i;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.CreditsBean;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.adapter.RecommendHouseAdapter;
import com.ziroom.ziroomcustomer.my.model.AdModel;
import com.ziroom.ziroomcustomer.my.model.HaiyanActivityModel;
import com.ziroom.ziroomcustomer.my.model.MinsuOrderBean;
import com.ziroom.ziroomcustomer.my.model.MinsuOrderBean.MinsuOrderListBean;
import com.ziroom.ziroomcustomer.my.model.MyActivityDataBean;
import com.ziroom.ziroomcustomer.my.model.MyStewardListEntity;
import com.ziroom.ziroomcustomer.my.model.MyTravelMinsuAndZiRuYiOrderMo;
import com.ziroom.ziroomcustomer.my.model.MyZiroomContract;
import com.ziroom.ziroomcustomer.my.model.OrderDataBean;
import com.ziroom.ziroomcustomer.my.model.RecommendActivitiesModel;
import com.ziroom.ziroomcustomer.my.model.RecommendActivitiesModel.ContentBean;
import com.ziroom.ziroomcustomer.my.model.ReserveV2Bean;
import com.ziroom.ziroomcustomer.my.model.ZiruyiOrderBean;
import com.ziroom.ziroomcustomer.my.model.ZiruyiOrderBean.ZiRuYiOrderListBean;
import com.ziroom.ziroomcustomer.my.selfsetting.SelfSettingActivity;
import com.ziroom.ziroomcustomer.my.widget.MyZiroomCardViewCommunity;
import com.ziroom.ziroomcustomer.my.widget.MyZiroomCardViewContract;
import com.ziroom.ziroomcustomer.my.widget.MyZiroomCardViewV2Order;
import com.ziroom.ziroomcustomer.my.widget.MyZiroomCardViewZSpace;
import com.ziroom.ziroomcustomer.newchat.chatcenter.ChatCenterActivity;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.SuggAndComActivity;
import com.ziroom.ziroomcustomer.newclean.mvp.CleanHomeActivity;
import com.ziroom.ziroomcustomer.signed.CertInformationActivity;
import com.ziroom.ziroomcustomer.signed.CertificationInfoActivity;
import com.ziroom.ziroomcustomer.social.activity.ac.AcEnrollListActivityNew;
import com.ziroom.ziroomcustomer.social.activity.ac.AcMainActivity;
import com.ziroom.ziroomcustomer.util.MessageUtil;
import com.ziroom.ziroomcustomer.util.MessageUtil.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.c.f.a;
import com.ziroom.ziroomcustomer.util.c.f.b;
import com.ziroom.ziroomcustomer.util.c.f.c;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.HorizontalListView;
import com.ziroom.ziroomcustomer.widget.IntellectDeviceView;
import com.ziroom.ziroomcustomer.widget.IntellectHomeView;
import com.ziroom.ziroomcustomer.widget.MyInfoItemView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuSdActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuContractItem;
import com.ziroom.ziroomcustomer.ziroomstation.OrderDetailActivity;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class MyZiroomFragment
  extends BaseFluxFragment
  implements View.OnClickListener, ObservableScrollView.a
{
  private static long bf = 0L;
  TextView A;
  LinearLayout B;
  TextView C;
  TextView D;
  TextView E;
  MyZiroomCardViewV2Order F;
  LinearLayout G;
  MyZiroomCardViewContract H;
  HorizontalListView I;
  IntellectHomeView J;
  IntellectHomeView K;
  IntellectHomeView L;
  IntellectHomeView M;
  IntellectHomeView N;
  IntellectHomeView O;
  IntellectHomeView P;
  IntellectHomeView Q;
  IntellectHomeView R;
  MyInfoItemView S;
  MyInfoItemView T;
  MyInfoItemView U;
  MyInfoItemView V;
  RecyclerView W;
  LinearLayout X;
  ObservableScrollView Y;
  View Z;
  private ConvenientBanner aA;
  private LinearLayout aB;
  private ImageView aC;
  private UserInfo aD;
  private String aE;
  private BroadcastReceiver aF;
  private int aG = 0;
  private int aH = 0;
  private int aI = 0;
  private int aJ;
  private boolean aK;
  private EMConversation aL;
  private EMMessageListener aM;
  private boolean aN = false;
  private boolean aO = false;
  private MinsuCmsBean aP;
  private RecommendActivitiesModel aQ;
  private HaiyanActivityModel aR;
  private MinsuCmsBean aS;
  private MyTravelMinsuAndZiRuYiOrderMo aT;
  private List<MinsuOrderBean.MinsuOrderListBean> aU;
  private List<ZiruyiOrderBean.ZiRuYiOrderListBean> aV;
  private MinsuOrderBean aW;
  private ZiruyiOrderBean aX;
  private int aY;
  private Context aZ;
  TextView aa;
  ImageView ab;
  ImageView ac;
  TextView ad;
  View ae;
  TextView af;
  LinearLayout ag;
  LinearLayout ah;
  LinearLayout ai;
  LinearLayout aj;
  TextView ak;
  TextView al;
  TextView am;
  TextView an;
  TextView ao;
  Button ap;
  ImageView aq;
  int ar = 0;
  int as = 0;
  int at = 0;
  int au = 0;
  int av;
  i aw;
  public Handler ax = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      MyZiroomFragment.this.dismissProgress();
    }
  };
  protected String ay;
  public BroadcastReceiver az = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent.getIntExtra("type", 0) == 7) && (MyZiroomFragment.y(MyZiroomFragment.this) != null))
      {
        MyZiroomFragment.z(MyZiroomFragment.this);
        MyZiroomFragment.y(MyZiroomFragment.this).sendEmptyMessageDelayed(1, 1200L);
      }
    }
  };
  MyZiroomCardViewZSpace b;
  private int ba = 1;
  private c bb;
  private boolean bc;
  private View bd;
  private List<MyStewardListEntity> be;
  private com.ziroom.ziroomcustomer.e.a.f bg = new com.ziroom.ziroomcustomer.e.a.f(this.aZ, new com.ziroom.ziroomcustomer.e.c.f(com.alibaba.fastjson.e.class))
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      MyZiroomFragment.a(MyZiroomFragment.this, 0);
    }
    
    public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      if (paramAnonymouse != null) {
        MyZiroomFragment.a(MyZiroomFragment.this, paramAnonymouse.getInteger("userType").intValue());
      }
    }
  };
  private com.ziroom.ziroomcustomer.e.a.f<com.alibaba.fastjson.e> bh = new com.ziroom.ziroomcustomer.e.a.f(this.aZ, new com.ziroom.ziroomcustomer.e.c.o())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
    }
    
    public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
    {
      paramAnonymouse = (CertInfoEntity)com.ziroom.ziroomcustomer.ziroomstation.utils.h.parseObject(paramAnonymouse.toJSONString(), CertInfoEntity.class);
      Intent localIntent;
      if ((paramAnonymouse != null) && (paramAnonymouse.credits != null) && (paramAnonymouse.credits.realNameStatus != 0)) {
        localIntent = new Intent();
      }
      switch (paramAnonymouse.credits.realNameStatus)
      {
      default: 
        return;
      case 2: 
        localIntent.setClass(MyZiroomFragment.e(MyZiroomFragment.this), CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", MyZiroomFragment.this.ay);
        localIntent.putExtra("type", 0);
        MyZiroomFragment.this.startActivity(localIntent);
        return;
      case 3: 
        localIntent.setClass(MyZiroomFragment.e(MyZiroomFragment.this), CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", MyZiroomFragment.this.ay);
        localIntent.putExtra("type", 0);
        MyZiroomFragment.this.startActivity(localIntent);
        return;
      case 4: 
        localIntent.setClass(MyZiroomFragment.e(MyZiroomFragment.this), CertificationInfoActivity.class);
        localIntent.putExtra("type", 0);
        localIntent.putExtra("phone", MyZiroomFragment.this.ay);
        localIntent.putExtra("cert_info", paramAnonymouse);
        MyZiroomFragment.this.startActivity(localIntent);
        return;
      case 1: 
        if ("1".equals(paramAnonymouse.getCert_type()))
        {
          localIntent.setClass(MyZiroomFragment.e(MyZiroomFragment.this), CertInformationActivity.class);
          localIntent.putExtra("cert_info", paramAnonymouse);
          localIntent.putExtra("type", 0);
          localIntent.putExtra("phone", MyZiroomFragment.this.ay);
          MyZiroomFragment.this.startActivity(localIntent);
          return;
        }
        localIntent.setClass(MyZiroomFragment.e(MyZiroomFragment.this), CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", MyZiroomFragment.this.ay);
        localIntent.putExtra("type", 0);
        MyZiroomFragment.this.startActivity(localIntent);
        return;
      }
      localIntent.setClass(MyZiroomFragment.e(MyZiroomFragment.this), CertInformationActivity.class);
      localIntent.putExtra("cert_info", paramAnonymouse);
      localIntent.putExtra("phone", MyZiroomFragment.this.ay);
      localIntent.putExtra("type", 0);
      MyZiroomFragment.this.startActivity(localIntent);
    }
  };
  private MessageUpdateReceiver bi;
  private b bj;
  MyZiroomCardViewCommunity c;
  PZAcitivitiesItemView d;
  RelativeLayout e;
  ImageView f;
  SimpleDraweeView g;
  TextView h;
  TextView i;
  TextView j;
  LinearLayout k;
  LinearLayout l;
  SimpleDraweeView m;
  ImageView n;
  ImageView o;
  IntellectDeviceView p;
  IntellectDeviceView q;
  IntellectDeviceView r;
  IntellectDeviceView s;
  IntellectDeviceView t;
  LinearLayout u;
  TextView v;
  ImageView w;
  TextView x;
  TextView y;
  TextView z;
  
  private void A()
  {
    getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        MyZiroomFragment.this.u.setVisibility(0);
        MyZiroomFragment.this.E.setVisibility(0);
        MyZiroomFragment.this.B.setVisibility(8);
        if (MyZiroomFragment.o(MyZiroomFragment.this) > 1)
        {
          MyZiroomFragment.this.v.setVisibility(0);
          MyZiroomFragment.this.w.setVisibility(0);
        }
        for (;;)
        {
          String str1 = ((ZiruyiOrderBean.ZiRuYiOrderListBean)MyZiroomFragment.j(MyZiroomFragment.this).getOrderList().get(0)).getProjectName();
          int i = ((ZiruyiOrderBean.ZiRuYiOrderListBean)MyZiroomFragment.j(MyZiroomFragment.this).getOrderList().get(0)).getNights();
          String str2 = ((ZiruyiOrderBean.ZiRuYiOrderListBean)MyZiroomFragment.j(MyZiroomFragment.this).getOrderList().get(0)).getStartDate();
          String str3 = ((ZiruyiOrderBean.ZiRuYiOrderListBean)MyZiroomFragment.j(MyZiroomFragment.this).getOrderList().get(0)).getEndDate();
          String str4 = ((ZiruyiOrderBean.ZiRuYiOrderListBean)MyZiroomFragment.j(MyZiroomFragment.this).getOrderList().get(0)).getAddress();
          MyZiroomFragment.this.x.setText("自如驿·" + str1);
          MyZiroomFragment.this.y.setText("共" + i + "天");
          MyZiroomFragment.this.z.setText(str2 + " 至 " + str3);
          MyZiroomFragment.this.A.setText(str4);
          return;
          MyZiroomFragment.this.v.setVisibility(8);
          MyZiroomFragment.this.w.setVisibility(8);
        }
      }
    });
  }
  
  private void B()
  {
    getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        MyZiroomFragment.this.u.setVisibility(0);
        if (MyZiroomFragment.o(MyZiroomFragment.this) > 1)
        {
          MyZiroomFragment.this.v.setVisibility(0);
          MyZiroomFragment.this.w.setVisibility(0);
          if (((MinsuOrderBean.MinsuOrderListBean)MyZiroomFragment.i(MyZiroomFragment.this).getOrderList().get(0)).getPjStatus() != 1) {
            break label379;
          }
          MyZiroomFragment.this.B.setVisibility(0);
          MyZiroomFragment.this.E.setVisibility(8);
          MyZiroomFragment.this.D.setText(((MinsuOrderBean.MinsuOrderListBean)MyZiroomFragment.i(MyZiroomFragment.this).getOrderList().get(0)).getPjButton());
        }
        for (;;)
        {
          String str1 = ((MinsuOrderBean.MinsuOrderListBean)MyZiroomFragment.i(MyZiroomFragment.this).getOrderList().get(0)).getHouseName();
          int i = ((MinsuOrderBean.MinsuOrderListBean)MyZiroomFragment.i(MyZiroomFragment.this).getOrderList().get(0)).getHousingDay();
          String str2 = ((MinsuOrderBean.MinsuOrderListBean)MyZiroomFragment.i(MyZiroomFragment.this).getOrderList().get(0)).getStartTimeStr();
          String str3 = ((MinsuOrderBean.MinsuOrderListBean)MyZiroomFragment.i(MyZiroomFragment.this).getOrderList().get(0)).getEndTimeStr();
          String str4 = ((MinsuOrderBean.MinsuOrderListBean)MyZiroomFragment.i(MyZiroomFragment.this).getOrderList().get(0)).getHouseAddr();
          MyZiroomFragment.this.x.setText("自如民宿·" + str1);
          MyZiroomFragment.this.y.setText("共" + i + "天");
          MyZiroomFragment.this.z.setText(str2 + " 至 " + str3);
          MyZiroomFragment.this.A.setText(str4);
          return;
          MyZiroomFragment.this.v.setVisibility(8);
          MyZiroomFragment.this.w.setVisibility(8);
          break;
          label379:
          MyZiroomFragment.this.B.setVisibility(8);
          MyZiroomFragment.this.E.setVisibility(0);
        }
      }
    });
  }
  
  private void C()
  {
    com.ziroom.ziroomcustomer.e.j.getCommonJsonGate(this.aZ, q.o + q.ac, new com.ziroom.ziroomcustomer.e.a.e(this.aZ, new com.ziroom.ziroomcustomer.e.c.d())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        MyZiroomFragment.this.d.setVisibility(8);
        MyZiroomFragment.this.aq.setVisibility(8);
        MyZiroomFragment.this.b.setContent(null);
        MyZiroomFragment.this.c.setContent(null);
        MyZiroomFragment.c(MyZiroomFragment.this, 8);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        if (paramAnonymouse != null)
        {
          paramAnonymouse = (MyActivityDataBean)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toJSONString(), MyActivityDataBean.class);
          MyZiroomFragment.a(MyZiroomFragment.this, paramAnonymouse.getUser_tags());
          if ((MyZiroomFragment.p(MyZiroomFragment.this) != null) && ("Y".equals(MyZiroomFragment.p(MyZiroomFragment.this).getSwitch())))
          {
            Object localObject = x.makeUrl(MyZiroomFragment.p(MyZiroomFragment.this).getPhoto());
            MyZiroomFragment.this.m.setController(com.freelxl.baselibrary.f.c.frescoController((String)localObject));
            MyZiroomFragment.this.m.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                JsBridgeWebActivity.start(MyZiroomFragment.6.a(MyZiroomFragment.6.this), MyZiroomFragment.p(MyZiroomFragment.this).getTitle(), MyZiroomFragment.p(MyZiroomFragment.this).getLink());
              }
            });
            MyZiroomFragment.a(MyZiroomFragment.this, paramAnonymouse.getActivity());
            if (MyZiroomFragment.q(MyZiroomFragment.this) == null) {
              break label418;
            }
            if ((MyZiroomFragment.q(MyZiroomFragment.this).content == null) || (MyZiroomFragment.q(MyZiroomFragment.this).content.size() <= 0)) {
              break label388;
            }
            MyZiroomFragment.this.d.initView(this.e, 2130904754);
            localObject = MyZiroomFragment.this.d;
            String str1 = MyZiroomFragment.q(MyZiroomFragment.this).getTitle();
            String str2 = MyZiroomFragment.q(MyZiroomFragment.this).getSubtitle();
            String str3 = MyZiroomFragment.q(MyZiroomFragment.this).button_name;
            View.OnClickListener local2 = new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                paramAnonymous2View = new Intent(MyZiroomFragment.6.b(MyZiroomFragment.6.this), AcMainActivity.class);
                paramAnonymous2View.putExtra("cityCode", com.ziroom.ziroomcustomer.base.b.d);
                MyZiroomFragment.6.c(MyZiroomFragment.6.this).startActivity(paramAnonymous2View);
              }
            };
            Context localContext = this.e;
            if (MyZiroomFragment.q(MyZiroomFragment.this).getContent() != null) {
              break label369;
            }
            paramAnonymousInt = 0;
            label247:
            ((PZAcitivitiesItemView)localObject).setData(str1, str2, str3, local2, new PZAcitivitiesItemView.a(localContext, paramAnonymousInt, 2130904452)
            {
              protected void a(RecyclerView.u paramAnonymous2u, int paramAnonymous2Int)
              {
                paramAnonymous2u = (PZAcitivitiesItemView.a.a)paramAnonymous2u;
                final RecommendActivitiesModel.ContentBean localContentBean = (RecommendActivitiesModel.ContentBean)MyZiroomFragment.q(MyZiroomFragment.this).getContent().get(paramAnonymous2Int);
                String str = x.makeUrl(localContentBean.getImg(), 1.0F);
                paramAnonymous2u.d.setController(com.freelxl.baselibrary.f.c.frescoController(str));
                if (TextUtils.isEmpty(localContentBean.getTitle()))
                {
                  paramAnonymous2u.b.setVisibility(8);
                  paramAnonymous2u.c.setVisibility(8);
                }
                for (;;)
                {
                  paramAnonymous2u.a.setOnClickListener(new View.OnClickListener()
                  {
                    @Instrumented
                    public void onClick(View paramAnonymous3View)
                    {
                      VdsAgent.onClick(this, paramAnonymous3View);
                      if ("1".equals(localContentBean.app)) {
                        return;
                      }
                      MyZiroomFragment.this.toH5Page(localContentBean.getTarget(), localContentBean.getTitle(), localContentBean.getDescription(), localContentBean.getImg());
                    }
                  });
                  return;
                  paramAnonymous2u.b.setText(localContentBean.getTitle());
                  paramAnonymous2u.b.setVisibility(0);
                  if (TextUtils.isEmpty(localContentBean.getDescription()))
                  {
                    paramAnonymous2u.c.setVisibility(8);
                  }
                  else
                  {
                    paramAnonymous2u.c.setText(localContentBean.getDescription());
                    paramAnonymous2u.c.setVisibility(0);
                  }
                }
              }
            });
            MyZiroomFragment.this.d.setVisibility(0);
            label283:
            if (!"1".equals(MyZiroomFragment.q(MyZiroomFragment.this).isOpenActivity)) {
              break label403;
            }
            MyZiroomFragment.this.aq.setVisibility(0);
          }
          for (;;)
          {
            MyZiroomFragment.this.b.setContent(paramAnonymouse.getZ_space());
            MyZiroomFragment.this.c.setContent(paramAnonymouse.getZhaozhao());
            paramAnonymouse = paramAnonymouse.getAd();
            MyZiroomFragment.d(MyZiroomFragment.this, paramAnonymouse);
            return;
            MyZiroomFragment.this.l.setVisibility(8);
            break;
            label369:
            paramAnonymousInt = MyZiroomFragment.q(MyZiroomFragment.this).getContent().size();
            break label247;
            label388:
            MyZiroomFragment.this.d.setVisibility(8);
            break label283;
            label403:
            MyZiroomFragment.this.aq.setVisibility(8);
            continue;
            label418:
            MyZiroomFragment.this.d.setVisibility(8);
            MyZiroomFragment.this.aq.setVisibility(8);
          }
        }
        MyZiroomFragment.this.b.setContent(null);
        MyZiroomFragment.this.c.setContent(null);
        MyZiroomFragment.this.d.setVisibility(8);
        MyZiroomFragment.this.aq.setVisibility(8);
        MyZiroomFragment.c(MyZiroomFragment.this, 8);
      }
    });
  }
  
  private void D()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getCms(getActivity(), "3055", new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        Log.e("MyZiRoomPageActivity", "onParse: " + paramAnonymousString);
      }
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        Log.e("MyZiRoomPageActivity", "onSuccess: " + paramAnonymousk.getObject());
        MyZiroomFragment.a(MyZiroomFragment.this, (MinsuCmsBean)paramAnonymousk.getObject());
        MyZiroomFragment.r(MyZiroomFragment.this);
      }
    });
  }
  
  private void E()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.commonlibrary.login.a.getUid(this.aZ));
    com.ziroom.ziroomcustomer.e.g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.get(q.s + e.h.G).tag(this).params(localHashMap).enqueue(new com.ziroom.ziroomcustomer.findhouse.b.b(this.aZ, new com.ziroom.ziroomcustomer.findhouse.b.e(ReserveV2Bean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MyZiroomFragment.this.F.setVisibility(8);
      }
      
      public void onSuccess(int paramAnonymousInt, ReserveV2Bean paramAnonymousReserveV2Bean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousReserveV2Bean);
        if (paramAnonymousReserveV2Bean == null)
        {
          MyZiroomFragment.this.F.setVisibility(8);
          return;
        }
        MyZiroomFragment.this.F.setReserveBean(paramAnonymousReserveV2Bean);
      }
    });
  }
  
  private void F()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", com.ziroom.commonlibrary.login.a.getUid(this.aZ));
    com.ziroom.ziroomcustomer.e.g.appendCommenParamsString(localHashMap);
    com.freelxl.baselibrary.d.a.get(q.s + e.h.H).tag(this).params(localHashMap).enqueue(new com.ziroom.ziroomcustomer.findhouse.b.b(this.aZ, new com.ziroom.ziroomcustomer.findhouse.b.e(MyZiroomContract.class))
    {
      public void onSuccess(int paramAnonymousInt, MyZiroomContract paramAnonymousMyZiroomContract)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMyZiroomContract);
        if (paramAnonymousMyZiroomContract == null)
        {
          MyZiroomFragment.this.H.setVisibility(8);
          return;
        }
        MyZiroomFragment.this.H.setContract(paramAnonymousMyZiroomContract);
      }
    });
  }
  
  private void G()
  {
    com.ziroom.ziroomcustomer.e.j.zryuContractCard(this.aZ, new com.ziroom.ziroomcustomer.e.a.b(this.aZ, new com.ziroom.ziroomcustomer.e.c.f(ZryuContractItem.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MyZiroomFragment.this.ah.setVisibility(8);
      }
      
      public void onSuccess(int paramAnonymousInt, final ZryuContractItem paramAnonymousZryuContractItem)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousZryuContractItem);
        if (paramAnonymousZryuContractItem != null)
        {
          Object localObject2;
          if ((paramAnonymousZryuContractItem.getHasMore() != null) && (paramAnonymousZryuContractItem.getHasMore().intValue() == 1))
          {
            MyZiroomFragment.this.ak.setVisibility(0);
            Object localObject1 = new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                MyZiroomFragment.a(MyZiroomFragment.this, LeaseActivity.class);
              }
            };
            MyZiroomFragment.this.ak.setOnClickListener((View.OnClickListener)localObject1);
            MyZiroomFragment.this.ai.setOnClickListener((View.OnClickListener)localObject1);
            MyZiroomFragment.this.aj.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                com.ziroom.ziroomcustomer.ziroomapartment.b.toContractInfo(MyZiroomFragment.10.a(MyZiroomFragment.10.this), paramAnonymousZryuContractItem.getContractId(), "XQ");
              }
            });
            MyZiroomFragment.this.ah.setVisibility(0);
            MyZiroomFragment.this.al.setText(paramAnonymousZryuContractItem.getRentTitle());
            MyZiroomFragment.this.am.setText(paramAnonymousZryuContractItem.getRentTime());
            localObject1 = paramAnonymousZryuContractItem.getExpireDate();
            localObject2 = paramAnonymousZryuContractItem.getExpireDateInfo();
            paramAnonymousInt = ((String)localObject2).indexOf("{1}");
            if (paramAnonymousInt < 0) {
              break label295;
            }
            localObject2 = new SpannableString(((String)localObject2).replace("{1}", (CharSequence)localObject1));
            ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(MyZiroomFragment.this.getResources().getColor(2131624516)), paramAnonymousInt, ((String)localObject1).length() + paramAnonymousInt, 34);
            MyZiroomFragment.this.an.setText((CharSequence)localObject2);
            label213:
            if (!TextUtils.isEmpty(paramAnonymousZryuContractItem.getWarnInfo())) {
              break label310;
            }
            MyZiroomFragment.this.ao.setVisibility(8);
          }
          for (;;)
          {
            MyZiroomFragment.this.ap.setText(paramAnonymousZryuContractItem.getOperation());
            MyZiroomFragment.this.ap.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                MyZiroomFragment.a(MyZiroomFragment.this, paramAnonymousZryuContractItem);
              }
            });
            return;
            MyZiroomFragment.this.ak.setVisibility(8);
            MyZiroomFragment.this.ai.setOnClickListener(null);
            break;
            label295:
            MyZiroomFragment.this.an.setText((CharSequence)localObject2);
            break label213;
            label310:
            MyZiroomFragment.this.ao.setVisibility(0);
            MyZiroomFragment.this.ao.setText(paramAnonymousZryuContractItem.getWarnInfo());
          }
        }
        MyZiroomFragment.this.ah.setVisibility(8);
      }
    });
  }
  
  private void H()
  {
    if ((this.aP != null) && (!s.isEmpty(this.aP.data)))
    {
      this.X.setVisibility(0);
      Object localObject = new LinearLayoutManager(this.aZ);
      ((LinearLayoutManager)localObject).setOrientation(0);
      this.W.setLayoutManager((RecyclerView.h)localObject);
      localObject = new RecommendHouseAdapter();
      ((RecommendHouseAdapter)localObject).setData(this.aP);
      this.W.setAdapter((RecyclerView.a)localObject);
      return;
    }
    this.X.setVisibility(8);
  }
  
  private void I()
  {
    this.aK = ApplicationEx.c.isLoginState();
    if (this.aN)
    {
      u.i("MyZiRoomPageActivity", "toMessCenter;" + getActivity().getIntent().getBooleanExtra("push_channel_key", false));
      J();
    }
  }
  
  private void J()
  {
    if (!this.aK)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.aZ);
      return;
    }
    this.aG = 0;
    this.aH = 0;
    this.aI = 0;
    this.aJ = 0;
    onScroll(0, this.Y.getScrollY());
    this.aO = true;
    startActivity(new Intent(this.aZ, MessageCenterActivity.class));
    w.onEvent("personalcenter_customer");
  }
  
  private void K()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getCms(getActivity(), "3056", new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        Log.e("MyZiRoomPageActivity", "onParse: " + paramAnonymousString);
      }
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        Log.e("MyZiRoomPageActivity", "onSuccess: " + paramAnonymousk.getObject());
        MyZiroomFragment.b(MyZiroomFragment.this, (MinsuCmsBean)paramAnonymousk.getObject());
        if ((MyZiroomFragment.w(MyZiroomFragment.this) != null) && (!s.isEmpty(MyZiroomFragment.w(MyZiroomFragment.this).data)))
        {
          paramAnonymousk = (MinsuCmsBean.DataBean)MyZiroomFragment.w(MyZiroomFragment.this).data.get(0);
          if ((paramAnonymousk != null) && (!TextUtils.isEmpty(paramAnonymousk.url)))
          {
            if (!paramAnonymousk.url.contains("?")) {
              break label142;
            }
            paramAnonymousk.url += "&os=android";
          }
        }
        return;
        label142:
        paramAnonymousk.url += "?&os=android";
      }
    });
  }
  
  private void L()
  {
    this.bi = new MessageUpdateReceiver();
    IntentFilter localIntentFilter = new IntentFilter(getString(2131296572));
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.bi, localIntentFilter);
    localIntentFilter = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.az, localIntentFilter);
    this.bj = new b(this);
  }
  
  private void M()
  {
    int i1;
    int i2;
    if ((this.ac != null) && (this.ad != null))
    {
      i1 = MessageUtil.getCustomServiceMsgNum() + MessageUtil.getMinsuCustomServiceMsgNum() + MessageUtil.getMinsuImMsgNum() + MessageUtil.getsMeetaMsgNum();
      i2 = MessageUtil.getSystemMsgNum();
      u.i("huanxin", " 自如客服 = " + MessageUtil.getCustomServiceMsgNum() + " 民宿客服 = " + MessageUtil.getMinsuCustomServiceMsgNum() + " 民宿  im = " + MessageUtil.getMinsuImMsgNum() + " 三个之和 = " + i1 + " 系统消息 = " + MessageUtil.getSystemMsgNum());
      if ((i1 > 0) && (i1 <= 99))
      {
        this.ad.setVisibility(0);
        this.ac.setVisibility(8);
        this.ad.setText(i1 + "");
      }
    }
    else
    {
      return;
    }
    if (i1 > 99)
    {
      this.ad.setVisibility(0);
      this.ac.setVisibility(8);
      this.ad.setText("99+");
      return;
    }
    if (i2 > 0)
    {
      this.ad.setVisibility(8);
      this.ac.setVisibility(0);
      this.ad.setText("99+");
      return;
    }
    this.ad.setVisibility(8);
    this.ac.setVisibility(8);
  }
  
  private void N()
  {
    this.ad.setText("");
    this.ad.setVisibility(8);
    this.ac.setVisibility(8);
  }
  
  private void a(int paramInt)
  {
    IntellectHomeView[] arrayOfIntellectHomeView = new IntellectHomeView[9];
    arrayOfIntellectHomeView[0] = this.J;
    arrayOfIntellectHomeView[1] = this.K;
    arrayOfIntellectHomeView[2] = this.N;
    arrayOfIntellectHomeView[3] = this.O;
    arrayOfIntellectHomeView[4] = this.P;
    arrayOfIntellectHomeView[5] = this.R;
    arrayOfIntellectHomeView[6] = this.L;
    arrayOfIntellectHomeView[7] = this.M;
    arrayOfIntellectHomeView[8] = this.Q;
    int i2 = arrayOfIntellectHomeView.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfIntellectHomeView[i1].setVisibility(8);
      i1 += 1;
    }
    arrayOfIntellectHomeView = new IntellectHomeView[8];
    arrayOfIntellectHomeView[0] = this.J;
    arrayOfIntellectHomeView[1] = this.K;
    arrayOfIntellectHomeView[2] = this.N;
    arrayOfIntellectHomeView[3] = this.O;
    arrayOfIntellectHomeView[4] = this.R;
    arrayOfIntellectHomeView[5] = this.L;
    arrayOfIntellectHomeView[6] = this.M;
    arrayOfIntellectHomeView[7] = this.Q;
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramInt = 0;
      while (paramInt < arrayOfIntellectHomeView.length)
      {
        arrayOfIntellectHomeView[paramInt].setVisibility(0);
        paramInt += 1;
      }
      arrayOfIntellectHomeView = new IntellectHomeView[6];
      arrayOfIntellectHomeView[0] = this.J;
      arrayOfIntellectHomeView[1] = this.N;
      arrayOfIntellectHomeView[2] = this.O;
      arrayOfIntellectHomeView[3] = this.P;
      arrayOfIntellectHomeView[4] = this.L;
      arrayOfIntellectHomeView[5] = this.M;
      continue;
      arrayOfIntellectHomeView = new IntellectHomeView[7];
      arrayOfIntellectHomeView[0] = this.J;
      arrayOfIntellectHomeView[1] = this.K;
      arrayOfIntellectHomeView[2] = this.N;
      arrayOfIntellectHomeView[3] = this.R;
      arrayOfIntellectHomeView[4] = this.L;
      arrayOfIntellectHomeView[5] = this.M;
      arrayOfIntellectHomeView[6] = this.Q;
      continue;
      arrayOfIntellectHomeView = new IntellectHomeView[9];
      arrayOfIntellectHomeView[0] = this.J;
      arrayOfIntellectHomeView[1] = this.K;
      arrayOfIntellectHomeView[2] = this.N;
      arrayOfIntellectHomeView[3] = this.O;
      arrayOfIntellectHomeView[4] = this.P;
      arrayOfIntellectHomeView[5] = this.R;
      arrayOfIntellectHomeView[6] = this.L;
      arrayOfIntellectHomeView[7] = this.M;
      arrayOfIntellectHomeView[8] = this.Q;
    }
  }
  
  private void a(final ZryuContractItem paramZryuContractItem)
  {
    if ((paramZryuContractItem != null) && (paramZryuContractItem.getOperationCode() != null))
    {
      if (paramZryuContractItem.getOperationCode().intValue() != 0) {
        break label37;
      }
      com.ziroom.ziroomcustomer.ziroomapartment.b.toSign(this.aZ, paramZryuContractItem.getContractId(), paramZryuContractItem.getHandleZOPhone());
    }
    label37:
    do
    {
      return;
      if (paramZryuContractItem.getOperationCode().intValue() == 1)
      {
        com.ziroom.ziroomcustomer.ziroomapartment.b.toBillsInfo(this.aZ, paramZryuContractItem.getContractId(), paramZryuContractItem.getContractCode(), "1007", "1");
        return;
      }
      if (paramZryuContractItem.getOperationCode().intValue() == 2)
      {
        com.ziroom.ziroomcustomer.ziroomapartment.b.toDelivery(this.aZ, paramZryuContractItem.getContractId());
        return;
      }
      if (paramZryuContractItem.getOperationCode().intValue() == 3)
      {
        if (TextUtils.isEmpty(paramZryuContractItem.getRenewContractId()))
        {
          com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.aZ).setContent("管家还未发起续约通知，请及时联系管家！").setTitle("提示").setBtnCancelText("取消").setBtnConfirmText("联系管家").setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
            {
              if (paramAnonymousBoolean) {
                ah.callPhone(MyZiroomFragment.e(MyZiroomFragment.this), paramZryuContractItem.getHandleZOPhone());
              }
            }
          }).build().show();
          return;
        }
        com.ziroom.ziroomcustomer.ziroomapartment.b.toContractInfo(this.aZ, paramZryuContractItem.getRenewContractId(), "XQ");
        return;
      }
      if (paramZryuContractItem.getOperationCode().intValue() == 5)
      {
        com.ziroom.ziroomcustomer.ziroomapartment.b.toBillsList(this.aZ, paramZryuContractItem.getContractId(), 1, 1);
        return;
      }
    } while (paramZryuContractItem.getOperationCode().intValue() != 6);
    com.ziroom.ziroomcustomer.ziroomapartment.b.toBillsList(this.aZ, paramZryuContractItem.getContractId(), 2, 1);
  }
  
  private void a(Class paramClass)
  {
    if (this.aK)
    {
      startActivity(new Intent(getActivity(), paramClass));
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(getActivity());
  }
  
  private void a(final List<AdModel> paramList)
  {
    if ((this.aA != null) && (paramList != null) && (paramList.size() > 0))
    {
      b(0);
      ArrayList localArrayList = new ArrayList();
      int i1 = 0;
      while (i1 < paramList.size())
      {
        localArrayList.add(((AdModel)paramList.get(i1)).getPhoto());
        i1 += 1;
      }
      this.aA.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
      {
        public MyZiroomFragment.a createHolder()
        {
          return new MyZiroomFragment.a(MyZiroomFragment.this, null);
        }
      }, localArrayList, null).setPageIndicator(new int[] { 2130839319, 2130839311 }).setPageIndicatorAlign(ConvenientBanner.c.c).setCoverBottomViewVisible(true).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
      {
        public void onItemClick(int paramAnonymousInt)
        {
          JSONObject localJSONObject = new JSONObject();
          AdModel localAdModel = (AdModel)paramList.get(paramAnonymousInt);
          if ((localAdModel != null) && (!TextUtils.isEmpty(localAdModel.getLink()))) {}
          try
          {
            localJSONObject.put("position", paramAnonymousInt);
            localJSONObject.put("title", localAdModel.getTitle());
            localJSONObject.put("link", localAdModel.getLink());
            JsBridgeWebActivity.start(MyZiroomFragment.e(MyZiroomFragment.this), localAdModel.getTitle(), localAdModel.getLink());
            GrowingIO.getInstance().track("grzx_banner", localJSONObject);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }).setPointViewVisible(true);
      this.aA.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
        }
      });
      this.aA.startTurning(5000L);
      return;
    }
    b(8);
  }
  
  private void b(int paramInt)
  {
    if (isAdded())
    {
      this.aA.setVisibility(paramInt);
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        return;
      } while ((this.aB == null) || (this.aB.getVisibility() != 0));
      paramInt = (int)(92.0F * getResources().getDisplayMetrics().density);
      ((LinearLayout.LayoutParams)this.aB.getLayoutParams()).height = paramInt;
      return;
    } while ((this.aB == null) || (this.aB.getVisibility() != 0));
    paramInt = (int)(178.0F * getResources().getDisplayMetrics().density);
    ((LinearLayout.LayoutParams)this.aB.getLayoutParams()).height = paramInt;
  }
  
  private void b(String paramString)
  {
    GenericDraweeHierarchy localGenericDraweeHierarchy = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).setPlaceholderImage(2130840439).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFailureImage(2130840439).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build();
    RoundingParams localRoundingParams = new RoundingParams();
    localRoundingParams.setRoundAsCircle(true);
    localGenericDraweeHierarchy.setRoundingParams(localRoundingParams);
    this.g.setHierarchy(localGenericDraweeHierarchy);
    this.g.setController(com.freelxl.baselibrary.f.c.frescoController(paramString));
  }
  
  private void c(String paramString)
  {
    com.ziroom.ziroomcustomer.e.j.getCertInfo(this.aZ, com.ziroom.commonlibrary.login.a.getToken(this.aZ), 1, this.bh);
  }
  
  private void d(String paramString)
  {
    if (this.aK) {
      w.onEvent(paramString);
    }
  }
  
  private void e()
  {
    K();
    this.aN = getActivity().getIntent().getBooleanExtra("push_channel_key", false);
    this.aO = false;
    I();
    this.aK = ApplicationEx.c.isLoginState();
    m();
  }
  
  private void f()
  {
    if (this.aK)
    {
      E();
      F();
      G();
      return;
    }
    this.F.setVisibility(8);
    this.H.setVisibility(8);
    this.ah.setVisibility(8);
  }
  
  private void g()
  {
    this.Y.setOnScrollChangedCallback(this);
    registerMessageReceiver();
  }
  
  private void h()
  {
    if (com.ziroom.ziroomcustomer.util.c.g.checkSkin())
    {
      j();
      return;
    }
    k();
  }
  
  private void i()
  {
    Object localObject = com.ziroom.ziroomcustomer.util.c.g.getMyZiroom();
    String str2;
    String str1;
    if (this.ba != 1)
    {
      str2 = ((com.ziroom.ziroomcustomer.util.c.f)localObject).getImages().getImage_navi_message_slide();
      str1 = ((com.ziroom.ziroomcustomer.util.c.f)localObject).getImages().getImage_navi_switchoverLandlord_slide();
      localObject = ((com.ziroom.ziroomcustomer.util.c.f)localObject).getColors().getColor_navi_switchoverLandlord_slide();
    }
    for (;;)
    {
      if (ae.notNull((String)localObject)) {}
      try
      {
        this.af.setTextColor(Color.parseColor((String)localObject));
        com.ziroom.ziroomcustomer.util.c.g.setImage(this.f, str1);
        com.ziroom.ziroomcustomer.util.c.g.setImage(this.ab, str2);
        return;
        str2 = ((com.ziroom.ziroomcustomer.util.c.f)localObject).getImages().getImage_navi_message_normal();
        str1 = ((com.ziroom.ziroomcustomer.util.c.f)localObject).getImages().getImage_navi_switchoverLandlord_normal();
        localObject = ((com.ziroom.ziroomcustomer.util.c.f)localObject).getColors().getColor_navi_switchoverLandlord_normal();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.getLocalizedMessage();
        }
      }
    }
  }
  
  public static boolean isFastClick()
  {
    boolean bool = false;
    long l1 = System.currentTimeMillis();
    if (l1 - bf >= 1000L) {
      bool = true;
    }
    bf = l1;
    return bool;
  }
  
  private void j()
  {
    com.ziroom.ziroomcustomer.util.c.f localf = com.ziroom.ziroomcustomer.util.c.g.getMyZiroom();
    if ((localf == null) || ((localf.getColors() == null) || (ae.notNull(localf.getColors().getColor_navi_title())))) {}
    try
    {
      this.aa.setTextColor(Color.parseColor(localf.getColors().getColor_navi_title()));
      if (!ae.notNull(localf.getColors().getColor_login_text())) {}
    }
    catch (Exception localException4)
    {
      try
      {
        this.j.setTextColor(Color.parseColor(localf.getColors().getColor_login_text()));
        if (!ae.notNull(localf.getColors().getColor_selfCredit_text())) {}
      }
      catch (Exception localException4)
      {
        try
        {
          this.i.setTextColor(Color.parseColor(localf.getColors().getColor_selfCredit_text()));
          if (!ae.notNull(localf.getColors().getColor_buttons())) {}
        }
        catch (Exception localException4)
        {
          try
          {
            this.p.getTv().setTextColor(Color.parseColor(localf.getColors().getColor_buttons()));
            this.q.getTv().setTextColor(Color.parseColor(localf.getColors().getColor_buttons()));
            this.r.getTv().setTextColor(Color.parseColor(localf.getColors().getColor_buttons()));
            this.s.getTv().setTextColor(Color.parseColor(localf.getColors().getColor_buttons()));
            this.t.getTv().setTextColor(Color.parseColor(localf.getColors().getColor_buttons()));
            if (!ae.notNull(localf.getColors().getColor_navi_title())) {}
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                this.Z.setBackgroundColor(Color.parseColor(localf.getColors().getColor_navi_background()));
                if (localf.getValues() != null)
                {
                  if (ae.notNull(localf.getValues().getValue_collection())) {
                    this.p.getTv().setText(localf.getValues().getValue_collection());
                  }
                  if (ae.notNull(localf.getValues().getValue_appointment())) {
                    this.q.getTv().setText(localf.getValues().getValue_appointment());
                  }
                  if (ae.notNull(localf.getValues().getValue_order())) {
                    this.r.getTv().setText(localf.getValues().getValue_order());
                  }
                  if (ae.notNull(localf.getValues().getValue_evaluation())) {
                    this.s.getTv().setText(localf.getValues().getValue_evaluation());
                  }
                  if (ae.notNull(localf.getValues().getValue_balance())) {
                    this.t.getTv().setText(localf.getValues().getValue_balance());
                  }
                }
                com.ziroom.ziroomcustomer.util.c.g.setBackground(this.e, localf.getImages().getImage_header_background());
                com.ziroom.ziroomcustomer.util.c.g.setBackground(this.ag, localf.getImages().getImage_buttons_background());
                com.ziroom.ziroomcustomer.util.c.g.setImage(this.aq, localf.getImages().getImage_myActivities());
                com.ziroom.ziroomcustomer.util.c.g.setImage(this.n, localf.getImages().getImage_selfCreditIcon());
                com.ziroom.ziroomcustomer.util.c.g.setImage(this.o, localf.getImages().getImage_selfCreditArrow());
                com.ziroom.ziroomcustomer.util.c.g.setImage(this.p.getIv(), localf.getImages().getImage_collection());
                com.ziroom.ziroomcustomer.util.c.g.setImage(this.q.getIv(), localf.getImages().getImage_appointment());
                com.ziroom.ziroomcustomer.util.c.g.setImage(this.r.getIv(), localf.getImages().getImage_order());
                com.ziroom.ziroomcustomer.util.c.g.setImage(this.s.getIv(), localf.getImages().getImage_evaluation());
                com.ziroom.ziroomcustomer.util.c.g.setImage(this.t.getIv(), localf.getImages().getImage_balance());
                if (!this.aK) {
                  com.ziroom.ziroomcustomer.util.c.g.setFresco(this.g, localf.getImages().getImage_userPortrait());
                }
                i();
                return;
                localException1 = localException1;
                localException1.getLocalizedMessage();
                continue;
                localException2 = localException2;
                localException2.getLocalizedMessage();
                continue;
                localException3 = localException3;
                localException3.getLocalizedMessage();
              }
              localException4 = localException4;
              localException4.getLocalizedMessage();
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                localException5.getLocalizedMessage();
              }
            }
          }
        }
      }
    }
  }
  
  private void k()
  {
    this.aa.setTextColor(Color.parseColor("#444444"));
    this.Z.setBackgroundColor(Color.parseColor("#ffffff"));
    this.af.setTextColor(Color.parseColor("#444444"));
    this.j.setTextColor(Color.parseColor("#666666"));
    this.i.setTextColor(Color.parseColor("#999999"));
    this.p.getTv().setTextColor(Color.parseColor("#444444"));
    this.q.getTv().setTextColor(Color.parseColor("#444444"));
    this.r.getTv().setTextColor(Color.parseColor("#444444"));
    this.s.getTv().setTextColor(Color.parseColor("#444444"));
    this.t.getTv().setTextColor(Color.parseColor("#444444"));
    this.e.setBackgroundColor(Color.parseColor("#f9f9f9"));
    this.ag.setBackgroundColor(Color.parseColor("#ffffff"));
    this.ab.setImageResource(2130840275);
    this.aq.setImageResource(2130840127);
    this.n.setImageResource(2130840206);
    this.o.setImageResource(2130839164);
    this.f.setImageResource(2130840472);
    this.p.getIv().setImageResource(2130840315);
    this.q.getIv().setImageResource(2130840314);
    this.r.getIv().setImageResource(2130840319);
    this.s.getIv().setImageResource(2130840317);
    this.t.getIv().setImageResource(2130840320);
    if (!this.aK) {
      this.g.setController(com.freelxl.baselibrary.f.c.frescoFromResourceController(2130840439));
    }
    this.p.getTv().setText("收藏");
    this.q.getTv().setText("约看");
    this.r.getTv().setText("订单");
    this.s.getTv().setText("评价");
    this.t.getTv().setText("钱包");
  }
  
  private boolean l()
  {
    this.aK = ApplicationEx.c.isLoginState();
    if (this.aK)
    {
      this.j.setVisibility(8);
      this.k.setVisibility(0);
      this.h.setVisibility(0);
      this.aD = ApplicationEx.c.getUser();
      if (this.aD != null)
      {
        if (TextUtils.isEmpty(this.aD.getNick_name())) {
          break label102;
        }
        this.h.setText(this.aD.getNick_name());
        b(this.aD.getHead_img());
      }
    }
    for (;;)
    {
      return this.aK;
      label102:
      if (!TextUtils.isEmpty(this.aD.getLogin_name_mobile()))
      {
        this.h.setText(this.aD.getLogin_name_mobile());
        break;
      }
      if (!TextUtils.isEmpty(this.aD.getLogin_name_email()))
      {
        this.h.setText(this.aD.getLogin_name_email());
        break;
      }
      this.h.setText(getString(2131297329));
      break;
      this.j.setVisibility(0);
      this.k.setVisibility(8);
      this.h.setVisibility(8);
      this.h.setText("");
      h();
    }
  }
  
  private void m()
  {
    if (this.aK) {
      com.ziroom.datacenter.remote.e.c.getUserBaseInfo((Activity)this.aZ, new com.ziroom.datacenter.remote.b.a()
      {
        public void onFailure(Throwable paramAnonymousThrowable) {}
        
        public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
        {
          return false;
        }
        
        public void onStart() {}
        
        public void onSuccess(int paramAnonymousInt, m paramAnonymousm)
        {
          if (paramAnonymousm.getUserType() == 2)
          {
            MyZiroomFragment.this.i.setText("企业用户");
            return;
          }
          if (paramAnonymousm.getUserType() == 1)
          {
            if (paramAnonymousm.getZiroomScore() <= 0)
            {
              MyZiroomFragment.this.i.setText("信用认证");
              return;
            }
            MyZiroomFragment.this.i.setText("信用认证" + paramAnonymousm.getZiroomScore());
            return;
          }
          if (paramAnonymousm.getZiroomScore() <= 0)
          {
            MyZiroomFragment.this.i.setText("信用认证");
            return;
          }
          MyZiroomFragment.this.i.setText("信用认证" + paramAnonymousm.getZiroomScore());
        }
      });
    }
    for (;;)
    {
      this.k.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MyZiroomFragment.c(MyZiroomFragment.this);
        }
      });
      return;
      this.i.setText("信用认证");
    }
  }
  
  private void n()
  {
    if (ApplicationEx.c.isLoginState())
    {
      Intent localIntent = new Intent(this.aZ, AcEnrollListActivityNew.class);
      this.aZ.startActivity(localIntent);
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this.aZ);
  }
  
  private void o()
  {
    if (!this.aK)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(getActivity());
      return;
    }
    com.freelxl.baselibrary.d.a.isLog(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(this.aZ));
    com.freelxl.baselibrary.d.a.get(q.R + e.p.a).tag(this).params(com.ziroom.ziroomcustomer.e.g.getCommonHouseSign(localHashMap)).enqueue(new com.ziroom.ziroomcustomer.e.a.f(this.aZ, new com.ziroom.ziroomcustomer.e.c.n())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        com.freelxl.baselibrary.f.d.d("OKHttp", "===" + paramAnonymousb.toString());
        MyZiroomFragment.a(MyZiroomFragment.this, com.alibaba.fastjson.a.parseArray(paramAnonymousb.toString(), MyStewardListEntity.class));
        if (MyZiroomFragment.d(MyZiroomFragment.this) != null)
        {
          if (MyZiroomFragment.d(MyZiroomFragment.this).size() == 1)
          {
            paramAnonymousb = new Intent(MyZiroomFragment.e(MyZiroomFragment.this), MyStewardInfoActivity.class);
            paramAnonymousb.putExtra("contractCode", ((MyStewardListEntity)MyZiroomFragment.d(MyZiroomFragment.this).get(0)).getContractCode() + "");
            MyZiroomFragment.this.startActivity(paramAnonymousb);
            return;
          }
          Intent localIntent = new Intent(MyZiroomFragment.e(MyZiroomFragment.this), MyStewardListActivity.class);
          localIntent.putExtra("stewardList", paramAnonymousb.toString());
          MyZiroomFragment.this.startActivity(localIntent);
          return;
        }
        MyZiroomFragment.this.showToast("");
      }
    });
  }
  
  private void p()
  {
    com.ziroom.ziroomcustomer.minsu.f.k.toCustomerEvaCommitActivity(getActivity(), ((MinsuOrderBean.MinsuOrderListBean)this.aU.get(0)).getOrderSn(), 1);
  }
  
  private void q()
  {
    if ((this.aU != null) && (this.aU.size() > 0)) {
      r();
    }
    String str;
    do
    {
      do
      {
        return;
      } while ((this.aV == null) || (this.aV.size() <= 0) || (((ZiruyiOrderBean.ZiRuYiOrderListBean)this.aV.get(0)).getOrderProjectType() != 2));
      str = ((ZiruyiOrderBean.ZiRuYiOrderListBean)this.aV.get(0)).getSellPhone();
    } while (str == null);
    com.ziroom.ziroomcustomer.minsu.f.k.callPhone(this.aZ, str);
  }
  
  private void r()
  {
    final Object localObject = new ArrayList();
    ((List)localObject).add(getString(2131296612));
    ((List)localObject).add(getString(2131296632));
    this.aw = new i(getActivity(), new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (String)localObject.get(paramAnonymousInt);
        if (MyZiroomFragment.this.getString(2131296612).equals(paramAnonymousAdapterView)) {
          if (ae.notNull(((MinsuOrderBean.MinsuOrderListBean)MyZiroomFragment.f(MyZiroomFragment.this).get(0)).getLandlordMobile())) {
            com.ziroom.ziroomcustomer.minsu.f.k.callPhone(MyZiroomFragment.e(MyZiroomFragment.this), ((MinsuOrderBean.MinsuOrderListBean)MyZiroomFragment.f(MyZiroomFragment.this).get(0)).getLandlordMobile());
          }
        }
        for (;;)
        {
          MyZiroomFragment.this.aw.dismiss();
          return;
          MyZiroomFragment.g(MyZiroomFragment.this);
        }
      }
    }, (List)localObject);
    localObject = this.aw;
    View localView = getActivity().getWindow().getDecorView();
    if (!(localObject instanceof PopupWindow))
    {
      ((i)localObject).showAtLocation(localView, 80, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)localObject, localView, 80, 0, 0);
  }
  
  private void s()
  {
    String str1 = ((MinsuOrderBean.MinsuOrderListBean)this.aU.get(0)).getLandlordUid();
    int i1 = ((MinsuOrderBean.MinsuOrderListBean)this.aU.get(0)).getRentWay().intValue();
    String str2 = ((MinsuOrderBean.MinsuOrderListBean)this.aU.get(0)).getFid();
    com.ziroom.ziroomcustomer.minsu.f.k.toImPage(getActivity(), str1, str2, i1, 2, MinsuMyActivity.class.getSimpleName());
  }
  
  public static Map<String, String> signMethod(Map paramMap)
  {
    com.ziroom.ziroomcustomer.minsu.e.d.setCommonParameter(paramMap);
    String str = com.freelxl.baselibrary.f.a.c.createEncryption("DES").encrypt(com.alibaba.fastjson.a.toJSONString(paramMap), SignKeyUtil.getIvKeyFromC(), SignKeyUtil.getKeyFromC());
    paramMap = com.freelxl.baselibrary.f.h.toMd5(com.alibaba.fastjson.a.toJSONString(paramMap).getBytes());
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", str);
    localHashMap.put("hPtJ39Xs", paramMap);
    return localHashMap;
  }
  
  private void t()
  {
    startActivity(new Intent(getActivity(), MyTravelMoreActivity.class));
  }
  
  private void u()
  {
    if (!this.aK)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(getActivity());
      return;
    }
    startActivity(new Intent(getActivity(), SuggAndComActivity.class));
    com.ziroom.ziroomcustomer.e.o.getChatNums(this.aZ, this.ax, "001");
  }
  
  private void v()
  {
    if (isFastClick())
    {
      if (ApplicationEx.c.isLoginState()) {
        Routers.open(this.aZ, "ziroomCustomer://zrCreditModule/home");
      }
    }
    else {
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this.aZ);
  }
  
  private void w()
  {
    if (this.aK)
    {
      com.ziroom.ziroomcustomer.e.j.getMyUserType(this.aZ, this.bg);
      return;
    }
    a(0);
  }
  
  private void x()
  {
    y();
  }
  
  private void y()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("page", Integer.valueOf(1));
    ((Map)localObject).put("limit", Integer.valueOf(1));
    ((Map)localObject).put("tenantOrderStatus", "");
    localObject = signMethod((Map)localObject);
    com.ziroom.ziroomcustomer.minsu.e.d.requestNoDES(getActivity(), com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/unCheckinMsYzOrderList", (Map)localObject, true, new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        MyZiroomFragment.this.showToast(paramAnonymousIOException.getMessage());
      }
      
      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
        try
        {
          com.freelxl.baselibrary.f.d.e("noob", paramAnonymousResponse.toString());
          MyZiroomFragment.a(MyZiroomFragment.this, (MyTravelMinsuAndZiRuYiOrderMo)new r(MyTravelMinsuAndZiRuYiOrderMo.class).parseResponse(paramAnonymousResponse));
          if (MyZiroomFragment.h(MyZiroomFragment.this) == null) {
            break label344;
          }
          MyZiroomFragment.a(MyZiroomFragment.this, MyZiroomFragment.h(MyZiroomFragment.this).getData().getMinsuOrder());
          if (MyZiroomFragment.i(MyZiroomFragment.this) != null)
          {
            MyZiroomFragment.b(MyZiroomFragment.this, MyZiroomFragment.i(MyZiroomFragment.this).getTotal());
            MyZiroomFragment.b(MyZiroomFragment.this, MyZiroomFragment.i(MyZiroomFragment.this).getOrderList());
          }
          MyZiroomFragment.a(MyZiroomFragment.this, MyZiroomFragment.h(MyZiroomFragment.this).getData().getZiruyiOrder());
          if (MyZiroomFragment.j(MyZiroomFragment.this) != null)
          {
            MyZiroomFragment.b(MyZiroomFragment.this, MyZiroomFragment.j(MyZiroomFragment.this).getTotal());
            MyZiroomFragment.c(MyZiroomFragment.this, MyZiroomFragment.j(MyZiroomFragment.this).getOrderList());
          }
          if ((MyZiroomFragment.i(MyZiroomFragment.this) != null) && (MyZiroomFragment.j(MyZiroomFragment.this) != null)) {
            MyZiroomFragment.b(MyZiroomFragment.this, MyZiroomFragment.i(MyZiroomFragment.this).getTotal() + MyZiroomFragment.j(MyZiroomFragment.this).getTotal());
          }
          if ((MyZiroomFragment.f(MyZiroomFragment.this) == null) && (MyZiroomFragment.k(MyZiroomFragment.this) == null)) {
            break label336;
          }
          if ((MyZiroomFragment.f(MyZiroomFragment.this).size() > 0) && (!MyZiroomFragment.f(MyZiroomFragment.this).isEmpty()))
          {
            MyZiroomFragment.l(MyZiroomFragment.this);
            return;
          }
          if ((MyZiroomFragment.k(MyZiroomFragment.this).size() > 0) && (!MyZiroomFragment.k(MyZiroomFragment.this).isEmpty()))
          {
            MyZiroomFragment.m(MyZiroomFragment.this);
            return;
          }
        }
        catch (Exception paramAnonymousCall)
        {
          paramAnonymousCall.printStackTrace();
          return;
        }
        MyZiroomFragment.n(MyZiroomFragment.this);
        return;
        label336:
        MyZiroomFragment.n(MyZiroomFragment.this);
        return;
        label344:
        MyZiroomFragment.n(MyZiroomFragment.this);
      }
    });
  }
  
  private void z()
  {
    getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        MyZiroomFragment.this.u.setVisibility(8);
      }
    });
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama) {}
  
  protected void c()
  {
    if (this.aM == null) {
      this.aM = new EMMessageListener()
      {
        public void onCmdMessageReceived(List<EMMessage> paramAnonymousList) {}
        
        public void onMessageChanged(EMMessage paramAnonymousEMMessage, Object paramAnonymousObject) {}
        
        public void onMessageDelivered(List<EMMessage> paramAnonymousList) {}
        
        public void onMessageRead(List<EMMessage> paramAnonymousList) {}
        
        public void onMessageRecalled(List<EMMessage> paramAnonymousList) {}
        
        public void onMessageReceived(List<EMMessage> paramAnonymousList)
        {
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            String str = ((EMMessage)paramAnonymousList.next()).getUserName();
            if ("ziroomerPro".equals(str))
            {
              MyZiroomFragment.a(MyZiroomFragment.this, EMClient.getInstance().chatManager().getConversation("ziroomerPro"));
              MyZiroomFragment.d(MyZiroomFragment.this, MyZiroomFragment.t(MyZiroomFragment.this).getUnreadMsgCount());
              ApplicationEx.c.setUnReadNum(MyZiroomFragment.u(MyZiroomFragment.this));
            }
            if ("ms_ziroom".equals(str))
            {
              MyZiroomFragment.a(MyZiroomFragment.this, EMClient.getInstance().chatManager().getConversation("ms_ziroom"));
              MyZiroomFragment.e(MyZiroomFragment.this, MyZiroomFragment.t(MyZiroomFragment.this).getUnreadMsgCount());
              ApplicationEx.c.setMisuNum(MyZiroomFragment.v(MyZiroomFragment.this));
            }
          }
        }
      };
    }
    EMClient.getInstance().chatManager().addMessageListener(this.aM);
  }
  
  protected void d()
  {
    if (!MessageUtil.issHasUpdateNum()) {
      M();
    }
    MessageUtil.doAfterMsgNumUpdate(new MessageUtil.a()
    {
      public void onMessageNumUpdate()
      {
        MyZiroomFragment.x(MyZiroomFragment.this);
      }
    });
  }
  
  public void doSign()
  {
    com.ziroom.commonlibrary.login.a.getUserInfo(this.aZ, new a.b()
    {
      public void onUserInfo(com.alibaba.fastjson.e paramAnonymouse)
      {
        if (paramAnonymouse == null) {
          return;
        }
        MyZiroomFragment.this.ay = ((String)paramAnonymouse.get("phone"));
        if (!TextUtils.isEmpty(MyZiroomFragment.this.ay))
        {
          MyZiroomFragment.a(MyZiroomFragment.this, MyZiroomFragment.this.ay);
          return;
        }
        com.ziroom.commonlibrary.login.a.startBindPhoneActivity(MyZiroomFragment.e(MyZiroomFragment.this));
      }
    });
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131696351: 
    case 2131691481: 
    case 2131692018: 
    case 2131696352: 
    case 2131696353: 
    case 2131691871: 
    case 2131691872: 
    case 2131691873: 
    case 2131691874: 
    case 2131691875: 
    case 2131696367: 
      do
      {
        return;
        n();
        return;
        a(SelfSettingActivity.class);
        return;
        v();
        return;
        w.onEvent("PersonalCenter_collection");
        a(MyCollectionsActivity.class);
        return;
        d("PersonalCenter_myappointment1018");
        a(MyAppointActivity.class);
        return;
        d("PersonalCenter_mytrips");
        a(MyOrdersActivity.class);
        return;
        d("PersonalCenter_notevaluate1018");
        a(EvaluationActivity.class);
        return;
        if (this.aK)
        {
          startActivity(new Intent(this.aZ, AccountMainActivity.class));
          w.onEvent("PersonalCenter_account");
          return;
        }
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.aZ);
        return;
        if ((this.aU != null) && (!this.aU.isEmpty())) {}
        for (this.av = ((MinsuOrderBean.MinsuOrderListBean)this.aU.get(0)).getOrderProjectType(); this.av == 1; this.av = ((ZiruyiOrderBean.ZiRuYiOrderListBean)this.aV.get(0)).getOrderProjectType())
        {
          paramView = new Intent(this.aZ, MinsuSignedActivity.class);
          paramView.putExtra("fid", ((MinsuOrderBean.MinsuOrderListBean)this.aU.get(0)).getFid());
          paramView.putExtra("rentWay", ((MinsuOrderBean.MinsuOrderListBean)this.aU.get(0)).getRentWay());
          paramView.putExtra("orderSn", ((MinsuOrderBean.MinsuOrderListBean)this.aU.get(0)).getOrderSn());
          startActivity(paramView);
          return;
          if ((this.aV == null) || (this.aV.isEmpty())) {
            break label433;
          }
        }
      } while (this.av != 2);
      paramView = new Intent(this.aZ, OrderDetailActivity.class);
      paramView.putExtra("orderBid", ((ZiruyiOrderBean.ZiRuYiOrderListBean)this.aV.get(0)).getOrderBid());
      startActivity(paramView);
      return;
    case 2131696370: 
    case 2131696371: 
      t();
      return;
    case 2131696380: 
    case 2131696381: 
      q();
      return;
    case 2131696379: 
      p();
      return;
    case 2131696358: 
      a(LeaseActivity.class);
      d("PersonalCenter_mycompact");
      return;
    case 2131696359: 
      if (this.aK)
      {
        paramView = new Intent(this.aZ, GestureLockActivity.class);
        paramView.putExtra("to", IntellectLockActivity.class.getName());
        startActivity(paramView);
      }
      for (;;)
      {
        d("PersonalCenter_mysmartlock");
        return;
        com.ziroom.commonlibrary.login.a.startLoginActivity(this.aZ);
      }
    case 2131696364: 
      com.ziroom.ziroomcustomer.newServiceList.utils.j.toZiRuRepair(this.aZ);
      return;
    case 2131696365: 
      a(CleanHomeActivity.class);
      return;
    case 2131696360: 
      a(MyWillPayListActivity.class);
      return;
    case 2131696361: 
      a(ZryuSdActivity.class);
      return;
    case 2131696366: 
      JsBridgeWebActivity.start(this.aZ, "自如客入住指南", "https://s.growingio.com/wbyE2a", true, "关于租住、生活和服务的问题，这里都有答案~", "http://image.ziroom.com/g2/M00/66/FF/ChAFfVmvVKaAbNJLAAAkLGzzqvc724.png", false, false);
      return;
    case 2131696363: 
      o();
      d("PersonalCenter_mybutler");
      return;
    case 2131691881: 
      if (!ApplicationEx.c.isLoginState())
      {
        com.ziroom.commonlibrary.login.a.startLoginActivity(getContext());
        return;
      }
      startActivity(new Intent(this.aZ, ChatCenterActivity.class));
      w.onEvent("personalcenter_customerservice");
      return;
    case 2131691882: 
      u();
      return;
    case 2131691883: 
      JsBridgeWebActivity.start(this.aZ, "", "http://zhuanti.ziroom.com/zhuanti/2017/recruitment/index.html");
      return;
    case 2131691884: 
      d("personal_settings");
      a(SelfSettingActivity.class);
      return;
    case 2131690144: 
      J();
      d("personalcenter_customer");
      return;
    case 2131696382: 
    case 2131696383: 
      label433:
      d("PersonalCenter_switchlandlord");
      a(IssueHouseActivity.class);
      return;
    }
    com.ziroom.ziroomcustomer.sharedlife.d.a.sharedLifeContract(this.aZ);
  }
  
  public View onCreateView(final LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.bd = paramLayoutInflater.inflate(2130903378, paramViewGroup, false);
    this.b = ((MyZiroomCardViewZSpace)this.bd.findViewById(2131691878));
    this.c = ((MyZiroomCardViewCommunity)this.bd.findViewById(2131691879));
    this.d = ((PZAcitivitiesItemView)this.bd.findViewById(2131691880));
    this.e = ((RelativeLayout)this.bd.findViewById(2131691477));
    this.g = ((SimpleDraweeView)this.bd.findViewById(2131691481));
    this.h = ((TextView)this.bd.findViewById(2131692018));
    this.i = ((TextView)this.bd.findViewById(2131696355));
    this.j = ((TextView)this.bd.findViewById(2131696352));
    this.k = ((LinearLayout)this.bd.findViewById(2131696353));
    this.p = ((IntellectDeviceView)this.bd.findViewById(2131691871));
    this.q = ((IntellectDeviceView)this.bd.findViewById(2131691872));
    this.r = ((IntellectDeviceView)this.bd.findViewById(2131691873));
    this.s = ((IntellectDeviceView)this.bd.findViewById(2131691874));
    this.t = ((IntellectDeviceView)this.bd.findViewById(2131691875));
    this.f = ((ImageView)this.bd.findViewById(2131696382));
    this.u = ((LinearLayout)this.bd.findViewById(2131696367));
    this.n = ((ImageView)this.bd.findViewById(2131696354));
    this.o = ((ImageView)this.bd.findViewById(2131696356));
    this.ag = ((LinearLayout)this.bd.findViewById(2131691870));
    this.v = ((TextView)this.bd.findViewById(2131696370));
    this.w = ((ImageView)this.bd.findViewById(2131696371));
    this.x = ((TextView)this.bd.findViewById(2131696372));
    this.y = ((TextView)this.bd.findViewById(2131696373));
    this.z = ((TextView)this.bd.findViewById(2131696375));
    this.A = ((TextView)this.bd.findViewById(2131696377));
    this.B = ((LinearLayout)this.bd.findViewById(2131696378));
    this.C = ((TextView)this.bd.findViewById(2131696380));
    this.D = ((TextView)this.bd.findViewById(2131696379));
    this.E = ((TextView)this.bd.findViewById(2131696381));
    this.F = ((MyZiroomCardViewV2Order)this.bd.findViewById(2131691876));
    this.H = ((MyZiroomCardViewContract)this.bd.findViewById(2131691877));
    this.I = ((HorizontalListView)this.bd.findViewById(2131696357));
    this.J = ((IntellectHomeView)this.bd.findViewById(2131696358));
    this.K = ((IntellectHomeView)this.bd.findViewById(2131696359));
    this.L = ((IntellectHomeView)this.bd.findViewById(2131696364));
    this.M = ((IntellectHomeView)this.bd.findViewById(2131696365));
    this.N = ((IntellectHomeView)this.bd.findViewById(2131696360));
    this.O = ((IntellectHomeView)this.bd.findViewById(2131696361));
    this.P = ((IntellectHomeView)this.bd.findViewById(2131696362));
    this.G = ((LinearLayout)this.bd.findViewById(2131693079));
    this.Q = ((IntellectHomeView)this.bd.findViewById(2131696366));
    this.R = ((IntellectHomeView)this.bd.findViewById(2131696363));
    this.S = ((MyInfoItemView)this.bd.findViewById(2131691881));
    this.T = ((MyInfoItemView)this.bd.findViewById(2131691882));
    this.U = ((MyInfoItemView)this.bd.findViewById(2131691883));
    this.V = ((MyInfoItemView)this.bd.findViewById(2131691884));
    this.W = ((RecyclerView)this.bd.findViewById(2131696348));
    this.X = ((LinearLayout)this.bd.findViewById(2131696346));
    this.Y = ((ObservableScrollView)this.bd.findViewById(2131691868));
    this.Z = this.bd.findViewById(2131689928);
    this.aa = ((TextView)this.bd.findViewById(2131692025));
    this.ab = ((ImageView)this.bd.findViewById(2131690144));
    this.ac = ((ImageView)this.bd.findViewById(2131690145));
    this.ad = ((TextView)this.bd.findViewById(2131690146));
    this.ae = this.bd.findViewById(2131691166);
    this.af = ((TextView)this.bd.findViewById(2131696383));
    this.aq = ((ImageView)this.bd.findViewById(2131696351));
    this.aA = ((ConvenientBanner)this.bd.findViewById(2131690977));
    this.l = ((LinearLayout)this.bd.findViewById(2131691886));
    this.m = ((SimpleDraweeView)this.bd.findViewById(2131691887));
    this.ah = ((LinearLayout)this.bd.findViewById(2131695923));
    this.aj = ((LinearLayout)this.bd.findViewById(2131695927));
    this.ai = ((LinearLayout)this.bd.findViewById(2131695924));
    this.ak = ((TextView)this.bd.findViewById(2131695926));
    this.al = ((TextView)this.bd.findViewById(2131695928));
    this.am = ((TextView)this.bd.findViewById(2131695929));
    this.an = ((TextView)this.bd.findViewById(2131695930));
    this.ao = ((TextView)this.bd.findViewById(2131695931));
    this.ap = ((Button)this.bd.findViewById(2131695932));
    this.aB = ((LinearLayout)this.bd.findViewById(2131691869));
    this.aC = ((ImageView)this.bd.findViewById(2131691885));
    this.f.setOnClickListener(this);
    this.aq.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.P.setOnClickListener(this);
    this.J.setOnClickListener(this);
    this.K.setOnClickListener(this);
    this.L.setOnClickListener(this);
    this.M.setOnClickListener(this);
    this.N.setOnClickListener(this);
    this.O.setOnClickListener(this);
    this.Q.setOnClickListener(this);
    this.R.setOnClickListener(this);
    this.S.setOnClickListener(this);
    this.T.setOnClickListener(this);
    this.U.setOnClickListener(this);
    this.V.setOnClickListener(this);
    this.aa.setOnClickListener(this);
    this.ab.setOnClickListener(this);
    this.ac.setOnClickListener(this);
    this.ad.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.af.setOnClickListener(this);
    this.ap.setOnClickListener(this);
    this.aZ = getActivity();
    paramLayoutInflater = this.aZ.getSharedPreferences("rent_house_detail", 0);
    if (paramLayoutInflater.getBoolean("flag_my_tips", true))
    {
      this.aC.setVisibility(0);
      this.aC.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MyZiroomFragment.a(MyZiroomFragment.this).setVisibility(8);
          paramAnonymousView = paramLayoutInflater.edit();
          paramAnonymousView.putBoolean("flag_my_tips", false);
          paramAnonymousView.apply();
        }
      });
    }
    this.aD = ApplicationEx.c.getUser();
    if (this.aD != null) {}
    for (paramLayoutInflater = this.aD.getUid();; paramLayoutInflater = "")
    {
      this.aE = paramLayoutInflater;
      this.bc = true;
      d();
      L();
      this.bb = new c();
      paramLayoutInflater = new IntentFilter();
      paramLayoutInflater.addAction("com.ziroom.ziroomcustomer.main.title");
      getActivity().registerReceiver(this.bb, paramLayoutInflater);
      h();
      w();
      return this.bd;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.bj != null)
    {
      this.bj.removeCallbacksAndMessages(null);
      this.bj = null;
    }
    if (this.aF != null) {
      getActivity().unregisterReceiver(this.aF);
    }
    if (this.bb != null) {
      getActivity().unregisterReceiver(this.bb);
    }
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.az);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.aN) && (!this.aO))
    {
      this.aO = true;
      I();
    }
    l();
    if (ApplicationEx.c.isLoginState()) {
      x();
    }
    for (;;)
    {
      w();
      f();
      m();
      if (this.aP == null) {
        D();
      }
      C();
      c();
      d();
      return;
      this.u.setVisibility(8);
    }
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f2 = paramInt2 / com.ziroom.ziroomcustomer.util.n.dip2px(this.aZ, 100.0F);
    float f1 = f2;
    if (f2 > 0.6D) {
      f1 = 1.0F;
    }
    this.Z.setAlpha(f1);
    this.aa.setAlpha(f1);
    this.ae.setAlpha(f1);
    if ((int)f1 != this.ba)
    {
      if (!com.ziroom.ziroomcustomer.util.c.g.checkSkin()) {
        break label81;
      }
      i();
    }
    for (;;)
    {
      this.ba = ((int)f1);
      return;
      label81:
      k();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    EMClient.getInstance().chatManager().removeMessageListener(this.aM);
  }
  
  public void registerMessageReceiver()
  {
    this.aF = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if ("select_city".equals(paramAnonymousIntent.getAction())) {
          MyZiroomFragment.s(MyZiroomFragment.this);
        }
      }
    };
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("select_city");
    this.aZ.registerReceiver(this.aF, localIntentFilter);
    c();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((paramBoolean) && (this.bc))
    {
      this.bc = false;
      g();
      e();
    }
  }
  
  public void toH5Page(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Log.i("MyZiRoomPageActivity", "跳到活动详情H5:" + paramString1);
    JsBridgeWebActivity.start(this.aZ, paramString2, paramString1, true, paramString3, paramString4, false, true);
  }
  
  public class MessageUpdateReceiver
    extends BroadcastReceiver
  {
    public MessageUpdateReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      u.i("huanxin", " MessageUpdateReceiver  onReceive  -------------- " + getClass().getSimpleName());
      MyZiroomFragment.this.d();
    }
  }
  
  private class a
    implements com.ziroom.commonlibrary.widget.convenientbanner.b.b<String>
  {
    private SimpleDraweeView b;
    
    private a() {}
    
    public void UpdateUI(Context paramContext, int paramInt, String paramString)
    {
      paramContext = x.makeUrl(paramString);
      this.b.setController(com.freelxl.baselibrary.f.c.frescoController(paramContext));
    }
    
    public View createView(Context paramContext)
    {
      this.b = new SimpleDraweeView(paramContext);
      ((GenericDraweeHierarchy)this.b.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
      return this.b;
    }
  }
  
  static class b
    extends Handler
  {
    WeakReference<MyZiroomFragment> a;
    
    b(MyZiroomFragment paramMyZiroomFragment)
    {
      this.a = new WeakReference(paramMyZiroomFragment);
    }
    
    public void handleMessage(Message paramMessage)
    {
      paramMessage = (MyZiroomFragment)this.a.get();
      if (paramMessage != null) {
        MyZiroomFragment.z(paramMessage);
      }
    }
  }
  
  class c
    extends BroadcastReceiver
  {
    c() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (com.ziroom.ziroomcustomer.util.c.g.checkSkin()) {
        MyZiroomFragment.b(MyZiroomFragment.this);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyZiroomFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */