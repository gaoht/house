package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newclean.d.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AcarusKillingProjectActivity
  extends BaseActivity
{
  private String a;
  private List<com.ziroom.ziroomcustomer.newclean.d.a> b = new ArrayList();
  @BindView(2131689843)
  Button btn_commit;
  private List<com.ziroom.ziroomcustomer.newclean.d.a> c = new ArrayList();
  private int d = 0;
  private Context e;
  private a f;
  private b g;
  @BindView(2131689842)
  ImageView iv_all_price;
  @BindView(2131689492)
  ImageView iv_back;
  @BindView(2131689839)
  LinearLayout ll_show_money;
  @BindView(2131689844)
  ListView lv_project;
  private int r = 0;
  private int s = 200;
  @BindView(2131689841)
  TextView tv_all_price;
  @BindView(2131689837)
  TextView tv_tip;
  @BindView(2131689840)
  TextView tv_unit;
  
  private void a()
  {
    this.a = getIntent().getStringExtra("serviceInfoId");
    List localList = (List)getIntent().getExtras().getSerializable("shoppingList");
    this.c.clear();
    this.btn_commit.setEnabled(false);
    if ((localList != null) && (localList.size() > 0))
    {
      this.c = localList;
      a(this.c);
    }
    this.f = new a(this);
    this.lv_project.setAdapter(this.f);
    n.getAcarusLKillingProject(this, this.a, new com.ziroom.ziroomcustomer.e.a.a(this.e, new m(b.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this, paramAnonymousb);
        if (AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this) != null)
        {
          if (TextUtils.isEmpty(AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this).getDesc()))
          {
            AcarusKillingProjectActivity.this.tv_tip.setVisibility(8);
            AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this, AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this).getChumanServicePrice());
            if ((AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this).getNAreaGoodsVOs() != null) && (AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this).getNAreaGoodsVOs().size() > 0)) {
              AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this, AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this).getMAreaGoodsVOs().size());
            }
            AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this).clear();
            AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this).addAll(AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this).getMAreaGoodsVOs());
            AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this).addAll(AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this).getNAreaGoodsVOs());
            if (AcarusKillingProjectActivity.c(AcarusKillingProjectActivity.this) != null) {
              paramAnonymousInt = 0;
            }
          }
          else
          {
            for (;;)
            {
              if (paramAnonymousInt >= AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this).size()) {
                break label444;
              }
              int i = 0;
              label213:
              if (i < AcarusKillingProjectActivity.c(AcarusKillingProjectActivity.this).size())
              {
                if (((com.ziroom.ziroomcustomer.newclean.d.a)AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this).get(paramAnonymousInt)).getGoodsId().equals(((com.ziroom.ziroomcustomer.newclean.d.a)AcarusKillingProjectActivity.c(AcarusKillingProjectActivity.this).get(i)).getGoodsId()))
                {
                  if (((com.ziroom.ziroomcustomer.newclean.d.a)AcarusKillingProjectActivity.c(AcarusKillingProjectActivity.this).get(i)).isIsArea()) {
                    break label374;
                  }
                  ((com.ziroom.ziroomcustomer.newclean.d.a)AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this).get(paramAnonymousInt)).setNumber(((com.ziroom.ziroomcustomer.newclean.d.a)AcarusKillingProjectActivity.c(AcarusKillingProjectActivity.this).get(i)).getNumber());
                }
                for (;;)
                {
                  i += 1;
                  break label213;
                  AcarusKillingProjectActivity.this.tv_tip.setVisibility(0);
                  AcarusKillingProjectActivity.this.tv_tip.setText(AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this).getDesc());
                  break;
                  label374:
                  ((com.ziroom.ziroomcustomer.newclean.d.a)AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this).get(paramAnonymousInt)).setIsArea(true);
                }
              }
              paramAnonymousInt += 1;
            }
          }
          AcarusKillingProjectActivity.this.btn_commit.setText("差" + AcarusKillingProjectActivity.d(AcarusKillingProjectActivity.this) + "元起约");
        }
        label444:
        AcarusKillingProjectActivity.c(AcarusKillingProjectActivity.this).clear();
        AcarusKillingProjectActivity.e(AcarusKillingProjectActivity.this).notifyDataSetChanged();
      }
    });
  }
  
  private void a(String paramString, final int paramInt, final ImageView paramImageView)
  {
    paramString = paramString + "按平米计价，总价需保洁员上门后根据实际面积收取";
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.e).setTitle("提示").setContent(paramString).setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          ((com.ziroom.ziroomcustomer.newclean.d.a)AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this).get(paramInt)).setIsArea(true);
          paramImageView.setImageResource(2130838895);
          AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this, AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this));
        }
      }
    }).build().show();
  }
  
  private void a(List<com.ziroom.ziroomcustomer.newclean.d.a> paramList)
  {
    this.r = 0;
    paramList = paramList.iterator();
    int j = 0;
    while (paramList.hasNext())
    {
      com.ziroom.ziroomcustomer.newclean.d.a locala = (com.ziroom.ziroomcustomer.newclean.d.a)paramList.next();
      int i = j;
      if (locala.isIsArea() == true) {
        i = 1;
      }
      j = i;
      if (locala.getAreaFlag() == 1)
      {
        j = this.r;
        int k = locala.getPrice();
        this.r = (locala.getNumber() * k + j);
        j = i;
      }
    }
    if (j == 1)
    {
      this.tv_unit.setVisibility(4);
      this.tv_all_price.setText("待确认");
      this.btn_commit.setText("完成");
      this.btn_commit.setEnabled(true);
    }
    do
    {
      return;
      this.tv_all_price.setText(this.r + "");
      this.tv_unit.setVisibility(0);
      if (this.r < this.s)
      {
        this.btn_commit.setEnabled(false);
        this.btn_commit.setText("差" + (this.s - this.r) + "元起约");
        return;
      }
    } while (this.r < this.s);
    this.btn_commit.setEnabled(true);
    this.btn_commit.setText("完成");
  }
  
  private List<com.ziroom.ziroomcustomer.newclean.d.a> b()
  {
    this.c.clear();
    if ((this.b != null) && (this.b.size() > 0))
    {
      int i = 0;
      while (i < this.b.size())
      {
        if (((com.ziroom.ziroomcustomer.newclean.d.a)this.b.get(i)).getNumber() > 0) {
          this.c.add(this.b.get(i));
        }
        if (((com.ziroom.ziroomcustomer.newclean.d.a)this.b.get(i)).isIsArea() == true) {
          this.c.add(this.b.get(i));
        }
        i += 1;
      }
    }
    return this.c;
  }
  
  @OnClick({2131689492, 2131689843, 2131689839})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131689843: 
      paramView = new Intent();
      this.c = b();
      paramView.putExtra("shoppingList", (Serializable)this.c);
      setResult(-1, paramView);
      finish();
      return;
    }
    this.c = b();
    if ((this.c != null) && (this.c.size() > 0))
    {
      new com.ziroom.ziroomcustomer.newclean.c.a(this, this.c).show();
      return;
    }
    g.textToast(this.e, "请选择除螨项目");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903085);
    ButterKnife.bind(this);
    this.e = this;
    a();
  }
  
  class a
    extends BaseAdapter
  {
    private Context b;
    
    public a(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public int getCount()
    {
      return AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      label173:
      label199:
      final com.ziroom.ziroomcustomer.newclean.d.a locala;
      if (paramView == null)
      {
        paramView = View.inflate(this.b, 2130904117, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694814));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131689541));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131690073));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131689912));
        paramViewGroup.e = ((ImageView)paramView.findViewById(2131694816));
        paramViewGroup.f = ((ImageView)paramView.findViewById(2131694815));
        paramViewGroup.g = ((TextView)paramView.findViewById(2131690003));
        paramViewGroup.h = ((RelativeLayout)paramView.findViewById(2131693917));
        paramViewGroup.i = paramView.findViewById(2131692133);
        paramView.setTag(paramViewGroup);
        if (paramInt != AcarusKillingProjectActivity.f(AcarusKillingProjectActivity.this)) {
          break label478;
        }
        if (AcarusKillingProjectActivity.f(AcarusKillingProjectActivity.this) != 0) {
          break label467;
        }
        paramViewGroup.h.setVisibility(8);
        if (paramInt != AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this).size() - 1) {
          break label490;
        }
        paramViewGroup.i.setVisibility(0);
        locala = (com.ziroom.ziroomcustomer.newclean.d.a)AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this).get(paramInt);
        paramViewGroup.b.setText(locala.getName());
        if (locala.getAreaFlag() != 0) {
          break label514;
        }
        paramViewGroup.f.setVisibility(4);
        paramViewGroup.g.setVisibility(4);
        if (locala.isIsArea()) {
          break label502;
        }
        paramViewGroup.e.setImageResource(2130838896);
        label270:
        if (TextUtils.isEmpty(locala.getSmallimgurl())) {
          break label551;
        }
        paramViewGroup.a.setBackgroundColor(-1);
        paramViewGroup.a.setController(com.freelxl.baselibrary.f.c.frescoController(locala.getSmallimgurl()));
        label304:
        if (TextUtils.isEmpty(locala.getDesc())) {
          break label563;
        }
        paramViewGroup.c.setText(locala.getDesc());
        label327:
        paramViewGroup.d.setText("¥" + locala.getPrice() + "元/" + locala.getStandard());
        int i = locala.getNumber();
        if (i <= 0) {
          break label575;
        }
        paramViewGroup.g.setText(i + "");
        paramViewGroup.f.setVisibility(0);
      }
      for (;;)
      {
        paramViewGroup.e.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (locala.getAreaFlag() == 0) {
              if (!locala.isIsArea()) {
                AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this, locala.getName(), paramInt, paramViewGroup.e);
              }
            }
            while (locala.getAreaFlag() != 1)
            {
              return;
              locala.setIsArea(false);
              paramViewGroup.e.setImageResource(2130838896);
              AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this, AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this));
              return;
            }
            paramViewGroup.f.setVisibility(0);
            paramViewGroup.g.setVisibility(0);
            int i = locala.getNumber();
            paramViewGroup.g.setText(i + 1 + "");
            locala.setNumber(i + 1);
            AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this, AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this));
          }
        });
        paramViewGroup.f.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            int i = locala.getNumber();
            if (i == 0)
            {
              paramViewGroup.f.setVisibility(4);
              paramViewGroup.g.setVisibility(4);
              return;
            }
            if (i == 1)
            {
              paramViewGroup.g.setText(i - 1 + "");
              paramViewGroup.g.setVisibility(4);
              paramViewGroup.f.setVisibility(4);
              locala.setNumber(i - 1);
              AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this, AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this));
              return;
            }
            paramViewGroup.g.setText(i - 1 + "");
            paramViewGroup.g.setVisibility(0);
            paramViewGroup.f.setVisibility(0);
            locala.setNumber(i - 1);
            AcarusKillingProjectActivity.a(AcarusKillingProjectActivity.this, AcarusKillingProjectActivity.b(AcarusKillingProjectActivity.this));
          }
        });
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label467:
        paramViewGroup.h.setVisibility(0);
        break label173;
        label478:
        paramViewGroup.h.setVisibility(8);
        break label173;
        label490:
        paramViewGroup.i.setVisibility(8);
        break label199;
        label502:
        paramViewGroup.e.setImageResource(2130838895);
        break label270;
        label514:
        if (locala.getAreaFlag() != 1) {
          break label270;
        }
        paramViewGroup.e.setImageResource(2130837589);
        paramViewGroup.f.setVisibility(4);
        paramViewGroup.g.setVisibility(0);
        break label270;
        label551:
        paramViewGroup.a.setBackgroundColor(-3355444);
        break label304;
        label563:
        paramViewGroup.c.setText("");
        break label327;
        label575:
        paramViewGroup.g.setVisibility(4);
        paramViewGroup.f.setVisibility(4);
      }
    }
    
    public class a
    {
      public SimpleDraweeView a;
      public TextView b;
      public TextView c;
      public TextView d;
      public ImageView e;
      public ImageView f;
      public TextView g;
      public RelativeLayout h;
      public View i;
      
      public a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/AcarusKillingProjectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */