/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.ReturnDl;
import ObjectFactory.ReturnOF;
import java.util.ArrayList;

/**
 *
 * @author chabbi
 */
public class ReportReturnBl {
    
  private ReturnDl ReturnDl;
  private ReturnOF rturn;
  
  public ReportReturnBl() {
    rturn = new ReturnOF();
    ReturnDl = new ReturnDl();
  }

  public ReportReturnBl(ReturnOF rturn) {
    this.rturn = rturn;
    this.ReturnDl = new ReturnDl();
  }

  public ReturnOF getRturn() {
    return rturn;
  }

  public void setRturn(ReturnOF rturn) {
    this.rturn = rturn;
  }
  
  public ArrayList<ReturnOF> getRturnList() throws Exception{
    try{
      return ReturnDl.getRturnList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
}
