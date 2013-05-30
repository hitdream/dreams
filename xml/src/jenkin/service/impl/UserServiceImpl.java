package jenkin.service.impl;

import jenkin.model.User;
import jenkin.pageModel.DataGrid;
import jenkin.service.UserServiceI;

/**
 * @author jenkin
 *
 */
public class UserServiceImpl implements UserServiceI {

	@Override
	public DataGrid datagrid(User user) {
		DataGrid dg = new DataGrid();
		
		return null;
	}

	@Override
	public User find(User user) {
		if(user.getName().equals("admin")&&user.getPassword().equals("admin"))
		{
			return user;
		}
		return null;
	}

	
	}

