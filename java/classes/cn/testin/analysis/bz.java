package cn.testin.analysis;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class bz
{
  HashMap<bv, List<by>> a = new HashMap();
  
  bz(bv parambv) {}
  
  public void addPath(bv parambv, List<by> paramList, by paramby)
  {
    if (!this.a.containsKey(parambv))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramList);
      localArrayList.add(0, paramby);
      if (!localArrayList.isEmpty()) {
        this.a.put(parambv, localArrayList);
      }
    }
  }
  
  void cleanUp(View paramView)
  {
    this.a.clear();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */