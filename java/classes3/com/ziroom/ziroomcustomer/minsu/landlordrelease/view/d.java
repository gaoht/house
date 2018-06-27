package com.ziroom.ziroomcustomer.minsu.landlordrelease.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.freelxl.baselibrary.a.a;
import com.freelxl.baselibrary.a.b;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import java.util.List;

public class d
  extends PopupWindow
{
  private TextView a;
  private TextView b;
  private View c;
  private ListViewForScrollView d;
  private ListViewForScrollView e;
  private Activity f;
  private a g;
  
  public d(Activity paramActivity, AdapterView.OnItemClickListener paramOnItemClickListener, List<String> paramList1, List<String> paramList2)
  {
    super(paramActivity);
    this.f = paramActivity;
    this.c = ((LayoutInflater)paramActivity.getSystemService("layout_inflater")).inflate(2130904885, null);
    this.d = ((ListViewForScrollView)this.c.findViewById(2131691217));
    this.b = ((TextView)this.c.findViewById(2131696852));
    this.b.getPaint().setFakeBoldText(true);
    this.e = ((ListViewForScrollView)this.c.findViewById(2131696853));
    this.a = ((TextView)this.c.findViewById(2131690460));
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (d.a(d.this) != null) {
          d.a(d.this).onCancel();
        }
        d.this.dismiss();
      }
    });
    a(paramActivity, paramOnItemClickListener, paramList1, paramList2);
    setWidth(-1);
    setHeight(-2);
    setContentView(this.c);
    setFocusable(true);
    setAnimationStyle(2131427507);
    setBackgroundDrawable(new ColorDrawable(Color.parseColor("#99000000")));
    this.c.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        u.e("err", "on touch in pop ==============");
        int i = d.b(d.this).findViewById(2131696851).getTop();
        int j = (int)paramAnonymousMotionEvent.getY();
        if ((paramAnonymousMotionEvent.getAction() == 1) && (j < i)) {
          d.this.dismiss();
        }
        return true;
      }
    });
  }
  
  private void a(Activity paramActivity, AdapterView.OnItemClickListener paramOnItemClickListener, List<String> paramList1, List<String> paramList2)
  {
    this.d.setAdapter(new a(paramActivity, paramList2, 2130904354)
    {
      public void convert(b paramAnonymousb, String paramAnonymousString)
      {
        paramAnonymousb.setText(2131690043, paramAnonymousString);
      }
    });
    this.d.setOnItemClickListener(paramOnItemClickListener);
    this.e.setAdapter(new a(paramActivity, paramList1, 2130904355)
    {
      public void convert(b paramAnonymousb, String paramAnonymousString)
      {
        paramAnonymousb.setText(2131690043, paramAnonymousString);
      }
    });
  }
  
  public void setCancelText(int paramInt)
  {
    if (this.a != null) {
      this.a.setText(paramInt);
    }
  }
  
  public void setCancelTextColor(int paramInt)
  {
    if (this.a != null) {
      this.a.setTextColor(this.f.getResources().getColor(paramInt));
    }
  }
  
  public void setCancelVisible(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.a != null)
    {
      localTextView = this.a;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void setOnCancelListener(a parama)
  {
    this.g = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */