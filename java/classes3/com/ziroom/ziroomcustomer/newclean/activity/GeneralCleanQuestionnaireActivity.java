package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.d.aa;
import com.ziroom.ziroomcustomer.newclean.d.aa.a;
import com.ziroom.ziroomcustomer.newclean.d.ab;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeneralCleanQuestionnaireActivity
  extends BaseActivity
  implements ObservableScrollView.a
{
  private ListViewForScrollView a;
  private View b;
  private ObservableScrollView c;
  private TextView d;
  private String e;
  private List<ab> f = new ArrayList();
  private aa g;
  
  private void a()
  {
    this.e = getIntent().getStringExtra("orderCode");
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        GeneralCleanQuestionnaireActivity.a(GeneralCleanQuestionnaireActivity.this);
      }
    });
    e();
  }
  
  private void b()
  {
    View localView = findViewById(2131690588);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    localView.requestFocus();
    localView.requestFocusFromTouch();
    findViewById(2131690588).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        GeneralCleanQuestionnaireActivity.this.finish();
      }
    });
    this.a = ((ListViewForScrollView)findViewById(2131690176));
    this.b = findViewById(2131690678);
    this.d = ((TextView)findViewById(2131689956));
    this.c = ((ObservableScrollView)findViewById(2131690677));
    this.c.setOnScrollChangedCallback(this);
  }
  
  private void e()
  {
    com.ziroom.ziroomcustomer.e.n.getGeneralCleanQuestion(this, this.e, new com.freelxl.baselibrary.d.c.a(new m(aa.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, aa paramAnonymousaa)
      {
        if (paramAnonymousaa != null)
        {
          GeneralCleanQuestionnaireActivity.a(GeneralCleanQuestionnaireActivity.this, paramAnonymousaa);
          paramAnonymousaa = new GeneralCleanQuestionnaireActivity.a(GeneralCleanQuestionnaireActivity.this, GeneralCleanQuestionnaireActivity.this, paramAnonymousaa);
          GeneralCleanQuestionnaireActivity.b(GeneralCleanQuestionnaireActivity.this).setAdapter(paramAnonymousaa);
        }
      }
    });
  }
  
  private void f()
  {
    if (this.f.size() == 0)
    {
      g.textToast(this, "请先选择选项");
      return;
    }
    com.ziroom.ziroomcustomer.e.n.saveGeneralCleanQuestion(this, this.f, this.e, new com.freelxl.baselibrary.d.c.a(new m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        j.showFailureMessage(GeneralCleanQuestionnaireActivity.this, paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        if (!TextUtils.isEmpty(paramAnonymousString)) {
          g.textToast(GeneralCleanQuestionnaireActivity.this, paramAnonymousString);
        }
        GeneralCleanQuestionnaireActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903188);
    b();
    a();
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    if (paramInt2 / 100.0F > 0.85D)
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
  
  class a
    extends BaseAdapter
  {
    private Context b;
    private aa c;
    
    public a(Context paramContext, aa paramaa)
    {
      this.b = paramContext;
      this.c = paramaa;
    }
    
    private void a(String paramString, final FlowLayout paramFlowLayout, final int paramInt)
    {
      View localView = LayoutInflater.from(this.b).inflate(2130904168, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131694955);
      ((TextView)localView.findViewById(2131690049)).setText(paramString);
      localView.setTag(Boolean.valueOf(false));
      paramString = new LinearLayout.LayoutParams(-2, -2);
      paramString.setMargins(0, 0, com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 32.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.b, 12.0F));
      localView.setLayoutParams(paramString);
      localView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          String str = ((aa.a)GeneralCleanQuestionnaireActivity.c(GeneralCleanQuestionnaireActivity.this).getPointItems().get(paramInt)).getFid();
          int i = 0;
          if (i < paramFlowLayout.getChildCount())
          {
            Object localObject1 = paramFlowLayout.getChildAt(i);
            Object localObject2 = (ImageView)((View)localObject1).findViewById(2131694955);
            TextView localTextView = (TextView)((View)localObject1).findViewById(2131690049);
            if (localObject1 == paramAnonymousView)
            {
              localObject1 = localTextView.getText().toString();
              localTextView.setTextColor(40960);
              ((ImageView)localObject2).setImageResource(2130837944);
              if (GeneralCleanQuestionnaireActivity.d(GeneralCleanQuestionnaireActivity.this).size() > 0)
              {
                int j = 0;
                int k = 0;
                while (j < GeneralCleanQuestionnaireActivity.d(GeneralCleanQuestionnaireActivity.this).size())
                {
                  if (str.equals(((ab)GeneralCleanQuestionnaireActivity.d(GeneralCleanQuestionnaireActivity.this).get(j)).getId()))
                  {
                    k = 1;
                    ((ab)GeneralCleanQuestionnaireActivity.d(GeneralCleanQuestionnaireActivity.this).get(j)).setPointItemAns((String)localObject1);
                  }
                  j += 1;
                }
                if (k == 0)
                {
                  localObject2 = new ab();
                  ((ab)localObject2).setId(str);
                  ((ab)localObject2).setPointItemAns((String)localObject1);
                  GeneralCleanQuestionnaireActivity.d(GeneralCleanQuestionnaireActivity.this).add(localObject2);
                }
              }
            }
            for (;;)
            {
              i += 1;
              break;
              localObject2 = new ab();
              ((ab)localObject2).setId(str);
              ((ab)localObject2).setPointItemAns((String)localObject1);
              GeneralCleanQuestionnaireActivity.d(GeneralCleanQuestionnaireActivity.this).add(localObject2);
              continue;
              localTextView.setTextColor(-12303292);
              ((ImageView)localObject2).setImageResource(2130837943);
            }
          }
          u.d("sdl;jgklds", "=====  " + com.alibaba.fastjson.a.toJSONString(GeneralCleanQuestionnaireActivity.d(GeneralCleanQuestionnaireActivity.this)));
        }
      });
      paramFlowLayout.addView(localView);
    }
    
    public int getCount()
    {
      return this.c.getPointItems().size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.c.getPointItems().get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(this.b, 2130904209, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131695038));
        paramViewGroup.b = ((FlowLayout)paramView.findViewById(2131690332));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject = (aa.a)this.c.getPointItems().get(paramInt);
        paramViewGroup.a.setText(((aa.a)localObject).getFpointitem());
        if ((((aa.a)localObject).getPointItemAnsList() == null) || (((aa.a)localObject).getPointItemAnsList().size() <= 0)) {
          break;
        }
        paramViewGroup.b.removeAllViews();
        localObject = ((aa.a)localObject).getPointItemAnsList().iterator();
        while (((Iterator)localObject).hasNext()) {
          a((String)((Iterator)localObject).next(), paramViewGroup.b, paramInt);
        }
        paramViewGroup = (a)paramView.getTag();
      }
      return paramView;
    }
    
    public class a
    {
      public TextView a;
      public FlowLayout b;
      
      public a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/GeneralCleanQuestionnaireActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */