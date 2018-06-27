package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.flux.b;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.newmovehouse.d.d;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanGoods;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MovingVanGoodsActivity
  extends BaseFluxActivity
{
  LayoutInflater b;
  Unbinder c;
  d d;
  com.ziroom.ziroomcustomer.newmovehouse.a.a e;
  NumberFormat f = NumberFormat.getNumberInstance();
  private BaseAdapter g = new BaseAdapter()
  {
    public int getCount()
    {
      if ((MovingVanGoodsActivity.this.d == null) || (MovingVanGoodsActivity.this.d.getGoodsList() == null)) {
        return 0;
      }
      return MovingVanGoodsActivity.this.d.getGoodsList().size();
    }
    
    public Object getItem(int paramAnonymousInt)
    {
      return MovingVanGoodsActivity.this.d.getGoodsList().get(paramAnonymousInt);
    }
    
    public long getItemId(int paramAnonymousInt)
    {
      return paramAnonymousInt;
    }
    
    public View getView(int paramAnonymousInt, View paramAnonymousView, final ViewGroup paramAnonymousViewGroup)
    {
      final MovingVanGoods localMovingVanGoods = (MovingVanGoods)getItem(paramAnonymousInt);
      View localView;
      if (paramAnonymousView == null)
      {
        localView = MovingVanGoodsActivity.this.b.inflate(2130904376, paramAnonymousViewGroup, false);
        paramAnonymousView = new a();
        paramAnonymousView.a = ((SimpleDraweeView)localView.findViewById(2131691098));
        paramAnonymousView.b = ((TextView)localView.findViewById(2131690049));
        paramAnonymousView.c = ((TextView)localView.findViewById(2131690073));
        paramAnonymousView.d = ((TextView)localView.findViewById(2131689912));
        paramAnonymousView.f = ((TextView)localView.findViewById(2131690003));
        paramAnonymousView.e = ((ImageButton)localView.findViewById(2131694892));
        paramAnonymousView.g = ((ImageButton)localView.findViewById(2131694816));
        localView.setTag(paramAnonymousView);
        paramAnonymousViewGroup = paramAnonymousView;
      }
      for (;;)
      {
        paramAnonymousViewGroup.a.setController(c.frescoController(localMovingVanGoods.imageUrl));
        paramAnonymousViewGroup.b.setText(localMovingVanGoods.materielName);
        paramAnonymousViewGroup.c.setText(localMovingVanGoods.materielPurpose);
        if (localMovingVanGoods.materielUnitPrice > 0L) {
          paramAnonymousViewGroup.d.setText("¥" + MovingVanGoodsActivity.this.f.format(localMovingVanGoods.materielUnitPrice / 100.0D));
        }
        paramAnonymousViewGroup.e.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            MovingVanGoodsActivity.this.e.updateMvGoods(MovingVanGoodsActivity.this, localMovingVanGoods.logicCode, -1);
          }
        });
        paramAnonymousViewGroup.g.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            MovingVanGoodsActivity.this.e.updateMvGoods(MovingVanGoodsActivity.this, localMovingVanGoods.logicCode, 1);
          }
        });
        paramAnonymousViewGroup.f.addTextChangedListener(new TextWatcher()
        {
          public void afterTextChanged(Editable paramAnonymous2Editable)
          {
            int i = Integer.parseInt(paramAnonymous2Editable.toString());
            if (i <= 0)
            {
              paramAnonymousViewGroup.f.setVisibility(8);
              paramAnonymousViewGroup.e.setVisibility(8);
              return;
            }
            if (i >= 99)
            {
              paramAnonymousViewGroup.g.setEnabled(false);
              return;
            }
            paramAnonymousViewGroup.g.setEnabled(true);
            paramAnonymousViewGroup.f.setVisibility(0);
            paramAnonymousViewGroup.e.setVisibility(0);
          }
          
          public void beforeTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3) {}
          
          public void onTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3) {}
        });
        paramAnonymousViewGroup.f.setText(localMovingVanGoods.buyNumber + "");
        return localView;
        paramAnonymousViewGroup = (a)paramAnonymousView.getTag();
        localView = paramAnonymousView;
      }
    }
    
    class a
    {
      SimpleDraweeView a;
      TextView b;
      TextView c;
      TextView d;
      ImageButton e;
      TextView f;
      ImageButton g;
      
      a() {}
    }
  };
  @BindView(2131689816)
  Button mBtnSubmit;
  @BindView(2131691788)
  FrameLayout mFlEmpty;
  @BindView(2131689838)
  LinearLayout mLlBottom;
  @BindView(2131689817)
  ListView mLv;
  @BindView(2131689912)
  TextView mTvPrice;
  
  private void a()
  {
    e();
    this.b = getLayoutInflater();
    this.mLv.setAdapter(this.g);
  }
  
  private void b()
  {
    this.f.setMaximumFractionDigits(2);
    this.f.setMinimumFractionDigits(2);
    this.d = new d(this);
    this.a.register(this.d);
    this.e = com.ziroom.ziroomcustomer.newmovehouse.a.a.getInstance(this.a);
    ArrayList localArrayList = getIntent().getParcelableArrayListExtra("goods");
    String str1 = getIntent().getStringExtra("token");
    String str2 = getIntent().getStringExtra("productCode");
    this.e.initMvGoods(this, str2, str1, localArrayList);
  }
  
  private void e()
  {
    ((ImageView)findViewById(2131691493)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MovingVanGoodsActivity.this.finish();
      }
    });
    findViewById(2131696483).setVisibility(8);
    findViewById(2131696484).setVisibility(8);
    ((TextView)findViewById(2131689541)).setText("搬家用品");
  }
  
  private void f()
  {
    if ((this.d.getGoodsSelectedList() != null) && (this.d.getGoodsSelectedList().size() > 0)) {
      this.mTvPrice.setTextColor(Color.parseColor("#FF6262"));
    }
    for (;;)
    {
      this.mBtnSubmit.setEnabled(true);
      if (TextUtils.isEmpty(this.d.getPriceText())) {
        break;
      }
      SpannableString localSpannableString = new SpannableString(this.d.getPriceText());
      localSpannableString.setSpan(new AbsoluteSizeSpan(14, true), 0, 1, 18);
      localSpannableString.setSpan(new AbsoluteSizeSpan(18, true), 1, localSpannableString.length(), 18);
      this.mTvPrice.setText(localSpannableString);
      return;
      this.mTvPrice.setTextColor(Color.parseColor("#DDDDDD"));
    }
    this.mTvPrice.setText(this.d.getPriceText());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903361);
    this.c = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.c.unbind();
    this.a.unregister(this.d);
    super.onDestroy();
  }
  
  public void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    label44:
    int i;
    switch (parama.hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (!parama.equals("service_mv_van_goods_init")) {
          break label44;
        }
        i = 0;
        continue;
        if (!parama.equals("service_mv_van_goods_update")) {
          break label44;
        }
        i = 1;
        continue;
        if (!parama.equals("service_mv_van_goods_submit")) {
          break label44;
        }
        i = 2;
      }
    }
    this.g.notifyDataSetChanged();
    this.mLv.setEmptyView(this.mFlEmpty);
    if (this.g.getCount() > 0)
    {
      this.mLlBottom.setVisibility(0);
      f();
      return;
    }
    this.mLlBottom.setVisibility(8);
    return;
    this.g.notifyDataSetChanged();
    f();
    return;
    parama = new Intent();
    parama.putParcelableArrayListExtra("goods", (ArrayList)this.d.getGoodsSelectedList());
    setResult(-1, parama);
    finish();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.e.submitMvGoods(this, this.d.getProductCode(), this.d.getToken(), this.d.getGoodsSelectedList());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MovingVanGoodsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */