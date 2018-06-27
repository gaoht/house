package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.bestgoods.model.GoodsParamsMo;
import java.util.ArrayList;

public class i
  extends RecyclerView.a<a>
{
  private ArrayList<GoodsParamsMo> a;
  private Context b;
  
  public i(Context paramContext, ArrayList<GoodsParamsMo> paramArrayList)
  {
    this.a = paramArrayList;
    this.b = paramContext;
  }
  
  public int getItemCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public void onBindViewHolder(a parama, int paramInt)
  {
    GoodsParamsMo localGoodsParamsMo = (GoodsParamsMo)this.a.get(paramInt);
    String str2 = localGoodsParamsMo.getAttributeNameCode();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    switch (str1.hashCode())
    {
    case 1226102188: 
    case 1226102189: 
    case 1226102190: 
    case 1226102191: 
    case 1226102192: 
    case 1226102193: 
    case 1226102194: 
    case 1226102195: 
    case 1226102196: 
    case 1226102197: 
    case 1226102198: 
    case 1226102199: 
    case 1226102200: 
    case 1226102201: 
    case 1226102202: 
    case 1226102203: 
    case 1226102204: 
    case 1226102205: 
    case 1226102206: 
    case 1226102207: 
    case 1226102208: 
    default: 
      paramInt = -1;
      switch (paramInt)
      {
      default: 
        label198:
        str1 = "res:///2130839941";
        label275:
        a.a(parama).setController(c.frescoController(str1));
        str1 = localGoodsParamsMo.getAttributeName();
        if (!TextUtils.isEmpty(str1)) {
          a.b(parama).setText(str1);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      str1 = localGoodsParamsMo.getAttributeValue();
      if (TextUtils.isEmpty(str1)) {
        break label650;
      }
      a.c(parama).setText(str1);
      return;
      if (!str1.equals("1000030001")) {
        break;
      }
      paramInt = 0;
      break label198;
      if (!str1.equals("1000030002")) {
        break;
      }
      paramInt = 1;
      break label198;
      if (!str1.equals("1000030003")) {
        break;
      }
      paramInt = 2;
      break label198;
      if (!str1.equals("1000030004")) {
        break;
      }
      paramInt = 3;
      break label198;
      if (!str1.equals("1000030005")) {
        break;
      }
      paramInt = 4;
      break label198;
      if (!str1.equals("1000030006")) {
        break;
      }
      paramInt = 5;
      break label198;
      if (!str1.equals("1000030007")) {
        break;
      }
      paramInt = 6;
      break label198;
      if (!str1.equals("1000030008")) {
        break;
      }
      paramInt = 7;
      break label198;
      if (!str1.equals("1000030009")) {
        break;
      }
      paramInt = 8;
      break label198;
      if (!str1.equals("1000030010")) {
        break;
      }
      paramInt = 9;
      break label198;
      if (!str1.equals("1000030011")) {
        break;
      }
      paramInt = 10;
      break label198;
      if (!str1.equals("1000030012")) {
        break;
      }
      paramInt = 11;
      break label198;
      if (!str1.equals("1000030013")) {
        break;
      }
      paramInt = 12;
      break label198;
      if (!str1.equals("1000030014")) {
        break;
      }
      paramInt = 13;
      break label198;
      if (!str1.equals("1000030015")) {
        break;
      }
      paramInt = 14;
      break label198;
      str1 = "res:///2130839925";
      break label275;
      str1 = "res:///2130839926";
      break label275;
      str1 = "res:///2130839927";
      break label275;
      str1 = "res:///2130839928";
      break label275;
      str1 = "res:///2130839929";
      break label275;
      str1 = "res:///2130839930";
      break label275;
      str1 = "res:///2130839931";
      break label275;
      str1 = "res:///2130839932";
      break label275;
      str1 = "res:///2130839933";
      break label275;
      str1 = "res:///2130839934";
      break label275;
      str1 = "res:///2130839935";
      break label275;
      str1 = "res:///2130839936";
      break label275;
      str1 = "res:///2130839937";
      break label275;
      str1 = "res:///2130839938";
      break label275;
      str1 = "res:///2130839939";
      break label275;
      a.b(parama).setText("");
    }
    label650:
    a.c(parama).setText("");
  }
  
  public a onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.b).inflate(2130904136, paramViewGroup, false));
  }
  
  public void setData(ArrayList<GoodsParamsMo> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public static class a
    extends RecyclerView.u
  {
    private SimpleDraweeView a;
    private TextView b;
    private TextView c;
    
    public a(View paramView)
    {
      super();
      this.a = ((SimpleDraweeView)paramView.findViewById(2131694859));
      this.b = ((TextView)paramView.findViewById(2131694867));
      this.c = ((TextView)paramView.findViewById(2131694868));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */