package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.ziroomstation.PhotoPreviewActivity;
import com.ziroom.ziroomcustomer.ziroomstation.a.b;
import com.ziroom.ziroomcustomer.ziroomstation.fragment.StationRoomFragment.a;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationRoom.DataBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class m
  extends BaseAdapter
{
  private List<StationRoom.DataBean> a;
  private Context b;
  private LayoutInflater c;
  private StationRoomFragment.a d;
  private b e = new b()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      if (paramAnonymousView.getTag() == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add((String)paramAnonymousView.getTag());
      paramAnonymousView = new Intent(m.c(m.this), PhotoPreviewActivity.class);
      paramAnonymousView.putStringArrayListExtra("photoDescription", localArrayList);
      paramAnonymousView.putExtra("position", 0);
      paramAnonymousView.putExtra("isDeleteable", false);
      ((Activity)m.c(m.this)).startActivityForResult(paramAnonymousView, 257);
    }
  };
  
  public m(Context paramContext, List<StationRoom.DataBean> paramList, StationRoomFragment.a parama)
  {
    this.b = paramContext;
    this.a = paramList;
    this.c = LayoutInflater.from(paramContext);
    this.d = parama;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, final View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (a)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      paramView.a.setTag(((StationRoom.DataBean)this.a.get(paramInt)).imgUrl);
      paramView.a.setOnClickListener(this.e);
      paramView.a.setController(c.frescoController(((StationRoom.DataBean)this.a.get(paramInt)).imgUrl));
      paramView.b.setText(((StationRoom.DataBean)this.a.get(paramInt)).houseShowName);
      paramView.c.setText("面积:" + (int)((StationRoom.DataBean)this.a.get(paramInt)).houseArea + "㎡");
      paramView.d.setText("床型:" + ((StationRoom.DataBean)this.a.get(paramInt)).bedTypeName);
      if (((StationRoom.DataBean)this.a.get(paramInt)).minPrice != ((StationRoom.DataBean)this.a.get(paramInt)).maxPrice) {
        break label578;
      }
      localObject = "¥" + (int)((StationRoom.DataBean)this.a.get(paramInt)).minPrice;
      label262:
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
      localSpannableString.setSpan(new TextAppearanceSpan(this.b, 2131427935), 0, 1, 33);
      localSpannableString.setSpan(new TextAppearanceSpan(this.b, 2131427936), 1, ((String)localObject).length(), 33);
      paramView.e.setText(localSpannableString);
      paramView.f.setText("床位:" + ((StationRoom.DataBean)this.a.get(paramInt)).bedCount + "个");
      paramView.g.setVisibility(4);
      if (((StationRoom.DataBean)this.a.get(paramInt)).usedCount != 0) {
        break label643;
      }
      paramView.h.setVisibility(4);
      paramView.i.setVisibility(4);
      label419:
      if ((((StationRoom.DataBean)this.a.get(paramInt)).availableCount != 0) && (((StationRoom.DataBean)this.a.get(paramInt)).isValid != 0)) {
        break label674;
      }
      paramView.h.setClickable(false);
      paramView.h.setImageResource(2130839768);
      paramView.j.setClickable(false);
      paramView.j.setImageResource(2130839762);
      if (((StationRoom.DataBean)this.a.get(paramInt)).availableCount != 0) {
        break label662;
      }
      paramView.k.setText("(已满)");
      label519:
      paramView.i.setTextColor(-7829368);
    }
    for (;;)
    {
      if (paramInt != this.a.size() - 1) {
        break label828;
      }
      paramView.l.setVisibility(0);
      return paramViewGroup;
      paramViewGroup = this.c.inflate(2130904203, paramViewGroup, false);
      paramView = a.a(paramViewGroup);
      paramViewGroup.setTag(paramView);
      break;
      label578:
      localObject = "¥" + (int)((StationRoom.DataBean)this.a.get(paramInt)).minPrice + "-" + (int)((StationRoom.DataBean)this.a.get(paramInt)).maxPrice;
      break label262;
      label643:
      paramView.h.setVisibility(0);
      paramView.i.setVisibility(0);
      break label419;
      label662:
      paramView.k.setText("(敬请期待)");
      break label519;
      label674:
      paramView.i.setTextColor(-12303292);
      paramView.k.setText("");
      paramView.h.setImageResource(2130839767);
      paramView.j.setImageResource(2130839761);
      paramView.h.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (((StationRoom.DataBean)m.a(m.this).get(paramInt)).usedCount > 0)
          {
            paramAnonymousView = paramView.i;
            StringBuilder localStringBuilder = new StringBuilder();
            StationRoom.DataBean localDataBean = (StationRoom.DataBean)m.a(m.this).get(paramInt);
            int i = localDataBean.usedCount - 1;
            localDataBean.usedCount = i;
            paramAnonymousView.setText(i + "");
            paramView.j.setClickable(true);
            paramView.j.setImageResource(2130839761);
            if (((StationRoom.DataBean)m.a(m.this).get(paramInt)).usedCount == 0)
            {
              paramView.i.setText(((StationRoom.DataBean)m.a(m.this).get(paramInt)).usedCount + "");
              paramView.h.setClickable(false);
              paramView.h.setImageResource(2130839768);
            }
          }
          for (;;)
          {
            m.b(m.this).numChange(paramInt, ((StationRoom.DataBean)m.a(m.this).get(paramInt)).usedCount);
            if (!TextUtils.isEmpty(((StationRoom.DataBean)m.a(m.this).get(paramInt)).houseTypeBid))
            {
              paramAnonymousView = new HashMap();
              paramAnonymousView.put("hid", ((StationRoom.DataBean)m.a(m.this).get(paramInt)).houseTypeBid);
              w.onEventValueToZiroomAndUmeng("zinn_detail_num_del", paramAnonymousView);
            }
            return;
            paramView.i.setText(((StationRoom.DataBean)m.a(m.this).get(paramInt)).usedCount + "");
            paramView.h.setClickable(false);
            paramView.h.setImageResource(2130839768);
          }
        }
      });
      paramView.i.setText(((StationRoom.DataBean)this.a.get(paramInt)).usedCount + "");
      paramView.j.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramView.h.setVisibility(0);
          paramView.i.setVisibility(0);
          if (((StationRoom.DataBean)m.a(m.this).get(paramInt)).usedCount < ((StationRoom.DataBean)m.a(m.this).get(paramInt)).availableCount)
          {
            paramAnonymousView = paramView.i;
            StringBuilder localStringBuilder = new StringBuilder();
            StationRoom.DataBean localDataBean = (StationRoom.DataBean)m.a(m.this).get(paramInt);
            int i = localDataBean.usedCount + 1;
            localDataBean.usedCount = i;
            paramAnonymousView.setText(i + "");
            paramView.h.setClickable(true);
            paramView.h.setImageResource(2130839767);
            if (((StationRoom.DataBean)m.a(m.this).get(paramInt)).usedCount == ((StationRoom.DataBean)m.a(m.this).get(paramInt)).availableCount)
            {
              paramView.i.setText(((StationRoom.DataBean)m.a(m.this).get(paramInt)).usedCount + "");
              paramView.j.setClickable(false);
              paramView.j.setImageResource(2130839762);
            }
          }
          for (;;)
          {
            m.b(m.this).numChange(paramInt, ((StationRoom.DataBean)m.a(m.this).get(paramInt)).usedCount);
            if (!TextUtils.isEmpty(((StationRoom.DataBean)m.a(m.this).get(paramInt)).houseTypeBid))
            {
              paramAnonymousView = new HashMap();
              paramAnonymousView.put("hid", ((StationRoom.DataBean)m.a(m.this).get(paramInt)).houseTypeBid);
              w.onEventValueToZiroomAndUmeng("zinn_detail_num_add", paramAnonymousView);
            }
            return;
            paramView.i.setText(((StationRoom.DataBean)m.a(m.this).get(paramInt)).usedCount + "");
            paramView.j.setClickable(false);
            paramView.j.setImageResource(2130839762);
          }
        }
      });
      if (((StationRoom.DataBean)this.a.get(paramInt)).usedCount == 0)
      {
        paramView.h.setClickable(false);
        paramView.h.setImageResource(2130839768);
      }
    }
    label828:
    paramView.l.setVisibility(8);
    return paramViewGroup;
  }
  
  public void setData(List<StationRoom.DataBean> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  static class a
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    TextView f;
    TextView g;
    ImageView h;
    TextView i;
    ImageView j;
    TextView k;
    View l;
    
    public a(SimpleDraweeView paramSimpleDraweeView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5, TextView paramTextView6, ImageView paramImageView1, TextView paramTextView7, ImageView paramImageView2, TextView paramTextView8, View paramView)
    {
      this.a = paramSimpleDraweeView;
      this.b = paramTextView1;
      this.c = paramTextView2;
      this.d = paramTextView3;
      this.e = paramTextView4;
      this.f = paramTextView5;
      this.g = paramTextView6;
      this.h = paramImageView1;
      this.i = paramTextView7;
      this.j = paramImageView2;
      this.k = paramTextView8;
      this.l = paramView;
    }
    
    private static a b(View paramView)
    {
      return new a((SimpleDraweeView)paramView.findViewById(2131689744), (TextView)paramView.findViewById(2131694996), (TextView)paramView.findViewById(2131694289), (TextView)paramView.findViewById(2131695011), (TextView)paramView.findViewById(2131695012), (TextView)paramView.findViewById(2131695013), (TextView)paramView.findViewById(2131695014), (ImageView)paramView.findViewById(2131695015), (TextView)paramView.findViewById(2131695016), (ImageView)paramView.findViewById(2131695017), (TextView)paramView.findViewById(2131695010), paramView.findViewById(2131695018));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */