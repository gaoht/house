package com.ziroom.ziroomcustomer.my;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class SettingItemView
  extends RelativeLayout
{
  private TextView a;
  private RelativeLayout b;
  
  public SettingItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public SettingItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    setTitle(paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/com.ziroom.ziroomcustomer", "title"));
  }
  
  public SettingItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    View.inflate(paramContext, 2130904363, this);
    this.a = ((TextView)findViewById(2131689533));
    this.b = ((RelativeLayout)findViewById(2131694919));
  }
  
  public void setOnclick(final Activity paramActivity, final Class paramClass, String paramString)
  {
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(paramActivity, paramClass);
        paramActivity.startActivity(paramAnonymousView);
        paramActivity.overridePendingTransition(2130968684, 2130968685);
      }
    });
  }
  
  public void setOnclick(final a parama)
  {
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        parama.mMethod();
      }
    });
  }
  
  public void setOnclickTo(final Activity paramActivity, final Class paramClass)
  {
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(paramActivity, paramClass);
        paramActivity.startActivity(paramAnonymousView);
        paramActivity.overridePendingTransition(2130968684, 2130968685);
        paramActivity.finish();
      }
    });
  }
  
  public void setTitle(String paramString)
  {
    this.a.setText(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void mMethod();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/SettingItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */