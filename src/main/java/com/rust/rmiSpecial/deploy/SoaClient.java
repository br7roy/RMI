package com.rust.rmiSpecial.deploy;

import java.io.Serializable;
import java.rmi.Remote;

/**
 * FileName:    RPC
 * Created by   kwx
 * on :         2017-04-10
 * Description:
 */
public interface SoaClient extends Remote, Serializable {
    Object invoke(Object...objects);
}
