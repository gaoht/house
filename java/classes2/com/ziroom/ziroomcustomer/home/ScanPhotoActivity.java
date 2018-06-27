package com.ziroom.ziroomcustomer.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.widget.CycleViewPager;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.a;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ScanPhotoActivity
  extends BaseActivity
{
  public static Map<String, Integer> a;
  int b = 0;
  private List<String> c;
  private int d;
  private Context e;
  private List<Integer> f = new ArrayList();
  private List<TextView> g = new ArrayList();
  private CycleViewPager r;
  private HorizontalScrollView s;
  private LinearLayout t;
  private int u;
  private CycleViewPager.a v = new CycleViewPager.a()
  {
    public void onImageClick(int paramAnonymousInt, View paramAnonymousView)
    {
      if (ScanPhotoActivity.a(ScanPhotoActivity.this).isCycle()) {
        ScanPhotoActivity.this.finish();
      }
    }
  };
  private CycleViewPager.b w = new CycleViewPager.b()
  {
    public void onPosChange(int paramAnonymousInt)
    {
      int i = 0;
      if (i < ScanPhotoActivity.b(ScanPhotoActivity.this).size())
      {
        TextView localTextView = (TextView)ScanPhotoActivity.b(ScanPhotoActivity.this).get(i);
        if (i + 1 >= ScanPhotoActivity.b(ScanPhotoActivity.this).size()) {
          if (((Integer)ScanPhotoActivity.c(ScanPhotoActivity.this).get(i)).intValue() > paramAnonymousInt) {}
        }
        for (ScanPhotoActivity.this.b = i;; ScanPhotoActivity.this.b = i) {
          do
          {
            localTextView.setBackground(null);
            localTextView.setTextColor(ApplicationEx.c.getResources().getColor(2131624583));
            i += 1;
            break;
          } while ((((Integer)ScanPhotoActivity.c(ScanPhotoActivity.this).get(i)).intValue() > paramAnonymousInt) || (paramAnonymousInt > ((Integer)ScanPhotoActivity.c(ScanPhotoActivity.this).get(i + 1)).intValue()));
        }
      }
      ((TextView)ScanPhotoActivity.b(ScanPhotoActivity.this).get(ScanPhotoActivity.this.b)).setBackgroundResource(2130839574);
      ((TextView)ScanPhotoActivity.b(ScanPhotoActivity.this).get(ScanPhotoActivity.this.b)).setTextColor(ApplicationEx.c.getResources().getColor(2131623937));
      ((TextView)ScanPhotoActivity.b(ScanPhotoActivity.this).get(ScanPhotoActivity.this.b)).setPadding(10, 10, 10, 10);
    }
  };
  
  private void a()
  {
    this.r = ((CycleViewPager)getSupportFragmentManager().findFragmentById(2131690555));
    this.s = ((HorizontalScrollView)findViewById(2131690556));
    this.t = ((LinearLayout)findViewById(2131690557));
  }
  
  public void bindLunboTu(List<String> paramList, Map<String, Integer> paramMap, int paramInt)
  {
    if (this.u != 1)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        final Map.Entry localEntry = (Map.Entry)paramMap.next();
        TextView localTextView = new TextView(ApplicationEx.c);
        localTextView.setPadding(10, 10, 10, 10);
        localTextView.setText((CharSequence)localEntry.getKey());
        localTextView.setTextColor(ApplicationEx.c.getResources().getColor(2131624583));
        localTextView.setTextSize(13.0F);
        localTextView.setBackground(null);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.setMargins(55, 0, 0, 0);
        localLayoutParams.gravity = 16;
        localTextView.setLayoutParams(localLayoutParams);
        localTextView.setTag(2131690557, localEntry.getValue());
        this.f.add(localEntry.getValue());
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            ScanPhotoActivity.a(ScanPhotoActivity.this).setCurrentItem(((Integer)localEntry.getValue()).intValue());
          }
        });
        this.g.add(localTextView);
        this.t.addView(localTextView);
      }
      this.s.setVisibility(0);
      this.r.setPosChangeListener(this.w);
    }
    this.r.setCycle(true);
    this.r.setData(this, paramList, this.v, paramInt, 1);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905109);
    this.e = this;
    a();
    this.c = ((ArrayList)getIntent().getSerializableExtra("photos"));
    this.d = getIntent().getIntExtra("position", 0);
    this.u = getIntent().getIntExtra("mHouse_type", 1);
    bindLunboTu(this.c, a, this.d);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/ScanPhotoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */