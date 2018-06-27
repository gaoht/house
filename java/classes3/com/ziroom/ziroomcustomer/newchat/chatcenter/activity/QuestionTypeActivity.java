package com.ziroom.ziroomcustomer.newchat.chatcenter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.d;
import com.ziroom.ziroomcustomer.newchat.chatcenter.a.e;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.m;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.m.a;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.n.a;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionTypeActivity
  extends BaseActivity
{
  Map<Integer, List<String>> a = new HashMap();
  private final String b = "QuestionTypeActivity";
  private ExpandableListView c;
  private QuestionTypeActivity d;
  private List<m.a> e = new ArrayList();
  private List<n.a> f = new ArrayList();
  private List<String> g = new ArrayList();
  private List<String> r = new ArrayList();
  private e s;
  private String t;
  private String u;
  private String v;
  private String w;
  private String x;
  private ImageView y;
  
  private void a()
  {
    this.c = ((ExpandableListView)findViewById(2131692597));
    this.y = ((ImageView)findViewById(2131689492));
    this.s = new e(this, this.r, this.a);
    this.c.setGroupIndicator(null);
    this.c.setAdapter(this.s);
    this.y.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        QuestionTypeActivity.this.finish();
      }
    });
  }
  
  private void b()
  {
    com.ziroom.ziroomcustomer.e.n.getComplainTypeOne(this.d, new com.ziroom.commonlibrary.a.a(this.d, new d(m.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, m paramAnonymousm)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousm);
        u.d("QuestionTypeActivity", "===" + com.alibaba.fastjson.a.toJSONString(paramAnonymousm));
        if ((paramAnonymousm != null) && (paramAnonymousm.getStatus() == 1))
        {
          QuestionTypeActivity.a(QuestionTypeActivity.this, paramAnonymousm.getData());
          if ((QuestionTypeActivity.a(QuestionTypeActivity.this) != null) && (QuestionTypeActivity.a(QuestionTypeActivity.this).size() > 0))
          {
            paramAnonymousInt = 0;
            while (paramAnonymousInt < QuestionTypeActivity.a(QuestionTypeActivity.this).size())
            {
              QuestionTypeActivity.b(QuestionTypeActivity.this).add(((m.a)QuestionTypeActivity.a(QuestionTypeActivity.this).get(paramAnonymousInt)).getValue());
              paramAnonymousInt += 1;
            }
          }
          QuestionTypeActivity.c(QuestionTypeActivity.this).notifyDataSetChanged();
        }
      }
    });
    this.c.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
    {
      @Instrumented
      public boolean onChildClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
      {
        VdsAgent.onChildClick(this, paramAnonymousExpandableListView, paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong);
        QuestionTypeActivity.a(QuestionTypeActivity.this, ((n.a)QuestionTypeActivity.d(QuestionTypeActivity.this).get(paramAnonymousInt2)).getKey());
        QuestionTypeActivity.b(QuestionTypeActivity.this, ((n.a)QuestionTypeActivity.d(QuestionTypeActivity.this).get(paramAnonymousInt2)).getValue());
        paramAnonymousExpandableListView = new Intent();
        paramAnonymousExpandableListView.putExtra("groupKey", QuestionTypeActivity.e(QuestionTypeActivity.this));
        paramAnonymousExpandableListView.putExtra("childKey", QuestionTypeActivity.f(QuestionTypeActivity.this));
        paramAnonymousExpandableListView.putExtra("groupName", QuestionTypeActivity.g(QuestionTypeActivity.this));
        paramAnonymousExpandableListView.putExtra("childName", QuestionTypeActivity.h(QuestionTypeActivity.this));
        QuestionTypeActivity.this.setResult(-1, paramAnonymousExpandableListView);
        QuestionTypeActivity.this.finish();
        VdsAgent.handleClickResult(new Boolean(true));
        return true;
      }
    });
    this.c.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener()
    {
      public void onGroupExpand(int paramAnonymousInt)
      {
        int i = 0;
        while (i < QuestionTypeActivity.c(QuestionTypeActivity.this).getGroupCount())
        {
          if (paramAnonymousInt != i) {
            QuestionTypeActivity.i(QuestionTypeActivity.this).collapseGroup(i);
          }
          i += 1;
        }
        QuestionTypeActivity.c(QuestionTypeActivity.this, ((m.a)QuestionTypeActivity.a(QuestionTypeActivity.this).get(paramAnonymousInt)).getKey());
        QuestionTypeActivity.d(QuestionTypeActivity.this, ((m.a)QuestionTypeActivity.a(QuestionTypeActivity.this).get(paramAnonymousInt)).getId());
        QuestionTypeActivity.e(QuestionTypeActivity.this, ((m.a)QuestionTypeActivity.a(QuestionTypeActivity.this).get(paramAnonymousInt)).getValue());
        QuestionTypeActivity.a(QuestionTypeActivity.this, paramAnonymousInt);
      }
    });
  }
  
  private void b(final int paramInt)
  {
    com.ziroom.ziroomcustomer.e.n.getComplainTypeTwo(this.d, this.t, new com.ziroom.commonlibrary.a.a(this.d, new d(com.ziroom.ziroomcustomer.newchat.chatcenter.b.n.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        paramAnonymousObject = (com.ziroom.ziroomcustomer.newchat.chatcenter.b.n)paramAnonymousObject;
        u.e("sdjgkds", com.alibaba.fastjson.a.toJSONString(paramAnonymousObject));
        if ((paramAnonymousObject != null) && (((com.ziroom.ziroomcustomer.newchat.chatcenter.b.n)paramAnonymousObject).getStatus() == 1))
        {
          QuestionTypeActivity.b(QuestionTypeActivity.this, ((com.ziroom.ziroomcustomer.newchat.chatcenter.b.n)paramAnonymousObject).getData());
          QuestionTypeActivity.j(QuestionTypeActivity.this).clear();
          if ((QuestionTypeActivity.d(QuestionTypeActivity.this) != null) && (QuestionTypeActivity.d(QuestionTypeActivity.this).size() > 0))
          {
            paramAnonymousInt = 0;
            while (paramAnonymousInt < QuestionTypeActivity.d(QuestionTypeActivity.this).size())
            {
              QuestionTypeActivity.j(QuestionTypeActivity.this).add(((n.a)QuestionTypeActivity.d(QuestionTypeActivity.this).get(paramAnonymousInt)).getValue());
              paramAnonymousInt += 1;
            }
          }
          QuestionTypeActivity.this.a.put(Integer.valueOf(paramInt), QuestionTypeActivity.j(QuestionTypeActivity.this));
          QuestionTypeActivity.c(QuestionTypeActivity.this).notifyDataSetChanged();
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903527);
    this.d = this;
    a();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/activity/QuestionTypeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */