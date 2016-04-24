package invest.session.builder.bloomberg;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import invest.session.Session;
import invest.session.ShareSession;
import invest.session.builder.SessionBuilder;
import net.WebReader;

public class BloombergShareSessionBuilder extends SessionBuilder {

   private static final String SHARE_URL= "http://www.bloomberg.com/quote/%s";
   private static final String DATE_REGEX = "<div class=\"price-datetime\">.*?([0-9]+\\/[0-9]+\\/[0-9]+).*?<\\/div>";
   private static final String OPEN_REGEX = "Open.*?<div class=\"cell__value cell__value_\">.*?([0-9]+\\.[0-9]+)";
   private static final String CLOSE_REGEX = "class=\"price\">.*?([0-9]+\\.[0-9]+).*?<\\/div>";
   private static final String INTRAMIN_REGEX = "Day Range.*?<\\/div>.*?([0-9]+\\.[0-9]+)";
   private static final String INTRAMAX_REGEX = "Day Range.*?<\\/div>.*?[0-9]+\\.[0-9]+ - ([0-9]+\\.[0-9]+)";
   private static final String PER_REGEX = "Current P\\/E Ratio.*?<\\/div>.*?([0-9]+\\.[0-9]+)";
   
   public Session getSession(String builderId) {
      ShareSession session = null;
      String auxStr;
      try {
         String url = String.format(SHARE_URL, builderId);
         WebReader webPage = new WebReader(url);
         session = new ShareSession();
         
         /* Get date */
         auxStr = webPage.search(DATE_REGEX);
         Calendar calendar = Calendar.getInstance();         
         int day = calendar.get(Calendar.DATE);
         int month = calendar.get(Calendar.MONTH) + 1;
         int year = calendar.get(Calendar.YEAR);
         String date = String.format("%s/%s/%s", month, day, year);
         if (auxStr.compareTo(date)==0)
         {
            Date myDate = new SimpleDateFormat("MM/dd/yyyy").parse(auxStr);
            session.setDate(myDate);            
         }
         else
         {
            // TODO Generate error
         }
         
         /* Get closing price */
         auxStr = webPage.search(CLOSE_REGEX);
         session.setClosingPrice(Double.parseDouble(auxStr));
         /* Get opening price */
         auxStr = webPage.search(OPEN_REGEX);
         session.setOpeningPrice(Double.parseDouble(auxStr));

         /* Get IntraDay Min price */
         auxStr = webPage.search(INTRAMIN_REGEX);
         session.setIntraDayMin(Double.parseDouble(auxStr));
         /* Get IntraDay Max price */
         auxStr = webPage.search(INTRAMAX_REGEX);
         session.setIntraDayMax(Double.parseDouble(auxStr));
         
         /* Get PER */
         auxStr = webPage.search(PER_REGEX);
         session.setPER(Double.parseDouble(auxStr));
         
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         session = null;
      } catch (NullPointerException e){
         /* Any REGEX search return no value */
         e.printStackTrace();
         session = null;
      } catch (ParseException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         session = null;
      }
      return session;
   }
}