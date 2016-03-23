import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import invest.Investments;

public class Main {

   public static void main(String[] args) {

      JAXBContext jaxbContext;
      try {
         jaxbContext = JAXBContext.newInstance(Investments.class);
         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
         Investments investments = (Investments) jaxbUnmarshaller.unmarshal(new File("D:\\Mis documentos\\Proyectos\\workspace\\InvesterAI\\file.xml"));
         investments.update();
      } catch (JAXBException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

}
