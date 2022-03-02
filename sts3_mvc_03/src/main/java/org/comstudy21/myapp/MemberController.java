package org.comstudy21.myapp;

import org.comstudy21.myapp.saram.SaramDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@RequestMapping(value="list.action", method = RequestMethod.GET)
	public String memberList(Model model) {
		System.out.println("::: memberList method :::");
		return "member/list";
	}

	@RequestMapping(value="add.action", method = RequestMethod.GET)
	public String memberAdd(SaramDto dto) {
		System.out.println("::: memberAdd :::");
		return "member/add";
	}
}
