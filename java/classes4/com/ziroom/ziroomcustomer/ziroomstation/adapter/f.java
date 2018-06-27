package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.ziroomstation.c.a;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderCreateHouseEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderCreateUserEntity;
import java.util.List;

public class f
  extends BaseAdapter
{
  private Context a;
  private a b;
  private a c;
  
  public f(Context paramContext, a parama)
  {
    this.a = paramContext;
    this.c = parama;
  }
  
  public int getCount()
  {
    if ((this.c == null) || (this.c.getmUserLt() == null)) {
      return 0;
    }
    return this.c.getmUserLt().size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.getmUserLt().get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130903701, null);
      this.b = new a();
      this.b.b = ((RelativeLayout)paramView.findViewById(2131693433));
      this.b.a = ((RelativeLayout)paramView.findViewById(2131693429));
      this.b.c = ((RelativeLayout)paramView.findViewById(2131693439));
      this.b.d = ((TextView)paramView.findViewById(2131693432));
      this.b.e = ((TextView)paramView.findViewById(2131693436));
      this.b.f = ((TextView)paramView.findViewById(2131693442));
      this.b.g = ((TextView)paramView.findViewById(2131693425));
      this.b.h = ((EditText)paramView.findViewById(2131693438));
      this.b.h.setKeyListener(DigitsKeyListener.getInstance("1234567890<qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM"));
      this.b.i = ((EditText)paramView.findViewById(2131693428));
      paramView.setTag(this.b);
    }
    for (;;)
    {
      this.b.g.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = 0;
          for (;;)
          {
            if (i < f.a(f.this).getmHouseLt().size())
            {
              if (((StationOrderCreateHouseEntity)f.a(f.this).getmHouseLt().get(i)).getName().equals(((StationOrderCreateUserEntity)f.a(f.this).getmUserLt().get(paramInt)).getHouseType())) {
                ((StationOrderCreateHouseEntity)f.a(f.this).getmHouseLt().get(i)).setUsedSize(((StationOrderCreateHouseEntity)f.a(f.this).getmHouseLt().get(i)).getUsedSize() - 1);
              }
            }
            else
            {
              f.a(f.this).getmUserLt().remove(paramInt);
              f.this.notifyDataSetChanged();
              return;
            }
            i += 1;
          }
        }
      });
      this.b.a.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          f.a(f.this).showPickerDialog(1, paramInt, true);
        }
      });
      this.b.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          f.a(f.this).showPickerDialog(2, paramInt, true);
        }
      });
      this.b.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          f.a(f.this).showPickerDialog(3, paramInt, true);
        }
      });
      this.b.d.setText(((StationOrderCreateUserEntity)this.c.getmUserLt().get(paramInt)).getSex());
      this.b.e.setText(((StationOrderCreateUserEntity)this.c.getmUserLt().get(paramInt)).getCredentialsStyle());
      this.b.f.setText(((StationOrderCreateUserEntity)this.c.getmUserLt().get(paramInt)).getHouseType());
      this.b.h.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          ((StationOrderCreateUserEntity)f.a(f.this).getmUserLt().get(paramInt)).setCredentials(paramAnonymousEditable.toString());
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.b.i.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          ((StationOrderCreateUserEntity)f.a(f.this).getmUserLt().get(paramInt)).setName(paramAnonymousEditable.toString());
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      return paramView;
      this.b = ((a)paramView.getTag());
    }
  }
  
  public void setmList(List<StationOrderCreateUserEntity> paramList)
  {
    notifyDataSetChanged();
  }
  
  class a
  {
    public RelativeLayout a;
    public RelativeLayout b;
    public RelativeLayout c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public EditText h;
    public EditText i;
    
    a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */