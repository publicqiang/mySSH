package com.mySSH.base.dao;


import java.io.Serializable;
import java.util.List;

/**
 * 基础数据库操作类
 * @param <T>
 */
public interface IBaseDao<T> {

    T load(Serializable var1);

    T get(Serializable var1);

    /**
     * 保存一个对象
     * @param o
     * @return
     */
    Serializable save(T o);

    void update(T var1);

    int count();

    List<T> findAll();

    /**
     * 查询
     * @param hql
     * @return
     */
    List<T> findByHql(String hql,Object... var2);

}
