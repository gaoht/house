package com.ziroom.credit.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.datacenter.remote.responsebody.financial.b.j;
import java.util.List;

public class c
  extends BaseAdapter
{
  List<j> a;
  private Context b;
  
  public c(Context paramContext, List<j> paramList)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    j localj;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.b).inflate(R.layout.credit_item_thrid_auth, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(R.id.credit_tv_content));
      paramViewGroup.b = ((TextView)paramView.findViewById(R.id.credit_tv_static));
      paramViewGroup.c = ((SimpleDraweeView)paramView.findViewById(R.id.credit_icon));
      paramViewGroup.d = ((ImageView)paramView.findViewById(R.id.credit_img_arraw));
      paramView.setTag(paramViewGroup);
      localj = (j)this.a.get(paramInt);
      GenericDraweeHierarchy localGenericDraweeHierarchy = new GenericDraweeHierarchyBuilder(this.b.getResources()).setFadeDuration(300).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
      paramViewGroup.c.setHierarchy(localGenericDraweeHierarchy);
      paramViewGroup.c.setController(com.freelxl.baselibrary.f.c.frescoController(localj.getIcon()));
      paramViewGroup.a.setText(localj.getType());
      if ((localj.getStatus() != 1) && (localj.getStatus() != 2)) {
        break label269;
      }
      paramViewGroup.d.setVisibility(4);
      label197:
      if (localj.getStatus() != 0) {
        break label280;
      }
      paramViewGroup.b.setText("去关联");
      label214:
      if (localj.getKey() == 0)
      {
        if (localj.getStatus() != 0) {
          break label301;
        }
        paramViewGroup.b.setText("去授权");
      }
    }
    for (;;)
    {
      if (localj.getStatus() != 1) {
        break label355;
      }
      paramViewGroup.d.setVisibility(4);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label269:
      paramViewGroup.d.setVisibility(0);
      break label197;
      label280:
      if (localj.getStatus() != 1) {
        break label214;
      }
      paramViewGroup.b.setText("已关联");
      break label214;
      label301:
      if (localj.getStatus() == 1) {
        paramViewGroup.b.setText("已授权");
      } else if (localj.getStatus() == 2) {
        paramViewGroup.b.setText("暂不支持");
      } else {
        paramViewGroup.b.setText("去授权");
      }
    }
    label355:
    paramViewGroup.d.setVisibility(0);
    return paramView;
  }
  
  public class a
  {
    TextView a;
    TextView b;
    SimpleDraweeView c;
    ImageView d;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */