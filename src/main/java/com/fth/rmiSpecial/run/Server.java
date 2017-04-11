/*
* Package com.fth.rmi 
* FileName: Server
* Author:   fth
* Date:     2017/4/7 15:07
*/
package com.fth.rmiSpecial.run;

import com.fth.InvokeException;
import com.fth.rmiSpecial.deploy.KSOA;
import com.fth.rmiSpecial.deploy.KSoaClient;
import com.fth.rmiSpecial.service.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public static Map<String, KSoaClient> serviceMethod = new HashMap<>();
    static private Logger logger = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) {

        //注册管理器
        Registry registry = null;

        logger.info("----------->注册服务start<-----------");
        try {
            registry = LocateRegistry.createRegistry(8082);
        } catch (RemoteException e) {
            throw new InvokeException("------------>注册服务失败<-----------");
        }
        logger.info("----------->注册服务成功<-----------");
        //创建一个服务
        try {
            ServiceImpl service = new ServiceImpl();
            logger.info("----------->服务发布:<-----------");
            Method[] Methods = service.getClass().getDeclaredMethods();
            for (Method method : Methods) {
                for (Annotation annotation : method.getDeclaredAnnotations()) {
                    logger.info("annotation:" + annotation.annotationType());
                }
                KSOA ksoa = method.getAnnotation(KSOA.class);
                if (ksoa == null) {
                    logger.error("-------->未找到注解<--------");
                    throw new RemoteException("-------->未找到注解<--------");
                }
                logger.info("----------->注册soa：[" + ksoa.value() + "]<-----------");
                logger.info("--------->desc：" + ksoa.desc() + "<------------");
                KSoaClient kSoaClient = new KSoaClient(ksoa.value(), service);
                registry.rebind(ksoa.value(), kSoaClient);
            }

        } catch (InvokeException | RemoteException e) {

            logger.error("----------->服务发布失败<----------");

        }
    }
}