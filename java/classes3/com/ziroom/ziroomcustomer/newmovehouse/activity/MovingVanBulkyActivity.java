package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.newmovehouse.fragment.LinkageSelectorFragment;
import com.ziroom.ziroomcustomer.newmovehouse.fragment.LinkageSelectorFragment.a;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanService;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanServiceCategoryDetail;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanServiceItem;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MovingVanBulkyActivity
  extends BaseFluxActivity
{
  Unbinder b;
  com.ziroom.ziroomcustomer.newmovehouse.d.b c;
  com.ziroom.ziroomcustomer.newmovehouse.a.a d;
  LayoutInflater e;
  LinkageSelectorFragment.a f;
  LinkageSelectorFragment g;
  @BindView(2131689816)
  Button mBtnSubmit;
  @BindView(2131690607)
  FrameLayout mFl;
  @BindView(2131691807)
  ImageView mIvPrice;
  @BindView(2131689912)
  TextView mTvPrice;
  b r;
  a s;
  c t;
  float u;
  int v;
  int w;
  int x;
  int y;
  int z;
  
  private void a()
  {
    e();
    this.e = getLayoutInflater();
    this.v = getResources().getColor(2131624516);
    this.w = getResources().getColor(2131624393);
    this.u = getResources().getDisplayMetrics().density;
    this.x = ((int)(this.u * 48.0F));
    this.y = ((int)(this.u * 28.0F));
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
    this.z = (localDisplayMetrics.heightPixels - i);
  }
  
  private void a(ImageView paramImageView, boolean paramBoolean)
  {
    float f2 = 180.0F;
    float f3 = paramImageView.getWidth() / 2.0F;
    float f4 = paramImageView.getHeight() / 2.0F;
    if (paramBoolean) {}
    for (float f1 = 360.0F;; f1 = 180.0F)
    {
      RotateAnimation localRotateAnimation = new RotateAnimation(f2, f1, f3, f4);
      localRotateAnimation.setDuration(100L);
      localRotateAnimation.setFillAfter(true);
      paramImageView.startAnimation(localRotateAnimation);
      return;
      f2 = 0.0F;
    }
  }
  
  private void b()
  {
    this.c = new com.ziroom.ziroomcustomer.newmovehouse.d.b(this);
    this.a.register(this.c);
    this.d = com.ziroom.ziroomcustomer.newmovehouse.a.a.getInstance(this.a);
    ArrayList localArrayList = getIntent().getParcelableArrayListExtra("services");
    String str1 = getIntent().getStringExtra("token");
    String str2 = getIntent().getStringExtra("productCode");
    this.d.initMvServices(this, str2, str1, localArrayList);
  }
  
  private void e()
  {
    ((ImageView)findViewById(2131691493)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MovingVanBulkyActivity.this.finish();
      }
    });
    findViewById(2131696483).setVisibility(8);
    findViewById(2131696484).setVisibility(8);
    ((TextView)findViewById(2131689541)).setText("大件物品");
  }
  
  private void f()
  {
    this.f = new LinkageSelectorFragment.a()
    {
      public int[] getItemIndex()
      {
        return MovingVanBulkyActivity.this.c.getServiceCategoryIndex();
      }
      
      public Object getLeftItem(int paramAnonymousInt)
      {
        return MovingVanBulkyActivity.this.c.getCategoryDetails().get(paramAnonymousInt);
      }
      
      public View getLeftView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new TextView(MovingVanBulkyActivity.this);
          paramAnonymousView.setLayoutParams(new AbsListView.LayoutParams(-1, MovingVanBulkyActivity.this.x));
          paramAnonymousView.setFocusable(false);
          paramAnonymousView.setGravity(17);
          paramAnonymousView.setText(((MovingVanServiceCategoryDetail)MovingVanBulkyActivity.this.c.getCategoryDetails().get(paramAnonymousInt)).getCategoryName());
          paramAnonymousView.setTextSize(2, 12.0F);
        }
        while (paramAnonymousBoolean)
        {
          ((TextView)paramAnonymousView).setTextColor(MovingVanBulkyActivity.this.v);
          paramAnonymousView.setBackgroundColor(-1);
          return paramAnonymousView;
          ((TextView)paramAnonymousView).setText(((MovingVanServiceCategoryDetail)MovingVanBulkyActivity.this.c.getCategoryDetails().get(paramAnonymousInt)).getCategoryName());
        }
        ((TextView)paramAnonymousView).setTextColor(MovingVanBulkyActivity.this.w);
        paramAnonymousView.setBackgroundColor(0);
        return paramAnonymousView;
      }
      
      public Object getRightItem(int paramAnonymousInt)
      {
        return MovingVanBulkyActivity.this.c.getServices().get(paramAnonymousInt);
      }
      
      public View getRightItemView(int paramAnonymousInt1, int paramAnonymousInt2, View paramAnonymousView, final ViewGroup paramAnonymousViewGroup)
      {
        final Object localObject = (MovingVanService)getRightItem(paramAnonymousInt2);
        if (paramAnonymousView == null)
        {
          paramAnonymousView = MovingVanBulkyActivity.this.e.inflate(2130904378, paramAnonymousViewGroup, false);
          paramAnonymousViewGroup = new a();
          paramAnonymousViewGroup.a = ((SimpleDraweeView)paramAnonymousView.findViewById(2131691098));
          paramAnonymousViewGroup.b = ((TextView)paramAnonymousView.findViewById(2131690049));
          paramAnonymousViewGroup.c = ((TextView)paramAnonymousView.findViewById(2131690073));
          paramAnonymousViewGroup.d = ((Button)paramAnonymousView.findViewById(2131690043));
          paramAnonymousViewGroup.e = ((LinearLayout)paramAnonymousView.findViewById(2131695380));
          paramAnonymousViewGroup.g = ((TextView)paramAnonymousView.findViewById(2131690003));
          paramAnonymousViewGroup.f = ((ImageButton)paramAnonymousView.findViewById(2131694892));
          paramAnonymousViewGroup.h = ((ImageButton)paramAnonymousView.findViewById(2131694816));
          paramAnonymousViewGroup.i = ((TextView)paramAnonymousView.findViewById(2131695379));
          paramAnonymousView.setTag(paramAnonymousViewGroup);
          if (((MovingVanService)localObject).getItem() == null) {
            break label671;
          }
          if (paramAnonymousViewGroup.a.getTag() != null) {
            break label434;
          }
          paramAnonymousViewGroup.a.setTag(((MovingVanService)localObject).getItem().getImgUrl());
          paramAnonymousViewGroup.a.setController(c.frescoController(((MovingVanService)localObject).getItem().getImgUrl()));
          label226:
          paramAnonymousViewGroup.b.setText(((MovingVanService)localObject).getItem().getCategoryName());
          paramAnonymousViewGroup.c.setText(((MovingVanService)localObject).getItem().getCategoryDetail());
          if ((((MovingVanService)localObject).getChildrenItemlist() == null) || (((MovingVanService)localObject).getChildrenItemlist().size() <= 0)) {
            break label649;
          }
          if (((MovingVanService)localObject).getChildrenItemlist().size() <= 1) {
            break label517;
          }
          paramAnonymousViewGroup.d.setVisibility(8);
          paramAnonymousViewGroup.i.setVisibility(0);
          paramAnonymousViewGroup.e.setVisibility(0);
          if (((MovingVanService)localObject).getItem().getBuyNumber() <= 0) {
            break label494;
          }
          paramAnonymousViewGroup.f.setVisibility(0);
          paramAnonymousViewGroup.g.setVisibility(0);
          paramAnonymousViewGroup.f.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              MovingVanBulkyActivity.this.d.initMvService(MovingVanBulkyActivity.this, localObject.getItem().getLogicCode());
            }
          });
          paramAnonymousViewGroup.g.setText(((MovingVanService)localObject).getItem().getBuyNumber() + "");
        }
        for (;;)
        {
          paramAnonymousViewGroup.h.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              MovingVanBulkyActivity.this.d.initMvService(MovingVanBulkyActivity.this, localObject.getItem().getLogicCode());
            }
          });
          return paramAnonymousView;
          paramAnonymousViewGroup = (a)paramAnonymousView.getTag();
          break;
          label434:
          if (((MovingVanService)localObject).getItem().getImgUrl().equals(paramAnonymousViewGroup.a.getTag())) {
            break label226;
          }
          paramAnonymousViewGroup.a.setTag(((MovingVanService)localObject).getItem().getImgUrl());
          paramAnonymousViewGroup.a.setController(c.frescoController(((MovingVanService)localObject).getItem().getImgUrl()));
          break label226;
          label494:
          paramAnonymousViewGroup.f.setVisibility(8);
          paramAnonymousViewGroup.g.setVisibility(8);
        }
        label517:
        localObject = (MovingVanServiceItem)((MovingVanService)localObject).getChildrenItemlist().get(0);
        paramAnonymousViewGroup.d.setVisibility(8);
        paramAnonymousViewGroup.i.setVisibility(8);
        paramAnonymousViewGroup.e.setVisibility(0);
        paramAnonymousViewGroup.f.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            MovingVanBulkyActivity.this.d.updateMvServices(MovingVanBulkyActivity.this, localObject.getLogicCode(), -1);
          }
        });
        paramAnonymousViewGroup.h.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            MovingVanBulkyActivity.this.d.updateMvServices(MovingVanBulkyActivity.this, localObject.getLogicCode(), 1);
          }
        });
        paramAnonymousViewGroup.g.addTextChangedListener(new TextWatcher()
        {
          public void afterTextChanged(Editable paramAnonymous2Editable)
          {
            int i = Integer.parseInt(paramAnonymous2Editable.toString());
            if (i <= 0)
            {
              paramAnonymousViewGroup.g.setVisibility(8);
              paramAnonymousViewGroup.f.setVisibility(8);
              return;
            }
            if (i >= 99)
            {
              paramAnonymousViewGroup.h.setEnabled(false);
              return;
            }
            paramAnonymousViewGroup.h.setEnabled(true);
            paramAnonymousViewGroup.g.setVisibility(0);
            paramAnonymousViewGroup.f.setVisibility(0);
          }
          
          public void beforeTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3) {}
          
          public void onTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3) {}
        });
        paramAnonymousViewGroup.g.setText(((MovingVanServiceItem)localObject).getBuyNumber() + "");
        return paramAnonymousView;
        label649:
        paramAnonymousViewGroup.d.setVisibility(8);
        paramAnonymousViewGroup.e.setVisibility(8);
        return paramAnonymousView;
        label671:
        paramAnonymousViewGroup.a.setController(c.frescoController(""));
        paramAnonymousViewGroup.b.setText("");
        paramAnonymousViewGroup.c.setText("");
        return paramAnonymousView;
      }
      
      public View getRightParentView(int paramAnonymousInt1, int paramAnonymousInt2, View paramAnonymousView, ViewGroup paramAnonymousViewGroup, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousView == null)
        {
          paramAnonymousView = new TextView(MovingVanBulkyActivity.this);
          paramAnonymousView.setLayoutParams(new AbsListView.LayoutParams(-1, MovingVanBulkyActivity.this.y));
          paramAnonymousView.setGravity(19);
          paramAnonymousView.setText(((MovingVanServiceCategoryDetail)MovingVanBulkyActivity.this.c.getCategoryDetails().get(paramAnonymousInt2)).getCategoryName());
          paramAnonymousView.setTextSize(2, 12.0F);
        }
        while (paramAnonymousBoolean)
        {
          ((TextView)paramAnonymousView).setTextColor(MovingVanBulkyActivity.this.v);
          return paramAnonymousView;
          ((TextView)paramAnonymousView).setText(((MovingVanServiceCategoryDetail)MovingVanBulkyActivity.this.c.getCategoryDetails().get(paramAnonymousInt2)).getCategoryName());
        }
        ((TextView)paramAnonymousView).setTextColor(MovingVanBulkyActivity.this.w);
        return paramAnonymousView;
      }
      
      class a
      {
        SimpleDraweeView a;
        TextView b;
        TextView c;
        Button d;
        LinearLayout e;
        ImageButton f;
        TextView g;
        ImageButton h;
        TextView i;
        
        a() {}
      }
    };
    this.g = LinkageSelectorFragment.getInstance(this.f);
    getSupportFragmentManager().beginTransaction().add(2131690607, this.g, "fragment").commit();
  }
  
  private void g()
  {
    if ((this.g != null) && (this.f != null)) {
      this.g.refreshData(this.f);
    }
  }
  
  private void h()
  {
    if ((this.c.getEstimateServiceItems() != null) && (this.c.getEstimateServiceItems().size() > 0))
    {
      this.mIvPrice.setVisibility(0);
      this.mTvPrice.setTextColor(Color.parseColor("#FF6262"));
    }
    for (;;)
    {
      this.mBtnSubmit.setEnabled(true);
      if (TextUtils.isEmpty(this.c.getPriceText())) {
        break;
      }
      SpannableString localSpannableString = new SpannableString(this.c.getPriceText());
      localSpannableString.setSpan(new AbsoluteSizeSpan(14, true), 0, 1, 18);
      localSpannableString.setSpan(new AbsoluteSizeSpan(18, true), 1, localSpannableString.length(), 18);
      this.mTvPrice.setText(localSpannableString);
      return;
      this.mIvPrice.clearAnimation();
      this.mIvPrice.setVisibility(8);
      this.mTvPrice.setTextColor(Color.parseColor("#DDDDDD"));
    }
    this.mTvPrice.setText(this.c.getPriceText());
  }
  
  private void i()
  {
    new d(this).show();
  }
  
  private void j()
  {
    if ((this.c.getEstimateServiceItems() == null) || (this.c.getEstimateServiceItems().size() == 0)) {
      return;
    }
    if ((this.r != null) && (this.r.isShowing()))
    {
      this.r.dismiss();
      return;
    }
    if (this.r == null) {
      this.r = new b(this);
    }
    this.r.setOnShowListener(new DialogInterface.OnShowListener()
    {
      public void onShow(DialogInterface paramAnonymousDialogInterface)
      {
        MovingVanBulkyActivity.a(MovingVanBulkyActivity.this, MovingVanBulkyActivity.this.mIvPrice, false);
      }
    });
    this.r.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        if (MovingVanBulkyActivity.this.mIvPrice.getVisibility() == 0) {
          MovingVanBulkyActivity.a(MovingVanBulkyActivity.this, MovingVanBulkyActivity.this.mIvPrice, true);
        }
      }
    });
    this.r.show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903358);
    this.b = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.b.unbind();
    this.a.unregister(this.c);
    super.onDestroy();
  }
  
  public void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i;
    switch (parama.hashCode())
    {
    default: 
      i = -1;
      label62:
      switch (i)
      {
      }
      break;
    }
    do
    {
      do
      {
        return;
        if (!parama.equals("service_mv_van_bulky_init")) {
          break;
        }
        i = 0;
        break label62;
        if (!parama.equals("service_mv_van_bulky_update")) {
          break;
        }
        i = 1;
        break label62;
        if (!parama.equals("service_mv_van_bulky_item_init")) {
          break;
        }
        i = 2;
        break label62;
        if (!parama.equals("service_mv_van_bulky_item_update")) {
          break;
        }
        i = 3;
        break label62;
        if (!parama.equals("service_mv_van_bulky_submit")) {
          break;
        }
        i = 4;
        break label62;
        f();
        h();
        return;
        g();
        h();
        if (this.t != null) {
          this.t.notifyDataSetChanged();
        }
      } while (this.s == null);
      this.s.notifyDataSetChanged();
      return;
      d.d("", "========onEventHandle:service_mv_van_bulky_item_init");
    } while (this.c.getService() == null);
    i();
    return;
    parama = new Intent();
    parama.putParcelableArrayListExtra("servicess", (ArrayList)this.c.getServices());
    setResult(-1, parama);
    finish();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691806: 
      j();
      return;
    }
    this.d.submitMvServices(this, this.c.getProductCode(), this.c.getToken(), this.c.getEstimateServiceItems());
  }
  
  private class a
    extends BaseAdapter
  {
    NumberFormat a = NumberFormat.getCurrencyInstance();
    LayoutInflater b = MovingVanBulkyActivity.this.getLayoutInflater();
    
    private a() {}
    
    public int getCount()
    {
      if (MovingVanBulkyActivity.this.c.getEstimateServiceItems() == null) {
        return 0;
      }
      return MovingVanBulkyActivity.this.c.getEstimateServiceItems().size();
    }
    
    public Object getItem(int paramInt)
    {
      return MovingVanBulkyActivity.this.c.getService().getChildrenItemlist().get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      final MovingVanServiceItem localMovingVanServiceItem = (MovingVanServiceItem)MovingVanBulkyActivity.this.c.getEstimateServiceItems().get(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = this.b.inflate(2130904379, paramViewGroup, false);
        paramView = new a();
        paramView.a = ((TextView)localView.findViewById(2131690049));
        paramView.b = ((TextView)localView.findViewById(2131690073));
        paramView.c = ((TextView)localView.findViewById(2131689912));
        paramView.c.setVisibility(0);
        paramView.e = ((TextView)localView.findViewById(2131690003));
        paramView.d = ((ImageButton)localView.findViewById(2131694892));
        paramView.f = ((ImageButton)localView.findViewById(2131694816));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.a.setText(localMovingVanServiceItem.getServiceName());
        paramViewGroup.b.setText(localMovingVanServiceItem.getServiceDetail());
        paramViewGroup.c.setText(this.a.format(localMovingVanServiceItem.getServicePrice() * localMovingVanServiceItem.getBuyNumber() / 100.0D));
        paramViewGroup.d.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            MovingVanBulkyActivity.this.d.updateMvServices(MovingVanBulkyActivity.this, localMovingVanServiceItem.getLogicCode(), -1);
          }
        });
        paramViewGroup.f.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            MovingVanBulkyActivity.this.d.updateMvServices(MovingVanBulkyActivity.this, localMovingVanServiceItem.getLogicCode(), 1);
          }
        });
        paramViewGroup.e.addTextChangedListener(new TextWatcher()
        {
          public void afterTextChanged(Editable paramAnonymousEditable)
          {
            int i = Integer.parseInt(paramAnonymousEditable.toString());
            if (i <= 0)
            {
              paramViewGroup.e.setVisibility(8);
              paramViewGroup.d.setVisibility(8);
              return;
            }
            if (i >= 99)
            {
              paramViewGroup.f.setEnabled(false);
              return;
            }
            paramViewGroup.f.setEnabled(true);
            paramViewGroup.e.setVisibility(0);
            paramViewGroup.d.setVisibility(0);
          }
          
          public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });
        paramViewGroup.e.setText(localMovingVanServiceItem.getBuyNumber() + "");
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
    }
    
    class a
    {
      TextView a;
      TextView b;
      TextView c;
      ImageButton d;
      TextView e;
      ImageButton f;
      
      a() {}
    }
  }
  
  class b
    extends Dialog
  {
    Context a;
    
    public b(Context paramContext)
    {
      super();
      this.a = paramContext;
      a();
    }
    
    private void a()
    {
      Window localWindow = getWindow();
      localWindow.requestFeature(1);
      localWindow.addFlags(2);
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = (MovingVanBulkyActivity.this.z - MovingVanBulkyActivity.this.x - (int)(MovingVanBulkyActivity.this.u * 0.5D));
      localLayoutParams.dimAmount = 0.0F;
      localWindow.setAttributes(localLayoutParams);
      localWindow.getDecorView().setBackgroundColor(0);
      localWindow.setGravity(48);
    }
    
    protected void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      paramBundle = LayoutInflater.from(this.a).inflate(2130903829, null);
      ListView localListView = (ListView)paramBundle.findViewById(2131689817);
      paramBundle.findViewById(2131693851).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MovingVanBulkyActivity.b.this.dismiss();
        }
      });
      MovingVanBulkyActivity.this.s = new MovingVanBulkyActivity.a(MovingVanBulkyActivity.this, null);
      localListView.setAdapter(MovingVanBulkyActivity.this.s);
      setContentView(paramBundle);
    }
  }
  
  private class c
    extends BaseAdapter
  {
    LayoutInflater a = MovingVanBulkyActivity.this.getLayoutInflater();
    
    private c() {}
    
    public int getCount()
    {
      MovingVanService localMovingVanService = MovingVanBulkyActivity.this.c.getService();
      if ((localMovingVanService == null) || (localMovingVanService.getChildrenItemlist() == null)) {
        return 0;
      }
      return localMovingVanService.getChildrenItemlist().size();
    }
    
    public Object getItem(int paramInt)
    {
      return MovingVanBulkyActivity.this.c.getService().getChildrenItemlist().get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      final MovingVanServiceItem localMovingVanServiceItem = (MovingVanServiceItem)getItem(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = this.a.inflate(2130904379, paramViewGroup, false);
        paramView = new a();
        paramView.a = ((TextView)localView.findViewById(2131690049));
        paramView.b = ((TextView)localView.findViewById(2131690073));
        paramView.d = ((TextView)localView.findViewById(2131690003));
        paramView.c = ((ImageButton)localView.findViewById(2131694892));
        paramView.e = ((ImageButton)localView.findViewById(2131694816));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.a.setText(localMovingVanServiceItem.getServiceName());
        paramViewGroup.b.setText(localMovingVanServiceItem.getServiceDetail());
        paramViewGroup.c.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            MovingVanBulkyActivity.this.d.updateMvServices(MovingVanBulkyActivity.this, localMovingVanServiceItem.getLogicCode(), -1);
          }
        });
        paramViewGroup.e.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            MovingVanBulkyActivity.this.d.updateMvServices(MovingVanBulkyActivity.this, localMovingVanServiceItem.getLogicCode(), 1);
          }
        });
        paramViewGroup.d.addTextChangedListener(new TextWatcher()
        {
          public void afterTextChanged(Editable paramAnonymousEditable)
          {
            int i = Integer.parseInt(paramAnonymousEditable.toString());
            if (i <= 0)
            {
              paramViewGroup.d.setVisibility(8);
              paramViewGroup.c.setVisibility(8);
              return;
            }
            if (i >= 99)
            {
              paramViewGroup.e.setEnabled(false);
              return;
            }
            paramViewGroup.e.setEnabled(true);
            paramViewGroup.d.setVisibility(0);
            paramViewGroup.c.setVisibility(0);
          }
          
          public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });
        paramViewGroup.d.setText(localMovingVanServiceItem.getBuyNumber() + "");
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
    }
    
    class a
    {
      TextView a;
      TextView b;
      ImageButton c;
      TextView d;
      ImageButton e;
      
      a() {}
    }
  }
  
  class d
    extends Dialog
  {
    Context a;
    
    public d(Context paramContext)
    {
      super();
      this.a = paramContext;
      a();
    }
    
    private void a()
    {
      Window localWindow = getWindow();
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localWindow.setAttributes(localLayoutParams);
      localWindow.getDecorView().setBackgroundColor(0);
      localWindow.setGravity(80);
    }
    
    protected void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      paramBundle = LayoutInflater.from(this.a).inflate(2130903828, null);
      SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)paramBundle.findViewById(2131691098);
      TextView localTextView1 = (TextView)paramBundle.findViewById(2131690049);
      TextView localTextView2 = (TextView)paramBundle.findViewById(2131690073);
      ListView localListView = (ListView)paramBundle.findViewById(2131689817);
      Button localButton = (Button)paramBundle.findViewById(2131690043);
      MovingVanService localMovingVanService = MovingVanBulkyActivity.this.c.getService();
      localSimpleDraweeView.setController(c.frescoController(localMovingVanService.getItem().getImgUrl()));
      localTextView1.setText(localMovingVanService.getItem().getCategoryName());
      localTextView2.setText(localMovingVanService.getItem().getCategoryDetail());
      MovingVanBulkyActivity.this.t = new MovingVanBulkyActivity.c(MovingVanBulkyActivity.this, null);
      localListView.setAdapter(MovingVanBulkyActivity.this.t);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MovingVanBulkyActivity.d.this.dismiss();
        }
      });
      setContentView(paramBundle);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MovingVanBulkyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */