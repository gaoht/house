package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.f;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.ziroomstation.PhotoPreviewActivity;
import com.ziroom.ziroomcustomer.ziroomstation.a.b;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationDescription;
import com.ziroom.ziroomcustomer.ziroomstation.widget.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class i
  extends BaseAdapter
{
  private static int f;
  private List<StationDescription> a;
  private Context b;
  private LayoutInflater c;
  private boolean d = false;
  private boolean e = false;
  private int g;
  private int h;
  private b i = new b()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      if (paramAnonymousView.getTag() == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int j = 0;
      if (i < ((FlowLayout)paramAnonymousView.getParent()).getChildCount())
      {
        ImageView localImageView = (ImageView)((FlowLayout)paramAnonymousView.getParent()).getChildAt(i);
        Object localObject = localImageView.getTag();
        if (!(localObject instanceof String)) {
          break label169;
        }
        localArrayList.add((String)localObject);
        if (!((String)paramAnonymousView.getTag()).equals(localImageView.getTag())) {
          break label169;
        }
        j = i;
      }
      label169:
      for (;;)
      {
        i += 1;
        break;
        paramAnonymousView = new Intent(i.b(i.this), PhotoPreviewActivity.class);
        paramAnonymousView.putStringArrayListExtra("photoDescription", localArrayList);
        paramAnonymousView.putExtra("position", j);
        paramAnonymousView.putExtra("isDeleteable", false);
        ((Activity)i.b(i.this)).startActivityForResult(paramAnonymousView, 257);
        return;
      }
    }
  };
  private a j;
  
  public i(Context paramContext, List<StationDescription> paramList, boolean paramBoolean)
  {
    this.b = paramContext;
    this.a = paramList;
    this.e = paramBoolean;
    a(paramList);
    f = (int)TypedValue.applyDimension(1, 12.0F, paramContext.getResources().getDisplayMetrics());
    int k = paramContext.getResources().getDimensionPixelSize(2131231240);
    this.g = ((paramContext.getResources().getDisplayMetrics().widthPixels - k * 2 - f * 3) / 4);
    this.h = (this.g * 2 / 3);
    this.c = LayoutInflater.from(paramContext);
  }
  
  private List<ImageView> a(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add((ImageView)paramView.findViewById(2131694998));
    localArrayList.add((ImageView)paramView.findViewById(2131694999));
    localArrayList.add((ImageView)paramView.findViewById(2131695000));
    localArrayList.add((ImageView)paramView.findViewById(2131695001));
    localArrayList.add((ImageView)paramView.findViewById(2131695002));
    return localArrayList;
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    paramTextView.setText("");
    if (!com.ziroom.ziroomcustomer.ziroomstation.utils.i.isLegal(((StationDescription)this.a.get(paramInt)).room_types)) {
      return;
    }
    String str1 = "";
    int k = 0;
    if (k < ((StationDescription)this.a.get(paramInt)).room_types.size())
    {
      String str2 = (String)((StationDescription)this.a.get(paramInt)).room_types.get(k);
      StringBuilder localStringBuilder = new StringBuilder().append(str1);
      if (com.ziroom.ziroomcustomer.ziroomstation.utils.i.TextisEmpty(str2)) {}
      for (str1 = "";; str1 = str2 + " ")
      {
        str1 = str1;
        k += 1;
        break;
      }
    }
    paramTextView.setText(str1);
  }
  
  private void a(FlowLayout paramFlowLayout, int paramInt)
  {
    paramFlowLayout.removeAllViews();
    if ((!com.ziroom.ziroomcustomer.ziroomstation.utils.i.isLegal(this.a)) || (!com.ziroom.ziroomcustomer.ziroomstation.utils.i.isLegal(((StationDescription)this.a.get(paramInt)).imgUrls))) {
      return;
    }
    int k = 0;
    label39:
    SimpleDraweeView localSimpleDraweeView;
    String str;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    if (k < ((StationDescription)this.a.get(paramInt)).imgUrls.size())
    {
      localSimpleDraweeView = new SimpleDraweeView(this.b);
      str = (String)((StationDescription)this.a.get(paramInt)).imgUrls.get(k);
      localSimpleDraweeView.setTag(str);
      ((GenericDraweeHierarchy)localSimpleDraweeView.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
      ((GenericDraweeHierarchy)localSimpleDraweeView.getHierarchy()).setPlaceholderImage(2130837592, ScalingUtils.ScaleType.CENTER_INSIDE);
      localSimpleDraweeView.setOnClickListener(this.i);
      localMarginLayoutParams = new ViewGroup.MarginLayoutParams(this.g, this.h);
      if (paramFlowLayout.getChildCount() % 4 != 0) {
        break label219;
      }
    }
    label219:
    for (localMarginLayoutParams.leftMargin = 0;; localMarginLayoutParams.leftMargin = f)
    {
      localMarginLayoutParams.topMargin = f;
      paramFlowLayout.addView(localSimpleDraweeView, localMarginLayoutParams);
      paramFlowLayout.requestLayout();
      localSimpleDraweeView.setController(c.frescoController(str));
      k += 1;
      break label39;
      break;
    }
  }
  
  private void a(FlowLayout paramFlowLayout, List<String> paramList)
  {
    paramFlowLayout.removeAllViews();
    if (!com.ziroom.ziroomcustomer.ziroomstation.utils.i.isLegal(paramList)) {
      return;
    }
    int k = 0;
    while (k < paramList.size())
    {
      TextView localTextView = new TextView(this.b);
      localTextView.setText((CharSequence)paramList.get(k));
      localTextView.setGravity(16);
      localTextView.setTextAppearance(this.b, 2131427972);
      int m = n.dip2px(this.b, 5.0F);
      localTextView.setPadding(m, 0, m, 0);
      localTextView.setBackgroundResource(2130839576);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, n.dip2px(this.b, 18.0F));
      m = n.dip2px(this.b, 6.0F);
      localMarginLayoutParams.setMargins(0, m * 2, m, 0);
      localTextView.setLayoutParams(localMarginLayoutParams);
      paramFlowLayout.addView(localTextView);
      k += 1;
    }
    paramFlowLayout.requestLayout();
  }
  
  private void a(List<StationDescription> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.d = bool;
      return;
    }
  }
  
  private void a(List<ImageView> paramList, int paramInt)
  {
    if ((com.ziroom.ziroomcustomer.ziroomstation.utils.i.isLegal(paramList)) && (paramInt >= 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        ((ImageView)localIterator.next()).setImageResource(2130839775);
      }
      if (paramList.size() >= paramInt)
      {
        int k = 0;
        while (k < paramInt)
        {
          ((ImageView)paramList.get(k)).setImageResource(2130839774);
          k += 1;
        }
      }
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
  
  public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    if (this.d)
    {
      if (paramInt == 0)
      {
        paramView = this.c.inflate(2130905154, paramViewGroup, false);
        paramViewGroup = paramView.findViewById(2131694991);
        if (this.e) {
          break label123;
        }
        paramViewGroup.findViewById(2131694992).setBackground(this.b.getResources().getDrawable(2130839777));
        paramViewGroup.findViewById(2131694993).setBackground(this.b.getResources().getDrawable(2130839778));
      }
      for (;;)
      {
        paramViewGroup.findViewById(2131694992).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (i.a(i.this) != null)
            {
              paramAnonymousView.setBackground(i.b(i.this).getResources().getDrawable(2130839777));
              ((View)paramAnonymousView.getParent()).findViewById(2131694993).setBackground(i.b(i.this).getResources().getDrawable(2130839778));
              i.a(i.this).onAllClick();
              w.onEventToZiroomAndUmeng("zinn_detail_eva");
            }
          }
        });
        paramViewGroup.findViewById(2131694993).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (i.a(i.this) != null)
            {
              paramAnonymousView.setBackground(i.b(i.this).getResources().getDrawable(2130839777));
              ((View)paramAnonymousView.getParent()).findViewById(2131694992).setBackground(i.b(i.this).getResources().getDrawable(2130839778));
              i.a(i.this).onHasImgClick();
              w.onEventToZiroomAndUmeng("zinn_detail_eva_pic");
            }
          }
        });
        return paramView;
        label123:
        paramViewGroup.findViewById(2131694993).setBackground(this.b.getResources().getDrawable(2130839777));
        paramViewGroup.findViewById(2131694992).setBackground(this.b.getResources().getDrawable(2130839778));
      }
    }
    paramView = this.c.inflate(2130904201, paramViewGroup, false);
    paramViewGroup = b.a(paramView);
    paramView.setTag(paramViewGroup);
    if (paramInt == 0)
    {
      paramViewGroup.a.setVisibility(0);
      if (!((StationDescription)this.a.get(paramInt)).hasImg)
      {
        paramViewGroup.a.findViewById(2131694992).setBackground(this.b.getResources().getDrawable(2130839777));
        paramViewGroup.a.findViewById(2131694993).setBackground(this.b.getResources().getDrawable(2130839778));
        paramViewGroup.a.findViewById(2131694992).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (i.a(i.this) != null)
            {
              paramAnonymousView.setBackground(i.b(i.this).getResources().getDrawable(2130839777));
              ((View)paramAnonymousView.getParent()).findViewById(2131694993).setBackground(i.b(i.this).getResources().getDrawable(2130839778));
              i.a(i.this).onAllClick();
              w.onEventToZiroomAndUmeng("zinn_detail_eva");
            }
          }
        });
        paramViewGroup.a.findViewById(2131694993).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (i.a(i.this) != null)
            {
              paramAnonymousView.setBackground(i.b(i.this).getResources().getDrawable(2130839777));
              ((View)paramAnonymousView.getParent()).findViewById(2131694992).setBackground(i.b(i.this).getResources().getDrawable(2130839778));
              i.a(i.this).onHasImgClick();
              w.onEventToZiroomAndUmeng("zinn_detail_eva_pic");
            }
          }
        });
        label320:
        if ((f.isNull(((StationDescription)this.a.get(paramInt)).ext)) || ("\"null\"".equals(((StationDescription)this.a.get(paramInt)).ext)) || (((StationDescription)this.a.get(paramInt)).ext.length() < 2)) {
          break label823;
        }
        paramViewGroup.b.setText(((StationDescription)this.a.get(paramInt)).ext.substring(0, 1) + "******" + ((StationDescription)this.a.get(paramInt)).ext.substring(((StationDescription)this.a.get(paramInt)).ext.length() - 1, ((StationDescription)this.a.get(paramInt)).ext.length()));
        label499:
        if (!com.ziroom.ziroomcustomer.ziroomstation.utils.i.TextisEmpty(((StationDescription)this.a.get(paramInt)).text_date)) {
          paramViewGroup.c.setText(((StationDescription)this.a.get(paramInt)).text_date.replace("-", "/").substring(0, 11));
        }
        a(paramViewGroup.d, paramInt);
        a(paramViewGroup.f, ((StationDescription)this.a.get(paramInt)).tags);
        if (com.ziroom.ziroomcustomer.ziroomstation.utils.i.TextisEmpty(((StationDescription)this.a.get(paramInt)).text_desc)) {
          break label1006;
        }
        paramViewGroup.g.setVisibility(0);
        paramViewGroup.g.setText(((StationDescription)this.a.get(paramInt)).text_desc);
        if (!((StationDescription)this.a.get(paramInt)).isExpanded) {
          break label985;
        }
        paramViewGroup.g.setMaxLines(1000);
        paramViewGroup.i.setText("点击收起");
      }
    }
    for (;;)
    {
      a(a(paramViewGroup.e), ((StationDescription)this.a.get(paramInt)).count_star);
      a(paramViewGroup.h, paramInt);
      paramViewGroup.g.post(new Runnable()
      {
        public void run()
        {
          Layout localLayout = paramViewGroup.g.getLayout();
          if (localLayout != null)
          {
            int i = localLayout.getLineCount();
            if (i > 0)
            {
              if ((i <= 2) && (localLayout.getEllipsisCount(i - 1) <= 0)) {
                break label51;
              }
              paramViewGroup.i.setVisibility(0);
            }
          }
          return;
          label51:
          paramViewGroup.i.setVisibility(8);
        }
      });
      paramViewGroup.i.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = (StationDescription)i.c(i.this).get(paramInt);
          if (!((StationDescription)i.c(i.this).get(paramInt)).isExpanded) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.isExpanded = bool;
            i.this.notifyDataSetChanged();
            return;
          }
        }
      });
      return paramView;
      paramViewGroup.a.findViewById(2131694993).setBackground(this.b.getResources().getDrawable(2130839777));
      paramViewGroup.a.findViewById(2131694992).setBackground(this.b.getResources().getDrawable(2130839778));
      break;
      paramViewGroup.a.setVisibility(8);
      break label320;
      label823:
      if (((StationDescription)this.a.get(paramInt)).orderCode.length() >= 7)
      {
        paramViewGroup.b.setText(((StationDescription)this.a.get(paramInt)).orderCode.substring(0, 3) + "****" + ((StationDescription)this.a.get(paramInt)).orderCode.substring(((StationDescription)this.a.get(paramInt)).orderCode.length() - 4, ((StationDescription)this.a.get(paramInt)).orderCode.length()));
        break label499;
      }
      paramViewGroup.b.setText(((StationDescription)this.a.get(paramInt)).orderCode);
      break label499;
      label985:
      paramViewGroup.g.setMaxLines(2);
      paramViewGroup.i.setText("点击查看更多");
      continue;
      label1006:
      paramViewGroup.g.setVisibility(8);
      paramViewGroup.i.setVisibility(8);
    }
  }
  
  public void setData(List<StationDescription> paramList, boolean paramBoolean)
  {
    this.a = paramList;
    this.e = paramBoolean;
    a(this.a);
    notifyDataSetChanged();
  }
  
  public void setOnHasImgClickListener(a parama)
  {
    this.j = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onAllClick();
    
    public abstract void onHasImgClick();
  }
  
  static class b
  {
    LinearLayout a;
    TextView b;
    TextView c;
    TextView d;
    LinearLayout e;
    FlowLayout f;
    TextView g;
    FlowLayout h;
    TextView i;
    
    public b(LinearLayout paramLinearLayout1, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, LinearLayout paramLinearLayout2, FlowLayout paramFlowLayout1, TextView paramTextView4, FlowLayout paramFlowLayout2, TextView paramTextView5)
    {
      this.a = paramLinearLayout1;
      this.b = paramTextView1;
      this.c = paramTextView2;
      this.d = paramTextView3;
      this.e = paramLinearLayout2;
      this.f = paramFlowLayout1;
      this.g = paramTextView4;
      this.h = paramFlowLayout2;
      this.i = paramTextView5;
    }
    
    private static b b(View paramView)
    {
      return new b((LinearLayout)paramView.findViewById(2131694991), (TextView)paramView.findViewById(2131694994), (TextView)paramView.findViewById(2131694995), (TextView)paramView.findViewById(2131694996), (LinearLayout)paramView.findViewById(2131694997), (FlowLayout)paramView.findViewById(2131695003), (TextView)paramView.findViewById(2131695004), (FlowLayout)paramView.findViewById(2131695006), (TextView)paramView.findViewById(2131695005));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */