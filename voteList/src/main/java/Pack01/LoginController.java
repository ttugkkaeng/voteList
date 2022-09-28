package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
	
	
	@PostMapping("/register/LoginCheck")
	public String  login(LoginDTO loginDTO, Model model) {
		
		
		LoginCheck logincheck = new LoginCheck(loginDTO.getId(), loginDTO.getPw());
		
		//로그인 검증 함수
		logincheck.LoginValidCheck();
		
		model.addAttribute("alertstr",logincheck.getAlertstr());

		return logincheck.getRedirectView();
	}
	
	
}
