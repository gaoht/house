package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.View;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.minsu.view.b.e.a;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MovingIndexActivity;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecModel;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecModel.ItemContentBean;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecResultModel;
import com.ziroom.ziroomcustomer.newmovehouse.model.MoveRecResultRequestModel;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class d
  implements c.a
{
  private WeakReference<c.b> a;
  private int b;
  private MoveRecModel c;
  private int d;
  private MoveRecResultModel e;
  
  public d(c.b paramb)
  {
    this.a = new WeakReference(paramb);
    if (getView() != null) {
      getView().setPresenter(this);
    }
  }
  
  private void a()
  {
    getView().initIndex(this.d + "");
    getView().initSize("/" + this.b);
    c.b localb = getView();
    Object localObject;
    if (this.c == null)
    {
      localObject = "";
      localb.initImg((String)localObject);
      localb = getView();
      if (this.c != null) {
        break label156;
      }
      localObject = "";
      label99:
      localb.initStandard((String)localObject);
      localObject = getView();
      if ((this.c != null) && (!TextUtils.isEmpty(this.c.picUrl))) {
        break label167;
      }
    }
    label156:
    label167:
    for (int i = 1;; i = 3)
    {
      ((c.b)localObject).initRecyclerView(i, b());
      return;
      localObject = this.c.picUrl;
      break;
      localObject = this.c.slogan;
      break label99;
    }
  }
  
  private void a(MoveRecResultModel paramMoveRecResultModel)
  {
    if (paramMoveRecResultModel == null)
    {
      getView().currentPageSelected(2);
      return;
    }
    this.e = paramMoveRecResultModel;
    getView().setResultVisible(true);
    getView().initResultImg(paramMoveRecResultModel.picUrl);
    getView().initResultType(paramMoveRecResultModel.serviceInfoName);
    getView().initResultMoney(paramMoveRecResultModel.priceRemark);
    getView().intiResultTime(paramMoveRecResultModel.timeRemark);
    getView().initResultDesc(paramMoveRecResultModel.slogan);
  }
  
  private com.ziroom.ziroomcustomer.newmovehouse.b.f b()
  {
    Activity localActivity = (Activity)getView().getViewContext();
    final Object localObject;
    if (this.c == null)
    {
      localObject = null;
      if ((this.c != null) && (!TextUtils.isEmpty(this.c.picUrl))) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      localObject = new com.ziroom.ziroomcustomer.newmovehouse.b.f(localActivity, 2130904367, (List)localObject, bool);
      ((com.ziroom.ziroomcustomer.newmovehouse.b.f)localObject).setOnItemClickListener(new e.a()
      {
        public void onItemClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          d.this.checkMoveRecResult(paramAnonymousInt);
          if (((MoveRecModel.ItemContentBean)d.a(d.this).itemContent.get(paramAnonymousInt)).isSelect) {
            return;
          }
          paramAnonymousView = d.a(d.this).itemContent.iterator();
          while (paramAnonymousView.hasNext()) {
            ((MoveRecModel.ItemContentBean)paramAnonymousView.next()).isSelect = false;
          }
          ((MoveRecModel.ItemContentBean)d.a(d.this).itemContent.get(paramAnonymousInt)).isSelect = true;
          localObject.notifyDataSetChanged();
        }
        
        public boolean onItemLongClick(View paramAnonymousView, RecyclerView.u paramAnonymousu, int paramAnonymousInt)
        {
          return false;
        }
      });
      return (com.ziroom.ziroomcustomer.newmovehouse.b.f)localObject;
      localObject = this.c.itemContent;
      break;
    }
  }
  
  public void checkMoveRecResult(int paramInt)
  {
    if ((getView() == null) || (!getView().isActive())) {
      return;
    }
    MoveRecResultRequestModel localMoveRecResultRequestModel = new MoveRecResultRequestModel();
    if (this.c == null)
    {
      str = "";
      localMoveRecResultRequestModel.num = str;
      if (this.c != null) {
        break label118;
      }
    }
    label118:
    for (String str = "";; str = ((MoveRecModel.ItemContentBean)this.c.itemContent.get(paramInt)).option)
    {
      localMoveRecResultRequestModel.option = str;
      n.requestMoveRecResult(getView().getViewContext(), getView().getOptions(localMoveRecResultRequestModel), new com.ziroom.ziroomcustomer.e.a.d(getView().getViewContext(), new com.ziroom.ziroomcustomer.e.c.f(MoveRecResultModel.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          if ((paramAnonymousThrowable instanceof com.ziroom.ziroomcustomer.e.b.a))
          {
            d.this.getView().currentPageSelected(2);
            dismissProgress();
            return;
          }
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, MoveRecResultModel paramAnonymousMoveRecResultModel)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousMoveRecResultModel);
          try
          {
            d.a(d.this, paramAnonymousMoveRecResultModel);
            return;
          }
          catch (Exception paramAnonymousMoveRecResultModel)
          {
            d.this.getView().currentPageSelected(2);
            g.textToast(d.this.getView().getViewContext(), "服务器请求异常！");
          }
        }
      });
      return;
      str = this.c.itemNum;
      break;
    }
  }
  
  public void detachView()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public MoveRecResultModel getResult()
  {
    return this.e;
  }
  
  public c.b getView()
  {
    if (this.a != null) {
      return (c.b)this.a.get();
    }
    return null;
  }
  
  public void gotoMovingIndexActivity()
  {
    if (this.e == null) {
      return;
    }
    Intent localIntent = new Intent(getView().getViewContext(), MovingIndexActivity.class);
    localIntent.putExtra("productCode", this.e.serviceInfoId);
    localIntent.putExtra("ServiceInfoName", this.e.serviceInfoName);
    localIntent.putExtra("shareImage", this.e.picUrl);
    localIntent.putExtra("serviceContent", this.e.slogan);
    getView().getViewContext().startActivity(localIntent);
  }
  
  public void start()
  {
    if ((getView() == null) || (!getView().isActive())) {
      return;
    }
    Bundle localBundle = getView().getArgs();
    this.d = localBundle.getInt("index");
    this.b = localBundle.getInt("size");
    this.c = ((MoveRecModel)localBundle.getSerializable("model"));
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */