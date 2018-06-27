package com.ziroom.ziroomcustomer.newrepair.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newclean.d.ax.a;
import com.ziroom.ziroomcustomer.newrepair.activity.InternalRepairFaultDescActivity;
import java.util.List;

public class e
  extends BaseAdapter
{
  private Context a;
  private List<ax.a> b;
  private float c;
  private boolean d = false;
  
  public e(Context paramContext, List<ax.a> paramList, float paramFloat, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramFloat;
    this.d = paramBoolean;
  }
  
  public int getCount()
  {
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
    final Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904258, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694449));
      paramView.setTag(paramViewGroup);
      localObject = paramViewGroup.a.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ((int)this.c);
      ((ViewGroup.LayoutParams)localObject).height = ((int)this.c);
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (ax.a)this.b.get(paramInt);
      paramViewGroup.b.setText(((ax.a)localObject).getGoodsName());
      if (paramViewGroup.a.getTag() != null) {
        break label188;
      }
      paramViewGroup.a.setTag(((ax.a)localObject).getGoodsPic());
      paramViewGroup.a.setController(c.frescoController(((ax.a)localObject).getGoodsPic()));
    }
    for (;;)
    {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(e.a(e.this), InternalRepairFaultDescActivity.class);
          paramAnonymousView.putExtra("internal_repair_fault_name", localObject.getGoodsName());
          paramAnonymousView.putExtra("internal_repair_fault_code", localObject.getGoodsCode());
          paramAnonymousView.putExtra("isMyFragment", e.b(e.this));
          e.a(e.this).startActivity(paramAnonymousView);
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label188:
      if (!((ax.a)localObject).getGoodsPic().equals(paramViewGroup.a.getTag()))
      {
        paramViewGroup.a.setTag(((ax.a)localObject).getGoodsPic());
        paramViewGroup.a.setController(c.frescoController(((ax.a)localObject).getGoodsPic()));
      }
    }
  }
  
  public void setData(List<ax.a> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public TextView b;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */