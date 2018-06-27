package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceLoginActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MovingIndexActivity;
import com.ziroom.ziroomcustomer.newmovehouse.b.f;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecModel;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecResultModel;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecResultRequestModel;
import com.ziroom.ziroomcustomer.widget.ReMeasureRecyclerView;
import java.util.List;

public class MoveRecFragment
  extends BaseFragment
  implements c.b
{
  private Context a;
  private Unbinder b;
  @BindView(2131694350)
  Button btnDetail;
  private c.a c;
  @BindView(2131696334)
  LinearLayout llMoveRecResultContainer;
  @BindView(2131696333)
  ReMeasureRecyclerView rvRecSelect;
  @BindView(2131696332)
  SimpleDraweeView sdvMoveRec;
  @BindView(2131696335)
  SimpleDraweeView sdvMoveRecResult;
  @BindView(2131696329)
  ScrollView svMoveRecContainer;
  @BindView(2131695659)
  TextView tvIndex;
  @BindView(2131696340)
  TextView tvMoveRecResultDesc;
  @BindView(2131696338)
  TextView tvMoveRecResultMoney;
  @BindView(2131696339)
  TextView tvMoveRecResultTime;
  @BindView(2131696336)
  TextView tvMoveRecResultType;
  @BindView(2131696337)
  TextView tvMoveRecResultYuan;
  @BindView(2131696331)
  TextView tvRecStandard;
  @BindView(2131696330)
  TextView tvSize;
  
  private void c()
  {
    int i = getActivity().getWindowManager().getDefaultDisplay().getWidth();
    ViewGroup.LayoutParams localLayoutParams = this.sdvMoveRecResult.getLayoutParams();
    localLayoutParams.height = ((i - getResources().getDimensionPixelSize(2131230787)) * 188 / 313);
    this.sdvMoveRecResult.setLayoutParams(localLayoutParams);
  }
  
  public static MoveRecFragment newInstance(int paramInt1, int paramInt2, MoveRecModel paramMoveRecModel)
  {
    MoveRecFragment localMoveRecFragment = new MoveRecFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt1);
    localBundle.putInt("size", paramInt2);
    localBundle.putSerializable("model", paramMoveRecModel);
    localMoveRecFragment.setArguments(localBundle);
    return localMoveRecFragment;
  }
  
  @OnClick({2131694350})
  public void click(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.c.getResult() == null);
    paramView = new Intent(getActivity(), MovingIndexActivity.class);
    paramView.putExtra("productCode", this.c.getResult().serviceInfoId);
    paramView.putExtra("ServiceInfoName", this.c.getResult().serviceInfoName);
    paramView.putExtra("shareImage", this.c.getResult().picUrl);
    paramView.putExtra("serviceContent", this.c.getResult().slogan);
    getActivity().startActivity(paramView);
  }
  
  public void currentPageSelected(int paramInt)
  {
    if ((this.a instanceof b.b)) {
      ((b.b)this.a).currentPageSelected(paramInt);
    }
  }
  
  public Bundle getArgs()
  {
    return getArguments();
  }
  
  public List<MoveRecResultRequestModel> getOptions(MoveRecResultRequestModel paramMoveRecResultRequestModel)
  {
    if ((this.a instanceof b.b)) {
      return ((b.b)this.a).getOptions(paramMoveRecResultRequestModel);
    }
    return null;
  }
  
  public Context getViewContext()
  {
    return this.a;
  }
  
  public void gotoLogin()
  {
    Intent localIntent = new Intent(this.a, ServiceLoginActivity.class);
    this.a.startActivity(localIntent);
  }
  
  public void initImg(String paramString)
  {
    SimpleDraweeView localSimpleDraweeView = this.sdvMoveRec;
    if (TextUtils.isEmpty(paramString)) {}
    for (int i = 8;; i = 0)
    {
      localSimpleDraweeView.setVisibility(i);
      this.sdvMoveRec.setController(c.frescoController(paramString));
      return;
    }
  }
  
  public void initIndex(String paramString)
  {
    this.tvIndex.setText(paramString);
  }
  
  public void initRecyclerView(int paramInt, f paramf)
  {
    this.rvRecSelect.setLayoutManager(new GridLayoutManager(this.a, paramInt));
    this.rvRecSelect.setAdapter(paramf);
  }
  
  public void initResultDesc(String paramString)
  {
    this.tvMoveRecResultDesc.setText(paramString);
  }
  
  public void initResultImg(String paramString)
  {
    this.sdvMoveRecResult.setController(c.frescoController(paramString));
  }
  
  public void initResultMoney(String paramString)
  {
    this.tvMoveRecResultMoney.setText(paramString);
  }
  
  public void initResultType(String paramString)
  {
    this.tvMoveRecResultType.setText(paramString);
  }
  
  public void initSize(String paramString)
  {
    this.tvSize.setText(paramString);
  }
  
  public void initStandard(String paramString)
  {
    this.tvRecStandard.setText(paramString);
  }
  
  public void intiResultTime(String paramString)
  {
    this.tvMoveRecResultTime.setText(paramString);
  }
  
  public boolean isActive()
  {
    return isAdded();
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.a = paramContext;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = new d(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2130903969, paramViewGroup, false);
    this.b = ButterKnife.bind(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.b != null) {
      this.b.unbind();
    }
    if (this.c != null) {
      this.c.detachView();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    c();
    if (this.c != null) {
      this.c.start();
    }
  }
  
  public void setPresenter(c.a parama)
  {
    this.c = parama;
  }
  
  public void setResultVisible(boolean paramBoolean)
  {
    int j = 0;
    Object localObject = this.svMoveRecContainer;
    if (paramBoolean)
    {
      i = 8;
      ((ScrollView)localObject).setVisibility(i);
      localObject = this.llMoveRecResultContainer;
      if (!paramBoolean) {
        break label45;
      }
    }
    label45:
    for (int i = j;; i = 8)
    {
      ((LinearLayout)localObject).setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/MoveRecFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */