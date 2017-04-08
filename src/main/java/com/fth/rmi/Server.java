/*
* Package com.fth.rmi 
* FileName: Server
* Author:   fth
* Date:     2017/4/7 15:07
*/
package com.fth.rmi;

import org.apache.log4j.Logger;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * FileName:    Server
 * Author:      Br7roy
 * Date:        2017/4/7
 * Description: RMI 服务端
 */
public class Server {
  private static   Logger logger = Logger.getLogger(Server.class);
    public static void main(String[] args) {

        //注册管理器
        Registry registry = null;

        try {
            registry = LocateRegistry.createRegistry(8080);
            logger.info("----------->注册服务成功<-----------");
        } catch (RemoteException e) {
            logger.error("------------>注册服务失败<-----------");
        }
        //创建一个服务
        try {
            ServiceImpl service = new ServiceImpl();
            //将服务绑定命名
            if (registry != null) {
//                Naming.rebind("rmi://127.0.0.1:8080/ServiceImpl.queryName",service);
//                Naming.rebind("rmi://127.0.0.1:8080/ServiceImpl.execute", service);
                registry.rebind("Rust",service);
                registry.rebind("Rust2", service);
            }
            logger.info("----------->服务发布成功，等待消费者<-----------");
        } catch (RemoteException e) {
            logger.error("----------->服务发布失败<----------");
        }


    }
}
