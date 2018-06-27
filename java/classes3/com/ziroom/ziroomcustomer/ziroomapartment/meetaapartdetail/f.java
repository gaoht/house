package com.ziroom.ziroomcustomer.ziroomapartment.meetaapartdetail;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.model.meetaapartmodel.ProjectDetailForAppVo.LabelsVo;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.LinkedList;

public class f
  extends PagerAdapter
{
  private Context a;
  private ArrayList<ProjectDetailForAppVo.LabelsVo> b;
  private LinkedList<View> c;
  
  public f(Context paramContext, ArrayList<ProjectDetailForAppVo.LabelsVo> paramArrayList)
  {
    this.a = paramContext;
    this.b = paramArrayList;
    this.c = new LinkedList();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.c.size() >= paramInt + 1) {
      paramViewGroup.removeView((View)this.c.get(paramInt));
    }
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public ArrayList<ProjectDetailForAppVo.LabelsVo> getData()
  {
    return this.b;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = View.inflate(this.a, 2130905209, null);
    localView.setEnabled(false);
    SimpleDraweeView localSimpleDraweeView1 = (SimpleDraweeView)localView.findViewById(2131697719);
    TextView localTextView1 = (TextView)localView.findViewById(2131697720);
    TextView localTextView2 = (TextView)localView.findViewById(2131697723);
    SimpleDraweeView localSimpleDraweeView2 = (SimpleDraweeView)localView.findViewById(2131697721);
    localSimpleDraweeView1.setController(c.frescoController(((ProjectDetailForAppVo.LabelsVo)this.b.get(paramInt)).bulletImageUrl));
    localSimpleDraweeView2.setController(c.frescoController(((ProjectDetailForAppVo.LabelsVo)this.b.get(paramInt)).bulletLogoUrl));
    localTextView1.setText(((ProjectDetailForAppVo.LabelsVo)this.b.get(paramInt)).bulletMainTitle);
    localTextView2.setText(((ProjectDetailForAppVo.LabelsVo)this.b.get(paramInt)).bulletContent);
    paramViewGroup.addView(localView);
    this.c.add(localView);
    paramViewGroup = (WindowManager)this.a.getSystemService("window");
    paramInt = paramViewGroup.getDefaultDisplay().getWidth() - ah.dip2px(this.a, 120.0F);
    int i = paramViewGroup.getDefaultDisplay().getWidth();
    int j = ah.dip2px(this.a, 95.0F);
    localSimpleDraweeView1.getLayoutParams().height = (paramInt * 3 / 4);
    localView.getLayoutParams().height = (paramInt * 373 / 280);
    localSimpleDraweeView2.getLayoutParams().height = ((i - j) * 60 / 280);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setData(ArrayList<ProjectDetailForAppVo.LabelsVo> paramArrayList)
  {
    this.c = null;
    this.b = paramArrayList;
    this.c = new LinkedList();
    notifyDataSetChanged();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/meetaapartdetail/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */