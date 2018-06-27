package com.ziroom.ziroomcoloreggs.eggs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.h;
import com.ziroom.ziroomcoloreggs.R.color;
import com.ziroom.ziroomcoloreggs.R.drawable;
import com.ziroom.ziroomcoloreggs.R.id;
import com.ziroom.ziroomcoloreggs.R.layout;
import com.ziroom.ziroomcoloreggs.eggs.a.b;
import com.ziroom.ziroomcoloreggs.eggs.widget.ListViewForScrollView;
import java.util.ArrayList;
import java.util.List;

public class TestMainActivity
  extends Activity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  ListViewForScrollView a;
  TextView b;
  ImageView c;
  ImageView d;
  ImageView e;
  RelativeLayout f;
  RelativeLayout g;
  RelativeLayout h;
  RelativeLayout i;
  private e j;
  private String[] k = { "开发环境", "测试环境", "准生产环境" };
  private int[] l = { 1, 2, 3, 4 };
  private List<com.alibaba.fastjson.e> m;
  private String n;
  
  private List<com.alibaba.fastjson.e> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < this.k.length)
    {
      com.alibaba.fastjson.e locale = new com.alibaba.fastjson.e();
      locale.put("name", this.k[i1]);
      locale.put("type", Integer.valueOf(this.l[i1]));
      if (paramInt == i1) {
        locale.put("isChecked", "1");
      }
      for (;;)
      {
        localArrayList.add(locale);
        i1 += 1;
        break;
        locale.put("isChecked", "0");
      }
    }
    return localArrayList;
  }
  
  private void a()
  {
    this.i = ((RelativeLayout)findViewById(R.id.show_web_log));
    this.h = ((RelativeLayout)findViewById(R.id.show_error_log));
    this.g = ((RelativeLayout)findViewById(R.id.web_log_rl));
    this.f = ((RelativeLayout)findViewById(R.id.error_log_rl));
    this.e = ((ImageView)findViewById(R.id.iv_back));
    this.a = ((ListViewForScrollView)findViewById(R.id.eggs_web_list));
    this.b = ((TextView)findViewById(R.id.eggs_web_tv));
    this.c = ((ImageView)findViewById(R.id.error_log_im));
    this.d = ((ImageView)findViewById(R.id.web_log_im));
    this.a.setOnItemClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
  }
  
  private void b()
  {
    if (a.b)
    {
      this.c.setImageResource(R.drawable.dir_choose);
      return;
    }
    this.c.setImageResource(R.color.transparent);
  }
  
  private void c()
  {
    if (a.a)
    {
      this.d.setImageResource(R.drawable.dir_choose);
      return;
    }
    this.d.setImageResource(R.color.transparent);
  }
  
  public void onBackPressed()
  {
    if ("1".equals(this.n))
    {
      if (b.b != null) {
        b.b.toMain(this);
      }
      finish();
    }
    super.onBackPressed();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int i1 = paramView.getId();
    if (i1 == R.id.iv_back)
    {
      if ("1".equals(this.n))
      {
        if (b.b != null) {
          b.b.toMain(this);
        }
        finish();
      }
      finish();
    }
    do
    {
      return;
      if (i1 == R.id.error_log_rl)
      {
        if (a.b) {}
        for (a.b = false;; a.b = true)
        {
          b();
          return;
        }
      }
      if (i1 == R.id.web_log_rl)
      {
        if (a.a) {}
        for (a.a = false;; a.a = true)
        {
          c();
          return;
        }
      }
      if (i1 == R.id.show_error_log)
      {
        startActivity(new Intent(this, ErrorLogListActivity.class));
        return;
      }
    } while (i1 != R.id.show_web_log);
    startActivity(new Intent(this, WebLogTimeListActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(R.layout.test_main_activity);
    this.n = getIntent().getStringExtra("showWebUpdata");
    a();
    if ("1".equals(this.n))
    {
      this.a.setVisibility(0);
      this.b.setVisibility(0);
    }
    for (;;)
    {
      int i1 = 0;
      while (i1 < this.l.length)
      {
        if (h.getsEnvironment() == this.l[i1]) {
          this.m = a(i1);
        }
        i1 += 1;
      }
      this.a.setVisibility(8);
      this.b.setVisibility(8);
    }
    if (h.getsEnvironment() == this.l[0]) {
      this.m = a(0);
    }
    for (;;)
    {
      if (this.m != null) {
        this.j = new e(this.m, this);
      }
      if (this.j != null) {
        this.a.setAdapter(this.j);
      }
      b();
      c();
      return;
      if (h.getsEnvironment() == this.l[1]) {
        this.m = a(1);
      }
    }
  }
  
  @Instrumented
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
    this.m = a(paramInt);
    this.j.setmList(this.m);
    this.j.notifyDataSetChanged();
    h.setsEnvironment(((Integer)((com.alibaba.fastjson.e)this.m.get(paramInt)).get("type")).intValue());
    if (b.a != null) {
      b.a.onUpdataUrl();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcoloreggs/eggs/TestMainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */