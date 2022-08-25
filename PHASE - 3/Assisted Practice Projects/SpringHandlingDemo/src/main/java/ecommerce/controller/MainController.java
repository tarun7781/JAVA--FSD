package ecommerce.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.beans.CustomEventPublisher;

@Controller
public class MainController {


        
           @RequestMapping(value = "/customevent", method = RequestMethod.GET)
            public String customEvent(ModelMap map)
            {
                    String confFile = "main-servlet.xml";
                ApplicationContext context = new ClassPathXmlApplicationContext(confFile);
                CustomEventPublisher cvp =
                        (CustomEventPublisher) context.getBean("customEventPublisher");
                     
                 cvp.publish();  
                 cvp.publish();
                return "customEvent";
            }


}
