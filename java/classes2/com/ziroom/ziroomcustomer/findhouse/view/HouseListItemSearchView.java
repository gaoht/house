package com.ziroom.ziroomcustomer.findhouse.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.MyGridView;
import java.util.ArrayList;
import java.util.List;

public class HouseListItemSearchView
  extends LinearLayout
  implements View.OnClickListener
{
  private Context a;
  private List<SelectBean> b = new ArrayList();
  private String c = "您想住哪儿";
  private MyGridView d;
  private a e;
  private TextView f;
  private TextView g;
  private b h;
  
  public HouseListItemSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    setOnClickListener(null);
  }
  
  private TextView a(SelectBean paramSelectBean)
  {
    TextView localTextView = new TextView(this.a);
    localTextView.setText(paramSelectBean.getTitle());
    localTextView.setTag(paramSelectBean);
    localTextView.setPadding(a(6.0F), a(6.0F), a(6.0F), a(6.0F));
    localTextView.setTextSize(2, 12.0F);
    localTextView.setTextColor(this.a.getResources().getColor(2131624417));
    localTextView.setGravity(17);
    localTextView.setBackgroundResource(2130839619);
    localTextView.setOnClickListener(this);
    return localTextView;
  }
  
  private void a()
  {
    this.e.notifyDataSetChanged();
  }
  
  private void b()
  {
    this.f = new TextView(this.a);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = a(12.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = a(9.0F);
    ((LinearLayout.LayoutParams)localObject).bottomMargin = a(5.0F);
    ((LinearLayout.LayoutParams)localObject).gravity = 1;
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.f.setTextSize(2, 13.0F);
    this.f.setTextColor(this.a.getResources().getColor(2131624417));
    this.f.setGravity(17);
    this.f.setText(this.c);
    localObject = getResources().getDrawable(2130839589);
    ((Drawable)localObject).setBounds(0, 0, a(8.0F), a(1.0F));
    this.f.setCompoundDrawables((Drawable)localObject, null, (Drawable)localObject, null);
    this.f.setCompoundDrawablePadding(a(6.0F));
    addView(this.f);
  }
  
  private void c()
  {
    this.g = new TextView(this.a);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = a(18.0F);
    localLayoutParams.topMargin = a(8.0F);
    localLayoutParams.bottomMargin = a(5.0F);
    this.g.setLayoutParams(localLayoutParams);
    this.g.setTextSize(2, 12.0F);
    this.g.setTextColor(this.a.getResources().getColor(2131624417));
    this.g.setBackgroundColor(this.a.getResources().getColor(2131624583));
    this.g.setGravity(17);
    this.g.setText("备注：点击后展开“位置”筛选面板");
    this.g.setVisibility(8);
    addView(this.g);
  }
  
  protected int a(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.h != null) {
      this.h.onLabelClick((SelectBean)paramView.getTag());
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    b();
    c();
    this.d = new MyGridView(this.a);
    int i = ah.dip2px(this.a, 6.0F);
    this.d.setPadding(i, 0, i, 0);
    this.d.setNumColumns(4);
    this.d.setHorizontalSpacing(ah.dip2px(this.a, 6.0F));
    this.d.setVerticalSpacing(ah.dip2px(this.a, 8.0F));
    this.e = new a();
    this.d.setAdapter(this.e);
    addView(this.d);
  }
  
  public void setLabelClickListener(b paramb)
  {
    this.h = paramb;
  }
  
  public void setmLabels(List<SelectBean> paramList)
  {
    this.b = paramList;
    a();
  }
  
  public void setmSearchTitle(String paramString)
  {
    this.c = paramString;
    this.f.setText(this.c);
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public int getCount()
    {
      if (HouseListItemSearchView.a(HouseListItemSearchView.this) == null) {
        return 0;
      }
      return HouseListItemSearchView.a(HouseListItemSearchView.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return HouseListItemSearchView.a(HouseListItemSearchView.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = (SelectBean)HouseListItemSearchView.a(HouseListItemSearchView.this).get(paramInt);
      return HouseListItemSearchView.a(HouseListItemSearchView.this, paramView);
    }
  }
  
  public static abstract interface b
  {
    public abstract void onLabelClick(SelectBean paramSelectBean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/HouseListItemSearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */