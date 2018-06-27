package com.ziroom.ziroomcustomer.minsu.adapter;

import android.content.Context;
import android.util.SparseBooleanArray;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.minsu.a.a;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationBean.DataBean.EvaListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationListBean.DataBean.RowsBean;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.minsu.view.MinsuExpandableTextView;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.List;

public class j
  extends a<MinsuEvaluationBean.DataBean.EvaListBean>
{
  private String d;
  private SparseBooleanArray e;
  
  public j(Context paramContext, List<MinsuEvaluationBean.DataBean.EvaListBean> paramList, int paramInt, String paramString)
  {
    super(paramContext, paramList, paramInt);
    this.d = paramString;
    this.e = new SparseBooleanArray();
  }
  
  public void convert(b paramb, MinsuEvaluationBean.DataBean.EvaListBean paramEvaListBean)
  {
    SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)paramb.getView(2131695253);
    localSimpleDraweeView.setController(c.frescoController(paramEvaListBean.customerIcon));
    localSimpleDraweeView.setHierarchy(d.getRoundingHierarchy(this.a));
    paramb.setText(2131694592, paramEvaListBean.customerName);
    paramb.setText(2131694593, paramEvaListBean.evalDate);
    if (ae.isNull(paramEvaListBean.landlordEvalContent)) {
      paramb.setVisibility(2131695255, 8);
    }
    for (;;)
    {
      if (ae.notNull(paramEvaListBean.evalContent)) {
        ((MinsuExpandableTextView)paramb.getView(2131695254)).setText(paramEvaListBean.evalContent, this.e, paramb.getPosition());
      }
      return;
      paramb.setVisibility(2131695255, 0);
      paramb.setText(2131695256, String.format("%s的回复", new Object[] { this.d }));
      paramb.setText(2131695257, paramEvaListBean.landlordEvalContent);
    }
  }
  
  public String getEvaTypeStr(MinsuEvaluationListBean.DataBean.RowsBean paramRowsBean)
  {
    return this.a.getResources().getStringArray(2131361821)[java.util.Arrays.asList(com.ziroom.ziroomcustomer.minsu.b.b.a.a).indexOf(paramRowsBean.evaStatus + "")];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */