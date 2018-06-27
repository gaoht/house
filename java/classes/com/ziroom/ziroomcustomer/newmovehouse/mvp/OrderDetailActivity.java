package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.UiSettings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.view.widget.a.a;
import com.ziroom.ziroomcustomer.newclean.d.ak;
import com.ziroom.ziroomcustomer.newclean.mvp.ScanCameraActivity;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail.SupplierEmployeeInfoVOBean;
import com.ziroom.ziroomcustomer.newmovehouse.widget.MoveEvalWidget;
import com.ziroom.ziroomcustomer.newrepair.widget.StarBar;
import com.ziroom.ziroomcustomer.util.n;
import java.io.File;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class OrderDetailActivity
  extends BaseActivity
  implements View.OnClickListener, h.b
{
  private View A;
  private SwipeRefreshLayout B;
  private BottomSheetBehavior C;
  private NestedScrollView D;
  private CardView E;
  private RelativeLayout F;
  private LinearLayout G;
  private TextView H;
  private TextView I;
  private TextView J;
  private LinearLayout K;
  private SimpleDraweeView L;
  private TextView M;
  private TextView N;
  private StarBar O;
  private ImageView P;
  private LinearLayout Q;
  private RelativeLayout R;
  private TextView S;
  private ImageView T;
  private RecyclerView U;
  private TextView V;
  private LinearLayout W;
  private TextView X;
  private TextView Y;
  private TextView Z;
  protected View a;
  private TextView aa;
  private LinearLayout ab;
  private TextView ac;
  private LinearLayout ad;
  private TextView ae;
  private ImageView af;
  private ClipboardManager ag;
  private TextView ah;
  private RelativeLayout ai;
  private TextView aj;
  private h.a ak;
  private CardView al;
  private Button am;
  private TextView an;
  private boolean ao = false;
  private List<String> ap = new ArrayList();
  private com.ziroom.ziroomcustomer.minsu.dialog.i aq;
  private OrderDetailActivity ar;
  private TextView as;
  private BroadcastReceiver at = new OrderDetailActivity.2(this);
  private List<File> au = new ArrayList();
  private int av = 1;
  protected MoveEvalWidget b;
  Handler c = new OrderDetailActivity.5(this);
  private SwipeRefreshLayout d;
  private View e;
  private CardView f;
  private ImageView g;
  private TextView r;
  private CardView s;
  private ImageView t;
  private View u;
  private LinearLayout v;
  private MapView w = null;
  private CardView x;
  private View y;
  private CoordinatorLayout z;
  
  private void a()
  {
    this.d = ((SwipeRefreshLayout)findViewById(2131691758));
    this.d.setColorSchemeResources(new int[] { 2131624583 });
    this.d.setProgressBackgroundColorSchemeResource(2131624516);
    this.d.setEnabled(false);
    this.e = findViewById(2131694693);
    this.f = ((CardView)findViewById(2131694694));
    this.g = ((ImageView)findViewById(2131689492));
    this.r = ((TextView)findViewById(2131689541));
    this.s = ((CardView)findViewById(2131694695));
    this.t = ((ImageView)findViewById(2131690023));
    this.u = findViewById(2131694696);
    this.v = ((LinearLayout)findViewById(2131694688));
    this.x = ((CardView)findViewById(2131694689));
    this.y = findViewById(2131694690);
    this.z = ((CoordinatorLayout)findViewById(2131691761));
    this.A = findViewById(2131690815);
    this.B = ((SwipeRefreshLayout)findViewById(2131691760));
    this.B.setColorSchemeResources(new int[] { 2131624583 });
    this.B.setProgressBackgroundColorSchemeResource(2131624516);
    this.B.setEnabled(false);
    this.D = ((NestedScrollView)findViewById(2131691591));
    this.C = BottomSheetBehavior.from(this.D);
    this.E = ((CardView)findViewById(2131693377));
    this.F = ((RelativeLayout)findViewById(2131692103));
    this.A.setEnabled(this.ao);
    this.A.setClickable(this.ao);
    this.G = ((LinearLayout)findViewById(2131693378));
    this.H = ((TextView)findViewById(2131690024));
    this.I = ((TextView)findViewById(2131694692));
    this.J = ((TextView)findViewById(2131691840));
    this.K = ((LinearLayout)findViewById(2131694705));
    this.L = ((SimpleDraweeView)findViewById(2131694706));
    this.M = ((TextView)findViewById(2131690371));
    this.N = ((TextView)findViewById(2131694708));
    this.O = ((StarBar)findViewById(2131690000));
    this.P = ((ImageView)findViewById(2131694709));
    this.Q = ((LinearLayout)findViewById(2131693380));
    this.R = ((RelativeLayout)findViewById(2131694562));
    this.S = ((TextView)findViewById(2131694563));
    this.T = ((ImageView)findViewById(2131690327));
    this.U = ((RecyclerView)findViewById(2131694683));
    this.U.setLayoutManager(new LinearLayoutManager(getViewContext(), 1, false));
    this.V = ((TextView)findViewById(2131694684));
    this.W = ((LinearLayout)findViewById(2131693382));
    this.X = ((TextView)findViewById(2131694698));
    this.Y = ((TextView)findViewById(2131694699));
    this.Z = ((TextView)findViewById(2131694701));
    this.aa = ((TextView)findViewById(2131694703));
    this.ab = ((LinearLayout)findViewById(2131694337));
    this.ac = ((TextView)findViewById(2131694704));
    this.ad = ((LinearLayout)findViewById(2131693384));
    this.ae = ((TextView)findViewById(2131691497));
    this.af = ((ImageView)findViewById(2131694559));
    this.ag = ((ClipboardManager)getSystemService("clipboard"));
    this.ah = ((TextView)findViewById(2131694686));
    this.ai = ((RelativeLayout)findViewById(2131691965));
    this.aj = ((TextView)findViewById(2131694687));
    this.a = findViewById(2131690029);
    this.b = ((MoveEvalWidget)findViewById(2131690030));
    this.al = ((CardView)findViewById(2131689955));
    this.an = ((TextView)findViewById(2131689846));
    this.am = ((Button)findViewById(2131690461));
    this.as = ((TextView)findViewById(2131693965));
  }
  
  private void b()
  {
    this.f.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.am.setOnClickListener(this);
    this.D.getViewTreeObserver().addOnScrollChangedListener(new OrderDetailActivity.1(this));
    this.d.setOnRefreshListener(new OrderDetailActivity.6(this));
    this.B.setOnRefreshListener(new OrderDetailActivity.7(this));
    this.C.setBottomSheetCallback(new OrderDetailActivity.8(this));
    this.z.setOnTouchListener(new OrderDetailActivity.9(this));
    this.D.setOnTouchListener(new OrderDetailActivity.10(this));
  }
  
  private void e()
  {
    com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().clear();
    if (this.au == null) {
      this.au = new ArrayList();
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("拍照");
      localArrayList.add("相册选择");
      this.aq = new com.ziroom.ziroomcustomer.minsu.dialog.i(this.ar, new OrderDetailActivity.3(this), localArrayList);
      new Handler().postDelayed(new OrderDetailActivity.4(this), 250L);
      return;
      this.au.clear();
    }
  }
  
  private void f()
  {
    try
    {
      showProgressNoCancel("请稍后...", 5000L);
      Iterator localIterator = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (a.a)localIterator.next();
        localObject2 = new File(ad.getRealFilePath2(this.ar, Uri.parse(((a.a)localObject2).getOriginalUri())));
        if (((File)localObject2).exists()) {
          this.au.add(localObject2);
        }
      }
      if (this.au == null) {
        break label120;
      }
    }
    finally {}
    if (this.au.size() > 0) {
      this.c.sendEmptyMessage(0);
    }
    label120:
  }
  
  public void doneLoad()
  {
    this.B.setRefreshing(false);
    this.d.setRefreshing(false);
  }
  
  public BaseActivity getActivity()
  {
    return this;
  }
  
  public BaiduMap getBaiduMap()
  {
    return this.w.getMap();
  }
  
  public BottomSheetBehavior getBehavior()
  {
    return this.C;
  }
  
  public TextView getBtn()
  {
    return this.J;
  }
  
  public MoveEvalWidget getEvalWidgth()
  {
    return this.b;
  }
  
  public Intent getExtras()
  {
    return getIntent();
  }
  
  public ImageView getIvPull()
  {
    return this.T;
  }
  
  public MapView getMapView()
  {
    return this.w;
  }
  
  public RelativeLayout getRlPull()
  {
    return this.R;
  }
  
  public RecyclerView getRvChargeDetail()
  {
    return this.U;
  }
  
  public SwipeRefreshLayout getSrlRefreshView()
  {
    return this.B;
  }
  
  public TextView getTvPull()
  {
    return this.S;
  }
  
  public TextView getTvTitle()
  {
    return this.r;
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  public View getViewConver()
  {
    return this.a;
  }
  
  public View getViewCopy()
  {
    return this.af;
  }
  
  public TextView getmTvReminder()
  {
    return this.as;
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  public void mapResControl(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.w == null)
      {
        this.w = new MapView(getViewContext());
        this.w.getMap().getUiSettings().setRotateGesturesEnabled(false);
        this.w.getMap().setMyLocationEnabled(true);
        this.v.removeAllViews();
        this.v.addView(this.w, new LinearLayout.LayoutParams(-1, -1));
      }
      return;
    }
    this.v.removeAllViews();
    if (this.w != null)
    {
      this.w.getMap().setMyLocationEnabled(false);
      this.w.onDestroy();
    }
    this.w = null;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.ziroom.ziroomcustomer.payment.a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (!com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().isResultOk());
          com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().setResultOk(false);
          f();
          return;
          paramIntent = com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCameraImgPath();
        } while (TextUtils.isEmpty(paramIntent));
        localObject = new File(paramIntent);
      } while (!((File)localObject).exists());
      Object localObject = Uri.fromFile((File)localObject);
      a.a locala = new a.a();
      locala.setThumbnailUri(((Uri)localObject).toString());
      locala.setOriginalUri(((Uri)localObject).toString());
      locala.setOrientation(ad.getBitmapDegree(paramIntent));
      com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().getCheckedItems().add(locala);
      com.ziroom.ziroomcustomer.minsu.view.widget.a.getInstance().setResultOk(true);
      f();
      return;
    } while ((paramInt2 != -1) || (paramIntent == null) || (paramIntent.getSerializableExtra("photos") == null));
    paramIntent = (ArrayList)paramIntent.getSerializableExtra("photos");
    this.ap.clear();
    this.ap.addAll(paramIntent);
    this.b.setCameraAdaperData(this.ap);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      onBackPressed();
      return;
      com.ziroom.ziroomcustomer.newServiceList.utils.j.toChat(this);
      return;
      this.C.setHideable(true);
      this.C.setState(5);
      this.s.setVisibility(8);
      this.A.setVisibility(8);
      return;
      this.d.setRefreshing(true);
      this.ak.getData();
      return;
      paramView = new Intent(getViewContext(), OrderStateActivity.class);
      paramView.putExtra("orderId", this.ak.getOrderId());
      startActivity(paramView);
      return;
    } while ((this.ak == null) || (!(this.ak instanceof i)));
    ((i)this.ak).setPayOrpertion();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setContentView(2130903348);
    this.ar = this;
    org.greenrobot.eventbus.c.getDefault().register(this);
    registerReceiver(this.at, new IntentFilter("com.ziroom.ziroomcustomer.payresult"));
    com.ziroom.ziroomcustomer.minsu.view.widget.a.init(this.ar);
    a();
    b();
    new i(this);
    this.ak.start();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    org.greenrobot.eventbus.c.getDefault().unregister(this);
    unregisterReceiver(this.at);
    if (this.ak != null) {
      this.ak.destoryPollTask();
    }
    this.ak.detachView();
    mapResControl(false);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.ak.onKeyBack();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onMapClicked()
  {
    this.C.setState(4);
    this.C.setHideable(false);
    this.A.setVisibility(0);
    this.s.setVisibility(0);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.w != null) {
      this.w.onPause();
    }
    if (this.ak != null) {
      this.ak.stopPollTask(true);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.w != null) {
      this.w.onResume();
    }
    if (this.ak != null) {
      this.ak.stopPollTask(false);
    }
  }
  
  @org.greenrobot.eventbus.j(threadMode=ThreadMode.MAIN)
  public void onShowMessageEvent(com.ziroom.ziroomcustomer.newServiceList.utils.c paramc)
  {
    if ("move_small_button_refresh_detail".equals(paramc.getType())) {
      this.ak.getData();
    }
    if ("move_small_button_refresh_cancle".equals(paramc.getType())) {
      this.ak.getData();
    }
    if ("move_small_detail_refresh".equals(paramc.getType())) {
      this.ak.getData();
    }
    if ("move_detail_coupon_use_info".equals(paramc.getType())) {
      this.ak.useCouponBean(true, (ak)paramc.getData());
    }
    if ("move_detail_coupon_not_use".equals(paramc.getType())) {
      this.ak.useCouponBean(false, null);
    }
  }
  
  public void setEvalCamera(int paramInt)
  {
    if (paramInt >= this.ap.size())
    {
      e();
      return;
    }
    Intent localIntent = new Intent(this.ar, ScanCameraActivity.class);
    localIntent.putExtra("photos", (Serializable)this.ap);
    localIntent.putExtra("position", paramInt);
    startActivityForResult(localIntent, 3);
  }
  
  public void setPayContainerVisiable(boolean paramBoolean)
  {
    CardView localCardView = this.al;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localCardView.setVisibility(i);
      return;
    }
  }
  
  public void setPayMoney(String paramString)
  {
    this.an.setText(paramString);
  }
  
  public void setPresenter(h.a parama)
  {
    this.ak = parama;
  }
  
  public void showDetail(MovingVanDetail paramMovingVanDetail)
  {
    this.H.setText(paramMovingVanDetail.getLogTitle());
    Object localObject = paramMovingVanDetail.getLogContent();
    this.I.setTextColor(getResources().getColor(2131624042));
    String str;
    int i;
    boolean bool1;
    boolean bool2;
    if (paramMovingVanDetail.getOrderStatus() == 20)
    {
      str = paramMovingVanDetail.getPlanStartTime();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains(str)))
      {
        i = ((String)localObject).indexOf(str);
        int j = str.length();
        localObject = new SpannableString((CharSequence)localObject);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(getResources().getColor(2131624608)), i, j + i, 33);
        this.I.setText((CharSequence)localObject);
        this.aa.setText(paramMovingVanDetail.getOrderStartAddress());
        this.Z.setText(paramMovingVanDetail.getOrderEndAddress());
        bool1 = TextUtils.isEmpty(paramMovingVanDetail.getSpecialNeed());
        bool2 = TextUtils.isEmpty(paramMovingVanDetail.getUserMessage());
        str = "";
        if ((!bool1) || (!bool2)) {
          break label455;
        }
        this.ab.setVisibility(8);
        localObject = new DecimalFormat("######0.00");
        this.V.setText(((DecimalFormat)localObject).format(paramMovingVanDetail.getActualAllAmount().longValue() / 100.0D) + "元");
        setPayMoney(((DecimalFormat)localObject).format(paramMovingVanDetail.getActualAllAmount().longValue() / 100.0D));
        this.ae.setText(paramMovingVanDetail.getLogicCode());
        this.ah.setText(com.ziroom.ziroomcustomer.newServiceList.utils.i.getMin2Data(paramMovingVanDetail.getCreateTime()));
        if (paramMovingVanDetail.getSupplierEmployeeInfoVO() != null) {
          break label563;
        }
        this.K.setVisibility(8);
        label310:
        this.S.setText("展开");
        this.T.setBackgroundResource(2130839134);
        this.ak.chargeViewControl();
        if (TextUtils.isEmpty(paramMovingVanDetail.getAppointmentTimeStr())) {
          break label741;
        }
        this.X.setText(paramMovingVanDetail.getAppointmentTimeStr());
        label360:
        if (!TextUtils.isEmpty(paramMovingVanDetail.getConnectPhone())) {
          break label758;
        }
        this.Y.setText("");
      }
    }
    for (;;)
    {
      this.af.setOnClickListener(new OrderDetailActivity.12(this));
      this.ae.setOnLongClickListener(new OrderDetailActivity.13(this, paramMovingVanDetail));
      if (!TextUtils.isEmpty(paramMovingVanDetail.getPayType())) {
        break label772;
      }
      this.ai.setVisibility(8);
      return;
      this.I.setText((CharSequence)localObject);
      break;
      this.I.setText((CharSequence)localObject);
      break;
      label455:
      this.ab.setVisibility(0);
      if ((!bool1) && (!bool2)) {
        localObject = paramMovingVanDetail.getSpecialNeed() + " " + paramMovingVanDetail.getUserMessage();
      }
      for (;;)
      {
        this.ac.setText((CharSequence)localObject);
        break;
        if ((!bool1) && (bool2))
        {
          localObject = paramMovingVanDetail.getSpecialNeed();
        }
        else
        {
          localObject = str;
          if (bool1)
          {
            localObject = str;
            if (!bool2) {
              localObject = paramMovingVanDetail.getUserMessage();
            }
          }
        }
      }
      label563:
      if (!TextUtils.isEmpty(paramMovingVanDetail.getSupplierEmployeeInfoVO().getEmployeeCode())) {
        this.ak.setMoverId(paramMovingVanDetail.getSupplierEmployeeInfoVO().getEmployeeCode());
      }
      this.K.setVisibility(0);
      this.L.setController(com.freelxl.baselibrary.f.c.frescoController(paramMovingVanDetail.getSupplierEmployeeInfoVO().getHeadPicture()));
      this.M.setText(paramMovingVanDetail.getSupplierEmployeeInfoVO().getTrueName());
      i = (int)Double.valueOf(paramMovingVanDetail.getSupplierEmployeeInfoVO().getEvaluateScore()).doubleValue();
      this.O.setStarMark(i);
      this.N.setText(paramMovingVanDetail.getSupplierEmployeeInfoVO().getTotalOrderCount() + "单");
      if (TextUtils.isEmpty(paramMovingVanDetail.getSupplierEmployeeInfoVO().getContactWay()))
      {
        this.P.setVisibility(8);
        break label310;
      }
      this.P.setVisibility(0);
      this.P.setOnClickListener(new OrderDetailActivity.11(this, paramMovingVanDetail));
      break label310;
      label741:
      this.X.setText(com.ziroom.ziroomcustomer.newServiceList.utils.i.getMin2Data(paramMovingVanDetail.getAppointmentTime()));
      break label360;
      label758:
      this.Y.setText(paramMovingVanDetail.getConnectPhone());
    }
    label772:
    this.ai.setVisibility(0);
    this.aj.setText(paramMovingVanDetail.getPayType());
  }
  
  public void switchBehaviorByMapStatus()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.E.getLayoutParams();
    if (this.ak.getIsShowMap() == 0)
    {
      this.C.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
      this.C.setState(4);
      this.ak.setTempState(4);
      this.C.setHideable(false);
      this.e.setAlpha(1.0F);
      this.A.setAlpha(1.0F);
      this.r.setAlpha(1.0F);
      this.u.setAlpha(1.0F);
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
      this.E.setLayoutParams(localLayoutParams);
      this.E.setRadius(0.0F);
    }
    for (;;)
    {
      this.ao = true;
      this.A.setEnabled(this.ao);
      this.A.setClickable(this.ao);
      do
      {
        return;
      } while (this.C.getState() == 5);
      this.e.setAlpha(0.0F);
      this.A.setAlpha(0.0F);
      this.r.setAlpha(0.0F);
      this.u.setAlpha(0.0F);
      this.C.setPeekHeight(n.dip2px(getViewContext(), 206.0F));
      this.C.setState(4);
      this.ak.setTempState(4);
      this.C.setHideable(false);
      localLayoutParams.leftMargin = n.dip2px(getViewContext(), 12.0F);
      localLayoutParams.rightMargin = n.dip2px(getViewContext(), 12.0F);
      this.E.setLayoutParams(localLayoutParams);
      this.E.setRadius(n.dip2px(getViewContext(), 4.0F));
    }
  }
  
  public void switchRefrushAbledByBehaviorStatusAndMapStatus()
  {
    if (this.ak.getIsShowMap() == 0)
    {
      this.d.setEnabled(false);
      if ((this.D != null) && (this.D.getScrollY() == 0))
      {
        this.B.setEnabled(true);
        return;
      }
      this.B.setEnabled(false);
      return;
    }
    this.B.setEnabled(false);
    if (this.C.getState() == 4)
    {
      this.d.setEnabled(true);
      return;
    }
    this.d.setEnabled(false);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/OrderDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */