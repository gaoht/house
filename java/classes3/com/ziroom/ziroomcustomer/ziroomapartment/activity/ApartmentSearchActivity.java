package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.rangebar.RangeBar;
import com.ziroom.commonlibrary.widget.rangebar.RangeBar.a;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchCondition;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchCondition.DataEntity;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchCondition.DataEntity.CheckInTimeBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchCondition.DataEntity.CityListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchCondition.DataEntity.DirectionListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchCondition.DataEntity.FloorNumberListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchCondition.DataEntity.PriceBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchCondition.DataEntity.SortListBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionRecord;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionResult;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionResult.AreaEntity;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuSearchConditionResult.PriceEntity;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ApartmentSearchActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private final int A = 258;
  private final int B = 259;
  private final int C = 260;
  private final int D = 1000;
  private TextView E;
  private View F;
  private TextView G;
  private LinearLayout H;
  private FlowLayout I;
  private ZryuSearchCondition J;
  private ZryuSearchConditionResult K = new ZryuSearchConditionResult();
  private ZryuSearchConditionResult L;
  private Context a;
  private Intent b;
  private final int c = -1;
  private int d;
  private final int e = 15;
  private final String f = "#444444";
  private final int g = 14;
  private final String r = "#dddddd";
  private final String s = "#444444";
  private final int t = 14;
  private final String u = "#999999";
  private final String v = "#ffa000";
  private final int w = 2147483646;
  private final int x = 2147483645;
  private final int y = 2147483644;
  private final int z = 257;
  
  private int a(float paramFloat)
  {
    float f1 = getApplication().getResources().getDisplayMetrics().density;
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(f1 * paramFloat + 0.5F);
  }
  
  private View a(Object paramObject, boolean paramBoolean, int paramInt)
  {
    TextView localTextView = new TextView(this.a);
    localTextView.setTextSize(14.0F);
    localTextView.setGravity(17);
    localTextView.setPadding(a(24.0F), a(8.0F), a(24.0F), a(8.0F));
    localTextView.setTextSize(12.0F);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
    localMarginLayoutParams.setMargins(a(5.0F), a(8.0F), a(5.0F), a(8.0F));
    localTextView.setLayoutParams(localMarginLayoutParams);
    if (paramBoolean)
    {
      localTextView.setBackgroundResource(2130839555);
      localTextView.setTextColor(Color.parseColor("#ffa000"));
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          boolean bool1 = false;
          VdsAgent.onClick(this, paramAnonymousView);
          boolean bool2 = ((Boolean)paramAnonymousView.getTag(2147483644)).booleanValue();
          int i = ((Integer)paramAnonymousView.getTag(2147483646)).intValue();
          String str = String.valueOf(paramAnonymousView.getTag(2147483645));
          Object localObject1;
          Object localObject2;
          if (bool2)
          {
            switch (i)
            {
            }
            for (;;)
            {
              paramAnonymousView.setBackgroundResource(2130839554);
              ((TextView)paramAnonymousView).setTextColor(Color.parseColor("#999999"));
              if (!bool2) {
                bool1 = true;
              }
              paramAnonymousView.setTag(2147483644, Boolean.valueOf(bool1));
              return;
              localObject1 = ApartmentSearchActivity.a(ApartmentSearchActivity.this).getCheckInTime().split(",");
              localObject2 = new StringBuilder();
              i = 0;
              while (i < localObject1.length)
              {
                if (!str.equals(localObject1[i])) {
                  ((StringBuilder)localObject2).append(localObject1[i]).append(",");
                }
                i += 1;
              }
              if (((StringBuilder)localObject2).length() > 0) {
                ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
              }
              ApartmentSearchActivity.a(ApartmentSearchActivity.this).setCheckInTime(((StringBuilder)localObject2).toString());
              continue;
              ApartmentSearchActivity.a(ApartmentSearchActivity.this).setCity("");
              ApartmentSearchActivity.a(ApartmentSearchActivity.this).setCityAll(false);
              continue;
              localObject1 = ApartmentSearchActivity.a(ApartmentSearchActivity.this).getDirection().split(",");
              localObject2 = new StringBuilder();
              i = 0;
              while (i < localObject1.length)
              {
                if (!str.equals(localObject1[i])) {
                  ((StringBuilder)localObject2).append(localObject1[i]).append(",");
                }
                i += 1;
              }
              if (((StringBuilder)localObject2).length() > 0) {
                ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
              }
              ApartmentSearchActivity.a(ApartmentSearchActivity.this).setDirection(((StringBuilder)localObject2).toString());
              continue;
              localObject1 = ApartmentSearchActivity.a(ApartmentSearchActivity.this).getFloor().split(",");
              localObject2 = new StringBuilder();
              i = 0;
              while (i < localObject1.length)
              {
                if (!str.equals(localObject1[i])) {
                  ((StringBuilder)localObject2).append(localObject1[i]).append(",");
                }
                i += 1;
              }
              if (((StringBuilder)localObject2).length() > 0) {
                ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
              }
              ApartmentSearchActivity.a(ApartmentSearchActivity.this).setFloor(((StringBuilder)localObject2).toString());
            }
          }
          switch (i)
          {
          default: 
          case 259: 
            for (;;)
            {
              paramAnonymousView.setBackgroundResource(2130839555);
              ((TextView)paramAnonymousView).setTextColor(Color.parseColor("#ffa000"));
              break;
              if (TextUtils.isEmpty(ApartmentSearchActivity.a(ApartmentSearchActivity.this).getCheckInTime())) {
                ApartmentSearchActivity.a(ApartmentSearchActivity.this).setCheckInTime(str);
              } else {
                ApartmentSearchActivity.a(ApartmentSearchActivity.this).setCheckInTime(ApartmentSearchActivity.a(ApartmentSearchActivity.this).getCheckInTime() + "," + str);
              }
            }
          case 257: 
            if ("null".equals(str)) {
              str = null;
            }
            break;
          }
          for (;;)
          {
            ApartmentSearchActivity.a(ApartmentSearchActivity.this).setCity(str);
            i = 0;
            if (i < ApartmentSearchActivity.c(ApartmentSearchActivity.this).getChildCount())
            {
              localObject1 = ApartmentSearchActivity.c(ApartmentSearchActivity.this).getChildAt(i);
              localObject2 = String.valueOf(((View)localObject1).getTag(2147483645));
              if ((!TextUtils.isEmpty(str)) && (!str.equals(localObject2)))
              {
                ((View)localObject1).setBackgroundResource(2130839554);
                ((TextView)localObject1).setTextColor(Color.parseColor("#999999"));
                ((View)localObject1).setTag(2147483644, Boolean.valueOf(false));
              }
              for (;;)
              {
                i += 1;
                break;
                ((View)localObject1).setBackgroundResource(2130839554);
                ((TextView)localObject1).setTextColor(Color.parseColor("#999999"));
                ((View)localObject1).setTag(2147483644, Boolean.valueOf(false));
              }
            }
            if (!TextUtils.isEmpty(str)) {
              break;
            }
            ApartmentSearchActivity.a(ApartmentSearchActivity.this).setCityAll(true);
            break;
            if (TextUtils.isEmpty(ApartmentSearchActivity.a(ApartmentSearchActivity.this).getDirection()))
            {
              ApartmentSearchActivity.a(ApartmentSearchActivity.this).setDirection(str);
              break;
            }
            ApartmentSearchActivity.a(ApartmentSearchActivity.this).setDirection(ApartmentSearchActivity.a(ApartmentSearchActivity.this).getDirection() + "," + str);
            break;
            if (TextUtils.isEmpty(ApartmentSearchActivity.a(ApartmentSearchActivity.this).getFloor()))
            {
              ApartmentSearchActivity.a(ApartmentSearchActivity.this).setFloor(str);
              break;
            }
            ApartmentSearchActivity.a(ApartmentSearchActivity.this).setFloor(ApartmentSearchActivity.a(ApartmentSearchActivity.this).getFloor() + "," + str);
            break;
          }
        }
      });
      return localTextView;
      localTextView.setBackgroundResource(2130839554);
      localTextView.setTextColor(Color.parseColor("#999999"));
      break;
      paramObject = (ZryuSearchCondition.DataEntity.CheckInTimeBean)paramObject;
      localTextView.setText(((ZryuSearchCondition.DataEntity.CheckInTimeBean)paramObject).getName());
      localTextView.setTag(2147483646, Integer.valueOf(259));
      localTextView.setTag(2147483645, Integer.valueOf(((ZryuSearchCondition.DataEntity.CheckInTimeBean)paramObject).getState()));
      localTextView.setTag(2147483644, Boolean.valueOf(paramBoolean));
      if (paramBoolean) {
        if (TextUtils.isEmpty(this.K.getCheckInTime()))
        {
          this.K.setCheckInTime(((ZryuSearchCondition.DataEntity.CheckInTimeBean)paramObject).getState() + "");
        }
        else
        {
          this.K.setCheckInTime(this.K.getCheckInTime() + "," + ((ZryuSearchCondition.DataEntity.CheckInTimeBean)paramObject).getState());
          continue;
          paramObject = (ZryuSearchCondition.DataEntity.CityListBean)paramObject;
          localTextView.setText(((ZryuSearchCondition.DataEntity.CityListBean)paramObject).getCityName());
          localTextView.setTag(2147483646, Integer.valueOf(257));
          localTextView.setTag(2147483645, ((ZryuSearchCondition.DataEntity.CityListBean)paramObject).getCityCode());
          localTextView.setTag(2147483644, Boolean.valueOf(paramBoolean));
          if (paramBoolean)
          {
            this.K.setCity(((ZryuSearchCondition.DataEntity.CityListBean)paramObject).getCityCode());
            continue;
            paramObject = (ZryuSearchCondition.DataEntity.DirectionListBean)paramObject;
            localTextView.setText(((ZryuSearchCondition.DataEntity.DirectionListBean)paramObject).getName());
            localTextView.setTag(2147483646, Integer.valueOf(260));
            localTextView.setTag(2147483645, Integer.valueOf(((ZryuSearchCondition.DataEntity.DirectionListBean)paramObject).getState()));
            localTextView.setTag(2147483644, Boolean.valueOf(paramBoolean));
            if (paramBoolean) {
              if (TextUtils.isEmpty(this.K.getDirection()))
              {
                this.K.setDirection(((ZryuSearchCondition.DataEntity.DirectionListBean)paramObject).getState() + "");
              }
              else
              {
                this.K.setDirection(this.K.getDirection() + "," + ((ZryuSearchCondition.DataEntity.DirectionListBean)paramObject).getState());
                continue;
                paramObject = (ZryuSearchCondition.DataEntity.FloorNumberListBean)paramObject;
                localTextView.setText(((ZryuSearchCondition.DataEntity.FloorNumberListBean)paramObject).getName());
                localTextView.setTag(2147483646, Integer.valueOf(258));
                localTextView.setTag(2147483645, Integer.valueOf(((ZryuSearchCondition.DataEntity.FloorNumberListBean)paramObject).getState()));
                localTextView.setTag(2147483644, Boolean.valueOf(paramBoolean));
                if (paramBoolean) {
                  if (TextUtils.isEmpty(this.K.getFloor())) {
                    this.K.setFloor(((ZryuSearchCondition.DataEntity.FloorNumberListBean)paramObject).getState() + "");
                  } else {
                    this.K.setFloor(this.K.getFloor() + "," + ((ZryuSearchCondition.DataEntity.FloorNumberListBean)paramObject).getState());
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void a()
  {
    ((TextView)findViewById(2131689541)).setText("筛选条件");
    this.E = ((TextView)findViewById(2131696484));
    this.E.setText("重置");
    this.F = findViewById(2131691493);
    this.H = ((LinearLayout)findViewById(2131689918));
    this.G = ((TextView)findViewById(2131689843));
  }
  
  private View b(int paramInt)
  {
    ImageView localImageView = new ImageView(this.a);
    localImageView.setBackgroundColor(Color.parseColor("#eeeeee"));
    localImageView.setPadding(20, 0, 20, 0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, a(0.5F));
    localLayoutParams.setMargins(a(16.0F), a(paramInt), a(16.0F), 0);
    localImageView.setLayoutParams(localLayoutParams);
    return localImageView;
  }
  
  private void b()
  {
    this.E.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.G.setOnClickListener(this);
  }
  
  private View d(String paramString)
  {
    TextView localTextView = new TextView(this.a);
    localTextView.setText(paramString);
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(Color.parseColor("#444444"));
    localTextView.setTextSize(15.0F);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(0, a(20.0F), 0, 0);
    localTextView.setLayoutParams(paramString);
    return localTextView;
  }
  
  private void e()
  {
    this.b = getIntent();
    this.d = this.b.getExtras().getInt("apartment_search_type", -1);
    switch (this.d)
    {
    }
    for (;;)
    {
      if (this.L != null) {
        this.K = this.L;
      }
      f();
      return;
      this.L = ZryuSearchConditionRecord.getInstance().getProjectRecord();
      continue;
      if (ZryuSearchConditionRecord.getInstance().getHouseRecord() == null) {}
      for (ZryuSearchConditionResult localZryuSearchConditionResult = ZryuSearchConditionRecord.getInstance().getProjectRecord();; localZryuSearchConditionResult = ZryuSearchConditionRecord.getInstance().getHouseRecord())
      {
        this.L = localZryuSearchConditionResult;
        break;
      }
      if (ZryuSearchConditionRecord.getInstance().getRoomRecord() != null) {
        this.L = ZryuSearchConditionRecord.getInstance().getRoomRecord();
      } else if (ZryuSearchConditionRecord.getInstance().getHouseCondition() != null) {
        this.L = ZryuSearchConditionRecord.getInstance().getHouseRecord();
      } else {
        this.L = ZryuSearchConditionRecord.getInstance().getProjectRecord();
      }
    }
  }
  
  private void f()
  {
    label32:
    Iterator localIterator;
    switch (this.d)
    {
    default: 
      Collections.sort(this.J.getData().getSortList());
      localIterator = this.J.getData().getSortList().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Object localObject = ((ZryuSearchCondition.DataEntity.SortListBean)localIterator.next()).getCode();
      int i = -1;
      switch (((String)localObject).hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          break;
        case 0: 
          localObject = g();
          this.H.addView(d("价格区间"));
          this.H.addView((View)localObject);
          this.H.addView(b(9));
          break;
          this.J = ZryuSearchConditionRecord.getInstance().getProjectCondition();
          break label32;
          this.J = ZryuSearchConditionRecord.getInstance().getHouseCondition();
          break label32;
          this.J = ZryuSearchConditionRecord.getInstance().getRoomCondition();
          break label32;
          if (((String)localObject).equals("price"))
          {
            i = 0;
            continue;
            if (((String)localObject).equals("roomNumber"))
            {
              i = 1;
              continue;
              if (((String)localObject).equals("area"))
              {
                i = 2;
                continue;
                if (((String)localObject).equals("cityList"))
                {
                  i = 3;
                  continue;
                  if (((String)localObject).equals("checkInTime"))
                  {
                    i = 4;
                    continue;
                    if (((String)localObject).equals("directionList"))
                    {
                      i = 5;
                      continue;
                      if (((String)localObject).equals("floorNumberList")) {
                        i = 6;
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      localObject = i();
      this.H.addView(d("房间号"));
      this.H.addView((View)localObject);
      this.H.addView(b(20));
      continue;
      localObject = h();
      this.H.addView(d("面积"));
      this.H.addView((View)localObject);
      this.H.addView(b(20));
      continue;
      localObject = j();
      this.H.addView(d("选择城市"));
      this.H.addView((View)localObject);
      this.H.addView(b(20));
      continue;
      localObject = k();
      this.H.addView(d("可入住时间"));
      this.H.addView((View)localObject);
      this.H.addView(b(20));
      continue;
      localObject = l();
      this.H.addView(d("朝向"));
      this.H.addView((View)localObject);
      this.H.addView(b(20));
      continue;
      localObject = m();
      this.H.addView(d("楼层"));
      this.H.addView((View)localObject);
      this.H.addView(b(20));
    }
  }
  
  private View g()
  {
    int k = 0;
    View localView = LayoutInflater.from(this.a).inflate(2130905190, null);
    final TextView localTextView1 = (TextView)localView.findViewById(2131695007);
    localTextView1.setText("¥" + this.J.getData().getPrice().getMinPrice());
    final TextView localTextView2 = (TextView)localView.findViewById(2131697700);
    localTextView2.setText("¥" + this.J.getData().getPrice().getMaxPrice());
    RangeBar localRangeBar = (RangeBar)localView.findViewById(2131691679);
    localRangeBar.setTickCount(1001);
    int i = this.J.getData().getPrice().getMinPrice();
    int j = this.J.getData().getPrice().getMaxPrice();
    float f1;
    if (this.K.getPrice() != null)
    {
      this.K.getPrice().setMinPrice(i);
      this.K.getPrice().setMaxPrice(j);
      localRangeBar.setLeft(i);
      localRangeBar.setRight(j);
      if ((this.L != null) && (this.L.getPrice() != null))
      {
        i = this.J.getData().getPrice().getMinPrice();
        if (this.J.getData().getPrice().getMaxPrice() - i != 0) {
          break label544;
        }
        f1 = 1.0F;
        label265:
        if ((this.L.getPrice().getMinPrice() <= i) || (this.L.getPrice().getMinPrice() >= this.J.getData().getPrice().getMaxPrice())) {
          break label592;
        }
        j = (int)((this.L.getPrice().getMinPrice() - i) / f1);
        localTextView1.setText("¥" + (int)this.L.getPrice().getMinPrice());
      }
    }
    for (;;)
    {
      if ((this.L.getPrice().getMaxPrice() > i) && (this.L.getPrice().getMaxPrice() < this.J.getData().getPrice().getMaxPrice()))
      {
        i = (int)((this.L.getPrice().getMaxPrice() - i) / f1);
        localTextView2.setText("¥" + (int)this.L.getPrice().getMaxPrice());
      }
      for (;;)
      {
        if (j < 0) {
          j = k;
        }
        for (;;)
        {
          k = i;
          if (i > 1000) {
            k = 1000;
          }
          localRangeBar.setThumbIndices(j, k);
          localRangeBar.setOnRangeBarChangeListener(new RangeBar.a()
          {
            public void onIndexChangeListener(RangeBar paramAnonymousRangeBar, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              int i = paramAnonymousInt1;
              if (paramAnonymousInt1 < 0)
              {
                i = 0;
                paramAnonymousRangeBar.setLeft(0);
              }
              paramAnonymousInt1 = paramAnonymousInt2;
              if (paramAnonymousInt2 > 1000)
              {
                paramAnonymousRangeBar.setRight(1000);
                paramAnonymousInt1 = 1000;
              }
              if (ApartmentSearchActivity.a(ApartmentSearchActivity.this).getPrice() == null) {
                ApartmentSearchActivity.a(ApartmentSearchActivity.this).setPrice(new ZryuSearchConditionResult.PriceEntity());
              }
              paramAnonymousInt2 = ApartmentSearchActivity.b(ApartmentSearchActivity.this).getData().getPrice().getMinPrice();
              int j = ApartmentSearchActivity.b(ApartmentSearchActivity.this).getData().getPrice().getMaxPrice() - paramAnonymousInt2;
              ApartmentSearchActivity.a(ApartmentSearchActivity.this).getPrice().setMinPrice(i * j / 1000 + paramAnonymousInt2);
              ApartmentSearchActivity.a(ApartmentSearchActivity.this).getPrice().setMaxPrice(paramAnonymousInt2 + j * paramAnonymousInt1 / 1000);
              localTextView1.setText("¥" + (int)ApartmentSearchActivity.a(ApartmentSearchActivity.this).getPrice().getMinPrice());
              localTextView2.setText("¥" + (int)ApartmentSearchActivity.a(ApartmentSearchActivity.this).getPrice().getMaxPrice());
            }
          });
          return localView;
          ZryuSearchConditionResult.PriceEntity localPriceEntity = new ZryuSearchConditionResult.PriceEntity();
          localPriceEntity.setMinPrice(i);
          localPriceEntity.setMaxPrice(j);
          this.K.setPrice(localPriceEntity);
          break;
          label544:
          f1 = (this.J.getData().getPrice().getMaxPrice() - i) / 1000;
          break label265;
          if (j >= 1000) {
            j = 999;
          }
        }
        i = 1000;
      }
      label592:
      j = 0;
    }
  }
  
  private View h()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(16);
    Object localObject1 = new RelativeLayout(this.a);
    ((RelativeLayout)localObject1).setPadding(a(10.0F), 0, a(10.0F), 0);
    ((RelativeLayout)localObject1).setBackgroundResource(2130839553);
    Object localObject2 = new TextView(this.a);
    ((TextView)localObject2).setText("㎡");
    ((TextView)localObject2).setTextSize(14.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#dddddd"));
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(11);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    localObject3 = new EditText(this.a);
    ((EditText)localObject3).setInputType(2);
    ((EditText)localObject3).setHint("最小面积");
    ((EditText)localObject3).setPadding(0, 0, 0, 0);
    ((EditText)localObject3).setBackgroundColor(0);
    ((EditText)localObject3).setHintTextColor(Color.parseColor("#dddddd"));
    ((EditText)localObject3).setGravity(16);
    ((EditText)localObject3).setTextSize(14.0F);
    ((EditText)localObject3).setTextColor(Color.parseColor("#444444"));
    Object localObject4 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(15);
    ((EditText)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((EditText)localObject3).addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (ApartmentSearchActivity.a(ApartmentSearchActivity.this).getArea() == null) {
          ApartmentSearchActivity.a(ApartmentSearchActivity.this).setArea(new ZryuSearchConditionResult.AreaEntity());
        }
        ZryuSearchConditionResult.AreaEntity localAreaEntity = ApartmentSearchActivity.a(ApartmentSearchActivity.this).getArea();
        if (TextUtils.isEmpty(paramAnonymousEditable.toString())) {}
        for (paramAnonymousEditable = "0";; paramAnonymousEditable = paramAnonymousEditable.toString())
        {
          localAreaEntity.setMinArea(Double.parseDouble(paramAnonymousEditable));
          return;
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    ((RelativeLayout)localObject1).addView((View)localObject3);
    localObject2 = new RelativeLayout(this.a);
    ((RelativeLayout)localObject2).setPadding(a(10.0F), 0, a(10.0F), 0);
    ((RelativeLayout)localObject2).setBackgroundResource(2130839553);
    Object localObject5 = new TextView(this.a);
    ((TextView)localObject5).setText("㎡");
    ((TextView)localObject5).setTextSize(14.0F);
    ((TextView)localObject5).setTextColor(Color.parseColor("#dddddd"));
    Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject6).addRule(11);
    ((RelativeLayout.LayoutParams)localObject6).addRule(15);
    ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    ((RelativeLayout)localObject2).addView((View)localObject5);
    localObject5 = new EditText(this.a);
    ((EditText)localObject5).setInputType(2);
    ((EditText)localObject5).setHint("最大面积");
    ((EditText)localObject5).setHintTextColor(Color.parseColor("#dddddd"));
    ((EditText)localObject5).setPadding(0, 0, 0, 0);
    ((EditText)localObject5).setGravity(16);
    ((EditText)localObject5).setBackgroundColor(0);
    ((EditText)localObject5).setTextSize(14.0F);
    ((EditText)localObject5).setTextColor(Color.parseColor("#444444"));
    new RelativeLayout.LayoutParams(-1, -2).addRule(15);
    ((EditText)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((EditText)localObject5).addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (ApartmentSearchActivity.a(ApartmentSearchActivity.this).getArea() == null) {
          ApartmentSearchActivity.a(ApartmentSearchActivity.this).setArea(new ZryuSearchConditionResult.AreaEntity());
        }
        ZryuSearchConditionResult.AreaEntity localAreaEntity = ApartmentSearchActivity.a(ApartmentSearchActivity.this).getArea();
        if (TextUtils.isEmpty(paramAnonymousEditable.toString())) {}
        for (paramAnonymousEditable = "0";; paramAnonymousEditable = paramAnonymousEditable.toString())
        {
          localAreaEntity.setMaxArea(Double.parseDouble(paramAnonymousEditable));
          return;
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    ((RelativeLayout)localObject2).addView((View)localObject5);
    if ((this.L != null) && (this.L.getArea() != null))
    {
      ((EditText)localObject3).setText((int)this.L.getArea().getMinArea() + "");
      ((EditText)localObject5).setText((int)this.L.getArea().getMaxArea() + "");
    }
    localObject3 = new View(this.a);
    ((View)localObject3).setBackgroundColor(Color.parseColor("#444444"));
    localObject4 = new LinearLayout.LayoutParams(a(12.0F), a(1.0F));
    ((LinearLayout.LayoutParams)localObject4).setMargins(a(10.0F), 0, a(10.0F), 0);
    localObject5 = new LinearLayout.LayoutParams(0, a(32.0F), 1.0F);
    localObject6 = new LinearLayout.LayoutParams(0, a(32.0F), 1.0F);
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject5);
    localLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject6);
    localObject1 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject1).setMargins(a(16.0F), a(16.0F), a(16.0F), 0);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    return localLinearLayout;
  }
  
  private View i()
  {
    EditText localEditText = new EditText(this.a);
    localEditText.setHint("请输入房间号");
    localEditText.setHintTextColor(Color.parseColor("#dddddd"));
    localEditText.setPadding(a(10.0F), 0, a(10.0F), 0);
    localEditText.setGravity(16);
    localEditText.setBackgroundResource(2130839553);
    localEditText.setTextSize(14.0F);
    localEditText.setTextColor(Color.parseColor("#444444"));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, a(32.0F));
    localLayoutParams.setMargins(a(16.0F), a(16.0F), a(16.0F), 0);
    localEditText.setLayoutParams(localLayoutParams);
    localEditText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        ApartmentSearchActivity.a(ApartmentSearchActivity.this).setRoomNumber(paramAnonymousEditable.toString());
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if ((this.L != null) && (this.L.getRoomNumber() != null)) {
      localEditText.setText(this.L.getRoomNumber());
    }
    return localEditText;
  }
  
  private View j()
  {
    this.I = new FlowLayout(this.a, null);
    if ((this.L != null) && ((!TextUtils.isEmpty(this.L.getCity())) || (this.L.isCityAll()))) {}
    for (int i = 1;; i = 0)
    {
      int j = 0;
      if (j < this.J.getData().getCityList().size())
      {
        if ((i != 0) && (this.L.isCityAll()) && (TextUtils.isEmpty(((ZryuSearchCondition.DataEntity.CityListBean)this.J.getData().getCityList().get(j)).getCityCode()))) {
          this.I.addView(a(this.J.getData().getCityList().get(j), true, 257));
        }
        for (;;)
        {
          j += 1;
          break;
          if ((i != 0) && (!TextUtils.isEmpty(((ZryuSearchCondition.DataEntity.CityListBean)this.J.getData().getCityList().get(j)).getCityCode())) && (((ZryuSearchCondition.DataEntity.CityListBean)this.J.getData().getCityList().get(j)).getCityCode().equals(this.L.getCity()))) {
            this.I.addView(a(this.J.getData().getCityList().get(j), true, 257));
          } else {
            this.I.addView(a(this.J.getData().getCityList().get(j), false, 257));
          }
        }
      }
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(0, a(20.0F), 0, 0);
      this.I.setLayoutParams(localLayoutParams);
      return this.I;
    }
  }
  
  private View k()
  {
    FlowLayout localFlowLayout = new FlowLayout(this.a, null);
    Object localObject;
    if ((this.L != null) && (!TextUtils.isEmpty(this.L.getCheckInTime()))) {
      localObject = this.L.getCheckInTime().split(",");
    }
    for (int i = 1;; i = 0)
    {
      int j = 0;
      if (j < this.J.getData().getCheckInTime().size())
      {
        int k;
        if (i != 0)
        {
          k = 0;
          label77:
          if (k < localObject.length)
          {
            if (!(((ZryuSearchCondition.DataEntity.CheckInTimeBean)this.J.getData().getCheckInTime().get(j)).getState() + "").equals(localObject[k])) {
              break label170;
            }
            localFlowLayout.addView(a(this.J.getData().getCheckInTime().get(j), true, 259));
          }
        }
        for (;;)
        {
          j += 1;
          break;
          label170:
          if (k == localObject.length - 1) {
            localFlowLayout.addView(a(this.J.getData().getCheckInTime().get(j), false, 259));
          }
          k += 1;
          break label77;
          localFlowLayout.addView(a(this.J.getData().getCheckInTime().get(j), false, 259));
        }
      }
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, a(20.0F), 0, 0);
      localFlowLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return localFlowLayout;
      localObject = null;
    }
  }
  
  private View l()
  {
    FlowLayout localFlowLayout = new FlowLayout(this.a, null);
    Object localObject;
    if ((this.L != null) && (!TextUtils.isEmpty(this.L.getDirection()))) {
      localObject = this.L.getDirection().split(",");
    }
    for (int i = 1;; i = 0)
    {
      int j = 0;
      if (j < this.J.getData().getDirectionList().size())
      {
        int k;
        if (i != 0)
        {
          k = 0;
          label77:
          if (k < localObject.length)
          {
            if (!(((ZryuSearchCondition.DataEntity.DirectionListBean)this.J.getData().getDirectionList().get(j)).getState() + "").equals(localObject[k])) {
              break label170;
            }
            localFlowLayout.addView(a(this.J.getData().getDirectionList().get(j), true, 260));
          }
        }
        for (;;)
        {
          j += 1;
          break;
          label170:
          if (k == localObject.length - 1) {
            localFlowLayout.addView(a(this.J.getData().getDirectionList().get(j), false, 260));
          }
          k += 1;
          break label77;
          localFlowLayout.addView(a(this.J.getData().getDirectionList().get(j), false, 260));
        }
      }
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, a(20.0F), 0, 0);
      localFlowLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return localFlowLayout;
      localObject = null;
    }
  }
  
  private View m()
  {
    FlowLayout localFlowLayout = new FlowLayout(this.a, null);
    Object localObject;
    if ((this.L != null) && (!TextUtils.isEmpty(this.L.getFloor()))) {
      localObject = this.L.getFloor().split(",");
    }
    for (int i = 1;; i = 0)
    {
      int j = 0;
      if (j < this.J.getData().getFloorNumberList().size())
      {
        int k;
        if (i != 0)
        {
          k = 0;
          label77:
          if (k < localObject.length)
          {
            if (!(((ZryuSearchCondition.DataEntity.FloorNumberListBean)this.J.getData().getFloorNumberList().get(j)).getState() + "").equals(localObject[k])) {
              break label170;
            }
            localFlowLayout.addView(a(this.J.getData().getFloorNumberList().get(j), true, 258));
          }
        }
        for (;;)
        {
          j += 1;
          break;
          label170:
          if (k == localObject.length - 1) {
            localFlowLayout.addView(a(this.J.getData().getFloorNumberList().get(j), false, 258));
          }
          k += 1;
          break label77;
          localFlowLayout.addView(a(this.J.getData().getFloorNumberList().get(j), false, 258));
        }
      }
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, a(20.0F), 0, 0);
      localFlowLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return localFlowLayout;
      localObject = null;
    }
  }
  
  private void n()
  {
    this.L = new ZryuSearchConditionResult();
    this.H.removeAllViews();
    f();
    this.K = new ZryuSearchConditionResult();
  }
  
  private void o()
  {
    switch (this.d)
    {
    }
    for (;;)
    {
      finishAfterSubmit();
      return;
      ZryuSearchConditionRecord.getInstance().setProjectRecord(this.K);
      continue;
      ZryuSearchConditionRecord.getInstance().setHouseRecord(this.K);
      continue;
      ZryuSearchConditionRecord.getInstance().setRoomRecord(this.K);
    }
  }
  
  public void finishAfterSubmit()
  {
    Intent localIntent = getIntent();
    if ((this.d == 1) && (MainActivity.class.getPackage().getName().equals(localIntent.getComponent().getPackageName())))
    {
      localIntent = new Intent();
      localIntent.setComponent(new ComponentName(MainActivity.class.getPackage().getName(), ZryuProjectListActivity.class.getName()));
      localIntent.putExtra("search_condition_result", this.K);
      startActivity(localIntent);
    }
    for (;;)
    {
      finish();
      return;
      localIntent.putExtra("search_condition_result", this.K);
      setResult(-1, localIntent);
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131696484: 
      n();
      return;
    case 2131691493: 
      finish();
      return;
    }
    if ((this.K.getArea() != null) && (this.K.getArea().getMinArea() > this.K.getArea().getMaxArea()))
    {
      af.showToast(this.a, "最小面积不能大于最大面积!");
      return;
    }
    o();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903095);
    getWindow().setSoftInputMode(32);
    this.a = this;
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ApartmentSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */