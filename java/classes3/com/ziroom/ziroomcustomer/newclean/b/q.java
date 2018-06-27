package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.d.v;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import java.util.List;

public class q
  extends BaseAdapter
{
  private Context a;
  private List<v> b;
  
  public q(Context paramContext, List<v> paramList)
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
    v localv;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904191, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131690047));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690371));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690388));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131690054));
      paramViewGroup.e = ((ImageView)paramView.findViewById(2131690055));
      paramViewGroup.f = ((ImageView)paramView.findViewById(2131690056));
      paramViewGroup.g = ((ImageView)paramView.findViewById(2131690057));
      paramViewGroup.h = ((ImageView)paramView.findViewById(2131690058));
      paramViewGroup.i = ((FlowLayout)paramView.findViewById(2131690332));
      paramViewGroup.j = ((TextView)paramView.findViewById(2131694977));
      paramViewGroup.k = paramView.findViewById(2131690279);
      paramViewGroup.l = ((TextView)paramView.findViewById(2131694976));
      paramView.setTag(paramViewGroup);
      localv = (v)this.b.get(paramInt);
      if (!TextUtils.isEmpty(localv.getUserHeadPic())) {
        paramViewGroup.a.setController(c.frescoController(localv.getUserHeadPic()));
      }
      if (!TextUtils.isEmpty(localv.getUserName())) {
        break label340;
      }
      paramViewGroup.b.setText("匿名用户");
      label243:
      paramViewGroup.l.setText(localv.getProductName());
      paramViewGroup.c.setText(i.getMin2Data(localv.getEvaluateTime()));
      j.getStar(localv.getEvaluateScode(), paramViewGroup.d, paramViewGroup.e, paramViewGroup.f, paramViewGroup.g, paramViewGroup.h);
      if (!TextUtils.isEmpty(localv.getEvaluateContent())) {
        break label355;
      }
      paramViewGroup.j.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.i.setVisibility(8);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label340:
      paramViewGroup.b.setText(localv.getUserName());
      break label243;
      label355:
      paramViewGroup.j.setVisibility(0);
      paramViewGroup.j.setText(localv.getEvaluateContent());
    }
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public FlowLayout i;
    public TextView j;
    public View k;
    public TextView l;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */