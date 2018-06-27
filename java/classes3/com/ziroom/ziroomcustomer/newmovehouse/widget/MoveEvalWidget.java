package com.ziroom.ziroomcustomer.newmovehouse.widget;

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
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar.a;
import com.ziroom.ziroomcustomer.newclean.b.ac;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.view.RightAnimationView;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail.SupplierEmployeeInfoVOBean;
import com.ziroom.ziroomcustomer.util.af;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MoveEvalWidget
  extends LinearLayout
{
  private SimpleDraweeView A;
  private MyGridView B;
  private TextView C;
  private ac D;
  private List<String> E = new ArrayList();
  private int F;
  private String G;
  private Context a;
  private MovingVanDetail b;
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
  private View m;
  private RatingStar n;
  private FrameLayout o;
  private EditText p;
  private LinearLayout q;
  private LinearLayout r;
  private int s = 0;
  private String t;
  private LinearLayout u;
  private RightAnimationView v;
  private boolean w = true;
  private boolean x = false;
  private LinearLayout y;
  private View z;
  
  public MoveEvalWidget(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public MoveEvalWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  public MoveEvalWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
  }
  
  private void a()
  {
    setOrientation(1);
    View localView = LayoutInflater.from(this.a).inflate(2130904745, null);
    this.d = ((ImageView)localView.findViewById(2131689492));
    this.q = ((LinearLayout)localView.findViewById(2131690204));
    this.r = ((LinearLayout)localView.findViewById(2131693935));
    this.e = ((LinearLayout)localView.findViewById(2131695820));
    this.f = ((SimpleDraweeView)localView.findViewById(2131695994));
    this.g = ((TextView)localView.findViewById(2131690912));
    this.n = ((RatingStar)localView.findViewById(2131690595));
    this.h = ((TextView)localView.findViewById(2131695995));
    this.o = ((FrameLayout)localView.findViewById(2131695999));
    this.p = ((EditText)localView.findViewById(2131690002));
    this.i = ((TextView)localView.findViewById(2131696000));
    this.l = ((TextView)localView.findViewById(2131696001));
    this.u = ((LinearLayout)localView.findViewById(2131695997));
    this.v = ((RightAnimationView)localView.findViewById(2131696002));
    this.j = ((TextView)localView.findViewById(2131696003));
    this.k = ((TextView)localView.findViewById(2131696004));
    this.y = ((LinearLayout)localView.findViewById(2131695993));
    this.z = localView.findViewById(2131696005);
    this.A = ((SimpleDraweeView)localView.findViewById(2131696006));
    this.m = localView.findViewById(2131695996);
    this.B = ((MyGridView)localView.findViewById(2131696007));
    this.C = ((TextView)localView.findViewById(2131696008));
    addView(localView);
  }
  
  private void b()
  {
    this.C.setText(this.G);
    this.t = this.b.getLogicCode();
    if (this.b.getSupplierEmployeeInfoVO() != null)
    {
      this.f.setController(c.frescoController(this.b.getSupplierEmployeeInfoVO().getHeadPicture()));
      this.g.setText(this.b.getSupplierEmployeeInfoVO().getTrueName());
    }
    this.D = new ac(this.a, this.E);
    this.B.setAdapter(this.D);
    if (this.F == 1) {
      this.C.setVisibility(0);
    }
    for (;;)
    {
      this.y.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
        }
      });
      this.n.setOnStarScoreListener(new RatingStar.a()
      {
        public void starScore(int paramAnonymousInt)
        {
          MoveEvalWidget.a(MoveEvalWidget.this);
          MoveEvalWidget.a(MoveEvalWidget.this, paramAnonymousInt);
          MoveEvalWidget.c(MoveEvalWidget.this).setText(j.getStarDesc(MoveEvalWidget.b(MoveEvalWidget.this)));
          MoveEvalWidget.c(MoveEvalWidget.this).setTextColor(40960);
        }
      });
      this.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (MoveEvalWidget.d(MoveEvalWidget.this) != null) {
            MoveEvalWidget.d(MoveEvalWidget.this).evalCancleDialog(MoveEvalWidget.e(MoveEvalWidget.this));
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
            MoveEvalWidget.f(MoveEvalWidget.this).setText("60/60");
            af.showToast(MoveEvalWidget.g(MoveEvalWidget.this), "字数超出限制!");
            MoveEvalWidget.h(MoveEvalWidget.this).setText(paramAnonymousCharSequence.subSequence(0, 60));
            MoveEvalWidget.h(MoveEvalWidget.this).setSelection(MoveEvalWidget.h(MoveEvalWidget.this).length());
            return;
          }
          MoveEvalWidget.f(MoveEvalWidget.this).setText(paramAnonymousCharSequence.length() + "/60");
        }
      });
      this.l.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MoveEvalWidget.i(MoveEvalWidget.this);
        }
      });
      return;
      this.C.setVisibility(8);
    }
  }
  
  private void c()
  {
    if (this.w)
    {
      this.w = false;
      this.m.setVisibility(8);
      j.showServceEvalTran(true, this.u, com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 320.0F));
      j.showServceEvalTran(false, this.e, com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 133.0F));
      ViewGroup.LayoutParams localLayoutParams = this.r.getLayoutParams();
      localLayoutParams.height = com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 294.0F);
      this.r.setLayoutParams(localLayoutParams);
    }
  }
  
  private void d()
  {
    String str1 = VdsAgent.trackEditTextSilent(this.p).toString();
    if (this.s < 1) {
      g.textToast(this.a, "请选择星级！");
    }
    do
    {
      return;
      if (((this.s == 1) || (this.s == 2)) && (TextUtils.isEmpty(str1)))
      {
        g.textToast(this.a, "非常抱歉，请告诉我们原因，我们会做的更好");
        return;
      }
      localObject = ApplicationEx.c.getUser();
    } while (localObject == null);
    String str2 = ((UserInfo)localObject).getUid();
    Object localObject = ((UserInfo)localObject).getRealName();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.E.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((String)localIterator.next()).replace("http://pic.ziroom.com/sms2/pics/", ""));
    }
    com.ziroom.ziroomcustomer.e.n.submitMovingEval(this.a, this.t, (String)localObject, this.s, str1, str2, "", localArrayList, new com.ziroom.ziroomcustomer.e.a.a(this.a, new m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MoveEvalWidget.p(MoveEvalWidget.this).setClickable(true);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        MoveEvalWidget.j(MoveEvalWidget.this).setBackgroundColor(-1);
        MoveEvalWidget.k(MoveEvalWidget.this).setVisibility(0);
        MoveEvalWidget.l(MoveEvalWidget.this).setVisibility(0);
        MoveEvalWidget.m(MoveEvalWidget.this).setVisibility(0);
        MoveEvalWidget.n(MoveEvalWidget.this).setVisibility(0);
        MoveEvalWidget.o(MoveEvalWidget.this).setVisibility(0);
        MoveEvalWidget.p(MoveEvalWidget.this).setVisibility(4);
        MoveEvalWidget.p(MoveEvalWidget.this).setClickable(false);
        MoveEvalWidget.h(MoveEvalWidget.this).setFocusable(false);
        MoveEvalWidget.h(MoveEvalWidget.this).setFocusableInTouchMode(false);
        if (MoveEvalWidget.q(MoveEvalWidget.this) != null)
        {
          paramAnonymousString = new Bundle();
          paramAnonymousString.putString("thumbType", "move");
          paramAnonymousString.putString("showType", "eval");
          paramAnonymousString.putString("orderCode", MoveEvalWidget.q(MoveEvalWidget.this).getLogicCode());
          paramAnonymousString.putString("orderNum", MoveEvalWidget.q(MoveEvalWidget.this).getLogicCode());
          paramAnonymousString.putString("employeeCode", MoveEvalWidget.q(MoveEvalWidget.this).getSupplierEmployeeInfoVO().getEmployeeCode());
          j.setServantThumb(MoveEvalWidget.g(MoveEvalWidget.this), MoveEvalWidget.o(MoveEvalWidget.this), paramAnonymousString);
        }
        MoveEvalWidget.a(MoveEvalWidget.this, true);
        if (MoveEvalWidget.d(MoveEvalWidget.this) != null)
        {
          MoveEvalWidget.d(MoveEvalWidget.this).evalStatus(true);
          MoveEvalWidget.d(MoveEvalWidget.this).evalToShare(true);
        }
      }
    });
  }
  
  public MyGridView getmGvCamera()
  {
    return this.B;
  }
  
  public void setCameraAdaperData(List<String> paramList)
  {
    this.E = paramList;
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        break label36;
      }
      this.C.setVisibility(8);
    }
    for (;;)
    {
      this.D.setData(paramList);
      return;
      label36:
      if (this.F == 1) {
        this.C.setVisibility(0);
      } else {
        this.C.setVisibility(8);
      }
    }
  }
  
  public void setMoveDetailInfo(MovingVanDetail paramMovingVanDetail, int paramInt, String paramString)
  {
    this.b = paramMovingVanDetail;
    this.F = paramInt;
    this.G = paramString;
    a();
    b();
  }
  
  public void setMoveVanEvalListener(a parama)
  {
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract void evalCancleDialog(boolean paramBoolean);
    
    public abstract void evalStatus(boolean paramBoolean);
    
    public abstract void evalToShare(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/widget/MoveEvalWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */