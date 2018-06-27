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
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.model.bn;
import com.ziroom.ziroomcustomer.newServiceList.model.w;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar.a;
import com.ziroom.ziroomcustomer.newclean.b.ac;
import com.ziroom.ziroomcustomer.newclean.b.j.a;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newmovehouse.model.ServiceDicItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleanEvalWidget
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
  private String L;
  private MyGridView M;
  private TextView N;
  private ac O;
  private List<String> P = new ArrayList();
  private int Q;
  private String R;
  private List<ServiceDicItem> S = new ArrayList();
  private int T = 0;
  private TextView U;
  private Context a;
  private a b;
  private ImageView c;
  private LinearLayout d;
  private SimpleDraweeView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private View l;
  private RatingStar m;
  private MyGridView n;
  private FrameLayout o;
  private EditText p;
  private LinearLayout q;
  private LinearLayout r;
  private List<w> s = new ArrayList();
  private List<w> t = new ArrayList();
  private List<w> u = new ArrayList();
  private com.ziroom.ziroomcustomer.newclean.b.j v;
  private int w = 0;
  private String x;
  private String y = "";
  private List<w> z = new ArrayList();
  
  public CleanEvalWidget(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public CleanEvalWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  public CleanEvalWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
  }
  
  private void a()
  {
    setOrientation(1);
    View localView = LayoutInflater.from(this.a).inflate(2130904672, null);
    this.c = ((ImageView)localView.findViewById(2131689492));
    this.q = ((LinearLayout)localView.findViewById(2131690204));
    this.r = ((LinearLayout)localView.findViewById(2131693935));
    this.d = ((LinearLayout)localView.findViewById(2131695820));
    this.e = ((SimpleDraweeView)localView.findViewById(2131695994));
    this.f = ((TextView)localView.findViewById(2131690912));
    this.m = ((RatingStar)localView.findViewById(2131690595));
    this.g = ((TextView)localView.findViewById(2131695995));
    this.n = ((MyGridView)localView.findViewById(2131695998));
    this.o = ((FrameLayout)localView.findViewById(2131695999));
    this.p = ((EditText)localView.findViewById(2131690002));
    this.h = ((TextView)localView.findViewById(2131696000));
    this.k = ((TextView)localView.findViewById(2131696001));
    this.C = ((LinearLayout)localView.findViewById(2131695997));
    this.D = ((RightAnimationView)localView.findViewById(2131696002));
    this.i = ((TextView)localView.findViewById(2131696003));
    this.j = ((TextView)localView.findViewById(2131696004));
    this.H = ((LinearLayout)localView.findViewById(2131695993));
    this.J = localView.findViewById(2131696005);
    this.K = ((SimpleDraweeView)localView.findViewById(2131696006));
    this.l = localView.findViewById(2131695996);
    this.M = ((MyGridView)localView.findViewById(2131696007));
    this.N = ((TextView)localView.findViewById(2131696008));
    this.U = ((TextView)localView.findViewById(2131690953));
    addView(localView);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    com.ziroom.ziroomcustomer.e.n.getWeekCleanerInfo(this.a, paramString, new com.freelxl.baselibrary.d.c.a(new m(bn.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, bn paramAnonymousbn)
      {
        if (paramAnonymousbn != null)
        {
          CleanEvalWidget.x(CleanEvalWidget.this).setController(c.frescoController(paramAnonymousbn.getHeadPic()));
          CleanEvalWidget.y(CleanEvalWidget.this).setText(paramAnonymousbn.getName());
        }
      }
    });
  }
  
  private void b()
  {
    this.N.setText(this.R);
    a(this.I);
    this.v = new com.ziroom.ziroomcustomer.newclean.b.j(this.a, this.u);
    this.v.setCleanEvalTagListListener(new j.a()
    {
      public void tagList(List<w> paramAnonymousList)
      {
        if (paramAnonymousList != null) {
          CleanEvalWidget.a(CleanEvalWidget.this, paramAnonymousList);
        }
      }
    });
    if (this.Q == 1) {
      this.N.setVisibility(0);
    }
    for (;;)
    {
      this.n.setAdapter(this.v);
      this.O = new ac(this.a, this.P);
      this.M.setAdapter(this.O);
      this.H.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
        }
      });
      this.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (CleanEvalWidget.a(CleanEvalWidget.this) != null) {
            CleanEvalWidget.a(CleanEvalWidget.this).evalCancleDialog(CleanEvalWidget.b(CleanEvalWidget.this));
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
            CleanEvalWidget.c(CleanEvalWidget.this).setText("60/60");
            g.textToast(CleanEvalWidget.d(CleanEvalWidget.this), "字数超出限制!");
            CleanEvalWidget.e(CleanEvalWidget.this).setText(paramAnonymousCharSequence.subSequence(0, 60));
            CleanEvalWidget.e(CleanEvalWidget.this).setSelection(CleanEvalWidget.e(CleanEvalWidget.this).length());
            return;
          }
          CleanEvalWidget.c(CleanEvalWidget.this).setText(paramAnonymousCharSequence.length() + "/60");
        }
      });
      this.U.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          CleanEvalWidget.f(CleanEvalWidget.this);
        }
      });
      this.m.setOnStarScoreListener(new RatingStar.a()
      {
        public void starScore(int paramAnonymousInt)
        {
          CleanEvalWidget.a(CleanEvalWidget.this, paramAnonymousInt);
          CleanEvalWidget.g(CleanEvalWidget.this).clear();
          CleanEvalWidget.h(CleanEvalWidget.this).clear();
          CleanEvalWidget.j(CleanEvalWidget.this).setText(com.ziroom.ziroomcustomer.newServiceList.utils.j.getStarDesc(CleanEvalWidget.i(CleanEvalWidget.this)));
          CleanEvalWidget.j(CleanEvalWidget.this).setTextColor(40960);
          CleanEvalWidget.k(CleanEvalWidget.this);
        }
      });
      return;
      this.N.setVisibility(8);
    }
  }
  
  private void c()
  {
    if (this.w == 0) {
      return;
    }
    if ((this.S != null) && (this.S.size() > 0))
    {
      d();
      return;
    }
    com.ziroom.ziroomcustomer.e.n.getServiceDic(this.a, "CleanEvaluateTagEnum", new com.ziroom.ziroomcustomer.e.a.a(this.a, new l(ServiceDicItem.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, List<ServiceDicItem> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          CleanEvalWidget.l(CleanEvalWidget.this).addAll(paramAnonymousList);
          CleanEvalWidget.m(CleanEvalWidget.this);
        }
      }
    });
  }
  
  private void d()
  {
    this.F = 0;
    this.s.clear();
    Iterator localIterator = this.S.iterator();
    while (localIterator.hasNext())
    {
      ServiceDicItem localServiceDicItem = (ServiceDicItem)localIterator.next();
      if (this.w == localServiceDicItem.getDictionaryType()) {
        this.s.add(new w(localServiceDicItem.getDictionaryValue(), false));
      }
    }
    if (com.ziroom.ziroomcustomer.newServiceList.utils.j.isEven(this.s.size())) {}
    for (int i1 = this.s.size() / 2 * 28 + 12 + (this.s.size() / 2 - 1) * 12;; i1 = (this.s.size() + 1) / 2 * 28 + 12 + ((this.s.size() + 1) / 2 - 1) * 12)
    {
      this.F = (i1 + 238);
      e();
      return;
    }
  }
  
  private void e()
  {
    this.u.clear();
    this.u.addAll(this.s);
    this.v.notifyDataSetChanged();
    f();
  }
  
  private void f()
  {
    if (this.T != this.F)
    {
      this.T = this.F;
      com.ziroom.ziroomcustomer.newServiceList.utils.j.showServceEvalTran(true, this.C, com.ziroom.ziroomcustomer.util.n.dip2px(this.a, this.F + 74));
      ViewGroup.LayoutParams localLayoutParams = this.r.getLayoutParams();
      localLayoutParams.height = com.ziroom.ziroomcustomer.util.n.dip2px(this.a, this.F + 74 + 68);
      this.r.setLayoutParams(localLayoutParams);
    }
    if (this.E)
    {
      this.E = false;
      this.l.setVisibility(8);
      com.ziroom.ziroomcustomer.newServiceList.utils.j.showServceEvalTran(false, this.d, com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 133.0F));
      this.U.setVisibility(0);
    }
  }
  
  private void g()
  {
    String str1 = VdsAgent.trackEditTextSilent(this.p).toString();
    Object localObject1 = ApplicationEx.c.getUser();
    if (localObject1 == null)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      return;
    }
    String str2 = ((UserInfo)localObject1).getUid();
    String str3 = ((UserInfo)localObject1).getPhone();
    localObject1 = "";
    Object localObject2 = localObject1;
    if (this.z != null)
    {
      localObject2 = localObject1;
      if (this.z.size() > 0)
      {
        localObject2 = this.z.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (w)((Iterator)localObject2).next();
          if (((w)localObject3).isSelect()) {
            this.A.add(((w)localObject3).getTypeName());
          }
        }
        localObject3 = this.A.iterator();
        localObject2 = localObject1;
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (String)((Iterator)localObject3).next();
          if (this.A.size() == 1) {}
          for (localObject1 = localObject2;; localObject1 = (String)localObject1 + ";" + (String)localObject2) {
            break;
          }
        }
      }
    }
    if (((this.w == 1) || (this.w == 2)) && (TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty(str1)))
    {
      g.textToast(this.a, "非常抱歉，请告诉我们原因，我们会做的更好");
      return;
    }
    localObject1 = new ArrayList();
    Object localObject3 = this.P.iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((List)localObject1).add(((String)((Iterator)localObject3).next()).replace("http://pic.ziroom.com/sms2/pics/", ""));
    }
    com.ziroom.ziroomcustomer.e.n.saveGenerCleanerEval(this.a, str1, this.w, str2, this.x, (String)localObject2, "", str3, (List)localObject1, new com.freelxl.baselibrary.d.c.a(new m(com.ziroom.ziroomcustomer.newServiceList.model.n.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.ziroom.ziroomcustomer.newServiceList.utils.j.showFailureMessage(CleanEvalWidget.d(CleanEvalWidget.this), paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.newServiceList.model.n paramAnonymousn)
      {
        CleanEvalWidget.n(CleanEvalWidget.this).setVisibility(8);
        CleanEvalWidget.o(CleanEvalWidget.this).setBackgroundColor(-1);
        CleanEvalWidget.o(CleanEvalWidget.this).setVisibility(0);
        CleanEvalWidget.p(CleanEvalWidget.this).setVisibility(0);
        CleanEvalWidget.q(CleanEvalWidget.this).setVisibility(0);
        CleanEvalWidget.r(CleanEvalWidget.this).setVisibility(0);
        CleanEvalWidget.s(CleanEvalWidget.this).setVisibility(0);
        CleanEvalWidget.t(CleanEvalWidget.this).setVisibility(0);
        CleanEvalWidget.n(CleanEvalWidget.this).setClickable(false);
        CleanEvalWidget.e(CleanEvalWidget.this).setFocusable(false);
        CleanEvalWidget.e(CleanEvalWidget.this).setFocusableInTouchMode(false);
        Bundle localBundle = new Bundle();
        localBundle.putString("thumbType", "clean");
        localBundle.putString("showType", "eval");
        localBundle.putString("orderCode", CleanEvalWidget.u(CleanEvalWidget.this));
        localBundle.putString("orderNum", CleanEvalWidget.v(CleanEvalWidget.this));
        localBundle.putString("employeeCode", CleanEvalWidget.w(CleanEvalWidget.this));
        com.ziroom.ziroomcustomer.newServiceList.utils.j.setServantThumb(CleanEvalWidget.d(CleanEvalWidget.this), CleanEvalWidget.t(CleanEvalWidget.this), localBundle);
        if (CleanEvalWidget.a(CleanEvalWidget.this) != null) {
          CleanEvalWidget.a(CleanEvalWidget.this).evalStatus(true);
        }
        if ((paramAnonymousn != null) && ("on".equals(paramAnonymousn.getInvestigationSwitch())))
        {
          CleanEvalWidget.a(CleanEvalWidget.this, true);
          if (CleanEvalWidget.a(CleanEvalWidget.this) != null) {
            CleanEvalWidget.a(CleanEvalWidget.this).evalToQuestion(true);
          }
        }
      }
    });
  }
  
  public MyGridView getmGvCamera()
  {
    return this.M;
  }
  
  public void setCameraAdaperData(List<String> paramList)
  {
    this.P = paramList;
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        break label36;
      }
      this.N.setVisibility(8);
    }
    for (;;)
    {
      this.O.setData(paramList);
      return;
      label36:
      if (this.Q == 1) {
        this.N.setVisibility(0);
      } else {
        this.N.setVisibility(8);
      }
    }
  }
  
  public void setCleanDetailInfo(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    this.x = paramString1;
    this.I = paramString2;
    this.L = paramString3;
    this.Q = paramInt;
    this.R = paramString4;
    a();
    b();
  }
  
  public void setCleanEvalListener(a parama)
  {
    this.b = parama;
  }
  
  public static abstract interface a
  {
    public abstract void evalCancleDialog(boolean paramBoolean);
    
    public abstract void evalStatus(boolean paramBoolean);
    
    public abstract void evalToQuestion(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/view/CleanEvalWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */