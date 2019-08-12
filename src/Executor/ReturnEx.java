package Executor;

import Databse.ReturnDB;
import Object.ReturnObj;
import java.util.ArrayList;

/**
 *
 * @author Rahat
 * executor class for return class
 */
public class ReturnEx {
    
  private ReturnDB ReturnDl;
  private ReturnObj rturn;
  
  public ReturnEx() {
    rturn = new ReturnObj();
    ReturnDl = new ReturnDB();
  }

  public ReturnEx(ReturnObj rturn) {
    this.rturn = rturn;
    this.ReturnDl = new ReturnDB();
  }

  public ReturnObj getRturn() {
    return rturn;
  }

  public void setRturn(ReturnObj rturn) {
    this.rturn = rturn;
  }
  
//  public boolean authenticaterturn() throws Exception{
//    try{
//      ReturnDB.setrturn(rturn);
//      if(ReturnDB.authenticaterturn()){
//        ReturnDB.loadrturn();
//        rturn = ReturnDB.getrturn();
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
  
  public ArrayList<ReturnObj> getRturnList() throws Exception{
    try{
      return ReturnDl.getRturnList();
    }catch(Exception ex){
      throw ex;
    }
  }
  
  public ArrayList<ReturnObj> searchRturn() throws Exception{
    try{
      ReturnDl.setRturn(rturn);  
      return ReturnDl.searchRturn();
    }catch(Exception ex){
      throw ex;
    }
  }
}
