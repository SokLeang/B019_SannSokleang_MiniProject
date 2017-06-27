package com.hrd.leang.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hrd.leang.model.User;

@Repository
public interface UserRepository {

	
			
	/*@Results(value={
			@Result(property="userHash", column="user_hash")
	})*/
	@Select("SELECT id, name, gender, phone_number, email, user_hash FROM users")
	public List<User> findAll(); 
	
	/**
	 * insert user to database
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO users(name, email, gender, phone_number, user_hash)"
			+ " VALUES(#{user.name}, #{user.email},#{user.gender}, #{user.phone_number}, #{user.user_hash})")
	public boolean save(@Param("user") User user);
	
	/**
	 * delete user from database
	 * @param user_hash
	 * @return
	 */
	@Delete("UPDATE userss SET status='0' WHERE user_hash=#{user_hash}")
	public boolean delete(@Param("user_hash") String user_hash);
	
	/**
	 * update user from database
	 * @param user
	 * @return
	 */
	@Update("UPDATE userss SET name=#{user.name}, email=#{user.email}, age=#{user.age} WHERE user_hash=#{user.user_hash}")
	public boolean update(@Param("user") User user);
	
	
}
