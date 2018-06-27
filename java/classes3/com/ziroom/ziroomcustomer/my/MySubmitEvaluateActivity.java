package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.p;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.model.MyEvaHistoryDetailModel;
import com.ziroom.ziroomcustomer.my.model.MyEvaHistoryDetailModel.EvaluateInfoBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.AnswersBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaHistoryDetailModel.KeeperInfoBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaIsExpiredModel;
import com.ziroom.ziroomcustomer.my.model.MyEvaIsRentAvaiModel;
import com.ziroom.ziroomcustomer.my.model.MyEvaIsRentAvaiModel.EvaluateInfoBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaIsRentAvaiModel.EvaluateInfoBean.ResultBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaSubmitModel;
import com.ziroom.ziroomcustomer.my.model.MyEvaSubmitModel.QuestionsBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaluateGetModel;
import com.ziroom.ziroomcustomer.my.model.MyEvaluateGetModel.EvaluateInfoBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaluateGetModel.KeeperInfoBean;
import com.ziroom.ziroomcustomer.my.model.MySteweardInfoEntity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ZryuEvaluteButton;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ZryuEvaluteButton.a;
import com.ziroom.ziroomcustomer.ziroomstation.widget.MyListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySubmitEvaluateActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean A;
  private MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean B;
  private List<MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean> C = new ArrayList();
  private com.ziroom.ziroomcustomer.my.adapter.b D;
  private String E;
  private String F;
  private long G;
  private int H = 1;
  private boolean I = false;
  private String J = "app";
  private String K = "2c908d174c946508014c9473c7d00005";
  private String L = "salesZO";
  private String M = "SZOABE";
  private String N = "salesZO";
  private String O;
  private MySteweardInfoEntity P;
  Unbinder a;
  private boolean b = false;
  @BindView(2131690078)
  ImageView btnBack;
  @BindView(2131691860)
  Button btnZryuEvaluateSubmit;
  private int c = 0;
  @BindView(2131691852)
  SimpleDraweeView civZryuEvaluateHeadPic;
  private MyEvaluateGetModel d;
  private com.ziroom.ziroomcustomer.my.adapter.a e;
  @BindView(2131691858)
  EditText etZryuEvaluateContent;
  private String f = "MySubmitEvaluateActivity";
  private List<MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean> g = new ArrayList();
  @BindView(2131690608)
  LinearLayout ll_content_container;
  @BindView(2131691851)
  LinearLayout ll_evaluate_contain;
  @BindView(2131691854)
  MyListView lvZryuEvaluateContent;
  private MyEvaSubmitModel r;
  @BindView(2131691856)
  ZryuEvaluteButton ratingbarZryuEvaluate;
  private String s;
  private MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean t;
  @BindView(2131691859)
  TextView tvCharNumTip;
  @BindView(2131691855)
  TextView tvEvaluateDesc;
  @BindView(2131691857)
  TextView tvEvaluateStarDesc;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131691853)
  TextView tvZryuEvaluateZoName;
  private MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean u;
  private String v = "";
  private String w = "";
  private MyEvaIsExpiredModel x;
  private MyEvaIsRentAvaiModel y;
  private MyEvaHistoryDetailModel z;
  
  private void a()
  {
    if (ApplicationEx.c.getUser() != null)
    {
      this.E = ApplicationEx.c.getUser().getUid();
      this.v = this.E;
    }
    for (;;)
    {
      Intent localIntent = getIntent();
      if (localIntent != null)
      {
        this.I = localIntent.getBooleanExtra("isPush", false);
        this.H = localIntent.getIntExtra("evaluateSource", 1);
        this.b = localIntent.getBooleanExtra("isShowHistory", false);
        this.F = localIntent.getStringExtra("keeperId");
        this.w = localIntent.getStringExtra("tokenId");
        this.s = localIntent.getStringExtra("orderCode");
        this.K = this.F;
        if (1 != this.H) {
          break;
        }
        this.L = "salesZO";
        this.N = "ziroomer";
        this.M = "SZOABE";
      }
      return;
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
    }
    this.L = "fwgj";
    this.N = "ziroomer";
    this.M = "cfzq";
  }
  
  private void b()
  {
    if (this.b) {
      if ((this.A != null) && (this.A.options != null) && (this.A.options.size() == 5)) {
        switch (this.c)
        {
        }
      }
    }
    while ((this.t == null) || (this.t.options == null) || (this.t.options.size() != 5))
    {
      return;
      this.tvEvaluateStarDesc.setText(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.A.options.get(0)).desc);
      return;
      this.tvEvaluateStarDesc.setText(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.A.options.get(1)).desc);
      return;
      this.tvEvaluateStarDesc.setText(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.A.options.get(2)).desc);
      return;
      this.tvEvaluateStarDesc.setText(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.A.options.get(3)).desc);
      return;
      this.tvEvaluateStarDesc.setText(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.A.options.get(4)).desc);
      return;
    }
    switch (this.c)
    {
    default: 
      return;
    case 1: 
      this.tvEvaluateStarDesc.setText(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.t.options.get(0)).desc);
      return;
    case 2: 
      this.tvEvaluateStarDesc.setText(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.t.options.get(1)).desc);
      return;
    case 3: 
      this.tvEvaluateStarDesc.setText(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.t.options.get(2)).desc);
      return;
    case 4: 
      this.tvEvaluateStarDesc.setText(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.t.options.get(3)).desc);
      return;
    }
    this.tvEvaluateStarDesc.setText(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.t.options.get(4)).desc);
  }
  
  private void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.civZryuEvaluateHeadPic.setController(c.frescoController(paramString, new Postprocessor()
      {
        public String getName()
        {
          return null;
        }
        
        public CacheKey getPostprocessorCacheKey()
        {
          return null;
        }
        
        public CloseableReference<Bitmap> process(Bitmap paramAnonymousBitmap, PlatformBitmapFactory paramAnonymousPlatformBitmapFactory)
        {
          return paramAnonymousPlatformBitmapFactory.createBitmap(Bitmap.createBitmap(paramAnonymousBitmap, 0, 0, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getWidth()));
        }
      }));
    }
  }
  
  private void e()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(this));
    localHashMap.put("contractCode", this.s);
    com.freelxl.baselibrary.d.a.get(q.R + e.p.b).tag(this).params(g.getCommonHouseSign(localHashMap)).enqueue(new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        MySubmitEvaluateActivity.a(MySubmitEvaluateActivity.this, (MySteweardInfoEntity)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString(), MySteweardInfoEntity.class));
        if (MySubmitEvaluateActivity.b(MySubmitEvaluateActivity.this) != null)
        {
          MySubmitEvaluateActivity.a(MySubmitEvaluateActivity.this, MySubmitEvaluateActivity.b(MySubmitEvaluateActivity.this).getEmpCode());
          MySubmitEvaluateActivity.b(MySubmitEvaluateActivity.this, MySubmitEvaluateActivity.c(MySubmitEvaluateActivity.this));
          MySubmitEvaluateActivity.this.isRentEvaluatable();
          return;
        }
        MySubmitEvaluateActivity.this.showToast("获取管家信息失败");
      }
    });
  }
  
  private void f()
  {
    int i;
    Object localObject;
    if (this.b)
    {
      if ((this.z != null) && (this.z.keeperInfo != null))
      {
        d(this.z.keeperInfo.keeperHeadCorn);
        this.tvZryuEvaluateZoName.setText("Z.O " + this.z.keeperInfo.keeperName);
      }
      if ((this.z != null) && (this.z.evaluateInfo != null) && (this.z.evaluateInfo.questions != null) && (this.z.evaluateInfo.questions.size() > 0) && (((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean)this.z.evaluateInfo.questions.get(0)).children != null))
      {
        i = 0;
        if (i < ((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean)this.z.evaluateInfo.questions.get(0)).children.size())
        {
          localObject = (MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean)this.z.evaluateInfo.questions.get(0)).children.get(i);
          if ("1".equals(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)localObject).optionType)) {
            this.C.add(localObject);
          }
          for (;;)
          {
            i += 1;
            break;
            if ("7".equals(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)localObject).optionType)) {
              this.A = ((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)localObject);
            } else if ("2".equals(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)localObject).optionType)) {
              this.B = ((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)localObject);
            }
          }
        }
      }
      this.D.setDatas(this.C);
      if ((this.A != null) && (this.A.options != null) && (this.A.options.size() >= 5) && (this.A.answers != null) && (this.A.answers.size() > 0) && (this.A.answers.get(0) != null))
      {
        if (!((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.A.options.get(0)).code.equals(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.AnswersBean)this.A.answers.get(0)).optionAnswerId)) {
          break label587;
        }
        this.ratingbarZryuEvaluate.setScore(1);
        this.c = 1;
      }
      for (;;)
      {
        b();
        if ((this.B == null) || (this.B.answers == null) || (this.B.answers.size() <= 0) || (this.B.answers.get(0) == null) || (ae.isNull(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.AnswersBean)this.B.answers.get(0)).label))) {
          break;
        }
        this.ll_content_container.setVisibility(0);
        this.etZryuEvaluateContent.setText(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.AnswersBean)this.B.answers.get(0)).label);
        this.tvCharNumTip.setText(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.AnswersBean)this.B.answers.get(0)).label.length() + "/512");
        return;
        label587:
        if (((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.A.options.get(1)).code.equals(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.AnswersBean)this.A.answers.get(0)).optionAnswerId))
        {
          this.ratingbarZryuEvaluate.setScore(2);
          this.c = 2;
        }
        else if (((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.A.options.get(2)).code.equals(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.AnswersBean)this.A.answers.get(0)).optionAnswerId))
        {
          this.ratingbarZryuEvaluate.setScore(3);
          this.c = 3;
        }
        else if (((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.A.options.get(3)).code.equals(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.AnswersBean)this.A.answers.get(0)).optionAnswerId))
        {
          this.ratingbarZryuEvaluate.setScore(4);
          this.c = 4;
        }
        else if (((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.A.options.get(4)).code.equals(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.AnswersBean)this.A.answers.get(0)).optionAnswerId))
        {
          this.ratingbarZryuEvaluate.setScore(5);
          this.c = 5;
        }
      }
      this.ll_content_container.setVisibility(8);
      return;
    }
    this.w = this.d.evaluateInfo.tokenId;
    this.g.removeAll(this.g);
    if ((this.d != null) && (this.d.keeperInfo != null))
    {
      d(this.d.keeperInfo.keeperHeadCorn);
      this.tvZryuEvaluateZoName.setText("Z.O " + this.d.keeperInfo.keeperName);
    }
    if ((this.d != null) && (this.d.evaluateInfo != null) && (this.d.evaluateInfo.questions != null) && (this.d.evaluateInfo.questions.size() > 0) && (((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean)this.d.evaluateInfo.questions.get(0)).children != null))
    {
      i = 0;
      if (i < ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean)this.d.evaluateInfo.questions.get(0)).children.size())
      {
        localObject = (MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean)this.d.evaluateInfo.questions.get(0)).children.get(i);
        if ("1".equals(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)localObject).optionType)) {
          this.g.add(localObject);
        }
        for (;;)
        {
          i += 1;
          break;
          if ("7".equals(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)localObject).optionType)) {
            this.t = ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)localObject);
          } else if ("2".equals(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)localObject).optionType)) {
            this.u = ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)localObject);
          }
        }
      }
    }
    this.e.setDatas(this.g);
  }
  
  private boolean g()
  {
    this.r = new MyEvaSubmitModel();
    int i;
    if (ApplicationEx.c.getUser() != null)
    {
      this.r.requesterId = ApplicationEx.c.getUser().getUid();
      this.r.requesterType = this.N;
      this.r.orderCode = this.s;
      this.r.questions = new ArrayList();
      i = 0;
    }
    MyEvaSubmitModel.QuestionsBean localQuestionsBean;
    while (i < this.g.size())
    {
      localQuestionsBean = new MyEvaSubmitModel.QuestionsBean();
      localQuestionsBean.code = ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.g.get(i)).code;
      if (ae.isNull(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.g.get(i)).curSelCode))
      {
        af.showToast(this, "请先对我们的服务进行评价");
        return false;
        com.ziroom.commonlibrary.login.a.startLoginActivity(this);
        return false;
      }
      localQuestionsBean.optionCode = ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.g.get(i)).curSelCode;
      localQuestionsBean.content = "";
      this.r.questions.add(localQuestionsBean);
      i += 1;
    }
    if (this.t != null)
    {
      localQuestionsBean = new MyEvaSubmitModel.QuestionsBean();
      localQuestionsBean.code = this.t.code;
      if (this.c == 0)
      {
        af.showToast(this, "请先对我们的服务进行评价");
        return false;
      }
      localQuestionsBean.optionCode = ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)this.t.options.get(this.c - 1)).code;
      localQuestionsBean.content = "";
      this.r.questions.add(localQuestionsBean);
    }
    if (this.u != null)
    {
      localQuestionsBean = new MyEvaSubmitModel.QuestionsBean();
      localQuestionsBean.code = this.u.code;
      localQuestionsBean.content = VdsAgent.trackEditTextSilent(this.etZryuEvaluateContent).toString().trim();
      localQuestionsBean.optionCode = "";
      this.r.questions.add(localQuestionsBean);
    }
    return true;
  }
  
  private void h()
  {
    if (g())
    {
      if (checkNet(this))
      {
        this.O = com.alibaba.fastjson.a.toJSONString(this.r, new SerializerFeature[] { SerializerFeature.WriteMapNullValue });
        j.submitZOEvaluate(this, g.buildZOSubmitEvaluatePros(this.H, this.E, this.F, this.s, this.G, this.w, this.O), new f(this, new com.ziroom.ziroomcustomer.e.c.b())
        {
          public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymouse);
            if (paramAnonymouse != null)
            {
              u.logBigData(MySubmitEvaluateActivity.d(MySubmitEvaluateActivity.this), "===" + paramAnonymouse.toString());
              if (paramAnonymouse == null) {
                break label211;
              }
              String str1 = paramAnonymouse.getString("title");
              String str3 = paramAnonymouse.getString("status");
              String str2 = paramAnonymouse.getString("content");
              paramAnonymouse = paramAnonymouse.getString("message");
              af.showToast(MySubmitEvaluateActivity.this, paramAnonymouse);
              if ("success".equals(str3))
              {
                paramAnonymouse = new Intent(MySubmitEvaluateActivity.this, ZOEvaluateSuccessActivity.class);
                paramAnonymouse.putExtra("title", str1);
                paramAnonymouse.putExtra("content", str2);
                paramAnonymouse.putExtra("evaluateSource", MySubmitEvaluateActivity.h(MySubmitEvaluateActivity.this));
                paramAnonymouse.putExtra("keeperId", MySubmitEvaluateActivity.c(MySubmitEvaluateActivity.this));
                paramAnonymouse.putExtra("orderCode", MySubmitEvaluateActivity.i(MySubmitEvaluateActivity.this));
                paramAnonymouse.putExtra("orderDtlId", MySubmitEvaluateActivity.j(MySubmitEvaluateActivity.this));
                paramAnonymouse.putExtra("tokenId", MySubmitEvaluateActivity.k(MySubmitEvaluateActivity.this));
                MySubmitEvaluateActivity.this.startActivity(paramAnonymouse);
                MySubmitEvaluateActivity.this.finish();
              }
            }
            return;
            label211:
            af.showToast(MySubmitEvaluateActivity.this, "评价失败，请稍后重试");
          }
        });
      }
    }
    else {
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  public void initEvaHistoryData()
  {
    if (checkNet(this))
    {
      j.getEvaluateHistoryDetail(this, g.buildEvaluateHistoryDetail(this.H, this.E, this.F, this.s, this.G, this.v, this.w), new f(this, new com.ziroom.ziroomcustomer.e.c.b())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          MySubmitEvaluateActivity.this.ll_evaluate_contain.setVisibility(0);
          if (paramAnonymouse != null)
          {
            u.logBigData(MySubmitEvaluateActivity.d(MySubmitEvaluateActivity.this), "===" + paramAnonymouse.toString());
            MySubmitEvaluateActivity.a(MySubmitEvaluateActivity.this, (MyEvaHistoryDetailModel)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString(), MyEvaHistoryDetailModel.class));
            MySubmitEvaluateActivity.g(MySubmitEvaluateActivity.this);
          }
        }
      });
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  public void initProsData()
  {
    if (checkNet(this))
    {
      j.getMyEvaluatePros(this, g.buildMyEvaluatePros(this.H, this.E, this.F, this.J, this.K, this.L, this.M), new f(this, new com.ziroom.ziroomcustomer.e.c.b())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          MySubmitEvaluateActivity.this.ll_evaluate_contain.setVisibility(0);
          if (paramAnonymouse != null)
          {
            u.logBigData(MySubmitEvaluateActivity.d(MySubmitEvaluateActivity.this), "===" + paramAnonymouse.toString());
            MySubmitEvaluateActivity.a(MySubmitEvaluateActivity.this, (MyEvaluateGetModel)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString(), MyEvaluateGetModel.class));
            MySubmitEvaluateActivity.g(MySubmitEvaluateActivity.this);
          }
        }
      });
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  public void initView()
  {
    this.btnBack.setOnClickListener(this);
    this.ratingbarZryuEvaluate.initRatingBtn(null, 2130840457, 2130840458, new ZryuEvaluteButton.a()
    {
      public void onSwitch(int paramAnonymousInt)
      {
        if ((paramAnonymousInt >= 1) && (paramAnonymousInt <= 5))
        {
          MySubmitEvaluateActivity.a(MySubmitEvaluateActivity.this, paramAnonymousInt);
          MySubmitEvaluateActivity.a(MySubmitEvaluateActivity.this);
        }
      }
    });
    if (this.b)
    {
      this.D = new com.ziroom.ziroomcustomer.my.adapter.b(this, null);
      this.lvZryuEvaluateContent.setAdapter(this.D);
      this.btnZryuEvaluateSubmit.setVisibility(8);
      this.etZryuEvaluateContent.setFocusable(false);
      this.etZryuEvaluateContent.setEnabled(false);
      this.ratingbarZryuEvaluate.setIsClickable(false);
      this.tvTitle.setText(getResources().getString(2131296774));
      this.tvEvaluateDesc.setText(getResources().getString(2131297566));
    }
    for (;;)
    {
      ((GenericDraweeHierarchy)this.civZryuEvaluateHeadPic.getHierarchy()).setPlaceholderImage(2130839150);
      return;
      this.tvTitle.setText(getResources().getString(2131297567));
      this.tvEvaluateDesc.setText(getResources().getString(2131297566));
      this.e = new com.ziroom.ziroomcustomer.my.adapter.a(this, null);
      this.lvZryuEvaluateContent.setAdapter(this.e);
      this.btnZryuEvaluateSubmit.setOnClickListener(this);
      this.etZryuEvaluateContent.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          paramAnonymousEditable = VdsAgent.trackEditTextSilent(MySubmitEvaluateActivity.this.etZryuEvaluateContent).toString();
          if (paramAnonymousEditable.length() > 512)
          {
            af.showToast(MySubmitEvaluateActivity.this, "您最多可输入512个字符");
            return;
          }
          MySubmitEvaluateActivity.this.tvCharNumTip.setText(paramAnonymousEditable.length() + "/512");
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
    }
  }
  
  public void isExpired()
  {
    if (checkNet(this))
    {
      j.getEvaluateIsExpired(this, g.buildEvaluateIsExpired(this.E, this.F, this.s, this.G, this.H), new f(this, new com.ziroom.ziroomcustomer.e.c.b())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if (paramAnonymouse != null)
          {
            u.logBigData(MySubmitEvaluateActivity.d(MySubmitEvaluateActivity.this), "===" + paramAnonymouse.toString());
            MySubmitEvaluateActivity.a(MySubmitEvaluateActivity.this, (MyEvaIsExpiredModel)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString(), MyEvaIsExpiredModel.class));
            if (1 == MySubmitEvaluateActivity.f(MySubmitEvaluateActivity.this).isExpired)
            {
              paramAnonymouse = new Intent(MySubmitEvaluateActivity.this, ZOEvaluateExpireActivity.class);
              paramAnonymouse.putExtra("title", MySubmitEvaluateActivity.f(MySubmitEvaluateActivity.this).title);
              paramAnonymouse.putExtra("content", MySubmitEvaluateActivity.f(MySubmitEvaluateActivity.this).content);
              MySubmitEvaluateActivity.this.startActivity(paramAnonymouse);
              MySubmitEvaluateActivity.this.finish();
            }
          }
          else
          {
            return;
          }
          if (2 == MySubmitEvaluateActivity.f(MySubmitEvaluateActivity.this).isExpired)
          {
            MySubmitEvaluateActivity.this.showToast("评价已完成，感谢您对自如的支持");
            MySubmitEvaluateActivity.this.finish();
            return;
          }
          MySubmitEvaluateActivity.this.initProsData();
        }
      });
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  public void isRentEvaluatable()
  {
    if (checkNet(this))
    {
      j.getRentZOEvaluateStatus(this, g.buildRentZOEvaluateAvailable(this.H, this.v, this.N, this.K, this.L, this.M, this.s, this.J), new f(this, new com.ziroom.ziroomcustomer.e.c.b())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if (paramAnonymouse != null)
          {
            u.logBigData(MySubmitEvaluateActivity.d(MySubmitEvaluateActivity.this), "===" + paramAnonymouse.toString());
            MySubmitEvaluateActivity.a(MySubmitEvaluateActivity.this, (MyEvaIsRentAvaiModel)com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString(), MyEvaIsRentAvaiModel.class));
            if ((MySubmitEvaluateActivity.e(MySubmitEvaluateActivity.this) != null) && (MySubmitEvaluateActivity.e(MySubmitEvaluateActivity.this).evaluateInfo != null) && (MySubmitEvaluateActivity.e(MySubmitEvaluateActivity.this).evaluateInfo.result != null) && (MySubmitEvaluateActivity.e(MySubmitEvaluateActivity.this).evaluateInfo.result.size() > 0))
            {
              if (!"1".equals(((MyEvaIsRentAvaiModel.EvaluateInfoBean.ResultBean)MySubmitEvaluateActivity.e(MySubmitEvaluateActivity.this).evaluateInfo.result.get(0)).statusContent)) {
                break label163;
              }
              MySubmitEvaluateActivity.this.initProsData();
            }
          }
          label163:
          do
          {
            return;
            if ("3".equals(((MyEvaIsRentAvaiModel.EvaluateInfoBean.ResultBean)MySubmitEvaluateActivity.e(MySubmitEvaluateActivity.this).evaluateInfo.result.get(0)).statusContent))
            {
              paramAnonymouse = new Intent(MySubmitEvaluateActivity.this, ZOEvaluateExpireActivity.class);
              paramAnonymouse.putExtra("title", ((MyEvaIsRentAvaiModel.EvaluateInfoBean.ResultBean)MySubmitEvaluateActivity.e(MySubmitEvaluateActivity.this).evaluateInfo.result.get(0)).title);
              paramAnonymouse.putExtra("content", ((MyEvaIsRentAvaiModel.EvaluateInfoBean.ResultBean)MySubmitEvaluateActivity.e(MySubmitEvaluateActivity.this).evaluateInfo.result.get(0)).content);
              MySubmitEvaluateActivity.this.startActivity(paramAnonymouse);
              MySubmitEvaluateActivity.this.showToast(((MyEvaIsRentAvaiModel.EvaluateInfoBean.ResultBean)MySubmitEvaluateActivity.e(MySubmitEvaluateActivity.this).evaluateInfo.result.get(0)).statusDesc);
              MySubmitEvaluateActivity.this.finish();
              return;
            }
            if ("4".equals(((MyEvaIsRentAvaiModel.EvaluateInfoBean.ResultBean)MySubmitEvaluateActivity.e(MySubmitEvaluateActivity.this).evaluateInfo.result.get(0)).statusContent))
            {
              MySubmitEvaluateActivity.this.showToast(((MyEvaIsRentAvaiModel.EvaluateInfoBean.ResultBean)MySubmitEvaluateActivity.e(MySubmitEvaluateActivity.this).evaluateInfo.result.get(0)).statusDesc);
              MySubmitEvaluateActivity.this.finish();
              return;
            }
          } while (!"2".equals(((MyEvaIsRentAvaiModel.EvaluateInfoBean.ResultBean)MySubmitEvaluateActivity.e(MySubmitEvaluateActivity.this).evaluateInfo.result.get(0)).statusContent));
          MySubmitEvaluateActivity.this.showToast("评价已完成，感谢您对自如的支持");
          MySubmitEvaluateActivity.this.finish();
        }
      });
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  public void onBackPressed()
  {
    setResult(999);
    super.onBackPressed();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690078: 
      finish();
      return;
    }
    h();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903374);
    this.a = ButterKnife.bind(this);
    a();
    initView();
    if (this.b) {
      initEvaHistoryData();
    }
    do
    {
      return;
      if (1 == this.H)
      {
        if (this.I)
        {
          isExpired();
          return;
        }
        initProsData();
        return;
      }
    } while (2 != this.H);
    if (this.I)
    {
      e();
      return;
    }
    initProsData();
  }
  
  protected void onDestroy()
  {
    if (this.a != null) {
      this.a.unbind();
    }
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MySubmitEvaluateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */