package com.ziroom.ziroomcustomer.minsu.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.aspsine.swipetoloadlayout.a;
import com.aspsine.swipetoloadlayout.b;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.adapter.s;
import java.util.ArrayList;
import java.util.List;

public class MinsuTestMDMainActivity
  extends Activity
{
  ObjectAnimator a;
  @BindView(2131696301)
  AppBarLayout appBarLayout;
  GestureDetector.SimpleOnGestureListener b = new GestureDetector.SimpleOnGestureListener()
  {
    public boolean onDown(MotionEvent paramAnonymousMotionEvent)
    {
      Log.i("Gesture", "onDown");
      return super.onDown(paramAnonymousMotionEvent);
    }
    
    public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      Log.i("Gesture", "onFling");
      return super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
    }
    
    public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      Log.i("Gesture", "onScroll");
      return super.onScroll(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
    }
    
    public void onShowPress(MotionEvent paramAnonymousMotionEvent)
    {
      Log.i("Gesture", "onShowPress");
      super.onShowPress(paramAnonymousMotionEvent);
    }
    
    public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
    {
      Log.i("Gesture", "onSingleTapUp");
      return super.onSingleTapUp(paramAnonymousMotionEvent);
    }
  };
  private SwipeToLoadLayout c;
  @BindView(2131691402)
  CoordinatorLayout coordinatorLayout;
  private RecyclerView d;
  private s e;
  private List<String> f = new ArrayList();
  private final int g = 1;
  private Handler h = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if (paramAnonymousMessage.what == 1) {
        removeMessages(1);
      }
    }
  };
  @BindView(2131691597)
  ViewGroup title_area;
  @BindView(2131696303)
  ViewGroup toolbar_content;
  @BindView(2131696480)
  TextView tvBack;
  @BindView(2131696481)
  TextView tvTitle;
  
  private void a()
  {
    this.tvTitle.setText("24K纯帅");
    b();
  }
  
  private void a(float paramFloat)
  {
    if (this.a == null) {
      this.a = ObjectAnimator.ofFloat(this.title_area, View.ALPHA, new float[] { paramFloat });
    }
    for (;;)
    {
      this.a.setDuration(1L);
      this.a.start();
      return;
      this.a.setFloatValues(new float[] { paramFloat });
    }
  }
  
  private void b()
  {
    this.tvBack.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuTestMDMainActivity.this.finish();
      }
    });
    this.appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener()
    {
      public void onOffsetChanged(AppBarLayout paramAnonymousAppBarLayout, int paramAnonymousInt)
      {
        float f = Math.abs(paramAnonymousInt / 495.0F);
        Log.i("info", "onOffsetChanged  verticalOffset = " + paramAnonymousInt + "       === " + f);
        if (f > 0.5D) {
          MinsuTestMDMainActivity.a(MinsuTestMDMainActivity.this, (f - 0.5F) / 0.5F);
        }
      }
    });
  }
  
  private void c()
  {
    int i = 0;
    while (i < 35)
    {
      this.f.add("第一页24K纯帅" + (i + 1));
      i += 1;
    }
  }
  
  private void d()
  {
    this.c = ((SwipeToLoadLayout)findViewById(2131691285));
    this.c.setOnLoadMoreListener(new a()
    {
      public void onLoadMore()
      {
        MinsuTestMDMainActivity.a(MinsuTestMDMainActivity.this);
      }
    });
    this.c.setOnRefreshListener(new b()
    {
      public void onRefresh() {}
    });
    this.c.setRefreshEnabled(false);
    this.d = ((RecyclerView)findViewById(2131689522));
    this.d.addOnScrollListener(new RecyclerView.l()
    {
      public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        Log.i("RecyclerView", "newState = " + paramAnonymousInt);
      }
      
      public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
      }
    });
    this.d.setLayoutManager(new LinearLayoutManager(this, 1, false));
    this.e = new s(this, this.f);
    this.d.setAdapter(this.e);
    new GestureDetector.SimpleOnGestureListener() {};
  }
  
  private void e()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          Thread.sleep(2500L);
          MinsuTestMDMainActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              MinsuTestMDMainActivity.b(MinsuTestMDMainActivity.this);
            }
          });
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }).start();
  }
  
  private void f()
  {
    g.textToast(this, "刷新|加载完成");
    if (this.c != null)
    {
      this.c.setRefreshing(false);
      this.c.setLoadingMore(false);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setContentView(2130904741);
    ButterKnife.bind(this);
    a();
    c();
    d();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuTestMDMainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */