package etechoracio.com.br.etec_solicitaodeferias.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeUtils {

    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static String formatDate(int dia , int mes , int ano){
        try{
            Calendar calendar = Calendar.getInstance();
            calendar.set(ano,mes,dia);
            return DATE_FORMAT.format(calendar.getTime());
        }
        catch (Exception e){
            return null;
        }
    }
}
