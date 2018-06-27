package com.ziroom.ziroomcustomer.newchat.chatcenter.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.h;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.l;
import com.ziroom.ziroomcustomer.util.n;
import java.util.List;

public class ChartAndHelpFristPaperGroup
  extends LinearLayout
  implements View.OnClickListener
{
  private LinearLayout a;
  private LinearLayout b;
  private TextView c;
  private SimpleDraweeView d;
  private Boolean e = Boolean.valueOf(false);
  private a f;
  private l g;
  
  public ChartAndHelpFristPaperGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public ChartAndHelpFristPaperGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    if (this.g == null) {
      return;
    }
    this.c.setText(this.g.getContent());
    GenericDraweeHierarchy localGenericDraweeHierarchy = new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(300).setPlaceholderImage(2130838822).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFailureImage(2130838822).setFailureImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build();
    RoundingParams localRoundingParams = new RoundingParams();
    localRoundingParams.setRoundAsCircle(true);
    localRoundingParams.setBorder(Color.parseColor("#99FFFFFF"), n.dip2px(getContext(), 2.0F));
    localGenericDraweeHierarchy.setRoundingParams(localRoundingParams);
    this.d.setHierarchy(localGenericDraweeHierarchy);
    this.d.setController(c.frescoController(this.g.getImageUrl()));
    b();
  }
  
  private void b()
  {
    if ((this.g == null) || (this.g.getLore() == null)) {}
    for (;;)
    {
      return;
      List localList = this.g.getLore();
      this.b.removeAllViews();
      int i = 0;
      while (i < localList.size())
      {
        Object localObject = (h)localList.get(i);
        TextView localTextView = new TextView(getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, sp2px(40.0F));
        localLayoutParams.setMargins(sp2px(5.0F), 0, 0, 0);
        localTextView.setBackgroundResource(2130838288);
        localTextView.setGravity(16);
        localTextView.setLayoutParams(localLayoutParams);
        localTextView.setText(((h)localObject).getQuestion());
        localTextView.setTag(localObject);
        localTextView.setMaxLines(1);
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localTextView.setTextColor(Color.parseColor("#444444"));
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (ChartAndHelpFristPaperGroup.a(ChartAndHelpFristPaperGroup.this) != null) {
              ChartAndHelpFristPaperGroup.a(ChartAndHelpFristPaperGroup.this).onClick(paramAnonymousView);
            }
          }
        });
        localObject = getResources().getDrawable(2130840133);
        ((Drawable)localObject).setBounds(0, 0, sp2px(24.0F), sp2px(24.0F));
        localTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
        localTextView.setTextSize(14.0F);
        this.b.addView(localTextView);
        if (i > 1) {
          localTextView.setVisibility(8);
        }
        i += 1;
      }
    }
  }
  
  public l getmQuestionTypeBeans()
  {
    return this.g;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    int i = 3;
    VdsAgent.onClick(this, paramView);
    if ((this.g == null) || (this.g.getLore() == null) || (this.g.getLore().size() < 3)) {
      return;
    }
    this.g.getLore();
    int j = i;
    if (this.e.booleanValue()) {
      while (i < this.b.getChildCount())
      {
        this.b.getChildAt(i).setVisibility(8);
        i += 1;
      }
    }
    while (j < this.b.getChildCount())
    {
      this.b.getChildAt(j).setVisibility(0);
      j += 1;
    }
    getParent().requestLayout();
    if (!this.e.booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      this.e = Boolean.valueOf(bool);
      return;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((LinearLayout)findViewById(2131697705));
    this.b = ((LinearLayout)findViewById(2131697706));
    this.c = ((TextView)findViewById(2131690049));
    this.d = ((SimpleDraweeView)findViewById(2131690097));
    this.a.setOnClickListener(this);
    a();
  }
  
  public void setOnViewClick(a parama)
  {
    this.f = parama;
  }
  
  public void setmQuestionTypeBeans(l paraml)
  {
    this.g = paraml;
    a();
  }
  
  public int sp2px(float paramFloat)
  {
    return (int)(getContext().getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  public static abstract interface a
  {
    @Instrumented
    public abstract void onClick(View paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/views/ChartAndHelpFristPaperGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */