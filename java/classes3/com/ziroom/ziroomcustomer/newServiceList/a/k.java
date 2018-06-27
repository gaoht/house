package com.ziroom.ziroomcustomer.newServiceList.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newServiceList.model.az;
import java.util.List;

public class k
  extends BaseAdapter
{
  private List<az> a;
  private Context b;
  private b c;
  
  public k(Context paramContext, List<az> paramList)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
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
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904495, null);
      paramViewGroup = new a();
      paramViewGroup.a = paramView.findViewById(2131695603);
      paramViewGroup.b = paramView.findViewById(2131695605);
      paramViewGroup.c = ((TextView)paramView.findViewById(2131689994));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131689956));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131695604));
      paramView.setTag(paramViewGroup);
      if (paramInt != 0) {
        break label186;
      }
      paramViewGroup.a.setVisibility(0);
    }
    for (;;)
    {
      az localaz = (az)this.a.get(paramInt);
      paramViewGroup.c.setText(localaz.getPromoPrice() + "");
      paramViewGroup.e.setText(localaz.getPromoName());
      paramViewGroup.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (k.a(k.this) != null) {
            k.a(k.this).commit(paramInt);
          }
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label186:
      paramViewGroup.a.setVisibility(8);
    }
  }
  
  public void setOnCommitListener(b paramb)
  {
    this.c = paramb;
  }
  
  public class a
  {
    public View a;
    public View b;
    public TextView c;
    public TextView d;
    public TextView e;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void commit(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */