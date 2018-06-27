package com.ziroom.ziroomcustomer.minsu.landlordangel;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.c;

public class LandlordAngelActivity
  extends BaseActivity
  implements b.b
{
  private b.a a;
  private Unbinder b;
  @BindView(2131691050)
  LinearLayout ll_landlord_angel_pre;
  @BindView(2131691047)
  RecyclerView recyclerview_landlord_angel;
  @BindView(2131691049)
  RelativeLayout rl_landlord_angel_pre;
  @BindView(2131691046)
  TextView tv_landlord_angel_describe;
  @BindView(2131691051)
  TextView tv_landlord_angel_pre_arrowright;
  @BindView(2131691048)
  TextView tv_landlord_angel_time;
  @BindView(2131691044)
  TextView tv_landlord_angel_title;
  
  private void a()
  {
    Object localObject = new a(this);
    this.recyclerview_landlord_angel.setAdapter((RecyclerView.a)localObject);
    localObject = new LinearLayoutManager(this, 1, false)
    {
      public boolean canScrollVertically()
      {
        return false;
      }
    };
    this.recyclerview_landlord_angel.setLayoutManager((RecyclerView.h)localObject);
  }
  
  public LinearLayout getLlLandlordPre()
  {
    return this.ll_landlord_angel_pre;
  }
  
  public RecyclerView getRecyclerview()
  {
    return this.recyclerview_landlord_angel;
  }
  
  public RelativeLayout getRlLandlordPre()
  {
    return this.rl_landlord_angel_pre;
  }
  
  public TextView getTvLandlordDescribe()
  {
    return this.tv_landlord_angel_describe;
  }
  
  public TextView getTvLandlordTime()
  {
    return this.tv_landlord_angel_time;
  }
  
  public TextView getTvLandlordTitle()
  {
    return this.tv_landlord_angel_title;
  }
  
  public Context getViewContext()
  {
    return this;
  }
  
  public TextView gettTvLandlordArrowright()
  {
    return this.tv_landlord_angel_pre_arrowright;
  }
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903239);
    this.b = ButterKnife.bind(this);
    a();
    this.a = new LandlordAngelPresenter(this);
    this.a.start();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.b.unbind();
    this.a.detachView();
  }
  
  public void setPresenter(b.a parama)
  {
    this.a = ((b.a)c.checkNotNull(parama));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordangel/LandlordAngelActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */