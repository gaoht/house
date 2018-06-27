package com.ziroom.ziroomcustomer.newrepair.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.model.RepairScore;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.List;

public class n
  extends BaseAdapter
{
  private Context a;
  private List<RepairScore> b;
  private boolean c = false;
  
  public n(Context paramContext, List<RepairScore> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "1分，非常不满意";
    case 2: 
      return "2分，不满意";
    case 3: 
      return "3分，一般";
    case 4: 
      return "4分，满意";
    }
    return "5分，非常满意";
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
  
  public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904478, null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131695219));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690073));
      paramViewGroup.c = ((RatingBar)paramView.findViewById(2131693259));
      paramView.setTag(paramViewGroup);
    }
    final RepairScore localRepairScore;
    for (;;)
    {
      localRepairScore = (RepairScore)this.b.get(paramInt);
      paramViewGroup.a.setText(localRepairScore.getITEM());
      if (!this.c) {
        break;
      }
      paramViewGroup.c.setEnabled(false);
      if (ae.notNull(localRepairScore.getVALUE()))
      {
        paramViewGroup.c.setRating(Float.valueOf(localRepairScore.getVALUE()).floatValue());
        paramViewGroup.b.setText(a(Integer.valueOf(localRepairScore.getVALUE()).intValue()));
      }
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.c.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
    {
      @Instrumented
      public void onRatingChanged(RatingBar paramAnonymousRatingBar, float paramAnonymousFloat, boolean paramAnonymousBoolean)
      {
        VdsAgent.onRatingChanged(this, paramAnonymousRatingBar, paramAnonymousFloat, paramAnonymousBoolean);
        int i = (int)paramAnonymousFloat;
        localRepairScore.setVALUE(i + "");
        paramViewGroup.b.setText(n.a(n.this, i));
      }
    });
    return paramView;
  }
  
  public void setOnlyRead()
  {
    this.c = true;
  }
  
  private class a
  {
    TextView a;
    TextView b;
    RatingBar c;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */