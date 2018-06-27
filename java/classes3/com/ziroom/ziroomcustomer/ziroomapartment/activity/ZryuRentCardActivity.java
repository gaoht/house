package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillDetailModelV2.DataBean.CardCouponsBean;
import java.util.ArrayList;
import java.util.Iterator;

public class ZryuRentCardActivity
  extends BaseActivity
{
  ArrayList<ZryuBillDetailModelV2.DataBean.CardCouponsBean> a;
  private final String b = "ZryuRentCardActivity";
  private a c;
  private Unbinder d;
  @BindView(2131691788)
  FrameLayout mFlEmpty;
  @BindView(2131689817)
  ListView mLv;
  @BindView(2131691829)
  TextView mTvEmpty;
  @BindView(2131689541)
  TextView mTvTitle;
  @BindView(2131689895)
  ImageView tvBack;
  @BindView(2131692909)
  TextView tvSelectCancelAll;
  
  private void a()
  {
    this.mTvTitle.setText(getString(2131297247));
    this.mTvEmpty.setText(getString(2131297246));
  }
  
  private void b()
  {
    this.a = getIntent().getParcelableArrayListExtra("rentCards");
    this.c = new a(this, this.a);
    this.mLv.setAdapter(this.c);
    this.mLv.setEmptyView(this.mFlEmpty);
    if (e())
    {
      this.tvSelectCancelAll.setText("取消");
      return;
    }
    this.tvSelectCancelAll.setText("全选");
  }
  
  private boolean e()
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (((ZryuBillDetailModelV2.DataBean.CardCouponsBean)localIterator.next()).isChecked != 1) {
          return false;
        }
      }
    }
    return true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903589);
    this.d = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.d.unbind();
    super.onDestroy();
  }
  
  @OnClick({2131689895, 2131692909})
  public void onViewClick(View paramView)
  {
    int j = 1;
    int k = 0;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689895: 
      paramView = new Intent();
      paramView.putExtra("rentCards", this.a);
      setResult(0, paramView);
      finish();
      return;
    }
    int i;
    if ("全选".equals(this.tvSelectCancelAll.getText().toString().trim()))
    {
      if (this.a != null) {}
      for (i = 1;; i = 0)
      {
        j = k;
        if (this.a.size() > 0) {
          j = 1;
        }
        if ((i & j) == 0) {
          break label167;
        }
        paramView = this.a.iterator();
        while (paramView.hasNext()) {
          ((ZryuBillDetailModelV2.DataBean.CardCouponsBean)paramView.next()).isChecked = 1;
        }
      }
      this.tvSelectCancelAll.setText("取消");
    }
    for (;;)
    {
      label167:
      this.c.notifyDataSetChanged();
      return;
      if ("取消".equals(this.tvSelectCancelAll.getText().toString().trim()))
      {
        if (this.a != null)
        {
          i = 1;
          if (this.a.size() <= 0) {
            break label261;
          }
        }
        for (;;)
        {
          if ((i & j) == 0) {
            break label264;
          }
          paramView = this.a.iterator();
          while (paramView.hasNext()) {
            ((ZryuBillDetailModelV2.DataBean.CardCouponsBean)paramView.next()).isChecked = 0;
          }
          i = 0;
          break;
          label261:
          j = 0;
        }
        label264:
        continue;
        this.tvSelectCancelAll.setText("全选");
      }
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
    @BindView(2131694578)
    TextView mTvSubTitle;
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
    private ArrayList<ZryuBillDetailModelV2.DataBean.CardCouponsBean> c;
    
    public a(ArrayList<ZryuBillDetailModelV2.DataBean.CardCouponsBean> paramArrayList)
    {
      this.b = paramArrayList;
      ArrayList localArrayList;
      this.c = localArrayList;
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
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      final Object localObject;
      if (paramView != null)
      {
        localObject = (ZryuRentCardActivity.ViewHolder)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject;
        localObject = (ZryuBillDetailModelV2.DataBean.CardCouponsBean)this.c.get(paramInt);
        if (localObject != null)
        {
          paramView.mTvName.setText(((ZryuBillDetailModelV2.DataBean.CardCouponsBean)localObject).name);
          paramView.mTvTime.setText(((ZryuBillDetailModelV2.DataBean.CardCouponsBean)localObject).startTime + " 至 " + ((ZryuBillDetailModelV2.DataBean.CardCouponsBean)localObject).endTime);
          paramView.mTvNum.setText(((ZryuBillDetailModelV2.DataBean.CardCouponsBean)localObject).money);
          if (TextUtils.isEmpty(((ZryuBillDetailModelV2.DataBean.CardCouponsBean)localObject).rule)) {
            break label238;
          }
          String[] arrayOfString = ((ZryuBillDetailModelV2.DataBean.CardCouponsBean)localObject).rule.split("\\n");
          paramView.mTvTitle.setText(arrayOfString[0]);
          if (arrayOfString.length <= 1) {
            break label227;
          }
          paramView.mTvSubTitle.setText(arrayOfString[1]);
          label150:
          paramView.mTvTitle.setVisibility(0);
          label158:
          if (((ZryuBillDetailModelV2.DataBean.CardCouponsBean)localObject).isChecked != 1) {
            break label259;
          }
          paramView.mIv.setImageResource(2130838724);
        }
      }
      for (;;)
      {
        paramView.card_check.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (localObject.isChecked == 1) {}
            for (localObject.isChecked = 0;; localObject.isChecked = 1)
            {
              ZryuRentCardActivity.a.this.notifyDataSetChanged();
              return;
            }
          }
        });
        return paramViewGroup;
        paramViewGroup = LayoutInflater.from(this.b).inflate(2130904626, paramViewGroup, false);
        paramView = new ZryuRentCardActivity.ViewHolder(paramViewGroup);
        paramViewGroup.setTag(paramView);
        break;
        label227:
        paramView.mTvSubTitle.setVisibility(4);
        break label150;
        label238:
        paramView.mTvTitle.setVisibility(8);
        paramView.mTvSubTitle.setVisibility(8);
        break label158;
        label259:
        paramView.mIv.setImageResource(2130838723);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuRentCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */