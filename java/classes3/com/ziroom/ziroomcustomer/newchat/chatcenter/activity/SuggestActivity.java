package com.ziroom.ziroomcustomer.newchat.chatcenter.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.h;
import com.ziroom.ziroomcustomer.e.c.t;
import com.ziroom.ziroomcustomer.e.c.w;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.view.NewsTitleTextView;
import com.ziroom.ziroomcustomer.newchat.chatcenter.ShowBigPicActivity;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.d.a;
import com.ziroom.ziroomcustomer.newchat.chatcenter.views.MyViewPaper;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SuggestActivity
  extends BaseActivity
{
  private int A = 0;
  private String B = "";
  private String C = "";
  private String D = "";
  private List<String> E = new ArrayList();
  private List<Contract> F;
  private Contract G;
  private Dialog H;
  private a I;
  private int J = 0;
  private UserInfo K;
  private String L;
  private String M;
  private LinearLayout N;
  private LinearLayout O;
  private List<com.ziroom.ziroomcustomer.newchat.chatcenter.d> P = new ArrayList();
  private MyViewPaper Q;
  private EditText R;
  private ImageView S;
  private RecyclerView.a T = new RecyclerView.a()
  {
    public int getItemCount()
    {
      if (SuggestActivity.r(SuggestActivity.this).size() == 3) {
        return 3;
      }
      return SuggestActivity.r(SuggestActivity.this).size() + 1;
    }
    
    public void onBindViewHolder(final RecyclerView.u paramAnonymousu, final int paramAnonymousInt)
    {
      SimpleDraweeView localSimpleDraweeView = ((a)paramAnonymousu).a;
      paramAnonymousu = ((a)paramAnonymousu).b;
      if (paramAnonymousInt >= SuggestActivity.r(SuggestActivity.this).size())
      {
        paramAnonymousu.setVisibility(8);
        localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(""));
        localSimpleDraweeView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            SuggestActivity.this.selectPhoto();
          }
        });
        return;
      }
      paramAnonymousu.setVisibility(0);
      paramAnonymousu.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymous2View)
        {
          VdsAgent.onClick(this, paramAnonymous2View);
          SuggestActivity.r(SuggestActivity.this).remove(paramAnonymousInt);
          SuggestActivity.s(SuggestActivity.this).notifyDataSetChanged();
          if (SuggestActivity.r(SuggestActivity.this).size() == 0) {
            SuggestActivity.f(SuggestActivity.this);
          }
        }
      });
      paramAnonymousu = "http://pic.ziroom.com/sms2/pics/" + SuggestActivity.r(SuggestActivity.this).getString(paramAnonymousInt);
      localSimpleDraweeView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymous2View)
        {
          VdsAgent.onClick(this, paramAnonymous2View);
          SuggestActivity.a(SuggestActivity.this, paramAnonymousu, paramAnonymousInt + 1);
        }
      });
      localSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousu));
    }
    
    public RecyclerView.u onCreateViewHolder(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
    {
      return new a(LayoutInflater.from(SuggestActivity.this).inflate(2130904246, paramAnonymousViewGroup, false));
    }
    
    class a
      extends RecyclerView.u
    {
      SimpleDraweeView a;
      ImageView b;
      
      public a(View paramView)
      {
        super();
        this.a = ((SimpleDraweeView)paramView.findViewById(2131695096));
        this.b = ((ImageView)paramView.findViewById(2131691648));
      }
    }
  };
  BasicZiroomToolBar a;
  private final String b = "SuggestActivity";
  private final int c = 17;
  private final int d = 18;
  private final int e = 19;
  private EditText f;
  private RecyclerView g;
  private b r = new b();
  private LabeledEditText s;
  private LabeledEditText t;
  private ImageView u;
  private TextView v;
  private Button w;
  private int x = 0;
  private int y = 0;
  private int z = 0;
  
  private void a()
  {
    this.a = ((BasicZiroomToolBar)findViewById(2131689787));
    this.a.setTitle("我要投诉");
    this.O = ((LinearLayout)findViewById(2131690096));
    this.R = ((EditText)findViewById(2131690098));
    this.f = ((EditText)findViewById(2131690099));
    this.g = ((RecyclerView)findViewById(2131690100));
    this.g.setLayoutManager(new LinearLayoutManager(this, 0, false));
    this.g.setAdapter(this.T);
    this.S = ((ImageView)findViewById(2131690097));
    this.s = ((LabeledEditText)findViewById(2131690101));
    this.t = ((LabeledEditText)findViewById(2131690103));
    this.u = ((ImageView)findViewById(2131690102));
    this.v = ((TextView)findViewById(2131690104));
    this.w = ((Button)findViewById(2131689816));
    this.N = ((LinearLayout)findViewById(2131690094));
    this.Q = ((MyViewPaper)findViewById(2131690095));
    this.F = ApplicationEx.c.getContracts();
    if ((this.F != null) && (this.F.size() > 0))
    {
      this.G = ((Contract)this.F.get(0));
      this.s.setText(this.G.getAddress());
    }
    this.K = ApplicationEx.c.getUser();
    if ((this.K != null) && (!TextUtils.isEmpty(this.K.getPhone())))
    {
      this.t.setText(this.K.getPhone());
      this.u.setVisibility(0);
      this.y = 1;
      i();
    }
    this.Q.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        SuggestActivity.a(SuggestActivity.this, paramAnonymousInt, true);
        if (SuggestActivity.a(SuggestActivity.this).get(paramAnonymousInt) == null) {
          return;
        }
        if ("1".equals(((com.ziroom.ziroomcustomer.newchat.chatcenter.d)SuggestActivity.a(SuggestActivity.this).get(paramAnonymousInt)).getKey()))
        {
          SuggestActivity.b(SuggestActivity.this).setVisibility(0);
          SuggestActivity.c(SuggestActivity.this).setHint("请输入房间编号（选填）");
          SuggestActivity.c(SuggestActivity.this).setText("");
          SuggestActivity.d(SuggestActivity.this).setImageResource(2130838832);
          return;
        }
        if ("2".equals(((com.ziroom.ziroomcustomer.newchat.chatcenter.d)SuggestActivity.a(SuggestActivity.this).get(paramAnonymousInt)).getKey()))
        {
          SuggestActivity.b(SuggestActivity.this).setVisibility(0);
          SuggestActivity.c(SuggestActivity.this).setHint("请输入管家姓名（选填）");
          SuggestActivity.c(SuggestActivity.this).setText("");
          SuggestActivity.d(SuggestActivity.this).setImageResource(2130838831);
          return;
        }
        SuggestActivity.b(SuggestActivity.this).setVisibility(8);
      }
    });
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.N.measure(this.N.getMeasuredWidth(), -1);
    Object localObject = new FrameLayout.LayoutParams(this.N.getMeasuredWidth(), -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.N.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int j = 0;
    int k = 0;
    int i = 0;
    if (j < this.N.getChildCount())
    {
      localObject = (NewsTitleTextView)this.N.getChildAt(j);
      int n = ((NewsTitleTextView)localObject).getMeasuredWidth();
      int m = i;
      if (j < paramInt) {
        m = i + n + ah.dip2px(this, 32.0F);
      }
      k += n;
      if (paramInt != j)
      {
        ((NewsTitleTextView)localObject).setTextColor(-16777216);
        ((NewsTitleTextView)localObject).setIsHorizontaline(false);
      }
      for (;;)
      {
        j += 1;
        i = m;
        break;
        ((NewsTitleTextView)localObject).setTextColor(33792);
        ((NewsTitleTextView)localObject).setIsHorizontaline(true);
      }
    }
    paramInt = this.N.getChildAt(paramInt).getMeasuredWidth();
    if (paramBoolean)
    {
      j = getWindowManager().getDefaultDisplay().getWidth();
      k = ((HorizontalScrollView)this.N.getParent()).getScrollX();
      if ((i - k <= 0) || (i - k >= j)) {
        break label230;
      }
    }
    label230:
    do
    {
      return;
      if (i - k >= j)
      {
        ((HorizontalScrollView)this.N.getParent()).setScrollX(paramInt + (i - j) + ah.dip2px(this, 32.0F));
        return;
      }
    } while (i - k >= 0);
    ((HorizontalScrollView)this.N.getParent()).setScrollX(i);
  }
  
  private void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this, ShowBigPicActivity.class);
    localIntent.putExtra("picUrl", paramString);
    localIntent.putExtra("mImgIndex", paramInt + "");
    localIntent.putExtra("mImgCount", this.r.size() + "");
    startActivityForResult(localIntent, 19);
  }
  
  private void a(List<com.ziroom.ziroomcustomer.newchat.chatcenter.d> paramList)
  {
    getWindowManager().getDefaultDisplay().getWidth();
    Object localObject1 = new ViewPager.LayoutParams();
    ((ViewPager.LayoutParams)localObject1).width = -2;
    ((ViewPager.LayoutParams)localObject1).height = -2;
    localObject1 = getLayoutInflater();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((com.ziroom.ziroomcustomer.newchat.chatcenter.d)paramList.get(i)).getValue();
      Object localObject2 = ((LayoutInflater)localObject1).inflate(2130903664, null);
      ((TextView)((View)localObject2).findViewById(2131691097)).setText(str);
      localArrayList.add(localObject2);
      localObject2 = new NewsTitleTextView(this);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      localLayoutParams.setMargins(ah.dip2px(this, 16.0F), 0, ah.dip2px(this, 16.0F), 0);
      ((NewsTitleTextView)localObject2).setPadding(ah.dip2px(this, 3.0F), 0, ah.dip2px(this, 3.0F), 0);
      ((NewsTitleTextView)localObject2).setLayoutParams(localLayoutParams);
      ((NewsTitleTextView)localObject2).setTextSize(14.0F);
      ((NewsTitleTextView)localObject2).setText(str);
      ((NewsTitleTextView)localObject2).setGravity(17);
      ((NewsTitleTextView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = 0;
          for (;;)
          {
            if (i < SuggestActivity.t(SuggestActivity.this).getChildCount())
            {
              if ((NewsTitleTextView)SuggestActivity.t(SuggestActivity.this).getChildAt(i) == paramAnonymousView)
              {
                SuggestActivity.a(SuggestActivity.this, i, false);
                SuggestActivity.j(SuggestActivity.this).setCurrentItem(i);
              }
            }
            else {
              return;
            }
            i += 1;
          }
        }
      });
      if (i == 0)
      {
        ((NewsTitleTextView)localObject2).setTextColor(33792);
        ((NewsTitleTextView)localObject2).setIsHorizontaline(true);
      }
      for (;;)
      {
        ((NewsTitleTextView)localObject2).setIsVerticalLine(false);
        this.N.addView((View)localObject2);
        i += 1;
        break;
        ((NewsTitleTextView)localObject2).setTextColor(-16777216);
        ((NewsTitleTextView)localObject2).setIsHorizontaline(false);
      }
    }
  }
  
  private void b()
  {
    this.t.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 11)
        {
          SuggestActivity.e(SuggestActivity.this).setText(paramAnonymousCharSequence.subSequence(0, 11).toString());
          SuggestActivity.e(SuggestActivity.this).setSelection(paramAnonymousCharSequence.subSequence(0, 11).toString().length());
        }
        if (paramAnonymousCharSequence.length() >= 11)
        {
          SuggestActivity.a(SuggestActivity.this, 1);
          SuggestActivity.f(SuggestActivity.this);
        }
        while (paramAnonymousCharSequence.length() > 0)
        {
          SuggestActivity.g(SuggestActivity.this).setVisibility(0);
          return;
          SuggestActivity.a(SuggestActivity.this, 0);
          SuggestActivity.f(SuggestActivity.this);
        }
        SuggestActivity.g(SuggestActivity.this).setVisibility(8);
      }
    });
    this.f.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 200)
        {
          SuggestActivity.h(SuggestActivity.this).setText(paramAnonymousCharSequence.subSequence(0, 200).toString());
          SuggestActivity.h(SuggestActivity.this).setSelection(paramAnonymousCharSequence.subSequence(0, 200).toString().length());
        }
        if (paramAnonymousCharSequence.length() > 15) {
          SuggestActivity.b(SuggestActivity.this, 1);
        }
        for (;;)
        {
          SuggestActivity.f(SuggestActivity.this);
          return;
          SuggestActivity.b(SuggestActivity.this, 0);
        }
      }
    });
    e();
    f();
  }
  
  private void e()
  {
    n.getComplainTime(this, new com.ziroom.commonlibrary.a.a(this, new com.ziroom.ziroomcustomer.newServiceList.utils.d(com.ziroom.ziroomcustomer.newchat.chatcenter.b.d.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.newchat.chatcenter.b.d paramAnonymousd)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousd);
        com.ziroom.ziroomcustomer.util.u.d("SuggestActivity", "===" + com.alibaba.fastjson.a.toJSONString(paramAnonymousd));
        if ((paramAnonymousd != null) && (paramAnonymousd.getStatus() == 1) && (paramAnonymousd.getData() != null))
        {
          paramAnonymousd = paramAnonymousd.getData();
          SuggestActivity.i(SuggestActivity.this).setText("您的投诉将于" + paramAnonymousd.getAcceptTime() + "受理");
          return;
        }
        SuggestActivity.i(SuggestActivity.this).setVisibility(8);
      }
    });
  }
  
  private void f()
  {
    n.getSugTypeList(this, new h(this, new com.ziroom.ziroomcustomer.e.c.u(com.ziroom.ziroomcustomer.newchat.chatcenter.d.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.ziroomcustomer.newchat.chatcenter.d> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        SuggestActivity.a(SuggestActivity.this).clear();
        SuggestActivity.a(SuggestActivity.this).addAll(paramAnonymousList);
        if ((SuggestActivity.a(SuggestActivity.this) != null) && (SuggestActivity.a(SuggestActivity.this).size() > 0))
        {
          SuggestActivity.a(SuggestActivity.this, SuggestActivity.a(SuggestActivity.this));
          paramAnonymousList = new ArrayList();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < SuggestActivity.a(SuggestActivity.this).size())
          {
            ComplainTypeFrament localComplainTypeFrament = new ComplainTypeFrament((com.ziroom.ziroomcustomer.newchat.chatcenter.d)SuggestActivity.a(SuggestActivity.this).get(paramAnonymousInt), SuggestActivity.j(SuggestActivity.this), paramAnonymousInt);
            localComplainTypeFrament.setmOnChecked(new ComplainTypeFrament.c()
            {
              public void onChecked(String paramAnonymous2String1, String paramAnonymous2String2)
              {
                SuggestActivity.a(SuggestActivity.this, paramAnonymous2String1);
                SuggestActivity.b(SuggestActivity.this, paramAnonymous2String2);
                if ((!TextUtils.isEmpty(SuggestActivity.k(SuggestActivity.this))) && (!TextUtils.isEmpty(SuggestActivity.l(SuggestActivity.this))))
                {
                  SuggestActivity.c(SuggestActivity.this, 1);
                  SuggestActivity.f(SuggestActivity.this);
                  return;
                }
                SuggestActivity.c(SuggestActivity.this, 0);
                SuggestActivity.f(SuggestActivity.this);
              }
            });
            paramAnonymousList.add(localComplainTypeFrament);
            paramAnonymousInt += 1;
          }
          SuggestActivity.j(SuggestActivity.this).setAdapter(new com.ziroom.ziroomcustomer.newchat.chatcenter.a.c(SuggestActivity.this.getSupportFragmentManager(), paramAnonymousList));
        }
      }
    });
  }
  
  private void g()
  {
    this.w.setClickable(false);
    String str6 = VdsAgent.trackEditTextSilent(this.f).toString();
    if (str6.length() < 15)
    {
      g.textToast(getApplicationContext(), "内容描述请至少输入15个字！");
      this.w.setClickable(true);
      return;
    }
    if (!ah.checkNet(this))
    {
      this.w.setClickable(true);
      showToast("当前网络不佳，请稍后再试");
    }
    String str7 = this.t.getText();
    Object localObject2 = this.K.getRealName();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "访客";
    }
    String str8 = this.K.getUid();
    if (!TextUtils.isEmpty(this.B)) {
      this.E.add(this.B);
    }
    if (!TextUtils.isEmpty(this.C)) {
      this.E.add(this.C);
    }
    if (!TextUtils.isEmpty(this.D)) {
      this.E.add(this.D);
    }
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str2 = str3;
    String str1 = str4;
    localObject2 = str5;
    if (this.F != null)
    {
      str2 = str3;
      str1 = str4;
      localObject2 = str5;
      if (this.F.size() > 0)
      {
        str2 = ((Contract)this.F.get(this.J)).getOld_contract_code();
        str1 = ((Contract)this.F.get(this.J)).getHouse_code();
        localObject2 = ((Contract)this.F.get(this.J)).getAddress();
      }
    }
    com.freelxl.baselibrary.f.d.d("hdshfgs", "=====  postComplain:" + str2);
    n.postComplain(this, this.L, this.M, str6, str7, str2, str1, (String)localObject2, (String)localObject1, str8, VdsAgent.trackEditTextSilent(this.R).toString(), this.r, new h(this, new t())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        SuggestActivity.m(SuggestActivity.this).setClickable(true);
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        paramAnonymouse = new Intent(SuggestActivity.this, AcceptSuccessActivity.class);
        SuggestActivity.this.startActivity(paramAnonymouse);
        SuggestActivity.this.finish();
      }
    });
  }
  
  private void h()
  {
    this.H = new Dialog(this, 2131427692);
    Object localObject1 = getLayoutInflater().inflate(2130903863, null);
    Object localObject2 = (ListView)((View)localObject1).findViewById(2131693805);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131691288);
    this.I = new a();
    ((ListView)localObject2).setAdapter(this.I);
    ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SuggestActivity.n(SuggestActivity.this).dismiss();
      }
    });
    this.H.setCanceledOnTouchOutside(true);
    localObject2 = this.H.getWindow();
    ((Window)localObject2).getDecorView().setPadding(0, 0, 0, 0);
    localObject3 = ((Window)localObject2).getAttributes();
    ((WindowManager.LayoutParams)localObject3).width = -1;
    ((WindowManager.LayoutParams)localObject3).height = -2;
    ((Window)localObject2).setAttributes((WindowManager.LayoutParams)localObject3);
    ((Window)localObject2).setGravity(80);
    this.H.setContentView((View)localObject1);
    localObject1 = this.H;
    if (!(localObject1 instanceof Dialog))
    {
      ((Dialog)localObject1).show();
      return;
    }
    VdsAgent.showDialog((Dialog)localObject1);
  }
  
  private void i()
  {
    if ((this.x == 1) && (this.y == 1) && ((this.z == 1) || (this.A == 1)))
    {
      this.w.setEnabled(true);
      return;
    }
    this.w.setEnabled(false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      default: 
        
      case 18: 
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("path");
          com.freelxl.baselibrary.f.d.d("SuggestActivity", "===" + paramIntent);
          if (!TextUtils.isEmpty(paramIntent))
          {
            paramIntent = new File(paramIntent);
            n.uploadImg(this, paramIntent, new com.ziroom.commonlibrary.a.a(this, new w())
            {
              public void onSuccess(int paramAnonymousInt, List<String> paramAnonymousList)
              {
                super.onSuccess(paramAnonymousInt, paramAnonymousList);
                if ((paramAnonymousList != null) && (paramAnonymousList.size() == 1))
                {
                  String str = (String)paramAnonymousList.get(0);
                  SuggestActivity.r(SuggestActivity.this).add(str);
                  SuggestActivity.s(SuggestActivity.this).notifyDataSetChanged();
                  if (paramIntent.exists()) {
                    paramIntent.delete();
                  }
                  SuggestActivity.f(SuggestActivity.this);
                  com.freelxl.baselibrary.f.d.d("SuggestActivity", "===" + paramAnonymousList);
                }
              }
            });
            return;
          }
        }
        break;
      case 19: 
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("imgIndex");
          if (!TextUtils.isEmpty(paramIntent)) {
            try
            {
              paramInt1 = Integer.parseInt(paramIntent) - 1;
              if (paramInt1 < this.r.size())
              {
                this.r.remove(paramInt1);
                this.T.notifyDataSetChanged();
                return;
              }
            }
            catch (Exception paramIntent)
            {
              paramIntent.printStackTrace();
            }
          }
        }
        break;
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903123);
    a();
    b();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690102: 
      this.t.setText("");
      this.y = 0;
      i();
      return;
    case 2131690101: 
      if ((this.F != null) && (this.F.size() > 0))
      {
        if (this.F.size() == 1)
        {
          this.s.setText(((Contract)this.F.get(0)).getAddress());
          h();
          return;
        }
        h();
        return;
      }
      g.textToast(this, "您不是自如客，不能选择物业地址");
      return;
    }
    g();
  }
  
  public void selectPhoto()
  {
    startActivityForResult(com.freelxl.baselibrary.widget.imgpicker.a.getPickerIntent(this, false, 0, true, 400, 400), 18);
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public int getCount()
    {
      return SuggestActivity.o(SuggestActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(SuggestActivity.this, 2130904570, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693248));
        paramViewGroup.b = ((ImageView)paramView.findViewById(2131695668));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.a.setText(((Contract)SuggestActivity.o(SuggestActivity.this).get(paramInt)).getAddress());
        paramViewGroup.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            SuggestActivity.d(SuggestActivity.this, paramInt);
            SuggestActivity.a.this.notifyDataSetChanged();
            SuggestActivity.p(SuggestActivity.this).setText(((Contract)SuggestActivity.o(SuggestActivity.this).get(paramInt)).getAddress());
            SuggestActivity.a(SuggestActivity.this, (Contract)SuggestActivity.o(SuggestActivity.this).get(paramInt));
            paramViewGroup.b.setVisibility(0);
            SuggestActivity.n(SuggestActivity.this).dismiss();
          }
        });
        if (SuggestActivity.q(SuggestActivity.this) != paramInt) {
          break;
        }
        paramViewGroup.a.setTextColor(-695296);
        paramViewGroup.b.setVisibility(0);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.a.setTextColor(-15658735);
      paramViewGroup.b.setVisibility(4);
      return paramView;
    }
    
    public class a
    {
      public TextView a;
      public ImageView b;
      
      public a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/activity/SuggestActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */