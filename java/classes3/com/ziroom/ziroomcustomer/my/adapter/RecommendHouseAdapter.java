package com.ziroom.ziroomcustomer.my.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuHouseDetailActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuTopHouseDetailActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCmsBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCmsBean.DataBean;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.StationProjectDetailActivity;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;
import java.util.List;

public class RecommendHouseAdapter
  extends RecyclerView.a
{
  MinsuCmsBean a;
  Context b;
  
  public int getItemCount()
  {
    if (!s.isEmpty(this.a.data)) {
      return this.a.data.size();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.u paramu, int paramInt)
  {
    final MinsuCmsBean.DataBean localDataBean = (MinsuCmsBean.DataBean)this.a.data.get(paramInt);
    Object localObject = new GenericDraweeHierarchyBuilder(this.b.getResources()).setFadeDuration(300).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_XY).build();
    ((RecyclerViewHolder)paramu).iv_img.setHierarchy((DraweeHierarchy)localObject);
    ((RecyclerViewHolder)paramu).iv_img.setController(c.frescoController(localDataBean.pic));
    if ("0".equals(localDataBean.types))
    {
      localObject = new SpannableString("自如民宿 ·" + localDataBean.title);
      ((SpannableString)localObject).setSpan(new StyleSpan(1), 0, 5, 33);
      ((RecyclerViewHolder)paramu).tv_title.setText((CharSequence)localObject);
    }
    for (;;)
    {
      ((RecyclerViewHolder)paramu).tv_subtitle.setText(localDataBean.subtitle);
      ((RecyclerViewHolder)paramu).tv_price.setVisibility(8);
      if (("0".equals(localDataBean.types)) && (!TextUtils.isEmpty(localDataBean.rgb)))
      {
        ((RecyclerViewHolder)paramu).tv_price.setVisibility(0);
        localObject = new SpannableString("¥" + localDataBean.rgb + " 元/晚");
        ((SpannableString)localObject).setSpan(new StyleSpan(1), 0, localDataBean.rgb.length() + 1, 33);
        ((RecyclerViewHolder)paramu).tv_price.setText((CharSequence)localObject);
      }
      paramu.itemView.setOnClickListener(new View.OnClickListener()
      {
        private String c;
        private String d;
        private String e;
        
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          int j = 0;
          VdsAgent.onClick(this, paramAnonymousView);
          Object localObject = localDataBean.url;
          paramAnonymousView = (View)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramAnonymousView = ((String)localObject).replace("&quot;", "");
            this.d = h.getJsonString(paramAnonymousView, "fid");
            this.c = h.getJsonString(paramAnonymousView, "rentWay");
            this.e = h.getJsonString(paramAnonymousView, "isTop50Online");
          }
          if ("0".equals(localDataBean.types)) {
            if ("1".equals(this.e)) {
              paramAnonymousView = new Intent(RecommendHouseAdapter.this.b, MinsuTopHouseDetailActivity.class);
            }
          }
          for (;;)
          {
            paramAnonymousView.putExtra("fid", this.d);
            int i = j;
            if (!TextUtils.isEmpty(this.c)) {}
            try
            {
              i = Integer.valueOf(this.c).intValue();
              paramAnonymousView.putExtra("rentWay", i);
              RecommendHouseAdapter.this.b.startActivity(paramAnonymousView);
              do
              {
                return;
                paramAnonymousView = new Intent(RecommendHouseAdapter.this.b, MinsuHouseDetailActivity.class);
                break;
              } while (!"1".equals(localDataBean.types));
              localObject = new Intent(RecommendHouseAdapter.this.b, StationProjectDetailActivity.class);
              ((Intent)localObject).putExtra("projectBid", paramAnonymousView);
              RecommendHouseAdapter.this.b.startActivity((Intent)localObject);
              return;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                i = j;
              }
            }
          }
        }
      });
      return;
      if ("1".equals(localDataBean.types))
      {
        localObject = new SpannableString("自如驿 · " + localDataBean.title);
        ((SpannableString)localObject).setSpan(new StyleSpan(1), 0, 4, 33);
        ((RecyclerViewHolder)paramu).tv_title.setText((CharSequence)localObject);
      }
      else
      {
        ((RecyclerViewHolder)paramu).tv_title.setText(localDataBean.title);
      }
    }
  }
  
  public RecyclerView.u onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    this.b = paramViewGroup.getContext();
    return new RecyclerViewHolder(LayoutInflater.from(this.b).inflate(2130904395, paramViewGroup, false));
  }
  
  public void setData(MinsuCmsBean paramMinsuCmsBean)
  {
    this.a = paramMinsuCmsBean;
  }
  
  public static class RecyclerViewHolder
    extends RecyclerView.u
  {
    @BindView(2131695428)
    SimpleDraweeView iv_img;
    @BindView(2131695429)
    TextView tv_price;
    @BindView(2131695431)
    TextView tv_subtitle;
    @BindView(2131695430)
    TextView tv_title;
    
    public RecyclerViewHolder(View paramView)
    {
      super();
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/RecommendHouseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */