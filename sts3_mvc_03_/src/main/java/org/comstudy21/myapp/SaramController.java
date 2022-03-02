package org.comstudy21.myapp;

import java.util.ArrayList;

import org.comstudy21.myapp.saram.SaramDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/saram")
public class SaramController {
	private static ArrayList<SaramDto> saramList = new ArrayList<SaramDto>();
	static {
		saramList.add(new SaramDto(SaramDto.nextSeq(), "Hong", "홍길동", "hong@a.com"));
		saramList.add(new SaramDto(SaramDto.nextSeq(), "Go", "고길동", "go@a.com"));
		saramList.add(new SaramDto(SaramDto.nextSeq(), "Park", "박길동", "park@a.com"));
	}
	
	@RequestMapping(value = "/list.action", method = RequestMethod.GET)
	public String saramList(Model model) {
		System.out.println("::: saramList method :::");
		model.addAttribute("saramList", saramList);
		return "saram/list";
	}
	
	@RequestMapping(value = "/input.action", method = RequestMethod.GET)
	public String saramInput() {
		System.out.println("::: saramInput GET method :::");
		return "saram/input";
	}
	
	@RequestMapping(value = "/input.action", method = RequestMethod.GET)
	public String saramInput(Model model, SaramDto dto) {
		System.out.println("::: saramInput POST method :::");
		dto.setIdx(SaramDto.nextSeq());
		return "redirect:list.action";
	}
	
	@RequestMapping(value = "/detail.action", method = RequestMethod.GET)
	public String saramDetail(Model model, SaramDto dto) {
		System.out.println("::: saramDetail :::");
		
		if(saramList.indexOf(dto) != -1) {
			int i = saramList.indexOf(dto);
			SaramDto saram = saramList.get(i);
			model.addAttribute("saramDto", saram);
		} else {
			System.out.println("정보가 없습니다.");
		}
		return "saram/detail";
	}
	
	@RequestMapping(value = "/modify.action", method = RequestMethod.GET)
	public String saramModify(Model model, SaramDto dto) {
		if(saramList.indexOf(dto) != -1) {
			int i = saramList.indexOf(dto);
			model.addAttribute("saramDto", saramList.get(i));
		}
		return "saram/modify";
	}
	
	@RequestMapping(value = "/modify.action", method = RequestMethod.GET)
	public String saramModify(SaramDto dto) {
		if(saramList.indexOf(dto) != -1) {
			int i = saramList.indexOf(dto);
			SaramDto saram = saramList.get(i);
			saram.setData(dto);
		}
		return "redirect:list.action";
	}
	
	@RequestMapping(value = "/delete.action")
	public String saramDelete(SaramDto dto) {
		if(saramList.indexOf(dto) != -1) {
			int i = saramList.indexOf(dto);
			saramList.remove(i);
		}
		return "redirect:list.action";
	}
	
}
