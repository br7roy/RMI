/*
* Package com.fth.rmi 
* FileName: Server
* Author:   fth
* Date:     2017/4/7 15:07
*/
package com.fth.rmiSpecial;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
/**
 * FileName:    Server
 * Author:      Br7roy
 * Date:        2017/4/7
 * Description: RMI 服务端
 */
public class Server {
    public static Map<String,KSoaClient> serviceMethod = new HashMap<>();
    public static void main(String[] args) {

        //注册管理器
        Registry registry = null;

        try {
        	 System.out.println("----------->注册服务start<-----------");
            registry = LocateRegistry.createRegistry(8082);
            System.out.println("----------->注册服务成功<-----------");
        } catch (RemoteException e) {
            System.out.println("------------>注册服务失败<-----------");
        }
        //创建一个服务
        try {
            ServiceImpl service = new ServiceImpl();
            System.out.println("----------->服务发布:<-----------");
            Method[] Methods = service.getClass().getMethods();
            for (Method method : Methods) {
                System.out.println(method.getName());
                for (Annotation annotation : method.getAnnotations()){
                    System.out.println("annotation" + annotation.annotationType());
                }
                KSOA ksoa = method.getAnnotation(KSOA.class);
                if (ksoa != null){
                    System.out.println("----------->注册soa：[" + method.getName() + "]<-----------");
                    KSoaClient kSoaClient = new KSoaClient(ksoa.value(), method.getName(), service);
                    registry.bind(ksoa.value(), kSoaClient);
                }
            }
        } catch (Exception e) {
            System.out.println("----------->服务发布失败<----------");
        }


    }
}
