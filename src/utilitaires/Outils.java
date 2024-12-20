package utilitaires;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Outils {

    public static Date stringToDate(String unedate) {
        Date datesortie = null;
        try {
            SimpleDateFormat defFormat = new SimpleDateFormat("dd/MM/yyyy");
            datesortie = defFormat.parse(unedate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return datesortie;
    }

    public static String dateToString(Date uneDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(uneDate);
    }

    public static Date dateJour() {
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }

    public static int getAnnee(Date uneDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(uneDate);
        return c.get(Calendar.YEAR);
    }

    /*
     Exemples d'utilisation 
     Date dateJour = Outils.stringToDate("29/04/1952", "dd/MM/yyyy");
     System.out.println(dateJour);
     Date d = new Date();
     String dateStr = Outils.dateToString(d);
     System.out.println(dateStr);
     int annee = Outils.getAnnee(d);
     System.out.println(annee);
     */
}
