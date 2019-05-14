package edu.nus.iss.simpledemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.nus.iss.simpledemo.model.Staff;
import edu.nus.iss.simpledemo.service.StaffService;

public class StaffTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaffService ss = new StaffService();
		Staff s1 = new Staff(1, "Suria","Po");
		Staff s2 = new Staff(2, "Alien", "Master OOgway");
		Staff s3 = new Staff (3, "Dumbo", "Master Shifu");
		Staff s4 = new Staff (4, "Leopard", "Tai Lung");
        ss.createStaff(s1);
        ss.createStaff(s2);
        ss.createStaff(s3);
        ss.createStaff(s4);
        List<Staff> slist = ss.findAllStaff();
        System.out.println("Staff List");
        for (Iterator iterator = slist.iterator(); iterator.hasNext();) {
			Staff staff = (Staff) iterator.next();
			System.out.println(staff);
		}
        System.out.println(ss.updateStaffNickName(1, "Super Duper Fast"));
        
	}

}
