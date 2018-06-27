package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.c;
import com.ziroom.ziroomcustomer.widget.MinsuCycleViewPager;
import com.ziroom.ziroomcustomer.widget.MinsuCycleViewPager.a;
import com.ziroom.ziroomcustomer.widget.MinsuCycleViewPager.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinsuScanPhotoActivity
  extends BaseActivity
{
  private List<String> a;
  private List<String> b;
  private Map<Integer, Integer> c;
  private List<String> d;
  private int e;
  private List<TextView> f = new ArrayList();
  private MinsuCycleViewPager g;
  private LinearLayout r;
  private MinsuCycleViewPager.b s = new MinsuCycleViewPager.b()
  {
    public void onPosChange(int paramAnonymousInt)
    {
      MinsuScanPhotoActivity.a(MinsuScanPhotoActivity.this, paramAnonymousInt);
    }
  };
  private MinsuCycleViewPager.a t = new MinsuCycleViewPager.a()
  {
    public void onImageClick(int paramAnonymousInt, View paramAnonymousView)
    {
      MinsuScanPhotoActivity.this.finish();
    }
  };
  
  private void a()
  {
    this.g = ((MinsuCycleViewPager)getSupportFragmentManager().findFragmentById(2131690555));
    this.r = ((LinearLayout)findViewById(2131690557));
  }
  
  private void a(String paramString, int paramInt)
  {
    TextView localTextView = new TextView(ApplicationEx.c);
    localTextView.setTextColor(ApplicationEx.c.getResources().getColor(2131624583));
    localTextView.setTextSize(13.0F);
    localTextView.setBackground(null);
    localTextView.setText(paramString);
    localTextView.setTag(Integer.valueOf(paramInt));
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(55, 0, 0, 0);
    paramString.gravity = 17;
    localTextView.setPadding(20, 20, 20, 20);
    localTextView.setLayoutParams(paramString);
    localTextView.setGravity(17);
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuScanPhotoActivity.a(MinsuScanPhotoActivity.this).setCurrentItem(((Integer)paramAnonymousView.getTag()).intValue());
      }
    });
    this.f.add(localTextView);
    this.r.addView(localTextView);
  }
  
  private void b()
  {
    if (this.b == null) {
      return;
    }
    this.c = new HashMap();
    this.d = new ArrayList();
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.b.get(i);
      if (!this.d.contains(str))
      {
        this.d.add(str);
        a(str, i);
      }
      this.c.put(Integer.valueOf(i), Integer.valueOf(this.d.indexOf(str)));
      i += 1;
    }
    this.g.setPosChangeListener(this.s);
    b(0);
  }
  
  private void b(int paramInt)
  {
    if ((paramInt < 0) || (this.c == null) || (this.f == null) || (this.f.isEmpty()) || (this.a == null) || (this.a.isEmpty())) {
      return;
    }
    int i = 0;
    while (i < this.f.size())
    {
      TextView localTextView = (TextView)this.f.get(i);
      localTextView.setBackground(null);
      localTextView.setTextColor(ApplicationEx.c.getResources().getColor(2131624583));
      i += 1;
    }
    i = this.a.size();
    paramInt = ((Integer)this.c.get(Integer.valueOf(paramInt % i))).intValue();
    ((TextView)this.f.get(paramInt)).setBackgroundResource(2130839574);
    ((TextView)this.f.get(paramInt)).setTextColor(ApplicationEx.c.getResources().getColor(2131623937));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904932);
    a();
    this.a = ((ArrayList)getIntent().getSerializableExtra("photos"));
    this.b = ((ArrayList)getIntent().getSerializableExtra("texts"));
    this.e = getIntent().getIntExtra("position", 0);
    int i = getIntent().getIntExtra("type", 1);
    if (c.isNullList(this.a)) {
      return;
    }
    b();
    this.g.setCycle(false);
    this.g.setData(this, this.a, this.t, this.e, i);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuScanPhotoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */