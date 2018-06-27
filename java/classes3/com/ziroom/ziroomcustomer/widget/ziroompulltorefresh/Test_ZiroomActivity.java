package com.ziroom.ziroomcustomer.widget.ziroompulltorefresh;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class Test_ZiroomActivity
  extends Activity
{
  private ZiroomPtrFrameLayout a;
  private RecyclerView b;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    this.a = ((ZiroomPtrFrameLayout)findViewById(2131689692));
    paramBundle = LayoutInflater.from(this).inflate(2130903040, null);
    this.a.setHeaderView(paramBundle);
    this.b.setOnScrollListener(new RecyclerView.l()
    {
      public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (((LinearLayoutManager)paramAnonymousRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0)
        {
          Test_ZiroomActivity.a(Test_ZiroomActivity.this).setEnabled(true);
          return;
        }
        Test_ZiroomActivity.a(Test_ZiroomActivity.this).setEnabled(false);
      }
    });
    this.a.setmPaintColor(-65536);
    this.a.setmOnPositionChangeListener(new ZiroomPtrFrameLayout.a()
    {
      public void onPositionChange(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        Log.e("Test_ZiroomActivity", "onPositionChange: " + paramAnonymousFloat1 + "hright00" + paramAnonymousFloat2);
      }
    });
    this.a.setPtrHandler(new a()
    {
      public boolean checkCanDoRefresh(PtrFrameLayout paramAnonymousPtrFrameLayout, View paramAnonymousView1, View paramAnonymousView2)
      {
        return true;
      }
      
      public void onRefreshBegin(PtrFrameLayout paramAnonymousPtrFrameLayout) {}
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ziroompulltorefresh/Test_ZiroomActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */