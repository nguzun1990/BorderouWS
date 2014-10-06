package md.usarb.borderou.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import md.usarb.borderou.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
 
	//get user from the database, via Hibernate
	@Autowired
	private UserDao userDao;
 
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) 
		throws UsernameNotFoundException {
 
		md.usarb.borderou.vo.User user = userDao.findByUserName(username);
//		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		List<GrantedAuthority> authorities = buildUserAuthority();
 
		
		return buildUserForAuthentication(user, authorities);
 
	}
 
	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(md.usarb.borderou.vo.User user, 
		List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
//		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}
 
//	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
	private List<GrantedAuthority> buildUserAuthority() {
 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		// Build user's authorities
//		for (UserRole userRole : userRoles) {
//			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
//		}
		setAuths.add(new SimpleGrantedAuthority("ADMIN_NICU"));
 
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
 
		return Result;
	}
 
}
