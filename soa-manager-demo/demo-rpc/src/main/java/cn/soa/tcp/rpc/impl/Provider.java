package cn.soa.tcp.rpc.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Provider {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(1234);
		while(true){
			Socket socket = server.accept();
			
			//读取服务信息
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			String interfacename = input.readUTF();//接口名称
			String methodName = input.readUTF();//方法名称
			Class<?>[] parameterTypes = (Class<?>[])input.readObject(); //参数对象
			Object[] arguments = (Object[]) input.readObject();//参数对象
				
			//执行调用 
			Class<?> serviceInterfaceClass = Class.forName(interfacename);
			//Object service = services.get(interfacename); //使用MAP集合获取该接口名称键对应的value, 此处不实现
			//获取要调用的方法
			Method method = serviceInterfaceClass.getMethod(methodName, parameterTypes);
			Object object = method.invoke(new SayHelloServiceImpl(), arguments);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(object);
		}
	}
}
