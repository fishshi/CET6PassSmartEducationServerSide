package com.smarteducationserverside.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smarteducationserverside.pojo.RespondUser;
import com.smarteducationserverside.pojo.User;

/**
 * 用户Mapper接口
 */
@Mapper
public interface UserMapper {
    /**
     * 新增用户
     * 
     * @param user 用户对象 {@link User}
     */
    @Insert("insert into tb_user(username, password) values (#{username}, #{password})")
    public void insert(User user);

    /**
     * 以用户名查询用户数据
     * 
     * @param username 用户名
     * @return 用户对象 {@link User}
     */
    @Select("select id, username, password from tb_user where username = #{username}")
    public User SelectByUsername(String username);

    /**
     * 以用户名查询可返回至前端的用户数据
     * 
     * @param username 用户名
     * @return 可返回用户对象 {@link RespondUser}
     */
    @Select("select id, username, email, avatarUrl from tb_user where username = #{username}")
    public RespondUser RespondByUsername(String username);

    /**
     * 用用户名修改密码
     * 
     * @param username 用户名
     * @param password 密码
     */
    @Update("update tb_user set password = #{password} where username = #{username}")
    public void updatePassword(String username, String password);

    /**
     * 修改用户信息（暂定为只修改邮箱）
     * 
     * @param user 用户对象 {@link RespondUser}
     */
    @Update("update tb_user set email = #{email} where id = #{id}")
    public void updateUser(RespondUser user);

    /**
     * 修改用户头像
     * 
     * @param user 用户对象 {@link RespondUser}
     */
    @Update("update tb_user set avatarUrl = #{avatarUrl} where id = #{id}")
    public void updateAvatarUrl(RespondUser user);
}
