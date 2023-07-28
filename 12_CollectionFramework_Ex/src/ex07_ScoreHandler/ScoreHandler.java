package ex07_ScoreHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreHandler {
  
  private List<Map<String, Object>> students;
  
  public ScoreHandler() {
    // TODO Auto-generated constructor stub
    students = new ArrayList<Map<String,Object>>();
  }
  
  public void addScore(Map<String, Object> student) {
    students.add(student);
  }
  
  public Map<String, Number> get() {
    int max, min, total;
    max = min = total = (int)(students.get(0).get("score"));
    for(int i = 1, length = students.size(); i < length; i++) {
      int score = (int)students.get(i).get("score");
      if(max < score) {
        max = score;
      }
      if(min > score) {
        min = score;
      }
      total += score;
    }
    // 반환
    Map<String, Number> result = new HashMap<String, Number>();
    result.put("max", max);
    result.put("min", min);
    result.put("total", total);
    result.put("average", (double)total / students.size());
    return result;
  }
  
  public int getMax() {
    int max = (int)students.get(0).get("score");
    for(int i = 1, length = students.size(); i < length; i++) {
      if(max < (int)students.get(i).get("score")) {
        max = (int)students.get(i).get("score");
      }
    }
    return max;
  }
  
  public int getMin() {
    int min = (int)students.get(0).get("score");
    for(int i = 1, length = students.size(); i < length; i++) {
      if(min > (int)students.get(i).get("score")) {
        min = (int)students.get(i).get("score");
      }
    }
    return min;
  }
  
  public int getTotal() {
    int total = 0;
    for(int i = 0, length = students.size(); i < length; i++) {
      total += (int)students.get(i).get("score");
    }
    return total;
  }
  
  public double getAverage() {
    double average = 0;
    for(int i = 0, length = students.size(); i < length; i++) {
      average += (int)students.get(i).get("score");
    }
    average /= students.size();
    
    return average;
  }
  
  
}
