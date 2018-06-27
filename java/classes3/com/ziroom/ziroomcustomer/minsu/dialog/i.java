package com.ziroom.ziroomcustomer.minsu.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

public class i
  extends PopupWindow
{
  private TextView a;
  private View b;
  private ListViewForScrollView c;
  private Activity d;
  private a e;
  
  public i(Activity paramActivity, AdapterView.OnItemClickListener paramOnItemClickListener, List<String> paramList)
  {
    super(paramActivity);
    this.d = paramActivity;
    this.b = ((LayoutInflater)paramActivity.getSystemService("layout_inflater")).inflate(2130904884, null);
    this.c = ((ListViewForScrollView)this.b.findViewById(2131691217));
    this.a = ((TextView)this.b.findViewById(2131690460));
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (i.a(i.this) != null) {
          i.a(i.this).onCancel();
        }
        i.this.dismiss();
      }
    });
    a(paramActivity, paramOnItemClickListener, paramList);
    setWidth(-1);
    setHeight(-1);
    setContentView(this.b);
    setFocusable(true);
    setAnimationStyle(2131427507);
    setBackgroundDrawable(new ColorDrawable(Color.parseColor("#99000000")));
    this.b.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        u.e("err", "on touch in pop ==============");
        int i = i.b(i.this).findViewById(2131696851).getTop();
        int j = (int)paramAnonymousMotionEvent.getY();
        if ((paramAnonymousMotionEvent.getAction() == 1) && (j < i)) {
          i.this.dismiss();
        }
        return true;
      }
    });
  }
  
  private void a(Activity paramActivity, AdapterView.OnItemClickListener paramOnItemClickListener, List<String> paramList)
  {
    this.c.setAdapter(new a(paramActivity, paramList, 2130904354)
    {
      public void convert(b paramAnonymousb, String paramAnonymousString)
      {
        paramAnonymousb.setText(2131690043, paramAnonymousString);
      }
    });
    this.c.setOnItemClickListener(paramOnItemClickListener);
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
      this.a.setTextColor(this.d.getResources().getColor(paramInt));
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
    this.e = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/dialog/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */