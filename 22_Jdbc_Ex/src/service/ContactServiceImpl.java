package service;

import java.util.List;
import java.util.Map;

import dao.ContactDao;
import dto.ContactDto;

//ContactView -> ContactController -> ContactService -> ContactDao -> DB

public class ContactServiceImpl implements ContactService {

  private ContactDao contactDao = ContactDao.getDao();
  
  @Override
  public int insert(Map<String, Object> map) {
    
    System.out.println("Service::" + map);
    // Map -> ContactDto
    ContactDto contactDto = new ContactDto();
    contactDto.setName((String)map.get("name"));
    contactDto.setTel((String)map.get("tel"));
    contactDto.setEmail((String)map.get("email"));
    contactDto.setAddress((String)map.get("address"));
    return contactDao.insert(contactDto);
  }

  @Override
  public int update(Map<String, Object> map) {
    System.out.println("Service::" + map);
    
    // 수정할 정보 (값이 있거나, 빈 문자열이다.)
    int contact_no = Integer.parseInt((String)map.get("contact_no"));
    String name = (String)map.get("name");
    String tel = (String)map.get("tel");
    String email = (String)map.get("email");
    String address = (String)map.get("address");
    
    // 수정하기 전 원본 contactDto 가져오기
    ContactDto originDto = contactDao.selectContactByNo(contact_no);
    
    // 원본 ContactDto가 없는 경우 (번호가 없는 경우)
    if(originDto == null) {
      return 0;
    }
    
    // Map -> ContactDto
    ContactDto contactDto = new ContactDto();
    contactDto.setContact_no(contact_no);
    contactDto.setName(name.isEmpty() ? originDto.getName(): name);
    contactDto.setTel(tel.isEmpty() ? originDto.getTel() : tel);
    contactDto.setEmail(email.isEmpty() ? originDto.getEmail() : email);
    contactDto.setAddress(address.isEmpty() ? originDto.getAddress() : address);
    return contactDao.update(contactDto);
  }

  @Override
  public int delete(Map<String, Object> map) {
    
    // Map이 없으면 삭제 안 함
    if(map == null) {
      return 0;
    }
    
    // Map에서 contact_no 추출
    int contact_no = Integer.parseInt((String)map.get("contact_no"));
    return contactDao.delete(contact_no);
  }

  @Override
  public List<ContactDto> selectList() {
    return contactDao.selectList();
  }

  @Override
  public ContactDto selectContactByNo(Map<String, Object> map) {
    // Map에서 contact_no 추출
    int contact_no = Integer.parseInt((String)map.get("contact_no"));
    return contactDao.selectContactByNo(contact_no);
  }

}
