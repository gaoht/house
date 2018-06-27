package com.ziroom.ziroomcustomer.ziroomstation;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.ziroomstation.a.a;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.IntoCashPledgeDetailsPop;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoSchemeModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoSchemeModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoSchemeModel.DataBean.HtListBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoSchemeModel.DataBean.HtListBean.ShemeListBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoSelectedInfos;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoSelectedInfos.RoomBedInfos;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoSelectedPeopleModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoToPayResultModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoToPayResultModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.widget.FlowLayout;
import com.ziroom.ziroomcustomer.ziroomstation.widget.IntoTagTextView;
import com.ziroom.ziroomcustomer.ziroomstation.widget.IntoTitleTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IntoDealMainActivity
  extends BaseActivity
{
  private IntoSchemeModel A;
  private IntoSelectedPeopleModel B;
  private IntoToPayResultModel C;
  private int D = 0;
  private com.ziroom.ziroomcustomer.ziroomstation.dialog.b E;
  private IntoSelectedInfos F = new IntoSelectedInfos();
  private List<IntoSelectedInfos.RoomBedInfos> G = new ArrayList();
  private List<IntoSelectedInfos.RoomBedInfos> H = new ArrayList();
  private IntoSchemeModel.DataBean.HtListBean I;
  private IntoSchemeModel.DataBean.HtListBean J;
  private IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean K;
  private int L;
  private int M;
  private int N = 0;
  private int O = 0;
  private String P = "";
  private int Q = 8;
  private int R = 0;
  private int S = 0;
  private int T = 0;
  private int U = 0;
  private int V = 0;
  private int W = 0;
  private int X = 0;
  private int Y = 3;
  private int Z = 5;
  private Unbinder a;
  private boolean aa = true;
  private int ab;
  private BroadcastReceiver ac = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("code", 1000) == 0)
      {
        paramAnonymousContext = new Intent(IntoDealMainActivity.this, IntoPaySuccessActivity.class);
        paramAnonymousContext.putExtra("orderBid", IntoDealMainActivity.a(IntoDealMainActivity.this).data.orderBid);
        IntoDealMainActivity.this.startActivity(paramAnonymousContext);
        IntoDealMainActivity.this.finish();
        return;
      }
      af.showToast(IntoDealMainActivity.this, "支付押金失败!");
    }
  };
  private AlertDialog ad;
  private String b = "IntoDealMainActivity";
  @BindView(2131690078)
  ImageView btnBack;
  @BindView(2131692802)
  Button btnPayNow;
  private int c = 14;
  private int d = 14;
  private int e = 40960;
  private int f = -12303292;
  private int[] g;
  @BindView(2131690093)
  HorizontalScrollView hScrollView;
  @BindView(2131692793)
  HorizontalScrollView hsvRoomBedsMap;
  @BindView(2131692801)
  ImageView ivCashPledgeRightIcon;
  @BindView(2131692797)
  ImageView ivRoomMap12;
  @BindView(2131692795)
  ImageView ivRoomMap8;
  @BindView(2131692798)
  LinearLayout llBtnsAtBotton;
  @BindView(2131692792)
  LinearLayout llTabsViewGroup;
  private int[] r;
  @BindView(2131692535)
  LinearLayout rlPricesDetails;
  @BindView(2131692796)
  RelativeLayout rlRoomMap12;
  @BindView(2131692794)
  RelativeLayout rlRoomMap8;
  private int[] s;
  private int[] t;
  @BindView(2131692800)
  TextView tvCashPledgeTotal;
  @BindView(2131692791)
  TextView tvRenewBatch;
  @BindView(2131689541)
  TextView tvTitle;
  private int u = -1;
  private int v = 4;
  private int w;
  private List<IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean> x = new ArrayList();
  private String y = "2932bb7312364ea29437fe6dad11eed1";
  private boolean z = false;
  
  private void a()
  {
    this.ab = getWindowManager().getDefaultDisplay().getWidth();
    this.g = getResources().getIntArray(2131361826);
    this.r = getResources().getIntArray(2131361827);
    this.s = getResources().getIntArray(2131361824);
    this.t = getResources().getIntArray(2131361825);
    this.F.selectedBedInfos = new ArrayList();
    m();
    IntentFilter localIntentFilter = new IntentFilter("com.ziroom.ziroomcustomer.activity_1");
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.activity_2");
    registerReceiver(this.ac, localIntentFilter);
  }
  
  private void a(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    this.hsvRoomBedsMap.post(new Runnable()
    {
      int a = paramInt2 - paramInt1;
      int b = (int)((paramInt2 - paramInt1) * 1.5D / (paramInt3 * 1000 / 20));
      
      public void run()
      {
        new CountDownTimer((paramInt3 + 1) * 1000, 20L)
        {
          long a = 0L;
          
          public void onFinish() {}
          
          public void onTick(long paramAnonymous2Long)
          {
            if ((IntoDealMainActivity.this.hsvRoomBedsMap != null) && ((this.a == 0L) || (IntoDealMainActivity.5.this.a <= (IntoDealMainActivity.5.this.c - IntoDealMainActivity.5.this.d) / 2))) {
              IntoDealMainActivity.this.hsvRoomBedsMap.scrollTo(IntoDealMainActivity.5.this.a, 0);
            }
            if (IntoDealMainActivity.5.this.a <= 0) {
              this.a = paramAnonymous2Long;
            }
            if (this.a == 0L)
            {
              IntoDealMainActivity.5.this.a -= IntoDealMainActivity.5.this.b;
              return;
            }
            IntoDealMainActivity.5.this.a += IntoDealMainActivity.5.this.b;
          }
        }.start();
      }
    });
  }
  
  private void a(View paramView, final IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean paramBedListBean)
  {
    switch (paramBedListBean.isUseAble)
    {
    default: 
      return;
    case 0: 
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          w.onEventToZiroomAndUmeng("zinn_ol_choose");
          IntoDealMainActivity.a(IntoDealMainActivity.this, paramBedListBean);
          if (IntoDealMainActivity.b(IntoDealMainActivity.this) == 8)
          {
            if (IntoDealMainActivity.t(IntoDealMainActivity.this) >= IntoDealMainActivity.u(IntoDealMainActivity.this))
            {
              if (IntoDealMainActivity.v(IntoDealMainActivity.this) >= IntoDealMainActivity.w(IntoDealMainActivity.this))
              {
                af.showToast(IntoDealMainActivity.this, IntoDealMainActivity.this.getResources().getString(2131297555));
                return;
              }
              af.showToast(IntoDealMainActivity.this, IntoDealMainActivity.this.getResources().getString(2131297556));
            }
          }
          else if (IntoDealMainActivity.v(IntoDealMainActivity.this) >= IntoDealMainActivity.w(IntoDealMainActivity.this))
          {
            if (IntoDealMainActivity.t(IntoDealMainActivity.this) >= IntoDealMainActivity.u(IntoDealMainActivity.this))
            {
              af.showToast(IntoDealMainActivity.this, IntoDealMainActivity.this.getResources().getString(2131297555));
              return;
            }
            af.showToast(IntoDealMainActivity.this, IntoDealMainActivity.this.getResources().getString(2131297554));
            return;
          }
          paramAnonymousView = new Intent(IntoDealMainActivity.this, IntoFillBedInfoActivity.class);
          paramAnonymousView.putExtra("roomName", IntoDealMainActivity.x(IntoDealMainActivity.this));
          paramAnonymousView.putExtra("orderBid", IntoDealMainActivity.q(IntoDealMainActivity.this).data.orderBid);
          if (IntoDealMainActivity.b(IntoDealMainActivity.this) == 8)
          {
            paramAnonymousView.putExtra("houseTypeBid", IntoDealMainActivity.d(IntoDealMainActivity.this).htBid);
            paramAnonymousView.putExtra("areaBid", ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)IntoDealMainActivity.d(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.c(IntoDealMainActivity.this))).get(IntoDealMainActivity.n(IntoDealMainActivity.this))).roomBid);
          }
          for (;;)
          {
            paramAnonymousView.putExtra("startDate", IntoDealMainActivity.q(IntoDealMainActivity.this).data.startDate);
            paramAnonymousView.putExtra("endDate", IntoDealMainActivity.q(IntoDealMainActivity.this).data.endDate);
            paramAnonymousView.putExtra("areaBedBid", paramBedListBean.bedBid);
            IntoDealMainActivity.this.startActivityForResult(paramAnonymousView, 4097);
            return;
            paramAnonymousView.putExtra("houseTypeBid", IntoDealMainActivity.h(IntoDealMainActivity.this).htBid);
            paramAnonymousView.putExtra("areaBid", ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)IntoDealMainActivity.h(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.g(IntoDealMainActivity.this))).get(IntoDealMainActivity.n(IntoDealMainActivity.this) - IntoDealMainActivity.k(IntoDealMainActivity.this))).roomBid);
          }
        }
      });
      return;
    case 1: 
      w.onEventToZiroomAndUmeng("zinn_ol_nei");
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          IntoDealMainActivity.b(IntoDealMainActivity.this, paramBedListBean);
        }
      });
      return;
    }
    paramView.setClickable(false);
  }
  
  private void a(IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean paramBedListBean)
  {
    View localView1 = LayoutInflater.from(this).inflate(2130903853, null);
    TextView localTextView = (TextView)localView1.findViewById(2131693882);
    Object localObject = localView1.findViewById(2131691363);
    View localView2 = localView1.findViewById(2131693883);
    FlowLayout localFlowLayout = (FlowLayout)localView1.findViewById(2131693884);
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        IntoDealMainActivity.B(IntoDealMainActivity.this).dismiss();
      }
    });
    localObject = paramBedListBean.label;
    if (1 == paramBedListBean.isDefaultLabel) {
      if ((localObject != null) && (localObject.length > 0))
      {
        localTextView.setText(localObject[0]);
        localView2.setVisibility(0);
        localFlowLayout.setVisibility(8);
        label112:
        this.ad = new AlertDialog.Builder(this, 2131427592).create();
        paramBedListBean = this.ad;
        if ((paramBedListBean instanceof AlertDialog)) {
          break label234;
        }
        paramBedListBean.show();
      }
    }
    for (;;)
    {
      this.ad.setCanceledOnTouchOutside(false);
      this.ad.getWindow().setContentView(localView1);
      return;
      localTextView.setText("神秘的室友~");
      break;
      localTextView.setText(paramBedListBean.bedCode + "床 " + paramBedListBean.sex);
      localView2.setVisibility(8);
      localFlowLayout.setVisibility(0);
      a((String[])localObject, localFlowLayout);
      break label112;
      label234:
      VdsAgent.showDialog((AlertDialog)paramBedListBean);
    }
  }
  
  private void a(String paramString, IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean paramBedListBean)
  {
    if (this.Q == 8)
    {
      a(this.G, paramString, paramBedListBean);
      return;
    }
    a(this.H, paramString, paramBedListBean);
  }
  
  private void a(List<IntoSelectedInfos.RoomBedInfos> paramList, String paramString, IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean paramBedListBean)
  {
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      IntoSelectedInfos.RoomBedInfos localRoomBedInfos = (IntoSelectedInfos.RoomBedInfos)((Iterator)localObject).next();
      if (paramString.equals(localRoomBedInfos.roomName))
      {
        if (localRoomBedInfos.beds == null) {
          localRoomBedInfos.beds = new ArrayList();
        }
        localRoomBedInfos.beds.add(paramBedListBean.bedCode + "床");
        return;
      }
    }
    localObject = new IntoSelectedInfos.RoomBedInfos();
    ((IntoSelectedInfos.RoomBedInfos)localObject).roomName = paramString;
    ((IntoSelectedInfos.RoomBedInfos)localObject).beds = new ArrayList();
    ((IntoSelectedInfos.RoomBedInfos)localObject).beds.add(paramBedListBean.bedCode + "床");
    paramList.add(localObject);
  }
  
  private void a(String[] paramArrayOfString, FlowLayout paramFlowLayout)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return;
    }
    paramFlowLayout.removeAllViews();
    int j = paramArrayOfString.length;
    int i = 0;
    label20:
    Object localObject;
    if (i < j)
    {
      localObject = paramArrayOfString[i];
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label46;
      }
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label46:
      IntoTagTextView localIntoTagTextView = new IntoTagTextView(this);
      localIntoTagTextView.setTagBean((String)localObject);
      localIntoTagTextView.setGravity(16);
      localIntoTagTextView.setTextAppearance(this, 2131427970);
      localIntoTagTextView.setBackgroundResource(2130837905);
      localObject = new ViewGroup.MarginLayoutParams(-2, n.dip2px(this, 26.0F));
      int k = n.dip2px(this, 3.0F);
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(k, 0, k, 0);
      localIntoTagTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      k = n.dip2px(this, 6.0F);
      localIntoTagTextView.setPadding(k, 0, k, 0);
      paramFlowLayout.addView(localIntoTagTextView);
      paramFlowLayout.requestLayout();
    }
  }
  
  private void b()
  {
    this.y = getIntent().getStringExtra("orderBid");
    this.z = getIntent().getBooleanExtra("showMode", false);
    if (this.z)
    {
      this.llBtnsAtBotton.setVisibility(8);
      this.tvRenewBatch.setVisibility(8);
      this.tvTitle.setText("已选床位信息");
      if (checkNet(this))
      {
        localMap = com.ziroom.ziroomcustomer.ziroomstation.b.b.buildIntoScheme(this, this.y);
        com.ziroom.ziroomcustomer.ziroomstation.b.c.intoGetSelectedBeds(this, new d(null), localMap, true);
      }
    }
    do
    {
      return;
      this.llBtnsAtBotton.setVisibility(0);
      this.tvRenewBatch.setVisibility(0);
      this.tvTitle.setText("办理入住");
    } while (!checkNet(this));
    Map localMap = com.ziroom.ziroomcustomer.ziroomstation.b.b.buildIntoScheme(this, this.y);
    com.ziroom.ziroomcustomer.ziroomstation.b.c.intoScheme(this, new c(null), localMap, true);
  }
  
  private void b(int paramInt)
  {
    int n = 0;
    this.llTabsViewGroup.measure(this.llTabsViewGroup.getMeasuredWidth(), -1);
    Object localObject = new FrameLayout.LayoutParams(this.llTabsViewGroup.getMeasuredWidth(), -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.llTabsViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int k = 0;
    int i = 0;
    int j = 0;
    int m;
    if (k < this.llTabsViewGroup.getChildCount())
    {
      localObject = (IntoTitleTextView)this.llTabsViewGroup.getChildAt(k);
      int i1 = ((IntoTitleTextView)localObject).getMeasuredWidth();
      m = j;
      if (k < paramInt) {
        m = j + i1;
      }
      i += i1;
      if (paramInt != k)
      {
        ((IntoTitleTextView)localObject).setTextColor(-16777216);
        ((IntoTitleTextView)localObject).setTextSize(this.c);
        ((IntoTitleTextView)localObject).setIsHorizontaline(false);
      }
      for (;;)
      {
        k += 1;
        j = m;
        break;
        ((IntoTitleTextView)localObject).setTextColor(this.e);
        ((IntoTitleTextView)localObject).setTextSize(this.d);
        ((IntoTitleTextView)localObject).setIsHorizontaline(true);
      }
    }
    if (paramInt == 0)
    {
      if ((this.u == -1) && (this.llTabsViewGroup != null) && (this.llTabsViewGroup.getChildCount() > paramInt) && (this.llTabsViewGroup.getChildAt(paramInt) != null)) {
        this.u = this.llTabsViewGroup.getChildAt(paramInt).getMeasuredWidth();
      }
      k = n;
      if (paramInt > 0)
      {
        if (paramInt != this.llTabsViewGroup.getChildCount() - 1) {
          break label347;
        }
        k = n;
      }
      label262:
      m = getWindowManager().getDefaultDisplay().getWidth();
      n = j - this.u * 2;
      if (this.w >= paramInt) {
        break label365;
      }
      if (k + (this.u + j) >= m / 2) {
        ((HorizontalScrollView)this.llTabsViewGroup.getParent()).setScrollX(n);
      }
    }
    for (;;)
    {
      this.w = paramInt;
      return;
      if (paramInt != this.llTabsViewGroup.getChildCount() - 1) {
        break;
      }
      break;
      label347:
      k = this.llTabsViewGroup.getChildAt(paramInt - 1).getMeasuredWidth();
      break label262;
      label365:
      if (i - j >= m / 2) {
        ((HorizontalScrollView)this.llTabsViewGroup.getParent()).setScrollX(n);
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    View localView = new View(this);
    if (paramInt3 < 4) {
      switch (((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3)).isUseAble)
      {
      }
    }
    for (;;)
    {
      a(localView, (IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3));
      this.rlRoomMap8.addView(localView, localLayoutParams);
      return;
      localView = getLayoutInflater().inflate(2130905049, null);
      localLayoutParams.topMargin = (this.r[paramInt3] * paramInt2 / 100 - n.dip2px(this, 16.0F));
      localLayoutParams.leftMargin = (this.g[paramInt3] * paramInt1 / 100 - n.dip2px(this, 11.0F));
      updateAvailableBedInfo(localView, (IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3));
      if (this.z)
      {
        localView.setVisibility(8);
      }
      else
      {
        localView.setVisibility(0);
        continue;
        localView = getLayoutInflater().inflate(2130905051, null);
        localLayoutParams.topMargin = (this.r[paramInt3] * paramInt2 / 100 - n.dip2px(this, 19.0F));
        localLayoutParams.leftMargin = (this.g[paramInt3] * paramInt1 / 100 - n.dip2px(this, 11.0F));
        updateUnAvailableBedInfo(localView, (IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3));
        if (ae.isNull(((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3)).sex))
        {
          localView.setVisibility(8);
        }
        else
        {
          localView.setVisibility(0);
          continue;
          localView = getLayoutInflater().inflate(2130905053, null);
          localLayoutParams.topMargin = (this.r[paramInt3] * paramInt2 / 100 - n.dip2px(this, 19.0F));
          localLayoutParams.leftMargin = (this.g[paramInt3] * paramInt1 / 100 - n.dip2px(this, 11.0F));
          updateSelectedBedInfo(localView, (IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3));
          continue;
          switch (((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3)).isUseAble)
          {
          default: 
            break;
          case 0: 
            localView = getLayoutInflater().inflate(2130905050, null);
            localLayoutParams.topMargin = (this.r[paramInt3] * paramInt2 / 100 - n.dip2px(this, 16.0F));
            localLayoutParams.leftMargin = (this.g[paramInt3] * paramInt1 / 100 - n.dip2px(this, 71.0F));
            updateAvailableBedInfo(localView, (IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3));
            if (this.z) {
              localView.setVisibility(8);
            } else {
              localView.setVisibility(0);
            }
            break;
          case 1: 
            localView = getLayoutInflater().inflate(2130905052, null);
            localLayoutParams.topMargin = (this.r[paramInt3] * paramInt2 / 100 - n.dip2px(this, 19.0F));
            localLayoutParams.leftMargin = (this.g[paramInt3] * paramInt1 / 100 - n.dip2px(this, 76.0F));
            updateUnAvailableBedInfo(localView, (IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3));
            if (ae.isNull(((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3)).sex)) {
              localView.setVisibility(8);
            } else {
              localView.setVisibility(0);
            }
            break;
          case 2: 
            localView = getLayoutInflater().inflate(2130905054, null);
            localLayoutParams.topMargin = (this.r[paramInt3] * paramInt2 / 100 - n.dip2px(this, 19.0F));
            localLayoutParams.leftMargin = (this.g[paramInt3] * paramInt1 / 100 - n.dip2px(this, 70.0F));
            updateSelectedBedInfo(localView, (IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3));
          }
        }
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    View localView = new View(this);
    if ((paramInt3 < 4) || (paramInt3 == 8) || (paramInt3 == 9)) {
      switch (((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3)).isUseAble)
      {
      }
    }
    for (;;)
    {
      a(localView, (IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3));
      this.rlRoomMap12.addView(localView, localLayoutParams);
      return;
      localView = getLayoutInflater().inflate(2130905049, null);
      localLayoutParams.topMargin = (this.t[paramInt3] * paramInt2 / 100 - n.dip2px(this, 16.0F));
      localLayoutParams.leftMargin = (this.s[paramInt3] * paramInt1 / 100 - n.dip2px(this, 11.0F));
      updateAvailableBedInfo(localView, (IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3));
      if (this.z)
      {
        localView.setVisibility(8);
      }
      else
      {
        localView.setVisibility(0);
        continue;
        localView = getLayoutInflater().inflate(2130905051, null);
        localLayoutParams.topMargin = (this.t[paramInt3] * paramInt2 / 100 - n.dip2px(this, 19.0F));
        localLayoutParams.leftMargin = (this.s[paramInt3] * paramInt1 / 100 - n.dip2px(this, 11.0F));
        updateUnAvailableBedInfo(localView, (IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3));
        if (ae.isNull(((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3)).sex))
        {
          localView.setVisibility(8);
        }
        else
        {
          localView.setVisibility(0);
          continue;
          localView = getLayoutInflater().inflate(2130905053, null);
          localLayoutParams.topMargin = (this.t[paramInt3] * paramInt2 / 100 - n.dip2px(this, 19.0F));
          localLayoutParams.leftMargin = (this.s[paramInt3] * paramInt1 / 100 - n.dip2px(this, 11.0F));
          updateSelectedBedInfo(localView, (IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3));
          continue;
          switch (((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3)).isUseAble)
          {
          default: 
            break;
          case 0: 
            localView = getLayoutInflater().inflate(2130905050, null);
            localLayoutParams.topMargin = (this.t[paramInt3] * paramInt2 / 100 - n.dip2px(this, 16.0F));
            localLayoutParams.leftMargin = (this.s[paramInt3] * paramInt1 / 100 - n.dip2px(this, 71.0F));
            updateAvailableBedInfo(localView, (IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3));
            if (this.z) {
              localView.setVisibility(8);
            } else {
              localView.setVisibility(0);
            }
            break;
          case 1: 
            localView = getLayoutInflater().inflate(2130905052, null);
            localLayoutParams.topMargin = (this.t[paramInt3] * paramInt2 / 100 - n.dip2px(this, 19.0F));
            localLayoutParams.leftMargin = (this.s[paramInt3] * paramInt1 / 100 - n.dip2px(this, 76.0F));
            updateUnAvailableBedInfo(localView, (IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3));
            if (ae.isNull(((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3)).sex)) {
              localView.setVisibility(8);
            } else {
              localView.setVisibility(0);
            }
            break;
          case 2: 
            localView = getLayoutInflater().inflate(2130905054, null);
            localLayoutParams.topMargin = (this.t[paramInt3] * paramInt2 / 100 - n.dip2px(this, 19.0F));
            localLayoutParams.leftMargin = (this.s[paramInt3] * paramInt1 / 100 - n.dip2px(this, 70.0F));
            updateSelectedBedInfo(localView, (IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)this.x.get(paramInt3));
          }
        }
      }
    }
  }
  
  private void e()
  {
    int i;
    if (this.z)
    {
      i = 0;
      if (i < this.B.data.size())
      {
        if (((IntoSchemeModel.DataBean.HtListBean)this.B.data.get(i)).htShowName.contains("12"))
        {
          this.J = ((IntoSchemeModel.DataBean.HtListBean)this.B.data.get(i));
          this.T = this.J.bedCount;
          this.V = this.J.depositAmount;
        }
        for (;;)
        {
          i += 1;
          break;
          this.I = ((IntoSchemeModel.DataBean.HtListBean)this.B.data.get(i));
          this.S = this.I.bedCount;
          this.U = this.I.depositAmount;
        }
      }
    }
    else
    {
      i = 0;
      if (i < this.A.data.htList.size())
      {
        if (((IntoSchemeModel.DataBean.HtListBean)this.A.data.htList.get(i)).htShowName.contains("12"))
        {
          this.J = ((IntoSchemeModel.DataBean.HtListBean)this.A.data.htList.get(i));
          this.T = this.J.bedCount;
          this.V = this.J.depositAmount;
        }
        for (;;)
        {
          i += 1;
          break;
          this.I = ((IntoSchemeModel.DataBean.HtListBean)this.A.data.htList.get(i));
          this.S = this.I.bedCount;
          this.U = this.I.depositAmount;
        }
      }
    }
    this.L = 0;
    this.M = 0;
    this.O = 0;
    if (this.I != null) {}
    for (this.Q = 8;; this.Q = 12)
    {
      f();
      return;
    }
  }
  
  private void f()
  {
    int i;
    if (this.I != null)
    {
      this.R = ((List)this.I.shemeList.get(this.L)).size();
      if (this.J != null)
      {
        i = this.R;
        this.N = (((List)this.J.shemeList.get(this.M)).size() + i);
        if (this.Q != 8) {
          break label251;
        }
        this.P = (this.I.htShowName + ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)this.I.shemeList.get(this.L)).get(this.O)).roomName);
        label147:
        if (this.N > 0) {
          if (this.N >= 4) {
            break label320;
          }
        }
      }
    }
    label251:
    label320:
    for (this.v = this.N;; this.v = 4)
    {
      l();
      g();
      return;
      this.N = this.R;
      break;
      this.R = 0;
      if (this.J != null)
      {
        i = this.R;
        this.N = (((List)this.J.shemeList.get(this.M)).size() + i);
        break;
      }
      this.N = this.R;
      break;
      this.P = (this.J.htShowName + ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)this.J.shemeList.get(this.M)).get(this.O - this.R)).roomName);
      break label147;
    }
  }
  
  private void g()
  {
    if (this.O < this.R) {
      if ((this.I != null) && (this.I.shemeList != null) && (this.I.shemeList.size() > this.L) && (this.I.shemeList.get(this.L) != null) && (((List)this.I.shemeList.get(this.L)).get(this.O) != null)) {
        this.x = ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)this.I.shemeList.get(this.L)).get(this.O)).bedList;
      }
    }
    for (this.Q = 8;; this.Q = 12)
    {
      do
      {
        switch (this.Q)
        {
        default: 
          return;
        }
      } while ((this.J == null) || (this.J.shemeList == null) || (this.J.shemeList.size() <= this.M) || (this.J.shemeList.get(this.M) == null) || (((List)this.J.shemeList.get(this.M)).get(this.O - this.R) == null));
      this.x = ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)this.J.shemeList.get(this.M)).get(this.O - this.R)).bedList;
    }
    h();
    return;
    i();
  }
  
  private void h()
  {
    this.rlRoomMap8.setVisibility(0);
    this.rlRoomMap12.setVisibility(8);
    this.ivRoomMap8.post(new Runnable()
    {
      public void run()
      {
        IntoDealMainActivity.r(IntoDealMainActivity.this);
      }
    });
  }
  
  private void i()
  {
    this.rlRoomMap8.setVisibility(8);
    this.rlRoomMap12.setVisibility(0);
    this.ivRoomMap12.post(new Runnable()
    {
      public void run()
      {
        IntoDealMainActivity.s(IntoDealMainActivity.this);
      }
    });
  }
  
  private void j()
  {
    int j = this.ivRoomMap8.getMeasuredWidth();
    int k = this.ivRoomMap8.getMeasuredHeight();
    this.rlRoomMap8.removeViews(1, this.rlRoomMap8.getChildCount() - 1);
    int i = 0;
    while (i < this.x.size())
    {
      if (i < 8) {
        b(j, k, i);
      }
      i += 1;
    }
    if (this.aa)
    {
      this.aa = false;
      a(this.ab, j, this.Y);
    }
  }
  
  private void k()
  {
    int j = this.ivRoomMap12.getMeasuredWidth();
    int k = this.ivRoomMap12.getMeasuredHeight();
    this.rlRoomMap12.removeViews(1, this.rlRoomMap12.getChildCount() - 1);
    int i = 0;
    while (i < this.x.size())
    {
      if (i < 12) {
        c(j, k, i);
      }
      i += 1;
    }
    if (this.aa)
    {
      this.aa = false;
      a(this.ab, j, this.Z);
    }
  }
  
  private void l()
  {
    if (this.N > 0)
    {
      this.llTabsViewGroup.removeAllViews();
      int i = 0;
      if (i < this.N)
      {
        String str;
        label87:
        IntoTitleTextView localIntoTitleTextView;
        if (i < this.R)
        {
          str = this.I.htShowName + ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)this.I.shemeList.get(this.L)).get(i)).roomName;
          localIntoTitleTextView = new IntoTitleTextView(this);
          this.u = (this.ab / this.v);
          localIntoTitleTextView.setLayoutParams(new LinearLayout.LayoutParams(this.u, -1));
          localIntoTitleTextView.setTextSize(this.c);
          localIntoTitleTextView.setText(str);
          localIntoTitleTextView.setGravity(17);
          localIntoTitleTextView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              int i = 0;
              for (;;)
              {
                if (i < IntoDealMainActivity.this.llTabsViewGroup.getChildCount())
                {
                  IntoTitleTextView localIntoTitleTextView = (IntoTitleTextView)IntoDealMainActivity.this.llTabsViewGroup.getChildAt(i);
                  if (localIntoTitleTextView == paramAnonymousView)
                  {
                    IntoDealMainActivity.g(IntoDealMainActivity.this, i);
                    IntoDealMainActivity.c(IntoDealMainActivity.this, i);
                    IntoDealMainActivity.a(IntoDealMainActivity.this, localIntoTitleTextView.getText().toString().trim());
                    IntoDealMainActivity.y(IntoDealMainActivity.this);
                  }
                }
                else
                {
                  return;
                }
                i += 1;
              }
            }
          });
          if (i != 0) {
            break label274;
          }
          localIntoTitleTextView.setTextColor(this.e);
          localIntoTitleTextView.setTextSize(this.d);
          localIntoTitleTextView.setIsHorizontaline(true);
        }
        for (;;)
        {
          localIntoTitleTextView.setIsVerticalLine(false);
          localIntoTitleTextView.setHorizontalineColor(this.e);
          this.llTabsViewGroup.addView(localIntoTitleTextView);
          i += 1;
          break;
          str = this.J.htShowName + ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)this.J.shemeList.get(this.M)).get(i - this.R)).roomName;
          break label87;
          label274:
          localIntoTitleTextView.setTextColor(this.f);
          localIntoTitleTextView.setTextSize(this.c);
          localIntoTitleTextView.setIsHorizontaline(false);
        }
      }
    }
  }
  
  private void m()
  {
    this.D = (this.U * this.W + this.V * this.X);
    this.tvCashPledgeTotal.setText(this.D + "");
    if (this.D > 0)
    {
      this.rlPricesDetails.setClickable(true);
      this.ivCashPledgeRightIcon.setVisibility(0);
      if ((this.W == this.S) && (this.X == this.T))
      {
        this.btnPayNow.setClickable(true);
        this.btnPayNow.setBackgroundResource(2130838050);
        return;
      }
      this.btnPayNow.setClickable(false);
      this.btnPayNow.setBackgroundResource(2130838051);
      return;
    }
    this.rlPricesDetails.setClickable(false);
    this.ivCashPledgeRightIcon.setVisibility(4);
    this.btnPayNow.setClickable(false);
    this.btnPayNow.setBackgroundResource(2130838051);
  }
  
  private void n()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this).setTitle("提示").setContent(getResources().getString(2131297557)).setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          w.onEventToZiroomAndUmeng("zinn_ol_out_y");
          IntoDealMainActivity.this.finish();
          return;
        }
        w.onEventToZiroomAndUmeng("zinn_ol_out_n");
      }
    }).build().show();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((4097 == paramInt1) && (8 == paramInt2))
    {
      if (this.Q != 8) {
        break label84;
      }
      this.W += 1;
    }
    for (;;)
    {
      a(this.P, this.K);
      m();
      paramIntent = paramIntent.getStringExtra("name");
      this.K.isUseAble = 2;
      this.K.name = paramIntent;
      g();
      return;
      label84:
      this.X += 1;
    }
  }
  
  @OnClick({2131690078, 2131692535, 2131692802, 2131692791})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690078: 
      w.onEventToZiroomAndUmeng("zinn_ol_out");
      if (this.z)
      {
        finish();
        return;
      }
      n();
      return;
    case 2131692535: 
      w.onEventToZiroomAndUmeng("zinn_ol_chose");
      this.F.bedSingleCash = this.U;
      this.F.cashTotal = this.D;
      this.F.timeString = getIntent().getStringExtra("timeString");
      this.F.personNum = (this.W + this.X);
      this.F.selectedBedInfos.removeAll(this.F.selectedBedInfos);
      this.F.selectedBedInfos.addAll(this.G);
      this.F.selectedBedInfos.addAll(this.H);
      new IntoCashPledgeDetailsPop(this, this.F, new a()
      {
        public void callback(int paramAnonymousInt) {}
      }).showPriceWindow();
      return;
    case 2131692791: 
      w.onEventToZiroomAndUmeng("zinn_ol_change");
      paramView = "";
      if (this.Q == 8) {
        if (this.I != null) {
          paramView = this.I.htBid;
        }
      }
      for (;;)
      {
        paramView = com.ziroom.ziroomcustomer.ziroomstation.b.b.buildIntoClear(this, this.y, paramView);
        com.ziroom.ziroomcustomer.ziroomstation.b.c.intoClear(this, new a(null), paramView, true);
        return;
        if (this.J != null) {
          paramView = this.J.htBid;
        }
      }
    }
    w.onEventToZiroomAndUmeng("zinn_ol_pay");
    paramView = com.ziroom.ziroomcustomer.ziroomstation.b.b.buildIntoPayCash(this, ApplicationEx.c.getUserId(this), this.y, this.D);
    com.ziroom.ziroomcustomer.ziroomstation.b.c.intoPayCash(this, new b(null), paramView, true);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903574);
    this.a = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    unregisterReceiver(this.ac);
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    w.onEventToZiroomAndUmeng("zinn_detail_ol_can");
  }
  
  public void updateAvailableBedInfo(View paramView, IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean paramBedListBean)
  {
    ((TextView)paramView.findViewById(2131697324)).setText(paramBedListBean.bedCode + "床 可选");
  }
  
  public void updateSelectedBedInfo(View paramView, IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean paramBedListBean)
  {
    ((TextView)paramView.findViewById(2131697324)).setText(paramBedListBean.bedCode + "床 已选");
    ((TextView)paramView.findViewById(2131690049)).setText(paramBedListBean.name);
  }
  
  public void updateUnAvailableBedInfo(View paramView, IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean paramBedListBean)
  {
    ((TextView)paramView.findViewById(2131697324)).setText(paramBedListBean.bedCode + "床 " + paramBedListBean.sex);
    TextView localTextView = (TextView)paramView.findViewById(2131697326);
    StringBuilder localStringBuilder = new StringBuilder().append("点击去认识");
    String str;
    if ("男".equals(paramBedListBean.sex))
    {
      str = "他";
      localTextView.setText(str);
      paramView = paramView.findViewById(2131697325);
      if (!"男".equals(paramBedListBean.sex)) {
        break label142;
      }
    }
    label142:
    for (int i = 2130837895;; i = 2130837898)
    {
      paramView.setBackgroundResource(i);
      return;
      str = "她";
      break;
    }
  }
  
  private class a
    implements i.a
  {
    private a() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        com.freelxl.baselibrary.b.b localb = (com.freelxl.baselibrary.b.b)paramk.getObject();
        if (localb != null)
        {
          if (200 == localb.error_code)
          {
            int j;
            if (IntoDealMainActivity.b(IntoDealMainActivity.this) == 8)
            {
              i = 0;
              while (i < ((List)IntoDealMainActivity.d(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.c(IntoDealMainActivity.this))).size())
              {
                j = 0;
                while (j < ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)IntoDealMainActivity.d(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.c(IntoDealMainActivity.this))).get(i)).bedList.size())
                {
                  if (((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)IntoDealMainActivity.d(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.c(IntoDealMainActivity.this))).get(i)).bedList.get(j)).isUseAble == 2)
                  {
                    ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)IntoDealMainActivity.d(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.c(IntoDealMainActivity.this))).get(i)).bedList.get(j)).isUseAble = 0;
                    ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)IntoDealMainActivity.d(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.c(IntoDealMainActivity.this))).get(i)).bedList.get(j)).name = "";
                    ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)IntoDealMainActivity.d(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.c(IntoDealMainActivity.this))).get(i)).bedList.get(j)).label = null;
                    ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)IntoDealMainActivity.d(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.c(IntoDealMainActivity.this))).get(i)).bedList.get(j)).sex = "";
                  }
                  j += 1;
                }
                i += 1;
              }
              IntoDealMainActivity.e(IntoDealMainActivity.this).removeAll(IntoDealMainActivity.e(IntoDealMainActivity.this));
              if (IntoDealMainActivity.c(IntoDealMainActivity.this) < IntoDealMainActivity.d(IntoDealMainActivity.this).shemeList.size() - 1) {
                IntoDealMainActivity.f(IntoDealMainActivity.this);
              }
              for (;;)
              {
                IntoDealMainActivity.b(IntoDealMainActivity.this, ((List)IntoDealMainActivity.d(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.c(IntoDealMainActivity.this))).size());
                IntoDealMainActivity.c(IntoDealMainActivity.this, 0);
                IntoDealMainActivity.d(IntoDealMainActivity.this, 0);
                IntoDealMainActivity.l(IntoDealMainActivity.this);
                IntoDealMainActivity.m(IntoDealMainActivity.this);
                IntoDealMainActivity.g(IntoDealMainActivity.this, IntoDealMainActivity.n(IntoDealMainActivity.this));
                return;
                IntoDealMainActivity.a(IntoDealMainActivity.this, 0);
              }
            }
            int i = 0;
            while (i < ((List)IntoDealMainActivity.h(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.g(IntoDealMainActivity.this))).size())
            {
              j = 0;
              while (j < ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)IntoDealMainActivity.h(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.g(IntoDealMainActivity.this))).get(i)).bedList.size())
              {
                if (((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)IntoDealMainActivity.h(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.g(IntoDealMainActivity.this))).get(i)).bedList.get(j)).isUseAble == 2)
                {
                  ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)IntoDealMainActivity.h(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.g(IntoDealMainActivity.this))).get(i)).bedList.get(j)).isUseAble = 0;
                  ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)IntoDealMainActivity.h(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.g(IntoDealMainActivity.this))).get(i)).bedList.get(j)).name = "";
                  ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)IntoDealMainActivity.h(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.g(IntoDealMainActivity.this))).get(i)).bedList.get(j)).label = null;
                  ((IntoSchemeModel.DataBean.HtListBean.ShemeListBean.BedListBean)((IntoSchemeModel.DataBean.HtListBean.ShemeListBean)((List)IntoDealMainActivity.h(IntoDealMainActivity.this).shemeList.get(IntoDealMainActivity.g(IntoDealMainActivity.this))).get(i)).bedList.get(j)).sex = "";
                }
                j += 1;
              }
              i += 1;
            }
            IntoDealMainActivity.i(IntoDealMainActivity.this).removeAll(IntoDealMainActivity.i(IntoDealMainActivity.this));
            if (IntoDealMainActivity.g(IntoDealMainActivity.this) < IntoDealMainActivity.h(IntoDealMainActivity.this).shemeList.size() - 1) {
              IntoDealMainActivity.j(IntoDealMainActivity.this);
            }
            for (;;)
            {
              IntoDealMainActivity.c(IntoDealMainActivity.this, IntoDealMainActivity.k(IntoDealMainActivity.this));
              IntoDealMainActivity.f(IntoDealMainActivity.this, 0);
              break;
              IntoDealMainActivity.e(IntoDealMainActivity.this, 0);
            }
          }
          af.showToast(IntoDealMainActivity.this, localb.error_message);
          return;
        }
        af.showToast(IntoDealMainActivity.this, paramk.getMessage());
        return;
      }
      af.showToast(IntoDealMainActivity.this, paramk.getMessage());
    }
  }
  
  private class b
    implements i.a
  {
    private b() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        IntoDealMainActivity.a(IntoDealMainActivity.this, (IntoToPayResultModel)paramk.getObject());
        if (IntoDealMainActivity.a(IntoDealMainActivity.this) != null)
        {
          if (200 == IntoDealMainActivity.a(IntoDealMainActivity.this).error_code)
          {
            IntoDealMainActivity.a(IntoDealMainActivity.this, new com.ziroom.ziroomcustomer.ziroomstation.dialog.b(IntoDealMainActivity.this, IntoDealMainActivity.a(IntoDealMainActivity.this).data.payOrderNumber, IntoDealMainActivity.z(IntoDealMainActivity.this), 2));
            IntoDealMainActivity.A(IntoDealMainActivity.this).setPayWay(true, false, false);
            IntoDealMainActivity.A(IntoDealMainActivity.this).show();
            return;
          }
          af.showToast(IntoDealMainActivity.this, IntoDealMainActivity.a(IntoDealMainActivity.this).error_message);
          return;
        }
        af.showToast(IntoDealMainActivity.this, paramk.getMessage());
        return;
      }
      af.showToast(IntoDealMainActivity.this, paramk.getMessage());
    }
  }
  
  private class c
    implements i.a
  {
    private c() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        IntoDealMainActivity.a(IntoDealMainActivity.this, (IntoSchemeModel)paramk.getObject());
        if (IntoDealMainActivity.q(IntoDealMainActivity.this) != null)
        {
          if (200 == IntoDealMainActivity.q(IntoDealMainActivity.this).error_code)
          {
            IntoDealMainActivity.p(IntoDealMainActivity.this);
            return;
          }
          af.showToast(IntoDealMainActivity.this, IntoDealMainActivity.q(IntoDealMainActivity.this).error_message);
          return;
        }
        af.showToast(IntoDealMainActivity.this, paramk.getMessage());
        return;
      }
      af.showToast(IntoDealMainActivity.this, paramk.getMessage());
    }
  }
  
  private class d
    implements i.a
  {
    private d() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        IntoDealMainActivity.a(IntoDealMainActivity.this, (IntoSelectedPeopleModel)paramk.getObject());
        if (IntoDealMainActivity.o(IntoDealMainActivity.this) != null)
        {
          if (200 == IntoDealMainActivity.o(IntoDealMainActivity.this).error_code)
          {
            IntoDealMainActivity.p(IntoDealMainActivity.this);
            return;
          }
          af.showToast(IntoDealMainActivity.this, IntoDealMainActivity.o(IntoDealMainActivity.this).error_message);
          return;
        }
        af.showToast(IntoDealMainActivity.this, paramk.getMessage());
        return;
      }
      af.showToast(IntoDealMainActivity.this, paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/IntoDealMainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */