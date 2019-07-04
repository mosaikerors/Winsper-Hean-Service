package com.mosaiker.heanservice.service.serviceImple;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.mosaiker.heanservice.entity.Hean;
import com.mosaiker.heanservice.repository.HeanRepository;
import com.mosaiker.heanservice.service.HeanService;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * HeanServiceImple Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 4, 2019</pre>
 */
public class HeanServiceImpleTest {

  @Mock
  private HeanRepository heanRepository;
  @InjectMocks
  private HeanServiceImple heanServiceImple;

  @Before
  public void before() throws Exception {
    MockitoAnnotations.initMocks(this);

  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: findHeansByUId(Long uId)
   */
  @Test
  public void testFindHeansByUId() throws Exception {
    Hean hean1 = new Hean("hean1", 10000L, new Date(), "test hean1", 100.1, 100.1, 100.1, null);
    Hean hean2 = new Hean("hean2", 10000L, new Date(), "test hean2", 100.1, 100.1, 100.1, null);
    List<Hean> heanList = Arrays.asList(hean1, hean2);
    when(heanRepository.findAllByUId(10000L)).thenReturn(heanList);
    List<Hean> heanResult = heanServiceImple.findHeansByUId(10000L);
    verify(heanRepository).findAllByUId(10000L);
    assertEquals(heanResult, heanList);
    verifyNoMoreInteractions(heanRepository);
  }

  /**
   * Method: findAllHeans()
   */
  @Test
  public void testFindAllHeans() throws Exception {
    Hean hean1 = new Hean("hean1", 10000L, new Date(), "test hean1", 100.1, 100.1, 100.1, null);
    Hean hean2 = new Hean("hean2", 10000L, new Date(), "test hean2", 100.1, 100.1, 100.1, null);
    List<Hean> heanList = Arrays.asList(hean1, hean2);
    when(heanRepository.findAll()).thenReturn(heanList);
    List<Hean> heanResult = heanServiceImple.findAllHeans();
    verify(heanRepository).findAll();
    assertEquals(heanList,heanResult);
    verifyNoMoreInteractions(heanRepository);
  }

  /**
   * Method: deleteByHId(String hId)
   */
  @Test
  public void testDeleteByHId() throws Exception {
/* User user1 = new User(10000, "username", "17037041703", 1);
    User user2 = new User(10001, "username", "17037031703", 1);
    List<User> userlist = Arrays.asList(user1, user2);
    // 设置模拟对象的返回预期值
    when(userInfoRepository.findAll()).thenReturn(userlist);
    // 执行测试
    List<User> userResult = userInfoServiceImple.findAll();
    // 验证模拟对象的fetchPerson(1)方法是否被调用了一次
    verify(userInfoRepository).findAll();
    assertEquals(userlist, userResult);
    // 检查模拟对象上是否还有未验证的交互
    verifyNoMoreInteractions(userInfoRepository);
    */
    Hean hean1 = new Hean("hean1", 10000L, new Date(), "test hean1", 100.1, 100.1, 100.1, null);
    when(heanRepository.deleteByHId("hean1")).thenReturn(true);
    Boolean result = heanServiceImple.deleteByHId("hean1");
    verify(heanRepository).deleteByHId("hean1");
    assertEquals(true,result);
    verifyNoMoreInteractions(heanRepository);

  }

  /**
   * Method: upload(Hean hean)
   */
  @Test
  public void testUpload() throws Exception {
    Hean hean1 = new Hean("hean1", 10000L, new Date(), "test hean1", 100.1, 100.1, 100.1, null);
    when(heanRepository.save(hean1)).thenReturn(hean1);
    Hean result = heanServiceImple.upload(hean1);
    verify(heanRepository).save(hean1);
    assertEquals(hean1,result);
    verifyNoMoreInteractions(heanRepository);
  }


}
