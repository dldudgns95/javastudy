package ex01_Stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MainWrapper {
  
  /*
   * forEach() 메소드
   * 1. Stream 파이프라인의 마지막에 사용할 수 있는 메소드 중 하나이다.
   * 2. Stream 파이프라인의 각 요소를 순회할 때 사용한다.
   * 3. for문처럼 동작한다.
   * 4. 형식
   *    void forEach(Consumer<T> consumer);
   */
  
  /* 스트림 생성 & forEach() */
  // Stream 생성 (Anonymous inner type)
  public static void ex01() {
    
    // Stream 생성
    Stream<String> stream = Stream.of("봄", "여름", "가을", "겨울");
    
    //Consumer 생성  (Anonymous inner type)
    Consumer<String> consumer = new Consumer<String>() {
      @Override
      public void accept(String t) {
        System.out.println(t);
      }
    };
    
    // forEach() 메소드 호출
    stream.forEach(consumer);
    
  }
  // Stream 생성 (람다 표현식)
  public static void ex02() {
    
    // Stream 생성
    Stream<String> stream = Stream.of("봄", "여름", "가을", "겨울");
    Consumer<String> consumer = (t) -> System.out.println(t);
    stream.forEach(consumer);
  }
  // Stream 생성 (람다 표현식)
  public static void ex03() {
    
    // Stream 생성
    Stream<String> stream = Stream.of("봄", "여름", "가을", "겨울");
    stream.forEach((t) -> System.out.println(t));
    
  }
  
  /* 각종 스트림 생성 방법 */
  // primitive type 전용 Stream
  public static void ex04() {
    
    // 1. Integer 전용 Stream
    // IntStream iStream = IntStream.of(1, 2, 3, 4, 5); // 1, 2, 3, 4, 5
    // IntStream iStream = IntStream.range(1, 6);       // 1이상 6미만 (1, 2, 3, 4, 5)
    // IntStream iStream = IntStream.rangeClosed(1, 5); // 1이상 5이하 (1, 2, 3, 4, 5)
    
    IntStream iStream = IntStream.of(1, 2, 3, 4, 5); // 1, 2, 3, 4, 5
    iStream.forEach((number) -> System.out.println(number));
    
    // 2. Long 전용 Stream (range, rangeClosed 사용 가능)
    LongStream lStream = LongStream.of(1, 2, 3, 4, 5);
    lStream.forEach((number) -> System.out.println(number));
    
    // 3. Double 전용 Stream (range, rangeClosed 사용 불가능)
    DoubleStream dStream = DoubleStream.of(1.1, 2.2);
    dStream.forEach((number) -> System.out.println(number));
  }
  // 배열 -> Stream
  public static void ex05() {
    
    // 배열 -> Stream
    
    // 1. 일반 Stream
    String[] season = {"봄", "여름", "가을", "겨울"};
    Stream<String> stream = Arrays.stream(season);
    stream.forEach((t) -> System.out.println(t));
    
    // 2. IntStream
    int[] iNumber = {1, 2, 3, 4, 5};
    IntStream iStream = Arrays.stream(iNumber);
    iStream.forEach((number) -> System.out.println(number));
    
    // 3. DoubleStream
    double[] dNumber = {1.1, 2.2};
    DoubleStream dStream = Arrays.stream(dNumber);
    dStream.forEach((number) -> System.out.println(number));
    //Arrays.stream(dNumber).forEach(System.out::println);
    
  }
  // 컬렉션(Collection) -> Stream
  public static void ex06() {
    
    // 컬렉션(Collection) -> Stream
    
    // List
    List<String> list = Arrays.asList("봄", "여름", "가을", "겨울");
    Stream<String> stream = list.stream();
    stream.forEach((t) -> System.out.println(t));
    
    // Set -> Stream
    Set<String> set = new HashSet<String>(Arrays.asList("봄", "여름", "가을", "겨울"));
    set.stream().forEach(t -> System.out.println(t));   // 일반적으로 이렇게 많이 사용함
    
  }
  // 파일(입출력 스트림) -> Stream
  public static void ex07() {
    
    // 파일(입출력 스트림) -> Stream
    File file = new File("src/ex01_Stream/hello.txt"); // new File("hello.txt")도 가능함 (동일한 곳에 있기 때문에)
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      
      // Stream 생성
      Stream<String> stream = reader.lines();
      StringBuilder sb = new StringBuilder();
      
      // forEach() 호출
      stream.forEach((t) -> sb.append(t + "\n"));
      
      // 확인
      System.out.println(sb.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
  }
  // Path를 이용한 Stream 처리
  public static void ex08() {
    
    // Path를 이용한 Stream 처리
    
    try {
      Path path = Paths.get("src/ex01_Stream/hello.txt");
      Stream<String> stream = Files.lines(path);
      stream.forEach((line) -> System.out.println(line));
      stream.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
    
  }
  // 디렉터리에 저장된 파일 목록 -> Stream
  public static void ex09() {
    
    // 디렉터리에 저장된 파일 목록 -> Stream
    
    File dir = new File("C:/Program Files");
    Stream<File> stream = Arrays.stream(dir.listFiles());
    stream.forEach((file) -> System.out.println(file.getPath()));
    
  }
  // Path를 이용한 File[] 배열 처리
  public static void ex10() {
    
    // Path를 이용한 File[] 배열 처리
    
    try {
      Path path = Paths.get("C:/Program Files");
      Stream<Path> stream = Files.list(path);
      stream.forEach((p) -> System.out.println(p.getFileName()));
      stream.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
    
  }
  
  public static void main(String[] args) {
    
    ex10();
    
  }

}
