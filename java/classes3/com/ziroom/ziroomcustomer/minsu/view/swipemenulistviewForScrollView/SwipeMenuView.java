package com.ziroom.ziroomcustomer.minsu.view.swipemenulistviewForScrollView;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.Iterator;
import java.util.List;

public class SwipeMenuView
  extends LinearLayout
  implements View.OnClickListener
{
  private SwipeMenuListView a;
  private SwipeMenuLayout b;
  private b c;
  private a d;
  private int e;
  
  public SwipeMenuView(b paramb, SwipeMenuListView paramSwipeMenuListView)
  {
    super(paramb.getContext());
    this.a = paramSwipeMenuListView;
    this.c = paramb;
    paramb = paramb.getMenuItems().iterator();
    int i = 0;
    while (paramb.hasNext())
    {
      a((e)paramb.next(), i);
      i += 1;
    }
  }
  
  private ImageView a(e parame)
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageDrawable(parame.getIcon());
    return localImageView;
  }
  
  private void a(e parame, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(parame.getWidth(), -1);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setId(paramInt);
    localLinearLayout.setGravity(17);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setBackgroundDrawable(parame.getBackground());
    localLinearLayout.setOnClickListener(this);
    addView(localLinearLayout);
    if (parame.getIcon() != null) {
      localLinearLayout.addView(a(parame));
    }
    if (!TextUtils.isEmpty(parame.getTitle())) {
      localLinearLayout.addView(b(parame));
    }
  }
  
  private TextView b(e parame)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(parame.getTitle());
    localTextView.setGravity(17);
    localTextView.setTextSize(parame.getTitleSize());
    localTextView.setTextColor(parame.getTitleColor());
    return localTextView;
  }
  
  public a getOnSwipeItemClickListener()
  {
    return this.d;
  }
  
  public int getPosition()
  {
    return this.e;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if ((this.d != null) && (this.b.isOpen())) {
      this.d.onItemClick(this, this.c, paramView.getId());
    }
  }
  
  public void setLayout(SwipeMenuLayout paramSwipeMenuLayout)
  {
    this.b = paramSwipeMenuLayout;
  }
  
  public void setOnSwipeItemClickListener(a parama)
  {
    this.d = parama;
  }
  
  public void setPosition(int paramInt)
  {
    this.e = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void onItemClick(SwipeMenuView paramSwipeMenuView, b paramb, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/swipemenulistviewForScrollView/SwipeMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */