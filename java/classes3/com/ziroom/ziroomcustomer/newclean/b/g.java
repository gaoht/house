package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.d.p;
import com.ziroom.ziroomcustomer.util.n;
import java.util.List;

public class g
  extends RecyclerView.a<a>
{
  List<p> a;
  private Context b;
  
  public g(Context paramContext, List<p> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
  }
  
  public int getItemCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public void onBindViewHolder(a parama, int paramInt)
  {
    parama.b.setPadding(0, 0, n.dip2px(this.b, 24.0F), 0);
    Object localObject = parama.a.getLayoutParams();
    float f1 = j.getDisplayWidth(this.b) * 262.0F / 375.0F;
    float f2 = 295.0F * f1 / 257.0F;
    ((ViewGroup.LayoutParams)localObject).width = ((int)f1);
    parama.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    f1 = (f1 - n.dip2px(this.b, 52.0F) - n.dip2px(this.b, 12.0F)) / 3.0F;
    localObject = parama.h.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ((int)f1);
    ((ViewGroup.LayoutParams)localObject).height = ((int)f1);
    parama.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = parama.i.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ((int)f1);
    ((ViewGroup.LayoutParams)localObject).height = ((int)f1);
    parama.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = parama.j.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ((int)f1);
    ((ViewGroup.LayoutParams)localObject).height = ((int)f1);
    parama.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (p)this.a.get(paramInt);
    parama.g.setText(((p)localObject).getServiceName());
    parama.c.setText(((p)localObject).getEvaluateContent());
    parama.e.setText(((p)localObject).getNickName());
    parama.f.setText(((p)localObject).getProTitle());
    if (parama.d.getTag() == null)
    {
      parama.d.setTag(((p)localObject).getHeadPic());
      parama.d.setController(c.frescoController(((p)localObject).getHeadPic()));
    }
    for (;;)
    {
      if ((((p)localObject).getEvaluatePics() != null) && (((p)localObject).getEvaluatePics().size() > 0) && (((p)localObject).getEvaluatePics().size() > 2))
      {
        parama.h.setController(c.frescoController((String)((p)localObject).getEvaluatePics().get(0)));
        parama.i.setController(c.frescoController((String)((p)localObject).getEvaluatePics().get(1)));
        parama.j.setController(c.frescoController((String)((p)localObject).getEvaluatePics().get(2)));
        parama.h.setVisibility(0);
        parama.i.setVisibility(0);
        parama.j.setVisibility(0);
      }
      return;
      if ((!TextUtils.isEmpty(((p)localObject).getHeadPic())) && (!((p)localObject).getHeadPic().equals(parama.d.getTag())))
      {
        parama.d.setTag(((p)localObject).getHeadPic());
        parama.d.setController(c.frescoController(((p)localObject).getHeadPic()));
      }
    }
  }
  
  public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.b).inflate(2130904510, paramViewGroup, false));
  }
  
  class a
    extends RecyclerView.u
  {
    LinearLayout a;
    LinearLayout b;
    TextView c;
    SimpleDraweeView d;
    TextView e;
    TextView f;
    TextView g;
    SimpleDraweeView h;
    SimpleDraweeView i;
    SimpleDraweeView j;
    
    public a(View paramView)
    {
      super();
      this.a = ((LinearLayout)paramView.findViewById(2131695650));
      this.b = ((LinearLayout)paramView.findViewById(2131690425));
      this.c = ((TextView)paramView.findViewById(2131695655));
      this.d = ((SimpleDraweeView)paramView.findViewById(2131695651));
      this.e = ((TextView)paramView.findViewById(2131695652));
      this.f = ((TextView)paramView.findViewById(2131695653));
      this.g = ((TextView)paramView.findViewById(2131695654));
      this.h = ((SimpleDraweeView)paramView.findViewById(2131695656));
      this.i = ((SimpleDraweeView)paramView.findViewById(2131695657));
      this.j = ((SimpleDraweeView)paramView.findViewById(2131695658));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */