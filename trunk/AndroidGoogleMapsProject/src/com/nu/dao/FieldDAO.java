package com.nu.dao;

import java.util.ArrayList;

import com.nu.activity.Note1Activity;
import com.nu.activity.Note2Activity;
import com.nu.activity.Note3Activity;
import com.nu.activity.Note4Activity;
import com.nu.activity.Note5Activity;
import com.nu.dto.Field;

public class FieldDAO {
	
	 private static final String EDIT_TEXT = "EditText";
	 private static final String DATE = "EditText";
	 private static final String SPINNER = "EditText";
	 private static final String TEXT_AREA = "EditText";
	 
	
	public ArrayList getFieldByAcivityName(String name){
		if(name.equals( Note1Activity.class.getSimpleName())){		
			return getFieldNote1();
		}else if(name.equals(Note2Activity.class.getSimpleName())){	
			return getFieldNote2();		
		}else if(name.equals(Note3Activity.class.getSimpleName())){	
			return getFieldNote3();		
		}else if(name.equals(Note4Activity.class.getSimpleName())){	
			return getFieldNote4();		
		}else if(name.equals(Note5Activity.class.getSimpleName())){	
			return getFieldNote5();		
		}
		return null;		
	}
	
	public ArrayList getFieldNote1(){
		  ArrayList result = new ArrayList();
		  Field f1 = new Field("Note","�Ţ����ǵ��","EditText",1,true,false,0,null);
		  result.add(f1);
		  Field f2 = new Field("Note","�Ţ����ŧ��١","EditText",1,true,false,1,null);
		  result.add(f2);
		  Field f3 = new Field("Note","�ѹ����Ǩ�ͺ","Date",1,false,true,2,null);
		  result.add(f3);
		  Field f4 = new Field("Note","�ѹ����١","Date",1,false,true,3,null);
		  result.add(f4);
		  Field f5 = new Field("Note","����ҳ����������պ*","Date",1,false,true,4,null);
		  result.add(f5);	
		  Field f20 = new Field("Note","����ҳ����������պ","EditText",1,true,false,5,null);
		  result.add(f20);
		  Field f6 = new Field("Note","��������� [�ٵû���]","Spinner",1,true,false,6,null);
		  result.add(f6);
		  Field f7 = new Field("Note","������","Spinner",1,true,false,7,null);
		  result.add(f7);
		  Field f8 = new Field("Note","�ѵ�ҡ��������","EditText",1,true,false,8,null);
		  result.add(f8);
		  Field f9 = new Field("Note","����-ʡ�Ū�����","EditText",1,true,false,9,null);
		  result.add(f9);
		  Field f10 = new Field("Note","��û�١","EditText",1,true,true,10,null);
		  result.add(f10);
		  Field f11 = new Field("Note","������ͧ","EditText",1,true,true,11,null);
		  result.add(f11);
		  Field f12 = new Field("Note","�����Թ�ż�Ե","EditText",1,true,true,12,null);
		  result.add(f12);
		  Field f13 = new Field("Note","��áӨѴ�Ѫ�ת","EditText",1,true,true,13,null);
		  result.add(f13);
		  Field f14 = new Field("Note","��������","EditText",1,true,false,14,null);
		  result.add(f14);
		  Field f15 = new Field("Note","����ҳ�����","EditText",1,true,false,15,null);
		  result.add(f15);
		  Field f16 = new Field("Note","��� Brix","EditText",1,true,false,16,null);
		  result.add(f16);
		  Field f17 = new Field("Note","����������","EditText",1,true,false,17,null);
		  result.add(f17);
		  Field f18 = new Field("Note","�ѹ������","Spinner",1,true,false,18,null);
		  result.add(f18);
		  StringBuilder dataF19 =new StringBuilder();
		  dataF19.append("㺢��|");
		  dataF19.append("������|");
		  dataF19.append("���|");
		  dataF19.append("��ᴧ|");
		  dataF19.append("�����Ѻ��ô|");
		  dataF19.append("����");
		  Field f19 = new Field("Note"," �ä [�к�]","CheckBox",1,true,false,19,dataF19.toString());
		  result.add(f19);
		  StringBuilder dataF21 =new StringBuilder();
		  dataF21.append("˹͹����¨ش���|");
		  dataF21.append("˹͹���բ��|");
		  dataF21.append("˹͹���ժ���|");
		  dataF21.append("��ǹ����|");
		  dataF21.append("��ꡡ��ᵹ|");
		  dataF21.append("��ꡡ�з��");
		  Field f21 = new Field("Note","��ŧ [�к�]","CheckBox",1,true,false,21,dataF21.toString());
		  result.add(f21);
		  StringBuilder dataF22 =new StringBuilder();
		  dataF22.append("back|");
		  dataF22.append("save|");
		  dataF22.append("camera");
		  Field f22 = new Field("Note","Button","Button",1,true,false,22,dataF22.toString());
		  result.add(f22);
		  return result;		
	}
	
	public ArrayList getFieldNote2(){
		  //�Ԩ�������»�١������駷��1
		  ArrayList result = new ArrayList();
		  Field f1 = new Field("Note","�Ţ����ǵ��","EditText",1,true,false,0,null);
		  result.add(f1);
		  Field f2 = new Field("Note","�����Ţ�ŧ","EditText",1,true,false,1,null);
		  result.add(f2);
		  Field f3 = new Field("Note","�ѹ����Ǩ�ͺ","Date",1,false,true,2,null);
		  result.add(f3);
		  Field f4 = new Field("Note","��Դ˹�ҴԹ�Ѻ�ӹǹ��ӽ�[����]","EditText",1,false,false,3,null);
		  result.add(f4);
		  Field f5 = new Field("Note","䶴д��¼ҹ","EditText",1,false,true,4,null);
		  result.add(f5);	
		  Field f6 = new Field("Note","䶾�ǹ�ҹ","EditText",1,true,false,5,null);
		  result.add(f6);
		  Field f7 = new Field("Note","¡��ͧ���¼ҹ","EditText",1,true,false,6,null);
		  result.add(f7);
		  Field f8 = new Field("Note","��������� [�ٵû���]","Spinner",1,true,false,7,null);
		  result.add(f8);
		  Field f9 = new Field("Note","������","Spinner",1,true,false,8,null);
		  result.add(f9);
		  Field f10 = new Field("Note","�ѵ�ҡ��������","EditText",1,true,false,9,null);
		  result.add(f10);		 
		  Field f11 = new Field("Note","�����˵�","TextArea",1,true,false,10,null);
		  result.add(f11);
		  Field f12 = new Field("Note","����-ʡ�Ū�����","EditText",1,true,false,12,null);
		  result.add(f12);
		  Field f13 = new Field("Note","����������","EditText",1,true,false,13,null);
		  result.add(f13);
		  Field f14 = new Field("Note","��Ҿ��鹴Թ","Spinner",1,true,true,14,null);
		  result.add(f14);
		  Field f15 = new Field("Note","�ѹ����١��������","Date",1,true,true,15,null);
		  result.add(f15);
		  Field f16 = new Field("Note","��ѹ������¨ҡ����","Spinner",1,true,false,16,null);
		  result.add(f16);
		  Field f17 = new Field("Note","�ӹǹ[����]","EditText",1,true,false,17,null);
		  result.add(f17);
		  Field f18 = new Field("Note","�ӹǹ[����]","EditText",1,true,false,18,null);
		  result.add(f18);
		  
		  Field f19 = new Field("Note","�٧ [��.]","EditText",1,true,false,18,null);
		  result.add(f19);
		  Field f20 = new Field("Note","��áӨѴ�Ѫ�ת","Spinner",1,true,false,18,null);
		  result.add(f20);
		  Field f21 = new Field("Note","�����������","Spinner",1,true,false,18,null);
		  result.add(f21);
		  Field f22 = new Field("Note","�ѵ���������� [�.�./���]","EditText",1,true,false,18,null);
		  result.add(f22);
		  Field f23 = new Field("Note","�ӹǹ[����]","EditText",1,true,false,18,null);
		  result.add(f23);
		  Field f24 = new Field("Note","�ѹ�������","Spinner",1,true,true,18,null);
		  result.add(f24);
		  Field f25 = new Field("Note","�ѡɳ����ʹԹ","Spinner",1,true,true,18,null);
		  result.add(f25);
		  Field f26 = new Field("Note","�������㹴Թ","Spinner",1,true,false,18,null);
		  result.add(f26);
		  Field f27 = new Field("Note","��������","Spinner",1,true,false,18,null);
		  result.add(f27);
		  Field f28 = new Field("Note","�֡[��.]","EditText",1,true,false,18,null);
		  result.add(f28);
		  Field f29 = new Field("Note","�֡[��.]","EditText",1,true,false,18,null);
		  result.add(f29);
		  Field f30 = new Field("Note","������ͧ[����]","EditText",1,true,true,18,null);
		  result.add(f30);
		  Field f31 = new Field("Note","��û�١","Spinner",1,true,true,18,null);
		  result.add(f31);
		  Field f32 = new Field("Note","�ҧ��͹�ѹ���Ẻ","Spinner",1,true,false,18,null);
		  result.add(f32);
		  Field f33 = new Field("Note","������ҧ[��.]","EditText",1,true,false,18,null);
		  result.add(f33);
		  
		  StringBuilder dataF34 =new StringBuilder();
		  dataF34.append("back|");
		  dataF34.append("save|");
		  dataF34.append("camera");
		  Field f34 = new Field("Note","Button","Button",1,true,false,22,dataF34.toString());
		  result.add(f34);
		 
		  return result;		
	}
	public ArrayList getFieldNote3(){
		  //�Ԩ�������»�١������駷��2
		  ArrayList result = new ArrayList();
	  
//		  �Ţ����ǵ��
		  Field f1 = new Field("Note","�Ţ����ǵ��","EditText",1,true,false,0,null);
		  result.add(f1);
//		  �����Ţ�ŧ
		  Field f2 = new Field("Note","�����Ţ�ŧ","EditText",1,true,false,0,null);
		  result.add(f2);
//		  �ѹ����Ǩ�ͺ*
		  Field f3 = new Field("Note","�ѹ����Ǩ�ͺ","Date",1,true,true,0,null);
		  result.add(f3);
//		  ��������� [�ٵû���] *
		  Field f4 = new Field("Note","��������� [�ٵû���]","Spinner",1,true,true,0,null);
		  result.add(f4);
//		  ������ *
		  Field f5 = new Field("Note","������","Spinner",1,true,true,0,null);
		  result.add(f5);
//		  �ѵ�ҡ�������� [�.�. / ���] *
		  Field f6 = new Field("Note","�ѵ�ҡ�������� [�.�./���]","EditText",1,false,true,0,null);
		  result.add(f6);
//		  �������� *
		  Field f7 = new Field("Note","��������","Spinner",1,true,true,0,null);
		  result.add(f7);
//		  ��ç͡ *
		  Field f8 = new Field("Note","��ç͡","Spinner",1,true,true,0,null);
		  result.add(f8);
//		  ���������  *
		  Field f9 = new Field("Note","���������","Spinner",1,true,true,0,null);
		  result.add(f9);
//		  ��������� [��� / ���]  *
		  Field f10 = new Field("Note","��������� ","EditText",1,true,true,0,null);
		  result.add(f10);
//		  ����-ʡ�Ū���������
		  Field f11 = new Field("Note","����-ʡ�Ū���������","EditText",1,true,false,0,null);
		  result.add(f11);
//		  ����������
		  Field f12 = new Field("Note","����������","EditText",1,true,false,0,null);
		  result.add(f12);
//		  �ѹ�������
		  Field f13 = new Field("Note","�ѹ�������","EditText",1,true,false,0,null);
		  result.add(f13);
		  //�ä [�к�]
		  StringBuilder dataF14 =new StringBuilder();
		  dataF14.append("�ä1|");
		  dataF14.append("�ä2|");
		  dataF14.append("�ä3|");
		  dataF14.append("�ä4|");
		  dataF14.append("�ä5|");
		  dataF14.append("�ä6|");
		  dataF14.append("�ä7");
		  Field f14 = new Field("Note","�ä [�к�]","CheckBox",1,true,false,0,dataF14.toString());
		  result.add(f14);
		  //��ŧ [�к�]
		  StringBuilder dataF15 =new StringBuilder();
		  dataF15.append("��ŧ1|");
		  dataF15.append("��ŧ2|");
		  dataF15.append("��ŧ3|");
		  dataF15.append("��ŧ4|");
		  dataF15.append("��ŧ5|");
		  dataF15.append("��ŧ6|");
		  dataF15.append("��ŧ7");
		  Field f15 = new Field("Note","��ŧ [�к�]","CheckBox",1,true,false,0,dataF15.toString());
		  result.add(f15);
          //��áӨѴ�Ѫ�ת
		  StringBuilder dataF16 =new StringBuilder();
		  dataF16.append("�ѧ���ӨѴ|");
		  dataF16.append("������ͧ�ѡá�|");
		  dataF16.append("���ç�ҹ��|");
		  dataF16.append("��������");
		  Field f16 = new Field("Note","��áӨѴ�Ѫ�ת","CheckBox",1,true,false,0,dataF16.toString());
		  result.add(f16);
//		  �ѧ���ӨѴ
//		  ������ͧ�ѡá�
//		  ���ç�ҹ��
//		  ��������
	//	  �ó���������㹡�áӨѴ�Ѫ�ת[�к�]
		  Field f17 = new Field("Note","�ó����������\n��áӨѴ�Ѫ�ת","Spinner",1,true,false,0,null);
		  result.add(f17);
		  // 

		  StringBuilder dataF34 =new StringBuilder();
		  dataF34.append("back|");
		  dataF34.append("save|");
		  dataF34.append("camera");
		  Field f34 = new Field("Note","Button","Button",1,true,false,22,dataF34.toString());
		  result.add(f34);
		  return result;
	}
	
	public ArrayList getFieldNote4(){
	    //	�Ԩ�������µͤ��駷��1
		  ArrayList result = new ArrayList();

		  
		  
//		  �Ţ����ǵ��
		  Field f1 = new Field("Note","�Ţ����ǵ��","EditText",1,true,false,0,null);
		  result.add(f1);
//		  �����Ţ�ŧ
		  Field f2 = new Field("Note","�����Ţ�ŧ","EditText",1,true,false,0,null);
		  result.add(f2);
//		  �ѹ����Ǩ�ͺ*
		  Field f3 = new Field("Note","�ѹ����Ǩ�ͺ","Date",1,true,true,0,null);
		  result.add(f3);
//		  ��������� [�ٵû���] *
		  Field f4 = new Field("Note","��������� [�ٵû���]","Spinner",1,true,true,0,null);
		  result.add(f4);
//		  ������ *
		  Field f5 = new Field("Note","������","Spinner",1,true,true,0,null);
		  result.add(f5);
//		  �ѵ�ҡ�������� [�.�. / ���] *
		  Field f6 = new Field("Note","�ѵ�ҡ�������� [�.�./���]","EditText",1,true,true,0,null);
		  result.add(f6);
//		  ����-ʡ�Ū�����
		  Field f7 = new Field("Note","����-ʡ�Ū�����","EditText",1,true,false,0,null);
		  result.add(f7);
//		  ����������
		  Field f8 = new Field("Note","����������","EditText",1,true,false,0,null);
		  result.add(f8);
//		  �����¹��  *
		  Field f9 = new Field("Note","�����¹��","Spinner",1,true,true,0,null);
		  result.add(f9);
//		  ��þ�ǹ�Թ  *
		  Field f10 = new Field("Note","��þ�ǹ�Թ","Spinner",1,true,true,0,null);
		  result.add(f10);
//		  ��áӨѴ�Ѫ�ת  *
		  Field f11 = new Field("Note","��áӨѴ�Ѫ�ת","Spinner",1,true,true,0,null);
		  result.add(f11);
//		  �ѹ�������
		  Field f12 = new Field("Note","�ѹ�������","EditText",1,true,false,0,null);
		  result.add(f12);
//		  ��������  *
		  Field f13 = new Field("Note","��������","Spinner",1,true,true,0,null);
		  result.add(f13);
//		  ����������  *
		  Field f14 = new Field("Note","����������","Spinner",1,true,true,0,null);
		  result.add(f14);
//		  ��������� [��� / ���]  *
		  Field f15 = new Field("Note","��������� [��� /���]","EditText",1,true,true,0,null);
		  result.add(f15);
//		 �����˵�  *
		  Field f1� = new Field("Note","�����˵�","TextArea",1,true,true,0,null);
		  result.add(f1�);
		  StringBuilder dataF34 =new StringBuilder();
		  dataF34.append("back|");
		  dataF34.append("save|");
		  dataF34.append("camera");
		  Field f34 = new Field("Note","Button","Button",1,true,false,22,dataF34.toString());
		  result.add(f34);

		  return result;
	}

	public ArrayList getFieldNote5(){
		//�Ԩ�������µͤ��駷��2
		  ArrayList result = new ArrayList();
		  
//		  �Ţ����ǵ��
		  Field f1 = new Field("Note","�Ţ����ǵ��","EditText",1,true,false,0,null);
		  result.add(f1);
//		  �����Ţ�ŧ
		  Field f2 = new Field("Note","�����Ţ�ŧ","EditText",1,true,false,0,null);
		  result.add(f2);
//		  �ѹ����Ǩ�ͺ*
		  Field f3 = new Field("Note","�ѹ����Ǩ�ͺ","Date",1,true,true,0,null);
		  result.add(f3);
//		  ��������� [�ٵû���] *
		  Field f4 = new Field("Note","��������� [�ٵû���]","Spinner",1,true,true,0,null);
		  result.add(f4);
//		  ������ *
		  Field f5 = new Field("Note","������","Spinner",1,true,true,0,null);
		  result.add(f5);
//		  �ѵ�ҡ�������� [�.�. / ���] *
		  Field f6 = new Field("Note","�ѵ�ҡ�������� [�.�./���]","EditText",1,false,true,0,null);
		  result.add(f6);
//		  �������� *
		  Field f7 = new Field("Note","��������","Spinner",1,true,true,0,null);
		  result.add(f7);
//		  ��ç͡ *
		  Field f8 = new Field("Note","��ç͡","Spinner",1,true,true,0,null);
		  result.add(f8);
//		  ���������  *
		  Field f9 = new Field("Note","���������","Spinner",1,true,true,0,null);
		  result.add(f9);
//		  ��������� [��� / ���]  *
		  Field f10 = new Field("Note","��������� [��� / ���] ","EditText",1,true,true,0,null);
		  result.add(f10);
//		  ����-ʡ�Ū���������
		  Field f11 = new Field("Note","����-ʡ�Ū���������","EditText",1,true,false,0,null);
		  result.add(f11);
//		  ����������
		  Field f12 = new Field("Note","����������","EditText",1,true,false,0,null);
		  result.add(f12);
//		  �ѹ�������
		  Field f13 = new Field("Note","�ѹ�������","EditText",1,true,false,0,null);
		  result.add(f13);
		  //�ä [�к�]
		  StringBuilder dataF14 =new StringBuilder();
		  dataF14.append("�ä1|");
		  dataF14.append("�ä2|");
		  dataF14.append("�ä3|");
		  dataF14.append("�ä4|");
		  dataF14.append("�ä5|");
		  dataF14.append("�ä6|");
		  dataF14.append("�ä7");
		  Field f14 = new Field("Note","�ä [�к�]","CheckBox",1,true,false,0,dataF14.toString());
		  result.add(f14);
		  //��ŧ [�к�]
		  StringBuilder dataF15 =new StringBuilder();
		  dataF15.append("��ŧ1|");
		  dataF15.append("��ŧ2|");
		  dataF15.append("��ŧ3|");
		  dataF15.append("��ŧ4|");
		  dataF15.append("��ŧ5|");
		  dataF15.append("��ŧ6|");
		  dataF15.append("��ŧ7");
		  Field f15 = new Field("Note","��ŧ [�к�]","CheckBox",1,true,false,0,dataF15.toString());
		  result.add(f15);
          //��áӨѴ�Ѫ�ת
		  StringBuilder dataF16 =new StringBuilder();
		  dataF16.append("�ѧ���ӨѴ|");
		  dataF16.append("������ͧ�ѡá�|");
		  dataF16.append("���ç�ҹ��|");
		  dataF16.append("��������");
		  Field f16 = new Field("Note","��áӨѴ�Ѫ�ת","CheckBox",1,true,false,0,dataF16.toString());
		  result.add(f16);
//		  �ѧ���ӨѴ
//		  ������ͧ�ѡá�
//		  ���ç�ҹ��
//		  ��������
	//	  �ó���������㹡�áӨѴ�Ѫ�ת[�к�]
		  Field f17 = new Field("Note","�ó���������㹡�áӨѴ�Ѫ�ת[�к�]","Spinner",1,true,false,0,null);
		  result.add(f17);
		  // 

		  StringBuilder dataF34 =new StringBuilder();
		  dataF34.append("back|");
		  dataF34.append("save|");
		  dataF34.append("camera");
		  Field f34 = new Field("Note","Button","Button",1,true,false,22,dataF34.toString());
		  result.add(f34);
		  return result;

	}
	
	public ArrayList getFieldNote6(){
		//����Ѵ�����ԭ�Ժ�����
		  ArrayList result = new ArrayList();
		  Field f1 = new Field("Note","�Ţ����ǵ��","EditText",1,true,false,0,null);
		  result.add(f1);
		  
//		  �Ţ����ǵ��
//		  �����Ţ�ŧ
//		  �ѹ����Ǩ�ͺ*
//		  ������ͧ[����] *                                             
//		  �����˵�
//		  ����-ʡ�Ū�����
//		  ����������
//		  �ѹ�������


		  
		  return result;
		  
	}
	
	public ArrayList getFieldNote7(){
		//��û����Թ�ż�Ե���¤��駷��1
		  ArrayList result = new ArrayList();
		  Field f1 = new Field("Note","�Ţ����ǵ��","EditText",1,true,false,0,null);
		  result.add(f1);
		  return result;
	}
}
