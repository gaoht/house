package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveChargeInfo;
import java.util.List;

public class x
  extends BaseAdapter
{
  private List<MoveChargeInfo> a;
  private Context b;
  private b c;
  
  public x(Context paramContext, List<MoveChargeInfo> paramList)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label114:
    MoveChargeInfo localMoveChargeInfo;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904432, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689846));
      paramViewGroup.c = paramView.findViewById(2131690279);
      paramViewGroup.d = ((RelativeLayout)paramView.findViewById(2131689760));
      paramViewGroup.e = ((ImageView)paramView.findViewById(2131690724));
      paramView.setTag(paramViewGroup);
      if (paramInt != this.a.size() - 1) {
        break label198;
      }
      paramViewGroup.c.setVisibility(0);
      localMoveChargeInfo = (MoveChargeInfo)this.a.get(paramInt);
      if (!localMoveChargeInfo.isCoupon()) {
        break label210;
      }
      paramViewGroup.e.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.a.setText(localMoveChargeInfo.getName());
      paramViewGroup.b.setText(localMoveChargeInfo.getMoney());
      paramViewGroup.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ((((MoveChargeInfo)x.a(x.this).get(paramInt)).isCoupon()) && (x.b(x.this) != null)) {
            x.b(x.this).couponClick(paramInt);
          }
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label198:
      paramViewGroup.c.setVisibility(8);
      break label114;
      label210:
      paramViewGroup.e.setVisibility(8);
    }
  }
  
  public void setOnChargeCouponLinstener(b paramb)
  {
    this.c = paramb;
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    public View c;
    public RelativeLayout d;
    public ImageView e;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void couponClick(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */