package com.ziroom.ziroomcustomer.social.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.social.model.o;
import java.util.List;

public class g
  extends BaseAdapter
{
  public int a = -1;
  private Context b;
  private List<o> c;
  private a d;
  
  public g(Context paramContext)
  {
    this.b = paramContext;
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
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904643, null);
      paramViewGroup = new b();
      paramViewGroup.d = ((CheckBox)paramView.findViewById(2131695907));
      paramViewGroup.a = ((TextView)paramView.findViewById(2131689857));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695908));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695909));
      paramView.setTag(paramViewGroup);
      if (this.a != paramInt) {
        break label192;
      }
      paramViewGroup.d.setChecked(true);
    }
    for (;;)
    {
      paramViewGroup.a.setText(((o)this.c.get(paramInt)).getCity_name());
      paramViewGroup.b.setText(((o)this.c.get(paramInt)).getBizcircle_name());
      paramViewGroup.c.setText(((o)this.c.get(paramInt)).getHouse_address());
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (paramInt == paramInt)
          {
            g.this.a = -1;
            g.a(g.this).setSelectType(null);
            g.this.notifyDataSetChanged();
            return;
          }
          g.this.a = paramInt;
          g.a(g.this).setSelectType((o)g.b(g.this).get(paramInt));
          g.this.notifyDataSetChanged();
        }
      });
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label192:
      paramViewGroup.d.setChecked(false);
    }
  }
  
  public List<o> getmList()
  {
    return this.c;
  }
  
  public a getmPayType()
  {
    return this.d;
  }
  
  public void setmList(List<o> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public void setmPayType(a parama)
  {
    this.d = parama;
  }
  
  public static abstract interface a
  {
    public abstract void setSelectType(o paramo);
  }
  
  class b
  {
    TextView a;
    TextView b;
    TextView c;
    CheckBox d;
    
    b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */