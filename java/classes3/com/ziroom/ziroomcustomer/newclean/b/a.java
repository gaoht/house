package com.ziroom.ziroomcustomer.newclean.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newclean.activity.ModifyNewAddressActivity;
import com.ziroom.ziroomcustomer.newclean.d.c;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<c> b;
  
  public a(Context paramContext, List<c> paramList)
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
      paramView = View.inflate(this.a, 2130904397, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((LabeledEditText)paramView.findViewById(2131690053));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131695440));
      paramViewGroup.c = ((RelativeLayout)paramView.findViewById(2131695437));
      paramViewGroup.d = ((RelativeLayout)paramView.findViewById(2131695439));
      paramViewGroup.e = ((RelativeLayout)paramView.findViewById(2131695438));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      final c localc = (c)this.b.get(paramInt);
      paramViewGroup.a.setText(localc.getLinkPhone(), localc.getVillage() + localc.getDetAddress());
      paramViewGroup.e.setVisibility(8);
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(a.a(a.this), ModifyNewAddressActivity.class);
          paramAnonymousView.putExtra("modify", "bedroom_modify");
          paramAnonymousView.putExtra("addressList", localc);
          paramAnonymousView.putExtra("modify_position", paramInt + "");
          ((Activity)a.a(a.this)).startActivityForResult(paramAnonymousView, 3);
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public class a
  {
    public LabeledEditText a;
    public ImageView b;
    public RelativeLayout c;
    public RelativeLayout d;
    public RelativeLayout e;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */