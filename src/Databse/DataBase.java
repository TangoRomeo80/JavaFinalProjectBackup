package Databse;

import javax.swing.JOptionPane;

/**
 *
 * @author Rahat
 * class for backing up the database
 */
public class DataBase {
    
    String pathToMySql = "C:\\Bitnami\\wampstack-5.4.39-0\\mysql\\bin\\";
    String dataBaseUserName="root";
    String databaseName="inventory";
    String fname="inventory_backup";
    String databasePassword="276914049";
    
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
