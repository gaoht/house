package com.ziroom.ziroomcustomer.newclean.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceWebActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.BuyGiftCard;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CardStylesBean;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanBuyGiftCard;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.ValueCardTypesBean;
import com.ziroom.ziroomcustomer.newclean.d.bc;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.WrapLayout;
import java.util.Iterator;
import java.util.List;

public class CleanGiftBuyCardFragment
  extends BaseFragment
{
  private ValueCardTypesBean a;
  private CardStylesBean b = null;
  private CleanBuyGiftCard c;
  @BindView(2131693377)
  CardView cardView;
  @BindView(2131690215)
  CheckBox cbAgree;
  @BindView(2131693971)
  WrapLayout lvMoneys;
  @BindView(2131693970)
  RecyclerView recyclerView;
  @BindView(2131694925)
  SimpleDraweeView sdvCard;
  @BindView(2131693684)
  TextView tvBuy;
  @BindView(2131690084)
  TextView tvContent;
  @BindView(2131693973)
  TextView tvFullMoney;
  @BindView(2131694927)
  TextView tvGet;
  @BindView(2131689846)
  TextView tvMoney;
  @BindView(2131690551)
  TextView tvPayMoney;
  @BindView(2131689835)
  TextView tvTips;
  @BindView(2131693972)
  TextView tvXieyi;
  @BindView(2131694926)
  TextView viewBg;
  
  private TextView a(Object paramObject, String paramString)
  {
    int i = ac.getScreenWidth(getActivity());
    int j = ab.dp2px(getActivity(), 60.0F);
    TextView localTextView = new TextView(getActivity());
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams((i - j) / 3, -2);
    localTextView.setTag(paramObject);
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setText(paramString);
    localTextView.setPadding(a(6.0F), a(6.0F), a(6.0F), a(6.0F));
    localTextView.setTextSize(14.0F);
    localTextView.setGravity(17);
    localTextView.setBackgroundResource(2130839472);
    localTextView.setTextColor(2130839473);
    localTextView.setMaxWidth(getActivity().getWindowManager().getDefaultDisplay().getWidth() - a(40.0F));
    localTextView.setMaxLines(1);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView.setSelected(true);
        ((TextView)paramAnonymousView).setTextColor(40960);
        TextView localTextView = (TextView)((View)paramAnonymousView.getParent()).getTag();
        CleanGiftBuyCardFragment.a(CleanGiftBuyCardFragment.this, (ValueCardTypesBean)paramAnonymousView.getTag());
        CleanGiftBuyCardFragment.this.tvMoney.setText("¥" + (CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getRechargeAmount() + CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getGiftCount()) / 100);
        CleanGiftBuyCardFragment.this.tvPayMoney.setText("¥" + ah.Number(CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getSaleAmount() * 1.0D / 100.0D));
        CleanGiftBuyCardFragment.this.tvFullMoney.setText("¥" + ah.Number((CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getRechargeAmount() + CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getGiftCount()) * 1.0D / 100.0D));
        if (CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getRechargeAmount() + CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getGiftCount() == CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getSaleAmount()) {
          CleanGiftBuyCardFragment.this.tvFullMoney.setVisibility(8);
        }
        if (paramAnonymousView != localTextView)
        {
          localTextView.setSelected(false);
          localTextView.setTextColor(-6710887);
          ((View)paramAnonymousView.getParent()).setTag(paramAnonymousView);
        }
      }
    });
    return localTextView;
  }
  
  private void a(final String paramString, long paramLong)
  {
    n.requestServicePayment(getActivity(), ApplicationEx.c.getUser().getUid(), paramString, 1, 3, paramLong, null, null, new com.ziroom.ziroomcustomer.e.a.d(getActivity(), new com.ziroom.ziroomcustomer.e.c.f(bc.class))
    {
      public void onSuccess(int paramAnonymousInt, bc paramAnonymousbc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousbc);
        com.ziroom.ziroomcustomer.payment.a.startPayActivty(CleanGiftBuyCardFragment.this.getActivity(), paramAnonymousbc.getAmount(), paramString, paramAnonymousbc.getOrderIds(), paramAnonymousbc.getSystemId());
      }
    });
  }
  
  private void a(final List<CardStylesBean> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ((CardStylesBean)paramList.get(0)).setSelected(Boolean.valueOf(true));
    this.b = ((CardStylesBean)paramList.get(0));
    this.sdvCard.setController(com.freelxl.baselibrary.f.c.frescoController(this.b.getCardStyleUrl()));
    int i = (int)((ac.getScreenWidth(getActivity()) - ab.dp2px(getActivity(), 40.0F)) * 1.0F / 335.0F * 210.0F);
    this.sdvCard.getLayoutParams().height = i;
    this.viewBg.getLayoutParams().height = i;
    this.tvContent.setText(this.b.getCardStyleNote());
    paramList = new com.ziroom.ziroomcustomer.minsu.view.b.a(getActivity(), 2130904151, paramList)
    {
      protected void a(com.ziroom.ziroomcustomer.minsu.view.b.a.c paramAnonymousc, final CardStylesBean paramAnonymousCardStylesBean, final int paramAnonymousInt)
      {
        TextView localTextView = (TextView)paramAnonymousc.getView(2131689857);
        Object localObject = (CardView)paramAnonymousc.getView(2131694900);
        ((CardView)localObject).setRadius(CleanGiftBuyCardFragment.this.a(4.0F));
        ((CardView)localObject).setCardElevation(CleanGiftBuyCardFragment.this.a(3.0F));
        localTextView.setText(paramAnonymousCardStylesBean.getCardStyleNote());
        localObject = (SimpleDraweeView)paramAnonymousc.getView(2131689744);
        ((SimpleDraweeView)localObject).setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousCardStylesBean.getCardStyleUrl()));
        if (paramAnonymousCardStylesBean.getSelected().booleanValue())
        {
          localTextView.setTextColor(-16777216);
          ((SimpleDraweeView)localObject).setAlpha(1.0F);
        }
        for (;;)
        {
          paramAnonymousc.itemView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              if (CleanGiftBuyCardFragment.c(CleanGiftBuyCardFragment.this) != paramAnonymousCardStylesBean)
              {
                CleanGiftBuyCardFragment.c(CleanGiftBuyCardFragment.this).setSelected(Boolean.valueOf(false));
                CleanGiftBuyCardFragment.5.this.notifyItemChanged(CleanGiftBuyCardFragment.5.this.a.indexOf(CleanGiftBuyCardFragment.c(CleanGiftBuyCardFragment.this)));
                CleanGiftBuyCardFragment.a(CleanGiftBuyCardFragment.this, paramAnonymousCardStylesBean);
                paramAnonymousCardStylesBean.setSelected(Boolean.valueOf(true));
                CleanGiftBuyCardFragment.5.this.notifyItemChanged(paramAnonymousInt);
                CleanGiftBuyCardFragment.this.sdvCard.setController(com.freelxl.baselibrary.f.c.frescoController(CleanGiftBuyCardFragment.c(CleanGiftBuyCardFragment.this).getCardStyleUrl()));
                CleanGiftBuyCardFragment.this.tvContent.setText(CleanGiftBuyCardFragment.c(CleanGiftBuyCardFragment.this).getCardStyleNote());
              }
            }
          });
          return;
          localTextView.setTextColor(-6710887);
          ((SimpleDraweeView)localObject).setAlpha(0.3F);
        }
      }
    };
    this.recyclerView.addItemDecoration(new a());
    this.recyclerView.setHasFixedSize(true);
    StaggeredGridLayoutManager localStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 0);
    this.recyclerView.setLayoutManager(localStaggeredGridLayoutManager);
    this.recyclerView.setAdapter(paramList);
  }
  
  private void c()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null)
    {
      g.textToast(getActivity(), "获取用户信息失败！");
      return;
    }
    if ((localUserInfo.getPhone() == null) || (com.freelxl.baselibrary.f.f.isNull(localUserInfo.getPhone())))
    {
      g.textToast(getActivity(), "获取用户手机号失败");
      return;
    }
    String str1 = localUserInfo.getRealName();
    String str2 = this.b.getCardStyleUrl();
    String str3 = this.b.getCardStyleNote();
    n.buyCleanGiftCard(getActivity(), this.a.getCid() + "", localUserInfo.getPhone(), str1, "", str2, str3, new com.ziroom.ziroomcustomer.e.a.d(getActivity(), new com.ziroom.ziroomcustomer.e.c.f(BuyGiftCard.class))
    {
      public void onSuccess(int paramAnonymousInt, BuyGiftCard paramAnonymousBuyGiftCard)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousBuyGiftCard);
        CleanGiftBuyCardFragment.a(CleanGiftBuyCardFragment.this, paramAnonymousBuyGiftCard.getOrderNumber(), paramAnonymousBuyGiftCard.getPayAmount());
      }
    });
  }
  
  public static CleanGiftBuyCardFragment getInstance()
  {
    return new CleanGiftBuyCardFragment();
  }
  
  protected int a(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public void initData()
  {
    this.cbAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
        CleanGiftBuyCardFragment.this.tvBuy.setEnabled(paramAnonymousBoolean);
      }
    });
    n.getCleanBuyGiftCardInfo(getActivity(), new com.ziroom.ziroomcustomer.e.a.d(getActivity(), new com.ziroom.ziroomcustomer.e.c.f(CleanBuyGiftCard.class))
    {
      public void onSuccess(int paramAnonymousInt, CleanBuyGiftCard paramAnonymousCleanBuyGiftCard)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousCleanBuyGiftCard);
        if (paramAnonymousCleanBuyGiftCard == null) {
          return;
        }
        CleanGiftBuyCardFragment.a(CleanGiftBuyCardFragment.this, paramAnonymousCleanBuyGiftCard);
        CleanGiftBuyCardFragment.this.tvFullMoney.setPaintFlags(16);
        CleanGiftBuyCardFragment.this.tvTips.setText(CleanGiftBuyCardFragment.a(CleanGiftBuyCardFragment.this).getTips());
        paramAnonymousCleanBuyGiftCard = paramAnonymousCleanBuyGiftCard.getValueCardTypes();
        CleanGiftBuyCardFragment.this.lvMoneys.removeAllViews();
        paramAnonymousCleanBuyGiftCard = paramAnonymousCleanBuyGiftCard.iterator();
        while (paramAnonymousCleanBuyGiftCard.hasNext())
        {
          ValueCardTypesBean localValueCardTypesBean = (ValueCardTypesBean)paramAnonymousCleanBuyGiftCard.next();
          CleanGiftBuyCardFragment.this.lvMoneys.addView(CleanGiftBuyCardFragment.a(CleanGiftBuyCardFragment.this, localValueCardTypesBean, "¥" + (localValueCardTypesBean.getGiftCount() + localValueCardTypesBean.getRechargeAmount()) / 100));
        }
        if (CleanGiftBuyCardFragment.this.lvMoneys.getChildCount() > 0)
        {
          CleanGiftBuyCardFragment.this.lvMoneys.getChildAt(0).setSelected(true);
          ((TextView)CleanGiftBuyCardFragment.this.lvMoneys.getChildAt(0)).setTextColor(40960);
          CleanGiftBuyCardFragment.this.lvMoneys.setTag(CleanGiftBuyCardFragment.this.lvMoneys.getChildAt(0));
          CleanGiftBuyCardFragment.a(CleanGiftBuyCardFragment.this, (ValueCardTypesBean)CleanGiftBuyCardFragment.this.lvMoneys.getChildAt(0).getTag());
          CleanGiftBuyCardFragment.this.tvMoney.setText("¥" + (CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getRechargeAmount() + CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getGiftCount()) / 100);
          CleanGiftBuyCardFragment.this.tvPayMoney.setText("¥" + ah.Number(CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getSaleAmount() * 1.0D / 100.0D));
          CleanGiftBuyCardFragment.this.tvFullMoney.setText("¥" + ah.Number((CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getRechargeAmount() + CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getGiftCount()) * 1.0D / 100.0D));
          if (CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getRechargeAmount() + CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getGiftCount() == CleanGiftBuyCardFragment.b(CleanGiftBuyCardFragment.this).getSaleAmount()) {
            CleanGiftBuyCardFragment.this.tvFullMoney.setVisibility(8);
          }
        }
        CleanGiftBuyCardFragment.a(CleanGiftBuyCardFragment.this, CleanGiftBuyCardFragment.a(CleanGiftBuyCardFragment.this).getCardStyles());
      }
    });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    com.freelxl.baselibrary.f.d.d("CleanGiftBuyCardFragment", "onCreateView");
    paramLayoutInflater = paramLayoutInflater.inflate(2130903900, paramViewGroup, false);
    ButterKnife.bind(this, paramLayoutInflater);
    this.cardView.setRadius(ab.dp2px(getActivity(), 8.0F));
    this.cardView.setCardElevation(a(6.0F));
    initData();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  @OnClick({2131693972, 2131693684})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131693972: 
      paramView = new Intent(getActivity(), ServiceWebActivity.class);
      paramView.putExtra("title_name", "自如保洁卡会员协议");
      paramView.putExtra("url", "http://www.ziroom.com/zhuanti/2016/czkxy/index.html");
      startActivity(paramView);
      return;
    }
    if (ApplicationEx.c.isLoginState())
    {
      c();
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(getActivity());
  }
  
  class a
    extends RecyclerView.g
  {
    a() {}
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.r paramr)
    {
      paramRect.set(0, 0, CleanGiftBuyCardFragment.this.a(6.0F), 0);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/fragment/CleanGiftBuyCardFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */