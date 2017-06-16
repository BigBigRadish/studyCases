package mj.radish.service;

import mj.radish.entity.Admin;
import mj.radish.exception.UserExistsException;

/**
 * 业务逻辑层接口设计
 * @author Jie.Yuan
 *
 */
public interface IAdminService {

	/**
	 * 注册
	 */
	void register(Admin admin) throws UserExistsException;
	
	/**
	 * 登陆
	 */
	Admin login(Admin admin);
}
