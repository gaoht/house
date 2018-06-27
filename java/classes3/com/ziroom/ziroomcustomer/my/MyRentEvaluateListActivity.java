package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.my.adapter.MyRentEvaluateAdapter;
import com.ziroom.ziroomcustomer.my.model.MyRentEvaluateListEntity;
import java.util.List;

public class MyRentEvaluateListActivity
  extends BaseActivity
  implements d.b
{
  private Unbinder a;
  private d.a b;
  private MyRentEvaluateAdapter c;
  @BindView(2131692126)
  ListView mLvRentEvaluate;
  @BindView(2131690894)
  ViewStub mVsError;
  
  public Context getViewContext()
  {
    return this;
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  @OnClick({2131689492})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903438);
    this.a = ButterKnife.bind(this);
    new e(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.b != null) {
      this.b.getData();
    }
  }
  
  public void setAdapter(List<MyRentEvaluateListEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      showError(true, "暂无评价");
      return;
    }
    if (this.c == null)
    {
      this.c = new MyRentEvaluateAdapter(paramList, this);
      this.mLvRentEvaluate.setAdapter(this.c);
      return;
    }
    this.c.setmList(paramList);
    this.c.notifyDataSetChanged();
  }
  
  public void setPresenter(d.a parama)
  {
    this.b = parama;
  }
  
  public void showError(boolean paramBoolean, String paramString)
  {
    if (!isFinishing())
    {
      if (paramBoolean)
      {
        this.mLvRentEvaluate.setVisibility(8);
        this.mVsError.setVisibility(0);
        ImageView localImageView = (ImageView)findViewById(2131690082);
        localImageView.setImageResource(2130840088);
        ((TextView)findViewById(2131690822)).setText(paramString);
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (MyRentEvaluateListActivity.a(MyRentEvaluateListActivity.this) != null) {
              MyRentEvaluateListActivity.a(MyRentEvaluateListActivity.this).getData();
            }
          }
        });
      }
    }
    else {
      return;
    }
    this.mLvRentEvaluate.setVisibility(0);
    this.mVsError.setVisibility(8);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyRentEvaluateListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */