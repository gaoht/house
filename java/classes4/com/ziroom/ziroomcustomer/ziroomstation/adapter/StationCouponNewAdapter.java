package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationCoupon.DataEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StationCouponNewAdapter
  extends BaseAdapter
{
  private Context a;
  private List<StationCoupon.DataEntity> b;
  private SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd");
  private long d = new Date().getTime() - 86400000L;
  
  public StationCouponNewAdapter(Context paramContext, List<StationCoupon.DataEntity> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (StationCoupon.DataEntity)this.b.get(paramInt);
    try
    {
      l = this.c.parse(((StationCoupon.DataEntity)localObject).getEndDate()).getTime();
      if (l < this.d)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label280;
        }
        paramView = LayoutInflater.from(this.a).inflate(2130904386, paramViewGroup, false);
        if ((paramInt != 0) || (!((StationCoupon.DataEntity)localObject).isIsUsable())) {
          break label298;
        }
        paramView.setBackgroundResource(2130837740);
        paramViewGroup = new HolderView(paramView);
        paramViewGroup.mTvName.setText(((StationCoupon.DataEntity)localObject).getActivityName());
        paramViewGroup.mTvTime.setText(((StationCoupon.DataEntity)localObject).getStartDate() + "至" + ((StationCoupon.DataEntity)localObject).getEndDate());
        paramViewGroup.mTvNum.setText(((StationCoupon.DataEntity)localObject).getAmount() + "");
        paramViewGroup.mTvUnit.setText("¥");
        if (paramInt == 0) {
          break label307;
        }
        paramViewGroup.tvStatus.setText("已过期");
        paramViewGroup.tvStatus.setTextColor(this.a.getResources().getColor(2131624599));
        if (ae.isNull(((StationCoupon.DataEntity)localObject).getCondition())) {
          break label387;
        }
        localObject = ((StationCoupon.DataEntity)localObject).getCondition().split("\\n");
        paramViewGroup.mTvTitle.setText(localObject[0]);
        if (localObject.length <= 1) {
          break label377;
        }
        paramViewGroup.mTvSubTitle.setText(localObject[1]);
        return paramView;
      }
    }
    catch (ParseException paramView)
    {
      for (;;)
      {
        long l = Long.MAX_VALUE;
        continue;
        paramInt = 0;
        continue;
        label280:
        paramView = LayoutInflater.from(this.a).inflate(2130904385, paramViewGroup, false);
        continue;
        label298:
        paramView.setBackgroundResource(2130837741);
        continue;
        label307:
        if (((StationCoupon.DataEntity)localObject).isIsUsable())
        {
          paramViewGroup.tvStatus.setText("可使用");
          paramViewGroup.tvStatus.setTextColor(this.a.getResources().getColor(2131624609));
        }
        else
        {
          paramViewGroup.tvStatus.setText("不可用");
          paramViewGroup.tvStatus.setTextColor(this.a.getResources().getColor(2131624599));
        }
      }
      label377:
      paramViewGroup.mTvSubTitle.setVisibility(4);
      return paramView;
    }
    label387:
    paramViewGroup.mTvSubTitle.setVisibility(4);
    paramViewGroup.mTvTitle.setVisibility(4);
    return paramView;
  }
  
  public void setList(List<StationCoupon.DataEntity> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public class HolderView
  {
    @BindView(2131690049)
    TextView mTvName;
    @BindView(2131690003)
    TextView mTvNum;
    @BindView(2131694578)
    TextView mTvSubTitle;
    @BindView(2131689852)
    TextView mTvTime;
    @BindView(2131689541)
    TextView mTvTitle;
    @BindView(2131689840)
    TextView mTvUnit;
    @BindView(2131689822)
    TextView tvStatus;
    
    public HolderView(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/StationCouponNewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */