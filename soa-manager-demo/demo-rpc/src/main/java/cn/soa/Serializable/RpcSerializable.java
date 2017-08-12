package cn.soa.Serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import cn.soa.entity.Person;
import cn.soa.entity.zhansan;

/*
 * ������Java���õ����л���ʽ��ʵ�ֵĶ������л��ͷ����л��Ĺؼ�����: 
 * Hessian�����ܿ�ܵײ���ʹ��
 * ���л���������  1,json/fiexjson/databind
 * 			2,java-built-in
 * 			3,xml
 * 			7,hessian
 */
public class RpcSerializable {
	@Test
	public void rpcSerializable() throws Exception{
		//����һ���ֽ����������
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		//���������
		ObjectOutputStream out = new ObjectOutputStream(os);
		//������д�뵽�ֽ��������, �������л�
		out.writeObject(new zhansan(18,"����"));
		byte[] zhangsanByte = os.toByteArray();
		
		//�ֽ�����������
		ByteArrayInputStream is = new ByteArrayInputStream(zhangsanByte);
		//ִ�з����л�,�����ж�ȡ����
		ObjectInputStream in = new ObjectInputStream(is);
		
		Person person = (Person) in.readObject();
		System.out.println(person);
	}
}