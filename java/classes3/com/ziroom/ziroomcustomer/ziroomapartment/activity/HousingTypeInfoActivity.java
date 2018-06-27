package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.findhouse.HouseMapLocationActivity;
import com.ziroom.ziroomcustomer.findhouse.b.e;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailSpacePop;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.AutoLineFeedLayout;
import com.ziroom.ziroomcustomer.widget.CycleViewPager;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.a;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.b;
import com.ziroom.ziroomcustomer.widget.ExpandableTextViewNewLine;
import com.ziroom.ziroomcustomer.widget.LinearLayoutForListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.ziroomapartment.a.f;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryHouseTypeRoom;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryHouseTypeRoom.PriceDtoBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryHousetypeInfo;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryHousetypeInfo.HouseConfigDtoListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryHousetypeInfo.HouseTypeImgDtoListBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HousingTypeInfoActivity
  extends BaseActivity
  implements ObservableScrollView.a
{
  private String A = "自如寓";
  private ZryHousetypeInfo B;
  private ZryHouseTypeRoom C;
  private CycleViewPager.a D = new CycleViewPager.a()
  {
    public void onImageClick(int paramAnonymousInt, View paramAnonymousView)
    {
      if (HousingTypeInfoActivity.f(HousingTypeInfoActivity.this).isCycle())
      {
        w.onEventToZiroomAndUmeng("zra_hx_pic");
        paramAnonymousView = new Intent(HousingTypeInfoActivity.this, ZryuScanPhotoActivity.class);
        paramAnonymousView.putExtra("panoramicUrl", HousingTypeInfoActivity.g(HousingTypeInfoActivity.this));
        paramAnonymousView.putExtra("position", HousingTypeInfoActivity.h(HousingTypeInfoActivity.this));
        paramAnonymousView.putStringArrayListExtra("photos", (ArrayList)HousingTypeInfoActivity.i(HousingTypeInfoActivity.this));
        if ((HousingTypeInfoActivity.j(HousingTypeInfoActivity.this) != null) && (HousingTypeInfoActivity.k(HousingTypeInfoActivity.this) != null))
        {
          paramAnonymousView.putStringArrayListExtra("types", (ArrayList)HousingTypeInfoActivity.j(HousingTypeInfoActivity.this));
          paramAnonymousView.putIntegerArrayListExtra("typeIndexs", (ArrayList)HousingTypeInfoActivity.k(HousingTypeInfoActivity.this));
        }
        HousingTypeInfoActivity.this.startActivity(paramAnonymousView);
      }
    }
  };
  private CycleViewPager.b E = new CycleViewPager.b()
  {
    public void onPosChange(int paramAnonymousInt)
    {
      HousingTypeInfoActivity.a(HousingTypeInfoActivity.this, paramAnonymousInt - 1);
      paramAnonymousInt = 0;
      for (;;)
      {
        if (paramAnonymousInt < HousingTypeInfoActivity.k(HousingTypeInfoActivity.this).size())
        {
          int i = ((Integer)HousingTypeInfoActivity.k(HousingTypeInfoActivity.this).get(paramAnonymousInt)).intValue();
          if (HousingTypeInfoActivity.h(HousingTypeInfoActivity.this) >= i) {}
        }
        else
        {
          HousingTypeInfoActivity.b(HousingTypeInfoActivity.this, paramAnonymousInt - 1);
          HousingTypeInfoActivity.this.a.notifyDataSetChanged();
          return;
        }
        paramAnonymousInt += 1;
      }
    }
  };
  private boolean F = false;
  private PlatformActionListener G = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      HousingTypeInfoActivity.this.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      paramAnonymousThrowable.printStackTrace();
      HousingTypeInfoActivity.this.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  a a;
  @BindView(2131696406)
  AutoLineFeedLayout alflHouseInfoTag;
  private CycleViewPager b;
  @BindView(2131696057)
  Button btnA;
  @BindView(2131696058)
  Button btnB;
  private int c;
  private int d;
  @BindView(2131696574)
  View divider_activity;
  @BindView(2131696572)
  View divider_location;
  @BindView(2131696570)
  View divider_tags;
  private List<String> e;
  @BindView(2131696415)
  ExpandableTextViewNewLine etvHouseIntroduce;
  private List<String> f;
  private List<Integer> g;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131696567)
  ImageView ivConfigArrowMore;
  @BindView(2131690673)
  ImageView ivShare;
  @BindView(2131696573)
  LinearLayoutForListView llActivity;
  @BindView(2131691352)
  LinearLayout llConfig;
  @BindView(2131696564)
  LinearLayout llConfigBlock;
  @BindView(2131691583)
  LinearLayout llHeader;
  @BindView(2131696571)
  LinearLayout llLocation;
  @BindView(2131696565)
  LinearLayout llRoomBlock;
  @BindView(2131696575)
  LinearLayoutForListView llRooms;
  @BindView(2131692860)
  RecyclerView mRvSlider;
  @BindView(2131690031)
  ObservableScrollView osv;
  private String r;
  @BindView(2131692858)
  RelativeLayout rlSlider;
  private boolean s;
  private String t;
  @BindView(2131696566)
  TextView tvConfigMore;
  @BindView(2131696569)
  TextView tvHouseRemaining;
  @BindView(2131696568)
  TextView tvHousetype;
  @BindView(2131690748)
  TextView tvLocation;
  @BindView(2131689912)
  TextView tvPrice;
  private String u;
  private String v;
  @BindView(2131694590)
  View vHeader;
  @BindView(2131696034)
  View vHeaderDivider;
  @BindView(2131690894)
  ViewStub vsError;
  private int w;
  private String x;
  private String y = "http://m.ziroomapartment.com";
  private String z;
  
  private LinearLayout a(ZryHousetypeInfo.HouseConfigDtoListBean paramHouseConfigDtoListBean)
  {
    float f1 = getResources().getDisplayMetrics().density;
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(17);
    Object localObject = new SimpleDraweeView(this);
    ((SimpleDraweeView)localObject).setController(com.freelxl.baselibrary.f.c.frescoController(paramHouseConfigDtoListBean.getImgUrl()));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(32.0F * f1), (int)(32.0F * f1));
    localLayoutParams.bottomMargin = ((int)(f1 * 8.0F));
    ((SimpleDraweeView)localObject).setLayoutParams(localLayoutParams);
    localLinearLayout.addView((View)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setTextColor(Color.parseColor("#444444"));
    ((TextView)localObject).setTextSize(2, 12.0F);
    ((TextView)localObject).setText(paramHouseConfigDtoListBean.getItemName());
    ((TextView)localObject).setSingleLine(true);
    ((TextView)localObject).setGravity(17);
    localLinearLayout.addView((View)localObject);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
    return localLinearLayout;
  }
  
  private void a()
  {
    this.osv.setOnScrollChangedCallback(this);
    this.b = ((CycleViewPager)getSupportFragmentManager().findFragmentById(2131692859));
    this.b.setCycle(true);
    this.b.setIsPageNumVisible(false);
    this.b.setScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    this.b.setPosChangeListener(this.E);
    this.b.setWheel(false);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int i = getResources().getDisplayMetrics().widthPixels;
    localLayoutParams.width = i;
    localLayoutParams.height = (i / 3 * 2);
    this.rlSlider.setLayoutParams(localLayoutParams);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = paramString2 + "," + paramString3;
    paramString3 = new Intent(this, HouseMapLocationActivity.class);
    paramString3.putExtra("search_location", paramString2);
    paramString3.putExtra("resblock_name", paramString1);
    startActivity(paramString3);
  }
  
  private void b()
  {
    this.t = getIntent().getStringExtra("htId");
    this.u = getIntent().getStringExtra("projectId");
    this.v = getIntent().getStringExtra("projectName");
    this.w = getIntent().getIntExtra("isRoomful", 0);
    this.a = new a(2130904613);
    this.mRvSlider.setLayoutManager(new LinearLayoutManager(this, 0, false));
    this.mRvSlider.setAdapter(this.a);
    g();
    e();
  }
  
  private void e()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("houseTypeId", this.t);
    ((Map)localObject).put("pageNum", "1");
    ((Map)localObject).put("pageSize", "5");
    com.ziroom.ziroomcustomer.ziroomapartment.a.b.convertorStr(this, (Map)localObject);
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localObject = com.ziroom.ziroomcustomer.ziroomapartment.a.c.encryptPost((Map)localObject);
    com.freelxl.baselibrary.d.a.post(q.E + f.h).tag(this).params((Map)localObject).enqueue(new com.ziroom.ziroomcustomer.findhouse.b.b(this, new e(ZryHouseTypeRoom.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        HousingTypeInfoActivity.this.llRoomBlock.setVisibility(8);
      }
      
      public void onSuccess(int paramAnonymousInt, ZryHouseTypeRoom paramAnonymousZryHouseTypeRoom)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousZryHouseTypeRoom);
        HousingTypeInfoActivity.a(HousingTypeInfoActivity.this, paramAnonymousZryHouseTypeRoom);
        if (HousingTypeInfoActivity.a(HousingTypeInfoActivity.this) == null) {}
        do
        {
          return;
          if (HousingTypeInfoActivity.b(HousingTypeInfoActivity.this))
          {
            HousingTypeInfoActivity.a(HousingTypeInfoActivity.this, false);
            HousingTypeInfoActivity.c(HousingTypeInfoActivity.this);
          }
        } while (HousingTypeInfoActivity.a(HousingTypeInfoActivity.this).getPriceDto() == null);
        if ((HousingTypeInfoActivity.a(HousingTypeInfoActivity.this).getPriceDto().getMinPrice() < 0) || (HousingTypeInfoActivity.a(HousingTypeInfoActivity.this).getPriceDto().getMaxPrice() < 0)) {
          HousingTypeInfoActivity.this.tvPrice.setText("");
        }
        while ((paramAnonymousZryHouseTypeRoom.getRoomDetailDtoList() == null) || (paramAnonymousZryHouseTypeRoom.getRoomDetailDtoList().size() < 1))
        {
          HousingTypeInfoActivity.this.llRoomBlock.setVisibility(8);
          return;
          if (HousingTypeInfoActivity.a(HousingTypeInfoActivity.this).getPriceDto().getMinPrice() == HousingTypeInfoActivity.a(HousingTypeInfoActivity.this).getPriceDto().getMaxPrice()) {
            HousingTypeInfoActivity.this.tvPrice.setText("¥" + HousingTypeInfoActivity.a(HousingTypeInfoActivity.this).getPriceDto().getMinPrice() + "/月");
          } else {
            HousingTypeInfoActivity.this.tvPrice.setText("¥" + HousingTypeInfoActivity.a(HousingTypeInfoActivity.this).getPriceDto().getMinPrice() + "-" + HousingTypeInfoActivity.a(HousingTypeInfoActivity.this).getPriceDto().getMaxPrice() + "/月");
          }
        }
        HousingTypeInfoActivity.d(HousingTypeInfoActivity.this);
      }
    });
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.ziroomapartment.adapter.b localb = new com.ziroom.ziroomcustomer.ziroomapartment.adapter.b(this, this.C.getRoomDetailDtoList());
    this.llRooms.setAdapter(localb);
  }
  
  private void g()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("houseTypeId", this.t);
    com.ziroom.ziroomcustomer.ziroomapartment.a.b.convertorStr(this, (Map)localObject);
    ((Map)localObject).put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    localObject = com.ziroom.ziroomcustomer.ziroomapartment.a.c.encryptPost((Map)localObject);
    com.freelxl.baselibrary.d.a.post(q.E + f.g).tag(this).params((Map)localObject).enqueue(new com.ziroom.ziroomcustomer.findhouse.b.a(this, new e(ZryHousetypeInfo.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, ZryHousetypeInfo paramAnonymousZryHousetypeInfo)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousZryHousetypeInfo);
        if (paramAnonymousZryHousetypeInfo == null) {
          return;
        }
        HousingTypeInfoActivity.a(HousingTypeInfoActivity.this, paramAnonymousZryHousetypeInfo);
        HousingTypeInfoActivity.e(HousingTypeInfoActivity.this);
      }
    });
  }
  
  private void h()
  {
    j();
    k();
    i();
    l();
  }
  
  private void i()
  {
    int j = 0;
    if ((this.B.getHouseConfigDtoList() == null) || (this.B.getHouseConfigDtoList().size() < 1))
    {
      this.llConfigBlock.setVisibility(8);
      return;
    }
    this.llConfigBlock.setVisibility(0);
    int i;
    label75:
    ZryHousetypeInfo.HouseConfigDtoListBean localHouseConfigDtoListBean;
    if (this.B.getHouseConfigDtoList().size() < 5)
    {
      i = this.B.getHouseConfigDtoList().size();
      if (j >= i) {
        break label111;
      }
      localHouseConfigDtoListBean = (ZryHousetypeInfo.HouseConfigDtoListBean)this.B.getHouseConfigDtoList().get(j);
      if (localHouseConfigDtoListBean != null) {
        break label113;
      }
    }
    for (;;)
    {
      j += 1;
      break label75;
      i = 5;
      break label75;
      label111:
      break;
      label113:
      this.llConfig.addView(a(localHouseConfigDtoListBean));
    }
  }
  
  private void j()
  {
    this.tvHousetype.setText(this.B.getHouseTypeName());
    this.z = this.B.getRoomIntroduction();
    this.A = ("自如寓--" + this.B.getHouseTypeName());
    this.tvHouseRemaining.setText(this.B.getCoreLab());
    if (TextUtils.isEmpty(this.B.getProAddrDesc()))
    {
      this.llLocation.setVisibility(8);
      this.divider_location.setVisibility(8);
    }
    for (;;)
    {
      this.etvHouseIntroduce.setText(this.B.getRoomIntroduction());
      if ((this.B.getActivityLab() != null) && (this.B.getActivityLab().size() >= 1)) {
        break;
      }
      return;
      this.llLocation.setVisibility(0);
      this.divider_location.setVisibility(0);
      this.tvLocation.setText(this.B.getProAddrDesc());
    }
    com.ziroom.ziroomcustomer.ziroomapartment.adapter.a locala = new com.ziroom.ziroomcustomer.ziroomapartment.adapter.a(this, this.B.getActivityLab());
    this.llActivity.setAdapter(locala);
  }
  
  private void k()
  {
    if ((this.B.getBasicLab() == null) || (this.B.getBasicLab().size() < 1)) {
      this.alflHouseInfoTag.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.alflHouseInfoTag.setVisibility(0);
      Iterator localIterator = this.B.getBasicLab().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        TextView localTextView = (TextView)LayoutInflater.from(this).inflate(2130904465, this.alflHouseInfoTag, false);
        localTextView.setText(str);
        this.alflHouseInfoTag.addView(localTextView);
      }
    }
  }
  
  private void l()
  {
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.g = new ArrayList();
    Object localObject1 = this.B.getHouseTypeImgDtoList();
    if ((localObject1 == null) || (((List)localObject1).size() < 1)) {
      return;
    }
    Iterator localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (ZryHousetypeInfo.HouseTypeImgDtoListBean)localIterator.next();
      if ((localObject2 != null) && (((ZryHousetypeInfo.HouseTypeImgDtoListBean)localObject2).getImgPathList() != null) && (((ZryHousetypeInfo.HouseTypeImgDtoListBean)localObject2).getImgPathList().size() >= 1))
      {
        if (TextUtils.isEmpty(((ZryHousetypeInfo.HouseTypeImgDtoListBean)localObject2).getImgTypeName())) {}
        for (localObject1 = "";; localObject1 = ((ZryHousetypeInfo.HouseTypeImgDtoListBean)localObject2).getImgTypeName())
        {
          this.f.add(localObject1);
          this.g.add(Integer.valueOf(this.e.size()));
          localObject1 = ((ZryHousetypeInfo.HouseTypeImgDtoListBean)localObject2).getImgPathList().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            this.e.add(localObject2);
          }
          break;
        }
      }
    }
    if (this.e.size() > 0) {
      this.x = ((String)this.e.get(0));
    }
    if (ae.notNull(this.B.getShareUrl())) {
      this.y = this.B.getShareUrl();
    }
    this.b.setData(this, this.e, this.D);
  }
  
  private void m()
  {
    if (!com.ziroom.commonlibrary.login.a.getLoginState(this))
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      return;
    }
    if (this.C == null)
    {
      this.F = true;
      e();
      return;
    }
    if (this.B.getNewBookPage() == 1)
    {
      JsBridgeWebActivity.start(this, "", this.B.getBookUrl() + "?projectId=" + this.u + "&houseTypeId=" + this.t + "&uid=" + ApplicationEx.c.getUser().getUid() + "&phone=" + ApplicationEx.c.getUser().getPhone() + "&name=" + ApplicationEx.c.getUser().getRealName());
      return;
    }
    Intent localIntent = new Intent(this, ApartmentAppointmentActivity.class);
    localIntent.putExtra("projectId", this.u);
    localIntent.putExtra("houseTypeId", this.t);
    localIntent.putExtra("proAddr", this.C.getProAddr());
    localIntent.putExtra("proHeadPic", this.C.getProHeadPic());
    localIntent.putExtra("proName", this.v);
    if (this.C.getPriceDto() != null)
    {
      localIntent.putExtra("minPrice", this.C.getPriceDto().getMinPrice() + "");
      localIntent.putExtra("maxPrice", this.C.getPriceDto().getMaxPrice() + "");
    }
    localIntent.putExtra("houseTypeName", this.B.getHouseTypeName());
    startActivity(localIntent);
  }
  
  private void n()
  {
    if (checkNet(this))
    {
      if (this.t != null)
      {
        String str1 = this.x;
        String str2 = this.y;
        String str3 = this.z;
        String str4 = this.A;
        if ((str1 == null) || (str2 == null) || (str3 == null) || (str4 == null)) {
          return;
        }
        com.ziroom.threelib.ziroomshare.c localc = com.ziroom.threelib.ziroomshare.c.getInstance();
        localc.setPaltFormShowFlag(15);
        localc.shareFromCenter(this, str2, str4, str3, str1, this.G);
        return;
      }
      g.textToast(this, "");
      return;
    }
    g.textToast(this, "网络连接错误");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904815);
    ButterKnife.bind(this);
    a();
    b();
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = paramInt2 / 500.0F;
    this.vHeader.setAlpha(f1);
    this.vHeaderDivider.setAlpha(f1);
    if (f1 > 0.75D)
    {
      this.s = true;
      this.ivShare.setImageResource(2130840338);
      this.ivBack.setImageResource(2130840141);
      return;
    }
    this.s = false;
    this.ivShare.setImageResource(2130840339);
    this.ivBack.setImageResource(2130840142);
  }
  
  @OnClick({2131696569, 2131696571, 2131689492, 2131690673, 2131696566, 2131696567, 2131696057, 2131696058})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131696571: 
      a(this.B.getProAddrDesc(), this.B.getLng(), this.B.getLat());
      return;
    case 2131689492: 
      finish();
      return;
    case 2131690673: 
      n();
      return;
    case 2131696566: 
    case 2131696567: 
      new RentHouseDetailSpacePop(this).showZryApartment(this.tvConfigMore, this.B.getHouseConfigDtoList());
      return;
    case 2131696057: 
      ah.callPhone(this, this.B.getPhone());
      return;
    }
    m();
  }
  
  private class a
    extends RecyclerView.a
  {
    private int b;
    private int c;
    
    public a(int paramInt)
    {
      this.b = paramInt;
      if (paramInt == 2130904611) {
        this.c = (HousingTypeInfoActivity.this.getResources().getDisplayMetrics().widthPixels / 6);
      }
      while (paramInt != 2130904613) {
        return;
      }
      this.c = ((int)(HousingTypeInfoActivity.this.getResources().getDisplayMetrics().widthPixels - 32.0F * HousingTypeInfoActivity.this.getResources().getDisplayMetrics().density + 0.5F) / 6);
    }
    
    public int getItemCount()
    {
      int j = 0;
      int i = j;
      if (this.b == 2130904613)
      {
        i = j;
        if (HousingTypeInfoActivity.j(HousingTypeInfoActivity.this) != null)
        {
          i = j;
          if (HousingTypeInfoActivity.k(HousingTypeInfoActivity.this) != null)
          {
            i = j;
            if (HousingTypeInfoActivity.j(HousingTypeInfoActivity.this).size() == HousingTypeInfoActivity.k(HousingTypeInfoActivity.this).size()) {
              i = HousingTypeInfoActivity.j(HousingTypeInfoActivity.this).size();
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
        paramu.setText((CharSequence)HousingTypeInfoActivity.j(HousingTypeInfoActivity.this).get(paramInt));
        if (paramInt != HousingTypeInfoActivity.l(HousingTypeInfoActivity.this)) {
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
            int i = ((Integer)HousingTypeInfoActivity.k(HousingTypeInfoActivity.this).get(paramInt)).intValue();
            if (i + 1 <= HousingTypeInfoActivity.i(HousingTypeInfoActivity.this).size()) {
              HousingTypeInfoActivity.f(HousingTypeInfoActivity.this).setCurrentItem(i + 1);
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
      paramViewGroup = LayoutInflater.from(HousingTypeInfoActivity.this).inflate(this.b, paramViewGroup, false);
      if (this.b == 2130904611)
      {
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(this.c, -2));
        return new b(paramViewGroup);
      }
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
    
    private class b
      extends RecyclerView.u
    {
      TextView a;
      
      public b(View paramView)
      {
        super();
        this.a = ((TextView)paramView.findViewById(2131695867));
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/HousingTypeInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */