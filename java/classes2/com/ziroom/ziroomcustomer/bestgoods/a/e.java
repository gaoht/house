package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.bestgoods.model.h;
import com.ziroom.ziroomcustomer.newrepair.widget.StarBar;
import com.ziroom.ziroomcustomer.util.m;
import java.util.List;

public class e
  extends BaseAdapter
{
  private List<h> a;
  private Context b;
  private LayoutInflater c;
  private boolean d = false;
  
  public e(Context paramContext, List<h> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
    a(paramList);
    this.c = LayoutInflater.from(this.b);
  }
  
  private String a(String paramString1, String paramString2)
  {
    return m.getFormatDate(m.strToDate(paramString1, m.c), paramString2);
  }
  
  private void a(List<h> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.d = bool;
      return;
    }
  }
  
  public int getCount()
  {
    if ((this.a != null) && (this.a.size() > 0)) {
      return this.a.size();
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.d)
    {
      if (paramInt == 0) {
        paramView = this.c.inflate(2130903657, paramViewGroup, false);
      }
      return paramView;
    }
    h localh;
    label219:
    String str;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = this.c.inflate(2130904133, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694859));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.c = ((StarBar)paramView.findViewById(2131690000));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131690073));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131694862));
      paramViewGroup.g = ((LinearLayout)paramView.findViewById(2131694860));
      paramViewGroup.h = ((TextView)paramView.findViewById(2131694861));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131693265));
      paramViewGroup.c.setEnabled(false);
      paramViewGroup.c.setClickable(false);
      paramView.setTag(paramViewGroup);
      localh = (h)this.a.get(paramInt);
      if (TextUtils.isEmpty(localh.getNickName())) {
        break label460;
      }
      paramViewGroup.b.setText(localh.getNickName());
      str = localh.getEvaluateTime();
      if (!TextUtils.isEmpty(str)) {
        break label472;
      }
      str = "";
      label238:
      paramViewGroup.f.setText(str);
      paramViewGroup.c.setStarMark(Math.round(localh.getStar()));
      if (TextUtils.isEmpty(localh.getSkuName())) {
        break label486;
      }
      paramViewGroup.e.setText(localh.getSkuName());
      label287:
      str = localh.getUserImgUrl();
      if (TextUtils.isEmpty(str)) {
        break label498;
      }
      ((GenericDraweeHierarchy)paramViewGroup.a.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
      ((GenericDraweeHierarchy)paramViewGroup.a.getHierarchy()).setPlaceholderImage(2130839897, ScalingUtils.ScaleType.CENTER_INSIDE);
      paramViewGroup.a.setController(c.frescoController(str));
      label348:
      if (TextUtils.isEmpty(localh.getEvaluateContent())) {
        break label512;
      }
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.d.setText(localh.getEvaluateContent());
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localh.getReplyContent()))
      {
        paramViewGroup.g.setVisibility(0);
        if (!TextUtils.isEmpty(localh.getOperatorName()))
        {
          paramViewGroup.h.setText(localh.getOperatorName() + "：" + localh.getReplyContent());
          return paramView;
          paramViewGroup = (a)paramView.getTag();
          break;
          label460:
          paramViewGroup.b.setText("");
          break label219;
          label472:
          str = a(str, m.b);
          break label238;
          label486:
          paramViewGroup.e.setText("");
          break label287;
          label498:
          paramViewGroup.a.setController(c.frescoController(null));
          break label348;
          label512:
          paramViewGroup.d.setVisibility(8);
          continue;
        }
        paramViewGroup.h.setText("客服回复：" + localh.getReplyContent());
        return paramView;
      }
    }
    paramViewGroup.g.setVisibility(8);
    return paramView;
  }
  
  public void setData(List<h> paramList)
  {
    this.a = paramList;
    a(this.a);
    notifyDataSetChanged();
  }
  
  static class a
  {
    SimpleDraweeView a;
    TextView b;
    StarBar c;
    TextView d;
    TextView e;
    TextView f;
    LinearLayout g;
    TextView h;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */