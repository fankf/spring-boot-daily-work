package com.fankf.dao.db2;

import com.fankf.entity.User2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (User2)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-02 11:20:21
 */
public interface User2Dao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User2 queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<User2> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param user2 实例对象
     * @return 对象列表
     */
    List<User2> queryAll(User2 user2);

    /**
     * 新增数据
     *
     * @param user2 实例对象
     * @return 影响行数
     */
    int insert(User2 user2);

    /**
     * 修改数据
     *
     * @param user2 实例对象
     * @return 影响行数
     */
    int update(User2 user2);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}