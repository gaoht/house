package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseDetailConfigBean;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import java.util.List;

public class MinsuServicelistActivity
  extends BaseActivity
{
  private List<MinsuHouseDetailConfigBean> a;
  @BindView(2131691272)
  CommonTitle commonTitle;
  @BindView(2131691217)
  ListView list;
  
  public void finish()
  {
    super.finish();
    k.animFinishAlpha(this);
  }
  
  public void initTitle()
  {
    this.commonTitle.showRightText(false, null);
    this.commonTitle.setLeftButtonType(4);
    this.commonTitle.setBottomLineAlpha(0.0F);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuServicelistActivity.this.finish();
      }
    });
    this.commonTitle.showTopLine(this.list);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903332);
    ButterKnife.bind(this);
    initTitle();
    this.a = ((List)getIntent().getSerializableExtra("houseConfigs"));
    paramBundle = new a(this.a);
    this.list.setAdapter(paramBundle);
  }
  
  class a
    extends BaseAdapter
  {
    private List<MinsuHouseDetailConfigBean> b;
    
    public a()
    {
      List localList;
      this.b = localList;
    }
    
    public int getCount()
    {
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      return ((MinsuHouseDetailConfigBean)this.b.get(paramInt)).getType();
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramViewGroup = new MinsuServicelistActivity.b();
        if (getItemViewType(paramInt) == 0)
        {
          paramView = LayoutInflater.from(ApplicationEx.c).inflate(2130904316, null);
          paramViewGroup.a = ((TextView)paramView.findViewById(2131689541));
        }
      }
      for (;;)
      {
        MinsuHouseDetailConfigBean localMinsuHouseDetailConfigBean = (MinsuHouseDetailConfigBean)this.b.get(paramInt);
        if (localMinsuHouseDetailConfigBean == null)
        {
          return paramView;
          if (getItemViewType(paramInt) == 1)
          {
            paramView = LayoutInflater.from(ApplicationEx.c).inflate(2130904315, null);
            paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
            paramViewGroup.b = ((SimpleDraweeView)paramView.findViewById(2131690097));
            continue;
            paramViewGroup = (MinsuServicelistActivity.b)paramView.getTag();
          }
        }
        else
        {
          paramViewGroup.a.setText(localMinsuHouseDetailConfigBean.getName());
          if (paramViewGroup.b != null) {
            paramViewGroup.b.setController(c.frescoController(localMinsuHouseDetailConfigBean.getIcPath()));
          }
          paramView.setTag(paramViewGroup);
          return paramView;
        }
        paramView = null;
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
  }
  
  static class b
  {
    TextView a;
    SimpleDraweeView b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuServicelistActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */