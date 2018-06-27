package com.ziroom.ziroomcustomer.account.swipemenulistview;

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
  private a c;
  private a d;
  private int e;
  
  public SwipeMenuView(a parama, SwipeMenuListView paramSwipeMenuListView)
  {
    super(parama.getContext());
    this.a = paramSwipeMenuListView;
    this.c = parama;
    parama = parama.getMenuItems().iterator();
    int i = 0;
    while (parama.hasNext())
    {
      a((d)parama.next(), i);
      i += 1;
    }
  }
  
  private ImageView a(d paramd)
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageDrawable(paramd.getIcon());
    return localImageView;
  }
  
  private void a(d paramd, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramd.getWidth(), -1);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setId(paramInt);
    localLinearLayout.setGravity(17);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setBackgroundDrawable(paramd.getBackground());
    localLinearLayout.setOnClickListener(this);
    addView(localLinearLayout);
    if (paramd.getIcon() != null) {
      localLinearLayout.addView(a(paramd));
    }
    if (!TextUtils.isEmpty(paramd.getTitle())) {
      localLinearLayout.addView(b(paramd));
    }
  }
  
  private TextView b(d paramd)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(paramd.getTitle());
    localTextView.setGravity(17);
    localTextView.setTextSize(paramd.getTitleSize());
    localTextView.setTextColor(paramd.getTitleColor());
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
    public abstract void onItemClick(SwipeMenuView paramSwipeMenuView, a parama, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/swipemenulistview/SwipeMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */