package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.a.d;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.d.bn;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class CleanSuccessActivity
  extends BaseActivity
{
  private TextView a;
  private TextView b;
  private SimpleDraweeView c;
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131690360));
    this.b = ((TextView)findViewById(2131689541));
    this.c = ((SimpleDraweeView)findViewById(2131690361));
  }
  
  private void b()
  {
    final String str1 = getIntent().getStringExtra("serviceInfoId");
    final String str2 = getIntent().getStringExtra("serviceInfoName");
    final String str3 = getIntent().getStringExtra("cleanId");
    this.b.setText(str2);
    findViewById(2131689492).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanSuccessActivity.this.finish();
      }
    });
    findViewById(2131690043).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(CleanSuccessActivity.this, GeneralOrderDetailActivity.class);
        paramAnonymousView.putExtra("cleanId", str3);
        paramAnonymousView.putExtra("serviceInfoId", str1);
        paramAnonymousView.putExtra("serviceInfoName", str2);
        CleanSuccessActivity.this.startActivity(paramAnonymousView);
      }
    });
    e();
  }
  
  private void e()
  {
    com.ziroom.ziroomcustomer.e.n.getCommonJson(this, "http://contentful.ziroom.com/online/combine/b53b3a3d6ab90ce0268229151c9bde11.json", new com.freelxl.baselibrary.d.c.a(new l(bn.class, new d()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, final List<bn> paramAnonymousList)
      {
        if (paramAnonymousList != null)
        {
          paramAnonymousInt = j.getDisplayWidth(CleanSuccessActivity.this);
          ViewGroup.LayoutParams localLayoutParams = CleanSuccessActivity.a(CleanSuccessActivity.this).getLayoutParams();
          localLayoutParams.height = ((paramAnonymousInt - com.ziroom.ziroomcustomer.util.n.dip2px(CleanSuccessActivity.this, 18.0F) * 2) / 3);
          CleanSuccessActivity.a(CleanSuccessActivity.this).setLayoutParams(localLayoutParams);
          if (paramAnonymousList.size() > 0)
          {
            CleanSuccessActivity.a(CleanSuccessActivity.this).setController(c.frescoController(((bn)paramAnonymousList.get(0)).getPic()));
            CleanSuccessActivity.a(CleanSuccessActivity.this).setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                paramAnonymous2View = ((bn)paramAnonymousList.get(0)).getTitle();
                String str1 = ((bn)paramAnonymousList.get(0)).getUrl();
                String str2 = ((bn)paramAnonymousList.get(0)).getSubtitle();
                String str3 = ((bn)paramAnonymousList.get(0)).getPic();
                JsBridgeWebActivity.start(CleanSuccessActivity.this, paramAnonymous2View, str1, true, str2, str3, false);
              }
            });
          }
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903154);
    a();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/CleanSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */