package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.fastjson.a;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.b.b;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceLoginActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomapartment.a.e;
import com.ziroom.ziroomcustomer.ziroomapartment.adapter.d;
import com.ziroom.ziroomcustomer.ziroomapartment.model.EvaluateMsg;
import com.ziroom.ziroomcustomer.ziroomapartment.model.EvaluateMsg.QuestionsBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaHistoryDetailModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaHistoryDetailModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaHistoryDetailModel.DataBean.QuestionsBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean.AnswersBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaluateGetModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaluateGetModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaluateGetModel.DataBean.QuestionsBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean.OptionsBean;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ZryuEvaluteButton;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ZryuEvaluteButton.a;
import com.ziroom.ziroomcustomer.ziroomstation.widget.MyListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZryuEvaluateActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String A = "ZADKPJ";
  private String B = "009fe61e-765a-4e5e-b666-cf1f11218ff8";
  private String C = "111";
  private String D = "95020";
  private ZryuEvaHistoryDetailModel E;
  private ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean F;
  private ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean G;
  private List<ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean> H = new ArrayList();
  private com.ziroom.ziroomcustomer.ziroomapartment.adapter.c I;
  Unbinder a;
  private boolean b = false;
  @BindView(2131690078)
  ImageView btnBack;
  @BindView(2131691860)
  Button btnZryuEvaluateSubmit;
  private boolean c = false;
  @BindView(2131691852)
  SimpleDraweeView civZryuEvaluateHeadPic;
  private Boolean d = Boolean.valueOf(true);
  private int e = 0;
  @BindView(2131691858)
  EditText etZryuEvaluateContent;
  private ZryuEvaluateGetModel f;
  private d g;
  @BindView(2131691854)
  MyListView lvZryuEvaluateContent;
  private String r = "ZryuEvaluateActivity";
  @BindView(2131691856)
  ZryuEvaluteButton ratingbarZryuEvaluate;
  private List<ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean> s = new ArrayList();
  private EvaluateMsg t;
  @BindView(2131691855)
  TextView tvEvaluateDesc;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131691853)
  TextView tvZryuEvaluateZoName;
  private String u;
  private ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean v;
  private ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean w;
  private String x = "app";
  private String y = "2c908d174c946508014c9473c7d00005";
  private String z = "ZAZO";
  
  private void a()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.b = localIntent.getBooleanExtra("isShowHistory", false);
      if (!this.b)
      {
        this.y = localIntent.getStringExtra("beEvaluatorId");
        this.B = localIntent.getStringExtra("businessBid");
        this.u = (this.B + this.A);
      }
    }
    else
    {
      return;
    }
    this.C = localIntent.getStringExtra("requesterId");
    this.D = localIntent.getStringExtra("tokenId");
  }
  
  private void b()
  {
    int i;
    Object localObject;
    if (this.b)
    {
      if ((this.E != null) && (this.E.data != null))
      {
        if (!TextUtils.isEmpty(this.E.data.zoPhotoUrl)) {
          this.civZryuEvaluateHeadPic.setController(com.freelxl.baselibrary.f.c.frescoController(this.E.data.zoPhotoUrl, new BaseControllerListener()
          {
            public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable)
            {
              super.onFailure(paramAnonymousString, paramAnonymousThrowable);
              ZryuEvaluateActivity.this.civZryuEvaluateHeadPic.setImageURI(Uri.EMPTY);
            }
          }));
        }
        this.tvZryuEvaluateZoName.setText("Z.O." + this.E.data.zoName);
      }
      if ((this.E != null) && (this.E.data != null) && (this.E.data.questions != null) && (this.E.data.questions.size() > 0) && (((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean)this.E.data.questions.get(0)).children != null))
      {
        i = 0;
        if (i < ((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean)this.E.data.questions.get(0)).children.size())
        {
          localObject = (ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean)((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean)this.E.data.questions.get(0)).children.get(i);
          if ("1".equals(((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean)localObject).optionType)) {
            this.H.add(localObject);
          }
          for (;;)
          {
            i += 1;
            break;
            if ("7".equals(((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean)localObject).optionType)) {
              this.F = ((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean)localObject);
            } else if ("2".equals(((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean)localObject).optionType)) {
              this.G = ((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean)localObject);
            }
          }
        }
      }
      this.I.setDatas(this.H);
      if ((this.F != null) && (this.F.answers != null) && (this.F.answers.size() > 0) && (this.F.answers.get(0) != null))
      {
        if (!"一星".equals(((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean.AnswersBean)this.F.answers.get(0)).label)) {
          break label484;
        }
        this.ratingbarZryuEvaluate.setScore(1);
      }
      for (;;)
      {
        if ((this.G != null) && (this.G.answers != null) && (this.G.answers.size() > 0) && (this.G.answers.get(0) != null)) {
          this.etZryuEvaluateContent.setText(((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean.AnswersBean)this.G.answers.get(0)).label);
        }
        return;
        label484:
        if ("二星".equals(((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean.AnswersBean)this.F.answers.get(0)).label)) {
          this.ratingbarZryuEvaluate.setScore(2);
        } else if ("三星".equals(((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean.AnswersBean)this.F.answers.get(0)).label)) {
          this.ratingbarZryuEvaluate.setScore(3);
        } else if ("四星".equals(((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean.AnswersBean)this.F.answers.get(0)).label)) {
          this.ratingbarZryuEvaluate.setScore(4);
        } else if ("五星".equals(((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean.AnswersBean)this.F.answers.get(0)).label)) {
          this.ratingbarZryuEvaluate.setScore(5);
        }
      }
    }
    this.D = this.f.data.tokenId;
    if ((this.f != null) && (this.f.data != null) && (!TextUtils.isEmpty(this.f.data.zoPhotoUrl))) {
      this.civZryuEvaluateHeadPic.setController(com.freelxl.baselibrary.f.c.frescoController(this.f.data.zoPhotoUrl, new BaseControllerListener()
      {
        public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousString, paramAnonymousThrowable);
          ZryuEvaluateActivity.this.civZryuEvaluateHeadPic.setImageURI(Uri.EMPTY);
        }
      }));
    }
    if ((this.f != null) && (this.f.data != null)) {
      this.tvZryuEvaluateZoName.setText("Z.O." + this.f.data.zoName);
    }
    if ((this.f != null) && (this.f.data != null) && (this.f.data.questions != null) && (this.f.data.questions.size() > 0) && (((ZryuEvaluateGetModel.DataBean.QuestionsBean)this.f.data.questions.get(0)).children != null))
    {
      i = 0;
      if (i < ((ZryuEvaluateGetModel.DataBean.QuestionsBean)this.f.data.questions.get(0)).children.size())
      {
        localObject = (ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)((ZryuEvaluateGetModel.DataBean.QuestionsBean)this.f.data.questions.get(0)).children.get(i);
        if ("1".equals(((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)localObject).optionType)) {
          this.s.add(localObject);
        }
        for (;;)
        {
          i += 1;
          break;
          if ("7".equals(((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)localObject).optionType)) {
            this.v = ((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)localObject);
          } else if ("2".equals(((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)localObject).optionType)) {
            this.w = ((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)localObject);
          }
        }
      }
    }
    this.g.setDatas(this.s);
  }
  
  private boolean e()
  {
    this.t = new EvaluateMsg();
    if (this.d.booleanValue()) {
      if (ApplicationEx.c.getUser() == null) {}
    }
    for (this.t.requesterId = ApplicationEx.c.getUser().getUid();; this.t.requesterId = "9c43cee6-1778-2cbd-e401-8247871067fd")
    {
      this.t.requesterType = "app";
      this.t.orderCode = this.u;
      this.t.ext = "";
      this.t.questions = new ArrayList();
      localQuestionsBean = new EvaluateMsg.QuestionsBean();
      localQuestionsBean.code = this.v.code;
      if (this.e != 0) {
        break;
      }
      af.showToast(this, "请对管家星级评价");
      return false;
      startActivity(new Intent(this, ServiceLoginActivity.class));
      return false;
    }
    localQuestionsBean.optionCode = ((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean.OptionsBean)this.v.options.get(this.e - 1)).code;
    localQuestionsBean.content = "";
    localQuestionsBean.picUrl = "";
    this.t.questions.add(localQuestionsBean);
    int i = 0;
    while (i < this.s.size())
    {
      localQuestionsBean = new EvaluateMsg.QuestionsBean();
      localQuestionsBean.code = ((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)this.s.get(i)).code;
      if (ae.isNull(((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)this.s.get(i)).curSelCode))
      {
        af.showToast(this, "请对管家服务内容评价");
        return false;
      }
      localQuestionsBean.optionCode = ((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)this.s.get(i)).curSelCode;
      localQuestionsBean.content = "";
      localQuestionsBean.picUrl = "";
      this.t.questions.add(localQuestionsBean);
      i += 1;
    }
    EvaluateMsg.QuestionsBean localQuestionsBean = new EvaluateMsg.QuestionsBean();
    localQuestionsBean.code = this.w.code;
    String str = VdsAgent.trackEditTextSilent(this.etZryuEvaluateContent).toString().trim();
    if (ae.isNull(str))
    {
      af.showToast(this, "请填写对管家的评价");
      return false;
    }
    localQuestionsBean.content = str;
    localQuestionsBean.picUrl = "";
    localQuestionsBean.optionCode = "";
    this.t.questions.add(localQuestionsBean);
    return true;
  }
  
  private void f()
  {
    if (e())
    {
      if (checkNet(this))
      {
        Map localMap = com.ziroom.ziroomcustomer.ziroomapartment.a.c.buildSubmitEvaluatePros(this, this.x, this.y, this.z, this.A, this.B, this.D, this.t);
        e.submitEvaluatePros(this, new c(), localMap, true);
      }
    }
    else {
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  public void initData()
  {
    Map localMap;
    if (this.b)
    {
      if (this.c)
      {
        this.E = ((ZryuEvaHistoryDetailModel)a.parseObject("{\"error_code\":\"200\",\"error_message\":\"操作成功！\",\"status\":\"success\",\"data\":{\"status\":\"success\",\"tokenId\":\"95020\",\"message\":\"ok\",\"zoIntroduce\":\"你好自如客，我是自如管家，很高兴为您服务。\",\"zoPhotoUrl\":\"http://www.ziroom.com/static/v2.0/images/detail/gjnone.png\",\"zoName\":\"自如管家\",\"questions\":[{\"code\":\"ZADKPJ\",\"index\":\"\",\"label\":\"带看评价\",\"children\":[{\"code\":\"562\",\"label\":\"是否提前跟您确认看房时间？\",\"optionType\":\"1\",\"options\":[{\"code\":\"2346\",\"desc\":\"否\"},{\"code\":\"2347\",\"desc\":\"是\"}],\"answers\":[{\"optionAnswerId\":\"2346\",\"label\":\"否\"}]},{\"code\":\"565\",\"label\":\"是否主动向您介绍我们的社区活动？\",\"optionType\":\"1\",\"options\":[{\"code\":\"2355\",\"desc\":\"是\"},{\"code\":\"2356\",\"desc\":\"否\"}],\"answers\":[{\"optionAnswerId\":\"2355\",\"label\":\"是\"}]},{\"code\":\"566\",\"label\":\"星级\",\"optionType\":\"7\",\"options\":[{\"code\":\"2358\",\"desc\":\"一星\"},{\"code\":\"2359\",\"desc\":\"二星\"},{\"code\":\"2360\",\"desc\":\"三星\"},{\"code\":\"2361\",\"desc\":\"四星\"},{\"code\":\"2362\",\"desc\":\"五星\"}],\"answers\":[{\"optionAnswerId\":\"2358\",\"label\":\"一星\"}]},{\"code\":\"563\",\"label\":\"是否面带微笑，礼仪、态度良好？\",\"optionType\":\"1\",\"options\":[{\"code\":\"2349\",\"desc\":\"是\"},{\"code\":\"2350\",\"desc\":\"否\"}],\"answers\":[{\"optionAnswerId\":\"2349\",\"label\":\"是\"}]},{\"code\":\"564\",\"label\":\"对您提出的问题是否有详尽解答？\",\"optionType\":\"1\",\"options\":[{\"code\":\"2352\",\"desc\":\"是\"},{\"code\":\"2353\",\"desc\":\"否\"}],\"answers\":[{\"optionAnswerId\":\"2352\",\"label\":\"是\"}]},{\"code\":\"561\",\"label\":\"对管家的评价(512字以内)\",\"optionType\":\"2\",\"options\":null,\"answers\":[{\"optionAnswerId\":null,\"label\":\"对管家的评价\"}]}]}]}}\n", ZryuEvaHistoryDetailModel.class));
        b();
        return;
      }
      if (checkNet(this))
      {
        localMap = com.ziroom.ziroomcustomer.ziroomapartment.a.c.buildGetEvaHistoryDetail(this, this.C, this.D);
        e.getEvaHistoryDetail(this, new a(), localMap, true);
        return;
      }
      af.showToast(this, "请检查您的网络，稍后再试！");
      return;
    }
    if (this.c)
    {
      this.f = ((ZryuEvaluateGetModel)a.parseObject("{\"error_code\":\"200\",\"error_message\":\"操作成功！\",\"status\":\"success\",\"data\":{\"status\":\"success\",\"message\":\"ok\",\"tokenId\":\"94959\",\"zoIntroduce\":\"你好自如客，我是自如管家，很高兴为您服务。\",\"zoPhotoUrl\":\"http://www.ziroom.com/static/v2.0/images/detail/gjnone.png\",\"zoName\":\"自如管家\",\"questions\":[{\"code\":\"ZADKPJ\",\"label\":\"带看评价\",\"index\":\"\",\"children\":[{\"code\":\"563\",\"index\":\"0\",\"label\":\"是否面带微笑，礼仪、态度良好？\",\"optionType\":\"1\",\"options\":[{\"code\":\"2349\",\"desc\":\"是\"},{\"code\":\"2350\",\"desc\":\"否\"}]},{\"code\":\"566\",\"index\":\"0\",\"label\":\"星级\",\"optionType\":\"7\",\"options\":[{\"code\":\"2358\",\"desc\":\"一星\"},{\"code\":\"2359\",\"desc\":\"二星\"},{\"code\":\"2360\",\"desc\":\"三星\"},{\"code\":\"2361\",\"desc\":\"四星\"},{\"code\":\"2362\",\"desc\":\"五星\"}]},{\"code\":\"562\",\"index\":\"0\",\"label\":\"是否提前跟您确认看房时间？\",\"optionType\":\"1\",\"options\":[{\"code\":\"2346\",\"desc\":\"否\"},{\"code\":\"2347\",\"desc\":\"是\"}]},{\"code\":\"565\",\"index\":\"0\",\"label\":\"是否主动向您介绍我们的社区活动？\",\"optionType\":\"1\",\"options\":[{\"code\":\"2355\",\"desc\":\"是\"},{\"code\":\"2356\",\"desc\":\"否\"}]},{\"code\":\"564\",\"index\":\"0\",\"label\":\"对您提出的问题是否有详尽解答？\",\"optionType\":\"1\",\"options\":[{\"code\":\"2352\",\"desc\":\"是\"},{\"code\":\"2353\",\"desc\":\"否\"}]},{\"code\":\"561\",\"index\":\"0\",\"label\":\"对管家的评价(512字以内)\",\"optionType\":\"2\",\"options\":null}]}]}}\n", ZryuEvaluateGetModel.class));
      b();
      return;
    }
    if (checkNet(this))
    {
      localMap = com.ziroom.ziroomcustomer.ziroomapartment.a.c.buildGetEvaluatePros(this, this.x, this.y, this.z, this.A);
      e.getEvaluatePros(this, new b(), localMap, true);
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
        if ((paramAnonymousInt >= 1) && (paramAnonymousInt <= 5)) {
          ZryuEvaluateActivity.a(ZryuEvaluateActivity.this, paramAnonymousInt);
        }
      }
    });
    if (this.b)
    {
      this.I = new com.ziroom.ziroomcustomer.ziroomapartment.adapter.c(this, null);
      this.lvZryuEvaluateContent.setAdapter(this.I);
      this.btnZryuEvaluateSubmit.setVisibility(8);
      this.etZryuEvaluateContent.setFocusable(false);
      this.etZryuEvaluateContent.setEnabled(false);
      this.ratingbarZryuEvaluate.setIsClickable(false);
      this.tvTitle.setText(getResources().getString(2131297571));
      this.tvEvaluateDesc.setText(getResources().getString(2131297570));
    }
    for (;;)
    {
      ((GenericDraweeHierarchy)this.civZryuEvaluateHeadPic.getHierarchy()).setPlaceholderImage(2130839150);
      return;
      this.tvTitle.setText(getResources().getString(2131297567));
      this.tvEvaluateDesc.setText(getResources().getString(2131297566));
      this.g = new d(this, null);
      this.lvZryuEvaluateContent.setAdapter(this.g);
      this.btnZryuEvaluateSubmit.setOnClickListener(this);
      this.etZryuEvaluateContent.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          if (VdsAgent.trackEditTextSilent(ZryuEvaluateActivity.this.etZryuEvaluateContent).toString().length() > 512) {
            af.showToast(ZryuEvaluateActivity.this, "您最多可输入512个字符");
          }
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
    }
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
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903582);
    this.a = ButterKnife.bind(this);
    setResult(999);
    a();
    initView();
    initData();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    super.onDestroy();
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      u.i(ZryuEvaluateActivity.c(ZryuEvaluateActivity.this), "接口返回：" + paramString);
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        ZryuEvaluateActivity.a(ZryuEvaluateActivity.this, (ZryuEvaHistoryDetailModel)paramk.getObject());
        if (200 == ZryuEvaluateActivity.a(ZryuEvaluateActivity.this).error_code)
        {
          ZryuEvaluateActivity.b(ZryuEvaluateActivity.this);
          return;
        }
        af.showToast(ZryuEvaluateActivity.this, ZryuEvaluateActivity.a(ZryuEvaluateActivity.this).error_message);
        return;
      }
      af.showToast(ZryuEvaluateActivity.this, paramk.getMessage());
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, k paramk)
    {
      u.i(ZryuEvaluateActivity.c(ZryuEvaluateActivity.this), "接口返回：" + paramString);
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        ZryuEvaluateActivity.a(ZryuEvaluateActivity.this, (ZryuEvaluateGetModel)paramk.getObject());
        if (200 == ZryuEvaluateActivity.d(ZryuEvaluateActivity.this).error_code)
        {
          ZryuEvaluateActivity.b(ZryuEvaluateActivity.this);
          return;
        }
        af.showToast(ZryuEvaluateActivity.this, ZryuEvaluateActivity.d(ZryuEvaluateActivity.this).error_message);
        return;
      }
      af.showToast(ZryuEvaluateActivity.this, paramk.getMessage());
    }
  }
  
  class c
    implements i.a<String>
  {
    c() {}
    
    public void onParse(String paramString, k paramk)
    {
      u.i(ZryuEvaluateActivity.c(ZryuEvaluateActivity.this), "接口返回：" + paramString);
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (b)paramk.getObject();
        if (200 == paramk.error_code)
        {
          af.showToast(ZryuEvaluateActivity.this, ZryuEvaluateActivity.this.getResources().getString(2131297495));
          ZryuEvaluateActivity.this.finish();
          return;
        }
        af.showToast(ZryuEvaluateActivity.this, paramk.error_message);
        return;
      }
      af.showToast(ZryuEvaluateActivity.this, paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuEvaluateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */