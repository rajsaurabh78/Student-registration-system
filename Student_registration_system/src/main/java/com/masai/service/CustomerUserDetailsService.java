package com.masai.service;

public class CustomerUserDetailsService {

//	@Autowired
//	private UserRepository userRepository;
//	
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		
//		Optional<com.masai.modal.User> opt= userRepository.findByEmail(username);
//
//		if(opt.isPresent()) {
//			
//			com.masai.modal.User rUser= opt.get();
//			
//			List<GrantedAuthority> authorities= new ArrayList<>();
//			//authorities.add(new SimpleGrantedAuthority(customer.getRole()));
//			
//			
//			return new User(rUser.getEmail(), rUser.getPassword(), authorities);
//			
//		}else
//			throw new BadCredentialsException("User Details not found with this username: "+username);
//		  
//	}

}
