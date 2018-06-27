package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.CycleViewPager;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.a;
import com.ziroom.ziroomcustomer.widget.CycleViewPager.b;
import java.util.List;

public class ZryuScanPhotoActivity
  extends BaseActivity
{
  a a;
  private List<String> b;
  private List<String> c;
  private List<Integer> d;
  private List<String> e;
  private int f;
  private TextView g;
  private String r;
  private CycleViewPager s;
  private RecyclerView t;
  private int u;
  private CycleViewPager.a v = new CycleViewPager.a()
  {
    public void onImageClick(int paramAnonymousInt, View paramAnonymousView)
    {
      if ((ZryuScanPhotoActivity.a(ZryuScanPhotoActivity.this) != null) && (paramAnonymousInt < ZryuScanPhotoActivity.a(ZryuScanPhotoActivity.this).size()))
      {
        paramAnonymousView = (String)ZryuScanPhotoActivity.a(ZryuScanPhotoActivity.this).get(paramAnonymousInt);
        if (ae.notNull(paramAnonymousView)) {
          JsBridgeWebActivity.start(ZryuScanPhotoActivity.this, null, paramAnonymousView);
        }
      }
    }
  };
  private CycleViewPager.b w = new CycleViewPager.b()
  {
    public void onPosChange(int paramAnonymousInt)
    {
      ZryuScanPhotoActivity.a(ZryuScanPhotoActivity.this, paramAnonymousInt - 1);
      paramAnonymousInt = 0;
      for (;;)
      {
        if (paramAnonymousInt < ZryuScanPhotoActivity.b(ZryuScanPhotoActivity.this).size())
        {
          int i = ((Integer)ZryuScanPhotoActivity.b(ZryuScanPhotoActivity.this).get(paramAnonymousInt)).intValue();
          if (ZryuScanPhotoActivity.c(ZryuScanPhotoActivity.this) >= i) {}
        }
        else
        {
          ZryuScanPhotoActivity.b(ZryuScanPhotoActivity.this, paramAnonymousInt - 1);
          ZryuScanPhotoActivity.this.a.notifyDataSetChanged();
          return;
        }
        paramAnonymousInt += 1;
      }
    }
  };
  
  private void a()
  {
    this.s = ((CycleViewPager)getSupportFragmentManager().findFragmentById(2131692934));
    this.t = ((RecyclerView)findViewById(2131692860));
    this.g = ((TextView)findViewById(2131692935));
    if (TextUtils.isEmpty(this.r))
    {
      this.g.setVisibility(8);
      return;
    }
    this.g.setVisibility(0);
  }
  
  private void b()
  {
    if ((this.c != null) && (this.d != null) && (this.c.size() == this.d.size()) && (this.c.size() > 0)) {}
    for (;;)
    {
      this.a = new a(null);
      this.t.setLayoutManager(new LinearLayoutManager(this, 0, false));
      this.t.setAdapter(this.a);
      this.s.setPosChangeListener(this.w);
      this.s.setCycle(true);
      this.s.setData(this, this.b, this.v, this.f, 1);
      return;
      this.c = null;
      this.d = null;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903596);
    this.e = getIntent().getStringArrayListExtra("url");
    this.r = getIntent().getStringExtra("panoramicUrl");
    this.b = getIntent().getStringArrayListExtra("photos");
    this.c = getIntent().getStringArrayListExtra("types");
    this.d = getIntent().getIntegerArrayListExtra("typeIndexs");
    this.f = getIntent().getIntExtra("position", 0);
    a();
    b();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131692935: 
      do
      {
        return;
      } while (TextUtils.isEmpty(this.r));
      JsBridgeWebActivity.start(this, "全景看房", this.r);
      return;
    }
    finish();
  }
  
  private class a
    extends RecyclerView.a
  {
    private a() {}
    
    public int getItemCount()
    {
      if ((ZryuScanPhotoActivity.d(ZryuScanPhotoActivity.this) != null) && (ZryuScanPhotoActivity.b(ZryuScanPhotoActivity.this) != null) && (ZryuScanPhotoActivity.d(ZryuScanPhotoActivity.this).size() == ZryuScanPhotoActivity.b(ZryuScanPhotoActivity.this).size())) {
        return ZryuScanPhotoActivity.d(ZryuScanPhotoActivity.this).size();
      }
      return 0;
    }
    
    public void onBindViewHolder(RecyclerView.u paramu, final int paramInt)
    {
      paramu = ((a)paramu).a;
      paramu.setText((CharSequence)ZryuScanPhotoActivity.d(ZryuScanPhotoActivity.this).get(paramInt));
      if (paramInt == ZryuScanPhotoActivity.e(ZryuScanPhotoActivity.this))
      {
        paramu.setBackgroundResource(2130839574);
        paramu.setTextColor(ZryuScanPhotoActivity.this.getResources().getColor(2131624599));
      }
      for (;;)
      {
        paramu.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            int i = ((Integer)ZryuScanPhotoActivity.b(ZryuScanPhotoActivity.this).get(paramInt)).intValue();
            if (i + 1 <= ZryuScanPhotoActivity.f(ZryuScanPhotoActivity.this).size()) {
              ZryuScanPhotoActivity.g(ZryuScanPhotoActivity.this).setCurrentItem(i + 1);
            }
          }
        });
        return;
        paramu.setBackground(null);
      }
    }
    
    public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      return new a(LayoutInflater.from(ZryuScanPhotoActivity.this).inflate(2130904627, paramViewGroup, false));
    }
    
    private class a
      extends RecyclerView.u
    {
      Button a;
      
      public a(View paramView)
      {
        super();
        this.a = ((Button)paramView.findViewById(2131695868));
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuScanPhotoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */