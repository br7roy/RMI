package com.fth.rmiSpecial.deploy;

import com.fth.InvokeException;
import util.FooUtil;

import java.rmi.Remote;

/**
 * FileName:    RPC
 * Created by   kwx
 * on :         2017-04-10
 * Description:
 */
public class KSoaClient implements SoaClient {
    private static final long serialVersionUID = 8963733452577369089L;
    private String name;
    private Remote remote;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Remote getRemote() {
        return remote;
    }

    public void setRemote(Remote remote) {
        this.remote = remote;
    }

    public KSoaClient(String name,
                      Remote remote) {
        this.name = name;
        this.remote = remote;
    }

    public KSoaClient() {
    }

    @Override
    public Object invoke(Object... objects) {
        if (FooUtil.isBlankArray(objects))
            throw new InvokeException("调用参数未接收");
        try {
            Class<?>[] params = null;
            params = new Class[objects.length];
            for (int i = 0; i < objects.length; i++) {
                params[i] = objects[i].getClass();
            }
//            return remote.getClass().getMethod(name, params).invoke(remote, objects);
            return remote.getClass().getDeclaredMethod(name, params).invoke(remote, objects);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
