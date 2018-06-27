package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.MobSDK;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner.c;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.r;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.CycleViewPager;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.a;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.b;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.ziroomapartment.adapter.ZryuPDImagePublishAdapter;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuPDRevisionADModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuPDRevisionADModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuPDRevisionADModel.DataBean.ZraDetailAdBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectDetailModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectDetailModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectDetailModel.DataBean.HouseTypeListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectDetailModel.DataBean.TopPicListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectDetailModel.DataBean.ZspaceDtoBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuProjectDetailModel.DataBean.ZspaceDtoBean.PicListBean;
import com.ziroom.ziroomcustomer.ziroomstation.baidumap.StationHouseMapLocationActivity;
import com.ziroom.ziroomcustomer.ziroomstation.model.ZSpaceImageItem;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ZryuProjectDRevisionActivity
  extends BaseActivity
  implements View.OnClickListener, ObservableScrollView.a
{
  public static List<ZSpaceImageItem> d = new ArrayList();
  private List<Integer> A;
  private String B;
  private String C;
  private String D;
  private String E;
  private String F;
  private List<String> G = new ArrayList();
  private String H;
  private String I;
  private String J;
  private String K;
  private String L;
  private String M;
  private List<String> N = new ArrayList();
  private List<String> O = new ArrayList();
  private List<Rect> P = new ArrayList();
  private ZryuPDImagePublishAdapter Q;
  private List<String> R = new ArrayList();
  private String S;
  private String T;
  private String U;
  private String V;
  private GrowingIO W;
  private CycleViewPager.b X = new CycleViewPager.b()
  {
    public void onPosChange(int paramAnonymousInt)
    {
      ZryuProjectDRevisionActivity.a(ZryuProjectDRevisionActivity.this, paramAnonymousInt - 1);
      paramAnonymousInt = 0;
      for (;;)
      {
        if (paramAnonymousInt < ZryuProjectDRevisionActivity.a(ZryuProjectDRevisionActivity.this).size())
        {
          int i = ((Integer)ZryuProjectDRevisionActivity.a(ZryuProjectDRevisionActivity.this).get(paramAnonymousInt)).intValue();
          if (ZryuProjectDRevisionActivity.b(ZryuProjectDRevisionActivity.this) >= i) {}
        }
        else
        {
          ZryuProjectDRevisionActivity.b(ZryuProjectDRevisionActivity.this, paramAnonymousInt - 1);
          ZryuProjectDRevisionActivity.c(ZryuProjectDRevisionActivity.this).notifyDataSetChanged();
          return;
        }
        paramAnonymousInt += 1;
      }
    }
  };
  private CycleViewPager.a Y = new CycleViewPager.a()
  {
    public void onImageClick(int paramAnonymousInt, View paramAnonymousView)
    {
      if (ZryuProjectDRevisionActivity.d(ZryuProjectDRevisionActivity.this).isCycle())
      {
        paramAnonymousView = new Intent(ZryuProjectDRevisionActivity.this, ZryuScanPhotoActivity.class);
        paramAnonymousView.putExtra("panoramicUrl", ZryuProjectDRevisionActivity.e(ZryuProjectDRevisionActivity.this));
        paramAnonymousView.putExtra("position", ZryuProjectDRevisionActivity.b(ZryuProjectDRevisionActivity.this));
        paramAnonymousView.putStringArrayListExtra("photos", (ArrayList)ZryuProjectDRevisionActivity.f(ZryuProjectDRevisionActivity.this));
        if ((ZryuProjectDRevisionActivity.g(ZryuProjectDRevisionActivity.this) != null) && (ZryuProjectDRevisionActivity.a(ZryuProjectDRevisionActivity.this) != null))
        {
          paramAnonymousView.putStringArrayListExtra("types", (ArrayList)ZryuProjectDRevisionActivity.g(ZryuProjectDRevisionActivity.this));
          paramAnonymousView.putIntegerArrayListExtra("typeIndexs", (ArrayList)ZryuProjectDRevisionActivity.a(ZryuProjectDRevisionActivity.this));
        }
        ZryuProjectDRevisionActivity.this.startActivity(paramAnonymousView);
      }
      w.onEventToZiroomAndUmeng("zra_xm_pic");
    }
  };
  private Handler Z = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
        ZryuProjectDRevisionActivity.this.cbZryuPdBanner.setVisibility(0);
        ZryuProjectDRevisionActivity.this.cbZryuPdBanner.getLayoutParams().height = ZryuProjectDRevisionActivity.this.f;
        ZryuProjectDRevisionActivity.n(ZryuProjectDRevisionActivity.this);
        return;
      } while (ZryuProjectDRevisionActivity.this.cbZryuPdBanner == null);
      ZryuProjectDRevisionActivity.this.cbZryuPdBanner.setVisibility(8);
    }
  };
  public List<ZryuProjectDetailModel.DataBean.HouseTypeListBean> a = new ArrayList();
  private PlatformActionListener aa = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      ZryuProjectDRevisionActivity.this.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      paramAnonymousThrowable.printStackTrace();
      ZryuProjectDRevisionActivity.this.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  ZryuProjectDetailModel b;
  @BindView(2131692916)
  Button btnContractZo;
  ZryuPDRevisionADModel c;
  @BindView(2131692914)
  ConvenientBanner cbZryuPdBanner;
  int e;
  int f;
  private final String g = ZryuProjectDRevisionActivity.class.getSimpleName();
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131690895)
  SimpleDraweeView ivMap;
  @BindView(2131691349)
  ImageView ivMapecenter;
  @BindView(2131690673)
  ImageView ivShare;
  @BindView(2131694766)
  LinearLayout llCheckTrafficIntro;
  @BindView(2131691583)
  LinearLayout llHeader;
  @BindView(2131694772)
  ListViewForScrollView lvHouseTypeList;
  @BindView(2131689486)
  GridView mGridView;
  @BindView(2131691157)
  ObservableScrollView mOsv;
  @BindView(2131692860)
  RecyclerView mRvSlider;
  @BindView(2131692917)
  Button orderSeeHouse;
  private Unbinder r;
  @BindView(2131692858)
  RelativeLayout rlSlider;
  @BindView(2131694774)
  RelativeLayout rlZryuPdRevisionHeader;
  private com.ziroom.ziroomcustomer.ziroomapartment.adapter.e s;
  @BindView(2131694779)
  SimpleDraweeView sdvZoPic;
  @BindView(2131694776)
  LinearLayout subwayDistanceList;
  private CycleViewPager t;
  @BindView(2131694775)
  TextView tvAddressStr;
  @BindView(2131694770)
  TextView tvPdDedicatedNameDesc;
  @BindView(2131694768)
  TextView tvPdIntroContent;
  @BindView(2131694763)
  TextView tvPdName;
  @BindView(2131694764)
  TextView tvPdNameDesc;
  @BindView(2131694773)
  TextView tvPdSeeCirclePic;
  @BindView(2131694781)
  TextView tvPdZSpaceContent;
  @BindView(2131694778)
  TextView tvPdZoContent;
  private b u;
  private int v;
  private int w;
  private String x = "";
  private List<String> y;
  private List<String> z;
  @BindView(2131692913)
  View zryu_house_list_container;
  @BindView(2131692911)
  View zryu_pd_revision_dedicated_service;
  @BindView(2131692915)
  View zryu_pd_revision_zo;
  @BindView(2131692912)
  View zryu_pd_revision_zspace;
  
  private void a()
  {
    this.e = getWindowManager().getDefaultDisplay().getWidth();
    this.f = (this.e * 2 / 3);
    com.freelxl.baselibrary.f.c.frescoHierarchyController(this.ivMap, 2130837607);
    this.ivMap.getLayoutParams().height = (this.e * 36 / 75);
    this.s = new com.ziroom.ziroomcustomer.ziroomapartment.adapter.e(this, null, "", "");
    this.lvHouseTypeList.setAdapter(this.s);
    this.mOsv.setOnScrollChangedCallback(this);
    this.ivBack.setOnClickListener(this);
    this.ivShare.setOnClickListener(this);
    this.btnContractZo.setOnClickListener(this);
    this.orderSeeHouse.setOnClickListener(this);
    this.ivMap.setOnClickListener(this);
    this.llCheckTrafficIntro.setOnClickListener(this);
    this.tvPdSeeCirclePic.setOnClickListener(this);
    this.rlSlider.getLayoutParams().height = this.f;
    this.t = ((CycleViewPager)getSupportFragmentManager().findFragmentById(2131692859));
    this.t.setCycle(true);
    this.t.setIsPageNumVisible(false);
    this.t.setScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    this.t.setPosChangeListener(this.X);
    this.t.setWheel(true);
    if (this.t != null) {
      GrowingIO.getInstance().ignoreFragment(this, this.t);
    }
    this.u = new b(2130904613);
    this.mRvSlider.setLayoutManager(new LinearLayoutManager(this, 0, false));
    this.mRvSlider.setAdapter(this.u);
    this.mGridView.setSelector(new ColorDrawable(0));
    d.removeAll(d);
    this.Q = new ZryuPDImagePublishAdapter(this, d);
    this.mGridView.setAdapter(this.Q);
    this.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousView = (SimpleDraweeView)paramAnonymousView.findViewById(2131695460);
        if (!ae.isNull(((ZSpaceImageItem)ZryuProjectDRevisionActivity.d.get(paramAnonymousInt)).localPath)) {}
        for (paramAnonymousAdapterView = r.getZoomBitmap(((ZSpaceImageItem)ZryuProjectDRevisionActivity.d.get(paramAnonymousInt)).localPath);; paramAnonymousAdapterView = null)
        {
          ZryuProjectDRevisionActivity.a(ZryuProjectDRevisionActivity.this, paramAnonymousInt, paramAnonymousView, paramAnonymousAdapterView);
          return;
        }
      }
    });
    this.Q.notifyDataSetChanged();
  }
  
  private void a(int paramInt, SimpleDraweeView paramSimpleDraweeView, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent(this, ZryuScanZSpaceImageActivity.class);
    this.P = b();
    localIntent.putParcelableArrayListExtra("image_origin_rect", (ArrayList)this.P);
    localIntent.putExtra("image_scale_type", paramSimpleDraweeView.getScaleType());
    localIntent.putExtra("image_res_id", paramArrayOfByte);
    localIntent.putExtra("panoramicUrl", this.B);
    localIntent.putExtra("position", paramInt);
    localIntent.putParcelableArrayListExtra("mImageList", (ArrayList)d);
    startActivity(localIntent);
    overridePendingTransition(0, 0);
  }
  
  private ArrayList<Rect> b()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.mGridView.getChildCount();
    int i = 0;
    while (i < j)
    {
      if (i < 6)
      {
        Rect localRect = new Rect();
        this.mGridView.getChildAt(i).findViewById(2131695460).getGlobalVisibleRect(localRect);
        localArrayList.add(localRect);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void e()
  {
    this.x = this.b.data.shareUrl;
    this.B = this.b.data.panoramicUrl;
    if (ae.isNull(this.B)) {
      this.tvPdSeeCirclePic.setVisibility(4);
    }
    Iterator localIterator;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      this.S = this.b.data.telePhone;
      this.y = new ArrayList();
      this.z = new ArrayList();
      this.A = new ArrayList();
      localIterator = this.b.data.topPicList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (ZryuProjectDetailModel.DataBean.TopPicListBean)localIterator.next();
        this.z.add(((ZryuProjectDetailModel.DataBean.TopPicListBean)localObject1).label);
        this.A.add(Integer.valueOf(this.y.size()));
        localObject1 = ((ZryuProjectDetailModel.DataBean.TopPicListBean)localObject1).picURL.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.y.add(localObject2);
        }
      }
      this.tvPdSeeCirclePic.setVisibility(0);
    }
    this.t.setData(this, this.y, this.Y);
    this.C = this.b.data.proName;
    this.D = this.b.data.slogan;
    this.E = this.b.data.briefInfo;
    this.F = this.b.data.zoServiceDesc;
    this.K = this.b.data.peripheralUrl;
    this.L = this.b.data.proName;
    if (ae.isNull(this.K))
    {
      this.llCheckTrafficIntro.setVisibility(8);
      this.I = (this.b.data.lat + "");
      this.H = (this.b.data.lng + "");
      this.G = this.b.data.trafficList;
      this.J = this.b.data.proAddr;
      setFindLife(this.J, this.G, this.H, this.I);
      if ((this.b.data.zspaceDto != null) && ((!ae.isNull(this.b.data.zspaceDto.description)) || ((this.b.data.zspaceDto.picList != null) && (this.b.data.zspaceDto.picList.size() != 0)))) {
        break label753;
      }
      this.zryu_pd_revision_zspace.setVisibility(8);
      label527:
      this.a = this.b.data.houseTypeList;
      if ((this.a == null) || (this.a.size() <= 0)) {
        break label902;
      }
      this.orderSeeHouse.setClickable(true);
      this.orderSeeHouse.setBackgroundColor(getResources().getColor(2131624609));
      this.zryu_house_list_container.setVisibility(0);
      this.s.setData(this.a, this.T, this.C, this.b.data.proAddr, this.b.data.proHeadPic);
      label632:
      this.U = this.b.data.zodesc;
      this.V = this.b.data.zourl;
      if ((!ae.isNull(this.U)) || (!ae.isNull(this.V))) {
        break label939;
      }
      this.zryu_pd_revision_zo.setVisibility(8);
    }
    for (;;)
    {
      this.tvPdName.setText(this.C);
      this.tvPdNameDesc.setText(this.D);
      this.tvPdIntroContent.setText(this.E);
      if (!ae.isNull(this.F)) {
        break label975;
      }
      this.zryu_pd_revision_dedicated_service.setVisibility(8);
      return;
      this.llCheckTrafficIntro.setVisibility(0);
      break;
      label753:
      this.zryu_pd_revision_zspace.setVisibility(0);
      this.M = this.b.data.zspaceDto.description;
      localIterator = this.b.data.zspaceDto.picList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (ZryuProjectDetailModel.DataBean.ZspaceDtoBean.PicListBean)localIterator.next();
        localObject2 = new ZSpaceImageItem();
        ((ZSpaceImageItem)localObject2).sourcePath = ((ZryuProjectDetailModel.DataBean.ZspaceDtoBean.PicListBean)localObject1).picUrl;
        this.N.add(((ZSpaceImageItem)localObject2).sourcePath);
        ((ZSpaceImageItem)localObject2).imageDesc = ((ZryuProjectDetailModel.DataBean.ZspaceDtoBean.PicListBean)localObject1).picDes;
        this.O.add(((ZSpaceImageItem)localObject2).imageDesc);
        d.add(localObject2);
      }
      this.Q.notifyDataSetChanged();
      this.tvPdZSpaceContent.setText(this.M);
      break label527;
      label902:
      this.orderSeeHouse.setClickable(false);
      this.orderSeeHouse.setBackgroundColor(getResources().getColor(2131624603));
      this.zryu_house_list_container.setVisibility(8);
      break label632;
      label939:
      this.zryu_pd_revision_zo.setVisibility(0);
      this.sdvZoPic.setController(com.freelxl.baselibrary.f.c.frescoController(this.V));
      this.tvPdZoContent.setText(this.U);
    }
    label975:
    this.zryu_pd_revision_dedicated_service.setVisibility(0);
    this.tvPdDedicatedNameDesc.setText(this.F);
  }
  
  private void f()
  {
    this.T = getIntent().getStringExtra("projectId");
    com.ziroom.ziroomcustomer.ziroomapartment.a.e.getProjectDetail(this, new c(), this.T, true);
    if (!TextUtils.isEmpty(this.T))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("pid", this.T);
      w.onEventValueToZiroomAndUmeng("zra_xm_all", localHashMap);
      w.onEventToZiroomAndUmeng("kZRAProjectDetail_" + this.T);
    }
  }
  
  private void g()
  {
    com.freelxl.baselibrary.d.a.get(q.ag).enqueue(new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        ZryuProjectDRevisionActivity.m(ZryuProjectDRevisionActivity.this).sendEmptyMessage(1);
      }
      
      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
        paramAnonymousCall = paramAnonymousResponse.body().string();
        try
        {
          ZryuProjectDRevisionActivity.this.c = ((ZryuPDRevisionADModel)com.alibaba.fastjson.a.parseObject(paramAnonymousCall, ZryuPDRevisionADModel.class));
          if ((ZryuProjectDRevisionActivity.this.c != null) && (ZryuProjectDRevisionActivity.this.c.error_code == 0))
          {
            if ((ZryuProjectDRevisionActivity.this.c.data != null) && (ZryuProjectDRevisionActivity.this.c.data.zra_detail_ad != null) && (ZryuProjectDRevisionActivity.this.c.data.zra_detail_ad.size() > 0))
            {
              ZryuProjectDRevisionActivity.m(ZryuProjectDRevisionActivity.this).sendEmptyMessage(0);
              return;
            }
            ZryuProjectDRevisionActivity.m(ZryuProjectDRevisionActivity.this).sendEmptyMessage(1);
            return;
          }
        }
        catch (Exception paramAnonymousCall)
        {
          ZryuProjectDRevisionActivity.m(ZryuProjectDRevisionActivity.this).sendEmptyMessage(1);
        }
      }
    });
  }
  
  private void h()
  {
    this.R.clear();
    int i = 0;
    while (i < this.c.data.zra_detail_ad.size())
    {
      this.R.add(((ZryuPDRevisionADModel.DataBean.ZraDetailAdBean)this.c.data.zra_detail_ad.get(i)).img);
      i += 1;
    }
    this.cbZryuPdBanner.setPages(new com.ziroom.commonlibrary.widget.convenientbanner.b.a()
    {
      public ZryuProjectDRevisionActivity.a createHolder()
      {
        return new ZryuProjectDRevisionActivity.a(ZryuProjectDRevisionActivity.this, null);
      }
    }, this.R).setPageIndicator(new int[] { 2130839322, 2130839313 }).setPageIndicatorAlign(ConvenientBanner.c.c).setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
    {
      public void onItemClick(int paramAnonymousInt) {}
    }).setPointViewVisible(true);
    this.cbZryuPdBanner.startTurning(5000L);
    this.cbZryuPdBanner.setOnItemClickListener(new com.ziroom.commonlibrary.widget.convenientbanner.c.b()
    {
      public void onItemClick(int paramAnonymousInt)
      {
        if ((ZryuProjectDRevisionActivity.this.c.data != null) && (ZryuProjectDRevisionActivity.this.c.data.zra_detail_ad != null) && (ZryuProjectDRevisionActivity.this.c.data.zra_detail_ad.size() > 0))
        {
          Intent localIntent = new Intent(ZryuProjectDRevisionActivity.this, HomeWebActivity.class);
          localIntent.putExtra("url", ((ZryuPDRevisionADModel.DataBean.ZraDetailAdBean)ZryuProjectDRevisionActivity.this.c.data.zra_detail_ad.get(paramAnonymousInt)).target);
          localIntent.putExtra("title", ((ZryuPDRevisionADModel.DataBean.ZraDetailAdBean)ZryuProjectDRevisionActivity.this.c.data.zra_detail_ad.get(paramAnonymousInt)).title);
          localIntent.putExtra("pic", ((ZryuPDRevisionADModel.DataBean.ZraDetailAdBean)ZryuProjectDRevisionActivity.this.c.data.zra_detail_ad.get(paramAnonymousInt)).img);
          localIntent.putExtra("ziru", "homeService");
          ZryuProjectDRevisionActivity.this.startActivity(localIntent);
        }
      }
    });
  }
  
  private void i()
  {
    if (checkNet(this)) {
      if (this.x != null) {
        if ((this.b == null) || (this.b.data == null) || (this.b.data.topPicList == null) || (this.b.data.topPicList.size() <= 0) || (((ZryuProjectDetailModel.DataBean.TopPicListBean)this.b.data.topPicList.get(0)).picURL == null) || (((ZryuProjectDetailModel.DataBean.TopPicListBean)this.b.data.topPicList.get(0)).picURL.size() <= 0)) {
          break label250;
        }
      }
    }
    label250:
    for (String str1 = (String)((ZryuProjectDetailModel.DataBean.TopPicListBean)this.b.data.topPicList.get(0)).picURL.get(0);; str1 = null)
    {
      String str3 = this.x;
      if ((this.b != null) && (this.b.data != null)) {}
      for (String str2 = this.b.data.proName;; str2 = null)
      {
        if ((str1 == null) || (str3 == null) || (str2 == null) || ("自如寓" == null)) {
          return;
        }
        com.ziroom.threelib.ziroomshare.c localc = com.ziroom.threelib.ziroomshare.c.getInstance();
        localc.setPaltFormShowFlag(15);
        localc.shareFromCenter(this, str3, "自如寓", str2, str1, this.aa);
        return;
        g.textToast(this, "");
        return;
        g.textToast(this, "网络连接错误");
        return;
      }
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131692916: 
    case 2131692917: 
    case 2131689492: 
    case 2131694773: 
      do
      {
        do
        {
          return;
          w.onEventToZiroomAndUmeng("zra_xm_tel");
          ah.callPhone(this, this.S);
          return;
        } while (ae.isNull(ApplicationEx.c.getUserId(this)));
        paramView = new Intent(this, ApartmentAppointmentActivity.class);
        paramView.putExtra("projectId", this.T);
        if ((this.b != null) && (this.b.data != null))
        {
          paramView.putExtra("proName", this.b.data.proName);
          paramView.putExtra("proAddr", this.b.data.proAddr);
          paramView.putExtra("minPrice", this.b.data.minPrice);
          paramView.putExtra("maxPrice", this.b.data.maxPrice);
          paramView.putExtra("proHeadPic", this.b.data.proHeadPic);
          startActivity(paramView);
        }
        w.onEventToZiroomAndUmeng("zra_xm_book");
        return;
        finish();
        return;
      } while (TextUtils.isEmpty(this.B));
      JsBridgeWebActivity.start(this, "全景看房", this.B);
      return;
    case 2131694766: 
      paramView = new Intent(this, HomeWebActivity.class);
      paramView.putExtra("url", this.K);
      paramView.putExtra("title", this.L);
      startActivity(paramView);
      return;
    case 2131690895: 
      w.onEventToZiroomAndUmeng("zra_xm_address");
      toBaiduMap(this.H, this.I, this.J);
      return;
    }
    i();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    MobSDK.init(this);
    setContentView(2130903591);
    this.r = ButterKnife.bind(this);
    a();
    f();
    this.W = GrowingIO.getInstance();
    this.W.setPageName(this, "自如寓项目详情");
  }
  
  protected void onDestroy()
  {
    this.r.unbind();
    com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto.a.recursionDeleteFile(new File(Environment.getExternalStorageDirectory() + "/ziroom_temp_images/"));
    super.onDestroy();
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = paramInt2 / 500.0F;
    this.llHeader.setAlpha(f1);
    if (f1 > 0.75D)
    {
      this.tvPdSeeCirclePic.setTextColor(getResources().getColor(2131624597));
      this.ivShare.setImageResource(2130840338);
      this.ivBack.setImageResource(2130840141);
      this.rlZryuPdRevisionHeader.setBackground(null);
      return;
    }
    this.ivBack.setImageResource(2130840142);
    this.ivShare.setImageResource(2130840339);
    this.tvPdSeeCirclePic.setTextColor(getResources().getColor(2131624583));
    this.rlZryuPdRevisionHeader.setBackground(getResources().getDrawable(2130838551));
  }
  
  public void setFindLife(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    this.tvAddressStr.setText(paramString1);
    if (!s.isEmpty(paramList))
    {
      i = 0;
      while (i < paramList.size())
      {
        paramString1 = (LinearLayout)LayoutInflater.from(this).inflate(2130904721, null);
        TextView localTextView = (TextView)paramString1.findViewById(2131696137);
        View localView = paramString1.findViewById(2131696200);
        localTextView.setText((CharSequence)paramList.get(i));
        if (i == paramList.size() - 1) {
          localView.setVisibility(4);
        }
        this.subwayDistanceList.addView(paramString1);
        i += 1;
      }
    }
    paramString1 = paramString2 + "," + paramString3;
    int i = Math.min(getResources().getDisplayMetrics().widthPixels, 900);
    int j = i * 36 / 75;
    this.ivMap.setController(com.freelxl.baselibrary.f.c.frescoController("http://api.map.baidu.com/staticimage?width=" + i + "&height=" + j + "&center=" + paramString1 + "&zoom=19"));
    paramString1 = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
    paramString1.setDuration(1500L);
    paramString1.setRepeatCount(99999);
    this.ivMapecenter.setAnimation(paramString1);
    paramString1.start();
  }
  
  public void toBaiduMap(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramString1 = paramString1 + "," + paramString2;
    paramString2 = new Intent(this, StationHouseMapLocationActivity.class);
    paramString2.putExtra("search_location", paramString1);
    paramString2.putExtra("resblock_name", paramString3);
    startActivity(paramString2);
  }
  
  private class a
    implements com.ziroom.commonlibrary.widget.convenientbanner.b.b<String>
  {
    private SimpleDraweeView b;
    
    private a() {}
    
    public void UpdateUI(Context paramContext, int paramInt, String paramString)
    {
      this.b.setController(com.freelxl.baselibrary.f.c.frescoController(paramString));
    }
    
    public View createView(Context paramContext)
    {
      this.b = new SimpleDraweeView(paramContext);
      ((GenericDraweeHierarchy)this.b.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
      return this.b;
    }
  }
  
  private class b
    extends RecyclerView.a
  {
    private int b;
    private int c;
    
    public b(int paramInt)
    {
      this.b = paramInt;
      if (paramInt == 2130904611) {
        this.c = (ZryuProjectDRevisionActivity.this.getResources().getDisplayMetrics().widthPixels / 6);
      }
      while (paramInt != 2130904613) {
        return;
      }
      this.c = ((int)(ZryuProjectDRevisionActivity.this.getResources().getDisplayMetrics().widthPixels - 32.0F * ZryuProjectDRevisionActivity.this.getResources().getDisplayMetrics().density + 0.5F) / 6);
    }
    
    public int getItemCount()
    {
      int j = 0;
      int i = j;
      if (this.b == 2130904613)
      {
        i = j;
        if (ZryuProjectDRevisionActivity.g(ZryuProjectDRevisionActivity.this) != null)
        {
          i = j;
          if (ZryuProjectDRevisionActivity.a(ZryuProjectDRevisionActivity.this) != null)
          {
            i = j;
            if (ZryuProjectDRevisionActivity.g(ZryuProjectDRevisionActivity.this).size() == ZryuProjectDRevisionActivity.a(ZryuProjectDRevisionActivity.this).size()) {
              i = ZryuProjectDRevisionActivity.g(ZryuProjectDRevisionActivity.this).size();
            }
          }
        }
      }
      return i;
    }
    
    public void onBindViewHolder(RecyclerView.u paramu, final int paramInt)
    {
      if (this.b == 2130904613)
      {
        paramu = ((a)paramu).a;
        paramu.setText((CharSequence)ZryuProjectDRevisionActivity.g(ZryuProjectDRevisionActivity.this).get(paramInt));
        if (paramInt != ZryuProjectDRevisionActivity.o(ZryuProjectDRevisionActivity.this)) {
          break label68;
        }
        paramu.setBackgroundResource(2130838624);
      }
      for (;;)
      {
        paramu.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            int i = ((Integer)ZryuProjectDRevisionActivity.a(ZryuProjectDRevisionActivity.this).get(paramInt)).intValue();
            if (i + 1 <= ZryuProjectDRevisionActivity.f(ZryuProjectDRevisionActivity.this).size()) {
              ZryuProjectDRevisionActivity.d(ZryuProjectDRevisionActivity.this).setCurrentItem(i + 1);
            }
          }
        });
        return;
        label68:
        paramu.setBackground(null);
      }
    }
    
    public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = LayoutInflater.from(ZryuProjectDRevisionActivity.this).inflate(this.b, paramViewGroup, false);
      if (this.b == 2130904613)
      {
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(this.c, -2));
        return new a(paramViewGroup);
      }
      return null;
    }
    
    private class a
      extends RecyclerView.u
    {
      Button a;
      
      public a(View paramView)
      {
        super();
        this.a = ((Button)paramView.findViewById(2131695868));
      }
    }
  }
  
  class c
    implements i.a<String>
  {
    c() {}
    
    public void onParse(String paramString, k paramk)
    {
      u.logBigData(ZryuProjectDRevisionActivity.l(ZryuProjectDRevisionActivity.this), "str:" + paramString);
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        ZryuProjectDRevisionActivity.this.b = ((ZryuProjectDetailModel)paramk.getObject());
        if (200 == ZryuProjectDRevisionActivity.this.b.error_code)
        {
          ZryuProjectDRevisionActivity.i(ZryuProjectDRevisionActivity.this);
          ZryuProjectDRevisionActivity.h(ZryuProjectDRevisionActivity.this);
        }
      }
      for (;;)
      {
        ZryuProjectDRevisionActivity.k(ZryuProjectDRevisionActivity.this).setPS1(ZryuProjectDRevisionActivity.this, ZryuProjectDRevisionActivity.j(ZryuProjectDRevisionActivity.this));
        return;
        af.showToast(ZryuProjectDRevisionActivity.this, paramk.getMessage());
        continue;
        af.showToast(ZryuProjectDRevisionActivity.this, paramk.getMessage());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuProjectDRevisionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */