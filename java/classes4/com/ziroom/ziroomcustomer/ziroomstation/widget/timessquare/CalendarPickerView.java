package com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.R.styleable;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class CalendarPickerView
  extends ListView
{
  private Typeface A;
  private String B;
  private String C;
  private String D;
  private h E;
  private c F;
  private i G = new d(null);
  private a H;
  private List<a> I;
  private b J = new c();
  final MonthView.a a = new b(null);
  final List<f> b = new ArrayList();
  final List<e> c = new ArrayList();
  final List<e> d = new ArrayList();
  final List<Calendar> e = new ArrayList();
  final List<Calendar> f = new ArrayList();
  j g;
  Calendar h;
  private final f i;
  private final List<List<List<e>>> j = new ArrayList();
  private Locale k;
  private DateFormat l;
  private DateFormat m;
  private DateFormat n;
  private Calendar o;
  private Calendar p;
  private Calendar q;
  private boolean r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private boolean x;
  private int y;
  private Typeface z;
  
  public CalendarPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Resources localResources = paramContext.getResources();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CalendarPickerView);
    int i1 = paramAttributeSet.getColor(0, localResources.getColor(2131623988));
    this.s = paramAttributeSet.getColor(1, localResources.getColor(2131623989));
    this.t = paramAttributeSet.getResourceId(2, 2130838094);
    this.u = paramAttributeSet.getResourceId(3, 2131624633);
    this.v = -7829368;
    this.w = 16;
    this.x = paramAttributeSet.getBoolean(5, true);
    this.y = paramAttributeSet.getColor(7, localResources.getColor(2131623994));
    paramAttributeSet.recycle();
    this.i = new f(null);
    setDivider(null);
    setDividerHeight(0);
    setBackgroundColor(i1);
    setCacheColorHint(i1);
    this.k = Locale.getDefault();
    this.h = Calendar.getInstance(this.k);
    this.o = Calendar.getInstance(this.k);
    this.p = Calendar.getInstance(this.k);
    this.q = Calendar.getInstance(this.k);
    this.l = new SimpleDateFormat(paramContext.getString(2131297173), this.k);
    this.m = new SimpleDateFormat(paramContext.getString(2131296756), this.k);
    this.n = DateFormat.getDateInstance(2, this.k);
    this.B = paramContext.getResources().getString(2131297523);
    this.C = paramContext.getResources().getString(2131297524);
    this.D = paramContext.getResources().getString(2131296582);
    if (isInEditMode())
    {
      paramContext = Calendar.getInstance(this.k);
      paramContext.add(1, 1);
      init(new Date(), paramContext.getTime()).withSelectedDate(new Date());
    }
  }
  
  private static String a(Date paramDate1, Date paramDate2)
  {
    return "minDate: " + paramDate1 + "\nmaxDate: " + paramDate2;
  }
  
  private static Calendar a(List<Calendar> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    Collections.sort(paramList);
    return (Calendar)paramList.get(0);
  }
  
  private Date a(Date paramDate, Calendar paramCalendar)
  {
    Object localObject2 = this.c.iterator();
    do
    {
      localObject1 = paramDate;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (e)((Iterator)localObject2).next();
    } while (!((e)localObject1).getDate().equals(paramDate));
    ((e)localObject1).setSelected(false);
    this.c.remove(localObject1);
    Object localObject1 = null;
    paramDate = this.e.iterator();
    while (paramDate.hasNext())
    {
      localObject2 = (Calendar)paramDate.next();
      if (a((Calendar)localObject2, paramCalendar)) {
        this.e.remove(localObject2);
      }
    }
    return (Date)localObject1;
  }
  
  private void a()
  {
    if (getAdapter() == null) {
      setAdapter(this.i);
    }
    this.i.notifyDataSetChanged();
  }
  
  private void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  private void a(final int paramInt, final boolean paramBoolean)
  {
    post(new Runnable()
    {
      public void run()
      {
        d.d("Scrolling to position %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramBoolean)
        {
          CalendarPickerView.this.smoothScrollToPosition(paramInt);
          return;
        }
        CalendarPickerView.this.setSelection(paramInt);
      }
    });
  }
  
  private void a(Date paramDate)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("Selected date must be non-null.");
    }
    if ((paramDate.before(this.o.getTime())) || (paramDate.after(this.p.getTime()))) {
      throw new IllegalArgumentException(String.format("SelectedDate must be between minDate and maxDate.%nminDate: %s%nmaxDate: %s%nselectedDate: %s", new Object[] { this.o.getTime(), this.p.getTime(), paramDate }));
    }
  }
  
  private static boolean a(Calendar paramCalendar, f paramf)
  {
    return (paramCalendar.get(2) == paramf.getMonth()) && (paramCalendar.get(1) == paramf.getYear());
  }
  
  private static boolean a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    return (paramCalendar1.get(2) == paramCalendar2.get(2)) && (paramCalendar1.get(1) == paramCalendar2.get(1)) && (paramCalendar1.get(5) == paramCalendar2.get(5));
  }
  
  private static boolean a(Calendar paramCalendar1, Calendar paramCalendar2, Calendar paramCalendar3)
  {
    return a(paramCalendar1.getTime(), paramCalendar2, paramCalendar3);
  }
  
  private boolean a(Date paramDate, e parame)
  {
    Object localObject2 = Calendar.getInstance(this.k);
    ((Calendar)localObject2).setTime(paramDate);
    setMidnight((Calendar)localObject2);
    Object localObject1 = this.c.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e)((Iterator)localObject1).next()).setRangeState(e.a.a);
    }
    switch (3.a[this.g.ordinal()])
    {
    default: 
      throw new IllegalStateException("Unknown selectionMode " + this.g);
    case 1: 
      if (this.e.size() > 1)
      {
        c();
        localObject1 = paramDate;
      }
      break;
    }
    while (localObject1 != null)
    {
      if ((this.c.size() == 0) || (!((e)this.c.get(0)).equals(parame)))
      {
        this.c.add(parame);
        parame.setSelected(true);
      }
      this.e.add(localObject2);
      if ((this.g != j.c) || (this.c.size() <= 1)) {
        break;
      }
      paramDate = ((e)this.c.get(0)).getDate();
      parame = ((e)this.c.get(1)).getDate();
      ((e)this.c.get(0)).setRangeState(e.a.b);
      ((e)this.c.get(1)).setRangeState(e.a.d);
      localObject2 = this.j.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      Iterator localIterator1 = ((List)((Iterator)localObject2).next()).iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((List)localIterator1.next()).iterator();
        while (localIterator2.hasNext())
        {
          e locale = (e)localIterator2.next();
          if ((locale.getDate().after(paramDate)) && (locale.getDate().before(parame)) && (locale.isSelectable()))
          {
            locale.setSelected(true);
            locale.setRangeState(e.a.c);
            this.c.add(locale);
          }
        }
      }
      localObject1 = paramDate;
      if (this.e.size() == 1)
      {
        localObject1 = paramDate;
        if (((Calendar)localObject2).before(this.e.get(0)))
        {
          c();
          localObject1 = paramDate;
          continue;
          localObject1 = a(paramDate, (Calendar)localObject2);
          continue;
          c();
          localObject1 = paramDate;
        }
      }
    }
    a();
    return localObject1 != null;
  }
  
  static boolean a(Date paramDate, Calendar paramCalendar1, Calendar paramCalendar2)
  {
    paramCalendar1 = paramCalendar1.getTime();
    return ((paramDate.equals(paramCalendar1)) || (paramDate.after(paramCalendar1))) && (paramDate.before(paramCalendar2.getTime()));
  }
  
  private static boolean a(List<Calendar> paramList, Calendar paramCalendar)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (a(paramCalendar, (Calendar)paramList.next())) {
        return true;
      }
    }
    return false;
  }
  
  private g b(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance(this.k);
    localCalendar.setTime(paramDate);
    paramDate = Calendar.getInstance(this.k);
    Iterator localIterator1 = this.j.iterator();
    int i1 = 0;
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)localIterator1.next()).iterator();
      e locale;
      do
      {
        Iterator localIterator3;
        while (!localIterator3.hasNext())
        {
          if (!localIterator2.hasNext()) {
            break;
          }
          localIterator3 = ((List)localIterator2.next()).iterator();
        }
        locale = (e)localIterator3.next();
        paramDate.setTime(locale.getDate());
      } while ((!a(paramDate, localCalendar)) || (!locale.isSelectable()));
      return new g(locale, i1);
      i1 += 1;
    }
    return null;
  }
  
  private static Calendar b(List<Calendar> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    Collections.sort(paramList);
    return (Calendar)paramList.get(paramList.size() - 1);
  }
  
  private void b()
  {
    Integer localInteger1 = null;
    Calendar localCalendar = Calendar.getInstance(this.k);
    int i1 = 0;
    Integer localInteger2 = null;
    if (i1 < this.b.size())
    {
      f localf = (f)this.b.get(i1);
      if (localInteger2 != null) {
        break label153;
      }
      Iterator localIterator = this.e.iterator();
      for (;;)
      {
        if (localIterator.hasNext()) {
          if (a((Calendar)localIterator.next(), localf))
          {
            localInteger2 = Integer.valueOf(i1);
            label91:
            if ((localInteger2 == null) && (localInteger1 == null) && (a(localCalendar, localf))) {
              localInteger1 = Integer.valueOf(i1);
            }
          }
        }
      }
    }
    label153:
    for (;;)
    {
      i1 += 1;
      break;
      if (localInteger2 != null) {
        a(localInteger2.intValue());
      }
      while (localInteger1 == null) {
        return;
      }
      a(localInteger1.intValue());
      return;
      continue;
      break label91;
    }
  }
  
  private void c()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      locale.setSelected(false);
      if (this.E != null)
      {
        Date localDate = locale.getDate();
        if (this.g == j.c)
        {
          int i1 = this.c.indexOf(locale);
          if ((i1 == 0) || (i1 == this.c.size() - 1)) {
            this.E.onDateUnselected(localDate);
          }
        }
        else
        {
          this.E.onDateUnselected(localDate);
        }
      }
    }
    this.c.clear();
    this.e.clear();
  }
  
  private boolean c(Date paramDate)
  {
    return (this.F == null) || (this.F.isDateSelectable(paramDate));
  }
  
  static void setMidnight(Calendar paramCalendar)
  {
    paramCalendar.set(11, 0);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    paramCalendar.set(14, 0);
  }
  
  List<List<e>> a(f paramf, Calendar paramCalendar)
  {
    Calendar localCalendar1 = Calendar.getInstance(this.k);
    localCalendar1.setTime(paramCalendar.getTime());
    ArrayList localArrayList1 = new ArrayList();
    localCalendar1.set(5, 1);
    int i1 = localCalendar1.get(7);
    int i2 = localCalendar1.getFirstDayOfWeek() - i1;
    i1 = i2;
    if (i2 > 0) {
      i1 = i2 - 7;
    }
    localCalendar1.add(5, i1);
    Calendar localCalendar2 = a(this.e);
    Calendar localCalendar3 = b(this.e);
    if (((localCalendar1.get(2) < paramf.getMonth() + 1) || (localCalendar1.get(1) < paramf.getYear())) && (localCalendar1.get(1) <= paramf.getYear()))
    {
      d.d("Building week row starting at %s", new Object[] { localCalendar1.getTime() });
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1.add(localArrayList2);
      i1 = 0;
      label170:
      Date localDate;
      boolean bool1;
      label199:
      boolean bool2;
      label219:
      boolean bool3;
      label252:
      boolean bool4;
      boolean bool5;
      boolean bool6;
      boolean bool7;
      e.a locala;
      if (i1 < 7)
      {
        localDate = localCalendar1.getTime();
        if (localCalendar1.get(2) != paramf.getMonth()) {
          break label415;
        }
        bool1 = true;
        if ((!bool1) || (!a(this.e, localCalendar1))) {
          break label421;
        }
        bool2 = true;
        if ((!bool1) || (!a(localCalendar1, this.o, this.p)) || (!c(localDate))) {
          break label427;
        }
        bool3 = true;
        bool4 = a(localCalendar1, this.h);
        paramCalendar = (Calendar)this.h.clone();
        paramCalendar.add(5, 1);
        bool5 = a(localCalendar1, paramCalendar);
        paramCalendar = (Calendar)this.h.clone();
        paramCalendar.add(5, 2);
        bool6 = a(localCalendar1, paramCalendar);
        bool7 = a(this.f, localCalendar1);
        i2 = localCalendar1.get(5);
        locala = e.a.a;
        paramCalendar = locala;
        if (this.e.size() > 1)
        {
          if (!a(localCalendar2, localCalendar1)) {
            break label433;
          }
          paramCalendar = e.a.b;
        }
      }
      for (;;)
      {
        localArrayList2.add(new e(localDate, bool1, bool3, bool2, bool4, bool5, bool6, bool7, i2, paramCalendar));
        localCalendar1.add(5, 1);
        i1 += 1;
        break label170;
        break;
        label415:
        bool1 = false;
        break label199;
        label421:
        bool2 = false;
        break label219;
        label427:
        bool3 = false;
        break label252;
        label433:
        if (a(b(this.e), localCalendar1))
        {
          paramCalendar = e.a.d;
        }
        else
        {
          paramCalendar = locala;
          if (a(localCalendar1, localCalendar2, localCalendar3)) {
            paramCalendar = e.a.c;
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public void clearHighlightedDates()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).a(false);
    }
    this.d.clear();
    this.f.clear();
    a();
  }
  
  public void fixDialogDimens()
  {
    d.d("Fixing dimensions to h = %d / w = %d", new Object[] { Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth()) });
    getLayoutParams().height = getMeasuredHeight();
    getLayoutParams().width = getMeasuredWidth();
    post(new Runnable()
    {
      public void run()
      {
        d.d("Dimens are fixed: now scroll to the selected date");
        CalendarPickerView.b(CalendarPickerView.this);
      }
    });
  }
  
  public List<a> getDecorators()
  {
    return this.I;
  }
  
  public List<f> getMonths()
  {
    return this.b;
  }
  
  public Date getSelectedDate()
  {
    if (this.e.size() > 0) {
      return ((Calendar)this.e.get(0)).getTime();
    }
    return null;
  }
  
  public List<Date> getSelectedDates()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((e)localIterator.next()).getDate());
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  public void highlightDates(Collection<Date> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = (Date)paramCollection.next();
      a((Date)localObject);
      g localg = b((Date)localObject);
      if (localg != null)
      {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime((Date)localObject);
        localObject = localg.a;
        this.d.add(localObject);
        this.f.add(localCalendar);
        ((e)localObject).a(true);
      }
    }
    a();
  }
  
  public e init(Date paramDate1, Date paramDate2)
  {
    return init(paramDate1, paramDate2, Locale.getDefault());
  }
  
  public e init(Date paramDate1, Date paramDate2, Locale paramLocale)
  {
    if ((paramDate1 == null) || (paramDate2 == null)) {
      throw new IllegalArgumentException("minDate and maxDate must be non-null.  " + a(paramDate1, paramDate2));
    }
    if (paramDate1.after(paramDate2)) {
      throw new IllegalArgumentException("minDate must be before maxDate.  " + a(paramDate1, paramDate2));
    }
    if (paramLocale == null) {
      throw new IllegalArgumentException("Locale is null.");
    }
    this.k = paramLocale;
    this.h = Calendar.getInstance(paramLocale);
    this.o = Calendar.getInstance(paramLocale);
    this.p = Calendar.getInstance(paramLocale);
    this.q = Calendar.getInstance(paramLocale);
    this.l = new SimpleDateFormat(getContext().getString(2131297173), paramLocale);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      localf.a(this.l.format(localf.getDate()));
    }
    this.m = new SimpleDateFormat(getContext().getString(2131296756), paramLocale);
    this.n = DateFormat.getDateInstance(2, paramLocale);
    this.g = j.a;
    this.e.clear();
    this.c.clear();
    this.f.clear();
    this.d.clear();
    this.j.clear();
    this.b.clear();
    this.o.setTime(paramDate1);
    this.p.setTime(paramDate2);
    setMidnight(this.o);
    setMidnight(this.p);
    this.r = false;
    this.p.add(12, -1);
    this.q.setTime(this.o.getTime());
    int i1 = this.p.get(2);
    int i2 = this.p.get(1);
    while (((this.q.get(2) <= i1) || (this.q.get(1) < i2)) && (this.q.get(1) < i2 + 1))
    {
      paramDate1 = this.q.getTime();
      paramDate1 = new f(this.q.get(2), this.q.get(1), paramDate1, this.l.format(paramDate1));
      this.j.add(a(paramDate1, this.q));
      d.d("Adding month %s", new Object[] { paramDate1 });
      this.b.add(paramDate1);
      this.q.add(2, 1);
    }
    a();
    return new e();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.b.isEmpty()) {
      throw new IllegalStateException("Must have at least one month to display.  Did you forget to call init()?");
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean scrollToDate(Date paramDate)
  {
    boolean bool = false;
    Calendar localCalendar = Calendar.getInstance(this.k);
    localCalendar.setTime(paramDate);
    int i1 = 0;
    if (i1 < this.b.size()) {
      if (!a(localCalendar, (f)this.b.get(i1))) {}
    }
    for (paramDate = Integer.valueOf(i1);; paramDate = null)
    {
      if (paramDate != null)
      {
        a(paramDate.intValue());
        bool = true;
      }
      return bool;
      i1 += 1;
      break;
    }
  }
  
  public boolean selectDate(Date paramDate)
  {
    return selectDate(paramDate, false);
  }
  
  public boolean selectDate(Date paramDate, boolean paramBoolean)
  {
    a(paramDate);
    g localg = b(paramDate);
    boolean bool1;
    if ((localg == null) || (!c(paramDate))) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = a(paramDate, localg.a);
      bool1 = bool2;
    } while (!bool2);
    a(localg.b, paramBoolean);
    return bool2;
  }
  
  public void setCellClickInterceptor(a parama)
  {
    this.H = parama;
  }
  
  public void setCustomDayView(b paramb)
  {
    this.J = paramb;
    if (this.i != null) {
      this.i.notifyDataSetChanged();
    }
  }
  
  public void setDateSelectableFilter(c paramc)
  {
    this.F = paramc;
  }
  
  public void setDateTypeface(Typeface paramTypeface)
  {
    this.A = paramTypeface;
    a();
  }
  
  public void setDecorators(List<a> paramList)
  {
    this.I = paramList;
    if (this.i != null) {
      this.i.notifyDataSetChanged();
    }
  }
  
  public void setOnDateSelectedListener(h paramh)
  {
    this.E = paramh;
  }
  
  public void setOnInvalidDateSelectedListener(i parami)
  {
    this.G = parami;
  }
  
  public void setTitleTypeface(Typeface paramTypeface)
  {
    this.z = paramTypeface;
    a();
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    setTitleTypeface(paramTypeface);
    setDateTypeface(paramTypeface);
  }
  
  public void unfixDialogDimens()
  {
    d.d("Reset the fixed dimensions to allow for re-measurement");
    getLayoutParams().height = -1;
    getLayoutParams().width = -1;
    requestLayout();
  }
  
  public static abstract interface a
  {
    public abstract boolean onCellClicked(Date paramDate);
  }
  
  private class b
    implements MonthView.a
  {
    private b() {}
    
    public void handleClick(e parame)
    {
      Date localDate = parame.getDate();
      if ((CalendarPickerView.d(CalendarPickerView.this) != null) && (CalendarPickerView.d(CalendarPickerView.this).onCellClicked(localDate))) {}
      boolean bool;
      do
      {
        do
        {
          return;
          if ((CalendarPickerView.a(localDate, CalendarPickerView.e(CalendarPickerView.this), CalendarPickerView.f(CalendarPickerView.this))) && (CalendarPickerView.a(CalendarPickerView.this, localDate))) {
            break;
          }
        } while (CalendarPickerView.g(CalendarPickerView.this) == null);
        CalendarPickerView.g(CalendarPickerView.this).onInvalidDateSelected(localDate);
        return;
        bool = CalendarPickerView.a(CalendarPickerView.this, localDate, parame);
      } while (CalendarPickerView.h(CalendarPickerView.this) == null);
      if (bool)
      {
        CalendarPickerView.h(CalendarPickerView.this).onDateSelected(localDate);
        return;
      }
      CalendarPickerView.h(CalendarPickerView.this).onDateUnselected(localDate);
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean isDateSelectable(Date paramDate);
  }
  
  private class d
    implements CalendarPickerView.i
  {
    private d() {}
    
    public void onInvalidDateSelected(Date paramDate)
    {
      paramDate = CalendarPickerView.this.getResources().getString(2131296812, new Object[] { CalendarPickerView.y(CalendarPickerView.this).format(CalendarPickerView.e(CalendarPickerView.this).getTime()), CalendarPickerView.y(CalendarPickerView.this).format(CalendarPickerView.f(CalendarPickerView.this).getTime()) });
      g.textToast(CalendarPickerView.this.getContext(), paramDate);
    }
  }
  
  public class e
  {
    public e() {}
    
    public e displayOnly()
    {
      CalendarPickerView.a(CalendarPickerView.this, true);
      return this;
    }
    
    public e inMode(CalendarPickerView.j paramj)
    {
      CalendarPickerView.this.g = paramj;
      CalendarPickerView.a(CalendarPickerView.this);
      return this;
    }
    
    @SuppressLint({"SimpleDateFormat"})
    public e setShortWeekdays(String[] paramArrayOfString)
    {
      DateFormatSymbols localDateFormatSymbols = new DateFormatSymbols(CalendarPickerView.c(CalendarPickerView.this));
      localDateFormatSymbols.setShortWeekdays(paramArrayOfString);
      CalendarPickerView.a(CalendarPickerView.this, new SimpleDateFormat(CalendarPickerView.this.getContext().getString(2131296756), localDateFormatSymbols));
      return this;
    }
    
    public e withHighlightedDate(Date paramDate)
    {
      return withHighlightedDates(Collections.singletonList(paramDate));
    }
    
    public e withHighlightedDates(Collection<Date> paramCollection)
    {
      CalendarPickerView.this.highlightDates(paramCollection);
      return this;
    }
    
    public e withSelectedDate(Date paramDate)
    {
      return withSelectedDates(Collections.singletonList(paramDate));
    }
    
    public e withSelectedDates(Collection<Date> paramCollection)
    {
      if ((CalendarPickerView.this.g == CalendarPickerView.j.a) && (paramCollection.size() > 1)) {
        throw new IllegalArgumentException("SINGLE mode can't be used with multiple selectedDates");
      }
      if ((CalendarPickerView.this.g == CalendarPickerView.j.c) && (paramCollection.size() > 2)) {
        throw new IllegalArgumentException("RANGE mode only allows two selectedDates.  You tried to pass " + paramCollection.size());
      }
      if (paramCollection != null)
      {
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          Date localDate = (Date)paramCollection.next();
          CalendarPickerView.this.selectDate(localDate);
        }
      }
      CalendarPickerView.b(CalendarPickerView.this);
      CalendarPickerView.a(CalendarPickerView.this);
      return this;
    }
  }
  
  private class f
    extends BaseAdapter
  {
    private final LayoutInflater b = LayoutInflater.from(CalendarPickerView.this.getContext());
    
    private f() {}
    
    public int getCount()
    {
      return CalendarPickerView.this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return CalendarPickerView.this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = (MonthView)paramView;
      if ((paramView == null) || (!paramView.getTag(2131689480).equals(CalendarPickerView.i(CalendarPickerView.this).getClass())))
      {
        paramView = MonthView.create(paramViewGroup, this.b, CalendarPickerView.j(CalendarPickerView.this), CalendarPickerView.this.a, CalendarPickerView.this.h, CalendarPickerView.k(CalendarPickerView.this), CalendarPickerView.l(CalendarPickerView.this), CalendarPickerView.m(CalendarPickerView.this), CalendarPickerView.n(CalendarPickerView.this), CalendarPickerView.o(CalendarPickerView.this), CalendarPickerView.p(CalendarPickerView.this), CalendarPickerView.q(CalendarPickerView.this), CalendarPickerView.c(CalendarPickerView.this), CalendarPickerView.i(CalendarPickerView.this), CalendarPickerView.r(CalendarPickerView.this), CalendarPickerView.s(CalendarPickerView.this), CalendarPickerView.t(CalendarPickerView.this));
        paramView.setTag(2131689480, CalendarPickerView.i(CalendarPickerView.this).getClass());
      }
      for (;;)
      {
        paramView.init((f)CalendarPickerView.this.b.get(paramInt), (List)CalendarPickerView.u(CalendarPickerView.this).get(paramInt), CalendarPickerView.v(CalendarPickerView.this), Typeface.DEFAULT, CalendarPickerView.w(CalendarPickerView.this), CalendarPickerView.n(CalendarPickerView.this), CalendarPickerView.x(CalendarPickerView.this));
        return paramView;
        paramView.setDecorators(CalendarPickerView.q(CalendarPickerView.this));
      }
    }
    
    public boolean isEnabled(int paramInt)
    {
      return false;
    }
  }
  
  private static class g
  {
    public e a;
    public int b;
    
    public g(e parame, int paramInt)
    {
      this.a = parame;
      this.b = paramInt;
    }
  }
  
  public static abstract interface h
  {
    public abstract void onDateSelected(Date paramDate);
    
    public abstract void onDateUnselected(Date paramDate);
  }
  
  public static abstract interface i
  {
    public abstract void onInvalidDateSelected(Date paramDate);
  }
  
  public static enum j
  {
    private j() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/timessquare/CalendarPickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */