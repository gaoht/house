package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaCommitBean;
import com.ziroom.ziroomcustomer.minsu.dialog.h;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MinsuNpsActivity
  extends BaseActivity
{
  private String a = "";
  private String b;
  @BindView(2131691627)
  ImageView back;
  private String c = "";
  private h d;
  private MinsuEvaCommitBean e;
  private String[] f = { "10 — 非常满意", "9", "8", "7", "6", "5", "4", "3", "2", "1", "0 — 完全不会" };
  private HashMap<String, Boolean> g = new HashMap();
  @BindView(2131691630)
  ListView mListView;
  @BindView(2131691628)
  TextView nps_submit_done;
  private a r;
  @BindView(2131691629)
  TextView tvPrompt;
  
  private void a()
  {
    this.tvPrompt.setText(this.c);
    this.r = new a();
    this.mListView.setAdapter(this.r);
    this.nps_submit_done.setTextColor(getResources().getColor(2131624599));
    this.nps_submit_done.setEnabled(false);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = MinsuNpsActivity.a(MinsuNpsActivity.this).keySet().iterator();
        while (paramAnonymousAdapterView.hasNext())
        {
          paramAnonymousView = (String)paramAnonymousAdapterView.next();
          MinsuNpsActivity.a(MinsuNpsActivity.this).put(paramAnonymousView, Boolean.valueOf(false));
        }
        MinsuNpsActivity.a(MinsuNpsActivity.this).put(String.valueOf(paramAnonymousInt), Boolean.valueOf(true));
        MinsuNpsActivity.b(MinsuNpsActivity.this).notifyDataSetChanged();
        MinsuNpsActivity.a(MinsuNpsActivity.this, String.valueOf(Math.abs(paramAnonymousInt - 10)));
        if (!TextUtils.isEmpty(MinsuNpsActivity.c(MinsuNpsActivity.this)))
        {
          MinsuNpsActivity.this.nps_submit_done.setTextColor(MinsuNpsActivity.this.getResources().getColor(2131624609));
          MinsuNpsActivity.this.nps_submit_done.setEnabled(true);
        }
      }
    });
    this.back.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuNpsActivity.this.finish();
        k.toMinsuEvaSuccessPage(MinsuNpsActivity.this, MinsuNpsActivity.d(MinsuNpsActivity.this), MinsuNpsActivity.e(MinsuNpsActivity.this));
      }
    });
  }
  
  public void commitNPS()
  {
    if (TextUtils.isEmpty(this.a))
    {
      g.textToast(ApplicationEx.c, "您还未选择分数!");
      return;
    }
    if (TextUtils.isEmpty(this.b))
    {
      g.textToast(ApplicationEx.c, "订单号错误，提交失败!");
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.saveNps(this, this.a, this.b, new s(this, new r(MinsuBaseJson.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MinsuNpsActivity.this.finish();
        k.toMinsuEvaSuccessPage(MinsuNpsActivity.this, MinsuNpsActivity.d(MinsuNpsActivity.this), MinsuNpsActivity.e(MinsuNpsActivity.this));
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuBaseJson paramAnonymousMinsuBaseJson)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuBaseJson);
        MinsuNpsActivity.this.showToast("提交成功");
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            MinsuNpsActivity.this.finish();
            k.toMinsuEvaSuccessPage(MinsuNpsActivity.this, MinsuNpsActivity.d(MinsuNpsActivity.this), MinsuNpsActivity.e(MinsuNpsActivity.this));
          }
        }, 1200L);
      }
    });
  }
  
  public void finish()
  {
    super.finish();
    k.animFinishAlpha(this);
  }
  
  @OnClick({2131691628})
  public void onClick()
  {
    commitNPS();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903317);
    ButterKnife.bind(this);
    this.b = getIntent().getStringExtra("orderSn");
    this.c = getIntent().getStringExtra("tips");
    this.d = ((h)getIntent().getSerializableExtra("userType"));
    this.e = ((MinsuEvaCommitBean)getIntent().getSerializableExtra("shareInfo"));
    a();
  }
  
  class a
    extends BaseAdapter
  {
    a() {}
    
    public int getCount()
    {
      return MinsuNpsActivity.f(MinsuNpsActivity.this).length;
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramViewGroup = new MinsuNpsActivity.b(MinsuNpsActivity.this);
        paramView = LayoutInflater.from(MinsuNpsActivity.this).inflate(2130904339, null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131695330));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.a.setText(MinsuNpsActivity.f(MinsuNpsActivity.this)[paramInt]);
        if ((MinsuNpsActivity.a(MinsuNpsActivity.this).get(String.valueOf(paramInt)) != null) && (((Boolean)MinsuNpsActivity.a(MinsuNpsActivity.this).get(String.valueOf(paramInt))).booleanValue())) {
          break;
        }
        paramViewGroup.a.setTextColor(MinsuNpsActivity.this.getResources().getColor(2131624598));
        paramViewGroup.a.setCompoundDrawables(null, null, null, null);
        return paramView;
        paramViewGroup = (MinsuNpsActivity.b)paramView.getTag();
      }
      paramViewGroup.a.setTextColor(MinsuNpsActivity.this.getResources().getColor(2131624609));
      Drawable localDrawable = MinsuNpsActivity.this.getResources().getDrawable(2130839717);
      localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
      paramViewGroup.a.setCompoundDrawables(null, null, localDrawable, null);
      paramViewGroup.a.setCompoundDrawablePadding(8);
      return paramView;
    }
  }
  
  class b
  {
    TextView a;
    
    b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuNpsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */