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
			
			//��ȡ������Ϣ
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			String interfacename = input.readUTF();//�ӿ�����
			String methodName = input.readUTF();//��������
			Class<?>[] parameterTypes = (Class<?>[])input.readObject(); //��������
			Object[] arguments = (Object[]) input.readObject();//��������
				
			//ִ�е��� 
			Class<?> serviceInterfaceClass = Class.forName(interfacename);
			//Object service = services.get(interfacename); //ʹ��MAP���ϻ�ȡ�ýӿ����Ƽ���Ӧ��value, �˴���ʵ��
			//��ȡҪ���õķ���
			Method method = serviceInterfaceClass.getMethod(methodName, parameterTypes);
			Object object = method.invoke(new SayHelloServiceImpl(), arguments);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(object);
		}
	}
}