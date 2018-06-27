package com.ziroom.ziroomcustomer.minsu.landlordrelease.view;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLCalendarDayInfoBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLCalendarOrderBean;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarCellView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView;
import com.ziroom.ziroomcustomer.util.m;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

public class a
  implements com.ziroom.ziroomcustomer.minsu.view.timessquare.a
{
  private CalendarPickerView a;
  private Map<String, LLCalendarDayInfoBean> b = new ArrayMap();
  private Date c;
  private Activity d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  private final int n;
  private final int o;
  private final int p;
  private final Drawable q;
  private final Drawable r;
  private final Drawable s;
  private final Drawable t;
  private final Drawable u;
  private final Drawable v;
  private final Drawable w;
  private final Drawable x;
  private final Drawable y;
  
  public a(Activity paramActivity, Map<String, LLCalendarDayInfoBean> paramMap, Date paramDate, CalendarPickerView paramCalendarPickerView)
  {
    this.a = paramCalendarPickerView;
    if (paramMap != null)
    {
      this.b.clear();
      this.b.putAll(paramMap);
    }
    this.c = paramDate;
    this.d = paramActivity;
    this.e = ContextCompat.getColor(ApplicationEx.c, 2131624583);
    this.f = ContextCompat.getColor(ApplicationEx.c, 2131624583);
    this.g = ContextCompat.getColor(ApplicationEx.c, 2131624583);
    this.h = ContextCompat.getColor(ApplicationEx.c, 2131624583);
    this.i = ContextCompat.getColor(ApplicationEx.c, 2131624081);
    this.j = ContextCompat.getColor(ApplicationEx.c, 2131624097);
    this.k = ContextCompat.getColor(ApplicationEx.c, 2131624046);
    this.l = ContextCompat.getColor(ApplicationEx.c, 2131624046);
    this.m = ContextCompat.getColor(ApplicationEx.c, 2131624475);
    this.n = ContextCompat.getColor(ApplicationEx.c, 2131624475);
    this.o = ContextCompat.getColor(ApplicationEx.c, 2131624046);
    this.p = ContextCompat.getColor(ApplicationEx.c, 2131624046);
    this.r = ContextCompat.getDrawable(ApplicationEx.c, 2130837709);
    this.s = ContextCompat.getDrawable(ApplicationEx.c, 2130837715);
    this.t = ContextCompat.getDrawable(ApplicationEx.c, 2130837718);
    this.q = ContextCompat.getDrawable(ApplicationEx.c, 2130837712);
    this.u = ContextCompat.getDrawable(ApplicationEx.c, 2130837710);
    this.v = ContextCompat.getDrawable(ApplicationEx.c, 2130837716);
    this.w = ContextCompat.getDrawable(ApplicationEx.c, 2130837719);
    this.x = ContextCompat.getDrawable(ApplicationEx.c, 2130837713);
    this.y = ContextCompat.getDrawable(ApplicationEx.c, 2130837711);
  }
  
  private void a(CalendarCellView paramCalendarCellView)
  {
    paramCalendarCellView.getDayOfMonthTextView().setText("");
    paramCalendarCellView.findViewById(2131689912).setVisibility(4);
    paramCalendarCellView.findViewById(2131695296).setVisibility(4);
    paramCalendarCellView.findViewById(2131695295).setVisibility(4);
    paramCalendarCellView.findViewById(2131695218).setVisibility(4);
    a(paramCalendarCellView, false);
  }
  
  private void a(CalendarCellView paramCalendarCellView, Date paramDate)
  {
    if (this.b == null) {}
    Object localObject1;
    final View localView;
    Object localObject2;
    label254:
    label343:
    TextView localTextView;
    label528:
    label534:
    label545:
    label552:
    label565:
    label571:
    label580:
    do
    {
      return;
      localObject1 = b(paramDate);
      LLCalendarDayInfoBean localLLCalendarDayInfoBean = (LLCalendarDayInfoBean)this.b.get(localObject1);
      if (localLLCalendarDayInfoBean == null)
      {
        a(paramCalendarCellView);
        return;
      }
      if (!paramCalendarCellView.isCurrentMonth()) {
        break;
      }
      paramCalendarCellView.findViewById(2131695218).setVisibility(0);
      paramCalendarCellView.findViewById(2131689912).setVisibility(0);
      float f1;
      final int i1;
      if (!TextUtils.isEmpty(localLLCalendarDayInfoBean.getHoliday()))
      {
        paramCalendarCellView.getDayOfMonthTextView().setTextSize(12.0F);
        paramCalendarCellView.getDayOfMonthTextView().setText(localLLCalendarDayInfoBean.getHoliday());
        if ((localLLCalendarDayInfoBean == null) || (TextUtils.isEmpty(localLLCalendarDayInfoBean.getIsWorkDay()))) {
          break label552;
        }
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(getClass().getSimpleName(), " 休息日 " + (String)localObject1);
        localView = paramCalendarCellView.findViewById(2131695296);
        localView.setVisibility(0);
        localObject2 = (FrameLayout.LayoutParams)localView.getLayoutParams();
        f1 = ab.length(paramCalendarCellView.getDayOfMonthTextView(), paramCalendarCellView.getDayOfMonthTextView().getText().toString());
        final int i2 = b.getScreenWidth(ApplicationEx.c) / 7;
        f1 = (i2 - f1) / 2.0F;
        if (f1 <= 15.0F) {
          break label545;
        }
        if (paramCalendarCellView.getDayOfMonthTextView().getText().toString().length() <= 2) {
          break label534;
        }
        if ((int)(f1 - 25.0F) < 0) {
          break label528;
        }
        i1 = (int)(f1 - 25.0F);
        final int i3 = ab.dp2px(ApplicationEx.c, 5.0F);
        localView.post(new Runnable()
        {
          public void run()
          {
            localView.layout(i2 - i1 - localView.getMeasuredWidth(), i3, i2 - i1, localView.getMeasuredHeight() + i3);
          }
        });
        paramCalendarCellView.postInvalidate();
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(getClass().getSimpleName(), " 休息日 " + (String)localObject1 + " mt = " + i3 + "  mr = " + i1);
        localObject1 = localLLCalendarDayInfoBean.getLandCalenderOrder();
        localView = paramCalendarCellView.findViewById(2131695218);
        localTextView = (TextView)paramCalendarCellView.findViewById(2131689912);
        localObject2 = (SimpleDraweeView)paramCalendarCellView.findViewById(2131695295);
        localTextView.setText("¥" + ad.getPriceInt(localLLCalendarDayInfoBean.getPrice()));
        if ((localLLCalendarDayInfoBean.getStatus() != 3) && (localLLCalendarDayInfoBean.getStatus() != 2)) {
          break label565;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        a(paramCalendarCellView, bool);
        if ((localLLCalendarDayInfoBean.getStatus() != 3) && (localLLCalendarDayInfoBean.getStatus() != 2)) {
          break label580;
        }
        localView.setBackgroundColor(ContextCompat.getColor(ApplicationEx.c, 2131624576));
        paramCalendarCellView.getDayOfMonthTextView().setTextColor(this.o);
        localTextView.setTextColor(this.p);
        ((SimpleDraweeView)localObject2).setVisibility(4);
        if (!paramCalendarCellView.isSelected()) {
          break label571;
        }
        localView.setBackground(this.y);
        return;
        paramCalendarCellView.getDayOfMonthTextView().setTextSize(14.0F);
        break;
        i1 = 0;
        break label254;
        i1 = (int)(f1 - 25.0F);
        break label254;
        i1 = 10;
        break label254;
        paramCalendarCellView.findViewById(2131695296).setVisibility(4);
        break label343;
      }
      localView.setBackgroundResource(2131624576);
      return;
      if (localLLCalendarDayInfoBean.getStatus() == 1)
      {
        if (localObject1 != null)
        {
          if ((((LLCalendarOrderBean)localObject1).getIsCheckOutRent() != null) && (((LLCalendarOrderBean)localObject1).getIsCheckOutRent().intValue() == 0))
          {
            if ((((LLCalendarOrderBean)localObject1).getStartSign() != null) && (((LLCalendarOrderBean)localObject1).getStartSign().intValue() == 1) && (((LLCalendarOrderBean)localObject1).getEndSign() != null) && (((LLCalendarOrderBean)localObject1).getEndSign().intValue() == 1))
            {
              paramDate = ((SimpleDraweeView)localObject2).getTag(2131689523);
              if ((paramDate == null) || (!(paramDate + "").equals(((LLCalendarOrderBean)localObject1).getUserPicUrl())))
              {
                ((SimpleDraweeView)localObject2).setVisibility(0);
                ((SimpleDraweeView)localObject2).setHierarchy(d.getRoundingHierarchy(this.d));
                ((SimpleDraweeView)localObject2).setController(c.frescoController(((LLCalendarOrderBean)localObject1).getUserPicUrl()));
                ((SimpleDraweeView)localObject2).setTag(2131689523, ((LLCalendarOrderBean)localObject1).getUserPicUrl());
              }
              ((SimpleDraweeView)localObject2).setVisibility(0);
              localView.setBackground(this.q);
            }
            for (;;)
            {
              localTextView.setTextColor(this.f);
              paramCalendarCellView.getDayOfMonthTextView().setTextColor(this.e);
              return;
              if ((((LLCalendarOrderBean)localObject1).getStartSign() != null) && (((LLCalendarOrderBean)localObject1).getStartSign().intValue() == 1))
              {
                paramDate = ((SimpleDraweeView)localObject2).getTag(2131689523);
                if ((paramDate == null) || (!(paramDate + "").equals(((LLCalendarOrderBean)localObject1).getUserPicUrl())))
                {
                  ((SimpleDraweeView)localObject2).setVisibility(0);
                  ((SimpleDraweeView)localObject2).setHierarchy(d.getRoundingHierarchy(this.d));
                  ((SimpleDraweeView)localObject2).setController(c.frescoController(((LLCalendarOrderBean)localObject1).getUserPicUrl()));
                  ((SimpleDraweeView)localObject2).setTag(2131689523, ((LLCalendarOrderBean)localObject1).getUserPicUrl());
                }
                ((SimpleDraweeView)localObject2).setVisibility(0);
                localView.setBackground(this.r);
              }
              else if ((((LLCalendarOrderBean)localObject1).getEndSign() != null) && (((LLCalendarOrderBean)localObject1).getEndSign().intValue() == 1))
              {
                ((SimpleDraweeView)localObject2).setVisibility(4);
                localView.setBackground(this.t);
              }
              else
              {
                ((SimpleDraweeView)localObject2).setVisibility(4);
                localView.setBackground(this.s);
              }
            }
          }
          localTextView.setTextColor(this.h);
          paramCalendarCellView.getDayOfMonthTextView().setTextColor(this.g);
          if ((((LLCalendarOrderBean)localObject1).getStartSign() != null) && (((LLCalendarOrderBean)localObject1).getStartSign().intValue() == 1) && (((LLCalendarOrderBean)localObject1).getEndSign() != null) && (((LLCalendarOrderBean)localObject1).getEndSign().intValue() == 1))
          {
            paramCalendarCellView = ((SimpleDraweeView)localObject2).getTag(2131689523);
            if ((paramCalendarCellView == null) || (!(paramCalendarCellView + "").equals(((LLCalendarOrderBean)localObject1).getUserPicUrl())))
            {
              ((SimpleDraweeView)localObject2).setVisibility(0);
              ((SimpleDraweeView)localObject2).setHierarchy(d.getRoundingHierarchy(this.d));
              ((SimpleDraweeView)localObject2).setController(c.frescoController(((LLCalendarOrderBean)localObject1).getUserPicUrl()));
              ((SimpleDraweeView)localObject2).setTag(2131689523, ((LLCalendarOrderBean)localObject1).getUserPicUrl());
            }
            ((SimpleDraweeView)localObject2).setVisibility(0);
            localView.setBackground(this.x);
            return;
          }
          if ((((LLCalendarOrderBean)localObject1).getStartSign() != null) && (((LLCalendarOrderBean)localObject1).getStartSign().intValue() == 1))
          {
            paramCalendarCellView = ((SimpleDraweeView)localObject2).getTag(2131689523);
            if ((paramCalendarCellView == null) || (!(paramCalendarCellView + "").equals(((LLCalendarOrderBean)localObject1).getUserPicUrl())))
            {
              ((SimpleDraweeView)localObject2).setVisibility(0);
              ((SimpleDraweeView)localObject2).setHierarchy(d.getRoundingHierarchy(this.d));
              ((SimpleDraweeView)localObject2).setController(c.frescoController(((LLCalendarOrderBean)localObject1).getUserPicUrl()));
              ((SimpleDraweeView)localObject2).setTag(2131689523, ((LLCalendarOrderBean)localObject1).getUserPicUrl());
            }
            ((SimpleDraweeView)localObject2).setVisibility(0);
            localView.setBackground(this.u);
            return;
          }
          if ((((LLCalendarOrderBean)localObject1).getEndSign() != null) && (((LLCalendarOrderBean)localObject1).getEndSign().intValue() == 1))
          {
            ((SimpleDraweeView)localObject2).setVisibility(4);
            localView.setBackground(this.w);
            return;
          }
          ((SimpleDraweeView)localObject2).setVisibility(4);
          localView.setBackground(this.v);
          return;
        }
        paramCalendarCellView.getDayOfMonthTextView().setTextColor(this.k);
        localTextView.setTextColor(this.l);
        localView.setBackgroundResource(2131624576);
        ((SimpleDraweeView)localObject2).setVisibility(4);
        return;
      }
      if ((paramDate.after(this.c)) || (m.equalsIngoreHMS(this.c, paramDate)))
      {
        ((SimpleDraweeView)localObject2).setVisibility(4);
        if (a(paramDate))
        {
          paramCalendarCellView.getDayOfMonthTextView().setTextColor(this.m);
          localTextView.setTextColor(this.n);
        }
        while (paramCalendarCellView.isSelected())
        {
          localView.setBackground(this.y);
          return;
          paramCalendarCellView.getDayOfMonthTextView().setTextColor(this.i);
          localTextView.setTextColor(this.j);
        }
        localView.setBackgroundResource(2131624576);
        return;
      }
    } while (!paramDate.before(this.c));
    ((SimpleDraweeView)localObject2).setVisibility(4);
    localView.setBackgroundResource(2131624576);
    localTextView.setTextColor(this.l);
    paramCalendarCellView.getDayOfMonthTextView().setTextColor(this.k);
    return;
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i(getClass().getSimpleName(), " 非本月 " + (String)localObject1);
    a(paramCalendarCellView);
  }
  
  private void a(CalendarCellView paramCalendarCellView, boolean paramBoolean)
  {
    if ((paramCalendarCellView == null) || (paramCalendarCellView.getDayOfMonthTextView() == null)) {
      return;
    }
    View localView = paramCalendarCellView.findViewById(2131695294);
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 4)
    {
      localView.setVisibility(i1);
      paramCalendarCellView.postInvalidate();
      return;
    }
  }
  
  private boolean a(Date paramDate)
  {
    GregorianCalendar localGregorianCalendar = (GregorianCalendar)GregorianCalendar.getInstance();
    localGregorianCalendar.setTime(paramDate);
    return (localGregorianCalendar.get(7) == 1) || (7 == localGregorianCalendar.get(7));
  }
  
  private String b(Date paramDate)
  {
    return m.getFormatDate(paramDate, m.b);
  }
  
  public void decorate(CalendarCellView paramCalendarCellView, Date paramDate)
  {
    a(paramCalendarCellView, paramDate);
    paramCalendarCellView.setBackgroundResource(2131624349);
  }
  
  public Map<String, LLCalendarDayInfoBean> getDataMap()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */