package com.ziroom.ziroomcustomer.ziroomapartment.dialog;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.adapter.r;
import com.ziroom.ziroomcustomer.minsu.f.ac;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarCellView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.e;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.h;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.i;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.j;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarRowView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.a;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomapartment.widget.ProjectListConditionalView.b;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class ZryuDateListPop
  extends PopupWindow
  implements View.OnClickListener
{
  public static final char[] b = "日一二三四五六".toCharArray();
  private static boolean f = false;
  CalendarPickerView a;
  private String c = ZryuDateListPop.class.getSimpleName();
  private TextView d;
  private TextView e;
  private Context g;
  private View h;
  private String i;
  private Date j;
  private ProjectListConditionalView.b k;
  private a l;
  
  public ZryuDateListPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ZryuDateListPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ZryuDateListPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    if (Build.VERSION.SDK_INT >= 24) {
      setHeight(-2);
    }
    for (;;)
    {
      setAnimationStyle(2131427934);
      this.h = LayoutInflater.from(paramContext).inflate(2130905069, null);
      this.g = paramContext;
      a();
      return;
      setHeight(-1);
    }
  }
  
  private void a()
  {
    this.a = ((CalendarPickerView)this.h.findViewById(2131691033));
    CalendarRowView localCalendarRowView = (CalendarRowView)this.h.findViewById(2131691032);
    int m = 0;
    while (m < 7)
    {
      ((TextView)localCalendarRowView.getChildAt(m)).setText(b[m] + "");
      m += 1;
    }
    this.d = ((TextView)this.h.findViewById(2131691289));
    this.e = ((TextView)this.h.findViewById(2131693064));
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (ZryuDateListPop.a(ZryuDateListPop.this) != null) {
          ZryuDateListPop.a(ZryuDateListPop.this).onDismiss();
        }
      }
    });
    setContentView(this.h);
  }
  
  private void b()
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.set(5, 1);
    localCalendar1.add(2, 7);
    if (this.j != null) {
      this.a.init(localCalendar2.getTime(), localCalendar1.getTime()).inMode(CalendarPickerView.j.a).withSelectedDate(this.j);
    }
    for (;;)
    {
      this.a.setDecorators(Arrays.asList(new a[] { new b() }));
      this.a.setCustomDayView(new r());
      this.a.setOnInvalidDateSelectedListener(new CalendarPickerView.i()
      {
        public void onInvalidDateSelected(Date paramAnonymousDate) {}
      });
      this.a.setOnDateSelectedListener(new CalendarPickerView.h()
      {
        public void onDateSelected(Date paramAnonymousDate)
        {
          u.d("lanzhihong", "onDateSelected===" + m.getFormatDate(paramAnonymousDate, m.b));
          ZryuDateListPop.a(ZryuDateListPop.this, paramAnonymousDate);
          ZryuDateListPop.a(ZryuDateListPop.this, m.getFormatDate(paramAnonymousDate, m.b));
          ZryuDateListPop.a(false);
        }
        
        public void onDateUnselected(Date paramAnonymousDate)
        {
          u.d("lanzhihong", "onDateUnselected===" + m.getFormatDate(paramAnonymousDate, m.b));
        }
      });
      return;
      this.a.init(localCalendar2.getTime(), localCalendar1.getTime()).inMode(CalendarPickerView.j.a);
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691289: 
      if (this.l != null)
      {
        u.i(this.c, "select:" + this.i);
        if (!f) {
          break label99;
        }
        this.l.select(this.j, false);
      }
      for (;;)
      {
        dismiss();
        return;
        label99:
        this.l.select(this.j, true);
      }
    }
    f = true;
    this.i = "";
    this.j = null;
    u.i(this.c, "重置了");
    this.a.clearOldSelections();
    this.a.validateAndUpdate();
  }
  
  public void setOnSelectListener(a parama)
  {
    this.l = parama;
  }
  
  public void setPopDismisListener(ProjectListConditionalView.b paramb)
  {
    this.k = paramb;
  }
  
  public void show(View paramView, Date paramDate)
  {
    if (paramDate == null) {
      f = true;
    }
    for (;;)
    {
      b();
      if ((this instanceof PopupWindow)) {
        break;
      }
      showAsDropDown(paramView, 0, 0);
      return;
      f = false;
      this.j = paramDate;
    }
    VdsAgent.showAsDropDown((PopupWindow)this, paramView, 0, 0);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT == 24)
    {
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      paramInt2 = arrayOfInt[1] + paramView.getHeight() + paramInt2;
      if (!(this instanceof PopupWindow))
      {
        showAtLocation(paramView, 0, paramInt1, paramInt2);
        return;
      }
      VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, paramInt1, paramInt2);
      return;
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  public static abstract interface a
  {
    public abstract void select(Date paramDate, boolean paramBoolean);
  }
  
  public class b
    implements a
  {
    public b() {}
    
    private String a(Date paramDate)
    {
      return Integer.toString(paramDate.getDate());
    }
    
    private void a(CalendarCellView paramCalendarCellView, Date paramDate)
    {
      if (paramCalendarCellView.isCurrentMonth())
      {
        if (paramCalendarCellView.isSelectable())
        {
          if (paramCalendarCellView.isSelected())
          {
            ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#ffffff"));
            paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837707);
            return;
          }
          if (paramCalendarCellView.isToday())
          {
            ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#444444"));
            paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837812);
            return;
          }
          ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#444444"));
          paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
          return;
        }
        ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#999999"));
        paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
        return;
      }
      ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#ffffff"));
      paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
    }
    
    public void decorate(CalendarCellView paramCalendarCellView, Date paramDate)
    {
      a(paramCalendarCellView, paramDate);
      paramCalendarCellView.setBackgroundResource(2131624349);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/dialog/ZryuDateListPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */