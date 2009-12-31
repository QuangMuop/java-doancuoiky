/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BUS;

import DTO.KhachHang;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author bin
 */
class MyWorker extends SwingWorker<ArrayList<KhachHang>, Integer>
{
    protected ArrayList<KhachHang> doInBackground() throws Exception
    {
            // Do a time-consuming task.
        ArrayList<KhachHang> lst = new ArrayList<KhachHang>();
        KhachHang k = new KhachHang();

            Thread.sleep(1000);
            return lst;
    }

    @Override
    protected void done()
    {
            try
            {
                    //JOptionPane.showMessageDialog(f, get());
            }
            catch (Exception e)
            {
                    e.printStackTrace();
            }
    }
}
