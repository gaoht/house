package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ProjectDetailDto
  extends b
{
  public ProjectDetailData data;
  
  public ProjectDetailDto() {}
  
  public ProjectDetailDto(ProjectDetailData paramProjectDetailData)
  {
    this.data = paramProjectDetailData;
  }
  
  public String toString()
  {
    return "ProjectDetailDto{data=" + this.data + '}';
  }
  
  public class ProjectDetailData
  {
    public double lat;
    public double lng;
    public String openTime;
    public String projectAddress;
    public String sellPhone;
    public String showHouseUrl;
    public String traffic;
    public List<String> url;
    public String viewpoint;
    
    public ProjectDetailData() {}
    
    public String toString()
    {
      return "ProjectDetailData{url=" + this.url + ", projectAddress='" + this.projectAddress + '\'' + ", lat=" + this.lat + ", lng=" + this.lng + ", sellPhone='" + this.sellPhone + '\'' + ", viewpoint='" + this.viewpoint + '\'' + ", traffic='" + this.traffic + '\'' + ", openTime='" + this.openTime + '\'' + ", showHouseUrl='" + this.showHouseUrl + '\'' + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/ProjectDetailDto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */