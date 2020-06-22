package com.irlen.market.mapper;

import com.irlen.market.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user (user_id,user_name,password,role_id) values(" +
            "#{userId,jdbcType=VARCHAR}," +
            "#{userName,jdbcType=VARCHAR}," +
            "#{password,jdbcType=VARCHAR}," +
            "#{roleId,jdbcType=INTEGER}" +
            ")")
     int saveUser(User user);

    @Select("select * from user")
    @Results({
            @Result(column="user_id", property="userId"),
            @Result(column="user_name",property="userName"),
            @Result(column="password",property="password"),
            @Result(column="role_id",property = "roleId")

    })
    List<User> findAll();

    /**
     * 根据字段更新
     * @param roleId
     * @param userName
     * @return
     */
    @Update("update user set role_id=#{roleId} where user_name=#{userName}")
    int updateUser(@Param("roleId") Integer roleId, @Param("userName") String userName);

    /**
     * 根据对象来更新
     * @param user
     * @return
     */
    @Update("update user set role_id=#{roleId} where user_name=#{userName}")
    int updateUserByObject(User user);

    @Delete("delete from user where user_name=#{userName}")
    int deleteUser(String userName);
}
