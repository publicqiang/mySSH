package com.mySSH.base.dao.impl;

import com.mySSH.base.dao.IBaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDao<T> implements IBaseDao<T> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    protected Class<T> clazz;
    @Autowired
    private SessionFactory sessionFactory;

    public BaseDao() {
        //getClass().getGenericSuperclass()返回表示此 Class
        //所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
        //然后将其转换ParameterizedType
        //getActualTypeArguments()返回表示此类型实际类型参数的 Type 对象的数组
        //[0]就是这个数组中第一个了。
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
        this.clazz = (Class)type.getActualTypeArguments()[0];
        logger.debug("DAO的真实实现类是：" + this.clazz.getName());
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public T load(Serializable id) {
         return this.getCurrentSession().load(this.clazz,id);
    }

    @Override
    public T get(Serializable id) {
        return this.getCurrentSession().get(this.clazz,id);
    }

    @Override
    public Serializable save(T entity) {
        return this.getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        this.getCurrentSession().update(entity);
    }

    @Override
    public int count() {
        return (Integer)this.getCurrentSession().createQuery("select count(1) from " + this.clazz.getSimpleName()).uniqueResult();
    }

    @Override
    public List<T> findAll() {

        return this.getCurrentSession().createQuery("select * from " + this.clazz.getSimpleName()).list();
    }

    @Override
    public List<T> findByHql(String hql,Object... params) {
        return this.getQuery(hql,params).list();
    }

    private Query getQuery(String hql, Object[] params) {
        Query query = this.getCurrentSession().createQuery(hql);

        for(int i = 0; params != null && i < params.length; ++i) {
            query.setParameter(i, params[i]);
        }

        return query;
    }


}
