package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.model.u.a;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import java.util.List;

public class ah
  extends BaseAdapter
{
  private List<aa> a;
  private List<u.a> b;
  private Context c;
  private b d;
  
  public ah(Context paramContext, List<aa> paramList, List<u.a> paramList1)
  {
    this.a = paramList;
    this.b = paramList1;
    this.c = paramContext;
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
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.c, 2130904591, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((MyGridView)paramView.findViewById(2131690745));
      paramViewGroup.b = paramView.findViewById(2131690279);
      paramViewGroup.c = ((TextView)paramView.findViewById(2131693684));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131690739));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131689912));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131695837));
      paramView.setTag(paramViewGroup);
      if (paramViewGroup.a.getTag() != null) {
        break label261;
      }
      paramViewGroup.a.setAdapter((ListAdapter)this.a.get(paramInt));
      paramViewGroup.a.setTag(Integer.valueOf(paramInt));
      label145:
      paramViewGroup.d.setText(((u.a)this.b.get(paramInt)).getGroupTitle());
      paramViewGroup.e.setText(((u.a)this.b.get(paramInt)).getGroupPrice() + "");
      if (paramInt != this.a.size() - 1) {
        break label312;
      }
      paramViewGroup.b.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (ah.a(ah.this) != null) {
            ah.a(ah.this).toGroupPay(paramInt);
          }
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label261:
      if (paramInt == ((Integer)paramViewGroup.a.getTag()).intValue()) {
        break label145;
      }
      paramViewGroup.a.setAdapter((ListAdapter)this.a.get(paramInt));
      paramViewGroup.a.setTag(Integer.valueOf(paramInt));
      break label145;
      label312:
      paramViewGroup.b.setVisibility(8);
    }
  }
  
  public void setOnItemClickListener(b paramb)
  {
    this.d = paramb;
  }
  
  public class a
  {
    public MyGridView a;
    public View b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void toGroupPay(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */