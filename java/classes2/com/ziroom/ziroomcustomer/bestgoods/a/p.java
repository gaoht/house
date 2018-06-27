package com.ziroom.ziroomcustomer.bestgoods.a;

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
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinModifyAddressActivity;
import com.ziroom.ziroomcustomer.newServiceList.model.AddressMo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import java.util.List;

public class p
  extends BaseAdapter
{
  private Context a;
  private List<AddressMo> b;
  
  public p(Context paramContext, List<AddressMo> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
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
    final AddressMo localAddressMo;
    LabeledEditText localLabeledEditText;
    StringBuilder localStringBuilder;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904404, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((LabeledEditText)paramView.findViewById(2131690053));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131695440));
      paramViewGroup.c = ((RelativeLayout)paramView.findViewById(2131695437));
      paramViewGroup.d = ((RelativeLayout)paramView.findViewById(2131695439));
      paramViewGroup.e = ((RelativeLayout)paramView.findViewById(2131695438));
      paramView.setTag(paramViewGroup);
      localAddressMo = (AddressMo)this.b.get(paramInt);
      localLabeledEditText = paramViewGroup.a;
      localStringBuilder = new StringBuilder().append(localAddressMo.getVillage());
      if (!ae.notNull(localAddressMo.getDetAddress())) {
        break label208;
      }
    }
    label208:
    for (String str = localAddressMo.getDetAddress();; str = "")
    {
      localLabeledEditText.setText(str);
      if (!"2".equals(localAddressMo.getDataSource())) {
        break label215;
      }
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.e.setVisibility(0);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
    }
    label215:
    paramViewGroup.e.setVisibility(8);
    paramViewGroup.d.setVisibility(0);
    paramViewGroup.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(p.a(p.this), YouPinModifyAddressActivity.class);
        paramAnonymousView.putExtra("modify", "modify");
        paramAnonymousView.putExtra("address", localAddressMo);
        ((Activity)p.a(p.this)).startActivityForResult(paramAnonymousView, 2);
      }
    });
    return paramView;
  }
  
  public void setList(List<AddressMo> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */