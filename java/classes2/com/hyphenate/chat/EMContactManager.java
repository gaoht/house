package com.hyphenate.chat;

import com.hyphenate.EMCallBack;
import com.hyphenate.EMContactListener;
import com.hyphenate.EMValueCallBack;
import com.hyphenate.chat.adapter.EMAContactListener;
import com.hyphenate.chat.adapter.EMAContactManager;
import com.hyphenate.chat.adapter.EMAError;
import com.hyphenate.exceptions.HyphenateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EMContactManager
{
  private EMAContactListenerImpl contactImpl = new EMAContactListenerImpl();
  private List<EMContactListener> contactListeners = Collections.synchronizedList(new ArrayList());
  EMAContactManager emaObject;
  EMClient mClient;
  
  EMContactManager(EMClient paramEMClient, EMAContactManager paramEMAContactManager)
  {
    this.mClient = paramEMClient;
    this.emaObject = new EMAContactManager(paramEMAContactManager);
    this.emaObject.registerContactListener(this.contactImpl);
  }
  
  private void handleError(EMAError paramEMAError)
    throws HyphenateException
  {
    if (paramEMAError.errCode() != 0) {
      throw new HyphenateException(paramEMAError);
    }
  }
  
  public void acceptInvitation(String paramString)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    this.emaObject.acceptInvitation(paramString, localEMAError);
    handleError(localEMAError);
  }
  
  public void addContact(String paramString1, String paramString2)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    this.emaObject.inviteContact(paramString1, paramString2, localEMAError);
    handleError(localEMAError);
  }
  
  public void addUserToBlackList(String paramString, boolean paramBoolean)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    this.emaObject.addToBlackList(paramString, paramBoolean, localEMAError);
    handleError(localEMAError);
  }
  
  public void asyncAcceptInvitation(final String paramString, final EMCallBack paramEMCallBack)
  {
    EMClient.getInstance().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          EMContactManager.this.acceptInvitation(paramString);
          paramEMCallBack.onSuccess();
          return;
        }
        catch (HyphenateException localHyphenateException)
        {
          paramEMCallBack.onError(localHyphenateException.getErrorCode(), localHyphenateException.getDescription());
        }
      }
    });
  }
  
  public void asyncDeclineInvitation(final String paramString, final EMCallBack paramEMCallBack)
  {
    EMClient.getInstance().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          EMContactManager.this.declineInvitation(paramString);
          paramEMCallBack.onSuccess();
          return;
        }
        catch (HyphenateException localHyphenateException)
        {
          paramEMCallBack.onError(localHyphenateException.getErrorCode(), localHyphenateException.getDescription());
        }
      }
    });
  }
  
  public void asyncSaveBlackList(final List<String> paramList, final EMCallBack paramEMCallBack)
  {
    EMClient.getInstance().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          EMContactManager.this.saveBlackList(paramList);
          paramEMCallBack.onSuccess();
          return;
        }
        catch (HyphenateException localHyphenateException)
        {
          paramEMCallBack.onError(localHyphenateException.getErrorCode(), localHyphenateException.getDescription());
        }
      }
    });
  }
  
  public void aysncAddContact(final String paramString1, final String paramString2, final EMCallBack paramEMCallBack)
  {
    EMClient.getInstance().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          EMContactManager.this.addContact(paramString1, paramString2);
          paramEMCallBack.onSuccess();
          return;
        }
        catch (HyphenateException localHyphenateException)
        {
          paramEMCallBack.onError(localHyphenateException.getErrorCode(), localHyphenateException.getDescription());
        }
      }
    });
  }
  
  public void aysncAddUserToBlackList(final String paramString, final boolean paramBoolean, final EMCallBack paramEMCallBack)
  {
    EMClient.getInstance().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          EMContactManager.this.addUserToBlackList(paramString, paramBoolean);
          paramEMCallBack.onSuccess();
          return;
        }
        catch (HyphenateException localHyphenateException)
        {
          paramEMCallBack.onError(localHyphenateException.getErrorCode(), localHyphenateException.getDescription());
        }
      }
    });
  }
  
  public void aysncDeleteContact(final String paramString, final EMCallBack paramEMCallBack)
  {
    EMClient.getInstance().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          EMContactManager.this.deleteContact(paramString);
          paramEMCallBack.onSuccess();
          return;
        }
        catch (HyphenateException localHyphenateException)
        {
          paramEMCallBack.onError(localHyphenateException.getErrorCode(), localHyphenateException.getDescription());
        }
      }
    });
  }
  
  public void aysncGetAllContactsFromServer(final EMValueCallBack<List<String>> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          List localList = EMContactManager.this.getAllContactsFromServer();
          paramEMValueCallBack.onSuccess(localList);
          return;
        }
        catch (HyphenateException localHyphenateException)
        {
          paramEMValueCallBack.onError(localHyphenateException.getErrorCode(), localHyphenateException.getDescription());
        }
      }
    });
  }
  
  public void aysncGetBlackListFromServer(final EMValueCallBack<List<String>> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          List localList = EMContactManager.this.getBlackListFromServer();
          paramEMValueCallBack.onSuccess(localList);
          return;
        }
        catch (HyphenateException localHyphenateException)
        {
          paramEMValueCallBack.onError(localHyphenateException.getErrorCode(), localHyphenateException.getDescription());
        }
      }
    });
  }
  
  public void aysncGetSelfIdsOnOtherPlatform(final EMValueCallBack<List<String>> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          List localList = EMContactManager.this.getSelfIdsOnOtherPlatform();
          paramEMValueCallBack.onSuccess(localList);
          return;
        }
        catch (HyphenateException localHyphenateException)
        {
          paramEMValueCallBack.onError(localHyphenateException.getErrorCode(), localHyphenateException.getDescription());
        }
      }
    });
  }
  
  public void aysncRemoveUserFromBlackList(final String paramString, final EMCallBack paramEMCallBack)
  {
    EMClient.getInstance().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          EMContactManager.this.removeUserFromBlackList(paramString);
          paramEMCallBack.onSuccess();
          return;
        }
        catch (HyphenateException localHyphenateException)
        {
          paramEMCallBack.onError(localHyphenateException.getErrorCode(), localHyphenateException.getDescription());
        }
      }
    });
  }
  
  public void declineInvitation(String paramString)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    this.emaObject.declineInvitation(paramString, localEMAError);
    handleError(localEMAError);
  }
  
  public void deleteContact(String paramString)
    throws HyphenateException
  {
    deleteContact(paramString, false);
  }
  
  public void deleteContact(String paramString, boolean paramBoolean)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    this.emaObject.deleteContact(paramString, localEMAError, paramBoolean);
    EMClient.getInstance().chatManager().caches.remove(paramString);
    handleError(localEMAError);
  }
  
  public List<String> getAllContactsFromServer()
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    List localList = this.emaObject.getContactsFromServer(localEMAError);
    handleError(localEMAError);
    return localList;
  }
  
  public List<String> getBlackListFromServer()
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    List localList = this.emaObject.getBlackListFromServer(localEMAError);
    handleError(localEMAError);
    return localList;
  }
  
  public List<String> getBlackListUsernames()
  {
    EMAError localEMAError = new EMAError();
    return this.emaObject.getBlackListFromDB(localEMAError);
  }
  
  List<String> getContactsFromDB(EMAError paramEMAError)
  {
    return this.emaObject.getContactsFromDB(paramEMAError);
  }
  
  public List<String> getSelfIdsOnOtherPlatform()
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    List localList = this.emaObject.getSelfIdsOnOtherPlatform(localEMAError);
    handleError(localEMAError);
    return localList;
  }
  
  void onLogout() {}
  
  public void removeContactListener(EMContactListener paramEMContactListener)
  {
    this.contactListeners.remove(paramEMContactListener);
  }
  
  public void removeUserFromBlackList(String paramString)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    this.emaObject.removeFromBlackList(paramString, localEMAError);
    handleError(localEMAError);
  }
  
  public void saveBlackList(List<String> paramList)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    this.emaObject.saveBlackList(paramList, localEMAError);
    handleError(localEMAError);
  }
  
  public void setContactListener(EMContactListener paramEMContactListener)
  {
    if (!this.contactListeners.contains(paramEMContactListener)) {
      this.contactListeners.add(paramEMContactListener);
    }
  }
  
  class EMAContactListenerImpl
    extends EMAContactListener
  {
    EMAContactListenerImpl() {}
    
    public void onContactAdded(String paramString)
    {
      synchronized (EMContactManager.this.contactListeners)
      {
        try
        {
          Iterator localIterator = EMContactManager.this.contactListeners.iterator();
          while (localIterator.hasNext()) {
            ((EMContactListener)localIterator.next()).onContactAdded(paramString);
          }
          paramString = finally;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
    }
    
    public void onContactAgreed(String paramString)
    {
      synchronized (EMContactManager.this.contactListeners)
      {
        try
        {
          Iterator localIterator = EMContactManager.this.contactListeners.iterator();
          while (localIterator.hasNext()) {
            ((EMContactListener)localIterator.next()).onFriendRequestAccepted(paramString);
          }
          paramString = finally;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
    }
    
    public void onContactDeleted(String paramString)
    {
      EMClient.getInstance().chatManager().caches.remove(paramString);
      synchronized (EMContactManager.this.contactListeners)
      {
        try
        {
          Iterator localIterator = EMContactManager.this.contactListeners.iterator();
          while (localIterator.hasNext()) {
            ((EMContactListener)localIterator.next()).onContactDeleted(paramString);
          }
          paramString = finally;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
    }
    
    public void onContactInvited(String paramString1, String paramString2)
    {
      synchronized (EMContactManager.this.contactListeners)
      {
        try
        {
          Iterator localIterator = EMContactManager.this.contactListeners.iterator();
          while (localIterator.hasNext()) {
            ((EMContactListener)localIterator.next()).onContactInvited(paramString1, paramString2);
          }
          paramString1 = finally;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          return;
        }
      }
    }
    
    public void onContactRefused(String paramString)
    {
      synchronized (EMContactManager.this.contactListeners)
      {
        try
        {
          Iterator localIterator = EMContactManager.this.contactListeners.iterator();
          while (localIterator.hasNext()) {
            ((EMContactListener)localIterator.next()).onFriendRequestDeclined(paramString);
          }
          paramString = finally;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMContactManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */