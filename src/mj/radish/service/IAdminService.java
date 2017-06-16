package mj.radish.service;

import mj.radish.entity.Admin;
import mj.radish.exception.UserExistsException;

/**
 * ҵ���߼���ӿ����
 * @author Jie.Yuan
 *
 */
public interface IAdminService {

	/**
	 * ע��
	 */
	void register(Admin admin) throws UserExistsException;
	
	/**
	 * ��½
	 */
	Admin login(Admin admin);
}
