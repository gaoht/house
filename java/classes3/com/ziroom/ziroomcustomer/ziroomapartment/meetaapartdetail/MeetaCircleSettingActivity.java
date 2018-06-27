package com.ziroom.ziroomcustomer.ziroomapartment.meetaapartdetail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.social.activity.zz.ZzSocialMySpaceActivity;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;

public class MeetaCircleSettingActivity
  extends BaseActivity
  implements d.b
{
  private d.a a;
  private ImageView b;
  private RelativeLayout c;
  private TextView d;
  private RelativeLayout e;
  private TextView f;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((RelativeLayout)findViewById(2131692906));
    this.d = ((TextView)findViewById(2131691571));
    this.e = ((RelativeLayout)findViewById(2131692907));
    this.f = ((TextView)findViewById(2131692908));
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MeetaCircleSettingActivity.this.finish();
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = "0";
        Object localObject = ApplicationEx.c.getUser();
        if (localObject != null) {
          paramAnonymousView = ((UserInfo)localObject).getUid();
        }
        localObject = new Intent(MeetaCircleSettingActivity.this, ZzSocialMySpaceActivity.class);
        ((Intent)localObject).putExtra("be_uid", paramAnonymousView);
        ((Intent)localObject).putExtra("isEditer", true);
        MeetaCircleSettingActivity.this.startActivity((Intent)localObject);
      }
    });
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903588);
    new e(this);
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.detachView();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.a.setProjectId(getIntent().getStringExtra("projectId"));
    this.a.start();
  }
  
  public void setPresenter(d.a parama)
  {
    this.a = parama;
  }
  
  public void showSettting(Integer paramInteger1, Integer paramInteger2)
  {
    if ((paramInteger1 != null) && (paramInteger2 != null))
    {
      if (paramInteger1.intValue() != 0) {
        break label44;
      }
      this.e.setVisibility(0);
      this.f.setEnabled(false);
      this.f.setTextColor(Color.parseColor("#CCCCCC"));
    }
    label44:
    do
    {
      return;
      this.e.setVisibility(0);
      if (paramInteger2.intValue() == 0)
      {
        this.f.setText("公开我的Meeta资料");
        this.e.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            MeetaCircleSettingActivity.a(MeetaCircleSettingActivity.this).openCircle();
          }
        });
        return;
      }
    } while (paramInteger2.intValue() != 1);
    this.f.setText("不公开我的Meeta资料");
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MeetaCircleSettingActivity.a(MeetaCircleSettingActivity.this).closeCircle();
      }
    });
  }
  
  public void toEditInfo(String paramString)
  {
    if (ApplicationEx.c.getUser() != null)
    {
      JsBridgeWebActivity.start(this, "", paramString);
      finish();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/meetaapartdetail/MeetaCircleSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */