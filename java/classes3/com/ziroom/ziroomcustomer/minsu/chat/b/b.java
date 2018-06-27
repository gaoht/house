package com.ziroom.ziroomcustomer.minsu.chat.b;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListAdapter;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newchat.ExpandGridView;
import com.ziroom.ziroomcustomer.newchat.SmileUtils;
import com.ziroom.ziroomcustomer.util.u;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class b
{
  public static View getBigExpressionView(Activity paramActivity, int paramInt, com.ziroom.ziroomcustomer.minsu.chat.c.a parama)
  {
    View localView = View.inflate(paramActivity, 2130903666, null);
    ExpandGridView localExpandGridView = (ExpandGridView)localView.findViewById(2131689486);
    List localList = com.ziroom.ziroomcustomer.minsu.chat.d.a.getInstance().getExpressionResBig();
    final ArrayList localArrayList = new ArrayList();
    if (paramInt == 1) {
      localArrayList.addAll(localList.subList(0, 8));
    }
    for (;;)
    {
      localExpandGridView.setAdapter(new c(paramActivity, 0, localArrayList));
      localExpandGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          if (this.a != null) {
            this.a.onClick((String)localArrayList.get(paramAnonymousInt));
          }
        }
      });
      return localView;
      if (paramInt == 2) {
        localArrayList.addAll(localList.subList(8, localList.size()));
      }
    }
  }
  
  public static List<String> getExpressionRes(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    while (i <= paramInt)
    {
      localArrayList.add("ee_" + i);
      i += 1;
    }
    return localArrayList;
  }
  
  public static View getGridChildView(int paramInt, final Activity paramActivity, final EditText paramEditText)
  {
    View localView = View.inflate(paramActivity, 2130903884, null);
    ExpandGridView localExpandGridView = (ExpandGridView)localView.findViewById(2131689486);
    Object localObject = getExpressionRes(35);
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1) {
      localArrayList.addAll(((List)localObject).subList(0, 20));
    }
    for (;;)
    {
      localArrayList.add("zrk_ic_fdmsgs_del");
      localObject = new a(paramActivity, 0, localArrayList);
      localExpandGridView.setAdapter((ListAdapter)localObject);
      localExpandGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramAnonymousAdapterView = (String)this.a.getItem(paramAnonymousInt);
          u.e("filename: ", paramAnonymousAdapterView);
          if (TextUtils.isEmpty(paramAnonymousAdapterView)) {}
          do
          {
            do
            {
              return;
              if (paramAnonymousAdapterView != "zrk_ic_fdmsgs_del") {}
              int i;
              try
              {
                paramAnonymousAdapterView = Class.forName("com.ziroom.ziroomcustomer.newchat.SmileUtils").getField(paramAnonymousAdapterView);
                paramEditText.append(SmileUtils.getSmiledText(paramActivity, (String)paramAnonymousAdapterView.get(null)));
                return;
              }
              catch (Exception paramAnonymousAdapterView) {}
            } while (TextUtils.isEmpty(VdsAgent.trackEditTextSilent(paramEditText)));
            paramAnonymousInt = paramEditText.getSelectionStart();
          } while (paramAnonymousInt <= 0);
          paramAnonymousAdapterView = VdsAgent.trackEditTextSilent(paramEditText).toString().substring(0, paramAnonymousInt);
          i = paramAnonymousAdapterView.lastIndexOf("[");
          if (i != -1)
          {
            if (SmileUtils.containsKey(paramAnonymousAdapterView.substring(i, paramAnonymousInt).toString()))
            {
              paramEditText.getEditableText().delete(i, paramAnonymousInt);
              return;
            }
            paramEditText.getEditableText().delete(paramAnonymousInt - 1, paramAnonymousInt);
            return;
          }
          paramEditText.getEditableText().delete(paramAnonymousInt - 1, paramAnonymousInt);
          return;
        }
      });
      return localView;
      if (paramInt == 2)
      {
        localArrayList.addAll(((List)localObject).subList(20, ((List)localObject).size()));
        if (localArrayList.size() < 20) {
          while (localArrayList.size() < 20) {
            localArrayList.add("");
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */