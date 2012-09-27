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
		  Field f1 = new Field("Note","เลขที่โควต้า","EditText",1,true,false,0,null);
		  result.add(f1);
		  Field f2 = new Field("Note","เลขที่แปลงปลูก","EditText",1,true,false,1,null);
		  result.add(f2);
		  Field f3 = new Field("Note","วันที่ตรวจสอบ","Date",1,false,true,2,null);
		  result.add(f3);
		  Field f4 = new Field("Note","วันที่ปลูก","Date",1,false,true,3,null);
		  result.add(f4);
		  Field f5 = new Field("Note","ประมาณส่งอ้อยเข้าหีบ*","Date",1,false,true,4,null);
		  result.add(f5);	
		  Field f20 = new Field("Note","ประมาณส่งอ้อยเข้าหีบ","EditText",1,true,false,5,null);
		  result.add(f20);
		  Field f6 = new Field("Note","การใส่ปุ๋ย [สูตรปุ๋ย]","Spinner",1,true,false,6,null);
		  result.add(f6);
		  Field f7 = new Field("Note","ยี่ห้อ","Spinner",1,true,false,7,null);
		  result.add(f7);
		  Field f8 = new Field("Note","อัตราการใส่ปุ๋ย","EditText",1,true,false,8,null);
		  result.add(f8);
		  Field f9 = new Field("Note","ชื่อ-สกุลชาวไร่","EditText",1,true,false,9,null);
		  result.add(f9);
		  Field f10 = new Field("Note","การปลูก","EditText",1,true,true,10,null);
		  result.add(f10);
		  Field f11 = new Field("Note","ระยะร่อง","EditText",1,true,true,11,null);
		  result.add(f11);
		  Field f12 = new Field("Note","ประเมินผลผลิต","EditText",1,true,true,12,null);
		  result.add(f12);
		  Field f13 = new Field("Note","การกำจัดวัชพืช","EditText",1,true,true,13,null);
		  result.add(f13);
		  Field f14 = new Field("Note","การให้น้ำ","EditText",1,true,false,14,null);
		  result.add(f14);
		  Field f15 = new Field("Note","ปริมาณให้น้ำ","EditText",1,true,false,15,null);
		  result.add(f15);
		  Field f16 = new Field("Note","ค่า Brix","EditText",1,true,false,16,null);
		  result.add(f16);
		  Field f17 = new Field("Note","ประเภทอ้อย","EditText",1,true,false,17,null);
		  result.add(f17);
		  Field f18 = new Field("Note","พันธ์อ้อย","Spinner",1,true,false,18,null);
		  result.add(f18);
		  StringBuilder dataF19 =new StringBuilder();
		  dataF19.append("ใบขาว|");
		  dataF19.append("เหี่ยว|");
		  dataF19.append("แห้ง|");
		  dataF19.append("เนาแดง|");
		  dataF19.append("กลิ่นสับปะรด|");
		  dataF19.append("แส้ดำ");
		  Field f19 = new Field("Note"," โรค [ระบุ]","CheckBox",1,true,false,19,dataF19.toString());
		  result.add(f19);
		  StringBuilder dataF21 =new StringBuilder();
		  dataF21.append("หนอนกอลายจุดเล็ก|");
		  dataF21.append("หนอนกอสีขาว|");
		  dataF21.append("หนอนกอสีชมพู|");
		  dataF21.append("ม้วนอ้อย|");
		  dataF21.append("ตั๊กกระแตน|");
		  dataF21.append("ตั๊กกระทาย");
		  Field f21 = new Field("Note","แมลง [ระบุ]","CheckBox",1,true,false,21,dataF21.toString());
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
		  //กิจกรรมอ้อยปลูกใหม่ครั้งที่1
		  ArrayList result = new ArrayList();
		  Field f1 = new Field("Note","เลขที่โควต้า","EditText",1,true,false,0,null);
		  result.add(f1);
		  Field f2 = new Field("Note","หมายเลขแปลง","EditText",1,true,false,1,null);
		  result.add(f2);
		  Field f3 = new Field("Note","วันที่ตรวจสอบ","Date",1,false,true,2,null);
		  result.add(f3);
		  Field f4 = new Field("Note","ไถเปิดหน้าดินรับจำนวนน้ำฝน[ครั้ง]","EditText",1,false,false,3,null);
		  result.add(f4);
		  Field f5 = new Field("Note","ไถดะด้วยผาน","EditText",1,false,true,4,null);
		  result.add(f5);	
		  Field f6 = new Field("Note","ไถพรวนผาน","EditText",1,true,false,5,null);
		  result.add(f6);
		  Field f7 = new Field("Note","ยกร่องด้วยผาน","EditText",1,true,false,6,null);
		  result.add(f7);
		  Field f8 = new Field("Note","การใส่ปุ๋ย [สูตรปุ๋ย]","Spinner",1,true,false,7,null);
		  result.add(f8);
		  Field f9 = new Field("Note","ยี่ห้อ","Spinner",1,true,false,8,null);
		  result.add(f9);
		  Field f10 = new Field("Note","อัตราการใส่ปุ๋ย","EditText",1,true,false,9,null);
		  result.add(f10);		 
		  Field f11 = new Field("Note","หมายเหตุ","TextArea",1,true,false,10,null);
		  result.add(f11);
		  Field f12 = new Field("Note","ชื่อ-สกุลชาวไร่","EditText",1,true,false,12,null);
		  result.add(f12);
		  Field f13 = new Field("Note","ประเภทอ้อย","EditText",1,true,false,13,null);
		  result.add(f13);
		  Field f14 = new Field("Note","สภาพพื้นดิน","Spinner",1,true,true,14,null);
		  result.add(f14);
		  Field f15 = new Field("Note","วันที่ปลูกอ้อยเสร็จ","Date",1,true,true,15,null);
		  result.add(f15);
		  Field f16 = new Field("Note","ใช้พันธุ์อ้อยจากอ้อย","Spinner",1,true,false,16,null);
		  result.add(f16);
		  Field f17 = new Field("Note","จำนวน[ครั้ง]","EditText",1,true,false,17,null);
		  result.add(f17);
		  Field f18 = new Field("Note","จำนวน[ครั้ง]","EditText",1,true,false,18,null);
		  result.add(f18);
		  
		  Field f19 = new Field("Note","สูง [ซม.]","EditText",1,true,false,18,null);
		  result.add(f19);
		  Field f20 = new Field("Note","การกำจัดวัชพืช","Spinner",1,true,false,18,null);
		  result.add(f20);
		  Field f21 = new Field("Note","การใช้สารเคมี","Spinner",1,true,false,18,null);
		  result.add(f21);
		  Field f22 = new Field("Note","อัตราใช้สารเคมี [ก.ก./ไร่]","EditText",1,true,false,18,null);
		  result.add(f22);
		  Field f23 = new Field("Note","จำนวน[ครั้ง]","EditText",1,true,false,18,null);
		  result.add(f23);
		  Field f24 = new Field("Note","พันธุ์อ้อย","Spinner",1,true,true,18,null);
		  result.add(f24);
		  Field f25 = new Field("Note","ลักษณะเนื้อดิน","Spinner",1,true,true,18,null);
		  result.add(f25);
		  Field f26 = new Field("Note","ความชื้นในดิน","Spinner",1,true,false,18,null);
		  result.add(f26);
		  Field f27 = new Field("Note","การให้น้ำ","Spinner",1,true,false,18,null);
		  result.add(f27);
		  Field f28 = new Field("Note","ลึก[ซม.]","EditText",1,true,false,18,null);
		  result.add(f28);
		  Field f29 = new Field("Note","ลึก[ซม.]","EditText",1,true,false,18,null);
		  result.add(f29);
		  Field f30 = new Field("Note","ระยะร่อง[เมตร]","EditText",1,true,true,18,null);
		  result.add(f30);
		  Field f31 = new Field("Note","การปลูก","Spinner",1,true,true,18,null);
		  result.add(f31);
		  Field f32 = new Field("Note","วางท่อนพันธุ์แบบ","Spinner",1,true,false,18,null);
		  result.add(f32);
		  Field f33 = new Field("Note","ระยะห่าง[ซม.]","EditText",1,true,false,18,null);
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
		  //กิจกรรมอ้อยปลูกใหม่ครั้งที่2
		  ArrayList result = new ArrayList();
	  
//		  เลขที่โควต้า
		  Field f1 = new Field("Note","เลขที่โควต้า","EditText",1,true,false,0,null);
		  result.add(f1);
//		  หมายเลขแปลง
		  Field f2 = new Field("Note","หมายเลขแปลง","EditText",1,true,false,0,null);
		  result.add(f2);
//		  วันที่ตรวจสอบ*
		  Field f3 = new Field("Note","วันที่ตรวจสอบ","Date",1,true,true,0,null);
		  result.add(f3);
//		  การใส่ปุ๋ย [สูตรปุ๋ย] *
		  Field f4 = new Field("Note","การใส่ปุ๋ย [สูตรปุ๋ย]","Spinner",1,true,true,0,null);
		  result.add(f4);
//		  ยี่ห้อ *
		  Field f5 = new Field("Note","ยี่ห้อ","Spinner",1,true,true,0,null);
		  result.add(f5);
//		  อัตราการใส่ปุ๋ย [ก.ก. / ไร่] *
		  Field f6 = new Field("Note","อัตราการใส่ปุ๋ย [ก.ก./ไร่]","EditText",1,false,true,0,null);
		  result.add(f6);
//		  การให้น้ำ *
		  Field f7 = new Field("Note","การให้น้ำ","Spinner",1,true,true,0,null);
		  result.add(f7);
//		  การงอก *
		  Field f8 = new Field("Note","การงอก","Spinner",1,true,true,0,null);
		  result.add(f8);
//		  การใช้วีแนส  *
		  Field f9 = new Field("Note","การใช้วีแนส","Spinner",1,true,true,0,null);
		  result.add(f9);
//		  การใช้วีแนส [คิว / ไร่]  *
		  Field f10 = new Field("Note","การใช้วีแนส ","EditText",1,true,true,0,null);
		  result.add(f10);
//		  ชื่อ-สกุลชาวไร่อ้อย
		  Field f11 = new Field("Note","ชื่อ-สกุลชาวไร่อ้อย","EditText",1,true,false,0,null);
		  result.add(f11);
//		  ประเภทอ้อย
		  Field f12 = new Field("Note","ประเภทอ้อย","EditText",1,true,false,0,null);
		  result.add(f12);
//		  พันธุ์อ้อย
		  Field f13 = new Field("Note","พันธุ์อ้อย","EditText",1,true,false,0,null);
		  result.add(f13);
		  //โรค [ระบุ]
		  StringBuilder dataF14 =new StringBuilder();
		  dataF14.append("โรค1|");
		  dataF14.append("โรค2|");
		  dataF14.append("โรค3|");
		  dataF14.append("โรค4|");
		  dataF14.append("โรค5|");
		  dataF14.append("โรค6|");
		  dataF14.append("โรค7");
		  Field f14 = new Field("Note","โรค [ระบุ]","CheckBox",1,true,false,0,dataF14.toString());
		  result.add(f14);
		  //แมลง [ระบุ]
		  StringBuilder dataF15 =new StringBuilder();
		  dataF15.append("แมลง1|");
		  dataF15.append("แมลง2|");
		  dataF15.append("แมลง3|");
		  dataF15.append("แมลง4|");
		  dataF15.append("แมลง5|");
		  dataF15.append("แมลง6|");
		  dataF15.append("แมลง7");
		  Field f15 = new Field("Note","แมลง [ระบุ]","CheckBox",1,true,false,0,dataF15.toString());
		  result.add(f15);
          //การกำจัดวัชพืช
		  StringBuilder dataF16 =new StringBuilder();
		  dataF16.append("ยังไม่กำจัด|");
		  dataF16.append("ใช้เครื่องจักรกล|");
		  dataF16.append("ใช้แรงงานคน|");
		  dataF16.append("ใช้สารเคมี");
		  Field f16 = new Field("Note","การกำจัดวัชพืช","CheckBox",1,true,false,0,dataF16.toString());
		  result.add(f16);
//		  ยังไม่กำจัด
//		  ใช้เครื่องจักรกล
//		  ใช้แรงงานคน
//		  ใช้สารเคมี
	//	  กรณีใช้สารเคมีในการกำจัดวัชพืช[ระบุ]
		  Field f17 = new Field("Note","กรณีใช้สารเคมีใน\nการกำจัดวัชพืช","Spinner",1,true,false,0,null);
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
	    //	กิจกรรมอ้อยตอครั้งที่1
		  ArrayList result = new ArrayList();

		  
		  
//		  เลขที่โควต้า
		  Field f1 = new Field("Note","เลขที่โควต้า","EditText",1,true,false,0,null);
		  result.add(f1);
//		  หมายเลขแปลง
		  Field f2 = new Field("Note","หมายเลขแปลง","EditText",1,true,false,0,null);
		  result.add(f2);
//		  วันที่ตรวจสอบ*
		  Field f3 = new Field("Note","วันที่ตรวจสอบ","Date",1,true,true,0,null);
		  result.add(f3);
//		  การใส่ปุ๋ย [สูตรปุ๋ย] *
		  Field f4 = new Field("Note","การใส่ปุ๋ย [สูตรปุ๋ย]","Spinner",1,true,true,0,null);
		  result.add(f4);
//		  ยี่ห้อ *
		  Field f5 = new Field("Note","ยี่ห้อ","Spinner",1,true,true,0,null);
		  result.add(f5);
//		  อัตราการใส่ปุ๋ย [ก.ก. / ไร่] *
		  Field f6 = new Field("Note","อัตราการใส่ปุ๋ย [ก.ก./ไร่]","EditText",1,true,true,0,null);
		  result.add(f6);
//		  ชื่อ-สกุลชาวไร่
		  Field f7 = new Field("Note","ชื่อ-สกุลชาวไร่","EditText",1,true,false,0,null);
		  result.add(f7);
//		  ประเภทอ้อย
		  Field f8 = new Field("Note","ประเภทอ้อย","EditText",1,true,false,0,null);
		  result.add(f8);
//		  การเจียนตอ  *
		  Field f9 = new Field("Note","การเจียนตอ","Spinner",1,true,true,0,null);
		  result.add(f9);
//		  การพรวนดิน  *
		  Field f10 = new Field("Note","การพรวนดิน","Spinner",1,true,true,0,null);
		  result.add(f10);
//		  การกำจัดวัชพืช  *
		  Field f11 = new Field("Note","การกำจัดวัชพืช","Spinner",1,true,true,0,null);
		  result.add(f11);
//		  พันธุ์อ้อย
		  Field f12 = new Field("Note","พันธุ์อ้อย","EditText",1,true,false,0,null);
		  result.add(f12);
//		  การให้น้ำ  *
		  Field f13 = new Field("Note","การให้น้ำ","Spinner",1,true,true,0,null);
		  result.add(f13);
//		  การให้วีแนส  *
		  Field f14 = new Field("Note","การให้วีแนส","Spinner",1,true,true,0,null);
		  result.add(f14);
//		  การใช้วีแนส [คิว / ไร่]  *
		  Field f15 = new Field("Note","การใช้วีแนส [คิว /ไร่]","EditText",1,true,true,0,null);
		  result.add(f15);
//		 หมายเหตุ  *
		  Field f1ุ = new Field("Note","หมายเหตุ","TextArea",1,true,true,0,null);
		  result.add(f1ุ);
		  StringBuilder dataF34 =new StringBuilder();
		  dataF34.append("back|");
		  dataF34.append("save|");
		  dataF34.append("camera");
		  Field f34 = new Field("Note","Button","Button",1,true,false,22,dataF34.toString());
		  result.add(f34);

		  return result;
	}

	public ArrayList getFieldNote5(){
		//กิจกรรมอ้อยตอครั้งที่2
		  ArrayList result = new ArrayList();
		  
//		  เลขที่โควต้า
		  Field f1 = new Field("Note","เลขที่โควต้า","EditText",1,true,false,0,null);
		  result.add(f1);
//		  หมายเลขแปลง
		  Field f2 = new Field("Note","หมายเลขแปลง","EditText",1,true,false,0,null);
		  result.add(f2);
//		  วันที่ตรวจสอบ*
		  Field f3 = new Field("Note","วันที่ตรวจสอบ","Date",1,true,true,0,null);
		  result.add(f3);
//		  การใส่ปุ๋ย [สูตรปุ๋ย] *
		  Field f4 = new Field("Note","การใส่ปุ๋ย [สูตรปุ๋ย]","Spinner",1,true,true,0,null);
		  result.add(f4);
//		  ยี่ห้อ *
		  Field f5 = new Field("Note","ยี่ห้อ","Spinner",1,true,true,0,null);
		  result.add(f5);
//		  อัตราการใส่ปุ๋ย [ก.ก. / ไร่] *
		  Field f6 = new Field("Note","อัตราการใส่ปุ๋ย [ก.ก./ไร่]","EditText",1,false,true,0,null);
		  result.add(f6);
//		  การให้น้ำ *
		  Field f7 = new Field("Note","การให้น้ำ","Spinner",1,true,true,0,null);
		  result.add(f7);
//		  การงอก *
		  Field f8 = new Field("Note","การงอก","Spinner",1,true,true,0,null);
		  result.add(f8);
//		  การใช้วีแนส  *
		  Field f9 = new Field("Note","การใช้วีแนส","Spinner",1,true,true,0,null);
		  result.add(f9);
//		  การใช้วีแนส [คิว / ไร่]  *
		  Field f10 = new Field("Note","การใช้วีแนส [คิว / ไร่] ","EditText",1,true,true,0,null);
		  result.add(f10);
//		  ชื่อ-สกุลชาวไร่อ้อย
		  Field f11 = new Field("Note","ชื่อ-สกุลชาวไร่อ้อย","EditText",1,true,false,0,null);
		  result.add(f11);
//		  ประเภทอ้อย
		  Field f12 = new Field("Note","ประเภทอ้อย","EditText",1,true,false,0,null);
		  result.add(f12);
//		  พันธุ์อ้อย
		  Field f13 = new Field("Note","พันธุ์อ้อย","EditText",1,true,false,0,null);
		  result.add(f13);
		  //โรค [ระบุ]
		  StringBuilder dataF14 =new StringBuilder();
		  dataF14.append("โรค1|");
		  dataF14.append("โรค2|");
		  dataF14.append("โรค3|");
		  dataF14.append("โรค4|");
		  dataF14.append("โรค5|");
		  dataF14.append("โรค6|");
		  dataF14.append("โรค7");
		  Field f14 = new Field("Note","โรค [ระบุ]","CheckBox",1,true,false,0,dataF14.toString());
		  result.add(f14);
		  //แมลง [ระบุ]
		  StringBuilder dataF15 =new StringBuilder();
		  dataF15.append("แมลง1|");
		  dataF15.append("แมลง2|");
		  dataF15.append("แมลง3|");
		  dataF15.append("แมลง4|");
		  dataF15.append("แมลง5|");
		  dataF15.append("แมลง6|");
		  dataF15.append("แมลง7");
		  Field f15 = new Field("Note","แมลง [ระบุ]","CheckBox",1,true,false,0,dataF15.toString());
		  result.add(f15);
          //การกำจัดวัชพืช
		  StringBuilder dataF16 =new StringBuilder();
		  dataF16.append("ยังไม่กำจัด|");
		  dataF16.append("ใช้เครื่องจักรกล|");
		  dataF16.append("ใช้แรงงานคน|");
		  dataF16.append("ใช้สารเคมี");
		  Field f16 = new Field("Note","การกำจัดวัชพืช","CheckBox",1,true,false,0,dataF16.toString());
		  result.add(f16);
//		  ยังไม่กำจัด
//		  ใช้เครื่องจักรกล
//		  ใช้แรงงานคน
//		  ใช้สารเคมี
	//	  กรณีใช้สารเคมีในการกำจัดวัชพืช[ระบุ]
		  Field f17 = new Field("Note","กรณีใช้สารเคมีในการกำจัดวัชพืช[ระบุ]","Spinner",1,true,false,0,null);
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
		//การวัดการเจริญเติบโตอ้อย
		  ArrayList result = new ArrayList();
		  Field f1 = new Field("Note","เลขที่โควต้า","EditText",1,true,false,0,null);
		  result.add(f1);
		  
//		  เลขที่โควต้า
//		  หมายเลขแปลง
//		  วันที่ตรวจสอบ*
//		  ระยะร่อง[เมตร] *                                             
//		  หมายเหตุ
//		  ชื่อ-สกุลชาวไร่
//		  ประเภทอ้อย
//		  พันธุ์อ้อย


		  
		  return result;
		  
	}
	
	public ArrayList getFieldNote7(){
		//การประเมินผลผลิตอ้อยครั้งที่1
		  ArrayList result = new ArrayList();
		  Field f1 = new Field("Note","เลขที่โควต้า","EditText",1,true,false,0,null);
		  result.add(f1);
		  return result;
	}
}
