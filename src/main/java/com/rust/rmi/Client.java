/*
* Package com.fth.rmi 
* FileName: Client
* Author:   fth
* Date:     2017/4/7 14:38
*/
package com.rust.rmi;

import org.apache.log4j.Logger;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * FileName:    Client
 * Author:      Br7roy
 * Date:        2017/4/7
 * Description: 远程对象调用 客户端
 */
public class Client {

    private static Logger logger = Logger.getLogger(Client.class);

    public static void main(String[] args) {
        String lookupName = "Rust";
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry("127.0.0.1", 8080);
            String[] serverNames = registry.list();
            for (String s : serverNames) {
                logger.info("----------->搜索到的服务列表：[" + s + "]<-----------");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            //根据命名获取服务
            IService iService = null;
            if (registry != null) {
                logger.info("----------->搜索服务名为：" + lookupName + "的服务<-----------");
                iService = (IService) registry.lookup(lookupName);
            }
            //调用远程方法

            String invokeResult = null;

            if (iService != null) {

                invokeResult = iService.queryName("Test MY RMI SERVER:queryName");

//                invokeResult = iService.execute("Test MY RMI SERVER:execute");


            }

            logger.info("----------->result of MY RMI SERVER:" + invokeResult + "<-----------");

        } catch (RemoteException | NotBoundException e) {

            logger.error("----------->服务名:[" + lookupName + "]未找到<-----------");

        }


    }
}
