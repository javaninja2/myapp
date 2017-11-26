package myapp.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import myapp.annotation.Anno1;
import myapp.model.User;
import myapp.service.stub.IMyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);
    private IMyService myService;
    
    public IMyService getMyService() {
        return myService;
    }
    @Autowired
    public void setMyService(IMyService myService) {
        this.myService = myService;
    }

    @RequestMapping (value = "/hello", method=RequestMethod.GET)
    public ModelAndView getPage(@Anno1 String anno1, 
                    @RequestParam(value="name") String name) {
        LOG.debug("reached hello:{}", anno1);
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("anno1", anno1);
        mav.addObject("name", String.format("%s - %d", name ,  myService.sum(3, 4)) );
        return mav;
    }

    @RequestMapping (value = "/login", method= RequestMethod.GET)
    public ModelAndView getLogin( ModelAndView mav) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
                Validator validator = validatorFactory.getValidator();
                System.out.println("NAME: " + validator.getClass().getCanonicalName());
                Set<ConstraintViolation<User>> constraintViolations = validator.validate( new User() );

                for (ConstraintViolation<User> violation : constraintViolations) {
                    System.out.println("ERORR: " + violation.getMessage());
                }
                
        mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }
    
    @RequestMapping (value = "/login", method= RequestMethod.POST)
    public String login(Model model, @Valid @ModelAttribute("user") User user, BindingResult result) {
        LOG.debug("errorcount:{}", result.getErrorCount());
        if (result.hasErrors()) {
            return "login";
        } else {
            return "redirect:hello?name=" + user.getUsername();
        }
    }
    

}
