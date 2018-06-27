package com.ziroom.ziroomcustomer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.adapter.MyEvaluateAdapter;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.c;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.EvaluateOption;
import com.ziroom.ziroomcustomer.model.EvaluateSign;
import com.ziroom.ziroomcustomer.model.EvaluateSubOption;
import com.ziroom.ziroomcustomer.model.EvaluateWithStar;
import com.ziroom.ziroomcustomer.model.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EvaluateSignActivity
  extends BaseActivity
{
  private String[] a = { "newsign", "appoint_com", "appoint_ovdue_n", "appoint_ovdue_y" };
  private ScrollView b;
  private TextView c;
  private ListView d;
  private TextView e;
  private List<FrameLayout> f = new ArrayList();
  private List<EvaluateWithStar> g;
  private Button r;
  private MyEvaluateAdapter s;
  private String t;
  private int u;
  private String v;
  private int w;
  
  private void a()
  {
    this.e = ((TextView)findViewById(2131689541));
    this.c = ((TextView)findViewById(2131690576));
    this.d = ((ListView)findViewById(2131690577));
    this.b = ((ScrollView)findViewById(2131690174));
    this.r = ((Button)findViewById(2131690043));
    this.r.setEnabled(true);
  }
  
  private void a(String paramString, int paramInt, final com.alibaba.fastjson.e parame)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setContent("您确认要给" + str + paramInt + "星评价吗？提交后将无法更改哦~").setTitle("提交评价").setButtonText("重新选择", "确认提交").setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        j.submitNewSignEvaluateInfo(EvaluateSignActivity.this, parame, new c(EvaluateSignActivity.this, new com.ziroom.ziroomcustomer.e.c.d())
        {
          public void onFailure(Throwable paramAnonymous2Throwable)
          {
            super.onFailure(paramAnonymous2Throwable);
          }
          
          public void onSuccess(int paramAnonymous2Int, com.alibaba.fastjson.e paramAnonymous2e)
          {
            super.onSuccess(paramAnonymous2Int, paramAnonymous2e);
            com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(EvaluateSignActivity.this).setTitle("提示").setContent("评价成功").setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous3View)
              {
                VdsAgent.onClick(this, paramAnonymous3View);
                EvaluateSignActivity.this.setResult(4660, EvaluateSignActivity.this.getIntent());
                EvaluateSignActivity.this.finish();
              }
            }).build().show();
          }
        });
      }
    }).show();
  }
  
  private void b()
  {
    this.t = getIntent().getStringExtra("orderCode");
    this.w = getIntent().getIntExtra("state", 1);
    this.u = getIntent().getIntExtra("sceneCode", 0);
    this.v = getIntent().getStringExtra("evaluateType");
    if (this.u == 3)
    {
      this.c.setVisibility(0);
      if (this.u != 0) {
        break label150;
      }
      this.e.setText("新签评价");
    }
    for (;;)
    {
      if (this.w != 1) {
        break label162;
      }
      this.r.setVisibility(0);
      j.getNewSignEvaluateConditions(this, this.t, this.a[this.u], new c(this, new f(EvaluateSign.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, EvaluateSign paramAnonymousEvaluateSign)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousEvaluateSign);
          if (paramAnonymousEvaluateSign != null)
          {
            EvaluateSignActivity.a(EvaluateSignActivity.this, paramAnonymousEvaluateSign.getQuestions());
            if (EvaluateSignActivity.a(EvaluateSignActivity.this) != null)
            {
              EvaluateSignActivity.a(EvaluateSignActivity.this, new MyEvaluateAdapter(EvaluateSignActivity.a(EvaluateSignActivity.this), EvaluateSignActivity.this, 0));
              EvaluateSignActivity.c(EvaluateSignActivity.this).setAdapter(EvaluateSignActivity.b(EvaluateSignActivity.this));
            }
          }
        }
      });
      return;
      this.c.setVisibility(8);
      break;
      label150:
      this.e.setText("约看评价");
    }
    label162:
    this.r.setVisibility(8);
    j.getEvaluateResultsConditions(this, this.t, this.v, new c(this, new f(EvaluateSign.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, EvaluateSign paramAnonymousEvaluateSign)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousEvaluateSign);
        if (paramAnonymousEvaluateSign != null)
        {
          EvaluateSignActivity.a(EvaluateSignActivity.this, paramAnonymousEvaluateSign.getQuestions());
          if (EvaluateSignActivity.a(EvaluateSignActivity.this) != null)
          {
            EvaluateSignActivity.a(EvaluateSignActivity.this, new MyEvaluateAdapter(EvaluateSignActivity.a(EvaluateSignActivity.this), EvaluateSignActivity.this, 1));
            EvaluateSignActivity.c(EvaluateSignActivity.this).setAdapter(EvaluateSignActivity.b(EvaluateSignActivity.this));
          }
        }
      }
    });
  }
  
  public com.alibaba.fastjson.e getEvaluateSubmitContent(EvaluateWithStar paramEvaluateWithStar)
  {
    com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
    int i = paramEvaluateWithStar.getRate();
    if (paramEvaluateWithStar != null)
    {
      locale.put("collectId", paramEvaluateWithStar.getCollectId());
      if (i == 0)
      {
        showToast("请选择您的满意度～");
        return null;
      }
      if ((paramEvaluateWithStar.getOptions() != null) && (i > 0) && (i <= paramEvaluateWithStar.getOptions().size()))
      {
        locale.put("code", paramEvaluateWithStar.getStarCode());
        Object localObject = (EvaluateOption)paramEvaluateWithStar.getOptions().get(i - 1);
        locale.put("optionCode", ((EvaluateOption)localObject).getCode());
        locale.put("content", ((EvaluateOption)localObject).getDesc());
        locale.put("subQuestionsCode", ((EvaluateOption)localObject).getSubQuestionCode());
        locale.put("orderCode", paramEvaluateWithStar.getOrderCode());
        com.alibaba.fastjson.b localb = new com.alibaba.fastjson.b();
        localObject = ((EvaluateOption)localObject).getSubOptions().iterator();
        while (((Iterator)localObject).hasNext())
        {
          EvaluateSubOption localEvaluateSubOption = (EvaluateSubOption)((Iterator)localObject).next();
          if (localEvaluateSubOption.getSelected() == 1) {
            localb.add(localEvaluateSubOption.getSubOptionCode());
          }
        }
        if ((localb.size() == 0) && (i <= 3))
        {
          showToast("请选择一个标签哦～");
          return null;
        }
        locale.put("subOptionCode", localb);
      }
      locale.put("ext", paramEvaluateWithStar.getExt().toJSONString());
      locale.put("evsceneCode", paramEvaluateWithStar.getEvsceneCode());
      locale.put("evaluatedPersonCode", paramEvaluateWithStar.getEvaluatedPersonCode());
      locale.put("suggestCode", paramEvaluateWithStar.getSuggestCode());
      locale.put("suggestContent", paramEvaluateWithStar.getSuggestContent());
    }
    return locale;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 4660)
    {
      setResult(4660, getIntent());
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903172);
    a();
    b();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131690576: 
    case 2131690043: 
      do
      {
        do
        {
          return;
          paramView = getIntent();
          paramView.putExtra("sceneCode", 2);
          startActivity(paramView);
          return;
        } while (this.s == null);
        paramView = ApplicationEx.c.getUser();
      } while ((paramView == null) || (TextUtils.isEmpty(this.t)));
      com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
      locale.put("requesterId", paramView.getUid());
      locale.put("requesterName", paramView.getRealName());
      locale.put("requesterType", "ziroomer");
      locale.put("requesterPhone", paramView.getPhone());
      locale.put("cityCode", com.ziroom.ziroomcustomer.base.b.getCurrentCity().getCode());
      locale.put("dataSource", "2");
      com.alibaba.fastjson.b localb = new com.alibaba.fastjson.b();
      paramView = null;
      Iterator localIterator = this.s.getmList().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label251;
        }
        EvaluateWithStar localEvaluateWithStar = (EvaluateWithStar)localIterator.next();
        if (getEvaluateSubmitContent(localEvaluateWithStar) == null) {
          break;
        }
        if ("ZODKFW".equals(localEvaluateWithStar.getEvsceneCode())) {
          paramView = localEvaluateWithStar;
        }
        localb.add(getEvaluateSubmitContent(localEvaluateWithStar));
      }
      label251:
      locale.put("results", localb);
      if ((this.u == 1) || (this.u == 2) || (this.u == 3))
      {
        if (paramView != null)
        {
          a(paramView.getTitle(), paramView.getRate(), locale);
          return;
        }
        j.submitNewSignEvaluateInfo(this, locale, new c(this, new com.ziroom.ziroomcustomer.e.c.d())
        {
          public void onFailure(Throwable paramAnonymousThrowable)
          {
            super.onFailure(paramAnonymousThrowable);
          }
          
          public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymouse);
            com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(EvaluateSignActivity.this).setTitle("提示").setContent("评价成功").setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                EvaluateSignActivity.this.setResult(4660, EvaluateSignActivity.this.getIntent());
                EvaluateSignActivity.this.finish();
              }
            }).build().show();
          }
        });
        return;
      }
      j.submitNewSignEvaluateInfo(this, locale, new c(this, new com.ziroom.ziroomcustomer.e.c.d())
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(EvaluateSignActivity.this).setTitle("提示").setContent("评价成功").setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              EvaluateSignActivity.this.setResult(4660, EvaluateSignActivity.this.getIntent());
              EvaluateSignActivity.this.finish();
            }
          }).build().show();
        }
      });
      return;
    }
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/EvaluateSignActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */