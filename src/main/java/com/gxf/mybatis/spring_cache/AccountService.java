package com.gxf.mybatis.spring_cache;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/10 7:57 PM
 **/
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public class AccountService {
  @Cacheable(value="accountCache")// 使用了一个缓存名叫 accountCache
  public Account getAccountByName(String userName) {
    // 方法内部实现不考虑缓存逻辑，直接实现业务
    return getFromDB(userName);
  }
  // 清空 accountCache 缓存  public void updateAccount(Account account) {
//  updateDB(account);
//  }

  @CacheEvict(value="accountCache",allEntries=true)// 清空 accountCache 缓存
  public void reload() {
  }

  private Account getFromDB(String acctName) {
    System.out.println("real querying db..."+acctName);
    return new Account(acctName);
  }

  @CacheEvict(value="accountCache",key="#account.getName()")
  public void updateDB(Account account) {
    System.out.println("real update db..."+account.getName());
  }

}