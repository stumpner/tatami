package fr.ippon.tatami.web.rest;


import org.springframework.stereotype.Controller;

@Controller
public class UserXAuthController {

//    private static final Logger log = LoggerFactory.getLogger(UserXAuthController.class);
//
//    private static final String GOOGLE_AUTH_CODE_HEADER_NAME = "x-auth-code-header";
//
//    @Inject
//    private UserService userService;
//
//    @Inject
//    private TokenProvider tokenProvider;
//
//    @Inject
//    private UserDetailsService userDetailsService;
//
//    @Inject
//    private DomainRepository domainRepository;
//
//    @Inject
//    private AuthenticationManager authenticationManager;
//
//    @Inject
//    Environment env;
//
//    /**
//     * GET /rest/client/id -> Gets the client id
//     */
//    @RequestMapping(value = "/rest/client/id",
//            method = RequestMethod.GET,
//            produces = "application/json")
//    @Timed
//    public Collection<String> getClientId() {
//
//        String clientId = env.getProperty("tatami.google.clientId");
//        Collection<String> clientList = new ArrayList<String>();
//        clientList.add(clientId);
//        return clientList;
//    }
//
//    /**
//     * POST /rest/oauth/token -> Gets a token based on the users google information
//     */
//    @RequestMapping(value = "/rest/oauth/token",
//            method = RequestMethod.POST)
//    @Timed
//    public Token getGoogleUser(ServletRequest servletRequest) {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        String authorizationCode = httpServletRequest.getHeader(GOOGLE_AUTH_CODE_HEADER_NAME);
//
//        Token authToken = null;
//        if(StringUtils.hasText(authorizationCode)){
//            try {
//                Person user = getGoogleUserInfo(authorizationCode);
//                UserDetails userDetails = getUserDetails(user);
//                GoogleAuthenticationToken token = new GoogleAuthenticationToken(userDetails);
//                authToken = tokenProvider.createToken(userDetails);
//                Authentication authentication = authenticationManager.authenticate(token);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            } catch (IOException ioe) {
//                log.error("{}", ioe);
//            }
//        }
//        return authToken;
//    }
//
//    @RequestMapping(value = "/rest/authentication",
//            method = RequestMethod.POST)
//    @Timed
//    public Token authorize(@RequestParam String username, @RequestParam String password) {
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
//        Authentication authentication = authenticationManager.authenticate(token);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        UserDetails details = userDetailsService.loadUserByUsername(username);
//        return tokenProvider.createToken(details);
//    }
//
//    private Person getGoogleUserInfo(String authorizationCode) throws IOException {
//        String clientId = env.getProperty("tatami.google.clientId");
//        String clientSecret = env.getProperty("tatami.google.clientSecret");
//
//        HttpTransport transport = new NetHttpTransport();
//        JacksonFactory jacksonFactory = new JacksonFactory();
//
//
//        TokenResponse accessCode = new GoogleAuthorizationCodeTokenRequest(transport, jacksonFactory,
//                clientId, clientSecret, authorizationCode, "http://localhost/callback")
//                .execute();
//
//        GoogleCredential googleCredential = new GoogleCredential.Builder()
//                .setJsonFactory(new JacksonFactory())
//                .setTransport(transport)
//                .setClientSecrets(clientId, clientSecret)
//                .build()
//                .setFromTokenResponse(accessCode);
//
//        Plus plus = new Plus.Builder(transport, jacksonFactory, googleCredential)
//                .setApplicationName("Tatami")
//                .build();
//        return plus.people().get("me").execute();
//    }
//
//    private UserDetails getUserDetails(Person user)  throws UsernameNotFoundException {
//        String login = user.getEmails().get(0).getValue();
//
//        if(login == null) {
//            String msg = "OAuth response did not contain the user email";
//            log.error(msg);
//            throw new UsernameNotFoundException(msg);
//        }
//
//        if(!login.contains("@")) {
//            log.debug("User login {} from OAuth response is incorrect.", login);
//            throw new UsernameNotFoundException("OAuth response did not contains a valid user email");
//        }
//
//        UserDetails userDetails;
//        try {
//            userDetails = userDetailsService.loadUserByUsername(login);
//            domainRepository.updateUserInDomain(DomainUtil.getDomainFromLogin(login), login);
//        } catch (UsernameNotFoundException e) {
//            log.info("User with login : \"{}\" doesn't exist yet in Tatami database - creating it...", login);
//            userDetails = getNewlyCreatedUserDetails(user);
//        }
//        return userDetails;
//    }
//
//    private UserDetails getNewlyCreatedUserDetails(Person user) {
//        String login = user.getEmails().get(0).getValue();
//        String firstName = user.getName().getGivenName();
//        String lastName = user.getName().getFamilyName();
//
//        User createdUser = new User();
//
//        createdUser.setLogin(login);
//        createdUser.setFirstName(firstName);
//        createdUser.setLastName(lastName);
//
//        userService.createUser(createdUser);
//        return userDetailsService.loadUserByUsername(createdUser.getLogin());
//    }
}
