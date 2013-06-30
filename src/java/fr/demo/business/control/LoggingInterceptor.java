/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.business.control;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.jboss.logging.Logger;

/**
 *
 * @author Adouche Ali
 */
@Interceptor
@Logging
public class LoggingInterceptor {
    
    private static final Logger logger =
            Logger.getLogger(LoggingInterceptor.class);
    
    @AroundInvoke
    public Object log(InvocationContext context) throws Exception{
        Object[] parameters = context.getParameters();
        StringBuilder sb = new StringBuilder();
        if ( parameters != null && parameters.length != 0 ) {
            for (Object object : parameters) {
                sb.append(object);
                sb.append(", ");
            }
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        
        logger.info(context.getTarget() + " : " + 
                context.getMethod().getName() + "(" + sb.toString() + ")");

        return context.proceed();
    }
}
