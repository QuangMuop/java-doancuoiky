/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import java.text.Collator;
import java.util.Locale;

/**
 *
 * @author bin
 */
public class MyCompare {
    public static int compareString(String s1, String s2)
    {
        Collator comp = Collator.getInstance(new Locale("vi"));
        return comp.compare(s1, s2);
    }
    public enum CompareOption
    {
        TangDan,
        GiamDan
    }

}
