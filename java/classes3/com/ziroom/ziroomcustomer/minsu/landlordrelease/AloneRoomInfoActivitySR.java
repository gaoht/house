package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.base.b;

public class AloneRoomInfoActivitySR
  extends FragmentActivity
  implements b
{
  private String a;
  private String b;
  private int c;
  
  public Object getDataCache(String paramString)
  {
    return null;
  }
  
  public String getHouseFid()
  {
    return null;
  }
  
  public int getRentWay()
  {
    return 0;
  }
  
  public String getRoomFid()
  {
    return null;
  }
  
  public int getRoomType()
  {
    return 0;
  }
  
  public void next()
  {
    finish();
  }
  
  protected void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903090);
    this.a = getIntent().getStringExtra("houseBaseFid");
    this.b = getIntent().getStringExtra("roomFid");
    this.c = getIntent().getIntExtra("rentWay", -1);
    paramBundle = (LLReleaseRoomSecondStepThreeFragment_SR)getSupportFragmentManager().findFragmentById(2131689894);
    paramBundle.setHouseBaseFid(this.a);
    paramBundle.setRentWay(this.c);
    paramBundle.setRoomFid(this.b);
    paramBundle.d();
    paramBundle.b.setVisibility(8);
    paramBundle.d.setVisibility(8);
    paramBundle.e.setText("客厅信息");
    paramBundle.c.setVisibility(0);
    paramBundle.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramBundle.e();
      }
    });
  }
  
  public void prev()
  {
    finish();
  }
  
  public void putDataCache(String paramString, Object paramObject) {}
  
  public void setHouseFid(String paramString) {}
  
  public void setRentWay(int paramInt) {}
  
  public void setRoomFid(String paramString) {}
  
  public void setRoomType(int paramInt) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/AloneRoomInfoActivitySR.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */