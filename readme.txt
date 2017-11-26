1) pom.xml
   -- add version properties and use them in dependencies  
   -- add dependencies
   -- plugins for deploying
   -- setup artifact id, deployment path etc.

2) web.xml
  -- spring DispatcherServlet with name myapp; load on startup = 1
  -- mapping to map / to dispatcher servlet;
  -- spring will look for myapp-servlet xml under WEB-INF
  -- add contextConfigLocation  param and set file path to classpath*:META-INF/myapp-spring.xml

3) Add /resources/META-INF/myapp-spring xml 
   -- add annotation driven and component scan

4) Under dispatcher servlet xml , /WEB-INF/myapp-servlet.xml
  -- add argument resolver
  -- add view resolver
  -- add interceptors
  -- annotation config
  -- component-scan - context - include filter to spring stereotype controller
 - 
 5)  Add JAVA files under different packages
 Under src/main
 -- myapp.controller.HelloController with annotation @Controller (class) and @Request (method)
 -- myapp.interceptor.HelloInterceptor extends HandlerInterceptorAdapter
 -- myapp.annotation.Anno1 @interface, @Retention, @Target
 -- myapp.resolver.Anno1Resolver implements HandlerMethodArgumentResolver
 -- myapp.service.MyService implements IMyService
Under src/test
  -- myapp.service.MyServiceTest (@Before, @After, @Test, assertEquals) 
  
6) maven goal - clean deploy
 --environment = local (parameter)
 
 --urlrewrite - required to avoid tomcat from invoking automatic JSP compiler on the URLs.
   -need to translate this to .do and map to a spring request-mapping

 7) Added RESTful web service 
 
 8) Adding spring security
   -add the spring security xml to contextConfigLocation param in web.xml : spring-security.xml
   -define the security:authentication-manager -> authentication-provider to the bean reference of class that implements AuthenticationProvider
   - add class that implments AuthenticationProvider; override - Authentication authenticate(Authentication authentication)
   -spring-security.xml: add security:intercept-url with pattern="xxx" access="hasRole('ROLE_USER')"
   -security:http and security:headers as needed
   
9) Add JPA
  
10) Create and consume web services
 
 http://www.baeldung.com/spring-mvc-handlerinterceptor
