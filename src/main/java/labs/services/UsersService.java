package labs.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import labs.models.User;
import labs.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {
	
	@Autowired
	private UserRepository usersRepo;
	
	@PostConstruct
	@Transactional
	public void createAdminUser() {		
		register("admin@mail.com","123456");
	}
	
	@Transactional(readOnly = false)
	public void register(String login, String pass) {
		String passHash = new BCryptPasswordEncoder().encode(pass);
		
		User user = new User(login, passHash);

		usersRepo.save(user);
	}
	
	/*@Transactional
	public List<User> getSubscribeRecommendations() {
		User currentUser = usersRepo.findOne(User.getCurrentUserId());

		// перетворює список користувачів на список їх ідентифікаторів
		List<Long> ignoreIds = new ArrayList<>();

		for(User u : currentUser.getSubscriptions()) {
			ignoreIds.add(u.getId());
		}
		
		return usersRepo.findFirst10ByIdNotIn(ignoreIds);
	}*/
	
	/*@Transactional
	public void subscribe(String login) {
		User u = usersRepo.findByLogin(login);

		// буде замінено після реалізації логіну
		User currentUser = usersRepo.findOne(User.getCurrentUserId());
		
		if(currentUser.getId() != u.getId()) {		
			currentUser.getSubscriptions().add(u);
		}
	}
	th:replace(filename) !!!!!!!!!!!!!!!!!!!!
	*
	*/ 
	
}
