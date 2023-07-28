package ex04_Student;

import java.util.HashMap;
import java.util.Map;

public class MainWrapper {

  public static void main(String[] args) {
    
    // 교실의 학생 정보를 저장하는 HashMap 만들기
    // key : 학번(예: 10101)
    // value : Student 객체
    
    Map<Integer, Student> stdClass = new HashMap<Integer, Student>();
    
    
    stdClass.put(10101, new Student("홍길동", new Exam(100, 100, 100)));
    
    Student student = new Student();
    student.setName("김철수");
    student.setExam(new Exam(90,95,85));
    stdClass.put(10102, student);
    
    Integer[] stuNo = {10101, 10102};
    for(int i = 0; i < stuNo.length; i++) {
      Student student2 = stdClass.get(stuNo[i]);
      System.out.println("이름: " + student2.getName());
      System.out.println("시험: " + student2.getExam());
    }
    
  }

}
