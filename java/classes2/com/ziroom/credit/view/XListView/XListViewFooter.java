package com.ziroom.credit.view.XListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.R.string;

public class XListViewFooter
  extends LinearLayout
{
  private Context a;
  private View b;
  private View c;
  private TextView d;
  
  public XListViewFooter(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public XListViewFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    paramContext = (LinearLayout)LayoutInflater.from(this.a).inflate(R.layout.credit_xlistview_footer, null);
    addView(paramContext);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    this.b = paramContext.findViewById(R.id.credit_xlistview_footer_content);
    this.c = paramContext.findViewById(R.id.credit_xlistview_footer_progressbar);
    this.d = ((TextView)paramContext.findViewById(R.id.credit_xlistview_footer_hint_textview));
  }
  
  public int getBottomMargin()
  {
    return ((LinearLayout.LayoutParams)this.b.getLayoutParams()).bottomMargin;
  }
  
  public void hide()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.height = 0;
    this.b.setLayoutParams(localLayoutParams);
  }
  
  public void loading()
  {
    this.d.setVisibility(8);
    this.c.setVisibility(0);
  }
  
  public void normal()
  {
    this.d.setVisibility(0);
    this.c.setVisibility(8);
  }
  
  public void setBottomMargin(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.bottomMargin = paramInt;
    this.b.setLayoutParams(localLayoutParams);
  }
  
  public void setState(int paramInt)
  {
    this.d.setVisibility(4);
    this.c.setVisibility(4);
    this.d.setVisibility(4);
    if (paramInt == 1)
    {
      this.d.setVisibility(0);
      this.d.setText(R.string.credit_xlistview_footer_hint_ready);
    }
    while (paramInt != 2) {
      return;
    }
    this.c.setVisibility(0);
  }
  
  public void show()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.height = -2;
    this.b.setLayoutParams(localLayoutParams);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/XListView/XListViewFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */