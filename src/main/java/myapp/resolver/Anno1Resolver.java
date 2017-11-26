package myapp.resolver;

import myapp.annotation.Anno1;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class Anno1Resolver implements HandlerMethodArgumentResolver {

    @Override
    public Object resolveArgument(MethodParameter arg0, ModelAndViewContainer arg1, 
                    NativeWebRequest arg2, WebDataBinderFactory arg3) throws Exception {
        return "annotation 1 2 3";
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {        
        return parameter.getParameterType().equals(String.class)
              && parameter.hasParameterAnnotation(Anno1.class);
    }

}
