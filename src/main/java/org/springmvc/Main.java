package org.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springmvc.controller.EmployeeController;
import org.springmvc.dao.EmployeeDao;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-servlet.xml");
        EmployeeDao dao = ctx.getBean("dao", EmployeeDao.class);
        // dao.save(new org.springmvc.entity.Employee(102, "Amit", 35000, "Java Developer"));
        // dao.update(new org.springmvc.entity.Employee(102, "Amit2", 50000, "Java Developer"));
        // dao.delete(102);
//        System.out.println("Employee Details");
//        for (org.springmvc.entity.Employee e : dao.getEmployees()) {
//            System.out.println(e.getName());
//        }
//        System.out.println(dao.getEmpById(101).getDesignation());

        EmployeeController controller = ctx.getBean("controller", EmployeeController.class);
//        controller.save(new org.springmvc.entity.Employee(103, "Amit3", 350050, "Java Developer"));
        //  controller.editsave(new org.springmvc.entity.Employee(103, "Amit3", 50000, "Java Developer"));

    }
}