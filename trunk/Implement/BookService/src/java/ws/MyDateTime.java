/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author bin
 */
public class MyDateTime {
    public static Date getNow()
    {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }
    
    public static int getYear(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);        
    }
    
    public static int getMonth(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);        
    }
    
    public static int getDay(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);        
    }

    public static String getString(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    static public int SubDate(Date start, Date end)
    {
        int distance = 0;

        Calendar cStart = Calendar.getInstance();
        cStart.setTime(start);

        Calendar cEnd = Calendar.getInstance();
        cEnd.setTime(end);

        int d1 = cStart.get(Calendar.DAY_OF_MONTH), d2 = cEnd.get(Calendar.DAY_OF_MONTH);
        int m1 = cStart.get(Calendar.MONTH), m2 = cEnd.get(Calendar.MONTH);
        int y1 = cStart.get(Calendar.YEAR), y2 = cEnd.get(Calendar.YEAR);

        if (y2 > y1)
        {
            while (y2 - y1 > 1)
            {
                if ((y2 - 1) % 4 == 0)
                    distance += 366;
                else
                    distance += 365;
                y2--;
            }

            distance += CalcDate(cEnd);
            cEnd.set(cStart.get(Calendar.YEAR), 12, 31);
        }

        distance += CalcDate(cEnd) - CalcDate(cStart);
        return distance;

    }

    static private int CalcDate(Calendar dt)
    {
        int d = dt.get(Calendar.DAY_OF_MONTH);
        int m = dt.get(Calendar.MONTH);
        m--;
        while (m > 0)
        {
            switch (m)
            {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    d += 31;
                    break;
                case 2:
                    if (dt.get(Calendar.YEAR) % 4 == 0)
                    {
                        d += 29;
                        break;
                    }
                    d += 28;
                    break;
                default:
                    d += 30;
                    break;
            }
            m--;
        }
        return d;
    }
}
