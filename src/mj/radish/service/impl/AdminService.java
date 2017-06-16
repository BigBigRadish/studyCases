package mj.radish.service.impl;

import mj.radish.dao.IAdminDao;
import mj.radish.dao.impl.AdminDao;
import mj.radish.entity.Admin;
import mj.radish.exception.UserExistsException;
import mj.radish.service.IAdminService;

/**
 * 3. ҵ���߼���ʵ��
 * @author Jie.Yuan
 *
 */
public class AdminService implements IAdminService {

	// ���õ�dao
	private IAdminDao adminDao = new AdminDao();
	
	@Override
	public Admin login(Admin admin) {
		try {
			return adminDao.findByNameAndPwd(admin);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void register(Admin admin) throws UserExistsException  {
		
		try {
			// 1. �ȸ����û�����ѯ�û��Ƿ����
			boolean flag = adminDao.userExists(admin.getUserName());
			
			// 2. ����û����ڣ�������ע��
			if (flag){
				// ������ע��, ����������ʾ
				throw new UserExistsException("�û����Ѿ����ڣ�ע��ʧ�ܣ�");
			}
			
			// 3. �û������ڣ��ſ���ע��
			adminDao.save(admin);
		
		} catch (UserExistsException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
