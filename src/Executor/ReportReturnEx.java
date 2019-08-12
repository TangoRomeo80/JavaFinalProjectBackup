package Executor;

import Databse.ReturnDB;
import Object.ReturnObj;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * executor class for return report class
 */
public class ReportReturnEx {
    
  private ReturnDB ReturnDl;
  private ReturnObj rturn;
  
  public ReportReturnEx() {
    rturn = new ReturnObj();
    ReturnDl = new ReturnDB();
  }

  public ReportReturnEx(ReturnObj rturn) {
    this.rturn = rturn;
    this.ReturnDl = new ReturnDB();
  }

  public ReturnObj getRturn() {
    return rturn;
  }

  public void setRturn(ReturnObj rturn) {
    this.rturn = rturn;
  }
  
  public ArrayList<ReturnObj> getRturnList() throws Exception{
    try{
      return ReturnDl.getRturnList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
}
