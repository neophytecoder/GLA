/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exammmm;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author root
 */
public class ApplicationLogger {
    @AroundInvoke
    public Object logMethodCall(InvocationContext ic) throws Exception {
        System.out.println(ic.getMethod()+"is called"); // log()
        long time = System.currentTimeMillis();
        Object obj = ic.proceed();
        long time2 = System.currentTimeMillis();
        System.out.println("time: " + (time2-time));
        return obj;
    }
}
