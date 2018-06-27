package com.ziroom.ziroomcustomer.ziroomstation.projectdetail.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.ziroomstation.PhotoPreviewActivity;
import com.ziroom.ziroomcustomer.ziroomstation.model.DaysPrice;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationRoom.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationRoom.DataBean.PriceBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.TypePrice;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b.a.e;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b.a.e.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class b
  extends RecyclerView.a<d>
{
  private List<b.a.e> a;
  private List<c> b;
  private Context c;
  private b d;
  private List<DaysPrice> e;
  private boolean f = true;
  
  public b(Context paramContext, List<b.a.e> paramList, boolean paramBoolean, b paramb)
  {
    this.c = paramContext;
    this.a = paramList;
    this.d = paramb;
    this.f = paramBoolean;
  }
  
  public List<DaysPrice> getBedData()
  {
    return this.e;
  }
  
  public int getItemCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public void onBindViewHolder(d paramd, int paramInt)
  {
    b.a.e locale = (b.a.e)this.a.get(paramInt);
    paramd.m.setText(locale.getHouseShowName());
    c localc = (c)this.b.get(paramInt);
    localc.bindPosition(paramInt);
    paramd.i.setAdapter(localc);
    Object localObject1;
    double d1;
    label158:
    label298:
    label316:
    int i;
    if (localc.isFull())
    {
      paramd.p.setVisibility(0);
      paramd.p.setText("当日满房");
      paramd.p.setBackgroundResource(2130839551);
      paramd.p.setTextColor(-6710887);
      localObject1 = paramd.o;
      Object localObject2 = new StringBuilder().append("¥");
      if (((c)this.b.get(paramInt)).getBedMinPrice() <= 0.0D) {
        break label449;
      }
      d1 = ((c)this.b.get(paramInt)).getBedMinPrice();
      ((TextView)localObject1).setText((int)d1);
      paramd.d.setTag(Integer.valueOf(paramInt));
      paramd.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          ((b.a.e)b.a(b.this).get(i)).a = false;
          b.this.notifyItemChanged(i);
        }
      });
      paramd.g.setTag(Integer.valueOf(paramInt));
      paramd.g.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = (b.a.e)b.a(b.this).get(i);
          if (!((b.a.e)b.a(b.this).get(i)).a) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.a = bool;
            b.this.notifyItemChanged(i);
            return;
          }
        }
      });
      paramd.n.setText(locale.getLableStr());
      if (!locale.a) {
        break label469;
      }
      paramd.c.setVisibility(0);
      paramd.f.setVisibility(8);
      paramd.h.setVisibility(0);
      paramd.n.setMaxLines(2);
      if (paramd.n.getLineCount() <= 1) {
        break label458;
      }
      paramd.e.setVisibility(8);
      localObject2 = paramd.l;
      if (locale.getUrl() != null) {
        break label514;
      }
      localObject1 = "0张";
      ((TextView)localObject2).setText((CharSequence)localObject1);
      i = localc.getBedCount();
      if (i != 0) {
        break label547;
      }
      paramd.k.setVisibility(8);
    }
    for (;;)
    {
      c.loadHolderImage(paramd.j, locale.getHeaderUrl());
      paramd.j.setTag(Integer.valueOf(paramInt));
      paramd.j.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int j = ((Integer)paramAnonymousView.getTag()).intValue();
          paramAnonymousView = new ArrayList();
          int i = 0;
          while ((((b.a.e)b.a(b.this).get(j)).getUrl() != null) && (i < ((b.a.e)b.a(b.this).get(j)).getUrl().size()))
          {
            paramAnonymousView.add(((b.a.e)b.a(b.this).get(j)).getUrl().get(i));
            i += 1;
          }
          if (paramAnonymousView.size() > 0)
          {
            Intent localIntent = new Intent(b.b(b.this), PhotoPreviewActivity.class);
            localIntent.putStringArrayListExtra("photoDescription", paramAnonymousView);
            localIntent.putExtra("position", 0);
            localIntent.putExtra("isDeleteable", false);
            ((Activity)b.b(b.this)).startActivityForResult(localIntent, 257);
          }
        }
      });
      return;
      if (localc.isShortage())
      {
        paramd.p.setVisibility(0);
        paramd.p.setText("床位紧张");
        paramd.p.setBackgroundResource(2130839583);
        paramd.p.setTextColor(-40350);
        break;
      }
      paramd.p.setVisibility(8);
      paramd.p.setText(null);
      break;
      label449:
      d1 = locale.getPriceMin();
      break label158;
      label458:
      paramd.e.setVisibility(4);
      break label298;
      label469:
      paramd.c.setVisibility(8);
      paramd.e.setVisibility(0);
      paramd.f.setVisibility(0);
      paramd.h.setVisibility(8);
      paramd.n.setMaxLines(1);
      break label298;
      label514:
      localObject1 = locale.getUrl().size() + "张";
      break label316;
      label547:
      paramd.k.setVisibility(0);
      paramd.k.setText(String.valueOf(i));
    }
  }
  
  public d onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new d(LayoutInflater.from(this.c).inflate(2130904552, paramViewGroup, false));
  }
  
  public void setRoomData(List<b.a.e> paramList, boolean paramBoolean)
  {
    this.a = paramList;
    this.f = paramBoolean;
    this.e = null;
    this.b = new ArrayList();
    int i = 0;
    while ((this.a != null) && (i < this.a.size()))
    {
      paramList = new c(this.c);
      paramList.setDataFromRoom(((b.a.e)this.a.get(i)).getStockDtos());
      this.b.add(paramList);
      i += 1;
    }
    if ((this.a != null) && (this.a.size() > 0)) {
      ((b.a.e)this.a.get(0)).a = true;
    }
    notifyDataSetChanged();
  }
  
  public void updateBedData(List<StationRoom.DataBean> paramList, Calendar paramCalendar1, Calendar paramCalendar2, boolean paramBoolean)
  {
    int k = 0;
    int m;
    int i;
    if (this.e == null)
    {
      this.e = new ArrayList();
      this.f = paramBoolean;
      m = (int)m.getDaysBetween(new Date(paramCalendar1.getTimeInMillis()), new Date(paramCalendar2.getTimeInMillis()));
      paramCalendar1 = (Calendar)paramCalendar1.clone();
      i = 0;
    }
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break label341;
      }
      paramCalendar2 = new DaysPrice();
      paramCalendar2.dayDate = new Date(paramCalendar1.getTimeInMillis());
      paramCalendar2.typePriceList = new ArrayList();
      j = 0;
      for (;;)
      {
        if (j < paramList.size())
        {
          TypePrice localTypePrice = new TypePrice();
          localTypePrice.typeName = ((StationRoom.DataBean)paramList.get(j)).houseShowName;
          List localList = ((StationRoom.DataBean)paramList.get(j)).price;
          if ((localList != null) && (i < localList.size()))
          {
            localTypePrice.typePrice = ((StationRoom.DataBean.PriceBean)localList.get(i)).price;
            localTypePrice.availableCount = ((StationRoom.DataBean)paramList.get(j)).availableCount;
            localTypePrice.houseTypeBid = ((StationRoom.DataBean)paramList.get(j)).houseTypeBid;
            localTypePrice.minPrice = ((StationRoom.DataBean)paramList.get(j)).minPrice;
            localTypePrice.maxPrice = ((StationRoom.DataBean)paramList.get(j)).maxPrice;
            paramCalendar2.typePriceList.add(localTypePrice);
          }
          j += 1;
          continue;
          this.e.clear();
          break;
        }
      }
      this.e.add(paramCalendar2);
      paramCalendar1.add(5, 1);
      i += 1;
    }
    label341:
    while (j < this.b.size())
    {
      ((c)this.b.get(j)).setDataFromBed();
      j += 1;
    }
    notifyDataSetChanged();
  }
  
  private class a
  {
    String a;
    String b;
    int c;
    int d;
    double e;
    String f;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void onOtherBedSelect(String paramString1, String paramString2, String paramString3);
    
    public abstract void onSelect();
    
    public abstract void shouldSelectTime();
  }
  
  private class c
    extends RecyclerView.a<a>
  {
    private List<b.a> b;
    private Context c;
    private boolean d;
    private boolean e;
    private int f;
    private double g = -1.0D;
    
    public c(Context paramContext)
    {
      this.c = paramContext;
    }
    
    public void bindPosition(int paramInt)
    {
      this.f = paramInt;
    }
    
    public int getBedCount()
    {
      Iterator localIterator = this.b.iterator();
      for (int i = 0; localIterator.hasNext(); i = ((b.a)localIterator.next()).d + i) {}
      return i;
    }
    
    public double getBedMinPrice()
    {
      return this.g;
    }
    
    public int getItemCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public boolean isFull()
    {
      return this.d;
    }
    
    public boolean isShortage()
    {
      return this.e;
    }
    
    public void onBindViewHolder(a parama, int paramInt)
    {
      b.a locala = (b.a)this.b.get(paramInt);
      parama.c.setText(locala.a);
      parama.d.setText(locala.f);
      parama.a.setTag(Integer.valueOf(paramInt));
      parama.b.setTag(Integer.valueOf(paramInt));
      parama.e.setText(null);
      if (b.d(b.this))
      {
        if (b.c(b.this) == null)
        {
          parama.f.setText("0");
          parama.g.setVisibility(0);
          parama.h.setVisibility(8);
          parama.h.setOnClickListener(null);
          parama.a.setImageResource(2130838054);
          parama.b.setImageResource(2130838057);
        }
        for (;;)
        {
          parama.a.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              if (b.e(b.this) != null) {
                b.e(b.this).shouldSelectTime();
              }
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = (b.a)b.c.b(b.c.this).get(i);
              if (paramAnonymousView.d < paramAnonymousView.c)
              {
                paramAnonymousView.d += 1;
                b.c.this.notifyItemChanged(i);
                b.this.notifyItemChanged(b.c.a(b.c.this));
                i = 0;
                while ((b.c(b.this) != null) && (b.c(b.this).size() > 0) && (i < ((DaysPrice)b.c(b.this).get(0)).typePriceList.size()))
                {
                  if (paramAnonymousView.b.equals(((TypePrice)((DaysPrice)b.c(b.this).get(0)).typePriceList.get(i)).houseTypeBid))
                  {
                    int j = 0;
                    while (j < b.c(b.this).size())
                    {
                      ((TypePrice)((DaysPrice)b.c(b.this).get(j)).typePriceList.get(i)).num = paramAnonymousView.d;
                      if ((b.a(b.this) != null) && (b.a(b.this).size() > b.c.a(b.c.this))) {
                        ((TypePrice)((DaysPrice)b.c(b.this).get(j)).typePriceList.get(i)).roomName = ((b.a.e)b.a(b.this).get(b.c.a(b.c.this))).getHouseShowName();
                      }
                      j += 1;
                    }
                  }
                  i += 1;
                }
                b.e(b.this).onSelect();
              }
            }
          });
          parama.b.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              int j = 0;
              VdsAgent.onClick(this, paramAnonymousView);
              if (b.e(b.this) != null) {
                b.e(b.this).shouldSelectTime();
              }
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = (b.a)b.c.b(b.c.this).get(i);
              if (paramAnonymousView.d > 0)
              {
                paramAnonymousView.d -= 1;
                b.c.this.notifyItemChanged(i);
                b.this.notifyItemChanged(b.c.a(b.c.this));
                i = 0;
                while ((b.c(b.this) != null) && (b.c(b.this).size() > 0) && (i < ((DaysPrice)b.c(b.this).get(0)).typePriceList.size()))
                {
                  if (paramAnonymousView.b.equals(((TypePrice)((DaysPrice)b.c(b.this).get(0)).typePriceList.get(i)).houseTypeBid)) {
                    while (j < b.c(b.this).size())
                    {
                      ((TypePrice)((DaysPrice)b.c(b.this).get(j)).typePriceList.get(i)).num = paramAnonymousView.d;
                      j += 1;
                    }
                  }
                  i += 1;
                }
                b.e(b.this).onSelect();
              }
            }
          });
          return;
          if (locala.c == 0)
          {
            parama.g.setVisibility(8);
            parama.h.setVisibility(0);
            parama.h.setTag(locala);
            parama.h.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                paramAnonymousView = (b.a)paramAnonymousView.getTag();
                if ((paramAnonymousView != null) && (b.e(b.this) != null) && (b.a(b.this) != null) && (b.a(b.this).size() > b.c.a(b.c.this))) {
                  b.e(b.this).onOtherBedSelect(paramAnonymousView.b, ((b.a.e)b.a(b.this).get(b.c.a(b.c.this))).getHouseShowName(), paramAnonymousView.a);
                }
              }
            });
            parama.e.setText("当日满房");
            parama.e.setBackgroundResource(2130839551);
            parama.e.setTextColor(-6710887);
          }
          else
          {
            parama.g.setVisibility(0);
            parama.h.setVisibility(8);
            parama.h.setOnClickListener(null);
            parama.f.setText(locala.d + "");
            if (locala.c < 4)
            {
              parama.e.setText("床位紧张");
              parama.e.setBackgroundResource(2130839583);
              parama.e.setTextColor(-40350);
            }
            if (locala.d == 0)
            {
              parama.a.setImageResource(2130838054);
              parama.b.setImageResource(2130838057);
            }
            else if (locala.d < locala.c)
            {
              parama.a.setImageResource(2130838054);
              parama.b.setImageResource(2130838056);
            }
            else
            {
              parama.a.setImageResource(2130838055);
              parama.b.setImageResource(2130838056);
            }
          }
        }
      }
      parama.f.setText("0");
      parama.g.setVisibility(0);
      parama.h.setVisibility(8);
      parama.h.setOnClickListener(null);
      parama.a.setImageResource(2130838055);
      parama.b.setImageResource(2130838057);
      parama.a.setOnClickListener(null);
      parama.b.setOnClickListener(null);
    }
    
    public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      return new a(LayoutInflater.from(this.c).inflate(2130904549, paramViewGroup, false));
    }
    
    public void setDataFromBed()
    {
      int k = 0;
      int i = 0;
      int j = 0;
      double d1 = Double.MAX_VALUE;
      int m;
      label29:
      String str;
      if (k < this.b.size())
      {
        m = 0;
        if ((b.c(b.this) == null) || (b.c(b.this).size() <= 0) || (m >= ((DaysPrice)b.c(b.this).get(0)).typePriceList.size())) {
          break label658;
        }
        if (((b.a)this.b.get(k)).b.equals(((TypePrice)((DaysPrice)b.c(b.this).get(0)).typePriceList.get(m)).houseTypeBid))
        {
          ((b.a)this.b.get(k)).d = 0;
          ((b.a)this.b.get(k)).c = ((TypePrice)((DaysPrice)b.c(b.this).get(0)).typePriceList.get(m)).availableCount;
          ((b.a)this.b.get(k)).e = ((TypePrice)((DaysPrice)b.c(b.this).get(0)).typePriceList.get(m)).typePrice;
          b.a locala = (b.a)this.b.get(k);
          if (((TypePrice)((DaysPrice)b.c(b.this).get(0)).typePriceList.get(m)).minPrice == ((TypePrice)((DaysPrice)b.c(b.this).get(0)).typePriceList.get(m)).maxPrice)
          {
            str = "¥" + (int)((TypePrice)((DaysPrice)b.c(b.this).get(0)).typePriceList.get(m)).minPrice + "/床";
            label398:
            locala.f = str;
            d1 = Math.min(d1, ((b.a)this.b.get(k)).e);
            i += ((b.a)this.b.get(k)).c;
            if (((b.a)this.b.get(k)).c >= 4) {
              break label652;
            }
            this.e = true;
            j = 1;
          }
        }
      }
      label652:
      label658:
      for (;;)
      {
        k += 1;
        break;
        str = "¥" + (int)((TypePrice)((DaysPrice)b.c(b.this).get(0)).typePriceList.get(m)).minPrice + "/床-¥" + (int)((TypePrice)((DaysPrice)b.c(b.this).get(0)).typePriceList.get(m)).maxPrice + "/床";
        break label398;
        m += 1;
        break label29;
        if ((j != 0) && (i == 0)) {}
        for (boolean bool = true;; bool = false)
        {
          this.d = bool;
          if (d1 != Double.MAX_VALUE) {
            this.g = d1;
          }
          notifyDataSetChanged();
          b.this.notifyItemChanged(this.f);
          return;
        }
        j = 1;
      }
    }
    
    public void setDataFromRoom(List<b.a.e.a> paramList)
    {
      this.b = new ArrayList();
      int i = 0;
      while ((paramList != null) && (i < paramList.size()))
      {
        b.a locala = new b.a(b.this, null);
        locala.c = ((b.a.e.a)paramList.get(i)).getBedCount();
        locala.b = ((b.a.e.a)paramList.get(i)).getHouseTypeBid();
        locala.a = ((b.a.e.a)paramList.get(i)).getHouseShowName();
        locala.e = ((b.a.e.a)paramList.get(i)).getAveragePrice();
        locala.f = ("¥" + (int)((b.a.e.a)paramList.get(i)).getAveragePrice() + "/床");
        this.b.add(locala);
        i += 1;
      }
      this.d = false;
      this.e = false;
      notifyDataSetChanged();
    }
    
    class a
      extends RecyclerView.u
    {
      ImageView a;
      ImageView b;
      TextView c;
      TextView d;
      TextView e;
      TextView f;
      View g;
      View h;
      View i;
      
      public a(View paramView)
      {
        super();
        this.i = paramView;
        this.g = paramView.findViewById(2131695729);
        this.h = paramView.findViewById(2131695733);
        this.a = ((ImageView)paramView.findViewById(2131695732));
        this.b = ((ImageView)paramView.findViewById(2131695730));
        this.c = ((TextView)paramView.findViewById(2131695726));
        this.d = ((TextView)paramView.findViewById(2131695728));
        this.e = ((TextView)paramView.findViewById(2131695727));
        this.f = ((TextView)paramView.findViewById(2131695731));
      }
    }
  }
  
  class d
    extends RecyclerView.u
  {
    View a;
    View b;
    View c;
    View d;
    View e;
    View f;
    View g;
    View h;
    RecyclerView i;
    SimpleDraweeView j;
    TextView k;
    TextView l;
    TextView m;
    TextView n;
    TextView o;
    TextView p;
    
    public d(View paramView)
    {
      super();
      this.a = paramView;
      this.b = paramView.findViewById(2131695753);
      this.c = paramView.findViewById(2131695755);
      this.d = paramView.findViewById(2131695757);
      this.i = ((RecyclerView)paramView.findViewById(2131695756));
      this.j = ((SimpleDraweeView)paramView.findViewById(2131695744));
      this.k = ((TextView)paramView.findViewById(2131695748));
      this.l = ((TextView)paramView.findViewById(2131695747));
      this.m = ((TextView)paramView.findViewById(2131694290));
      this.n = ((TextView)paramView.findViewById(2131690016));
      this.o = ((TextView)paramView.findViewById(2131694211));
      this.p = ((TextView)paramView.findViewById(2131695752));
      this.e = paramView.findViewById(2131695750);
      this.g = paramView.findViewById(2131695749);
      this.f = paramView.findViewById(2131695754);
      this.h = paramView.findViewById(2131693860);
      this.i.setLayoutManager(new LinearLayoutManager(b.b(b.this), 1, false));
      this.i.setFocusable(false);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/projectdetail/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */