package com.ziroom.ziroomcustomer.ziroomapartment.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.ziroomapartment.a;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuListItem;
import java.util.Iterator;
import java.util.List;

public class ZryuProjectDetailPop
  extends PopupWindow
  implements View.OnClickListener
{
  private Context a;
  private SimpleDraweeView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private LinearLayout f;
  private View g;
  private float h;
  private ZryuListItem i;
  
  public ZryuProjectDetailPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ZryuProjectDetailPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ZryuProjectDetailPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    paramAttributeSet = paramContext.getResources().getDisplayMetrics();
    paramInt = (int)(paramAttributeSet.widthPixels / 375.0F * 250.0F);
    d.d("ZryuProjectDetailPop", "====ZryuProjectDetailPop:" + paramAttributeSet.widthPixels + ";" + paramInt);
    this.h = paramAttributeSet.density;
    setWidth(-1);
    setHeight(paramInt);
    setAnimationStyle(2131427507);
    this.a = paramContext;
    this.g = LayoutInflater.from(paramContext).inflate(2130904824, null);
    a();
  }
  
  private void a()
  {
    this.b = ((SimpleDraweeView)this.g.findViewById(2131691098));
    this.c = ((TextView)this.g.findViewById(2131690049));
    this.d = ((TextView)this.g.findViewById(2131689912));
    this.e = ((TextView)this.g.findViewById(2131690041));
    this.f = ((LinearLayout)this.g.findViewById(2131695864));
    setContentView(this.g);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
  }
  
  public void show(View paramView, ZryuListItem paramZryuListItem)
  {
    update(paramZryuListItem);
    if (!(this instanceof PopupWindow))
    {
      showAtLocation(paramView, 80, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)this, paramView, 80, 0, 0);
  }
  
  public void update(final ZryuListItem paramZryuListItem)
  {
    this.i = paramZryuListItem;
    this.b.setController(c.frescoController(paramZryuListItem.getHeadPic()));
    this.c.setText(paramZryuListItem.getProName());
    if ((ae.notNull(paramZryuListItem.getPriceTag())) && (ae.notNull(paramZryuListItem.getMinPrice())) && (ae.notNull(paramZryuListItem.getMaxPrice())))
    {
      this.d.setText(paramZryuListItem.getPriceTag() + paramZryuListItem.getMinPrice() + "-" + paramZryuListItem.getMaxPrice());
      if (!TextUtils.isEmpty(paramZryuListItem.getProAddr())) {
        break label310;
      }
      this.e.setVisibility(8);
    }
    for (;;)
    {
      this.f.removeAllViews();
      if ((paramZryuListItem.getTagList() == null) || (paramZryuListItem.getTagList().size() <= 0)) {
        break label332;
      }
      Iterator localIterator = paramZryuListItem.getTagList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        TextView localTextView = new TextView(this.a);
        localTextView.setText((CharSequence)localObject);
        localTextView.setTextColor(Color.parseColor("#FFFFFF"));
        localTextView.setTextSize(10.0F);
        localTextView.setPadding((int)this.h * 5, (int)this.h * 3, (int)this.h * 5, (int)this.h * 3);
        localTextView.setBackgroundResource(2130837916);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, (int)this.h * 5, 0);
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.f.addView(localTextView);
      }
      this.d.setText("");
      break;
      label310:
      this.e.setVisibility(0);
      this.e.setText(paramZryuListItem.getProAddr());
    }
    label332:
    this.g.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (1 == paramZryuListItem.getProjectState())
        {
          g.textToast(ZryuProjectDetailPop.a(ZryuProjectDetailPop.this), "敬请期待");
          return;
        }
        a.ToProjectInfo(ZryuProjectDetailPop.a(ZryuProjectDetailPop.this), paramZryuListItem.getProFid());
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/dialog/ZryuProjectDetailPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */