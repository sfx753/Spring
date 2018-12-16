package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Check;
import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.CheckService;
import kr.ac.hansung.service.OfferService;


@Controller
public class OfferController {
	
	
	// model은 자동으로 생성되어서 넘어온다.
	@Autowired
	private OfferService offerService;
	@Autowired
	private CheckService checkService;

	@RequestMapping("/2018_1")
	public String show2018_1(Model model) {
		
		List<Check> ss = checkService.getCurrent();
		model.addAttribute("ss",ss); // 최소한  model에  offer 객체를 넣어 주어야 한다. 
		System.out.println("불렸습니다.");
		return "2018_1";
	}

	@RequestMapping("/inquirys")
	public String showChecks(Model model) {
		
		List<Check> inquirys = checkService.getCurrent();
		model.addAttribute("inquirys",inquirys); // 최소한  model에  offer 객체를 넣어 주어야 한다. 
		System.out.println("불렸습니다.");
		return "inquirys";
		
	}
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offerService.getCurrent();
		
		model.addAttribute("offers",offers); // 최소한  model에  offer 객체를 넣어 주어야 한다. 
		
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		
		model.addAttribute("offer",new Offer());
		return "createoffer";
	}

	@RequestMapping("/docreate")                              //@Valid 검증태그 ex)) null값확인?
	public String doCreate(Model model, @Valid Offer offer,BindingResult result) { //넘겨줄 곳에 데이터 바인딩 필요--> (Offer offerr)부분이 자동 바인딩
		                                                            //검증후 결과가 result에 들어가게 된다.
		
		if(result.hasErrors()) {
			System.out.println("==Form data does no validated");
			List<ObjectError> errors =result.getAllErrors();
			
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createoffer";
		}
		System.out.println(offer);  //--> Offer클래스에 ToString이 불린다.
		
		offerService.insert(offer);
		return "offercreated";
	}
}
