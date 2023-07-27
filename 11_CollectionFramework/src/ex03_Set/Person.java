package ex03_Set;

import java.util.Objects;

public class Person {
  
  private String name;
  private int age;
  
  public Person() {
    // TODO Auto-generated constructor stub
  }
  
  public Person(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
  
  
  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";
  }

  // HashSet은 내부적으로 hashcode()와 equals()를 실행해보기 때문에 참조값이 아닌 객체들의 값을 비교하기 위해서는 Override로 재정의해줘야 한다.
  @Override
  public int hashCode() {
    return Objects.hash(age, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    return age == other.age && Objects.equals(name, other.name);
  }
  
  
}
