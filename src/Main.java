import java.io.File;

import javax.sql.DataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import invest.Invester;
import invest.Investment;
import invest.Investments;

public class Main {

   private static ApplicationContext context;

   private static Investments getInvestments(String file){

      JAXBContext jaxbContext;
      Investments investments = null;
      try {
         jaxbContext = JAXBContext.newInstance(Investments.class);
         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
         investments = (Investments) jaxbUnmarshaller.unmarshal(
               new File(file));
      } catch (JAXBException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return investments;
   }
   
   public static void main(String[] args) {

      context = new ClassPathXmlApplicationContext("Beans.xml");
      Investments investments = getInvestments("Configuration.xml");
      DataSource dataSource = (DataSource)context.getBean("dataSource");
      Invester invester = new Invester(dataSource);
      if (investments != null){
         for (Investment invest : investments.getInvestment())
         {
            invester.update(invest);
         }
      }
   }

}
