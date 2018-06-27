package com.ziroom.ziroomcustomer.my.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.EvaluateSignActivity;
import com.ziroom.ziroomcustomer.my.model.MyRentEvaluateListEntity;
import com.ziroom.ziroomcustomer.my.model.MyRentEvaluateListEntity.KeeperInfo;
import com.ziroom.ziroomcustomer.my.model.MyRentEvaluateListEntity.OrderInfo;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyRentEvaluateAdapter
  extends BaseAdapter
{
  private List<MyRentEvaluateListEntity> a;
  private Context b;
  private viewHolder c;
  
  public MyRentEvaluateAdapter(List<MyRentEvaluateListEntity> paramList, Context paramContext)
  {
    if (paramList == null) {}
    for (this.a = new ArrayList();; this.a = paramList)
    {
      this.b = paramContext;
      return;
    }
  }
  
  private View a(MyRentEvaluateListEntity.OrderInfo paramOrderInfo, int paramInt)
  {
    View localView = View.inflate(this.b, 2130905201, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131694588);
    TextView localTextView2 = (TextView)localView.findViewById(2131691546);
    float f = 0.0F;
    Iterator localIterator = ((MyRentEvaluateListEntity)this.a.get(paramInt)).getOrderInfo().iterator();
    if (localIterator.hasNext())
    {
      MyRentEvaluateListEntity.OrderInfo localOrderInfo = (MyRentEvaluateListEntity.OrderInfo)localIterator.next();
      if (f >= ah.getTextViewLength(localTextView1, localOrderInfo.getCode())) {
        break label151;
      }
      f = ah.getTextViewLength(localTextView1, localOrderInfo.getCode());
    }
    label151:
    for (;;)
    {
      break;
      if (localTextView1.getWidth() != f) {
        localTextView1.setWidth((int)f);
      }
      localTextView1.setText(paramOrderInfo.getCode());
      localTextView2.setText(paramOrderInfo.getValue());
      return localView;
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130903371, null);
      this.c = new viewHolder(paramView);
      paramView.setTag(this.c);
    }
    for (;;)
    {
      paramViewGroup = (MyRentEvaluateListEntity)this.a.get(paramInt);
      if (paramViewGroup != null) {
        break;
      }
      return paramView;
      this.c = ((viewHolder)paramView.getTag());
    }
    this.c.tv_btn.setText(paramViewGroup.getButStr());
    if (paramViewGroup.getKeeperInfo() != null)
    {
      this.c.siv_icon.setController(c.frescoController(paramViewGroup.getKeeperInfo().getKeeperPhoto()));
      this.c.tv_name.setText(paramViewGroup.getKeeperInfo().getKeeperStr());
      this.c.tv_name.setVisibility(0);
      this.c.siv_icon.setVisibility(0);
    }
    while ((paramViewGroup.getOrderInfo() != null) && (paramViewGroup.getOrderInfo().size() > 0))
    {
      this.c.ll_content.removeAllViews();
      int i = 0;
      while (i < paramViewGroup.getOrderInfo().size())
      {
        View localView = a((MyRentEvaluateListEntity.OrderInfo)paramViewGroup.getOrderInfo().get(i), paramInt);
        if (i == 0) {
          localView.setPadding(0, 0, 0, 0);
        }
        this.c.ll_content.addView(localView);
        i += 1;
      }
      this.c.tv_name.setVisibility(8);
      this.c.siv_icon.setVisibility(8);
    }
    this.c.tv_title.setText(paramViewGroup.getOrderName());
    this.c.tv_btn.setText(paramViewGroup.getButStr());
    this.c.tv_btn.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        int i;
        if ("XQ".equals(paramViewGroup.getEvaluateType())) {
          i = 0;
        }
        for (;;)
        {
          if (i == -1)
          {
            return;
            if ("YK".equals(paramViewGroup.getEvaluateType()))
            {
              if ("6".equals(paramViewGroup.getOrderState()))
              {
                i = 3;
                continue;
              }
              i = 1;
            }
          }
          else
          {
            paramAnonymousView = new Intent(MyRentEvaluateAdapter.a(MyRentEvaluateAdapter.this), EvaluateSignActivity.class);
            paramAnonymousView.putExtra("sceneCode", i);
            paramAnonymousView.putExtra("orderCode", paramViewGroup.getOrderCode());
            paramAnonymousView.setFlags(268435456);
            MyRentEvaluateAdapter.a(MyRentEvaluateAdapter.this).startActivity(paramAnonymousView);
            return;
          }
          i = -1;
        }
      }
    });
    return paramView;
  }
  
  public List<MyRentEvaluateListEntity> getmList()
  {
    return this.a;
  }
  
  public void setmList(List<MyRentEvaluateListEntity> paramList)
  {
    if (paramList == null)
    {
      this.a = new ArrayList();
      return;
    }
    this.a = paramList;
  }
  
  class viewHolder
  {
    @BindView(2131691838)
    LinearLayout ll_content;
    @BindView(2131691839)
    SimpleDraweeView siv_icon;
    @BindView(2131691840)
    TextView tv_btn;
    @BindView(2131690049)
    TextView tv_name;
    @BindView(2131689541)
    TextView tv_title;
    
    viewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/MyRentEvaluateAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */