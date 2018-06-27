package com.ziroom.ziroomcustomer.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.home.a.f;
import com.ziroom.ziroomcustomer.home.bean.ContentBean;
import java.util.List;

public class ZiroomerListActivity
  extends BaseActivity
{
  private List<ContentBean> a;
  private String b;
  private ListView c;
  
  private void a()
  {
    this.a = ((List)getIntent().getSerializableExtra("ziroomers"));
    this.b = getIntent().getStringExtra("title");
    b();
    this.c = ((ListView)findViewById(2131689817));
    if ((this.a != null) && (this.a.size() > 0)) {
      this.c.setAdapter(new f(this, this.a, true));
    }
  }
  
  private void b()
  {
    ((ImageView)findViewById(2131691493)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ZiroomerListActivity.this.finish();
      }
    });
    findViewById(2131696483).setVisibility(8);
    findViewById(2131696484).setVisibility(8);
    ((TextView)findViewById(2131689541)).setText(this.b);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903572);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/ZiroomerListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */