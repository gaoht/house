package com.ziroom.ziroomcustomer.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.activity.EvaluateSignActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.model.MyAppoint;
import com.ziroom.ziroomcustomer.my.MyApartUnEvaAppointFragment;
import com.ziroom.ziroomcustomer.my.MyFinishedAppointFragment;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.ziroomapartment.a.b;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuEvaluateActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAppointAdapter
  extends BaseAdapter
{
  private List<MyAppoint> a;
  private List<String> b;
  private Context c;
  private Map<String, String> d;
  private Map<String, String> e;
  private int f = 0;
  private final String g = "没有未处理的约看请求";
  private final int h = 0;
  private final int i = 1;
  private b j;
  
  public MyAppointAdapter(Context paramContext, List<MyAppoint> paramList, List<String> paramList1, int paramInt)
  {
    this.c = paramContext;
    this.a = paramList;
    this.b = paramList1;
    this.f = paramInt;
    a();
  }
  
  private void a()
  {
    this.d = new HashMap();
    this.e = new HashMap();
    this.d.put("1", "待确认");
    this.d.put("2", "待看房");
    this.d.put("3", "已完成");
    this.d.put("4", "已取消");
    this.d.put("5", "已过期");
    this.e.put("zxpzz", "装修配置中");
    this.e.put("dzz", "待租中");
    this.e.put("yxd", "已下定");
    this.e.put("ycz", "已出租");
    this.e.put("tzpzz", "退租配置中");
    this.e.put("kyd", "可预订");
  }
  
  private void a(ViewHolder paramViewHolder, MyAppoint paramMyAppoint)
  {
    if (("1".equals(paramMyAppoint.getViewEvaluate())) && ("0".equals(paramMyAppoint.getIsEvaluate())))
    {
      paramViewHolder.tvAppointSeeEvaluate.setVisibility(0);
      paramViewHolder.tvAppointDel.setVisibility(8);
      paramViewHolder.tvAppointEvaluate.setVisibility(8);
      return;
    }
    if (("0".equals(paramMyAppoint.getViewEvaluate())) && ("1".equals(paramMyAppoint.getIsEvaluate())))
    {
      paramViewHolder.tvAppointSeeEvaluate.setVisibility(8);
      paramViewHolder.tvAppointEvaluate.setVisibility(0);
      if ("5".equals(paramMyAppoint.getAppointStatus())) {
        paramViewHolder.tvAppointStatus.setText((CharSequence)this.d.get(paramMyAppoint.getAppointStatus()));
      }
      for (;;)
      {
        paramViewHolder.tvAppointDel.setVisibility(8);
        return;
        paramViewHolder.tvAppointStatus.setText("待评价");
      }
    }
    paramViewHolder.tvAppointSeeEvaluate.setVisibility(8);
    paramViewHolder.tvAppointEvaluate.setVisibility(8);
    paramViewHolder.tvAppointDel.setVisibility(0);
  }
  
  private void a(final String paramString)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.c).setTitle("提示").setContent("确定要取消订单吗？").setBtnConfirmText("确定").setBtnCancelText("我再想想").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("bid", paramString);
          b.convertor(MyAppointAdapter.a(MyAppointAdapter.this), paramAnonymousView);
          com.ziroom.ziroomcustomer.ziroomapartment.a.e.cancelZryuAppointList(MyAppointAdapter.a(MyAppointAdapter.this), new MyAppointAdapter.a(MyAppointAdapter.this), paramAnonymousView, true);
        }
      }
    }).build().show();
  }
  
  private void a(final String paramString, final int paramInt)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.c).setTitle("提示").setContent("确定要删除订单吗？").setBtnConfirmText("确定").setBtnCancelText("我再想想").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        ArrayList localArrayList;
        MyAppointAdapter.c localc;
        if (paramAnonymousBoolean)
        {
          paramAnonymousView = new HashMap();
          localArrayList = new ArrayList();
          localc = new MyAppointAdapter.c();
        }
        try
        {
          localc.setOrderId(Integer.parseInt(paramString));
          localc.setOrderType(paramInt);
          localArrayList.add(localc);
          paramAnonymousView.put("uid", ApplicationEx.c.getUserId((Activity)MyAppointAdapter.a(MyAppointAdapter.this)));
          paramAnonymousView.put("orderInfoJson", com.alibaba.fastjson.a.toJSONString(localArrayList));
          com.ziroom.ziroomcustomer.e.g.appendCommenParams(paramAnonymousView);
          j.delMyFinishedAppointBatch(MyAppointAdapter.a(MyAppointAdapter.this), new MyAppointAdapter.a(MyAppointAdapter.this), paramAnonymousView, true);
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            localNumberFormatException.printStackTrace();
          }
        }
      }
    }).build().show();
  }
  
  private void a(final String paramString1, final String paramString2)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.c).setTitle("提示").setContent("好房不等人哦，是否要取消约看？").setBtnConfirmText("确定").setBtnCancelText("我再想想").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("uid", ApplicationEx.c.getUserId((Activity)MyAppointAdapter.a(MyAppointAdapter.this)));
          paramAnonymousView.put("orderId", paramString1);
          paramAnonymousView.put("orderType", paramString2);
          com.ziroom.ziroomcustomer.e.g.appendCommenParams(paramAnonymousView);
          j.cancelMyAppointOrder(MyAppointAdapter.a(MyAppointAdapter.this), new MyAppointAdapter.a(MyAppointAdapter.this), paramAnonymousView, true);
        }
      }
    }).build().show();
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
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.a == null) || (this.a.size() < 1) || (this.a.get(paramInt) == null)) {
      return 0;
    }
    if ("zra".equals(((MyAppoint)this.a.get(paramInt)).getSource())) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    final View localView;
    label37:
    final MyAppoint localMyAppoint;
    final Object localObject1;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.c).inflate(2130904390, paramViewGroup, false);
      paramViewGroup = new ViewHolder(localView);
      localView.setTag(paramViewGroup);
      localMyAppoint = (MyAppoint)this.a.get(paramInt);
      localObject1 = paramViewGroup.tvAppointTime;
      localObject2 = new StringBuilder().append("约看时间：");
      if (!ae.isNull(localMyAppoint.getAppointTime())) {
        break label524;
      }
      paramView = "-";
      label88:
      ((TextView)localObject1).setText(paramView);
      localObject1 = paramViewGroup.tvAppointLocation;
      localObject2 = new StringBuilder().append("约看地点：");
      if (!ae.isNull(localMyAppoint.getAppointAddr())) {
        break label533;
      }
      paramView = "-";
      label138:
      ((TextView)localObject1).setText(paramView);
      paramViewGroup.ivAppointPic.setController(com.freelxl.baselibrary.f.c.frescoController(localMyAppoint.getHousePhoto()));
      paramViewGroup.ivKeeperPic.setController(com.freelxl.baselibrary.f.c.frescoController(localMyAppoint.getKeeperHeadCorn(), new Postprocessor()
      {
        public String getName()
        {
          return null;
        }
        
        public CacheKey getPostprocessorCacheKey()
        {
          return null;
        }
        
        public CloseableReference<Bitmap> process(Bitmap paramAnonymousBitmap, PlatformBitmapFactory paramAnonymousPlatformBitmapFactory)
        {
          return paramAnonymousPlatformBitmapFactory.createBitmap(Bitmap.createBitmap(paramAnonymousBitmap, 0, 0, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getWidth()));
        }
      }));
      paramViewGroup.tvHouseStatus.setText((CharSequence)this.e.get(localMyAppoint.getHouseStatus()));
      paramViewGroup.tvAppointPrice.setText("季付价·" + localMyAppoint.getRent());
      paramViewGroup.tvAppointUnit.setText(localMyAppoint.getRentUnit());
      paramViewGroup.tvKeeperName.setText(localMyAppoint.getKeeperName());
      if (1 != this.f) {
        break label542;
      }
      paramViewGroup.tvAppointCancel.setVisibility(8);
    }
    for (;;)
    {
      localObject1 = (MyAppoint)this.a.get(paramInt);
      paramView = null;
      switch (getItemViewType(paramInt))
      {
      default: 
        if (ae.isNull(localMyAppoint.getVillageName()))
        {
          paramViewGroup.ll_appoint.setVisibility(8);
          paramViewGroup.ivAppointPic.setVisibility(8);
          paramViewGroup.tv_appoint_hint.setVisibility(0);
        }
        paramViewGroup.tvKeeperTel.setOnClickListener(paramView);
        paramViewGroup.tvAppointCancel.setOnClickListener(paramView);
        paramViewGroup.tvAppointDel.setOnClickListener(paramView);
        paramViewGroup.tvAppointEvaluate.setOnClickListener(paramView);
        paramViewGroup.tvAppointSeeEvaluate.setOnClickListener(paramView);
        localView.setOnClickListener(paramView);
        if ((8 != paramViewGroup.tvAppointCancel.getVisibility()) || (8 != paramViewGroup.tvAppointDel.getVisibility()) || (8 != paramViewGroup.tvAppointEvaluate.getVisibility()) || (8 != paramViewGroup.tvAppointSeeEvaluate.getVisibility())) {
          break label1557;
        }
        paramView = (LinearLayout.LayoutParams)paramViewGroup.ll_button_container.getLayoutParams();
        paramView.width = n.dip2px(this.c, 164.0F);
        paramViewGroup.ll_button_container.setLayoutParams(paramView);
        return localView;
        paramViewGroup = (ViewHolder)paramView.getTag();
        paramViewGroup.tvAppointStatus.setTag(Integer.valueOf(paramInt));
        localView = paramView;
        break label37;
        label524:
        paramView = localMyAppoint.getAppointTime();
        break label88;
        label533:
        paramView = localMyAppoint.getAppointAddr();
        break label138;
        label542:
        paramViewGroup.tvAppointCancel.setVisibility(0);
      }
    }
    paramView = new StringBuilder();
    Object localObject2 = localMyAppoint.getHouseType();
    switch (((String)localObject2).hashCode())
    {
    default: 
      label608:
      paramInt = -1;
      switch (paramInt)
      {
      default: 
        label610:
        paramView.append("自如整租");
        label644:
        paramView.append("·").append(localMyAppoint.getVillageName()).append(localMyAppoint.getBedroom());
        if ("1".equals(localMyAppoint.getHouseType()))
        {
          paramView.append("居室").append("-").append(localMyAppoint.getNumber()).append("卧");
          label709:
          paramView = paramView.toString();
          paramViewGroup.tvAppointTitle.setText(paramView);
          paramViewGroup.tvAppointStatus.setText((CharSequence)this.d.get(localMyAppoint.getAppointStatus()));
          paramView = localMyAppoint.getArea() + "㎡ · " + localMyAppoint.getFloor() + "层";
          paramViewGroup.tvAppointArea.setText(paramView);
          paramViewGroup.tvHouseStatus.setText((CharSequence)this.e.get(localMyAppoint.getHouseStatus()));
          paramView = localMyAppoint.getAppointStatus();
          switch (paramView.hashCode())
          {
          default: 
            label860:
            paramInt = -1;
            switch (paramInt)
            {
            default: 
              label862:
              label896:
              if ("已完成".equals(paramViewGroup.tvAppointStatus.getText())) {
                paramViewGroup.tvAppointStatus.setTextColor(this.c.getResources().getColor(2131624597));
              }
              break;
            }
            break;
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      paramView = new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          int i = 3;
          VdsAgent.onClick(this, paramAnonymousView);
          if (paramAnonymousView == paramViewGroup.tvKeeperTel)
          {
            d.i("====appoint", "call tel:" + localObject1.getKeeperPhone());
            ah.callPhone(MyAppointAdapter.a(MyAppointAdapter.this), localObject1.getKeeperPhone());
          }
          do
          {
            return;
            if (paramAnonymousView == paramViewGroup.tvAppointCancel)
            {
              d.i("====appoint", "cancel appoint clicked");
              w.onEventToZiroomAndUmeng("zra_book_cancel");
              MyAppointAdapter.a(MyAppointAdapter.this, localObject1.getOrderId(), localObject1.getAppointStatus());
              return;
            }
            if (paramAnonymousView == paramViewGroup.tvAppointDel)
            {
              d.i("====appoint", "delete appoint clicked");
              MyAppointAdapter.a(MyAppointAdapter.this, localObject1.getOrderId(), localObject1.getOrderType());
              return;
            }
            if (paramAnonymousView == paramViewGroup.tvAppointEvaluate)
            {
              d.i("====appoint", "youjia evaluate appoint clicked");
              if ("5".equals(localObject1.getAppointStatus())) {}
              for (;;)
              {
                paramAnonymousView = new Intent(MyAppointAdapter.a(MyAppointAdapter.this), EvaluateSignActivity.class);
                paramAnonymousView.putExtra("sceneCode", i);
                paramAnonymousView.putExtra("orderCode", localObject1.getOrderKey());
                ((BaseActivity)MyAppointAdapter.a(MyAppointAdapter.this)).startActivityForResult(paramAnonymousView, 4660);
                return;
                i = 1;
              }
            }
            if (paramAnonymousView == paramViewGroup.tvAppointSeeEvaluate)
            {
              d.i("====appoint", "youjia evaluate appoint clicked");
              if ("5".equals(localObject1.getAppointStatus())) {}
              for (;;)
              {
                paramAnonymousView = new Intent(MyAppointAdapter.a(MyAppointAdapter.this), EvaluateSignActivity.class);
                paramAnonymousView.putExtra("state", 2);
                paramAnonymousView.putExtra("sceneCode", i);
                paramAnonymousView.putExtra("evaluateType", "YK");
                paramAnonymousView.putExtra("orderCode", localObject1.getOrderKey());
                ((BaseActivity)MyAppointAdapter.a(MyAppointAdapter.this)).startActivityForResult(paramAnonymousView, 4660);
                return;
                i = 1;
              }
            }
          } while ((paramAnonymousView != localView) || (ae.isNull(localObject1.getVillageName())));
          paramAnonymousView = new Intent(MyAppointAdapter.a(MyAppointAdapter.this), RentHouseDetailActivity.class);
          paramAnonymousView.putExtra("id", localObject1.getHouseCode());
          paramAnonymousView.putExtra("house_id", localObject1.getHouseId());
          MyAppointAdapter.a(MyAppointAdapter.this).startActivity(paramAnonymousView);
          d.i("====appoint", "start housedetail page");
        }
      };
      break;
      if (!((String)localObject2).equals("1")) {
        break label608;
      }
      paramInt = 0;
      break label610;
      if (!((String)localObject2).equals("5")) {
        break label608;
      }
      paramInt = 1;
      break label610;
      if (!((String)localObject2).equals("8")) {
        break label608;
      }
      paramInt = 2;
      break label610;
      paramView.append("自如友家");
      break label644;
      paramView.append("业主直租");
      break label644;
      paramView.append("自如豪宅");
      break label644;
      paramView.append("室").append(localMyAppoint.getNumber()).append("厅");
      break label709;
      if (!paramView.equals("1")) {
        break label860;
      }
      paramInt = 0;
      break label862;
      if (!paramView.equals("2")) {
        break label860;
      }
      paramInt = 1;
      break label862;
      if (!paramView.equals("3")) {
        break label860;
      }
      paramInt = 2;
      break label862;
      if (!paramView.equals("4")) {
        break label860;
      }
      paramInt = 3;
      break label862;
      if (!paramView.equals("5")) {
        break label860;
      }
      paramInt = 4;
      break label862;
      paramViewGroup.tvAppointSeeEvaluate.setVisibility(8);
      paramViewGroup.tvAppointEvaluate.setVisibility(8);
      paramViewGroup.tvAppointDel.setVisibility(8);
      paramViewGroup.tvAppointCancel.setVisibility(0);
      break label896;
      paramViewGroup.tvAppointSeeEvaluate.setVisibility(8);
      paramViewGroup.tvAppointEvaluate.setVisibility(8);
      paramViewGroup.tvAppointDel.setVisibility(8);
      paramViewGroup.tvAppointCancel.setVisibility(8);
      break label896;
      paramViewGroup.tvAppointCancel.setVisibility(8);
      a(paramViewGroup, localMyAppoint);
      break label896;
      paramViewGroup.tvAppointSeeEvaluate.setVisibility(8);
      paramViewGroup.tvAppointEvaluate.setVisibility(8);
      paramViewGroup.tvAppointDel.setVisibility(0);
      paramViewGroup.tvAppointCancel.setVisibility(8);
      break label896;
      paramViewGroup.tvAppointCancel.setVisibility(8);
      a(paramViewGroup, localMyAppoint);
      break label896;
      if ("已过期".equals(paramViewGroup.tvAppointStatus.getText())) {
        paramViewGroup.tvAppointStatus.setTextColor(this.c.getResources().getColor(2131624599));
      } else {
        paramViewGroup.tvAppointStatus.setTextColor(this.c.getResources().getColor(2131624601));
      }
    }
    paramViewGroup.tvAppointTitle.setText("自如寓·" + localMyAppoint.getVillageName());
    paramViewGroup.tvAppointArea.setText(localMyAppoint.getArea() + "㎡");
    paramViewGroup.tvAppointStatus.setText(localMyAppoint.getAppointStatusZra());
    paramViewGroup.tvAppointDel.setVisibility(8);
    if (1 == this.f)
    {
      paramViewGroup.tvAppointEvaluate.setVisibility(0);
      if ("0".equals(localMyAppoint.getIsEvaluate())) {
        paramViewGroup.tvAppointEvaluate.setText("立即评价");
      }
    }
    for (;;)
    {
      localObject1 = new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (paramAnonymousView == paramViewGroup.tvKeeperTel)
          {
            d.i("====appoint", "call tel:" + localObject1.getKeeperPhone());
            ah.callPhone(MyAppointAdapter.a(MyAppointAdapter.this), localObject1.getKeeperPhone());
          }
          do
          {
            do
            {
              return;
              if (paramAnonymousView == paramViewGroup.tvAppointCancel)
              {
                d.i("====appoint", "cancel appoint clicked");
                w.onEventToZiroomAndUmeng("zra_book_cancel");
                MyAppointAdapter.a(MyAppointAdapter.this, localMyAppoint.getOrderId());
                return;
              }
              if ((paramAnonymousView != paramViewGroup.tvAppointEvaluate) || (!"0".equals(localMyAppoint.getIsEvaluate()))) {
                break;
              }
              d.i("====appoint", "evaluate appoint clicked");
              w.onEventToZiroomAndUmeng("zra_book_eva");
              paramAnonymousView = new Intent(MyAppointAdapter.a(MyAppointAdapter.this), ZryuEvaluateActivity.class);
              paramAnonymousView.putExtra("isShowHistory", false);
              paramAnonymousView.putExtra("beEvaluatorId", localMyAppoint.getKeeperId());
              paramAnonymousView.putExtra("businessBid", localMyAppoint.getOrderId());
              paramAnonymousView.putExtra("tokenId", localMyAppoint.getTokenId());
              if ((MyAppointAdapter.b(MyAppointAdapter.this) instanceof MyFinishedAppointFragment))
              {
                ((MyFinishedAppointFragment)MyAppointAdapter.b(MyAppointAdapter.this)).startActivityForResult(paramAnonymousView, 1);
                return;
              }
            } while (!(MyAppointAdapter.b(MyAppointAdapter.this) instanceof MyApartUnEvaAppointFragment));
            ((MyApartUnEvaAppointFragment)MyAppointAdapter.b(MyAppointAdapter.this)).startActivityForResult(paramAnonymousView, 1);
            return;
            if ((paramAnonymousView == paramViewGroup.tvAppointEvaluate) && (!"0".equals(localMyAppoint.getIsEvaluate())))
            {
              d.i("====appoint", "evaluate appoint clicked");
              w.onEventToZiroomAndUmeng("zra_book_eva_read");
              paramAnonymousView = new Intent(MyAppointAdapter.a(MyAppointAdapter.this), ZryuEvaluateActivity.class);
              paramAnonymousView.putExtra("isShowHistory", true);
              paramAnonymousView.putExtra("requesterId", ApplicationEx.c.getUserId((Activity)MyAppointAdapter.a(MyAppointAdapter.this)));
              paramAnonymousView.putExtra("tokenId", localMyAppoint.getTokenId());
              MyAppointAdapter.a(MyAppointAdapter.this).startActivity(paramAnonymousView);
              return;
            }
          } while (paramAnonymousView != localView);
          d.i("====appoint", "start zryu project page");
          com.ziroom.ziroomcustomer.ziroomapartment.a.ToProjectInfo(MyAppointAdapter.a(MyAppointAdapter.this), localMyAppoint.getHouseId());
        }
      };
      paramView = (View)localObject1;
      if (!"已取消".equals(localMyAppoint.getAppointStatusZra())) {
        break;
      }
      paramViewGroup.tvAppointCancel.setVisibility(8);
      paramViewGroup.tvKeeperTel.setVisibility(0);
      paramViewGroup.tvAppointDel.setVisibility(8);
      paramViewGroup.tvAppointEvaluate.setVisibility(8);
      paramView = (View)localObject1;
      break;
      paramViewGroup.tvAppointEvaluate.setText("查看评价");
      continue;
      paramViewGroup.tvAppointEvaluate.setVisibility(8);
    }
    label1557:
    paramView = (LinearLayout.LayoutParams)paramViewGroup.ll_button_container.getLayoutParams();
    paramView.width = -1;
    paramViewGroup.ll_button_container.setLayoutParams(paramView);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void setDataRefresher(b paramb)
  {
    this.j = paramb;
  }
  
  public void setList(List<MyAppoint> paramList)
  {
    this.a = paramList;
  }
  
  static class ViewHolder
  {
    @BindView(2131695405)
    SimpleDraweeView ivAppointPic;
    @BindView(2131695401)
    SimpleDraweeView ivKeeperPic;
    @BindView(2131695406)
    LinearLayout ll_appoint;
    @BindView(2131689498)
    LinearLayout ll_button_container;
    @BindView(2131695408)
    TextView tvAppointArea;
    @BindView(2131695412)
    TextView tvAppointCancel;
    @BindView(2131695415)
    TextView tvAppointDel;
    @BindView(2131695413)
    TextView tvAppointEvaluate;
    @BindView(2131695403)
    TextView tvAppointLocation;
    @BindView(2131695409)
    TextView tvAppointPrice;
    @BindView(2131695414)
    TextView tvAppointSeeEvaluate;
    @BindView(2131695402)
    TextView tvAppointStatus;
    @BindView(2131694329)
    TextView tvAppointTime;
    @BindView(2131695407)
    TextView tvAppointTitle;
    @BindView(2131695410)
    TextView tvAppointUnit;
    @BindView(2131695071)
    TextView tvHouseStatus;
    @BindView(2131694731)
    TextView tvKeeperName;
    @BindView(2131695411)
    TextView tvKeeperTel;
    @BindView(2131695404)
    TextView tv_appoint_hint;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
      ((GenericDraweeHierarchy)this.ivKeeperPic.getHierarchy()).setPlaceholderImage(2130838109);
      ((GenericDraweeHierarchy)this.ivKeeperPic.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if ("success".equals((String)paramString.get("status")))
      {
        paramk.setSuccess(Boolean.valueOf(true));
        paramk.setMessage((String)paramString.get("error_message"));
        return;
      }
      String str = (String)paramString.get("error_message");
      paramString = str;
      if (str == null) {
        paramString = "服务器异常，正在努力抢修中，请稍后再试!";
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage(paramString);
    }
    
    public void onSuccess(k paramk)
    {
      paramk = paramk.getMessage();
      com.freelxl.baselibrary.f.g.textToast(MyAppointAdapter.a(MyAppointAdapter.this), paramk, 0);
      if (MyAppointAdapter.b(MyAppointAdapter.this) != null) {
        MyAppointAdapter.b(MyAppointAdapter.this).loadData();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void loadData();
  }
  
  static class c
  {
    int a;
    int b;
    
    public int getOrderId()
    {
      return this.a;
    }
    
    public int getOrderType()
    {
      return this.b;
    }
    
    public void setOrderId(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void setOrderType(int paramInt)
    {
      this.b = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/MyAppointAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */