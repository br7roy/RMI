
2017-4-11
完善发布多个服务,client可以调用所需服务
---
下一步:如何使用代理模式，将代码隐藏起来。

使用接口定义的类型方便向上转型，实现多态，提高复用。

# rmiremote
RMI通讯测试

## target
rmi package provide one method in one service,when create connection between service & client,
runs good

rmi包中提供了单一方法的service，客户端与服务段建立连接后可以良好调用。


rmiSpecial package is mean to provide for not one method invoke
in the service 
rmiSpecial包中添加的内容意旨提供不止一种方法的service，通过不同服务名调用不同
的服务