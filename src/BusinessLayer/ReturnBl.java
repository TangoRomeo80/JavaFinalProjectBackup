/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.ReturnDl;
import ObjectFactory.ReturnOF;
import java.util.ArrayList;

/**
 *
 * @author chhabi
 */
public class ReturnBl {
    
  private ReturnDl ReturnDl;
  private ReturnOF rturn;
  
  public ReturnBl() {
    rturn = new ReturnOF();
    ReturnDl = new ReturnDl();
  }

  public ReturnBl(ReturnOF rturn) {
    this.rturn = rturn;
    this.ReturnDl = new ReturnDl();
  }

  public ReturnOF getRturn() {
    return rturn;
  }

  public void setRturn(ReturnOF rturn) {
    this.rturn = rturn;
  }
  
//  public boolean authenticaterturn() throws Exception{
//    try{
//      ReturnDl.setrturn(rturn);
//      if(ReturnDl.authenticaterturn()){
//        ReturnDl.loadrturn();
//        rturn = ReturnDl.getrturn();
//        return true;
//      }
//    }catch( Exception ex){
//      throw ex;
//    }
//    return false;
//  }
//  
  public boolean insertRturn() throws Exception{
    try{
      ReturnDl.setRturn(rturn);
      return ReturnDl.insertRturn();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean updateRturn() throws Exception{
    try{
      ReturnDl.setRturn(rturn);
      return ReturnDl.updateRturn();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public boolean deleteRturn() throws Exception{
    try{
      ReturnDl.setRturn(rturn);
      return ReturnDl.deleteRturn();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<ReturnOF> getRturnList() throws Exception{
    try{
      return ReturnDl.getRturnList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<ReturnOF> searchRturn() throws Exception{
    try{
      ReturnDl.setRturn(rturn);  
      return ReturnDl.searchRturn();
    }catch(Exception ex){
      throw ex;
    }
  }
}
