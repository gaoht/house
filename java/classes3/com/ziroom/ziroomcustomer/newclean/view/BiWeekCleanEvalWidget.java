package com.ziroom.ziroomcustomer.newclean.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.c.k;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.model.w;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar.a;
import com.ziroom.ziroomcustomer.newclean.b.ac;
import com.ziroom.ziroomcustomer.newclean.b.j.a;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.d.h;
import com.ziroom.ziroomcustomer.newclean.d.h.a;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHDicTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BiWeekCleanEvalWidget
  extends LinearLayout
{
  private List<String> A = new ArrayList();
  private boolean B = true;
  private LinearLayout C;
  private RightAnimationView D;
  private boolean E = true;
  private int F = 0;
  private boolean G = false;
  private LinearLayout H;
  private String I;
  private View J;
  private SimpleDraweeView K;
  private MyGridView L;
  private ImageView M;
  private ac N;
  private List<String> O = new ArrayList();
  private Context a;
  private h b;
  private a c;
  private ImageView d;
  private LinearLayout e;
  private SimpleDraweeView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private RatingStar m;
  private MyGridView n;
  private FrameLayout o;
  private EditText p;
  private View q;
  private LinearLayout r;
  private LinearLayout s;
  private List<w> t = new ArrayList();
  private List<w> u = new ArrayList();
  private List<w> v = new ArrayList();
  private com.ziroom.ziroomcustomer.newclean.b.j w;
  private int x = 0;
  private String y = "";
  private List<w> z = new ArrayList();
  
  public BiWeekCleanEvalWidget(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public BiWeekCleanEvalWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  public BiWeekCleanEvalWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
  }
  
  private void a()
  {
    setOrientation(1);
    View localView = LayoutInflater.from(this.a).inflate(2130904672, null);
    this.d = ((ImageView)localView.findViewById(2131689492));
    this.r = ((LinearLayout)localView.findViewById(2131690204));
    this.s = ((LinearLayout)localView.findViewById(2131693935));
    this.e = ((LinearLayout)localView.findViewById(2131695820));
    this.f = ((SimpleDraweeView)localView.findViewById(2131695994));
    this.g = ((TextView)localView.findViewById(2131690912));
    this.m = ((RatingStar)localView.findViewById(2131690595));
    this.h = ((TextView)localView.findViewById(2131695995));
    this.n = ((MyGridView)localView.findViewById(2131695998));
    this.o = ((FrameLayout)localView.findViewById(2131695999));
    this.p = ((EditText)localView.findViewById(2131690002));
    this.i = ((TextView)localView.findViewById(2131696000));
    this.l = ((TextView)localView.findViewById(2131696001));
    this.C = ((LinearLayout)localView.findViewById(2131695997));
    this.D = ((RightAnimationView)localView.findViewById(2131696002));
    this.j = ((TextView)localView.findViewById(2131696003));
    this.k = ((TextView)localView.findViewById(2131696004));
    this.H = ((LinearLayout)localView.findViewById(2131695993));
    this.J = localView.findViewById(2131696005);
    this.K = ((SimpleDraweeView)localView.findViewById(2131696006));
    this.q = localView.findViewById(2131695996);
    this.L = ((MyGridView)localView.findViewById(2131696007));
    this.M = ((ImageView)localView.findViewById(2131696008));
    addView(localView);
  }
  
  private void a(final String paramString)
  {
    com.ziroom.ziroomcustomer.e.n.getCommonDicTag(this.a, paramString, new com.ziroom.ziroomcustomer.e.a.a(this.a, new l(MHDicTag.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<MHDicTag> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        MHDicTag localMHDicTag;
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          BiWeekCleanEvalWidget.b(BiWeekCleanEvalWidget.this, 0);
          if (!"CleanPositiveEvaluateEnum".equals(paramString)) {
            break label234;
          }
          BiWeekCleanEvalWidget.u(BiWeekCleanEvalWidget.this).clear();
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            localMHDicTag = (MHDicTag)paramAnonymousList.next();
            BiWeekCleanEvalWidget.u(BiWeekCleanEvalWidget.this).add(new w(localMHDicTag.getTagValue(), false));
          }
          if (!com.ziroom.ziroomcustomer.newServiceList.utils.j.isEven(BiWeekCleanEvalWidget.u(BiWeekCleanEvalWidget.this).size())) {
            break label186;
          }
          paramAnonymousInt = BiWeekCleanEvalWidget.u(BiWeekCleanEvalWidget.this).size() / 2 * 30 + 12 + (BiWeekCleanEvalWidget.u(BiWeekCleanEvalWidget.this).size() / 2 - 1) * 14;
          BiWeekCleanEvalWidget.b(BiWeekCleanEvalWidget.this, paramAnonymousInt + 238);
          BiWeekCleanEvalWidget.k(BiWeekCleanEvalWidget.this);
        }
        label186:
        label234:
        while (!"CleanNegativeEvaluateEnum".equals(paramString)) {
          for (;;)
          {
            return;
            paramAnonymousInt = (BiWeekCleanEvalWidget.u(BiWeekCleanEvalWidget.this).size() + 1) / 2 * 30 + 12 + ((BiWeekCleanEvalWidget.u(BiWeekCleanEvalWidget.this).size() + 1) / 2 - 1) * 14;
          }
        }
        BiWeekCleanEvalWidget.v(BiWeekCleanEvalWidget.this).clear();
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          localMHDicTag = (MHDicTag)paramAnonymousList.next();
          BiWeekCleanEvalWidget.v(BiWeekCleanEvalWidget.this).add(new w(localMHDicTag.getTagValue(), false));
        }
        if (com.ziroom.ziroomcustomer.newServiceList.utils.j.isEven(BiWeekCleanEvalWidget.v(BiWeekCleanEvalWidget.this).size())) {}
        for (paramAnonymousInt = BiWeekCleanEvalWidget.v(BiWeekCleanEvalWidget.this).size() / 2 * 30 + 12 + (BiWeekCleanEvalWidget.v(BiWeekCleanEvalWidget.this).size() / 2 - 1) * 14;; paramAnonymousInt = (BiWeekCleanEvalWidget.v(BiWeekCleanEvalWidget.this).size() + 1) / 2 * 30 + 12 + ((BiWeekCleanEvalWidget.v(BiWeekCleanEvalWidget.this).size() + 1) / 2 - 1) * 14)
        {
          BiWeekCleanEvalWidget.b(BiWeekCleanEvalWidget.this, paramAnonymousInt + 238);
          BiWeekCleanEvalWidget.l(BiWeekCleanEvalWidget.this);
          return;
        }
      }
    });
  }
  
  private void b()
  {
    this.I = this.b.getOrderId();
    if (!TextUtils.isEmpty(this.b.getEmployeeDetailVO().getCleanerId()))
    {
      this.f.setController(c.frescoController(this.b.getEmployeeDetailVO().getHeadPic()));
      this.g.setText(this.b.getEmployeeDetailVO().getName());
    }
    this.w = new com.ziroom.ziroomcustomer.newclean.b.j(this.a, this.v);
    this.w.setCleanEvalTagListListener(new j.a()
    {
      public void tagList(List<w> paramAnonymousList)
      {
        if (paramAnonymousList != null) {
          BiWeekCleanEvalWidget.a(BiWeekCleanEvalWidget.this, paramAnonymousList);
        }
      }
    });
    this.n.setAdapter(this.w);
    this.N = new ac(this.a, this.O);
    this.L.setAdapter(this.N);
    this.H.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (BiWeekCleanEvalWidget.a(BiWeekCleanEvalWidget.this) != null) {
          BiWeekCleanEvalWidget.a(BiWeekCleanEvalWidget.this).evalCancleDialog(BiWeekCleanEvalWidget.b(BiWeekCleanEvalWidget.this));
        }
      }
    });
    this.p.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 60)
        {
          BiWeekCleanEvalWidget.c(BiWeekCleanEvalWidget.this).setText("60/60");
          g.textToast(BiWeekCleanEvalWidget.d(BiWeekCleanEvalWidget.this), "字数超出限制!");
          BiWeekCleanEvalWidget.e(BiWeekCleanEvalWidget.this).setText(paramAnonymousCharSequence.subSequence(0, 60));
          BiWeekCleanEvalWidget.e(BiWeekCleanEvalWidget.this).setSelection(BiWeekCleanEvalWidget.e(BiWeekCleanEvalWidget.this).length());
          return;
        }
        BiWeekCleanEvalWidget.c(BiWeekCleanEvalWidget.this).setText(paramAnonymousCharSequence.length() + "/60");
      }
    });
    this.l.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        BiWeekCleanEvalWidget.f(BiWeekCleanEvalWidget.this);
      }
    });
    this.m.setOnStarScoreListener(new RatingStar.a()
    {
      public void starScore(int paramAnonymousInt)
      {
        BiWeekCleanEvalWidget.a(BiWeekCleanEvalWidget.this, paramAnonymousInt);
        BiWeekCleanEvalWidget.g(BiWeekCleanEvalWidget.this).clear();
        BiWeekCleanEvalWidget.h(BiWeekCleanEvalWidget.this).clear();
        BiWeekCleanEvalWidget.j(BiWeekCleanEvalWidget.this).setText(com.ziroom.ziroomcustomer.newServiceList.utils.j.getStarDesc(BiWeekCleanEvalWidget.i(BiWeekCleanEvalWidget.this)));
        BiWeekCleanEvalWidget.j(BiWeekCleanEvalWidget.this).setTextColor(40960);
        if (paramAnonymousInt > 3)
        {
          BiWeekCleanEvalWidget.k(BiWeekCleanEvalWidget.this);
          return;
        }
        BiWeekCleanEvalWidget.l(BiWeekCleanEvalWidget.this);
      }
    });
  }
  
  private void c()
  {
    String str2 = VdsAgent.trackEditTextSilent(this.p).toString();
    Object localObject1 = ApplicationEx.c.getUser();
    if (localObject1 == null)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      return;
    }
    String str3 = ((UserInfo)localObject1).getUid();
    Object localObject3 = "";
    String str1 = "";
    Object localObject4 = localObject3;
    Object localObject2 = str1;
    if (this.z != null)
    {
      localObject4 = localObject3;
      localObject2 = str1;
      if (this.z.size() > 0)
      {
        localObject1 = this.z.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (w)((Iterator)localObject1).next();
          if (((w)localObject2).isSelect()) {
            this.A.add(((w)localObject2).getTypeName());
          }
        }
        localObject1 = localObject3;
        if ("positive".equals(this.y))
        {
          localObject2 = this.A.iterator();
          localObject1 = localObject3;
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (String)((Iterator)localObject2).next();
            if (this.A.size() == 1) {}
            for (;;)
            {
              localObject3 = localObject1;
              break;
              localObject1 = (String)localObject3 + ";" + (String)localObject1;
            }
          }
        }
        localObject4 = localObject1;
        localObject2 = str1;
        if ("negative".equals(this.y))
        {
          Iterator localIterator = this.A.iterator();
          localObject3 = str1;
          localObject4 = localObject1;
          localObject2 = localObject3;
          if (localIterator.hasNext())
          {
            localObject2 = (String)localIterator.next();
            if (this.A.size() == 1) {}
            for (;;)
            {
              localObject3 = localObject2;
              break;
              localObject2 = (String)localObject3 + ";" + (String)localObject2;
            }
          }
        }
      }
    }
    localObject1 = "";
    if ("positive".equals(this.y)) {
      localObject1 = localObject4;
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.e.n.postBiweeklyCleanEval(this.a, this.I, str2, this.x, (String)localObject1, str3, new com.ziroom.ziroomcustomer.e.a.a(this.a, new k(new com.ziroom.ziroomcustomer.e.c.a.a()))
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          BiWeekCleanEvalWidget.m(BiWeekCleanEvalWidget.this).setBackgroundColor(-1);
          BiWeekCleanEvalWidget.n(BiWeekCleanEvalWidget.this).setVisibility(0);
          BiWeekCleanEvalWidget.o(BiWeekCleanEvalWidget.this).setVisibility(0);
          BiWeekCleanEvalWidget.p(BiWeekCleanEvalWidget.this).setVisibility(0);
          BiWeekCleanEvalWidget.q(BiWeekCleanEvalWidget.this).setVisibility(0);
          BiWeekCleanEvalWidget.r(BiWeekCleanEvalWidget.this).setClickable(false);
          BiWeekCleanEvalWidget.r(BiWeekCleanEvalWidget.this).setClickable(false);
          BiWeekCleanEvalWidget.e(BiWeekCleanEvalWidget.this).setFocusable(false);
          BiWeekCleanEvalWidget.e(BiWeekCleanEvalWidget.this).setFocusableInTouchMode(false);
          Bundle localBundle = new Bundle();
          localBundle.putString("thumbType", "clean");
          localBundle.putString("showType", "eval");
          localBundle.putString("orderCode", BiWeekCleanEvalWidget.s(BiWeekCleanEvalWidget.this));
          localBundle.putString("orderNum", BiWeekCleanEvalWidget.t(BiWeekCleanEvalWidget.this).getOrderNum());
          localBundle.putString("employeeCode", BiWeekCleanEvalWidget.t(BiWeekCleanEvalWidget.this).getEmployeeDetailVO().getCleanerId());
          com.ziroom.ziroomcustomer.newServiceList.utils.j.setServantThumb(BiWeekCleanEvalWidget.d(BiWeekCleanEvalWidget.this), BiWeekCleanEvalWidget.q(BiWeekCleanEvalWidget.this), localBundle);
          if (BiWeekCleanEvalWidget.a(BiWeekCleanEvalWidget.this) != null) {
            BiWeekCleanEvalWidget.a(BiWeekCleanEvalWidget.this).evalStatus(true);
          }
          if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("investigationSwitch")) && ("on".equals(paramAnonymouse.getString("investigationSwitch"))) && (BiWeekCleanEvalWidget.a(BiWeekCleanEvalWidget.this) != null)) {
            BiWeekCleanEvalWidget.a(BiWeekCleanEvalWidget.this).evalToQuestion(true);
          }
        }
      });
      return;
      if ("negative".equals(this.y)) {
        localObject1 = localObject2;
      }
    }
  }
  
  private void d()
  {
    this.y = "positive";
    if ((this.t != null) && (this.t.size() > 0))
    {
      this.v.clear();
      this.v.addAll(this.t);
      this.w.notifyDataSetChanged();
      f();
      return;
    }
    a("CleanPositiveEvaluateEnum");
  }
  
  private void e()
  {
    this.y = "negative";
    if ((this.u != null) && (this.u.size() > 0))
    {
      this.v.clear();
      this.v.addAll(this.u);
      this.w.notifyDataSetChanged();
      f();
      return;
    }
    a("CleanNegativeEvaluateEnum");
  }
  
  private void f()
  {
    if (this.E)
    {
      this.E = false;
      this.q.setVisibility(8);
      com.ziroom.ziroomcustomer.newServiceList.utils.j.showServceEvalTran(true, this.C, com.ziroom.ziroomcustomer.util.n.dip2px(this.a, this.F + 82));
      com.ziroom.ziroomcustomer.newServiceList.utils.j.showServceEvalTran(false, this.e, com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 133.0F));
      ViewGroup.LayoutParams localLayoutParams = this.s.getLayoutParams();
      localLayoutParams.height = com.ziroom.ziroomcustomer.util.n.dip2px(this.a, this.F + 68);
      this.s.setLayoutParams(localLayoutParams);
    }
  }
  
  public MyGridView getmGvCamera()
  {
    return this.L;
  }
  
  public void setCameraAdaperData(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        break label31;
      }
      this.M.setVisibility(8);
    }
    for (;;)
    {
      this.N.setData(paramList);
      return;
      label31:
      this.M.setVisibility(0);
    }
  }
  
  public void setCleanDetailInfo(h paramh)
  {
    this.b = paramh;
    a();
    b();
  }
  
  public void setCleanEvalListener(a parama)
  {
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract void evalCancleDialog(boolean paramBoolean);
    
    public abstract void evalStatus(boolean paramBoolean);
    
    public abstract void evalToQuestion(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/view/BiWeekCleanEvalWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */