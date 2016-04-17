import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import invest.Invester;
import invest.Investment;
import invest.Investments;

public class Main {

   public static void main(String[] args) {

      JAXBContext jaxbContext;
      try {
         jaxbContext = JAXBContext.newInstance(Investments.class);
         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
         Investments investments = (Investments) jaxbUnmarshaller.unmarshal(
               new File("Configuration.xml"));
         ApplicationContext context = 
               new ClassPathXmlApplicationContext("Beans.xml");

         Invester invester = (Invester)context.getBean("studentJDBCTemplate");
         for (Investment invest : investments.getInvestment())
         {
            invester.update(invest);
         }
      } catch (JAXBException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } 
   }

}
