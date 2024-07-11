package com.smarteducationserverside.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smarteducationserverside.pojo.UserAbility;

/**
 * 用户能力Mapper
 */
@Mapper
public interface UserAbilityMapper {
    /**
     * 新建用户能力
     * 
     * @param userAbility 用户能力对象
     */
    @Insert("INSERT INTO tb_user_ability(id, username) VALUES(#{id}, #{username})")
    public void insertUserAbility(UserAbility userAbility);

    /**
     * 根据用户名查询用户能力
     * 
     * @param username 用户名
     * @return 用户能力对象
     */
    @Select("SELECT * FROM tb_user_ability WHERE username = #{username}")
    public UserAbility getUserAbilityByUsername(String username);

    /**
     * 根据ID更新用户能力
     * 
     * @param userAbility 用户能力对象
     */
    @Update("UPDATE tb_user_ability SET ability1 = #{ability1}, ability2 = #{ability2}, ability3 = #{ability3}, ability4 = #{ability4}, ability5 = #{ability5}, ability6 = #{ability6} WHERE id = #{id}")
    public void updateUserAbility(UserAbility userAbility);
}
