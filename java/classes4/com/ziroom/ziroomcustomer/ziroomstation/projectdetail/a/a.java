package com.ziroom.ziroomcustomer.ziroomstation.projectdetail.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.ziroomstation.PhotoPreviewActivity;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.b.a.d;
import java.util.ArrayList;
import java.util.List;

public class a
  extends RecyclerView.a<b>
{
  private Context a;
  private List<b.a.d> b;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public int getItemCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public void onBindViewHolder(final b paramb, int paramInt)
  {
    Object localObject = paramb.b;
    String str;
    if (((b.a.d)this.b.get(paramInt)).getHeaderUrl() == null)
    {
      str = "";
      label28:
      ((SimpleDraweeView)localObject).setController(c.frescoController(str));
      localObject = paramb.d;
      if (!TextUtils.isEmpty(((b.a.d)this.b.get(paramInt)).getNickName())) {
        break label350;
      }
      str = this.a.getResources().getString(2131297472);
      label78:
      ((TextView)localObject).setText(str);
      if ((((b.a.d)this.b.get(paramInt)).getPicUrlsFour() != null) && (((b.a.d)this.b.get(paramInt)).getPicUrlsFour().size() != 0)) {
        break label370;
      }
      paramb.c.setVisibility(8);
      paramb.i.setVisibility(8);
      label145:
      if (!TextUtils.isEmpty(((b.a.d)this.b.get(paramInt)).getEvaluateContent())) {
        break label586;
      }
      paramb.g.setVisibility(8);
    }
    for (;;)
    {
      paramb.h.setVisibility(8);
      paramb.f.setText(((b.a.d)this.b.get(paramInt)).getStar());
      if (!TextUtils.isEmpty(((b.a.d)this.b.get(paramInt)).getStar())) {}
      switch (((b.a.d)this.b.get(paramInt)).getStar().charAt(0))
      {
      default: 
        paramb.j.setImageResource(2130839774);
        paramb.k.setImageResource(2130839774);
        paramb.l.setImageResource(2130839774);
        paramb.m.setImageResource(2130839774);
        paramb.n.setImageResource(2130839774);
        return;
        str = ((b.a.d)this.b.get(paramInt)).getHeaderUrl();
        break label28;
        label350:
        str = ((b.a.d)this.b.get(paramInt)).getNickName();
        break label78;
        label370:
        if (((b.a.d)this.b.get(paramInt)).getPicUrlsFour().size() == 1)
        {
          paramb.c.setVisibility(0);
          paramb.i.setVisibility(8);
          paramb.c.setController(c.frescoController((String)((b.a.d)this.b.get(paramInt)).getPicUrlsFour().get(0)));
          paramb.c.setTag(((b.a.d)this.b.get(paramInt)).getPicUrls().get(0));
          paramb.c.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              Object localObject = (String)paramAnonymousView.getTag();
              paramAnonymousView = new ArrayList();
              paramAnonymousView.add(localObject);
              localObject = new Intent(a.a(a.this), PhotoPreviewActivity.class);
              ((Intent)localObject).putStringArrayListExtra("photoDescription", paramAnonymousView);
              ((Intent)localObject).putExtra("position", 0);
              ((Intent)localObject).putExtra("isDeleteable", false);
              ((Activity)a.a(a.this)).startActivityForResult((Intent)localObject, 257);
            }
          });
          break label145;
        }
        paramb.c.setVisibility(8);
        paramb.i.setVisibility(0);
        paramb.i.setLayoutManager(new GridLayoutManager(this.a, 4, 1, false));
        paramb.i.setAdapter(new a(((b.a.d)this.b.get(paramInt)).getPicUrlsFour(), ((b.a.d)this.b.get(paramInt)).getPicUrls(), this.a));
        break label145;
        label586:
        paramb.g.setVisibility(0);
        paramb.g.setText(((b.a.d)this.b.get(paramInt)).getEvaluateContent());
        paramb.g.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public boolean onPreDraw()
          {
            if (paramb.g.getLineCount() > 3)
            {
              paramb.g.setMaxLines(3);
              paramb.h.setVisibility(0);
              paramb.h.setOnClickListener(new View.OnClickListener()
              {
                @Instrumented
                public void onClick(View paramAnonymous2View)
                {
                  VdsAgent.onClick(this, paramAnonymous2View);
                  a.2.this.a.h.setVisibility(8);
                  a.2.this.a.g.setMaxLines(100);
                }
              });
              paramb.g.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            return true;
          }
        });
      }
    }
    paramb.j.setImageResource(2130839775);
    paramb.k.setImageResource(2130839775);
    paramb.l.setImageResource(2130839775);
    paramb.m.setImageResource(2130839775);
    paramb.n.setImageResource(2130839775);
    return;
    paramb.j.setImageResource(2130839774);
    paramb.k.setImageResource(2130839775);
    paramb.l.setImageResource(2130839775);
    paramb.m.setImageResource(2130839775);
    paramb.n.setImageResource(2130839775);
    return;
    paramb.j.setImageResource(2130839774);
    paramb.k.setImageResource(2130839774);
    paramb.l.setImageResource(2130839775);
    paramb.m.setImageResource(2130839775);
    paramb.n.setImageResource(2130839775);
    return;
    paramb.j.setImageResource(2130839774);
    paramb.k.setImageResource(2130839774);
    paramb.l.setImageResource(2130839774);
    paramb.m.setImageResource(2130839775);
    paramb.n.setImageResource(2130839775);
    return;
    paramb.j.setImageResource(2130839774);
    paramb.k.setImageResource(2130839774);
    paramb.l.setImageResource(2130839774);
    paramb.m.setImageResource(2130839774);
    paramb.n.setImageResource(2130839775);
  }
  
  public b onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.a).inflate(2130904550, paramViewGroup, false));
  }
  
  public void setDatas(List<b.a.d> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  class a
    extends RecyclerView.a<a>
  {
    private ArrayList<String> b = new ArrayList();
    private ArrayList<String> c;
    private Context d;
    
    public a(List<String> paramList, Context paramContext)
    {
      int i = 0;
      while ((paramList != null) && (i < paramList.size()))
      {
        this.b.add(paramList.get(i));
        i += 1;
      }
      this.c = new ArrayList();
      i = j;
      while ((paramContext != null) && (i < paramContext.size()))
      {
        this.c.add(paramContext.get(i));
        i += 1;
      }
      Context localContext;
      this.d = localContext;
    }
    
    public int getItemCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public void onBindViewHolder(a parama, int paramInt)
    {
      Object localObject = new DisplayMetrics();
      ((Activity)this.d).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      int i = (((DisplayMetrics)localObject).widthPixels - n.dip2px(this.d, 103.0F)) / 4;
      localObject = parama.a;
      int j;
      label64:
      SimpleDraweeView localSimpleDraweeView;
      if (i > 0)
      {
        j = i;
        if (i <= 0) {
          break label143;
        }
        ((SimpleDraweeView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(j, i));
        localSimpleDraweeView = parama.a;
        if (this.b.get(paramInt) != null) {
          break label148;
        }
      }
      label143:
      label148:
      for (localObject = "";; localObject = (String)this.b.get(paramInt))
      {
        localSimpleDraweeView.setController(c.frescoController((String)localObject));
        parama.a.setTag(Integer.valueOf(paramInt));
        parama.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (a.a.a(a.a.this) == null) {
              return;
            }
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            paramAnonymousView = new Intent(a.a.b(a.a.this), PhotoPreviewActivity.class);
            paramAnonymousView.putStringArrayListExtra("photoDescription", a.a.c(a.a.this));
            paramAnonymousView.putExtra("position", i);
            paramAnonymousView.putExtra("isDeleteable", false);
            ((Activity)a.a.b(a.a.this)).startActivityForResult(paramAnonymousView, 257);
          }
        });
        return;
        j = -1;
        break;
        i = -1;
        break label64;
      }
    }
    
    public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      return new a(LayoutInflater.from(this.d).inflate(2130904555, paramViewGroup, false));
    }
    
    class a
      extends RecyclerView.u
    {
      SimpleDraweeView a;
      View b;
      
      public a(View paramView)
      {
        super();
        this.b = paramView;
        this.a = ((SimpleDraweeView)paramView.findViewById(2131694859));
      }
    }
  }
  
  class b
    extends RecyclerView.u
  {
    View a;
    SimpleDraweeView b;
    SimpleDraweeView c;
    TextView d;
    TextView e;
    TextView f;
    TextView g;
    View h;
    RecyclerView i;
    ImageView j;
    ImageView k;
    ImageView l;
    ImageView m;
    ImageView n;
    
    public b(View paramView)
    {
      super();
      this.a = paramView;
      this.b = ((SimpleDraweeView)paramView.findViewById(2131695112));
      this.c = ((SimpleDraweeView)paramView.findViewById(2131695743));
      this.d = ((TextView)paramView.findViewById(2131690049));
      this.e = ((TextView)paramView.findViewById(2131689852));
      this.f = ((TextView)paramView.findViewById(2131695740));
      this.g = ((TextView)paramView.findViewById(2131691383));
      this.h = paramView.findViewById(2131695741);
      this.i = ((RecyclerView)paramView.findViewById(2131695742));
      this.j = ((ImageView)paramView.findViewById(2131695735));
      this.k = ((ImageView)paramView.findViewById(2131695736));
      this.l = ((ImageView)paramView.findViewById(2131695737));
      this.m = ((ImageView)paramView.findViewById(2131695738));
      this.n = ((ImageView)paramView.findViewById(2131695739));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/projectdetail/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */