package com.ziroom.ziroomcoloreggs.eggs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcoloreggs.R.id;
import com.ziroom.ziroomcoloreggs.R.layout;
import com.ziroom.ziroomcoloreggs.eggs.widget.ListViewForScrollView;
import java.util.ArrayList;
import java.util.List;

public class WebLogHttpInfoActivity
  extends Activity
  implements View.OnClickListener
{
  EditText a;
  TextView b;
  TextView c;
  ListViewForScrollView d;
  TextView e;
  ImageView f;
  private e g;
  private List<String> h;
  private g i;
  
  private void a()
  {
    this.a = ((EditText)findViewById(R.id.web_log_http_info_edit));
    this.b = ((TextView)findViewById(R.id.web_log_http_info_code));
    this.c = ((TextView)findViewById(R.id.web_log_http_info_time));
    this.d = ((ListViewForScrollView)findViewById(R.id.web_log_http_info_list));
    this.e = ((TextView)findViewById(R.id.iv_help));
    this.f = ((ImageView)findViewById(R.id.iv_back));
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g = e.parseObject(getIntent().getStringExtra("JSONString"));
    this.h = new ArrayList();
    this.h.add(this.g.get("resp").toString());
    if ("POST".equals(this.g.get("webType"))) {
      this.a.setText(this.g.get("url") + "    " + this.g.get("params"));
    }
    for (;;)
    {
      this.c.setText(this.g.get("time").toString());
      this.b.setText("HttpCode:" + this.g.get("code") + "   " + this.g.get("webType"));
      this.i = new g(this.h, this);
      this.d.setAdapter(this.i);
      return;
      this.a.setText(this.g.get("url").toString());
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int j = paramView.getId();
    if (j == R.id.iv_back) {
      finish();
    }
    while ((j != R.id.iv_help) || ("POST".equals(this.g.get("webType"))) || (!"GET".equals(this.g.get("webType")))) {
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(R.layout.web_log_http_info_activity);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcoloreggs/eggs/WebLogHttpInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */