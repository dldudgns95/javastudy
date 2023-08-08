package ex05_Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {

	private List<Employee> employees = new ArrayList<Employee>();
	private Scanner sc = new Scanner(System.in);
	
	public Company() {

	}
	
	public void addEmployee() {
		System.out.println("===== 고용 =====");
		System.out.print("고용 형태 선택(1.정규 2.프리랜서) >>> ");
		int result = sc.nextInt();
		if(!(result == 1 || result == 2)) {
		  throw new RuntimeException("잘못 입력하셨습니다.");
		}
		System.out.print("사원번호 입력 >>> ");
		String empNo = sc.next();
		System.out.print("사원명 입력 >>> ");
		String name = sc.next();
		if(result == 1) {
		  Regular regular = new Regular(empNo, name);
		  System.out.print("기본급 입력 >>> ");
		  regular.setSalary(sc.nextInt());
		  employees.add(regular);
		} else if(result == 2) {
		  Freelance freelance = new Freelance(empNo, name);
		  System.out.print("시간당 임금 입력 >>> ");
		  freelance.setHourlyWage(sc.nextInt());
		  System.out.print("근무한 시간 입력 >>> ");
		  freelance.setWorkingHours(sc.nextInt());
		  employees.add(freelance);
		}
		System.out.println("사원 등록이 완료되었습니다. 현재 등록된 사원은 " + employees.size() + "명입니다.");
	}
	
	public void dropEmployee() {
		System.out.println("===== 해고 =====");
		if(employees.isEmpty()) {
		  throw new RuntimeException("등록된 사원이 없습니다. 해고가 불가능합니다.");
		}
		System.out.print("삭제할 사원번호 입력 >>> ");
		String empNo = sc.next();
		for(Employee employee : employees) {
		  if(empNo.equals(employee.getEmpNo())) {
		    System.out.println("다음 사원이 삭제되었습니다.");
		    employee.info();
		    employees.remove(employee);
		    return;
		  }
		}
		System.out.println("사원 번호를 찾지 못했습니다.");
		
	}
	
	public void findEmployee() {
		System.out.println("===== 조회 =====");
		if(employees.isEmpty()) {
      throw new RuntimeException("등록된 사원이 없습니다. 해고가 불가능합니다.");
    }
    System.out.print("조회할 사원번호 입력 >>> ");
    String empNo = sc.next();
    for(Employee employee : employees) {
      if(empNo.equals(employee.getEmpNo())) {
        System.out.println("사원 조회 성공!");
        employee.info();
        return;
      }
    }
    System.out.println("사원 번호를 찾지 못했습니다.");
	}
	
	public void printAllEmployee() {
		System.out.println("===== 전체조회 =====");
		if(employees.isEmpty()) {
      throw new RuntimeException("등록된 사원이 없습니다. 해고가 불가능합니다.");
    }
		System.out.println("전체사원(" + employees.size() + "명)");
		System.out.println("------------------");
		for(Employee employee : employees) {
		  employee.info();
		  System.out.println("------------------");
		}
	}
	
	public void manage() {
		System.out.println("===== 사원관리프로그램 시작 =====");
		while(true) {
			try {
				System.out.print("\n1.고용 2.해고 3.조회 4.전체조회 0.종료 >>> ");
				String choice = sc.next();
				switch(choice) {
				case "1": addEmployee(); break;
				case "2": dropEmployee(); break;
				case "3": findEmployee(); break;
				case "4": printAllEmployee(); break;
				case "0": System.out.println("===== 사원관리프로그램 종료 ====="); return;
				default: throw new RuntimeException("잘못된 요청입니다. 다시 시도하세요.");
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
