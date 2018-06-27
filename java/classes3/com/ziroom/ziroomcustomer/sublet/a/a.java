package com.ziroom.ziroomcustomer.sublet.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.sublet.model.SubletProgressStepModel;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private float b;
  private int c = 999;
  private List<SubletProgressStepModel> d;
  
  public a(Context paramContext, List<SubletProgressStepModel> paramList)
  {
    this.a = paramContext;
    this.d = paramList;
    this.b = this.a.getResources().getDisplayMetrics().density;
  }
  
  public int getCount()
  {
    if (this.d != null) {
      return this.d.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = LayoutInflater.from(this.a).inflate(2130904601, null, false);
    paramViewGroup = paramView.findViewById(2131695858);
    View localView1 = paramView.findViewById(2131695859);
    View localView2 = paramView.findViewById(2131695861);
    View localView3 = paramView.findViewById(2131695862);
    View localView4 = paramView.findViewById(2131695860);
    TextView localTextView1 = (TextView)paramView.findViewById(2131690073);
    TextView localTextView2 = (TextView)paramView.findViewById(2131695068);
    SubletProgressStepModel localSubletProgressStepModel = (SubletProgressStepModel)this.d.get(paramInt);
    if (localSubletProgressStepModel != null)
    {
      localTextView1.setText("[" + localSubletProgressStepModel.title + "]" + localSubletProgressStepModel.desc);
      if (1 != localSubletProgressStepModel.status) {
        break label271;
      }
      this.c = paramInt;
      localView4.setBackgroundResource(2130839610);
      localTextView1.setTextColor(this.a.getResources().getColor(2131624597));
      if (paramInt != this.d.size() - 1) {
        break label335;
      }
      localView2.setVisibility(8);
      localView3.setVisibility(8);
      label204:
      if (paramInt <= this.c) {
        break label375;
      }
      paramViewGroup.setVisibility(8);
      localView1.setVisibility(0);
    }
    for (;;)
    {
      if (!ae.isNull(localSubletProgressStepModel.buttonText))
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(localSubletProgressStepModel.buttonText);
        if (localSubletProgressStepModel.listener != null)
        {
          localTextView2.setOnClickListener(localSubletProgressStepModel.listener);
          return paramView;
          label271:
          localView4.setBackgroundResource(2130839609);
          if (localSubletProgressStepModel.status == 0)
          {
            localTextView1.setTextColor(this.a.getResources().getColor(2131624599));
            break;
          }
          if (2 != localSubletProgressStepModel.status) {
            break;
          }
          localTextView1.setTextColor(this.a.getResources().getColor(2131624601));
          break;
          label335:
          if (paramInt >= this.c)
          {
            localView2.setVisibility(8);
            localView3.setVisibility(0);
            break label204;
          }
          localView2.setVisibility(0);
          localView3.setVisibility(8);
          break label204;
          label375:
          paramViewGroup.setVisibility(0);
          localView1.setVisibility(8);
          continue;
        }
        localTextView2.setOnClickListener(null);
        return paramView;
      }
    }
    localTextView2.setVisibility(8);
    return paramView;
  }
  
  public void setDatas(List<SubletProgressStepModel> paramList)
  {
    this.d = paramList;
    notifyDataSetChanged();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */