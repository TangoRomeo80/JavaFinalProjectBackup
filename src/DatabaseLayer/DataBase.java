/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import javax.swing.JOptionPane;

/**
 *
 * @author chhabi
 */
public class DataBase {
    
    String pathToMySql = "C:\\Bitnami\\wampstack-5.4.39-0\\mysql\\bin\\";
    String dataBaseUserName="root";
    String databaseName="inventory";
    String fname="inventory_backup";
    String databasePassword="password";
    
    public void DbBackUp() throws Exception
    {
        try
        {
            Process p = null;
            Runtime runtime = Runtime.getRuntime();
            String uri = this.pathToMySql + "mysqldump -u " + this.dataBaseUserName + " -p"+ this.databasePassword + " --add-drop-database -B " + this.databaseName+" -r E:\\"+ fname+".sql";
            //JOptionPane.showMessageDialog(null, uri);
            p = runtime.exec(uri);
            int processComplete = p.waitFor();
            
            if (processComplete == 0)
            {
                //JOptionPane.showMessageDialog(null, "Backuped successfully","Successfull", JOptionPane.INFORMATION_MESSAGE);                
            } else
            {
                //JOptionPane.showMessageDialog(null, "Unable to Backup", "Error Occured", JOptionPane.ERROR_MESSAGE);                
            }

        } catch (Exception e)
        {
            
            throw e;
        }
    }
}
