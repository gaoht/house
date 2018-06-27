package com.ziroom.ziroomcustomer.ziroomstation;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newchat.ChatNewActivity;
import com.ziroom.ziroomcustomer.newchat.l;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.b;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshBase.d;
import com.ziroom.ziroomcustomer.newmovehouse.widget.PullToRefreshScrollView;
import com.ziroom.ziroomcustomer.util.ab;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.ziroomstation.b.b;
import com.ziroom.ziroomcustomer.ziroomstation.baidumap.StationHouseMapLocationActivity;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.c.a;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderDetailEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderDetailEntity.DataEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity.StayPersonInfoEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderDetailEntity.DataEntity.RefundStepBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationRoomPassword;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationRoomPassword.DataEntity;
import com.ziroom.ziroomcustomer.ziroomstation.utils.i;
import com.ziroom.ziroomcustomer.ziroomstation.widget.DashedLine;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private View A;
  private View B;
  private View C;
  private View D;
  private ImageView E;
  private ImageView F;
  private ImageView G;
  private ImageView H;
  private ImageView I;
  private ImageView J;
  private TextView K;
  private TextView L;
  private TextView M;
  private TextView N;
  private TextView O;
  private TextView P;
  private TextView Q;
  private TextView R;
  private TextView S;
  private TextView T;
  private TextView U;
  private TextView V;
  private TextView W;
  private TextView X;
  private TextView Y;
  private TextView Z;
  private View a;
  private TextView aa;
  private TextView ab;
  private TextView ac;
  private LinearLayout ad;
  private DashedLine ae;
  private DashedLine af;
  private PullToRefreshScrollView ag;
  private SimpleDraweeView ah;
  private int ai;
  private b aj;
  private Context ak;
  private StationOrderDetailEntity al;
  private String am;
  private String an;
  private StationRoomPassword ao;
  private String ap = "";
  private String aq = "";
  private boolean ar = false;
  private long as;
  private c at;
  private boolean au = true;
  private com.ziroom.ziroomcustomer.ziroomstation.dialog.c av;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View r;
  private View s;
  private View t;
  private View u;
  private View v;
  private View w;
  private View x;
  private View y;
  private View z;
  
  private void a()
  {
    int i = (int)((System.currentTimeMillis() - this.as) / 1000L);
    w.onDuration(this.aq, i);
    this.ar = false;
  }
  
  private void a(int paramInt, StationOrderDetailEntity.DataEntity.RefundStepBean paramRefundStepBean, ImageView paramImageView1, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView2, DashedLine paramDashedLine)
  {
    if (!ae.isNull(paramRefundStepBean.getPointTime()))
    {
      paramTextView2.setVisibility(0);
      paramTextView2.setText(paramRefundStepBean.getPointTime());
      switch (paramRefundStepBean.getPointStatus())
      {
      }
    }
    do
    {
      for (;;)
      {
        return;
        paramTextView2.setVisibility(8);
        break;
        paramImageView1.setBackgroundResource(2130838827);
        a(paramTextView1, paramRefundStepBean.getPointName(), 2131624599);
        if ((paramImageView2 != null) && (paramDashedLine != null))
        {
          paramImageView2.setVisibility(8);
          paramDashedLine.setVisibility(0);
          return;
          paramImageView1.setBackgroundResource(2130838826);
          a(paramTextView1, paramRefundStepBean.getPointName() + "·", paramRefundStepBean.getPointDes(), 2131624607, 2131624599);
          if ((paramImageView2 != null) && (paramDashedLine != null))
          {
            paramImageView2.setVisibility(0);
            paramDashedLine.setVisibility(8);
            return;
            paramImageView1.setBackgroundResource(2130838828);
            if (2 == paramInt) {
              a(paramTextView1, paramRefundStepBean.getPointName() + "·", paramRefundStepBean.getPointDes(), 2131624607, 2131624599);
            }
            while ((paramImageView2 != null) && (paramDashedLine != null))
            {
              paramImageView2.setVisibility(0);
              paramDashedLine.setVisibility(8);
              return;
              a(paramTextView1, paramRefundStepBean.getPointName() + "·", paramRefundStepBean.getPointDes(), 2131624597, 2131624599);
            }
          }
        }
      }
      paramImageView1.setBackgroundResource(2130838825);
      a(paramTextView1, paramRefundStepBean.getPointName() + "·", paramRefundStepBean.getPointDes(), 2131624610, 2131624599);
    } while ((paramImageView2 == null) || (paramDashedLine == null));
    paramImageView2.setVisibility(0);
    paramDashedLine.setVisibility(8);
    paramImageView2.setBackgroundResource(2131624610);
  }
  
  private void a(int paramInt, String paramString)
  {
    this.aa.setText(paramString);
    switch (paramInt)
    {
    default: 
    case 5: 
    case 7: 
      do
      {
        do
        {
          return;
          this.aa.setTextColor(getResources().getColor(2131624610));
          this.d.setVisibility(8);
          this.e.setVisibility(8);
          this.c.setVisibility(8);
          this.r.setVisibility(8);
          this.s.setVisibility(8);
          this.v.setVisibility(0);
          this.w.setVisibility(0);
          this.x.setVisibility(8);
          this.B.setVisibility(8);
          this.D.setVisibility(8);
          this.y.setVisibility(8);
          this.z.setVisibility(8);
          this.t.setVisibility(0);
          this.u.setVisibility(0);
          this.ap = "zinn_det_dzf_call";
        } while (this.ar);
        this.ar = true;
        this.as = System.currentTimeMillis();
        this.aq = "zinn_det_dzf_duration";
        return;
        this.aa.setTextColor(getResources().getColor(2131624600));
        this.d.setVisibility(0);
        this.e.setVisibility(0);
        this.c.setVisibility(0);
        this.V.setVisibility(4);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.v.setVisibility(8);
        this.w.setVisibility(8);
        this.x.setVisibility(8);
        this.B.setVisibility(8);
        this.D.setVisibility(8);
        this.y.setVisibility(8);
        this.z.setVisibility(8);
        this.t.setVisibility(8);
        this.u.setVisibility(8);
        this.ap = "zinn_det_yqx_call";
      } while (this.ar);
      this.ar = true;
      this.as = System.currentTimeMillis();
      this.aq = "zinn_det_yqx_duration";
      return;
    case 1: 
      this.aa.setTextColor(getResources().getColor(2131624609));
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      this.c.setVisibility(8);
      this.r.setVisibility(8);
      this.v.setVisibility(8);
      this.w.setVisibility(8);
      this.x.setVisibility(0);
      if ((this.al != null) && (this.al.getData().isSupportSelfCheck()) && (this.al.getData().getSelfChecked() == 0))
      {
        this.B.setVisibility(0);
        this.y.setVisibility(8);
        paramString = ab.getInstance().getStationCheckIn();
        String[] arrayOfString = paramString.split(",");
        paramInt = 0;
        label553:
        if (paramInt >= arrayOfString.length) {
          break label1765;
        }
        if (!this.al.getData().getOrderBid().equals(arrayOfString[paramInt])) {
          break;
        }
      }
      break;
    }
    label610:
    label617:
    label803:
    label1180:
    label1765:
    for (paramInt = 0;; paramInt = 1)
    {
      if (paramInt != 0)
      {
        this.D.setVisibility(0);
        if (TextUtils.isEmpty(paramString))
        {
          paramString = this.al.getData().getOrderBid();
          ab.getInstance().setStationCheckIn(paramString);
          if ((this.al == null) || (!this.al.getData().isSupportSelfCheck()) || (this.al.getData().getSelfChecked() != 0)) {
            break label803;
          }
          this.s.setVisibility(8);
        }
      }
      for (;;)
      {
        this.z.setVisibility(8);
        this.t.setVisibility(0);
        this.u.setVisibility(0);
        this.ap = "zinn_det_yzf_call";
        if (this.ar) {
          break;
        }
        this.ar = true;
        this.as = System.currentTimeMillis();
        this.aq = "zinn_det_yzf_duration";
        return;
        paramInt += 1;
        break label553;
        paramString = paramString + "," + this.al.getData().getOrderBid();
        break label610;
        this.D.setVisibility(8);
        break label617;
        this.B.setVisibility(8);
        this.y.setVisibility(0);
        this.D.setVisibility(8);
        break label617;
        this.s.setVisibility(0);
      }
      this.aa.setTextColor(getResources().getColor(2131624609));
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      this.c.setVisibility(8);
      this.r.setVisibility(0);
      this.s.setVisibility(8);
      this.v.setVisibility(8);
      this.w.setVisibility(8);
      this.x.setVisibility(8);
      this.B.setVisibility(8);
      this.D.setVisibility(8);
      this.y.setVisibility(0);
      this.z.setVisibility(8);
      this.t.setVisibility(0);
      this.u.setVisibility(0);
      this.ap = "zinn_det_yrz_call";
      if (this.ar) {
        break;
      }
      this.ar = true;
      this.as = System.currentTimeMillis();
      this.aq = "zinn_det_yrz_duration";
      return;
      this.aa.setTextColor(getResources().getColor(2131624600));
      this.d.setVisibility(0);
      this.e.setVisibility(0);
      this.c.setVisibility(0);
      this.V.setVisibility(4);
      this.r.setVisibility(8);
      this.s.setVisibility(8);
      this.v.setVisibility(8);
      this.w.setVisibility(8);
      this.x.setVisibility(8);
      this.B.setVisibility(8);
      this.D.setVisibility(8);
      this.y.setVisibility(8);
      if ((this.al != null) && (this.al.getData() != null) && (this.al.getData().getIsEvaluate() != null))
      {
        paramString = this.al.getData().getIsEvaluate();
        paramInt = -1;
        switch (paramString.hashCode())
        {
        default: 
          switch (paramInt)
          {
          }
          break;
        }
      }
      for (;;)
      {
        this.ap = "zinn_det_ytf_call";
        if (this.ar) {
          break;
        }
        this.ar = true;
        this.as = System.currentTimeMillis();
        this.aq = "zinn_det_ytf_duration";
        return;
        if (!paramString.equals("0")) {
          break label1180;
        }
        paramInt = 0;
        break label1180;
        if (!paramString.equals("1")) {
          break label1180;
        }
        paramInt = 1;
        break label1180;
        if (!paramString.equals("2")) {
          break label1180;
        }
        paramInt = 2;
        break label1180;
        this.z.setVisibility(8);
        this.A.setVisibility(8);
        this.t.setVisibility(8);
        this.u.setVisibility(8);
        continue;
        this.z.setVisibility(0);
        this.A.setVisibility(8);
        this.t.setVisibility(0);
        this.u.setVisibility(0);
        continue;
        this.z.setVisibility(8);
        this.A.setVisibility(8);
        this.t.setVisibility(8);
        this.u.setVisibility(8);
      }
      this.aa.setTextColor(getResources().getColor(2131624606));
      this.d.setVisibility(0);
      this.e.setVisibility(0);
      this.c.setVisibility(0);
      this.V.setVisibility(4);
      this.r.setVisibility(8);
      this.s.setVisibility(8);
      this.v.setVisibility(8);
      this.w.setVisibility(8);
      this.x.setVisibility(8);
      this.B.setVisibility(8);
      this.D.setVisibility(8);
      this.y.setVisibility(8);
      this.z.setVisibility(8);
      this.t.setVisibility(8);
      this.u.setVisibility(8);
      this.ap = "zinn_det_tkz_call";
      if (this.ar) {
        break;
      }
      this.ar = true;
      this.as = System.currentTimeMillis();
      this.aq = "zinn_det_tkz_duration";
      return;
      this.aa.setTextColor(getResources().getColor(2131624606));
      this.d.setVisibility(0);
      this.e.setVisibility(0);
      this.c.setVisibility(0);
      this.V.setVisibility(4);
      this.r.setVisibility(8);
      this.s.setVisibility(8);
      this.v.setVisibility(8);
      this.w.setVisibility(8);
      this.x.setVisibility(8);
      this.B.setVisibility(8);
      this.D.setVisibility(8);
      this.y.setVisibility(8);
      this.z.setVisibility(8);
      this.t.setVisibility(8);
      this.u.setVisibility(8);
      this.ap = "zinn_det_ytk_call";
      if (this.ar) {
        break;
      }
      this.ar = true;
      this.as = System.currentTimeMillis();
      this.aq = "zinn_det_ytk_duration";
      return;
    }
  }
  
  private void a(TextView paramTextView, String paramString, int paramInt)
  {
    if (!ae.isNull(paramString))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.ak.getResources().getColor(paramInt)), 0, paramString.length(), 33);
      paramTextView.setText(localSpannableStringBuilder);
    }
  }
  
  private void a(TextView paramTextView, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!ae.isNull(paramString1))
    {
      paramString2 = paramString1 + paramString2;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString2);
      paramInt1 = this.ak.getResources().getColor(paramInt1);
      paramInt2 = this.ak.getResources().getColor(paramInt2);
      ForegroundColorSpan localForegroundColorSpan1 = new ForegroundColorSpan(paramInt1);
      ForegroundColorSpan localForegroundColorSpan2 = new ForegroundColorSpan(paramInt2);
      localSpannableStringBuilder.setSpan(localForegroundColorSpan1, 0, paramString1.length(), 33);
      localSpannableStringBuilder.setSpan(localForegroundColorSpan2, paramString1.length(), paramString2.length(), 33);
      paramTextView.setText(localSpannableStringBuilder);
    }
  }
  
  private void b()
  {
    this.W = ((TextView)findViewById(2131690469));
    this.f = findViewById(2131690477);
    this.a = findViewById(2131690459);
    this.b = findViewById(2131690078);
    this.ab = ((TextView)findViewById(2131690501));
    this.ah = ((SimpleDraweeView)findViewById(2131690432));
    ((GenericDraweeHierarchy)this.ah.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    this.G = ((ImageView)findViewById(2131690433));
    this.K = ((TextView)findViewById(2131690434));
    this.L = ((TextView)findViewById(2131690435));
    this.M = ((TextView)findViewById(2131690436));
    this.aa = ((TextView)findViewById(2131690472));
    this.N = ((TextView)findViewById(2131690499));
    this.O = ((TextView)findViewById(2131690500));
    this.P = ((TextView)findViewById(2131690471));
    this.Q = ((TextView)findViewById(2131690479));
    this.V = ((TextView)findViewById(2131690473));
    this.g = findViewById(2131690503);
    this.X = ((TextView)findViewById(2131690488));
    this.Y = ((TextView)findViewById(2131690494));
    this.Z = ((TextView)findViewById(2131690498));
    this.c = findViewById(2131690480);
    this.e = findViewById(2131690474);
    this.d = findViewById(2131690502);
    this.F = ((ImageView)findViewById(2131690485));
    this.E = ((ImageView)findViewById(2131690491));
    this.ae = ((DashedLine)findViewById(2131690492));
    this.af = ((DashedLine)findViewById(2131690486));
    this.H = ((ImageView)findViewById(2131690484));
    this.I = ((ImageView)findViewById(2131690490));
    this.J = ((ImageView)findViewById(2131690496));
    this.R = ((TextView)findViewById(2131690487));
    this.S = ((TextView)findViewById(2131690493));
    this.T = ((TextView)findViewById(2131690497));
    this.U = ((TextView)findViewById(2131690476));
    this.ac = ((TextView)findViewById(2131690504));
    this.r = findViewById(2131690505);
    this.s = findViewById(2131690506);
    this.ad = ((LinearLayout)findViewById(2131690507));
    this.t = findViewById(2131690467);
    this.u = findViewById(2131689498);
    this.v = findViewById(2131690460);
    this.w = findViewById(2131690461);
    this.x = findViewById(2131690462);
    this.y = findViewById(2131690464);
    this.z = findViewById(2131690465);
    this.A = findViewById(2131690466);
    this.B = findViewById(2131690463);
    this.C = findViewById(2131690509);
    this.D = findViewById(2131690508);
    this.ag = ((PullToRefreshScrollView)findViewById(2131690468));
  }
  
  private void b(int paramInt)
  {
    int i;
    Object localObject2;
    View localView1;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    if ((1 == paramInt) && (this.al != null) && (this.al.getData().isSupportSelfCheck()) && (this.al.getData().getSelfChecked() == 1))
    {
      if ((this.ad != null) && (this.al != null) && (this.al.getData().getHouseTypeInfo() != null) && (this.al.getData().getHouseTypeInfo().size() > 0))
      {
        this.ad.removeAllViews();
        i = 0;
        paramInt = 1;
        while (i < this.al.getData().getHouseTypeInfo().size())
        {
          int j = 0;
          if (j < ((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity)this.al.getData().getHouseTypeInfo().get(i)).getStayPersonInfo().size())
          {
            localObject2 = LayoutInflater.from(this).inflate(2130904546, this.ad, false);
            localView1 = ((View)localObject2).findViewById(2131695697);
            localObject3 = ((View)localObject2).findViewById(2131695705);
            localObject4 = ((View)localObject2).findViewById(2131695706);
            View localView2 = ((View)localObject2).findViewById(2131695707);
            localObject1 = (LinearLayout)((View)localObject2).findViewById(2131695698);
            LinearLayout localLinearLayout = (LinearLayout)((View)localObject2).findViewById(2131695702);
            TextView localTextView2 = (TextView)((View)localObject2).findViewById(2131695699);
            TextView localTextView3 = (TextView)((View)localObject2).findViewById(2131695703);
            TextView localTextView4 = (TextView)((View)localObject2).findViewById(2131695700);
            TextView localTextView5 = (TextView)((View)localObject2).findViewById(2131695704);
            TextView localTextView1 = (TextView)((View)localObject2).findViewById(2131695701);
            StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity.StayPersonInfoEntity localStayPersonInfoEntity = (StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity.StayPersonInfoEntity)((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity)this.al.getData().getHouseTypeInfo().get(i)).getStayPersonInfo().get(j);
            String[] arrayOfString = localStayPersonInfoEntity.getLabels();
            if ((arrayOfString != null) && (arrayOfString.length > 0))
            {
              ((LinearLayout)localObject1).setVisibility(0);
              localLinearLayout.setVisibility(8);
              localTextView2.setText(localStayPersonInfoEntity.getZName());
              localTextView4.setText(localStayPersonInfoEntity.getAreaName() + " " + localStayPersonInfoEntity.getBedNum() + "床");
              localObject1 = "";
              int k = 0;
              if (k < arrayOfString.length)
              {
                if (k == arrayOfString.length - 1) {}
                for (localObject1 = (String)localObject1 + arrayOfString[k];; localObject1 = (String)localObject1 + arrayOfString[k] + " | ")
                {
                  k += 1;
                  break;
                }
              }
              localTextView1.setText((CharSequence)localObject1);
              label512:
              if (paramInt == 0) {
                break label629;
              }
              paramInt = 0;
              localView1.setVisibility(0);
            }
            for (;;)
            {
              ((View)localObject3).setVisibility(8);
              ((View)localObject4).setVisibility(0);
              localView2.setVisibility(8);
              this.ad.addView((View)localObject2);
              j += 1;
              break;
              ((LinearLayout)localObject1).setVisibility(8);
              localLinearLayout.setVisibility(0);
              localTextView3.setText(localStayPersonInfoEntity.getZName());
              localTextView5.setText(localStayPersonInfoEntity.getAreaName() + " " + localStayPersonInfoEntity.getBedNum() + "床");
              break label512;
              label629:
              localView1.setVisibility(8);
            }
          }
          i += 1;
        }
        this.ad.getChildAt(this.ad.getChildCount() - 1).findViewById(2131695707).setVisibility(0);
        this.ad.getChildAt(this.ad.getChildCount() - 1).findViewById(2131695706).setVisibility(8);
        this.ad.getChildAt(this.ad.getChildCount() - 1).findViewById(2131695705).setVisibility(0);
        this.ac.setVisibility(0);
        this.s.setVisibility(0);
        return;
      }
      this.ac.setVisibility(4);
      this.s.setVisibility(4);
      return;
    }
    this.s.setVisibility(4);
    if ((this.ad != null) && (this.al != null) && (this.al.getData().getHouseTypeInfo() != null) && (this.al.getData().getHouseTypeInfo().size() > 0))
    {
      this.ad.removeAllViews();
      paramInt = 0;
      while (paramInt < this.al.getData().getHouseTypeInfo().size())
      {
        i = 0;
        while (i < ((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity)this.al.getData().getHouseTypeInfo().get(paramInt)).getStayPersonInfo().size())
        {
          if (!ae.isNull(((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity.StayPersonInfoEntity)((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity)this.al.getData().getHouseTypeInfo().get(paramInt)).getStayPersonInfo().get(i)).getCredentialNumber()))
          {
            localObject1 = LayoutInflater.from(this).inflate(2130904182, this.ad, false);
            ((TextView)((View)localObject1).findViewById(2131694968)).setText(((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity)this.al.getData().getHouseTypeInfo().get(paramInt)).getHouseShowName());
            localObject2 = (LinearLayout)((View)localObject1).findViewById(2131694969);
            localView1 = LayoutInflater.from(this).inflate(2130904181, (ViewGroup)localObject2, false);
            localObject3 = (TextView)localView1.findViewById(2131694965);
            localObject4 = (TextView)localView1.findViewById(2131694967);
            ((TextView)localObject3).setText(((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity.StayPersonInfoEntity)((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity)this.al.getData().getHouseTypeInfo().get(paramInt)).getStayPersonInfo().get(i)).getZName());
            ((TextView)localObject4).setText(((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity.StayPersonInfoEntity)((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity)this.al.getData().getHouseTypeInfo().get(paramInt)).getStayPersonInfo().get(i)).getCredentialNumber());
            ((LinearLayout)localObject2).addView(localView1);
            this.ad.addView((View)localObject1);
          }
          i += 1;
        }
        paramInt += 1;
      }
      if (this.ad.getChildCount() > 0)
      {
        this.ac.setVisibility(0);
        return;
      }
      this.ac.setVisibility(4);
      return;
    }
    this.ac.setVisibility(4);
  }
  
  private void e() {}
  
  private void f()
  {
    this.f.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.ag.setMode(PullToRefreshBase.b.b);
    this.ag.setOnRefreshListener(new PullToRefreshBase.d()
    {
      public void onRefresh(PullToRefreshBase<ScrollView> paramAnonymousPullToRefreshBase)
      {
        OrderDetailActivity.u(OrderDetailActivity.this);
      }
    });
  }
  
  private void g()
  {
    if (!ah.checkNet(this.ak))
    {
      af.showToast(this.ak, 2131297483);
      if (this.ag.isRefreshing()) {
        this.ag.onRefreshComplete();
      }
      return;
    }
    com.ziroom.ziroomcustomer.ziroomstation.b.c.getOrderDetail(this, new a(null), b.buildGetOrderDetail(this, this.an), true);
  }
  
  private void h()
  {
    i();
    if (TextUtils.isEmpty(this.am))
    {
      af.showToast(this, "未登记电话，请联系客服");
      return;
    }
    ah.callPhone(this, this.am);
  }
  
  private void i()
  {
    if (!TextUtils.isEmpty(this.ap)) {
      w.onEventToZiroomAndUmeng(this.ap);
    }
  }
  
  private void j()
  {
    if (this.al.getData().refundStep.size() == 0)
    {
      this.c.setVisibility(8);
      return;
    }
    int i = 0;
    label30:
    StationOrderDetailEntity.DataEntity.RefundStepBean localRefundStepBean;
    if (i < this.al.getData().refundStep.size())
    {
      localRefundStepBean = (StationOrderDetailEntity.DataEntity.RefundStepBean)this.al.getData().refundStep.get(i);
      if (localRefundStepBean.getPointOrder() != 0) {
        break label103;
      }
      a(0, localRefundStepBean, this.H, this.R, this.X, null, null);
    }
    for (;;)
    {
      i += 1;
      break label30;
      break;
      label103:
      if (1 == localRefundStepBean.getPointOrder()) {
        a(1, localRefundStepBean, this.I, this.S, this.Y, this.F, this.af);
      } else if (2 == localRefundStepBean.getPointOrder()) {
        a(2, localRefundStepBean, this.J, this.T, this.Z, this.E, this.ae);
      }
    }
  }
  
  private void k()
  {
    if (this.aj == null) {
      this.aj = new b(this.ak, getWindow().getDecorView());
    }
    this.aj.showPopwindow();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    g();
    if (this.av != null) {
      this.av.getCallback().doInActivityResult(this.ak, paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == -1) {}
  }
  
  public void onBackPressed()
  {
    if (this.D.getVisibility() == 0)
    {
      this.D.setVisibility(8);
      return;
    }
    super.onBackPressed();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {}
    Object localObject2;
    switch (paramView.getId())
    {
    case 2131690466: 
    default: 
    case 2131690477: 
    case 2131690459: 
    case 2131690078: 
    case 2131690506: 
    case 2131690505: 
    case 2131690464: 
    case 2131690460: 
    case 2131690465: 
    case 2131690462: 
    case 2131690461: 
      do
      {
        return;
        toBaiduMap();
        return;
        h();
        return;
        finish();
        return;
        paramView = new Intent(this.ak, IntoDealMainActivity.class);
        paramView.putExtra("orderBid", this.an);
        paramView.putExtra("showMode", true);
        startActivityForResult(paramView, 5);
        return;
        if (!ah.checkNet(this.ak))
        {
          af.showToast(this.ak, 2131297483);
          return;
        }
        w.onEventToZiroomAndUmeng("zinn_det_yrz_passwd");
        com.ziroom.ziroomcustomer.ziroomstation.b.c.getStationOrderDetailPassword(this.ak, b.buildRoomPassword(this, this.al.getData().getOrderBid()), new com.freelxl.baselibrary.e.i.a()
        {
          public void onParse(String paramAnonymousString, k paramAnonymousk) {}
          
          public void onSuccess(k paramAnonymousk)
          {
            OrderDetailActivity.a(OrderDetailActivity.this, (StationRoomPassword)paramAnonymousk.getObject());
            if ((OrderDetailActivity.v(OrderDetailActivity.this) != null) && ("200".equals(OrderDetailActivity.v(OrderDetailActivity.this).getError_code())))
            {
              OrderDetailActivity.w(OrderDetailActivity.this);
              return;
            }
            if ((OrderDetailActivity.v(OrderDetailActivity.this) != null) && (!TextUtils.isEmpty(OrderDetailActivity.v(OrderDetailActivity.this).getError_message())))
            {
              af.showToast(OrderDetailActivity.d(OrderDetailActivity.this), OrderDetailActivity.v(OrderDetailActivity.this).getError_message());
              return;
            }
            af.showToast(OrderDetailActivity.d(OrderDetailActivity.this), "获取密码失败！");
          }
        }, true);
        return;
        switch (this.ai)
        {
        }
        for (;;)
        {
          h();
          return;
          w.onEventToZiroomAndUmeng("zinn_det_yzf_complain");
          continue;
          w.onEventToZiroomAndUmeng("zinn_det_yrz_complain");
          continue;
          w.onEventToZiroomAndUmeng("zinn_det_tkz_complain");
        }
        i.commonOkDialog(this.ak, "您确认取消该订单？", new com.ziroom.ziroomcustomer.ziroomstation.utils.i.a()
        {
          public void okCallback()
          {
            com.ziroom.ziroomcustomer.ziroomstation.b.c.cancelOrder(OrderDetailActivity.d(OrderDetailActivity.this), b.buildCancelOrder(OrderDetailActivity.d(OrderDetailActivity.this), OrderDetailActivity.c(OrderDetailActivity.this).getData().getOrderBid()), new com.freelxl.baselibrary.e.i.a()
            {
              public void onParse(String paramAnonymous2String, k paramAnonymous2k) {}
              
              public void onSuccess(k paramAnonymous2k)
              {
                paramAnonymous2k = (com.ziroom.ziroomcustomer.ziroomstation.b.a)paramAnonymous2k.getObject();
                if ((paramAnonymous2k != null) && ("200".equals(paramAnonymous2k.getError_code())))
                {
                  af.showToast(OrderDetailActivity.d(OrderDetailActivity.this), "取消成功");
                  OrderDetailActivity.u(OrderDetailActivity.this);
                }
                while (paramAnonymous2k == null) {
                  return;
                }
                Context localContext = OrderDetailActivity.d(OrderDetailActivity.this);
                if (TextUtils.isEmpty(paramAnonymous2k.getError_message())) {}
                for (paramAnonymous2k = "取消失败！";; paramAnonymous2k = paramAnonymous2k.getError_message())
                {
                  af.showToast(localContext, paramAnonymous2k);
                  return;
                }
              }
            }, true);
          }
        });
        w.onEventToZiroomAndUmeng("zinn_det_dzf_cancel");
        return;
        localObject2 = new Intent(this, StationEvaluateActivity.class);
        ((Intent)localObject2).putExtra("orderNumber", this.al.getData().getOrderNumber());
        ((Intent)localObject2).putExtra("projectBid", this.al.getData().getProjectBid());
        ((Intent)localObject2).putExtra("dName", this.al.getData().getDName());
        ((Intent)localObject2).putExtra("phone", this.al.getData().getPhone());
        ((Intent)localObject2).putExtra("orderBid", this.al.getData().getOrderBid());
        Object localObject1 = "";
        paramView = (View)localObject1;
        if (this.al.getData() != null)
        {
          paramView = (View)localObject1;
          if (this.al.getData().getHouseTypeInfo() != null)
          {
            paramView = (View)localObject1;
            if (this.al.getData().getHouseTypeInfo().size() > 0)
            {
              paramView = "";
              int i = 0;
              if (i < this.al.getData().getHouseTypeInfo().size())
              {
                if (i == 0) {}
                for (paramView = paramView + ((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity)this.al.getData().getHouseTypeInfo().get(i)).getHouseShowName();; paramView = paramView + "," + ((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity)this.al.getData().getHouseTypeInfo().get(i)).getHouseShowName())
                {
                  i += 1;
                  break;
                }
              }
            }
          }
        }
        ((Intent)localObject2).putExtra("houseTypeNames", paramView);
        startActivityForResult((Intent)localObject2, 3);
        w.onEventToZiroomAndUmeng("zinn_det_ytf_eva");
        return;
        switch (this.ai)
        {
        }
        for (;;)
        {
          paramView = new Intent(this, ApplyRefundActivity.class);
          paramView.putExtra("orderBid", this.an);
          localObject1 = new SimpleDateFormat("yyyy-MM-dd");
          localObject2 = new SimpleDateFormat("yyyy年MM月dd日");
          try
          {
            paramView.putExtra("start", ((SimpleDateFormat)localObject2).format(((SimpleDateFormat)localObject1).parse(i.checkString(this.al.getData().getStartDate()))));
            paramView.putExtra("end", ((SimpleDateFormat)localObject2).format(((SimpleDateFormat)localObject1).parse(i.checkString(this.al.getData().getEndDate()))));
            paramView.putExtra("name", this.al.getData().getDName());
            startActivityForResult(paramView, 2);
            return;
            w.onEventToZiroomAndUmeng("zinn_det_yzf_payback");
            continue;
            w.onEventToZiroomAndUmeng("zinn_det_yrz_payback");
          }
          catch (ParseException localParseException)
          {
            for (;;)
            {
              paramView.putExtra("start", "未知");
              paramView.putExtra("end", "未知");
            }
          }
        }
      } while ((this.al == null) || (this.al.getData() == null));
      this.av = new com.ziroom.ziroomcustomer.ziroomstation.dialog.c(this.ak, this.al.getData().getPaymentNumber(), Double.parseDouble(this.al.getData().getAmount()), 1);
      this.av.show();
      return;
    case 2131690463: 
      w.onEventToZiroomAndUmeng("zinn_detail_ol");
      Intent localIntent = new Intent(this.ak, IntoDealMainActivity.class);
      localIntent.putExtra("orderBid", this.an);
      paramView = new SimpleDateFormat("yyyy-MM-dd");
      localObject2 = new SimpleDateFormat("yyyy/MM/dd");
      try
      {
        paramView = ((SimpleDateFormat)localObject2).format(paramView.parse(i.checkString(this.al.getData().getStartDate()))) + " 至 " + ((SimpleDateFormat)localObject2).format(paramView.parse(i.checkString(this.al.getData().getEndDate())));
        localIntent.putExtra("timeString", paramView);
        startActivityForResult(localIntent, 5);
        return;
      }
      catch (ParseException paramView)
      {
        for (;;)
        {
          paramView = "未知 至 未知";
        }
      }
    case 2131690509: 
      this.B.callOnClick();
      return;
    }
    w.onEventToZiroomAndUmeng("zinn_detail_cancel");
    this.D.setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903164);
    this.ak = this;
    if (getIntent().getExtras() != null) {}
    for (this.an = getIntent().getExtras().getString("orderBid");; this.an = "")
    {
      b();
      e();
      f();
      g();
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    a();
    super.onPause();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = (StationOrderDetailEntity)paramBundle.getSerializable("data");
      if (paramBundle != null) {
        this.al = paramBundle;
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.au)
    {
      this.au = false;
      return;
    }
    g();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.al != null) {
      paramBundle.putSerializable("data", this.al);
    }
    super.onSaveInstanceState(paramBundle);
  }
  
  public void resetGetPwd()
  {
    this.W.setVisibility(8);
    g();
  }
  
  public void setChatInfo()
  {
    if (!checkNet(this.ak))
    {
      showToast("网络请求失败，请检查网络连接");
      return;
    }
    if (ApplicationEx.c.isLoginState())
    {
      if (!ApplicationEx.c.isImconnect())
      {
        com.ziroom.ziroomcustomer.newchat.a.register(this);
        if (l.getNetWorkType(this.ak)) {
          showProgressNoCancel("", 8000L);
        }
        for (;;)
        {
          new Thread()
          {
            public void run()
            {
              super.run();
              try
              {
                if (l.getNetWorkType(OrderDetailActivity.d(OrderDetailActivity.this))) {
                  Thread.sleep(8000L);
                }
                for (;;)
                {
                  Intent localIntent = new Intent(OrderDetailActivity.this, ChatNewActivity.class);
                  localIntent.putExtra("chatForm", "ziruyi");
                  OrderDetailActivity.this.startActivity(localIntent);
                  return;
                  Thread.sleep(18000L);
                }
              }
              catch (InterruptedException localInterruptedException)
              {
                for (;;)
                {
                  localInterruptedException.printStackTrace();
                }
              }
            }
          }.start();
          return;
          showProgressNoCancel("", 18000L);
        }
      }
      Intent localIntent = new Intent(this, ChatNewActivity.class);
      localIntent.putExtra("chatForm", "ziruyi");
      startActivity(localIntent);
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  public void setGetPwdTime(int paramInt)
  {
    this.W.setText("支付剩余时间 " + paramInt / 60 + "分" + paramInt % 60 + "秒");
  }
  
  public void toBaiduMap()
  {
    if ((this.al != null) && (this.al.getData() != null) && (this.al.getData().getProjectAddress() != null))
    {
      String str = this.al.getData().lng + "," + this.al.getData().lat;
      Intent localIntent = new Intent(this, StationHouseMapLocationActivity.class);
      localIntent.putExtra("search_location", str);
      localIntent.putExtra("resblock_name", this.al.getData().getProjectAddress());
      startActivity(localIntent);
    }
  }
  
  private class a
    implements com.freelxl.baselibrary.e.i.a<String>
  {
    private a() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (OrderDetailActivity.a(OrderDetailActivity.this).isRefreshing())
      {
        OrderDetailActivity.a(OrderDetailActivity.this).onRefreshComplete();
        OrderDetailActivity.b(OrderDetailActivity.this);
      }
      OrderDetailActivity.a(OrderDetailActivity.this, (StationOrderDetailEntity)paramk.getObject());
      if (OrderDetailActivity.c(OrderDetailActivity.this) == null) {
        af.showToast(OrderDetailActivity.d(OrderDetailActivity.this), "服务器开小差了，请稍后再试");
      }
      for (;;)
      {
        return;
        if ((OrderDetailActivity.c(OrderDetailActivity.this) != null) && (!"200".equals(OrderDetailActivity.c(OrderDetailActivity.this).getError_code())) && (!TextUtils.isEmpty(OrderDetailActivity.c(OrderDetailActivity.this).getError_message())))
        {
          af.showToast(OrderDetailActivity.d(OrderDetailActivity.this), OrderDetailActivity.c(OrderDetailActivity.this).getError_message());
          return;
        }
        int i;
        label240:
        StringBuilder localStringBuilder;
        if ((OrderDetailActivity.c(OrderDetailActivity.this) != null) && (OrderDetailActivity.c(OrderDetailActivity.this).getData().remainTime > 0))
        {
          OrderDetailActivity.e(OrderDetailActivity.this).setVisibility(0);
          if (OrderDetailActivity.f(OrderDetailActivity.this) == null) {
            OrderDetailActivity.a(OrderDetailActivity.this, new OrderDetailActivity.c(OrderDetailActivity.this, OrderDetailActivity.this));
          }
          OrderDetailActivity.f(OrderDetailActivity.this).sendEmptyMessage(1);
          paramk = OrderDetailActivity.c(OrderDetailActivity.this).getData().getHouseTypeInfo();
          localObject = new StringBuilder();
          i = 0;
          if (i >= paramk.size()) {
            break label344;
          }
          localStringBuilder = ((StringBuilder)localObject).append(((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity)paramk.get(i)).getHouseShowName());
          if (((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity)paramk.get(i)).getStayPersonInfo() != null) {
            break label322;
          }
        }
        label322:
        for (int j = 0;; j = ((StationOrderDetailEntity.DataEntity.HouseTypeInfoEntity)paramk.get(i)).getStayPersonInfo().size())
        {
          localStringBuilder.append(j).append("人 ");
          i += 1;
          break label240;
          OrderDetailActivity.e(OrderDetailActivity.this).setVisibility(8);
          break;
        }
        label344:
        if (((StringBuilder)localObject).length() > 0) {
          ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
        }
        OrderDetailActivity.g(OrderDetailActivity.this).setText(((StringBuilder)localObject).toString());
        OrderDetailActivity.a(OrderDetailActivity.this, OrderDetailActivity.c(OrderDetailActivity.this).getData().getOrderStatus());
        OrderDetailActivity.a(OrderDetailActivity.this, OrderDetailActivity.h(OrderDetailActivity.this), OrderDetailActivity.c(OrderDetailActivity.this).getData().getOrderStatusDesc());
        OrderDetailActivity.b(OrderDetailActivity.this, OrderDetailActivity.h(OrderDetailActivity.this));
        OrderDetailActivity.i(OrderDetailActivity.this).setText(i.checkString(OrderDetailActivity.c(OrderDetailActivity.this).getData().getDName()));
        OrderDetailActivity.j(OrderDetailActivity.this).setText(i.checkString(OrderDetailActivity.c(OrderDetailActivity.this).getData().getOrderNumber()));
        OrderDetailActivity.k(OrderDetailActivity.this).setText(i.checkString(OrderDetailActivity.c(OrderDetailActivity.this).getData().getProjectAddress()));
        paramk = new SimpleDateFormat("yyyy-MM-dd");
        Object localObject = new SimpleDateFormat("yyyy年MM月dd日");
        try
        {
          OrderDetailActivity.l(OrderDetailActivity.this).setText(((SimpleDateFormat)localObject).format(paramk.parse(i.checkString(OrderDetailActivity.c(OrderDetailActivity.this).getData().getStartDate()))));
          OrderDetailActivity.m(OrderDetailActivity.this).setText(((SimpleDateFormat)localObject).format(paramk.parse(i.checkString(OrderDetailActivity.c(OrderDetailActivity.this).getData().getEndDate()))));
          OrderDetailActivity.o(OrderDetailActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(OrderDetailActivity.c(OrderDetailActivity.this).getData().getImgUrl(), new BaseControllerListener()
          {
            public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable)
            {
              super.onFailure(paramAnonymousString, paramAnonymousThrowable);
              OrderDetailActivity.n(OrderDetailActivity.this).setVisibility(0);
            }
            
            public void onFinalImageSet(String paramAnonymousString, Object paramAnonymousObject, Animatable paramAnonymousAnimatable)
            {
              super.onFinalImageSet(paramAnonymousString, paramAnonymousObject, paramAnonymousAnimatable);
              OrderDetailActivity.n(OrderDetailActivity.this).setVisibility(8);
            }
          }));
          OrderDetailActivity.p(OrderDetailActivity.this).setText(i.checkString(OrderDetailActivity.c(OrderDetailActivity.this).getData().getProjectName()));
          OrderDetailActivity.q(OrderDetailActivity.this).setText(i.checkString(OrderDetailActivity.c(OrderDetailActivity.this).getData().getPhone()));
        }
        catch (ParseException paramk)
        {
          try
          {
            if (OrderDetailActivity.c(OrderDetailActivity.this).getData().getAmount() != null)
            {
              i = (int)Float.parseFloat(OrderDetailActivity.c(OrderDetailActivity.this).getData().getAmount());
              OrderDetailActivity.r(OrderDetailActivity.this).setText("¥ " + i + "");
            }
          }
          catch (NumberFormatException paramk)
          {
            try
            {
              for (;;)
              {
                if (OrderDetailActivity.c(OrderDetailActivity.this).getData().getRefund() != null)
                {
                  i = (int)Float.parseFloat(OrderDetailActivity.c(OrderDetailActivity.this).getData().getRefund());
                  OrderDetailActivity.s(OrderDetailActivity.this).setText("¥ " + i + "");
                }
                OrderDetailActivity.a(OrderDetailActivity.this, OrderDetailActivity.c(OrderDetailActivity.this).getData().getSellPhone());
                if ((OrderDetailActivity.h(OrderDetailActivity.this) != 4) && (OrderDetailActivity.h(OrderDetailActivity.this) != 3) && (OrderDetailActivity.h(OrderDetailActivity.this) != 6) && (OrderDetailActivity.h(OrderDetailActivity.this) != 7)) {
                  break;
                }
                OrderDetailActivity.t(OrderDetailActivity.this);
                return;
                paramk = paramk;
                OrderDetailActivity.l(OrderDetailActivity.this).setText("未知");
                OrderDetailActivity.m(OrderDetailActivity.this).setText("未知");
                continue;
                paramk = paramk;
                OrderDetailActivity.r(OrderDetailActivity.this).setText(OrderDetailActivity.c(OrderDetailActivity.this).getData().getAmount());
              }
            }
            catch (NumberFormatException paramk)
            {
              for (;;)
              {
                OrderDetailActivity.s(OrderDetailActivity.this).setText(OrderDetailActivity.c(OrderDetailActivity.this).getData().getRefund());
              }
            }
          }
        }
      }
    }
  }
  
  private class b
  {
    private Context b;
    private View c;
    private PopupWindow d;
    private LinearLayout e;
    private RelativeLayout f;
    private long g;
    
    public b(Context paramContext, View paramView)
    {
      this.b = paramContext;
      this.c = paramView;
    }
    
    private void a(View paramView)
    {
      this.f = ((RelativeLayout)paramView.findViewById(2131697271));
      this.f.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          OrderDetailActivity.b.this.dismiss();
        }
      });
      this.e = ((LinearLayout)paramView.findViewById(2131697272));
      this.e.removeAllViews();
      int j = 0;
      int i = 1;
      if (j < OrderDetailActivity.v(OrderDetailActivity.this).getData().size())
      {
        if (((StationRoomPassword.DataEntity)OrderDetailActivity.v(OrderDetailActivity.this).getData().get(j)).getIs_past() != 0) {
          break label325;
        }
        Object localObject = LayoutInflater.from(this.b).inflate(2130904183, this.e, false);
        TextView localTextView1 = (TextView)((View)localObject).findViewById(2131694290);
        TextView localTextView2 = (TextView)((View)localObject).findViewById(2131694970);
        localTextView1.setText(((StationRoomPassword.DataEntity)OrderDetailActivity.v(OrderDetailActivity.this).getData().get(j)).getAreCode());
        localTextView2.setText(((StationRoomPassword.DataEntity)OrderDetailActivity.v(OrderDetailActivity.this).getData().get(j)).getPassWord());
        this.e.addView((View)localObject);
        if (i == 0) {
          break label325;
        }
        localObject = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        ((TextView)paramView.findViewById(2131697273)).setText(i.checkString(((SimpleDateFormat)localObject).format(new Date(((StationRoomPassword.DataEntity)OrderDetailActivity.v(OrderDetailActivity.this).getData().get(j)).getStartDate()))));
        ((TextView)paramView.findViewById(2131697274)).setText(i.checkString(((SimpleDateFormat)localObject).format(new Date(((StationRoomPassword.DataEntity)OrderDetailActivity.v(OrderDetailActivity.this).getData().get(j)).getEndDate()))));
        i = 0;
      }
      label325:
      for (;;)
      {
        j += 1;
        break;
        return;
      }
    }
    
    public void dismiss()
    {
      if ((this.d != null) && (this.d.isShowing())) {
        this.d.dismiss();
      }
    }
    
    public PopupWindow getWindow()
    {
      return this.d;
    }
    
    public void showPopwindow()
    {
      Object localObject = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2130905033, null);
      a((View)localObject);
      this.d = new PopupWindow((View)localObject, -1, -1);
      this.d.setFocusable(true);
      localObject = new ColorDrawable(-167772161);
      this.d.setBackgroundDrawable((Drawable)localObject);
      localObject = this.d;
      View localView = this.c;
      if (!(localObject instanceof PopupWindow)) {
        ((PopupWindow)localObject).showAtLocation(localView, 0, 0, 0);
      }
      for (;;)
      {
        this.g = System.currentTimeMillis();
        this.d.setOnDismissListener(new PopupWindow.OnDismissListener()
        {
          public void onDismiss()
          {
            w.onDuration("zinn_det_yrz_passwd_duration", (int)((System.currentTimeMillis() - OrderDetailActivity.b.a(OrderDetailActivity.b.this)) / 1000L));
          }
        });
        return;
        VdsAgent.showAtLocation((PopupWindow)localObject, localView, 0, 0, 0);
      }
    }
  }
  
  public class c
    extends Handler
  {
    private WeakReference<Context> b;
    private int c;
    
    public c(Context paramContext)
    {
      this.b = new WeakReference(paramContext);
    }
    
    public void handleMessage(Message paramMessage)
    {
      OrderDetailActivity localOrderDetailActivity = (OrderDetailActivity)this.b.get();
      if (paramMessage != null) {}
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        this.c = OrderDetailActivity.c(OrderDetailActivity.this).getData().remainTime;
        localOrderDetailActivity.setGetPwdTime(this.c);
        OrderDetailActivity.f(localOrderDetailActivity).removeMessages(2);
        OrderDetailActivity.f(localOrderDetailActivity).sendEmptyMessageDelayed(2, 1000L);
        return;
      case 2: 
        if (this.c > 0)
        {
          this.c -= 1;
          OrderDetailActivity.f(localOrderDetailActivity).sendEmptyMessage(3);
          OrderDetailActivity.f(localOrderDetailActivity).sendEmptyMessageDelayed(2, 1000L);
          return;
        }
        OrderDetailActivity.f(localOrderDetailActivity).sendEmptyMessage(4);
        return;
      case 3: 
        localOrderDetailActivity.setGetPwdTime(this.c);
        return;
      }
      localOrderDetailActivity.resetGetPwd();
    }
    
    public void setContext(Context paramContext)
    {
      this.b = new WeakReference(paramContext);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/OrderDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */