package ex04_Singer;

public class MainWrapper {
  
  public static void main(String[] args) {
    
    Song song = new Song();
    
    song.setTitle("좋은날");
    song.setGenre("발라드");
    song.setPlayTime(3.5);
    
    song.info();  // 제목: ㅇㅇ, 장르: ㅇㅇ, 재생시간: 3.5분
    
    Singer singer = new Singer();
    singer.setName("아이유");
    singer.setTitleSong(song);
    
    singer.info(); // 이름: ㅇㅇ
                   // 제목: ㅇㅇ, 장르: ㅇㅇ, 재생시간: 3.5분
    
    
    
  }

}
