package cn.soa.Serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import cn.soa.entity.Person;
import cn.soa.entity.zhansan;
/*
 * Hession�����л��ķ����л�ʵ��
 */
public class HessianSerializable {
	public static void main(String[] args) throws Exception {
		//����һ���ֽ����������
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		//���������
		HessianOutput out = new HessianOutput(os);
		//������д�뵽�ֽ��������, �������л�
		out.writeObject(new zhansan(18,"����"));
		byte[] zhangsanByte = os.toByteArray();
		
		//�ֽ�����������
		ByteArrayInputStream is = new ByteArrayInputStream(zhangsanByte);
		//ִ�з����л�,�����ж�ȡ����
		HessianInput in = new HessianInput(is);
		
		Person person = (Person) in.readObject();
		System.out.println(person);
	}
}
