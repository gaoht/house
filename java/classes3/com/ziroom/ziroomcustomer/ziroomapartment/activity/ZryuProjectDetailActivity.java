package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.MobSDK;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.wxapi.a;
import com.ziroom.ziroomcustomer.ziroomapartment.a.c;
import com.ziroom.ziroomcustomer.ziroomapartment.a.e;
import com.ziroom.ziroomcustomer.ziroomapartment.fragment.ZryuCircumFragment;
import com.ziroom.ziroomcustomer.ziroomapartment.fragment.ZryuRoomFragment;
import com.ziroom.ziroomcustomer.ziroomapartment.model.Area;
import com.ziroom.ziroomcustomer.ziroomapartment.model.Price;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuHouseTypeListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuHouseTypeListModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionRecord;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionResult;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.MyViewPager;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ZryuStickyNavLayout;
import com.ziroom.ziroomcustomer.ziroomstation.baidumap.StationHouseMapLocationActivity;
import com.ziroom.ziroomcustomer.ziroomstation.carouselimg.CycleViewPager;
import com.ziroom.ziroomcustomer.ziroomstation.carouselimg.CycleViewPager.a;
import com.ziroom.ziroomcustomer.ziroomstation.utils.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ZryuProjectDetailActivity
  extends BaseActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private static int K;
  private TextView A;
  private TextView B;
  private TextView C;
  private ImageView D;
  private RelativeLayout E;
  private MyViewPager F;
  private ZryuStickyNavLayout G;
  private CycleViewPager H;
  private Button I;
  private LinearLayout J;
  private int L;
  private List<TextView> M = new ArrayList();
  private List<Fragment> N = new ArrayList();
  private FragmentPagerAdapter O;
  private boolean P = true;
  private BaseActivity Q;
  private String R = "http://imgsrc.baidu.com/forum/pic/item/a275666b3b092e466a60fbfe.jpg";
  private IWXAPI S;
  private Price T = new Price();
  private Area U = new Area();
  private GrowingIO V;
  private PlatformActionListener W = new PlatformActionListener()
  {
    public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt) {}
    
    public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
    {
      ZryuProjectDetailActivity.this.showToast("分享成功");
    }
    
    public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      paramAnonymousThrowable.printStackTrace();
      ZryuProjectDetailActivity.this.showToast("分享失败");
      if ("SinaWeibo".equals(paramAnonymousPlatform.getName()))
      {
        ShareSDK.getPlatform(SinaWeibo.NAME).removeAccount(false);
        ShareSDK.removeCookieOnAuthorize(true);
      }
    }
  };
  public String a;
  public ZryuHouseTypeListModel b;
  public boolean c = false;
  public ZryuSearchConditionResult d;
  View.OnClickListener e = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      String str2 = (String)ZryuProjectDetailActivity.this.b.data.projectImgUrl.get(0);
      Object localObject = ZryuProjectDetailActivity.e(ZryuProjectDetailActivity.this);
      String str1 = ZryuProjectDetailActivity.this.b.data.projectName;
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 2131697535: 
        u.e("QQ", "QQ");
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如寓");
        paramAnonymousView.setTitleUrl((String)localObject);
        paramAnonymousView.setText(str1);
        paramAnonymousView.setImageUrl(str2);
        localObject = ShareSDK.getPlatform(QQ.NAME);
        ((Platform)localObject).setPlatformActionListener(ZryuProjectDetailActivity.f(ZryuProjectDetailActivity.this));
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697536: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如寓");
        paramAnonymousView.setTitleUrl((String)localObject);
        paramAnonymousView.setText(str1);
        paramAnonymousView.setImageUrl(str2);
        paramAnonymousView.setSiteUrl("www.ziroom.com");
        localObject = ShareSDK.getPlatform(QZone.NAME);
        ((Platform)localObject).setPlatformActionListener(ZryuProjectDetailActivity.f(ZryuProjectDetailActivity.this));
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697537: 
        paramAnonymousView = new Platform.ShareParams();
        paramAnonymousView.setTitle("自如寓");
        paramAnonymousView.setTitleUrl((String)localObject);
        paramAnonymousView.setText(str1);
        if (!ae.isNull(str2)) {
          paramAnonymousView.setImageUrl(str2);
        }
        localObject = ShareSDK.getPlatform(SinaWeibo.NAME);
        ((Platform)localObject).setPlatformActionListener(ZryuProjectDetailActivity.f(ZryuProjectDetailActivity.this));
        ((Platform)localObject).share(paramAnonymousView);
        return;
      case 2131697538: 
        paramAnonymousView = new WXWebpageObject();
        paramAnonymousView.webpageUrl = ((String)localObject);
        paramAnonymousView = new WXMediaMessage(paramAnonymousView);
        paramAnonymousView.title = "自如寓";
        paramAnonymousView.thumbData = a.bmpToByteArray(BitmapFactory.decodeResource(ZryuProjectDetailActivity.this.getResources(), 2130838626), true);
        localObject = new SendMessageToWX.Req();
        ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
        ((SendMessageToWX.Req)localObject).message = paramAnonymousView;
        ((SendMessageToWX.Req)localObject).scene = 1;
        ZryuProjectDetailActivity.g(ZryuProjectDetailActivity.this).sendReq((BaseReq)localObject);
        return;
      }
      paramAnonymousView = new WXWebpageObject();
      paramAnonymousView.webpageUrl = ((String)localObject);
      paramAnonymousView = new WXMediaMessage(paramAnonymousView);
      paramAnonymousView.title = "自如寓";
      paramAnonymousView.description = str1;
      paramAnonymousView.thumbData = a.bmpToByteArray(BitmapFactory.decodeResource(ZryuProjectDetailActivity.this.getResources(), 2130838626), true);
      localObject = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject).transaction = (System.currentTimeMillis() + "");
      ((SendMessageToWX.Req)localObject).message = paramAnonymousView;
      ZryuProjectDetailActivity.g(ZryuProjectDetailActivity.this).sendReq((BaseReq)localObject);
    }
  };
  private ImageView f;
  private TextView g;
  private ImageView r;
  private View s;
  private RelativeLayout t;
  private FrameLayout u;
  private TextView v;
  private TextView w;
  private ImageView x;
  private LinearLayout y;
  private View z;
  
  private void a()
  {
    this.N.removeAll(this.N);
    this.N.add(new ZryuRoomFragment());
    this.N.add(new ZryuCircumFragment(this.b.data.projectAroundUrl));
    this.O = new FragmentPagerAdapter(getSupportFragmentManager())
    {
      public int getCount()
      {
        return 2;
      }
      
      public Fragment getItem(int paramAnonymousInt)
      {
        return (Fragment)ZryuProjectDetailActivity.a(ZryuProjectDetailActivity.this).get(paramAnonymousInt);
      }
    };
    this.F.setAdapter(this.O);
    this.F.setOffscreenPageLimit(2);
    b(0);
    this.F.setCurrentItem(0, false);
    this.F.setOnPageChangeListener(this);
    if (ae.isNull(this.b.data.projectAroundUrl))
    {
      this.E.setVisibility(8);
      this.J.setVisibility(8);
    }
    for (;;)
    {
      this.J.post(new Runnable()
      {
        public void run()
        {
          ZryuProjectDetailActivity.b(ZryuProjectDetailActivity.this).calculateTopViewHeight();
        }
      });
      return;
      this.E.setVisibility(0);
      this.J.setVisibility(0);
    }
  }
  
  private void a(a parama, float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.D.getLayoutParams();
    if (parama == a.a) {
      localLayoutParams.leftMargin = ((int)(-(1.0F - paramFloat) * K + this.L * K));
    }
    for (;;)
    {
      this.D.setLayoutParams(localLayoutParams);
      return;
      if (parama == a.b) {
        localLayoutParams.leftMargin = ((int)(K * paramFloat + this.L * K));
      }
    }
  }
  
  private void a(List<String> paramList)
  {
    this.H.setCycle(true);
    this.H.setData(paramList, b(paramList));
    this.H.setWheel(true);
    this.H.setTime(2000);
    this.H.setIndicatorCenter();
  }
  
  private CycleViewPager.a b(final List<String> paramList)
  {
    paramList = (ArrayList)paramList;
    if (!i.isLegal(paramList)) {
      return null;
    }
    new CycleViewPager.a()
    {
      public void onImageClick(String paramAnonymousString, int paramAnonymousInt, View paramAnonymousView)
      {
        if (paramAnonymousView.getTag() == null) {
          return;
        }
        paramAnonymousInt = 0;
        int i = 0;
        while (paramAnonymousInt < paramList.size())
        {
          if (paramAnonymousString.equals((String)paramList.get(paramAnonymousInt))) {
            i = paramAnonymousInt;
          }
          paramAnonymousInt += 1;
        }
        paramAnonymousString = new Intent(ZryuProjectDetailActivity.this, ZryuPhotoPreviewActivity.class);
        paramAnonymousString.putStringArrayListExtra("urlList", paramList);
        paramAnonymousString.putExtra("position", i);
        paramAnonymousString.putExtra("isDeleteable", false);
        paramAnonymousString.putExtra("fPanoramicUrl", ZryuProjectDetailActivity.this.b.data.fPanoramicUrl);
        ZryuProjectDetailActivity.this.startActivityForResult(paramAnonymousString, 257);
        w.onEventToZiroomAndUmeng("zra_xm_pic");
      }
    };
  }
  
  private void b()
  {
    if (this.P) {
      findViewById(2131692922).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(ZryuProjectDetailActivity.this, ZryuEvaluateActivity.class);
          ZryuProjectDetailActivity.this.startActivity(paramAnonymousView);
        }
      });
    }
    for (;;)
    {
      this.J = ((LinearLayout)findViewById(2131692924));
      this.I = ((Button)findViewById(2131692928));
      this.I.setOnClickListener(this);
      this.f = ((ImageView)findViewById(2131689492));
      this.f.setOnClickListener(this);
      this.g = ((TextView)findViewById(2131692920));
      this.r = ((ImageView)findViewById(2131692921));
      this.r.setOnClickListener(this);
      this.s = findViewById(2131692923);
      this.t = ((RelativeLayout)findViewById(2131692919));
      this.H = ((CycleViewPager)getFragmentManager().findFragmentById(2131692523));
      this.u = ((FrameLayout)findViewById(2131692522));
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.u.getLayoutParams();
      localLayoutParams.height = (localDisplayMetrics.widthPixels * 2 / 3);
      this.u.setLayoutParams(localLayoutParams);
      this.v = ((TextView)findViewById(2131692524));
      this.w = ((TextView)findViewById(2131692525));
      this.w.setOnClickListener(this);
      this.x = ((ImageView)findViewById(2131692520));
      this.x.setOnClickListener(this);
      this.y = ((LinearLayout)findViewById(2131690045));
      this.z = findViewById(2131692531);
      this.A = ((TextView)findViewById(2131692925));
      this.B = ((TextView)findViewById(2131692926));
      this.C = ((TextView)findViewById(2131692927));
      this.M.add(this.A);
      this.M.add(this.B);
      this.A.setOnClickListener(this);
      this.B.setOnClickListener(this);
      this.D = ((ImageView)findViewById(2131690026));
      this.E = ((RelativeLayout)findViewById(2131690060));
      this.F = ((MyViewPager)findViewById(2131690064));
      this.G = ((ZryuStickyNavLayout)findViewById(2131690044));
      return;
      findViewById(2131692922).setVisibility(8);
    }
  }
  
  private void b(int paramInt)
  {
    Iterator localIterator = this.M.iterator();
    while (localIterator.hasNext()) {
      ((TextView)localIterator.next()).setTextColor(getResources().getColor(2131624597));
    }
    ((TextView)this.M.get(paramInt)).setTextColor(getResources().getColor(2131624609));
  }
  
  private void e()
  {
    this.a = getIntent().getStringExtra("projectId");
    this.d = ((ZryuSearchConditionResult)getIntent().getSerializableExtra("search_condition_result"));
    f();
    if (!TextUtils.isEmpty(this.a))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("pid", this.a);
      w.onEventValueToZiroomAndUmeng("zra_xm_all", localHashMap);
      w.onEventToZiroomAndUmeng("kZRAProjectDetail_" + this.a);
    }
  }
  
  private void f()
  {
    if (checkNet(this))
    {
      Map localMap = c.buildHouseTypeList(this, this.a, this.d);
      e.getHouseTypeList(this, new b(), localMap, true);
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  private void g()
  {
    if (!this.c)
    {
      a(this.b.data.projectImgUrl);
      this.R = this.b.data.projectShareUrl;
      this.g.setText(this.b.data.projectName);
      this.v.setText(this.b.data.projectName);
      this.w.setText(this.b.data.projectAddr);
      if (this.b.data.projectAroundName != null) {
        this.B.setText(this.b.data.projectAroundName);
      }
      for (;;)
      {
        a();
        return;
        this.B.setText("周边");
      }
    }
    ((ZryuRoomFragment)this.O.getItem(0)).setData(this.b);
  }
  
  private void h()
  {
    K = getResources().getDisplayMetrics().widthPixels / 2;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.D.getLayoutParams();
    localLayoutParams.width = K;
    localLayoutParams.leftMargin = (K * 0);
    int i = (K - n.dip2px(this, 50.0F)) / 2;
    this.D.setPadding(i, 0, i, 0);
    this.D.setLayoutParams(localLayoutParams);
  }
  
  private void i()
  {
    if (checkNet(this))
    {
      if (this.R != null)
      {
        this.S = WXAPIFactory.createWXAPI(this, "wxc2bae7e8ecb7d70b", true);
        this.S.registerApp("wxc2bae7e8ecb7d70b");
        View localView = LayoutInflater.from(this).inflate(2130905131, null);
        Object localObject = (LinearLayout)localView.findViewById(2131697535);
        LinearLayout localLinearLayout1 = (LinearLayout)localView.findViewById(2131697536);
        LinearLayout localLinearLayout2 = (LinearLayout)localView.findViewById(2131697537);
        LinearLayout localLinearLayout3 = (LinearLayout)localView.findViewById(2131697539);
        LinearLayout localLinearLayout4 = (LinearLayout)localView.findViewById(2131697538);
        ((LinearLayout)localObject).setOnClickListener(this.e);
        localLinearLayout1.setOnClickListener(this.e);
        localLinearLayout2.setOnClickListener(this.e);
        localLinearLayout3.setOnClickListener(this.e);
        localLinearLayout4.setOnClickListener(this.e);
        localObject = new Dialog(this, 2131427781);
        ((Dialog)localObject).setContentView(localView);
        if (!(localObject instanceof Dialog))
        {
          ((Dialog)localObject).show();
          return;
        }
        VdsAgent.showDialog((Dialog)localObject);
        return;
      }
      g.textToast(this, "");
      return;
    }
    g.textToast(this, "网络连接错误");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((-1 == paramInt2) && (43981 == paramInt1))
    {
      this.d = ((ZryuSearchConditionResult)paramIntent.getSerializableExtra("search_condition_result"));
      f();
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131692928: 
    case 2131692925: 
    case 2131692926: 
      do
      {
        do
        {
          return;
          w.onEventToZiroomAndUmeng("zra_xm_book");
        } while (ae.isNull(ApplicationEx.c.getUserId(this)));
        paramView = new Intent(this, ApartmentAppointmentActivity.class);
        paramView.putExtra("projectId", this.b.data.projectId);
        startActivity(paramView);
        return;
        b(0);
        this.F.setCurrentItem(0, false);
        return;
      } while ((this.N == null) || (this.N.size() < 2));
      ((Fragment)this.N.get(1)).setUserVisibleHint(true);
      b(1);
      this.F.setCurrentItem(1, false);
      return;
    case 2131689492: 
      finish();
      return;
    case 2131692921: 
      i();
      return;
    case 2131692525: 
      w.onEventToZiroomAndUmeng("zra_xm_address");
      toBaiduMap();
      return;
    }
    w.onEventToZiroomAndUmeng("zra_xm_tel");
    startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.b.data.projectPhone)));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    MobSDK.init(this);
    setContentView(2130903593);
    this.Q = this;
    b();
    h();
    e();
    this.V = GrowingIO.getInstance();
    this.V.setPageGroup(this, "自如寓项目详情");
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((this.L == 0) && (paramInt1 == 0)) {
      a(a.b, paramFloat);
    }
    do
    {
      return;
      if ((this.L == 1) && (paramInt1 == 0))
      {
        a(a.a, paramFloat);
        return;
      }
      if ((this.L == 1) && (paramInt1 == 1))
      {
        a(a.b, paramFloat);
        return;
      }
      if ((this.L == 2) && (paramInt1 == 1))
      {
        a(a.a, paramFloat);
        return;
      }
    } while ((this.L != 2) || (paramInt1 != 2));
    a(a.b, paramFloat);
  }
  
  public void onPageSelected(int paramInt)
  {
    b(paramInt);
    this.L = paramInt;
  }
  
  public void toBaiduMap()
  {
    if ((this.b != null) && (this.b.data != null))
    {
      String str = this.b.data.projectLong + "," + this.b.data.projectLat;
      Intent localIntent = new Intent(this, StationHouseMapLocationActivity.class);
      localIntent.putExtra("search_location", str);
      localIntent.putExtra("resblock_name", this.b.data.projectAddr);
      startActivity(localIntent);
    }
  }
  
  public void toFilterPage()
  {
    w.onEventToZiroomAndUmeng("zra_xm_search");
    ZryuSearchConditionRecord.getInstance().startHouseSearchActivity(this, this.a);
    this.c = true;
  }
  
  static enum a
  {
    private a() {}
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        ZryuProjectDetailActivity.this.b = ((ZryuHouseTypeListModel)paramk.getObject());
        if (200 == ZryuProjectDetailActivity.this.b.error_code) {
          ZryuProjectDetailActivity.c(ZryuProjectDetailActivity.this);
        }
      }
      for (;;)
      {
        ZryuProjectDetailActivity.d(ZryuProjectDetailActivity.this).setPS1(ZryuProjectDetailActivity.this, ZryuProjectDetailActivity.this.a);
        return;
        af.showToast(ZryuProjectDetailActivity.this, ZryuProjectDetailActivity.this.b.error_message);
        continue;
        af.showToast(ZryuProjectDetailActivity.this, paramk.getMessage());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuProjectDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */