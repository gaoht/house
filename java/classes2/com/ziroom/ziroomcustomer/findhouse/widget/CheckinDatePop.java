package com.ziroom.ziroomcustomer.findhouse.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.freelxl.baselibrary.f.f;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import com.ziroom.ziroomcustomer.minsu.adapter.r;
import com.ziroom.ziroomcustomer.minsu.f.ac;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarCellView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.c;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.e;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.h;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.i;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.j;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarRowView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.a;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CheckinDatePop
  extends PopupWindow
  implements View.OnClickListener
{
  public static final char[] a = "日一二三四五六".toCharArray();
  private static boolean e = false;
  private CalendarPickerView b;
  private TextView c;
  private TextView d;
  private boolean f = true;
  private Context g;
  private View h;
  private List<SelectBean> i = new ArrayList();
  private String j;
  private SearchCondition k;
  private String l;
  private String m;
  private int n = 0;
  private HouseList_ConditionalView.c o;
  private a p;
  
  public CheckinDatePop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CheckinDatePop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckinDatePop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
      this.h = LayoutInflater.from(paramContext).inflate(2130905031, null);
      this.g = paramContext;
      a();
      return;
      setHeight(-1);
    }
  }
  
  private void a()
  {
    CalendarRowView localCalendarRowView = (CalendarRowView)this.h.findViewById(2131691032);
    localCalendarRowView.setCellTextColor(this.g.getResources().getColor(2131624039));
    int i1 = 0;
    while (i1 < 7)
    {
      ((TextView)localCalendarRowView.getChildAt(i1)).setText(a[i1] + "");
      i1 += 1;
    }
    this.c = ((TextView)this.h.findViewById(2131691289));
    this.d = ((TextView)this.h.findViewById(2131693064));
    this.b = ((CalendarPickerView)this.h.findViewById(2131691033));
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (CheckinDatePop.a(CheckinDatePop.this) != null) {
          CheckinDatePop.a(CheckinDatePop.this).onDismiss();
        }
      }
    });
    setContentView(this.h);
  }
  
  public void initCalendar()
  {
    if (this.n != 0) {}
    while ((ae.isNull(this.l)) || (ae.isNull(this.m))) {
      return;
    }
    this.n += 1;
    ArrayList localArrayList = new ArrayList();
    if (ae.notNull(this.j)) {
      localArrayList.add(m.strToDate(this.j, m.b));
    }
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      this.b.init(m.strToDate(this.l, m.b), m.getDateAfter(m.strToDate(this.m, m.b), 1)).inMode(CalendarPickerView.j.a).withSelectedDates(localArrayList);
    }
    for (;;)
    {
      this.b.setDecorators(Arrays.asList(new a[] { new b(this.g, this.b) }));
      this.b.setCustomDayView(new r());
      this.b.setDateSelectableFilter(new CalendarPickerView.c()
      {
        public boolean isDateSelectable(Date paramAnonymousDate)
        {
          return (!ae.notNull(CheckinDatePop.b(CheckinDatePop.this))) || (!m.getFormatDate(paramAnonymousDate, m.b).equals(CheckinDatePop.b(CheckinDatePop.this)));
        }
      });
      this.b.setOnInvalidDateSelectedListener(new CalendarPickerView.i()
      {
        public void onInvalidDateSelected(Date paramAnonymousDate) {}
      });
      this.b.setOnDateSelectedListener(new CalendarPickerView.h()
      {
        public void onDateSelected(Date paramAnonymousDate)
        {
          paramAnonymousDate = m.getFormatDate(paramAnonymousDate, m.b);
          CheckinDatePop.a(CheckinDatePop.this, paramAnonymousDate);
          paramAnonymousDate = CheckinDatePop.b(CheckinDatePop.this).split("-");
          g.textToast(CheckinDatePop.c(CheckinDatePop.this), "优先为您筛选" + Integer.parseInt(paramAnonymousDate[2]) + "号前可释放的房源");
        }
        
        public void onDateUnselected(Date paramAnonymousDate) {}
      });
      return;
      this.b.init(m.strToDate(this.l, m.b), m.getDateAfter(m.strToDate(this.m, m.b), 1)).inMode(CalendarPickerView.j.a);
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
      this.p.select(this.j);
      dismiss();
      return;
    }
    this.j = "";
    this.k.setCheckin_date("");
    paramView = new ArrayList();
    if (ae.notNull(this.j)) {
      paramView.add(m.strToDate(this.j, m.b));
    }
    this.b.init(m.strToDate(this.l, m.b), m.getDateAfter(m.strToDate(this.m, m.b), 1)).inMode(CalendarPickerView.j.a).withSelectedDates(paramView);
  }
  
  public void setOnSelectListener(a parama)
  {
    this.p = parama;
  }
  
  public void setPopDismisListener(HouseList_ConditionalView.c paramc)
  {
    this.o = paramc;
  }
  
  public void show(View paramView, String paramString1, String paramString2, SearchCondition paramSearchCondition, boolean paramBoolean)
  {
    e = paramBoolean;
    this.k = paramSearchCondition;
    this.l = paramString1;
    this.m = paramString2;
    initCalendar();
    if (!(this instanceof PopupWindow))
    {
      showAsDropDown(paramView, 0, 0);
      return;
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
    public abstract void select(String paramString);
  }
  
  public class b
    implements a
  {
    private CalendarPickerView b;
    private Context c;
    
    public b(Context paramContext, CalendarPickerView paramCalendarPickerView)
    {
      this.c = paramContext;
      this.b = paramCalendarPickerView;
    }
    
    private String a(Date paramDate)
    {
      return Integer.toString(paramDate.getDate());
    }
    
    private void a(CalendarCellView paramCalendarCellView, Date paramDate)
    {
      List localList = this.b.getSelectedDates();
      Date localDate = null;
      if ((localList != null) && (localList.size() == 1))
      {
        localDate = (Date)localList.get(0);
        if (localDate == null) {
          break label336;
        }
      }
      label336:
      for (long l = m.getDaysBetween(paramDate, localDate);; l = 0L)
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
              if (!f.notNull(CheckinDatePop.b(CheckinDatePop.this))) {
                break;
              }
              localDate = m.strToDate(CheckinDatePop.b(CheckinDatePop.this), m.b);
              break;
            }
            if ((l < 7L) && (l > 0L))
            {
              ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#444444"));
              paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837747);
              return;
            }
            if (paramCalendarCellView.isToday())
            {
              ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#444444"));
              paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837759);
              return;
            }
            ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#444444"));
            paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
            return;
          }
          if (paramCalendarCellView.isToday())
          {
            ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#dddddd"));
            paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
            return;
          }
          ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#dddddd"));
          paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
          return;
        }
        ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#ffffff"));
        paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
        return;
      }
    }
    
    public void decorate(CalendarCellView paramCalendarCellView, Date paramDate)
    {
      a(paramCalendarCellView, paramDate);
      paramCalendarCellView.setBackgroundResource(2131624349);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/widget/CheckinDatePop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */