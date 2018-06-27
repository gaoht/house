package com.ziroom.ziroomcustomer.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.HomeWebActivity;
import java.util.Iterator;
import java.util.List;

public class YezhuStoryListActivity
  extends BaseActivity
{
  Unbinder a;
  private Context b;
  private List<ContentBean> c;
  private String d;
  @BindView(2131692666)
  LinearLayout ll_yezhu_story_list;
  @BindView(2131689541)
  TextView tv_title;
  
  private void a()
  {
    this.d = getIntent().getStringExtra("title");
    this.c = ((List)getIntent().getSerializableExtra("datalist"));
  }
  
  private void a(List<ContentBean> paramList)
  {
    float f = this.b.getResources().getDisplayMetrics().density;
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = (int)(this.b.getResources().getDisplayMetrics().widthPixels * 0.44D);
      int j = i * 2 / 3;
      this.ll_yezhu_story_list.removeAllViews();
      LayoutInflater.from(this.b);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        final Object localObject = (ContentBean)paramList.next();
        View localView = View.inflate(this.b, 2130904425, null);
        SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)localView.findViewById(2131691098);
        localSimpleDraweeView.setLayoutParams(new RelativeLayout.LayoutParams(i, j));
        TextView localTextView1 = (TextView)localView.findViewById(2131689541);
        TextView localTextView2 = (TextView)localView.findViewById(2131690071);
        localSimpleDraweeView.setController(c.frescoController(x.makeUrl(((ContentBean)localObject).getPic(), 0.5F)));
        localTextView1.setText(((ContentBean)localObject).getTitle());
        localTextView2.setText(((ContentBean)localObject).getSubtitle());
        localView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(YezhuStoryListActivity.a(YezhuStoryListActivity.this), HomeWebActivity.class);
            paramAnonymousView.putExtra("url", localObject.getLink());
            paramAnonymousView.putExtra("title", localObject.getTitle());
            paramAnonymousView.putExtra("content", localObject.getSubtitle());
            paramAnonymousView.putExtra("pic", localObject.getPic());
            YezhuStoryListActivity.a(YezhuStoryListActivity.this).startActivity(paramAnonymousView);
          }
        });
        localObject = new LinearLayout.LayoutParams(-1, j);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, (int)(16.0F * f));
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.ll_yezhu_story_list.addView(localView);
      }
    }
  }
  
  @OnClick({2131691914})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903548);
    this.a = ButterKnife.bind(this);
    this.b = this;
    a();
    a(this.c);
    this.tv_title.setText(this.d);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/YezhuStoryListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */