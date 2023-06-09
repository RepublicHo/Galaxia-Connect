package com.g31.demo;

import com.g31.demo.model.User;
import com.g31.demo.model.Role;
import com.g31.demo.model.RoleType;
import com.g31.demo.model.UserRole;
import com.g31.demo.repository.RoleRepository;
import com.g31.demo.repository.UserRepository;
import com.g31.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;


//@ComponentScan//(basePackages = {"com.g31.demo.repository", "com.g31.demo.controller", "com.g31.demo.service"})
@SpringBootApplication//(exclude = SecurityAutoConfiguration.class)
//@EnableJpaRepositories("com.g31.demo.repository")
public class GalaxiaConnectApplication implements CommandLineRunner {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;


	private static final String[] cmd = {"cmd", "node", "./galaxy/server.js "};
	public static void main(String[] args) throws IOException, InterruptedException {


		SpringApplication.run(GalaxiaConnectApplication.class, args);
	}

//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		return new BCryptPasswordEncoder();
//	}

	/**
	 * Initialize role repository and an admin.
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(java.lang.String... args) throws IOException  {


		//初始化角色信息
		for (RoleType roleType : RoleType.values()) {
			roleRepository.save(new Role(roleType.getName(), roleType.getDescription()));
		}
		//初始化一个 admin 用户
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		User user = User.builder().enabled(true).email("admin").userName("root").password(bCryptPasswordEncoder.encode("root")).build();

		userRepository.save(user);
		Role role = roleRepository.findByName(RoleType.ADMIN.getName()).get();
		userRoleRepository.save(new UserRole(user, role));
	}


}