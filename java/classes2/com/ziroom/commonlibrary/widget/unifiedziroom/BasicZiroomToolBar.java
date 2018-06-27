package com.ziroom.commonlibrary.widget.unifiedziroom;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.freelxl.baselibrary.f.b;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.R.drawable;
import com.ziroom.commonlibrary.R.id;
import java.util.ArrayList;
import java.util.List;

public class BasicZiroomToolBar
  extends RelativeLayout
{
  protected LinearLayout a;
  protected ImageView b;
  private List<View> c;
  private TextView d;
  
  public BasicZiroomToolBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public BasicZiroomToolBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public BasicZiroomToolBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void c()
  {
    this.a = new LinearLayout(getContext());
    this.a.setId(R.id.ll_button_container);
    this.a.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(0, 0, b.dip2px(getContext(), 12.0F), 0);
    this.a.setGravity(15);
    addView(this.a, localLayoutParams);
    this.a.setVisibility(8);
  }
  
  private void d()
  {
    View localView = new View(getContext());
    localView.setBackgroundColor(Color.parseColor("#DDDDDD"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, b.dip2px(getContext(), 0.5F));
    localLayoutParams.addRule(12);
    addView(localView, localLayoutParams);
  }
  
  private void e()
  {
    this.b = new ImageView(getContext());
    this.b.setImageResource(R.drawable.zrk_ic_back);
    this.b.setId(R.id.iv_back);
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ((Activity)BasicZiroomToolBar.this.getContext()).finish();
      }
    });
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(9);
    this.b.setPadding(b.dip2px(getContext(), 12.0F), 0, 0, 0);
    addView(this.b, localLayoutParams);
  }
  
  protected void a()
  {
    this.d = new TextView(getContext());
    this.d.setTextColor(Color.parseColor("#444444"));
    this.d.setTextSize(2, 18.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.d.setMaxLines(1);
    this.d.setVisibility(8);
    addView(this.d, localLayoutParams);
  }
  
  protected void a(AttributeSet paramAttributeSet)
  {
    d();
    e();
    c();
    a();
    setBackgroundColor(-1);
    getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        ViewGroup.LayoutParams localLayoutParams = BasicZiroomToolBar.this.getLayoutParams();
        localLayoutParams.height = b.dip2px(BasicZiroomToolBar.this.getContext(), 56.0F);
        BasicZiroomToolBar.this.setLayoutParams(localLayoutParams);
        BasicZiroomToolBar.this.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
      }
    });
  }
  
  public BasicZiroomToolBar addButton(ImageButton paramImageButton)
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    if ((this.c.size() > 0) && ((this.c.get(0) instanceof TextButton))) {
      this.c.clear();
    }
    this.c.add(paramImageButton);
    b();
    return this;
  }
  
  public BasicZiroomToolBar addButton(TextButton paramTextButton)
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    if ((this.c.size() > 0) && ((this.c.get(0) instanceof ImageView))) {
      this.c.clear();
    }
    this.c.add(paramTextButton);
    b();
    return this;
  }
  
  protected void b()
  {
    this.a.removeAllViews();
    if ((this.c != null) && (this.c.size() > 0))
    {
      this.a.setVisibility(0);
      int i = this.c.size() - 1;
      if (i >= 0)
      {
        View localView = (View)this.c.get(i);
        if ((localView instanceof TextView)) {}
        for (LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);; localLayoutParams = new LinearLayout.LayoutParams(b.dip2px(getContext(), 24.0F), -1))
        {
          localLayoutParams.gravity = 16;
          if (i > 0) {
            localLayoutParams.setMargins(0, 0, b.dip2px(getContext(), 28.0F), 0);
          }
          this.a.addView(localView, localLayoutParams);
          i -= 1;
          break;
        }
      }
    }
    else
    {
      this.a.setVisibility(8);
    }
  }
  
  public ImageButton newButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    ImageButton localImageButton = new ImageButton(getContext(), null);
    localImageButton.setImageResource(paramInt);
    localImageButton.setOnClickListener(paramOnClickListener);
    return localImageButton;
  }
  
  public TextButton newButton(String paramString, View.OnClickListener paramOnClickListener)
  {
    TextButton localTextButton = new TextButton(getContext(), null);
    localTextButton.setText(paramString);
    localTextButton.setTextColor(Color.parseColor("#444444"));
    localTextButton.setTextSize(2, 14.0F);
    localTextButton.setOnClickListener(paramOnClickListener);
    localTextButton.setPadding(0, 0, 0, 0);
    localTextButton.setMaxLines(1);
    localTextButton.setGravity(17);
    return localTextButton;
  }
  
  public BasicZiroomToolBar setBackVisible(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.setVisibility(0);
    }
    for (;;)
    {
      b();
      return this;
      this.b.setVisibility(8);
    }
  }
  
  public BasicZiroomToolBar setOnBackClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {
      this.b.setOnClickListener(paramOnClickListener);
    }
    return this;
  }
  
  public BasicZiroomToolBar setTitle(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.d.setText(paramString);
      this.d.setVisibility(0);
      return this;
    }
    this.d.setMaxLines(8);
    return this;
  }
  
  public static final class ImageButton
    extends ImageView
  {
    private ImageButton(Context paramContext)
    {
      super();
    }
  }
  
  public static final class TextButton
    extends TextView
  {
    private TextButton(Context paramContext)
    {
      super();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/unifiedziroom/BasicZiroomToolBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */