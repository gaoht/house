package com.ziroom.ziroomcustomer.newmovehouse.b;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.ziroom.ziroomcustomer.minsu.view.b.a;
import com.ziroom.ziroomcustomer.minsu.view.b.a.c;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecModel.ItemContentBean;
import java.util.List;

public class f
  extends a<MoveRecModel.ItemContentBean>
{
  private boolean a;
  
  public f(Activity paramActivity, int paramInt, List<MoveRecModel.ItemContentBean> paramList, boolean paramBoolean)
  {
    super(paramActivity, paramInt, paramList);
    this.a = paramBoolean;
  }
  
  protected void a(c paramc, MoveRecModel.ItemContentBean paramItemContentBean, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramc.getView(2131690084).getLayoutParams();
    if (this.a) {
      if (paramInt == 0)
      {
        paramInt = this.b.getResources().getDimensionPixelSize(2131230788);
        localLayoutParams.topMargin = paramInt;
        if (!this.a) {
          break label197;
        }
        paramInt = this.b.getResources().getDimensionPixelSize(2131231195);
        label64:
        localLayoutParams.bottomMargin = paramInt;
        if (!this.a) {
          break label213;
        }
        paramInt = this.b.getResources().getDimensionPixelSize(2131231174);
        label90:
        localLayoutParams.height = paramInt;
        paramc.getView(2131690084).setLayoutParams(localLayoutParams);
        if (!paramItemContentBean.isSelect) {
          break label229;
        }
        paramInt = 2130837706;
        label117:
        paramc.setBackgroundRes(2131690084, paramInt);
        if (!paramItemContentBean.isSelect) {
          break label235;
        }
      }
    }
    label197:
    label213:
    label229:
    label235:
    for (paramInt = this.b.getResources().getColor(2131624608);; paramInt = this.b.getResources().getColor(2131624562))
    {
      paramc.setTextColor(2131690084, paramInt);
      paramc.setText(2131690084, paramItemContentBean.content);
      return;
      paramInt = this.b.getResources().getDimensionPixelSize(2131231195);
      break;
      paramInt = this.b.getResources().getDimensionPixelSize(2131231148);
      break;
      paramInt = this.b.getResources().getDimensionPixelSize(2131231148);
      break label64;
      paramInt = this.b.getResources().getDimensionPixelSize(2131230786);
      break label90;
      paramInt = 2130837705;
      break label117;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */