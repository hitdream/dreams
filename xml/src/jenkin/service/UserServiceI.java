package jenkin.service;

import jenkin.model.User;
import jenkin.pageModel.DataGrid;

/**
 * @author jenkin
 *
 */
public interface UserServiceI {

	public DataGrid datagrid(User user);
	public User find(User user);


}
