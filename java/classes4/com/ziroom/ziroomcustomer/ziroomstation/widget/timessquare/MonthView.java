package com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class MonthView
  extends LinearLayout
{
  private static String g;
  private static String h;
  private static String i;
  TextView a;
  CalendarGridView b;
  private a c;
  private List<a> d;
  private boolean e;
  private Locale f;
  
  public MonthView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt2 = paramInt1 + paramInt2;
    paramInt1 = paramInt2;
    if (paramBoolean) {
      paramInt1 = 8 - paramInt2;
    }
    return paramInt1;
  }
  
  private static boolean a(Locale paramLocale)
  {
    boolean bool = false;
    int j = Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0));
    if ((j == 1) || (j == 2)) {
      bool = true;
    }
    return bool;
  }
  
  public static MonthView create(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, DateFormat paramDateFormat, a parama, Calendar paramCalendar, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, List<a> paramList, Locale paramLocale, b paramb, String paramString1, String paramString2, String paramString3)
  {
    g = paramString1;
    h = paramString2;
    i = paramString3;
    paramViewGroup = (MonthView)paramLayoutInflater.inflate(2130904938, paramViewGroup, false);
    paramViewGroup.setDayViewAdapter(paramb);
    paramViewGroup.setDividerColor(paramInt1);
    paramViewGroup.setDayTextColor(paramInt3);
    paramViewGroup.setTitleTextColor(paramInt4);
    paramViewGroup.setDisplayHeader(paramBoolean);
    paramViewGroup.setHeaderTextColor(paramInt5);
    if (paramInt2 != 0) {
      paramViewGroup.setDayBackground(paramInt2);
    }
    paramInt2 = paramCalendar.get(7);
    paramViewGroup.e = a(paramLocale);
    paramViewGroup.f = paramLocale;
    paramInt3 = paramCalendar.getFirstDayOfWeek();
    paramLayoutInflater = (CalendarRowView)paramViewGroup.b.getChildAt(0);
    paramInt1 = 0;
    if (paramInt1 < 7)
    {
      paramCalendar.set(7, a(paramInt3, paramInt1, paramViewGroup.e));
      paramLocale = (TextView)paramLayoutInflater.getChildAt(paramInt1);
      paramb = paramDateFormat.format(paramCalendar.getTime());
      if ((paramInt1 == 0) || (paramInt1 == 6)) {
        paramLocale.setTextColor(40960);
      }
      for (;;)
      {
        paramLocale.setText(paramb.substring(paramb.length() - 1));
        paramInt1 += 1;
        break;
        paramLocale.setTextColor(-7829368);
      }
    }
    paramCalendar.set(7, paramInt2);
    paramViewGroup.c = parama;
    paramViewGroup.d = paramList;
    return paramViewGroup;
  }
  
  public static MonthView create(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, DateFormat paramDateFormat, a parama, Calendar paramCalendar, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, Locale paramLocale, b paramb, String paramString1, String paramString2, String paramString3)
  {
    return create(paramViewGroup, paramLayoutInflater, paramDateFormat, parama, paramCalendar, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5, null, paramLocale, paramb, paramString1, paramString2, paramString3);
  }
  
  public List<a> getDecorators()
  {
    return this.d;
  }
  
  public void init(f paramf, List<List<e>> paramList, boolean paramBoolean, Typeface paramTypeface1, Typeface paramTypeface2, int paramInt1, int paramInt2)
  {
    d.d("Initializing MonthView (%d) for %s", new Object[] { Integer.valueOf(System.identityHashCode(this)), paramf });
    long l = System.currentTimeMillis();
    this.a.setTextColor(paramInt1);
    this.a.setTextSize(2, paramInt2);
    this.a.setTypeface(paramTypeface1);
    this.a.setText(paramf.getLabel());
    paramf = NumberFormat.getInstance(this.f);
    int k = paramList.size();
    this.b.setNumRows(k);
    paramInt2 = 0;
    while (paramInt2 < 6)
    {
      CalendarRowView localCalendarRowView = (CalendarRowView)this.b.getChildAt(paramInt2 + 1);
      localCalendarRowView.setListener(this.c);
      if (paramInt2 < k)
      {
        localCalendarRowView.setVisibility(0);
        List localList = (List)paramList.get(paramInt2);
        paramInt1 = 0;
        while (paramInt1 < localList.size())
        {
          int j;
          e locale;
          CalendarCellView localCalendarCellView;
          Object localObject;
          if (this.e)
          {
            j = 6 - paramInt1;
            locale = (e)localList.get(j);
            localCalendarCellView = (CalendarCellView)localCalendarRowView.getChildAt(paramInt1);
            localCalendarCellView.setToday(locale.isToday());
            localCalendarCellView.setTomorrow(locale.isTomorrow());
            localCalendarCellView.setAfterTomorrow(locale.isAftertomorrow());
            localCalendarCellView.setSelected(locale.isSelected());
            localObject = paramf.format(locale.getValue());
            if (!localCalendarCellView.getDayOfMonthTextView().getText().equals(localObject))
            {
              if ((!localCalendarCellView.isToday()) && (!localCalendarCellView.isTomorrow()) && (!localCalendarCellView.isAfterTomorrow())) {
                break label495;
              }
              if (!localCalendarCellView.isToday()) {
                break label451;
              }
              localCalendarCellView.getDayOfMonthTextView().setText(g);
            }
            label320:
            localCalendarCellView.setEnabled(locale.isCurrentMonth());
            if (paramBoolean) {
              break label508;
            }
          }
          label451:
          label495:
          label508:
          for (boolean bool = true;; bool = false)
          {
            localCalendarCellView.setClickable(bool);
            localCalendarCellView.setSelectable(locale.isSelectable());
            localCalendarCellView.setCurrentMonth(locale.isCurrentMonth());
            localCalendarCellView.setRangeState(locale.getRangeState());
            localCalendarCellView.setHighlighted(locale.a());
            localCalendarCellView.setTag(locale);
            if (this.d == null) {
              break label514;
            }
            localObject = this.d.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((a)((Iterator)localObject).next()).decorate(localCalendarCellView, locale.getDate());
            }
            j = paramInt1;
            break;
            if (localCalendarCellView.isTomorrow())
            {
              localCalendarCellView.getDayOfMonthTextView().setText(h);
              break label320;
            }
            if (!localCalendarCellView.isAfterTomorrow()) {
              break label320;
            }
            localCalendarCellView.getDayOfMonthTextView().setText(i);
            break label320;
            localCalendarCellView.getDayOfMonthTextView().setText((CharSequence)localObject);
            break label320;
          }
          label514:
          paramInt1 += 1;
        }
      }
      localCalendarRowView.setVisibility(8);
      paramInt2 += 1;
    }
    if ((paramTypeface1 == null) || (paramTypeface2 != null)) {
      this.b.setTypeface(paramTypeface2);
    }
    d.d("MonthView.init took %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((TextView)findViewById(2131689533));
    this.b = ((CalendarGridView)findViewById(2131696917));
  }
  
  public void setDayBackground(int paramInt)
  {
    this.b.setDayBackground(paramInt);
  }
  
  public void setDayTextColor(int paramInt)
  {
    this.b.setDayTextColor(paramInt);
  }
  
  public void setDayViewAdapter(b paramb)
  {
    this.b.setDayViewAdapter(paramb);
  }
  
  public void setDecorators(List<a> paramList)
  {
    this.d = paramList;
  }
  
  public void setDisplayHeader(boolean paramBoolean)
  {
    this.b.setDisplayHeader(paramBoolean);
  }
  
  public void setDividerColor(int paramInt)
  {
    this.b.setDividerColor(paramInt);
  }
  
  public void setHeaderTextColor(int paramInt)
  {
    this.b.setHeaderTextColor(paramInt);
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.a.setTextColor(paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void handleClick(e parame);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/timessquare/MonthView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */