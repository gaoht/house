package com.ziroom.ziroomcustomer.newclean.cardpay.model;

public class CleanUesrIsNewMo
{
  private DocumentMo document;
  private InviteMo invite;
  private boolean isNew;
  
  public DocumentMo getDocument()
  {
    return this.document;
  }
  
  public InviteMo getInvite()
  {
    return this.invite;
  }
  
  public boolean isNew()
  {
    return this.isNew;
  }
  
  public void setDocument(DocumentMo paramDocumentMo)
  {
    this.document = paramDocumentMo;
  }
  
  public void setInvite(InviteMo paramInviteMo)
  {
    this.invite = paramInviteMo;
  }
  
  public void setNew(boolean paramBoolean)
  {
    this.isNew = paramBoolean;
  }
  
  public class DocumentMo
  {
    private String image;
    private String text;
    private String url;
    
    public DocumentMo() {}
    
    public String getImage()
    {
      return this.image;
    }
    
    public String getText()
    {
      return this.text;
    }
    
    public String getUrl()
    {
      return this.url;
    }
    
    public void setImage(String paramString)
    {
      this.image = paramString;
    }
    
    public void setText(String paramString)
    {
      this.text = paramString;
    }
    
    public void setUrl(String paramString)
    {
      this.url = paramString;
    }
  }
  
  public class InviteMo
  {
    private String content;
    private String image;
    private String inviteUrl;
    private String shareUrl;
    private String title;
    
    public InviteMo() {}
    
    public String getContent()
    {
      return this.content;
    }
    
    public String getImage()
    {
      return this.image;
    }
    
    public String getInviteUrl()
    {
      return this.inviteUrl;
    }
    
    public String getShareUrl()
    {
      return this.shareUrl;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setContent(String paramString)
    {
      this.content = paramString;
    }
    
    public void setImage(String paramString)
    {
      this.image = paramString;
    }
    
    public void setInviteUrl(String paramString)
    {
      this.inviteUrl = paramString;
    }
    
    public void setShareUrl(String paramString)
    {
      this.shareUrl = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/model/CleanUesrIsNewMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */