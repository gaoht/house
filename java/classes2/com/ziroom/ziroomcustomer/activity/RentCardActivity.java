package com.ziroom.ziroomcustomer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.RentCardDetail;
import com.ziroom.ziroomcustomer.util.ae;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class RentCardActivity
  extends BaseActivity
{
  private final String a = "RentCardActivity";
  private List<RentCardDetail> b;
  private a c;
  private String d;
  private float e;
  private Unbinder f;
  @BindView(2131691788)
  FrameLayout mFlEmpty;
  @BindView(2131689817)
  ListView mLv;
  @BindView(2131691829)
  TextView mTvEmpty;
  @BindView(2131689541)
  TextView mTvTitle;
  @BindView(2131697381)
  TextView rent_card_use;
  
  private void a()
  {
    this.e = Float.parseFloat(getIntent().getStringExtra("money"));
    this.b = ((List)getIntent().getSerializableExtra("mCardDetail"));
    if (this.b != null) {
      if (this.b.size() == 0) {
        this.rent_card_use.setVisibility(8);
      }
    }
    for (;;)
    {
      this.d = getIntent().getStringExtra("errorMessage");
      this.mTvTitle.setText(getString(2131297247));
      if (!ae.isNull(this.d)) {
        break;
      }
      this.mTvEmpty.setText(getString(2131297369));
      return;
      this.rent_card_use.setVisibility(0);
      continue;
      this.rent_card_use.setVisibility(8);
    }
    this.mTvEmpty.setText(this.d);
  }
  
  private void b()
  {
    this.c = new a(this, this.b);
    this.mLv.setAdapter(this.c);
    this.mLv.setEmptyView(this.mFlEmpty);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905087);
    this.f = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.f.unbind();
  }
  
  @OnClick({2131689895, 2131697381})
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689895: 
      finish();
      return;
    }
    paramView = this.c.getmData().iterator();
    float f1 = 0.0F;
    if (paramView.hasNext())
    {
      RentCardDetail localRentCardDetail = (RentCardDetail)paramView.next();
      if (localRentCardDetail.getIsCheck() != 1) {
        break label137;
      }
      f1 = localRentCardDetail.getCardValue() + f1;
    }
    label137:
    for (;;)
    {
      break;
      if (f1 > this.e)
      {
        showToast("租金卡不能超出支付金额！");
        return;
      }
      paramView = getIntent();
      paramView.putExtra("mCardDetail", (Serializable)this.b);
      setResult(99, paramView);
      finish();
      return;
    }
  }
  
  static class ViewHolder
  {
    @BindView(2131695387)
    RelativeLayout card_check;
    @BindView(2131691574)
    ImageView mIv;
    @BindView(2131690049)
    TextView mTvName;
    @BindView(2131690003)
    TextView mTvNum;
    @BindView(2131689852)
    TextView mTvTime;
    @BindView(2131689541)
    TextView mTvTitle;
    
    public ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  private class a
    extends BaseAdapter
  {
    private Context b;
    private List<RentCardDetail> c;
    
    public a(List<RentCardDetail> paramList)
    {
      this.b = paramList;
      List localList;
      this.c = localList;
    }
    
    public int getCount()
    {
      if (this.c == null) {
        return 0;
      }
      return this.c.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.c.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject;
      float f;
      if (paramView != null)
      {
        localObject = (RentCardActivity.ViewHolder)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject;
        if ((this.c != null) && (this.c.size() > 0) && (this.c.get(paramInt) != null))
        {
          paramView.mTvName.setText(((RentCardDetail)this.c.get(paramInt)).getRentCardName() + "");
          localObject = new StringBuffer();
          if (ae.notNull(((RentCardDetail)this.c.get(paramInt)).getDrawDate())) {
            ((StringBuffer)localObject).append(((RentCardDetail)this.c.get(paramInt)).getDrawDate());
          }
          ((StringBuffer)localObject).append(" 至 ");
          if (ae.notNull(((RentCardDetail)this.c.get(paramInt)).getExpireDate())) {
            ((StringBuffer)localObject).append(((RentCardDetail)this.c.get(paramInt)).getExpireDate() + "");
          }
          paramView.mTvTime.setText(((StringBuffer)localObject).toString());
          f = ((RentCardDetail)this.c.get(paramInt)).getCardValue();
          int i = (int)f;
          TextView localTextView = paramView.mTvNum;
          if (f != i) {
            break label425;
          }
          localObject = i + "";
          label286:
          localTextView.setText((CharSequence)localObject);
          if (!ae.notNull(((RentCardDetail)this.c.get(paramInt)).getRentCardDescription())) {
            break label450;
          }
          paramView.mTvTitle.setText(((RentCardDetail)this.c.get(paramInt)).getRentCardDescription());
          paramView.mTvTitle.setVisibility(0);
        }
        label346:
        if (((RentCardDetail)this.c.get(paramInt)).getIsCheck() != 1) {
          break label462;
        }
        paramView.mIv.setImageResource(2130838724);
      }
      for (;;)
      {
        paramView.card_check.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (((RentCardDetail)RentCardActivity.a.a(RentCardActivity.a.this).get(paramInt)).getIsCheck() == 1) {
              ((RentCardDetail)RentCardActivity.a.a(RentCardActivity.a.this).get(paramInt)).setIsCheck(0);
            }
            for (;;)
            {
              RentCardActivity.a.this.notifyDataSetChanged();
              return;
              ((RentCardDetail)RentCardActivity.a.a(RentCardActivity.a.this).get(paramInt)).setIsCheck(1);
            }
          }
        });
        return paramViewGroup;
        paramViewGroup = LayoutInflater.from(this.b).inflate(2130904384, paramViewGroup, false);
        paramView = new RentCardActivity.ViewHolder(paramViewGroup);
        paramViewGroup.setTag(paramView);
        break;
        label425:
        localObject = f + "";
        break label286;
        label450:
        paramView.mTvTitle.setVisibility(8);
        break label346;
        label462:
        paramView.mIv.setImageResource(2130838723);
      }
    }
    
    public List<RentCardDetail> getmData()
    {
      return this.c;
    }
    
    public void setmData(List<RentCardDetail> paramList)
    {
      this.c = paramList;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/RentCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */