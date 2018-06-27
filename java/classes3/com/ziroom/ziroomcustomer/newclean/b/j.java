package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newServiceList.model.w;
import java.util.List;

public class j
  extends BaseAdapter
{
  private Context a;
  private List<w> b;
  private a c;
  
  public j(Context paramContext, List<w> paramList)
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
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904161, paramViewGroup, false);
      paramViewGroup = new b();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131692733));
      paramView.setTag(paramViewGroup);
      w localw = (w)this.b.get(paramInt);
      paramViewGroup.a.setText(localw.getTypeName());
      if (!localw.isSelect()) {
        break label129;
      }
      paramViewGroup.a.setTextColor(40960);
      paramViewGroup.a.setBackgroundResource(2130838087);
    }
    for (;;)
    {
      paramViewGroup.a.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = (w)j.a(j.this).get(paramInt);
          if (paramAnonymousView.isSelect()) {
            paramAnonymousView.setSelect(false);
          }
          for (;;)
          {
            if (j.b(j.this) != null) {
              j.b(j.this).tagList(j.a(j.this));
            }
            j.this.notifyDataSetChanged();
            return;
            paramAnonymousView.setSelect(true);
          }
        }
      });
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label129:
      paramViewGroup.a.setTextColor(-6710887);
      paramViewGroup.a.setBackgroundResource(2130838086);
    }
  }
  
  public void setCleanEvalTagListListener(a parama)
  {
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract void tagList(List<w> paramList);
  }
  
  public class b
  {
    public TextView a;
    
    public b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */