package com.ziroom.ziroomcustomer.ziroomstation.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.ziroomstation.a.a;
import com.ziroom.ziroomcustomer.ziroomstation.adapter.SelectedBedInfosAdapter;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoSelectedInfos;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoSelectedInfos.RoomBedInfos;
import com.ziroom.ziroomcustomer.ziroomstation.widget.MyListView;
import java.util.List;

public class IntoCashPledgeDetailsPop
  implements View.OnClickListener
{
  List<IntoSelectedInfos.RoomBedInfos> a;
  private Context b;
  private PopupWindow c;
  private SelectedBedInfosAdapter d;
  private a e;
  private long f;
  private int g;
  private String h;
  private int i;
  @BindView(2131697591)
  ImageView ivIntoCashPledgeClose;
  private int j;
  private int k;
  @BindView(2131697593)
  LinearLayout llArea0;
  @BindView(2131697597)
  LinearLayout llArea1;
  @BindView(2131697595)
  MyListView lvCashPledgeDetail;
  @BindView(2131697601)
  TextView tvCashPledgeNum;
  @BindView(2131697600)
  TextView tvCashPledgeSingle;
  @BindView(2131692800)
  TextView tvCashPledgeTotal;
  @BindView(2131697598)
  TextView tvIntoDateStartEnd;
  @BindView(2131697594)
  TextView tvIntoPeopleNum;
  @BindView(2131697599)
  TextView tvIntoPeopleNumRen;
  @BindView(2131697592)
  View viewDivider0;
  @BindView(2131697596)
  View viewDivider1;
  @BindView(2131697602)
  View viewDivider2;
  
  public IntoCashPledgeDetailsPop(Context paramContext, IntoSelectedInfos paramIntoSelectedInfos, a parama)
  {
    this.b = paramContext;
    this.e = parama;
    this.a = paramIntoSelectedInfos.selectedBedInfos;
    this.g = paramIntoSelectedInfos.personNum;
    this.h = paramIntoSelectedInfos.timeString;
    this.i = paramIntoSelectedInfos.bedSingleCash;
    this.j = paramIntoSelectedInfos.cashTotal;
    this.k = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getHeight();
  }
  
  private void a(View paramView)
  {
    this.ivIntoCashPledgeClose = ((ImageView)paramView.findViewById(2131697591));
    this.viewDivider0 = paramView.findViewById(2131697592);
    this.viewDivider1 = paramView.findViewById(2131697596);
    this.viewDivider2 = paramView.findViewById(2131697602);
    this.llArea0 = ((LinearLayout)paramView.findViewById(2131697593));
    this.llArea1 = ((LinearLayout)paramView.findViewById(2131697597));
    this.viewDivider2.post(new Runnable()
    {
      public void run()
      {
        int i = (IntoCashPledgeDetailsPop.c(IntoCashPledgeDetailsPop.this) - IntoCashPledgeDetailsPop.this.ivIntoCashPledgeClose.getHeight() - IntoCashPledgeDetailsPop.this.llArea0.getHeight() - IntoCashPledgeDetailsPop.this.llArea1.getHeight() - n.dip2px(IntoCashPledgeDetailsPop.d(IntoCashPledgeDetailsPop.this), 48.0F)) / 3;
        int j = n.px2dip(IntoCashPledgeDetailsPop.d(IntoCashPledgeDetailsPop.this), i);
        ViewGroup.LayoutParams localLayoutParams = IntoCashPledgeDetailsPop.this.viewDivider0.getLayoutParams();
        if (j > 48) {}
        for (localLayoutParams.height = i;; localLayoutParams.height = n.dip2px(IntoCashPledgeDetailsPop.d(IntoCashPledgeDetailsPop.this), 48.0F))
        {
          IntoCashPledgeDetailsPop.this.viewDivider0.setLayoutParams(localLayoutParams);
          IntoCashPledgeDetailsPop.this.viewDivider1.setLayoutParams(localLayoutParams);
          IntoCashPledgeDetailsPop.this.viewDivider2.setLayoutParams(localLayoutParams);
          return;
        }
      }
    });
    this.tvIntoPeopleNum = ((TextView)paramView.findViewById(2131697594));
    this.lvCashPledgeDetail = ((MyListView)paramView.findViewById(2131697595));
    this.tvIntoDateStartEnd = ((TextView)paramView.findViewById(2131697598));
    this.tvIntoPeopleNumRen = ((TextView)paramView.findViewById(2131697599));
    this.tvCashPledgeSingle = ((TextView)paramView.findViewById(2131697600));
    this.tvCashPledgeNum = ((TextView)paramView.findViewById(2131697601));
    this.tvCashPledgeTotal = ((TextView)paramView.findViewById(2131692800));
    this.ivIntoCashPledgeClose.setOnClickListener(this);
    this.tvIntoPeopleNum.setText(this.g + "位入住人");
    this.tvIntoDateStartEnd.setText(this.h);
    this.tvIntoPeopleNumRen.setText(this.g + "人");
    this.tvCashPledgeSingle.setText(this.i + "");
    this.tvCashPledgeNum.setText(" x " + this.g);
    this.tvCashPledgeTotal.setText(this.j + "");
    this.d = new SelectedBedInfosAdapter(this.b, this.a);
    this.lvCashPledgeDetail.setAdapter(this.d);
  }
  
  public void dismissDialog()
  {
    if ((this.c != null) && (this.c.isShowing())) {
      this.c.dismiss();
    }
  }
  
  @OnClick({2131697591})
  public void onClick()
  {
    dismissDialog();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismissDialog();
  }
  
  public void showPriceWindow()
  {
    View localView = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2130905152, null);
    a(localView);
    this.c = new PopupWindow(localView, -1, -1);
    this.c.setFocusable(true);
    Object localObject = new ColorDrawable(-167772161);
    this.c.setBackgroundDrawable((Drawable)localObject);
    localObject = this.c;
    if (!(localObject instanceof PopupWindow)) {
      ((PopupWindow)localObject).showAtLocation(localView, 0, 0, 0);
    }
    for (;;)
    {
      this.c.setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public void onDismiss()
        {
          int i = (int)((IntoCashPledgeDetailsPop.a(IntoCashPledgeDetailsPop.this) - System.currentTimeMillis()) / 1000L);
          if ((IntoCashPledgeDetailsPop.b(IntoCashPledgeDetailsPop.this) != null) && (i > 0)) {
            IntoCashPledgeDetailsPop.b(IntoCashPledgeDetailsPop.this).callback(i);
          }
        }
      });
      this.f = System.currentTimeMillis();
      return;
      VdsAgent.showAtLocation((PopupWindow)localObject, localView, 0, 0, 0);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/dialog/IntoCashPledgeDetailsPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */